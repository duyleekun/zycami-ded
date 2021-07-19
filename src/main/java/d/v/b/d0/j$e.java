/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 */
package d.v.b.d0;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import d.v.b.c0.b;
import d.v.b.d0.j;
import d.v.b.d0.j$a;
import d.v.d.h.f;

public class j$e
extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ j a;

    private j$e(j j10) {
        this.a = j10;
    }

    public /* synthetic */ j$e(j j10, j$a j$a) {
        this(j10);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        f.a("on Single Tap up");
        Object object = this.a;
        float f10 = motionEvent.getX();
        float f11 = motionEvent.getY();
        j.b((j)object, f10, f11);
        object = j.c(this.a);
        int n10 = (int)motionEvent.getX();
        int n11 = (int)motionEvent.getY();
        Point point = new Point(n10, n11);
        ((b)object).set(point);
        return true;
    }
}

