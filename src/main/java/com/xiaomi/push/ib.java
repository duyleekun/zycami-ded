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
public class ib
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
    public long a;
    public String a;
    private BitSet a;
    public boolean a;
    public String b;
    public String c;
    public String d;

    static {
        Object object = new jn("Target");
        a = object;
        String string2 = "";
        a = object = new jf(string2, 10, 1);
        byte by2 = 11;
        byte by3 = 2;
        b = object = new jf(string2, by2, by3);
        c = object = new jf(string2, by2, 3);
        d = object = new jf(string2, by2, 4);
        e = object = new jf(string2, by3, 5);
        f = object = new jf(string2, by2, 7);
    }

    public ib() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(2);
        this.a = 5;
        this.b = "xiaomi.com";
        this.c = "";
        this.a = false;
    }

    public int a(ib object) {
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
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ib)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.a, l10 = ((ib)object).a)) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ib)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((ib)object).a))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ib)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((ib)object).b))) != 0) {
            return n11;
        }
        constable = this.d();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ib)object).d())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.d() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((ib)object).c))) != 0) {
            return n11;
        }
        constable = this.e();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ib)object).e())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.e() ? 1 : 0);
        if (n11 != 0) {
            n11 = (int)(this.a ? 1 : 0);
            bl2 = ((ib)object).a;
            if ((n11 = iy.a(n11 != 0, bl2)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable = Boolean.valueOf(this.f()))).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((ib)object).f())))) != 0) {
            return n11;
        }
        n11 = (int)(this.f() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((String)((Object)(constable = this.d)), (String)(object = ((ib)object).d))) != 0) {
            return n10;
        }
        return 0;
    }

    public void a() {
        Object object = this.a;
        if (object != null) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'userId' was not present! Struct: ");
        String string2 = this.toString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        object = new jj((String)charSequence);
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    public void a(ji var1_1) {
        var1_1.a();
        while (true) {
            block5: {
                block6: {
                    block7: {
                        block8: {
                            block9: {
                                block10: {
                                    var2_2 = var1_1.a();
                                    var3_3 = var2_2.a;
                                    if (var3_3 == 0) {
                                        var1_1.f();
                                        var4_10 = this.a();
                                        if (var4_10) {
                                            this.a();
                                            return;
                                        }
                                        var2_2 = new StringBuilder();
                                        var2_2.append("Required field 'channelId' was not found in serialized data! Struct: ");
                                        var5_11 = this.toString();
                                        var2_2.append(var5_11);
                                        var2_2 = var2_2.toString();
                                        var1_1 = new jj((String)var2_2);
                                        throw var1_1;
                                    }
                                    var6_4 = var2_2.a;
                                    var7_5 = 1;
                                    if (var6_4 == var7_5) break block6;
                                    var8_6 = 2;
                                    var9_7 = 11;
                                    if (var6_4 == var8_6) break block7;
                                    var10_8 = 3;
                                    if (var6_4 == var10_8) break block8;
                                    var10_8 = 4;
                                    if (var6_4 == var10_8) break block9;
                                    var10_8 = 5;
                                    if (var6_4 == var10_8) break block10;
                                    var7_5 = 7;
                                    if (var6_4 != var7_5) lbl-1000:
                                    // 7 sources

                                    {
                                        while (true) {
                                            jl.a((ji)var1_1, (byte)var3_3);
                                            break block5;
                                            break;
                                        }
                                    }
                                    if (var3_3 != var9_7) ** GOTO lbl-1000
                                    this.d = var2_2 = var1_1.a();
                                    break block5;
                                }
                                if (var3_3 != var8_6) ** GOTO lbl-1000
                                var6_4 = (int)var1_1.a();
                                this.a = var6_4;
                                this.b((boolean)var7_5);
                                break block5;
                            }
                            if (var3_3 != var9_7) ** GOTO lbl-1000
                            this.c = var2_2 = var1_1.a();
                            break block5;
                        }
                        if (var3_3 != var9_7) ** GOTO lbl-1000
                        this.b = var2_2 = var1_1.a();
                        break block5;
                    }
                    if (var3_3 != var9_7) ** GOTO lbl-1000
                    this.a = var2_2 = var1_1.a();
                    break block5;
                }
                var6_4 = 10;
                if (var3_3 == var6_4) ** break;
                ** continue;
                this.a = var11_9 = var1_1.a();
                this.a((boolean)var7_5);
            }
            var1_1.g();
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
    public boolean a(ib object) {
        String string2;
        String string3;
        if (object == null) {
            return false;
        }
        long l10 = this.a;
        long l11 = ((ib)object).a;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            return false;
        }
        boolean bl2 = this.b();
        boolean bl3 = ((ib)object).b();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            string3 = this.a;
            string2 = ((ib)object).a;
            boolean bl4 = string3.equals(string2);
            if (!bl4) {
                return false;
            }
        }
        boolean bl5 = this.c();
        bl3 = ((ib)object).c();
        if (bl5 || bl3) {
            if (!bl5 || !bl3) return false;
            string3 = this.b;
            string2 = ((ib)object).b;
            boolean bl6 = string3.equals(string2);
            if (!bl6) {
                return false;
            }
        }
        boolean bl7 = this.d();
        bl3 = ((ib)object).d();
        if (bl7 || bl3) {
            if (!bl7 || !bl3) return false;
            string3 = this.c;
            string2 = ((ib)object).c;
            boolean bl8 = string3.equals(string2);
            if (!bl8) {
                return false;
            }
        }
        boolean bl9 = this.e();
        bl3 = ((ib)object).e();
        if (bl9 || bl3) {
            if (!bl9 || !bl3) return false;
            boolean bl10 = this.a;
            bl3 = ((ib)object).a;
            if (bl10 != bl3) {
                return false;
            }
        }
        boolean bl11 = this.f();
        bl3 = ((ib)object).f();
        if (!bl11 && !bl3) return true;
        if (!bl11 || !bl3) return false;
        string3 = this.d;
        object = ((ib)object).d;
        boolean bl12 = string3.equals(object);
        if (bl12) return true;
        return false;
    }

    public void b(ji ji2) {
        boolean bl2;
        this.a();
        Object object = a;
        ji2.a((jn)object);
        object = a;
        ji2.a((jf)object);
        long l10 = this.a;
        ji2.a(l10);
        ji2.b();
        object = this.a;
        if (object != null) {
            object = b;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.b) != null && (bl2 = this.c())) {
            object = c;
            ji2.a((jf)object);
            object = this.b;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.c) != null && (bl2 = this.d())) {
            object = d;
            ji2.a((jf)object);
            object = this.c;
            ji2.a((String)object);
            ji2.b();
        }
        if (bl2 = this.e()) {
            object = e;
            ji2.a((jf)object);
            bl2 = this.a;
            ji2.a(bl2);
            ji2.b();
        }
        if ((object = this.d) != null && (bl2 = this.f())) {
            object = f;
            ji2.a((jf)object);
            object = this.d;
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
        object = (ib)object;
        return this.a((ib)object);
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
        return this.a.get(1);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof ib;
        if (bl2) {
            object = (ib)object;
            return this.a((ib)object);
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

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Target(");
        stringBuilder.append("channelId:");
        long l10 = this.a;
        stringBuilder.append(l10);
        String string2 = ", ";
        stringBuilder.append(string2);
        stringBuilder.append("userId:");
        String string3 = this.a;
        String string4 = "null";
        if (string3 == null) {
            stringBuilder.append(string4);
        } else {
            stringBuilder.append(string3);
        }
        boolean bl2 = this.c();
        if (bl2) {
            stringBuilder.append(string2);
            stringBuilder.append("server:");
            string3 = this.b;
            if (string3 == null) {
                stringBuilder.append(string4);
            } else {
                stringBuilder.append(string3);
            }
        }
        if (bl2 = this.d()) {
            stringBuilder.append(string2);
            stringBuilder.append("resource:");
            string3 = this.c;
            if (string3 == null) {
                stringBuilder.append(string4);
            } else {
                stringBuilder.append(string3);
            }
        }
        if (bl2 = this.e()) {
            stringBuilder.append(string2);
            string3 = "isPreview:";
            stringBuilder.append(string3);
            bl2 = this.a;
            stringBuilder.append(bl2);
        }
        if (bl2 = this.f()) {
            stringBuilder.append(string2);
            stringBuilder.append("token:");
            string2 = this.d;
            if (string2 == null) {
                stringBuilder.append(string4);
            } else {
                stringBuilder.append(string2);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

