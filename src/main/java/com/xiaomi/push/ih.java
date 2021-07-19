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
public class ih
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
    public String c;
    public String d;
    public String e;
    public String f;

    static {
        Object object = new jn("XmPushActionCommandResult");
        a = object;
        String string2 = "";
        byte by2 = 12;
        byte by3 = 2;
        a = object = new jf(string2, by2, by3);
        byte by4 = 11;
        b = object = new jf(string2, by4, 3);
        c = object = new jf(string2, by4, 4);
        d = object = new jf(string2, by4, 5);
        byte by5 = 10;
        e = object = new jf(string2, by5, 7);
        f = object = new jf(string2, by4, 8);
        g = object = new jf(string2, by4, 9);
        h = object = new jf(string2, 15, by5);
        i = object = new jf(string2, by4, by2);
        j = object = new jf(string2, by3, 13);
    }

    public ih() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(2);
        this.a = true;
    }

    public int a(ih object) {
        long l10;
        long l11;
        boolean bl2;
        Object object2;
        Constable constable = this.getClass();
        int n10 = constable.equals(object2 = object.getClass());
        if (!n10) {
            constable = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)((Object)constable)).compareTo((String)object);
        }
        constable = this.a();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ih)object).a())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.a() ? 1 : 0);
        if (n10 && (n10 = iy.a((Comparable)((Object)(constable = this.a)), object2 = ((ih)object).a))) {
            return n10;
        }
        constable = this.b();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ih)object).b())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.b() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((ih)object).a)))) {
            return n10;
        }
        constable = this.c();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ih)object).c())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.c() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((ih)object).b)))) {
            return n10;
        }
        constable = this.d();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ih)object).d())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.d() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((ih)object).c)))) {
            return n10;
        }
        constable = this.e();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ih)object).e())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.e() ? 1 : 0);
        if (n10 && (n10 = iy.a(l11 = this.a, l10 = ((ih)object).a))) {
            return n10;
        }
        constable = this.f();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ih)object).f())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.f() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((ih)object).d)))) {
            return n10;
        }
        constable = this.g();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ih)object).g())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.g() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((ih)object).e)))) {
            return n10;
        }
        constable = this.h();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ih)object).h())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.h() ? 1 : 0);
        if (n10 && (n10 = iy.a((List)((Object)(constable = this.a)), (List)(object2 = ((ih)object).a)))) {
            return n10;
        }
        constable = this.i();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ih)object).i())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.i() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.f)), (String)(object2 = ((ih)object).f)))) {
            return n10;
        }
        constable = this.j();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ih)object).j())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.j() ? 1 : 0);
        if (n10) {
            n10 = (int)(this.a ? 1 : 0);
            int n11 = ((ih)object).a;
            if ((n11 = iy.a(n10 != 0, n11 != 0)) != 0) {
                return n11;
            }
        }
        return 0;
    }

    public String a() {
        return this.c;
    }

    public List a() {
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
    public void a(ji object) {
        ((ji)object).a();
        while (true) {
            block16: {
                ArrayList arrayList;
                Object object2 = ((ji)object).a();
                int n10 = ((jf)object2).a;
                if (n10 == 0) {
                    ((ji)object).f();
                    boolean bl2 = this.e();
                    if (bl2) {
                        this.a();
                        return;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Required field 'errorCode' was not found in serialized data! Struct: ");
                    arrayList = this.toString();
                    ((StringBuilder)object2).append((String)((Object)arrayList));
                    object2 = ((StringBuilder)object2).toString();
                    object = new jj((String)object2);
                    throw object;
                }
                int n11 = ((jf)object2).a;
                int n12 = 1;
                int n13 = 11;
                switch (n11) {
                    case 13: {
                        n11 = 2;
                        if (n10 != n11) break;
                        n11 = (int)(((ji)object).a() ? 1 : 0);
                        this.a = n11;
                        this.b(n12 != 0);
                        break block16;
                    }
                    case 12: {
                        if (n10 != n13) break;
                        this.f = object2 = ((ji)object).a();
                        break block16;
                    }
                    case 10: {
                        n11 = 15;
                        if (n10 != n11) break;
                        object2 = ((ji)object).a();
                        n12 = ((jg)object2).a;
                        this.a = arrayList = new ArrayList(n12);
                        arrayList = null;
                        for (n10 = 0; n10 < (n12 = ((jg)object2).a); ++n10) {
                            String string2 = ((ji)object).a();
                            List list = this.a;
                            list.add(string2);
                        }
                        ((ji)object).i();
                        break block16;
                    }
                    case 9: {
                        if (n10 != n13) break;
                        this.e = object2 = ((ji)object).a();
                        break block16;
                    }
                    case 8: {
                        if (n10 != n13) break;
                        this.d = object2 = ((ji)object).a();
                        break block16;
                    }
                    case 7: {
                        long l10;
                        n11 = 10;
                        if (n10 != n11) break;
                        this.a = l10 = ((ji)object).a();
                        this.a(n12 != 0);
                        break block16;
                    }
                    case 5: {
                        if (n10 != n13) break;
                        this.c = object2 = ((ji)object).a();
                        break block16;
                    }
                    case 4: {
                        if (n10 != n13) break;
                        this.b = object2 = ((ji)object).a();
                        break block16;
                    }
                    case 3: {
                        if (n10 != n13) break;
                        this.a = object2 = ((ji)object).a();
                        break block16;
                    }
                    case 2: {
                        n11 = 12;
                        if (n10 != n11) break;
                        this.a = object2 = new ib();
                        ((ib)object2).a((ji)object);
                        break block16;
                    }
                }
                jl.a((ji)object, (byte)n10);
            }
            ((ji)object).g();
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
    public boolean a(ih ih2) {
        long l10;
        long l11;
        long l12;
        Object object;
        Object object2;
        if (ih2 == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = ih2.a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.a;
            object = ih2.a;
            bl2 = ((ib)object2).a((ib)object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.b();
        bl3 = ih2.b();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.a;
            object = ih2.a;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.c();
        bl3 = ih2.c();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.b;
            object = ih2.b;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.d();
        bl3 = ih2.d();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.c;
            object = ih2.c;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        if (bl2 = (l12 = (l11 = this.a) - (l10 = ih2.a)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) {
            return false;
        }
        bl2 = this.f();
        bl3 = ih2.f();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.d;
            object = ih2.d;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.g();
        bl3 = ih2.g();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.e;
            object = ih2.e;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.h();
        bl3 = ih2.h();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.a;
            object = ih2.a;
            bl2 = object2.equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.i();
        bl3 = ih2.i();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.f;
            object = ih2.f;
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.j();
        bl3 = ih2.j();
        if (!bl2 && !bl3) return true;
        if (!bl2 || !bl3) return false;
        bl2 = this.a;
        boolean bl4 = ih2.a;
        if (bl2 == bl4) return true;
        return false;
    }

    public String b() {
        return this.f;
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
        iterator2 = e;
        ji2.a((jf)((Object)iterator2));
        long l10 = this.a;
        ji2.a(l10);
        ji2.b();
        iterator2 = this.d;
        if (iterator2 != null && (bl2 = this.f())) {
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
        if ((iterator2 = this.a) != null && (bl2 = this.h())) {
            iterator2 = h;
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
        if ((iterator2 = this.f) != null && (bl2 = this.i())) {
            iterator2 = i;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.f;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if (bl2 = this.j()) {
            iterator2 = j;
            ji2.a((jf)((Object)iterator2));
            bl2 = this.a;
            ji2.a(bl2);
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
        object = (ih)object;
        return this.a((ih)object);
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
        boolean bl2 = object instanceof ih;
        if (bl2) {
            object = (ih)object;
            return this.a((ih)object);
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
        List list = this.a;
        if (list != null) {
            bl2 = true;
        } else {
            bl2 = false;
            list = null;
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
        return this.a.get(1);
    }

    public String toString() {
        Object object = "XmPushActionCommandResult(";
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
            stringBuilder.append("cmdArgs:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        }
        if (bl2 = this.i()) {
            stringBuilder.append(string3);
            stringBuilder.append("category:");
            object = this.f;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.j()) {
            stringBuilder.append(string3);
            object = "response2Client:";
            stringBuilder.append((String)object);
            bl2 = this.a;
            stringBuilder.append(bl2);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

