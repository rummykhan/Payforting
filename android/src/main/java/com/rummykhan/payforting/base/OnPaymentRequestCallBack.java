package com.rummykhan.payforting;

/**
 * Created by rummykhan on 17/11/18
 */

public interface OnPaymentRequestCallBack {
    void onPaymentRequestResponse(int responseType, PayFortData responseData);
}
