/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import com.uber.autodispose.AutoDisposableHelper;
import d.q.a.r;
import e.a.y0.b;
import java.util.concurrent.atomic.AtomicReference;

public class r$a
extends b {
    public final /* synthetic */ r b;

    public r$a(r r10) {
        this.b = r10;
    }

    public void onComplete() {
        AtomicReference atomicReference = this.b.b;
        AutoDisposableHelper autoDisposableHelper = AutoDisposableHelper.DISPOSED;
        atomicReference.lazySet(autoDisposableHelper);
        AutoDisposableHelper.dispose(this.b.a);
    }

    public void onError(Throwable throwable) {
        AtomicReference atomicReference = this.b.b;
        AutoDisposableHelper autoDisposableHelper = AutoDisposableHelper.DISPOSED;
        atomicReference.lazySet(autoDisposableHelper);
        this.b.onError(throwable);
    }
}

