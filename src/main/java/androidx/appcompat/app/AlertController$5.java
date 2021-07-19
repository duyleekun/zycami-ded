/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ListView
 */
package androidx.appcompat.app;

import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;

public class AlertController$5
implements Runnable {
    public final /* synthetic */ AlertController this$0;
    public final /* synthetic */ View val$bottom;
    public final /* synthetic */ View val$top;

    public AlertController$5(AlertController alertController, View view, View view2) {
        this.this$0 = alertController;
        this.val$top = view;
        this.val$bottom = view2;
    }

    public void run() {
        ListView listView = this.this$0.mListView;
        View view = this.val$top;
        View view2 = this.val$bottom;
        AlertController.manageScrollIndicators((View)listView, view, view2);
    }
}

