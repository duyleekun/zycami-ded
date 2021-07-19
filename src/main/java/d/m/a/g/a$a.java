/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package d.m.a.g;

import android.graphics.Bitmap;
import d.m.a.g.a$e;

public class a$a
implements a$e {
    public Bitmap a(int n10, int n11) {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        return Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
    }

    public void b(Bitmap bitmap) {
    }
}

