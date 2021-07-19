/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package d.v.b.d0;

import android.graphics.drawable.Drawable;
import d.v.b.d0.j;

public final class c
implements Runnable {
    public final /* synthetic */ j a;
    public final /* synthetic */ Drawable b;

    public /* synthetic */ c(j j10, Drawable drawable2) {
        this.a = j10;
        this.b = drawable2;
    }

    public final void run() {
        j j10 = this.a;
        Drawable drawable2 = this.b;
        j10.K(drawable2);
    }
}

