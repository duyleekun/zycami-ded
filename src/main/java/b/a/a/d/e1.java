/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final class e1
implements AsyncFunction {
    public final /* synthetic */ SynchronizedCaptureSessionImpl a;
    public final /* synthetic */ List b;
    public final /* synthetic */ long c;

    public /* synthetic */ e1(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, List list, long l10) {
        this.a = synchronizedCaptureSessionImpl;
        this.b = list;
        this.c = l10;
    }

    public final ListenableFuture apply(Object object) {
        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.a;
        List list = this.b;
        long l10 = this.c;
        object = (List)object;
        return synchronizedCaptureSessionImpl.p(list, l10, (List)object);
    }
}

