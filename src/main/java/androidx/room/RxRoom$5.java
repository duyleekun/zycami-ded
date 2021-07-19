/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.EmptyResultSetException;
import e.a.k0;
import e.a.m0;
import java.util.concurrent.Callable;

public class RxRoom$5
implements m0 {
    public final /* synthetic */ Callable val$callable;

    public RxRoom$5(Callable callable) {
        this.val$callable = callable;
    }

    public void subscribe(k0 k02) {
        Callable callable = this.val$callable;
        callable = callable.call();
        try {
            k02.onSuccess(callable);
        }
        catch (EmptyResultSetException emptyResultSetException) {
            k02.tryOnError(emptyResultSetException);
        }
    }
}

