/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closer;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;

public final class ByteSource$SlicedByteSource
extends ByteSource {
    public final long length;
    public final long offset;
    public final /* synthetic */ ByteSource this$0;

    public ByteSource$SlicedByteSource(ByteSource byteSource, long l10, long l11) {
        this.this$0 = byteSource;
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        boolean bl2 = true;
        if (l13 >= 0) {
            l13 = (long)bl2;
        } else {
            l13 = 0;
            byteSource = null;
        }
        String string2 = "offset (%s) may not be negative";
        Preconditions.checkArgument((boolean)l13, string2, l10);
        l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 < 0) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "length (%s) may not be negative", l11);
        this.offset = l10;
        this.length = l11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private InputStream sliceStream(InputStream object) {
        long l10;
        block5: {
            l10 = this.offset;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                try {
                    l10 = ByteStreams.skipUpTo((InputStream)object, l10);
                    l11 = this.offset;
                    long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (l13 >= 0) break block5;
                }
                catch (Throwable throwable) {
                    Closer closer = Closer.create();
                    closer.register((Closeable)object);
                    try {
                        object = closer.rethrow(throwable);
                        throw object;
                    }
                    catch (Throwable throwable2) {
                        closer.close();
                        throw throwable2;
                    }
                }
                ((InputStream)object).close();
                byte[] byArray = new byte[]{};
                return new ByteArrayInputStream(byArray);
            }
        }
        l10 = this.length;
        return ByteStreams.limit((InputStream)object, l10);
    }

    public boolean isEmpty() {
        long l10 = this.length;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false && (object = (Object)super.isEmpty()) == false ? (Object)0 : (Object)1;
        return (boolean)object;
    }

    public InputStream openBufferedStream() {
        InputStream inputStream = this.this$0.openBufferedStream();
        return this.sliceStream(inputStream);
    }

    public InputStream openStream() {
        InputStream inputStream = this.this$0.openStream();
        return this.sliceStream(inputStream);
    }

    public Optional sizeIfKnown() {
        Optional optional = this.this$0.sizeIfKnown();
        boolean bl2 = optional.isPresent();
        if (bl2) {
            long l10 = (Long)optional.get();
            long l11 = Math.min(this.offset, l10);
            long l12 = this.length;
            return Optional.of(Math.min(l12, l10 -= l11));
        }
        return Optional.absent();
    }

    public ByteSource slice(long l10, long l11) {
        ByteSource byteSource;
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        boolean bl2 = true;
        if (l13 >= 0) {
            l13 = (long)bl2;
        } else {
            l13 = 0;
            byteSource = null;
        }
        String string2 = "offset (%s) may not be negative";
        Preconditions.checkArgument((boolean)l13, string2, l10);
        long l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l14 < 0) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "length (%s) may not be negative", l11);
        l12 = this.length - l10;
        byteSource = this.this$0;
        long l15 = this.offset + l10;
        l10 = Math.min(l11, l12);
        return byteSource.slice(l15, l10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.this$0.toString();
        stringBuilder.append(string2);
        stringBuilder.append(".slice(");
        long l10 = this.offset;
        stringBuilder.append(l10);
        stringBuilder.append(", ");
        l10 = this.length;
        stringBuilder.append(l10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

