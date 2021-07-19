/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

public final class a {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = 0;
    public static final int D = 0;
    public static final int E = 0;
    public static final int F = 0;
    public static final int G = 0;
    public static final int H = 0;
    public static final int I = 0;
    public static final int J = 0;
    public static final int K = 0;
    public static final int L = 0;
    public static final int M = 0;
    public static final int N = 0;
    public static final int O = 0;
    private static final int P = 512;
    private static final int Q = 3;
    private static final int R = 8;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    public static final int i = 7;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;

    static {
        int n10 = 1;
        j = i.f.c.a.h(n10);
        int n11 = 2;
        k = i.f.c.a.h(n11);
        int n12 = 3;
        l = i.f.c.a.h(n12);
        int n13 = 4;
        m = i.f.c.a.h(n13);
        n = i.f.c.a.g(n10);
        o = i.f.c.a.g(n11);
        p = i.f.c.a.g(n12);
        q = i.f.c.a.g(n13);
        r = i.f.c.a.c(n10);
        s = i.f.c.a.c(n11);
        t = i.f.c.a.c(n12);
        u = i.f.c.a.c(n13);
        v = i.f.c.a.b(n10);
        w = i.f.c.a.b(n11);
        x = i.f.c.a.b(n12);
        y = i.f.c.a.b(n13);
        z = i.f.c.a.e(n10);
        A = i.f.c.a.e(n11);
        B = i.f.c.a.e(n12);
        C = i.f.c.a.e(n13);
        D = i.f.c.a.d(n10);
        E = i.f.c.a.d(n11);
        F = i.f.c.a.d(n12);
        G = i.f.c.a.d(n13);
        H = i.f.c.a.f(n10);
        I = i.f.c.a.f(n11);
        J = i.f.c.a.f(n12);
        K = i.f.c.a.f(n13);
        L = i.f.c.a.a(n10);
        M = i.f.c.a.a(n11);
        N = i.f.c.a.a(n12);
        O = i.f.c.a.a(n13);
    }

    public static final int a(int n10) {
        return i.f.c.a.m(7, n10);
    }

    public static final int b(int n10) {
        return i.f.c.a.m(3, n10);
    }

    public static final int c(int n10) {
        return i.f.c.a.m(2, n10);
    }

    public static final int d(int n10) {
        return i.f.c.a.m(5, n10);
    }

    public static final int e(int n10) {
        return i.f.c.a.m(4, n10);
    }

    public static final int f(int n10) {
        return i.f.c.a.m(6, n10);
    }

    public static final int g(int n10) {
        return i.f.c.a.m(1, n10);
    }

    public static final int h(int n10) {
        return i.f.c.a.m(0, n10);
    }

    public static final int i(int n10) {
        int n11 = i.f.c.a.k(n10);
        switch (n11) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported CvType value: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
                throw unsupportedOperationException;
            }
            case 6: {
                return i.f.c.a.j(n10) * 8;
            }
            case 4: 
            case 5: {
                return i.f.c.a.j(n10) * 4;
            }
            case 2: 
            case 3: 
            case 7: {
                return i.f.c.a.j(n10) * 2;
            }
            case 0: 
            case 1: 
        }
        return i.f.c.a.j(n10);
    }

    public static final int j(int n10) {
        return (n10 >> 3) + 1;
    }

    public static final int k(int n10) {
        return n10 & 7;
    }

    public static final boolean l(int n10) {
        int n11;
        n10 = (n10 = i.f.c.a.k(n10)) < (n11 = 5) ? 1 : 0;
        return n10 != 0;
    }

    public static final int m(int n10, int n11) {
        int n12;
        if (n11 > 0 && n11 < (n12 = 512)) {
            if (n10 >= 0 && n10 < (n12 = 8)) {
                n11 = n11 + -1 << 3;
                return (n10 &= 7) + n11;
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Data type depth should be 0..7");
            throw unsupportedOperationException;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Channels count should be 1..511");
        throw unsupportedOperationException;
    }

    public static final String n(int n10) {
        String string2;
        int n11 = i.f.c.a.k(n10);
        switch (n11) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported CvType value: ");
                stringBuilder.append(n10);
                String string3 = stringBuilder.toString();
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string3);
                throw unsupportedOperationException;
            }
            case 7: {
                string2 = "CV_16F";
                break;
            }
            case 6: {
                string2 = "CV_64F";
                break;
            }
            case 5: {
                string2 = "CV_32F";
                break;
            }
            case 4: {
                string2 = "CV_32S";
                break;
            }
            case 3: {
                string2 = "CV_16S";
                break;
            }
            case 2: {
                string2 = "CV_16U";
                break;
            }
            case 1: {
                string2 = "CV_8S";
                break;
            }
            case 0: {
                string2 = "CV_8U";
            }
        }
        n10 = i.f.c.a.j(n10);
        int n12 = 4;
        if (n10 <= n12) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("C");
            stringBuilder.append(n10);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("C(");
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

