/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.collect.TreeTraverser;
import com.google.common.io.Files;
import java.io.File;

public final class Files$2
extends TreeTraverser {
    public Iterable children(File file) {
        return Files.access$200(file);
    }

    public String toString() {
        return "Files.fileTreeTraverser()";
    }
}

