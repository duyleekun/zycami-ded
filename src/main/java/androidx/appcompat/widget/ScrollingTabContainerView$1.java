/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ScrollingTabContainerView;

public class ScrollingTabContainerView$1
implements Runnable {
    public final /* synthetic */ ScrollingTabContainerView this$0;
    public final /* synthetic */ View val$tabView;

    public ScrollingTabContainerView$1(ScrollingTabContainerView scrollingTabContainerView, View view) {
        this.this$0 = scrollingTabContainerView;
        this.val$tabView = view;
    }

    public void run() {
        int n10 = this.val$tabView.getLeft();
        int n11 = this.this$0.getWidth();
        int n12 = this.val$tabView.getWidth();
        n11 = (n11 - n12) / 2;
        this.this$0.smoothScrollTo(n10 -= n11, 0);
        this.this$0.mTabSelector = null;
    }
}

