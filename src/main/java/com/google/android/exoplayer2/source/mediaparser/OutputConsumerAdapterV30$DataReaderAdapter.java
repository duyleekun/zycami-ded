/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaParser$InputReader
 */
package com.google.android.exoplayer2.source.mediaparser;

import android.media.MediaParser;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30$1;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;

public final class OutputConsumerAdapterV30$DataReaderAdapter
implements DataReader {
    public MediaParser.InputReader input;

    private OutputConsumerAdapterV30$DataReaderAdapter() {
    }

    public /* synthetic */ OutputConsumerAdapterV30$DataReaderAdapter(OutputConsumerAdapterV30$1 outputConsumerAdapterV30$1) {
        this();
    }

    public int read(byte[] byArray, int n10, int n11) {
        return ((MediaParser.InputReader)Util.castNonNull(this.input)).read(byArray, n10, n11);
    }
}

