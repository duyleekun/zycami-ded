/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.t;

import d.n.a.d0;
import d.n.a.d0$b;

public class a {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final d0$b f;

    public a(int n10, int n11, int n12, boolean bl2, boolean bl3, d0$b d0$b) {
        this.a = n10;
        this.b = n11;
        this.c = n12;
        this.d = bl2;
        this.e = bl3;
        this.f = d0$b;
    }

    /*
     * WARNING - void declaration
     */
    public a a(d0 object) {
        void var3_17;
        void var3_14;
        void var3_11;
        void var3_8;
        void var3_5;
        Object object2 = ((d0)object).a();
        if (object2 != null) {
            object2 = ((d0)object).a();
            int bl2 = (Integer)object2;
        } else {
            int n10 = this.a;
        }
        void var4_18 = var3_5;
        object2 = ((d0)object).c();
        if (object2 != null) {
            object2 = ((d0)object).c();
            int n11 = (Integer)object2;
        } else {
            int n12 = this.b;
        }
        void var5_19 = var3_8;
        object2 = ((d0)object).f();
        if (object2 != null) {
            object2 = ((d0)object).f();
            int n13 = (Integer)object2;
        } else {
            int n14 = this.c;
        }
        void var6_20 = var3_11;
        object2 = ((d0)object).d();
        if (object2 != null) {
            object2 = ((d0)object).d();
            boolean bl2 = (Boolean)object2;
        } else {
            boolean bl3 = this.d;
        }
        void var7_21 = var3_14;
        object2 = ((d0)object).e();
        if (object2 != null) {
            object2 = ((d0)object).e();
            boolean bl4 = (Boolean)object2;
        } else {
            boolean bl5 = this.e;
        }
        void var8_22 = var3_17;
        object2 = ((d0)object).b();
        object = object2 != null ? ((d0)object).b() : this.f;
        Object object3 = object;
        object = new a((int)var4_18, (int)var5_19, (int)var6_20, (boolean)var7_21, (boolean)var8_22, (d0$b)object3);
        return object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LoggerSetup{logLevel=");
        int bl2 = this.a;
        stringBuilder.append(bl2);
        stringBuilder.append(", macAddressLogSetting=");
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", uuidLogSetting=");
        int n11 = this.c;
        stringBuilder.append(n11);
        stringBuilder.append(", shouldLogAttributeValues=");
        boolean bl3 = this.d;
        stringBuilder.append(bl3);
        stringBuilder.append(", shouldLogScannedPeripherals=");
        boolean bl4 = this.e;
        stringBuilder.append(bl4);
        stringBuilder.append(", logger=");
        d0$b d0$b = this.f;
        stringBuilder.append(d0$b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

