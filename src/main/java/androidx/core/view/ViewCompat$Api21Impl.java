/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 */
package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.R$id;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat$Api21Impl$1;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Api21ReflectionHolder;

public class ViewCompat$Api21Impl {
    private ViewCompat$Api21Impl() {
    }

    public static void callCompatInsetAnimationCallback(WindowInsets windowInsets, View view) {
        int n10 = R$id.tag_window_insets_animation_callback;
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener)view.getTag(n10);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
        }
        rect.setEmpty();
        return windowInsetsCompat;
    }

    public static WindowInsetsCompat getRootWindowInsets(View view) {
        return WindowInsetsCompat$Api21ReflectionHolder.getRootWindowInsets(view);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 < n11) {
            n10 = R$id.tag_on_apply_window_listener;
            view.setTag(n10, (Object)onApplyWindowInsetsListener);
        }
        if (onApplyWindowInsetsListener == null) {
            int n12 = R$id.tag_window_insets_animation_callback;
            onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener)view.getTag(n12);
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)onApplyWindowInsetsListener);
            return;
        }
        ViewCompat$Api21Impl$1 viewCompat$Api21Impl$1 = new ViewCompat$Api21Impl$1(view, onApplyWindowInsetsListener);
        view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)viewCompat$Api21Impl$1);
    }
}

