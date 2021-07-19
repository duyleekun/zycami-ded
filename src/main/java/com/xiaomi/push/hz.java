/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

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
public class hz
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
    public int a;
    public long a;
    public String a;
    private BitSet a;
    public Map a;
    public boolean a;
    public int b;
    public String b;
    public Map b;
    public int c;
    public String c;
    public Map c;
    public String d;
    public String e;

    static {
        Object object = new jn("PushMetaInfo");
        a = object;
        String string2 = "";
        byte by2 = 11;
        a = object = new jf(string2, by2, 1);
        byte by3 = 10;
        byte by4 = 2;
        b = object = new jf(string2, by3, by4);
        c = object = new jf(string2, by2, 3);
        d = object = new jf(string2, by2, 4);
        e = object = new jf(string2, by2, 5);
        byte by5 = 8;
        f = object = new jf(string2, by5, 6);
        g = object = new jf(string2, by2, 7);
        h = object = new jf(string2, by5, by5);
        i = object = new jf(string2, by5, 9);
        by5 = 13;
        j = object = new jf(string2, by5, by3);
        k = object = new jf(string2, by5, by2);
        l = object = new jf(string2, by4, 12);
        m = object = new jf(string2, by5, by5);
    }

    public hz() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(5);
        this.a = false;
    }

    public hz(hz object) {
        boolean bl2;
        boolean bl3;
        String string2;
        Object object2;
        boolean bl4;
        int n10;
        int n11;
        int n12;
        boolean bl5;
        boolean bl6;
        long l10;
        int n102 = 5;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>(n102);
        this.a = hashMap;
        ((BitSet)((Object)hashMap)).clear();
        hashMap = this.a;
        Object object3 = ((hz)object).a;
        ((BitSet)((Object)hashMap)).or((BitSet)object3);
        boolean n112 = ((hz)((Object)object)).a();
        if (n112) {
            hashMap = ((hz)object).a;
            this.a = hashMap;
        }
        this.a = l10 = ((hz)object).a;
        boolean bl7 = ((hz)((Object)object)).c();
        if (bl7) {
            hashMap = ((hz)object).b;
            this.b = hashMap;
        }
        if (bl6 = ((hz)((Object)object)).d()) {
            hashMap = ((hz)object).c;
            this.c = hashMap;
        }
        if (bl5 = ((hz)((Object)object)).e()) {
            hashMap = ((hz)object).d;
            this.d = hashMap;
        }
        this.a = n12 = ((hz)object).a;
        boolean bl8 = ((hz)((Object)object)).g();
        if (bl8) {
            hashMap = ((hz)object).e;
            this.e = hashMap;
        }
        this.b = n11 = ((hz)object).b;
        this.c = n10 = ((hz)object).c;
        boolean bl9 = ((hz)((Object)object)).j();
        if (bl9) {
            hashMap = new HashMap<Object, Object>();
            object3 = ((hz)object).a.entrySet().iterator();
            while (bl4 = object3.hasNext()) {
                object2 = object3.next();
                string2 = (String)object2.getKey();
                object2 = (String)object2.getValue();
                hashMap.put(string2, object2);
            }
            this.a = hashMap;
        }
        if (bl3 = ((hz)((Object)object)).k()) {
            hashMap = new HashMap<Object, Object>();
            object3 = ((hz)object).b.entrySet().iterator();
            while (bl4 = object3.hasNext()) {
                object2 = object3.next();
                string2 = (String)object2.getKey();
                object2 = (String)object2.getValue();
                hashMap.put(string2, object2);
            }
            this.b = hashMap;
        }
        this.a = bl2 = ((hz)object).a;
        boolean bl10 = ((hz)((Object)object)).n();
        if (bl10) {
            hashMap = new HashMap<Object, Object>();
            object = ((hz)object).c.entrySet().iterator();
            while ((n102 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object3 = object.next();
                object2 = (String)object3.getKey();
                object3 = (String)object3.getValue();
                hashMap.put(object2, object3);
            }
            this.c = hashMap;
        }
    }

    public int a() {
        return this.a;
    }

    public int a(hz object) {
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
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hz)object).a()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.a() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((hz)object).a))) != 0) {
            return n12;
        }
        constable = this.b();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hz)object).b()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.b() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a(l11 = this.a, l10 = ((hz)object).a)) != 0) {
            return n12;
        }
        constable = this.c();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hz)object).c()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.c() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((hz)object).b))) != 0) {
            return n12;
        }
        constable = this.d();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hz)object).d()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.d() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((hz)object).c))) != 0) {
            return n12;
        }
        constable = this.e();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hz)object).e()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.e() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((hz)object).d))) != 0) {
            return n12;
        }
        constable = this.f();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hz)object).f()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.f() ? 1 : 0);
        if (n12 != 0) {
            n12 = this.a;
            n11 = ((hz)object).a;
            if ((n12 = iy.a(n12, n11)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(constable = Boolean.valueOf(this.g()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = (int)(((hz)object).g() ? 1 : 0)) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.g() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((hz)object).e))) != 0) {
            return n12;
        }
        constable = this.h();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hz)object).h()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.h() ? 1 : 0);
        if (n12 != 0) {
            n12 = this.b;
            n11 = ((hz)object).b;
            if ((n12 = iy.a(n12, n11)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(constable = Boolean.valueOf(this.i()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = (int)(((hz)object).i() ? 1 : 0)) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.i() ? 1 : 0);
        if (n12 != 0) {
            n12 = this.c;
            n11 = ((hz)object).c;
            if ((n12 = iy.a(n12, n11)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(constable = Boolean.valueOf(this.j()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = (int)(((hz)object).j() ? 1 : 0)) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.j() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((Map)((Object)(constable = this.a)), (Map)(object2 = ((hz)object).a))) != 0) {
            return n12;
        }
        constable = this.k();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hz)object).k()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.k() ? 1 : 0);
        if (n12 != 0 && (n12 = iy.a((Map)((Object)(constable = this.b)), (Map)(object2 = ((hz)object).b))) != 0) {
            return n12;
        }
        constable = this.m();
        n12 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hz)object).m()) != 0)));
        if (n12 != 0) {
            return n12;
        }
        n12 = (int)(this.m() ? 1 : 0);
        if (n12 != 0) {
            n12 = (int)(this.a ? 1 : 0);
            n11 = ((hz)object).a;
            if ((n12 = iy.a(n12 != 0, n11 != 0)) != 0) {
                return n12;
            }
        }
        if ((n12 = ((Boolean)(constable = Boolean.valueOf(this.n()))).compareTo((Boolean)(object2 = Boolean.valueOf((n11 = ((hz)object).n()) != 0)))) != 0) {
            return n12;
        }
        n12 = (int)(this.n() ? 1 : 0);
        if (n12 != 0 && (n10 = iy.a((Map)((Object)(constable = this.c)), (Map)(object = ((hz)object).c))) != 0) {
            return n10;
        }
        return 0;
    }

    public long a() {
        return this.a;
    }

    public hz a() {
        hz hz2 = new hz(this);
        return hz2;
    }

    public hz a(int n10) {
        this.a = n10;
        this.b(true);
        return this;
    }

    public hz a(String string2) {
        this.a = string2;
        return this;
    }

    public hz a(Map map) {
        this.a = map;
        return this;
    }

    public String a() {
        return this.a;
    }

    public Map a() {
        return this.a;
    }

    public void a() {
        Object object = this.a;
        if (object != null) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'id' was not present! Struct: ");
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
            block23: {
                var2_2 = var1_1.a();
                var3_3 = var2_2.a;
                if (var3_3 == 0) {
                    var1_1.f();
                    var4_15 = this.b();
                    if (var4_15) {
                        this.a();
                        return;
                    }
                    var2_2 = new StringBuilder();
                    var2_2.append("Required field 'messageTs' was not found in serialized data! Struct: ");
                    var5_4 = this.toString();
                    var2_2.append((String)var5_4);
                    var2_2 = var2_2.toString();
                    var1_1 = new jj((String)var2_2);
                    throw var1_1;
                }
                var6_5 = var2_2.a;
                var8_7 = 13;
                var9_8 = 8;
                var10_9 = 2;
                var11_10 = 11;
                var12_11 = true;
                switch (var6_5) lbl-1000:
                // 13 sources

                {
                    default: {
                        while (true) {
                            jl.a((ji)var1_1, (byte)var3_3);
                            break block23;
                            break;
                        }
                    }
                    case 13: {
                        if (var3_3 != var8_7) ** GOTO lbl-1000
                        var2_2 = var1_1.a();
                        var8_7 = var2_2.a * var10_9;
                        var5_4 = new HashMap(var8_7);
                        this.c = var5_4;
                        for (var7_6 = 0; var7_6 < (var3_3 = var2_2.a); ++var7_6) {
                            var5_4 = var1_1.a();
                            var13_12 = var1_1.a();
                            var14_13 = this.c;
                            var14_13.put(var5_4, var13_12);
                        }
                        ** GOTO lbl81
                    }
                    case 12: {
                        if (var3_3 != var10_9) ** GOTO lbl-1000
                        var6_5 = (int)var1_1.a();
                        this.a = var6_5;
                        this.e(var12_11);
                        break block23;
                    }
                    case 11: {
                        if (var3_3 != var8_7) ** GOTO lbl-1000
                        var2_2 = var1_1.a();
                        var8_7 = var2_2.a * var10_9;
                        var5_4 = new HashMap(var8_7);
                        this.b = var5_4;
                        while (var7_6 < (var3_3 = var2_2.a)) {
                            var5_4 = var1_1.a();
                            var13_12 = var1_1.a();
                            var14_13 = this.b;
                            var14_13.put(var5_4, var13_12);
                            ++var7_6;
                        }
                        ** GOTO lbl81
                    }
                    case 10: {
                        if (var3_3 != var8_7) ** GOTO lbl-1000
                        var2_2 = var1_1.a();
                        var8_7 = var2_2.a * var10_9;
                        var5_4 = new HashMap(var8_7);
                        this.a = var5_4;
                        while (var7_6 < (var3_3 = var2_2.a)) {
                            var5_4 = var1_1.a();
                            var13_12 = var1_1.a();
                            var14_13 = this.a;
                            var14_13.put(var5_4, var13_12);
                            ++var7_6;
                        }
lbl81:
                        // 3 sources

                        var1_1.h();
                        break block23;
                    }
                    case 9: {
                        if (var3_3 != var9_8) ** GOTO lbl-1000
                        this.c = var6_5 = var1_1.a();
                        this.d(var12_11);
                        break block23;
                    }
                    case 8: {
                        if (var3_3 != var9_8) ** GOTO lbl-1000
                        this.b = var6_5 = var1_1.a();
                        this.c(var12_11);
                        break block23;
                    }
                    case 7: {
                        if (var3_3 != var11_10) ** GOTO lbl-1000
                        this.e = var2_2 = var1_1.a();
                        break block23;
                    }
                    case 6: {
                        if (var3_3 != var9_8) ** GOTO lbl-1000
                        this.a = var6_5 = var1_1.a();
                        this.b(var12_11);
                        break block23;
                    }
                    case 5: {
                        if (var3_3 != var11_10) ** GOTO lbl-1000
                        this.d = var2_2 = var1_1.a();
                        break block23;
                    }
                    case 4: {
                        if (var3_3 != var11_10) ** GOTO lbl-1000
                        this.c = var2_2 = var1_1.a();
                        break block23;
                    }
                    case 3: {
                        if (var3_3 != var11_10) ** GOTO lbl-1000
                        this.b = var2_2 = var1_1.a();
                        break block23;
                    }
                    case 2: {
                        var6_5 = 10;
                        if (var3_3 != var6_5) ** GOTO lbl-1000
                        this.a = var15_14 = var1_1.a();
                        this.a(var12_11);
                        break block23;
                    }
                    case 1: 
                }
                if (var3_3 != var11_10) ** continue;
                this.a = var2_2 = var1_1.a();
            }
            var1_1.g();
        }
    }

    public void a(String string2, String string3) {
        HashMap hashMap = this.a;
        if (hashMap == null) {
            this.a = hashMap = new HashMap();
        }
        this.a.put(string2, string3);
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
    public boolean a(hz object) {
        long l10;
        long l11;
        long l12;
        Object object2;
        Object object3;
        if (object == null) {
            return false;
        }
        int n10 = this.a();
        int n11 = ((hz)object).a();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.a;
            object2 = ((hz)object).a;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        if ((n10 = (l12 = (l11 = this.a) - (l10 = ((hz)object).a)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0) {
            return false;
        }
        n10 = this.c();
        n11 = ((hz)object).c();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.b;
            object2 = ((hz)object).b;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.d();
        n11 = ((hz)object).d();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.c;
            object2 = ((hz)object).c;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.e();
        n11 = ((hz)object).e();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.d;
            object2 = ((hz)object).d;
            n10 = ((String)object3).equals(object2);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = this.f();
        n11 = ((hz)object).f();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.a;
            n11 = ((hz)object).a;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = this.g();
        n11 = ((hz)object).g();
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.e;
            object2 = ((hz)object).e;
            n10 = (int)(((String)object3).equals(object2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.h() ? 1 : 0);
        n11 = (int)(((hz)object).h() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.b;
            n11 = ((hz)object).b;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.i() ? 1 : 0);
        n11 = (int)(((hz)object).i() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = this.c;
            n11 = ((hz)object).c;
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.j() ? 1 : 0);
        n11 = (int)(((hz)object).j() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.a;
            object2 = ((hz)object).a;
            n10 = (int)(object3.equals(object2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.k() ? 1 : 0);
        n11 = (int)(((hz)object).k() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            object3 = this.b;
            object2 = ((hz)object).b;
            n10 = (int)(object3.equals(object2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        n10 = (int)(this.m() ? 1 : 0);
        n11 = (int)(((hz)object).m() ? 1 : 0);
        if (n10 != 0 || n11 != 0) {
            if (n10 == 0 || n11 == 0) return false;
            n10 = (int)(this.a ? 1 : 0);
            n11 = (int)(((hz)object).a ? 1 : 0);
            if (n10 != n11) {
                return false;
            }
        }
        n10 = (int)(this.n() ? 1 : 0);
        n11 = (int)(((hz)object).n() ? 1 : 0);
        if (n10 == 0 && n11 == 0) return true;
        if (n10 == 0 || n11 == 0) return false;
        object3 = this.c;
        object = ((hz)object).c;
        boolean bl2 = object3.equals(object);
        if (bl2) return true;
        return false;
    }

    public int b() {
        return this.b;
    }

    public hz b(int n10) {
        this.b = n10;
        this.c(true);
        return this;
    }

    public hz b(String string2) {
        this.b = string2;
        return this;
    }

    public String b() {
        return this.b;
    }

    public Map b() {
        return this.b;
    }

    public void b(ji ji2) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        String string2;
        int n10;
        Object object;
        boolean bl5;
        boolean bl6;
        boolean bl7;
        boolean bl8;
        boolean bl9;
        boolean bl10;
        boolean bl11;
        boolean bl22;
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
        iterator2 = b;
        ji2.a((jf)((Object)iterator2));
        long l10 = this.a;
        ji2.a(l10);
        ji2.b();
        iterator2 = this.b;
        if (iterator2 != null && (bl22 = this.c())) {
            iterator2 = c;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.b;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.c) != null && (bl11 = this.d())) {
            iterator2 = d;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.c;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if ((iterator2 = this.d) != null && (bl10 = this.e())) {
            iterator2 = e;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.d;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if (bl9 = this.f()) {
            iterator2 = f;
            ji2.a((jf)((Object)iterator2));
            int n11 = this.a;
            ji2.a(n11);
            ji2.b();
        }
        if ((iterator2 = this.e) != null && (bl8 = this.g())) {
            iterator2 = g;
            ji2.a((jf)((Object)iterator2));
            iterator2 = this.e;
            ji2.a((String)((Object)iterator2));
            ji2.b();
        }
        if (bl7 = this.h()) {
            iterator2 = h;
            ji2.a((jf)((Object)iterator2));
            int n12 = this.b;
            ji2.a(n12);
            ji2.b();
        }
        if (bl6 = this.i()) {
            iterator2 = i;
            ji2.a((jf)((Object)iterator2));
            int n13 = this.c;
            ji2.a(n13);
            ji2.b();
        }
        iterator2 = this.a;
        byte by2 = 11;
        if (iterator2 != null && (bl5 = this.j())) {
            iterator2 = j;
            ji2.a((jf)((Object)iterator2));
            object = this.a;
            n10 = object.size();
            iterator2 = new Iterator(by2, by2, n10);
            ji2.a((jh)((Object)iterator2));
            iterator2 = this.a.entrySet().iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object = iterator2.next();
                string2 = (String)object.getKey();
                ji2.a(string2);
                object = (String)object.getValue();
                ji2.a((String)object);
            }
            ji2.d();
            ji2.b();
        }
        if ((iterator2 = this.b) != null && (bl4 = this.k())) {
            iterator2 = k;
            ji2.a((jf)((Object)iterator2));
            object = this.b;
            n10 = object.size();
            iterator2 = new Iterator(by2, by2, n10);
            ji2.a((jh)((Object)iterator2));
            iterator2 = this.b.entrySet().iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object = iterator2.next();
                string2 = (String)object.getKey();
                ji2.a(string2);
                object = (String)object.getValue();
                ji2.a((String)object);
            }
            ji2.d();
            ji2.b();
        }
        if (bl3 = this.m()) {
            iterator2 = l;
            ji2.a((jf)((Object)iterator2));
            boolean bl12 = this.a;
            ji2.a(bl12);
            ji2.b();
        }
        if ((iterator2 = this.c) != null && (bl2 = this.n())) {
            iterator2 = m;
            ji2.a((jf)((Object)iterator2));
            object = this.c;
            n10 = object.size();
            iterator2 = new Iterator(by2, by2, n10);
            ji2.a((jh)((Object)iterator2));
            iterator2 = this.c.entrySet().iterator();
            while ((by2 = (byte)(iterator2.hasNext() ? 1 : 0)) != 0) {
                Object object2 = iterator2.next();
                object = (String)object2.getKey();
                ji2.a((String)object);
                object2 = (String)object2.getValue();
                ji2.a((String)object2);
            }
            ji2.d();
            ji2.b();
        }
        ji2.c();
        ji2.a();
    }

    public void b(String string2, String string3) {
        HashMap hashMap = this.b;
        if (hashMap == null) {
            this.b = hashMap = new HashMap();
        }
        this.b.put(string2, string3);
    }

    public void b(boolean bl2) {
        this.a.set(1, bl2);
    }

    public boolean b() {
        return this.a.get(0);
    }

    public int c() {
        return this.c;
    }

    public hz c(int n10) {
        this.c = n10;
        this.d(true);
        return this;
    }

    public hz c(String string2) {
        this.c = string2;
        return this;
    }

    public String c() {
        return this.c;
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
        object = (hz)object;
        return this.a((hz)object);
    }

    public hz d(String string2) {
        this.d = string2;
        return this;
    }

    public String d() {
        return this.d;
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
        boolean bl2 = object instanceof hz;
        if (bl2) {
            object = (hz)object;
            return this.a((hz)object);
        }
        return false;
    }

    public boolean f() {
        return this.a.get(1);
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
        return this.a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.a.get(3);
    }

    public boolean j() {
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

    public boolean k() {
        boolean bl2;
        Map map = this.b;
        if (map != null) {
            bl2 = true;
        } else {
            bl2 = false;
            map = null;
        }
        return bl2;
    }

    public boolean l() {
        return this.a;
    }

    public boolean m() {
        return this.a.get(4);
    }

    public boolean n() {
        boolean bl2;
        Map map = this.c;
        if (map != null) {
            bl2 = true;
        } else {
            bl2 = false;
            map = null;
        }
        return bl2;
    }

    public String toString() {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        boolean bl7;
        boolean bl8;
        boolean bl9;
        boolean bl10;
        boolean bl11;
        StringBuilder stringBuilder = new StringBuilder("PushMetaInfo(");
        stringBuilder.append("id:");
        Object object = this.a;
        String string2 = "null";
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        object = ", ";
        stringBuilder.append((String)object);
        Object object2 = "messageTs:";
        stringBuilder.append((String)object2);
        long l10 = this.a;
        stringBuilder.append(l10);
        boolean bl22 = this.c();
        if (bl22) {
            stringBuilder.append((String)object);
            stringBuilder.append("topic:");
            object2 = this.b;
            if (object2 == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object2);
            }
        }
        if (bl11 = this.d()) {
            stringBuilder.append((String)object);
            stringBuilder.append("title:");
            object2 = this.c;
            if (object2 == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object2);
            }
        }
        if (bl10 = this.e()) {
            stringBuilder.append((String)object);
            stringBuilder.append("description:");
            object2 = this.d;
            if (object2 == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object2);
            }
        }
        if (bl9 = this.f()) {
            stringBuilder.append((String)object);
            object2 = "notifyType:";
            stringBuilder.append((String)object2);
            int n10 = this.a;
            stringBuilder.append(n10);
        }
        if (bl8 = this.g()) {
            stringBuilder.append((String)object);
            stringBuilder.append("url:");
            object2 = this.e;
            if (object2 == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object2);
            }
        }
        if (bl7 = this.h()) {
            stringBuilder.append((String)object);
            object2 = "passThrough:";
            stringBuilder.append((String)object2);
            int n11 = this.b;
            stringBuilder.append(n11);
        }
        if (bl6 = this.i()) {
            stringBuilder.append((String)object);
            object2 = "notifyId:";
            stringBuilder.append((String)object2);
            int n12 = this.c;
            stringBuilder.append(n12);
        }
        if (bl5 = this.j()) {
            stringBuilder.append((String)object);
            stringBuilder.append("extra:");
            object2 = this.a;
            if (object2 == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object2);
            }
        }
        if (bl4 = this.k()) {
            stringBuilder.append((String)object);
            stringBuilder.append("internal:");
            object2 = this.b;
            if (object2 == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object2);
            }
        }
        if (bl3 = this.m()) {
            stringBuilder.append((String)object);
            object2 = "ignoreRegInfo:";
            stringBuilder.append((String)object2);
            boolean bl12 = this.a;
            stringBuilder.append(bl12);
        }
        if (bl2 = this.n()) {
            stringBuilder.append((String)object);
            stringBuilder.append("apsProperFields:");
            object = this.c;
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

