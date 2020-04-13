package com.codenation.data;

import java.util.List;

import org.springframework.stereotype.Component;



@Component
public class CustomResponseWrapper {

    private String method;
    
    private String result;
    
    private List<Object> msgSaida;
    
    private List<ErrorCripto> error;
    
    /**
     * @return the methodName
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the msgSaida
     */
    public List<Object> getMsgSaida() {
        return msgSaida;
    }

    /**
     * @param msgSaida the msgSaida to set
     */
    public void setMsgSaida(List<Object> msgSaida) {
        this.msgSaida = msgSaida;
    }

    /**
     * @return the error
     */
    public List<ErrorCripto> getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(List<ErrorCripto> error) {
        this.error = error;
    }
}

