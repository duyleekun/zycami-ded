/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.location.Location
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.Log
 *  android.webkit.WebView
 */
package com.baidu.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient$a;
import com.baidu.location.LocationClient$b;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b;
import com.baidu.location.b.d;
import com.baidu.location.b.d$a;
import com.baidu.location.b.n;
import com.baidu.location.c;
import com.baidu.location.d.a;
import com.baidu.location.f;
import com.baidu.location.h.l;
import java.util.ArrayList;
import java.util.Iterator;

public final class LocationClient
implements d$a {
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = 255;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
    private Boolean A;
    private Boolean B;
    private Boolean C;
    private boolean D;
    private d E;
    private boolean F;
    private boolean G;
    private boolean H;
    private ServiceConnection I;
    private long a;
    private String b;
    private LocationClientOption c;
    private LocationClientOption d;
    private boolean e;
    private Context f;
    private Messenger g;
    private LocationClient$a h;
    private final Messenger i;
    private ArrayList j;
    private ArrayList k;
    private BDLocation l;
    private boolean m;
    private boolean n;
    private boolean o;
    private LocationClient$b p;
    private boolean q;
    private final Object r;
    private long s;
    private long t;
    private a u;
    private BDLocationListener v;
    private String w;
    private String x;
    private boolean y;
    private boolean z;

    public LocationClient(Context object) {
        Object object2;
        LocationClientOption locationClientOption;
        long l10;
        this.a = l10 = 0L;
        this.b = null;
        this.c = locationClientOption = new LocationClientOption();
        this.d = locationClientOption = new LocationClientOption();
        this.e = false;
        this.f = null;
        this.g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = null;
        this.q = false;
        this.r = object2 = new Object();
        this.s = l10;
        this.t = l10;
        this.u = null;
        this.v = null;
        this.w = null;
        this.y = false;
        this.z = true;
        Object object3 = Boolean.FALSE;
        this.A = object3;
        this.B = object3;
        object3 = Boolean.TRUE;
        this.C = object3;
        this.E = null;
        this.F = false;
        this.G = false;
        this.H = false;
        object3 = new b(this);
        this.I = object3;
        this.f = object;
        this.c = object;
        object3 = Looper.getMainLooper();
        super((Looper)object3, this);
        this.h = object;
        object3 = this.h;
        super((Handler)object3);
        this.i = object;
    }

    public LocationClient(Context object, LocationClientOption object2) {
        Object object3;
        LocationClientOption locationClientOption;
        long l10;
        this.a = l10 = 0L;
        this.b = null;
        this.c = locationClientOption = new LocationClientOption();
        this.d = locationClientOption = new LocationClientOption();
        this.e = false;
        this.f = null;
        this.g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = null;
        this.q = false;
        this.r = object3 = new Object();
        this.s = l10;
        this.t = l10;
        this.u = null;
        this.v = null;
        this.w = null;
        this.y = false;
        this.z = true;
        Object object4 = Boolean.FALSE;
        this.A = object4;
        this.B = object4;
        object4 = Boolean.TRUE;
        this.C = object4;
        this.E = null;
        this.F = false;
        this.G = false;
        this.H = false;
        object4 = new b(this);
        this.I = object4;
        this.f = object;
        this.c = object2;
        super((LocationClientOption)object2);
        this.d = object;
        object2 = Looper.getMainLooper();
        super((Looper)object2, this);
        this.h = object;
        object2 = this.h;
        super((Handler)object2);
        this.i = object;
    }

    public static /* synthetic */ Messenger a(LocationClient locationClient) {
        return locationClient.g;
    }

    public static /* synthetic */ Messenger a(LocationClient locationClient, Messenger messenger) {
        locationClient.g = messenger;
        return messenger;
    }

    public static /* synthetic */ LocationClient$b a(LocationClient locationClient, LocationClient$b locationClient$b) {
        locationClient.p = locationClient$b;
        return locationClient$b;
    }

    public static /* synthetic */ d a(LocationClient locationClient, d d10) {
        locationClient.E = d10;
        return d10;
    }

    private void a() {
        int n10 = 28;
        Message message = Message.obtain(null, (int)n10);
        Messenger messenger = this.i;
        message.replyTo = messenger;
        messenger = this.g;
        try {
            messenger.send(message);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10, Notification object) {
        try {
            Context context = this.f;
            Class<f> clazz = f.class;
            Intent intent = new Intent(context, clazz);
            String string2 = "notification";
            intent.putExtra(string2, (Parcelable)object);
            String string3 = "id";
            intent.putExtra(string3, n10);
            String string4 = "command";
            int n11 = 1;
            intent.putExtra(string4, n11);
            n10 = Build.VERSION.SDK_INT;
            int n12 = 26;
            if (n10 >= n12) {
                string4 = this.f;
                string4.startForegroundService(intent);
            } else {
                string4 = this.f;
                string4.startService(intent);
            }
            this.H = n11;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void a(Message object) {
        if (object != null && (object = object.obj) != null) {
            object = (BDNotifyListener)object;
            a a10 = this.u;
            if (a10 == null) {
                Context context = this.f;
                this.u = a10 = new a(context, this);
            }
            a10 = this.u;
            a10.a((BDNotifyListener)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Message object, int n10) {
        int n11 = this.e;
        if (n11 == 0) {
            return;
        }
        try {
            object = object.getData();
            Object object2 = BDLocation.class;
            object2 = ((Class)object2).getClassLoader();
            object.setClassLoader((ClassLoader)object2);
            object2 = "locStr";
            object = object.getParcelable((String)object2);
            this.l = object = (BDLocation)object;
            int n12 = ((BDLocation)object).getLocType();
            n11 = 61;
            if (n12 == n11) {
                long l10;
                this.s = l10 = System.currentTimeMillis();
            }
            if ((n12 = ((BDLocation)(object = this.l)).getLocType()) == n11 || (n12 = ((BDLocation)(object = this.l)).getLocType()) == (n11 = 161)) {
                com.baidu.location.b.a a10 = com.baidu.location.b.a.a();
                object = this.l;
                double d10 = ((BDLocation)object).getLatitude();
                object = this.l;
                double d11 = ((BDLocation)object).getLongitude();
                object = this.l;
                String string2 = ((BDLocation)object).getCoorType();
                a10.a(d10, d11, string2);
            }
            this.b(n10);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void a(BDLocation bDLocation) {
        Iterator iterator2;
        Object object;
        int n10;
        int n11 = this.z;
        if (n11 != 0) {
            return;
        }
        this.l = bDLocation;
        n11 = this.G;
        if (n11 == 0 && (n11 = bDLocation.getLocType()) == (n10 = 161)) {
            n11 = 1;
            this.F = n11;
            object = com.baidu.location.b.a.a();
            double d10 = bDLocation.getLatitude();
            double d11 = bDLocation.getLongitude();
            String string2 = bDLocation.getCoorType();
            ((com.baidu.location.b.a)object).a(d10, d11, string2);
        }
        if ((iterator2 = this.j) != null) {
            iterator2 = ((ArrayList)((Object)iterator2)).iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object = (BDLocationListener)iterator2.next();
                object.onReceiveLocation(bDLocation);
            }
        }
        if ((iterator2 = this.k) != null) {
            iterator2 = ((ArrayList)((Object)iterator2)).iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object = (BDAbstractLocationListener)iterator2.next();
                ((BDAbstractLocationListener)object).onReceiveLocation(bDLocation);
            }
        }
    }

    public static /* synthetic */ void a(LocationClient locationClient, int n10, Notification notification) {
        locationClient.a(n10, notification);
    }

    public static /* synthetic */ void a(LocationClient locationClient, Message message) {
        locationClient.c(message);
    }

    public static /* synthetic */ void a(LocationClient locationClient, Message message, int n10) {
        locationClient.a(message, n10);
    }

    public static /* synthetic */ void a(LocationClient locationClient, BDLocation bDLocation) {
        locationClient.a(bDLocation);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(boolean bl2) {
        Class<f> clazz;
        Context context;
        try {
            context = this.f;
            clazz = f.class;
        }
        catch (Exception exception) {
            return;
        }
        Intent intent = new Intent(context, clazz);
        String string2 = "removenotify";
        intent.putExtra(string2, bl2);
        String string3 = "command";
        int n10 = 2;
        intent.putExtra(string3, n10);
        string3 = this.f;
        string3.startService(intent);
        bl2 = true;
        this.H = bl2;
    }

    private boolean a(int n10) {
        boolean bl2;
        Messenger messenger = this.g;
        if (messenger != null && (bl2 = this.e)) {
            Message message;
            bl2 = false;
            messenger = null;
            try {
                message = Message.obtain(null, (int)n10);
            }
            catch (Exception exception) {}
            messenger = this.g;
            messenger.send(message);
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean a(LocationClient locationClient, boolean bl2) {
        locationClient.e = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b() {
        boolean bl2;
        Object object;
        int n10 = (int)(this.e ? 1 : 0);
        int n11 = 1;
        if (n10 == n11) {
            return;
        }
        Object object2 = this.C;
        n10 = ((Boolean)object2).booleanValue();
        if (n10 != 0) {
            object2 = this.f;
            n10 = com.baidu.location.h.l.d((Context)object2);
            object = this.d;
            bl2 = ((LocationClientOption)object).isOnceLocation();
            if (bl2) {
                n10 = n11;
            }
            if (n10 != 0) {
                try {
                    object2 = new c(this);
                    ((Thread)object2).start();
                }
                catch (Throwable throwable) {}
            }
        }
        if ((n10 = ((LocationClientOption)(object2 = this.d)).isOnceLocation()) != 0) {
            return;
        }
        this.C = object2 = Boolean.FALSE;
        this.b = object2 = this.f.getPackageName();
        object2 = new StringBuilder();
        object = this.b;
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("_bdls_v2.9");
        this.w = object2 = ((StringBuilder)object2).toString();
        object = this.f;
        Object object3 = f.class;
        object2 = new Intent((Context)object, object3);
        object = "debug_dev";
        try {
            boolean bl3 = this.D;
            object2.putExtra((String)object, bl3);
        }
        catch (Exception exception) {}
        if ((object = this.c) == null) {
            this.c = object = new LocationClientOption();
        }
        bl2 = this.c.isIgnoreCacheException;
        object2.putExtra("cache_exception", bl2);
        object = this.c;
        bl2 = ((LocationClientOption)object).isIgnoreKillProcess;
        object3 = "kill_process";
        object2.putExtra((String)object3, bl2);
        try {
            object = this.f;
            object3 = this.I;
            object.bindService((Intent)object2, (ServiceConnection)object3, n11);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            n10 = 0;
            object2 = null;
            this.e = false;
        }
    }

    private void b(int n10) {
        block10: {
            BDLocation bDLocation;
            Object object;
            int n11;
            int n12;
            int n13;
            Object object2;
            block9: {
                object2 = this.l.getCoorType();
                if (object2 == null) {
                    object2 = this.l;
                    String string2 = this.c.coorType;
                    ((BDLocation)object2).setCoorType(string2);
                }
                n10 = (int)(this.m ? 1 : 0);
                n13 = 67;
                n12 = 66;
                n11 = 1;
                if (n10 == n11) break block9;
                object2 = this.c;
                n10 = (int)(((LocationClientOption)object2).location_change_notify ? 1 : 0);
                if ((n10 != n11 || (n10 = ((BDLocation)(object2 = this.l)).getLocType()) != (n11 = 61)) && (n10 = ((BDLocation)(object2 = this.l)).getLocType()) != n12 && (n10 = ((BDLocation)(object2 = this.l)).getLocType()) != n13 && (n10 = (int)(this.y ? 1 : 0)) == 0 && (n10 = ((BDLocation)(object2 = this.l)).getLocType()) != (n11 = 161)) break block10;
            }
            if ((object2 = this.j) != null) {
                object2 = ((ArrayList)object2).iterator();
                while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    object = (BDLocationListener)object2.next();
                    bDLocation = this.l;
                    object.onReceiveLocation(bDLocation);
                }
            }
            if ((object2 = this.k) != null) {
                object2 = ((ArrayList)object2).iterator();
                while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    object = (BDAbstractLocationListener)object2.next();
                    bDLocation = this.l;
                    ((BDAbstractLocationListener)object).onReceiveLocation(bDLocation);
                }
            }
            if ((n10 = ((BDLocation)(object2 = this.l)).getLocType()) != n12 && (n10 = ((BDLocation)(object2 = this.l)).getLocType()) != n13) {
                long l10;
                n10 = 0;
                object2 = null;
                this.m = false;
                this.t = l10 = System.currentTimeMillis();
            }
        }
    }

    private void b(Message object) {
        if (object != null && (object = object.obj) != null) {
            object = (BDNotifyListener)object;
            a a10 = this.u;
            if (a10 != null) {
                a10.c((BDNotifyListener)object);
            }
        }
    }

    public static /* synthetic */ void b(LocationClient locationClient, Message message) {
        locationClient.d(message);
    }

    public static /* synthetic */ boolean b(LocationClient locationClient) {
        return locationClient.z;
    }

    public static /* synthetic */ boolean b(LocationClient locationClient, boolean bl2) {
        locationClient.o = bl2;
        return bl2;
    }

    public static /* synthetic */ LocationClient$a c(LocationClient locationClient) {
        return locationClient.h;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        Object object;
        Object object2;
        Object object3;
        block16: {
            int n10 = this.e;
            if (n10 == 0) return;
            Messenger messenger = this.g;
            if (messenger == null) {
                return;
            }
            n10 = 12;
            messenger = Message.obtain(null, (int)n10);
            object3 = this.i;
            messenger.replyTo = object3;
            try {
                object3 = this.g;
                object3.send((Message)messenger);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            n10 = 0;
            messenger = null;
            try {
                object3 = this.f;
                object2 = this.I;
                object3.unbindService(object2);
                boolean bl2 = this.H;
                if (!bl2) break block16;
            }
            catch (Exception exception) {}
            try {
                object2 = this.f;
                object = f.class;
                object3 = new Intent((Context)object2, (Class)object);
                object2 = this.f;
                object2.stopService((Intent)object3);
            }
            catch (Exception exception) {}
            this.H = false;
        }
        object3 = this.r;
        synchronized (object3) {
            Throwable throwable2;
            block18: {
                try {
                    boolean bl3 = this.o;
                    boolean bl4 = true;
                    if (bl3 == bl4) {
                        object2 = this.h;
                        object = this.p;
                        object2.removeCallbacks((Runnable)object);
                        this.o = false;
                    }
                }
                catch (Throwable throwable2) {
                    break block18;
                }
                catch (Exception exception) {}
                {
                    // MONITOREXIT @DISABLED, blocks:[5, 7] lbl52 : MonitorExitStatement: MONITOREXIT : var3_5
                    object3 = this.u;
                    if (object3 != null) {
                        ((a)object3).a();
                    }
                    this.g = null;
                    this.n = false;
                    this.y = false;
                    this.e = false;
                    this.F = false;
                    this.G = false;
                    return;
                }
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void c(Message object) {
        int n10 = 0;
        Object object2 = null;
        this.n = false;
        if (object == null) return;
        object = object.obj;
        if (object == null) {
            return;
        }
        Object object3 = this.c;
        int n11 = ((LocationClientOption)object3).optionEquals((LocationClientOption)(object = (LocationClientOption)object));
        if (n11 != 0) return;
        object3 = this.c;
        n11 = ((LocationClientOption)object3).scanSpan;
        int n12 = object.scanSpan;
        if (n11 != n12) {
            Object object4;
            try {
                object3 = this.r;
                // MONITORENTER : object3
            }
            catch (Exception exception) {}
            n12 = (int)(this.o ? 1 : 0);
            int n13 = 1;
            if (n12 == n13) {
                object4 = this.h;
                LocationClient$b locationClient$b = this.p;
                object4.removeCallbacks(locationClient$b);
                this.o = false;
            }
            if ((n10 = object.scanSpan) >= (n12 = 1000) && (n10 = (int)(this.o ? 1 : 0)) == 0) {
                object2 = this.p;
                if (object2 == null) {
                    object2 = new LocationClient$b(this, null);
                    this.p = object2;
                }
                object2 = this.h;
                object4 = this.p;
                int n14 = object.scanSpan;
                long l10 = n14;
                object2.postDelayed((Runnable)object4, l10);
                this.o = n13;
            }
            // MONITOREXIT : object3
        }
        object2 = new LocationClientOption((LocationClientOption)object);
        this.c = object2;
        object = this.g;
        if (object == null) {
            return;
        }
        int n15 = 15;
        try {
            object = Message.obtain(null, (int)n15);
            object2 = this.i;
            object.replyTo = object2;
            object2 = this.d();
            object.setData((Bundle)object2);
            object2 = this.g;
            object2.send(object);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static /* synthetic */ void c(LocationClient locationClient, Message message) {
        locationClient.e(message);
    }

    public static /* synthetic */ boolean c(LocationClient locationClient, boolean bl2) {
        locationClient.q = bl2;
        return bl2;
    }

    private Bundle d() {
        LocationClientOption locationClientOption = this.c;
        if (locationClientOption == null) {
            return null;
        }
        locationClientOption = new Bundle();
        String string2 = this.b;
        locationClientOption.putString("packName", string2);
        string2 = this.c.prodName;
        locationClientOption.putString("prodName", string2);
        string2 = this.c.coorType;
        locationClientOption.putString("coorType", string2);
        string2 = this.c.addrType;
        locationClientOption.putString("addrType", string2);
        int n10 = this.c.openGps;
        locationClientOption.putBoolean("openGPS", n10 != 0);
        n10 = this.c.location_change_notify;
        locationClientOption.putBoolean("location_change_notify", n10 != 0);
        n10 = this.c.scanSpan;
        locationClientOption.putInt("scanSpan", n10);
        n10 = (int)(this.c.enableSimulateGps ? 1 : 0);
        locationClientOption.putBoolean("enableSimulateGps", n10 != 0);
        double d10 = this.c.judgeMockDisValue;
        locationClientOption.putDouble("judgeMockDisValue", d10);
        n10 = this.c.isNeedRealLocWhenIsMock;
        locationClientOption.putBoolean("isNeedRealLocWhenIsMock", n10 != 0);
        n10 = this.c.timeOut;
        locationClientOption.putInt("timeOut", n10);
        n10 = this.c.priority;
        locationClientOption.putInt("priority", n10);
        n10 = (int)(this.A.booleanValue() ? 1 : 0);
        locationClientOption.putBoolean("map", n10 != 0);
        n10 = this.B.booleanValue();
        locationClientOption.putBoolean("import", n10 != 0);
        n10 = this.c.mIsNeedDeviceDirect;
        locationClientOption.putBoolean("needDirect", n10 != 0);
        n10 = this.c.isNeedAptag;
        locationClientOption.putBoolean("isneedaptag", n10 != 0);
        n10 = this.c.isNeedPoiRegion;
        locationClientOption.putBoolean("isneedpoiregion", n10 != 0);
        n10 = this.c.isNeedRegular;
        locationClientOption.putBoolean("isneedregular", n10 != 0);
        n10 = this.c.isNeedAptagd;
        locationClientOption.putBoolean("isneedaptagd", n10 != 0);
        n10 = this.c.isNeedAltitude;
        locationClientOption.putBoolean("isneedaltitude", n10 != 0);
        n10 = this.c.isNeedNewVersionRgc;
        locationClientOption.putBoolean("isneednewrgc", n10 != 0);
        n10 = this.c.a();
        locationClientOption.putInt("autoNotifyMaxInterval", n10);
        n10 = this.c.getAutoNotifyMinTimeInterval();
        locationClientOption.putInt("autoNotifyMinTimeInterval", n10);
        n10 = this.c.getAutoNotifyMinDistance();
        locationClientOption.putInt("autoNotifyMinDistance", n10);
        float f10 = this.c.b();
        locationClientOption.putFloat("autoNotifyLocSensitivity", f10);
        n10 = this.c.wifiCacheTimeOut;
        locationClientOption.putInt("wifitimeout", n10);
        n10 = com.baidu.location.b.a.a().b;
        locationClientOption.putInt("wfnum", n10);
        n10 = (int)(com.baidu.location.b.a.a().a ? 1 : 0);
        locationClientOption.putBoolean("ischeckper", n10 != 0);
        f10 = (float)com.baidu.location.b.a.a().c;
        locationClientOption.putFloat("wfsm", f10);
        d10 = com.baidu.location.b.a.a().f;
        locationClientOption.putDouble("gnmcrm", d10);
        n10 = com.baidu.location.b.a.a().g;
        locationClientOption.putInt("gnmcon", n10);
        n10 = com.baidu.location.b.a.a().e;
        locationClientOption.putInt("lpcs", n10);
        return locationClientOption;
    }

    public static /* synthetic */ Messenger d(LocationClient locationClient) {
        return locationClient.i;
    }

    private void d(Message object) {
        if (object != null && (object = object.obj) != null) {
            object = (BDLocationListener)object;
            this.v = object;
        }
    }

    public static /* synthetic */ void d(LocationClient locationClient, Message message) {
        locationClient.h(message);
    }

    public static /* synthetic */ boolean d(LocationClient locationClient, boolean bl2) {
        locationClient.G = bl2;
        return bl2;
    }

    public static /* synthetic */ Bundle e(LocationClient locationClient) {
        return locationClient.d();
    }

    private void e() {
        Messenger messenger = this.g;
        if (messenger == null) {
            return;
        }
        int n10 = 22;
        messenger = Message.obtain(null, (int)n10);
        Messenger messenger2 = this.i;
        messenger.replyTo = messenger2;
        messenger2 = this.g;
        try {
            messenger2.send((Message)messenger);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void e(Message object) {
        if (object != null && (object = object.obj) != null) {
            boolean bl2;
            object = (BDLocationListener)object;
            ArrayList arrayList = this.j;
            if (arrayList == null) {
                this.j = arrayList = new ArrayList();
            }
            if (!(bl2 = (arrayList = this.j).contains(object))) {
                arrayList = this.j;
                arrayList.add(object);
            }
        }
    }

    public static /* synthetic */ void e(LocationClient locationClient, Message message) {
        locationClient.f(message);
    }

    public static /* synthetic */ void e(LocationClient locationClient, boolean bl2) {
        locationClient.a(bl2);
    }

    public static /* synthetic */ LocationClientOption f(LocationClient locationClient) {
        return locationClient.c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f() {
        LocationClientOption locationClientOption;
        int n10;
        Object object;
        int n11;
        LocationClient$a locationClient$a;
        boolean bl2;
        Object object2;
        block11: {
            long l10;
            Object object3;
            block12: {
                object2 = this.g;
                if (object2 == null) {
                    return;
                }
                long l11 = System.currentTimeMillis();
                long l12 = this.s;
                l11 -= l12;
                l12 = 3000L;
                object3 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                bl2 = true;
                locationClient$a = null;
                if (object3 <= 0 && ((object2 = this.c) == null || (object3 = (Object)object2.location_change_notify) != false) && (object3 = (Object)this.n) == false) break block11;
                object3 = this.y;
                if (object3 == false) break block12;
                l10 = System.currentTimeMillis();
                long l13 = this.t;
                long l14 = (l10 -= l13) - (l13 = 20000L);
                object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object3 <= 0 && (object3 = (Object)this.n) == false) break block11;
            }
            object3 = 22;
            object2 = Message.obtain(null, (int)object3);
            n11 = this.n;
            if (n11 != 0) {
                object = new Bundle();
                boolean bl3 = this.n;
                object.putBoolean("isWaitingLocTag", bl3);
                n10 = 0;
                locationClientOption = null;
                this.n = false;
                object2.setData((Bundle)object);
            }
            try {
                object = this.i;
                object2.replyTo = object;
                object = this.g;
                object.send((Message)object2);
                this.a = l10 = System.currentTimeMillis();
                this.m = bl2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        object2 = this.r;
        synchronized (object2) {
            object = this.c;
            if (object != null && (n11 = ((LocationClientOption)object).scanSpan) >= (n10 = 1000) && (n11 = (int)(this.o ? 1 : 0)) == 0) {
                object = this.p;
                if (object == null) {
                    this.p = object = new LocationClient$b(this, null);
                }
                locationClient$a = this.h;
                object = this.p;
                locationClientOption = this.c;
                n10 = locationClientOption.scanSpan;
                long l15 = n10;
                locationClient$a.postDelayed((Runnable)object, l15);
                this.o = bl2;
            }
            return;
        }
    }

    private void f(Message object) {
        if (object != null && (object = object.obj) != null) {
            boolean bl2;
            object = (BDAbstractLocationListener)object;
            ArrayList arrayList = this.k;
            if (arrayList == null) {
                this.k = arrayList = new ArrayList();
            }
            if (!(bl2 = (arrayList = this.k).contains(object))) {
                arrayList = this.k;
                arrayList.add(object);
            }
        }
    }

    public static /* synthetic */ void f(LocationClient locationClient, Message message) {
        locationClient.g(message);
    }

    public static /* synthetic */ Boolean g(LocationClient locationClient) {
        return locationClient.C;
    }

    private void g(Message object) {
        if (object != null && (object = object.obj) != null) {
            boolean bl2;
            object = (BDAbstractLocationListener)object;
            ArrayList arrayList = this.k;
            if (arrayList != null && (bl2 = arrayList.contains(object))) {
                arrayList = this.k;
                arrayList.remove(object);
            }
        }
    }

    public static /* synthetic */ void g(LocationClient locationClient, Message message) {
        locationClient.a(message);
    }

    public static BDLocation getBDLocationInCoorType(BDLocation object, String string2) {
        BDLocation bDLocation = new BDLocation((BDLocation)object);
        Object object2 = ((BDLocation)object).getLongitude();
        double d10 = ((BDLocation)object).getLatitude();
        object = Jni.coorEncrypt(object2, d10, string2);
        object2 = object[1];
        bDLocation.setLatitude((double)object2);
        object2 = object[0];
        bDLocation.setLongitude((double)object2);
        return bDLocation;
    }

    public static /* synthetic */ d h(LocationClient locationClient) {
        return locationClient.E;
    }

    private void h(Message object) {
        if (object != null && (object = object.obj) != null) {
            boolean bl2;
            object = (BDLocationListener)object;
            ArrayList arrayList = this.j;
            if (arrayList != null && (bl2 = arrayList.contains(object))) {
                arrayList = this.j;
                arrayList.remove(object);
            }
        }
    }

    public static /* synthetic */ void h(LocationClient locationClient, Message message) {
        locationClient.b(message);
    }

    public static /* synthetic */ Context i(LocationClient locationClient) {
        return locationClient.f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void i(Message object) {
        try {
            int n10;
            int n11;
            object = object.getData();
            Object object2 = BDLocation.class;
            object2 = ((Class)object2).getClassLoader();
            object.setClassLoader((ClassLoader)object2);
            object2 = "locStr";
            object = object.getParcelable((String)object2);
            object = (BDLocation)object;
            object2 = this.v;
            if (object2 == null) return;
            object2 = this.c;
            if (object2 != null && (n11 = ((LocationClientOption)object2).isDisableCache()) != 0 && (n11 = ((BDLocation)object).getLocType()) == (n10 = 65)) {
                return;
            }
            object2 = this.v;
            object2.onReceiveLocation((BDLocation)object);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static /* synthetic */ void i(LocationClient locationClient, Message message) {
        locationClient.i(message);
    }

    public static /* synthetic */ LocationClientOption j(LocationClient locationClient) {
        return locationClient.d;
    }

    public static /* synthetic */ Object k(LocationClient locationClient) {
        return locationClient.r;
    }

    public static /* synthetic */ ArrayList l(LocationClient locationClient) {
        return locationClient.j;
    }

    public static /* synthetic */ ArrayList m(LocationClient locationClient) {
        return locationClient.k;
    }

    public static /* synthetic */ boolean n(LocationClient locationClient) {
        return locationClient.n;
    }

    public static /* synthetic */ LocationClient$b o(LocationClient locationClient) {
        return locationClient.p;
    }

    public static /* synthetic */ void p(LocationClient locationClient) {
        locationClient.b();
    }

    public static /* synthetic */ void q(LocationClient locationClient) {
        locationClient.c();
    }

    public static /* synthetic */ void r(LocationClient locationClient) {
        locationClient.e();
    }

    public static /* synthetic */ void s(LocationClient locationClient) {
        locationClient.f();
    }

    public static /* synthetic */ void t(LocationClient locationClient) {
        locationClient.a();
    }

    public static /* synthetic */ boolean u(LocationClient locationClient) {
        return locationClient.G;
    }

    public static /* synthetic */ boolean v(LocationClient locationClient) {
        return locationClient.F;
    }

    public void disableAssistantLocation() {
        com.baidu.location.b.n.a().b();
    }

    public void disableLocInForeground(boolean bl2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("removenotify", bl2);
        Message message = this.h.obtainMessage(704);
        message.setData(bundle);
        message.sendToTarget();
    }

    public void enableAssistantLocation(WebView webView) {
        n n10 = com.baidu.location.b.n.a();
        Context context = this.f;
        n10.a(context, webView, this);
    }

    public void enableLocInForeground(int n10, Notification object) {
        if (n10 > 0 && object != null) {
            Bundle bundle = new Bundle();
            String string2 = "id";
            bundle.putInt(string2, n10);
            bundle.putParcelable("notification", (Parcelable)object);
            LocationClient$a locationClient$a = this.h;
            int n11 = 703;
            locationClient$a = locationClient$a.obtainMessage(n11);
            locationClient$a.setData(bundle);
            locationClient$a.sendToTarget();
        } else {
            String string3 = "baidu_location_Client";
            object = "can not startLocInForeground if the param is unlegal";
            Log.e((String)string3, (String)object);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String getAccessKey() {
        block10: {
            Context context;
            try {
                context = this.f;
            }
            catch (Exception exception) {
                return null;
            }
            String string2 = com.baidu.location.a.a.b(context);
            this.x = string2;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) break block10;
            String string3 = "KEY=%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            String string4 = this.x;
            objectArray[0] = string4;
            return String.format(string3, objectArray);
        }
        String string5 = "please setting key from Manifest.xml";
        IllegalStateException illegalStateException = new IllegalStateException(string5);
        throw illegalStateException;
    }

    public BDLocation getLastKnownLocation() {
        return this.l;
    }

    public LocationClientOption getLocOption() {
        return this.c;
    }

    public String getVersion() {
        return "8.4.0";
    }

    public boolean isStarted() {
        return this.e;
    }

    public void onReceiveLightLocString(String string2) {
    }

    public void onReceiveLocation(BDLocation bDLocation) {
        boolean bl2 = this.G;
        boolean bl3 = true;
        if (bl2 == bl3 && !(bl2 = this.F)) {
            return;
        }
        if (bDLocation == null) {
            return;
        }
        Message message = this.h.obtainMessage(701);
        message.obj = bDLocation;
        message.sendToTarget();
    }

    public void registerLocationListener(BDAbstractLocationListener object) {
        if (object != null) {
            Message message = this.h.obtainMessage(1300);
            message.obj = object;
            message.sendToTarget();
            return;
        }
        object = new IllegalStateException("please set a non-null listener");
        throw object;
    }

    public void registerLocationListener(BDLocationListener object) {
        if (object != null) {
            Message message = this.h.obtainMessage(5);
            message.obj = object;
            message.sendToTarget();
            return;
        }
        object = new IllegalStateException("please set a non-null listener");
        throw object;
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message message = this.h.obtainMessage(9);
        message.obj = bDNotifyListener;
        message.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message message = this.h.obtainMessage(8);
        message.obj = bDLocationListener;
        message.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message message = this.h.obtainMessage(10);
        message.obj = bDNotifyListener;
        message.sendToTarget();
    }

    public boolean requestHotSpotState() {
        boolean bl2;
        Messenger messenger = this.g;
        if (messenger != null && (bl2 = this.e)) {
            bl2 = false;
            messenger = null;
            int n10 = 406;
            try {
                messenger = Message.obtain(null, (int)n10);
            }
            catch (Exception exception) {}
            Messenger messenger2 = this.g;
            messenger2.send((Message)messenger);
            return true;
        }
        return false;
    }

    public int requestLocation() {
        Object object = this.g;
        int n10 = 1;
        if (object != null && (object = this.i) != null) {
            int n11;
            object = this.j;
            if (object != null && (n11 = ((ArrayList)object).size()) >= n10 || (object = this.k) != null && (n11 = ((ArrayList)object).size()) >= n10) {
                long l10 = System.currentTimeMillis();
                long l11 = this.a;
                long l12 = (l10 -= l11) - (l11 = 1000L);
                n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n11 < 0) {
                    return 6;
                }
                this.n = n10;
                object = this.h.obtainMessage(4);
                ((Message)object).arg1 = 0;
                object.sendToTarget();
                return 0;
            }
            return 2;
        }
        return n10;
    }

    public void requestNotifyLocation() {
        this.h.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        Object object = this.g;
        int n10 = 1;
        if (object != null && (object = this.i) != null) {
            int n11;
            object = this.j;
            if (object != null && (n11 = ((ArrayList)object).size()) >= n10 || (object = this.k) != null && (n11 = ((ArrayList)object).size()) >= n10) {
                this.h.obtainMessage(12).sendToTarget();
                return 0;
            }
            return 2;
        }
        return n10;
    }

    public void restart() {
        this.stop();
        this.z = false;
        this.h.sendEmptyMessageDelayed(1, 1000L);
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        LocationClientOption locationClientOption2;
        boolean bl2;
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if ((bl2 = locationClientOption.a()) > false) {
            locationClientOption2 = null;
            locationClientOption.setScanSpan(0);
            bl2 = true;
            locationClientOption.setLocationNotify(bl2);
        }
        this.d = locationClientOption2 = new LocationClientOption(locationClientOption);
        locationClientOption2 = this.h.obtainMessage(3);
        ((Message)locationClientOption2).obj = locationClientOption;
        locationClientOption2.sendToTarget();
    }

    public void start() {
        com.baidu.location.b.a a10 = null;
        this.z = false;
        boolean bl2 = com.baidu.location.h.l.b();
        if (bl2) {
            return;
        }
        a10 = com.baidu.location.b.a.a();
        Context context = this.f;
        LocationClientOption locationClientOption = this.d;
        a10.a(context, locationClientOption);
        this.h.obtainMessage(1).sendToTarget();
    }

    public boolean startIndoorMode() {
        boolean bl2 = this.a(110);
        if (bl2) {
            boolean bl3;
            this.y = bl3 = true;
        }
        return bl2;
    }

    public void stop() {
        this.z = true;
        this.h.obtainMessage(2).sendToTarget();
        this.E = null;
    }

    public boolean stopIndoorMode() {
        boolean bl2 = this.a(111);
        if (bl2) {
            this.y = false;
        }
        return bl2;
    }

    public void unRegisterLocationListener(BDAbstractLocationListener object) {
        if (object != null) {
            Message message = this.h.obtainMessage(1400);
            message.obj = object;
            message.sendToTarget();
            return;
        }
        object = new IllegalStateException("please set a non-null listener");
        throw object;
    }

    public void unRegisterLocationListener(BDLocationListener object) {
        if (object != null) {
            Message message = this.h.obtainMessage(6);
            message.obj = object;
            message.sendToTarget();
            return;
        }
        object = new IllegalStateException("please set a non-null listener");
        throw object;
    }

    public boolean updateLocation(Location location) {
        Messenger messenger = this.g;
        if (messenger != null && (messenger = this.i) != null && location != null) {
            messenger = null;
            int n10 = 57;
            messenger = Message.obtain(null, (int)n10);
            messenger.obj = location;
            location = this.g;
            try {
                location.send((Message)messenger);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return true;
        }
        return false;
    }
}

