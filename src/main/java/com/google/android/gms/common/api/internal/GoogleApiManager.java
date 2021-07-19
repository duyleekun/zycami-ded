/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.GoogleApiManager$zab;
import com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zaaf;
import com.google.android.gms.common.api.internal.zab;
import com.google.android.gms.common.api.internal.zabi;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zae;
import com.google.android.gms.common.api.internal.zaf;
import com.google.android.gms.common.api.internal.zag;
import com.google.android.gms.common.api.internal.zah;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.api.internal.zak;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleApiManager
implements Handler.Callback {
    private static final Object lock;
    public static final Status zahx;
    private static final Status zahy;
    private static GoogleApiManager zaic;
    private final Handler handler;
    private long zahz = 5000L;
    private long zaia = 120000L;
    private long zaib = 10000L;
    private final Context zaid;
    private final GoogleApiAvailability zaie;
    private final GoogleApiAvailabilityCache zaif;
    private final AtomicInteger zaig;
    private final AtomicInteger zaih;
    private final Map zaii;
    private zaae zaij;
    private final Set zaik;
    private final Set zail;

    static {
        int n10 = 4;
        Object object = new Status(n10, "Sign-out occurred while this API call was in progress.");
        zahx = object;
        object = new Status(n10, "The user must be signed in to make this API call.");
        zahy = object;
        lock = object = new Object();
    }

    private GoogleApiManager(Context object, Looper object2, GoogleApiAvailability googleApiAvailability) {
        int n10 = 1;
        Object object3 = new AtomicInteger(n10);
        this.zaig = object3;
        object3 = new AtomicInteger(0);
        this.zaih = object3;
        super(5, 0.75f, n10);
        this.zaii = object3;
        this.zaij = null;
        this.zaik = object3 = new ArraySet();
        this.zail = object3 = new ArraySet();
        this.zaid = object;
        super((Looper)object2, this);
        this.handler = object;
        this.zaie = googleApiAvailability;
        super(googleApiAvailability);
        this.zaif = object2;
        object2 = object.obtainMessage(6);
        object.sendMessage((Message)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void reportSignOut() {
        Object object = lock;
        synchronized (object) {
            GoogleApiManager googleApiManager = zaic;
            if (googleApiManager != null) {
                AtomicInteger atomicInteger = googleApiManager.zaih;
                atomicInteger.incrementAndGet();
                googleApiManager = googleApiManager.handler;
                int n10 = 10;
                atomicInteger = googleApiManager.obtainMessage(n10);
                googleApiManager.sendMessageAtFrontOfQueue((Message)atomicInteger);
            }
            return;
        }
    }

    public static /* synthetic */ Handler zaa(GoogleApiManager googleApiManager) {
        return googleApiManager.handler;
    }

    public static /* synthetic */ Context zab(GoogleApiManager googleApiManager) {
        return googleApiManager.zaid;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static GoogleApiManager zab(Context object) {
        Object object2 = lock;
        synchronized (object2) {
            GoogleApiManager googleApiManager = zaic;
            if (googleApiManager != null) return zaic;
            Object object3 = "GoogleApiHandler";
            int n10 = 9;
            googleApiManager = new HandlerThread((String)object3, n10);
            googleApiManager.start();
            googleApiManager = googleApiManager.getLooper();
            object = object.getApplicationContext();
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            zaic = object3 = new GoogleApiManager((Context)object, (Looper)googleApiManager, googleApiAvailability);
            return zaic;
        }
    }

    private final void zab(GoogleApi object) {
        boolean bl2;
        zai zai2 = ((GoogleApi)object).zak();
        GoogleApiManager$zaa googleApiManager$zaa = (GoogleApiManager$zaa)this.zaii.get(zai2);
        if (googleApiManager$zaa == null) {
            googleApiManager$zaa = new GoogleApiManager$zaa(this, (GoogleApi)object);
            object = this.zaii;
            object.put(zai2, googleApiManager$zaa);
        }
        if (bl2 = googleApiManager$zaa.requiresSignIn()) {
            object = this.zail;
            object.add(zai2);
        }
        googleApiManager$zaa.connect();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static GoogleApiManager zabc() {
        Object object = lock;
        synchronized (object) {
            GoogleApiManager googleApiManager = zaic;
            String string2 = "Must guarantee manager is non-null before using getInstance";
            Preconditions.checkNotNull(googleApiManager, string2);
            return zaic;
        }
    }

    public static /* synthetic */ Object zabe() {
        return lock;
    }

    public static /* synthetic */ Status zabf() {
        return zahy;
    }

    public static /* synthetic */ long zac(GoogleApiManager googleApiManager) {
        return googleApiManager.zahz;
    }

    public static /* synthetic */ long zad(GoogleApiManager googleApiManager) {
        return googleApiManager.zaia;
    }

    public static /* synthetic */ GoogleApiAvailabilityCache zae(GoogleApiManager googleApiManager) {
        return googleApiManager.zaif;
    }

    public static /* synthetic */ zaae zaf(GoogleApiManager googleApiManager) {
        return googleApiManager.zaij;
    }

    public static /* synthetic */ Set zag(GoogleApiManager googleApiManager) {
        return googleApiManager.zaik;
    }

    public static /* synthetic */ GoogleApiAvailability zah(GoogleApiManager googleApiManager) {
        return googleApiManager.zaie;
    }

    public static /* synthetic */ long zai(GoogleApiManager googleApiManager) {
        return googleApiManager.zaib;
    }

    public static /* synthetic */ Map zaj(GoogleApiManager googleApiManager) {
        return googleApiManager.zaii;
    }

    public boolean handleMessage(Message object) {
        int n10 = ((Message)object).what;
        boolean bl2 = true;
        long l10 = 300000L;
        int n11 = 0;
        Object object2 = null;
        CharSequence charSequence = "GoogleApiManager";
        Object object3 = null;
        block0 : switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Unknown message id: ");
                stringBuilder.append(n10);
                object = stringBuilder.toString();
                Log.w((String)charSequence, (String)object);
                return false;
            }
            case 16: {
                object = (GoogleApiManager$zab)((Message)object).obj;
                Object object4 = this.zaii;
                zai zai2 = GoogleApiManager$zab.zac((GoogleApiManager$zab)object);
                n10 = (int)(object4.containsKey(zai2) ? 1 : 0);
                if (n10 == 0) break;
                object4 = this.zaii;
                zai2 = GoogleApiManager$zab.zac((GoogleApiManager$zab)object);
                object4 = (GoogleApiManager$zaa)object4.get(zai2);
                GoogleApiManager$zaa.zab((GoogleApiManager$zaa)object4, (GoogleApiManager$zab)object);
                break;
            }
            case 15: {
                object = (GoogleApiManager$zab)((Message)object).obj;
                Object object5 = this.zaii;
                zai zai3 = GoogleApiManager$zab.zac((GoogleApiManager$zab)object);
                n10 = (int)(object5.containsKey(zai3) ? 1 : 0);
                if (n10 == 0) break;
                object5 = this.zaii;
                zai3 = GoogleApiManager$zab.zac((GoogleApiManager$zab)object);
                object5 = (GoogleApiManager$zaa)object5.get(zai3);
                GoogleApiManager$zaa.zaa((GoogleApiManager$zaa)object5, (GoogleApiManager$zab)object);
                break;
            }
            case 14: {
                object = (zaaf)((Message)object).obj;
                Object object6 = ((zaaf)object).zak();
                Map map = this.zaii;
                boolean bl3 = map.containsKey(object6);
                if (!bl3) {
                    object = ((zaaf)object).zaal();
                    object6 = Boolean.FALSE;
                    ((TaskCompletionSource)object).setResult(object6);
                    break;
                }
                map = this.zaii;
                n10 = (int)(GoogleApiManager$zaa.zaa((GoogleApiManager$zaa)map.get(object6), false) ? 1 : 0);
                object = ((zaaf)object).zaal();
                object6 = n10 != 0;
                ((TaskCompletionSource)object).setResult(object6);
                break;
            }
            case 12: {
                Map map = this.zaii;
                Object object7 = ((Message)object).obj;
                n10 = (int)(map.containsKey(object7) ? 1 : 0);
                if (n10 == 0) break;
                map = this.zaii;
                object = ((Message)object).obj;
                object = (GoogleApiManager$zaa)map.get(object);
                ((GoogleApiManager$zaa)object).zabp();
                break;
            }
            case 11: {
                Map map = this.zaii;
                Object object8 = ((Message)object).obj;
                n10 = (int)(map.containsKey(object8) ? 1 : 0);
                if (n10 == 0) break;
                map = this.zaii;
                object = ((Message)object).obj;
                object = (GoogleApiManager$zaa)map.get(object);
                ((GoogleApiManager$zaa)object).zaav();
                break;
            }
            case 10: {
                object = this.zail.iterator();
                while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    Object object9 = (zai)object.next();
                    Map map = this.zaii;
                    object9 = (GoogleApiManager$zaa)map.remove(object9);
                    ((GoogleApiManager$zaa)object9).zabj();
                }
                object = this.zail;
                object.clear();
                break;
            }
            case 9: {
                Map map = this.zaii;
                Object object10 = ((Message)object).obj;
                n10 = (int)(map.containsKey(object10) ? 1 : 0);
                if (n10 == 0) break;
                map = this.zaii;
                object = ((Message)object).obj;
                object = (GoogleApiManager$zaa)map.get(object);
                ((GoogleApiManager$zaa)object).resume();
                break;
            }
            case 7: {
                object = (GoogleApi)((Message)object).obj;
                this.zab((GoogleApi)object);
                break;
            }
            case 6: {
                boolean bl4 = PlatformVersion.isAtLeastIceCreamSandwich();
                if (!bl4 || !(bl4 = (object = this.zaid.getApplicationContext()) instanceof Application)) break;
                BackgroundDetector.initialize((Application)this.zaid.getApplicationContext());
                object = BackgroundDetector.getInstance();
                zabi zabi2 = new zabi(this);
                ((BackgroundDetector)object).addListener(zabi2);
                object = BackgroundDetector.getInstance();
                bl4 = ((BackgroundDetector)object).readCurrentStateIfPossible(bl2);
                if (bl4) break;
                this.zaib = l10;
                break;
            }
            case 5: {
                Object object11;
                boolean bl5;
                n10 = ((Message)object).arg1;
                object = (ConnectionResult)((Message)object).obj;
                Object object12 = this.zaii.values().iterator();
                while (bl5 = object12.hasNext()) {
                    object11 = (GoogleApiManager$zaa)object12.next();
                    n11 = ((GoogleApiManager$zaa)object11).getInstanceId();
                    if (n11 != n10) continue;
                    object3 = object11;
                    break;
                }
                if (object3 != null) {
                    int n12 = 17;
                    object11 = this.zaie;
                    n11 = ((ConnectionResult)object).getErrorCode();
                    object11 = ((GoogleApiAvailability)object11).getErrorString(n11);
                    object = ((ConnectionResult)object).getErrorMessage();
                    n11 = String.valueOf(object11).length() + 69;
                    int n13 = String.valueOf(object).length();
                    charSequence = new StringBuilder(n11 += n13);
                    object2 = "Error resolution was canceled by the user, original error message: ";
                    ((StringBuilder)charSequence).append((String)object2);
                    ((StringBuilder)charSequence).append((String)object11);
                    object11 = ": ";
                    ((StringBuilder)charSequence).append((String)object11);
                    ((StringBuilder)charSequence).append((String)object);
                    object = ((StringBuilder)charSequence).toString();
                    Status status = new Status(n12, (String)object);
                    ((GoogleApiManager$zaa)object3).zac(status);
                    break;
                }
                int n14 = 76;
                object12 = new StringBuilder(n14);
                ((StringBuilder)object12).append("Could not find API instance ");
                ((StringBuilder)object12).append(n10);
                ((StringBuilder)object12).append(" while trying to fail enqueued calls.");
                object = ((StringBuilder)object12).toString();
                Exception exception = new Exception();
                Log.wtf((String)charSequence, (String)object, (Throwable)exception);
                break;
            }
            case 4: 
            case 8: 
            case 13: {
                int n15;
                int n16;
                object = (zabv)((Message)object).obj;
                Object object13 = this.zaii;
                Object object14 = ((zabv)object).zajt.zak();
                object13 = (GoogleApiManager$zaa)object13.get(object14);
                if (object13 == null) {
                    object13 = ((zabv)object).zajt;
                    this.zab((GoogleApi)object13);
                    object13 = this.zaii;
                    object14 = ((zabv)object).zajt.zak();
                    object13 = (GoogleApiManager$zaa)object13.get(object14);
                }
                if ((n16 = ((GoogleApiManager$zaa)object13).requiresSignIn()) != 0 && (n16 = ((AtomicInteger)(object14 = this.zaih)).get()) != (n15 = ((zabv)object).zajs)) {
                    object = ((zabv)object).zajr;
                    object14 = zahx;
                    ((zab)object).zaa((Status)object14);
                    ((GoogleApiManager$zaa)object13).zabj();
                    break;
                }
                object = ((zabv)object).zajr;
                ((GoogleApiManager$zaa)object13).zaa((zab)object);
                break;
            }
            case 3: {
                object = this.zaii.values().iterator();
                while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    GoogleApiManager$zaa googleApiManager$zaa = (GoogleApiManager$zaa)object.next();
                    googleApiManager$zaa.zabl();
                    googleApiManager$zaa.connect();
                }
                break;
            }
            case 2: {
                boolean bl6;
                object = (zak)((Message)object).obj;
                Object object15 = ((zak)object).zap().iterator();
                while (bl6 = object15.hasNext()) {
                    zai zai4 = (zai)object15.next();
                    Object object16 = (GoogleApiManager$zaa)this.zaii.get(zai4);
                    if (object16 == null) {
                        int n17 = 13;
                        object15 = new ConnectionResult(n17);
                        ((zak)object).zaa(zai4, (ConnectionResult)object15, null);
                        break block0;
                    }
                    n11 = (int)(((GoogleApiManager$zaa)object16).isConnected() ? 1 : 0);
                    if (n11 != 0) {
                        object2 = ConnectionResult.RESULT_SUCCESS;
                        object16 = ((GoogleApiManager$zaa)object16).zaab().getEndpointPackageName();
                        ((zak)object).zaa(zai4, (ConnectionResult)object2, (String)object16);
                        continue;
                    }
                    object2 = ((GoogleApiManager$zaa)object16).zabm();
                    if (object2 != null) {
                        object16 = ((GoogleApiManager$zaa)object16).zabm();
                        ((zak)object).zaa(zai4, (ConnectionResult)object16, null);
                        continue;
                    }
                    ((GoogleApiManager$zaa)object16).zaa((zak)object);
                    ((GoogleApiManager$zaa)object16).connect();
                }
                break;
            }
            case 1: {
                boolean bl7;
                object = (Boolean)((Message)object).obj;
                boolean bl8 = (Boolean)object;
                if (bl8) {
                    l10 = 10000L;
                }
                this.zaib = l10;
                object = this.handler;
                n10 = 12;
                object.removeMessages(n10);
                object = this.zaii.keySet().iterator();
                while (bl7 = object.hasNext()) {
                    zai zai5 = (zai)object.next();
                    Handler handler = this.handler;
                    zai5 = handler.obtainMessage(n10, (Object)zai5);
                    long l11 = this.zaib;
                    handler.sendMessageDelayed((Message)zai5, l11);
                }
                break block0;
            }
        }
        return bl2;
    }

    public final void maybeSignOut() {
        this.zaih.incrementAndGet();
        Handler handler = this.handler;
        Message message = handler.obtainMessage(10);
        handler.sendMessage(message);
    }

    public final PendingIntent zaa(zai object, int n10) {
        object = (GoogleApiManager$zaa)this.zaii.get(object);
        Context context = null;
        if (object == null) {
            return null;
        }
        if ((object = ((GoogleApiManager$zaa)object).zabq()) == null) {
            return null;
        }
        context = this.zaid;
        object = object.getSignInIntent();
        return PendingIntent.getActivity((Context)context, (int)n10, (Intent)object, (int)0x8000000);
    }

    public final Task zaa(GoogleApi googleApi, ListenerHolder$ListenerKey listenerHolder$ListenerKey) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zah zah2 = new zah(listenerHolder$ListenerKey, taskCompletionSource);
        listenerHolder$ListenerKey = this.handler;
        int n10 = this.zaih.get();
        zabv zabv2 = new zabv(zah2, n10, googleApi);
        googleApi = listenerHolder$ListenerKey.obtainMessage(13, zabv2);
        listenerHolder$ListenerKey.sendMessage((Message)googleApi);
        return taskCompletionSource.getTask();
    }

    public final Task zaa(GoogleApi googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod object) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zabw zabw2 = new zabw(registerListenerMethod, (UnregisterListenerMethod)object);
        zaf zaf2 = new zaf(zabw2, taskCompletionSource);
        registerListenerMethod = this.handler;
        int n10 = this.zaih.get();
        object = new zabv(zaf2, n10, googleApi);
        googleApi = registerListenerMethod.obtainMessage(8, object);
        registerListenerMethod.sendMessage((Message)googleApi);
        return taskCompletionSource.getTask();
    }

    public final Task zaa(Iterable iterable) {
        zak zak2 = new zak(iterable);
        iterable = this.handler;
        Message message = iterable.obtainMessage(2, zak2);
        iterable.sendMessage(message);
        return zak2.getTask();
    }

    public final void zaa(ConnectionResult connectionResult, int n10) {
        boolean bl2 = this.zac(connectionResult, n10);
        if (!bl2) {
            Handler handler = this.handler;
            int n11 = 5;
            connectionResult = handler.obtainMessage(n11, n10, 0, (Object)connectionResult);
            handler.sendMessage((Message)connectionResult);
        }
    }

    public final void zaa(GoogleApi googleApi) {
        Handler handler = this.handler;
        googleApi = handler.obtainMessage(7, (Object)googleApi);
        handler.sendMessage((Message)googleApi);
    }

    public final void zaa(GoogleApi googleApi, int n10, BaseImplementation$ApiMethodImpl object) {
        zae zae2 = new zae(n10, (BaseImplementation$ApiMethodImpl)object);
        Handler handler = this.handler;
        int n11 = this.zaih.get();
        object = new zabv(zae2, n11, googleApi);
        googleApi = handler.obtainMessage(4, object);
        handler.sendMessage((Message)googleApi);
    }

    public final void zaa(GoogleApi googleApi, int n10, TaskApiCall object, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zag zag2 = new zag(n10, (TaskApiCall)object, taskCompletionSource, statusExceptionMapper);
        Handler handler = this.handler;
        int n11 = this.zaih.get();
        object = new zabv(zag2, n11, googleApi);
        googleApi = handler.obtainMessage(4, object);
        handler.sendMessage((Message)googleApi);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zaa(zaae object) {
        Object object2 = lock;
        synchronized (object2) {
            Object object3 = this.zaij;
            if (object3 != object) {
                this.zaij = object;
                object3 = this.zaik;
                object3.clear();
            }
            object3 = this.zaik;
            object = ((zaae)object).zaaj();
            object3.addAll(object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zab(zaae object) {
        Object object2 = lock;
        synchronized (object2) {
            zaae zaae2 = this.zaij;
            if (zaae2 == object) {
                object = null;
                this.zaij = null;
                object = this.zaik;
                object.clear();
            }
            return;
        }
    }

    public final int zabd() {
        return this.zaig.getAndIncrement();
    }

    public final Task zac(GoogleApi object) {
        object = ((GoogleApi)object).zak();
        zaaf zaaf2 = new zaaf((zai)object);
        object = this.handler;
        Message message = object.obtainMessage(14, (Object)zaaf2);
        object.sendMessage(message);
        return zaaf2.zaal().getTask();
    }

    public final boolean zac(ConnectionResult connectionResult, int n10) {
        GoogleApiAvailability googleApiAvailability = this.zaie;
        Context context = this.zaid;
        return googleApiAvailability.zaa(context, connectionResult, n10);
    }

    public final void zao() {
        Handler handler = this.handler;
        Message message = handler.obtainMessage(3);
        handler.sendMessage(message);
    }
}

