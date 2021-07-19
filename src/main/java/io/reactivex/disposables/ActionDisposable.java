/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.disposables;

import e.a.v0.a;
import io.reactivex.disposables.ReferenceDisposable;
import io.reactivex.internal.util.ExceptionHelper;

public final class ActionDisposable
extends ReferenceDisposable {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(a a10) {
        super(a10);
    }

    public void onDisposed(a a10) {
        try {
            a10.run();
            return;
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.f(throwable);
        }
    }
}

