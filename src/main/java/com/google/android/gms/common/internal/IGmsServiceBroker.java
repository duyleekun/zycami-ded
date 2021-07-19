/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 */
package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.IGmsCallbacks;

public interface IGmsServiceBroker
extends IInterface {
    public void getService(IGmsCallbacks var1, GetServiceRequest var2);
}

