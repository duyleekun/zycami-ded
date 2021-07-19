/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;

public class LayoutState {
    public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    public static final int ITEM_DIRECTION_HEAD = 255;
    public static final int ITEM_DIRECTION_TAIL = 1;
    public static final int LAYOUT_END = 1;
    public static final int LAYOUT_START = 255;
    public int mAvailable;
    public int mCurrentPosition;
    public int mEndLine = 0;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLayoutDirection;
    public boolean mRecycle = true;
    public int mStartLine = 0;
    public boolean mStopInFocusable;

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

    public View next(RecyclerView$Recycler recyclerView$Recycler) {
        int n10 = this.mCurrentPosition;
        recyclerView$Recycler = recyclerView$Recycler.getViewForPosition(n10);
        n10 = this.mCurrentPosition;
        int n11 = this.mItemDirection;
        this.mCurrentPosition = n10 += n11;
        return recyclerView$Recycler;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LayoutState{mAvailable=");
        int n10 = this.mAvailable;
        stringBuilder.append(n10);
        stringBuilder.append(", mCurrentPosition=");
        n10 = this.mCurrentPosition;
        stringBuilder.append(n10);
        stringBuilder.append(", mItemDirection=");
        n10 = this.mItemDirection;
        stringBuilder.append(n10);
        stringBuilder.append(", mLayoutDirection=");
        n10 = this.mLayoutDirection;
        stringBuilder.append(n10);
        stringBuilder.append(", mStartLine=");
        n10 = this.mStartLine;
        stringBuilder.append(n10);
        stringBuilder.append(", mEndLine=");
        n10 = this.mEndLine;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

