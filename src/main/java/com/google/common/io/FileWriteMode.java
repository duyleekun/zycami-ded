/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

public final class FileWriteMode
extends Enum {
    private static final /* synthetic */ FileWriteMode[] $VALUES;
    public static final /* enum */ FileWriteMode APPEND;

    static {
        FileWriteMode fileWriteMode;
        APPEND = fileWriteMode = new FileWriteMode("APPEND", 0);
        FileWriteMode[] fileWriteModeArray = new FileWriteMode[]{fileWriteMode};
        $VALUES = fileWriteModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FileWriteMode() {
        void var2_-1;
        void var1_-1;
    }

    public static FileWriteMode valueOf(String string2) {
        return Enum.valueOf(FileWriteMode.class, string2);
    }

    public static FileWriteMode[] values() {
        return (FileWriteMode[])$VALUES.clone();
    }
}

