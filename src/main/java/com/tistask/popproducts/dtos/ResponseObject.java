package com.tistask.popproducts.dtos;

public class ResponseObject<T> {
    private T data;
    private String message;
	private boolean isError;
	
	public ResponseObject(T data, String message, boolean isError) {
		this.data = data;
        this.message = message;
		this.isError = isError;
	}

	public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

    @Override
	public String toString() {
		return "ResponseObject [message=" + message + ", data=" + data + "]";
	}
}

