/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.Files$FilePredicate;
import java.io.File;

public final class Files$FilePredicate$2
extends Files$FilePredicate {
    public boolean apply(File file) {
        return file.isFile();
    }

    public String toString() {
        return "Files.isFile()";
    }
}

