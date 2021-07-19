/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 */
package d.c.a.o.k.a0;

import android.graphics.Bitmap;
import d.c.a.o.k.a0.d;

public class d$a {
    private final int a;
    private final int b;
    private Bitmap.Config c;
    private int d;

    public d$a(int n10) {
        this(n10, n10);
    }

    public d$a(int n10, int n11) {
        int n12;
        this.d = n12 = 1;
        if (n10 > 0) {
            if (n11 > 0) {
                this.a = n10;
                this.b = n11;
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Height must be > 0");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Width must be > 0");
        throw illegalArgumentException;
    }

    public d a() {
        int n10 = this.a;
        int n11 = this.b;
        Bitmap.Config config = this.c;
        int n12 = this.d;
        d d10 = new d(n10, n11, config, n12);
        return d10;
    }

    public Bitmap.Config b() {
        return this.c;
    }

    public d$a c(Bitmap.Config config) {
        this.c = config;
        return this;
    }

    public d$a d(int n10) {
        if (n10 > 0) {
            this.d = n10;
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Weight must be > 0");
        throw illegalArgumentException;
    }
}

