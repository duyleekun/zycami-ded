/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzff;
import com.google.android.gms.internal.vision.zzfg;
import java.io.PrintStream;
import java.util.Objects;

public final class zzfh
extends zzfg {
    private final zzff zzob;

    public zzfh() {
        zzff zzff2;
        this.zzob = zzff2 = new zzff();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(Throwable object) {
        ((Throwable)object).printStackTrace();
        Object object2 = this.zzob;
        boolean bl2 = false;
        Throwable throwable = null;
        object = ((zzff)object2).zza((Throwable)object, false);
        if (object == null) {
            return;
        }
        synchronized (object) {
            object2 = object.iterator();
            while (bl2 = object2.hasNext()) {
                throwable = (Throwable)object2.next();
                throwable = throwable;
                PrintStream printStream = System.err;
                String string2 = "Suppressed: ";
                printStream.print(string2);
                throwable.printStackTrace();
            }
            return;
        }
    }

    public final void zza(Throwable throwable, Throwable throwable2) {
        if (throwable2 != throwable) {
            Objects.requireNonNull(throwable2, "The suppressed exception cannot be null.");
            this.zzob.zza(throwable, true).add(throwable2);
            return;
        }
        throwable = new IllegalArgumentException("Self suppression is not allowed.", throwable2);
        throw throwable;
    }
}

