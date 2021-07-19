/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.disposables;

import i.g.e;
import io.reactivex.disposables.ReferenceDisposable;

public final class SubscriptionDisposable
extends ReferenceDisposable {
    private static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(e e10) {
        super(e10);
    }

    public void onDisposed(e e10) {
        e10.cancel();
    }
}

