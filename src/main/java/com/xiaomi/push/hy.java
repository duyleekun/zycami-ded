/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.hz;
import com.xiaomi.push.ib;
import com.xiaomi.push.ix;
import com.xiaomi.push.iy;
import com.xiaomi.push.jf;
import com.xiaomi.push.ji;
import com.xiaomi.push.jj;
import com.xiaomi.push.jl;
import com.xiaomi.push.jn;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.BitSet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class hy
implements ix,
Serializable,
Cloneable {
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
    public long a;
    public hz a;
    public ib a;
    public String a;
    private BitSet a;
    public boolean a;
    public long b;
    public String b;
    public long c;
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

    static {
        Object object = new jn("PushMessage");
        a = object;
        String string2 = "";
        byte by2 = 12;
        a = object = new jf(string2, by2, 1);
        byte by3 = 11;
        byte by4 = 2;
        b = object = new jf(string2, by3, by4);
        c = object = new jf(string2, by3, 3);
        d = object = new jf(string2, by3, 4);
        byte by5 = 10;
        e = object = new jf(string2, by5, 5);
        f = object = new jf(string2, by5, 6);
        g = object = new jf(string2, by3, 7);
        h = object = new jf(string2, by3, 8);
        i = object = new jf(string2, by3, 9);
        j = object = new jf(string2, by3, by5);
        k = object = new jf(string2, by3, by3);
        l = object = new jf(string2, by2, by2);
        m = object = new jf(string2, by3, 13);
        n = object = new jf(string2, by4, 14);
        o = object = new jf(string2, by3, 15);
        p = object = new jf(string2, by5, 16);
        q = object = new jf(string2, by3, 20);
        r = object = new jf(string2, by3, 21);
    }

    public hy() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(4);
        this.a = false;
    }

    public int a(hy object) {
        int n10;
        long l10;
        long l11;
        boolean bl2;
        Object object2;
        Constable constable = this.getClass();
        int n11 = constable.equals(object2 = object.getClass());
        if (n11 == 0) {
            constable = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)((Object)constable)).compareTo((String)object);
        }
        constable = this.a();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)((Object)(constable = this.a)), object2 = ((hy)object).a)) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((hy)object).a))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((hy)object).b))) != 0) {
            return n11;
        }
        constable = this.d();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).d())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((hy)object).c))) != 0) {
            return n11;
        }
        constable = this.e();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).e())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.a, l10 = ((hy)object).a)) != 0) {
            return n11;
        }
        constable = this.f();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).f())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.b, l10 = ((hy)object).b)) != 0) {
            return n11;
        }
        constable = this.g();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).g())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.g() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((hy)object).d))) != 0) {
            return n11;
        }
        constable = this.h();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).h())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((hy)object).e))) != 0) {
            return n11;
        }
        constable = this.i();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).i())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.i() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.f)), (String)(object2 = ((hy)object).f))) != 0) {
            return n11;
        }
        constable = this.j();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).j())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.j() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.g)), (String)(object2 = ((hy)object).g))) != 0) {
            return n11;
        }
        constable = this.k();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).k())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.k() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.h)), (String)(object2 = ((hy)object).h))) != 0) {
            return n11;
        }
        constable = this.l();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).l())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.l() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((hy)object).a))) != 0) {
            return n11;
        }
        constable = this.m();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).m())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.m() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.i)), (String)(object2 = ((hy)object).i))) != 0) {
            return n11;
        }
        constable = this.n();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).n())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.n() ? 1 : 0);
        if (n11 != 0) {
            n11 = (int)(this.a ? 1 : 0);
            bl2 = ((hy)object).a;
            if ((n11 = iy.a(n11 != 0, bl2)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable = Boolean.valueOf(this.o()))).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).o())))) != 0) {
            return n11;
        }
        n11 = (int)(this.o() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.j)), (String)(object2 = ((hy)object).j))) != 0) {
            return n11;
        }
        constable = this.p();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).p())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.p() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.c, l10 = ((hy)object).c)) != 0) {
            return n11;
        }
        constable = this.q();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).q())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.q() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.k)), (String)(object2 = ((hy)object).k))) != 0) {
            return n11;
        }
        constable = this.r();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hy)object).r())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.r() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((String)((Object)(constable = this.l)), (String)(object = ((hy)object).l))) != 0) {
            return n10;
        }
        return 0;
    }

    public long a() {
        return this.a;
    }

    public String a() {
        return this.a;
    }

    public void a() {
        Object object = this.a;
        if (object != null) {
            object = this.b;
            if (object != null) {
                object = this.c;
                if (object != null) {
                    return;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Required field 'payload' was not present! Struct: ");
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
            block24: {
                block22: {
                    block23: {
                        var2_2 = var1_1.a();
                        var3_3 = var2_2.a;
                        if (var3_3 == 0) {
                            var1_1.f();
                            this.a();
                            return;
                        }
                        var4_4 = var2_2.a;
                        var5_5 = 20;
                        var6_6 = 11;
                        if (var4_4 == var5_5) break block22;
                        var5_5 = 21;
                        if (var4_4 == var5_5) break block23;
                        var5_5 = 12;
                        var7_7 = 10;
                        var8_8 = true;
                        block0 : switch (var4_4) lbl-1000:
                        // 17 sources

                        {
                            default: lbl-1000:
                            // 3 sources

                            {
                                while (true) {
                                    jl.a(var1_1, var3_3);
                                    break block0;
                                    break;
                                }
                            }
                            case 16: {
                                if (var3_3 != var7_7) ** GOTO lbl-1000
                                this.c = var9_9 = var1_1.a();
                                this.d(var8_8);
                                break;
                            }
                            case 15: {
                                if (var3_3 != var6_6) ** GOTO lbl-1000
                                this.j = var2_2 = var1_1.a();
                                break;
                            }
                            case 14: {
                                var4_4 = 2;
                                if (var3_3 != var4_4) ** GOTO lbl-1000
                                var4_4 = (byte)var1_1.a();
                                this.a = var4_4;
                                this.c(var8_8);
                                break;
                            }
                            case 13: {
                                if (var3_3 != var6_6) ** GOTO lbl-1000
                                this.i = var2_2 = var1_1.a();
                                break;
                            }
                            case 12: {
                                if (var3_3 != var5_5) ** GOTO lbl-1000
                                this.a = var2_2 = new hz();
                                var2_2.a(var1_1);
                                break;
                            }
                            case 11: {
                                if (var3_3 != var6_6) ** GOTO lbl-1000
                                this.h = var2_2 = var1_1.a();
                                break;
                            }
                            case 10: {
                                if (var3_3 != var6_6) ** GOTO lbl-1000
                                this.g = var2_2 = var1_1.a();
                                break;
                            }
                            case 9: {
                                if (var3_3 != var6_6) ** GOTO lbl-1000
                                this.f = var2_2 = var1_1.a();
                                break;
                            }
                            case 8: {
                                if (var3_3 != var6_6) ** GOTO lbl-1000
                                this.e = var2_2 = var1_1.a();
                                break;
                            }
                            case 7: {
                                if (var3_3 != var6_6) ** GOTO lbl-1000
                                this.d = var2_2 = var1_1.a();
                                break;
                            }
                            case 6: {
                                if (var3_3 != var7_7) ** GOTO lbl-1000
                                this.b = var9_9 = var1_1.a();
                                this.b(var8_8);
                                break;
                            }
                            case 5: {
                                if (var3_3 != var7_7) ** GOTO lbl-1000
                                this.a = var9_9 = var1_1.a();
                                this.a(var8_8);
                                break;
                            }
                            case 4: {
                                if (var3_3 != var6_6) ** GOTO lbl-1000
                                this.c = var2_2 = var1_1.a();
                                break;
                            }
                            case 3: {
                                if (var3_3 != var6_6) ** GOTO lbl-1000
                                this.b = var2_2 = var1_1.a();
                                break;
                            }
                            case 2: {
                                if (var3_3 != var6_6) ** GOTO lbl-1000
                                this.a = var2_2 = var1_1.a();
                                break;
                            }
                            case 1: {
                                if (var3_3 != var5_5) ** GOTO lbl-1000
                                this.a = var2_2 = new ib();
                                var2_2.a(var1_1);
                                break;
                            }
                        }
                        break block24;
                    }
                    if (var3_3 != var6_6) ** GOTO lbl-1000
                    this.l = var2_2 = var1_1.a();
                    break block24;
                }
                if (var3_3 != var6_6) ** continue;
                this.k = var2_2 = var1_1.a();
            }
            var1_1.g();
        }
    }

    public void a(boolean bl2) {
        this.a.set(0, bl2);
    }

    public boolean a() {
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(hy object) {
        long l10;
        long l11;
        Object object2;
        Object object3;
        if (object == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = ((hy)object).a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.a;
            object2 = ((hy)object).a;
            boolean bl4 = ((ib)object3).a((ib)object2);
            if (!bl4) {
                return false;
            }
        }
        boolean bl5 = this.b();
        bl3 = ((hy)object).b();
        if (bl5 || bl3) {
            if (!bl5 || !bl3) return false;
            object3 = this.a;
            object2 = ((hy)object).a;
            boolean bl6 = ((String)object3).equals(object2);
            if (!bl6) {
                return false;
            }
        }
        boolean bl7 = this.c();
        bl3 = ((hy)object).c();
        if (bl7 || bl3) {
            if (!bl7 || !bl3) return false;
            object3 = this.b;
            object2 = ((hy)object).b;
            boolean bl8 = ((String)object3).equals(object2);
            if (!bl8) {
                return false;
            }
        }
        boolean bl9 = this.d();
        bl3 = ((hy)object).d();
        if (bl9 || bl3) {
            if (!bl9 || !bl3) return false;
            object3 = this.c;
            object2 = ((hy)object).c;
            boolean bl10 = ((String)object3).equals(object2);
            if (!bl10) {
                return false;
            }
        }
        boolean bl11 = this.e();
        bl3 = ((hy)object).e();
        if (bl11 || bl3) {
            if (!bl11 || !bl3) return false;
            l11 = this.a;
            l10 = ((hy)object).a;
            long l12 = l11 - l10;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false) {
                return false;
            }
        }
        boolean bl12 = this.f();
        bl3 = ((hy)object).f();
        if (bl12 || bl3) {
            if (!bl12 || !bl3) return false;
            l11 = this.b;
            l10 = ((hy)object).b;
            long l13 = l11 - l10;
            Object object5 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object5 != false) {
                return false;
            }
        }
        boolean bl13 = this.g();
        bl3 = ((hy)object).g();
        if (bl13 || bl3) {
            if (!bl13 || !bl3) return false;
            object3 = this.d;
            object2 = ((hy)object).d;
            boolean bl14 = ((String)object3).equals(object2);
            if (!bl14) {
                return false;
            }
        }
        boolean bl15 = this.h();
        bl3 = ((hy)object).h();
        if (bl15 || bl3) {
            if (!bl15 || !bl3) return false;
            object3 = this.e;
            object2 = ((hy)object).e;
            boolean bl16 = ((String)object3).equals(object2);
            if (!bl16) {
                return false;
            }
        }
        boolean bl17 = this.i();
        bl3 = ((hy)object).i();
        if (bl17 || bl3) {
            if (!bl17 || !bl3) return false;
            object3 = this.f;
            object2 = ((hy)object).f;
            boolean bl18 = ((String)object3).equals(object2);
            if (!bl18) {
                return false;
            }
        }
        boolean bl19 = this.j();
        bl3 = ((hy)object).j();
        if (bl19 || bl3) {
            if (!bl19 || !bl3) return false;
            object3 = this.g;
            object2 = ((hy)object).g;
            boolean bl20 = ((String)object3).equals(object2);
            if (!bl20) {
                return false;
            }
        }
        boolean bl21 = this.k();
        bl3 = ((hy)object).k();
        if (bl21 || bl3) {
            if (!bl21 || !bl3) return false;
            object3 = this.h;
            object2 = ((hy)object).h;
            boolean bl22 = ((String)object3).equals(object2);
            if (!bl22) {
                return false;
            }
        }
        boolean bl23 = this.l();
        bl3 = ((hy)object).l();
        if (bl23 || bl3) {
            if (!bl23 || !bl3) return false;
            object3 = this.a;
            object2 = ((hy)object).a;
            boolean bl24 = ((hz)object3).a((hz)object2);
            if (!bl24) {
                return false;
            }
        }
        boolean bl25 = this.m();
        bl3 = ((hy)object).m();
        if (bl25 || bl3) {
            if (!bl25 || !bl3) return false;
            object3 = this.i;
            object2 = ((hy)object).i;
            boolean bl26 = ((String)object3).equals(object2);
            if (!bl26) {
                return false;
            }
        }
        boolean bl27 = this.n();
        bl3 = ((hy)object).n();
        if (bl27 || bl3) {
            if (!bl27 || !bl3) return false;
            boolean bl28 = this.a;
            bl3 = ((hy)object).a;
            if (bl28 != bl3) {
                return false;
            }
        }
        boolean bl29 = this.o();
        bl3 = ((hy)object).o();
        if (bl29 || bl3) {
            if (!bl29 || !bl3) return false;
            object3 = this.j;
            object2 = ((hy)object).j;
            boolean bl30 = ((String)object3).equals(object2);
            if (!bl30) {
                return false;
            }
        }
        boolean bl31 = this.p();
        bl3 = ((hy)object).p();
        if (bl31 || bl3) {
            if (!bl31 || !bl3) return false;
            l11 = this.c;
            l10 = ((hy)object).c;
            long l14 = l11 - l10;
            Object object6 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object6 != false) {
                return false;
            }
        }
        boolean bl32 = this.q();
        bl3 = ((hy)object).q();
        if (bl32 || bl3) {
            if (!bl32 || !bl3) return false;
            object3 = this.k;
            object2 = ((hy)object).k;
            boolean bl33 = ((String)object3).equals(object2);
            if (!bl33) {
                return false;
            }
        }
        boolean bl34 = this.r();
        bl3 = ((hy)object).r();
        if (!bl34 && !bl3) return true;
        if (!bl34 || !bl3) return false;
        object3 = this.l;
        object = ((hy)object).l;
        boolean bl35 = ((String)object3).equals(object);
        if (bl35) return true;
        return false;
    }

    public String b() {
        return this.b;
    }

    public void b(ji ji2) {
        long l10;
        boolean bl2;
        this.a();
        Object object = a;
        ji2.a((jn)object);
        object = this.a;
        if (object != null && (bl2 = this.a())) {
            object = a;
            ji2.a((jf)object);
            object = this.a;
            ((ib)object).b(ji2);
            ji2.b();
        }
        if ((object = this.a) != null) {
            object = b;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((String)object);
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
        if (bl2 = this.e()) {
            object = e;
            ji2.a((jf)object);
            l10 = this.a;
            ji2.a(l10);
            ji2.b();
        }
        if (bl2 = this.f()) {
            object = f;
            ji2.a((jf)object);
            l10 = this.b;
            ji2.a(l10);
            ji2.b();
        }
        if ((object = this.d) != null && (bl2 = this.g())) {
            object = g;
            ji2.a((jf)object);
            object = this.d;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.e) != null && (bl2 = this.h())) {
            object = h;
            ji2.a((jf)object);
            object = this.e;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.f) != null && (bl2 = this.i())) {
            object = i;
            ji2.a((jf)object);
            object = this.f;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.g) != null && (bl2 = this.j())) {
            object = j;
            ji2.a((jf)object);
            object = this.g;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.h) != null && (bl2 = this.k())) {
            object = k;
            ji2.a((jf)object);
            object = this.h;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.a) != null && (bl2 = this.l())) {
            object = l;
            ji2.a((jf)object);
            object = this.a;
            ((hz)object).b(ji2);
            ji2.b();
        }
        if ((object = this.i) != null && (bl2 = this.m())) {
            object = m;
            ji2.a((jf)object);
            object = this.i;
            ji2.a((String)object);
            ji2.b();
        }
        if (bl2 = this.n()) {
            object = n;
            ji2.a((jf)object);
            bl2 = this.a;
            ji2.a(bl2);
            ji2.b();
        }
        if ((object = this.j) != null && (bl2 = this.o())) {
            object = o;
            ji2.a((jf)object);
            object = this.j;
            ji2.a((String)object);
            ji2.b();
        }
        if (bl2 = this.p()) {
            object = p;
            ji2.a((jf)object);
            l10 = this.c;
            ji2.a(l10);
            ji2.b();
        }
        if ((object = this.k) != null && (bl2 = this.q())) {
            object = q;
            ji2.a((jf)object);
            object = this.k;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.l) != null && (bl2 = this.r())) {
            object = r;
            ji2.a((jf)object);
            object = this.l;
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
        String string2 = this.a;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public String c() {
        return this.c;
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
        object = (hy)object;
        return this.a((hy)object);
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

    public boolean e() {
        return this.a.get(0);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof hy;
        if (bl2) {
            object = (hy)object;
            return this.a((hy)object);
        }
        return false;
    }

    public boolean f() {
        return this.a.get(1);
    }

    public boolean g() {
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

    public boolean h() {
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

    public int hashCode() {
        return 0;
    }

    public boolean i() {
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

    public boolean j() {
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

    public boolean k() {
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

    public boolean l() {
        boolean bl2;
        hz hz2 = this.a;
        if (hz2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            hz2 = null;
        }
        return bl2;
    }

    public boolean m() {
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

    public boolean n() {
        return this.a.get(2);
    }

    public boolean o() {
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

    public boolean p() {
        return this.a.get(3);
    }

    public boolean q() {
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

    public boolean r() {
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

    public String toString() {
        long l10;
        Object object = "PushMessage(";
        StringBuilder stringBuilder = new StringBuilder((String)object);
        boolean bl2 = this.a();
        String string2 = "null";
        if (bl2) {
            stringBuilder.append("to:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        String string3 = ", ";
        if (!bl2) {
            stringBuilder.append(string3);
        }
        stringBuilder.append("id:");
        object = this.a;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        stringBuilder.append(string3);
        stringBuilder.append("appId:");
        object = this.b;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        stringBuilder.append(string3);
        stringBuilder.append("payload:");
        object = this.c;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        bl2 = this.e();
        if (bl2) {
            stringBuilder.append(string3);
            object = "createAt:";
            stringBuilder.append((String)object);
            l10 = this.a;
            stringBuilder.append(l10);
        }
        if (bl2 = this.f()) {
            stringBuilder.append(string3);
            object = "ttl:";
            stringBuilder.append((String)object);
            l10 = this.b;
            stringBuilder.append(l10);
        }
        if (bl2 = this.g()) {
            stringBuilder.append(string3);
            stringBuilder.append("collapseKey:");
            object = this.d;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.h()) {
            stringBuilder.append(string3);
            stringBuilder.append("packageName:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.i()) {
            stringBuilder.append(string3);
            stringBuilder.append("regId:");
            object = this.f;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.j()) {
            stringBuilder.append(string3);
            stringBuilder.append("category:");
            object = this.g;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.k()) {
            stringBuilder.append(string3);
            stringBuilder.append("topic:");
            object = this.h;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.l()) {
            stringBuilder.append(string3);
            stringBuilder.append("metaInfo:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        }
        if (bl2 = this.m()) {
            stringBuilder.append(string3);
            stringBuilder.append("aliasName:");
            object = this.i;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.n()) {
            stringBuilder.append(string3);
            object = "isOnline:";
            stringBuilder.append((String)object);
            bl2 = this.a;
            stringBuilder.append(bl2);
        }
        if (bl2 = this.o()) {
            stringBuilder.append(string3);
            stringBuilder.append("userAccount:");
            object = this.j;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.p()) {
            stringBuilder.append(string3);
            object = "miid:";
            stringBuilder.append((String)object);
            l10 = this.c;
            stringBuilder.append(l10);
        }
        if (bl2 = this.q()) {
            stringBuilder.append(string3);
            stringBuilder.append("imeiMd5:");
            object = this.k;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.r()) {
            stringBuilder.append(string3);
            stringBuilder.append("deviceId:");
            object = this.l;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

