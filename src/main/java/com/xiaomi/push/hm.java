/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class hm
extends Enum {
    public static final /* enum */ hm A;
    public static final /* enum */ hm B;
    public static final /* enum */ hm C;
    public static final /* enum */ hm D;
    public static final /* enum */ hm E;
    public static final /* enum */ hm F;
    public static final /* enum */ hm G;
    public static final /* enum */ hm H;
    public static final /* enum */ hm I;
    public static final /* enum */ hm J;
    public static final /* enum */ hm K;
    public static final /* enum */ hm a;
    private static final /* synthetic */ hm[] a;
    public static final /* enum */ hm b;
    public static final /* enum */ hm c;
    public static final /* enum */ hm d;
    public static final /* enum */ hm e;
    public static final /* enum */ hm f;
    public static final /* enum */ hm g;
    public static final /* enum */ hm h;
    public static final /* enum */ hm i;
    public static final /* enum */ hm j;
    public static final /* enum */ hm k;
    public static final /* enum */ hm l;
    public static final /* enum */ hm m;
    public static final /* enum */ hm n;
    public static final /* enum */ hm o;
    public static final /* enum */ hm p;
    public static final /* enum */ hm q;
    public static final /* enum */ hm r;
    public static final /* enum */ hm s;
    public static final /* enum */ hm t;
    public static final /* enum */ hm u;
    public static final /* enum */ hm v;
    public static final /* enum */ hm w;
    public static final /* enum */ hm x;
    public static final /* enum */ hm y;
    public static final /* enum */ hm z;
    private final int a;

    static {
        hm hm2;
        hm hm3;
        hm hm4;
        hm hm5;
        hm hm6;
        hm hm7;
        hm hm8;
        hm hm9;
        hm hm10;
        hm hm11;
        hm hm12;
        hm hm13;
        hm hm14;
        hm hm15;
        hm hm16;
        int n10 = 1;
        a = hm16 = new hm("Registration", 0, n10);
        int n11 = 2;
        b = hm15 = new hm("UnRegistration", n10, n11);
        int n12 = 3;
        c = hm14 = new hm("Subscription", n11, n12);
        int n13 = 4;
        d = hm13 = new hm("UnSubscription", n12, n13);
        int n14 = 5;
        e = hm12 = new hm("SendMessage", n13, n14);
        int n15 = 6;
        f = hm11 = new hm("AckMessage", n14, n15);
        int n16 = 7;
        g = hm10 = new hm("SetConfig", n15, n16);
        n15 = 8;
        h = hm9 = new hm("ReportFeedback", n16, n15);
        n14 = 9;
        i = hm8 = new hm("Notification", n15, n14);
        n13 = 10;
        j = hm7 = new hm("Command", n14, n13);
        n12 = 11;
        k = hm6 = new hm("MultiConnectionBroadcast", n13, n12);
        n11 = 12;
        l = hm5 = new hm("MultiConnectionResult", n12, n11);
        n10 = 13;
        m = hm4 = new hm("ConnectionKick", n11, n10);
        hm hm17 = hm4;
        n13 = 14;
        n = hm3 = new hm("ApnsMessage", n10, n13);
        hm hm18 = hm3;
        n12 = 15;
        hm[] hmArray = new hm("IOSDeviceTokenWrite", n13, n12);
        o = hmArray;
        hm[] hmArray2 = hmArray;
        n11 = 16;
        p = hm2 = new hm("SaveInvalidRegId", n12, n11);
        hm hm19 = hm2;
        n10 = 17;
        q = hm4 = new hm("ApnsCertChanged", n11, n10);
        hm hm20 = hm4;
        n13 = 18;
        r = hm3 = new hm("RegisterDevice", n10, n13);
        n12 = 19;
        hmArray = new hm("ExpandTopicInXmq", n13, n12);
        s = hmArray;
        hm[] hmArray3 = hmArray;
        t = hm2 = new hm("SendMessageNew", n12, 22);
        hm hm21 = hm2;
        u = hm4 = new hm("ExpandTopicInXmqNew", 20, 23);
        hmArray = new hm("DeleteInvalidMessage", 21, 24);
        v = hmArray;
        hm[] hmArray4 = hmArray;
        w = hm2 = new hm("BadAction", 22, 99);
        hm hm22 = hm2;
        hmArray = new hm("Presence", 23, 100);
        x = hmArray;
        hm[] hmArray5 = hmArray;
        y = hm2 = new hm("FetchOfflineMessage", 24, 101);
        hm hm23 = hm2;
        hmArray = new hm("SaveJob", 25, 102);
        z = hmArray;
        hm[] hmArray6 = hmArray;
        A = hm2 = new hm("Broadcast", 26, 103);
        hm hm24 = hm2;
        hmArray = new hm("BatchPresence", 27, 104);
        B = hmArray;
        hm[] hmArray7 = hmArray;
        C = hm2 = new hm("BatchMessage", 28, 105);
        hm hm25 = hm2;
        hmArray = new hm("StatCounter", 29, 107);
        D = hmArray;
        hm[] hmArray8 = hmArray;
        E = hm2 = new hm("FetchTopicMessage", 30, 108);
        hm hm26 = hm2;
        hmArray = new hm("DeleteAliasCache", 31, 109);
        F = hmArray;
        hm[] hmArray9 = hmArray;
        G = hm2 = new hm("UpdateRegistration", 32, 110);
        hm hm27 = hm2;
        hmArray = new hm("BatchMessageNew", 33, 112);
        H = hmArray;
        hm[] hmArray10 = hmArray;
        I = hm2 = new hm("PublicWelfareMessage", 34, 113);
        hm hm28 = hm2;
        hmArray = new hm("RevokeMessage", 35, 114);
        J = hmArray;
        hm[] hmArray11 = hmArray;
        K = hm2 = new hm("SimulatorJob", 36, 200);
        hmArray = new hm[]{hm16, hm15, hm14, hm13, hm12, hm11, hm10, hm9, hm8, hm7, hm6, hm5, hm17, hm18, hmArray2, hm19, hm20, hm3, hmArray3, hm21, hm4, hmArray4, hm22, hmArray5, hm23, hmArray6, hm24, hmArray7, hm25, hmArray8, hm26, hmArray9, hm27, hmArray10, hm28, hmArray11, hm2};
        a = hmArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private hm() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static hm a(int n10) {
        int n11 = 200;
        if (n10 != n11) {
            switch (n10) {
                default: {
                    switch (n10) {
                        default: {
                            switch (n10) {
                                default: {
                                    switch (n10) {
                                        default: {
                                            switch (n10) {
                                                default: {
                                                    return null;
                                                }
                                                case 114: {
                                                    return J;
                                                }
                                                case 113: {
                                                    return I;
                                                }
                                                case 112: 
                                            }
                                            return H;
                                        }
                                        case 110: {
                                            return G;
                                        }
                                        case 109: {
                                            return F;
                                        }
                                        case 108: {
                                            return E;
                                        }
                                        case 107: 
                                    }
                                    return D;
                                }
                                case 105: {
                                    return C;
                                }
                                case 104: {
                                    return B;
                                }
                                case 103: {
                                    return A;
                                }
                                case 102: {
                                    return z;
                                }
                                case 101: {
                                    return y;
                                }
                                case 100: {
                                    return x;
                                }
                                case 99: 
                            }
                            return w;
                        }
                        case 24: {
                            return v;
                        }
                        case 23: {
                            return u;
                        }
                        case 22: 
                    }
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
        return K;
    }

    public static hm valueOf(String string2) {
        return Enum.valueOf(hm.class, string2);
    }

    public static hm[] values() {
        return (hm[])a.clone();
    }

    public int a() {
        return this.a;
    }
}

