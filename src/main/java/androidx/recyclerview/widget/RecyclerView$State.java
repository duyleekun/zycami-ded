/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView$Adapter;

public class RecyclerView$State {
    public static final int STEP_ANIMATIONS = 4;
    public static final int STEP_LAYOUT = 2;
    public static final int STEP_START = 1;
    private SparseArray mData;
    public int mDeletedInvisibleItemCountSincePreviousLayout = 0;
    public long mFocusedItemId;
    public int mFocusedItemPosition;
    public int mFocusedSubChildId;
    public boolean mInPreLayout = false;
    public boolean mIsMeasuring = false;
    public int mItemCount = 0;
    public int mLayoutStep = 1;
    public int mPreviousLayoutItemCount = 0;
    public int mRemainingScrollHorizontal;
    public int mRemainingScrollVertical;
    public boolean mRunPredictiveAnimations = false;
    public boolean mRunSimpleAnimations = false;
    public boolean mStructureChanged = false;
    public int mTargetPosition = -1;
    public boolean mTrackOldChangeHolders = false;

    public void assertLayoutStep(int n10) {
        int n11 = this.mLayoutStep & n10;
        if (n11 != 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Layout state should be one of ");
        String string2 = Integer.toBinaryString(n10);
        stringBuilder.append(string2);
        stringBuilder.append(" but it is ");
        string2 = Integer.toBinaryString(this.mLayoutStep);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public boolean didStructureChange() {
        return this.mStructureChanged;
    }

    public Object get(int n10) {
        SparseArray sparseArray = this.mData;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(n10);
    }

    public int getItemCount() {
        int n10 = this.mInPreLayout;
        if (n10 != 0) {
            n10 = this.mPreviousLayoutItemCount;
            int n11 = this.mDeletedInvisibleItemCountSincePreviousLayout;
            n10 -= n11;
        } else {
            n10 = this.mItemCount;
        }
        return n10;
    }

    public int getRemainingScrollHorizontal() {
        return this.mRemainingScrollHorizontal;
    }

    public int getRemainingScrollVertical() {
        return this.mRemainingScrollVertical;
    }

    public int getTargetScrollPosition() {
        return this.mTargetPosition;
    }

    public boolean hasTargetScrollPosition() {
        int n10 = this.mTargetPosition;
        int n11 = -1;
        n10 = n10 != n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isMeasuring() {
        return this.mIsMeasuring;
    }

    public boolean isPreLayout() {
        return this.mInPreLayout;
    }

    public void prepareForNestedPrefetch(RecyclerView$Adapter recyclerView$Adapter) {
        int n10;
        this.mLayoutStep = 1;
        this.mItemCount = n10 = recyclerView$Adapter.getItemCount();
        this.mInPreLayout = false;
        this.mTrackOldChangeHolders = false;
        this.mIsMeasuring = false;
    }

    public void put(int n10, Object object) {
        SparseArray sparseArray = this.mData;
        if (sparseArray == null) {
            this.mData = sparseArray = new SparseArray();
        }
        this.mData.put(n10, object);
    }

    public void remove(int n10) {
        SparseArray sparseArray = this.mData;
        if (sparseArray == null) {
            return;
        }
        sparseArray.remove(n10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("State{mTargetPosition=");
        int bl2 = this.mTargetPosition;
        stringBuilder.append(bl2);
        stringBuilder.append(", mData=");
        SparseArray sparseArray = this.mData;
        stringBuilder.append(sparseArray);
        stringBuilder.append(", mItemCount=");
        int n10 = this.mItemCount;
        stringBuilder.append(n10);
        stringBuilder.append(", mIsMeasuring=");
        boolean bl3 = this.mIsMeasuring;
        stringBuilder.append(bl3);
        stringBuilder.append(", mPreviousLayoutItemCount=");
        int n11 = this.mPreviousLayoutItemCount;
        stringBuilder.append(n11);
        stringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
        int n12 = this.mDeletedInvisibleItemCountSincePreviousLayout;
        stringBuilder.append(n12);
        stringBuilder.append(", mStructureChanged=");
        boolean bl4 = this.mStructureChanged;
        stringBuilder.append(bl4);
        stringBuilder.append(", mInPreLayout=");
        boolean bl5 = this.mInPreLayout;
        stringBuilder.append(bl5);
        stringBuilder.append(", mRunSimpleAnimations=");
        boolean bl6 = this.mRunSimpleAnimations;
        stringBuilder.append(bl6);
        stringBuilder.append(", mRunPredictiveAnimations=");
        boolean bl7 = this.mRunPredictiveAnimations;
        stringBuilder.append(bl7);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean willRunPredictiveAnimations() {
        return this.mRunPredictiveAnimations;
    }

    public boolean willRunSimpleAnimations() {
        return this.mRunSimpleAnimations;
    }
}

