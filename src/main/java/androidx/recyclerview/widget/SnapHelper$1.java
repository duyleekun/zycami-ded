/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.SnapHelper;

public class SnapHelper$1
extends RecyclerView$OnScrollListener {
    public boolean mScrolled = false;
    public final /* synthetic */ SnapHelper this$0;

    public SnapHelper$1(SnapHelper snapHelper) {
        this.this$0 = snapHelper;
    }

    public void onScrollStateChanged(RecyclerView object, int n10) {
        boolean bl2;
        super.onScrollStateChanged((RecyclerView)object, n10);
        if (n10 == 0 && (bl2 = this.mScrolled)) {
            bl2 = false;
            this.mScrolled = false;
            object = this.this$0;
            ((SnapHelper)object).snapToTargetExistingView();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int n10, int n11) {
        if (n10 != 0 || n11 != 0) {
            boolean bl2;
            this.mScrolled = bl2 = true;
        }
    }
}

