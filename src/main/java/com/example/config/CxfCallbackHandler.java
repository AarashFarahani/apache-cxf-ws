package com.example.config;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;

public class CxfCallbackHandler implements CallbackHandler {
    public void handle(Callback[] callbacks) {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

        if (pc.getIdentifier().equalsIgnoreCase("arash")) {
            pc.setPassword("123");
        }
    }
}