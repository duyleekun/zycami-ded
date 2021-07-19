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

public class DefaultItemAnimator$7
extends AnimatorListenerAdapter {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ DefaultItemAnimator$ChangeInfo val$changeInfo;
    public final /* synthetic */ ViewPropertyAnimator val$oldViewAnim;
    public final /* synthetic */ View val$view;

    public DefaultItemAnimator$7(DefaultItemAnimator defaultItemAnimator, DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.this$0 = defaultItemAnimator;
        this.val$changeInfo = defaultItemAnimator$ChangeInfo;
        this.val$oldViewAnim = viewPropertyAnimator;
        this.val$view = view;
    }

    public void onAnimationEnd(Animator object) {
        this.val$oldViewAnim.setListener(null);
        this.val$view.setAlpha(1.0f);
        this.val$view.setTranslationX(0.0f);
        this.val$view.setTranslationY(0.0f);
        object = this.this$0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.val$changeInfo.oldHolder;
        ((SimpleItemAnimator)object).dispatchChangeFinished(recyclerView$ViewHolder, true);
        object = this.this$0.mChangeAnimations;
        recyclerView$ViewHolder = this.val$changeInfo.oldHolder;
        ((ArrayList)object).remove(recyclerView$ViewHolder);
        this.this$0.dispatchFinishedWhenDone();
    }

    public void onAnimationStart(Animator object) {
        object = this.this$0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.val$changeInfo.oldHolder;
        ((SimpleItemAnimator)object).dispatchChangeStarting(recyclerView$ViewHolder, true);
    }
}

