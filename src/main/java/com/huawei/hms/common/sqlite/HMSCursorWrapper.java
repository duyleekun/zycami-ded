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
package com.huawei.hms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class HMSCursorWrapper
extends CursorWrapper
implements CrossProcessCursor {
    private AbstractWindowedCursor mCursor;

    public HMSCursorWrapper(Cursor object) {
        super(object);
        if (object != null) {
            boolean bl2 = object instanceof CursorWrapper;
            String string2 = " is not a subclass for CursorWrapper";
            if (bl2) {
                if ((object = ((CursorWrapper)object).getWrappedCursor()) != null) {
                    bl2 = object instanceof AbstractWindowedCursor;
                    if (bl2) {
                        object = (AbstractWindowedCursor)object;
                        this.mCursor = object;
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("getWrappedCursor:");
                    stringBuilder.append(object);
                    stringBuilder.append(string2);
                    object = stringBuilder.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                    throw illegalArgumentException;
                }
                super("getWrappedCursor cannot be null");
                throw object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cursor:");
            stringBuilder.append(object);
            stringBuilder.append(string2);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        super("cursor cannot be null");
        throw object;
    }

    public void fillWindow(int n10, CursorWindow cursorWindow) {
        this.mCursor.fillWindow(n10, cursorWindow);
    }

    public CursorWindow getWindow() {
        return this.mCursor.getWindow();
    }

    public Cursor getWrappedCursor() {
        return this.mCursor;
    }

    public boolean onMove(int n10, int n11) {
        return this.mCursor.onMove(n10, n11);
    }

    public void setWindow(CursorWindow cursorWindow) {
        this.mCursor.setWindow(cursorWindow);
    }
}

