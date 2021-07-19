/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 */
package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.Api$AnyClient;

public interface Api$SimpleClient
extends Api$AnyClient {
    public IInterface createServiceInterface(IBinder var1);

    public Context getContext();

    public String getServiceDescriptor();

    public String getStartServiceAction();

    public void setState(int var1, IInterface var2);
}

