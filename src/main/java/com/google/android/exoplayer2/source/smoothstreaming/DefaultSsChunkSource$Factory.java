/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource$Factory;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class DefaultSsChunkSource$Factory
implements SsChunkSource$Factory {
    private final DataSource$Factory dataSourceFactory;

    public DefaultSsChunkSource$Factory(DataSource$Factory dataSource$Factory) {
        this.dataSourceFactory = dataSource$Factory;
    }

    public SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int n10, ExoTrackSelection exoTrackSelection, TransferListener object) {
        DataSource$Factory dataSource$Factory = this.dataSourceFactory;
        DataSource dataSource = dataSource$Factory.createDataSource();
        if (object != null) {
            dataSource.addTransferListener((TransferListener)object);
        }
        object = new DefaultSsChunkSource(loaderErrorThrower, ssManifest, n10, exoTrackSelection, dataSource);
        return object;
    }
}

