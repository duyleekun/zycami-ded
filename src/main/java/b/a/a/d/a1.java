/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final class a1
implements AsyncFunction {
    public final /* synthetic */ SynchronizedCaptureSessionBaseImpl a;
    public final /* synthetic */ List b;

    public /* synthetic */ a1(SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl, List list) {
        this.a = synchronizedCaptureSessionBaseImpl;
        this.b = list;
    }

    public final ListenableFuture apply(Object object) {
        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = this.a;
        List list = this.b;
        object = (List)object;
        return synchronizedCaptureSessionBaseImpl.f(list, (List)object);
    }
}

