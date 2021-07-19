/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.l2.i;
import f.l2.q;
import f.q2.u;
import g.h0.d;
import g.s;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;

public final class s$b {
    private s$b() {
    }

    public /* synthetic */ s$b(f.h2.t.u u10) {
        this();
    }

    public static final /* synthetic */ void c(s$b s$b, String string2) {
        s$b.f(string2);
    }

    public static final /* synthetic */ void d(s$b s$b, String string2, String string3) {
        s$b.g(string2, string3);
    }

    public static final /* synthetic */ String e(s$b s$b, String[] stringArray, String string2) {
        return s$b.h(stringArray, string2);
    }

    private final void f(String object) {
        Object object2;
        int n10 = object.length();
        int n11 = 1;
        Integer n12 = null;
        if (n10 > 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            n10 = ((String)object).length();
            for (int i10 = 0; i10 < n10; ++i10) {
                int n13 = ((String)object).charAt(i10);
                int n14 = 126;
                int n15 = 33;
                n14 = n15 <= n13 && n14 >= n13 ? n11 : 0;
                if (n14 != 0) {
                    continue;
                }
                object2 = new Object[3];
                Integer n16 = n13;
                object2[0] = n16;
                n12 = i10;
                object2[n11] = n12;
                object2[2] = object;
                object = d.v("Unexpected char %#04x at %d in header name: %s", object2);
                object = object.toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            return;
        }
        object2 = "name is empty".toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    private final void g(String var1_1, String var2_2) {
        var3_3 = var1_1.length();
        var4_4 = null;
        for (var5_5 = 0; var5_5 < var3_3; ++var5_5) {
            var6_6 = var1_1.charAt(var5_5);
            var7_7 = 9;
            var8_8 = 1;
            if (var6_6 == var7_7) ** GOTO lbl-1000
            var7_7 = 126;
            var9_9 = 32;
            if (var9_9 > var6_6 || var7_7 < var6_6) {
                var7_7 = 0;
            } else lbl-1000:
            // 2 sources

            {
                var7_7 = var8_8;
            }
            if (var7_7 != 0) {
                continue;
            }
            var10_10 = new Object[4];
            var11_11 = var6_6;
            var10_10[0] = var11_11;
            var4_4 = var5_5;
            var10_10[var8_8] = var4_4;
            var10_10[2] = var2_2;
            var10_10[3] = var1_1;
            var1_1 = d.v("Unexpected char %#04x at %d in %s value: %s", var10_10);
            var1_1 = var1_1.toString();
            var2_2 = new IllegalArgumentException(var1_1);
            throw var2_2;
        }
    }

    private final String h(String[] stringArray, String string2) {
        int n10 = stringArray.length;
        int n11 = 2;
        i i10 = q.S0(q.W(n10 - n11, 0), n11);
        n11 = i10.e();
        int n12 = i10.f();
        n10 = i10.g();
        if (n10 >= 0 ? n11 <= n12 : n11 >= n12) {
            while (true) {
                int n13;
                String string3;
                boolean bl2;
                if (bl2 = u.I1(string2, string3 = stringArray[n11], (n13 = 1) != 0)) {
                    return stringArray[n11 += n13];
                }
                if (n11 == n12) break;
                n11 += n10;
            }
        }
        return null;
    }

    public final s a(Map map) {
        f0.p(map, "headers");
        return this.i(map);
    }

    public final s b(String ... stringArray) {
        f0.p(stringArray, "namesAndValues");
        int n10 = stringArray.length;
        stringArray = Arrays.copyOf(stringArray, n10);
        return this.j(stringArray);
    }

    public final s i(Map object) {
        boolean bl2;
        f0.p(object, "$this$toHeaders");
        int n10 = object.size() * 2;
        String[] stringArray = new String[n10];
        object = object.entrySet().iterator();
        int n11 = 0;
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = (String)object2.getValue();
            String string3 = "null cannot be cast to non-null type kotlin.CharSequence";
            Objects.requireNonNull(string2, string3);
            string2 = ((Object)StringsKt__StringsKt.p5(string2)).toString();
            Objects.requireNonNull(object2, string3);
            object2 = ((Object)StringsKt__StringsKt.p5((CharSequence)object2)).toString();
            this.f(string2);
            this.g((String)object2, string2);
            stringArray[n11] = string2;
            int n12 = n11 + 1;
            stringArray[n12] = object2;
            n11 += 2;
        }
        object = new s(stringArray, null);
        return object;
    }

    public final s j(String ... stringArray) {
        Object object = "namesAndValues";
        f0.p(stringArray, (String)object);
        int n10 = stringArray.length;
        int n11 = 2;
        int n12 = 1;
        String string2 = null;
        if ((n10 %= n11) == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            int n13;
            stringArray = stringArray.clone();
            object = "null cannot be cast to non-null type kotlin.Array<kotlin.String>";
            Objects.requireNonNull(stringArray, (String)object);
            n10 = stringArray.length;
            String string3 = null;
            for (n13 = 0; n13 < n10; ++n13) {
                int n14;
                String string4 = stringArray[n13];
                if (string4 != null) {
                    n14 = n12;
                } else {
                    n14 = 0;
                    string4 = null;
                }
                if (n14 != 0) {
                    string4 = stringArray[n13];
                    String string5 = "null cannot be cast to non-null type kotlin.CharSequence";
                    Objects.requireNonNull(string4, string5);
                    stringArray[n13] = string4 = ((Object)StringsKt__StringsKt.p5(string4)).toString();
                    continue;
                }
                object = "Headers cannot be null".toString();
                stringArray = new IllegalArgumentException((String)object);
                throw stringArray;
            }
            n10 = stringArray.length;
            object = q.S0(q.n1(0, n10), n11);
            n11 = ((i)object).e();
            n12 = ((i)object).f();
            n10 = ((i)object).g();
            if (n10 >= 0 ? n11 <= n12 : n11 >= n12) {
                while (true) {
                    string2 = stringArray[n11];
                    n13 = n11 + 1;
                    string3 = stringArray[n13];
                    this.f(string2);
                    this.g(string3, string2);
                    if (n11 == n12) break;
                    n11 += n10;
                }
            }
            object = new s(stringArray, null);
            return object;
        }
        object = "Expected alternating header names and values".toString();
        stringArray = new IllegalArgumentException((String)object);
        throw stringArray;
    }
}

