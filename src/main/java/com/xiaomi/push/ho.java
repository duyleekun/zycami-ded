/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ho
extends Enum {
    public static final /* enum */ ho a;
    private static final /* synthetic */ ho[] a;
    public static final /* enum */ ho b;
    public static final /* enum */ ho c;
    public static final /* enum */ ho d;
    public static final /* enum */ ho e;
    public static final /* enum */ ho f;
    public static final /* enum */ ho g;
    public static final /* enum */ ho h;
    public static final /* enum */ ho i;
    public static final /* enum */ ho j;
    public static final /* enum */ ho k;
    public static final /* enum */ ho l;
    public static final /* enum */ ho m;
    public static final /* enum */ ho n;
    public static final /* enum */ ho o;
    public static final /* enum */ ho p;
    public static final /* enum */ ho q;
    public static final /* enum */ ho r;
    public static final /* enum */ ho s;
    public static final /* enum */ ho t;
    public static final /* enum */ ho u;
    public static final /* enum */ ho v;
    public static final /* enum */ ho w;
    public static final /* enum */ ho x;
    private final int a;

    static {
        ho ho2;
        ho ho3;
        ho ho4;
        ho ho5;
        ho ho6;
        ho ho7;
        ho ho8;
        ho ho9;
        ho ho10;
        ho ho11;
        ho ho12;
        ho ho13;
        ho ho14;
        ho ho15;
        ho ho16;
        int n10 = 1;
        a = ho16 = new ho("DeviceInfo", 0, n10);
        int n11 = 2;
        b = ho15 = new ho("AppInstallList", n10, n11);
        int n12 = 3;
        c = ho14 = new ho("AppActiveList", n11, n12);
        int n13 = 4;
        d = ho13 = new ho("Bluetooth", n12, n13);
        int n14 = 5;
        e = ho12 = new ho("Location", n13, n14);
        int n15 = 6;
        f = ho11 = new ho("Account", n14, n15);
        int n16 = 7;
        g = ho10 = new ho("WIFI", n15, n16);
        n15 = 8;
        h = ho9 = new ho("Cellular", n16, n15);
        n14 = 9;
        i = ho8 = new ho("TopApp", n15, n14);
        n13 = 10;
        j = ho7 = new ho("BroadcastAction", n14, n13);
        n12 = 11;
        k = ho6 = new ho("BroadcastActionAdded", n13, n12);
        n11 = 12;
        l = ho5 = new ho("BroadcastActionRemoved", n12, n11);
        n10 = 13;
        m = ho4 = new ho("BroadcastActionReplaced", n11, n10);
        ho ho17 = ho4;
        n13 = 14;
        n = ho3 = new ho("BroadcastActionDataCleared", n10, n13);
        ho ho18 = ho3;
        n12 = 15;
        ho[] hoArray = new ho("BroadcastActionRestarted", n13, n12);
        o = hoArray;
        ho[] hoArray2 = hoArray;
        n11 = 16;
        p = ho2 = new ho("BroadcastActionChanged", n12, n11);
        ho ho19 = ho2;
        n10 = 17;
        q = ho4 = new ho("AppPermission", n11, n10);
        ho ho20 = ho4;
        n13 = 18;
        r = ho3 = new ho("WifiDevicesMac", n10, n13);
        ho ho21 = ho3;
        n12 = 19;
        hoArray = new ho("ActivityActiveTimeStamp", n13, n12);
        s = hoArray;
        ho[] hoArray3 = hoArray;
        n11 = 20;
        t = ho2 = new ho("DeviceBaseInfo", n12, n11);
        ho ho22 = ho2;
        n10 = 21;
        u = ho4 = new ho("DeviceInfoV2", n11, n10);
        n13 = 22;
        v = ho3 = new ho("Battery", n10, n13);
        hoArray = new ho("Storage", n13, 23);
        w = hoArray;
        ho[] hoArray4 = hoArray;
        n11 = 24;
        x = ho2 = new ho("AppIsInstalled", 23, n11);
        hoArray = new ho[n11];
        hoArray[0] = ho16;
        hoArray[1] = ho15;
        hoArray[2] = ho14;
        hoArray[3] = ho13;
        hoArray[4] = ho12;
        hoArray[5] = ho11;
        hoArray[6] = ho10;
        hoArray[7] = ho9;
        hoArray[8] = ho8;
        hoArray[9] = ho7;
        hoArray[10] = ho6;
        hoArray[11] = ho5;
        hoArray[12] = ho17;
        hoArray[13] = ho18;
        hoArray[14] = hoArray2;
        hoArray[15] = ho19;
        hoArray[16] = ho20;
        hoArray[17] = ho21;
        hoArray[18] = hoArray3;
        hoArray[19] = ho22;
        hoArray[20] = ho4;
        hoArray[21] = ho3;
        hoArray[22] = hoArray4;
        hoArray[23] = ho2;
        a = hoArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ho() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static ho a(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 24: {
                return x;
            }
            case 23: {
                return w;
            }
            case 22: {
                return v;
            }
            case 21: {
                return u;
            }
            case 20: {
                return t;
            }
            case 19: {
                return s;
            }
            case 18: {
                return r;
            }
            case 17: {
                return q;
            }
            case 16: {
                return p;
            }
            case 15: {
                return o;
            }
            case 14: {
                return n;
            }
            case 13: {
                return m;
            }
            case 12: {
                return l;
            }
            case 11: {
                return k;
            }
            case 10: {
                return j;
            }
            case 9: {
                return i;
            }
            case 8: {
                return h;
            }
            case 7: {
                return g;
            }
            case 6: {
                return f;
            }
            case 5: {
                return e;
            }
            case 4: {
                return d;
            }
            case 3: {
                return c;
            }
            case 2: {
                return b;
            }
            case 1: 
        }
        return a;
    }

    public static ho valueOf(String string2) {
        return Enum.valueOf(ho.class, string2);
    }

    public static ho[] values() {
        return (ho[])a.clone();
    }

    public int a() {
        return this.a;
    }
}

