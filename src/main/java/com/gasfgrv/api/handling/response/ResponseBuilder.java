package com.gasfgrv.api.handling.response;

public class ResponseBuilder<T> {

    private final Response<T> response = new Response<>();

    private ResponseBuilder<T> result(String result) {
        response.setResult(result);
        return this;
    }

    public ResponseBuilder<T> error(ResponseError error) {
        response.setError(error);
        response.setResult("Failed");
        response.setStatus("500");
        return this;
    }

    public ResponseBuilder<T> addData(final T body) {
        response.setData(body);
        response.setResult("Succeeded");
        response.setStatus("200");
        return this;
    }

    public Response<T> build() {
        return response;
    }

}
