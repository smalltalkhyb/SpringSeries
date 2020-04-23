package com.smalltalk.hyb.spring.boot.pro.aop;

public class AliPayment implements Payment {

    private Payment payment;

    public AliPayment(Payment payment) {
        this.payment = payment;
    }

    private void beforePay() {
        System.out.println("从招商银行取钱！");
    }

    @Override
    public void pay() {
        beforePay();
        payment.pay();
        afterPay();
    }


    private void afterPay() {
        System.out.println("支付给京东商城！");
    }

    public static void main(String[] args) {
        Payment proxyPay=new AliPayment(new RealPayment());
        proxyPay.pay();
    }
}
