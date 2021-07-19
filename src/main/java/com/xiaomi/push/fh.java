/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class fh
extends Enum {
    public static final /* enum */ fh A;
    public static final /* enum */ fh B;
    public static final /* enum */ fh C;
    public static final /* enum */ fh D;
    public static final /* enum */ fh E;
    public static final /* enum */ fh F;
    public static final /* enum */ fh G;
    public static final /* enum */ fh H;
    public static final /* enum */ fh I;
    public static final /* enum */ fh J;
    public static final /* enum */ fh K;
    public static final /* enum */ fh L;
    public static final /* enum */ fh M;
    public static final /* enum */ fh N;
    public static final /* enum */ fh O;
    public static final /* enum */ fh P;
    public static final /* enum */ fh Q;
    public static final /* enum */ fh R;
    public static final /* enum */ fh S;
    public static final /* enum */ fh T;
    public static final /* enum */ fh U;
    public static final /* enum */ fh V;
    public static final /* enum */ fh W;
    public static final /* enum */ fh X;
    public static final /* enum */ fh Y;
    public static final /* enum */ fh Z;
    public static final /* enum */ fh a;
    private static final /* synthetic */ fh[] a;
    public static final /* enum */ fh aa;
    public static final /* enum */ fh ab;
    public static final /* enum */ fh ac;
    public static final /* enum */ fh b;
    public static final /* enum */ fh c;
    public static final /* enum */ fh d;
    public static final /* enum */ fh e;
    public static final /* enum */ fh f;
    public static final /* enum */ fh g;
    public static final /* enum */ fh h;
    public static final /* enum */ fh i;
    public static final /* enum */ fh j;
    public static final /* enum */ fh k;
    public static final /* enum */ fh l;
    public static final /* enum */ fh m;
    public static final /* enum */ fh n;
    public static final /* enum */ fh o;
    public static final /* enum */ fh p;
    public static final /* enum */ fh q;
    public static final /* enum */ fh r;
    public static final /* enum */ fh s;
    public static final /* enum */ fh t;
    public static final /* enum */ fh u;
    public static final /* enum */ fh v;
    public static final /* enum */ fh w;
    public static final /* enum */ fh x;
    public static final /* enum */ fh y;
    public static final /* enum */ fh z;
    private final int a;

    static {
        fh fh2;
        int n10 = 1;
        fh[] fhArray = new fh("TCP_CONN_FAIL", 0, n10);
        a = fhArray;
        int n11 = 2;
        fhArray = new fh("TCP_CONN_TIME", n10, n11);
        b = fhArray;
        int n12 = 3;
        fhArray = new fh("PING_RTT", n11, n12);
        c = fhArray;
        int n13 = 4;
        fhArray = new fh("CHANNEL_CON_FAIL", n12, n13);
        d = fhArray;
        int n14 = 5;
        fhArray = new fh("CHANNEL_CON_OK", n13, n14);
        e = fhArray;
        int n15 = 6;
        fhArray = new fh("ICMP_PING_FAIL", n14, n15);
        f = fhArray;
        int n16 = 7;
        fhArray = new fh("ICMP_PING_OK", n15, n16);
        g = fhArray;
        int n17 = 8;
        fhArray = new fh("CHANNEL_ONLINE_RATE", n16, n17);
        h = fhArray;
        fhArray = new fh("GSLB_REQUEST_SUCCESS", n17, 10000);
        i = fhArray;
        int n18 = 9;
        fhArray = new fh("GSLB_TCP_NOACCESS", n18, 10101);
        j = fhArray;
        int n19 = 10;
        fhArray = new fh("GSLB_TCP_NETUNREACH", n19, 10102);
        k = fhArray;
        int n20 = 11;
        fhArray = new fh("GSLB_TCP_CONNREFUSED", n20, 10103);
        l = fhArray;
        fhArray = new fh("GSLB_TCP_NOROUTETOHOST", 12, 10104);
        m = fhArray;
        fhArray = new fh("GSLB_TCP_TIMEOUT", 13, 10105);
        n = fhArray;
        fhArray = new fh("GSLB_TCP_INVALARG", 14, 10106);
        o = fhArray;
        fhArray = new fh("GSLB_TCP_UKNOWNHOST", 15, 10107);
        p = fhArray;
        fhArray = new fh("GSLB_TCP_ERR_OTHER", 16, 10199);
        q = fhArray;
        fhArray = new fh("GSLB_ERR", 17, 10999);
        r = fhArray;
        fhArray = new fh("CONN_SUCCESS", 18, 20000);
        s = fhArray;
        fhArray = new fh("CONN_TCP_NOACCESS", 19, 20101);
        t = fhArray;
        fhArray = new fh("CONN_TCP_NETUNREACH", 20, 20102);
        u = fhArray;
        fhArray = new fh("CONN_TCP_CONNREFUSED", 21, 20103);
        v = fhArray;
        fhArray = new fh("CONN_TCP_NOROUTETOHOST", 22, 20104);
        w = fhArray;
        fhArray = new fh("CONN_TCP_TIMEOUT", 23, 20105);
        x = fhArray;
        fhArray = new fh("CONN_TCP_INVALARG", 24, 20106);
        y = fhArray;
        fhArray = new fh("CONN_TCP_UKNOWNHOST", 25, 20107);
        z = fhArray;
        fhArray = new fh("CONN_TCP_ERR_OTHER", 26, 20199);
        A = fhArray;
        fhArray = new fh("CONN_XMPP_ERR", 27, 20399);
        B = fhArray;
        fhArray = new fh("CONN_BOSH_UNKNOWNHOST", 28, 20407);
        C = fhArray;
        fhArray = new fh("CONN_BOSH_ERR", 29, 20499);
        D = fhArray;
        fhArray = new fh("BIND_SUCCESS", 30, 30000);
        E = fhArray;
        fhArray = new fh("BIND_TCP_READ_TIMEOUT_DEPRECTED", 31, 30101);
        F = fhArray;
        fhArray = new fh("BIND_TCP_CONNRESET_DEPRECTED", 32, 30102);
        G = fhArray;
        fhArray = new fh("BIND_TCP_BROKEN_PIPE_DEPRECTED", 33, 30103);
        H = fhArray;
        fhArray = new fh("BIND_TCP_READ_TIMEOUT", 34, 30108);
        I = fhArray;
        fhArray = new fh("BIND_TCP_CONNRESET", 35, 30109);
        J = fhArray;
        fhArray = new fh("BIND_TCP_BROKEN_PIPE", 36, 30110);
        K = fhArray;
        fhArray = new fh("BIND_TCP_ERR", 37, 30199);
        L = fhArray;
        fhArray = new fh("BIND_XMPP_ERR", 38, 30399);
        M = fhArray;
        fhArray = new fh("BIND_BOSH_ITEM_NOT_FOUND", 39, 30401);
        N = fhArray;
        fhArray = new fh("BIND_BOSH_ERR", 40, 30499);
        O = fhArray;
        fhArray = new fh("BIND_TIMEOUT", 41, 30501);
        P = fhArray;
        fhArray = new fh("BIND_INVALID_SIG", 42, 30502);
        Q = fhArray;
        fhArray = new fh("CHANNEL_TCP_READTIMEOUT_DEPRECTED", 43, 40101);
        R = fhArray;
        fhArray = new fh("CHANNEL_TCP_CONNRESET_DEPRECTED", 44, 40102);
        S = fhArray;
        fhArray = new fh("CHANNEL_TCP_BROKEN_PIPE_DEPRECTED", 45, 40103);
        T = fhArray;
        fhArray = new fh("CHANNEL_TCP_READTIMEOUT", 46, 40108);
        U = fhArray;
        fhArray = new fh("CHANNEL_TCP_CONNRESET", 47, 40109);
        V = fhArray;
        fhArray = new fh("CHANNEL_TCP_BROKEN_PIPE", 48, 40110);
        W = fhArray;
        fhArray = new fh("CHANNEL_TCP_ERR", 49, 40199);
        X = fhArray;
        fhArray = new fh("CHANNEL_XMPPEXCEPTION", 50, 40399);
        Y = fhArray;
        fhArray = new fh("CHANNEL_BOSH_ITEMNOTFIND", 51, 40401);
        Z = fhArray;
        fhArray = new fh("CHANNEL_BOSH_EXCEPTION", 52, 40499);
        aa = fhArray;
        fhArray = new fh("CHANNEL_TIMER_DELAYED", 53, 50001);
        ab = fhArray;
        fhArray = new fh("CHANNEL_STATS_COUNTER", 54, 8000);
        ac = fhArray;
        fhArray = new fh[55];
        fhArray[0] = fh2 = a;
        fhArray[n10] = fh2 = b;
        fhArray[n11] = fh2 = c;
        fhArray[n12] = fh2 = d;
        fhArray[n13] = fh2 = e;
        fhArray[n14] = fh2 = f;
        fhArray[n15] = fh2 = g;
        fhArray[n16] = fh2 = h;
        fhArray[n17] = fh2 = i;
        fhArray[n18] = fh2 = j;
        fhArray[n19] = fh2 = k;
        fhArray[n20] = fh2 = l;
        fhArray[12] = fh2 = m;
        fhArray[13] = fh2 = n;
        fhArray[14] = fh2 = o;
        fhArray[15] = fh2 = p;
        fhArray[16] = fh2 = q;
        fhArray[17] = fh2 = r;
        fhArray[18] = fh2 = s;
        fhArray[19] = fh2 = t;
        fhArray[20] = fh2 = u;
        fhArray[21] = fh2 = v;
        fhArray[22] = fh2 = w;
        fhArray[23] = fh2 = x;
        fhArray[24] = fh2 = y;
        fhArray[25] = fh2 = z;
        fhArray[26] = fh2 = A;
        fhArray[27] = fh2 = B;
        fhArray[28] = fh2 = C;
        fhArray[29] = fh2 = D;
        fhArray[30] = fh2 = E;
        fhArray[31] = fh2 = F;
        fhArray[32] = fh2 = G;
        fhArray[33] = fh2 = H;
        fhArray[34] = fh2 = I;
        fhArray[35] = fh2 = J;
        fhArray[36] = fh2 = K;
        fhArray[37] = fh2 = L;
        fhArray[38] = fh2 = M;
        fhArray[39] = fh2 = N;
        fhArray[40] = fh2 = O;
        fhArray[41] = fh2 = P;
        fhArray[42] = fh2 = Q;
        fhArray[43] = fh2 = R;
        fhArray[44] = fh2 = S;
        fhArray[45] = fh2 = T;
        fhArray[46] = fh2 = U;
        fhArray[47] = fh2 = V;
        fhArray[48] = fh2 = W;
        fhArray[49] = fh2 = X;
        fhArray[50] = fh2 = Y;
        fhArray[51] = fh2 = Z;
        fhArray[52] = fh2 = aa;
        fhArray[53] = fh2 = ab;
        fhArray[54] = fh2 = ac;
        a = fhArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private fh() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static fh a(int n10) {
        int n11 = 30501;
        if (n10 != n11) {
            n11 = 30502;
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
                                                        switch (n10) {
                                                            default: {
                                                                switch (n10) {
                                                                    default: {
                                                                        switch (n10) {
                                                                            default: {
                                                                                return null;
                                                                            }
                                                                            case 40110: {
                                                                                return W;
                                                                            }
                                                                            case 40109: {
                                                                                return V;
                                                                            }
                                                                            case 40108: 
                                                                        }
                                                                        return U;
                                                                    }
                                                                    case 40103: {
                                                                        return T;
                                                                    }
                                                                    case 40102: {
                                                                        return S;
                                                                    }
                                                                    case 40101: 
                                                                }
                                                                return R;
                                                            }
                                                            case 30110: {
                                                                return K;
                                                            }
                                                            case 30109: {
                                                                return J;
                                                            }
                                                            case 30108: 
                                                        }
                                                        return I;
                                                    }
                                                    case 30103: {
                                                        return H;
                                                    }
                                                    case 30102: {
                                                        return G;
                                                    }
                                                    case 30101: 
                                                }
                                                return F;
                                            }
                                            case 20107: {
                                                return z;
                                            }
                                            case 20106: {
                                                return y;
                                            }
                                            case 20105: {
                                                return x;
                                            }
                                            case 20104: {
                                                return w;
                                            }
                                            case 20103: {
                                                return v;
                                            }
                                            case 20102: {
                                                return u;
                                            }
                                            case 20101: 
                                        }
                                        return t;
                                    }
                                    case 10107: {
                                        return p;
                                    }
                                    case 10106: {
                                        return o;
                                    }
                                    case 10105: {
                                        return n;
                                    }
                                    case 10104: {
                                        return m;
                                    }
                                    case 10103: {
                                        return l;
                                    }
                                    case 10102: {
                                        return k;
                                    }
                                    case 10101: 
                                }
                                return j;
                            }
                            case 50001: {
                                return ab;
                            }
                            case 40499: {
                                return aa;
                            }
                            case 40401: {
                                return Z;
                            }
                            case 40399: {
                                return Y;
                            }
                            case 40199: {
                                return X;
                            }
                            case 30499: {
                                return O;
                            }
                            case 30401: {
                                return N;
                            }
                            case 30399: {
                                return M;
                            }
                            case 30199: {
                                return L;
                            }
                            case 30000: {
                                return E;
                            }
                            case 20499: {
                                return D;
                            }
                            case 20407: {
                                return C;
                            }
                            case 20399: {
                                return B;
                            }
                            case 20199: {
                                return A;
                            }
                            case 20000: {
                                return s;
                            }
                            case 10999: {
                                return r;
                            }
                            case 10199: {
                                return q;
                            }
                            case 10000: {
                                return i;
                            }
                            case 8000: 
                        }
                        return ac;
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
            return Q;
        }
        return P;
    }

    public static fh valueOf(String string2) {
        return Enum.valueOf(fh.class, string2);
    }

    public static fh[] values() {
        return (fh[])a.clone();
    }

    public int a() {
        return this.a;
    }
}

