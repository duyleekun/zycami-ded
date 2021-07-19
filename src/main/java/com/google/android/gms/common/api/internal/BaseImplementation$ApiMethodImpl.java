/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 *  android.os.RemoteException
 */
package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.Api$AnyClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

public abstract class BaseImplementation$ApiMethodImpl
extends BasePendingResult
implements BaseImplementation$ResultHolder {
    private final Api mApi;
    private final Api$AnyClientKey mClientKey;

    public BaseImplementation$ApiMethodImpl(Api$AnyClientKey api$AnyClientKey, GoogleApiClient googleApiClient) {
        googleApiClient = (GoogleApiClient)Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null");
        super(googleApiClient);
        this.mClientKey = api$AnyClientKey = (Api$AnyClientKey)Preconditions.checkNotNull(api$AnyClientKey);
        this.mApi = null;
    }

    public BaseImplementation$ApiMethodImpl(Api api, GoogleApiClient object) {
        object = (GoogleApiClient)Preconditions.checkNotNull(object, "GoogleApiClient must not be null");
        super((GoogleApiClient)object);
        Preconditions.checkNotNull(api, "Api must not be null");
        this.mClientKey = object = api.getClientKey();
        this.mApi = api;
    }

    public BaseImplementation$ApiMethodImpl(BasePendingResult$CallbackHandler basePendingResult$CallbackHandler) {
        super(basePendingResult$CallbackHandler);
        this.mClientKey = null;
        this.mApi = null;
    }

    private void setFailedResult(RemoteException object) {
        object = object.getLocalizedMessage();
        Status status = new Status(8, (String)object, null);
        this.setFailedResult(status);
    }

    public abstract void doExecute(Api$AnyClient var1);

    public final Api getApi() {
        return this.mApi;
    }

    public final Api$AnyClientKey getClientKey() {
        return this.mClientKey;
    }

    public void onSetFailedResult(Result result2) {
    }

    public final void run(Api$AnyClient api$AnyClient) {
        boolean bl2 = api$AnyClient instanceof SimpleClientAdapter;
        if (bl2) {
            api$AnyClient = ((SimpleClientAdapter)api$AnyClient).getClient();
        }
        try {
            this.doExecute(api$AnyClient);
            return;
        }
        catch (RemoteException remoteException) {
            this.setFailedResult(remoteException);
            return;
        }
        catch (DeadObjectException deadObjectException) {
            this.setFailedResult((RemoteException)((Object)deadObjectException));
            throw deadObjectException;
        }
    }

    public final void setFailedResult(Status result2) {
        Preconditions.checkArgument(result2.isSuccess() ^ true, "Failed result must not be success");
        result2 = this.createFailedResult((Status)result2);
        this.setResult(result2);
        this.onSetFailedResult(result2);
    }
}

