/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 */
package d.c.a.s.j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import d.c.a.s.j.i$a;
import d.c.a.u.k;

public class i
extends Drawable {
    private final Matrix a;
    private final RectF b;
    private final RectF c;
    private Drawable d;
    private i$a e;
    private boolean f;

    public i(Drawable drawable2, int n10, int n11) {
        Drawable.ConstantState constantState = drawable2.getConstantState();
        i$a i$a = new i$a(constantState, n10, n11);
        this(i$a, drawable2);
    }

    public i(i$a i$a, Drawable drawable2) {
        this.e = i$a = (i$a)((Object)k.d((Object)i$a));
        i$a = (Drawable)k.d(drawable2);
        this.d = i$a;
        int n10 = drawable2.getIntrinsicWidth();
        int n11 = drawable2.getIntrinsicHeight();
        drawable2.setBounds(0, 0, n10, n11);
        this.a = i$a;
        float f10 = drawable2.getIntrinsicWidth();
        float f11 = drawable2.getIntrinsicHeight();
        super(0.0f, 0.0f, f10, f11);
        this.b = i$a;
        super();
        this.c = i$a;
    }

    private void a() {
        Matrix matrix = this.a;
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.CENTER;
        matrix.setRectToRect(rectF, rectF2, scaleToFit);
    }

    public void clearColorFilter() {
        this.d.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        canvas.save();
        Matrix matrix = this.a;
        canvas.concat(matrix);
        this.d.draw(canvas);
        canvas.restore();
    }

    public int getAlpha() {
        return this.d.getAlpha();
    }

    public Drawable.Callback getCallback() {
        return this.d.getCallback();
    }

    public int getChangingConfigurations() {
        return this.d.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        return this.e;
    }

    public Drawable getCurrent() {
        return this.d.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.e.c;
    }

    public int getIntrinsicWidth() {
        return this.e.b;
    }

    public int getMinimumHeight() {
        return this.d.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.d.getMinimumWidth();
    }

    public int getOpacity() {
        return this.d.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.d.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.d.invalidateSelf();
    }

    public Drawable mutate() {
        Object object;
        boolean bl2 = this.f;
        if (!bl2 && (object = super.mutate()) == this) {
            this.d = object = this.d.mutate();
            i$a i$a = this.e;
            object = new i$a(i$a);
            this.e = object;
            this.f = bl2 = true;
        }
        return this;
    }

    public void scheduleSelf(Runnable runnable, long l10) {
        super.scheduleSelf(runnable, l10);
        this.d.scheduleSelf(runnable, l10);
    }

    public void setAlpha(int n10) {
        this.d.setAlpha(n10);
    }

    public void setBounds(int n10, int n11, int n12, int n13) {
        super.setBounds(n10, n11, n12, n13);
        RectF rectF = this.c;
        float f10 = n10;
        float f11 = n11;
        float f12 = n12;
        float f13 = n13;
        rectF.set(f10, f11, f12, f13);
        this.a();
    }

    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.c.set(rect);
        this.a();
    }

    public void setChangingConfigurations(int n10) {
        this.d.setChangingConfigurations(n10);
    }

    public void setColorFilter(int n10, PorterDuff.Mode mode) {
        this.d.setColorFilter(n10, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }

    public void setDither(boolean bl2) {
        this.d.setDither(bl2);
    }

    public void setFilterBitmap(boolean bl2) {
        this.d.setFilterBitmap(bl2);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        return this.d.setVisible(bl2, bl3);
    }

    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.d.unscheduleSelf(runnable);
    }
}

