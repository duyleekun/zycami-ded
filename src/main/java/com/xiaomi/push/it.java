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
public class it
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
    public long b;
    public String b;
    public long c;
    public String c;
    public String d;
    public String e;

    static {
        Object object = new jn("XmPushActionUnRegistrationResult");
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
        h = object = new jf(string2, by3, 9);
        i = object = new jf(string2, by3, by3);
    }

    public it() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(3);
    }

    public int a(it object) {
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
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((it)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((it)object).a))) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((it)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((it)object).a))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((it)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((it)object).b))) != 0) {
            return n11;
        }
        constable = this.d();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((it)object).d())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((it)object).c))) != 0) {
            return n11;
        }
        constable = this.e();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((it)object).e())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.a, l10 = ((it)object).a)) != 0) {
            return n11;
        }
        constable = this.f();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((it)object).f())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((it)object).d))) != 0) {
            return n11;
        }
        constable = this.g();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((it)object).g())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.g() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((it)object).e))) != 0) {
            return n11;
        }
        constable = this.h();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((it)object).h())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.b, l10 = ((it)object).b)) != 0) {
            return n11;
        }
        constable = this.i();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((it)object).i())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.i() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a(l11 = this.c, l10 = ((it)object).c)) != 0) {
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
    public void a(ji object) {
        ((ji)object).a();
        while (true) {
            block14: {
                Object object2 = ((ji)object).a();
                byte by2 = ((jf)object2).a;
                if (by2 == 0) {
                    ((ji)object).f();
                    boolean bl2 = this.e();
                    if (bl2) {
                        this.a();
                        return;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Required field 'errorCode' was not found in serialized data! Struct: ");
                    String string2 = this.toString();
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    object = new jj((String)object2);
                    throw object;
                }
                byte by3 = ((jf)object2).a;
                boolean bl3 = true;
                byte by4 = 10;
                byte by5 = 11;
                switch (by3) {
                    case 10: {
                        long l10;
                        if (by2 != by4) break;
                        this.c = l10 = ((ji)object).a();
                        this.c(bl3);
                        break block14;
                    }
                    case 9: {
                        long l10;
                        if (by2 != by4) break;
                        this.b = l10 = ((ji)object).a();
                        this.b(bl3);
                        break block14;
                    }
                    case 8: {
                        if (by2 != by5) break;
                        this.e = object2 = ((ji)object).a();
                        break block14;
                    }
                    case 7: {
                        if (by2 != by5) break;
                        this.d = object2 = ((ji)object).a();
                        break block14;
                    }
                    case 6: {
                        long l10;
                        if (by2 != by4) break;
                        this.a = l10 = ((ji)object).a();
                        this.a(bl3);
                        break block14;
                    }
                    case 4: {
                        if (by2 != by5) break;
                        this.c = object2 = ((ji)object).a();
                        break block14;
                    }
                    case 3: {
                        if (by2 != by5) break;
                        this.b = object2 = ((ji)object).a();
                        break block14;
                    }
                    case 2: {
                        by3 = 12;
                        if (by2 != by3) break;
                        this.a = object2 = new ib();
                        ((ib)object2).a((ji)object);
                        break block14;
                    }
                    case 1: {
                        if (by2 != by5) break;
                        this.a = object2 = ((ji)object).a();
                        break block14;
                    }
                }
                jl.a((ji)object, by2);
            }
            ((ji)object).g();
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
    public boolean a(it it2) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object;
        Object object2;
        if (it2 == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = it2.a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.a;
            object = it2.a;
            boolean bl4 = ((String)object2).equals(object);
            if (!bl4) {
                return false;
            }
        }
        boolean bl5 = this.b();
        bl3 = it2.b();
        if (bl5 || bl3) {
            if (!bl5 || !bl3) return false;
            object2 = this.a;
            object = it2.a;
            boolean bl6 = ((ib)object2).a((ib)object);
            if (!bl6) {
                return false;
            }
        }
        boolean bl7 = this.c();
        bl3 = it2.c();
        if (bl7 || bl3) {
            if (!bl7 || !bl3) return false;
            object2 = this.b;
            object = it2.b;
            boolean bl8 = ((String)object2).equals(object);
            if (!bl8) {
                return false;
            }
        }
        boolean bl9 = this.d();
        bl3 = it2.d();
        if (bl9 || bl3) {
            if (!bl9 || !bl3) return false;
            object2 = this.c;
            object = it2.c;
            boolean bl10 = ((String)object2).equals(object);
            if (!bl10) {
                return false;
            }
        }
        if ((l13 = (l12 = (l11 = this.a) - (l10 = it2.a)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            return false;
        }
        boolean bl11 = this.f();
        bl3 = it2.f();
        if (bl11 || bl3) {
            if (!bl11 || !bl3) return false;
            object2 = this.d;
            object = it2.d;
            boolean bl12 = ((String)object2).equals(object);
            if (!bl12) {
                return false;
            }
        }
        boolean bl13 = this.g();
        bl3 = it2.g();
        if (bl13 || bl3) {
            if (!bl13 || !bl3) return false;
            object2 = this.e;
            object = it2.e;
            boolean bl14 = ((String)object2).equals(object);
            if (!bl14) {
                return false;
            }
        }
        boolean bl15 = this.h();
        bl3 = it2.h();
        if (bl15 || bl3) {
            if (!bl15 || !bl3) return false;
            l11 = this.b;
            l10 = it2.b;
            long l14 = l11 - l10;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 != false) {
                return false;
            }
        }
        boolean bl16 = this.i();
        bl3 = it2.i();
        if (!bl16 && !bl3) return true;
        if (!bl16 || !bl3) return false;
        l11 = this.c;
        l10 = it2.c;
        long l15 = l11 - l10;
        Object object4 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object4 == false) return true;
        return false;
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
        object = e;
        ji2.a((jf)object);
        long l10 = this.a;
        ji2.a(l10);
        ji2.b();
        object = this.d;
        if (object != null && (bl2 = this.f())) {
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
        if (bl2 = this.h()) {
            object = h;
            ji2.a((jf)object);
            l10 = this.b;
            ji2.a(l10);
            ji2.b();
        }
        if (bl2 = this.i()) {
            object = i;
            ji2.a((jf)object);
            l10 = this.c;
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
        object = (it)object;
        return this.a((it)object);
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
        boolean bl2 = object instanceof it;
        if (bl2) {
            object = (it)object;
            return this.a((it)object);
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
        return this.a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.a.get(2);
    }

    public String toString() {
        Object object = "XmPushActionUnRegistrationResult(";
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
        stringBuilder.append(string3);
        object = "errorCode:";
        stringBuilder.append((String)object);
        long l10 = this.a;
        stringBuilder.append(l10);
        bl2 = this.f();
        if (bl2) {
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
            stringBuilder.append("packageName:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.h()) {
            stringBuilder.append(string3);
            object = "unRegisteredAt:";
            stringBuilder.append((String)object);
            l10 = this.b;
            stringBuilder.append(l10);
        }
        if (bl2 = this.i()) {
            stringBuilder.append(string3);
            object = "costTime:";
            stringBuilder.append((String)object);
            l10 = this.c;
            stringBuilder.append(l10);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

