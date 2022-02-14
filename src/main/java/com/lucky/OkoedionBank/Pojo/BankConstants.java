package com.lucky.OkoedionBank.Pojo;

public final class BankConstants {
    public static final AccountType PRIVATE_ACCOUNT_TYPE = new AccountType(AccountTypeEnum.PRIVATE);
    public static final AccountType CORPORATE_ACCOUNT_TYPE = new AccountType(AccountTypeEnum.CORPORATE);
    public static final AccountType JOINT_ACCOUNT_TYPE = new AccountType(AccountTypeEnum.JOINT);
    public static final AccountType CURRENT_ACCOUNT_TYPE = new AccountType(AccountTypeEnum.CURRENT);
    public static final TransactionChannels ATM_CREDIT_CHANNEL = new TransactionChannels(TransactionChannelsEnum.ATM);
    public static final TransactionChannels API_CREDIT_CHANNEL = new TransactionChannels(TransactionChannelsEnum.API);
    public static final TransactionChannels CROSS_BORDER_CREDIT_CHANNEL = new TransactionChannels(TransactionChannelsEnum.CROSS_BORDER);
    public static final TransactionChannels OVER_THE_COUNTER_CREDIT_CHANNEL = new TransactionChannels(TransactionChannelsEnum.OVER_THE_COUNTER);
    public static final TransactionChannels MOBILE_APP_CREDIT_CHANNEL = new TransactionChannels(TransactionChannelsEnum.MOBILE_APP);
    public static final TransactionChannels WEB_APP_CREDIT_CHANNEL = new TransactionChannels(TransactionChannelsEnum.WEB_APP);
}
