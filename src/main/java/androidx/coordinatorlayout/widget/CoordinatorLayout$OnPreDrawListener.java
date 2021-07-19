/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.coordinatorlayout.widget;

import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class CoordinatorLayout$OnPreDrawListener
implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ CoordinatorLayout this$0;

    public CoordinatorLayout$OnPreDrawListener(CoordinatorLayout coordinatorLayout) {
        this.this$0 = coordinatorLayout;
    }

    public boolean onPreDraw() {
        this.this$0.onChildViewsChanged(0);
        return true;
    }
}

