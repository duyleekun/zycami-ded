/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ArrayAdapter
 */
package androidx.appcompat.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController$AlertParams;
import androidx.appcompat.app.AlertController$RecycleListView;

public class AlertController$AlertParams$1
extends ArrayAdapter {
    public final /* synthetic */ AlertController$AlertParams this$0;
    public final /* synthetic */ AlertController$RecycleListView val$listView;

    public AlertController$AlertParams$1(AlertController$AlertParams alertParams, Context context, int n10, int n11, CharSequence[] charSequenceArray, AlertController$RecycleListView recycleListView) {
        this.this$0 = alertParams;
        this.val$listView = recycleListView;
        super(context, n10, n11, (Object[])charSequenceArray);
    }

    public View getView(int n10, View view, ViewGroup object) {
        ViewGroup viewGroup;
        view = super.getView(n10, view, object);
        object = this.this$0.mCheckedItems;
        if (object != null && (viewGroup = object[n10]) != false) {
            object = this.val$listView;
            boolean bl2 = true;
            object.setItemChecked(n10, bl2);
        }
        return view;
    }
}

