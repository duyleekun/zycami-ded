/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RectF
 */
package d.c.a.o.m.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import d.c.a.o.m.d.d0$c;

public class d0$a
implements d0$c {
    public final /* synthetic */ int a;

    public d0$a(int n10) {
        this.a = n10;
    }

    public void a(Canvas canvas, Paint paint, RectF rectF) {
        int n10 = this.a;
        float f10 = n10;
        float f11 = n10;
        canvas.drawRoundRect(rectF, f10, f11, paint);
    }
}

