/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager.widget;

import androidx.viewpager.widget.ViewPager;

public class ViewPager$3
implements Runnable {
    public final /* synthetic */ ViewPager this$0;

    public ViewPager$3(ViewPager viewPager) {
        this.this$0 = viewPager;
    }

    public void run() {
        this.this$0.setScrollState(0);
        this.this$0.populate();
    }
}

