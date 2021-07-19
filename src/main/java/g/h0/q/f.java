/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.q.f$a;

public final class f {
    private static final String g = "Sec-WebSocket-Extensions";
    public static final f$a h;
    public final boolean a;
    public final Integer b;
    public final boolean c;
    public final Integer d;
    public final boolean e;
    public final boolean f;

    static {
        f$a f$a;
        h = f$a = new f$a(null);
    }

    public f() {
        this(false, null, false, null, false, false, 63, null);
    }

    public f(boolean bl2, Integer n10, boolean bl3, Integer n11, boolean bl4, boolean bl5) {
        this.a = bl2;
        this.b = n10;
        this.c = bl3;
        this.d = n11;
        this.e = bl4;
        this.f = bl5;
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ f(boolean bl2, Integer n10, boolean bl3, Integer n11, boolean bl4, boolean bl5, int n12, u u10) {
        int bl6;
        void var5_10;
        void var3_8;
        void var2_7;
        int bl7;
        int n13 = bl7 & 1;
        n13 = n13 != 0 ? 0 : (int)(bl2 ? 1 : 0);
        int n14 = bl7 & 2;
        Integer n15 = null;
        Object object = n14 != 0 ? null : var2_7;
        int n16 = bl7 & 4;
        boolean bl8 = n16 != 0 ? false : var3_8;
        int n17 = bl7 & 8;
        if (n17 == 0) {
            void var4_9;
            n15 = var4_9;
        }
        int n18 = bl7 & 0x10;
        int bl9 = n18 != 0 ? 0 : var5_10;
        int n19 = bl7 & 0x20;
        bl7 = n19 != 0 ? 0 : bl6;
        bl6 = bl9;
        this(n13 != 0, (Integer)object, bl8, n15, (boolean)bl9, (boolean)bl7);
    }

    public static /* synthetic */ f h(f f10, boolean bl2, Integer object, boolean bl3, Integer object2, boolean bl4, boolean bl5, int n10, Object object3) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            bl2 = f10.a;
        }
        if ((n11 = n10 & 2) != 0) {
            object = f10.b;
        }
        object3 = object;
        int n12 = n10 & 4;
        if (n12 != 0) {
            bl3 = f10.c;
        }
        boolean bl6 = bl3;
        n12 = n10 & 8;
        if (n12 != 0) {
            object2 = f10.d;
        }
        Integer n13 = object2;
        n12 = n10 & 0x10;
        if (n12 != 0) {
            bl4 = f10.e;
        }
        boolean bl7 = bl4;
        n12 = n10 & 0x20;
        if (n12 != 0) {
            bl5 = f10.f;
        }
        object = f10;
        bl3 = bl2;
        object2 = object3;
        bl4 = bl6;
        n10 = (int)(bl7 ? 1 : 0);
        n11 = (int)(bl5 ? 1 : 0);
        return f10.g(bl2, (Integer)object3, bl6, n13, bl7, bl5);
    }

    public final boolean a() {
        return this.a;
    }

    public final Integer b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final Integer d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object object) {
        block2: {
            block3: {
                boolean bl2;
                Integer n10;
                Integer n11;
                if (this == object) break block2;
                boolean bl3 = object instanceof f;
                if (!bl3) break block3;
                object = (f)object;
                bl3 = this.a;
                boolean bl4 = ((f)object).a;
                if (bl3 == bl4 && (bl3 = f0.g(n11 = this.b, n10 = ((f)object).b)) && (bl3 = this.c) == (bl4 = ((f)object).c) && (bl3 = f0.g(n11 = this.d, n10 = ((f)object).d)) && (bl3 = this.e) == (bl4 = ((f)object).e) && (bl3 = this.f) == (bl2 = ((f)object).f)) break block2;
            }
            return false;
        }
        return true;
    }

    public final boolean f() {
        return this.f;
    }

    public final f g(boolean bl2, Integer n10, boolean bl3, Integer n11, boolean bl4, boolean bl5) {
        f f10 = new f(bl2, n10, bl3, n11, bl4, bl5);
        return f10;
    }

    public int hashCode() {
        int n10;
        int n11;
        boolean n112 = this.a;
        int n12 = 1;
        if (n112) {
            n11 = n12;
        }
        void var1_3 = n11 * 31;
        Integer n13 = this.b;
        int n14 = 0;
        if (n13 != null) {
            n10 = ((Object)n13).hashCode();
        } else {
            n10 = 0;
            n13 = null;
        }
        void var1_4 = (var1_3 + n10) * 31;
        n10 = (int)(this.c ? 1 : 0);
        if (n10 != 0) {
            n10 = n12;
        }
        void var1_5 = (var1_4 + n10) * 31;
        n13 = this.d;
        if (n13 != null) {
            n14 = ((Object)n13).hashCode();
        }
        void var1_6 = (var1_5 + n14) * 31;
        n10 = (int)(this.e ? 1 : 0);
        if (n10 != 0) {
            n10 = n12;
        }
        void var1_7 = (var1_6 + n10) * 31;
        n10 = (int)(this.f ? 1 : 0);
        if (n10 == 0) {
            n12 = n10;
        }
        return (int)(var1_7 + n12);
    }

    public final boolean i(boolean bl2) {
        bl2 = bl2 ? this.c : this.e;
        return bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WebSocketExtensions(perMessageDeflate=");
        boolean bl2 = this.a;
        stringBuilder.append(bl2);
        stringBuilder.append(", clientMaxWindowBits=");
        Integer n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", clientNoContextTakeover=");
        bl2 = this.c;
        stringBuilder.append(bl2);
        stringBuilder.append(", serverMaxWindowBits=");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append(", serverNoContextTakeover=");
        bl2 = this.e;
        stringBuilder.append(bl2);
        stringBuilder.append(", unknownValues=");
        bl2 = this.f;
        stringBuilder.append(bl2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

