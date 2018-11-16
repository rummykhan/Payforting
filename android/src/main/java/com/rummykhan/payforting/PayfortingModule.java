
package com.rummykhan.payforting;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class PayfortingModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public PayfortingModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "Payforting";
    }

    @ReactMethod
    public void logMessage(String message) {
        System.out.println(message);
    }

    @ReactMethod
    public void createPurchase(String merchantIdentifier, String serviceCommand) {

    }

}