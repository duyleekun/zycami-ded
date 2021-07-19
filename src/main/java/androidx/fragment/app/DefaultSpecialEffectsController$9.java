/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo;

public class DefaultSpecialEffectsController$9
implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ DefaultSpecialEffectsController$TransitionInfo val$transitionInfo;

    public DefaultSpecialEffectsController$9(DefaultSpecialEffectsController defaultSpecialEffectsController, DefaultSpecialEffectsController$TransitionInfo transitionInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$transitionInfo = transitionInfo;
    }

    public void run() {
        this.val$transitionInfo.completeSpecialEffect();
    }
}

