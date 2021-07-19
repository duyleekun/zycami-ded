/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.ChangeBounds;
import androidx.transition.ViewUtils;

public class ChangeBounds$10
extends AnimatorListenerAdapter {
    public final /* synthetic */ ChangeBounds this$0;
    public final /* synthetic */ BitmapDrawable val$drawable;
    public final /* synthetic */ ViewGroup val$sceneRoot;
    public final /* synthetic */ float val$transitionAlpha;
    public final /* synthetic */ View val$view;

    public ChangeBounds$10(ChangeBounds changeBounds, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
        this.this$0 = changeBounds;
        this.val$sceneRoot = viewGroup;
        this.val$drawable = bitmapDrawable;
        this.val$view = view;
        this.val$transitionAlpha = f10;
    }

    public void onAnimationEnd(Animator object) {
        object = ViewUtils.getOverlay((View)this.val$sceneRoot);
        BitmapDrawable bitmapDrawable = this.val$drawable;
        object.remove((Drawable)bitmapDrawable);
        object = this.val$view;
        float f10 = this.val$transitionAlpha;
        ViewUtils.setTransitionAlpha((View)object, f10);
    }
}

