/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import f.h2.t.f0;
import f.q2.u;
import g.h0.a;
import java.security.cert.X509Certificate;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.CertificatePinner;
import okhttp3.CertificatePinner$b;
import okio.ByteString;

public final class CertificatePinner$c {
    private final String a;
    private final String b;
    private final ByteString c;

    /*
     * Unable to fully structure code
     */
    public CertificatePinner$c(String var1_1, String var2_2) {
        block5: {
            block6: {
                block10: {
                    block11: {
                        block9: {
                            block7: {
                                block8: {
                                    f0.p(var1_1, "pattern");
                                    f0.p(var2_2, "pin");
                                    super();
                                    var3_3 = "*.";
                                    var4_4 = 0;
                                    var5_5 = null;
                                    var6_6 = 2;
                                    var7_7 = u.q2((String)var1_1, (String)var3_3, false, var6_6, null);
                                    var8_8 = -1;
                                    if (var7_7 != 0 && (var7_7 = StringsKt__StringsKt.j3((CharSequence)var1_1, var11_11 = "*", var9_9 = 1, false, var10_10 = 4, null)) == var8_8 || (var7_7 = u.q2((String)var1_1, (String)(var3_3 = "**."), false, var6_6, null)) != 0 && (var7_7 = StringsKt__StringsKt.j3((CharSequence)var1_1, var11_11 = "*", var9_9 = 2, false, var10_10 = 4, null)) == var8_8) ** GOTO lbl-1000
                                    var9_9 = 0;
                                    var11_11 = "*";
                                    var10_10 = 6;
                                    var7_7 = StringsKt__StringsKt.j3((CharSequence)var1_1, var11_11, 0, false, var10_10, null);
                                    if (var7_7 == var8_8) lbl-1000:
                                    // 2 sources

                                    {
                                        var7_7 = 1;
                                    } else {
                                        var7_7 = 0;
                                        var3_3 = null;
                                    }
                                    if (var7_7 == 0) break block5;
                                    var3_3 = g.h0.a.e((String)var1_1);
                                    if (var3_3 == null) break block6;
                                    this.a = var3_3;
                                    var1_1 = "sha1/";
                                    var12_12 = u.q2((String)var2_2, (String)var1_1, false, var6_6, null);
                                    var3_3 = "Invalid pin hash: ";
                                    var13_13 = "(this as java.lang.String).substring(startIndex)";
                                    if (!var12_12) break block7;
                                    this.b = "sha1";
                                    var1_1 = ByteString.Companion;
                                    var4_4 = 5;
                                    var5_5 = var2_2.substring(var4_4);
                                    f0.o(var5_5, var13_13);
                                    var1_1 = var1_1.h((String)var5_5);
                                    if (var1_1 == null) break block8;
                                    this.c = var1_1;
                                    break block9;
                                }
                                super();
                                var5_5.append((String)var3_3);
                                var5_5.append((String)var2_2);
                                var2_2 = var5_5.toString();
                                var1_1 = new IllegalArgumentException((String)var2_2);
                                throw var1_1;
                            }
                            var1_1 = "sha256/";
                            var12_12 = u.q2((String)var2_2, (String)var1_1, false, var6_6, null);
                            if (!var12_12) break block10;
                            this.b = "sha256";
                            var1_1 = ByteString.Companion;
                            var4_4 = 7;
                            var5_5 = var2_2.substring(var4_4);
                            f0.o(var5_5, var13_13);
                            var1_1 = var1_1.h((String)var5_5);
                            if (var1_1 == null) break block11;
                            this.c = var1_1;
                        }
                        return;
                    }
                    super();
                    var5_5.append((String)var3_3);
                    var5_5.append((String)var2_2);
                    var2_2 = var5_5.toString();
                    var1_1 = new IllegalArgumentException((String)var2_2);
                    throw var1_1;
                }
                super();
                var3_3.append("pins must start with 'sha256/' or 'sha1/': ");
                var3_3.append((String)var2_2);
                var2_2 = var3_3.toString();
                var1_1 = new IllegalArgumentException((String)var2_2);
                throw var1_1;
            }
            super();
            var3_3.append("Invalid pattern: ");
            var3_3.append((String)var1_1);
            var1_1 = var3_3.toString();
            var2_2 = new IllegalArgumentException((String)var1_1);
            throw var2_2;
        }
        super();
        var2_2.append("Unexpected pattern: ");
        var2_2.append((String)var1_1);
        var1_1 = var2_2.toString();
        var1_1 = var1_1.toString();
        var2_2 = new IllegalArgumentException((String)var1_1);
        throw var2_2;
    }

    public final ByteString a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean d(X509Certificate serializable) {
        f0.p(serializable, "certificate");
        Object object = this.b;
        int n10 = ((String)object).hashCode();
        int n11 = -903629273;
        if (n10 != n11) {
            n11 = 3528965;
            if (n10 != n11) return false;
            Object object2 = "sha1";
            boolean bl2 = ((String)object).equals(object2);
            if (!bl2) return false;
            object = this.c;
            object2 = CertificatePinner.d;
            ByteString byteString = ((CertificatePinner$b)object2).b((X509Certificate)serializable);
            return f0.g(object, byteString);
        }
        Object object3 = "sha256";
        boolean bl3 = ((String)object).equals(object3);
        if (!bl3) return false;
        object = this.c;
        object3 = CertificatePinner.d;
        ByteString byteString = ((CertificatePinner$b)object3).c((X509Certificate)serializable);
        return f0.g(object, byteString);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean e(String string2) {
        f0.p(string2, "hostname");
        String string3 = this.a;
        String string4 = "**.";
        int n10 = 0;
        int n11 = 2;
        int n12 = 0;
        int n13 = u.q2(string3, string4, false, n11, null);
        int n14 = 1;
        if (n13 != 0) {
            string3 = this.a;
            int n15 = string3.length() + -3;
            n13 = string2.length() - n15;
            n12 = string2.length() - n15;
            String string5 = this.a;
            int n16 = 3;
            boolean bl2 = false;
            int n17 = 16;
            n11 = (int)(u.b2(string2, n12, string5, n16, n15, false, n17, null) ? 1 : 0);
            if (n11 == 0) return n10 != 0;
            if (n13 == 0) return n14 != 0;
            n13 -= n14;
            char c10 = string2.charAt(n13);
            if (c10 != (n13 = 46)) return n10 != 0;
            return n14 != 0;
        }
        string3 = this.a;
        String string6 = "*.";
        n13 = u.q2(string3, string6, false, n11, null);
        if (n13 != 0) {
            string3 = this.a;
            int n18 = string3.length() + -1;
            n13 = string2.length() - n18;
            n12 = string2.length() - n18;
            string6 = this.a;
            int n19 = 1;
            int n20 = 0;
            int n21 = 16;
            n11 = (int)(u.b2(string2, n12, string6, n19, n18, false, n21, null) ? 1 : 0);
            if (n11 == 0) return n10 != 0;
            char c11 = '.';
            n19 = n13 + -1;
            n18 = 0;
            n20 = 4;
            n21 = 0;
            int n22 = StringsKt__StringsKt.w3(string2, c11, n19, false, n20, null);
            if (n22 != (n13 = -1)) return n10 != 0;
            return n14 != 0;
        }
        string3 = this.a;
        return f0.g(string2, string3) != 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof CertificatePinner$c;
        if (!bl3) {
            return false;
        }
        Object object2 = this.a;
        object = (CertificatePinner$c)object;
        String string2 = ((CertificatePinner$c)object).a;
        bl3 = f0.g(object2, string2) ^ bl2;
        if (bl3) {
            return false;
        }
        object2 = this.b;
        string2 = ((CertificatePinner$c)object).b;
        bl3 = f0.g(object2, string2) ^ bl2;
        if (bl3) {
            return false;
        }
        object2 = this.c;
        object = ((CertificatePinner$c)object).c;
        boolean bl4 = f0.g(object2, object) ^ bl2;
        if (bl4) {
            return false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.a.hashCode() * 31;
        int n11 = this.b.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.c.hashCode();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.b;
        stringBuilder.append(string2);
        stringBuilder.append('/');
        string2 = this.c.base64();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

