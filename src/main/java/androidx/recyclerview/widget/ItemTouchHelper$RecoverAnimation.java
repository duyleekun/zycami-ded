/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation$1;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class ItemTouchHelper$RecoverAnimation
implements Animator.AnimatorListener {
    public final int mActionState;
    public final int mAnimationType;
    public boolean mEnded = false;
    private float mFraction;
    public boolean mIsPendingCleanup;
    public boolean mOverridden = false;
    public final float mStartDx;
    public final float mStartDy;
    public final float mTargetX;
    public final float mTargetY;
    public final ValueAnimator mValueAnimator;
    public final RecyclerView$ViewHolder mViewHolder;
    public float mX;
    public float mY;

    public ItemTouchHelper$RecoverAnimation(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, int n11, float f10, float f11, float f12, float f13) {
        this.mActionState = n11;
        this.mAnimationType = n10;
        this.mViewHolder = recyclerView$ViewHolder;
        this.mStartDx = f10;
        this.mStartDy = f11;
        this.mTargetX = f12;
        this.mTargetY = f13;
        Object object = new float[]{0.0f, 1.0f};
        object = ValueAnimator.ofFloat((float[])object);
        this.mValueAnimator = (ValueAnimator)object;
        ItemTouchHelper$RecoverAnimation$1 itemTouchHelper$RecoverAnimation$1 = new ItemTouchHelper$RecoverAnimation$1(this);
        object.addUpdateListener((ValueAnimator.AnimatorUpdateListener)itemTouchHelper$RecoverAnimation$1);
        recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
        object.setTarget((Object)recyclerView$ViewHolder);
        object.addListener((Animator.AnimatorListener)this);
        this.setFraction(0.0f);
    }

    public void cancel() {
        this.mValueAnimator.cancel();
    }

    public void onAnimationCancel(Animator animator2) {
        this.setFraction(1.0f);
    }

    public void onAnimationEnd(Animator object) {
        boolean bl2 = this.mEnded;
        boolean bl3 = true;
        if (!bl2) {
            object = this.mViewHolder;
            ((RecyclerView$ViewHolder)object).setIsRecyclable(bl3);
        }
        this.mEnded = bl3;
    }

    public void onAnimationRepeat(Animator animator2) {
    }

    public void onAnimationStart(Animator animator2) {
    }

    public void setDuration(long l10) {
        this.mValueAnimator.setDuration(l10);
    }

    public void setFraction(float f10) {
        this.mFraction = f10;
    }

    public void start() {
        this.mViewHolder.setIsRecyclable(false);
        this.mValueAnimator.start();
    }

    public void update() {
        float f10;
        View view;
        float f11 = this.mStartDx;
        float f12 = this.mTargetX;
        float f13 = f11 - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object == false) {
            view = this.mViewHolder.itemView;
            this.mX = f11 = view.getTranslationX();
        } else {
            f10 = this.mFraction;
            f10 *= (f12 -= f11);
            this.mX = f11 += f10;
        }
        f11 = this.mStartDy;
        f12 = this.mTargetY;
        object = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1);
        if (object == false) {
            view = this.mViewHolder.itemView;
            this.mY = f11 = view.getTranslationY();
        } else {
            f10 = this.mFraction;
            f10 *= (f12 -= f11);
            this.mY = f11 += f10;
        }
    }
}

