/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView$OnScrollChangeListener;

public class AlertController$2
implements NestedScrollView$OnScrollChangeListener {
    public final /* synthetic */ AlertController this$0;
    public final /* synthetic */ View val$bottom;
    public final /* synthetic */ View val$top;

    public AlertController$2(AlertController alertController, View view, View view2) {
        this.this$0 = alertController;
        this.val$top = view;
        this.val$bottom = view2;
    }

    public void onScrollChange(NestedScrollView nestedScrollView, int n10, int n11, int n12, int n13) {
        View view = this.val$top;
        View view2 = this.val$bottom;
        AlertController.manageScrollIndicators((View)nestedScrollView, view, view2);
    }
}

