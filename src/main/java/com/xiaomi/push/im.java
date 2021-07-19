/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ia;
import com.xiaomi.push.ib;
import com.xiaomi.push.ix;
import com.xiaomi.push.iy;
import com.xiaomi.push.jf;
import com.xiaomi.push.jh;
import com.xiaomi.push.ji;
import com.xiaomi.push.jj;
import com.xiaomi.push.jl;
import com.xiaomi.push.jn;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class im
implements ix,
Serializable,
Cloneable {
    private static final jf A;
    private static final jf B;
    private static final jf a;
    private static final jn a;
    private static final jf b;
    private static final jf c;
    private static final jf d;
    private static final jf e;
    private static final jf f;
    private static final jf g;
    private static final jf h;
    private static final jf i;
    private static final jf j;
    private static final jf k;
    private static final jf l;
    private static final jf m;
    private static final jf n;
    private static final jf o;
    private static final jf p;
    private static final jf q;
    private static final jf r;
    private static final jf s;
    private static final jf t;
    private static final jf u;
    private static final jf v;
    private static final jf w;
    private static final jf x;
    private static final jf y;
    private static final jf z;
    public int a;
    public long a;
    public ia a;
    public ib a;
    public String a;
    private BitSet a;
    public Map a;
    public boolean a;
    public int b;
    public long b;
    public String b;
    public boolean b;
    public int c;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;

    static {
        Object object = new jn("XmPushActionRegistration");
        a = object;
        String string2 = "";
        byte by2 = 11;
        a = object = new jf(string2, by2, 1);
        byte by3 = 12;
        byte by4 = 2;
        b = object = new jf(string2, by3, by4);
        c = object = new jf(string2, by2, 3);
        d = object = new jf(string2, by2, 4);
        e = object = new jf(string2, by2, 5);
        f = object = new jf(string2, by2, 6);
        g = object = new jf(string2, by2, 7);
        byte by5 = 8;
        h = object = new jf(string2, by2, by5);
        i = object = new jf(string2, by2, 9);
        byte by6 = 10;
        j = object = new jf(string2, by2, by6);
        k = object = new jf(string2, by2, by2);
        l = object = new jf(string2, by2, by3);
        by3 = 13;
        m = object = new jf(string2, by5, by3);
        n = object = new jf(string2, by5, 14);
        o = object = new jf(string2, by2, 15);
        p = object = new jf(string2, by2, 16);
        q = object = new jf(string2, by2, 17);
        r = object = new jf(string2, by2, 18);
        s = object = new jf(string2, by5, 19);
        t = object = new jf(string2, by5, 20);
        u = object = new jf(string2, by4, 21);
        v = object = new jf(string2, by6, 22);
        w = object = new jf(string2, by6, 23);
        x = object = new jf(string2, by2, 24);
        y = object = new jf(string2, by2, 25);
        z = object = new jf(string2, by3, 100);
        A = object = new jf(string2, by4, 101);
        B = object = new jf(string2, by2, 102);
    }

    public im() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(7);
        this.a = true;
        this.b = false;
    }

    public boolean A() {
        return this.a.get(6);
    }

    public boolean B() {
        boolean bl2;
        String string2 = this.r;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public int a(im object) {
        int n10;
        long l10;
        long l11;
        int n11;
        Object object2;
        Object object3 = this.getClass();
        int n12 = object3.equals(object2 = object.getClass());
        if (n12 == 0) {
            object3 = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)object3).compareTo((String)object);
        }
        object3 = this.a();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).a()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.a() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.a), (String)(object2 = ((im)object).a))) != 0) {
            return n12;
        }
        object3 = this.b();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).b()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.b() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((Comparable)(object3 = this.a), (Comparable)(object2 = ((im)object).a))) != 0) {
            return n12;
        }
        object3 = this.c();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).c()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.c() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.b), (String)(object2 = ((im)object).b))) != 0) {
            return n12;
        }
        object3 = this.d();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).d()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.d() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.c), (String)(object2 = ((im)object).c))) != 0) {
            return n12;
        }
        object3 = this.e();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).e()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.e() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.d), (String)(object2 = ((im)object).d))) != 0) {
            return n12;
        }
        object3 = this.f();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).f()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.f() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.e), (String)(object2 = ((im)object).e))) != 0) {
            return n12;
        }
        object3 = this.g();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).g()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.g() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.f), (String)(object2 = ((im)object).f))) != 0) {
            return n12;
        }
        object3 = this.h();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).h()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.h() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.g), (String)(object2 = ((im)object).g))) != 0) {
            return n12;
        }
        object3 = this.i();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).i()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.i() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.h), (String)(object2 = ((im)object).h))) != 0) {
            return n12;
        }
        object3 = this.j();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).j()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.j() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.i), (String)(object2 = ((im)object).i))) != 0) {
            return n12;
        }
        object3 = this.k();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).k()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.k() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.j), (String)(object2 = ((im)object).j))) != 0) {
            return n12;
        }
        object3 = this.l();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).l()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.l() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.k), (String)(object2 = ((im)object).k))) != 0) {
            return n12;
        }
        object3 = this.m();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).m()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.m() ? 1 : 0);
        if (n12 != 0) {
            n12 = this.a;
            n11 = ((im)object).a;
            if ((n12 = iy.a(n12, n11)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(object3 = Boolean.valueOf(this.n()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = (int)(((im)object).n() ? 1 : 0)) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.n() ? 1 : 0);
        if (n12 != 0) {
            n12 = this.b;
            n11 = ((im)object).b;
            if ((n12 = iy.a(n12, n11)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(object3 = Boolean.valueOf(this.o()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = (int)(((im)object).o() ? 1 : 0)) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.o() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.l), (String)(object2 = ((im)object).l))) != 0) {
            return n12;
        }
        object3 = this.p();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).p()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.p() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.m), (String)(object2 = ((im)object).m))) != 0) {
            return n12;
        }
        object3 = this.q();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).q()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.q() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.n), (String)(object2 = ((im)object).n))) != 0) {
            return n12;
        }
        object3 = this.r();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).r()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.r() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.o), (String)(object2 = ((im)object).o))) != 0) {
            return n12;
        }
        object3 = this.s();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).s()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.s() ? 1 : 0);
        if (n12 != 0) {
            n12 = this.c;
            n11 = ((im)object).c;
            if ((n12 = iy.a(n12, n11)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(object3 = Boolean.valueOf(this.t()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = (int)(((im)object).t() ? 1 : 0)) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.t() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((Comparable)(object3 = this.a), (Comparable)(object2 = ((im)object).a))) != 0) {
            return n12;
        }
        object3 = this.u();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).u()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.u() ? 1 : 0);
        if (n12 != 0) {
            n12 = (int)(this.a ? 1 : 0);
            n11 = ((im)object).a;
            if ((n12 = iy.a(n12 != 0, n11 != 0)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(object3 = Boolean.valueOf(this.v()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).v()) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.v() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a(l11 = this.a, l10 = ((im)object).a)) != 0) {
            return n12;
        }
        object3 = this.w();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).w()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.w() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a(l11 = this.b, l10 = ((im)object).b)) != 0) {
            return n12;
        }
        object3 = this.x();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).x()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.x() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.p), (String)(object2 = ((im)object).p))) != 0) {
            return n12;
        }
        object3 = this.y();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).y()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.y() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)(object3 = this.q), (String)(object2 = ((im)object).q))) != 0) {
            return n12;
        }
        object3 = this.z();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).z()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.z() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((Map)(object3 = this.a), (Map)(object2 = ((im)object).a))) != 0) {
            return n12;
        }
        object3 = this.A();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).A()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.A() ? 1 : 0);
        if (n12 != 0) {
            n12 = (int)(this.b ? 1 : 0);
            n11 = ((im)object).b;
            if ((n12 = iy.a(n12 != 0, n11 != 0)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(object3 = Boolean.valueOf(this.B()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((im)object).B()) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.B() ? 1 : 0);
        if (n12 != 0 && (n10 = iy.a((String)(object3 = this.r), (String)(object = ((im)object).r))) != 0) {
            return n10;
        }
        return 0;
    }

    public im a(int n10) {
        this.a = n10;
        this.a(true);
        return this;
    }

    public im a(ia ia2) {
        this.a = ia2;
        return this;
    }

    public im a(String string2) {
        this.b = string2;
        return this;
    }

    public String a() {
        return this.b;
    }

    public void a() {
        Object object = this.b;
        if (object != null) {
            object = this.c;
            if (object != null) {
                object = this.f;
                if (object != null) {
                    return;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Required field 'token' was not present! Struct: ");
                String string2 = this.toString();
                charSequence.append(string2);
                charSequence = charSequence.toString();
                object = new jj((String)charSequence);
                throw object;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Required field 'appId' was not present! Struct: ");
            String string3 = this.toString();
            charSequence.append(string3);
            charSequence = charSequence.toString();
            object = new jj((String)charSequence);
            throw object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'id' was not present! Struct: ");
        String string4 = this.toString();
        charSequence.append(string4);
        charSequence = charSequence.toString();
        object = new jj((String)charSequence);
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    public void a(ji var1_1) {
        var1_1.a();
        while (true) {
            var2_2 = var1_1.a();
            var3_3 = var2_2.a;
            if (var3_3 == 0) {
                var1_1.f();
                this.a();
                return;
            }
            var4_4 = var2_2.a;
            var5_5 = 10;
            var6_6 = 2;
            var7_7 = 8;
            var8_8 = true;
            var9_9 = 11;
            block0 : switch (var4_4) {
                default: {
                    switch (var4_4) lbl-1000:
                    // 3 sources

                    {
                        default: lbl-1000:
                        // 27 sources

                        {
                            while (true) {
                                jl.a(var1_1, (byte)var3_3);
                                break block0;
                                break;
                            }
                        }
                        case 102: {
                            if (var3_3 != var9_9) ** GOTO lbl-1000
                            var2_2 = var1_1.a();
                            this.r = var2_2;
                            break block0;
                        }
                        case 101: {
                            if (var3_3 != var6_6) ** GOTO lbl-1000
                            var4_4 = (int)var1_1.a();
                            this.b = var4_4;
                            this.g(var8_8);
                            break block0;
                        }
                        case 100: 
                    }
                    var4_4 = 13;
                    if (var3_3 != var4_4) ** GOTO lbl-1000
                    var2_2 = var1_1.a();
                    var5_5 = var2_2.a * var6_6;
                    this.a = var10_10 = new HashMap<K, V>(var5_5);
                    var10_10 = null;
                    for (var3_3 = 0; var3_3 < (var5_5 = var2_2.a); ++var3_3) {
                        var11_11 = var1_1.a();
                        var12_12 = var1_1.a();
                        var13_13 = this.a;
                        var13_13.put(var11_11, var12_12);
                    }
                    var1_1.h();
                    break;
                }
                case 25: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.q = var2_2 = var1_1.a();
                    break;
                }
                case 24: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.p = var2_2 = var1_1.a();
                    break;
                }
                case 23: {
                    if (var3_3 != var5_5) ** GOTO lbl-1000
                    this.b = var14_14 = var1_1.a();
                    this.f(var8_8);
                    break;
                }
                case 22: {
                    if (var3_3 != var5_5) ** GOTO lbl-1000
                    this.a = var14_14 = var1_1.a();
                    this.e(var8_8);
                    break;
                }
                case 21: {
                    if (var3_3 != var6_6) ** GOTO lbl-1000
                    var4_4 = (int)var1_1.a();
                    this.a = var4_4;
                    this.d(var8_8);
                    break;
                }
                case 20: {
                    if (var3_3 != var7_7) ** GOTO lbl-1000
                    var4_4 = var1_1.a();
                    var2_2 = ia.a(var4_4);
                    this.a = var2_2;
                    break;
                }
                case 19: {
                    if (var3_3 != var7_7) ** GOTO lbl-1000
                    this.c = var4_4 = var1_1.a();
                    this.c(var8_8);
                    break;
                }
                case 18: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.o = var2_2 = var1_1.a();
                    break;
                }
                case 17: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.n = var2_2 = var1_1.a();
                    break;
                }
                case 16: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.m = var2_2 = var1_1.a();
                    break;
                }
                case 15: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.l = var2_2 = var1_1.a();
                    break;
                }
                case 14: {
                    if (var3_3 != var7_7) ** GOTO lbl-1000
                    this.b = var4_4 = var1_1.a();
                    this.b(var8_8);
                    break;
                }
                case 13: {
                    if (var3_3 != var7_7) ** GOTO lbl-1000
                    this.a = var4_4 = var1_1.a();
                    this.a(var8_8);
                    break;
                }
                case 12: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.k = var2_2 = var1_1.a();
                    break;
                }
                case 11: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.j = var2_2 = var1_1.a();
                    break;
                }
                case 10: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.i = var2_2 = var1_1.a();
                    break;
                }
                case 9: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.h = var2_2 = var1_1.a();
                    break;
                }
                case 8: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.g = var2_2 = var1_1.a();
                    break;
                }
                case 7: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.f = var2_2 = var1_1.a();
                    break;
                }
                case 6: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.e = var2_2 = var1_1.a();
                    break;
                }
                case 5: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.d = var2_2 = var1_1.a();
                    break;
                }
                case 4: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.c = var2_2 = var1_1.a();
                    break;
                }
                case 3: {
                    if (var3_3 != var9_9) ** GOTO lbl-1000
                    this.b = var2_2 = var1_1.a();
                    break;
                }
                case 2: {
                    var4_4 = 12;
                    if (var3_3 != var4_4) ** GOTO lbl-1000
                    var2_2 = new ib();
                    this.a = var2_2;
                    var2_2.a(var1_1);
                    break;
                }
                case 1: {
                    if (var3_3 == var9_9) ** break;
                    ** continue;
                    this.a = var2_2 = var1_1.a();
                }
            }
            var1_1.g();
        }
    }

    public void a(boolean bl2) {
        this.a.set(0, bl2);
    }

    public boolean a() {
        boolean bl2;
        String string2 = this.a;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(im object) {
        long l10;
        long l11;
        if (object == null) {
            return false;
        }
        int n10 = this.a();
        int n11 = ((im)object).a();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string2 = this.a;
            String string3 = ((im)object).a;
            n10 = string2.equals(string3);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.b();
        n11 = ((im)object).b();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            ib ib2 = this.a;
            ib ib3 = ((im)object).a;
            n10 = ib2.a(ib3);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.c();
        n11 = ((im)object).c();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string4 = this.b;
            String string5 = ((im)object).b;
            n10 = string4.equals(string5);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.d();
        n11 = ((im)object).d();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string6 = this.c;
            String string7 = ((im)object).c;
            n10 = string6.equals(string7);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.e();
        n11 = ((im)object).e();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string8 = this.d;
            String string9 = ((im)object).d;
            n10 = string8.equals(string9);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.f();
        n11 = ((im)object).f();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string10 = this.e;
            String string11 = ((im)object).e;
            n10 = string10.equals(string11);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.g();
        n11 = ((im)object).g();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string12 = this.f;
            String string13 = ((im)object).f;
            n10 = string12.equals(string13);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.h();
        n11 = ((im)object).h();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string14 = this.g;
            String string15 = ((im)object).g;
            n10 = string14.equals(string15);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.i();
        n11 = ((im)object).i();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string16 = this.h;
            String string17 = ((im)object).h;
            n10 = string16.equals(string17);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.j();
        n11 = ((im)object).j();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string18 = this.i;
            String string19 = ((im)object).i;
            n10 = string18.equals(string19);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.k();
        n11 = ((im)object).k();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string20 = this.j;
            String string21 = ((im)object).j;
            n10 = string20.equals(string21);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.l();
        n11 = ((im)object).l();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string22 = this.k;
            String string23 = ((im)object).k;
            n10 = string22.equals(string23);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.m();
        n11 = ((im)object).m();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.a;
            n11 = ((im)object).a;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = this.n();
        n11 = ((im)object).n();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.b;
            n11 = ((im)object).b;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.o() ? 1 : 0);
        n11 = (int)(((im)object).o() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string24 = this.l;
            String string25 = ((im)object).l;
            n10 = (int)(string24.equals(string25) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.p() ? 1 : 0);
        n11 = (int)(((im)object).p() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string26 = this.m;
            String string27 = ((im)object).m;
            n10 = (int)(string26.equals(string27) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.q() ? 1 : 0);
        n11 = (int)(((im)object).q() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string28 = this.n;
            String string29 = ((im)object).n;
            n10 = (int)(string28.equals(string29) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.r() ? 1 : 0);
        n11 = (int)(((im)object).r() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string30 = this.o;
            String string31 = ((im)object).o;
            n10 = (int)(string30.equals(string31) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.s() ? 1 : 0);
        n11 = (int)(((im)object).s() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.c;
            n11 = ((im)object).c;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.t() ? 1 : 0);
        n11 = (int)(((im)object).t() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            ia ia2 = this.a;
            ia ia3 = ((im)object).a;
            n10 = (int)(ia2.equals((Object)ia3) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.u() ? 1 : 0);
        n11 = (int)(((im)object).u() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = (int)(this.a ? 1 : 0);
            n11 = (int)(((im)object).a ? 1 : 0);
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.v() ? 1 : 0);
        n11 = (int)(((im)object).v() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            l11 = this.a;
            l10 = ((im)object).a;
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) {
                return false;
            }
        }
        n10 = (int)(this.w() ? 1 : 0);
        n11 = (int)(((im)object).w() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            l11 = this.b;
            l10 = ((im)object).b;
            long l13 = l11 - l10;
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 != 0) {
                return false;
            }
        }
        n10 = (int)(this.x() ? 1 : 0);
        n11 = (int)(((im)object).x() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string32 = this.p;
            String string33 = ((im)object).p;
            n10 = (int)(string32.equals(string33) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.y() ? 1 : 0);
        n11 = (int)(((im)object).y() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string34 = this.q;
            String string35 = ((im)object).q;
            n10 = (int)(string34.equals(string35) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.z() ? 1 : 0);
        n11 = (int)(((im)object).z() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            Map map = this.a;
            Map map2 = ((im)object).a;
            n10 = (int)(map.equals(map2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.A() ? 1 : 0);
        n11 = (int)(((im)object).A() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = (int)(this.b ? 1 : 0);
            n11 = (int)(((im)object).b ? 1 : 0);
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.B() ? 1 : 0);
        n11 = (int)(((im)object).B() ? 1 : 0);
        if (n10 == 0 && n11 == 0) return true;
        if (n10 == 0 || n11 == 0) return false;
        String string36 = this.r;
        object = ((im)object).r;
        boolean bl2 = string36.equals(object);
        if (bl2) return true;
        return false;
    }

    public im b(int n10) {
        this.b = n10;
        this.b(true);
        return this;
    }

    public im b(String string2) {
        this.c = string2;
        return this;
    }

    public String b() {
        return this.c;
    }

    public void b(ji ji2) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        boolean bl7;
        long l10;
        boolean bl8;
        boolean bl9;
        boolean bl10;
        boolean bl11;
        boolean bl12;
        boolean bl13;
        boolean bl14;
        boolean bl15;
        boolean bl16;
        boolean bl17;
        boolean bl18;
        boolean bl19;
        boolean bl20;
        boolean bl21;
        boolean bl22;
        boolean bl23;
        boolean bl24;
        boolean bl25;
        boolean bl26;
        this.a();
        Object object = a;
        ji2.a((jn)object);
        object = this.a;
        if (object != null && (bl26 = this.a())) {
            object = a;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.a) != null && (bl25 = this.b())) {
            object = b;
            ji2.a((jf)object);
            object = this.a;
            ((ib)object).b(ji2);
            ji2.b();
        }
        if ((object = this.b) != null) {
            object = c;
            ji2.a((jf)object);
            object = this.b;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.c) != null) {
            object = d;
            ji2.a((jf)object);
            object = this.c;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.d) != null && (bl24 = this.e())) {
            object = e;
            ji2.a((jf)object);
            object = this.d;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.e) != null && (bl23 = this.f())) {
            object = f;
            ji2.a((jf)object);
            object = this.e;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.f) != null) {
            object = g;
            ji2.a((jf)object);
            object = this.f;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.g) != null && (bl22 = this.h())) {
            object = h;
            ji2.a((jf)object);
            object = this.g;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.h) != null && (bl21 = this.i())) {
            object = i;
            ji2.a((jf)object);
            object = this.h;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.i) != null && (bl20 = this.j())) {
            object = j;
            ji2.a((jf)object);
            object = this.i;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.j) != null && (bl19 = this.k())) {
            object = k;
            ji2.a((jf)object);
            object = this.j;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.k) != null && (bl18 = this.l())) {
            object = l;
            ji2.a((jf)object);
            object = this.k;
            ji2.a((String)object);
            ji2.b();
        }
        if (bl17 = this.m()) {
            object = m;
            ji2.a((jf)object);
            int n10 = this.a;
            ji2.a(n10);
            ji2.b();
        }
        if (bl16 = this.n()) {
            object = n;
            ji2.a((jf)object);
            int n11 = this.b;
            ji2.a(n11);
            ji2.b();
        }
        if ((object = this.l) != null && (bl15 = this.o())) {
            object = o;
            ji2.a((jf)object);
            object = this.l;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.m) != null && (bl14 = this.p())) {
            object = p;
            ji2.a((jf)object);
            object = this.m;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.n) != null && (bl13 = this.q())) {
            object = q;
            ji2.a((jf)object);
            object = this.n;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.o) != null && (bl12 = this.r())) {
            object = r;
            ji2.a((jf)object);
            object = this.o;
            ji2.a((String)object);
            ji2.b();
        }
        if (bl11 = this.s()) {
            object = s;
            ji2.a((jf)object);
            int n12 = this.c;
            ji2.a(n12);
            ji2.b();
        }
        if ((object = this.a) != null && (bl10 = this.t())) {
            object = t;
            ji2.a((jf)object);
            object = this.a;
            int n13 = ((ia)((Object)object)).a();
            ji2.a(n13);
            ji2.b();
        }
        if (bl9 = this.u()) {
            object = u;
            ji2.a((jf)object);
            boolean bl27 = this.a;
            ji2.a(bl27);
            ji2.b();
        }
        if (bl8 = this.v()) {
            object = v;
            ji2.a((jf)object);
            l10 = this.a;
            ji2.a(l10);
            ji2.b();
        }
        if (bl7 = this.w()) {
            object = w;
            ji2.a((jf)object);
            l10 = this.b;
            ji2.a(l10);
            ji2.b();
        }
        if ((object = this.p) != null && (bl6 = this.x())) {
            object = x;
            ji2.a((jf)object);
            object = this.p;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.q) != null && (bl5 = this.y())) {
            object = y;
            ji2.a((jf)object);
            object = this.q;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.a) != null && (bl4 = this.z())) {
            object = z;
            ji2.a((jf)object);
            Object object2 = this.a;
            int n14 = object2.size();
            byte by2 = 11;
            object = new jh(by2, by2, n14);
            ji2.a((jh)object);
            object = this.a.entrySet().iterator();
            while ((n14 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (Map.Entry)object.next();
                String string2 = (String)object2.getKey();
                ji2.a(string2);
                object2 = (String)object2.getValue();
                ji2.a((String)object2);
            }
            ji2.d();
            ji2.b();
        }
        if (bl3 = this.A()) {
            object = A;
            ji2.a((jf)object);
            boolean bl28 = this.b;
            ji2.a(bl28);
            ji2.b();
        }
        if ((object = this.r) != null && (bl2 = this.B())) {
            object = B;
            ji2.a((jf)object);
            object = this.r;
            ji2.a((String)object);
            ji2.b();
        }
        ji2.c();
        ji2.a();
    }

    public void b(boolean bl2) {
        this.a.set(1, bl2);
    }

    public boolean b() {
        boolean bl2;
        ib ib2 = this.a;
        if (ib2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            ib2 = null;
        }
        return bl2;
    }

    public im c(int n10) {
        this.c = n10;
        this.c(true);
        return this;
    }

    public im c(String string2) {
        this.d = string2;
        return this;
    }

    public String c() {
        return this.f;
    }

    public void c(boolean bl2) {
        this.a.set(2, bl2);
    }

    public boolean c() {
        boolean bl2;
        String string2 = this.b;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public /* synthetic */ int compareTo(Object object) {
        object = (im)object;
        return this.a((im)object);
    }

    public im d(String string2) {
        this.e = string2;
        return this;
    }

    public void d(boolean bl2) {
        this.a.set(3, bl2);
    }

    public boolean d() {
        boolean bl2;
        String string2 = this.c;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public im e(String string2) {
        this.f = string2;
        return this;
    }

    public void e(boolean bl2) {
        this.a.set(4, bl2);
    }

    public boolean e() {
        boolean bl2;
        String string2 = this.d;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof im;
        if (bl2) {
            object = (im)object;
            return this.a((im)object);
        }
        return false;
    }

    public im f(String string2) {
        this.g = string2;
        return this;
    }

    public void f(boolean bl2) {
        this.a.set(5, bl2);
    }

    public boolean f() {
        boolean bl2;
        String string2 = this.e;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public im g(String string2) {
        this.h = string2;
        return this;
    }

    public void g(boolean bl2) {
        this.a.set(6, bl2);
    }

    public boolean g() {
        boolean bl2;
        String string2 = this.f;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public im h(String string2) {
        this.k = string2;
        return this;
    }

    public boolean h() {
        boolean bl2;
        String string2 = this.g;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public int hashCode() {
        return 0;
    }

    public im i(String string2) {
        this.l = string2;
        return this;
    }

    public boolean i() {
        boolean bl2;
        String string2 = this.h;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public im j(String string2) {
        this.n = string2;
        return this;
    }

    public boolean j() {
        boolean bl2;
        String string2 = this.i;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public im k(String string2) {
        this.o = string2;
        return this;
    }

    public boolean k() {
        boolean bl2;
        String string2 = this.j;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean l() {
        boolean bl2;
        String string2 = this.k;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean m() {
        return this.a.get(0);
    }

    public boolean n() {
        return this.a.get(1);
    }

    public boolean o() {
        boolean bl2;
        String string2 = this.l;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean p() {
        boolean bl2;
        String string2 = this.m;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean q() {
        boolean bl2;
        String string2 = this.n;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean r() {
        boolean bl2;
        String string2 = this.o;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean s() {
        return this.a.get(2);
    }

    public boolean t() {
        boolean bl2;
        ia ia2 = this.a;
        if (ia2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            ia2 = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    public String toString() {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        boolean bl7;
        long l10;
        boolean bl8;
        boolean bl9;
        boolean bl10;
        boolean bl11;
        boolean bl12;
        boolean bl13;
        boolean bl14;
        boolean bl15;
        boolean bl16;
        boolean bl17;
        boolean bl18;
        boolean bl19;
        boolean bl20;
        boolean bl21;
        boolean bl22;
        void var3_6;
        Object object = "XmPushActionRegistration(";
        StringBuilder stringBuilder = new StringBuilder((String)object);
        boolean bl23 = this.a();
        boolean bl24 = false;
        String string2 = "null";
        if (bl23) {
            stringBuilder.append("debug:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
            boolean bl25 = false;
            object = null;
        } else {
            boolean bl26 = true;
        }
        boolean bl27 = this.b();
        String string3 = ", ";
        if (bl27) {
            if (var3_6 == false) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("target:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        } else {
            bl24 = var3_6;
        }
        if (!bl24) {
            stringBuilder.append(string3);
        }
        stringBuilder.append("id:");
        object = this.b;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        stringBuilder.append(string3);
        stringBuilder.append("appId:");
        object = this.c;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        boolean bl28 = this.e();
        if (bl28) {
            stringBuilder.append(string3);
            stringBuilder.append("appVersion:");
            object = this.d;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl22 = this.f()) {
            stringBuilder.append(string3);
            stringBuilder.append("packageName:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        stringBuilder.append(string3);
        stringBuilder.append("token:");
        object = this.f;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        boolean bl29 = this.h();
        if (bl29) {
            stringBuilder.append(string3);
            stringBuilder.append("deviceId:");
            object = this.g;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl21 = this.i()) {
            stringBuilder.append(string3);
            stringBuilder.append("aliasName:");
            object = this.h;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl20 = this.j()) {
            stringBuilder.append(string3);
            stringBuilder.append("sdkVersion:");
            object = this.i;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl19 = this.k()) {
            stringBuilder.append(string3);
            stringBuilder.append("regId:");
            object = this.j;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl18 = this.l()) {
            stringBuilder.append(string3);
            stringBuilder.append("pushSdkVersionName:");
            object = this.k;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl17 = this.m()) {
            stringBuilder.append(string3);
            object = "pushSdkVersionCode:";
            stringBuilder.append((String)object);
            int n10 = this.a;
            stringBuilder.append(n10);
        }
        if (bl16 = this.n()) {
            stringBuilder.append(string3);
            object = "appVersionCode:";
            stringBuilder.append((String)object);
            int n11 = this.b;
            stringBuilder.append(n11);
        }
        if (bl15 = this.o()) {
            stringBuilder.append(string3);
            stringBuilder.append("androidId:");
            object = this.l;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl14 = this.p()) {
            stringBuilder.append(string3);
            stringBuilder.append("imei:");
            object = this.m;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl13 = this.q()) {
            stringBuilder.append(string3);
            stringBuilder.append("serial:");
            object = this.n;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl12 = this.r()) {
            stringBuilder.append(string3);
            stringBuilder.append("imeiMd5:");
            object = this.o;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl11 = this.s()) {
            stringBuilder.append(string3);
            object = "spaceId:";
            stringBuilder.append((String)object);
            int n12 = this.c;
            stringBuilder.append(n12);
        }
        if (bl10 = this.t()) {
            stringBuilder.append(string3);
            stringBuilder.append("reason:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        }
        if (bl9 = this.u()) {
            stringBuilder.append(string3);
            object = "validateToken:";
            stringBuilder.append((String)object);
            boolean bl30 = this.a;
            stringBuilder.append(bl30);
        }
        if (bl8 = this.v()) {
            stringBuilder.append(string3);
            object = "miid:";
            stringBuilder.append((String)object);
            l10 = this.a;
            stringBuilder.append(l10);
        }
        if (bl7 = this.w()) {
            stringBuilder.append(string3);
            object = "createdTs:";
            stringBuilder.append((String)object);
            l10 = this.b;
            stringBuilder.append(l10);
        }
        if (bl6 = this.x()) {
            stringBuilder.append(string3);
            stringBuilder.append("subImei:");
            object = this.p;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl5 = this.y()) {
            stringBuilder.append(string3);
            stringBuilder.append("subImeiMd5:");
            object = this.q;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl4 = this.z()) {
            stringBuilder.append(string3);
            stringBuilder.append("connectionAttrs:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        }
        if (bl3 = this.A()) {
            stringBuilder.append(string3);
            object = "cleanOldRegInfo:";
            stringBuilder.append((String)object);
            boolean bl31 = this.b;
            stringBuilder.append(bl31);
        }
        if (bl2 = this.B()) {
            stringBuilder.append(string3);
            stringBuilder.append("oldRegId:");
            object = this.r;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public boolean u() {
        return this.a.get(3);
    }

    public boolean v() {
        return this.a.get(4);
    }

    public boolean w() {
        return this.a.get(5);
    }

    public boolean x() {
        boolean bl2;
        String string2 = this.p;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean y() {
        boolean bl2;
        String string2 = this.q;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean z() {
        boolean bl2;
        Map map = this.a;
        if (map != null) {
            bl2 = true;
        } else {
            bl2 = false;
            map = null;
        }
        return bl2;
    }
}

