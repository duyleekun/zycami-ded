/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.ScrollingTabContainerView$TabView;

public class ScrollingTabContainerView$TabClickListener
implements View.OnClickListener {
    public final /* synthetic */ ScrollingTabContainerView this$0;

    public ScrollingTabContainerView$TabClickListener(ScrollingTabContainerView scrollingTabContainerView) {
        this.this$0 = scrollingTabContainerView;
    }

    public void onClick(View view) {
        Object object = view;
        ((ScrollingTabContainerView$TabView)view).getTab().select();
        object = this.this$0.mTabLayout;
        int n10 = object.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view2 = this.this$0.mTabLayout.getChildAt(i10);
            boolean bl2 = view2 == view;
            view2.setSelected(bl2);
        }
    }
}

