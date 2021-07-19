/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfa;
import java.util.NoSuchElementException;

public final class zzeo
extends zzfa {
    private boolean zzni;
    private final /* synthetic */ Object zznj;

    public zzeo(Object object) {
        this.zznj = object;
    }

    public final boolean hasNext() {
        boolean bl2 = this.zzni;
        return !bl2;
    }

    public final Object next() {
        boolean bl2 = this.zzni;
        if (!bl2) {
            this.zzni = true;
            return this.zznj;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

