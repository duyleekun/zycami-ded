/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.hs;
import com.xiaomi.push.hx;
import com.xiaomi.push.ix;
import com.xiaomi.push.iy;
import com.xiaomi.push.jf;
import com.xiaomi.push.jg;
import com.xiaomi.push.ji;
import com.xiaomi.push.jj;
import com.xiaomi.push.jl;
import com.xiaomi.push.jn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class hv
implements ix,
Serializable,
Cloneable {
    private static final jf a;
    private static final jn a;
    private static final jf b;
    private static final jf c;
    public int a;
    public hs a;
    private BitSet a;
    public List a;

    static {
        Object object = new jn("NormalConfig");
        a = object;
        String string2 = "";
        byte by2 = 8;
        a = object = new jf(string2, by2, 1);
        b = object = new jf(string2, 15, 2);
        c = object = new jf(string2, by2, 3);
    }

    public hv() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(1);
    }

    public int a() {
        return this.a;
    }

    public int a(hv object) {
        int n10;
        int n11;
        Object object2;
        Object object3 = this.getClass();
        int n12 = object3.equals(object2 = object.getClass());
        if (n12 == 0) {
            object3 = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)object3).compareTo((String)object);
        }
        object3 = this.a();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hv)object).a()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.a() ? 1 : 0);
        if (n12 != 0) {
            n12 = this.a;
            n11 = ((hv)object).a;
            if ((n12 = iy.a(n12, n11)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(object3 = Boolean.valueOf(this.b()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = (int)(((hv)object).b() ? 1 : 0)) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.b() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((List)(object3 = this.a), (List)(object2 = ((hv)object).a))) != 0) {
            return n12;
        }
        object3 = this.c();
        n12 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hv)object).c()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.c() ? 1 : 0);
        if (n12 != 0 && (n10 = iy.a((Comparable)(object3 = this.a), (Comparable)(object = ((hv)object).a))) != 0) {
            return n10;
        }
        return 0;
    }

    public hs a() {
        return this.a;
    }

    public void a() {
        Object object = this.a;
        if (object != null) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'configItems' was not present! Struct: ");
        String string2 = this.toString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        object = new jj((String)charSequence);
        throw object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(ji var1_1) {
        var1_1.a();
        while (true) {
            block6: {
                block7: {
                    block8: {
                        var2_2 /* !! */  = var1_1.a();
                        var3_3 = var2_2 /* !! */ .a;
                        if (var3_3 == 0) {
                            var1_1.f();
                            var4_10 = this.a();
                            if (var4_10) {
                                this.a();
                                return;
                            }
                            var2_2 /* !! */  = new StringBuilder();
                            var2_2 /* !! */ .append("Required field 'version' was not found in serialized data! Struct: ");
                            var5_4 = this.toString();
                            var2_2 /* !! */ .append((String)var5_4);
                            var2_2 /* !! */  = var2_2 /* !! */ .toString();
                            var1_1 = new jj((String)var2_2 /* !! */ );
                            throw var1_1;
                        }
                        var6_5 = var2_2 /* !! */ .a;
                        var7_6 = 8;
                        var8_7 = 1;
                        if (var6_5 == var8_7) break block7;
                        var8_7 = 2;
                        if (var6_5 == var8_7) break block8;
                        var8_7 = 3;
                        if (var6_5 != var8_7) lbl-1000:
                        // 4 sources

                        {
                            while (true) {
                                jl.a((ji)var1_1, (byte)var3_3);
                                break block6;
                                break;
                            }
                        }
                        if (var3_3 != var7_6) ** GOTO lbl-1000
                        var6_5 = var1_1.a();
                        var2_2 /* !! */  = hs.a(var6_5);
                        this.a = var2_2 /* !! */ ;
                        break block6;
                    }
                    var6_5 = 15;
                    if (var3_3 != var6_5) ** GOTO lbl-1000
                    var2_2 /* !! */  = var1_1.a();
                    var7_6 = var2_2 /* !! */ .a;
                    this.a = var5_4 = new ArrayList<E>(var7_6);
                    var5_4 = null;
                    for (var3_3 = 0; var3_3 < (var7_6 = var2_2 /* !! */ .a); ++var3_3) {
                        var9_8 = new hx();
                        var9_8.a((ji)var1_1);
                        var10_9 = this.a;
                        var10_9.add(var9_8);
                    }
                    var1_1.i();
                    break block6;
                }
                if (var3_3 == var7_6) ** break;
                ** continue;
                this.a = var6_5 = var1_1.a();
                this.a((boolean)var8_7);
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
    public boolean a(hv object) {
        if (object == null) {
            return false;
        }
        int n10 = this.a;
        int n11 = ((hv)object).a;
        if (n10 != n11) {
            return false;
        }
        n10 = (int)(this.b() ? 1 : 0);
        n11 = (int)(((hv)object).b() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            List list = this.a;
            List list2 = ((hv)object).a;
            n10 = (int)(list.equals(list2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.c() ? 1 : 0);
        n11 = (int)(((hv)object).c() ? 1 : 0);
        if (n10 == 0 && n11 == 0) return true;
        if (n10 == 0 || n11 == 0) return false;
        hs hs2 = this.a;
        hs hs3 = ((hv)object).a;
        boolean bl2 = hs2.equals((Object)hs3);
        if (bl2) return true;
        return false;
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
        object = this.a;
        if (object != null) {
            object = b;
            ji2.a((jf)object);
            byte by2 = 12;
            List list = this.a;
            int n11 = list.size();
            object = new jg(by2, n11);
            ji2.a((jg)object);
            object = this.a.iterator();
            while ((by2 = (byte)(object.hasNext() ? 1 : 0)) != 0) {
                hx hx2 = (hx)object.next();
                hx2.b(ji2);
            }
            ji2.e();
            ji2.b();
        }
        if ((object = this.a) != null && (n10 = (int)(this.c() ? 1 : 0)) != 0) {
            object = c;
            ji2.a((jf)object);
            object = this.a;
            n10 = ((hs)((Object)object)).a();
            ji2.a(n10);
            ji2.b();
        }
        ji2.c();
        ji2.a();
    }

    public boolean b() {
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

    public boolean c() {
        boolean bl2;
        hs hs2 = this.a;
        if (hs2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            hs2 = null;
        }
        return bl2;
    }

    public /* synthetic */ int compareTo(Object object) {
        object = (hv)object;
        return this.a((hv)object);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof hv;
        if (bl2) {
            object = (hv)object;
            return this.a((hv)object);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NormalConfig(");
        stringBuilder.append("version:");
        int n10 = this.a;
        stringBuilder.append(n10);
        Object object = ", ";
        stringBuilder.append((String)object);
        stringBuilder.append("configItems:");
        List list = this.a;
        String string2 = "null";
        if (list == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append(list);
        }
        boolean bl2 = this.c();
        if (bl2) {
            stringBuilder.append((String)object);
            stringBuilder.append("type:");
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

