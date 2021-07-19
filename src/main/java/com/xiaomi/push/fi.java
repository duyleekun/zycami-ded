/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

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
public class fi
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
    public byte a;
    public int a;
    public String a;
    private BitSet a;
    public int b;
    public String b;
    public int c;
    public String c;
    public int d;
    public String d;
    public int e;

    static {
        Object object = new jn("StatsEvent");
        a = object;
        String string2 = "";
        byte by2 = 3;
        a = object = new jf(string2, by2, 1);
        byte by3 = 8;
        b = object = new jf(string2, by3, 2);
        c = object = new jf(string2, by3, by2);
        by2 = 11;
        d = object = new jf(string2, by2, 4);
        e = object = new jf(string2, by2, 5);
        f = object = new jf(string2, by3, 6);
        g = object = new jf(string2, by2, 7);
        h = object = new jf(string2, by2, by3);
        i = object = new jf(string2, by3, 9);
        j = object = new jf(string2, by3, 10);
    }

    public fi() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(6);
    }

    public int a(fi object) {
        byte by2;
        Object object2;
        Constable constable = this.getClass();
        int n10 = constable.equals(object2 = object.getClass());
        if (n10 == 0) {
            constable = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)((Object)constable)).compareTo((String)object);
        }
        constable = this.a();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((by2 = ((fi)object).a()) != 0)));
        if (n10 != 0) {
            return n10;
        }
        n10 = (int)(this.a() ? 1 : 0);
        if (n10 != 0) {
            n10 = this.a;
            by2 = ((fi)object).a;
            if ((n10 = iy.a((byte)n10, by2)) != 0) {
                return n10;
            }
        }
        if ((n10 = ((Boolean)(constable = Boolean.valueOf(this.b()))).compareTo((Boolean)(object2 = Boolean.valueOf((by2 = (byte)(((fi)object).b() ? 1 : 0)) != 0)))) != 0) {
            return n10;
        }
        n10 = (int)(this.b() ? 1 : 0);
        if (n10 != 0) {
            n10 = this.a;
            by2 = (byte)((fi)object).a;
            if ((n10 = iy.a(n10, (int)by2)) != 0) {
                return n10;
            }
        }
        if ((n10 = ((Boolean)(constable = Boolean.valueOf(this.c()))).compareTo((Boolean)(object2 = Boolean.valueOf((by2 = (byte)(((fi)object).c() ? 1 : 0)) != 0)))) != 0) {
            return n10;
        }
        n10 = (int)(this.c() ? 1 : 0);
        if (n10 != 0) {
            n10 = this.b;
            by2 = (byte)((fi)object).b;
            if ((n10 = iy.a(n10, (int)by2)) != 0) {
                return n10;
            }
        }
        if ((n10 = ((Boolean)(constable = Boolean.valueOf(this.d()))).compareTo((Boolean)(object2 = Boolean.valueOf((by2 = (byte)(((fi)object).d() ? 1 : 0)) != 0)))) != 0) {
            return n10;
        }
        n10 = (int)(this.d() ? 1 : 0);
        if (n10 != 0 && (n10 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((fi)object).a))) != 0) {
            return n10;
        }
        constable = this.e();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((by2 = ((fi)object).e()) != 0)));
        if (n10 != 0) {
            return n10;
        }
        n10 = (int)(this.e() ? 1 : 0);
        if (n10 != 0 && (n10 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((fi)object).b))) != 0) {
            return n10;
        }
        constable = this.f();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((by2 = ((fi)object).f()) != 0)));
        if (n10 != 0) {
            return n10;
        }
        n10 = (int)(this.f() ? 1 : 0);
        if (n10 != 0) {
            n10 = this.c;
            by2 = (byte)((fi)object).c;
            if ((n10 = iy.a(n10, (int)by2)) != 0) {
                return n10;
            }
        }
        if ((n10 = ((Boolean)(constable = Boolean.valueOf(this.g()))).compareTo((Boolean)(object2 = Boolean.valueOf((by2 = (byte)(((fi)object).g() ? 1 : 0)) != 0)))) != 0) {
            return n10;
        }
        n10 = (int)(this.g() ? 1 : 0);
        if (n10 != 0 && (n10 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((fi)object).c))) != 0) {
            return n10;
        }
        constable = this.h();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((by2 = ((fi)object).h()) != 0)));
        if (n10 != 0) {
            return n10;
        }
        n10 = (int)(this.h() ? 1 : 0);
        if (n10 != 0 && (n10 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((fi)object).d))) != 0) {
            return n10;
        }
        constable = this.i();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((by2 = ((fi)object).i()) != 0)));
        if (n10 != 0) {
            return n10;
        }
        n10 = (int)(this.i() ? 1 : 0);
        if (n10 != 0) {
            n10 = this.d;
            by2 = (byte)((fi)object).d;
            if ((n10 = iy.a(n10, (int)by2)) != 0) {
                return n10;
            }
        }
        if ((n10 = ((Boolean)(constable = Boolean.valueOf(this.j()))).compareTo((Boolean)(object2 = Boolean.valueOf((by2 = (byte)(((fi)object).j() ? 1 : 0)) != 0)))) != 0) {
            return n10;
        }
        n10 = (int)(this.j() ? 1 : 0);
        if (n10 != 0) {
            n10 = this.e;
            int n11 = ((fi)object).e;
            if ((n11 = iy.a(n10, n11)) != 0) {
                return n11;
            }
        }
        return 0;
    }

    public fi a(byte by2) {
        this.a = by2;
        this.a(true);
        return this;
    }

    public fi a(int n10) {
        this.a = n10;
        this.b(true);
        return this;
    }

    public fi a(String string2) {
        this.a = string2;
        return this;
    }

    public void a() {
        Object object = this.a;
        if (object != null) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'connpt' was not present! Struct: ");
        String string2 = this.toString();
        charSequence.append(string2);
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
            block17: {
                Object object2 = ((ji)object).a();
                int n10 = ((jf)object2).a;
                if (n10 == 0) {
                    ((ji)object).f();
                    boolean bl2 = this.a();
                    if (!bl2) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Required field 'chid' was not found in serialized data! Struct: ");
                        String string2 = this.toString();
                        ((StringBuilder)object2).append(string2);
                        object2 = ((StringBuilder)object2).toString();
                        object = new jj((String)object2);
                        throw object;
                    }
                    bl2 = this.b();
                    if (!bl2) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Required field 'type' was not found in serialized data! Struct: ");
                        String string3 = this.toString();
                        ((StringBuilder)object2).append(string3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new jj((String)object2);
                        throw object;
                    }
                    bl2 = this.c();
                    if (bl2) {
                        this.a();
                        return;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Required field 'value' was not found in serialized data! Struct: ");
                    String string4 = this.toString();
                    ((StringBuilder)object2).append(string4);
                    object2 = ((StringBuilder)object2).toString();
                    object = new jj((String)object2);
                    throw object;
                }
                int n11 = ((jf)object2).a;
                int n12 = 11;
                int n13 = 8;
                boolean bl3 = true;
                switch (n11) {
                    case 10: {
                        if (n10 != n13) break;
                        this.e = n11 = ((ji)object).a();
                        this.f(bl3);
                        break block17;
                    }
                    case 9: {
                        if (n10 != n13) break;
                        this.d = n11 = ((ji)object).a();
                        this.e(bl3);
                        break block17;
                    }
                    case 8: {
                        if (n10 != n12) break;
                        this.d = object2 = ((ji)object).a();
                        break block17;
                    }
                    case 7: {
                        if (n10 != n12) break;
                        this.c = object2 = ((ji)object).a();
                        break block17;
                    }
                    case 6: {
                        if (n10 != n13) break;
                        this.c = n11 = ((ji)object).a();
                        this.d(bl3);
                        break block17;
                    }
                    case 5: {
                        if (n10 != n12) break;
                        this.b = object2 = ((ji)object).a();
                        break block17;
                    }
                    case 4: {
                        if (n10 != n12) break;
                        this.a = object2 = ((ji)object).a();
                        break block17;
                    }
                    case 3: {
                        if (n10 != n13) break;
                        this.b = n11 = ((ji)object).a();
                        this.c(bl3);
                        break block17;
                    }
                    case 2: {
                        if (n10 != n13) break;
                        this.a = n11 = ((ji)object).a();
                        this.b(bl3);
                        break block17;
                    }
                    case 1: {
                        n11 = 3;
                        if (n10 != n11) break;
                        n11 = ((ji)object).a();
                        this.a = (byte)n11;
                        this.a(bl3);
                        break block17;
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
        return this.a.get(0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(fi fi2) {
        String string2;
        String string3;
        if (fi2 == null) {
            return false;
        }
        int n10 = this.a;
        int n11 = fi2.a;
        if (n10 != n11) {
            return false;
        }
        n10 = this.a;
        n11 = fi2.a;
        if (n10 != n11) {
            return false;
        }
        n10 = this.b;
        n11 = fi2.b;
        if (n10 != n11) {
            return false;
        }
        n10 = (int)(this.d() ? 1 : 0);
        n11 = (int)(fi2.d() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            string3 = this.a;
            string2 = fi2.a;
            n10 = (int)(string3.equals(string2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.e() ? 1 : 0);
        n11 = (int)(fi2.e() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            string3 = this.b;
            string2 = fi2.b;
            n10 = (int)(string3.equals(string2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.f() ? 1 : 0);
        n11 = (int)(fi2.f() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.c;
            n11 = fi2.c;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.g() ? 1 : 0);
        n11 = (int)(fi2.g() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            string3 = this.c;
            string2 = fi2.c;
            n10 = (int)(string3.equals(string2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.h() ? 1 : 0);
        n11 = (int)(fi2.h() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            string3 = this.d;
            string2 = fi2.d;
            n10 = (int)(string3.equals(string2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.i() ? 1 : 0);
        n11 = (int)(fi2.i() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.d;
            n11 = fi2.d;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.j() ? 1 : 0);
        n11 = (int)(fi2.j() ? 1 : 0);
        if (n10 == 0 && n11 == 0) return true;
        if (n10 == 0 || n11 == 0) return false;
        n10 = this.e;
        int n12 = fi2.e;
        if (n10 == n12) return true;
        return false;
    }

    public fi b(int n10) {
        this.b = n10;
        this.c(true);
        return this;
    }

    public fi b(String string2) {
        this.b = string2;
        return this;
    }

    public void b(ji ji2) {
        this.a();
        Object object = a;
        ji2.a((jn)object);
        object = a;
        ji2.a((jf)object);
        int n10 = this.a;
        ji2.a((byte)n10);
        ji2.b();
        object = b;
        ji2.a((jf)object);
        n10 = this.a;
        ji2.a(n10);
        ji2.b();
        object = c;
        ji2.a((jf)object);
        n10 = this.b;
        ji2.a(n10);
        ji2.b();
        object = this.a;
        if (object != null) {
            object = d;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.b) != null && (n10 = (int)(this.e() ? 1 : 0)) != 0) {
            object = e;
            ji2.a((jf)object);
            object = this.b;
            ji2.a((String)object);
            ji2.b();
        }
        if ((n10 = (int)(this.f() ? 1 : 0)) != 0) {
            object = f;
            ji2.a((jf)object);
            n10 = this.c;
            ji2.a(n10);
            ji2.b();
        }
        if ((object = this.c) != null && (n10 = (int)(this.g() ? 1 : 0)) != 0) {
            object = g;
            ji2.a((jf)object);
            object = this.c;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.d) != null && (n10 = (int)(this.h() ? 1 : 0)) != 0) {
            object = h;
            ji2.a((jf)object);
            object = this.d;
            ji2.a((String)object);
            ji2.b();
        }
        if ((n10 = (int)(this.i() ? 1 : 0)) != 0) {
            object = i;
            ji2.a((jf)object);
            n10 = this.d;
            ji2.a(n10);
            ji2.b();
        }
        if ((n10 = (int)(this.j() ? 1 : 0)) != 0) {
            object = j;
            ji2.a((jf)object);
            n10 = this.e;
            ji2.a(n10);
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

    public fi c(int n10) {
        this.c = n10;
        this.d(true);
        return this;
    }

    public fi c(String string2) {
        this.c = string2;
        return this;
    }

    public void c(boolean bl2) {
        this.a.set(2, bl2);
    }

    public boolean c() {
        return this.a.get(2);
    }

    public /* synthetic */ int compareTo(Object object) {
        object = (fi)object;
        return this.a((fi)object);
    }

    public fi d(int n10) {
        this.d = n10;
        this.e(true);
        return this;
    }

    public fi d(String string2) {
        this.d = string2;
        return this;
    }

    public void d(boolean bl2) {
        this.a.set(3, bl2);
    }

    public boolean d() {
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

    public void e(boolean bl2) {
        this.a.set(4, bl2);
    }

    public boolean e() {
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

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof fi;
        if (bl2) {
            object = (fi)object;
            return this.a((fi)object);
        }
        return false;
    }

    public void f(boolean bl2) {
        this.a.set(5, bl2);
    }

    public boolean f() {
        return this.a.get(3);
    }

    public boolean g() {
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

    public boolean h() {
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

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.a.get(4);
    }

    public boolean j() {
        return this.a.get(5);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatsEvent(");
        stringBuilder.append("chid:");
        int n10 = this.a;
        stringBuilder.append(n10);
        String string2 = ", ";
        stringBuilder.append(string2);
        stringBuilder.append("type:");
        int n11 = this.a;
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        stringBuilder.append("value:");
        n11 = this.b;
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        stringBuilder.append("connpt:");
        String string3 = this.a;
        String string4 = "null";
        if (string3 == null) {
            stringBuilder.append(string4);
        } else {
            stringBuilder.append(string3);
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0) {
            stringBuilder.append(string2);
            stringBuilder.append("host:");
            string3 = this.b;
            if (string3 == null) {
                stringBuilder.append(string4);
            } else {
                stringBuilder.append(string3);
            }
        }
        if ((n11 = (int)(this.f() ? 1 : 0)) != 0) {
            stringBuilder.append(string2);
            string3 = "subvalue:";
            stringBuilder.append(string3);
            n11 = this.c;
            stringBuilder.append(n11);
        }
        if ((n11 = (int)(this.g() ? 1 : 0)) != 0) {
            stringBuilder.append(string2);
            stringBuilder.append("annotation:");
            string3 = this.c;
            if (string3 == null) {
                stringBuilder.append(string4);
            } else {
                stringBuilder.append(string3);
            }
        }
        if ((n11 = (int)(this.h() ? 1 : 0)) != 0) {
            stringBuilder.append(string2);
            stringBuilder.append("user:");
            string3 = this.d;
            if (string3 == null) {
                stringBuilder.append(string4);
            } else {
                stringBuilder.append(string3);
            }
        }
        if ((n11 = (int)(this.i() ? 1 : 0)) != 0) {
            stringBuilder.append(string2);
            string3 = "time:";
            stringBuilder.append(string3);
            n11 = this.d;
            stringBuilder.append(n11);
        }
        if ((n11 = (int)(this.j() ? 1 : 0)) != 0) {
            stringBuilder.append(string2);
            string2 = "clientIp:";
            stringBuilder.append(string2);
            n10 = this.e;
            stringBuilder.append(n10);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

