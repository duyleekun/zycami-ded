/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.ib;
import com.xiaomi.push.ix;
import com.xiaomi.push.iy;
import com.xiaomi.push.jf;
import com.xiaomi.push.ji;
import com.xiaomi.push.jj;
import com.xiaomi.push.jl;
import com.xiaomi.push.jn;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ii
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
    public hm a;
    public hz a;
    public ib a;
    public String a;
    public ByteBuffer a;
    private BitSet a;
    public boolean a;
    public String b;
    public boolean b;

    static {
        Object object = new jn("XmPushActionContainer");
        a = object;
        String string2 = "";
        byte by2 = 8;
        a = object = new jf(string2, by2, 1);
        byte by3 = 2;
        b = object = new jf(string2, by3, by3);
        c = object = new jf(string2, by3, 3);
        by3 = 11;
        d = object = new jf(string2, by3, 4);
        e = object = new jf(string2, by3, 5);
        f = object = new jf(string2, by3, 6);
        by3 = 12;
        g = object = new jf(string2, by3, 7);
        h = object = new jf(string2, by3, by2);
    }

    public ii() {
        boolean bl2;
        BitSet bitSet;
        this.a = bitSet = new BitSet(2);
        this.a = bl2 = true;
        this.b = bl2;
    }

    public int a(ii object) {
        int n10;
        boolean bl2;
        Object object2;
        Object object3 = this.getClass();
        int n11 = object3.equals(object2 = object.getClass());
        if (n11 == 0) {
            object3 = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)object3).compareTo((String)object);
        }
        object3 = this.a();
        n11 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ii)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)(object3 = this.a), object2 = ((ii)object).a)) != 0) {
            return n11;
        }
        object3 = this.c();
        n11 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ii)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0) {
            n11 = (int)(this.a ? 1 : 0);
            bl2 = ((ii)object).a;
            if ((n11 = iy.a(n11 != 0, bl2)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(object3 = Boolean.valueOf(this.d()))).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ii)object).d())))) != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0) {
            n11 = (int)(this.b ? 1 : 0);
            bl2 = ((ii)object).b;
            if ((n11 = iy.a(n11 != 0, bl2)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(object3 = Boolean.valueOf(this.e()))).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ii)object).e())))) != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)(object3 = this.a), object2 = ((ii)object).a)) != 0) {
            return n11;
        }
        object3 = this.f();
        n11 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ii)object).f())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)(object3 = this.a), object2 = ((ii)object).a)) != 0) {
            return n11;
        }
        object3 = this.g();
        n11 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ii)object).g())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.g() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)(object3 = this.b), object2 = ((ii)object).b)) != 0) {
            return n11;
        }
        object3 = this.h();
        n11 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ii)object).h())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.h() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)(object3 = this.a), object2 = ((ii)object).a)) != 0) {
            return n11;
        }
        object3 = this.i();
        n11 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ii)object).i())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.i() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((Comparable)(object3 = this.a), (Comparable)(object = ((ii)object).a))) != 0) {
            return n10;
        }
        return 0;
    }

    public hm a() {
        return this.a;
    }

    public hz a() {
        return this.a;
    }

    public ii a(hm hm2) {
        this.a = hm2;
        return this;
    }

    public ii a(hz hz2) {
        this.a = hz2;
        return this;
    }

    public ii a(ib ib2) {
        this.a = ib2;
        return this;
    }

    public ii a(String string2) {
        this.a = string2;
        return this;
    }

    public ii a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        return this;
    }

    public ii a(boolean bl2) {
        this.a = bl2;
        this.a(true);
        return this;
    }

    public String a() {
        return this.a;
    }

    public void a() {
        Object object = this.a;
        if (object != null) {
            object = this.a;
            if (object != null) {
                object = this.a;
                if (object != null) {
                    return;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Required field 'target' was not present! Struct: ");
                String string2 = this.toString();
                charSequence.append(string2);
                charSequence = charSequence.toString();
                object = new jj((String)charSequence);
                throw object;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Required field 'pushAction' was not present! Struct: ");
            String string3 = this.toString();
            charSequence.append(string3);
            charSequence = charSequence.toString();
            object = new jj((String)charSequence);
            throw object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'action' was not present! Struct: ");
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
            block14: {
                Object object2 = ((ji)object).a();
                int n10 = ((jf)object2).a;
                if (n10 == 0) {
                    ((ji)object).f();
                    boolean bl2 = this.c();
                    if (!bl2) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Required field 'encryptAction' was not found in serialized data! Struct: ");
                        String string2 = this.toString();
                        ((StringBuilder)object2).append(string2);
                        object2 = ((StringBuilder)object2).toString();
                        object = new jj((String)object2);
                        throw object;
                    }
                    bl2 = this.d();
                    if (bl2) {
                        this.a();
                        return;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Required field 'isRequest' was not found in serialized data! Struct: ");
                    String string3 = this.toString();
                    ((StringBuilder)object2).append(string3);
                    object2 = ((StringBuilder)object2).toString();
                    object = new jj((String)object2);
                    throw object;
                }
                int n11 = ((jf)object2).a;
                boolean bl3 = true;
                int n12 = 12;
                int n13 = 2;
                int n14 = 11;
                switch (n11) {
                    case 8: {
                        if (n10 != n12) break;
                        this.a = object2 = new hz();
                        ((hz)object2).a((ji)object);
                        break block14;
                    }
                    case 7: {
                        if (n10 != n12) break;
                        this.a = object2 = new ib();
                        ((ib)object2).a((ji)object);
                        break block14;
                    }
                    case 6: {
                        if (n10 != n14) break;
                        this.b = object2 = ((ji)object).a();
                        break block14;
                    }
                    case 5: {
                        if (n10 != n14) break;
                        this.a = object2 = ((ji)object).a();
                        break block14;
                    }
                    case 4: {
                        if (n10 != n14) break;
                        this.a = object2 = ((ji)object).a();
                        break block14;
                    }
                    case 3: {
                        if (n10 != n13) break;
                        n11 = (int)(((ji)object).a() ? 1 : 0);
                        this.b = n11;
                        this.b(bl3);
                        break block14;
                    }
                    case 2: {
                        if (n10 != n13) break;
                        n11 = (int)(((ji)object).a() ? 1 : 0);
                        this.a = n11;
                        this.a(bl3);
                        break block14;
                    }
                    case 1: {
                        n11 = 8;
                        if (n10 != n11) break;
                        n11 = ((ji)object).a();
                        object2 = hm.a(n11);
                        this.a = object2;
                        break block14;
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
        hm hm2 = this.a;
        if (hm2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            hm2 = null;
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(ii cloneable) {
        if (cloneable == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = ((ii)cloneable).a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            hm hm2 = this.a;
            hm hm3 = ((ii)cloneable).a;
            bl2 = hm2.equals((Object)hm3);
            if (!bl2) {
                return false;
            }
        }
        if ((bl2 = this.a) != (bl3 = ((ii)cloneable).a)) {
            return false;
        }
        bl2 = this.b;
        bl3 = ((ii)cloneable).b;
        if (bl2 != bl3) {
            return false;
        }
        bl2 = this.e();
        bl3 = ((ii)cloneable).e();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            ByteBuffer byteBuffer = this.a;
            ByteBuffer byteBuffer2 = ((ii)cloneable).a;
            bl2 = byteBuffer.equals(byteBuffer2);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.f();
        bl3 = ((ii)cloneable).f();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            String string2 = this.a;
            String string3 = ((ii)cloneable).a;
            bl2 = string2.equals(string3);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.g();
        bl3 = ((ii)cloneable).g();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            String string4 = this.b;
            String string5 = ((ii)cloneable).b;
            bl2 = string4.equals(string5);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.h();
        bl3 = ((ii)cloneable).h();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            ib ib2 = this.a;
            ib ib3 = ((ii)cloneable).a;
            bl2 = ib2.a(ib3);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.i();
        bl3 = ((ii)cloneable).i();
        if (!bl2 && !bl3) return true;
        if (!bl2 || !bl3) return false;
        hz hz2 = this.a;
        hz hz3 = ((ii)cloneable).a;
        boolean bl4 = hz2.a(hz3);
        if (bl4) return true;
        return false;
    }

    public byte[] a() {
        ByteBuffer byteBuffer = iy.a(this.a);
        this.a(byteBuffer);
        return this.a.array();
    }

    public ii b(String string2) {
        this.b = string2;
        return this;
    }

    public ii b(boolean bl2) {
        this.b = bl2;
        this.b(true);
        return this;
    }

    public String b() {
        return this.b;
    }

    public void b(ji ji2) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        this.a();
        Object object = a;
        ji2.a((jn)object);
        object = this.a;
        if (object != null) {
            object = a;
            ji2.a((jf)object);
            object = this.a;
            int bl22 = ((hm)((Object)object)).a();
            ji2.a(bl22);
            ji2.b();
        }
        object = b;
        ji2.a((jf)object);
        boolean bl5 = this.a;
        ji2.a(bl5);
        ji2.b();
        object = c;
        ji2.a((jf)object);
        boolean bl6 = this.b;
        ji2.a(bl6);
        ji2.b();
        object = this.a;
        if (object != null) {
            object = d;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((ByteBuffer)object);
            ji2.b();
        }
        if ((object = this.a) != null && (bl4 = this.f())) {
            object = e;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.b) != null && (bl3 = this.g())) {
            object = f;
            ji2.a((jf)object);
            object = this.b;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.a) != null) {
            object = g;
            ji2.a((jf)object);
            object = this.a;
            ((ib)object).b(ji2);
            ji2.b();
        }
        if ((object = this.a) != null && (bl2 = this.i())) {
            object = h;
            ji2.a((jf)object);
            object = this.a;
            ((hz)object).b(ji2);
            ji2.b();
        }
        ji2.c();
        ji2.a();
    }

    public void b(boolean bl2) {
        this.a.set(1, bl2);
    }

    public boolean b() {
        return this.a;
    }

    public boolean c() {
        return this.a.get(0);
    }

    public /* synthetic */ int compareTo(Object object) {
        object = (ii)object;
        return this.a((ii)object);
    }

    public boolean d() {
        return this.a.get(1);
    }

    public boolean e() {
        boolean bl2;
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer != null) {
            bl2 = true;
        } else {
            bl2 = false;
            byteBuffer = null;
        }
        return bl2;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof ii;
        if (bl2) {
            object = (ii)object;
            return this.a((ii)object);
        }
        return false;
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

    public boolean h() {
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

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        boolean bl2;
        hz hz2 = this.a;
        if (hz2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            hz2 = null;
        }
        return bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionContainer(");
        stringBuilder.append("action:");
        Object object = this.a;
        String string2 = "null";
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append(object);
        }
        object = ", ";
        stringBuilder.append((String)object);
        stringBuilder.append("encryptAction:");
        boolean bl2 = this.a;
        stringBuilder.append(bl2);
        stringBuilder.append((String)object);
        stringBuilder.append("isRequest:");
        bl2 = this.b;
        stringBuilder.append(bl2);
        stringBuilder.append((String)object);
        stringBuilder.append("pushAction:");
        Object object2 = this.a;
        if (object2 == null) {
            stringBuilder.append(string2);
        } else {
            iy.a((ByteBuffer)object2, stringBuilder);
        }
        bl2 = this.f();
        if (bl2) {
            stringBuilder.append((String)object);
            stringBuilder.append("appid:");
            object2 = this.a;
            if (object2 == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object2);
            }
        }
        if (bl2 = this.g()) {
            stringBuilder.append((String)object);
            stringBuilder.append("packageName:");
            object2 = this.b;
            if (object2 == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object2);
            }
        }
        stringBuilder.append((String)object);
        stringBuilder.append("target:");
        object2 = this.a;
        if (object2 == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append(object2);
        }
        bl2 = this.i();
        if (bl2) {
            stringBuilder.append((String)object);
            stringBuilder.append("metaInfo:");
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

