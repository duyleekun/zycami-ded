/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.util.Collections;
import java.util.Map;

public interface DataSource
extends DataReader {
    public void addTransferListener(TransferListener var1);

    public void close();

    default public Map getResponseHeaders() {
        return Collections.emptyMap();
    }

    public Uri getUri();

    public long open(DataSpec var1);
}

