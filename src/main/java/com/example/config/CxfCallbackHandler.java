package com.example.config;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;

@Component
public class CxfCallbackHandler implements CallbackHandler {
    @Value("${username}") private String username;
    @Value("${password}") private String password;

    public void handle(Callback[] callbacks) {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

        if (pc.getIdentifier().equalsIgnoreCase(this.username)) {
            pc.setPassword(this.password);
        }
    }
}