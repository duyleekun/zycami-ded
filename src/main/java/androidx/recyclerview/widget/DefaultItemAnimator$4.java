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

public class DefaultItemAnimator$4
extends AnimatorListenerAdapter {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ ViewPropertyAnimator val$animation;
    public final /* synthetic */ RecyclerView$ViewHolder val$holder;
    public final /* synthetic */ View val$view;

    public DefaultItemAnimator$4(DefaultItemAnimator defaultItemAnimator, RecyclerView$ViewHolder recyclerView$ViewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.this$0 = defaultItemAnimator;
        this.val$holder = recyclerView$ViewHolder;
        this.val$animation = viewPropertyAnimator;
        this.val$view = view;
    }

    public void onAnimationEnd(Animator object) {
        this.val$animation.setListener(null);
        this.val$view.setAlpha(1.0f);
        object = this.this$0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.val$holder;
        ((SimpleItemAnimator)object).dispatchRemoveFinished(recyclerView$ViewHolder);
        object = this.this$0.mRemoveAnimations;
        recyclerView$ViewHolder = this.val$holder;
        ((ArrayList)object).remove(recyclerView$ViewHolder);
        this.this$0.dispatchFinishedWhenDone();
    }

    public void onAnimationStart(Animator object) {
        object = this.this$0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.val$holder;
        ((SimpleItemAnimator)object).dispatchRemoveStarting(recyclerView$ViewHolder);
    }
}

