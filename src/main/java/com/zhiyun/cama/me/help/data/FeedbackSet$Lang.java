/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.help.data;

public final class FeedbackSet$Lang
extends Enum {
    public static final /* enum */ FeedbackSet$Lang DE;
    public static final /* enum */ FeedbackSet$Lang EN;
    public static final /* enum */ FeedbackSet$Lang ES;
    public static final /* enum */ FeedbackSet$Lang FR;
    public static final /* enum */ FeedbackSet$Lang IT;
    public static final /* enum */ FeedbackSet$Lang JA;
    public static final /* enum */ FeedbackSet$Lang KO;
    public static final /* enum */ FeedbackSet$Lang PT;
    public static final /* enum */ FeedbackSet$Lang PT_BR;
    public static final /* enum */ FeedbackSet$Lang RU;
    public static final /* enum */ FeedbackSet$Lang ZH_CN;
    public static final /* enum */ FeedbackSet$Lang ZH_TW;
    private static final /* synthetic */ FeedbackSet$Lang[] a;
    private String lang;
    private int stringRes;

    static {
        FeedbackSet$Lang feedbackSet$Lang;
        FeedbackSet$Lang feedbackSet$Lang2;
        FeedbackSet$Lang feedbackSet$Lang3;
        FeedbackSet$Lang feedbackSet$Lang4;
        FeedbackSet$Lang feedbackSet$Lang5;
        Object object = "zh_CN".toLowerCase();
        ZH_CN = feedbackSet$Lang5 = new FeedbackSet$Lang("ZH_CN", 0, object, 2131952392);
        Object object2 = "zh_TW".toLowerCase();
        object = new FeedbackSet$Lang("ZH_TW", 1, object2, 2131952393);
        ZH_TW = object;
        Object object3 = "en".toLowerCase();
        object2 = new FeedbackSet$Lang("EN", 2, object3, 2131952384);
        EN = object2;
        Object object4 = "de".toLowerCase();
        object3 = new FeedbackSet$Lang("DE", 3, object4, 2131952383);
        DE = object3;
        Object object5 = "pt_BR".toLowerCase();
        int n10 = 2131952390;
        object4 = new FeedbackSet$Lang("PT_BR", 4, object5, n10);
        PT_BR = object4;
        Object object6 = "pt".toLowerCase();
        object5 = new FeedbackSet$Lang("PT", 5, object6, n10);
        PT = object5;
        Object object7 = "ja".toLowerCase();
        object6 = new FeedbackSet$Lang("JA", 6, object7, 2131952388);
        JA = object6;
        String string2 = "ko".toLowerCase();
        object7 = new FeedbackSet$Lang("KO", 7, string2, 2131952389);
        KO = object7;
        string2 = "fr".toLowerCase();
        FR = feedbackSet$Lang4 = new FeedbackSet$Lang("FR", 8, string2, 2131952386);
        string2 = "es".toLowerCase();
        ES = feedbackSet$Lang3 = new FeedbackSet$Lang("ES", 9, string2, 2131952385);
        string2 = "ru".toLowerCase();
        RU = feedbackSet$Lang2 = new FeedbackSet$Lang("RU", 10, string2, 2131952391);
        string2 = "it".toLowerCase();
        int n11 = 11;
        IT = feedbackSet$Lang = new FeedbackSet$Lang("IT", n11, string2, 2131952387);
        FeedbackSet$Lang[] feedbackSet$LangArray = new FeedbackSet$Lang[12];
        feedbackSet$LangArray[0] = feedbackSet$Lang5;
        feedbackSet$LangArray[1] = object;
        feedbackSet$LangArray[2] = object2;
        feedbackSet$LangArray[3] = object3;
        feedbackSet$LangArray[4] = object4;
        feedbackSet$LangArray[5] = object5;
        feedbackSet$LangArray[6] = object6;
        feedbackSet$LangArray[7] = object7;
        feedbackSet$LangArray[8] = feedbackSet$Lang4;
        feedbackSet$LangArray[9] = feedbackSet$Lang3;
        feedbackSet$LangArray[10] = feedbackSet$Lang2;
        feedbackSet$LangArray[n11] = feedbackSet$Lang;
        a = feedbackSet$LangArray;
    }

    /*
     * WARNING - void declaration
     */
    private FeedbackSet$Lang() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.lang = var3_1;
        this.stringRes = var4_2;
    }

    public static FeedbackSet$Lang from(String string2) {
        for (FeedbackSet$Lang feedbackSet$Lang : FeedbackSet$Lang.values()) {
            String string3 = feedbackSet$Lang.getLang();
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return feedbackSet$Lang;
        }
        return EN;
    }

    public static FeedbackSet$Lang valueOf(String string2) {
        return Enum.valueOf(FeedbackSet$Lang.class, string2);
    }

    public static FeedbackSet$Lang[] values() {
        return (FeedbackSet$Lang[])a.clone();
    }

    public String getLang() {
        return this.lang;
    }

    public int getStringRes() {
        return this.stringRes;
    }

    public void setLang(String string2) {
        this.lang = string2;
    }

    public void setStringRes(int n10) {
        this.stringRes = n10;
    }
}

