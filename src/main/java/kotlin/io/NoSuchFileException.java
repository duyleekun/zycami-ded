/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

import f.h2.t.f0;
import f.h2.t.u;
import java.io.File;
import kotlin.io.FileSystemException;

public final class NoSuchFileException
extends FileSystemException {
    public NoSuchFileException(File file, File file2, String string2) {
        f0.p(file, "file");
        super(file, file2, string2);
    }

    public /* synthetic */ NoSuchFileException(File file, File file2, String string2, int n10, u u10) {
        int n11 = n10 & 2;
        if (n11 != 0) {
            file2 = null;
        }
        if ((n10 &= 4) != 0) {
            string2 = null;
        }
        this(file, file2, string2);
    }
}

