/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.os.Build$VERSION
 *  android.widget.EdgeEffect
 */
package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat {
    private EdgeEffect mEdgeEffect;

    public EdgeEffectCompat(Context context) {
        EdgeEffect edgeEffect;
        this.mEdgeEffect = edgeEffect = new EdgeEffect(context);
    }

    public static void onPull(EdgeEffect edgeEffect, float f10, float f11) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            edgeEffect.onPull(f10, f11);
        } else {
            edgeEffect.onPull(f10);
        }
    }

    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    public void finish() {
        this.mEdgeEffect.finish();
    }

    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    public boolean onAbsorb(int n10) {
        this.mEdgeEffect.onAbsorb(n10);
        return true;
    }

    public boolean onPull(float f10) {
        this.mEdgeEffect.onPull(f10);
        return true;
    }

    public boolean onPull(float f10, float f11) {
        EdgeEffectCompat.onPull(this.mEdgeEffect, f10, f11);
        return true;
    }

    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    public void setSize(int n10, int n11) {
        this.mEdgeEffect.setSize(n10, n11);
    }
}

