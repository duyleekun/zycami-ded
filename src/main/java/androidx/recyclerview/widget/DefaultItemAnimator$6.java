/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;

public class DefaultItemAnimator$6
extends AnimatorListenerAdapter {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ ViewPropertyAnimator val$animation;
    public final /* synthetic */ int val$deltaX;
    public final /* synthetic */ int val$deltaY;
    public final /* synthetic */ RecyclerView$ViewHolder val$holder;
    public final /* synthetic */ View val$view;

    public DefaultItemAnimator$6(DefaultItemAnimator defaultItemAnimator, RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, View view, int n11, ViewPropertyAnimator viewPropertyAnimator) {
        this.this$0 = defaultItemAnimator;
        this.val$holder = recyclerView$ViewHolder;
        this.val$deltaX = n10;
        this.val$view = view;
        this.val$deltaY = n11;
        this.val$animation = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator2) {
        int n10 = this.val$deltaX;
        if (n10 != 0) {
            animator2 = this.val$view;
            animator2.setTranslationX(0.0f);
        }
        if ((n10 = this.val$deltaY) != 0) {
            animator2 = this.val$view;
            animator2.setTranslationY(0.0f);
        }
    }

    public void onAnimationEnd(Animator object) {
        this.val$animation.setListener(null);
        object = this.this$0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.val$holder;
        ((SimpleItemAnimator)object).dispatchMoveFinished(recyclerView$ViewHolder);
        object = this.this$0.mMoveAnimations;
        recyclerView$ViewHolder = this.val$holder;
        ((ArrayList)object).remove(recyclerView$ViewHolder);
        this.this$0.dispatchFinishedWhenDone();
    }

    public void onAnimationStart(Animator object) {
        object = this.this$0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.val$holder;
        ((SimpleItemAnimator)object).dispatchMoveStarting(recyclerView$ViewHolder);
    }
}

