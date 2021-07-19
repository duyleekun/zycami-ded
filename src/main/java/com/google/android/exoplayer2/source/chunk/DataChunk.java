/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public abstract class DataChunk
extends Chunk {
    private static final int READ_GRANULARITY = 16384;
    private byte[] data;
    private volatile boolean loadCanceled;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int n10, Format format, int n11, Object object, byte[] byArray) {
        long l10 = -9223372036854775807L;
        long l11 = -9223372036854775807L;
        Object object2 = this;
        Object object3 = dataSource;
        super(dataSource, dataSpec, n10, format, n11, object, l10, l11);
        if (byArray == null) {
            object2 = Util.EMPTY_BYTE_ARRAY;
            object3 = this;
        } else {
            object3 = this;
            object2 = byArray;
        }
        ((DataChunk)object3).data = (byte[])object2;
    }

    private void maybeExpandData(int n10) {
        byte[] byArray = this.data;
        int n11 = byArray.length;
        if (n11 < (n10 += 16384)) {
            n10 = byArray.length + 16384;
            byte[] byArray2 = Arrays.copyOf(byArray, n10);
            this.data = byArray2;
        }
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public abstract void consume(byte[] var1, int var2);

    public byte[] getDataHolder() {
        return this.data;
    }

    public final void load() {
        block13: {
            int n10;
            Object object = this.dataSource;
            DataSpec dataSpec = this.dataSpec;
            ((StatsDataSource)object).open(dataSpec);
            int n11 = 0;
            object = null;
            int n12 = 0;
            dataSpec = null;
            while (n11 != (n10 = -1)) {
                n11 = (int)(this.loadCanceled ? 1 : 0);
                if (n11 != 0) break;
                this.maybeExpandData(n12);
                object = this.dataSource;
                byte[] byArray = this.data;
                int n13 = 16384;
                n11 = ((StatsDataSource)object).read(byArray, n12, n13);
                if (n11 == n10) continue;
                n12 += n11;
            }
            n11 = (int)(this.loadCanceled ? 1 : 0);
            if (n11 != 0) break block13;
            object = this.data;
            this.consume((byte[])object, n12);
        }
        return;
        finally {
            Util.closeQuietly(this.dataSource);
        }
    }
}

