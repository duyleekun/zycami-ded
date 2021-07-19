/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient$LegacyClientCallbackAdapter;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zaf;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zah;
import com.google.android.gms.signin.internal.zaj;

public class SignInClientImpl
extends GmsClient
implements com.google.android.gms.signin.zad {
    private final ClientSettings zaet;
    private Integer zaoe;
    private final boolean zasb;
    private final Bundle zasc;

    private SignInClientImpl(Context object, Looper looper, boolean bl2, ClientSettings clientSettings, Bundle bundle, GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        super((Context)object, looper, 44, clientSettings, googleApiClient$ConnectionCallbacks, googleApiClient$OnConnectionFailedListener);
        this.zasb = true;
        this.zaet = clientSettings;
        this.zasc = bundle;
        object = clientSettings.getClientSessionId();
        this.zaoe = object;
    }

    public SignInClientImpl(Context context, Looper looper, boolean bl2, ClientSettings clientSettings, SignInOptions signInOptions, GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        Bundle bundle = SignInClientImpl.createBundleFromClientSettings(clientSettings);
        this(context, looper, true, clientSettings, bundle, googleApiClient$ConnectionCallbacks, googleApiClient$OnConnectionFailedListener);
    }

    public static Bundle createBundleFromClientSettings(ClientSettings object) {
        SignInOptions signInOptions = ((ClientSettings)object).getSignInOptions();
        Object object2 = ((ClientSettings)object).getClientSessionId();
        Bundle bundle = new Bundle();
        object = ((ClientSettings)object).getAccount();
        String string2 = "com.google.android.gms.signin.internal.clientRequestedAccount";
        bundle.putParcelable(string2, (Parcelable)object);
        if (object2 != null) {
            int bl2 = (Integer)object2;
            object2 = "com.google.android.gms.common.internal.ClientSettings.sessionId";
            bundle.putInt((String)object2, bl2);
        }
        if (signInOptions != null) {
            boolean bl2 = signInOptions.isOfflineAccessRequested();
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", bl2);
            boolean bl3 = signInOptions.isIdTokenRequested();
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", bl3);
            object = signInOptions.getServerClientId();
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String)object);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            boolean bl4 = signInOptions.isForceCodeForRefreshToken();
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", bl4);
            object = signInOptions.getHostedDomain();
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String)object);
            boolean bl5 = signInOptions.waitForAccessTokenRefresh();
            object2 = "com.google.android.gms.signin.internal.waitForAccessTokenRefresh";
            bundle.putBoolean((String)object2, bl5);
            object = signInOptions.getAuthApiSignInModuleVersion();
            if (object != null) {
                long l10 = signInOptions.getAuthApiSignInModuleVersion();
                object = "com.google.android.gms.signin.internal.authApiSignInModuleVersion";
                bundle.putLong((String)object, l10);
            }
            if ((object = signInOptions.getRealClientLibraryVersion()) != null) {
                long l11 = signInOptions.getRealClientLibraryVersion();
                object = "com.google.android.gms.signin.internal.realClientLibraryVersion";
                bundle.putLong((String)object, l11);
            }
        }
        return bundle;
    }

    public final void connect() {
        BaseGmsClient$LegacyClientCallbackAdapter baseGmsClient$LegacyClientCallbackAdapter = new BaseGmsClient$LegacyClientCallbackAdapter(this);
        this.connect(baseGmsClient$LegacyClientCallbackAdapter);
    }

    public /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        boolean bl2 = iInterface instanceof zaf;
        if (bl2) {
            return (zaf)iInterface;
        }
        iInterface = new zag(iBinder);
        return iInterface;
    }

    public Bundle getGetServiceRequestExtraArgs() {
        String string2 = this.zaet.getRealClientPackageName();
        String string3 = this.getContext().getPackageName();
        boolean bl2 = string3.equals(string2);
        if (!bl2) {
            string2 = this.zasc;
            string3 = this.zaet.getRealClientPackageName();
            String string4 = "com.google.android.gms.signin.internal.realClientPackageName";
            string2.putString(string4, string3);
        }
        return this.zasc;
    }

    public int getMinApkVersion() {
        return 12451000;
    }

    public String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    public boolean requiresSignIn() {
        return this.zasb;
    }

    public final void zaa(IAccountAccessor iAccountAccessor, boolean bl2) {
        IInterface iInterface;
        try {
            iInterface = this.getService();
        }
        catch (RemoteException remoteException) {
            Log.w((String)"SignInClientImpl", (String)"Remote service probably died when saveDefaultAccount is called");
            return;
        }
        iInterface = (zaf)iInterface;
        Integer n10 = this.zaoe;
        int n11 = n10;
        iInterface.zaa(iAccountAccessor, n11, bl2);
    }

    public final void zaa(zad zad2) {
        Object object;
        int n10;
        Object object2;
        Object object3;
        Object object4;
        block20: {
            object4 = "Expecting a valid ISignInCallbacks";
            Preconditions.checkNotNull(zad2, object4);
            try {
                object4 = this.zaet;
            }
            catch (RemoteException remoteException) {
                object3 = "SignInClientImpl";
                object2 = "Remote service probably died when signIn is called";
                Log.w((String)object3, (String)object2);
                n10 = 8;
                try {
                    object2 = new zaj(n10);
                }
                catch (RemoteException remoteException2) {
                    Log.wtf((String)object3, (String)"ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", (Throwable)remoteException);
                    return;
                }
                zad2.zab((zaj)object2);
                return;
            }
            object4 = ((ClientSettings)object4).getAccountOrDefault();
            object3 = null;
            object2 = "<<default account>>";
            object = ((Account)object4).name;
            boolean bl2 = ((String)object2).equals(object);
            if (!bl2) break block20;
            object3 = this.getContext();
            object3 = Storage.getInstance((Context)object3);
            object3 = ((Storage)object3).getSavedDefaultGoogleSignInAccount();
        }
        object = this.zaoe;
        n10 = (Integer)object;
        object2 = new ResolveAccountRequest((Account)object4, n10, (GoogleSignInAccount)object3);
        object4 = this.getService();
        object4 = (zaf)object4;
        object3 = new zah((ResolveAccountRequest)object2);
        object4.zaa((zah)object3, zad2);
    }

    public final void zacw() {
        IInterface iInterface;
        try {
            iInterface = this.getService();
        }
        catch (RemoteException remoteException) {
            Log.w((String)"SignInClientImpl", (String)"Remote service probably died when clearAccountFromSessionStore is called");
            return;
        }
        iInterface = (zaf)iInterface;
        Integer n10 = this.zaoe;
        int n11 = n10;
        iInterface.zam(n11);
    }
}

