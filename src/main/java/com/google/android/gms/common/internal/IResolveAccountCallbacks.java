/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 */
package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.common.internal.ResolveAccountResponse;

public interface IResolveAccountCallbacks
extends IInterface {
    public void onAccountResolutionComplete(ResolveAccountResponse var1);
}

