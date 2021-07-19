/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ix;
import com.xiaomi.push.iy;
import com.xiaomi.push.jf;
import com.xiaomi.push.jh;
import com.xiaomi.push.ji;
import com.xiaomi.push.jl;
import com.xiaomi.push.jn;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class hq
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
    public long a;
    public String a;
    private BitSet a;
    public Map a;
    public boolean a;
    public long b;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    static {
        Object object = new jn("ClientUploadDataItem");
        a = object;
        String string2 = "";
        byte by2 = 11;
        a = object = new jf(string2, by2, 1);
        byte by3 = 2;
        b = object = new jf(string2, by2, by3);
        c = object = new jf(string2, by2, 3);
        byte by4 = 10;
        d = object = new jf(string2, by4, 4);
        e = object = new jf(string2, by4, 5);
        f = object = new jf(string2, by3, 6);
        g = object = new jf(string2, by2, 7);
        h = object = new jf(string2, by2, 8);
        i = object = new jf(string2, by2, 9);
        j = object = new jf(string2, 13, by4);
        k = object = new jf(string2, by2, by2);
    }

    public hq() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(3);
    }

    public int a(hq object) {
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
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((hq)object).a))) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((hq)object).b))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((hq)object).c))) != 0) {
            return n11;
        }
        constable = this.d();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).d())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.a, l10 = ((hq)object).a)) != 0) {
            return n11;
        }
        constable = this.e();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).e())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.b, l10 = ((hq)object).b)) != 0) {
            return n11;
        }
        constable = this.f();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).f())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0) {
            n11 = (int)(this.a ? 1 : 0);
            bl2 = ((hq)object).a;
            if ((n11 = iy.a(n11 != 0, bl2)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable = Boolean.valueOf(this.g()))).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).g())))) != 0) {
            return n11;
        }
        n11 = (int)(this.g() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((hq)object).d))) != 0) {
            return n11;
        }
        constable = this.h();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).h())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((hq)object).e))) != 0) {
            return n11;
        }
        constable = this.i();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).i())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.i() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.f)), (String)(object2 = ((hq)object).f))) != 0) {
            return n11;
        }
        constable = this.j();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).j())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.j() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Map)((Object)(constable = this.a)), (Map)(object2 = ((hq)object).a))) != 0) {
            return n11;
        }
        constable = this.k();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hq)object).k())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.k() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((String)((Object)(constable = this.g)), (String)(object = ((hq)object).g))) != 0) {
            return n10;
        }
        return 0;
    }

    public long a() {
        return this.b;
    }

    public hq a(long l10) {
        this.a = l10;
        this.a(true);
        return this;
    }

    public hq a(String string2) {
        this.a = string2;
        return this;
    }

    public hq a(boolean bl2) {
        this.a = bl2;
        this.c(true);
        return this;
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
            block16: {
                Object object = ji2.a();
                int n10 = ((jf)object).a;
                if (n10 == 0) {
                    ji2.f();
                    this.a();
                    return;
                }
                int n11 = ((jf)object).a;
                int n12 = 2;
                int n13 = 10;
                boolean bl2 = true;
                int n14 = 11;
                switch (n11) {
                    case 11: {
                        if (n10 != n14) break;
                        this.g = object = ji2.a();
                        break block16;
                    }
                    case 10: {
                        HashMap hashMap;
                        n11 = 13;
                        if (n10 != n11) break;
                        object = ji2.a();
                        n13 = ((jh)object).a * n12;
                        this.a = hashMap = new HashMap(n13);
                        hashMap = null;
                        for (n10 = 0; n10 < (n12 = ((jh)object).a); ++n10) {
                            String string2 = ji2.a();
                            String string3 = ji2.a();
                            Map map = this.a;
                            map.put(string2, string3);
                        }
                        ji2.h();
                        break block16;
                    }
                    case 9: {
                        if (n10 != n14) break;
                        this.f = object = ji2.a();
                        break block16;
                    }
                    case 8: {
                        if (n10 != n14) break;
                        this.e = object = ji2.a();
                        break block16;
                    }
                    case 7: {
                        if (n10 != n14) break;
                        this.d = object = ji2.a();
                        break block16;
                    }
                    case 6: {
                        if (n10 != n12) break;
                        n11 = (int)(ji2.a() ? 1 : 0);
                        this.a = n11;
                        this.c(bl2);
                        break block16;
                    }
                    case 5: {
                        long l10;
                        if (n10 != n13) break;
                        this.b = l10 = ji2.a();
                        this.b(bl2);
                        break block16;
                    }
                    case 4: {
                        long l10;
                        if (n10 != n13) break;
                        this.a = l10 = ji2.a();
                        this.a(bl2);
                        break block16;
                    }
                    case 3: {
                        if (n10 != n14) break;
                        this.c = object = ji2.a();
                        break block16;
                    }
                    case 2: {
                        if (n10 != n14) break;
                        this.b = object = ji2.a();
                        break block16;
                    }
                    case 1: {
                        if (n10 != n14) break;
                        this.a = object = ji2.a();
                        break block16;
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
    public boolean a(hq object) {
        long l10;
        long l11;
        Object object2;
        Object object3;
        if (object == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = ((hq)object).a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.a;
            object2 = ((hq)object).a;
            boolean bl4 = ((String)object3).equals(object2);
            if (!bl4) {
                return false;
            }
        }
        boolean bl5 = this.b();
        bl3 = ((hq)object).b();
        if (bl5 || bl3) {
            if (!bl5 || !bl3) return false;
            object3 = this.b;
            object2 = ((hq)object).b;
            boolean bl6 = ((String)object3).equals(object2);
            if (!bl6) {
                return false;
            }
        }
        boolean bl7 = this.c();
        bl3 = ((hq)object).c();
        if (bl7 || bl3) {
            if (!bl7 || !bl3) return false;
            object3 = this.c;
            object2 = ((hq)object).c;
            boolean bl8 = ((String)object3).equals(object2);
            if (!bl8) {
                return false;
            }
        }
        boolean bl9 = this.d();
        bl3 = ((hq)object).d();
        if (bl9 || bl3) {
            if (!bl9 || !bl3) return false;
            l11 = this.a;
            l10 = ((hq)object).a;
            long l12 = l11 - l10;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false) {
                return false;
            }
        }
        boolean bl10 = this.e();
        bl3 = ((hq)object).e();
        if (bl10 || bl3) {
            if (!bl10 || !bl3) return false;
            l11 = this.b;
            l10 = ((hq)object).b;
            long l13 = l11 - l10;
            Object object5 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object5 != false) {
                return false;
            }
        }
        boolean bl11 = this.f();
        bl3 = ((hq)object).f();
        if (bl11 || bl3) {
            if (!bl11 || !bl3) return false;
            boolean bl12 = this.a;
            bl3 = ((hq)object).a;
            if (bl12 != bl3) {
                return false;
            }
        }
        boolean bl13 = this.g();
        bl3 = ((hq)object).g();
        if (bl13 || bl3) {
            if (!bl13 || !bl3) return false;
            object3 = this.d;
            object2 = ((hq)object).d;
            boolean bl14 = ((String)object3).equals(object2);
            if (!bl14) {
                return false;
            }
        }
        boolean bl15 = this.h();
        bl3 = ((hq)object).h();
        if (bl15 || bl3) {
            if (!bl15 || !bl3) return false;
            object3 = this.e;
            object2 = ((hq)object).e;
            boolean bl16 = ((String)object3).equals(object2);
            if (!bl16) {
                return false;
            }
        }
        boolean bl17 = this.i();
        bl3 = ((hq)object).i();
        if (bl17 || bl3) {
            if (!bl17 || !bl3) return false;
            object3 = this.f;
            object2 = ((hq)object).f;
            boolean bl18 = ((String)object3).equals(object2);
            if (!bl18) {
                return false;
            }
        }
        boolean bl19 = this.j();
        bl3 = ((hq)object).j();
        if (bl19 || bl3) {
            if (!bl19 || !bl3) return false;
            object3 = this.a;
            object2 = ((hq)object).a;
            boolean bl20 = object3.equals(object2);
            if (!bl20) {
                return false;
            }
        }
        boolean bl21 = this.k();
        bl3 = ((hq)object).k();
        if (!bl21 && !bl3) return true;
        if (!bl21 || !bl3) return false;
        object3 = this.g;
        object = ((hq)object).g;
        boolean bl22 = ((String)object3).equals(object);
        if (bl22) return true;
        return false;
    }

    public hq b(long l10) {
        this.b = l10;
        this.b(true);
        return this;
    }

    public hq b(String string2) {
        this.b = string2;
        return this;
    }

    public String b() {
        return this.c;
    }

    public void b(ji ji2) {
        long l10;
        boolean bl2;
        this.a();
        Iterator iterator2 = a;
        ji2.a((jn)((Object)iterator2));
        iterator2 = this.a;
        if (iterator2 != null && (bl2 = this.a())) {
            iterator2 = a;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.a;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.b) != null && (bl2 = this.b())) {
            iterator2 = b;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.b;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.c) != null && (bl2 = this.c())) {
            iterator2 = c;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.c;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if (bl2 = this.d()) {
            iterator2 = d;
            ji2.a((jf)((Object)iterator2));
            l10 = this.a;
            ji2.a(l10);
            ji2.b();
        }
        if (bl2 = this.e()) {
            iterator2 = e;
            ji2.a((jf)((Object)iterator2));
            l10 = this.b;
            ji2.a(l10);
            ji2.b();
        }
        if (bl2 = this.f()) {
            iterator2 = f;
            ji2.a((jf)((Object)iterator2));
            bl2 = this.a;
            ji2.a(bl2);
            ji2.b();
        }
        if ((iterator2 = this.d) != null && (bl2 = this.g())) {
            iterator2 = g;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.d;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.e) != null && (bl2 = this.h())) {
            iterator2 = h;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.e;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.f) != null && (bl2 = this.i())) {
            iterator2 = i;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.f;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.a) != null && (bl2 = this.j())) {
            iterator2 = j;
            ji2.a((jf)((Object)iterator2));
            Object object = this.a;
            int n10 = object.size();
            byte by2 = 11;
            iterator2 = new Iterator(by2, by2, n10);
            ji2.a((jh)((Object)iterator2));
            iterator2 = this.a.entrySet().iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object = iterator2.next();
                String string2 = (String)object.getKey();
                ji2.a(string2);
                object = (String)object.getValue();
                ji2.a((String)object);
            }
            ji2.d();
            ji2.b();
        }
        if ((iterator2 = this.g) != null && (bl2 = this.k())) {
            iterator2 = k;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.g;
            ji2.a((String)((Object)iterator2));
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
        String string2 = this.b;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public hq c(String string2) {
        this.c = string2;
        return this;
    }

    public String c() {
        return this.e;
    }

    public void c(boolean bl2) {
        this.a.set(2, bl2);
    }

    public boolean c() {
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

    public /* synthetic */ int compareTo(Object object) {
        object = (hq)object;
        return this.a((hq)object);
    }

    public hq d(String string2) {
        this.d = string2;
        return this;
    }

    public String d() {
        return this.f;
    }

    public boolean d() {
        return this.a.get(0);
    }

    public hq e(String string2) {
        this.e = string2;
        return this;
    }

    public String e() {
        return this.g;
    }

    public boolean e() {
        return this.a.get(1);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof hq;
        if (bl2) {
            object = (hq)object;
            return this.a((hq)object);
        }
        return false;
    }

    public hq f(String string2) {
        this.f = string2;
        return this;
    }

    public boolean f() {
        return this.a.get(2);
    }

    public hq g(String string2) {
        this.g = string2;
        return this;
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
        Map map = this.a;
        if (map != null) {
            bl2 = true;
        } else {
            bl2 = false;
            map = null;
        }
        return bl2;
    }

    public boolean k() {
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
        long l10;
        Object object = "ClientUploadDataItem(";
        StringBuilder stringBuilder = new StringBuilder((String)object);
        boolean bl2 = this.a();
        String string2 = "null";
        boolean bl3 = false;
        if (bl2) {
            stringBuilder.append("channel:");
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
            stringBuilder.append("data:");
            object = this.b;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
            bl2 = false;
            object = null;
        }
        if (bl4 = this.c()) {
            if (!bl2) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("name:");
            object = this.c;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
            bl2 = false;
            object = null;
        }
        if (bl4 = this.d()) {
            if (!bl2) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("counter:");
            l10 = this.a;
            stringBuilder.append(l10);
            bl2 = false;
            object = null;
        }
        if (bl4 = this.e()) {
            if (!bl2) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("timestamp:");
            l10 = this.b;
            stringBuilder.append(l10);
            bl2 = false;
            object = null;
        }
        if (bl4 = this.f()) {
            if (!bl2) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("fromSdk:");
            bl2 = this.a;
            stringBuilder.append(bl2);
            bl2 = false;
            object = null;
        }
        if (bl4 = this.g()) {
            if (!bl2) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("category:");
            object = this.d;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
            bl2 = false;
            object = null;
        }
        if (bl4 = this.h()) {
            if (!bl2) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("sourcePackage:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
            bl2 = false;
            object = null;
        }
        if (bl4 = this.i()) {
            if (!bl2) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("id:");
            object = this.f;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
            bl2 = false;
            object = null;
        }
        if (bl4 = this.j()) {
            if (!bl2) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("extra:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        } else {
            bl3 = bl2;
        }
        bl2 = this.k();
        if (bl2) {
            if (!bl3) {
                stringBuilder.append(string3);
            }
            stringBuilder.append("pkgName:");
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

