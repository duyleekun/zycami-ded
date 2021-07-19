/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 */
package d.v.b.d0;

import android.view.ScaleGestureDetector;
import d.v.b.d0.j;
import d.v.b.d0.j$a;

public class j$d
extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    public final /* synthetic */ j a;

    private j$d(j j10) {
        this.a = j10;
    }

    public /* synthetic */ j$d(j j10, j$a j$a) {
        this(j10);
    }

    public boolean onScale(ScaleGestureDetector object) {
        d.v.b.d0.k.j j10 = j.d(this.a);
        object = Float.valueOf(object.getScaleFactor());
        j10.o((Float)object);
        return true;
    }
}

