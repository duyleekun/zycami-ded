/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.PrimitiveSink;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource$AsCharSource;
import com.google.common.io.ByteSource$ByteArrayByteSource;
import com.google.common.io.ByteSource$ConcatenatedByteSource;
import com.google.common.io.ByteSource$EmptyByteSource;
import com.google.common.io.ByteSource$SlicedByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

public abstract class ByteSource {
    public static ByteSource concat(Iterable iterable) {
        ByteSource$ConcatenatedByteSource byteSource$ConcatenatedByteSource = new ByteSource$ConcatenatedByteSource(iterable);
        return byteSource$ConcatenatedByteSource;
    }

    public static ByteSource concat(Iterator iterator2) {
        return ByteSource.concat(ImmutableList.copyOf(iterator2));
    }

    public static ByteSource concat(ByteSource ... byteSourceArray) {
        return ByteSource.concat(ImmutableList.copyOf(byteSourceArray));
    }

    private long countBySkipping(InputStream inputStream) {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14 = l13 = 0L;
        while ((l12 = (l11 = (l10 = ByteStreams.skipUpTo(inputStream, Integer.MAX_VALUE)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            l14 += l10;
        }
        return l14;
    }

    public static ByteSource empty() {
        return ByteSource$EmptyByteSource.INSTANCE;
    }

    public static ByteSource wrap(byte[] byArray) {
        ByteSource$ByteArrayByteSource byteSource$ByteArrayByteSource = new ByteSource$ByteArrayByteSource(byArray);
        return byteSource$ByteArrayByteSource;
    }

    public CharSource asCharSource(Charset charset) {
        ByteSource$AsCharSource byteSource$AsCharSource = new ByteSource$AsCharSource(this, charset);
        return byteSource$AsCharSource;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean contentEquals(ByteSource object) {
        Preconditions.checkNotNull(object);
        byte[] byArray = ByteStreams.createBuffer();
        byte[] byArray2 = ByteStreams.createBuffer();
        Closer closer = Closer.create();
        try {
            block5: {
                int n10;
                int n11;
                Closeable closeable = this.openStream();
                closeable = closer.register(closeable);
                object = ((ByteSource)object).openStream();
                object = closer.register((Closeable)object);
                object = (InputStream)object;
                do {
                    n11 = byArray.length;
                    n10 = 0;
                    n11 = ByteStreams.read(closeable, byArray, 0, n11);
                    int n12 = byArray2.length;
                    if (n11 != (n12 = ByteStreams.read((InputStream)object, byArray2, 0, n12)) || (n12 = (int)(Arrays.equals(byArray, byArray2) ? 1 : 0)) == 0) break block5;
                } while (n11 == (n10 = byArray.length));
                closer.close();
                return true;
            }
            closer.close();
            return false;
        }
        catch (Throwable throwable) {
            try {
                RuntimeException runtimeException = closer.rethrow(throwable);
                throw runtimeException;
            }
            catch (Throwable throwable2) {
                closer.close();
                throw throwable2;
            }
        }
    }

    public long copyTo(ByteSink object) {
        InputStream inputStream;
        Preconditions.checkNotNull(object);
        Closer closer = Closer.create();
        try {
            inputStream = this.openStream();
        }
        catch (Throwable throwable) {
            RuntimeException runtimeException;
            try {
                runtimeException = closer.rethrow(throwable);
            }
            catch (Throwable throwable2) {
                closer.close();
                throw throwable2;
            }
            throw runtimeException;
        }
        Closeable closeable = closer.register(inputStream);
        InputStream inputStream2 = (InputStream)closeable;
        object = ((ByteSink)object).openStream();
        object = closer.register((Closeable)object);
        object = (OutputStream)object;
        long l10 = ByteStreams.copy(inputStream2, (OutputStream)object);
        closer.close();
        return l10;
    }

    public long copyTo(OutputStream outputStream) {
        InputStream inputStream;
        Preconditions.checkNotNull(outputStream);
        Closer closer = Closer.create();
        try {
            inputStream = this.openStream();
        }
        catch (Throwable throwable) {
            RuntimeException runtimeException;
            try {
                runtimeException = closer.rethrow(throwable);
            }
            catch (Throwable throwable2) {
                closer.close();
                throw throwable2;
            }
            throw runtimeException;
        }
        Closeable closeable = closer.register(inputStream);
        InputStream inputStream2 = (InputStream)closeable;
        long l10 = ByteStreams.copy(inputStream2, outputStream);
        closer.close();
        return l10;
    }

    public HashCode hash(HashFunction object) {
        object = object.newHasher();
        OutputStream outputStream = Funnels.asOutputStream((PrimitiveSink)object);
        this.copyTo(outputStream);
        return object.hash();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isEmpty() {
        Object object = this.sizeIfKnown();
        int n10 = ((Optional)object).isPresent();
        boolean bl2 = true;
        if (n10 != 0) {
            long l10;
            long l11 = (Long)(object = (Long)((Optional)object).get());
            long l12 = l11 - (l10 = 0L);
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != false) return false;
            return bl2;
        }
        object = Closer.create();
        try {
            Closeable closeable = this.openStream();
            closeable = ((Closer)object).register(closeable);
            n10 = ((InputStream)closeable).read();
            int n11 = -1;
            if (n10 != n11) {
                bl2 = false;
            }
            ((Closer)object).close();
            return bl2;
        }
        catch (Throwable throwable) {
            try {
                RuntimeException runtimeException = ((Closer)object).rethrow(throwable);
                throw runtimeException;
            }
            catch (Throwable throwable2) {
                ((Closer)object).close();
                throw throwable2;
            }
        }
    }

    public InputStream openBufferedStream() {
        InputStream inputStream = this.openStream();
        boolean bl2 = inputStream instanceof BufferedInputStream;
        if (bl2) {
            inputStream = (BufferedInputStream)inputStream;
        } else {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            inputStream = bufferedInputStream;
        }
        return inputStream;
    }

    public abstract InputStream openStream();

    public Object read(ByteProcessor object) {
        InputStream inputStream;
        Preconditions.checkNotNull(object);
        Closer closer = Closer.create();
        try {
            inputStream = this.openStream();
        }
        catch (Throwable throwable) {
            RuntimeException runtimeException;
            try {
                runtimeException = closer.rethrow(throwable);
            }
            catch (Throwable throwable2) {
                closer.close();
                throw throwable2;
            }
            throw runtimeException;
        }
        Closeable closeable = closer.register(inputStream);
        InputStream inputStream2 = (InputStream)closeable;
        object = ByteStreams.readBytes(inputStream2, (ByteProcessor)object);
        closer.close();
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public byte[] read() {
        Closer closer = Closer.create();
        try {
            Object object = this.openStream();
            object = closer.register((Closeable)object);
            Object object2 = this.sizeIfKnown();
            boolean bl2 = ((Optional)object2).isPresent();
            if (bl2) {
                object2 = ((Optional)object2).get();
                object2 = (Long)object2;
                long l10 = (Long)object2;
                object = ByteStreams.toByteArray((InputStream)object, l10);
            } else {
                object = ByteStreams.toByteArray((InputStream)object);
            }
            closer.close();
            return object;
        }
        catch (Throwable throwable) {
            try {
                RuntimeException runtimeException = closer.rethrow(throwable);
                throw runtimeException;
            }
            catch (Throwable throwable2) {
                closer.close();
                throw throwable2;
            }
        }
    }

    public long size() {
        Object object = this.sizeIfKnown();
        boolean bl2 = ((Optional)object).isPresent();
        if (bl2) {
            return (Long)((Optional)object).get();
        }
        object = Closer.create();
        try {
            InputStream inputStream = this.openStream();
            Closeable closeable = ((Closer)object).register(inputStream);
            InputStream inputStream2 = (InputStream)closeable;
            long l10 = this.countBySkipping(inputStream2);
            return l10;
        }
        catch (IOException iOException) {
            InputStream inputStream;
            ((Closer)object).close();
            object = Closer.create();
            try {
                inputStream = this.openStream();
            }
            catch (Throwable throwable) {
                RuntimeException runtimeException = ((Closer)object).rethrow(throwable);
                throw runtimeException;
            }
            Closeable closeable = ((Closer)object).register(inputStream);
            InputStream inputStream3 = (InputStream)closeable;
            long l11 = ByteStreams.exhaust(inputStream3);
            return l11;
        }
        finally {
            ((Closer)object).close();
        }
    }

    public Optional sizeIfKnown() {
        return Optional.absent();
    }

    public ByteSource slice(long l10, long l11) {
        ByteSource$SlicedByteSource byteSource$SlicedByteSource = new ByteSource$SlicedByteSource(this, l10, l11);
        return byteSource$SlicedByteSource;
    }
}

