/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;

public interface ResolvingDataSource$Resolver {
    public DataSpec resolveDataSpec(DataSpec var1);

    default public Uri resolveReportedUri(Uri uri) {
        return uri;
    }
}

