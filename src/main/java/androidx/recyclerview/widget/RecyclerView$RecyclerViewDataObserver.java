/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView$SavedState;
import androidx.recyclerview.widget.RecyclerView$State;

public class RecyclerView$RecyclerViewDataObserver
extends RecyclerView$AdapterDataObserver {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$RecyclerViewDataObserver(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void onChanged() {
        boolean bl2;
        this.this$0.assertNotInLayoutOrScroll(null);
        Object object = this.this$0;
        RecyclerView$State recyclerView$State = ((RecyclerView)object).mState;
        recyclerView$State.mStructureChanged = bl2 = true;
        ((RecyclerView)object).processDataSetCompletelyChanged(bl2);
        object = this.this$0.mAdapterHelper;
        boolean bl3 = ((AdapterHelper)object).hasPendingUpdates();
        if (!bl3) {
            object = this.this$0;
            ((RecyclerView)object).requestLayout();
        }
    }

    public void onItemRangeChanged(int n10, int n11, Object object) {
        this.this$0.assertNotInLayoutOrScroll(null);
        AdapterHelper adapterHelper = this.this$0.mAdapterHelper;
        n10 = (int)(adapterHelper.onItemRangeChanged(n10, n11, object) ? 1 : 0);
        if (n10 != 0) {
            this.triggerUpdateProcessor();
        }
    }

    public void onItemRangeInserted(int n10, int n11) {
        this.this$0.assertNotInLayoutOrScroll(null);
        AdapterHelper adapterHelper = this.this$0.mAdapterHelper;
        n10 = (int)(adapterHelper.onItemRangeInserted(n10, n11) ? 1 : 0);
        if (n10 != 0) {
            this.triggerUpdateProcessor();
        }
    }

    public void onItemRangeMoved(int n10, int n11, int n12) {
        this.this$0.assertNotInLayoutOrScroll(null);
        AdapterHelper adapterHelper = this.this$0.mAdapterHelper;
        n10 = (int)(adapterHelper.onItemRangeMoved(n10, n11, n12) ? 1 : 0);
        if (n10 != 0) {
            this.triggerUpdateProcessor();
        }
    }

    public void onItemRangeRemoved(int n10, int n11) {
        this.this$0.assertNotInLayoutOrScroll(null);
        AdapterHelper adapterHelper = this.this$0.mAdapterHelper;
        n10 = (int)(adapterHelper.onItemRangeRemoved(n10, n11) ? 1 : 0);
        if (n10 != 0) {
            this.triggerUpdateProcessor();
        }
    }

    public void onStateRestorationPolicyChanged() {
        boolean bl2;
        Object object = this.this$0;
        RecyclerView$SavedState recyclerView$SavedState = ((RecyclerView)object).mPendingSavedState;
        if (recyclerView$SavedState == null) {
            return;
        }
        object = ((RecyclerView)object).mAdapter;
        if (object != null && (bl2 = ((RecyclerView$Adapter)object).canRestoreState())) {
            object = this.this$0;
            ((RecyclerView)object).requestLayout();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void triggerUpdateProcessor() {
        boolean bl2;
        RecyclerView recyclerView;
        boolean bl3 = RecyclerView.POST_UPDATES_ON_ANIMATION;
        if (bl3) {
            recyclerView = this.this$0;
            bl2 = recyclerView.mHasFixedSize;
            if (bl2 && (bl2 = recyclerView.mIsAttached)) {
                Runnable runnable = recyclerView.mUpdateChildViewsRunnable;
                ViewCompat.postOnAnimation((View)recyclerView, runnable);
                return;
            }
        }
        recyclerView = this.this$0;
        recyclerView.mAdapterUpdateDuringMeasure = bl2 = true;
        recyclerView.requestLayout();
    }
}

