/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.Layout
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewPropertyAnimator
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;
import com.google.android.material.snackbar.ContentViewCallback;

public class SnackbarContentLayout
extends LinearLayout
implements ContentViewCallback {
    private Button actionView;
    private int maxInlineActionWidth;
    private int maxWidth;
    private TextView messageView;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] nArray = R$styleable.SnackbarLayout;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = R$styleable.SnackbarLayout_android_maxWidth;
        int n11 = -1;
        this.maxWidth = n10 = context.getDimensionPixelSize(n10, n11);
        n10 = R$styleable.SnackbarLayout_maxActionInlineWidth;
        this.maxInlineActionWidth = n10 = context.getDimensionPixelSize(n10, n11);
        context.recycle();
    }

    private static void updateTopBottomPadding(View view, int n10, int n11) {
        int n12 = ViewCompat.isPaddingRelative(view);
        if (n12 != 0) {
            n12 = ViewCompat.getPaddingStart(view);
            int n13 = ViewCompat.getPaddingEnd(view);
            ViewCompat.setPaddingRelative(view, n12, n10, n13, n11);
        } else {
            n12 = view.getPaddingLeft();
            int n14 = view.getPaddingRight();
            view.setPadding(n12, n10, n14, n11);
        }
    }

    private boolean updateViewsWithinLayout(int n10, int n11, int n12) {
        TextView textView;
        float f10;
        int n13 = this.getOrientation();
        int n14 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 != n13) {
            this.setOrientation(n10);
            n10 = n14;
            f10 = f11;
        } else {
            n10 = 0;
            f10 = 0.0f;
            textView = null;
        }
        TextView textView2 = this.messageView;
        n13 = textView2.getPaddingTop();
        if (n13 == n11 && (n13 = (textView2 = this.messageView).getPaddingBottom()) == n12) {
            n14 = n10;
            f11 = f10;
        } else {
            textView = this.messageView;
            SnackbarContentLayout.updateTopBottomPadding((View)textView, n11, n12);
        }
        return n14 != 0;
    }

    public void animateContentIn(int n10, int n11) {
        this.messageView.setAlpha(0.0f);
        ViewPropertyAnimator viewPropertyAnimator = this.messageView.animate();
        float f10 = 1.0f;
        viewPropertyAnimator = viewPropertyAnimator.alpha(f10);
        long l10 = n11;
        ViewPropertyAnimator viewPropertyAnimator2 = viewPropertyAnimator.setDuration(l10);
        long l11 = n10;
        viewPropertyAnimator2.setStartDelay(l11).start();
        Button button = this.actionView;
        n10 = button.getVisibility();
        if (n10 == 0) {
            this.actionView.setAlpha(0.0f);
            button = this.actionView.animate().alpha(f10).setDuration(l10).setStartDelay(l11);
            button.start();
        }
    }

    public void animateContentOut(int n10, int n11) {
        TextView textView = this.messageView;
        float f10 = 1.0f;
        textView.setAlpha(f10);
        textView = this.messageView.animate().alpha(0.0f);
        long l10 = n11;
        ViewPropertyAnimator viewPropertyAnimator = textView.setDuration(l10);
        long l11 = n10;
        viewPropertyAnimator.setStartDelay(l11).start();
        Button button = this.actionView;
        n10 = button.getVisibility();
        if (n10 == 0) {
            this.actionView.setAlpha(f10);
            button = this.actionView.animate().alpha(0.0f).setDuration(l10).setStartDelay(l11);
            button.start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    public void onFinishInflate() {
        TextView textView;
        super.onFinishInflate();
        int n10 = R$id.snackbar_text;
        this.messageView = textView = (TextView)this.findViewById(n10);
        n10 = R$id.snackbar_action;
        textView = (Button)this.findViewById(n10);
        this.actionView = textView;
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        block9: {
            int n13;
            block10: {
                int n14;
                int n15;
                int n16;
                block8: {
                    int n17;
                    Button button;
                    int n18;
                    super.onMeasure(n10, n11);
                    n16 = this.maxWidth;
                    if (n16 > 0 && (n16 = this.getMeasuredWidth()) > (n15 = this.maxWidth)) {
                        n10 = View.MeasureSpec.makeMeasureSpec((int)n15, (int)0x40000000);
                        super.onMeasure(n10, n11);
                    }
                    Resources resources = this.getResources();
                    n15 = R$dimen.design_snackbar_padding_vertical_2lines;
                    n16 = resources.getDimensionPixelSize(n15);
                    Resources resources2 = this.getResources();
                    n14 = R$dimen.design_snackbar_padding_vertical;
                    n15 = resources2.getDimensionPixelSize(n14);
                    Layout layout2 = this.messageView.getLayout();
                    n14 = layout2.getLineCount();
                    n12 = 0;
                    n13 = 1;
                    if (n14 > n13) {
                        n14 = n13;
                    } else {
                        n14 = 0;
                        layout2 = null;
                    }
                    if (n14 == 0 || (n18 = this.maxInlineActionWidth) <= 0 || (n18 = (button = this.actionView).getMeasuredWidth()) <= (n17 = this.maxInlineActionWidth)) break block8;
                    if ((n16 = (int)(this.updateViewsWithinLayout(n13, n16, n15 = n16 - n15) ? 1 : 0)) == 0) break block9;
                    break block10;
                }
                if (n14 == 0) {
                    n16 = n15;
                }
                n16 = (int)(this.updateViewsWithinLayout(0, n16, n16) ? 1 : 0);
                if (n16 == 0) break block9;
            }
            n12 = n13;
        }
        if (n12 != 0) {
            super.onMeasure(n10, n11);
        }
    }
}

