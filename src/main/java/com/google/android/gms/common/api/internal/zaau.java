/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaak;
import com.google.android.gms.common.api.internal.zaal;
import com.google.android.gms.common.api.internal.zabe;
import java.util.concurrent.locks.Lock;

public abstract class zaau
implements Runnable {
    private final /* synthetic */ zaak zagj;

    private zaau(zaak zaak2) {
        this.zagj = zaak2;
    }

    public /* synthetic */ zaau(zaak zaak2, zaal zaal2) {
        this(zaak2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Throwable throwable222222;
        block6: {
            block5: {
                Lock lock = zaak.zac(this.zagj);
                lock.lock();
                boolean bl2 = Thread.interrupted();
                if (!bl2) break block5;
                zaak.zac(this.zagj).unlock();
                return;
            }
            this.zaan();
            zaak.zac(this.zagj).unlock();
            return;
            {
                catch (Throwable throwable222222) {
                    break block6;
                }
                catch (RuntimeException runtimeException) {}
                {
                    Object object = this.zagj;
                    object = zaak.zad((zaak)object);
                    ((zabe)object).zab(runtimeException);
                    zaak.zac(this.zagj).unlock();
                    return;
                }
            }
        }
        zaak.zac(this.zagj).unlock();
        throw throwable222222;
    }

    public abstract void zaan();
}

