/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.api.Api$ApiOptions$HasAccountOptions;
import com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApi$Settings;
import com.google.android.gms.common.api.GoogleApi$Settings$Builder;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings$Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collection;
import java.util.Collections;

public class GoogleApi {
    private final Api mApi;
    private final Context mContext;
    private final int mId;
    private final Api$ApiOptions zabh;
    private final zai zabi;
    private final Looper zabj;
    private final GoogleApiClient zabk;
    private final StatusExceptionMapper zabl;
    public final GoogleApiManager zabm;

    public GoogleApi(Activity activity, Api object, Api$ApiOptions object2, GoogleApi$Settings object3) {
        int n10;
        Looper looper;
        Context context;
        Preconditions.checkNotNull(activity, "Null activity is not permitted.");
        Preconditions.checkNotNull(object, "Api must not be null.");
        Preconditions.checkNotNull(object3, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context = activity.getApplicationContext();
        this.mApi = object;
        this.zabh = object2;
        this.zabj = looper = ((GoogleApi$Settings)object3).zabo;
        this.zabi = object = zai.zaa((Api)object, (Api$ApiOptions)object2);
        this.zabk = object2 = new zabp(this);
        this.zabm = object2 = GoogleApiManager.zab(context);
        this.mId = n10 = ((GoogleApiManager)object2).zabd();
        this.zabl = object3 = ((GoogleApi$Settings)object3).zabn;
        boolean bl2 = activity instanceof GoogleApiActivity;
        if (!bl2) {
            zaae.zaa(activity, (GoogleApiManager)object2, (zai)object);
        }
        ((GoogleApiManager)object2).zaa(this);
    }

    public GoogleApi(Activity activity, Api api, Api$ApiOptions api$ApiOptions, StatusExceptionMapper object) {
        GoogleApi$Settings$Builder googleApi$Settings$Builder = new GoogleApi$Settings$Builder();
        object = googleApi$Settings$Builder.setMapper((StatusExceptionMapper)object);
        googleApi$Settings$Builder = activity.getMainLooper();
        object = ((GoogleApi$Settings$Builder)object).setLooper((Looper)googleApi$Settings$Builder).build();
        this(activity, api, api$ApiOptions, (GoogleApi$Settings)object);
    }

    public GoogleApi(Context object, Api object2, Looper looper) {
        int n10;
        Preconditions.checkNotNull(object, "Null context is not permitted.");
        Preconditions.checkNotNull(object2, "Api must not be null.");
        Preconditions.checkNotNull(looper, "Looper must not be null.");
        object = object.getApplicationContext();
        this.mContext = object;
        this.mApi = object2;
        this.zabh = null;
        this.zabj = looper;
        this.zabi = object2 = zai.zaa((Api)object2);
        this.zabk = object2 = new zabp(this);
        object = GoogleApiManager.zab((Context)object);
        this.zabm = object;
        this.mId = n10 = ((GoogleApiManager)object).zabd();
        this.zabl = object = new ApiExceptionMapper();
    }

    public GoogleApi(Context context, Api api, Api$ApiOptions api$ApiOptions, Looper object, StatusExceptionMapper statusExceptionMapper) {
        GoogleApi$Settings$Builder googleApi$Settings$Builder = new GoogleApi$Settings$Builder();
        object = googleApi$Settings$Builder.setLooper((Looper)object).setMapper(statusExceptionMapper).build();
        this(context, api, api$ApiOptions, (GoogleApi$Settings)object);
    }

    public GoogleApi(Context object, Api object2, Api$ApiOptions api$ApiOptions, GoogleApi$Settings googleApi$Settings) {
        int n10;
        Looper looper;
        Preconditions.checkNotNull(object, "Null context is not permitted.");
        Preconditions.checkNotNull(object2, "Api must not be null.");
        Preconditions.checkNotNull(googleApi$Settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        object = object.getApplicationContext();
        this.mContext = object;
        this.mApi = object2;
        this.zabh = api$ApiOptions;
        this.zabj = looper = googleApi$Settings.zabo;
        this.zabi = object2 = zai.zaa((Api)object2, api$ApiOptions);
        this.zabk = object2 = new zabp(this);
        object = GoogleApiManager.zab((Context)object);
        this.zabm = object;
        this.mId = n10 = ((GoogleApiManager)object).zabd();
        this.zabl = object2 = googleApi$Settings.zabn;
        ((GoogleApiManager)object).zaa(this);
    }

    public GoogleApi(Context context, Api api, Api$ApiOptions api$ApiOptions, StatusExceptionMapper object) {
        GoogleApi$Settings$Builder googleApi$Settings$Builder = new GoogleApi$Settings$Builder();
        object = googleApi$Settings$Builder.setMapper((StatusExceptionMapper)object).build();
        this(context, api, api$ApiOptions, (GoogleApi$Settings)object);
    }

    private final BaseImplementation$ApiMethodImpl zaa(int n10, BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        baseImplementation$ApiMethodImpl.zau();
        this.zabm.zaa(this, n10, baseImplementation$ApiMethodImpl);
        return baseImplementation$ApiMethodImpl;
    }

    private final Task zaa(int n10, TaskApiCall taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GoogleApiManager googleApiManager = this.zabm;
        StatusExceptionMapper statusExceptionMapper = this.zabl;
        googleApiManager.zaa(this, n10, taskApiCall, taskCompletionSource, statusExceptionMapper);
        return taskCompletionSource.getTask();
    }

    public GoogleApiClient asGoogleApiClient() {
        return this.zabk;
    }

    public ClientSettings$Builder createClientSettingsBuilder() {
        ClientSettings$Builder clientSettings$Builder = new ClientSettings$Builder();
        Object object = this.zabh;
        boolean bl2 = object instanceof Api$ApiOptions$HasGoogleSignInAccountOptions;
        object = bl2 && (object = ((Api$ApiOptions$HasGoogleSignInAccountOptions)object).getGoogleSignInAccount()) != null ? ((GoogleSignInAccount)object).getAccount() : ((bl2 = (object = this.zabh) instanceof Api$ApiOptions$HasAccountOptions) ? ((Api$ApiOptions$HasAccountOptions)object).getAccount() : null);
        clientSettings$Builder = clientSettings$Builder.setAccount((Account)object);
        object = this.zabh;
        bl2 = object instanceof Api$ApiOptions$HasGoogleSignInAccountOptions;
        object = bl2 && (object = ((Api$ApiOptions$HasGoogleSignInAccountOptions)object).getGoogleSignInAccount()) != null ? ((GoogleSignInAccount)object).getRequestedScopes() : Collections.emptySet();
        clientSettings$Builder = clientSettings$Builder.addAllRequiredScopes((Collection)object);
        object = this.mContext.getClass().getName();
        clientSettings$Builder = clientSettings$Builder.setRealClientClassName((String)object);
        object = this.mContext.getPackageName();
        return clientSettings$Builder.setRealClientPackageName((String)object);
    }

    public Task disconnectService() {
        return this.zabm.zac(this);
    }

    public BaseImplementation$ApiMethodImpl doBestEffortWrite(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        return this.zaa(2, baseImplementation$ApiMethodImpl);
    }

    public Task doBestEffortWrite(TaskApiCall taskApiCall) {
        return this.zaa(2, taskApiCall);
    }

    public BaseImplementation$ApiMethodImpl doRead(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        return this.zaa(0, baseImplementation$ApiMethodImpl);
    }

    public Task doRead(TaskApiCall taskApiCall) {
        return this.zaa(0, taskApiCall);
    }

    public Task doRegisterEventListener(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod) {
        Preconditions.checkNotNull(registerListenerMethod);
        Preconditions.checkNotNull(unregisterListenerMethod);
        ListenerHolder$ListenerKey listenerHolder$ListenerKey = registerListenerMethod.getListenerKey();
        Object object = "Listener has already been released.";
        Preconditions.checkNotNull(listenerHolder$ListenerKey, object);
        Preconditions.checkNotNull(unregisterListenerMethod.getListenerKey(), object);
        listenerHolder$ListenerKey = registerListenerMethod.getListenerKey();
        object = unregisterListenerMethod.getListenerKey();
        Preconditions.checkArgument(listenerHolder$ListenerKey.equals(object), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zabm.zaa(this, registerListenerMethod, unregisterListenerMethod);
    }

    public Task doRegisterEventListener(RegistrationMethods object) {
        Preconditions.checkNotNull(object);
        Object object2 = ((RegistrationMethods)object).zajz.getListenerKey();
        Object object3 = "Listener has already been released.";
        Preconditions.checkNotNull(object2, object3);
        Preconditions.checkNotNull(((RegistrationMethods)object).zaka.getListenerKey(), object3);
        object2 = this.zabm;
        object3 = ((RegistrationMethods)object).zajz;
        object = ((RegistrationMethods)object).zaka;
        return ((GoogleApiManager)object2).zaa(this, (RegisterListenerMethod)object3, (UnregisterListenerMethod)object);
    }

    public Task doUnregisterEventListener(ListenerHolder$ListenerKey listenerHolder$ListenerKey) {
        Preconditions.checkNotNull(listenerHolder$ListenerKey, "Listener key cannot be null.");
        return this.zabm.zaa(this, listenerHolder$ListenerKey);
    }

    public BaseImplementation$ApiMethodImpl doWrite(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        return this.zaa(1, baseImplementation$ApiMethodImpl);
    }

    public Task doWrite(TaskApiCall taskApiCall) {
        return this.zaa(1, taskApiCall);
    }

    public final Api getApi() {
        return this.mApi;
    }

    public Api$ApiOptions getApiOptions() {
        return this.zabh;
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    public Looper getLooper() {
        return this.zabj;
    }

    public ListenerHolder registerListener(Object object, String string2) {
        Looper looper = this.zabj;
        return ListenerHolders.createListenerHolder(object, looper, string2);
    }

    public Api.Client zaa(Looper looper, GoogleApiManager$zaa googleApiManager$zaa) {
        ClientSettings clientSettings = this.createClientSettingsBuilder().build();
        Api$AbstractClientBuilder api$AbstractClientBuilder = this.mApi.zai();
        Context context = this.mContext;
        Api$ApiOptions api$ApiOptions = this.zabh;
        return api$AbstractClientBuilder.buildClient(context, looper, clientSettings, api$ApiOptions, googleApiManager$zaa, googleApiManager$zaa);
    }

    public zace zaa(Context context, Handler handler) {
        ClientSettings clientSettings = this.createClientSettingsBuilder().build();
        zace zace2 = new zace(context, handler, clientSettings);
        return zace2;
    }

    public final zai zak() {
        return this.zabi;
    }
}

