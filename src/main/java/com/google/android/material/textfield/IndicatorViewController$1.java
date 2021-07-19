/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.widget.TextView
 */
package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.google.android.material.textfield.IndicatorViewController;

public class IndicatorViewController$1
extends AnimatorListenerAdapter {
    public final /* synthetic */ IndicatorViewController this$0;
    public final /* synthetic */ int val$captionToHide;
    public final /* synthetic */ int val$captionToShow;
    public final /* synthetic */ TextView val$captionViewToHide;
    public final /* synthetic */ TextView val$captionViewToShow;

    public IndicatorViewController$1(IndicatorViewController indicatorViewController, int n10, TextView textView, int n11, TextView textView2) {
        this.this$0 = indicatorViewController;
        this.val$captionToShow = n10;
        this.val$captionViewToHide = textView;
        this.val$captionToHide = n11;
        this.val$captionViewToShow = textView2;
    }

    public void onAnimationEnd(Animator object) {
        object = this.this$0;
        int n10 = this.val$captionToShow;
        IndicatorViewController.access$002((IndicatorViewController)object, n10);
        object = this.this$0;
        n10 = 0;
        IndicatorViewController.access$102((IndicatorViewController)object, null);
        object = this.val$captionViewToHide;
        if (object != null) {
            object.setVisibility(4);
            int n11 = this.val$captionToHide;
            int n12 = 1;
            if (n11 == n12 && (object = IndicatorViewController.access$200(this.this$0)) != null) {
                object = IndicatorViewController.access$200(this.this$0);
                object.setText(null);
            }
        }
    }

    public void onAnimationStart(Animator animator2) {
        animator2 = this.val$captionViewToShow;
        if (animator2 != null) {
            animator2.setVisibility(0);
        }
    }
}

