/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.util;

import com.google.firebase.perf.util.StorageUnit;

public final class StorageUnit$2
extends StorageUnit {
    public StorageUnit$2(long l10) {
    }

    public long convert(long l10, StorageUnit storageUnit) {
        return storageUnit.toGigabytes(l10);
    }
}

