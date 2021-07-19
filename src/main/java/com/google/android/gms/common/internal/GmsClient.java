/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager$GmsClientEventState;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zaf;
import com.google.android.gms.common.internal.zag;
import java.util.Iterator;
import java.util.Set;

public abstract class GmsClient
extends BaseGmsClient
implements Api$Client,
GmsClientEventManager$GmsClientEventState {
    private final Set mScopes;
    private final ClientSettings zaet;
    private final Account zax;

    public GmsClient(Context context, Handler handler, int n10, ClientSettings clientSettings) {
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        this(context, handler, gmsClientSupervisor, googleApiAvailability, n10, clientSettings, null, null);
    }

    public GmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int n10, ClientSettings clientSettings, GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        BaseGmsClient$BaseConnectionCallbacks baseGmsClient$BaseConnectionCallbacks = GmsClient.zaa(googleApiClient$ConnectionCallbacks);
        BaseGmsClient$BaseOnConnectionFailedListener baseGmsClient$BaseOnConnectionFailedListener = GmsClient.zaa(googleApiClient$OnConnectionFailedListener);
        Object object = this;
        super(context, handler, gmsClientSupervisor, googleApiAvailability, n10, baseGmsClient$BaseConnectionCallbacks, baseGmsClient$BaseOnConnectionFailedListener);
        this.zaet = object = (ClientSettings)Preconditions.checkNotNull(clientSettings);
        object = clientSettings.getAccount();
        this.zax = object;
        object = clientSettings.getAllRequestedScopes();
        this.mScopes = object = this.zaa((Set)object);
    }

    public GmsClient(Context context, Looper looper, int n10, ClientSettings clientSettings) {
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        this(context, looper, gmsClientSupervisor, googleApiAvailability, n10, clientSettings, null, null);
    }

    public GmsClient(Context context, Looper looper, int n10, ClientSettings clientSettings, GoogleApiClient$ConnectionCallbacks object, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Object object2 = object = Preconditions.checkNotNull(object);
        object2 = (GoogleApiClient$ConnectionCallbacks)object;
        Object object3 = object = Preconditions.checkNotNull(googleApiClient$OnConnectionFailedListener);
        object3 = (GoogleApiClient$OnConnectionFailedListener)object;
        this(context, looper, gmsClientSupervisor, googleApiAvailability, n10, clientSettings, (GoogleApiClient$ConnectionCallbacks)object2, (GoogleApiClient$OnConnectionFailedListener)object3);
    }

    public GmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int n10, ClientSettings clientSettings, GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        BaseGmsClient$BaseConnectionCallbacks baseGmsClient$BaseConnectionCallbacks = GmsClient.zaa(googleApiClient$ConnectionCallbacks);
        BaseGmsClient$BaseOnConnectionFailedListener baseGmsClient$BaseOnConnectionFailedListener = GmsClient.zaa(googleApiClient$OnConnectionFailedListener);
        String string2 = clientSettings.getRealClientClassName();
        Object object = this;
        Context context2 = context;
        super(context, looper, gmsClientSupervisor, googleApiAvailability, n10, baseGmsClient$BaseConnectionCallbacks, baseGmsClient$BaseOnConnectionFailedListener, string2);
        object = clientSettings;
        this.zaet = clientSettings;
        context2 = clientSettings.getAccount();
        this.zax = context2;
        object = clientSettings.getAllRequestedScopes();
        this.mScopes = object = this.zaa((Set)object);
    }

    private static BaseGmsClient$BaseConnectionCallbacks zaa(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        if (googleApiClient$ConnectionCallbacks == null) {
            return null;
        }
        zaf zaf2 = new zaf(googleApiClient$ConnectionCallbacks);
        return zaf2;
    }

    private static BaseGmsClient$BaseOnConnectionFailedListener zaa(GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        if (googleApiClient$OnConnectionFailedListener == null) {
            return null;
        }
        zag zag2 = new zag(googleApiClient$OnConnectionFailedListener);
        return zag2;
    }

    private final Set zaa(Set object) {
        boolean bl2;
        Set set = this.validateScopes((Set)object);
        Iterator iterator2 = set.iterator();
        while (bl2 = iterator2.hasNext()) {
            Scope scope = (Scope)iterator2.next();
            bl2 = object.contains(scope);
            if (bl2) continue;
            object = new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            throw object;
        }
        return set;
    }

    public final Account getAccount() {
        return this.zax;
    }

    public final ClientSettings getClientSettings() {
        return this.zaet;
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    public final Set getScopes() {
        return this.mScopes;
    }

    public Set validateScopes(Set set) {
        return set;
    }
}

