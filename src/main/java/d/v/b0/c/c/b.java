/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 */
package d.v.b0.c.c;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.TextureView;
import com.zhiyun.renderengine.business.display.DisplayRender;
import d.v.b0.c.c.b$a;

public class b
extends TextureView {
    private DisplayRender a;
    private TextureView.SurfaceTextureListener b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;

    public b(Context context) {
        super(context);
        b$a b$a = new b$a(this);
        this.b = b$a;
        this.c = false;
        this.c(context);
    }

    public b(Context context, AttributeSet object) {
        super(context, object);
        super(this);
        this.b = object;
        this.c = false;
        this.c(context);
    }

    public static /* synthetic */ DisplayRender a(b b10) {
        return b10.a;
    }

    private void c(Context context) {
        context = this.b;
        this.setSurfaceTextureListener((TextureView.SurfaceTextureListener)context);
    }

    public void b() {
        Matrix matrix = new Matrix();
        float f10 = this.f;
        float f11 = this.g;
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        f11 = this.d;
        float f12 = this.e;
        RectF rectF2 = new RectF(0.0f, 0.0f, f11, f12);
        f11 = rectF.centerX();
        float f13 = rectF.centerY();
        f12 = rectF2.centerX();
        f12 = f11 - f12;
        float f14 = rectF2.centerY();
        f14 = f13 - f14;
        rectF2.offset(f12, f14);
        Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.FILL;
        matrix.setRectToRect(rectF, rectF2, scaleToFit);
        float f15 = this.f;
        f10 = this.d;
        f15 /= f10;
        f10 = this.g;
        f12 = this.e;
        f15 = Math.max(f15, f10 /= f12);
        matrix.postScale(f15, f15, f11, f13);
        f15 = -90;
        matrix.postRotate(f15, f11, f13);
        this.setTransform(matrix);
    }

    public void d(int n10, int n11) {
        this.d = n10;
        this.e = n11;
        this.b();
    }

    public void e(int n10, int n11) {
        this.f = n10;
        this.g = n11;
    }

    public void setRender(DisplayRender displayRender) {
        this.a = displayRender;
    }

    public void setRequest(boolean bl2) {
        this.c = bl2;
    }
}

