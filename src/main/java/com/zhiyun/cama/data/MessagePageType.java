/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data;

public final class MessagePageType
extends Enum {
    public static final /* enum */ MessagePageType MESSAGE_COMMENT;
    public static final /* enum */ MessagePageType MESSAGE_FOLLOW;
    public static final /* enum */ MessagePageType MESSAGE_LETTER;
    public static final /* enum */ MessagePageType MESSAGE_LIKE;
    public static final /* enum */ MessagePageType MESSAGE_PERSONAL;
    public static final /* enum */ MessagePageType MESSAGE_SYSTEM;
    public static final /* enum */ MessagePageType MESSAGE_VIOLATION;
    private static final /* synthetic */ MessagePageType[] a;
    private String type;

    static {
        MessagePageType messagePageType;
        MessagePageType messagePageType2;
        MessagePageType messagePageType3;
        MessagePageType messagePageType4;
        MessagePageType messagePageType5;
        MessagePageType messagePageType6;
        MessagePageType messagePageType7;
        MESSAGE_LIKE = messagePageType7 = new MessagePageType("MESSAGE_LIKE", 0, "like");
        int n10 = 1;
        MESSAGE_COMMENT = messagePageType6 = new MessagePageType("MESSAGE_COMMENT", n10, "comment");
        int n11 = 2;
        MESSAGE_FOLLOW = messagePageType5 = new MessagePageType("MESSAGE_FOLLOW", n11, "follow");
        int n12 = 3;
        MESSAGE_LETTER = messagePageType4 = new MessagePageType("MESSAGE_LETTER", n12, "message");
        int n13 = 4;
        MESSAGE_PERSONAL = messagePageType3 = new MessagePageType("MESSAGE_PERSONAL", n13, "personal");
        int n14 = 5;
        MESSAGE_SYSTEM = messagePageType2 = new MessagePageType("MESSAGE_SYSTEM", n14, "notice");
        int n15 = 6;
        MESSAGE_VIOLATION = messagePageType = new MessagePageType("MESSAGE_VIOLATION", n15, "violation");
        MessagePageType[] messagePageTypeArray = new MessagePageType[7];
        messagePageTypeArray[0] = messagePageType7;
        messagePageTypeArray[n10] = messagePageType6;
        messagePageTypeArray[n11] = messagePageType5;
        messagePageTypeArray[n12] = messagePageType4;
        messagePageTypeArray[n13] = messagePageType3;
        messagePageTypeArray[n14] = messagePageType2;
        messagePageTypeArray[n15] = messagePageType;
        a = messagePageTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MessagePageType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.type = var3_1;
    }

    public static MessagePageType valueOf(String string2) {
        return Enum.valueOf(MessagePageType.class, string2);
    }

    public static MessagePageType[] values() {
        return (MessagePageType[])a.clone();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String string2) {
        this.type = string2;
    }
}

