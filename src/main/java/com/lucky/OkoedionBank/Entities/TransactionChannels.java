package com.lucky.OkoedionBank.Entities;

import com.lucky.OkoedionBank.Pojo.TransactionChannelsEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionChannels<T extends TransactionChannelsEnum> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    final T theChanel;

    public TransactionChannels(T chanel) {
        this.theChanel = chanel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public T getTheChanel() {
        return theChanel;
    }
}
