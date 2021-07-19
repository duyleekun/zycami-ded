/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 */
package androidx.cursoradapter.widget;

import android.database.ContentObserver;
import android.os.Handler;
import androidx.cursoradapter.widget.CursorAdapter;

public class CursorAdapter$ChangeObserver
extends ContentObserver {
    public final /* synthetic */ CursorAdapter this$0;

    public CursorAdapter$ChangeObserver(CursorAdapter cursorAdapter) {
        this.this$0 = cursorAdapter;
        super((Handler)cursorAdapter);
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean bl2) {
        this.this$0.onContentChanged();
    }
}

