/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.r;

import android.graphics.Bitmap;
import d.v.r.e$a;

public final class a
implements Runnable {
    public final /* synthetic */ e$a a;
    public final /* synthetic */ Bitmap b;

    public /* synthetic */ a(e$a a10, Bitmap bitmap) {
        this.a = a10;
        this.b = bitmap;
    }

    public final void run() {
        e$a e$a = this.a;
        Bitmap bitmap = this.b;
        e$a.s(bitmap);
    }
}

