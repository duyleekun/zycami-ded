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
import androidx.fragment.app.DefaultSpecialEffectsController$4;

public class DefaultSpecialEffectsController$4$1
implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController$4 this$1;

    public DefaultSpecialEffectsController$4$1(DefaultSpecialEffectsController$4 var1_1) {
        this.this$1 = var1_1;
    }

    public void run() {
        DefaultSpecialEffectsController$4 defaultSpecialEffectsController$4 = this.this$1;
        ViewGroup viewGroup = defaultSpecialEffectsController$4.val$container;
        defaultSpecialEffectsController$4 = defaultSpecialEffectsController$4.val$viewToAnimate;
        viewGroup.endViewTransition((View)defaultSpecialEffectsController$4);
        this.this$1.val$animationInfo.completeSpecialEffect();
    }
}

