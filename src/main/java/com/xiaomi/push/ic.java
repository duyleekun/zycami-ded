/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ib;
import com.xiaomi.push.ip;
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
public class ic
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
    private static final jf s;
    private static final jf t;
    public int a;
    public long a;
    public ib a;
    public ip a;
    public String a;
    private BitSet a;
    public Map a;
    public short a;
    public boolean a;
    public String b;
    public short b;
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
        Object object = new jn("XmPushActionAckMessage");
        a = object;
        String string2 = "";
        byte by2 = 11;
        a = object = new jf(string2, by2, 1);
        byte by3 = 12;
        byte by4 = 2;
        b = object = new jf(string2, by3, by4);
        c = object = new jf(string2, by2, 3);
        d = object = new jf(string2, by2, 4);
        byte by5 = 10;
        e = object = new jf(string2, by5, 5);
        byte by6 = 6;
        f = object = new jf(string2, by2, by6);
        g = object = new jf(string2, by2, 7);
        byte by7 = 8;
        h = object = new jf(string2, by3, by7);
        i = object = new jf(string2, by2, 9);
        j = object = new jf(string2, by2, by5);
        k = object = new jf(string2, by4, by2);
        l = object = new jf(string2, by2, by3);
        by3 = 13;
        m = object = new jf(string2, by2, by3);
        n = object = new jf(string2, by2, 14);
        o = object = new jf(string2, by6, 15);
        p = object = new jf(string2, by6, 16);
        q = object = new jf(string2, by2, 20);
        r = object = new jf(string2, by2, 21);
        s = object = new jf(string2, by7, 22);
        t = object = new jf(string2, by3, 23);
    }

    public ic() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(5);
        this.a = false;
    }

    public int a(ic object) {
        int n10;
        long l10;
        long l11;
        short s10;
        Object object2;
        Constable constable = this.getClass();
        int n11 = constable.equals(object2 = object.getClass());
        if (n11 == 0) {
            constable = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)((Object)constable)).compareTo((String)object);
        }
        constable = this.a();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).a()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((ic)object).a))) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).b()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((ic)object).a))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).c()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((ic)object).b))) != 0) {
            return n11;
        }
        constable = this.d();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).d()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((ic)object).c))) != 0) {
            return n11;
        }
        constable = this.e();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).e()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.a, l10 = ((ic)object).a)) != 0) {
            return n11;
        }
        constable = this.f();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).f()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((ic)object).d))) != 0) {
            return n11;
        }
        constable = this.g();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).g()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.g() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((ic)object).e))) != 0) {
            return n11;
        }
        constable = this.h();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).h()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((ic)object).a))) != 0) {
            return n11;
        }
        constable = this.i();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).i()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.i() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.f)), (String)(object2 = ((ic)object).f))) != 0) {
            return n11;
        }
        constable = this.j();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).j()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.j() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.g)), (String)(object2 = ((ic)object).g))) != 0) {
            return n11;
        }
        constable = this.k();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).k()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.k() ? 1 : 0);
        if (n11 != 0) {
            n11 = (int)(this.a ? 1 : 0);
            s10 = ((ic)object).a;
            if ((n11 = iy.a(n11 != 0, s10 != 0)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable = Boolean.valueOf(this.l()))).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).l()) != 0)))) != 0) {
            return n11;
        }
        n11 = (int)(this.l() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.h)), (String)(object2 = ((ic)object).h))) != 0) {
            return n11;
        }
        constable = this.m();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).m()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.m() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.i)), (String)(object2 = ((ic)object).i))) != 0) {
            return n11;
        }
        constable = this.n();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).n()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.n() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.j)), (String)(object2 = ((ic)object).j))) != 0) {
            return n11;
        }
        constable = this.o();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).o()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.o() ? 1 : 0);
        if (n11 != 0) {
            n11 = this.a;
            s10 = ((ic)object).a;
            if ((n11 = iy.a((short)n11, s10)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable = Boolean.valueOf(this.p()))).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = (short)(((ic)object).p() ? 1 : 0)) != 0)))) != 0) {
            return n11;
        }
        n11 = (int)(this.p() ? 1 : 0);
        if (n11 != 0) {
            n11 = this.b;
            s10 = ((ic)object).b;
            if ((n11 = iy.a((short)n11, s10)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable = Boolean.valueOf(this.q()))).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = (short)(((ic)object).q() ? 1 : 0)) != 0)))) != 0) {
            return n11;
        }
        n11 = (int)(this.q() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.k)), (String)(object2 = ((ic)object).k))) != 0) {
            return n11;
        }
        constable = this.r();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).r()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.r() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.l)), (String)(object2 = ((ic)object).l))) != 0) {
            return n11;
        }
        constable = this.s();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = ((ic)object).s()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.s() ? 1 : 0);
        if (n11 != 0) {
            n11 = this.a;
            s10 = (short)((ic)object).a;
            if ((n11 = iy.a(n11, (int)s10)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable = Boolean.valueOf(this.t()))).compareTo((Boolean)(object2 = Boolean.valueOf((s10 = (short)(((ic)object).t() ? 1 : 0)) != 0)))) != 0) {
            return n11;
        }
        n11 = (int)(this.t() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((Map)((Object)(constable = this.a)), (Map)(object = ((ic)object).a))) != 0) {
            return n10;
        }
        return 0;
    }

    public ic a(long l10) {
        this.a = l10;
        this.a(true);
        return this;
    }

    public ic a(String string2) {
        this.b = string2;
        return this;
    }

    public ic a(short s10) {
        this.a = s10;
        this.c(true);
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
    public void a(ji object) {
        ((ji)object).a();
        while (true) {
            block26: {
                HashMap hashMap;
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
                    ((StringBuilder)object2).append("Required field 'messageTs' was not found in serialized data! Struct: ");
                    hashMap = this.toString();
                    ((StringBuilder)object2).append((String)((Object)hashMap));
                    object2 = ((StringBuilder)object2).toString();
                    object = new jj((String)object2);
                    throw object;
                }
                int n11 = ((jf)object2).a;
                int n12 = 6;
                int n13 = 2;
                int n14 = 12;
                boolean bl3 = true;
                int n15 = 11;
                switch (n11) {
                    case 23: {
                        n11 = 13;
                        if (n10 != n11) break;
                        object2 = ((ji)object).a();
                        n12 = ((jh)object2).a * n13;
                        this.a = hashMap = new HashMap(n12);
                        hashMap = null;
                        for (n10 = 0; n10 < (n12 = ((jh)object2).a); ++n10) {
                            String string2 = ((ji)object).a();
                            String string3 = ((ji)object).a();
                            Map map = this.a;
                            map.put(string2, string3);
                        }
                        ((ji)object).h();
                        break block26;
                    }
                    case 22: {
                        n11 = 8;
                        if (n10 != n11) break;
                        this.a = n11 = ((ji)object).a();
                        this.e(bl3);
                        break block26;
                    }
                    case 21: {
                        if (n10 != n15) break;
                        this.l = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 20: {
                        if (n10 != n15) break;
                        this.k = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 16: {
                        if (n10 != n12) break;
                        n11 = ((ji)object).a();
                        this.b = (short)n11;
                        this.d(bl3);
                        break block26;
                    }
                    case 15: {
                        if (n10 != n12) break;
                        n11 = ((ji)object).a();
                        this.a = (short)n11;
                        this.c(bl3);
                        break block26;
                    }
                    case 14: {
                        if (n10 != n15) break;
                        this.j = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 13: {
                        if (n10 != n15) break;
                        this.i = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 12: {
                        if (n10 != n15) break;
                        this.h = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 11: {
                        if (n10 != n13) break;
                        n11 = (int)(((ji)object).a() ? 1 : 0);
                        this.a = n11;
                        this.b(bl3);
                        break block26;
                    }
                    case 10: {
                        if (n10 != n15) break;
                        this.g = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 9: {
                        if (n10 != n15) break;
                        this.f = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 8: {
                        if (n10 != n14) break;
                        this.a = object2 = new ip();
                        ((ip)object2).a((ji)object);
                        break block26;
                    }
                    case 7: {
                        if (n10 != n15) break;
                        this.e = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 6: {
                        if (n10 != n15) break;
                        this.d = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 5: {
                        long l10;
                        n11 = 10;
                        if (n10 != n11) break;
                        this.a = l10 = ((ji)object).a();
                        this.a(bl3);
                        break block26;
                    }
                    case 4: {
                        if (n10 != n15) break;
                        this.c = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 3: {
                        if (n10 != n15) break;
                        this.b = object2 = ((ji)object).a();
                        break block26;
                    }
                    case 2: {
                        if (n10 != n14) break;
                        this.a = object2 = new ib();
                        ((ib)object2).a((ji)object);
                        break block26;
                    }
                    case 1: {
                        if (n10 != n15) break;
                        this.a = object2 = ((ji)object).a();
                        break block26;
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
    public boolean a(ic object) {
        long l10;
        long l11;
        long l12;
        Object object2;
        Object object3;
        if (object == null) {
            return false;
        }
        int n10 = this.a();
        int n11 = ((ic)object).a();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.a;
            object2 = ((ic)object).a;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.b();
        n11 = ((ic)object).b();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.a;
            object2 = ((ic)object).a;
            n10 = ((ib)object3).a((ib)object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.c();
        n11 = ((ic)object).c();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.b;
            object2 = ((ic)object).b;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.d();
        n11 = ((ic)object).d();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.c;
            object2 = ((ic)object).c;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        if ((n10 = (l12 = (l11 = this.a) - (l10 = ((ic)object).a)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0) {
            return false;
        }
        n10 = this.f();
        n11 = ((ic)object).f();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.d;
            object2 = ((ic)object).d;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.g();
        n11 = ((ic)object).g();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.e;
            object2 = ((ic)object).e;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.h();
        n11 = ((ic)object).h();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.a;
            object2 = ((ic)object).a;
            n10 = ((ip)object3).a((ip)object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.i();
        n11 = ((ic)object).i();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.f;
            object2 = ((ic)object).f;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.j();
        n11 = ((ic)object).j();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.g;
            object2 = ((ic)object).g;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.k();
        n11 = ((ic)object).k();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.a;
            n11 = ((ic)object).a;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = this.l();
        n11 = ((ic)object).l();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.h;
            object2 = ((ic)object).h;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.m();
        n11 = ((ic)object).m();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.i;
            object2 = ((ic)object).i;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.n();
        n11 = ((ic)object).n();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.j;
            object2 = ((ic)object).j;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.o();
        n11 = ((ic)object).o();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.a;
            n11 = ((ic)object).a;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = this.p();
        n11 = ((ic)object).p();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.b;
            n11 = ((ic)object).b;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.q() ? 1 : 0);
        n11 = (int)(((ic)object).q() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.k;
            object2 = ((ic)object).k;
            n10 = (int)(((String)object3).equals(object2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.r() ? 1 : 0);
        n11 = (int)(((ic)object).r() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.l;
            object2 = ((ic)object).l;
            n10 = (int)(((String)object3).equals(object2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.s() ? 1 : 0);
        n11 = (int)(((ic)object).s() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.a;
            n11 = ((ic)object).a;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.t() ? 1 : 0);
        n11 = (int)(((ic)object).t() ? 1 : 0);
        if (n10 == 0 && n11 == 0) return true;
        if (n10 == 0 || n11 == 0) return false;
        object3 = this.a;
        object = ((ic)object).a;
        boolean bl2 = object3.equals(object);
        if (bl2) return true;
        return false;
    }

    public ic b(String string2) {
        this.c = string2;
        return this;
    }

    public void b(ji ji2) {
        int n10;
        this.a();
        Iterator iterator2 = a;
        ji2.a((jn)((Object)iterator2));
        iterator2 = this.a;
        if (iterator2 != null && (n10 = this.a()) != 0) {
            iterator2 = a;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.a;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.a) != null && (n10 = this.b()) != 0) {
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
        iterator2 = e;
        ji2.a((jf)((Object)iterator2));
        long l10 = this.a;
        ji2.a(l10);
        ji2.b();
        iterator2 = this.d;
        if (iterator2 != null && (n10 = this.f()) != 0) {
            iterator2 = f;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.d;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.e) != null && (n10 = this.g()) != 0) {
            iterator2 = g;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.e;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.a) != null && (n10 = this.h()) != 0) {
            iterator2 = h;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.a;
            ((ip)((Object)iterator2)).b(ji2);
            ji2.b();
        }
        if ((iterator2 = this.f) != null && (n10 = this.i()) != 0) {
            iterator2 = i;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.f;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.g) != null && (n10 = this.j()) != 0) {
            iterator2 = j;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.g;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((n10 = this.k()) != 0) {
            iterator2 = k;
            ji2.a((jf)((Object)iterator2));
            n10 = this.a;
            ji2.a(n10 != 0);
            ji2.b();
        }
        if ((iterator2 = this.h) != null && (n10 = this.l()) != 0) {
            iterator2 = l;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.h;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.i) != null && (n10 = this.m()) != 0) {
            iterator2 = m;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.i;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.j) != null && (n10 = this.n()) != 0) {
            iterator2 = n;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.j;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((n10 = this.o()) != 0) {
            iterator2 = o;
            ji2.a((jf)((Object)iterator2));
            n10 = this.a;
            ji2.a((short)n10);
            ji2.b();
        }
        if ((n10 = this.p()) != 0) {
            iterator2 = p;
            ji2.a((jf)((Object)iterator2));
            n10 = this.b;
            ji2.a((short)n10);
            ji2.b();
        }
        if ((iterator2 = this.k) != null && (n10 = (int)(this.q() ? 1 : 0)) != 0) {
            iterator2 = q;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.k;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.l) != null && (n10 = (int)(this.r() ? 1 : 0)) != 0) {
            iterator2 = r;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.l;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((n10 = (int)(this.s() ? 1 : 0)) != 0) {
            iterator2 = s;
            ji2.a((jf)((Object)iterator2));
            n10 = this.a;
            ji2.a(n10);
            ji2.b();
        }
        if ((iterator2 = this.a) != null && (n10 = (int)(this.t() ? 1 : 0)) != 0) {
            iterator2 = t;
            ji2.a((jf)((Object)iterator2));
            Object object = this.a;
            int n11 = object.size();
            byte by2 = 11;
            iterator2 = new Iterator(by2, by2, n11);
            ji2.a((jh)((Object)iterator2));
            iterator2 = this.a.entrySet().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object = iterator2.next();
                String string2 = (String)object.getKey();
                ji2.a(string2);
                object = (String)object.getValue();
                ji2.a((String)object);
            }
            ji2.d();
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

    public ic c(String string2) {
        this.d = string2;
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
        object = (ic)object;
        return this.a((ic)object);
    }

    public ic d(String string2) {
        this.e = string2;
        return this;
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
        boolean bl2 = object instanceof ic;
        if (bl2) {
            object = (ic)object;
            return this.a((ic)object);
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
        ip ip2 = this.a;
        if (ip2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            ip2 = null;
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

    public boolean k() {
        return this.a.get(1);
    }

    public boolean l() {
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

    public boolean m() {
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
        return this.a.get(2);
    }

    public boolean p() {
        return this.a.get(3);
    }

    public boolean q() {
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

    public boolean s() {
        return this.a.get(4);
    }

    public boolean t() {
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

    public String toString() {
        Object object = "XmPushActionAckMessage(";
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
        object = "messageTs:";
        stringBuilder.append((String)object);
        long l10 = this.a;
        stringBuilder.append(l10);
        n10 = this.f();
        if (n10 != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("topic:");
            object = this.d;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.g()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("aliasName:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.h()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("request:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        }
        if ((n10 = this.i()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("packageName:");
            object = this.f;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.j()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("category:");
            object = this.g;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.k()) != 0) {
            stringBuilder.append(string3);
            object = "isOnline:";
            stringBuilder.append((String)object);
            n10 = this.a;
            stringBuilder.append(n10 != 0);
        }
        if ((n10 = this.l()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("regId:");
            object = this.h;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.m()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("callbackUrl:");
            object = this.i;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.n()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("userAccount:");
            object = this.j;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = this.o()) != 0) {
            stringBuilder.append(string3);
            object = "deviceStatus:";
            stringBuilder.append((String)object);
            n10 = this.a;
            stringBuilder.append(n10);
        }
        if ((n10 = this.p()) != 0) {
            stringBuilder.append(string3);
            object = "geoMsgStatus:";
            stringBuilder.append((String)object);
            n10 = this.b;
            stringBuilder.append(n10);
        }
        if ((n10 = this.q()) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("imeiMd5:");
            object = this.k;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = (int)(this.r() ? 1 : 0)) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("deviceId:");
            object = this.l;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if ((n10 = (int)(this.s() ? 1 : 0)) != 0) {
            stringBuilder.append(string3);
            object = "passThrough:";
            stringBuilder.append((String)object);
            n10 = this.a;
            stringBuilder.append(n10);
        }
        if ((n10 = (int)(this.t() ? 1 : 0)) != 0) {
            stringBuilder.append(string3);
            stringBuilder.append("extra:");
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

