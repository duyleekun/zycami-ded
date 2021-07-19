/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.widget.Filter
 *  android.widget.Filter$FilterResults
 */
package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;
import androidx.cursoradapter.widget.CursorFilter$CursorFilterClient;

public class CursorFilter
extends Filter {
    public CursorFilter$CursorFilterClient mClient;

    public CursorFilter(CursorFilter$CursorFilterClient cursorFilter$CursorFilterClient) {
        this.mClient = cursorFilter$CursorFilterClient;
    }

    public CharSequence convertResultToString(Object object) {
        CursorFilter$CursorFilterClient cursorFilter$CursorFilterClient = this.mClient;
        object = (Cursor)object;
        return cursorFilter$CursorFilterClient.convertToString((Cursor)object);
    }

    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        charSequence = this.mClient.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (charSequence != null) {
            int n10;
            filterResults.count = n10 = charSequence.getCount();
            filterResults.values = charSequence;
        } else {
            filterResults.count = 0;
            charSequence = null;
            filterResults.values = null;
        }
        return filterResults;
    }

    public void publishResults(CharSequence object, Filter.FilterResults object2) {
        object = this.mClient.getCursor();
        object2 = object2.values;
        if (object2 != null && object2 != object) {
            object = this.mClient;
            object2 = (Cursor)object2;
            object.changeCursor((Cursor)object2);
        }
    }
}

