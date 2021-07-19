/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.ByteSource;
import com.google.common.io.FileBackedOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class FileBackedOutputStream$1
extends ByteSource {
    public final /* synthetic */ FileBackedOutputStream this$0;

    public FileBackedOutputStream$1(FileBackedOutputStream fileBackedOutputStream) {
        this.this$0 = fileBackedOutputStream;
    }

    public void finalize() {
        FileBackedOutputStream fileBackedOutputStream = this.this$0;
        try {
            fileBackedOutputStream.reset();
        }
        catch (Throwable throwable) {
            PrintStream printStream = System.err;
            throwable.printStackTrace(printStream);
        }
    }

    public InputStream openStream() {
        return FileBackedOutputStream.access$100(this.this$0);
    }
}

