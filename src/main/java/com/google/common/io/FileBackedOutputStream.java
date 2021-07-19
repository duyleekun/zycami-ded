/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.ByteSource;
import com.google.common.io.FileBackedOutputStream$1;
import com.google.common.io.FileBackedOutputStream$2;
import com.google.common.io.FileBackedOutputStream$MemoryOutput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class FileBackedOutputStream
extends OutputStream {
    private File file;
    private final int fileThreshold;
    private FileBackedOutputStream$MemoryOutput memory;
    private OutputStream out;
    private final File parentDirectory;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    public FileBackedOutputStream(int n10) {
        this(n10, false);
    }

    public FileBackedOutputStream(int n10, boolean bl2) {
        this(n10, bl2, null);
    }

    private FileBackedOutputStream(int n10, boolean bl2, File file) {
        this.fileThreshold = n10;
        this.resetOnFinalize = bl2;
        this.parentDirectory = file;
        file = null;
        Object object = new FileBackedOutputStream$MemoryOutput(null);
        this.memory = object;
        this.out = object;
        this.source = bl2 ? (object = new FileBackedOutputStream$1(this)) : (object = new FileBackedOutputStream$2(this));
    }

    public static /* synthetic */ InputStream access$100(FileBackedOutputStream fileBackedOutputStream) {
        return fileBackedOutputStream.openInputStream();
    }

    private InputStream openInputStream() {
        synchronized (this) {
            Object object;
            block12: {
                object = this.file;
                if (object == null) break block12;
                File file = this.file;
                object = new FileInputStream(file);
                return object;
            }
            Object object2 = this.memory;
            object2 = ((FileBackedOutputStream$MemoryOutput)object2).getBuffer();
            FileBackedOutputStream$MemoryOutput fileBackedOutputStream$MemoryOutput = this.memory;
            int n10 = fileBackedOutputStream$MemoryOutput.getCount();
            object = new ByteArrayInputStream((byte[])object2, 0, n10);
            return object;
        }
    }

    private void update(int n10) {
        int n11;
        Object object = this.file;
        if (object == null && (n11 = ((FileBackedOutputStream$MemoryOutput)(object = this.memory)).getCount() + n10) > (n10 = this.fileThreshold)) {
            File file = this.parentDirectory;
            object = "FileBackedOutputStream";
            file = File.createTempFile((String)object, null, file);
            n11 = (int)(this.resetOnFinalize ? 1 : 0);
            if (n11 != 0) {
                file.deleteOnExit();
            }
            object = new FileOutputStream(file);
            byte[] byArray = this.memory.getBuffer();
            FileBackedOutputStream$MemoryOutput fileBackedOutputStream$MemoryOutput = this.memory;
            int n12 = fileBackedOutputStream$MemoryOutput.getCount();
            ((FileOutputStream)object).write(byArray, 0, n12);
            ((OutputStream)object).flush();
            this.out = object;
            this.file = file;
            this.memory = null;
        }
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    public void close() {
        synchronized (this) {
            OutputStream outputStream = this.out;
            outputStream.close();
            return;
        }
    }

    public void flush() {
        synchronized (this) {
            OutputStream outputStream = this.out;
            outputStream.flush();
            return;
        }
    }

    public File getFile() {
        synchronized (this) {
            File file = this.file;
            return file;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void reset() {
        synchronized (this) {
            boolean bl2 = false;
            IOException iOException = null;
            try {
                this.close();
            }
            catch (Throwable throwable) {
                Object object = this.memory;
                if (object == null) {
                    object = new FileBackedOutputStream$MemoryOutput(null);
                    this.memory = object;
                } else {
                    object = this.memory;
                    ((ByteArrayOutputStream)object).reset();
                }
                object = this.memory;
                this.out = object;
                object = this.file;
                if (object != null) {
                    this.file = null;
                    bl2 = ((File)object).delete();
                    if (!bl2) {
                        CharSequence charSequence = new StringBuilder();
                        String string2 = "Could not delete: ";
                        charSequence.append(string2);
                        charSequence.append(object);
                        charSequence = charSequence.toString();
                        iOException = new IOException((String)charSequence);
                        throw iOException;
                    }
                }
                throw throwable;
            }
            try {
                Object object = this.memory;
                if (object == null) {
                    object = new FileBackedOutputStream$MemoryOutput(null);
                    this.memory = object;
                } else {
                    ((ByteArrayOutputStream)object).reset();
                }
                object = this.memory;
                this.out = object;
                object = this.file;
                if (object != null) {
                    this.file = null;
                    bl2 = ((File)object).delete();
                    if (!bl2) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String string3 = "Could not delete: ";
                        stringBuilder.append(string3);
                        stringBuilder.append(object);
                        object = stringBuilder.toString();
                        iOException = new IOException((String)object);
                        throw iOException;
                    }
                }
                return;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public void write(int n10) {
        synchronized (this) {
            int n11 = 1;
            this.update(n11);
            OutputStream outputStream = this.out;
            outputStream.write(n10);
            return;
        }
    }

    public void write(byte[] byArray) {
        synchronized (this) {
            int n10 = byArray.length;
            this.write(byArray, 0, n10);
            return;
        }
    }

    public void write(byte[] byArray, int n10, int n11) {
        synchronized (this) {
            this.update(n11);
            OutputStream outputStream = this.out;
            outputStream.write(byArray, n10, n11);
            return;
        }
    }
}

