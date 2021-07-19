/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Property
 */
package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import androidx.transition.ChangeBounds$ViewBounds;

public final class ChangeBounds$3
extends Property {
    public ChangeBounds$3(Class clazz, String string2) {
        super(clazz, string2);
    }

    public PointF get(ChangeBounds$ViewBounds changeBounds$ViewBounds) {
        return null;
    }

    public void set(ChangeBounds$ViewBounds changeBounds$ViewBounds, PointF pointF) {
        changeBounds$ViewBounds.setBottomRight(pointF);
    }
}

