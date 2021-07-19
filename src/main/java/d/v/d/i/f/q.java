/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 */
package d.v.d.i.f;

import android.graphics.Point;
import d.v.d.h.f;
import d.v.d.i.a.a;

public class q
extends a {
    public q() {
        Point point = new Point(0, 0);
        this.a = point;
    }

    public void n(Point point) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rect set point=");
        stringBuilder.append(point);
        d.v.d.h.f.a(stringBuilder.toString());
        super.set(point);
    }
}

