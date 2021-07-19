/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import f.h2.t.f0;
import h.m$a;
import okio.ByteString;
import okio.ByteString$a;

public final class g {
    public static final String a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int b = 128;
    public static final int c = 64;
    public static final int d = 32;
    public static final int e = 16;
    public static final int f = 15;
    public static final int g = 8;
    public static final int h = 128;
    public static final int i = 127;
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 8;
    public static final int n = 9;
    public static final int o = 10;
    public static final long p = 125L;
    public static final long q = 123L;
    public static final int r = 126;
    public static final long s = 65535L;
    public static final int t = 127;
    public static final int u = 1001;
    public static final int v = 1005;
    public static final g w;

    static {
        g g10;
        w = g10 = new g();
    }

    private g() {
    }

    public final String a(String string2) {
        f0.p(string2, "key");
        ByteString$a byteString$a = ByteString.Companion;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(a);
        string2 = stringBuilder.toString();
        return byteString$a.l(string2).sha1().base64();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String b(int n10) {
        int n11 = 1000;
        if (n10 >= n11 && n10 < (n11 = 5000)) {
            n11 = 1006;
            int n12 = 1004;
            if (n12 > n10 || n11 < n10) {
                n11 = 2999;
                n12 = 1015;
                if (n12 > n10) return null;
                if (n11 < n10) return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Code ";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            stringBuilder.append(" is reserved and may not be used.");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "Code must be in range [1000,5000): ";
        stringBuilder.append(string3);
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public final void c(m$a m$a, byte[] byArray) {
        int n10;
        int n11;
        f0.p(m$a, "cursor");
        String string2 = "key";
        f0.p(byArray, string2);
        int n12 = byArray.length;
        int n13 = 0;
        do {
            byte[] byArray2 = m$a.e;
            n10 = m$a.f;
            int n14 = m$a.g;
            if (byArray2 == null) continue;
            while (n10 < n14) {
                byte by2 = byArray2[n10];
                byte by3 = byArray[n13 %= n12];
                byArray2[n10] = by2 = (byte)(by2 ^ by3);
                ++n10;
                ++n13;
            }
        } while ((n11 = m$a.h()) != (n10 = -1));
    }

    public final void d(int n10) {
        IllegalArgumentException illegalArgumentException;
        boolean bl2;
        String string2 = this.b(n10);
        if (string2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            illegalArgumentException = null;
        }
        if (bl2) {
            return;
        }
        f0.m(string2);
        string2 = string2.toString();
        illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }
}

