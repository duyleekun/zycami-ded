/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo;

public class DefaultSpecialEffectsController$5
implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ DefaultSpecialEffectsController$AnimationInfo val$animationInfo;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ View val$viewToAnimate;

    public DefaultSpecialEffectsController$5(DefaultSpecialEffectsController defaultSpecialEffectsController, View view, ViewGroup viewGroup, DefaultSpecialEffectsController$AnimationInfo defaultSpecialEffectsController$AnimationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$viewToAnimate = view;
        this.val$container = viewGroup;
        this.val$animationInfo = defaultSpecialEffectsController$AnimationInfo;
    }

    public void onCancel() {
        this.val$viewToAnimate.clearAnimation();
        ViewGroup viewGroup = this.val$container;
        View view = this.val$viewToAnimate;
        viewGroup.endViewTransition(view);
        this.val$animationInfo.completeSpecialEffect();
    }
}

