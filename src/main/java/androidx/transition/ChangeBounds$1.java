/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.Property
 */
package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

public final class ChangeBounds$1
extends Property {
    private Rect mBounds;

    public ChangeBounds$1(Class clazz, String string2) {
        super(clazz, string2);
        super();
        this.mBounds = clazz;
    }

    public PointF get(Drawable drawable2) {
        Rect rect = this.mBounds;
        drawable2.copyBounds(rect);
        rect = this.mBounds;
        float f10 = rect.left;
        float f11 = rect.top;
        drawable2 = new PointF(f10, f11);
        return drawable2;
    }

    public void set(Drawable drawable2, PointF pointF) {
        Rect rect = this.mBounds;
        drawable2.copyBounds(rect);
        rect = this.mBounds;
        int n10 = Math.round(pointF.x);
        int n11 = Math.round(pointF.y);
        rect.offsetTo(n10, n11);
        pointF = this.mBounds;
        drawable2.setBounds((Rect)pointF);
    }
}

