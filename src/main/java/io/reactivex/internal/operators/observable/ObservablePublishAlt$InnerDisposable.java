/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishAlt$InnerDisposable
extends AtomicReference
implements b {
    private static final long serialVersionUID = 7463222674719692880L;
    public final g0 downstream;

    public ObservablePublishAlt$InnerDisposable(g0 g02, ObservablePublishAlt$PublishConnection observablePublishAlt$PublishConnection) {
        this.downstream = g02;
        this.lazySet(observablePublishAlt$PublishConnection);
    }

    public void dispose() {
        ObservablePublishAlt$PublishConnection observablePublishAlt$PublishConnection = this.getAndSet(null);
        if (observablePublishAlt$PublishConnection != null) {
            observablePublishAlt$PublishConnection.remove(this);
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        Object v10 = this.get();
        if (v10 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }
}

