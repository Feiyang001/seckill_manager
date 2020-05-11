package com.seckill.zuul.provider;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


@Component
public class FallBackProvider implements FallbackProvider {



    public String getRoute() {
        // 表明是为哪个微服务提供回退，* 表示为所有微服务提供回退
        return "*";
    }

    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        if (cause instanceof HystrixTimeoutException){
            return response(HttpStatus.GATEWAY_TIMEOUT,cause);
        }

        return null;
    }

    private ClientHttpResponse response(final HttpStatus status, final Throwable cause){

        return new ClientHttpResponse() {
            public HttpStatus getStatusCode() throws IOException {
                return  status;
            }

            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            public void close() {

            }

            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(cause.getMessage().getBytes());
            }

            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();

                headers.setContentType(MediaType.APPLICATION_JSON);

                return headers;
            }
        };
    }
}
