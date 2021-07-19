/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface zabs {
    public ConnectionResult blockingConnect();

    public ConnectionResult blockingConnect(long var1, TimeUnit var3);

    public void connect();

    public void disconnect();

    public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

    public BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl var1);

    public BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl var1);

    public ConnectionResult getConnectionResult(Api var1);

    public boolean isConnected();

    public boolean isConnecting();

    public boolean maybeSignIn(SignInConnectionListener var1);

    public void maybeSignOut();

    public void zaw();
}

