/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.AbstractWindowedCursor
 *  android.database.CrossProcessCursor
 *  android.database.Cursor
 *  android.database.CursorWindow
 *  android.database.CursorWrapper
 */
package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;

public class CursorWrapper
extends android.database.CursorWrapper
implements CrossProcessCursor {
    private AbstractWindowedCursor zza;

    public CursorWrapper(Cursor object) {
        super((Cursor)object);
        int n10;
        int n11;
        IllegalArgumentException illegalArgumentException = null;
        for (n11 = 0; n11 < (n10 = 10) && (n10 = object instanceof android.database.CursorWrapper) != 0; ++n11) {
            object = ((android.database.CursorWrapper)object).getWrappedCursor();
        }
        n11 = object instanceof AbstractWindowedCursor;
        if (n11 == 0) {
            String string2 = "Unknown type: ";
            int n12 = ((String)(object = String.valueOf(object.getClass().getName()))).length();
            object = n12 != 0 ? string2.concat((String)object) : new String(string2);
            illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        object = (AbstractWindowedCursor)object;
        this.zza = object;
    }

    public void fillWindow(int n10, CursorWindow cursorWindow) {
        this.zza.fillWindow(n10, cursorWindow);
    }

    public CursorWindow getWindow() {
        return this.zza.getWindow();
    }

    public /* synthetic */ Cursor getWrappedCursor() {
        return this.zza;
    }

    public boolean onMove(int n10, int n11) {
        return this.zza.onMove(n10, n11);
    }

    public void setWindow(CursorWindow cursorWindow) {
        this.zza.setWindow(cursorWindow);
    }
}

