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

public class AlertController$3
implements Runnable {
    public final /* synthetic */ AlertController this$0;
    public final /* synthetic */ View val$bottom;
    public final /* synthetic */ View val$top;

    public AlertController$3(AlertController alertController, View view, View view2) {
        this.this$0 = alertController;
        this.val$top = view;
        this.val$bottom = view2;
    }

    public void run() {
        NestedScrollView nestedScrollView = this.this$0.mScrollView;
        View view = this.val$top;
        View view2 = this.val$bottom;
        AlertController.manageScrollIndicators((View)nestedScrollView, view, view2);
    }
}

