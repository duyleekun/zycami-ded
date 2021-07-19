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
public class is
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
    public long a;
    public ib a;
    public String a;
    private BitSet a;
    public boolean a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    static {
        Object object = new jn("XmPushActionUnRegistration");
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
        h = object = new jf(string2, by2, 8);
        i = object = new jf(string2, by2, 9);
        byte by5 = 10;
        j = object = new jf(string2, by2, by5);
        k = object = new jf(string2, by4, by2);
        l = object = new jf(string2, by5, by3);
    }

    public is() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(2);
        this.a = true;
    }

    public int a(is object) {
        long l10;
        long l11;
        int n10;
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
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((is)object).a))) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((is)object).a))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((is)object).b))) != 0) {
            return n11;
        }
        constable = this.d();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).d())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((is)object).c))) != 0) {
            return n11;
        }
        constable = this.e();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).e())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((is)object).d))) != 0) {
            return n11;
        }
        constable = this.f();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).f())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((is)object).e))) != 0) {
            return n11;
        }
        constable = this.g();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).g())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.g() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.f)), (String)(object2 = ((is)object).f))) != 0) {
            return n11;
        }
        constable = this.h();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).h())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.g)), (String)(object2 = ((is)object).g))) != 0) {
            return n11;
        }
        constable = this.i();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).i())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.i() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.h)), (String)(object2 = ((is)object).h))) != 0) {
            return n11;
        }
        constable = this.j();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).j())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.j() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.i)), (String)(object2 = ((is)object).i))) != 0) {
            return n11;
        }
        constable = this.k();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).k())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.k() ? 1 : 0);
        if (n11 != 0) {
            n11 = (int)(this.a ? 1 : 0);
            bl2 = ((is)object).a;
            if ((n11 = iy.a(n11 != 0, bl2)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable = Boolean.valueOf(this.l()))).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((is)object).l())))) != 0) {
            return n11;
        }
        n11 = (int)(this.l() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a(l11 = this.a, l10 = ((is)object).a)) != 0) {
            return n10;
        }
        return 0;
    }

    public is a(String string2) {
        this.b = string2;
        return this;
    }

    public void a() {
        Object object = this.b;
        if (object != null) {
            object = this.c;
            if (object != null) {
                return;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Required field 'appId' was not present! Struct: ");
            String string2 = this.toString();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            object = new jj((String)charSequence);
            throw object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'id' was not present! Struct: ");
        String string3 = this.toString();
        charSequence.append(string3);
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
            block16: {
                Object object = ji2.a();
                byte by2 = ((jf)object).a;
                if (by2 == 0) {
                    ji2.f();
                    this.a();
                    return;
                }
                byte by3 = ((jf)object).a;
                boolean bl2 = true;
                byte by4 = 11;
                switch (by3) {
                    case 12: {
                        long l10;
                        by3 = 10;
                        if (by2 != by3) break;
                        this.a = l10 = ji2.a();
                        this.b(bl2);
                        break block16;
                    }
                    case 11: {
                        by3 = 2;
                        if (by2 != by3) break;
                        by3 = (byte)(ji2.a() ? 1 : 0);
                        this.a = by3;
                        this.a(bl2);
                        break block16;
                    }
                    case 10: {
                        if (by2 != by4) break;
                        this.i = object = ji2.a();
                        break block16;
                    }
                    case 9: {
                        if (by2 != by4) break;
                        this.h = object = ji2.a();
                        break block16;
                    }
                    case 8: {
                        if (by2 != by4) break;
                        this.g = object = ji2.a();
                        break block16;
                    }
                    case 7: {
                        if (by2 != by4) break;
                        this.f = object = ji2.a();
                        break block16;
                    }
                    case 6: {
                        if (by2 != by4) break;
                        this.e = object = ji2.a();
                        break block16;
                    }
                    case 5: {
                        if (by2 != by4) break;
                        this.d = object = ji2.a();
                        break block16;
                    }
                    case 4: {
                        if (by2 != by4) break;
                        this.c = object = ji2.a();
                        break block16;
                    }
                    case 3: {
                        if (by2 != by4) break;
                        this.b = object = ji2.a();
                        break block16;
                    }
                    case 2: {
                        by3 = 12;
                        if (by2 != by3) break;
                        this.a = object = new ib();
                        ((ib)object).a(ji2);
                        break block16;
                    }
                    case 1: {
                        if (by2 != by4) break;
                        this.a = object = ji2.a();
                        break block16;
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
    public boolean a(is is2) {
        Object object;
        Object object2;
        if (is2 == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = is2.a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.a;
            object = is2.a;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.b();
        bl3 = is2.b();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.a;
            object = is2.a;
            bl2 = ((ib)object2).a((ib)object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.c();
        bl3 = is2.c();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.b;
            object = is2.b;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.d();
        bl3 = is2.d();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.c;
            object = is2.c;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.e();
        bl3 = is2.e();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.d;
            object = is2.d;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.f();
        bl3 = is2.f();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.e;
            object = is2.e;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.g();
        bl3 = is2.g();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.f;
            object = is2.f;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.h();
        bl3 = is2.h();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.g;
            object = is2.g;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.i();
        bl3 = is2.i();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.h;
            object = is2.h;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.j();
        bl3 = is2.j();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.i;
            object = is2.i;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.k();
        bl3 = is2.k();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            bl2 = this.a;
            bl3 = is2.a;
            if (bl2 != bl3) {
                return false;
            }
        }
        bl2 = this.l();
        bl3 = is2.l();
        if (!bl2 && !bl3) return true;
        if (!bl2 || !bl3) return false;
        long l10 = this.a;
        long l11 = is2.a;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 == false) return true;
        return false;
    }

    public is b(String string2) {
        this.c = string2;
        return this;
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
        if ((object = this.c) != null) {
            object = d;
            ji2.a((jf)object);
            object = this.c;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.d) != null && (bl2 = this.e())) {
            object = e;
            ji2.a((jf)object);
            object = this.d;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.e) != null && (bl2 = this.f())) {
            object = f;
            ji2.a((jf)object);
            object = this.e;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.f) != null && (bl2 = this.g())) {
            object = g;
            ji2.a((jf)object);
            object = this.f;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.g) != null && (bl2 = this.h())) {
            object = h;
            ji2.a((jf)object);
            object = this.g;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.h) != null && (bl2 = this.i())) {
            object = i;
            ji2.a((jf)object);
            object = this.h;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.i) != null && (bl2 = this.j())) {
            object = j;
            ji2.a((jf)object);
            object = this.i;
            ji2.a((String)object);
            ji2.b();
        }
        if (bl2 = this.k()) {
            object = k;
            ji2.a((jf)object);
            bl2 = this.a;
            ji2.a(bl2);
            ji2.b();
        }
        if (bl2 = this.l()) {
            object = l;
            ji2.a((jf)object);
            long l10 = this.a;
            ji2.a(l10);
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

    public is c(String string2) {
        this.d = string2;
        return this;
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
        object = (is)object;
        return this.a((is)object);
    }

    public is d(String string2) {
        this.f = string2;
        return this;
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

    public is e(String string2) {
        this.g = string2;
        return this;
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
        boolean bl2 = object instanceof is;
        if (bl2) {
            object = (is)object;
            return this.a((is)object);
        }
        return false;
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

    public boolean k() {
        return this.a.get(0);
    }

    public boolean l() {
        return this.a.get(1);
    }

    public String toString() {
        Object object = "XmPushActionUnRegistration(";
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
        stringBuilder.append(string3);
        stringBuilder.append("appId:");
        object = this.c;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        bl2 = this.e();
        if (bl2) {
            stringBuilder.append(string3);
            stringBuilder.append("regId:");
            object = this.d;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.f()) {
            stringBuilder.append(string3);
            stringBuilder.append("appVersion:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.g()) {
            stringBuilder.append(string3);
            stringBuilder.append("packageName:");
            object = this.f;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.h()) {
            stringBuilder.append(string3);
            stringBuilder.append("token:");
            object = this.g;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.i()) {
            stringBuilder.append(string3);
            stringBuilder.append("deviceId:");
            object = this.h;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.j()) {
            stringBuilder.append(string3);
            stringBuilder.append("aliasName:");
            object = this.i;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.k()) {
            stringBuilder.append(string3);
            object = "needAck:";
            stringBuilder.append((String)object);
            bl2 = this.a;
            stringBuilder.append(bl2);
        }
        if (bl2 = this.l()) {
            stringBuilder.append(string3);
            object = "createdTs:";
            stringBuilder.append((String)object);
            long l10 = this.a;
            stringBuilder.append(l10);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

