/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.internal.GmsClientEventManager$GmsClientEventState;

public final class zaax
implements GmsClientEventManager$GmsClientEventState {
    private final /* synthetic */ zaaw zahh;

    public zaax(zaaw zaaw2) {
        this.zahh = zaaw2;
    }

    public final Bundle getConnectionHint() {
        return null;
    }

    public final boolean isConnected() {
        return ((GoogleApiClient)this.zahh).isConnected();
    }
}

