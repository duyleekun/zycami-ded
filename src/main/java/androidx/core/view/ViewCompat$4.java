/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 */
package androidx.core.view;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat$AccessibilityViewProperty;

public class ViewCompat$4
extends ViewCompat$AccessibilityViewProperty {
    public ViewCompat$4(int n10, Class clazz, int n11, int n12) {
        super(n10, clazz, n11, n12);
    }

    public CharSequence frameworkGet(View view) {
        return view.getStateDescription();
    }

    public void frameworkSet(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }

    public boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
        return TextUtils.equals((CharSequence)charSequence, (CharSequence)charSequence2) ^ true;
    }
}

