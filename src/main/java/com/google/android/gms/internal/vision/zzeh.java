/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzdn;
import com.google.android.gms.internal.vision.zzef;
import java.io.Serializable;
import java.util.Map;

public class zzeh
extends zzdn
implements Serializable {
    private final transient int size;
    private final transient zzef zznc;

    public zzeh(zzef zzef2, int n10) {
        this.zznc = zzef2;
        this.size = n10;
    }

    public final boolean containsValue(Object object) {
        boolean bl2;
        return object != null && (bl2 = super.containsValue(object));
    }

    public final /* synthetic */ Map zzcc() {
        return this.zznc;
    }

    public final Map zzcd() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }
}

