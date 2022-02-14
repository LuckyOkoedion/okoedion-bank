package com.lucky.OkoedionBank.Pojo;

public class TransactionChannels<T extends TransactionChannelsEnum> {
    final T theChanel;

    public TransactionChannels(T chanel) {
        this.theChanel = chanel;
    }

}
