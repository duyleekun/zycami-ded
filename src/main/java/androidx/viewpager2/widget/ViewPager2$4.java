/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener;
import androidx.viewpager2.widget.ViewPager2;

public class ViewPager2$4
implements RecyclerView$OnChildAttachStateChangeListener {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$4(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    public void onChildViewAttachedToWindow(View object) {
        int n10;
        object = (RecyclerView$LayoutParams)object.getLayoutParams();
        int n11 = object.width;
        int n12 = -1;
        if (n11 == n12 && (n10 = object.height) == n12) {
            return;
        }
        object = new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        throw object;
    }

    public void onChildViewDetachedFromWindow(View view) {
    }
}

