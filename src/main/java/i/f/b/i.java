/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.util.Log
 */
package i.f.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import java.text.DecimalFormat;
import org.opencv.core.Core;

public class i {
    private static final String i = "FpsMeter";
    private static final int j = 20;
    private static final DecimalFormat k;
    private int a;
    private double b;
    private long c;
    private String d;
    public Paint e;
    public boolean f = false;
    public int g = 0;
    public int h = 0;

    static {
        DecimalFormat decimalFormat;
        k = decimalFormat = new DecimalFormat("0.00");
    }

    public void a(Canvas canvas, float f10, float f11) {
        String string2 = this.d;
        Log.d((String)i, (String)string2);
        string2 = this.d;
        Paint paint = this.e;
        canvas.drawText(string2, f10, f11, paint);
    }

    public void b() {
        Paint paint;
        long l10;
        double d10;
        this.a = 0;
        this.b = d10 = Core.Y0();
        this.c = l10 = Core.X0();
        this.d = "";
        this.e = paint = new Paint();
        paint.setColor(-16776961);
        this.e.setTextSize(20.0f);
    }

    public void c() {
        int n10 = this.f;
        int n11 = 1;
        if (n10 == 0) {
            this.b();
            this.f = n11;
        } else {
            this.a = n10 = this.a + n11;
            if ((n10 %= 20) == 0) {
                Object object;
                CharSequence charSequence;
                long l10 = Core.X0();
                double d10 = this.b * 20.0;
                long l11 = this.c;
                l11 = l10 - l11;
                double d11 = l11;
                d10 /= d11;
                this.c = l10;
                n10 = this.g;
                if (n10 != 0 && (n10 = this.h) != 0) {
                    charSequence = new StringBuilder();
                    object = k.format(d10);
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(" FPS@");
                    object = this.g;
                    ((StringBuilder)charSequence).append(object);
                    ((StringBuilder)charSequence).append("x");
                    n11 = this.h;
                    object = n11;
                    ((StringBuilder)charSequence).append(object);
                    charSequence = ((StringBuilder)charSequence).toString();
                    this.d = charSequence;
                } else {
                    charSequence = new StringBuilder();
                    object = k.format(d10);
                    ((StringBuilder)charSequence).append((String)object);
                    object = " FPS";
                    ((StringBuilder)charSequence).append((String)object);
                    charSequence = ((StringBuilder)charSequence).toString();
                    this.d = charSequence;
                }
                charSequence = this.d;
                object = i;
                Log.i((String)object, (String)charSequence);
            }
        }
    }

    public void d(int n10, int n11) {
        this.g = n10;
        this.h = n11;
    }
}

