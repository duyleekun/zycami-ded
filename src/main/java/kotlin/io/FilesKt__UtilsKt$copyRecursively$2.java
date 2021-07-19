/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

import f.h2.s.p;
import f.h2.t.f0;
import java.io.File;
import java.io.IOException;
import kotlin.io.OnErrorAction;
import kotlin.io.TerminateException;
import kotlin.jvm.internal.Lambda;

public final class FilesKt__UtilsKt$copyRecursively$2
extends Lambda
implements p {
    public final /* synthetic */ p $onError;

    public FilesKt__UtilsKt$copyRecursively$2(p p10) {
        this.$onError = p10;
        super(2);
    }

    public final void invoke(File file, IOException object) {
        f0.p(file, "f");
        f0.p(object, "e");
        object = (OnErrorAction)((Object)this.$onError.invoke(file, object));
        OnErrorAction onErrorAction = OnErrorAction.TERMINATE;
        if (object != onErrorAction) {
            return;
        }
        object = new TerminateException(file);
        throw object;
    }
}

