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
public class in
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
    public int a;
    public long a;
    public ib a;
    public String a;
    private BitSet a;
    public int b;
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
        Object object = new jn("XmPushActionRegistrationResult");
        a = object;
        String string2 = "";
        byte by2 = 11;
        a = object = new jf(string2, by2, 1);
        byte by3 = 12;
        b = object = new jf(string2, by3, 2);
        c = object = new jf(string2, by2, 3);
        d = object = new jf(string2, by2, 4);
        byte by4 = 10;
        e = object = new jf(string2, by4, 6);
        f = object = new jf(string2, by2, 7);
        byte by5 = 8;
        g = object = new jf(string2, by2, by5);
        h = object = new jf(string2, by2, 9);
        i = object = new jf(string2, by2, by4);
        j = object = new jf(string2, by4, by2);
        k = object = new jf(string2, by2, by3);
        l = object = new jf(string2, by2, 13);
        m = object = new jf(string2, by4, 14);
        n = object = new jf(string2, by2, 15);
        o = object = new jf(string2, by5, 16);
        p = object = new jf(string2, by2, 17);
        q = object = new jf(string2, by5, 18);
        r = object = new jf(string2, by2, 19);
    }

    public in() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(5);
    }

    public int a(in object) {
        int n10;
        long l10;
        long l11;
        int n11;
        Object object2;
        Constable constable = this.getClass();
        int n12 = constable.equals(object2 = object.getClass());
        if (n12 == 0) {
            constable = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)((Object)constable)).compareTo((String)object);
        }
        constable = this.a();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).a()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.a() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((in)object).a))) != 0) {
            return n12;
        }
        constable = this.b();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).b()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.b() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((in)object).a))) != 0) {
            return n12;
        }
        constable = this.c();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).c()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.c() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((in)object).b))) != 0) {
            return n12;
        }
        constable = this.d();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).d()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.d() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((in)object).c))) != 0) {
            return n12;
        }
        constable = this.e();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).e()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.e() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a(l11 = this.a, l10 = ((in)object).a)) != 0) {
            return n12;
        }
        constable = this.f();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).f()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.f() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((in)object).d))) != 0) {
            return n12;
        }
        constable = this.g();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).g()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.g() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((in)object).e))) != 0) {
            return n12;
        }
        constable = this.h();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).h()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.h() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.f)), (String)(object2 = ((in)object).f))) != 0) {
            return n12;
        }
        constable = this.i();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).i()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.i() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.g)), (String)(object2 = ((in)object).g))) != 0) {
            return n12;
        }
        constable = this.j();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).j()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.j() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a(l11 = this.b, l10 = ((in)object).b)) != 0) {
            return n12;
        }
        constable = this.k();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).k()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.k() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.h)), (String)(object2 = ((in)object).h))) != 0) {
            return n12;
        }
        constable = this.l();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).l()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.l() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.i)), (String)(object2 = ((in)object).i))) != 0) {
            return n12;
        }
        constable = this.m();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).m()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.m() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a(l11 = this.c, l10 = ((in)object).c)) != 0) {
            return n12;
        }
        constable = this.n();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).n()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.n() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.j)), (String)(object2 = ((in)object).j))) != 0) {
            return n12;
        }
        constable = this.o();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).o()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.o() ? 1 : 0);
        if (n12 != 0) {
            n12 = this.a;
            n11 = ((in)object).a;
            if ((n12 = iy.a(n12, n11)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(constable = Boolean.valueOf(this.p()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = (int)(((in)object).p() ? 1 : 0)) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.p() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.k)), (String)(object2 = ((in)object).k))) != 0) {
            return n12;
        }
        constable = this.q();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((in)object).q()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.q() ? 1 : 0);
        if (n12 != 0) {
            n12 = this.b;
            n11 = ((in)object).b;
            if ((n12 = iy.a(n12, n11)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(constable = Boolean.valueOf(this.r()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = (int)(((in)object).r() ? 1 : 0)) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.r() ? 1 : 0);
        if (n12 != 0 && (n10 = iy.a((String)((Object)(constable = this.l)), (String)(object = ((in)object).l))) != 0) {
            return n10;
        }
        return 0;
    }

    public long a() {
        return this.a;
    }

    public String a() {
        return this.b;
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
            block23: {
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
                    String string2 = this.toString();
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    object = new jj((String)object2);
                    throw object;
                }
                int n11 = ((jf)object2).a;
                int n12 = 8;
                int n13 = 10;
                boolean bl3 = true;
                int n14 = 11;
                switch (n11) {
                    case 19: {
                        if (n10 != n14) break;
                        this.l = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 18: {
                        if (n10 != n12) break;
                        this.b = n11 = ((ji)object).a();
                        this.e(bl3);
                        break block23;
                    }
                    case 17: {
                        if (n10 != n14) break;
                        this.k = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 16: {
                        if (n10 != n12) break;
                        this.a = n11 = ((ji)object).a();
                        this.d(bl3);
                        break block23;
                    }
                    case 15: {
                        if (n10 != n14) break;
                        this.j = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 14: {
                        long l10;
                        if (n10 != n13) break;
                        this.c = l10 = ((ji)object).a();
                        this.c(bl3);
                        break block23;
                    }
                    case 13: {
                        if (n10 != n14) break;
                        this.i = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 12: {
                        if (n10 != n14) break;
                        this.h = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 11: {
                        long l10;
                        if (n10 != n13) break;
                        this.b = l10 = ((ji)object).a();
                        this.b(bl3);
                        break block23;
                    }
                    case 10: {
                        if (n10 != n14) break;
                        this.g = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 9: {
                        if (n10 != n14) break;
                        this.f = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 8: {
                        if (n10 != n14) break;
                        this.e = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 7: {
                        if (n10 != n14) break;
                        this.d = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 6: {
                        long l10;
                        if (n10 != n13) break;
                        this.a = l10 = ((ji)object).a();
                        this.a(bl3);
                        break block23;
                    }
                    case 4: {
                        if (n10 != n14) break;
                        this.c = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 3: {
                        if (n10 != n14) break;
                        this.b = object2 = ((ji)object).a();
                        break block23;
                    }
                    case 2: {
                        n11 = 12;
                        if (n10 != n11) break;
                        this.a = object2 = new ib();
                        ((ib)object2).a((ji)object);
                        break block23;
                    }
                    case 1: {
                        if (n10 != n14) break;
                        this.a = object2 = ((ji)object).a();
                        break block23;
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
    public boolean a(in object) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2;
        Object object3;
        if (object == null) {
            return false;
        }
        boolean bl2 = this.a();
        int n10 = ((in)object).a();
        if (bl2 || n10 != 0) {
            if (!bl2 || n10 == 0) return false;
            object3 = this.a;
            object2 = ((in)object).a;
            boolean bl3 = ((String)object3).equals(object2);
            if (!bl3) {
                return false;
            }
        }
        boolean bl4 = this.b();
        n10 = ((in)object).b();
        if (bl4 || n10 != 0) {
            if (!bl4 || n10 == 0) return false;
            object3 = this.a;
            object2 = ((in)object).a;
            boolean bl5 = ((ib)object3).a((ib)object2);
            if (!bl5) {
                return false;
            }
        }
        boolean bl6 = this.c();
        n10 = ((in)object).c();
        if (bl6 || n10 != 0) {
            if (!bl6 || n10 == 0) return false;
            object3 = this.b;
            object2 = ((in)object).b;
            boolean bl7 = ((String)object3).equals(object2);
            if (!bl7) {
                return false;
            }
        }
        boolean bl8 = this.d();
        n10 = ((in)object).d();
        if (bl8 || n10 != 0) {
            if (!bl8 || n10 == 0) return false;
            object3 = this.c;
            object2 = ((in)object).c;
            boolean bl9 = ((String)object3).equals(object2);
            if (!bl9) {
                return false;
            }
        }
        if ((l13 = (l12 = (l11 = this.a) - (l10 = ((in)object).a)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            return false;
        }
        boolean bl10 = this.f();
        n10 = ((in)object).f();
        if (bl10 || n10 != 0) {
            if (!bl10 || n10 == 0) return false;
            object3 = this.d;
            object2 = ((in)object).d;
            boolean bl11 = ((String)object3).equals(object2);
            if (!bl11) {
                return false;
            }
        }
        boolean bl12 = this.g();
        n10 = ((in)object).g();
        if (bl12 || n10 != 0) {
            if (!bl12 || n10 == 0) return false;
            object3 = this.e;
            object2 = ((in)object).e;
            boolean bl13 = ((String)object3).equals(object2);
            if (!bl13) {
                return false;
            }
        }
        boolean bl14 = this.h();
        n10 = ((in)object).h();
        if (bl14 || n10 != 0) {
            if (!bl14 || n10 == 0) return false;
            object3 = this.f;
            object2 = ((in)object).f;
            boolean bl15 = ((String)object3).equals(object2);
            if (!bl15) {
                return false;
            }
        }
        boolean bl16 = this.i();
        n10 = ((in)object).i();
        if (bl16 || n10 != 0) {
            if (!bl16 || n10 == 0) return false;
            object3 = this.g;
            object2 = ((in)object).g;
            boolean bl17 = ((String)object3).equals(object2);
            if (!bl17) {
                return false;
            }
        }
        boolean bl18 = this.j();
        n10 = ((in)object).j();
        if (bl18 || n10 != 0) {
            if (!bl18 || n10 == 0) return false;
            l11 = this.b;
            l10 = ((in)object).b;
            long l14 = l11 - l10;
            Object object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object4 != false) {
                return false;
            }
        }
        boolean bl19 = this.k();
        n10 = ((in)object).k();
        if (bl19 || n10 != 0) {
            if (!bl19 || n10 == 0) return false;
            object3 = this.h;
            object2 = ((in)object).h;
            boolean bl20 = ((String)object3).equals(object2);
            if (!bl20) {
                return false;
            }
        }
        boolean bl21 = this.l();
        n10 = ((in)object).l();
        if (bl21 || n10 != 0) {
            if (!bl21 || n10 == 0) return false;
            object3 = this.i;
            object2 = ((in)object).i;
            boolean bl22 = ((String)object3).equals(object2);
            if (!bl22) {
                return false;
            }
        }
        boolean bl23 = this.m();
        n10 = ((in)object).m();
        if (bl23 || n10 != 0) {
            if (!bl23 || n10 == 0) return false;
            l11 = this.c;
            l10 = ((in)object).c;
            long l15 = l11 - l10;
            Object object5 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object5 != false) {
                return false;
            }
        }
        boolean bl24 = this.n();
        n10 = ((in)object).n();
        if (bl24 || n10 != 0) {
            if (!bl24 || n10 == 0) return false;
            object3 = this.j;
            object2 = ((in)object).j;
            boolean bl25 = ((String)object3).equals(object2);
            if (!bl25) {
                return false;
            }
        }
        boolean bl26 = this.o();
        n10 = ((in)object).o();
        if (bl26 || n10 != 0) {
            if (!bl26 || n10 == 0) return false;
            int n11 = this.a;
            n10 = ((in)object).a;
            if (n11 != n10) {
                return false;
            }
        }
        boolean bl27 = this.p();
        n10 = ((in)object).p();
        if (bl27 || n10 != 0) {
            if (!bl27 || n10 == 0) return false;
            object3 = this.k;
            object2 = ((in)object).k;
            boolean bl28 = ((String)object3).equals(object2);
            if (!bl28) {
                return false;
            }
        }
        boolean bl29 = this.q();
        n10 = (int)(((in)object).q() ? 1 : 0);
        if (bl29 || n10 != 0) {
            if (!bl29 || n10 == 0) return false;
            int n12 = this.b;
            n10 = ((in)object).b;
            if (n12 != n10) {
                return false;
            }
        }
        boolean bl30 = this.r();
        n10 = (int)(((in)object).r() ? 1 : 0);
        if (!bl30 && n10 == 0) return true;
        if (!bl30 || n10 == 0) return false;
        object3 = this.l;
        object = ((in)object).l;
        boolean bl31 = ((String)object3).equals(object);
        if (bl31) return true;
        return false;
    }

    public String b() {
        return this.g;
    }

    public void b(ji ji2) {
        int n10;
        this.a();
        Object object = a;
        ji2.a((jn)object);
        object = this.a;
        if (object != null && (n10 = this.a()) != 0) {
            object = a;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.a) != null && (n10 = this.b()) != 0) {
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
        if (object != null && (n10 = this.f()) != 0) {
            object = f;
            ji2.a((jf)object);
            object = this.d;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.e) != null && (n10 = this.g()) != 0) {
            object = g;
            ji2.a((jf)object);
            object = this.e;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.f) != null && (n10 = this.h()) != 0) {
            object = h;
            ji2.a((jf)object);
            object = this.f;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.g) != null && (n10 = this.i()) != 0) {
            object = i;
            ji2.a((jf)object);
            object = this.g;
            ji2.a((String)object);
            ji2.b();
        }
        if ((n10 = this.j()) != 0) {
            object = j;
            ji2.a((jf)object);
            l10 = this.b;
            ji2.a(l10);
            ji2.b();
        }
        if ((object = this.h) != null && (n10 = this.k()) != 0) {
            object = k;
            ji2.a((jf)object);
            object = this.h;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.i) != null && (n10 = this.l()) != 0) {
            object = l;
            ji2.a((jf)object);
            object = this.i;
            ji2.a((String)object);
            ji2.b();
        }
        if ((n10 = this.m()) != 0) {
            object = m;
            ji2.a((jf)object);
            l10 = this.c;
            ji2.a(l10);
            ji2.b();
        }
        if ((object = this.j) != null && (n10 = this.n()) != 0) {
            object = n;
            ji2.a((jf)object);
            object = this.j;
            ji2.a((String)object);
            ji2.b();
        }
        if ((n10 = this.o()) != 0) {
            object = o;
            ji2.a((jf)object);
            n10 = this.a;
            ji2.a(n10);
            ji2.b();
        }
        if ((object = this.k) != null && (n10 = (int)(this.p() ? 1 : 0)) != 0) {
            object = p;
            ji2.a((jf)object);
            object = this.k;
            ji2.a((String)object);
            ji2.b();
        }
        if ((n10 = (int)(this.q() ? 1 : 0)) != 0) {
            object = q;
            ji2.a((jf)object);
            n10 = this.b;
            ji2.a(n10);
            ji2.b();
        }
        if ((object = this.l) != null && (n10 = (int)(this.r() ? 1 : 0)) != 0) {
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
        object = (in)object;
        return this.a((in)object);
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

    public void e(boolean bl2) {
        this.a.set(4, bl2);
    }

    public boolean e() {
        return this.a.get(0);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof in;
        if (bl2) {
            object = (in)object;
            return this.a((in)object);
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

    public boolean j() {
        return this.a.get(1);
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
        String string2 = this.i;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean m() {
        return this.a.get(2);
    }

    public boolean n() {
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

    public boolean o() {
        return this.a.get(3);
    }

    public boolean p() {
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

    public boolean q() {
        return this.a.get(4);
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
        Object object = "XmPushActionRegistrationResult(";
        StringBuilder stringBuilder = new StringBuilder((String)object);
        int n10 = this.a();
        int n11 = 0;
        String string2 = "null";
        if (n10 != 0) {
            stringBuilder.append("debug:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
            n10 = 0;
            object = null;
        } else {
            n10 = 1;
        }
        boolean bl2 = this.b();
        String string3 = ", ";
        if (bl2) {
            if (n10 == 0) {
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
            n11 = n10;
        }
        if (n11 == 0) {
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
        n10 = this.f();
        if (n10 != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("reason:");
            object = this.d;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.g()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("regId:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.h()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("regSecret:");
            object = this.f;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.i()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("packageName:");
            object = this.g;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.j()) != 0) {
            stringBuilder.append(string3);
            object = "registeredAt:";
            stringBuilder.append((String)object);
            l10 = this.b;
            stringBuilder.append(l10);
        }
        if ((n10 = this.k()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("aliasName:");
            object = this.h;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.l()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("clientId:");
            object = this.i;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.m()) != 0) {
            stringBuilder.append(string3);
            object = "costTime:";
            stringBuilder.append((String)object);
            l10 = this.c;
            stringBuilder.append(l10);
        }
        if ((n10 = this.n()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("appVersion:");
            object = this.j;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.o()) != 0) {
            stringBuilder.append(string3);
            object = "pushSdkVersionCode:";
            stringBuilder.append((String)object);
            n10 = this.a;
            stringBuilder.append(n10);
        }
        if ((n10 = this.p()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("hybridPushEndpoint:");
            object = this.k;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.q()) != 0) {
            stringBuilder.append(string3);
            object = "appVersionCode:";
            stringBuilder.append((String)object);
            n10 = this.b;
            stringBuilder.append(n10);
        }
        if ((n10 = (int)(this.r() ? 1 : 0)) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("region:");
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

