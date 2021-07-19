/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.graph.SuccessorsFunction;
import com.google.common.io.Files;
import java.io.File;

public final class Files$3
implements SuccessorsFunction {
    public Iterable successors(File file) {
        return Files.access$200(file);
    }
}

