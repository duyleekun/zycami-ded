/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ix;
import com.xiaomi.push.iy;
import com.xiaomi.push.jf;
import com.xiaomi.push.ji;
import com.xiaomi.push.jl;
import com.xiaomi.push.jn;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.BitSet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class hx
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
    public int a;
    public long a;
    public String a;
    private BitSet a;
    public boolean a;
    public int b;
    public boolean b;
    public int c;

    static {
        Object object = new jn("OnlineConfigItem");
        a = object;
        String string2 = "";
        byte by2 = 8;
        a = object = new jf(string2, by2, 1);
        byte by3 = 2;
        b = object = new jf(string2, by2, by3);
        c = object = new jf(string2, by3, 3);
        d = object = new jf(string2, by2, 4);
        e = object = new jf(string2, 10, 5);
        f = object = new jf(string2, 11, 6);
        g = object = new jf(string2, by3, 7);
    }

    public hx() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(6);
    }

    public int a() {
        return this.a;
    }

    public int a(hx object) {
        long l10;
        long l11;
        int n10;
        Object object2;
        Constable constable = this.getClass();
        int n11 = constable.equals(object2 = object.getClass());
        if (!n11) {
            constable = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)((Object)constable)).compareTo((String)object);
        }
        constable = this.a();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n10 = ((hx)object).a()) != 0)));
        if (n11) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11) {
            n11 = this.a;
            n10 = ((hx)object).a;
            if (n11 = iy.a(n11, n10)) {
                return n11;
            }
        }
        if (n11 = ((Boolean)(constable = Boolean.valueOf(this.b()))).compareTo((Boolean)(object2 = Boolean.valueOf((n10 = (int)(((hx)object).b() ? 1 : 0)) != 0)))) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11) {
            n11 = this.b;
            n10 = ((hx)object).b;
            if (n11 = iy.a(n11, n10)) {
                return n11;
            }
        }
        if (n11 = ((Boolean)(constable = Boolean.valueOf(this.c()))).compareTo((Boolean)(object2 = Boolean.valueOf((n10 = (int)(((hx)object).c() ? 1 : 0)) != 0)))) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11) {
            n11 = (int)(this.a ? 1 : 0);
            n10 = ((hx)object).a;
            if (n11 = iy.a(n11 != 0, n10 != 0)) {
                return n11;
            }
        }
        if (n11 = ((Boolean)(constable = Boolean.valueOf(this.d()))).compareTo((Boolean)(object2 = Boolean.valueOf((n10 = ((hx)object).d()) != 0)))) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11) {
            n11 = this.c;
            n10 = ((hx)object).c;
            if (n11 = iy.a(n11, n10)) {
                return n11;
            }
        }
        if (n11 = ((Boolean)(constable = Boolean.valueOf(this.e()))).compareTo((Boolean)(object2 = Boolean.valueOf((n10 = (int)(((hx)object).e() ? 1 : 0)) != 0)))) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 && (n11 = iy.a(l11 = this.a, l10 = ((hx)object).a))) {
            return n11;
        }
        constable = this.f();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n10 = ((hx)object).f()) != 0)));
        if (n11) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((hx)object).a)))) {
            return n11;
        }
        constable = this.h();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n10 = ((hx)object).h()) != 0)));
        if (n11) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11) {
            n11 = (int)(this.b ? 1 : 0);
            int n12 = ((hx)object).b;
            if ((n12 = iy.a(n11 != 0, n12 != 0)) != 0) {
                return n12;
            }
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
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(ji ji2) {
        ji2.a();
        while (true) {
            block11: {
                Object object = ji2.a();
                int n10 = ((jf)object).a;
                if (n10 == 0) {
                    ji2.f();
                    this.a();
                    return;
                }
                int n11 = ((jf)object).a;
                int n12 = 2;
                int n13 = 8;
                boolean bl2 = true;
                switch (n11) {
                    case 7: {
                        if (n10 != n12) break;
                        n11 = (int)(ji2.a() ? 1 : 0);
                        this.b = n11;
                        this.f(bl2);
                        break block11;
                    }
                    case 6: {
                        n11 = 11;
                        if (n10 != n11) break;
                        this.a = object = ji2.a();
                        break block11;
                    }
                    case 5: {
                        long l10;
                        n11 = 10;
                        if (n10 != n11) break;
                        this.a = l10 = ji2.a();
                        this.e(bl2);
                        break block11;
                    }
                    case 4: {
                        if (n10 != n13) break;
                        this.c = n11 = ji2.a();
                        this.d(bl2);
                        break block11;
                    }
                    case 3: {
                        if (n10 != n12) break;
                        n11 = (int)(ji2.a() ? 1 : 0);
                        this.a = n11;
                        this.c(bl2);
                        break block11;
                    }
                    case 2: {
                        if (n10 != n13) break;
                        this.b = n11 = ji2.a();
                        this.b(bl2);
                        break block11;
                    }
                    case 1: {
                        if (n10 != n13) break;
                        this.a = n11 = ji2.a();
                        this.a(bl2);
                        break block11;
                    }
                }
                jl.a(ji2, (byte)n10);
            }
            ji2.g();
        }
    }

    public void a(boolean bl2) {
        this.a.set(0, bl2);
    }

    public boolean a() {
        return this.a.get(0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(hx hx2) {
        if (hx2 == null) {
            return false;
        }
        int n10 = this.a();
        int n11 = hx2.a();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.a;
            n11 = hx2.a;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = this.b();
        n11 = hx2.b();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.b;
            n11 = hx2.b;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.c() ? 1 : 0);
        n11 = (int)(hx2.c() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = (int)(this.a ? 1 : 0);
            n11 = (int)(hx2.a ? 1 : 0);
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.d() ? 1 : 0);
        n11 = (int)(hx2.d() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.c;
            n11 = hx2.c;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.e() ? 1 : 0);
        n11 = (int)(hx2.e() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            long l10 = this.a;
            long l11 = hx2.a;
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) {
                return false;
            }
        }
        n10 = (int)(this.f() ? 1 : 0);
        n11 = (int)(hx2.f() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            String string2 = this.a;
            String string3 = hx2.a;
            n10 = (int)(string2.equals(string3) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.h() ? 1 : 0);
        n11 = (int)(hx2.h() ? 1 : 0);
        if (n10 == 0 && n11 == 0) return true;
        if (n10 == 0 || n11 == 0) return false;
        n10 = (int)(this.b ? 1 : 0);
        int n12 = hx2.b;
        if (n10 == n12) return true;
        return false;
    }

    public int b() {
        return this.b;
    }

    public void b(ji ji2) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        boolean bl7;
        this.a();
        Object object = a;
        ji2.a((jn)object);
        boolean bl22 = this.a();
        if (bl22) {
            object = a;
            ji2.a((jf)object);
            int n10 = this.a;
            ji2.a(n10);
            ji2.b();
        }
        if (bl7 = this.b()) {
            object = b;
            ji2.a((jf)object);
            int n11 = this.b;
            ji2.a(n11);
            ji2.b();
        }
        if (bl6 = this.c()) {
            object = c;
            ji2.a((jf)object);
            boolean bl8 = this.a;
            ji2.a(bl8);
            ji2.b();
        }
        if (bl5 = this.d()) {
            object = d;
            ji2.a((jf)object);
            int n12 = this.c;
            ji2.a(n12);
            ji2.b();
        }
        if (bl4 = this.e()) {
            object = e;
            ji2.a((jf)object);
            long l10 = this.a;
            ji2.a(l10);
            ji2.b();
        }
        if ((object = this.a) != null && (bl3 = this.f())) {
            object = f;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((String)object);
            ji2.b();
        }
        if (bl2 = this.h()) {
            object = g;
            ji2.a((jf)object);
            boolean bl9 = this.b;
            ji2.a(bl9);
            ji2.b();
        }
        ji2.c();
        ji2.a();
    }

    public void b(boolean bl2) {
        this.a.set(1, bl2);
    }

    public boolean b() {
        return this.a.get(1);
    }

    public int c() {
        return this.c;
    }

    public void c(boolean bl2) {
        this.a.set(2, bl2);
    }

    public boolean c() {
        return this.a.get(2);
    }

    public /* synthetic */ int compareTo(Object object) {
        object = (hx)object;
        return this.a((hx)object);
    }

    public void d(boolean bl2) {
        this.a.set(3, bl2);
    }

    public boolean d() {
        return this.a.get(3);
    }

    public void e(boolean bl2) {
        this.a.set(4, bl2);
    }

    public boolean e() {
        return this.a.get(4);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof hx;
        if (bl2) {
            object = (hx)object;
            return this.a((hx)object);
        }
        return false;
    }

    public void f(boolean bl2) {
        this.a.set(5, bl2);
    }

    public boolean f() {
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

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    public String toString() {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        String string2 = "OnlineConfigItem(";
        StringBuilder stringBuilder = new StringBuilder(string2);
        boolean bl22 = this.a();
        boolean bl6 = false;
        if (bl22) {
            stringBuilder.append("key:");
            int n10 = this.a;
            stringBuilder.append(n10);
            boolean bl7 = false;
            string2 = null;
        } else {
            boolean bl8 = true;
        }
        boolean bl9 = this.b();
        String string3 = ", ";
        if (bl9) {
            void var3_7;
            if (var3_7 == false) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("type:");
            int n11 = this.b;
            stringBuilder.append(n11);
            bl5 = false;
            string2 = null;
        }
        if (bl9 = this.c()) {
            if (!bl5) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("clear:");
            boolean bl10 = this.a;
            stringBuilder.append(bl10);
            bl4 = false;
            string2 = null;
        }
        if (bl9 = this.d()) {
            if (!bl4) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("intValue:");
            int n12 = this.c;
            stringBuilder.append(n12);
            bl3 = false;
            string2 = null;
        }
        if (bl9 = this.e()) {
            if (!bl3) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("longValue:");
            long l10 = this.a;
            stringBuilder.append(l10);
            bl2 = false;
            string2 = null;
        }
        if (bl9 = this.f()) {
            if (!bl2) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("stringValue:");
            string2 = this.a;
            if (string2 == null) {
                string2 = "null";
            }
            stringBuilder.append(string2);
        } else {
            bl6 = bl2;
        }
        boolean bl11 = this.h();
        if (bl11) {
            if (!bl6) {
                stringBuilder.append(string3);
            }
            string2 = "boolValue:";
            stringBuilder.append(string2);
            boolean bl12 = this.b;
            stringBuilder.append(bl12);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

