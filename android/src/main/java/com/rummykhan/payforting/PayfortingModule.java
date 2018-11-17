
package com.rummykhan.payforting;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.payfort.fort.android.sdk.base.callbacks.FortCallBackManager;
import com.payfort.fort.android.sdk.base.callbacks.FortCallback;
import java.util.*;
import com.payfort.fort.android.sdk.activities.InitSecureConnectionActivity;
import com.payfort.sdk.android.dependancies.models.FortRequest;
import android.content.Intent;

public class PayfortingModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public static final String PURCHASE_EXCEPTION = "PURCHASE_EXCEPTION";

    public static final String COMMAND_AUTHORIZATION = "COMMAND_AUTHORIZATION";
    public static final String COMMAND_PURCHASE = "COMMAND_PURCHASE";
    public static final String CURRENCY_AED = "CURRENCY_AED";
    public static final String CURRENCY_SAR = "CURRENCY_SAR";

    public PayfortingModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "Payforting";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        constants.put(COMMAND_AUTHORIZATION, PayFortPayment.AUTHORIZATION);
        constants.put(COMMAND_PURCHASE, PayFortPayment.PURCHASE);

        constants.put(CURRENCY_AED, PayFortPayment.CURRENCY_AED);
        constants.put(CURRENCY_SAR, PayFortPayment.CURRENCY_SAR);
        return constants;
    }

    @ReactMethod
    public void logMessage(String message) {
        System.out.println(message);
    }

    @ReactMethod
    public void showActivity() {
        Intent openSDK = new Intent(this.reactContext.getCurrentActivity(), InitSecureConnectionActivity.class);
        openSDK.putExtra("merchantReq", new FortRequest());
        openSDK.putExtra("environment", "https://sbcheckout.payfort.com");
        openSDK.putExtra("showLoading", true);
        this.reactContext.getCurrentActivity().startActivityForResult(openSDK, 1);
    }

    //TODO: Add language to Exposed constants
    @ReactMethod
    public void sendCommand(String command,
                            String amount,
                            String currency,
                            String email,
                            String currentLanguage,
                            String merchantIdentifier,
                            String accessCode,
                            String shaRequestPhrase,
                            String shaResponsePhrase,
                            boolean isSandBox,
                            Promise promise
    ) {
        try {

            PayFortData payFortData = new PayFortData();
            payFortData.setCommand(command);
            payFortData.setAmount(amount);
            payFortData.setCurrency(currency);
            payFortData.setCustomerEmail(email);
            payFortData.setLanguage(currentLanguage);
            payFortData.setMerchantReference(String.valueOf(System.currentTimeMillis()));

            PayFortPayment payFortPayment = new PayFortPayment(
                    this.reactContext.getCurrentActivity(),
                    currentLanguage,
                    FortCallback.Factory.create(),
                    promise
            );

            String url = PayFortPayment.URL_SANDBOX;
            if (!isSandBox) {
                url = PayFortPayment.URL_PRODUCTION;
            }

            payFortPayment.setHostUrl(url);
            payFortPayment.setMerchantIdentifier(merchantIdentifier);
            payFortPayment.setAccessCode(accessCode);
            payFortPayment.setShaRequestPhrase(shaRequestPhrase);
            payFortPayment.setShaResponsePhrase(shaResponsePhrase);

            payFortPayment.requestForPayment(payFortData);

        } catch (Exception e) {
            promise.reject(PayfortingModule.PURCHASE_EXCEPTION, e);
        }
    }

}