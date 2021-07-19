/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

import f.h2.t.f0;
import java.io.File;
import kotlin.io.FileSystemException;

public final class TerminateException
extends FileSystemException {
    public TerminateException(File file) {
        f0.p(file, "file");
        super(file, null, null, 6, null);
    }
}

