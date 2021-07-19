/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.Download;
import java.io.Closeable;

public interface DownloadCursor
extends Closeable {
    public void close();

    public int getCount();

    public Download getDownload();

    public int getPosition();

    default public boolean isAfterLast() {
        int n10;
        int n11 = this.getCount();
        boolean bl2 = true;
        if (n11 == 0) {
            return bl2;
        }
        n11 = this.getPosition();
        if (n11 != (n10 = this.getCount())) {
            bl2 = false;
        }
        return bl2;
    }

    default public boolean isBeforeFirst() {
        int n10;
        int n11 = this.getCount();
        boolean bl2 = true;
        if (n11 == 0) {
            return bl2;
        }
        n11 = this.getPosition();
        if (n11 != (n10 = -1)) {
            bl2 = false;
        }
        return bl2;
    }

    public boolean isClosed();

    default public boolean isFirst() {
        int n10 = this.getPosition();
        n10 = n10 == 0 && (n10 = this.getCount()) != 0 ? 1 : 0;
        return n10 != 0;
    }

    default public boolean isLast() {
        int n10;
        int n11 = this.getCount();
        int n12 = this.getPosition();
        n11 = n12 == (n10 = n11 + -1) && n11 != 0 ? 1 : 0;
        return n11 != 0;
    }

    default public boolean moveToFirst() {
        return this.moveToPosition(0);
    }

    default public boolean moveToLast() {
        int n10 = this.getCount() + -1;
        return this.moveToPosition(n10);
    }

    default public boolean moveToNext() {
        int n10 = this.getPosition() + 1;
        return this.moveToPosition(n10);
    }

    public boolean moveToPosition(int var1);

    default public boolean moveToPrevious() {
        int n10 = this.getPosition() + -1;
        return this.moveToPosition(n10);
    }
}

