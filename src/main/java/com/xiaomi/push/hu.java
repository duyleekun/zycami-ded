/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ho;
import com.xiaomi.push.ix;
import com.xiaomi.push.iy;
import com.xiaomi.push.jf;
import com.xiaomi.push.ji;
import com.xiaomi.push.jj;
import com.xiaomi.push.jl;
import com.xiaomi.push.jn;
import java.io.Serializable;
import java.util.BitSet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class hu
implements ix,
Serializable,
Cloneable {
    private static final jf a;
    private static final jn a;
    private static final jf b;
    private static final jf c;
    public long a;
    public ho a;
    public String a;
    private BitSet a;

    static {
        Object object = new jn("DataCollectionItem");
        a = object;
        String string2 = "";
        a = object = new jf(string2, 10, 1);
        b = object = new jf(string2, 8, 2);
        c = object = new jf(string2, 11, 3);
    }

    public hu() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(1);
    }

    public int a(hu object) {
        int n10;
        long l10;
        long l11;
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
        n11 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hu)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a(l11 = this.a, l10 = ((hu)object).a)) != 0) {
            return n11;
        }
        object3 = this.b();
        n11 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hu)object).b())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0 && (n11 = iy.a((Comparable)(object3 = this.a), object2 = ((hu)object).a)) != 0) {
            return n11;
        }
        object3 = this.c();
        n11 = ((Boolean)object3).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((hu)object).c())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.c() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((String)(object3 = this.a), (String)(object = ((hu)object).a))) != 0) {
            return n10;
        }
        return 0;
    }

    public hu a(long l10) {
        this.a = l10;
        this.a(true);
        return this;
    }

    public hu a(ho ho2) {
        this.a = ho2;
        return this;
    }

    public hu a(String string2) {
        this.a = string2;
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
                return;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Required field 'content' was not present! Struct: ");
            String string2 = this.toString();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            object = new jj((String)charSequence);
            throw object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'collectionType' was not present! Struct: ");
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
                            var4_7 = this.a();
                            if (var4_7) {
                                this.a();
                                return;
                            }
                            var2_2 = new StringBuilder();
                            var2_2.append("Required field 'collectedAt' was not found in serialized data! Struct: ");
                            var5_8 = this.toString();
                            var2_2.append(var5_8);
                            var2_2 = var2_2.toString();
                            var1_1 = new jj((String)var2_2);
                            throw var1_1;
                        }
                        var6_4 = var2_2.a;
                        var7_5 = 1;
                        if (var6_4 == var7_5) break block6;
                        var7_5 = 2;
                        if (var6_4 == var7_5) break block7;
                        var7_5 = 3;
                        if (var6_4 != var7_5) lbl-1000:
                        // 4 sources

                        {
                            while (true) {
                                jl.a((ji)var1_1, (byte)var3_3);
                                break block5;
                                break;
                            }
                        }
                        var6_4 = 11;
                        if (var3_3 != var6_4) ** GOTO lbl-1000
                        this.a = var2_2 = var1_1.a();
                        break block5;
                    }
                    var6_4 = 8;
                    if (var3_3 != var6_4) ** GOTO lbl-1000
                    var6_4 = var1_1.a();
                    var2_2 = ho.a(var6_4);
                    this.a = var2_2;
                    break block5;
                }
                var6_4 = 10;
                if (var3_3 == var6_4) ** break;
                ** continue;
                this.a = var8_6 = var1_1.a();
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
    public boolean a(hu object) {
        if (object == null) {
            return false;
        }
        long l10 = this.a;
        long l11 = ((hu)object).a;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            return false;
        }
        boolean bl2 = this.b();
        boolean bl3 = ((hu)object).b();
        if (bl2 || bl3) {
            if (!bl2 || !bl3) return false;
            ho ho2 = this.a;
            ho ho3 = ((hu)object).a;
            boolean bl4 = ho2.equals((Object)ho3);
            if (!bl4) {
                return false;
            }
        }
        boolean bl5 = this.c();
        bl3 = ((hu)object).c();
        if (!bl5 && !bl3) return true;
        if (!bl5 || !bl3) return false;
        String string2 = this.a;
        object = ((hu)object).a;
        boolean bl6 = string2.equals(object);
        if (bl6) return true;
        return false;
    }

    public void b(ji ji2) {
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
            int n10 = ((ho)((Object)object)).a();
            ji2.a(n10);
            ji2.b();
        }
        if ((object = this.a) != null) {
            object = c;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((String)object);
            ji2.b();
        }
        ji2.c();
        ji2.a();
    }

    public boolean b() {
        boolean bl2;
        ho ho2 = this.a;
        if (ho2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            ho2 = null;
        }
        return bl2;
    }

    public boolean c() {
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

    public /* synthetic */ int compareTo(Object object) {
        object = (hu)object;
        return this.a((hu)object);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof hu;
        if (bl2) {
            object = (hu)object;
            return this.a((hu)object);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataCollectionItem(");
        stringBuilder.append("collectedAt:");
        long l10 = this.a;
        stringBuilder.append(l10);
        String string2 = ", ";
        stringBuilder.append(string2);
        stringBuilder.append("collectionType:");
        ho ho2 = this.a;
        String string3 = "null";
        if (ho2 == null) {
            stringBuilder.append(string3);
        } else {
            stringBuilder.append((Object)ho2);
        }
        stringBuilder.append(string2);
        stringBuilder.append("content:");
        string2 = this.a;
        if (string2 == null) {
            stringBuilder.append(string3);
        } else {
            stringBuilder.append(string2);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

