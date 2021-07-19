/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.AnimationSet
 *  android.view.animation.Transformation
 */
package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;

public class FragmentAnim$EndViewTransitionAnimation
extends AnimationSet
implements Runnable {
    private boolean mAnimating = true;
    private final View mChild;
    private boolean mEnded;
    private final ViewGroup mParent;
    private boolean mTransitionEnded;

    public FragmentAnim$EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.mParent = viewGroup;
        this.mChild = view;
        this.addAnimation(animation);
        viewGroup.post((Runnable)this);
    }

    public boolean getTransformation(long l10, Transformation transformation) {
        boolean bl2;
        this.mAnimating = bl2 = true;
        boolean bl3 = this.mEnded;
        if (bl3) {
            return this.mTransitionEnded ^ bl2;
        }
        boolean bl4 = super.getTransformation(l10, transformation);
        if (!bl4) {
            this.mEnded = bl2;
            ViewGroup viewGroup = this.mParent;
            OneShotPreDrawListener.add((View)viewGroup, this);
        }
        return bl2;
    }

    public boolean getTransformation(long l10, Transformation transformation, float f10) {
        boolean bl2;
        this.mAnimating = bl2 = true;
        boolean bl3 = this.mEnded;
        if (bl3) {
            return this.mTransitionEnded ^ bl2;
        }
        boolean bl4 = super.getTransformation(l10, transformation, f10);
        if (!bl4) {
            this.mEnded = bl2;
            ViewGroup viewGroup = this.mParent;
            OneShotPreDrawListener.add((View)viewGroup, this);
        }
        return bl2;
    }

    public void run() {
        boolean bl2 = this.mEnded;
        if (!bl2 && (bl2 = this.mAnimating)) {
            bl2 = false;
            this.mAnimating = false;
            ViewGroup viewGroup = this.mParent;
            viewGroup.post((Runnable)this);
        } else {
            ViewGroup viewGroup = this.mParent;
            View view = this.mChild;
            viewGroup.endViewTransition(view);
            this.mTransitionEnded = bl2 = true;
        }
    }
}

