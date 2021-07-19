/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.fi;
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
public class fj
implements ix,
Serializable,
Cloneable {
    private static final jf a;
    private static final jn a;
    private static final jf b;
    private static final jf c;
    public String a;
    public List a;
    public String b;

    static {
        Object object = new jn("StatsEvents");
        a = object;
        String string2 = "";
        byte by2 = 11;
        a = object = new jf(string2, by2, 1);
        b = object = new jf(string2, by2, 2);
        c = object = new jf(string2, 15, 3);
    }

    public fj() {
    }

    public fj(String string2, List list) {
        this();
        this.a = string2;
        this.a = list;
    }

    public int a(fj object) {
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
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((fj)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((fj)object).a))) != 0) {
            return n11;
        }
        constable = this.b();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((fj)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((fj)object).b))) != 0) {
            return n11;
        }
        constable = this.c();
        n11 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((fj)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((List)((Object)(constable = this.a)), (List)(object = ((fj)object).a))) != 0) {
            return n10;
        }
        return 0;
    }

    public fj a(String string2) {
        this.b = string2;
        return this;
    }

    public void a() {
        Object object = this.a;
        if (object != null) {
            object = this.a;
            if (object != null) {
                return;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Required field 'events' was not present! Struct: ");
            String string2 = this.toString();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            object = new jj((String)charSequence);
            throw object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'uuid' was not present! Struct: ");
        String string3 = this.toString();
        charSequence.append(string3);
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
                        var2_2 = var1_1.a();
                        var3_3 = var2_2.a;
                        if (var3_3 == 0) {
                            var1_1.f();
                            this.a();
                            return;
                        }
                        var4_4 = var2_2.a;
                        var5_5 = 11;
                        var6_6 = 1;
                        if (var4_4 == var6_6) break block6;
                        var6_6 = 2;
                        if (var4_4 == var6_6) break block7;
                        var5_5 = 3;
                        if (var4_4 != var5_5) lbl-1000:
                        // 4 sources

                        {
                            while (true) {
                                jl.a(var1_1, (byte)var3_3);
                                break block5;
                                break;
                            }
                        }
                        var4_4 = 15;
                        if (var3_3 != var4_4) ** GOTO lbl-1000
                        var2_2 = var1_1.a();
                        var5_5 = var2_2.a;
                        this.a = var7_7 = new ArrayList<E>(var5_5);
                        var7_7 = null;
                        for (var3_3 = 0; var3_3 < (var5_5 = var2_2.a); ++var3_3) {
                            var8_8 = new fi();
                            var8_8.a(var1_1);
                            var9_9 = this.a;
                            var9_9.add(var8_8);
                        }
                        var1_1.i();
                        break block5;
                    }
                    if (var3_3 != var5_5) ** GOTO lbl-1000
                    this.b = var2_2 = var1_1.a();
                    break block5;
                }
                if (var3_3 == var5_5) ** break;
                ** continue;
                this.a = var2_2 = var1_1.a();
            }
            var1_1.g();
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
    public boolean a(fj object) {
        String string2;
        Object object2;
        if (object == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = ((fj)object).a();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.a;
            string2 = ((fj)object).a;
            bl2 = ((String)object2).equals(string2);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.b();
        bl3 = ((fj)object).b();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            object2 = this.b;
            string2 = ((fj)object).b;
            bl2 = ((String)object2).equals(string2);
            if (!bl2) {
                return false;
            }
        }
        bl2 = this.c();
        bl3 = ((fj)object).c();
        if (!bl2 && !bl3) return true;
        if (!bl2 || !bl3) return false;
        object2 = this.a;
        object = ((fj)object).a;
        boolean bl4 = object2.equals(object);
        if (bl4) return true;
        return false;
    }

    public void b(ji ji2) {
        boolean bl2;
        this.a();
        Iterator iterator2 = a;
        ji2.a((jn)((Object)iterator2));
        iterator2 = this.a;
        if (iterator2 != null) {
            iterator2 = a;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.a;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.b) != null && (bl2 = this.b())) {
            iterator2 = b;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.b;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.a) != null) {
            iterator2 = c;
            ji2.a((jf)((Object)iterator2));
            byte by2 = 12;
            List list = this.a;
            int n10 = list.size();
            iterator2 = new Iterator(by2, n10);
            ji2.a((jg)((Object)iterator2));
            iterator2 = this.a.iterator();
            while ((by2 = (byte)(iterator2.hasNext() ? 1 : 0)) != 0) {
                fi fi2 = (fi)iterator2.next();
                fi2.b(ji2);
            }
            ji2.e();
            ji2.b();
        }
        ji2.c();
        ji2.a();
    }

    public boolean b() {
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

    public boolean c() {
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

    public /* synthetic */ int compareTo(Object object) {
        object = (fj)object;
        return this.a((fj)object);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof fj;
        if (bl2) {
            object = (fj)object;
            return this.a((fj)object);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatsEvents(");
        stringBuilder.append("uuid:");
        Object object = this.a;
        String string2 = "null";
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        boolean bl2 = this.b();
        String string3 = ", ";
        if (bl2) {
            stringBuilder.append(string3);
            stringBuilder.append("operator:");
            object = this.b;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        stringBuilder.append(string3);
        stringBuilder.append("events:");
        object = this.a;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append(object);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

