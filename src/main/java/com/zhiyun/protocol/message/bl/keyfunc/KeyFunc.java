/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.keyfunc;

public final class KeyFunc
extends Enum {
    public static final /* enum */ KeyFunc APP_CUSTOM_MENU;
    public static final /* enum */ KeyFunc APP_PHOTO_VIDEO;
    public static final /* enum */ KeyFunc APP_TRACKING;
    public static final /* enum */ KeyFunc AWAKE;
    public static final /* enum */ KeyFunc DEFAULT;
    public static final /* enum */ KeyFunc GCUMOD_F;
    public static final /* enum */ KeyFunc GCUMOD_GO;
    public static final /* enum */ KeyFunc GCUMOD_L;
    public static final /* enum */ KeyFunc GCUMOD_NEXT;
    public static final /* enum */ KeyFunc GCUMOD_PF;
    public static final /* enum */ KeyFunc GCUMOD_POV;
    public static final /* enum */ KeyFunc GCUMOD_PRE;
    public static final /* enum */ KeyFunc GCUMOD_V;
    public static final /* enum */ KeyFunc HVSWITCH;
    public static final /* enum */ KeyFunc NONE;
    public static final /* enum */ KeyFunc SLEEP;
    public static final /* enum */ KeyFunc SLEEP_AWAKE;
    private static final /* synthetic */ KeyFunc[] a;
    public final int value;

    static {
        KeyFunc keyFunc;
        KeyFunc keyFunc2;
        KeyFunc keyFunc3;
        KeyFunc keyFunc4;
        KeyFunc keyFunc5;
        KeyFunc keyFunc6;
        KeyFunc keyFunc7;
        KeyFunc keyFunc8;
        KeyFunc keyFunc9;
        KeyFunc keyFunc10;
        KeyFunc keyFunc11;
        KeyFunc keyFunc12;
        KeyFunc keyFunc13;
        KeyFunc keyFunc14;
        KeyFunc keyFunc15;
        NONE = keyFunc15 = new KeyFunc("NONE", 0, 0);
        int n10 = 1;
        DEFAULT = keyFunc14 = new KeyFunc("DEFAULT", n10, n10);
        int n11 = 2;
        GCUMOD_PRE = keyFunc13 = new KeyFunc("GCUMOD_PRE", n11, n11);
        int n12 = 3;
        GCUMOD_NEXT = keyFunc12 = new KeyFunc("GCUMOD_NEXT", n12, n12);
        int n13 = 4;
        GCUMOD_PF = keyFunc11 = new KeyFunc("GCUMOD_PF", n13, n13);
        int n14 = 5;
        GCUMOD_L = keyFunc10 = new KeyFunc("GCUMOD_L", n14, n14);
        int n15 = 6;
        GCUMOD_F = keyFunc9 = new KeyFunc("GCUMOD_F", n15, n15);
        n15 = 7;
        GCUMOD_POV = keyFunc8 = new KeyFunc("GCUMOD_POV", n15, n15);
        n14 = 8;
        GCUMOD_GO = keyFunc7 = new KeyFunc("GCUMOD_GO", n14, n14);
        n13 = 9;
        GCUMOD_V = keyFunc6 = new KeyFunc("GCUMOD_V", n13, n13);
        n12 = 10;
        SLEEP_AWAKE = keyFunc5 = new KeyFunc("SLEEP_AWAKE", n12, n12);
        n11 = 11;
        HVSWITCH = keyFunc4 = new KeyFunc("HVSWITCH", n11, n11);
        n10 = 12;
        SLEEP = keyFunc3 = new KeyFunc("SLEEP", n10, n10);
        int n16 = 13;
        AWAKE = keyFunc2 = new KeyFunc("AWAKE", n16, n16);
        APP_PHOTO_VIDEO = keyFunc = new KeyFunc("APP_PHOTO_VIDEO", 14, 176);
        KeyFunc keyFunc16 = keyFunc;
        KeyFunc[] keyFuncArray = new KeyFunc("APP_CUSTOM_MENU", 15, 177);
        APP_CUSTOM_MENU = keyFuncArray;
        n11 = 16;
        KeyFunc[] keyFuncArray2 = keyFuncArray;
        APP_TRACKING = keyFunc = new KeyFunc("APP_TRACKING", n11, 178);
        keyFuncArray = new KeyFunc[17];
        keyFuncArray[0] = keyFunc15;
        keyFuncArray[1] = keyFunc14;
        keyFuncArray[2] = keyFunc13;
        keyFuncArray[3] = keyFunc12;
        keyFuncArray[4] = keyFunc11;
        keyFuncArray[5] = keyFunc10;
        keyFuncArray[6] = keyFunc9;
        keyFuncArray[7] = keyFunc8;
        keyFuncArray[8] = keyFunc7;
        keyFuncArray[9] = keyFunc6;
        keyFuncArray[10] = keyFunc5;
        keyFuncArray[11] = keyFunc4;
        keyFuncArray[12] = keyFunc3;
        keyFuncArray[13] = keyFunc2;
        keyFuncArray[14] = keyFunc16;
        keyFuncArray[15] = keyFuncArray2;
        keyFuncArray[n11] = keyFunc;
        a = keyFuncArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private KeyFunc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static KeyFunc from(int n10) {
        for (KeyFunc keyFunc : KeyFunc.values()) {
            int n11 = keyFunc.value;
            if (n11 != n10) continue;
            return keyFunc;
        }
        return DEFAULT;
    }

    public static KeyFunc valueOf(String string2) {
        return Enum.valueOf(KeyFunc.class, string2);
    }

    public static KeyFunc[] values() {
        return (KeyFunc[])a.clone();
    }
}

