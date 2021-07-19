/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

import f.h2.s.l;
import f.h2.t.f0;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;

public final class FilesKt__FileReadWriteKt$readLines$1
extends Lambda
implements l {
    public final /* synthetic */ ArrayList $result;

    public FilesKt__FileReadWriteKt$readLines$1(ArrayList arrayList) {
        this.$result = arrayList;
        super(1);
    }

    public final void invoke(String string2) {
        f0.p(string2, "it");
        this.$result.add(string2);
    }
}

