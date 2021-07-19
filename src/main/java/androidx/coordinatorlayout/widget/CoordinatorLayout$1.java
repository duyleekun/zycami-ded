/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.coordinatorlayout.widget;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

public class CoordinatorLayout$1
implements OnApplyWindowInsetsListener {
    public final /* synthetic */ CoordinatorLayout this$0;

    public CoordinatorLayout$1(CoordinatorLayout coordinatorLayout) {
        this.this$0 = coordinatorLayout;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.this$0.setWindowInsets(windowInsetsCompat);
    }
}

