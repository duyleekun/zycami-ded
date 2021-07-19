/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

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
public class ir
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
    public long a;
    public ib a;
    public String a;
    private BitSet a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    static {
        Object object = new jn("XmPushActionSubscriptionResult");
        a = object;
        String string2 = "";
        byte by2 = 11;
        a = object = new jf(string2, by2, 1);
        b = object = new jf(string2, 12, 2);
        c = object = new jf(string2, by2, 3);
        d = object = new jf(string2, by2, 4);
        byte by3 = 10;
        e = object = new jf(string2, by3, 6);
        f = object = new jf(string2, by2, 7);
        g = object = new jf(string2, by2, 8);
        h = object = new jf(string2, by2, 9);
        i = object = new jf(string2, by2, by3);
    }

    public ir() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(1);
    }

    public int a(ir object) {
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
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ir)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((ir)object).a))) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ir)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((ir)object).a))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ir)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((ir)object).b))) != 0) {
            return n11;
        }
        constable = this.d();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ir)object).d())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((ir)object).c))) != 0) {
            return n11;
        }
        constable = this.e();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ir)object).e())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.a, l10 = ((ir)object).a)) != 0) {
            return n11;
        }
        constable = this.f();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ir)object).f())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((ir)object).d))) != 0) {
            return n11;
        }
        constable = this.g();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ir)object).g())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.g() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((ir)object).e))) != 0) {
            return n11;
        }
        constable = this.h();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ir)object).h())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.f)), (String)(object2 = ((ir)object).f))) != 0) {
            return n11;
        }
        constable = this.i();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ir)object).i())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.i() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((String)((Object)(constable = this.g)), (String)(object = ((ir)object).g))) != 0) {
            return n10;
        }
        return 0;
    }

    public String a() {
        return this.e;
    }

    public void a() {
        Object object = this.b;
        if (object != null) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'id' was not present! Struct: ");
        String string2 = this.toString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        object = new jj((String)charSequence);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(ji ji2) {
        ji2.a();
        while (true) {
            block13: {
                Object object = ji2.a();
                byte by2 = ((jf)object).a;
                if (!by2) {
                    ji2.f();
                    this.a();
                    return;
                }
                byte by3 = ((jf)object).a;
                byte by4 = 11;
                switch (by3) {
                    case 10: {
                        if (by2 != by4) break;
                        this.g = object = ji2.a();
                        break block13;
                    }
                    case 9: {
                        if (by2 != by4) break;
                        this.f = object = ji2.a();
                        break block13;
                    }
                    case 8: {
                        if (by2 != by4) break;
                        this.e = object = ji2.a();
                        break block13;
                    }
                    case 7: {
                        if (by2 != by4) break;
                        this.d = object = ji2.a();
                        break block13;
                    }
                    case 6: {
                        long l10;
                        by3 = 10;
                        if (by2 != by3) break;
                        this.a = l10 = ji2.a();
                        by3 = 1;
                        this.a(by3 != 0);
                        break block13;
                    }
                    case 4: {
                        if (by2 != by4) break;
                        this.c = object = ji2.a();
                        break block13;
                    }
                    case 3: {
                        if (by2 != by4) break;
                        this.b = object = ji2.a();
                        break block13;
                    }
                    case 2: {
                        by3 = 12;
                        if (by2 != by3) break;
                        this.a = object = new ib();
                        ((ib)object).a(ji2);
                        break block13;
                    }
                    case 1: {
                        if (by2 != by4) break;
                        this.a = object = ji2.a();
                        break block13;
                    }
                }
                jl.a(ji2, by2);
            }
            ji2.g();
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
    public boolean a(ir object) {
        Object object2;
        Object object3;
        if (object == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = ((ir)object).a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.a;
            object2 = ((ir)object).a;
            boolean bl4 = ((String)object3).equals(object2);
            if (!bl4) {
                return false;
            }
        }
        boolean bl5 = this.b();
        bl3 = ((ir)object).b();
        if (bl5 || bl3) {
            if (!bl5 || !bl3) return false;
            object3 = this.a;
            object2 = ((ir)object).a;
            boolean bl6 = ((ib)object3).a((ib)object2);
            if (!bl6) {
                return false;
            }
        }
        boolean bl7 = this.c();
        bl3 = ((ir)object).c();
        if (bl7 || bl3) {
            if (!bl7 || !bl3) return false;
            object3 = this.b;
            object2 = ((ir)object).b;
            boolean bl8 = ((String)object3).equals(object2);
            if (!bl8) {
                return false;
            }
        }
        boolean bl9 = this.d();
        bl3 = ((ir)object).d();
        if (bl9 || bl3) {
            if (!bl9 || !bl3) return false;
            object3 = this.c;
            object2 = ((ir)object).c;
            boolean bl10 = ((String)object3).equals(object2);
            if (!bl10) {
                return false;
            }
        }
        boolean bl11 = this.e();
        bl3 = ((ir)object).e();
        if (bl11 || bl3) {
            if (!bl11 || !bl3) return false;
            long l10 = this.a;
            long l11 = ((ir)object).a;
            long l12 = l10 - l11;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false) {
                return false;
            }
        }
        boolean bl12 = this.f();
        bl3 = ((ir)object).f();
        if (bl12 || bl3) {
            if (!bl12 || !bl3) return false;
            object3 = this.d;
            object2 = ((ir)object).d;
            boolean bl13 = ((String)object3).equals(object2);
            if (!bl13) {
                return false;
            }
        }
        boolean bl14 = this.g();
        bl3 = ((ir)object).g();
        if (bl14 || bl3) {
            if (!bl14 || !bl3) return false;
            object3 = this.e;
            object2 = ((ir)object).e;
            boolean bl15 = ((String)object3).equals(object2);
            if (!bl15) {
                return false;
            }
        }
        boolean bl16 = this.h();
        bl3 = ((ir)object).h();
        if (bl16 || bl3) {
            if (!bl16 || !bl3) return false;
            object3 = this.f;
            object2 = ((ir)object).f;
            boolean bl17 = ((String)object3).equals(object2);
            if (!bl17) {
                return false;
            }
        }
        boolean bl18 = this.i();
        bl3 = ((ir)object).i();
        if (!bl18 && !bl3) return true;
        if (!bl18 || !bl3) return false;
        object3 = this.g;
        object = ((ir)object).g;
        boolean bl19 = ((String)object3).equals(object);
        if (bl19) return true;
        return false;
    }

    public String b() {
        return this.g;
    }

    public void b(ji ji2) {
        boolean bl2;
        this.a();
        Object object = a;
        ji2.a((jn)object);
        object = this.a;
        if (object != null && (bl2 = this.a())) {
            object = a;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.a) != null && (bl2 = this.b())) {
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
        if ((object = this.c) != null && (bl2 = this.d())) {
            object = d;
            ji2.a((jf)object);
            object = this.c;
            ji2.a((String)object);
            ji2.b();
        }
        if (bl2 = this.e()) {
            object = e;
            ji2.a((jf)object);
            long l10 = this.a;
            ji2.a(l10);
            ji2.b();
        }
        if ((object = this.d) != null && (bl2 = this.f())) {
            object = f;
            ji2.a((jf)object);
            object = this.d;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.e) != null && (bl2 = this.g())) {
            object = g;
            ji2.a((jf)object);
            object = this.e;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.f) != null && (bl2 = this.h())) {
            object = h;
            ji2.a((jf)object);
            object = this.f;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.g) != null && (bl2 = this.i())) {
            object = i;
            ji2.a((jf)object);
            object = this.g;
            ji2.a((String)object);
            ji2.b();
        }
        ji2.c();
        ji2.a();
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
        object = (ir)object;
        return this.a((ir)object);
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
        boolean bl2 = object instanceof ir;
        if (bl2) {
            object = (ir)object;
            return this.a((ir)object);
        }
        return false;
    }

    public boolean f() {
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

    public boolean g() {
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

    public boolean h() {
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

    public int hashCode() {
        return 0;
    }

    public boolean i() {
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

    public String toString() {
        Object object = "XmPushActionSubscriptionResult(";
        StringBuilder stringBuilder = new StringBuilder((String)object);
        boolean bl2 = this.a();
        boolean bl3 = false;
        String string2 = "null";
        if (bl2) {
            stringBuilder.append("debug:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        boolean bl4 = this.b();
        String string3 = ", ";
        if (bl4) {
            if (!bl2) {
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
            bl3 = bl2;
        }
        if (!bl3) {
            stringBuilder.append(string3);
        }
        stringBuilder.append("id:");
        object = this.b;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        bl2 = this.d();
        if (bl2) {
            stringBuilder.append(string3);
            stringBuilder.append("appId:");
            object = this.c;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.e()) {
            stringBuilder.append(string3);
            object = "errorCode:";
            stringBuilder.append((String)object);
            long l10 = this.a;
            stringBuilder.append(l10);
        }
        if (bl2 = this.f()) {
            stringBuilder.append(string3);
            stringBuilder.append("reason:");
            object = this.d;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.g()) {
            stringBuilder.append(string3);
            stringBuilder.append("topic:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.h()) {
            stringBuilder.append(string3);
            stringBuilder.append("packageName:");
            object = this.f;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.i()) {
            stringBuilder.append(string3);
            stringBuilder.append("category:");
            object = this.g;
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

