/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.cct;

import android.content.Context;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.time.Clock;

public class CctBackendFactory
implements BackendFactory {
    public TransportBackend create(CreationContext object) {
        Context context = ((CreationContext)object).getApplicationContext();
        Clock clock = ((CreationContext)object).getWallClock();
        object = ((CreationContext)object).getMonotonicClock();
        CctTransportBackend cctTransportBackend = new CctTransportBackend(context, clock, (Clock)object);
        return cctTransportBackend;
    }
}

