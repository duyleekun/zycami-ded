/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;

public class Fragment$3
implements Runnable {
    public final /* synthetic */ Fragment this$0;
    public final /* synthetic */ SpecialEffectsController val$controller;

    public Fragment$3(Fragment fragment, SpecialEffectsController specialEffectsController) {
        this.this$0 = fragment;
        this.val$controller = specialEffectsController;
    }

    public void run() {
        this.val$controller.executePendingOperations();
    }
}

