/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.FileBackedOutputStream$1;
import java.io.ByteArrayOutputStream;

public class FileBackedOutputStream$MemoryOutput
extends ByteArrayOutputStream {
    private FileBackedOutputStream$MemoryOutput() {
    }

    public /* synthetic */ FileBackedOutputStream$MemoryOutput(FileBackedOutputStream.1 var1_1) {
        this();
    }

    public byte[] getBuffer() {
        return this.buf;
    }

    public int getCount() {
        return this.count;
    }
}

