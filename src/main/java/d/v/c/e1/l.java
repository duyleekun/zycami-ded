/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.c.e1;

import android.graphics.Bitmap;
import d.v.c.e1.u;

public final class l
implements Runnable {
    public final /* synthetic */ u a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ String c;

    public /* synthetic */ l(u u10, Bitmap bitmap, String string2) {
        this.a = u10;
        this.b = bitmap;
        this.c = string2;
    }

    public final void run() {
        u u10 = this.a;
        Bitmap bitmap = this.b;
        String string2 = this.c;
        u10.H(bitmap, string2);
    }
}

