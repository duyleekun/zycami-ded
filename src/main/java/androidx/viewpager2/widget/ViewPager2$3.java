/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 */
package androidx.viewpager2.widget;

import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;

public class ViewPager2$3
extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$3(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    public void onPageSelected(int n10) {
        this.this$0.clearFocus();
        ViewGroup viewGroup = this.this$0;
        n10 = (int)(viewGroup.hasFocus() ? 1 : 0);
        if (n10 != 0) {
            viewGroup = this.this$0.mRecyclerView;
            int n11 = 2;
            viewGroup.requestFocus(n11);
        }
    }
}

