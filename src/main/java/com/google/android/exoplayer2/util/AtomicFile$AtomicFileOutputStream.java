/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class AtomicFile$AtomicFileOutputStream
extends OutputStream {
    private boolean closed = false;
    private final FileOutputStream fileOutputStream;

    public AtomicFile$AtomicFileOutputStream(File file) {
        FileOutputStream fileOutputStream;
        this.fileOutputStream = fileOutputStream = new FileOutputStream(file);
    }

    public void close() {
        boolean bl2 = this.closed;
        if (bl2) {
            return;
        }
        this.closed = bl2 = true;
        this.flush();
        Object object = this.fileOutputStream;
        object = ((FileOutputStream)object).getFD();
        try {
            ((FileDescriptor)object).sync();
        }
        catch (IOException iOException) {
            String string2 = "AtomicFile";
            String string3 = "Failed to sync file descriptor:";
            Log.w(string2, string3, iOException);
        }
        this.fileOutputStream.close();
    }

    public void flush() {
        this.fileOutputStream.flush();
    }

    public void write(int n10) {
        this.fileOutputStream.write(n10);
    }

    public void write(byte[] byArray) {
        this.fileOutputStream.write(byArray);
    }

    public void write(byte[] byArray, int n10, int n11) {
        this.fileOutputStream.write(byArray, n10, n11);
    }
}

