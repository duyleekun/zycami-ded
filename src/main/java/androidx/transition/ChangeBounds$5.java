/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Property
 *  android.view.View
 */
package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;
import androidx.transition.ViewUtils;

public final class ChangeBounds$5
extends Property {
    public ChangeBounds$5(Class clazz, String string2) {
        super(clazz, string2);
    }

    public PointF get(View view) {
        return null;
    }

    public void set(View view, PointF pointF) {
        int n10 = Math.round(pointF.x);
        int n11 = Math.round(pointF.y);
        int n12 = view.getRight();
        int n13 = view.getBottom();
        ViewUtils.setLeftTopRightBottom(view, n10, n11, n12, n13);
    }
}

