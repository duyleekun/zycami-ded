/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.l2.f;

public final class d
implements f {
    private final double a;
    private final double b;

    public d(double d10, double d11) {
        this.a = d10;
        this.b = d11;
    }

    public boolean a(double d10) {
        double d11;
        int n10;
        double d12 = this.a;
        double d13 = d10 - d12;
        Object object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        n10 = object >= 0 && (n10 = (d11 = d10 - (d12 = this.b)) == 0.0 ? 0 : (d11 < 0.0 ? -1 : 1)) <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public Double d() {
        return this.b;
    }

    public Double e() {
        return this.a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        boolean bl2 = object instanceof d;
        if (!bl2) return false;
        boolean bl3 = this.isEmpty();
        if (bl3) {
            Object object2 = object;
            object2 = (d)object;
            boolean bl4 = ((d)object2).isEmpty();
            if (bl4) return true;
        }
        double d10 = this.a;
        object = (d)object;
        double d11 = ((d)object).a;
        double d12 = d10 - d11;
        Object object3 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object3 != false) return false;
        d10 = this.b;
        d11 = ((d)object).b;
        double d13 = d10 - d11;
        Object object4 = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        if (object4) return false;
        return true;
    }

    public boolean f(double d10, double d11) {
        Object object = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
        object = object <= 0 ? (Object)true : (Object)false;
        return (boolean)object;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
        } else {
            double d10 = this.a;
            Double d11 = d10;
            n10 = ((Object)d11).hashCode() * 31;
            double d12 = this.b;
            Double d13 = d12;
            int n11 = ((Object)d13).hashCode();
            n10 += n11;
        }
        return n10;
    }

    public boolean isEmpty() {
        double d10 = this.a;
        double d11 = this.b;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        object = object > 0 ? (Object)true : (Object)false;
        return (boolean)object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        double d10 = this.a;
        stringBuilder.append(d10);
        stringBuilder.append("..");
        d10 = this.b;
        stringBuilder.append(d10);
        return stringBuilder.toString();
    }
}

