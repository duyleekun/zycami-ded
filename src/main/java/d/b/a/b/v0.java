/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.google.android.gms.internal.play_billing.zzb;
import d.b.a.b.e;
import java.util.concurrent.Future;

public final class v0
implements Runnable {
    private final /* synthetic */ Future a;
    private final /* synthetic */ Runnable b;

    public v0(e e10, Future future, Runnable runnable) {
        this.a = future;
        this.b = runnable;
    }

    public final void run() {
        Object object = this.a;
        boolean bl2 = object.isDone();
        if (!bl2 && !(bl2 = (object = this.a).isCancelled())) {
            object = this.a;
            boolean bl3 = true;
            object.cancel(bl3);
            String string2 = "Async task is taking too long, cancel it!";
            zzb.zzb("BillingClient", string2);
            object = this.b;
            if (object != null) {
                object.run();
            }
        }
    }
}

