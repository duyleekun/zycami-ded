/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.snackbar;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class BaseTransientBottomBar$2
implements OnApplyWindowInsetsListener {
    public final /* synthetic */ BaseTransientBottomBar this$0;

    public BaseTransientBottomBar$2(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int n10 = view.getPaddingLeft();
        int n11 = view.getPaddingTop();
        int n12 = view.getPaddingRight();
        int n13 = windowInsetsCompat.getSystemWindowInsetBottom();
        view.setPadding(n10, n11, n12, n13);
        return windowInsetsCompat;
    }
}

