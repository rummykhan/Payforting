
package com.rummykhan.payforting;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

public class PayfortingModule extends ReactContextBaseJavaModule implements OnPaymentRequestCallBack {

    private final ReactApplicationContext reactContext;

    public static final String PURCHASE_EXCEPTION = "PURCHASE_EXCEPTION";

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
        final Map<String, String> constants = new HashMap<>();

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
                    this.reactContext,
                    currentLanguage,
                    mFortCallBackManager,
                    PayfortingModule.this
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

            payFortPayment.requestForPayment(payFortData, promise);

        } catch (Exception e) {
            promise.reject(PayfortingModule.PURCHASE_EXCEPTION, e);
        }
    }

}