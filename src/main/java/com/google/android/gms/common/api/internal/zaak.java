/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$AnyClientKey;
import com.google.android.gms.common.api.Api$BaseClientBuilder;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.zaal;
import com.google.android.gms.common.api.internal.zaam;
import com.google.android.gms.common.api.internal.zaan;
import com.google.android.gms.common.api.internal.zaaq;
import com.google.android.gms.common.api.internal.zaat;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabh;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings$OptionalApiSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zaak
implements zabd {
    private final Context mContext;
    private final Api$AbstractClientBuilder zace;
    private final Lock zaeo;
    private final ClientSettings zaet;
    private final Map zaew;
    private final GoogleApiAvailabilityLight zaey;
    private ConnectionResult zafh;
    private final zabe zaft;
    private int zafw;
    private int zafx = 0;
    private int zafy;
    private final Bundle zafz;
    private final Set zaga;
    private zad zagb;
    private boolean zagc;
    private boolean zagd;
    private boolean zage;
    private IAccountAccessor zagf;
    private boolean zagg;
    private boolean zagh;
    private ArrayList zagi;

    public zaak(zabe zabe2, ClientSettings clientSettings, Map map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api$AbstractClientBuilder api$AbstractClientBuilder, Lock lock, Context context) {
        Object object;
        this.zafz = object = new Bundle();
        this.zaga = object;
        super();
        this.zagi = object;
        this.zaft = zabe2;
        this.zaet = clientSettings;
        this.zaew = map;
        this.zaey = googleApiAvailabilityLight;
        this.zace = api$AbstractClientBuilder;
        this.zaeo = lock;
        this.mContext = context;
    }

    public static /* synthetic */ Context zaa(zaak zaak2) {
        return zaak2.mContext;
    }

    public static /* synthetic */ void zaa(zaak zaak2, ConnectionResult connectionResult) {
        zaak2.zae(connectionResult);
    }

    public static /* synthetic */ void zaa(zaak zaak2, ConnectionResult connectionResult, Api api, boolean bl2) {
        zaak2.zab(connectionResult, api, bl2);
    }

    public static /* synthetic */ void zaa(zaak zaak2, zaj zaj2) {
        zaak2.zaa(zaj2);
    }

    private final void zaa(zaj object) {
        Object object2 = null;
        boolean bl2 = this.zac(0);
        if (!bl2) {
            return;
        }
        object2 = ((zaj)object).getConnectionResult();
        boolean n10 = ((ConnectionResult)object2).isSuccess();
        if (n10) {
            boolean bl3;
            object2 = ((ResolveAccountResponse)(object = ((zaj)object).zacx())).getConnectionResult();
            boolean bl4 = ((ConnectionResult)object2).isSuccess();
            if (!bl4) {
                object = String.valueOf(object2);
                int n11 = String.valueOf(object).length() + 48;
                StringBuilder stringBuilder = new StringBuilder(n11);
                stringBuilder.append("Sign-in succeeded with resolve account failure: ");
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                Exception exception = new Exception();
                Log.wtf((String)"GoogleApiClientConnecting", (String)object, (Throwable)exception);
                this.zae((ConnectionResult)object2);
                return;
            }
            this.zage = true;
            this.zagf = object2 = ((ResolveAccountResponse)object).getAccountAccessor();
            this.zagg = bl2 = ((ResolveAccountResponse)object).getSaveDefaultAccount();
            this.zagh = bl3 = ((ResolveAccountResponse)object).isFromCrossClientAuth();
            this.zaap();
            return;
        }
        boolean bl5 = this.zad((ConnectionResult)object2);
        if (bl5) {
            this.zaar();
            this.zaap();
            return;
        }
        this.zae((ConnectionResult)object2);
    }

    public static /* synthetic */ boolean zaa(zaak zaak2, int n10) {
        return zaak2.zac(0);
    }

    private final boolean zaao() {
        int n10 = this.zafy;
        int n11 = 1;
        this.zafy = n10 -= n11;
        if (n10 > 0) {
            return false;
        }
        if (n10 < 0) {
            Object object = this.zaft.zaee.zaay();
            String string2 = "GoogleApiClientConnecting";
            Log.w((String)string2, (String)object);
            object = new Exception();
            Log.wtf((String)string2, (String)"GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", (Throwable)object);
            object = new ConnectionResult(8, null);
            this.zae((ConnectionResult)object);
            return false;
        }
        ConnectionResult connectionResult = this.zafh;
        if (connectionResult != null) {
            int n12;
            zabe zabe2 = this.zaft;
            zabe2.zahs = n12 = this.zafw;
            this.zae(connectionResult);
            return false;
        }
        return n11 != 0;
    }

    private final void zaap() {
        int n10 = this.zafy;
        if (n10 != 0) {
            return;
        }
        n10 = (int)(this.zagd ? 1 : 0);
        if (n10 == 0 || (n10 = (int)(this.zage ? 1 : 0)) != 0) {
            Object object;
            Object object2;
            boolean bl2;
            int n11;
            Object object3 = new ArrayList();
            this.zafx = 1;
            this.zafy = n11 = this.zaft.zagz.size();
            Object object4 = this.zaft.zagz.keySet().iterator();
            while (bl2 = object4.hasNext()) {
                object2 = this.zaft.zahp;
                object = (Api$AnyClientKey)object4.next();
                boolean bl3 = object2.containsKey(object);
                if (bl3) {
                    bl2 = this.zaao();
                    if (!bl2) continue;
                    this.zaaq();
                    continue;
                }
                object2 = this.zaft.zagz;
                object = (Api$Client)object2.get(object);
                ((ArrayList)object3).add(object);
            }
            n11 = (int)(((ArrayList)object3).isEmpty() ? 1 : 0);
            if (n11 == 0) {
                object4 = this.zagi;
                object = zabh.zabb();
                object2 = new zaaq(this, (ArrayList)object3);
                object3 = object.submit((Runnable)object2);
                ((ArrayList)object4).add(object3);
            }
        }
    }

    private final void zaaq() {
        boolean bl2;
        boolean bl3;
        this.zaft.zaba();
        Bundle bundle = zabh.zabb();
        Object object = new zaal(this);
        bundle.execute((Runnable)object);
        bundle = this.zagb;
        if (bundle != null) {
            bl3 = this.zagg;
            if (bl3) {
                object = this.zagf;
                boolean bl4 = this.zagh;
                bundle.zaa((IAccountAccessor)object, bl4);
            }
            bl2 = false;
            bundle = null;
            this.zab(false);
        }
        bundle = this.zaft.zahp.keySet().iterator();
        while (bl3 = bundle.hasNext()) {
            object = (Api$AnyClientKey)bundle.next();
            Map map = this.zaft.zagz;
            object = (Api$Client)map.get(object);
            object.disconnect();
        }
        bundle = this.zafz;
        bl2 = bundle.isEmpty();
        if (bl2) {
            bl2 = false;
            bundle = null;
        } else {
            bundle = this.zafz;
        }
        this.zaft.zaht.zab(bundle);
    }

    private final void zaar() {
        boolean bl2;
        this.zagd = false;
        Object object = this.zaft.zaee;
        Object object2 = Collections.emptySet();
        ((zaaw)object).zaha = object2;
        object = this.zaga.iterator();
        while (bl2 = object.hasNext()) {
            Map map = this.zaft.zahp;
            object2 = (Api$AnyClientKey)object.next();
            boolean bl3 = map.containsKey(object2);
            if (bl3) continue;
            map = this.zaft.zahp;
            int n10 = 17;
            ConnectionResult connectionResult = new ConnectionResult(n10, null);
            map.put(object2, connectionResult);
        }
    }

    private final void zaas() {
        ArrayList arrayList = this.zagi;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = arrayList.get(i10);
            object = (Future)object;
            boolean bl2 = true;
            object.cancel(bl2);
        }
        this.zagi.clear();
    }

    private final Set zaat() {
        boolean bl2;
        Object object = this.zaet;
        if (object == null) {
            return Collections.emptySet();
        }
        Object object2 = this.zaet.getRequiredScopes();
        object = new Object(object2);
        object2 = this.zaet.getOptionalApiSettings();
        Iterator iterator2 = object2.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map map = this.zaft.zahp;
            Object object3 = (Api)iterator2.next();
            Api$AnyClientKey api$AnyClientKey = ((Api)object3).getClientKey();
            boolean bl3 = map.containsKey(api$AnyClientKey);
            if (bl3) continue;
            object3 = ((ClientSettings$OptionalApiSettings)object2.get((Object)object3)).mScopes;
            object.addAll(object3);
        }
        return object;
    }

    public static /* synthetic */ GoogleApiAvailabilityLight zab(zaak zaak2) {
        return zaak2.zaey;
    }

    /*
     * Unable to fully structure code
     */
    private final void zab(ConnectionResult var1_1, Api var2_2, boolean var3_3) {
        block9: {
            block8: {
                var4_4 = var2_2.zah();
                var5_5 = var4_4.getPriority();
                var6_6 = 0;
                var7_7 = 1;
                if (var3_3 == 0) break block8;
                var3_3 = var1_1.hasResolution();
                if (var3_3 != 0) {
                    while (true) {
                        var3_3 = var7_7;
                        break;
                    }
                } else {
                    var8_8 = this.zaey;
                    if ((var8_8 = var8_8.getErrorResolutionIntent(var9_9 = var1_1.getErrorCode())) != null) ** continue;
                    var3_3 = 0;
                    var8_8 = null;
                }
                if (var3_3 == 0) break block9;
            }
            if ((var8_8 = this.zafh) == null || var5_5 < (var3_3 = this.zafw)) {
                var6_6 = var7_7;
            }
        }
        if (var6_6 != 0) {
            this.zafh = var1_1;
            this.zafw = var5_5;
        }
        var8_8 = this.zaft.zahp;
        var2_2 = var2_2.getClientKey();
        var8_8.put(var2_2, var1_1);
    }

    private final void zab(boolean bl2) {
        zad zad2 = this.zagb;
        if (zad2 != null) {
            Object object;
            boolean bl3 = zad2.isConnected();
            if (bl3 && bl2) {
                object = this.zagb;
                object.zacw();
            }
            this.zagb.disconnect();
            object = this.zaet;
            bl2 = ((ClientSettings)object).isSignInClientDisconnectFixEnabled();
            bl3 = false;
            zad2 = null;
            if (bl2) {
                this.zagb = null;
            }
            this.zagf = null;
        }
    }

    public static /* synthetic */ boolean zab(zaak zaak2, ConnectionResult connectionResult) {
        return zaak2.zad(connectionResult);
    }

    public static /* synthetic */ Lock zac(zaak zaak2) {
        return zaak2.zaeo;
    }

    private final boolean zac(int n10) {
        int n11 = this.zafx;
        if (n11 != n10) {
            Object object = this.zaft.zaee.zaay();
            String string2 = "GoogleApiClientConnecting";
            Log.w((String)string2, (String)object);
            object = String.valueOf(this);
            int n12 = String.valueOf(object).length() + 23;
            StringBuilder stringBuilder = new StringBuilder(n12);
            stringBuilder.append("Unexpected callback in ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Log.w((String)string2, (String)object);
            n11 = this.zafy;
            stringBuilder = new StringBuilder(33);
            stringBuilder.append("mRemainingConnections=");
            stringBuilder.append(n11);
            object = stringBuilder.toString();
            Log.w((String)string2, (String)object);
            object = zaak.zad(this.zafx);
            Object object2 = zaak.zad(n10);
            n12 = String.valueOf(object).length() + 70;
            int n13 = String.valueOf(object2).length();
            stringBuilder = new StringBuilder(n12 += n13);
            stringBuilder.append("GoogleApiClient connecting is in step ");
            stringBuilder.append((String)object);
            stringBuilder.append(" but received callback for step ");
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            object = new Exception();
            Log.wtf((String)string2, (String)object2, (Throwable)object);
            object2 = new ConnectionResult(8, null);
            this.zae((ConnectionResult)object2);
            return false;
        }
        return true;
    }

    public static /* synthetic */ zabe zad(zaak zaak2) {
        return zaak2.zaft;
    }

    private static String zad(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return "UNKNOWN";
            }
            return "STEP_GETTING_REMOTE_SERVICE";
        }
        return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    private final boolean zad(ConnectionResult connectionResult) {
        boolean bl2;
        boolean bl3 = this.zagc;
        return bl3 && !(bl2 = connectionResult.hasResolution());
    }

    private final void zae(ConnectionResult connectionResult) {
        this.zaas();
        boolean bl2 = connectionResult.hasResolution() ^ true;
        this.zab(bl2);
        this.zaft.zaf(connectionResult);
        this.zaft.zaht.zac(connectionResult);
    }

    public static /* synthetic */ boolean zae(zaak zaak2) {
        return zaak2.zagd;
    }

    public static /* synthetic */ zad zaf(zaak zaak2) {
        return zaak2.zagb;
    }

    public static /* synthetic */ Set zag(zaak zaak2) {
        return zaak2.zaat();
    }

    public static /* synthetic */ IAccountAccessor zah(zaak zaak2) {
        return zaak2.zagf;
    }

    public static /* synthetic */ ClientSettings zai(zaak zaak2) {
        return zaak2.zaet;
    }

    public static /* synthetic */ void zaj(zaak zaak2) {
        zaak2.zaar();
    }

    public static /* synthetic */ void zak(zaak zaak2) {
        zaak2.zaap();
    }

    public static /* synthetic */ boolean zal(zaak zaak2) {
        return zaak2.zaao();
    }

    public final void begin() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Api api;
        boolean bl2;
        int n10;
        this.zaft.zahp.clear();
        int n11 = 0;
        Object object6 = null;
        this.zagd = false;
        Object object7 = null;
        this.zafh = null;
        this.zafx = 0;
        this.zagc = n10 = 1;
        this.zage = false;
        this.zagg = false;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object object8 = this.zaew.keySet().iterator();
        int n12 = 0;
        Context context = null;
        while (bl2 = object8.hasNext()) {
            api = (Api)object8.next();
            object5 = this.zaft.zagz;
            object4 = api.getClientKey();
            object5 = (Api$Client)object5.get(object4);
            object4 = api.zah();
            int n13 = ((Api$BaseClientBuilder)object4).getPriority();
            if (n13 == n10) {
                n13 = n10;
            } else {
                n13 = 0;
                object4 = null;
            }
            n12 |= n13;
            object4 = (Boolean)this.zaew.get(api);
            n13 = (int)(((Boolean)object4).booleanValue() ? 1 : 0);
            boolean bl3 = object5.requiresSignIn();
            if (bl3) {
                this.zagd = n10;
                if (n13 != 0) {
                    object3 = this.zaga;
                    object2 = api.getClientKey();
                    object3.add(object2);
                } else {
                    this.zagc = false;
                }
            }
            object3 = new zaam(this, api, n13 != 0);
            hashMap.put(object5, object3);
        }
        if (n12 != 0) {
            this.zagd = false;
        }
        if ((n11 = this.zagd) != 0) {
            object6 = this.zaet;
            n10 = System.identityHashCode(this.zaft.zaee);
            object = n10;
            ((ClientSettings)object6).setClientSessionId((Integer)object);
            object2 = new zaat(this, null);
            object8 = this.zace;
            context = this.mContext;
            api = ((GoogleApiClient)this.zaft.zaee).getLooper();
            object5 = this.zaet;
            object4 = ((ClientSettings)object5).getSignInOptions();
            object3 = object2;
            this.zagb = object6 = (zad)((Api$AbstractClientBuilder)object8).buildClient(context, (Looper)api, (ClientSettings)object5, object4, (GoogleApiClient$ConnectionCallbacks)object2, (GoogleApiClient$OnConnectionFailedListener)object2);
        }
        this.zafy = n11 = this.zaft.zagz.size();
        object6 = this.zagi;
        object7 = zabh.zabb();
        object = new zaan(this, hashMap);
        object7 = object7.submit((Runnable)object);
        ((ArrayList)object6).add(object7);
    }

    public final void connect() {
    }

    public final boolean disconnect() {
        this.zaas();
        boolean bl2 = true;
        this.zab(bl2);
        this.zaft.zaf(null);
        return bl2;
    }

    public final BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        this.zaft.zaee.zafc.add(baseImplementation$ApiMethodImpl);
        return baseImplementation$ApiMethodImpl;
    }

    public final BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl object) {
        object = new IllegalStateException("GoogleApiClient is not connected yet.");
        throw object;
    }

    public final void onConnected(Bundle bundle) {
        boolean bl2;
        boolean bl3 = this.zac(1);
        if (!bl3) {
            return;
        }
        if (bundle != null) {
            Bundle bundle2 = this.zafz;
            bundle2.putAll(bundle);
        }
        if (bl2 = this.zaao()) {
            this.zaaq();
        }
    }

    public final void onConnectionSuspended(int n10) {
        ConnectionResult connectionResult = new ConnectionResult(8, null);
        this.zae(connectionResult);
    }

    public final void zaa(ConnectionResult connectionResult, Api api, boolean bl2) {
        boolean bl3 = this.zac(1);
        if (!bl3) {
            return;
        }
        this.zab(connectionResult, api, bl2);
        boolean bl4 = this.zaao();
        if (bl4) {
            this.zaaq();
        }
    }
}

