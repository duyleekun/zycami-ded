/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 */
package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;
import androidx.appcompat.app.AlertController;

public class AlertController$4
implements AbsListView.OnScrollListener {
    public final /* synthetic */ AlertController this$0;
    public final /* synthetic */ View val$bottom;
    public final /* synthetic */ View val$top;

    public AlertController$4(AlertController alertController, View view, View view2) {
        this.this$0 = alertController;
        this.val$top = view;
        this.val$bottom = view2;
    }

    public void onScroll(AbsListView absListView, int n10, int n11, int n12) {
        View view = this.val$top;
        View view2 = this.val$bottom;
        AlertController.manageScrollIndicators((View)absListView, view, view2);
    }

    public void onScrollStateChanged(AbsListView absListView, int n10) {
    }
}

