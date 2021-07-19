/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.l2.i;
import f.l2.q;
import f.q2.u;
import g.h0.a;
import g.h0.d;
import g.t;
import g.t$a$a;
import g.t$b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

public final class t$a {
    public static final String i = "Invalid URL host";
    public static final t$a$a j;
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private final List f;
    private List g;
    private String h;

    static {
        t$a$a t$a$a;
        j = t$a$a = new t$a$a(null);
    }

    public t$a() {
        ArrayList<String> arrayList;
        String string2;
        this.b = string2 = "";
        this.c = string2;
        this.e = -1;
        this.f = arrayList = new ArrayList<String>();
        arrayList.add(string2);
    }

    private final void C() {
        Object object = this.f;
        int n10 = object.size();
        int n11 = 1;
        int n12 = (object = (String)object.remove(n10 -= n11)).length();
        if (n12 == 0) {
            n12 = n11;
        } else {
            n12 = 0;
            object = null;
        }
        String string2 = "";
        if (n12 != 0 && (n12 = (object = this.f).isEmpty() ^ n11) != 0) {
            object = this.f;
            int n13 = object.size() - n11;
            object.set(n13, string2);
        } else {
            object = this.f;
            object.add(string2);
        }
    }

    private final void E(String string2, int n10, int n11, boolean bl2, boolean bl3) {
        t$a t$a = this;
        Object object = t.w;
        String string3 = " \"<>^`{}|/\\?#";
        int n12 = 240;
        Object object2 = string2;
        int n13 = n10;
        int n14 = n11;
        int n15 = this.y((String)(object = t$b.f((t$b)object, string2, n10, n11, string3, bl3, false, false, false, null, n12, null)));
        if (n15 != 0) {
            return;
        }
        n15 = this.z((String)object);
        if (n15 != 0) {
            this.C();
            return;
        }
        object2 = this.f;
        n13 = object2.size();
        n14 = 1;
        n15 = (object2 = (CharSequence)object2.get(n13 -= n14)).length();
        if (n15 == 0) {
            n15 = n14;
        } else {
            n15 = 0;
            object2 = null;
        }
        if (n15 != 0) {
            object2 = t$a.f;
            n13 = object2.size() - n14;
            object2.set(n13, object);
        } else {
            object2 = t$a.f;
            object2.add(object);
        }
        if (bl2) {
            object = t$a.f;
            object2 = "";
            object.add(object2);
        }
    }

    private final void H(String string2) {
        Iterable iterable = this.g;
        f0.m(iterable);
        int n10 = iterable.size();
        int n11 = 2;
        iterable = q.S0(q.W(n10 - n11, 0), n11);
        n11 = ((i)iterable).e();
        int n12 = ((i)iterable).f();
        n10 = ((i)iterable).g();
        if (n10 >= 0 ? n11 <= n12 : n11 >= n12) {
            while (true) {
                Object object = this.g;
                f0.m(object);
                object = (String)object.get(n11);
                boolean bl2 = f0.g(string2, object);
                if (bl2) {
                    object = this.g;
                    f0.m(object);
                    int n13 = n11 + 1;
                    object.remove(n13);
                    object = this.g;
                    f0.m(object);
                    object.remove(n11);
                    object = this.g;
                    f0.m(object);
                    bl2 = object.isEmpty();
                    if (bl2) {
                        this.g = null;
                        return;
                    }
                }
                if (n11 == n12) break;
                n11 += n10;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void L(String string2, int n10, int n11) {
        List list;
        if (n10 == n11) {
            return;
        }
        int n12 = string2.charAt(n10);
        int n13 = 47;
        String string3 = "";
        int n14 = 1;
        float f10 = Float.MIN_VALUE;
        if (n12 != n13 && n12 != (n13 = 92)) {
            list = this.f;
            n13 = list.size() - n14;
            list.set(n13, string3);
        } else {
            this.f.clear();
            list = this.f;
            list.add(string3);
        }
        while (true) {
            int n15 = ++n10;
            if (n10 >= n11) {
                return;
            }
            String string4 = "/\\";
            if ((n10 = g.h0.d.q(string2, string4, n10, n11)) < n11) {
                n12 = n14;
            } else {
                n12 = 0;
                list = null;
            }
            boolean bl2 = true;
            this.E(string2, n15, n10, n12 != 0, bl2);
            if (n12 == 0) continue;
        }
    }

    private final t$a f(String string2, boolean bl2) {
        int n10;
        int n11;
        int n12 = 0;
        do {
            n10 = string2.length();
            String string3 = "/\\";
            n11 = g.h0.d.q(string2, string3, n12, n10);
            int n13 = n11 < (n10 = string2.length()) ? (n10 = 1) : 0;
            string3 = string2;
            this.E(string2, n12, n11, n13 != 0, bl2);
        } while ((n12 = n11 + 1) <= (n10 = string2.length()));
        return this;
    }

    private final int i() {
        int n10 = this.e;
        int n11 = -1;
        if (n10 == n11) {
            t$b t$b = t.w;
            String string2 = this.a;
            f0.m(string2);
            n10 = t$b.g(string2);
        }
        return n10;
    }

    private final boolean y(String string2) {
        boolean bl2;
        String string3 = ".";
        boolean bl3 = f0.g(string2, string3);
        boolean bl4 = true;
        if (!bl3 && !(bl2 = u.I1(string2, string3 = "%2e", bl4))) {
            bl4 = false;
        }
        return bl4;
    }

    private final boolean z(String string2) {
        boolean bl2;
        String string3 = "..";
        boolean bl3 = f0.g(string2, string3);
        boolean bl4 = true;
        if (!(bl3 || (bl3 = u.I1(string2, string3 = "%2e.", bl4)) || (bl3 = u.I1(string2, string3 = ".%2e", bl4)) || (bl2 = u.I1(string2, string3 = "%2e%2e", bl4)))) {
            bl4 = false;
        }
        return bl4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final t$a A(t t10, String string2) {
        int n10;
        Object object;
        t$b t$b;
        Object object2;
        int n11;
        float f10;
        int n12;
        int n13;
        int n14;
        int n15;
        Object object3;
        String string3;
        boolean bl2;
        String string4;
        t$a t$a = this;
        String string5 = string2;
        Object object4 = "input";
        f0.p(string2, (String)object4);
        int n16 = 0;
        Object var7_7 = null;
        int n17 = 0;
        int n18 = g.h0.d.D(string2, 0, 0, 3, null);
        int n19 = 2;
        int n20 = g.h0.d.F(string2, n18, 0, n19, null);
        Object object5 = j;
        int n21 = t$a$a.c((t$a$a)object5, string2, n18, n20);
        Object object6 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
        int n22 = -1;
        int n23 = 1;
        float f11 = Float.MIN_VALUE;
        if (n21 != n22) {
            string4 = "https:";
            bl2 = u.n2(string2, string4, n18, n23 != 0);
            if (bl2) {
                this.a = string3 = "https";
                n18 += 6;
            } else {
                string4 = "http:";
                bl2 = u.n2(string2, string4, n18, n23 != 0);
                if (!bl2) {
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("Expected URL scheme 'http' or 'https' but was '");
                    String string6 = string2.substring(0, n21);
                    f0.o(string6, (String)object6);
                    ((StringBuilder)object5).append(string6);
                    ((StringBuilder)object5).append("'");
                    object5 = ((StringBuilder)object5).toString();
                    object4 = new IllegalArgumentException((String)object5);
                    throw object4;
                }
                this.a = string3 = "http";
                n18 += 5;
            }
        } else {
            if (t10 == null) {
                object4 = new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                throw object4;
            }
            this.a = string3 = t10.X();
        }
        n17 = t$a$a.d((t$a$a)object5, string5, n18, n20);
        int n24 = 63;
        int n25 = 35;
        if (n17 < n19 && t10 != null && (n19 = f0.g(object3 = t10.X(), string3 = t$a.a) ^ n23) == 0) {
            t$a.b = object5 = t10.A();
            t$a.c = object5 = t10.w();
            t$a.d = object5 = t10.F();
            t$a.e = n17 = t10.N();
            t$a.f.clear();
            object5 = t$a.f;
            object3 = t10.y();
            object5.addAll(object3);
            if (n18 == n20 || (n17 = (int)string5.charAt(n18)) == n25) {
                object5 = t10.z();
                t$a.m((String)object5);
            }
            int n26 = n23;
            float f12 = f11;
            n15 = n20;
        } else {
            Object object7;
            float f13;
            int n27;
            n14 = n18 += n17;
            n13 = 0;
            float f14 = 0.0f;
            n12 = 0;
            f10 = 0.0f;
            while ((n18 = (n11 = g.h0.d.q(string5, (String)(object4 = "@/\\?#"), n14, n20)) != n20 ? (int)string5.charAt(n11) : n22) != n22 && n18 != n25 && n18 != (n17 = 47) && n18 != (n17 = 92) && n18 != n24) {
                n17 = 64;
                if (n18 != n17) {
                    n27 = n23;
                    f13 = f11;
                    object7 = object6;
                    n15 = n20;
                } else {
                    string4 = "%40";
                    if (n13 == 0) {
                        n18 = 58;
                        n21 = g.h0.d.p(string5, (char)n18, n14, n11);
                        object7 = t.w;
                        int n28 = 240;
                        float f15 = 3.36E-43f;
                        String string7 = " \"':;<=>@[]^`{}|/\\?#";
                        object4 = object7;
                        object5 = string2;
                        n19 = n14;
                        n14 = n21;
                        String string8 = string4;
                        string4 = string7;
                        int n29 = n11;
                        n11 = 1;
                        int n30 = n21;
                        n14 = 0;
                        n25 = 0;
                        object2 = null;
                        n24 = 0;
                        n27 = n23;
                        f13 = f11;
                        n23 = 0;
                        t$b = null;
                        f11 = 0.0f;
                        n22 = n28;
                        n15 = n20;
                        object = object6;
                        n10 = 0;
                        object6 = null;
                        object4 = t$b.f((t$b)object7, string2, n19, n21, string7, n11 != 0, false, false, false, null, n28, null);
                        if (n12 != 0) {
                            object5 = new StringBuilder();
                            object3 = t$a.b;
                            ((StringBuilder)object5).append((String)object3);
                            ((StringBuilder)object5).append(string8);
                            ((StringBuilder)object5).append((String)object4);
                            object4 = ((StringBuilder)object5).toString();
                        }
                        t$a.b = object4;
                        n16 = n29;
                        n18 = n30;
                        if (n30 != n29) {
                            n19 = n30 + 1;
                            n11 = 1;
                            n14 = 0;
                            n25 = 0;
                            object2 = null;
                            n24 = 0;
                            t$b = null;
                            n22 = 240;
                            n10 = 0;
                            object6 = null;
                            string4 = " \"':;<=>@[]^`{}|/\\?#";
                            object4 = object7;
                            object5 = string2;
                            n21 = n29;
                            t$a.c = object4 = t$b.f((t$b)object7, string2, n19, n29, string4, n11 != 0, false, false, false, null, n22, null);
                            n23 = n27;
                            f11 = f13;
                        } else {
                            n23 = n13;
                            f11 = f14;
                        }
                        n13 = n23;
                        f14 = f11;
                        object7 = object;
                        n23 = n27;
                        f11 = f13;
                        n20 = n16;
                    } else {
                        String string9 = string4;
                        n27 = n23;
                        f13 = f11;
                        n15 = n20;
                        object = object6;
                        n10 = n11;
                        StringBuilder stringBuilder = new StringBuilder();
                        object4 = t$a.c;
                        stringBuilder.append((String)object4);
                        stringBuilder.append(string4);
                        object4 = t.w;
                        n11 = 1;
                        n16 = 0;
                        int n31 = 240;
                        float f16 = 3.36E-43f;
                        string4 = " \"':;<=>@[]^`{}|/\\?#";
                        object5 = string2;
                        n19 = n14;
                        n21 = n10;
                        n14 = 0;
                        n25 = 0;
                        object2 = null;
                        n24 = 0;
                        t$b = null;
                        StringBuilder stringBuilder2 = stringBuilder;
                        n22 = n31;
                        object7 = object6;
                        n20 = n10;
                        n10 = 0;
                        object6 = null;
                        object4 = t$b.f((t$b)object4, string2, n19, n21, string4, n11 != 0, false, false, false, null, n31, null);
                        stringBuilder.append((String)object4);
                        t$a.c = object4 = stringBuilder.toString();
                        n23 = n12;
                        f11 = f10;
                    }
                    n14 = n20 + 1;
                    n12 = n23;
                    f10 = f11;
                }
                object6 = object7;
                n23 = n27;
                f11 = f13;
                n20 = n15;
                n25 = 35;
                n24 = 63;
                n22 = -1;
                n16 = 0;
                Object var7_14 = null;
            }
            n27 = n23;
            f13 = f11;
            object7 = object6;
            n15 = n20;
            n20 = n11;
            object2 = j;
            n24 = t$a$a.b((t$a$a)object2, string5, n14, n11);
            n23 = n24 + 1;
            n22 = 34;
            if (n23 < n11) {
                object4 = t.w;
                bl2 = false;
                string4 = null;
                n11 = 4;
                n10 = 0;
                object6 = null;
                object5 = string2;
                n19 = n14;
                n21 = n24;
                n16 = n14;
                n14 = 0;
                t$a.d = object4 = g.h0.a.e(t$b.n((t$b)object4, string2, n19, n24, false, n11, null));
                t$a.e = n18 = t$a$a.a((t$a$a)object2, string5, n23, n20);
                n17 = -1;
                if (n18 != n17) {
                    n18 = n27;
                } else {
                    n18 = 0;
                    object4 = null;
                }
                if (n18 == 0) {
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append("Invalid URL port: \"");
                    object5 = string5.substring(n23, n20);
                    object2 = object7;
                    f0.o(object5, (String)object7);
                    ((StringBuilder)object4).append((String)object5);
                    ((StringBuilder)object4).append((char)n22);
                    object4 = ((StringBuilder)object4).toString();
                    object4 = object4.toString();
                    object5 = new IllegalArgumentException((String)object4);
                    throw object5;
                }
                object2 = object7;
            } else {
                n16 = n14;
                object2 = object6;
                t$b = t.w;
                bl2 = false;
                string4 = null;
                n11 = 4;
                n14 = 0;
                object4 = t$b;
                object5 = string2;
                n19 = n16;
                n21 = n24;
                t$a.d = object4 = g.h0.a.e(t$b.n(t$b, string2, n16, n24, false, n11, null));
                object4 = t$a.a;
                f0.m(object4);
                t$a.e = n18 = t$b.g((String)object4);
            }
            object4 = t$a.d;
            int n32 = object4 != null ? n27 : 0;
            if (n32 == 0) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("Invalid URL host: \"");
                object5 = string5.substring(n16, n24);
                f0.o(object5, (String)object2);
                ((StringBuilder)object4).append((String)object5);
                ((StringBuilder)object4).append((char)n22);
                object4 = ((StringBuilder)object4).toString();
                object4 = object4.toString();
                object5 = new IllegalArgumentException((String)object4);
                throw object5;
            }
            n18 = n20;
        }
        object5 = "?#";
        n16 = n15;
        n17 = g.h0.d.q(string5, (String)object5, n18, n15);
        t$a.L(string5, n18, n17);
        if (n17 < n15 && (n18 = (int)string5.charAt(n17)) == (n19 = 63)) {
            n20 = 35;
            n13 = g.h0.d.p(string5, (char)n20, n17, n15);
            object6 = t.w;
            n19 = n17 + 1;
            n11 = 1;
            n14 = 0;
            n25 = 1;
            n24 = 0;
            n23 = 0;
            f11 = 0.0f;
            t$b = null;
            n22 = 208;
            n12 = 0;
            f10 = 0.0f;
            string4 = " \"'<>#";
            object4 = object6;
            object5 = string2;
            n21 = n13;
            object = object6;
            n10 = 0;
            object6 = null;
            object4 = t$b.f((t$b)object4, string2, n19, n13, string4, n11 != 0, false, n25 != 0, false, null, n22, null);
            t$a.g = object4 = ((t$b)object).p((String)object4);
            n17 = n13;
        }
        if (n17 < n16 && (n18 = (int)string5.charAt(n17)) == (n19 = 35)) {
            object4 = t.w;
            n19 = n17 + 1;
            n11 = 1;
            n14 = 0;
            n25 = 0;
            object2 = null;
            n24 = 1;
            n23 = 0;
            f11 = 0.0f;
            t$b = null;
            n22 = 176;
            n10 = 0;
            object6 = null;
            string4 = "";
            object5 = string2;
            n21 = n16;
            t$a.h = object4 = t$b.f((t$b)object4, string2, n19, n16, string4, n11 != 0, false, false, n24 != 0, null, n22, null);
        }
        return t$a;
    }

    public final t$a B(String string2) {
        f0.p(string2, "password");
        this.c = string2 = t$b.f(t.w, string2, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
        return this;
    }

    public final t$a D(int n10) {
        Serializable serializable;
        char c10;
        int n11 = 1;
        if (n11 > n10 || (c10 = (char)-1) < n10) {
            n11 = 0;
            serializable = null;
        }
        if (n11 != 0) {
            this.e = n10;
            return this;
        }
        serializable = new StringBuilder();
        serializable.append("unexpected port: ");
        serializable.append(n10);
        String string2 = serializable.toString();
        string2 = string2.toString();
        serializable = new IllegalArgumentException(string2);
        throw serializable;
    }

    public final t$a F(String list) {
        int n10;
        boolean bl2;
        String string2;
        t$b t$b;
        list = list != null && (list = t$b.f(t$b = t.w, (String)((Object)list), 0, 0, string2 = " \"'<>#", false, false, bl2 = true, false, null, n10 = 219, null)) != null ? t$b.p((String)((Object)list)) : null;
        this.g = list;
        return this;
    }

    public final t$a G() {
        String string2;
        int n10;
        int n11;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        String string3;
        Object object;
        Object object2;
        Object object3;
        int n12;
        int n13;
        String string4;
        Regex regex;
        t$a t$a = this;
        Object object4 = this.d;
        String string5 = null;
        if (object4 != null) {
            regex = new Regex("[\"<>^`{|}]");
            string4 = "";
            object4 = regex.replace((CharSequence)object4, string4);
        } else {
            n13 = 0;
            object4 = null;
        }
        t$a.d = object4;
        object4 = t$a.f;
        n13 = object4.size();
        int n14 = 0;
        regex = null;
        string4 = null;
        for (n12 = 0; n12 < n13; ++n12) {
            object3 = t$a.f;
            object2 = t.w;
            object = (String)object3.get(n12);
            string3 = null;
            bl4 = true;
            bl3 = true;
            bl2 = false;
            n11 = 0;
            n10 = 227;
            string2 = "[]";
            object2 = t$b.f((t$b)object2, (String)object, 0, 0, string2, bl4, bl3, false, false, null, n10, null);
            object3.set(n12, object2);
        }
        object4 = t$a.g;
        if (object4 != null) {
            n12 = object4.size();
            while (n14 < n12) {
                object = object3 = object4.get(n14);
                object = (String)object3;
                if (object != null) {
                    object2 = t.w;
                    string3 = null;
                    bl4 = true;
                    bl3 = true;
                    bl2 = true;
                    n11 = 0;
                    n10 = 195;
                    string2 = "\\^`{|}";
                    object3 = t$b.f((t$b)object2, (String)object, 0, 0, string2, bl4, bl3, bl2, false, null, n10, null);
                } else {
                    object3 = null;
                }
                object4.set(n14, object3);
                ++n14;
            }
        }
        if ((object2 = t$a.h) != null) {
            object3 = t.w;
            object = null;
            boolean bl5 = true;
            bl4 = true;
            bl3 = false;
            bl2 = true;
            n11 = 163;
            n10 = 0;
            string3 = " \"#<>\\^`{|}";
            string5 = t$b.f((t$b)object3, (String)object2, 0, 0, string3, bl5, bl4, false, bl2, null, n11, null);
        }
        t$a.h = string5;
        return t$a;
    }

    public final t$a I(String string2) {
        f0.p(string2, "encodedName");
        List list = this.g;
        if (list == null) {
            return this;
        }
        string2 = t$b.f(t.w, string2, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null);
        this.H(string2);
        return this;
    }

    public final t$a J(String string2) {
        f0.p(string2, "name");
        List list = this.g;
        if (list == null) {
            return this;
        }
        string2 = t$b.f(t.w, string2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null);
        this.H(string2);
        return this;
    }

    public final t$a K(int n10) {
        Object object = this.f;
        object.remove(n10);
        List list = this.f;
        n10 = (int)(list.isEmpty() ? 1 : 0);
        if (n10 != 0) {
            list = this.f;
            object = "";
            list.add(object);
        }
        return this;
    }

    public final t$a M(String string2) {
        Object object;
        block4: {
            block3: {
                boolean bl2;
                block2: {
                    f0.p(string2, "scheme");
                    object = "http";
                    bl2 = true;
                    boolean bl3 = u.I1(string2, (String)object, bl2);
                    if (!bl3) break block2;
                    this.a = object;
                    break block3;
                }
                object = "https";
                if (!(bl2 = u.I1(string2, (String)object, bl2))) break block4;
                this.a = object;
            }
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected scheme: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final void N(String string2) {
        this.h = string2;
    }

    public final void O(String string2) {
        f0.p(string2, "<set-?>");
        this.c = string2;
    }

    public final t$a P(int n10, String object) {
        CharSequence charSequence;
        f0.p(object, "encodedPathSegment");
        Object object2 = t.w;
        String string2 = " \"<>^`{}|/\\?#";
        boolean bl2 = true;
        int n11 = 243;
        String string3 = t$b.f((t$b)object2, (String)object, 0, 0, string2, bl2, false, false, false, null, n11, null);
        object2 = this.f;
        object2.set(n10, string3);
        n10 = (int)(this.y(string3) ? 1 : 0);
        if (n10 == 0 && (n10 = (int)(this.z(string3) ? 1 : 0)) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            charSequence = null;
        }
        if (n10 != 0) {
            return this;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("unexpected path segment: ");
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public final void Q(List list) {
        this.g = list;
    }

    public final t$a R(String string2, String string3) {
        f0.p(string2, "encodedName");
        this.I(string2);
        this.c(string2, string3);
        return this;
    }

    public final void S(String string2) {
        f0.p(string2, "<set-?>");
        this.b = string2;
    }

    public final void T(String string2) {
        this.d = string2;
    }

    public final t$a U(int n10, String object) {
        f0.p(object, "pathSegment");
        t$b t$b = t.w;
        String string2 = " \"<>^`{}|/\\?#";
        int n11 = 251;
        String string3 = t$b.f(t$b, (String)object, 0, 0, string2, false, false, false, false, null, n11, null);
        boolean bl2 = this.y(string3);
        if (!bl2 && !(bl2 = this.z(string3))) {
            bl2 = true;
        } else {
            bl2 = false;
            t$b = null;
        }
        if (bl2) {
            this.f.set(n10, string3);
            return this;
        }
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("unexpected path segment: ");
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public final void V(int n10) {
        this.e = n10;
    }

    public final t$a W(String string2, String string3) {
        f0.p(string2, "name");
        this.J(string2);
        this.g(string2, string3);
        return this;
    }

    public final void X(String string2) {
        this.a = string2;
    }

    public final t$a Y(String string2) {
        f0.p(string2, "username");
        this.b = string2 = t$b.f(t.w, string2, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
        return this;
    }

    public final t$a a(String string2) {
        f0.p(string2, "encodedPathSegment");
        int n10 = string2.length();
        this.E(string2, 0, n10, false, true);
        return this;
    }

    public final t$a b(String string2) {
        f0.p(string2, "encodedPathSegments");
        return this.f(string2, true);
    }

    public final t$a c(String string2, String string3) {
        t$a t$a = this;
        f0.p(string2, "encodedName");
        List<Object> list = this.g;
        if (list == null) {
            list = new List<Object>();
            this.g = list;
        }
        list = t$a.g;
        f0.m(list);
        t$b t$b = t.w;
        boolean bl2 = true;
        boolean bl3 = true;
        int n10 = 211;
        String string4 = " \"'<>#&=";
        Object object = t$b;
        object = t$b.f(t$b, string2, 0, 0, string4, bl2, false, bl3, false, null, n10, null);
        list.add(object);
        list = t$a.g;
        f0.m(list);
        if (string3 != null) {
            bl2 = true;
            bl3 = true;
            n10 = 211;
            string4 = " \"'<>#&=";
            object = t$b;
            object = t$b.f(t$b, string3, 0, 0, string4, bl2, false, bl3, false, null, n10, null);
        } else {
            object = null;
        }
        list.add(object);
        return t$a;
    }

    public final t$a d(String string2) {
        f0.p(string2, "pathSegment");
        int n10 = string2.length();
        this.E(string2, 0, n10, false, false);
        return this;
    }

    public final t$a e(String string2) {
        f0.p(string2, "pathSegments");
        return this.f(string2, false);
    }

    public final t$a g(String string2, String string3) {
        t$a t$a = this;
        f0.p(string2, "name");
        List<Object> list = this.g;
        if (list == null) {
            list = new List<Object>();
            this.g = list;
        }
        list = t$a.g;
        f0.m(list);
        t$b t$b = t.w;
        boolean bl2 = true;
        int n10 = 219;
        String string4 = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
        Object object = t$b;
        object = t$b.f(t$b, string2, 0, 0, string4, false, false, bl2, false, null, n10, null);
        list.add(object);
        list = t$a.g;
        f0.m(list);
        if (string3 != null) {
            bl2 = true;
            n10 = 219;
            string4 = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
            object = t$b;
            object = t$b.f(t$b, string3, 0, 0, string4, false, false, bl2, false, null, n10, null);
        } else {
            object = null;
        }
        list.add(object);
        return t$a;
    }

    public final t h() {
        t$a t$a = this;
        String string2 = this.a;
        if (string2 != null) {
            Object object = t.w;
            String string3 = this.b;
            int n10 = 0;
            ArrayList arrayList = null;
            int n11 = 7;
            Object object2 = null;
            Object object3 = object;
            Object object4 = t$b.n((t$b)object, string3, 0, 0, false, n11, null);
            string3 = this.c;
            string3 = t$b.n((t$b)object, string3, 0, 0, false, n11, null);
            String string4 = this.d;
            if (string4 != null) {
                int n12;
                boolean bl2;
                t t10;
                Object object5;
                Object object6;
                Object object7;
                n10 = this.i();
                object = this.f;
                int n13 = 10;
                n11 = f.x1.u.Y((Iterable)object, n13);
                arrayList = new ArrayList(n11);
                object = object.iterator();
                while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    object6 = object7 = object.next();
                    object6 = (String)object7;
                    object5 = t.w;
                    t10 = null;
                    bl2 = false;
                    n12 = 7;
                    object7 = t$b.n((t$b)object5, object6, 0, 0, false, n12, null);
                    arrayList.add(object7);
                }
                object = t$a.g;
                n11 = 0;
                object7 = null;
                if (object != null) {
                    n13 = f.x1.u.Y((Iterable)object, n13);
                    object2 = new ArrayList(n13);
                    object = object.iterator();
                    while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        object3 = object.next();
                        object6 = object3;
                        object6 = (String)object3;
                        if (object6 != null) {
                            object5 = t.w;
                            t10 = null;
                            bl2 = true;
                            n12 = 3;
                            object3 = t$b.n((t$b)object5, object6, 0, 0, bl2, n12, null);
                        } else {
                            n13 = 0;
                            object3 = null;
                        }
                        object2.add(object3);
                    }
                } else {
                    object2 = null;
                }
                if ((object6 = t$a.h) != null) {
                    object5 = t.w;
                    t10 = null;
                    bl2 = false;
                    n12 = 7;
                    object5 = object = t$b.n((t$b)object5, object6, 0, 0, false, n12, null);
                } else {
                    object5 = null;
                }
                object6 = this.toString();
                object = t10;
                object3 = object4;
                object7 = object2;
                object2 = object5;
                object4 = object6;
                t10 = new t(string2, (String)object3, string3, string4, n10, arrayList, (List)object7, (String)object5, (String)object6);
                return t10;
            }
            object = new IllegalStateException("host == null");
            throw object;
        }
        IllegalStateException illegalStateException = new IllegalStateException("scheme == null");
        throw illegalStateException;
    }

    public final t$a j(String string2) {
        if (string2 != null) {
            t$b t$b = t.w;
            boolean bl2 = true;
            boolean bl3 = true;
            int n10 = 179;
            String string3 = "";
            string2 = t$b.f(t$b, string2, 0, 0, string3, bl2, false, false, bl3, null, n10, null);
        } else {
            string2 = null;
        }
        this.h = string2;
        return this;
    }

    public final t$a k(String string2) {
        f0.p(string2, "encodedPassword");
        this.c = string2 = t$b.f(t.w, string2, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
        return this;
    }

    public final t$a l(String string2) {
        f0.p(string2, "encodedPath");
        Object object = "/";
        int n10 = 2;
        int n11 = u.q2(string2, (String)object, false, n10, null);
        if (n11 != 0) {
            n11 = string2.length();
            this.L(string2, 0, n11);
            return this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("unexpected encodedPath: ");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        string2 = string2.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final t$a m(String list) {
        int n10;
        boolean bl2;
        boolean bl3;
        String string2;
        t$b t$b;
        list = list != null && (list = t$b.f(t$b = t.w, (String)((Object)list), 0, 0, string2 = " \"'<>#", bl3 = true, false, bl2 = true, false, null, n10 = 211, null)) != null ? t$b.p((String)((Object)list)) : null;
        this.g = list;
        return this;
    }

    public final t$a n(String string2) {
        f0.p(string2, "encodedUsername");
        this.b = string2 = t$b.f(t.w, string2, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
        return this;
    }

    public final t$a o(String string2) {
        if (string2 != null) {
            t$b t$b = t.w;
            boolean bl2 = true;
            int n10 = 187;
            String string3 = "";
            string2 = t$b.f(t$b, string2, 0, 0, string3, false, false, false, bl2, null, n10, null);
        } else {
            string2 = null;
        }
        this.h = string2;
        return this;
    }

    public final String p() {
        return this.h;
    }

    public final String q() {
        return this.c;
    }

    public final List r() {
        return this.f;
    }

    public final List s() {
        return this.g;
    }

    public final String t() {
        return this.b;
    }

    /*
     * WARNING - void declaration
     */
    public String toString() {
        Object object;
        char c10;
        Object object2;
        CharSequence charSequence;
        block21: {
            int n10;
            char c11;
            block22: {
                char c12;
                t$b t$b;
                block20: {
                    block19: {
                        void var3_10;
                        void var3_6;
                        charSequence = new StringBuilder();
                        object2 = this.a;
                        if (object2 != null) {
                            ((StringBuilder)charSequence).append((String)object2);
                            object2 = "://";
                            ((StringBuilder)charSequence).append((String)object2);
                        } else {
                            object2 = "//";
                            ((StringBuilder)charSequence).append((String)object2);
                        }
                        object2 = this.b;
                        int c112 = object2.length();
                        c10 = '\u0001';
                        t$b = null;
                        if (c112 > 0) {
                            char c13 = c10;
                        } else {
                            boolean bl2 = false;
                            object2 = null;
                        }
                        c11 = ':';
                        if (var3_6 != false) break block19;
                        object2 = this.c;
                        int n11 = object2.length();
                        if (n11 > 0) {
                            char c14 = c10;
                        } else {
                            boolean bl3 = false;
                            object2 = null;
                        }
                        if (var3_10 == false) break block20;
                    }
                    object2 = this.b;
                    ((StringBuilder)charSequence).append((String)object2);
                    object2 = this.c;
                    int n12 = object2.length();
                    if (n12 <= 0) {
                        c10 = '\u0000';
                        object = null;
                    }
                    if (c10 != '\u0000') {
                        ((StringBuilder)charSequence).append(c11);
                        object2 = this.c;
                        ((StringBuilder)charSequence).append((String)object2);
                    }
                    char c15 = '@';
                    ((StringBuilder)charSequence).append(c15);
                }
                if ((object2 = this.d) != null) {
                    f0.m(object2);
                    c10 = '\u0002';
                    boolean bl4 = StringsKt__StringsKt.O2((CharSequence)object2, c11, false, c10, null);
                    if (bl4) {
                        ((StringBuilder)charSequence).append('[');
                        object2 = this.d;
                        ((StringBuilder)charSequence).append((String)object2);
                        char c16 = ']';
                        ((StringBuilder)charSequence).append(c16);
                    } else {
                        object2 = this.d;
                        ((StringBuilder)charSequence).append((String)object2);
                    }
                }
                if ((c12 = this.e) == (c10 = '\uffffffff') && (object2 = this.a) == null) break block21;
                n10 = this.i();
                object = this.a;
                if (object == null) break block22;
                t$b = t.w;
                f0.m(object);
                c10 = t$b.g((String)object);
                if (n10 == c10) break block21;
            }
            ((StringBuilder)charSequence).append(c11);
            ((StringBuilder)charSequence).append(n10);
        }
        object2 = t.w;
        object = this.f;
        ((t$b)object2).o((List)object, (StringBuilder)charSequence);
        object = this.g;
        if (object != null) {
            c10 = '?';
            ((StringBuilder)charSequence).append(c10);
            object = this.g;
            f0.m(object);
            ((t$b)object2).q((List)object, (StringBuilder)charSequence);
        }
        if ((object2 = this.h) != null) {
            char c17 = '#';
            ((StringBuilder)charSequence).append(c17);
            object2 = this.h;
            ((StringBuilder)charSequence).append((String)object2);
        }
        charSequence = ((StringBuilder)charSequence).toString();
        f0.o(charSequence, "StringBuilder().apply(builderAction).toString()");
        return charSequence;
    }

    public final String u() {
        return this.d;
    }

    public final int v() {
        return this.e;
    }

    public final String w() {
        return this.a;
    }

    public final t$a x(String string2) {
        f0.p(string2, "host");
        Object object = t.w;
        int n10 = 7;
        Object object2 = g.h0.a.e(t$b.n((t$b)object, string2, 0, 0, false, n10, null));
        if (object2 != null) {
            this.d = object2;
            return this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("unexpected host: ");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        object2 = new IllegalArgumentException(string2);
        throw object2;
    }
}

