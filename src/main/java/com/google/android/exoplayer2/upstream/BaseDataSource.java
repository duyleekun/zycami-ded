/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;

public abstract class BaseDataSource
implements DataSource {
    private DataSpec dataSpec;
    private final boolean isNetwork;
    private int listenerCount;
    private final ArrayList listeners;

    public BaseDataSource(boolean bl2) {
        ArrayList arrayList;
        this.isNetwork = bl2;
        this.listeners = arrayList = new ArrayList(1);
    }

    public final void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        ArrayList arrayList = this.listeners;
        boolean bl2 = arrayList.contains(transferListener);
        if (!bl2) {
            int n10;
            arrayList = this.listeners;
            arrayList.add(transferListener);
            this.listenerCount = n10 = this.listenerCount + 1;
        }
    }

    public final void bytesTransferred(int n10) {
        int n11;
        DataSpec dataSpec = (DataSpec)Util.castNonNull(this.dataSpec);
        for (int i10 = 0; i10 < (n11 = this.listenerCount); ++i10) {
            TransferListener transferListener = (TransferListener)this.listeners.get(i10);
            boolean bl2 = this.isNetwork;
            transferListener.onBytesTransferred(this, dataSpec, bl2, n10);
        }
    }

    public final void transferEnded() {
        int n10;
        DataSpec dataSpec = (DataSpec)Util.castNonNull(this.dataSpec);
        for (int i10 = 0; i10 < (n10 = this.listenerCount); ++i10) {
            TransferListener transferListener = (TransferListener)this.listeners.get(i10);
            boolean bl2 = this.isNetwork;
            transferListener.onTransferEnd(this, dataSpec, bl2);
        }
        this.dataSpec = null;
    }

    public final void transferInitializing(DataSpec dataSpec) {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.listenerCount); ++i10) {
            TransferListener transferListener = (TransferListener)this.listeners.get(i10);
            boolean bl2 = this.isNetwork;
            transferListener.onTransferInitializing(this, dataSpec, bl2);
        }
    }

    public final void transferStarted(DataSpec dataSpec) {
        int n10;
        this.dataSpec = dataSpec;
        for (int i10 = 0; i10 < (n10 = this.listenerCount); ++i10) {
            TransferListener transferListener = (TransferListener)this.listeners.get(i10);
            boolean bl2 = this.isNetwork;
            transferListener.onTransferStart(this, dataSpec, bl2);
        }
    }
}

