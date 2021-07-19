/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 */
package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.api.Api$ApiOptions$HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings$OptionalApiSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zaa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class GoogleApiClient$Builder {
    private final Context mContext;
    private Looper zabj;
    private final Set zabr;
    private final Set zabs;
    private int zabt;
    private View zabu;
    private String zabv;
    private String zabw;
    private final Map zabx;
    private boolean zaby;
    private final Map zabz;
    private LifecycleActivity zaca;
    private int zacb;
    private GoogleApiClient$OnConnectionFailedListener zacc;
    private GoogleApiAvailability zacd;
    private Api$AbstractClientBuilder zace;
    private final ArrayList zacf;
    private final ArrayList zacg;
    private boolean zach;
    private Account zax;

    public GoogleApiClient$Builder(Context object) {
        Object object2 = new HashSet();
        this.zabr = object2;
        object2 = new HashSet();
        this.zabs = object2;
        this.zabx = object2 = new ArrayMap();
        this.zaby = false;
        ArrayList arrayList = new ArrayList();
        this.zabz = arrayList;
        this.zacb = -1;
        arrayList = GoogleApiAvailability.getInstance();
        this.zacd = arrayList;
        arrayList = zaa.zaph;
        this.zace = arrayList;
        this.zacf = arrayList = new ArrayList();
        this.zacg = arrayList = new ArrayList();
        this.zach = false;
        this.mContext = object;
        object2 = object.getMainLooper();
        this.zabj = object2;
        this.zabv = object2 = object.getPackageName();
        object = object.getClass().getName();
        this.zabw = object;
    }

    public GoogleApiClient$Builder(Context context, GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        this(context);
        Preconditions.checkNotNull(googleApiClient$ConnectionCallbacks, "Must provide a connected listener");
        this.zacf.add(googleApiClient$ConnectionCallbacks);
        Preconditions.checkNotNull(googleApiClient$OnConnectionFailedListener, "Must provide a connection failed listener");
        this.zacg.add(googleApiClient$OnConnectionFailedListener);
    }

    private final void zaa(Api api, Api$ApiOptions object, Scope ... object2) {
        object = api.zah().getImpliedScopes(object);
        HashSet<Object> hashSet = new HashSet<Object>((Collection<Object>)object);
        for (Object object3 : object2) {
            hashSet.add(object3);
        }
        object = this.zabx;
        ClientSettings$OptionalApiSettings clientSettings$OptionalApiSettings = new ClientSettings$OptionalApiSettings(hashSet);
        object.put(api, clientSettings$OptionalApiSettings);
    }

    public final GoogleApiClient$Builder addApi(Api object) {
        Preconditions.checkNotNull(object, "Api must not be null");
        this.zabz.put(object, null);
        object = ((Api)object).zah().getImpliedScopes(null);
        this.zabs.addAll(object);
        this.zabr.addAll(object);
        return this;
    }

    public final GoogleApiClient$Builder addApi(Api object, Api$ApiOptions$HasOptions api$ApiOptions$HasOptions) {
        Preconditions.checkNotNull(object, "Api must not be null");
        Preconditions.checkNotNull(api$ApiOptions$HasOptions, "Null options are not permitted for this Api");
        this.zabz.put(object, api$ApiOptions$HasOptions);
        object = ((Api)object).zah().getImpliedScopes(api$ApiOptions$HasOptions);
        this.zabs.addAll(object);
        this.zabr.addAll(object);
        return this;
    }

    public final GoogleApiClient$Builder addApiIfAvailable(Api api, Api$ApiOptions$HasOptions api$ApiOptions$HasOptions, Scope ... scopeArray) {
        Preconditions.checkNotNull(api, "Api must not be null");
        Preconditions.checkNotNull(api$ApiOptions$HasOptions, "Null options are not permitted for this Api");
        this.zabz.put(api, api$ApiOptions$HasOptions);
        this.zaa(api, api$ApiOptions$HasOptions, scopeArray);
        return this;
    }

    public final GoogleApiClient$Builder addApiIfAvailable(Api api, Scope ... scopeArray) {
        Preconditions.checkNotNull(api, "Api must not be null");
        this.zabz.put(api, null);
        this.zaa(api, null, scopeArray);
        return this;
    }

    public final GoogleApiClient$Builder addConnectionCallbacks(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        Preconditions.checkNotNull(googleApiClient$ConnectionCallbacks, "Listener must not be null");
        this.zacf.add(googleApiClient$ConnectionCallbacks);
        return this;
    }

    public final GoogleApiClient$Builder addOnConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient$OnConnectionFailedListener, "Listener must not be null");
        this.zacg.add(googleApiClient$OnConnectionFailedListener);
        return this;
    }

    public final GoogleApiClient$Builder addScope(Scope scope) {
        Preconditions.checkNotNull(scope, "Scope must not be null");
        this.zabr.add(scope);
        return this;
    }

    public final GoogleApiClient$Builder addScopeNames(String[] stringArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            Set set = this.zabr;
            String string2 = stringArray[i10];
            Scope scope = new Scope(string2);
            set.add(scope);
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final GoogleApiClient build() {
        zaaw zaaw2;
        Object object;
        Looper looper;
        Object object2;
        Object object3;
        Object v10;
        Object object4;
        int n10;
        GoogleApiClient$Builder googleApiClient$Builder = this;
        int n11 = this.zabz.isEmpty();
        int n12 = 1;
        Preconditions.checkArgument((n11 ^= n12) != 0, "must call addApi() to add at least one API");
        Object object5 = this.buildClientSettings();
        int n13 = 0;
        Object object6 = null;
        Map map = ((ClientSettings)object5).getOptionalApiSettings();
        Object object7 = new ArrayMap();
        ArrayMap arrayMap = new ArrayMap();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object8 = this.zabz.keySet();
        Object object9 = object8.iterator();
        int n14 = 0;
        int n15 = 0;
        while ((n10 = object9.hasNext()) != 0) {
            object4 = object8 = object9.next();
            object4 = (Api)object8;
            v10 = googleApiClient$Builder.zabz.get(object4);
            object8 = map.get(object4);
            if (object8 != null) {
                n10 = n12;
            } else {
                n10 = 0;
                object8 = null;
            }
            object3 = n10 != 0;
            object7.put(object4, object3);
            object2 = new zaq((Api)object4, n10 != 0);
            arrayList.add(object2);
            Api$AbstractClientBuilder api$AbstractClientBuilder = ((Api)object4).zai();
            object3 = googleApiClient$Builder.mContext;
            looper = googleApiClient$Builder.zabj;
            object8 = api$AbstractClientBuilder;
            object = object5;
            Object object10 = object4;
            object4 = object2;
            object8 = api$AbstractClientBuilder.buildClient((Context)object3, looper, (ClientSettings)object5, v10, (GoogleApiClient$ConnectionCallbacks)object2, (GoogleApiClient$OnConnectionFailedListener)object2);
            object3 = ((Api)object10).getClientKey();
            arrayMap.put(object3, object8);
            int n16 = api$AbstractClientBuilder.getPriority();
            if (n16 == n12) {
                n15 = v10 != null ? n12 : 0;
            }
            if ((n10 = (int)(object8.providesSignIn() ? 1 : 0)) == 0) continue;
            if (object6 != null) {
                String string2 = ((Api)object10).getName();
                object6 = ((Api)object6).getName();
                n10 = String.valueOf(string2).length() + 21;
                n16 = String.valueOf(object6).length();
                object3 = new StringBuilder(n10 += n16);
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(" cannot be used with ");
                ((StringBuilder)object3).append((String)object6);
                string2 = ((StringBuilder)object3).toString();
                object5 = new IllegalStateException(string2);
                throw object5;
            }
            object6 = object10;
        }
        if (object6 != null) {
            if (n15 != 0) {
                String string3 = ((Api)object6).getName();
                n13 = String.valueOf(string3).length() + 82;
                object8 = new StringBuilder(n13);
                object8.append("With using ");
                object8.append(string3);
                object8.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                string3 = object8.toString();
                object5 = new IllegalStateException(string3);
                throw object5;
            }
            object8 = googleApiClient$Builder.zax;
            if (object8 == null) {
                n10 = n12;
            } else {
                n10 = 0;
                object8 = null;
            }
            looper = new Object[n12];
            looper[0] = object = ((Api)object6).getName();
            Preconditions.checkState(n10 != 0, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", (Object[])looper);
            object8 = googleApiClient$Builder.zabr;
            object3 = googleApiClient$Builder.zabs;
            n10 = object8.equals(object3);
            object3 = "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.";
            looper = new Object[n12];
            object6 = ((Api)object6).getName();
            looper[0] = object6;
            Preconditions.checkState(n10 != 0, (String)object3, (Object[])looper);
        }
        n14 = zaaw.zaa(arrayMap.values(), n12 != 0);
        object3 = googleApiClient$Builder.mContext;
        looper = new ReentrantLock();
        object = googleApiClient$Builder.zabj;
        object2 = googleApiClient$Builder.zacd;
        object4 = googleApiClient$Builder.zace;
        object6 = googleApiClient$Builder.zacf;
        object9 = googleApiClient$Builder.zacg;
        int n17 = googleApiClient$Builder.zacb;
        v10 = null;
        object8 = zaaw2;
        n11 = n17;
        map = object7;
        object7 = object6;
        object6 = arrayList;
        zaaw2 = new zaaw((Context)object3, (Lock)looper, (Looper)object, (ClientSettings)object5, (GoogleApiAvailability)object2, (Api$AbstractClientBuilder)object4, map, (List)object7, (List)object9, arrayMap, n17, n14, arrayList, false);
        object6 = GoogleApiClient.zal();
        synchronized (object6) {
            object5 = GoogleApiClient.zal();
            object5.add(zaaw2);
        }
        n11 = googleApiClient$Builder.zacb;
        if (n11 >= 0) {
            object5 = zaj.zaa(googleApiClient$Builder.zaca);
            n13 = googleApiClient$Builder.zacb;
            object8 = googleApiClient$Builder.zacc;
            ((zaj)object5).zaa(n13, zaaw2, (GoogleApiClient$OnConnectionFailedListener)object8);
        }
        return zaaw2;
    }

    public final ClientSettings buildClientSettings() {
        Object object = SignInOptions.DEFAULT;
        Object object2 = this.zabz;
        Api api = zaa.API;
        boolean bl2 = object2.containsKey(api);
        if (bl2) {
            object = (SignInOptions)this.zabz.get(api);
        }
        SignInOptions signInOptions = object;
        api = this.zax;
        Set set = this.zabr;
        Map map = this.zabx;
        int n10 = this.zabt;
        View view = this.zabu;
        String string2 = this.zabv;
        String string3 = this.zabw;
        object2 = object;
        object = new ClientSettings((Account)api, set, map, n10, view, string2, string3, signInOptions, false);
        return object;
    }

    public final GoogleApiClient$Builder enableAutoManage(FragmentActivity fragmentActivity, int n10, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        boolean bl2;
        LifecycleActivity lifecycleActivity = new LifecycleActivity(fragmentActivity);
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            fragmentActivity = null;
        }
        Preconditions.checkArgument(bl2, "clientId must be non-negative");
        this.zacb = n10;
        this.zacc = googleApiClient$OnConnectionFailedListener;
        this.zaca = lifecycleActivity;
        return this;
    }

    public final GoogleApiClient$Builder enableAutoManage(FragmentActivity fragmentActivity, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        return this.enableAutoManage(fragmentActivity, 0, googleApiClient$OnConnectionFailedListener);
    }

    public final GoogleApiClient$Builder setAccountName(String string2) {
        if (string2 == null) {
            string2 = null;
        } else {
            String string3 = "com.google";
            Account account = new Account(string2, string3);
            string2 = account;
        }
        this.zax = string2;
        return this;
    }

    public final GoogleApiClient$Builder setGravityForPopups(int n10) {
        this.zabt = n10;
        return this;
    }

    public final GoogleApiClient$Builder setHandler(Handler handler) {
        Preconditions.checkNotNull(handler, "Handler must not be null");
        handler = handler.getLooper();
        this.zabj = handler;
        return this;
    }

    public final GoogleApiClient$Builder setViewForPopups(View view) {
        Preconditions.checkNotNull(view, "View must not be null");
        this.zabu = view;
        return this;
    }

    public final GoogleApiClient$Builder useDefaultAccount() {
        return this.setAccountName("<<default account>>");
    }
}

