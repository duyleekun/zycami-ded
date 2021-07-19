/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.publicsuffix;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.d;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class PublicSuffixDatabase$a {
    private PublicSuffixDatabase$a() {
    }

    public /* synthetic */ PublicSuffixDatabase$a(u u10) {
        this();
    }

    public static final /* synthetic */ String a(PublicSuffixDatabase$a publicSuffixDatabase$a, byte[] byArray, byte[][] byArray2, int n10) {
        return publicSuffixDatabase$a.b(byArray, byArray2, n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final String b(byte[] byArray, byte[][] byArray2, int n10) {
        byte[] byArray3 = byArray;
        byte[][] byArray4 = byArray2;
        int n11 = byArray.length;
        int n12 = 0;
        block0: while (n12 < n11) {
            int n13;
            int n14;
            int n15;
            int n16;
            int n17;
            int n18;
            int n19;
            int n20 = (n12 + n11) / 2;
            while (true) {
                n19 = 10;
                n18 = -1;
                if (n20 <= n18 || (n17 = byArray3[n20]) == (n16 = (int)n19)) break;
                n20 += -1;
            }
            n17 = 1;
            float f10 = Float.MIN_VALUE;
            n16 = n17;
            float f11 = f10;
            while ((n15 = byArray3[n14 = ++n20 + n16]) != (n13 = (int)n19)) {
                ++n16;
            }
            n19 = n14 - n20;
            n15 = n10;
            n16 = 0;
            f11 = 0.0f;
            byte[] byArray5 = null;
            n13 = 0;
            int n21 = 0;
            while (true) {
                float f12;
                int n22;
                block13: {
                    block14: {
                        block16: {
                            int n23;
                            block17: {
                                block15: {
                                    block12: {
                                        byte[] byArray6;
                                        int n24 = 255;
                                        if (n16 != 0) {
                                            n16 = 46;
                                            f11 = 6.4E-44f;
                                            n22 = 0;
                                            f12 = 0.0f;
                                            byArray6 = null;
                                        } else {
                                            byArray6 = byArray4[n15];
                                            int n25 = d.b(byArray6[n13], n24);
                                            n22 = n16;
                                            f12 = f11;
                                            n16 = n25;
                                        }
                                        int n26 = n20 + n21;
                                        n23 = d.b(byArray3[n26], n24);
                                        if ((n16 -= n23) != 0) break block12;
                                        ++n13;
                                        if (++n21 == n19) break block12;
                                        byte[] byArray7 = byArray4[n15];
                                        n23 = byArray7.length;
                                        if (n23 != n13) break block13;
                                        n23 = byArray4.length - n17;
                                        if (n15 != n23) break block14;
                                    }
                                    if (n16 < 0) break block15;
                                    if (n16 > 0) break block16;
                                    n23 = n19 - n21;
                                    byte[] byArray8 = byArray4[n15];
                                    n18 = byArray8.length - n13;
                                    ++n15;
                                    n17 = byArray4.length;
                                    while (n15 < n17) {
                                        byArray5 = byArray4[n15];
                                        n16 = byArray5.length;
                                        n18 += n16;
                                        ++n15;
                                    }
                                    if (n18 >= n23) break block17;
                                }
                                n11 = n20 += -1;
                                continue block0;
                            }
                            if (n18 <= n23) {
                                Charset charset = StandardCharsets.UTF_8;
                                f0.o(charset, "UTF_8");
                                return new String(byArray3, n20, n19, charset);
                            }
                        }
                        n12 = n14 + 1;
                        continue block0;
                    }
                    ++n15;
                    n13 = n18;
                    n16 = n17;
                    f11 = f10;
                    continue;
                }
                n16 = n22;
                f11 = f12;
            }
            break;
        }
        return null;
    }

    public final PublicSuffixDatabase c() {
        return PublicSuffixDatabase.a();
    }
}

