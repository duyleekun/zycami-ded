/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$DataSetChangeObserver;

public class ViewPager2$1
extends ViewPager2$DataSetChangeObserver {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$1(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
        super(null);
    }

    public void onChanged() {
        ViewPager2 viewPager2 = this.this$0;
        viewPager2.mCurrentItemDirty = true;
        viewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
    }
}

