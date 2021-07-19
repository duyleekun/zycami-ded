/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.sms;

public final class AVSMS$TYPE
extends Enum {
    private static final /* synthetic */ AVSMS$TYPE[] $VALUES;
    public static final /* enum */ AVSMS$TYPE TEXT_SMS;
    public static final /* enum */ AVSMS$TYPE VOICE_SMS;
    private String name;

    static {
        AVSMS$TYPE aVSMS$TYPE;
        AVSMS$TYPE aVSMS$TYPE2;
        VOICE_SMS = aVSMS$TYPE2 = new AVSMS$TYPE("VOICE_SMS", 0, "voice");
        int n10 = 1;
        TEXT_SMS = aVSMS$TYPE = new AVSMS$TYPE("TEXT_SMS", n10, "sms");
        AVSMS$TYPE[] aVSMS$TYPEArray = new AVSMS$TYPE[2];
        aVSMS$TYPEArray[0] = aVSMS$TYPE2;
        aVSMS$TYPEArray[n10] = aVSMS$TYPE;
        $VALUES = aVSMS$TYPEArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVSMS$TYPE() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.name = var3_1;
    }

    public static AVSMS$TYPE valueOf(String string2) {
        return Enum.valueOf(AVSMS$TYPE.class, string2);
    }

    public static AVSMS$TYPE[] values() {
        return (AVSMS$TYPE[])$VALUES.clone();
    }

    public String toString() {
        return this.name;
    }
}

