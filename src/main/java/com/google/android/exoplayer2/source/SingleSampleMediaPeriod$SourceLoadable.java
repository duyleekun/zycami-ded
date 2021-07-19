/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class SingleSampleMediaPeriod$SourceLoadable
implements Loader$Loadable {
    private final StatsDataSource dataSource;
    public final DataSpec dataSpec;
    public final long loadTaskId;
    private byte[] sampleData;

    public SingleSampleMediaPeriod$SourceLoadable(DataSpec object, DataSource dataSource) {
        long l10;
        this.loadTaskId = l10 = LoadEventInfo.getNewId();
        this.dataSpec = object;
        this.dataSource = object = new StatsDataSource(dataSource);
    }

    public static /* synthetic */ StatsDataSource access$100(SingleSampleMediaPeriod$SourceLoadable singleSampleMediaPeriod$SourceLoadable) {
        return singleSampleMediaPeriod$SourceLoadable.dataSource;
    }

    public static /* synthetic */ byte[] access$200(SingleSampleMediaPeriod$SourceLoadable singleSampleMediaPeriod$SourceLoadable) {
        return singleSampleMediaPeriod$SourceLoadable.sampleData;
    }

    public void cancelLoad() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void load() {
        StatsDataSource statsDataSource = this.dataSource;
        statsDataSource.resetBytesRead();
        try {
            int n10;
            statsDataSource = this.dataSource;
            Object object = this.dataSpec;
            statsDataSource.open((DataSpec)object);
            int n11 = 0;
            statsDataSource = null;
            while (n11 != (n10 = -1)) {
                statsDataSource = this.dataSource;
                long l10 = statsDataSource.getBytesRead();
                n11 = (int)l10;
                object = this.sampleData;
                if (object == null) {
                    n10 = 1024;
                    object = new byte[n10];
                    this.sampleData = (byte[])object;
                } else {
                    int n12 = ((Object)object).length;
                    if (n11 == n12) {
                        n12 = ((Object)object).length * 2;
                        object = Arrays.copyOf((byte[])object, n12);
                        this.sampleData = (byte[])object;
                    }
                }
                object = this.dataSource;
                byte[] byArray = this.sampleData;
                int n13 = byArray.length - n11;
                n11 = ((StatsDataSource)object).read(byArray, n11, n13);
            }
            return;
        }
        finally {
            Util.closeQuietly(this.dataSource);
        }
    }
}

