package com.codenation.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Renato
 */
public class ErrorCripto {
    private String code;
    
    private String message;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    public ErrorCripto(String i, String localizedMessage) {
            this.code = i;
            this.message = localizedMessage;
    }
    
    public ErrorCripto() {

    }
    
}
