/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckedTextView
 *  android.widget.CursorAdapter
 */
package androidx.appcompat.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertController$AlertParams;
import androidx.appcompat.app.AlertController$RecycleListView;

public class AlertController$AlertParams$2
extends CursorAdapter {
    private final int mIsCheckedIndex;
    private final int mLabelIndex;
    public final /* synthetic */ AlertController$AlertParams this$0;
    public final /* synthetic */ AlertController val$dialog;
    public final /* synthetic */ AlertController$RecycleListView val$listView;

    public AlertController$AlertParams$2(AlertController$AlertParams object, Context context, Cursor object2, boolean bl2, AlertController$RecycleListView alertController$RecycleListView, AlertController alertController) {
        int n10;
        int n11;
        this.this$0 = object;
        this.val$listView = alertController$RecycleListView;
        this.val$dialog = alertController;
        super(context, object2, bl2);
        context = this.getCursor();
        object2 = ((AlertController$AlertParams)object).mLabelColumn;
        this.mLabelIndex = n11 = context.getColumnIndexOrThrow((String)object2);
        object = ((AlertController$AlertParams)object).mIsCheckedColumn;
        this.mIsCheckedIndex = n10 = context.getColumnIndexOrThrow((String)object);
    }

    public void bindView(View object, Context object2, Cursor cursor) {
        object = (CheckedTextView)object.findViewById(16908308);
        int n10 = this.mLabelIndex;
        object2 = cursor.getString(n10);
        object.setText((CharSequence)object2);
        object = this.val$listView;
        n10 = cursor.getPosition();
        int n11 = this.mIsCheckedIndex;
        int n12 = cursor.getInt(n11);
        n11 = 1;
        if (n12 != n11) {
            n11 = 0;
        }
        object.setItemChecked(n10, n11 != 0);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        context = this.this$0.mInflater;
        int n10 = this.val$dialog.mMultiChoiceItemLayout;
        return context.inflate(n10, viewGroup, false);
    }
}

