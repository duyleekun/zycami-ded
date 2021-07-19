/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentManager$7
extends AnimatorListenerAdapter {
    public final /* synthetic */ FragmentManager this$0;
    public final /* synthetic */ View val$animatingView;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ Fragment val$fragment;

    public FragmentManager$7(FragmentManager fragmentManager, ViewGroup viewGroup, View view, Fragment fragment) {
        this.this$0 = fragmentManager;
        this.val$container = viewGroup;
        this.val$animatingView = view;
        this.val$fragment = fragment;
    }

    public void onAnimationEnd(Animator object) {
        int n10;
        ViewGroup viewGroup = this.val$container;
        View view = this.val$animatingView;
        viewGroup.endViewTransition(view);
        object.removeListener((Animator.AnimatorListener)this);
        object = this.val$fragment;
        viewGroup = object.mView;
        if (viewGroup != null && (n10 = object.mHidden) != 0) {
            n10 = 8;
            viewGroup.setVisibility(n10);
        }
    }
}

