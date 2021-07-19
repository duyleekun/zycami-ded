/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.WindowInsets
 */
package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.WindowInsetsCompat;

public class ViewCompat$Api23Impl {
    private ViewCompat$Api23Impl() {
    }

    public static WindowInsetsCompat getRootWindowInsets(View view) {
        Object object = view.getRootWindowInsets();
        if (object == null) {
            return null;
        }
        object = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)object);
        ((WindowInsetsCompat)object).setRootWindowInsets((WindowInsetsCompat)object);
        view = view.getRootView();
        ((WindowInsetsCompat)object).copyRootViewBounds(view);
        return object;
    }
}

