/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 */
package d.c.a.o.m.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import d.c.a.o.m.d.d0$c;

public class d0$b
implements d0$c {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;

    public d0$b(float f10, float f11, float f12, float f13) {
        this.a = f10;
        this.b = f11;
        this.c = f12;
        this.d = f13;
    }

    public void a(Canvas canvas, Paint paint, RectF rectF) {
        Path path = new Path();
        float f10 = this.a;
        float[] fArray = new float[]{f10, f10, f10 = this.b, f10, f10 = this.c, f10, f10 = this.d, f10};
        Path.Direction direction = Path.Direction.CW;
        path.addRoundRect(rectF, fArray, direction);
        canvas.drawPath(path, paint);
    }
}

