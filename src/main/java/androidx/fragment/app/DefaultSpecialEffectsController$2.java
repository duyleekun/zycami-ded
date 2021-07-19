/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo;
import androidx.fragment.app.SpecialEffectsController$Operation;
import androidx.fragment.app.SpecialEffectsController$Operation$State;

public class DefaultSpecialEffectsController$2
extends AnimatorListenerAdapter {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ DefaultSpecialEffectsController$AnimationInfo val$animationInfo;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ boolean val$isHideOperation;
    public final /* synthetic */ SpecialEffectsController$Operation val$operation;
    public final /* synthetic */ View val$viewToAnimate;

    public DefaultSpecialEffectsController$2(DefaultSpecialEffectsController defaultSpecialEffectsController, ViewGroup viewGroup, View view, boolean bl2, SpecialEffectsController$Operation specialEffectsController$Operation, DefaultSpecialEffectsController$AnimationInfo animationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$isHideOperation = bl2;
        this.val$operation = specialEffectsController$Operation;
        this.val$animationInfo = animationInfo;
    }

    public void onAnimationEnd(Animator object) {
        object = this.val$container;
        View view = this.val$viewToAnimate;
        object.endViewTransition(view);
        boolean bl2 = this.val$isHideOperation;
        if (bl2) {
            object = this.val$operation.getFinalState();
            view = this.val$viewToAnimate;
            ((SpecialEffectsController$Operation$State)((Object)object)).applyState(view);
        }
        this.val$animationInfo.completeSpecialEffect();
    }
}

