package design_mode.model11.Impl;

import design_mode.model11.Payment;

/**
 * 银联支付
 */
public class UnionPay extends Payment {

    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected Double queryBalance(String uid) {
        return 120d;
    }
}
