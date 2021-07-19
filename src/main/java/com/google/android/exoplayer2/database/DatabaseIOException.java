/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.SQLException
 */
package com.google.android.exoplayer2.database;

import android.database.SQLException;
import java.io.IOException;

public final class DatabaseIOException
extends IOException {
    public DatabaseIOException(SQLException sQLException) {
        super((Throwable)sQLException);
    }

    public DatabaseIOException(SQLException sQLException, String string2) {
        super(string2, (Throwable)sQLException);
    }
}

