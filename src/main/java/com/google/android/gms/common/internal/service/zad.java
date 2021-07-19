/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.service.zac;
import com.google.android.gms.common.internal.service.zae;

public final class zad
implements zac {
    public final PendingResult zaa(GoogleApiClient googleApiClient) {
        zae zae2 = new zae(this, googleApiClient);
        return googleApiClient.execute(zae2);
    }
}

