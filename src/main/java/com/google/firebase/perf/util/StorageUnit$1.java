/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.util;

import com.google.firebase.perf.util.StorageUnit;

public final class StorageUnit$1
extends StorageUnit {
    public StorageUnit$1(long l10) {
    }

    public long convert(long l10, StorageUnit storageUnit) {
        return storageUnit.toTerabytes(l10);
    }
}

