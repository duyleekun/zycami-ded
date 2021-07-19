/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.Files$FilePredicate;
import java.io.File;

public final class Files$FilePredicate$1
extends Files$FilePredicate {
    public boolean apply(File file) {
        return file.isDirectory();
    }

    public String toString() {
        return "Files.isDirectory()";
    }
}

