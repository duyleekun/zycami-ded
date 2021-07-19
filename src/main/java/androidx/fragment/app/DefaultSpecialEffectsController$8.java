/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentTransition;
import java.util.ArrayList;

public class DefaultSpecialEffectsController$8
implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ ArrayList val$transitioningViews;

    public DefaultSpecialEffectsController$8(DefaultSpecialEffectsController defaultSpecialEffectsController, ArrayList arrayList) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$transitioningViews = arrayList;
    }

    public void run() {
        FragmentTransition.setViewVisibility(this.val$transitioningViews, 4);
    }
}

