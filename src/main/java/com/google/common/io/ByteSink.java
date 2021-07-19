/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSink$AsCharSink;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSink;
import com.google.common.io.Closer;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public abstract class ByteSink {
    public CharSink asCharSink(Charset charset) {
        ByteSink$AsCharSink byteSink$AsCharSink = new ByteSink$AsCharSink(this, charset, null);
        return byteSink$AsCharSink;
    }

    public OutputStream openBufferedStream() {
        OutputStream outputStream = this.openStream();
        boolean bl2 = outputStream instanceof BufferedOutputStream;
        if (bl2) {
            outputStream = (BufferedOutputStream)outputStream;
        } else {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            outputStream = bufferedOutputStream;
        }
        return outputStream;
    }

    public abstract OutputStream openStream();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(byte[] byArray) {
        Preconditions.checkNotNull(byArray);
        Closer closer = Closer.create();
        try {
            Closeable closeable = this.openStream();
            closeable = closer.register(closeable);
            ((OutputStream)closeable).write(byArray);
            ((OutputStream)closeable).flush();
            closer.close();
            return;
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long writeFrom(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        Closer closer = Closer.create();
        try {
            Closeable closeable = this.openStream();
            closeable = closer.register(closeable);
            long l10 = ByteStreams.copy(inputStream, (OutputStream)closeable);
            ((OutputStream)closeable).flush();
            closer.close();
            return l10;
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
}

