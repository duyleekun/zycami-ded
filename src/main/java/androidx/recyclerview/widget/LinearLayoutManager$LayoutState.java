/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.List;

public class LinearLayoutManager$LayoutState {
    public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    public static final int ITEM_DIRECTION_HEAD = 255;
    public static final int ITEM_DIRECTION_TAIL = 1;
    public static final int LAYOUT_END = 1;
    public static final int LAYOUT_START = 255;
    public static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
    public static final String TAG = "LLM#LayoutState";
    public int mAvailable;
    public int mCurrentPosition;
    public int mExtraFillSpace = 0;
    public boolean mInfinite;
    public boolean mIsPreLayout = false;
    public int mItemDirection;
    public int mLastScrollDelta;
    public int mLayoutDirection;
    public int mNoRecycleSpace = 0;
    public int mOffset;
    public boolean mRecycle = true;
    public List mScrapList = null;
    public int mScrollingOffset;

    private View nextViewFromScrapList() {
        List list = this.mScrapList;
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            View view = ((RecyclerView$ViewHolder)this.mScrapList.get((int)i10)).itemView;
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
            int n12 = recyclerView$LayoutParams.isItemRemoved();
            if (n12 != 0 || (n12 = this.mCurrentPosition) != (n11 = recyclerView$LayoutParams.getViewLayoutPosition())) continue;
            this.assignPositionFromScrapList(view);
            return view;
        }
        return null;
    }

    public void assignPositionFromScrapList() {
        this.assignPositionFromScrapList(null);
    }

    public void assignPositionFromScrapList(View object) {
        if ((object = this.nextViewInLimitedList((View)object)) == null) {
            int n10;
            this.mCurrentPosition = n10 = -1;
        } else {
            int n11;
            object = (RecyclerView$LayoutParams)object.getLayoutParams();
            this.mCurrentPosition = n11 = ((RecyclerView$LayoutParams)((Object)object)).getViewLayoutPosition();
        }
    }

    public boolean hasMore(RecyclerView$State recyclerView$State) {
        int n10;
        int n11 = this.mCurrentPosition;
        if (n11 >= 0 && n11 < (n10 = recyclerView$State.getItemCount())) {
            n10 = 1;
        } else {
            n10 = 0;
            recyclerView$State = null;
        }
        return n10;
    }

    public void log() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("avail:");
        int n10 = this.mAvailable;
        charSequence.append(n10);
        charSequence.append(", ind:");
        n10 = this.mCurrentPosition;
        charSequence.append(n10);
        charSequence.append(", dir:");
        n10 = this.mItemDirection;
        charSequence.append(n10);
        charSequence.append(", offset:");
        n10 = this.mOffset;
        charSequence.append(n10);
        charSequence.append(", layoutDir:");
        n10 = this.mLayoutDirection;
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Log.d((String)TAG, (String)charSequence);
    }

    public View next(RecyclerView$Recycler recyclerView$Recycler) {
        List list = this.mScrapList;
        if (list != null) {
            return this.nextViewFromScrapList();
        }
        int n10 = this.mCurrentPosition;
        recyclerView$Recycler = recyclerView$Recycler.getViewForPosition(n10);
        n10 = this.mCurrentPosition;
        int n11 = this.mItemDirection;
        this.mCurrentPosition = n10 += n11;
        return recyclerView$Recycler;
    }

    public View nextViewInLimitedList(View view) {
        List list = this.mScrapList;
        int n10 = list.size();
        View view2 = null;
        int n11 = -1 >>> 1;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12;
            View view3 = ((RecyclerView$ViewHolder)this.mScrapList.get((int)i10)).itemView;
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view3.getLayoutParams();
            if (view3 == view || (n12 = recyclerView$LayoutParams.isItemRemoved()) != 0) continue;
            int n13 = recyclerView$LayoutParams.getViewLayoutPosition();
            n12 = this.mCurrentPosition;
            n13 -= n12;
            n12 = this.mItemDirection;
            if ((n13 *= n12) < 0 || n13 >= n11) continue;
            view2 = view3;
            if (n13 == 0) break;
            n11 = n13;
        }
        return view2;
    }
}

