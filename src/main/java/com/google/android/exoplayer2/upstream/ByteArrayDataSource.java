/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ByteArrayDataSource
extends BaseDataSource {
    private int bytesRemaining;
    private final byte[] data;
    private boolean opened;
    private int readPosition;
    private Uri uri;

    public ByteArrayDataSource(byte[] byArray) {
        boolean bl2 = false;
        super(false);
        Assertions.checkNotNull(byArray);
        int n10 = byArray.length;
        if (n10 > 0) {
            bl2 = true;
        }
        Assertions.checkArgument(bl2);
        this.data = byArray;
    }

    public void close() {
        boolean bl2 = this.opened;
        if (bl2) {
            bl2 = false;
            this.opened = false;
            this.transferEnded();
        }
        this.uri = null;
    }

    public Uri getUri() {
        return this.uri;
    }

    public long open(DataSpec object) {
        int n10;
        int n11;
        Object object2;
        this.uri = object2 = ((DataSpec)object).uri;
        this.transferInitializing((DataSpec)object);
        long l10 = ((DataSpec)object).position;
        this.readPosition = n11 = (int)l10;
        long l11 = ((DataSpec)object).length;
        long l12 = -1;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 == false) {
            byte[] byArray = this.data;
            int n12 = byArray.length;
            l11 = (long)n12 - l10;
        }
        this.bytesRemaining = n10 = (int)l11;
        if (n10 > 0 && (n11 += n10) <= (n10 = ((Uri)(object2 = (Object)this.data)).length)) {
            this.opened = true;
            this.transferStarted((DataSpec)object);
            return this.bytesRemaining;
        }
        int n13 = this.readPosition;
        long l14 = ((DataSpec)object).length;
        int n14 = this.data.length;
        StringBuilder stringBuilder = new StringBuilder(77);
        stringBuilder.append("Unsatisfiable range: [");
        stringBuilder.append(n13);
        stringBuilder.append(", ");
        stringBuilder.append(l14);
        stringBuilder.append("], length: ");
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        object2 = new IOException((String)object);
        throw object2;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        if (n11 == 0) {
            return 0;
        }
        int n13 = this.bytesRemaining;
        if (n13 == 0) {
            return -1;
        }
        n11 = Math.min(n11, n13);
        byte[] byArray2 = this.data;
        int n14 = this.readPosition;
        System.arraycopy(byArray2, n14, byArray, n10, n11);
        this.readPosition = n12 = this.readPosition + n11;
        this.bytesRemaining = n12 = this.bytesRemaining - n11;
        this.bytesTransferred(n11);
        return n11;
    }
}

