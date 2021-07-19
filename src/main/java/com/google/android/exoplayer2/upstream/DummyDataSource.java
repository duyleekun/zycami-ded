/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import d.h.a.a.q0.c;
import java.io.IOException;

public final class DummyDataSource
implements DataSource {
    public static final DataSource$Factory FACTORY;
    public static final DummyDataSource INSTANCE;

    static {
        DummyDataSource dummyDataSource;
        INSTANCE = dummyDataSource = new DummyDataSource();
        FACTORY = c.a;
    }

    private DummyDataSource() {
    }

    public static /* synthetic */ DummyDataSource b() {
        DummyDataSource dummyDataSource = new DummyDataSource();
        return dummyDataSource;
    }

    public void addTransferListener(TransferListener transferListener) {
    }

    public void close() {
    }

    public Uri getUri() {
        return null;
    }

    public long open(DataSpec object) {
        object = new IOException("DummyDataSource cannot be opened");
        throw object;
    }

    public int read(byte[] object, int n10, int n11) {
        object = new UnsupportedOperationException;
        object();
        throw object;
    }
}

