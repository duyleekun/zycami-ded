/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeClipBounds;

public class ChangeClipBounds$1
extends AnimatorListenerAdapter {
    public final /* synthetic */ ChangeClipBounds this$0;
    public final /* synthetic */ View val$endView;

    public ChangeClipBounds$1(ChangeClipBounds changeClipBounds, View view) {
        this.this$0 = changeClipBounds;
        this.val$endView = view;
    }

    public void onAnimationEnd(Animator animator2) {
        ViewCompat.setClipBounds(this.val$endView, null);
    }
}

