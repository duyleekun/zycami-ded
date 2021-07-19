/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;

public class AppBarLayout$1
implements OnApplyWindowInsetsListener {
    public final /* synthetic */ AppBarLayout this$0;

    public AppBarLayout$1(AppBarLayout appBarLayout) {
        this.this$0 = appBarLayout;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.this$0.onWindowInsetChanged(windowInsetsCompat);
    }
}

