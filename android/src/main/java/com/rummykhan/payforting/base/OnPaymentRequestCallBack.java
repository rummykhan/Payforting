package com.rummykhan.payforting;

/**
 * Created by basselchaitani on 8/1/18
 */

public interface OnPaymentRequestCallBack {
    void onPaymentRequestResponse(int responseType, PayFortData responseData);
}
