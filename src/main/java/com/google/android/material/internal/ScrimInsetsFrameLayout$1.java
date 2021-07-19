/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 */
package com.google.android.material.internal;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ScrimInsetsFrameLayout;

public class ScrimInsetsFrameLayout$1
implements OnApplyWindowInsetsListener {
    public final /* synthetic */ ScrimInsetsFrameLayout this$0;

    public ScrimInsetsFrameLayout$1(ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
        this.this$0 = scrimInsetsFrameLayout;
    }

    /*
     * WARNING - void declaration
     */
    public WindowInsetsCompat onApplyWindowInsets(View object, WindowInsetsCompat windowInsetsCompat) {
        void var4_8;
        object = this.this$0;
        Rect rect = object.insets;
        if (rect == null) {
            object.insets = rect = new Rect();
        }
        object = this.this$0.insets;
        int bl2 = windowInsetsCompat.getSystemWindowInsetLeft();
        int n10 = windowInsetsCompat.getSystemWindowInsetTop();
        int n11 = windowInsetsCompat.getSystemWindowInsetRight();
        int n12 = windowInsetsCompat.getSystemWindowInsetBottom();
        object.set(bl2, n10, n11, n12);
        this.this$0.onInsetsChanged(windowInsetsCompat);
        object = this.this$0;
        boolean bl3 = windowInsetsCompat.hasSystemWindowInsets();
        if (bl3 && (rect = this.this$0.insetForeground) != null) {
            boolean bl4 = false;
            rect = null;
        } else {
            boolean bl5 = true;
        }
        object.setWillNotDraw((boolean)var4_8);
        ViewCompat.postInvalidateOnAnimation((View)this.this$0);
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}

