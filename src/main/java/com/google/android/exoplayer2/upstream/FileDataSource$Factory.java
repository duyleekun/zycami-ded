/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class FileDataSource$Factory
implements DataSource$Factory {
    private TransferListener listener;

    public FileDataSource createDataSource() {
        FileDataSource fileDataSource = new FileDataSource();
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            fileDataSource.addTransferListener(transferListener);
        }
        return fileDataSource;
    }

    public FileDataSource$Factory setListener(TransferListener transferListener) {
        this.listener = transferListener;
        return this;
    }
}

