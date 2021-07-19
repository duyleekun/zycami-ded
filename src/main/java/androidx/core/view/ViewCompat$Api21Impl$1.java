/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewCompat$Api21Impl;
import androidx.core.view.WindowInsetsCompat;

public class ViewCompat$Api21Impl$1
implements View.OnApplyWindowInsetsListener {
    public WindowInsetsCompat mLastInsets = null;
    public final /* synthetic */ OnApplyWindowInsetsListener val$listener;
    public final /* synthetic */ View val$v;

    public ViewCompat$Api21Impl$1(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.val$v = view;
        this.val$listener = onApplyWindowInsetsListener;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets object) {
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)object, view);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 < n11) {
            View view2 = this.val$v;
            ViewCompat$Api21Impl.callCompatInsetAnimationCallback((WindowInsets)object, view2);
            object = this.mLastInsets;
            boolean bl2 = windowInsetsCompat.equals(object);
            if (bl2) {
                return this.val$listener.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
            }
        }
        this.mLastInsets = windowInsetsCompat;
        object = this.val$listener.onApplyWindowInsets(view, windowInsetsCompat);
        if (n10 >= n11) {
            return ((WindowInsetsCompat)object).toWindowInsets();
        }
        ViewCompat.requestApplyInsets(view);
        return ((WindowInsetsCompat)object).toWindowInsets();
    }
}

