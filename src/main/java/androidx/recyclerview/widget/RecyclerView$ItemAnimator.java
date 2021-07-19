/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemAnimatorFinishedListener;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemAnimatorListener;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerView$ItemAnimator {
    public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    public static final int FLAG_CHANGED = 2;
    public static final int FLAG_INVALIDATED = 4;
    public static final int FLAG_MOVED = 2048;
    public static final int FLAG_REMOVED = 8;
    private long mAddDuration;
    private long mChangeDuration;
    private ArrayList mFinishedListeners;
    private RecyclerView$ItemAnimator$ItemAnimatorListener mListener = null;
    private long mMoveDuration;
    private long mRemoveDuration;

    public RecyclerView$ItemAnimator() {
        long l10;
        ArrayList arrayList;
        this.mFinishedListeners = arrayList = new ArrayList();
        this.mAddDuration = l10 = (long)120;
        this.mRemoveDuration = l10;
        this.mMoveDuration = l10 = 250L;
        this.mChangeDuration = l10;
    }

    public static int buildAdapterChangeFlagsForAnimations(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int n10 = recyclerView$ViewHolder.mFlags & 0xE;
        int n11 = recyclerView$ViewHolder.isInvalid();
        if (n11 != 0) {
            return 4;
        }
        n11 = n10 & 4;
        if (n11 == 0) {
            n11 = recyclerView$ViewHolder.getOldPosition();
            int n12 = recyclerView$ViewHolder.getAbsoluteAdapterPosition();
            int n13 = -1;
            if (n11 != n13 && n12 != n13 && n11 != n12) {
                n10 |= 0x800;
            }
        }
        return n10;
    }

    public abstract boolean animateAppearance(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2, RecyclerView$ItemAnimator$ItemHolderInfo var3);

    public abstract boolean animateChange(RecyclerView$ViewHolder var1, RecyclerView$ViewHolder var2, RecyclerView$ItemAnimator$ItemHolderInfo var3, RecyclerView$ItemAnimator$ItemHolderInfo var4);

    public abstract boolean animateDisappearance(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2, RecyclerView$ItemAnimator$ItemHolderInfo var3);

    public abstract boolean animatePersistence(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2, RecyclerView$ItemAnimator$ItemHolderInfo var3);

    public boolean canReuseUpdatedViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return true;
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, List list) {
        return this.canReuseUpdatedViewHolder(recyclerView$ViewHolder);
    }

    public final void dispatchAnimationFinished(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.onAnimationFinished(recyclerView$ViewHolder);
        RecyclerView$ItemAnimator$ItemAnimatorListener recyclerView$ItemAnimator$ItemAnimatorListener = this.mListener;
        if (recyclerView$ItemAnimator$ItemAnimatorListener != null) {
            recyclerView$ItemAnimator$ItemAnimatorListener.onAnimationFinished(recyclerView$ViewHolder);
        }
    }

    public final void dispatchAnimationStarted(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.onAnimationStarted(recyclerView$ViewHolder);
    }

    public final void dispatchAnimationsFinished() {
        ArrayList arrayList = this.mFinishedListeners;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            RecyclerView$ItemAnimator$ItemAnimatorFinishedListener recyclerView$ItemAnimator$ItemAnimatorFinishedListener = (RecyclerView$ItemAnimator$ItemAnimatorFinishedListener)this.mFinishedListeners.get(i10);
            recyclerView$ItemAnimator$ItemAnimatorFinishedListener.onAnimationsFinished();
        }
        this.mFinishedListeners.clear();
    }

    public abstract void endAnimation(RecyclerView$ViewHolder var1);

    public abstract void endAnimations();

    public long getAddDuration() {
        return this.mAddDuration;
    }

    public long getChangeDuration() {
        return this.mChangeDuration;
    }

    public long getMoveDuration() {
        return this.mMoveDuration;
    }

    public long getRemoveDuration() {
        return this.mRemoveDuration;
    }

    public abstract boolean isRunning();

    public final boolean isRunning(RecyclerView$ItemAnimator$ItemAnimatorFinishedListener recyclerView$ItemAnimator$ItemAnimatorFinishedListener) {
        boolean bl2 = this.isRunning();
        if (recyclerView$ItemAnimator$ItemAnimatorFinishedListener != null) {
            if (!bl2) {
                recyclerView$ItemAnimator$ItemAnimatorFinishedListener.onAnimationsFinished();
            } else {
                ArrayList arrayList = this.mFinishedListeners;
                arrayList.add(recyclerView$ItemAnimator$ItemAnimatorFinishedListener);
            }
        }
        return bl2;
    }

    public RecyclerView$ItemAnimator$ItemHolderInfo obtainHolderInfo() {
        RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo = new RecyclerView$ItemAnimator$ItemHolderInfo();
        return recyclerView$ItemAnimator$ItemHolderInfo;
    }

    public void onAnimationFinished(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public void onAnimationStarted(RecyclerView$ViewHolder recyclerView$ViewHolder) {
    }

    public RecyclerView$ItemAnimator$ItemHolderInfo recordPostLayoutInformation(RecyclerView$State recyclerView$State, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.obtainHolderInfo().setFrom(recyclerView$ViewHolder);
    }

    public RecyclerView$ItemAnimator$ItemHolderInfo recordPreLayoutInformation(RecyclerView$State recyclerView$State, RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, List list) {
        return this.obtainHolderInfo().setFrom(recyclerView$ViewHolder);
    }

    public abstract void runPendingAnimations();

    public void setAddDuration(long l10) {
        this.mAddDuration = l10;
    }

    public void setChangeDuration(long l10) {
        this.mChangeDuration = l10;
    }

    public void setListener(RecyclerView$ItemAnimator$ItemAnimatorListener recyclerView$ItemAnimator$ItemAnimatorListener) {
        this.mListener = recyclerView$ItemAnimator$ItemAnimatorListener;
    }

    public void setMoveDuration(long l10) {
        this.mMoveDuration = l10;
    }

    public void setRemoveDuration(long l10) {
        this.mRemoveDuration = l10;
    }
}

