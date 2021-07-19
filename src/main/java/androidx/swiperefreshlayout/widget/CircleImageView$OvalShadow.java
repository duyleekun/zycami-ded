/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RadialGradient
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.shapes.OvalShape
 */
package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.shapes.OvalShape;
import androidx.swiperefreshlayout.widget.CircleImageView;

public class CircleImageView$OvalShadow
extends OvalShape {
    private RadialGradient mRadialGradient;
    private Paint mShadowPaint;
    public final /* synthetic */ CircleImageView this$0;

    public CircleImageView$OvalShadow(CircleImageView circleImageView, int n10) {
        Paint paint;
        this.this$0 = circleImageView;
        this.mShadowPaint = paint = new Paint();
        circleImageView.mShadowRadius = n10;
        int n11 = (int)this.rect().width();
        this.updateRadialGradient(n11);
    }

    private void updateRadialGradient(int n10) {
        RadialGradient radialGradient;
        int n11 = 2;
        float f10 = n10 / n11;
        float f11 = this.this$0.mShadowRadius;
        int[] nArray = new int[n11];
        nArray[0] = 0x3D000000;
        nArray[1] = 0;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mRadialGradient = radialGradient = new RadialGradient(f10, f10, f11, nArray, null, tileMode);
        this.mShadowPaint.setShader((Shader)radialGradient);
    }

    public void draw(Canvas canvas, Paint paint) {
        int n10 = this.this$0.getWidth();
        int n11 = this.this$0.getHeight();
        float f10 = n10 /= 2;
        float f11 = n11 / 2;
        Paint paint2 = this.mShadowPaint;
        canvas.drawCircle(f10, f11, f10, paint2);
        int n12 = this.this$0.mShadowRadius;
        float f12 = n10 - n12;
        canvas.drawCircle(f10, f11, f12, paint);
    }

    public void onResize(float f10, float f11) {
        super.onResize(f10, f11);
        int n10 = (int)f10;
        this.updateRadialGradient(n10);
    }
}

