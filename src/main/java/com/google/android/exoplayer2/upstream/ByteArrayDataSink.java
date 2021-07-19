/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.ByteArrayOutputStream;

public final class ByteArrayDataSink
implements DataSink {
    private ByteArrayOutputStream stream;

    public void close() {
        ((ByteArrayOutputStream)Util.castNonNull(this.stream)).close();
    }

    public byte[] getData() {
        Object object = this.stream;
        object = object == null ? null : (Object)((ByteArrayOutputStream)object).toByteArray();
        return object;
    }

    public void open(DataSpec object) {
        long l10 = ((DataSpec)object).length;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.stream = object = new ByteArrayOutputStream();
        } else {
            ByteArrayOutputStream byteArrayOutputStream;
            l11 = Integer.MAX_VALUE;
            long l13 = l10 - l11;
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 <= 0) {
                object3 = 1;
            } else {
                object3 = 0;
                byteArrayOutputStream = null;
            }
            Assertions.checkArgument((boolean)object3);
            long l14 = ((DataSpec)object).length;
            int n10 = (int)l14;
            this.stream = byteArrayOutputStream = new ByteArrayOutputStream(n10);
        }
    }

    public void write(byte[] byArray, int n10, int n11) {
        ((ByteArrayOutputStream)Util.castNonNull(this.stream)).write(byArray, n10, n11);
    }
}

