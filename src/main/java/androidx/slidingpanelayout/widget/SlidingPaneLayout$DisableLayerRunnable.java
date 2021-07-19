/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.slidingpanelayout.widget;

import android.view.View;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

public class SlidingPaneLayout$DisableLayerRunnable
implements Runnable {
    public final View mChildView;
    public final /* synthetic */ SlidingPaneLayout this$0;

    public SlidingPaneLayout$DisableLayerRunnable(SlidingPaneLayout slidingPaneLayout, View view) {
        this.this$0 = slidingPaneLayout;
        this.mChildView = view;
    }

    public void run() {
        SlidingPaneLayout slidingPaneLayout;
        Object object = this.mChildView.getParent();
        if (object == (slidingPaneLayout = this.this$0)) {
            this.mChildView.setLayerType(0, null);
            object = this.this$0;
            slidingPaneLayout = this.mChildView;
            ((SlidingPaneLayout)((Object)object)).invalidateChildRegion((View)slidingPaneLayout);
        }
        this.this$0.mPostedRunnables.remove(this);
    }
}

