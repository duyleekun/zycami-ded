/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.material.animation;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$id;

public class ChildrenAlphaProperty
extends Property {
    public static final Property CHILDREN_ALPHA;

    static {
        ChildrenAlphaProperty childrenAlphaProperty = new ChildrenAlphaProperty("childrenAlpha");
        CHILDREN_ALPHA = childrenAlphaProperty;
    }

    private ChildrenAlphaProperty(String string2) {
        super(Float.class, string2);
    }

    public Float get(ViewGroup object) {
        int n10 = R$id.mtrl_internal_children_alpha_tag;
        if ((object = (Float)object.getTag(n10)) != null) {
            return object;
        }
        return Float.valueOf(1.0f);
    }

    public void set(ViewGroup viewGroup, Float f10) {
        float f11 = f10.floatValue();
        int n10 = R$id.mtrl_internal_children_alpha_tag;
        Float f12 = Float.valueOf(f11);
        viewGroup.setTag(n10, (Object)f12);
        n10 = viewGroup.getChildCount();
        f12 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = viewGroup.getChildAt(i10);
            view.setAlpha(f11);
        }
    }
}

