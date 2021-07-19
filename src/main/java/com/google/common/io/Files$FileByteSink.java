/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files$1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;

public final class Files$FileByteSink
extends ByteSink {
    private final File file;
    private final ImmutableSet modes;

    private Files$FileByteSink(File serializable, FileWriteMode ... fileWriteModeArray) {
        this.file = serializable = (File)Preconditions.checkNotNull(serializable);
        serializable = ImmutableSet.copyOf((Object[])fileWriteModeArray);
        this.modes = serializable;
    }

    public /* synthetic */ Files$FileByteSink(File file, FileWriteMode[] fileWriteModeArray, Files$1 files$1) {
        this(file, fileWriteModeArray);
    }

    public FileOutputStream openStream() {
        File file = this.file;
        ImmutableSet immutableSet = this.modes;
        FileWriteMode fileWriteMode = FileWriteMode.APPEND;
        boolean bl2 = immutableSet.contains((Object)fileWriteMode);
        FileOutputStream fileOutputStream = new FileOutputStream(file, bl2);
        return fileOutputStream;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Files.asByteSink(");
        Serializable serializable = this.file;
        stringBuilder.append(serializable);
        stringBuilder.append(", ");
        serializable = this.modes;
        stringBuilder.append(serializable);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

