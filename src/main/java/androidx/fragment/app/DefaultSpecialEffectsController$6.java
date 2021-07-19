/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.collection.ArrayMap;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.SpecialEffectsController$Operation;

public class DefaultSpecialEffectsController$6
implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ SpecialEffectsController$Operation val$firstOut;
    public final /* synthetic */ boolean val$isPop;
    public final /* synthetic */ SpecialEffectsController$Operation val$lastIn;
    public final /* synthetic */ ArrayMap val$lastInViews;

    public DefaultSpecialEffectsController$6(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController$Operation specialEffectsController$Operation, SpecialEffectsController$Operation specialEffectsController$Operation2, boolean bl2, ArrayMap arrayMap) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$lastIn = specialEffectsController$Operation;
        this.val$firstOut = specialEffectsController$Operation2;
        this.val$isPop = bl2;
        this.val$lastInViews = arrayMap;
    }

    public void run() {
        Fragment fragment = this.val$lastIn.getFragment();
        Fragment fragment2 = this.val$firstOut.getFragment();
        boolean bl2 = this.val$isPop;
        ArrayMap arrayMap = this.val$lastInViews;
        FragmentTransition.callSharedElementStartEnd(fragment, fragment2, bl2, arrayMap, false);
    }
}

