package design_mode.model11.Impl;

import design_mode.model11.Payment;

public class AliPay extends Payment {

    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected Double queryBalance(String uid) {
        return 900d;
    }
}
