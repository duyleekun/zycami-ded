/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ib;
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
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class il
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
    public long a;
    public ib a;
    public String a;
    public ByteBuffer a;
    private BitSet a;
    public Map a;
    public boolean a;
    public String b;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    static {
        Object object = new jn("XmPushActionNotification");
        a = object;
        String string2 = "";
        byte by2 = 11;
        a = object = new jf(string2, by2, 1);
        byte by3 = 12;
        byte by4 = 2;
        b = object = new jf(string2, by3, by4);
        c = object = new jf(string2, by2, 3);
        d = object = new jf(string2, by2, 4);
        e = object = new jf(string2, by2, 5);
        f = object = new jf(string2, by4, 6);
        g = object = new jf(string2, by2, 7);
        byte by5 = 13;
        h = object = new jf(string2, by5, 8);
        i = object = new jf(string2, by2, 9);
        byte by6 = 10;
        j = object = new jf(string2, by2, by6);
        k = object = new jf(string2, by2, by3);
        l = object = new jf(string2, by2, by5);
        m = object = new jf(string2, by2, 14);
        n = object = new jf(string2, by6, 15);
        o = object = new jf(string2, by4, 20);
    }

    public il() {
        BitSet bitSet;
        this.a = bitSet = new BitSet(3);
        this.a = true;
        this.b = false;
    }

    public il(String string2, boolean bl2) {
        this();
        this.b = string2;
        this.a = bl2;
        this.a(true);
    }

    public int a(il object) {
        long l10;
        long l11;
        boolean bl2;
        Object object2;
        Constable constable = this.getClass();
        int n10 = constable.equals(object2 = object.getClass());
        if (!n10) {
            constable = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)((Object)constable)).compareTo((String)object);
        }
        constable = this.a();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).a())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.a() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.a)), (String)(object2 = ((il)object).a)))) {
            return n10;
        }
        constable = this.b();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).b())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.b() ? 1 : 0);
        if (n10 && (n10 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((il)object).a)))) {
            return n10;
        }
        constable = this.c();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).c())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.c() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.b)), (String)(object2 = ((il)object).b)))) {
            return n10;
        }
        constable = this.d();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).d())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.d() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.c)), (String)(object2 = ((il)object).c)))) {
            return n10;
        }
        constable = this.e();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).e())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.e() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.d)), (String)(object2 = ((il)object).d)))) {
            return n10;
        }
        constable = this.f();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).f())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.f() ? 1 : 0);
        if (n10) {
            n10 = (int)(this.a ? 1 : 0);
            bl2 = ((il)object).a;
            if (n10 = iy.a(n10 != 0, bl2)) {
                return n10;
            }
        }
        if (n10 = ((Boolean)(constable = Boolean.valueOf(this.g()))).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).g())))) {
            return n10;
        }
        n10 = (int)(this.g() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.e)), (String)(object2 = ((il)object).e)))) {
            return n10;
        }
        constable = this.h();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).h())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.h() ? 1 : 0);
        if (n10 && (n10 = iy.a((Map)((Object)(constable = this.a)), (Map)(object2 = ((il)object).a)))) {
            return n10;
        }
        constable = this.i();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).i())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.i() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.f)), (String)(object2 = ((il)object).f)))) {
            return n10;
        }
        constable = this.j();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).j())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.j() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.g)), (String)(object2 = ((il)object).g)))) {
            return n10;
        }
        constable = this.k();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).k())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.k() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.h)), (String)(object2 = ((il)object).h)))) {
            return n10;
        }
        constable = this.l();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).l())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.l() ? 1 : 0);
        if (n10 && (n10 = iy.a((String)((Object)(constable = this.i)), (String)(object2 = ((il)object).i)))) {
            return n10;
        }
        constable = this.m();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).m())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.m() ? 1 : 0);
        if (n10 && (n10 = iy.a((Comparable)((Object)(constable = this.a)), (Comparable)(object2 = ((il)object).a)))) {
            return n10;
        }
        constable = this.n();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).n())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.n() ? 1 : 0);
        if (n10 && (n10 = iy.a(l11 = this.a, l10 = ((il)object).a))) {
            return n10;
        }
        constable = this.o();
        n10 = ((Boolean)constable).compareTo((Boolean)(object2 = Boolean.valueOf(bl2 = ((il)object).o())));
        if (n10) {
            return n10;
        }
        n10 = (int)(this.o() ? 1 : 0);
        if (n10) {
            n10 = (int)(this.b ? 1 : 0);
            int n11 = ((il)object).b;
            if ((n11 = iy.a(n10 != 0, n11 != 0)) != 0) {
                return n11;
            }
        }
        return 0;
    }

    public il a(String string2) {
        this.b = string2;
        return this;
    }

    public il a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        return this;
    }

    public il a(Map map) {
        this.a = map;
        return this;
    }

    public il a(boolean bl2) {
        this.a = bl2;
        this.a(true);
        return this;
    }

    public il a(byte[] object) {
        object = ByteBuffer.wrap(object);
        this.a((ByteBuffer)object);
        return this;
    }

    public String a() {
        return this.b;
    }

    public Map a() {
        return this.a;
    }

    public void a() {
        Object object = this.b;
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
     * Enabled aggressive block sorting
     */
    public void a(ji object) {
        ((ji)object).a();
        while (true) {
            block21: {
                HashMap hashMap;
                Object object2 = ((ji)object).a();
                int n10 = ((jf)object2).a;
                if (n10 == 0) {
                    ((ji)object).f();
                    boolean bl2 = this.f();
                    if (bl2) {
                        this.a();
                        return;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Required field 'requireAck' was not found in serialized data! Struct: ");
                    hashMap = this.toString();
                    ((StringBuilder)object2).append((String)((Object)hashMap));
                    object2 = ((StringBuilder)object2).toString();
                    object = new jj((String)object2);
                    throw object;
                }
                int n11 = ((jf)object2).a;
                int n12 = 2;
                int n13 = 1;
                int n14 = 11;
                switch (n11) {
                    case 20: {
                        if (n10 != n12) break;
                        n11 = (int)(((ji)object).a() ? 1 : 0);
                        this.b = n11;
                        this.c(n13 != 0);
                        break block21;
                    }
                    case 15: {
                        long l10;
                        n11 = 10;
                        if (n10 != n11) break;
                        this.a = l10 = ((ji)object).a();
                        this.b(n13 != 0);
                        break block21;
                    }
                    case 14: {
                        if (n10 != n14) break;
                        this.a = object2 = ((ji)object).a();
                        break block21;
                    }
                    case 13: {
                        if (n10 != n14) break;
                        this.i = object2 = ((ji)object).a();
                        break block21;
                    }
                    case 12: {
                        if (n10 != n14) break;
                        this.h = object2 = ((ji)object).a();
                        break block21;
                    }
                    case 10: {
                        if (n10 != n14) break;
                        this.g = object2 = ((ji)object).a();
                        break block21;
                    }
                    case 9: {
                        if (n10 != n14) break;
                        this.f = object2 = ((ji)object).a();
                        break block21;
                    }
                    case 8: {
                        n11 = 13;
                        if (n10 != n11) break;
                        object2 = ((ji)object).a();
                        n13 = ((jh)object2).a * n12;
                        this.a = hashMap = new HashMap(n13);
                        hashMap = null;
                        for (n10 = 0; n10 < (n12 = ((jh)object2).a); ++n10) {
                            String string2 = ((ji)object).a();
                            String string3 = ((ji)object).a();
                            Map map = this.a;
                            map.put(string2, string3);
                        }
                        ((ji)object).h();
                        break block21;
                    }
                    case 7: {
                        if (n10 != n14) break;
                        this.e = object2 = ((ji)object).a();
                        break block21;
                    }
                    case 6: {
                        if (n10 != n12) break;
                        n11 = (int)(((ji)object).a() ? 1 : 0);
                        this.a = n11;
                        this.a(n13 != 0);
                        break block21;
                    }
                    case 5: {
                        if (n10 != n14) break;
                        this.d = object2 = ((ji)object).a();
                        break block21;
                    }
                    case 4: {
                        if (n10 != n14) break;
                        this.c = object2 = ((ji)object).a();
                        break block21;
                    }
                    case 3: {
                        if (n10 != n14) break;
                        this.b = object2 = ((ji)object).a();
                        break block21;
                    }
                    case 2: {
                        n11 = 12;
                        if (n10 != n11) break;
                        this.a = object2 = new ib();
                        ((ib)object2).a((ji)object);
                        break block21;
                    }
                    case 1: {
                        if (n10 != n14) break;
                        this.a = object2 = ((ji)object).a();
                        break block21;
                    }
                }
                jl.a((ji)object, (byte)n10);
            }
            ((ji)object).g();
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
    public boolean a(il il2) {
        boolean bl2;
        Object object;
        Object object2;
        if (il2 == null) {
            return false;
        }
        boolean bl3 = this.a();
        boolean bl4 = il2.a();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) return false;
            object2 = this.a;
            object = il2.a;
            boolean bl5 = ((String)object2).equals(object);
            if (!bl5) {
                return false;
            }
        }
        boolean bl6 = this.b();
        bl4 = il2.b();
        if (bl6 || bl4) {
            if (!bl6 || !bl4) return false;
            object2 = this.a;
            object = il2.a;
            boolean bl7 = ((ib)object2).a((ib)object);
            if (!bl7) {
                return false;
            }
        }
        boolean bl8 = this.c();
        bl4 = il2.c();
        if (bl8 || bl4) {
            if (!bl8 || !bl4) return false;
            object2 = this.b;
            object = il2.b;
            boolean bl9 = ((String)object2).equals(object);
            if (!bl9) {
                return false;
            }
        }
        boolean bl10 = this.d();
        bl4 = il2.d();
        if (bl10 || bl4) {
            if (!bl10 || !bl4) return false;
            object2 = this.c;
            object = il2.c;
            boolean bl11 = ((String)object2).equals(object);
            if (!bl11) {
                return false;
            }
        }
        boolean bl12 = this.e();
        bl4 = il2.e();
        if (bl12 || bl4) {
            if (!bl12 || !bl4) return false;
            object2 = this.d;
            object = il2.d;
            boolean bl13 = ((String)object2).equals(object);
            if (!bl13) {
                return false;
            }
        }
        if ((bl2 = this.a) != (bl4 = il2.a)) {
            return false;
        }
        boolean bl14 = this.g();
        bl4 = il2.g();
        if (bl14 || bl4) {
            if (!bl14 || !bl4) return false;
            object2 = this.e;
            object = il2.e;
            boolean bl15 = ((String)object2).equals(object);
            if (!bl15) {
                return false;
            }
        }
        boolean bl16 = this.h();
        bl4 = il2.h();
        if (bl16 || bl4) {
            if (!bl16 || !bl4) return false;
            object2 = this.a;
            object = il2.a;
            boolean bl17 = object2.equals(object);
            if (!bl17) {
                return false;
            }
        }
        boolean bl18 = this.i();
        bl4 = il2.i();
        if (bl18 || bl4) {
            if (!bl18 || !bl4) return false;
            object2 = this.f;
            object = il2.f;
            boolean bl19 = ((String)object2).equals(object);
            if (!bl19) {
                return false;
            }
        }
        boolean bl20 = this.j();
        bl4 = il2.j();
        if (bl20 || bl4) {
            if (!bl20 || !bl4) return false;
            object2 = this.g;
            object = il2.g;
            boolean bl21 = ((String)object2).equals(object);
            if (!bl21) {
                return false;
            }
        }
        boolean bl22 = this.k();
        bl4 = il2.k();
        if (bl22 || bl4) {
            if (!bl22 || !bl4) return false;
            object2 = this.h;
            object = il2.h;
            boolean bl23 = ((String)object2).equals(object);
            if (!bl23) {
                return false;
            }
        }
        boolean bl24 = this.l();
        bl4 = il2.l();
        if (bl24 || bl4) {
            if (!bl24 || !bl4) return false;
            object2 = this.i;
            object = il2.i;
            boolean bl25 = ((String)object2).equals(object);
            if (!bl25) {
                return false;
            }
        }
        boolean bl26 = this.m();
        bl4 = il2.m();
        if (bl26 || bl4) {
            if (!bl26 || !bl4) return false;
            object2 = this.a;
            object = il2.a;
            boolean bl27 = ((ByteBuffer)object2).equals(object);
            if (!bl27) {
                return false;
            }
        }
        boolean bl28 = this.n();
        bl4 = il2.n();
        if (bl28 || bl4) {
            if (!bl28 || !bl4) return false;
            long l10 = this.a;
            long l11 = il2.a;
            long l12 = l10 - l11;
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 != false) {
                return false;
            }
        }
        boolean bl29 = this.o();
        bl4 = il2.o();
        if (!bl29 && !bl4) return true;
        if (!bl29 || !bl4) return false;
        boolean bl30 = this.b;
        boolean bl31 = il2.b;
        if (bl30 == bl31) return true;
        return false;
    }

    public byte[] a() {
        ByteBuffer byteBuffer = iy.a(this.a);
        this.a(byteBuffer);
        return this.a.array();
    }

    public il b(String string2) {
        this.c = string2;
        return this;
    }

    public String b() {
        return this.c;
    }

    public void b(ji ji2) {
        boolean bl2;
        this.a();
        Object object = a;
        ji2.a((jn)object);
        object = this.a;
        if (object != null && (bl2 = this.a())) {
            object = a;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.a) != null && (bl2 = this.b())) {
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
        if ((object = this.c) != null && (bl2 = this.d())) {
            object = d;
            ji2.a((jf)object);
            object = this.c;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.d) != null && (bl2 = this.e())) {
            object = e;
            ji2.a((jf)object);
            object = this.d;
            ji2.a((String)object);
            ji2.b();
        }
        object = f;
        ji2.a((jf)object);
        bl2 = this.a;
        ji2.a(bl2);
        ji2.b();
        object = this.e;
        if (object != null && (bl2 = this.g())) {
            object = g;
            ji2.a((jf)object);
            object = this.e;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.a) != null && (bl2 = this.h())) {
            object = h;
            ji2.a((jf)object);
            Object object2 = this.a;
            int n10 = object2.size();
            byte by2 = 11;
            object = new jh(by2, by2, n10);
            ji2.a((jh)object);
            object = this.a.entrySet().iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (Map.Entry)object.next();
                String string2 = (String)object2.getKey();
                ji2.a(string2);
                object2 = (String)object2.getValue();
                ji2.a((String)object2);
            }
            ji2.d();
            ji2.b();
        }
        if ((object = this.f) != null && (bl2 = this.i())) {
            object = i;
            ji2.a((jf)object);
            object = this.f;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.g) != null && (bl2 = this.j())) {
            object = j;
            ji2.a((jf)object);
            object = this.g;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.h) != null && (bl2 = this.k())) {
            object = k;
            ji2.a((jf)object);
            object = this.h;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.i) != null && (bl2 = this.l())) {
            object = l;
            ji2.a((jf)object);
            object = this.i;
            ji2.a((String)object);
            ji2.b();
        }
        if ((object = this.a) != null && (bl2 = this.m())) {
            object = m;
            ji2.a((jf)object);
            object = this.a;
            ji2.a((ByteBuffer)object);
            ji2.b();
        }
        if (bl2 = this.n()) {
            object = n;
            ji2.a((jf)object);
            long l10 = this.a;
            ji2.a(l10);
            ji2.b();
        }
        if (bl2 = this.o()) {
            object = o;
            ji2.a((jf)object);
            bl2 = this.b;
            ji2.a(bl2);
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

    public il c(String string2) {
        this.d = string2;
        return this;
    }

    public String c() {
        return this.f;
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
        object = (il)object;
        return this.a((il)object);
    }

    public il d(String string2) {
        this.f = string2;
        return this;
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
        boolean bl2 = object instanceof il;
        if (bl2) {
            object = (il)object;
            return this.a((il)object);
        }
        return false;
    }

    public boolean f() {
        return this.a.get(0);
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
        Map map = this.a;
        if (map != null) {
            bl2 = true;
        } else {
            bl2 = false;
            map = null;
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

    public boolean n() {
        return this.a.get(1);
    }

    public boolean o() {
        return this.a.get(2);
    }

    public String toString() {
        Object object = "XmPushActionNotification(";
        StringBuilder stringBuilder = new StringBuilder((String)object);
        boolean bl2 = this.a();
        boolean bl3 = false;
        String string2 = "null";
        if (bl2) {
            stringBuilder.append("debug:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        boolean bl4 = this.b();
        String string3 = ", ";
        if (bl4) {
            if (!bl2) {
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
            bl3 = bl2;
        }
        if (!bl3) {
            stringBuilder.append(string3);
        }
        stringBuilder.append("id:");
        object = this.b;
        if (object == null) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append((String)object);
        }
        bl2 = this.d();
        if (bl2) {
            stringBuilder.append(string3);
            stringBuilder.append("appId:");
            object = this.c;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.e()) {
            stringBuilder.append(string3);
            stringBuilder.append("type:");
            object = this.d;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        stringBuilder.append(string3);
        object = "requireAck:";
        stringBuilder.append((String)object);
        bl2 = this.a;
        stringBuilder.append(bl2);
        bl2 = this.g();
        if (bl2) {
            stringBuilder.append(string3);
            stringBuilder.append("payload:");
            object = this.e;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.h()) {
            stringBuilder.append(string3);
            stringBuilder.append("extra:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(object);
            }
        }
        if (bl2 = this.i()) {
            stringBuilder.append(string3);
            stringBuilder.append("packageName:");
            object = this.f;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.j()) {
            stringBuilder.append(string3);
            stringBuilder.append("category:");
            object = this.g;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.k()) {
            stringBuilder.append(string3);
            stringBuilder.append("regId:");
            object = this.h;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.l()) {
            stringBuilder.append(string3);
            stringBuilder.append("aliasName:");
            object = this.i;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)object);
            }
        }
        if (bl2 = this.m()) {
            stringBuilder.append(string3);
            stringBuilder.append("binaryExtra:");
            object = this.a;
            if (object == null) {
                stringBuilder.append(string2);
            } else {
                iy.a((ByteBuffer)object, stringBuilder);
            }
        }
        if (bl2 = this.n()) {
            stringBuilder.append(string3);
            object = "createdTs:";
            stringBuilder.append((String)object);
            long l10 = this.a;
            stringBuilder.append(l10);
        }
        if (bl2 = this.o()) {
            stringBuilder.append(string3);
            object = "alreadyLogClickInXmq:";
            stringBuilder.append((String)object);
            bl2 = this.b;
            stringBuilder.append(bl2);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

