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
import androidx.recyclerview.widget.DefaultItemAnimator$ChangeInfo;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;

public class DefaultItemAnimator$8
extends AnimatorListenerAdapter {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ DefaultItemAnimator$ChangeInfo val$changeInfo;
    public final /* synthetic */ View val$newView;
    public final /* synthetic */ ViewPropertyAnimator val$newViewAnimation;

    public DefaultItemAnimator$8(DefaultItemAnimator defaultItemAnimator, DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.this$0 = defaultItemAnimator;
        this.val$changeInfo = defaultItemAnimator$ChangeInfo;
        this.val$newViewAnimation = viewPropertyAnimator;
        this.val$newView = view;
    }

    public void onAnimationEnd(Animator object) {
        this.val$newViewAnimation.setListener(null);
        this.val$newView.setAlpha(1.0f);
        this.val$newView.setTranslationX(0.0f);
        this.val$newView.setTranslationY(0.0f);
        object = this.this$0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.val$changeInfo.newHolder;
        ((SimpleItemAnimator)object).dispatchChangeFinished(recyclerView$ViewHolder, false);
        object = this.this$0.mChangeAnimations;
        recyclerView$ViewHolder = this.val$changeInfo.newHolder;
        ((ArrayList)object).remove(recyclerView$ViewHolder);
        this.this$0.dispatchFinishedWhenDone();
    }

    public void onAnimationStart(Animator object) {
        object = this.this$0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.val$changeInfo.newHolder;
        ((SimpleItemAnimator)object).dispatchChangeStarting(recyclerView$ViewHolder, false);
    }
}

