/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

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
import java.lang.constant.Constable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class id
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
    public long a;
    public ib a;
    public String a;
    private BitSet a;
    public Map a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    static {
        Object object = new jn("XmPushActionAckNotification");
        a = object;
        String string2 = "";
        byte by2 = 11;
        a = object = new jf(string2, by2, 1);
        b = object = new jf(string2, 12, 2);
        c = object = new jf(string2, by2, 3);
        d = object = new jf(string2, by2, 4);
        e = object = new jf(string2, by2, 5);
        byte by3 = 10;
        f = object = new jf(string2, by3, 7);
        g = object = new jf(string2, by2, 8);
        h = object = new jf(string2, 13, 9);
        i = object = new jf(string2, by2, by3);
        j = object = new jf(string2, by2, by2);
    }

    public id() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(1);
        this.a = 0L;
    }

    public int a(id object) {
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
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((id)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((id)object).a))) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((id)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((id)object).a))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((id)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((id)object).b))) != 0) {
            return n11;
        }
        constable = this.d();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((id)object).d())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((id)object).c))) != 0) {
            return n11;
        }
        constable = this.e();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((id)object).e())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((id)object).d))) != 0) {
            return n11;
        }
        constable = this.f();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((id)object).f())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.a, l10 = ((id)object).a)) != 0) {
            return n11;
        }
        constable = this.g();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((id)object).g())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.g() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((id)object).e))) != 0) {
            return n11;
        }
        constable = this.h();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((id)object).h())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Map)((Object)(constable = this.a)), (Map)(object2 = ((id)object).a))) != 0) {
            return n11;
        }
        constable = this.i();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((id)object).i())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.i() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.f)), (String)(object2 = ((id)object).f))) != 0) {
            return n11;
        }
        constable = this.j();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((id)object).j())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.j() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((String)((Object)(constable = this.g)), (String)(object = ((id)object).g))) != 0) {
            return n10;
        }
        return 0;
    }

    public String a() {
        return this.b;
    }

    public Map a() {
        return this.a;
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
            block15: {
                Object object = ji2.a();
                int n10 = ((jf)object).a;
                if (n10 == 0) {
                    ji2.f();
                    this.a();
                    return;
                }
                int n11 = ((jf)object).a;
                int n12 = 11;
                switch (n11) {
                    case 11: {
                        if (n10 != n12) break;
                        this.g = object = ji2.a();
                        break block15;
                    }
                    case 10: {
                        if (n10 != n12) break;
                        this.f = object = ji2.a();
                        break block15;
                    }
                    case 9: {
                        HashMap hashMap;
                        n11 = 13;
                        if (n10 != n11) break;
                        object = ji2.a();
                        n12 = ((jh)object).a * 2;
                        this.a = hashMap = new HashMap(n12);
                        hashMap = null;
                        for (n10 = 0; n10 < (n12 = ((jh)object).a); ++n10) {
                            String string2 = ji2.a();
                            String string3 = ji2.a();
                            Map map = this.a;
                            map.put(string2, string3);
                        }
                        ji2.h();
                        break block15;
                    }
                    case 8: {
                        if (n10 != n12) break;
                        this.e = object = ji2.a();
                        break block15;
                    }
                    case 7: {
                        long l10;
                        n11 = 10;
                        if (n10 != n11) break;
                        this.a = l10 = ji2.a();
                        n11 = 1;
                        this.a(n11 != 0);
                        break block15;
                    }
                    case 5: {
                        if (n10 != n12) break;
                        this.d = object = ji2.a();
                        break block15;
                    }
                    case 4: {
                        if (n10 != n12) break;
                        this.c = object = ji2.a();
                        break block15;
                    }
                    case 3: {
                        if (n10 != n12) break;
                        this.b = object = ji2.a();
                        break block15;
                    }
                    case 2: {
                        n11 = 12;
                        if (n10 != n11) break;
                        this.a = object = new ib();
                        ((ib)object).a(ji2);
                        break block15;
                    }
                    case 1: {
                        if (n10 != n12) break;
                        this.a = object = ji2.a();
                        break block15;
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
    public boolean a(id object) {
        Object object2;
        Object object3;
        if (object == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = ((id)object).a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.a;
            object2 = ((id)object).a;
            boolean bl4 = ((String)object3).equals(object2);
            if (!bl4) {
                return false;
            }
        }
        boolean bl5 = this.b();
        bl3 = ((id)object).b();
        if (bl5 || bl3) {
            if (!bl5 || !bl3) return false;
            object3 = this.a;
            object2 = ((id)object).a;
            boolean bl6 = ((ib)object3).a((ib)object2);
            if (!bl6) {
                return false;
            }
        }
        boolean bl7 = this.c();
        bl3 = ((id)object).c();
        if (bl7 || bl3) {
            if (!bl7 || !bl3) return false;
            object3 = this.b;
            object2 = ((id)object).b;
            boolean bl8 = ((String)object3).equals(object2);
            if (!bl8) {
                return false;
            }
        }
        boolean bl9 = this.d();
        bl3 = ((id)object).d();
        if (bl9 || bl3) {
            if (!bl9 || !bl3) return false;
            object3 = this.c;
            object2 = ((id)object).c;
            boolean bl10 = ((String)object3).equals(object2);
            if (!bl10) {
                return false;
            }
        }
        boolean bl11 = this.e();
        bl3 = ((id)object).e();
        if (bl11 || bl3) {
            if (!bl11 || !bl3) return false;
            object3 = this.d;
            object2 = ((id)object).d;
            boolean bl12 = ((String)object3).equals(object2);
            if (!bl12) {
                return false;
            }
        }
        boolean bl13 = this.f();
        bl3 = ((id)object).f();
        if (bl13 || bl3) {
            if (!bl13 || !bl3) return false;
            long l10 = this.a;
            long l11 = ((id)object).a;
            long l12 = l10 - l11;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false) {
                return false;
            }
        }
        boolean bl14 = this.g();
        bl3 = ((id)object).g();
        if (bl14 || bl3) {
            if (!bl14 || !bl3) return false;
            object3 = this.e;
            object2 = ((id)object).e;
            boolean bl15 = ((String)object3).equals(object2);
            if (!bl15) {
                return false;
            }
        }
        boolean bl16 = this.h();
        bl3 = ((id)object).h();
        if (bl16 || bl3) {
            if (!bl16 || !bl3) return false;
            object3 = this.a;
            object2 = ((id)object).a;
            boolean bl17 = object3.equals(object2);
            if (!bl17) {
                return false;
            }
        }
        boolean bl18 = this.i();
        bl3 = ((id)object).i();
        if (bl18 || bl3) {
            if (!bl18 || !bl3) return false;
            object3 = this.f;
            object2 = ((id)object).f;
            boolean bl19 = ((String)object3).equals(object2);
            if (!bl19) {
                return false;
            }
        }
        boolean bl20 = this.j();
        bl3 = ((id)object).j();
        if (!bl20 && !bl3) return true;
        if (!bl20 || !bl3) return false;
        object3 = this.g;
        object = ((id)object).g;
        boolean bl21 = ((String)object3).equals(object);
        if (bl21) return true;
        return false;
    }

    public void b(ji ji2) {
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
        if ((iterator2 = this.a) != null && (bl2 = this.b())) {
            iterator2 = b;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.a;
            ((ib)((Object)iterator2)).b(ji2);
            ji2.b();
        }
        if ((iterator2 = this.b) != null) {
            iterator2 = c;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.b;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.c) != null && (bl2 = this.d())) {
            iterator2 = d;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.c;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.d) != null && (bl2 = this.e())) {
            iterator2 = e;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.d;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if (bl2 = this.f()) {
            iterator2 = f;
            ji2.a((jf)((Object)iterator2));
            long l10 = this.a;
            ji2.a(l10);
            ji2.b();
        }
        if ((iterator2 = this.e) != null && (bl2 = this.g())) {
            iterator2 = g;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.e;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.a) != null && (bl2 = this.h())) {
            iterator2 = h;
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
        if ((iterator2 = this.f) != null && (bl2 = this.i())) {
            iterator2 = i;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.f;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.g) != null && (bl2 = this.j())) {
            iterator2 = j;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.g;
            ji2.a((String)((Object)iterator2));
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
        object = (id)object;
        return this.a((id)object);
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
        boolean bl2 = object instanceof id;
        if (bl2) {
            object = (id)object;
            return this.a((id)object);
        }
        return false;
    }

    public boolean f() {
        return this.a.get(0);
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
        Map map = this.a;
        if (map != null) {
            bl2 = true;
        } else {
            bl2 = false;
            map = null;
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

    public String toString() {
        Object object = "XmPushActionAckNotification(";
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
            stringBuilder.append("type:");
            object = this.d;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.f()) {
            stringBuilder.append(string3);
            object = "errorCode:";
            stringBuilder.append((String)object);
            long l10 = this.a;
            stringBuilder.append(l10);
        }
        if (bl2 = this.g()) {
            stringBuilder.append(string3);
            stringBuilder.append("reason:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.h()) {
            stringBuilder.append(string3);
            stringBuilder.append("extra:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        }
        if (bl2 = this.i()) {
            stringBuilder.append(string3);
            stringBuilder.append("packageName:");
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
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

