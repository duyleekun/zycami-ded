/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.e2.h;
import f.h2.t.f0;
import java.io.File;
import kotlin.io.FileWalkDirection;
import kotlin.io.FilesKt__FileReadWriteKt;

public class l
extends FilesKt__FileReadWriteKt {
    public static final h J(File file, FileWalkDirection fileWalkDirection) {
        f0.p(file, "$this$walk");
        f0.p((Object)fileWalkDirection, "direction");
        h h10 = new h(file, fileWalkDirection);
        return h10;
    }

    public static /* synthetic */ h K(File file, FileWalkDirection fileWalkDirection, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return l.J(file, fileWalkDirection);
    }

    public static final h L(File file) {
        f0.p(file, "$this$walkBottomUp");
        FileWalkDirection fileWalkDirection = FileWalkDirection.BOTTOM_UP;
        return l.J(file, fileWalkDirection);
    }

    public static final h M(File file) {
        f0.p(file, "$this$walkTopDown");
        FileWalkDirection fileWalkDirection = FileWalkDirection.TOP_DOWN;
        return l.J(file, fileWalkDirection);
    }
}

