/*
 * Decompiled with CFR 0.151.
 */
package androidx.versionedparcelable;

import androidx.versionedparcelable.VersionedParcelStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class VersionedParcelStream$1
extends FilterInputStream {
    public final /* synthetic */ VersionedParcelStream this$0;

    public VersionedParcelStream$1(VersionedParcelStream versionedParcelStream, InputStream inputStream) {
        this.this$0 = versionedParcelStream;
        super(inputStream);
    }

    public int read() {
        int n10;
        Object object = this.this$0;
        int n11 = ((VersionedParcelStream)object).mFieldSize;
        int n12 = -1;
        if (n11 != n12 && (n10 = ((VersionedParcelStream)object).mCount) >= n11) {
            object = new IOException();
            throw object;
        }
        n10 = super.read();
        VersionedParcelStream versionedParcelStream = this.this$0;
        versionedParcelStream.mCount = n12 = versionedParcelStream.mCount + 1;
        return n10;
    }

    public int read(byte[] object, int n10, int n11) {
        int n12;
        VersionedParcelStream versionedParcelStream = this.this$0;
        int n13 = versionedParcelStream.mFieldSize;
        int n14 = -1;
        if (n13 != n14 && (n12 = versionedParcelStream.mCount) >= n13) {
            object = new IOException;
            object();
            throw object;
        }
        int n15 = super.read((byte[])object, n10, n11);
        if (n15 > 0) {
            VersionedParcelStream versionedParcelStream2 = this.this$0;
            versionedParcelStream2.mCount = n11 = versionedParcelStream2.mCount + n15;
        }
        return n15;
    }

    public long skip(long l10) {
        long l11;
        int n10;
        VersionedParcelStream versionedParcelStream = this.this$0;
        int n11 = versionedParcelStream.mFieldSize;
        int n12 = -1;
        if (n11 != n12 && (n10 = versionedParcelStream.mCount) >= n11) {
            IOException iOException = new IOException();
            throw iOException;
        }
        long l12 = (l10 = super.skip(l10)) - (l11 = 0L);
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n10 > 0) {
            versionedParcelStream = this.this$0;
            n11 = versionedParcelStream.mCount;
            n12 = (int)l10;
            versionedParcelStream.mCount = n11 += n12;
        }
        return l10;
    }
}

