/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 */
package d.v.e.l;

import android.graphics.Canvas;
import android.graphics.Paint;
import d.v.e.l.d2;

public class j1 {
    private static final boolean a = false;

    private j1() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static void a(String string2, float f10, float f11, Paint paint, Canvas canvas) {
        float f12 = d2.c(paint, string2);
        j1.b(string2, f10, f11, paint, canvas, f12);
    }

    public static void b(String string2, float f10, float f11, Paint paint, Canvas canvas, float f12) {
        canvas.drawText(string2, f10, f11, paint);
    }
}

