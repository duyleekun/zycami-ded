/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Message
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$LegacyClientCallbackAdapter;
import com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$zzc;
import com.google.android.gms.common.internal.BaseGmsClient$zzd;
import com.google.android.gms.common.internal.BaseGmsClient$zze;
import com.google.android.gms.common.internal.BaseGmsClient$zzf;
import com.google.android.gms.common.internal.BaseGmsClient$zzg;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.GmsClientSupervisor$zza;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.internal.zzk;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseGmsClient {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES;
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zzd;
    public final Handler zza;
    private ConnectionResult zzaa;
    private boolean zzab;
    private volatile zzc zzac;
    public BaseGmsClient$ConnectionProgressReportCallbacks zzb;
    public AtomicInteger zzc;
    private int zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    private volatile String zzj;
    private zzk zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    private IGmsServiceBroker zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private BaseGmsClient$zzd zzu;
    private int zzv;
    private final BaseGmsClient$BaseConnectionCallbacks zzw;
    private final BaseGmsClient$BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;

    static {
        zzd = new Feature[0];
        GOOGLE_PLUS_REQUIRED_FEATURES = new String[]{"service_esmobile", "service_googleme"};
    }

    public BaseGmsClient(Context object, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int n10, BaseGmsClient$BaseConnectionCallbacks baseGmsClient$BaseConnectionCallbacks, BaseGmsClient$BaseOnConnectionFailedListener baseGmsClient$BaseOnConnectionFailedListener) {
        AtomicInteger atomicInteger;
        this.zzj = null;
        ArrayList arrayList = new ArrayList();
        this.zzp = arrayList;
        arrayList = new ArrayList();
        this.zzq = arrayList;
        this.zzt = arrayList = new ArrayList();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = atomicInteger = new AtomicInteger(0);
        this.zzl = object = (Context)Preconditions.checkNotNull(object, "Context must not be null");
        object = (Handler)Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zza = object;
        object = handler.getLooper();
        this.zzm = object;
        object = (GmsClientSupervisor)Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = object;
        object = (GoogleApiAvailabilityLight)Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = object;
        this.zzy = n10;
        this.zzw = baseGmsClient$BaseConnectionCallbacks;
        this.zzx = baseGmsClient$BaseOnConnectionFailedListener;
        this.zzz = null;
    }

    public BaseGmsClient(Context context, Looper looper, int n10, BaseGmsClient$BaseConnectionCallbacks object, BaseGmsClient$BaseOnConnectionFailedListener baseGmsClient$BaseOnConnectionFailedListener, String string2) {
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
        Object object2 = object = Preconditions.checkNotNull(object);
        object2 = (BaseGmsClient$BaseConnectionCallbacks)object;
        Object object3 = object = Preconditions.checkNotNull(baseGmsClient$BaseOnConnectionFailedListener);
        object3 = (BaseGmsClient$BaseOnConnectionFailedListener)object;
        this(context, looper, gmsClientSupervisor, googleApiAvailabilityLight, n10, (BaseGmsClient$BaseConnectionCallbacks)object2, (BaseGmsClient$BaseOnConnectionFailedListener)object3, string2);
    }

    public BaseGmsClient(Context object, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int n10, BaseGmsClient$BaseConnectionCallbacks baseGmsClient$BaseConnectionCallbacks, BaseGmsClient$BaseOnConnectionFailedListener baseGmsClient$BaseOnConnectionFailedListener, String string2) {
        AtomicInteger atomicInteger;
        this.zzj = null;
        ArrayList arrayList = new ArrayList();
        this.zzp = arrayList;
        arrayList = new ArrayList();
        this.zzq = arrayList;
        this.zzt = arrayList = new ArrayList();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = atomicInteger = new AtomicInteger(0);
        this.zzl = object = (Context)Preconditions.checkNotNull(object, "Context must not be null");
        object = (Looper)Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzm = object;
        object = (GmsClientSupervisor)Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = object;
        object = (GoogleApiAvailabilityLight)Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = object;
        super(this, looper);
        this.zza = object;
        this.zzy = n10;
        this.zzw = baseGmsClient$BaseConnectionCallbacks;
        this.zzx = baseGmsClient$BaseOnConnectionFailedListener;
        this.zzz = string2;
    }

    public static /* synthetic */ ConnectionResult zza(BaseGmsClient baseGmsClient, ConnectionResult connectionResult) {
        baseGmsClient.zzaa = connectionResult;
        return connectionResult;
    }

    public static /* synthetic */ IGmsServiceBroker zza(BaseGmsClient baseGmsClient, IGmsServiceBroker iGmsServiceBroker) {
        baseGmsClient.zzr = iGmsServiceBroker;
        return iGmsServiceBroker;
    }

    public static /* synthetic */ Object zza(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzq;
    }

    private final String zza() {
        String string2 = this.zzz;
        if (string2 == null) {
            string2 = this.zzl.getClass().getName();
        }
        return string2;
    }

    private final void zza(int n10) {
        n10 = (int)(this.zzb() ? 1 : 0);
        if (n10 != 0) {
            boolean bl2;
            n10 = 5;
            this.zzab = bl2 = true;
        } else {
            n10 = 4;
        }
        Handler handler = this.zza;
        int n11 = this.zzc.get();
        Message message = handler.obtainMessage(n10, n11, 16);
        handler.sendMessage(message);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zza(int n10, IInterface object) {
        Object object2;
        int n11;
        int n12 = 4;
        int n13 = 0;
        Object object3 = null;
        int n14 = 1;
        int n15 = n10 == n12 ? n14 : 0;
        if (object != null) {
            n11 = n14;
        } else {
            n11 = 0;
            object2 = null;
        }
        if (n15 == n11) {
            n13 = n14;
        }
        Preconditions.checkArgument(n13 != 0);
        object3 = this.zzp;
        synchronized (object3) {
            block15: {
                block14: {
                    this.zzv = n10;
                    this.zzs = object;
                    this.onSetConnectState(n10, (IInterface)object);
                    n15 = 0;
                    if (n10 == n14) break block14;
                    n14 = 2;
                    n11 = 3;
                    if (n10 != n14 && n10 != n11) {
                        if (n10 == n12) {
                            this.onConnectedLocked((IInterface)object);
                        }
                        break block15;
                    } else {
                        BaseGmsClient$zzd baseGmsClient$zzd;
                        int n16;
                        Object object4;
                        Object object5;
                        Object object6;
                        Object object7;
                        Object object8;
                        Object object9 = this.zzu;
                        if (object9 != null && (object9 = this.zzk) != null) {
                            object = "GmsClient";
                            object9 = ((zzk)object9).zza();
                            object8 = this.zzk;
                            object8 = ((zzk)object8).zzb();
                            object7 = String.valueOf(object9);
                            n14 = ((String)object7).length() + 70;
                            object6 = String.valueOf(object8);
                            int n17 = ((String)object6).length();
                            object6 = new StringBuilder(n14 += n17);
                            object7 = "Calling connect() while still connected, missing disconnect() for ";
                            ((StringBuilder)object6).append((String)object7);
                            ((StringBuilder)object6).append((String)object9);
                            object9 = " on ";
                            ((StringBuilder)object6).append((String)object9);
                            ((StringBuilder)object6).append((String)object8);
                            object9 = ((StringBuilder)object6).toString();
                            Log.e((String)object, (String)object9);
                            object6 = this.zzn;
                            object9 = this.zzk;
                            object5 = ((zzk)object9).zza();
                            object9 = this.zzk;
                            object4 = ((zzk)object9).zzb();
                            object9 = this.zzk;
                            n16 = ((zzk)object9).zzc();
                            baseGmsClient$zzd = this.zzu;
                            String string2 = this.zza();
                            object9 = this.zzk;
                            boolean bl2 = ((zzk)object9).zzd();
                            ((GmsClientSupervisor)object6).zza((String)object5, (String)object4, n16, baseGmsClient$zzd, string2, bl2);
                            object9 = this.zzc;
                            ((AtomicInteger)object9).incrementAndGet();
                        }
                        object = this.zzc;
                        int n18 = ((AtomicInteger)object).get();
                        this.zzu = object9 = new BaseGmsClient$zzd(this, n18);
                        n10 = this.zzv;
                        if (n10 == n11 && (object9 = this.getLocalStartServiceAction()) != null) {
                            object = this.getContext();
                            object6 = object.getPackageName();
                            object5 = this.getLocalStartServiceAction();
                            boolean bl3 = true;
                            n16 = GmsClientSupervisor.getDefaultBindFlags();
                            boolean bl4 = false;
                            baseGmsClient$zzd = null;
                            object2 = object9;
                            object9 = new zzk((String)object6, (String)object5, bl3, n16, false);
                        } else {
                            object6 = this.getStartServicePackage();
                            object5 = this.getStartServiceAction();
                            boolean bl5 = false;
                            object4 = null;
                            n16 = GmsClientSupervisor.getDefaultBindFlags();
                            boolean bl6 = this.getUseDynamicLookup();
                            object2 = object9;
                            object9 = new zzk((String)object6, (String)object5, false, n16, bl6);
                        }
                        this.zzk = object9;
                        n10 = (int)(((zzk)object9).zzd() ? 1 : 0);
                        if (n10 != 0 && (n10 = this.getMinApkVersion()) < (n18 = 17895000)) {
                            object = "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ";
                            object8 = this.zzk;
                            object8 = ((zzk)object8).zza();
                            n14 = ((String)(object8 = String.valueOf(object8))).length();
                            object = n14 != 0 ? ((String)object).concat((String)object8) : (object8 = new String((String)object));
                            object9 = new IllegalStateException((String)object);
                            throw object9;
                        }
                        object9 = this.zzn;
                        object = this.zzk;
                        object = ((zzk)object).zza();
                        object8 = this.zzk;
                        object8 = ((zzk)object8).zzb();
                        object7 = this.zzk;
                        n14 = ((zzk)object7).zzc();
                        object2 = this.zzu;
                        object6 = this.zza();
                        object5 = this.zzk;
                        boolean bl7 = ((zzk)object5).zzd();
                        object4 = new GmsClientSupervisor$zza((String)object, (String)object8, n14, bl7);
                        n10 = (int)(((GmsClientSupervisor)object9).zza((GmsClientSupervisor$zza)object4, (ServiceConnection)object2, (String)object6) ? 1 : 0);
                        if (n10 == 0) {
                            object9 = "GmsClient";
                            object = this.zzk;
                            object = ((zzk)object).zza();
                            object8 = this.zzk;
                            object8 = ((zzk)object8).zzb();
                            object7 = String.valueOf(object);
                            n14 = ((String)object7).length() + 34;
                            object2 = String.valueOf(object8);
                            n11 = ((String)object2).length();
                            object2 = new StringBuilder(n14 += n11);
                            object7 = "unable to connect to service: ";
                            ((StringBuilder)object2).append((String)object7);
                            ((StringBuilder)object2).append((String)object);
                            object = " on ";
                            ((StringBuilder)object2).append((String)object);
                            ((StringBuilder)object2).append((String)object8);
                            object = ((StringBuilder)object2).toString();
                            Log.e((String)object9, (String)object);
                            n10 = 16;
                            object = this.zzc;
                            n18 = ((AtomicInteger)object).get();
                            this.zza(n10, null, n18);
                        }
                    }
                    break block15;
                }
                Object object10 = this.zzu;
                if (object10 != null) {
                    object2 = this.zzn;
                    object10 = this.zzk;
                    String string3 = ((zzk)object10).zza();
                    object10 = this.zzk;
                    String string4 = ((zzk)object10).zzb();
                    object10 = this.zzk;
                    int n19 = ((zzk)object10).zzc();
                    BaseGmsClient$zzd baseGmsClient$zzd = this.zzu;
                    String string5 = this.zza();
                    object10 = this.zzk;
                    boolean bl8 = ((zzk)object10).zzd();
                    ((GmsClientSupervisor)object2).zza(string3, string4, n19, baseGmsClient$zzd, string5, bl8);
                    this.zzu = null;
                }
            }
            return;
        }
    }

    public static /* synthetic */ void zza(BaseGmsClient baseGmsClient, int n10) {
        baseGmsClient.zza(16);
    }

    public static /* synthetic */ void zza(BaseGmsClient baseGmsClient, int n10, IInterface iInterface) {
        baseGmsClient.zza(n10, null);
    }

    public static /* synthetic */ void zza(BaseGmsClient baseGmsClient, zzc zzc2) {
        baseGmsClient.zza(zzc2);
    }

    private final void zza(zzc zzc2) {
        this.zzac = zzc2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean zza(int n10, int n11, IInterface iInterface) {
        Object object = this.zzp;
        synchronized (object) {
            int n12 = this.zzv;
            if (n12 != n10) {
                return false;
            }
            this.zza(n11, iInterface);
            return 1 != 0;
        }
    }

    public static /* synthetic */ boolean zza(BaseGmsClient baseGmsClient, int n10, int n11, IInterface iInterface) {
        return baseGmsClient.zza(n10, n11, iInterface);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean zzb() {
        Object object = this.zzp;
        synchronized (object) {
            boolean bl2 = this.zzv;
            boolean bl3 = 3 != 0;
            if (bl2 != bl3) return false;
            return true;
        }
    }

    public static /* synthetic */ boolean zzb(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzc();
    }

    private final boolean zzc() {
        boolean bl2 = this.zzab;
        if (bl2) {
            return false;
        }
        String string2 = this.getServiceDescriptor();
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        string2 = this.getLocalStartServiceAction();
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        try {
            string2 = this.getServiceDescriptor();
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
        Class.forName(string2);
        return true;
    }

    public static /* synthetic */ boolean zzc(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzab;
    }

    public static /* synthetic */ ConnectionResult zzd(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzaa;
    }

    public static /* synthetic */ BaseGmsClient$BaseConnectionCallbacks zze(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzw;
    }

    public static /* synthetic */ ArrayList zzf(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzt;
    }

    public static /* synthetic */ BaseGmsClient$BaseOnConnectionFailedListener zzg(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzx;
    }

    public void checkAvailabilityAndConnect() {
        Object object = this.zzo;
        Object object2 = this.zzl;
        int n10 = this.getMinApkVersion();
        int n11 = ((GoogleApiAvailabilityLight)object).isGooglePlayServicesAvailable((Context)object2, n10);
        if (n11 != 0) {
            this.zza(1, null);
            object2 = new BaseGmsClient$LegacyClientCallbackAdapter(this);
            this.triggerNotAvailable((BaseGmsClient$ConnectionProgressReportCallbacks)object2, n11, null);
            return;
        }
        object = new BaseGmsClient$LegacyClientCallbackAdapter(this);
        this.connect((BaseGmsClient$ConnectionProgressReportCallbacks)object);
    }

    public final void checkConnected() {
        boolean bl2 = this.isConnected();
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        throw illegalStateException;
    }

    public void connect(BaseGmsClient$ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks) {
        this.zzb = baseGmsClient$ConnectionProgressReportCallbacks = (BaseGmsClient$ConnectionProgressReportCallbacks)Preconditions.checkNotNull(baseGmsClient$ConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zza(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void disconnect() {
        this.zzc.incrementAndGet();
        ArrayList arrayList = this.zzt;
        synchronized (arrayList) {
            Object object = this.zzt;
            int n10 = ((ArrayList)object).size();
            int n11 = 0;
            while (true) {
                if (n11 >= n10) {
                    object = this.zzt;
                    ((ArrayList)object).clear();
                    // MONITOREXIT @DISABLED, blocks:[4, 6, 7] lbl12 : MonitorExitStatement: MONITOREXIT : var1_1
                    object = this.zzq;
                    synchronized (object) {
                        arrayList = null;
                        this.zzr = null;
                    }
                    this.zza(1, null);
                    return;
                }
                Object object2 = this.zzt;
                object2 = ((ArrayList)object2).get(n11);
                object2 = (BaseGmsClient$zzc)object2;
                ((BaseGmsClient$zzc)object2).zze();
                ++n11;
            }
        }
    }

    public void disconnect(String string2) {
        this.zzj = string2;
        this.disconnect();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dump(String object, FileDescriptor object2, PrintWriter object3, String[] object4) {
        long l10;
        long l11;
        long l12;
        int n10;
        Object object5;
        Object object6;
        int n11;
        block25: {
            CharSequence charSequence;
            int n12;
            Object object7;
            block21: {
                block26: {
                    long l13;
                    int n13;
                    int n14;
                    block20: {
                        block22: {
                            block23: {
                                block24: {
                                    object2 = this.zzp;
                                    synchronized (object2) {
                                        n11 = this.zzv;
                                        object6 = this.zzs;
                                    }
                                    object5 = this.zzq;
                                    synchronized (object5) {
                                        object2 = this.zzr;
                                    }
                                    object5 = ((PrintWriter)object3).append((CharSequence)object);
                                    object7 = "mConnectState=";
                                    ((PrintWriter)object5).append((CharSequence)object7);
                                    n14 = 3;
                                    n13 = 2;
                                    n12 = 1;
                                    if (n11 == n12) break block22;
                                    if (n11 == n13) break block23;
                                    if (n11 == n14) break block24;
                                    int n15 = 4;
                                    if (n11 != n15) {
                                        n15 = 5;
                                        if (n11 != n15) {
                                            object4 = "UNKNOWN";
                                            ((PrintWriter)object3).print((String)object4);
                                            break block20;
                                        } else {
                                            object4 = "DISCONNECTING";
                                            ((PrintWriter)object3).print((String)object4);
                                        }
                                        break block20;
                                    } else {
                                        object4 = "CONNECTED";
                                        ((PrintWriter)object3).print((String)object4);
                                    }
                                    break block20;
                                }
                                object4 = "LOCAL_CONNECTING";
                                ((PrintWriter)object3).print((String)object4);
                                break block20;
                            }
                            object4 = "REMOTE_CONNECTING";
                            ((PrintWriter)object3).print((String)object4);
                            break block20;
                        }
                        object4 = "DISCONNECTED";
                        ((PrintWriter)object3).print((String)object4);
                    }
                    object4 = " mService=";
                    ((PrintWriter)object3).append((CharSequence)object4);
                    if (object6 == null) {
                        object4 = "null";
                        ((PrintWriter)object3).append((CharSequence)object4);
                    } else {
                        object4 = this.getServiceDescriptor();
                        object4 = ((PrintWriter)object3).append((CharSequence)object4);
                        charSequence = "@";
                        object4 = ((PrintWriter)object4).append(charSequence);
                        n10 = System.identityHashCode(object6.asBinder());
                        object6 = Integer.toHexString(n10);
                        ((PrintWriter)object4).append((CharSequence)object6);
                    }
                    object4 = " mServiceBroker=";
                    ((PrintWriter)object3).append((CharSequence)object4);
                    if (object2 == null) {
                        object2 = "null";
                        ((PrintWriter)object3).println((String)object2);
                    } else {
                        object4 = ((PrintWriter)object3).append("IGmsServiceBroker@");
                        int n16 = System.identityHashCode(object2.asBinder());
                        object2 = Integer.toHexString(n16);
                        ((PrintWriter)object4).println((String)object2);
                    }
                    object4 = "yyyy-MM-dd HH:mm:ss.SSS";
                    object6 = Locale.US;
                    object2 = new SimpleDateFormat((String)object4, (Locale)object6);
                    long l14 = this.zzg;
                    l12 = 0L;
                    n11 = (int)(l14 == l12 ? 0 : (l14 < l12 ? -1 : 1));
                    if (n11 > 0) {
                        object4 = ((PrintWriter)object3).append((CharSequence)object).append("lastConnectedTime=");
                        l14 = this.zzg;
                        long l15 = this.zzg;
                        object6 = new Date(l15);
                        object6 = ((DateFormat)object2).format((Date)object6);
                        String string2 = String.valueOf(object6);
                        int n17 = string2.length() + 21;
                        StringBuilder stringBuilder = new StringBuilder(n17);
                        stringBuilder.append(l14);
                        charSequence = " ";
                        stringBuilder.append((String)charSequence);
                        stringBuilder.append((String)object6);
                        object6 = stringBuilder.toString();
                        ((PrintWriter)object4).println((String)object6);
                    }
                    if ((n11 = (int)((l13 = (l14 = this.zzf) - l12) == 0L ? 0 : (l13 < 0L ? -1 : 1))) <= 0) break block25;
                    object4 = ((PrintWriter)object3).append((CharSequence)object);
                    object6 = "lastSuspendedCause=";
                    ((PrintWriter)object4).append((CharSequence)object6);
                    n11 = this.zze;
                    if (n11 == n12) break block26;
                    if (n11 != n13) {
                        if (n11 != n14) {
                            object4 = String.valueOf(n11);
                            ((PrintWriter)object3).append((CharSequence)object4);
                            break block21;
                        } else {
                            object4 = "CAUSE_DEAD_OBJECT_EXCEPTION";
                            ((PrintWriter)object3).append((CharSequence)object4);
                        }
                        break block21;
                    } else {
                        object4 = "CAUSE_NETWORK_LOST";
                        ((PrintWriter)object3).append((CharSequence)object4);
                    }
                    break block21;
                }
                object4 = "CAUSE_SERVICE_DISCONNECTED";
                ((PrintWriter)object3).append((CharSequence)object4);
            }
            object4 = ((PrintWriter)object3).append(" lastSuspendedTime=");
            l11 = this.zzf;
            long l16 = this.zzf;
            object7 = new Date(l16);
            object7 = ((DateFormat)object2).format((Date)object7);
            String string3 = String.valueOf(object7);
            n12 = string3.length() + 21;
            charSequence = new StringBuilder(n12);
            ((StringBuilder)charSequence).append(l11);
            ((StringBuilder)charSequence).append(" ");
            ((StringBuilder)charSequence).append((String)object7);
            object6 = ((StringBuilder)charSequence).toString();
            ((PrintWriter)object4).println((String)object6);
        }
        if ((n11 = (int)((l10 = (l11 = this.zzi) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1))) > 0) {
            object = ((PrintWriter)object3).append((CharSequence)object).append("lastFailedStatus=");
            n11 = this.zzh;
            object4 = CommonStatusCodes.getStatusCodeString(n11);
            ((PrintWriter)object).append((CharSequence)object4);
            object = ((PrintWriter)object3).append(" lastFailedTime=");
            long l17 = this.zzi;
            long l18 = this.zzi;
            object6 = new Date(l18);
            object2 = ((DateFormat)object2).format((Date)object6);
            object6 = String.valueOf(object2);
            n10 = ((String)object6).length() + 21;
            object5 = new StringBuilder(n10);
            ((StringBuilder)object5).append(l17);
            object3 = " ";
            ((StringBuilder)object5).append((String)object3);
            ((StringBuilder)object5).append((String)object2);
            object2 = ((StringBuilder)object5).toString();
            ((PrintWriter)object).println((String)object2);
        }
    }

    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public Feature[] getApiFeatures() {
        return zzd;
    }

    public final Feature[] getAvailableFeatures() {
        zzc zzc2 = this.zzac;
        if (zzc2 == null) {
            return null;
        }
        return zzc2.zzb;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        Object object;
        boolean bl2 = this.isConnected();
        if (bl2 && (object = this.zzk) != null) {
            return ((zzk)object).zzb();
        }
        object = new RuntimeException("Failed to connect when checking package");
        throw object;
    }

    public Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        return bundle;
    }

    public String getLastDisconnectMessage() {
        return this.zzj;
    }

    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void getRemoteService(IAccountAccessor object, Set object2) {
        void var1_4;
        int n10;
        block16: {
            Object object3 = this.getGetServiceRequestExtraArgs();
            int n11 = this.zzy;
            GetServiceRequest getServiceRequest = new GetServiceRequest(n11);
            Object object4 = this.zzl.getPackageName();
            getServiceRequest.zza = object4;
            getServiceRequest.zzd = object3;
            if (object2 != null) {
                int n12 = object2.size();
                object3 = new Scope[n12];
                object2 = object2.toArray((T[])object3);
                getServiceRequest.zzc = object2;
            }
            if ((n10 = this.requiresSignIn()) != 0) {
                object2 = this.getAccount();
                if (object2 != null) {
                    object2 = this.getAccount();
                } else {
                    object3 = "<<default account>>";
                    object4 = "com.google";
                    object2 = new Account((String)object3, (String)object4);
                }
                getServiceRequest.zze = object2;
                if (object != null) {
                    getServiceRequest.zzb = object = object.asBinder();
                }
            } else {
                boolean bl2 = this.requiresAccount();
                if (bl2) {
                    object = this.getAccount();
                    getServiceRequest.zze = object;
                }
            }
            getServiceRequest.zzf = object = zzd;
            object = this.getApiFeatures();
            getServiceRequest.zzg = object;
            try {
                object = this.zzq;
                synchronized (object) {
                    object2 = this.zzr;
                    if (object2 == null) break block15;
                    object4 = this.zzc;
                }
            }
            catch (RuntimeException runtimeException) {
                break block16;
            }
            catch (RemoteException remoteException) {
                // empty catch block
                break block16;
            }
            catch (SecurityException securityException) {
                throw securityException;
            }
            catch (DeadObjectException deadObjectException) {
                Log.w((String)"GmsClient", (String)"IGmsServiceBroker.getService failed", (Throwable)deadObjectException);
                this.triggerConnectionSuspended(3);
                return;
            }
            {
                block17: {
                    block15: {
                        n11 = ((AtomicInteger)object4).get();
                        object3 = new BaseGmsClient$zze(this, n11);
                        object2.getService((IGmsCallbacks)object3, getServiceRequest);
                        break block17;
                    }
                    object2 = "GmsClient";
                    object3 = "mServiceBroker is null, client disconnected";
                    Log.w((String)object2, (String)object3);
                }
                return;
            }
        }
        Log.w((String)"GmsClient", (String)"IGmsServiceBroker.getService failed", (Throwable)var1_4);
        n10 = this.zzc.get();
        this.onPostInitHandler(8, null, null, n10);
    }

    public Set getScopes() {
        return Collections.emptySet();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final IInterface getService() {
        Object object = this.zzp;
        synchronized (object) {
            boolean bl2 = this.zzv;
            boolean bl3 = 5 != 0;
            if (bl2 == bl3) {
                DeadObjectException deadObjectException = new DeadObjectException();
                throw deadObjectException;
            }
            this.checkConnected();
            IInterface iInterface = this.zzs;
            if (iInterface != null) {
                bl2 = true;
            } else {
                bl2 = false;
                iInterface = null;
            }
            String string2 = "Client is connected but service is null";
            Preconditions.checkState(bl2, string2);
            return this.zzs;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public IBinder getServiceBrokerBinder() {
        Object object = this.zzq;
        synchronized (object) {
            IGmsServiceBroker iGmsServiceBroker = this.zzr;
            if (iGmsServiceBroker != null) return iGmsServiceBroker.asBinder();
            return null;
        }
    }

    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not a sign in API");
        throw unsupportedOperationException;
    }

    public abstract String getStartServiceAction();

    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public boolean getUseDynamicLookup() {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isConnected() {
        Object object = this.zzp;
        synchronized (object) {
            boolean bl2 = this.zzv;
            boolean bl3 = 4 != 0;
            if (bl2 != bl3) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isConnecting() {
        Object object = this.zzp;
        synchronized (object) {
            boolean bl2 = this.zzv;
            boolean bl3 = 2 != 0;
            if (bl2 == bl3) return true;
            bl3 = 3 != 0;
            if (bl2 != bl3) return false;
            return true;
        }
    }

    public void onConnectedLocked(IInterface iInterface) {
        long l10;
        this.zzg = l10 = System.currentTimeMillis();
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        long l10;
        int n10;
        this.zzh = n10 = connectionResult.getErrorCode();
        this.zzi = l10 = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int n10) {
        long l10;
        this.zze = n10;
        this.zzf = l10 = System.currentTimeMillis();
    }

    public void onPostInitHandler(int n10, IBinder iBinder, Bundle bundle, int n11) {
        Handler handler = this.zza;
        BaseGmsClient$zzf baseGmsClient$zzf = new BaseGmsClient$zzf(this, n10, iBinder, bundle);
        Message message = handler.obtainMessage(1, n11, -1, (Object)baseGmsClient$zzf);
        handler.sendMessage(message);
    }

    public void onSetConnectState(int n10, IInterface iInterface) {
    }

    public void onUserSignOut(BaseGmsClient$SignOutCallbacks baseGmsClient$SignOutCallbacks) {
        baseGmsClient$SignOutCallbacks.onSignOutComplete();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void triggerConnectionSuspended(int n10) {
        Handler handler = this.zza;
        int n11 = this.zzc.get();
        Message message = handler.obtainMessage(6, n11, n10);
        handler.sendMessage(message);
    }

    public void triggerNotAvailable(BaseGmsClient$ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks, int n10, PendingIntent pendingIntent) {
        this.zzb = baseGmsClient$ConnectionProgressReportCallbacks = (BaseGmsClient$ConnectionProgressReportCallbacks)Preconditions.checkNotNull(baseGmsClient$ConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        baseGmsClient$ConnectionProgressReportCallbacks = this.zza;
        int n11 = this.zzc.get();
        Message message = baseGmsClient$ConnectionProgressReportCallbacks.obtainMessage(3, n11, n10, pendingIntent);
        baseGmsClient$ConnectionProgressReportCallbacks.sendMessage(message);
    }

    public final void zza(int n10, Bundle bundle, int n11) {
        bundle = this.zza;
        BaseGmsClient$zzg baseGmsClient$zzg = new BaseGmsClient$zzg(this, n10, null);
        Message message = bundle.obtainMessage(7, n11, -1, (Object)baseGmsClient$zzg);
        bundle.sendMessage(message);
    }
}

