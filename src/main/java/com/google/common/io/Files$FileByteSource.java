/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closer;
import com.google.common.io.Files$1;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.channels.FileChannel;

public final class Files$FileByteSource
extends ByteSource {
    private final File file;

    private Files$FileByteSource(File file) {
        this.file = file = (File)Preconditions.checkNotNull(file);
    }

    public /* synthetic */ Files$FileByteSource(File file, Files$1 files$1) {
        this(file);
    }

    public FileInputStream openStream() {
        File file = this.file;
        FileInputStream fileInputStream = new FileInputStream(file);
        return fileInputStream;
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
            FileChannel fileChannel = ((FileInputStream)object).getChannel();
            long l10 = fileChannel.size();
            object = ByteStreams.toByteArray((InputStream)object, l10);
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
        Serializable serializable = this.file;
        boolean bl2 = serializable.isFile();
        if (bl2) {
            return this.file.length();
        }
        String string2 = this.file.toString();
        serializable = new FileNotFoundException(string2);
        throw serializable;
    }

    public Optional sizeIfKnown() {
        File file = this.file;
        boolean bl2 = file.isFile();
        if (bl2) {
            return Optional.of(this.file.length());
        }
        return Optional.absent();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Files.asByteSource(");
        File file = this.file;
        stringBuilder.append(file);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

