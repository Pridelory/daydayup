package design_mode.model11.Impl;

import design_mode.model11.Payment;

public class WechatPay extends Payment {

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected Double queryBalance(String uid) {
        return 256d;
    }
}
