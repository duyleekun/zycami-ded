/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  android.view.View
 */
package androidx.transition;

import android.util.Property;
import android.view.View;
import androidx.transition.ViewUtils;

public final class ViewUtils$1
extends Property {
    public ViewUtils$1(Class clazz, String string2) {
        super(clazz, string2);
    }

    public Float get(View view) {
        return Float.valueOf(ViewUtils.getTransitionAlpha(view));
    }

    public void set(View view, Float f10) {
        float f11 = f10.floatValue();
        ViewUtils.setTransitionAlpha(view, f11);
    }
}

