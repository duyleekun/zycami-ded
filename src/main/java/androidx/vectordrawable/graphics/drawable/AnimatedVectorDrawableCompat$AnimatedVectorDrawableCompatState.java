/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.util.ArrayList;
import java.util.Collection;

public class AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState
extends Drawable.ConstantState {
    public AnimatorSet mAnimatorSet;
    public ArrayList mAnimators;
    public int mChangingConfigurations;
    public ArrayMap mTargetNameMap;
    public VectorDrawableCompat mVectorDrawable;

    public AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState(Context object, AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState, Drawable.Callback object2, Resources resources) {
        if (animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState != null) {
            int n10;
            this.mChangingConfigurations = n10 = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mChangingConfigurations;
            object = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mVectorDrawable;
            int n11 = 0;
            if (object != null) {
                object = ((VectorDrawableCompat)object).getConstantState();
                this.mVectorDrawable = resources != null ? (object = (VectorDrawableCompat)object.newDrawable(resources)) : (object = (VectorDrawableCompat)object.newDrawable());
                this.mVectorDrawable = object = (VectorDrawableCompat)this.mVectorDrawable.mutate();
                object.setCallback(object2);
                object = this.mVectorDrawable;
                object2 = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mVectorDrawable.getBounds();
                object.setBounds((Rect)object2);
                object = this.mVectorDrawable;
                ((VectorDrawableCompat)object).setAllowCaching(false);
            }
            if ((object = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mAnimators) != null) {
                n10 = ((ArrayList)object).size();
                super(n10);
                this.mAnimators = object2;
                super(n10);
                this.mTargetNameMap = object2;
                while (n11 < n10) {
                    object2 = (Animator)animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mAnimators.get(n11);
                    resources = object2.clone();
                    object2 = (String)animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mTargetNameMap.get(object2);
                    Object object3 = this.mVectorDrawable.getTargetByName((String)object2);
                    resources.setTarget(object3);
                    this.mAnimators.add(resources);
                    object3 = this.mTargetNameMap;
                    ((SimpleArrayMap)object3).put(resources, object2);
                    ++n11;
                }
                this.setupAnimatorSet();
            }
        }
    }

    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public Drawable newDrawable() {
        IllegalStateException illegalStateException = new IllegalStateException("No constant state support for SDK < 24.");
        throw illegalStateException;
    }

    public Drawable newDrawable(Resources object) {
        object = new IllegalStateException("No constant state support for SDK < 24.");
        throw object;
    }

    public void setupAnimatorSet() {
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet == null) {
            this.mAnimatorSet = animatorSet = new AnimatorSet();
        }
        animatorSet = this.mAnimatorSet;
        ArrayList arrayList = this.mAnimators;
        animatorSet.playTogether((Collection)arrayList);
    }
}

