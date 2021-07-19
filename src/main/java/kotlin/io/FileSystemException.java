/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

import f.e2.e;
import f.h2.t.f0;
import f.h2.t.u;
import java.io.File;
import java.io.IOException;

public class FileSystemException
extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    public FileSystemException(File file, File file2, String string2) {
        f0.p(file, "file");
        String string3 = e.a(file, file2, string2);
        super(string3);
        this.file = file;
        this.other = file2;
        this.reason = string2;
    }

    public /* synthetic */ FileSystemException(File file, File file2, String string2, int n10, u u10) {
        int n11 = n10 & 2;
        if (n11 != 0) {
            file2 = null;
        }
        if ((n10 &= 4) != 0) {
            string2 = null;
        }
        this(file, file2, string2);
    }

    public final File getFile() {
        return this.file;
    }

    public final File getOther() {
        return this.other;
    }

    public final String getReason() {
        return this.reason;
    }
}

