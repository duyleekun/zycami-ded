/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.util;

import com.google.firebase.perf.util.StorageUnit;

public final class StorageUnit$5
extends StorageUnit {
    public StorageUnit$5(long l10) {
    }

    public long convert(long l10, StorageUnit storageUnit) {
        return storageUnit.toBytes(l10);
    }
}

