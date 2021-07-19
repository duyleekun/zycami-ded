/*
 * Decompiled with CFR 0.151.
 */
package retrofit2;

import f.b2.c;
import f.o0;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

public final class KotlinExtensions$d
implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ Exception b;

    public KotlinExtensions$d(c c10, Exception exception) {
        this.a = c10;
        this.b = exception;
    }

    public final void run() {
        c c10 = IntrinsicsKt__IntrinsicsJvmKt.d(this.a);
        Object object = this.b;
        object = Result.constructor-impl(o0.a((Throwable)object));
        c10.resumeWith(object);
    }
}

