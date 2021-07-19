/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

public class HttpDataSource$HttpDataSourceException
extends IOException {
    public static final int TYPE_CLOSE = 3;
    public static final int TYPE_OPEN = 1;
    public static final int TYPE_READ = 2;
    public final DataSpec dataSpec;
    public final int type;

    public HttpDataSource$HttpDataSourceException(DataSpec dataSpec, int n10) {
        this.dataSpec = dataSpec;
        this.type = n10;
    }

    public HttpDataSource$HttpDataSourceException(IOException iOException, DataSpec dataSpec, int n10) {
        super(iOException);
        this.dataSpec = dataSpec;
        this.type = n10;
    }

    public HttpDataSource$HttpDataSourceException(String string2, DataSpec dataSpec, int n10) {
        super(string2);
        this.dataSpec = dataSpec;
        this.type = n10;
    }

    public HttpDataSource$HttpDataSourceException(String string2, IOException iOException, DataSpec dataSpec, int n10) {
        super(string2, iOException);
        this.dataSpec = dataSpec;
        this.type = n10;
    }
}

