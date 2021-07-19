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
import java.util.Iterator;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class iu
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
    public ib a;
    public String a;
    public List a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    static {
        Object object = new jn("XmPushActionUnSubscription");
        a = object;
        String string2 = "";
        byte by2 = 11;
        a = object = new jf(string2, by2, 1);
        b = object = new jf(string2, 12, 2);
        c = object = new jf(string2, by2, 3);
        d = object = new jf(string2, by2, 4);
        e = object = new jf(string2, by2, 5);
        f = object = new jf(string2, by2, 6);
        g = object = new jf(string2, by2, 7);
        h = object = new jf(string2, 15, 8);
    }

    public int a(iu object) {
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
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((iu)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((iu)object).a))) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((iu)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((iu)object).a))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((iu)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((iu)object).b))) != 0) {
            return n11;
        }
        constable = this.d();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((iu)object).d())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((iu)object).c))) != 0) {
            return n11;
        }
        constable = this.e();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((iu)object).e())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((iu)object).d))) != 0) {
            return n11;
        }
        constable = this.f();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((iu)object).f())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((iu)object).e))) != 0) {
            return n11;
        }
        constable = this.g();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((iu)object).g())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.g() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.f)), (String)(object2 = ((iu)object).f))) != 0) {
            return n11;
        }
        constable = this.h();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((iu)object).h())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((List)((Object)(constable = this.a)), (List)(object = ((iu)object).a))) != 0) {
            return n10;
        }
        return 0;
    }

    public iu a(String string2) {
        this.b = string2;
        return this;
    }

    public void a() {
        Object object = this.b;
        if (object != null) {
            object = this.c;
            if (object != null) {
                object = this.d;
                if (object != null) {
                    return;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Required field 'topic' was not present! Struct: ");
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
            block13: {
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
                    case 8: {
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
                        break block13;
                    }
                    case 7: {
                        if (n10 != n12) break;
                        this.f = object = ji2.a();
                        break block13;
                    }
                    case 6: {
                        if (n10 != n12) break;
                        this.e = object = ji2.a();
                        break block13;
                    }
                    case 5: {
                        if (n10 != n12) break;
                        this.d = object = ji2.a();
                        break block13;
                    }
                    case 4: {
                        if (n10 != n12) break;
                        this.c = object = ji2.a();
                        break block13;
                    }
                    case 3: {
                        if (n10 != n12) break;
                        this.b = object = ji2.a();
                        break block13;
                    }
                    case 2: {
                        n11 = 12;
                        if (n10 != n11) break;
                        this.a = object = new ib();
                        ((ib)object).a(ji2);
                        break block13;
                    }
                    case 1: {
                        if (n10 != n12) break;
                        this.a = object = ji2.a();
                        break block13;
                    }
                }
                jl.a(ji2, (byte)n10);
            }
            ji2.g();
        }
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
    public boolean a(iu object) {
        Object object2;
        Object object3;
        if (object == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = ((iu)object).a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.a;
            object2 = ((iu)object).a;
            bl2 = ((String)object3).equals(object2);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.b();
        bl3 = ((iu)object).b();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.a;
            object2 = ((iu)object).a;
            bl2 = ((ib)object3).a((ib)object2);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.c();
        bl3 = ((iu)object).c();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.b;
            object2 = ((iu)object).b;
            bl2 = ((String)object3).equals(object2);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.d();
        bl3 = ((iu)object).d();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.c;
            object2 = ((iu)object).c;
            bl2 = ((String)object3).equals(object2);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.e();
        bl3 = ((iu)object).e();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.d;
            object2 = ((iu)object).d;
            bl2 = ((String)object3).equals(object2);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.f();
        bl3 = ((iu)object).f();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.e;
            object2 = ((iu)object).e;
            bl2 = ((String)object3).equals(object2);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.g();
        bl3 = ((iu)object).g();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object3 = this.f;
            object2 = ((iu)object).f;
            bl2 = ((String)object3).equals(object2);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.h();
        bl3 = ((iu)object).h();
        if (!bl2 && !bl3) return true;
        if (!bl2 || !bl3) return false;
        object3 = this.a;
        object = ((iu)object).a;
        boolean bl4 = object3.equals(object);
        if (bl4) return true;
        return false;
    }

    public iu b(String string2) {
        this.c = string2;
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
        if ((iterator2 = this.c) != null) {
            iterator2 = d;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.c;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.d) != null) {
            iterator2 = e;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.d;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.e) != null && (bl2 = this.f())) {
            iterator2 = f;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.e;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.f) != null && (bl2 = this.g())) {
            iterator2 = g;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.f;
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

    public iu c(String string2) {
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
        object = (iu)object;
        return this.a((iu)object);
    }

    public iu d(String string2) {
        this.e = string2;
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

    public iu e(String string2) {
        this.f = string2;
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
        boolean bl2 = object instanceof iu;
        if (bl2) {
            object = (iu)object;
            return this.a((iu)object);
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

    public String toString() {
        Object object = "XmPushActionUnSubscription(";
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
        stringBuilder.append("topic:");
        object = this.d;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        bl2 = this.f();
        if (bl2) {
            stringBuilder.append(string3);
            stringBuilder.append("packageName:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.g()) {
            stringBuilder.append(string3);
            stringBuilder.append("category:");
            object = this.f;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.h()) {
            stringBuilder.append(string3);
            stringBuilder.append("aliases:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

