/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.c.s0.a7;

import android.graphics.Bitmap;
import d.v.c.s0.a7.e1;
import d.v.l.f;

public class e1$b
extends f {
    public final /* synthetic */ e1 b;

    public e1$b(e1 e12) {
        this.b = e12;
    }

    public void b() {
    }

    public void e(Bitmap bitmap) {
        int n10 = bitmap.getWidth();
        int n11 = bitmap.getHeight();
        e1 e12 = this.b;
        float f10 = (float)n10 * 1.0f;
        float f11 = n11;
        e1.H(e12, f10 /= f11);
        e1.C((e1)this.b).d.setImageBitmap(bitmap);
    }
}

