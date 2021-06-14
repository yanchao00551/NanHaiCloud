package com.nanhai.core.framework.object;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.*;

import java.io.IOException;
import java.net.URI;
import java.util.*;

import static lombok.Lombok.checkNotNull;


/**
 * @PackageName:com.nanhai.config
 * @ClassName:MyRestTemplate
 * @Description:
 * @author: 悟空
 * @date: 2021/5/14 20:33
 * @email: 10947@163.com
 */
public class MyRestTemplate extends RestTemplate {
    private final Map<String, List<String>> headers = new LinkedHashMap<>();

    @Nullable
    @Override
    protected <T> T doExecute(URI url, @Nullable HttpMethod method, @Nullable RequestCallback requestCallback,
                              @Nullable ResponseExtractor<T> responseExtractor) throws RestClientException {

        Assert.notNull(url, "URI is required");
        Assert.notNull(method, "HttpMethod is required");
        ClientHttpResponse response = null;
        try {
            ClientHttpRequest request = createRequest(url, method);

            // lpf: 添加headers
            HttpHeaders myHeaders = request.getHeaders();
            addAllHeaders(myHeaders);

            if (requestCallback != null) {
                requestCallback.doWithRequest(request);
            }
            response = request.execute();
            handleResponse(url, method, response);
            return (responseExtractor != null ? responseExtractor.extractData(response) : null);
        }
        catch (IOException ex) {
            String resource = url.toString();
            String query = url.getRawQuery();
            resource = (query != null ? resource.substring(0, resource.indexOf('?')) : resource);
            throw new ResourceAccessException("I/O error on " + method.name()
                    + " request for \"" + resource + "\": " + ex.getMessage(), ex);
        }
        finally {
            if (response != null) {
                response.close();
            }
        }
    }

    public void header(String name, String... values) {
        checkNotNull(name, "header name");
        if (values == null || (values.length == 1 && values[0] == null)) {
            headers.remove(name);
        } else {
            List<String> headers = new ArrayList<>(Arrays.asList(values));
            this.headers.put(name, headers);
        }
    }

    private void addAllHeaders(HttpHeaders myHeaders) {
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            myHeaders.addAll(key, values);
        }
    }
}

