/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource$Factory;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class FileDataSourceFactory
implements DataSource$Factory {
    private final FileDataSource$Factory wrappedFactory;

    public FileDataSourceFactory() {
        this(null);
    }

    public FileDataSourceFactory(TransferListener object) {
        FileDataSource$Factory fileDataSource$Factory = new FileDataSource$Factory();
        this.wrappedFactory = object = fileDataSource$Factory.setListener((TransferListener)object);
    }

    public FileDataSource createDataSource() {
        return this.wrappedFactory.createDataSource();
    }
}

