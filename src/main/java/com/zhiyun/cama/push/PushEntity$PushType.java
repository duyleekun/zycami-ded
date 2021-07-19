/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.push;

public final class PushEntity$PushType
extends Enum {
    public static final /* enum */ PushEntity$PushType ACTIVITYNOTICE;
    public static final /* enum */ PushEntity$PushType CHAT;
    public static final /* enum */ PushEntity$PushType CIRCLECREATEDSUCCESSFULLY;
    public static final /* enum */ PushEntity$PushType CIRCLEJOINEDSUCCESSFULLY;
    public static final /* enum */ PushEntity$PushType COMMENT;
    public static final /* enum */ PushEntity$PushType CONNECTION;
    public static final /* enum */ PushEntity$PushType CREATCIRCLEDIDNOTPASS;
    public static final /* enum */ PushEntity$PushType FOLLOWLIST;
    public static final /* enum */ PushEntity$PushType JOINEDTHECIRCLEFAILED;
    public static final /* enum */ PushEntity$PushType LIKELIST;
    public static final /* enum */ PushEntity$PushType PRIME;
    public static final /* enum */ PushEntity$PushType SHARENOTICE;
    public static final /* enum */ PushEntity$PushType SUBJECTNOTIFICATION;
    public static final /* enum */ PushEntity$PushType TEXT;
    public static final /* enum */ PushEntity$PushType WORKS;
    private static final /* synthetic */ PushEntity$PushType[] a;
    private String name;

    static {
        PushEntity$PushType pushEntity$PushType;
        PushEntity$PushType pushEntity$PushType2;
        PushEntity$PushType pushEntity$PushType3;
        PushEntity$PushType pushEntity$PushType4;
        PushEntity$PushType pushEntity$PushType5;
        PushEntity$PushType pushEntity$PushType6;
        PushEntity$PushType pushEntity$PushType7;
        PushEntity$PushType pushEntity$PushType8;
        PushEntity$PushType pushEntity$PushType9;
        PushEntity$PushType pushEntity$PushType10;
        PushEntity$PushType pushEntity$PushType11;
        PushEntity$PushType pushEntity$PushType12;
        PushEntity$PushType pushEntity$PushType13;
        CHAT = pushEntity$PushType13 = new PushEntity$PushType("CHAT", 0, "chat");
        FOLLOWLIST = pushEntity$PushType12 = new PushEntity$PushType("FOLLOWLIST", 1, "followList");
        CIRCLECREATEDSUCCESSFULLY = pushEntity$PushType11 = new PushEntity$PushType("CIRCLECREATEDSUCCESSFULLY", 2, "CircleCreatedSuccessfully");
        LIKELIST = pushEntity$PushType10 = new PushEntity$PushType("LIKELIST", 3, "likeList");
        COMMENT = pushEntity$PushType9 = new PushEntity$PushType("COMMENT", 4, "comment");
        CREATCIRCLEDIDNOTPASS = pushEntity$PushType8 = new PushEntity$PushType("CREATCIRCLEDIDNOTPASS", 5, "creatCircleDidNotPass");
        JOINEDTHECIRCLEFAILED = pushEntity$PushType7 = new PushEntity$PushType("JOINEDTHECIRCLEFAILED", 6, "joinedTheCircleFailed");
        CIRCLEJOINEDSUCCESSFULLY = pushEntity$PushType6 = new PushEntity$PushType("CIRCLEJOINEDSUCCESSFULLY", 7, "circleJoinedSuccessfully");
        SUBJECTNOTIFICATION = pushEntity$PushType5 = new PushEntity$PushType("SUBJECTNOTIFICATION", 8, "subjectNotification");
        ACTIVITYNOTICE = pushEntity$PushType4 = new PushEntity$PushType("ACTIVITYNOTICE", 9, "activityNotice");
        WORKS = pushEntity$PushType3 = new PushEntity$PushType("WORKS", 10, "works");
        CONNECTION = pushEntity$PushType2 = new PushEntity$PushType("CONNECTION", 11, "connection");
        TEXT = pushEntity$PushType = new PushEntity$PushType("TEXT", 12, "text");
        PushEntity$PushType pushEntity$PushType14 = pushEntity$PushType;
        PushEntity$PushType[] pushEntity$PushTypeArray = new PushEntity$PushType("SHARENOTICE", 13, "shareNotice");
        SHARENOTICE = pushEntity$PushTypeArray;
        int n10 = 14;
        PushEntity$PushType[] pushEntity$PushTypeArray2 = pushEntity$PushTypeArray;
        PRIME = pushEntity$PushType = new PushEntity$PushType("PRIME", n10, "primeMessage");
        pushEntity$PushTypeArray = new PushEntity$PushType[15];
        pushEntity$PushTypeArray[0] = pushEntity$PushType13;
        pushEntity$PushTypeArray[1] = pushEntity$PushType12;
        pushEntity$PushTypeArray[2] = pushEntity$PushType11;
        pushEntity$PushTypeArray[3] = pushEntity$PushType10;
        pushEntity$PushTypeArray[4] = pushEntity$PushType9;
        pushEntity$PushTypeArray[5] = pushEntity$PushType8;
        pushEntity$PushTypeArray[6] = pushEntity$PushType7;
        pushEntity$PushTypeArray[7] = pushEntity$PushType6;
        pushEntity$PushTypeArray[8] = pushEntity$PushType5;
        pushEntity$PushTypeArray[9] = pushEntity$PushType4;
        pushEntity$PushTypeArray[10] = pushEntity$PushType3;
        pushEntity$PushTypeArray[11] = pushEntity$PushType2;
        pushEntity$PushTypeArray[12] = pushEntity$PushType14;
        pushEntity$PushTypeArray[13] = pushEntity$PushTypeArray2;
        pushEntity$PushTypeArray[n10] = pushEntity$PushType;
        a = pushEntity$PushTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PushEntity$PushType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.name = var3_1;
    }

    public static PushEntity$PushType fromTypeName(String string2) {
        for (PushEntity$PushType pushEntity$PushType : PushEntity$PushType.values()) {
            String string3 = pushEntity$PushType.getTypeName();
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return pushEntity$PushType;
        }
        return null;
    }

    public static PushEntity$PushType valueOf(String string2) {
        return Enum.valueOf(PushEntity$PushType.class, string2);
    }

    public static PushEntity$PushType[] values() {
        return (PushEntity$PushType[])a.clone();
    }

    public String getTypeName() {
        return this.name;
    }
}

