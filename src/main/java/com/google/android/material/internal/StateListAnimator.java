/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.util.StateSet
 */
package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import com.google.android.material.internal.StateListAnimator$Tuple;
import java.util.ArrayList;

public final class StateListAnimator {
    private final Animator.AnimatorListener animationListener;
    private StateListAnimator$Tuple lastMatch;
    public ValueAnimator runningAnimator;
    private final ArrayList tuples;

    public StateListAnimator() {
        Object object;
        this.tuples = object = new Object();
        this.lastMatch = null;
        this.runningAnimator = null;
        super(this);
        this.animationListener = object;
    }

    private void cancel() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            valueAnimator = null;
            this.runningAnimator = null;
        }
    }

    private void start(StateListAnimator$Tuple stateListAnimator$Tuple) {
        stateListAnimator$Tuple = stateListAnimator$Tuple.animator;
        this.runningAnimator = stateListAnimator$Tuple;
        stateListAnimator$Tuple.start();
    }

    public void addState(int[] object, ValueAnimator valueAnimator) {
        StateListAnimator$Tuple stateListAnimator$Tuple = new StateListAnimator$Tuple((int[])object, valueAnimator);
        object = this.animationListener;
        valueAnimator.addListener((Animator.AnimatorListener)object);
        this.tuples.add(stateListAnimator$Tuple);
    }

    public void jumpToCurrentState() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            valueAnimator = null;
            this.runningAnimator = null;
        }
    }

    public void setState(int[] object) {
        StateListAnimator$Tuple stateListAnimator$Tuple;
        block5: {
            ArrayList arrayList = this.tuples;
            int n10 = arrayList.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                stateListAnimator$Tuple = (StateListAnimator$Tuple)this.tuples.get(i10);
                int[] nArray = stateListAnimator$Tuple.specs;
                boolean bl2 = StateSet.stateSetMatches((int[])nArray, (int[])object);
                if (!bl2) {
                    continue;
                }
                break block5;
            }
            stateListAnimator$Tuple = null;
        }
        object = this.lastMatch;
        if (stateListAnimator$Tuple == object) {
            return;
        }
        if (object != null) {
            this.cancel();
        }
        this.lastMatch = stateListAnimator$Tuple;
        if (stateListAnimator$Tuple != null) {
            this.start(stateListAnimator$Tuple);
        }
    }
}

