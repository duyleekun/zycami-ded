/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class DeferrableSurfaces$1
implements FutureCallback {
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$completer;
    public final /* synthetic */ boolean val$removeNullSurfaces;
    public final /* synthetic */ ScheduledFuture val$scheduledFuture;

    public DeferrableSurfaces$1(boolean bl2, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ScheduledFuture scheduledFuture) {
        this.val$removeNullSurfaces = bl2;
        this.val$completer = callbackToFutureAdapter$Completer;
        this.val$scheduledFuture = scheduledFuture;
    }

    public void onFailure(Throwable object) {
        object = this.val$completer;
        List list = Collections.unmodifiableList(Collections.emptyList());
        ((CallbackToFutureAdapter$Completer)object).set(list);
        this.val$scheduledFuture.cancel(true);
    }

    public void onSuccess(List collection) {
        ArrayList arrayList = new ArrayList(collection);
        boolean bl2 = this.val$removeNullSurfaces;
        if (bl2) {
            bl2 = false;
            collection = Collections.singleton(null);
            arrayList.removeAll(collection);
        }
        this.val$completer.set(arrayList);
        this.val$scheduledFuture.cancel(true);
    }
}

