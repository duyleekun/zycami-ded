/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DashChunkSource$Factory;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerTrackEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.util.List;

public final class DefaultDashChunkSource$Factory
implements DashChunkSource$Factory {
    private final DataSource$Factory dataSourceFactory;
    private final int maxSegmentsPerLoad;

    public DefaultDashChunkSource$Factory(DataSource$Factory dataSource$Factory) {
        this(dataSource$Factory, 1);
    }

    public DefaultDashChunkSource$Factory(DataSource$Factory dataSource$Factory, int n10) {
        this.dataSourceFactory = dataSource$Factory;
        this.maxSegmentsPerLoad = n10;
    }

    public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int n10, int[] nArray, ExoTrackSelection exoTrackSelection, int n11, long l10, boolean bl2, List list, PlayerEmsgHandler$PlayerTrackEmsgHandler playerEmsgHandler$PlayerTrackEmsgHandler, TransferListener transferListener) {
        DefaultDashChunkSource$Factory defaultDashChunkSource$Factory = this;
        Object object = transferListener;
        DataSource$Factory dataSource$Factory = this.dataSourceFactory;
        DataSource dataSource = dataSource$Factory.createDataSource();
        if (transferListener != null) {
            dataSource.addTransferListener(transferListener);
        }
        int n12 = defaultDashChunkSource$Factory.maxSegmentsPerLoad;
        object = new DefaultDashChunkSource(loaderErrorThrower, dashManifest, n10, nArray, exoTrackSelection, n11, dataSource, l10, n12, bl2, list, playerEmsgHandler$PlayerTrackEmsgHandler);
        return object;
    }
}

