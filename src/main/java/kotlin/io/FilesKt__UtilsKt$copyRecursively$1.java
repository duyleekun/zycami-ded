/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

import f.h2.s.p;
import f.h2.t.f0;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Lambda;

public final class FilesKt__UtilsKt$copyRecursively$1
extends Lambda
implements p {
    public static final FilesKt__UtilsKt$copyRecursively$1 INSTANCE;

    static {
        FilesKt__UtilsKt$copyRecursively$1 filesKt__UtilsKt$copyRecursively$1;
        INSTANCE = filesKt__UtilsKt$copyRecursively$1 = new FilesKt__UtilsKt$copyRecursively$1();
    }

    public FilesKt__UtilsKt$copyRecursively$1() {
        super(2);
    }

    public final Void invoke(File file, IOException iOException) {
        f0.p(file, "<anonymous parameter 0>");
        f0.p(iOException, "exception");
        throw iOException;
    }
}

