/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

public final class z
implements FileFilter {
    public boolean accept(File file) {
        return file.isDirectory();
    }
}

