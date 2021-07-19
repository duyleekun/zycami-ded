/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.google.android.exoplayer2.offline;

import android.database.Cursor;
import com.google.android.exoplayer2.offline.DefaultDownloadIndex;
import com.google.android.exoplayer2.offline.DefaultDownloadIndex$1;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadCursor;

public final class DefaultDownloadIndex$DownloadCursorImpl
implements DownloadCursor {
    private final Cursor cursor;

    private DefaultDownloadIndex$DownloadCursorImpl(Cursor cursor) {
        this.cursor = cursor;
    }

    public /* synthetic */ DefaultDownloadIndex$DownloadCursorImpl(Cursor cursor, DefaultDownloadIndex$1 defaultDownloadIndex$1) {
        this(cursor);
    }

    public void close() {
        this.cursor.close();
    }

    public int getCount() {
        return this.cursor.getCount();
    }

    public Download getDownload() {
        return DefaultDownloadIndex.access$100(this.cursor);
    }

    public int getPosition() {
        return this.cursor.getPosition();
    }

    public boolean isClosed() {
        return this.cursor.isClosed();
    }

    public boolean moveToPosition(int n10) {
        return this.cursor.moveToPosition(n10);
    }
}

