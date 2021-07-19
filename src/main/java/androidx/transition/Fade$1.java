/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.ViewUtils;

public class Fade$1
extends TransitionListenerAdapter {
    public final /* synthetic */ Fade this$0;
    public final /* synthetic */ View val$view;

    public Fade$1(Fade fade, View view) {
        this.this$0 = fade;
        this.val$view = view;
    }

    public void onTransitionEnd(Transition transition) {
        ViewUtils.setTransitionAlpha(this.val$view, 1.0f);
        ViewUtils.clearNonTransitionAlpha(this.val$view);
        transition.removeListener(this);
    }
}

