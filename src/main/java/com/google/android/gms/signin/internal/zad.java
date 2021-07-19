/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 */
package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zaj;

public interface zad
extends IInterface {
    public void zaa(ConnectionResult var1, zaa var2);

    public void zaa(Status var1, GoogleSignInAccount var2);

    public void zab(zaj var1);

    public void zag(Status var1);

    public void zah(Status var1);
}

