/*
 * Decompiled with CFR 0.151.
 */
package g.h0;

import f.h2.t.f0;
import f.q2.u;
import g.h0.d;
import h.m;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.text.StringsKt__StringsKt;

public final class a {
    private static final boolean a(String string2) {
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = string2.charAt(i10);
            int n12 = f0.t(n11, 31);
            boolean bl2 = true;
            if (n12 > 0 && (n12 = f0.t(n11, 127)) < 0) {
                String string3 = " #%/:?@[\\]";
                int n13 = 6;
                n12 = StringsKt__StringsKt.i3(string3, (char)n11, 0, false, n13, null);
                if (n12 == (n11 = -1)) continue;
                return bl2;
            }
            return bl2;
        }
        return false;
    }

    private static final boolean b(String string2, int n10, int n11, byte[] byArray, int n12) {
        byte by2;
        int n13 = n12;
        while (true) {
            int n14;
            int n15;
            int n16;
            int n17;
            by2 = 0;
            if (n10 >= n11) break;
            int n18 = byArray.length;
            if (n13 == n18) {
                return false;
            }
            if (n13 != n12) {
                n18 = string2.charAt(n10);
                if (n18 != (n17 = 46)) {
                    return false;
                }
                ++n10;
            }
            n17 = 0;
            for (n18 = n10; n18 < n11 && (n16 = f0.t(n15 = string2.charAt(n18), n14 = 48)) >= 0 && (n16 = f0.t(n15, 57)) <= 0; ++n18) {
                if (n17 == 0 && n10 != n18) {
                    return false;
                }
                if ((n17 = n17 * 10 + n15 - n14) <= (n15 = 255)) continue;
                return false;
            }
            if ((n10 = n18 - n10) == 0) {
                return false;
            }
            n10 = n13 + 1;
            byArray[n13] = by2 = (byte)n17;
            n13 = n10;
            n10 = n18;
        }
        if (n13 == (n12 += 4)) {
            by2 = 1;
        }
        return by2 != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final InetAddress c(String string2, int n10, int n11) {
        String string3 = string2;
        int n12 = n11;
        int n13 = 16;
        byte[] byArray = new byte[n13];
        int n14 = -1;
        int n15 = n10;
        int n16 = n14;
        int n17 = n14;
        int n18 = 0;
        while (true) {
            int n19;
            int n20;
            int n21;
            block12: {
                block7: {
                    block10: {
                        block11: {
                            String string4;
                            int n22;
                            int n23;
                            block8: {
                                int n24;
                                block9: {
                                    if (n15 >= n12) break block7;
                                    if (n18 == n13) {
                                        return null;
                                    }
                                    n23 = n15 + 2;
                                    if (n23 > n12) break block8;
                                    n22 = 4;
                                    string4 = "::";
                                    n21 = n15;
                                    n24 = n23;
                                    n23 = 0;
                                    n20 = (int)(u.p2(string2, string4, n15, false, n22, null) ? 1 : 0);
                                    if (n20 == 0) break block8;
                                    if (n16 != n14) {
                                        return null;
                                    }
                                    n18 += 2;
                                    if (n24 != n12) break block9;
                                    n16 = n18;
                                    break block7;
                                }
                                n17 = n24;
                                n16 = n18;
                                break block10;
                            }
                            if (n18 == 0) break block11;
                            n22 = 4;
                            n23 = 0;
                            string4 = ":";
                            n21 = n15;
                            n20 = (int)(u.p2(string2, string4, n15, false, n22, null) ? 1 : 0);
                            if (n20 != 0) break block11;
                            n22 = 4;
                            n23 = 0;
                            string4 = ".";
                            n20 = (int)(u.p2(string2, string4, n15, false, n22, null) ? 1 : 0);
                            if (n20 == 0) return null;
                            n20 = n18 + -2;
                            if ((n20 = (int)(a.b(string3, n17, n12, byArray, n20) ? 1 : 0)) == 0) {
                                return null;
                            }
                            n18 += 2;
                            break block7;
                        }
                        n17 = ++n15;
                    }
                    n20 = 0;
                    break block12;
                }
                if (n18 == n13) return InetAddress.getByAddress(byArray);
                if (n16 == n14) {
                    return null;
                }
                n20 = n18 - n16;
                n19 = 16 - n20;
                System.arraycopy(byArray, n16, byArray, n19, n20);
                n13 = n13 - n18 + n16;
                n20 = (byte)0;
                Arrays.fill(byArray, n16, n13, (byte)n20);
                return InetAddress.getByAddress(byArray);
            }
            for (n15 = n17; n15 < n12 && (n19 = d.N(string3.charAt(n15))) != n14; ++n15) {
                n20 = (n20 << 4) + n19;
            }
            n19 = n15 - n17;
            if (n19 == 0) return null;
            n21 = 4;
            if (n19 > n21) {
                return null;
            }
            n19 = n18 + 1;
            byArray[n18] = n21 = (int)((byte)(n20 >>> 8 & 0xFF));
            n18 = n19 + 1;
            byArray[n19] = n20 = (int)((byte)(n20 & 0xFF));
        }
    }

    private static final String d(byte[] byArray) {
        int n10;
        int n11;
        int n12;
        int n13 = 0;
        int n14 = -1;
        int n15 = 0;
        m m10 = null;
        int n16 = 0;
        while (true) {
            n12 = byArray.length;
            n11 = 16;
            if (n15 >= n12) break;
            for (n12 = n15; n12 < n11 && (n10 = byArray[n12]) == 0; n12 += 2) {
                n10 = n12 + 1;
                if ((n10 = byArray[n10]) != 0) break;
            }
            if ((n11 = n12 - n15) > n16 && n11 >= (n10 = 4)) {
                n14 = n15;
                n16 = n11;
            }
            n15 = n12 + 2;
        }
        m10 = new m();
        while (n13 < (n12 = byArray.length)) {
            n12 = 58;
            if (n13 == n14) {
                m10.b1(n12);
                if ((n13 += n16) != n11) continue;
                m10.b1(n12);
                continue;
            }
            if (n13 > 0) {
                m10.b1(n12);
            }
            n12 = byArray[n13];
            n10 = 255;
            n12 = d.b((byte)n12, n10) << 8;
            byte by2 = n13 + 1;
            by2 = byArray[by2];
            n10 = d.b(by2, n10);
            long l10 = n12 |= n10;
            m10.d1(l10);
            n13 += 2;
        }
        return m10.f0();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final String e(String object) {
        Object object2;
        block16: {
            int n10;
            Object object3;
            block17: {
                f0.p(object, "$this$toCanonicalHost");
                object2 = ":";
                int n11 = 0;
                Object var3_3 = null;
                int n12 = 2;
                int n13 = 0;
                object3 = null;
                n10 = StringsKt__StringsKt.P2((CharSequence)object, (CharSequence)object2, false, n12, null);
                int n14 = 1;
                if (n10 != 0) {
                    object2 = "[";
                    n10 = u.q2((String)object, (String)object2, false, n12, null);
                    if (n10 != 0 && (n10 = (int)(u.H1((String)object, (String)(object2 = "]"), false, n12, null) ? 1 : 0)) != 0) {
                        n10 = ((String)object).length() - n14;
                        object2 = a.c((String)object, n14, n10);
                    } else {
                        n10 = ((String)object).length();
                        object2 = a.c((String)object, 0, n10);
                    }
                    if (object2 == null) return null;
                    byte[] byArray = ((InetAddress)object2).getAddress();
                    n12 = byArray.length;
                    if (n12 == (n13 = 16)) {
                        f0.o(byArray, "address");
                        return a.d(byArray);
                    }
                    n11 = byArray.length;
                    n12 = 4;
                    if (n11 == n12) {
                        return ((InetAddress)object2).getHostAddress();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid IPv6 address: '");
                    stringBuilder.append((String)object);
                    stringBuilder.append('\'');
                    object = stringBuilder.toString();
                    object2 = new AssertionError(object);
                    throw object2;
                }
                try {
                    object = IDN.toASCII((String)object);
                    object2 = "IDN.toASCII(host)";
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    return null;
                }
                f0.o(object, (String)object2);
                object2 = Locale.US;
                String string2 = "Locale.US";
                f0.o(object2, string2);
                if (object == null) break block16;
                object = ((String)object).toLowerCase((Locale)object2);
                object2 = "(this as java.lang.String).toLowerCase(locale)";
                f0.o(object, (String)object2);
                n10 = object.length();
                if (n10 == 0) {
                    n11 = n14;
                }
                if (n11 == 0) break block17;
                return null;
            }
            n10 = (int)(a.a((String)object) ? 1 : 0);
            if (n10 == 0) return object;
            return object3;
        }
        object2 = "null cannot be cast to non-null type java.lang.String";
        object = new NullPointerException((String)object2);
        throw object;
    }
}

