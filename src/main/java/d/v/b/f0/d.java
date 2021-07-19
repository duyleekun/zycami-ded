/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 */
package d.v.b.f0;

import android.graphics.Matrix;
import d.v.b.f0.j;

public final class d
implements Runnable {
    public final /* synthetic */ j a;
    public final /* synthetic */ Matrix b;

    public /* synthetic */ d(j j10, Matrix matrix) {
        this.a = j10;
        this.b = matrix;
    }

    public final void run() {
        j j10 = this.a;
        Matrix matrix = this.b;
        j10.r(matrix);
    }
}

