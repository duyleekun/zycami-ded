/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.core.view;

import android.view.View;
import androidx.core.view.ViewCompat$AccessibilityViewProperty;

public class ViewCompat$5
extends ViewCompat$AccessibilityViewProperty {
    public ViewCompat$5(int n10, Class clazz, int n11) {
        super(n10, clazz, n11);
    }

    public Boolean frameworkGet(View view) {
        return view.isAccessibilityHeading();
    }

    public void frameworkSet(View view, Boolean bl2) {
        boolean bl3 = bl2;
        view.setAccessibilityHeading(bl3);
    }

    public boolean shouldUpdate(Boolean bl2, Boolean bl3) {
        return this.booleanNullToFalseEquals(bl2, bl3) ^ true;
    }
}

