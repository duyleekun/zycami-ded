/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 */
package androidx.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

public class ViewCompat$Api29Impl {
    private ViewCompat$Api29Impl() {
    }

    public static void saveAttributeDataForStyleable(View view, Context context, int[] nArray, AttributeSet attributeSet, TypedArray typedArray, int n10, int n11) {
        view.saveAttributeDataForStyleable(context, nArray, attributeSet, typedArray, n10, n11);
    }
}

