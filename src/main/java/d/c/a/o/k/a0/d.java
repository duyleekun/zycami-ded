/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 */
package d.c.a.o.k.a0;

import android.graphics.Bitmap;
import d.c.a.u.k;

public final class d {
    public static final Bitmap.Config e = Bitmap.Config.RGB_565;
    private final int a;
    private final int b;
    private final Bitmap.Config c;
    private final int d;

    public d(int n10, int n11, Bitmap.Config config, int n12) {
        this.c = config = (Bitmap.Config)k.e(config, "Config must not be null");
        this.a = n10;
        this.b = n11;
        this.d = n12;
    }

    public Bitmap.Config a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.a;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof d;
        boolean bl2 = false;
        if (n10 != 0) {
            Bitmap.Config config;
            object = (d)object;
            n10 = this.b;
            int n11 = ((d)object).b;
            if (n10 == n11 && (n10 = this.a) == (n11 = ((d)object).a) && (n10 = this.d) == (n11 = ((d)object).d) && (config = this.c) == (object = ((d)object).c)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.a * 31;
        int n11 = this.b;
        n10 = (n10 + n11) * 31;
        n11 = this.c.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.d;
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PreFillSize{width=");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", height=");
        n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", config=");
        Bitmap.Config config = this.c;
        stringBuilder.append(config);
        stringBuilder.append(", weight=");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

