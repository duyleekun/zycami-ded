/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 */
package androidx.cursoradapter.widget;

import android.database.DataSetObserver;
import androidx.cursoradapter.widget.CursorAdapter;

public class CursorAdapter$MyDataSetObserver
extends DataSetObserver {
    public final /* synthetic */ CursorAdapter this$0;

    public CursorAdapter$MyDataSetObserver(CursorAdapter cursorAdapter) {
        this.this$0 = cursorAdapter;
    }

    public void onChanged() {
        CursorAdapter cursorAdapter = this.this$0;
        cursorAdapter.mDataValid = true;
        cursorAdapter.notifyDataSetChanged();
    }

    public void onInvalidated() {
        CursorAdapter cursorAdapter = this.this$0;
        cursorAdapter.mDataValid = false;
        cursorAdapter.notifyDataSetInvalidated();
    }
}

