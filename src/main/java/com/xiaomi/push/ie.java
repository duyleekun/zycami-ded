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
public class ie
implements ix,
Serializable,
Cloneable {
    private static final jf a;
    private static final jn a;
    private static final jf b;
    public int a;
    private BitSet a;
    public int b;

    static {
        Object object = new jn("XmPushActionCheckClientInfo");
        a = object;
        String string2 = "";
        byte by2 = 8;
        a = object = new jf(string2, by2, 1);
        b = object = new jf(string2, by2, 2);
    }

    public ie() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(2);
    }

    public int a(ie object) {
        int n10;
        Constable constable;
        Constable constable2 = this.getClass();
        int n11 = constable2.equals(constable = object.getClass());
        if (n11 == 0) {
            constable2 = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)((Object)constable2)).compareTo((String)object);
        }
        constable2 = this.a();
        n11 = ((Boolean)constable2).compareTo((Boolean)(constable = Boolean.valueOf((n10 = ((ie)object).a()) != 0)));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0) {
            n11 = this.a;
            n10 = ((ie)object).a;
            if ((n11 = iy.a(n11, n10)) != 0) {
                return n11;
            }
        }
        if ((n11 = ((Boolean)(constable2 = Boolean.valueOf(this.b()))).compareTo((Boolean)(constable = Boolean.valueOf((n10 = (int)(((ie)object).b() ? 1 : 0)) != 0)))) != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0) {
            n11 = this.b;
            int n12 = ((ie)object).b;
            if ((n12 = iy.a(n11, n12)) != 0) {
                return n12;
            }
        }
        return 0;
    }

    public ie a(int n10) {
        this.a = n10;
        this.a(true);
        return this;
    }

    public void a() {
    }

    /*
     * Unable to fully structure code
     */
    public void a(ji var1_1) {
        var1_1.a();
        while (true) {
            block6: {
                block7: {
                    var2_2 = var1_1.a();
                    var3_3 = var2_2.a;
                    if (var3_3 == 0) {
                        var1_1.f();
                        var4_8 = this.a();
                        if (var4_8) {
                            var4_8 = this.b();
                            if (var4_8) {
                                this.a();
                                return;
                            }
                            var2_2 = new StringBuilder();
                            var2_2.append("Required field 'pluginConfigVersion' was not found in serialized data! Struct: ");
                            var5_9 = this.toString();
                            var2_2.append(var5_9);
                            var2_2 = var2_2.toString();
                            var1_1 = new jj((String)var2_2);
                            throw var1_1;
                        }
                        var2_2 = new StringBuilder();
                        var2_2.append("Required field 'miscConfigVersion' was not found in serialized data! Struct: ");
                        var5_10 = this.toString();
                        var2_2.append(var5_10);
                        var2_2 = var2_2.toString();
                        var1_1 = new jj((String)var2_2);
                        throw var1_1;
                    }
                    var6_4 = var2_2.a;
                    var7_5 = 8;
                    var8_6 = 1;
                    if (var6_4 == var8_6) break block7;
                    var9_7 = 2;
                    if (var6_4 != var9_7) lbl-1000:
                    // 3 sources

                    {
                        while (true) {
                            jl.a((ji)var1_1, var3_3);
                            break block6;
                            break;
                        }
                    }
                    if (var3_3 != var7_5) ** GOTO lbl-1000
                    this.b = var6_4 = var1_1.a();
                    this.b((boolean)var8_6);
                    break block6;
                }
                if (var3_3 != var7_5) ** continue;
                this.a = var6_4 = var1_1.a();
                this.a((boolean)var8_6);
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

    public boolean a(ie ie2) {
        if (ie2 == null) {
            return false;
        }
        int n10 = this.a;
        int n11 = ie2.a;
        if (n10 != n11) {
            return false;
        }
        n10 = this.b;
        int n12 = ie2.b;
        return n10 == n12;
    }

    public ie b(int n10) {
        this.b = n10;
        this.b(true);
        return this;
    }

    public void b(ji ji2) {
        this.a();
        Object object = a;
        ji2.a((jn)object);
        object = a;
        ji2.a((jf)object);
        int n10 = this.a;
        ji2.a(n10);
        ji2.b();
        object = b;
        ji2.a((jf)object);
        n10 = this.b;
        ji2.a(n10);
        ji2.b();
        ji2.c();
        ji2.a();
    }

    public void b(boolean bl2) {
        this.a.set(1, bl2);
    }

    public boolean b() {
        return this.a.get(1);
    }

    public /* synthetic */ int compareTo(Object object) {
        object = (ie)object;
        return this.a((ie)object);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof ie;
        if (bl2) {
            object = (ie)object;
            return this.a((ie)object);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCheckClientInfo(");
        stringBuilder.append("miscConfigVersion:");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", ");
        stringBuilder.append("pluginConfigVersion:");
        n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

