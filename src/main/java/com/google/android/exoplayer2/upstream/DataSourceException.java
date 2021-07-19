/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public final class DataSourceException
extends IOException {
    public static final int POSITION_OUT_OF_RANGE;
    public final int reason;

    public DataSourceException(int n10) {
        this.reason = n10;
    }

    public static boolean isCausedByPositionOutOfRange(IOException throwable) {
        while (throwable != null) {
            int n10 = throwable instanceof DataSourceException;
            if (n10 != 0) {
                IOException iOException = throwable;
                iOException = (DataSourceException)throwable;
                n10 = ((DataSourceException)iOException).reason;
                if (n10 == 0) {
                    return true;
                }
            }
            throwable = ((Throwable)throwable).getCause();
        }
        return false;
    }
}

