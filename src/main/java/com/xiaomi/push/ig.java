/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ib;
import com.xiaomi.push.ix;
import com.xiaomi.push.iy;
import com.xiaomi.push.jf;
import com.xiaomi.push.jg;
import com.xiaomi.push.ji;
import com.xiaomi.push.jj;
import com.xiaomi.push.jl;
import com.xiaomi.push.jn;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ig
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
    public List a;
    public boolean a;
    public String b;
    public boolean b;
    public String c;
    public String d;
    public String e;

    static {
        Object object = new jn("XmPushActionCommand");
        a = object;
        String string2 = "";
        byte by2 = 12;
        byte by3 = 2;
        a = object = new jf(string2, by2, by3);
        byte by4 = 11;
        b = object = new jf(string2, by4, 3);
        c = object = new jf(string2, by4, 4);
        d = object = new jf(string2, by4, 5);
        e = object = new jf(string2, 15, 6);
        f = object = new jf(string2, by4, 7);
        g = object = new jf(string2, by4, 9);
        byte by5 = 10;
        h = object = new jf(string2, by3, by5);
        i = object = new jf(string2, by3, by4);
        j = object = new jf(string2, by5, by2);
    }

    public ig() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(3);
        this.a = false;
        this.b = true;
    }

    public int a(ig object) {
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
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ig)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)((Object)(constable = this.a)), object2 = ((ig)object).a)) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ig)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((ig)object).a))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ig)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((ig)object).b))) != 0) {
            return n11;
        }
        constable = this.d();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ig)object).d())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((ig)object).c))) != 0) {
            return n11;
        }
        constable = this.e();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ig)object).e())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((List)((Object)(constable = this.a)), (List)(object2 = ((ig)object).a))) != 0) {
            return n11;
        }
        constable = this.f();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ig)object).f())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((ig)object).d))) != 0) {
            return n11;
        }
        constable = this.g();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ig)object).g())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.g() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((ig)object).e))) != 0) {
            return n11;
        }
        constable = this.h();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ig)object).h())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11 != 0) {
            n11 = (int)(this.a ? 1 : 0);
            bl2 = ((ig)object).a;
            if ((n11 = iy.a(n11 != 0, bl2)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable = Boolean.valueOf(this.i()))).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ig)object).i())))) != 0) {
            return n11;
        }
        n11 = (int)(this.i() ? 1 : 0);
        if (n11 != 0) {
            n11 = (int)(this.b ? 1 : 0);
            bl2 = ((ig)object).b;
            if ((n11 = iy.a(n11 != 0, bl2)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable = Boolean.valueOf(this.j()))).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ig)object).j())))) != 0) {
            return n11;
        }
        n11 = (int)(this.j() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a(l11 = this.a, l10 = ((ig)object).a)) != 0) {
            return n10;
        }
        return 0;
    }

    public ig a(String string2) {
        this.a = string2;
        return this;
    }

    public ig a(List list) {
        this.a = list;
        return this;
    }

    public String a() {
        return this.c;
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
                charSequence.append("Required field 'cmdName' was not present! Struct: ");
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
                int n12 = 2;
                boolean bl2 = true;
                int n13 = 11;
                switch (n11) {
                    case 12: {
                        long l10;
                        n11 = 10;
                        if (n10 != n11) break;
                        this.a = l10 = ji2.a();
                        this.c(bl2);
                        break block15;
                    }
                    case 11: {
                        if (n10 != n12) break;
                        n11 = (int)(ji2.a() ? 1 : 0);
                        this.b = n11;
                        this.b(bl2);
                        break block15;
                    }
                    case 10: {
                        if (n10 != n12) break;
                        n11 = (int)(ji2.a() ? 1 : 0);
                        this.a = n11;
                        this.a(bl2);
                        break block15;
                    }
                    case 9: {
                        if (n10 != n13) break;
                        this.e = object = ji2.a();
                        break block15;
                    }
                    case 7: {
                        if (n10 != n13) break;
                        this.d = object = ji2.a();
                        break block15;
                    }
                    case 6: {
                        ArrayList arrayList;
                        n11 = 15;
                        if (n10 != n11) break;
                        object = ji2.a();
                        n12 = ((jg)object).a;
                        this.a = arrayList = new ArrayList(n12);
                        arrayList = null;
                        for (n10 = 0; n10 < (n12 = ((jg)object).a); ++n10) {
                            String string2 = ji2.a();
                            List list = this.a;
                            list.add(string2);
                        }
                        ji2.i();
                        break block15;
                    }
                    case 5: {
                        if (n10 != n13) break;
                        this.c = object = ji2.a();
                        break block15;
                    }
                    case 4: {
                        if (n10 != n13) break;
                        this.b = object = ji2.a();
                        break block15;
                    }
                    case 3: {
                        if (n10 != n13) break;
                        this.a = object = ji2.a();
                        break block15;
                    }
                    case 2: {
                        n11 = 12;
                        if (n10 != n11) break;
                        this.a = object = new ib();
                        ((ib)object).a(ji2);
                        break block15;
                    }
                }
                jl.a(ji2, (byte)n10);
            }
            ji2.g();
        }
    }

    public void a(String string2) {
        ArrayList arrayList = this.a;
        if (arrayList == null) {
            this.a = arrayList = new ArrayList();
        }
        this.a.add(string2);
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
    public boolean a(ig ig2) {
        Object object;
        Object object2;
        if (ig2 == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = ig2.a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.a;
            object = ig2.a;
            bl2 = ((ib)object2).a((ib)object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.b();
        bl3 = ig2.b();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.a;
            object = ig2.a;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.c();
        bl3 = ig2.c();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.b;
            object = ig2.b;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.d();
        bl3 = ig2.d();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.c;
            object = ig2.c;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.e();
        bl3 = ig2.e();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.a;
            object = ig2.a;
            bl2 = object2.equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.f();
        bl3 = ig2.f();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.d;
            object = ig2.d;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.g();
        bl3 = ig2.g();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.e;
            object = ig2.e;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.h();
        bl3 = ig2.h();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            bl2 = this.a;
            bl3 = ig2.a;
            if (bl2 != bl3) {
                return false;
            }
        }
        bl2 = this.i();
        bl3 = ig2.i();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            bl2 = this.b;
            bl3 = ig2.b;
            if (bl2 != bl3) {
                return false;
            }
        }
        bl2 = this.j();
        bl3 = ig2.j();
        if (!bl2 && !bl3) return true;
        if (!bl2 || !bl3) return false;
        long l10 = this.a;
        long l11 = ig2.a;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 == false) return true;
        return false;
    }

    public ig b(String string2) {
        this.b = string2;
        return this;
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
            ((ib)((Object)iterator2)).b(ji2);
            ji2.b();
        }
        if ((iterator2 = this.a) != null) {
            iterator2 = b;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.a;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.b) != null) {
            iterator2 = c;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.b;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.c) != null) {
            iterator2 = d;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.c;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.a) != null && (bl2 = this.e())) {
            iterator2 = e;
            ji2.a((jf)((Object)iterator2));
            byte by2 = 11;
            List list = this.a;
            int n10 = list.size();
            iterator2 = new Iterator(by2, n10);
            ji2.a((jg)((Object)iterator2));
            iterator2 = this.a.iterator();
            while ((by2 = (byte)(iterator2.hasNext() ? 1 : 0)) != 0) {
                String string2 = (String)iterator2.next();
                ji2.a(string2);
            }
            ji2.e();
            ji2.b();
        }
        if ((iterator2 = this.d) != null && (bl2 = this.f())) {
            iterator2 = f;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.d;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.e) != null && (bl2 = this.g())) {
            iterator2 = g;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.e;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if (bl2 = this.h()) {
            iterator2 = h;
            ji2.a((jf)((Object)iterator2));
            bl2 = this.a;
            ji2.a(bl2);
            ji2.b();
        }
        if (bl2 = this.i()) {
            iterator2 = i;
            ji2.a((jf)((Object)iterator2));
            bl2 = this.b;
            ji2.a(bl2);
            ji2.b();
        }
        if (bl2 = this.j()) {
            iterator2 = j;
            ji2.a((jf)((Object)iterator2));
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
        String string2 = this.a;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public ig c(String string2) {
        this.c = string2;
        return this;
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
        object = (ig)object;
        return this.a((ig)object);
    }

    public ig d(String string2) {
        this.d = string2;
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

    public ig e(String string2) {
        this.e = string2;
        return this;
    }

    public boolean e() {
        boolean bl2;
        List list = this.a;
        if (list != null) {
            bl2 = true;
        } else {
            bl2 = false;
            list = null;
        }
        return bl2;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof ig;
        if (bl2) {
            object = (ig)object;
            return this.a((ig)object);
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
        return this.a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.a.get(1);
    }

    public boolean j() {
        return this.a.get(2);
    }

    public String toString() {
        Object object = "XmPushActionCommand(";
        StringBuilder stringBuilder = new StringBuilder((String)object);
        boolean bl2 = this.a();
        String string2 = "null";
        if (bl2) {
            stringBuilder.append("target:");
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
        stringBuilder.append("cmdName:");
        object = this.c;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        bl2 = this.e();
        if (bl2) {
            stringBuilder.append(string3);
            stringBuilder.append("cmdArgs:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        }
        if (bl2 = this.f()) {
            stringBuilder.append(string3);
            stringBuilder.append("packageName:");
            object = this.d;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.g()) {
            stringBuilder.append(string3);
            stringBuilder.append("category:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.h()) {
            stringBuilder.append(string3);
            object = "updateCache:";
            stringBuilder.append((String)object);
            bl2 = this.a;
            stringBuilder.append(bl2);
        }
        if (bl2 = this.i()) {
            stringBuilder.append(string3);
            object = "response2Client:";
            stringBuilder.append((String)object);
            bl2 = this.b;
            stringBuilder.append(bl2);
        }
        if (bl2 = this.j()) {
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

