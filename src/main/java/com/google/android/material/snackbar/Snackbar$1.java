/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;

public class Snackbar$1
implements View.OnClickListener {
    public final /* synthetic */ Snackbar this$0;
    public final /* synthetic */ View.OnClickListener val$listener;

    public Snackbar$1(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.this$0 = snackbar;
        this.val$listener = onClickListener;
    }

    public void onClick(View view) {
        this.val$listener.onClick(view);
        this.this$0.dispatchDismiss(1);
    }
}

