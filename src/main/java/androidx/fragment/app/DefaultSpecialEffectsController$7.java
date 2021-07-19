/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 */
package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentTransitionImpl;

public class DefaultSpecialEffectsController$7
implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ FragmentTransitionImpl val$impl;
    public final /* synthetic */ Rect val$lastInEpicenterRect;
    public final /* synthetic */ View val$lastInEpicenterView;

    public DefaultSpecialEffectsController$7(DefaultSpecialEffectsController defaultSpecialEffectsController, FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$impl = fragmentTransitionImpl;
        this.val$lastInEpicenterView = view;
        this.val$lastInEpicenterRect = rect;
    }

    public void run() {
        FragmentTransitionImpl fragmentTransitionImpl = this.val$impl;
        View view = this.val$lastInEpicenterView;
        Rect rect = this.val$lastInEpicenterRect;
        fragmentTransitionImpl.getBoundsOnScreen(view, rect);
    }
}

