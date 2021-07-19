/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zziy;
import java.util.ListIterator;

public final class zzix
implements ListIterator {
    private ListIterator zza;
    private final /* synthetic */ int zzb;
    private final /* synthetic */ zziy zzc;

    public zzix(zziy object, int n10) {
        this.zzc = object;
        this.zzb = n10;
        this.zza = object = zziy.zza((zziy)object).listIterator(n10);
    }

    public final /* synthetic */ void add(Object object) {
        object = (String)object;
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return (String)this.zza.next();
    }

    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return (String)this.zza.previous();
    }

    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final /* synthetic */ void set(Object object) {
        object = (String)object;
        object = new UnsupportedOperationException();
        throw object;
    }
}

