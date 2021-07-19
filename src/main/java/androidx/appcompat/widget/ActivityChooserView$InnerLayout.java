/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.LinearLayout
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.TintTypedArray;

public class ActivityChooserView$InnerLayout
extends LinearLayout {
    private static final int[] TINT_ATTRS;

    static {
        int[] nArray = new int[]{16842964};
        TINT_ATTRS = nArray;
    }

    public ActivityChooserView$InnerLayout(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        int[] nArray = TINT_ATTRS;
        object = TintTypedArray.obtainStyledAttributes((Context)object, attributeSet, nArray);
        attributeSet = ((TintTypedArray)object).getDrawable(0);
        this.setBackgroundDrawable((Drawable)attributeSet);
        ((TintTypedArray)object).recycle();
    }
}

