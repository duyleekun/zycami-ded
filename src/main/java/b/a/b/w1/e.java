/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable$Observer;

public final class e
implements Runnable {
    public final /* synthetic */ ConstantObservable a;
    public final /* synthetic */ Observable$Observer b;

    public /* synthetic */ e(ConstantObservable constantObservable, Observable$Observer observable$Observer) {
        this.a = constantObservable;
        this.b = observable$Observer;
    }

    public final void run() {
        ConstantObservable constantObservable = this.a;
        Observable$Observer observable$Observer = this.b;
        constantObservable.b(observable$Observer);
    }
}

