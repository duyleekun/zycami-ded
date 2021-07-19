/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.location.Location
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Message
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.mob.commons.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.a.d;
import com.mob.commons.a.k$1;
import com.mob.commons.a.k$2;
import com.mob.commons.a.k$3;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.e;
import com.mob.commons.i;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import org.json.JSONObject;

public class k
extends d {
    private Hashon a;
    private Random b;
    private BroadcastReceiver c;
    private BroadcastReceiver d;
    private BroadcastReceiver e;
    private DeviceHelper f;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;

    public k() {
        DeviceHelper deviceHelper;
        this.f = deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
    }

    private HashMap a(Location object) {
        if (object != null) {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            float f10 = object.getAccuracy();
            Object object2 = Float.valueOf(f10);
            String string2 = "accuracy";
            hashMap.put(string2, object2);
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 >= n11 && (n10 = (int)(object.hasVerticalAccuracy() ? 1 : 0)) != 0) {
                f10 = object.getVerticalAccuracyMeters();
                object2 = Float.valueOf(f10);
                string2 = "verticalAccuracy";
                hashMap.put(string2, object2);
            }
            object2 = object.getLatitude();
            hashMap.put("latitude", object2);
            object2 = object.getLongitude();
            hashMap.put("longitude", object2);
            long l10 = object.getTime();
            object2 = l10;
            hashMap.put("ltime", object2);
            object2 = object.getProvider();
            hashMap.put("provider", object2);
            double d10 = object.getAltitude();
            object2 = d10;
            hashMap.put("altitude", object2);
            f10 = object.getBearing();
            object2 = Float.valueOf(f10);
            string2 = "bearing";
            hashMap.put(string2, object2);
            float f11 = object.getSpeed();
            object = Float.valueOf(f11);
            hashMap.put("speed", object);
            object = this.f.getSSID();
            object2 = this.f.getBssid();
            n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
            if (n11 == 0) {
                string2 = "cur_bssid";
                hashMap.put(string2, object2);
            }
            if ((n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0)) == 0) {
                object2 = "cur_ssid";
                hashMap.put(object2, object);
            }
            return hashMap;
        }
        return null;
    }

    private void a(Parcelable object) {
        block19: {
            Object object2;
            boolean bl2;
            block18: {
                block17: {
                    object = (NetworkInfo)object;
                    bl2 = object.isConnected();
                    if (bl2) break block17;
                    return;
                }
                object = new TreeMap();
                object2 = "ssid";
                Object object3 = this.f;
                object3 = ((DeviceHelper)object3).getSSID();
                ((TreeMap)object).put(object2, object3);
                object2 = "bssid";
                object3 = this.f;
                object3 = ((DeviceHelper)object3).getBssid();
                ((TreeMap)object).put(object2, object3);
                object2 = new JSONObject((Map)object);
                object = object2.toString();
                object = Data.MD5((String)object);
                object2 = com.mob.commons.i.b();
                if (object2 == null) break block18;
                bl2 = ((String)object2).equals(object);
                if (bl2) break block19;
            }
            bl2 = com.mob.commons.b.o();
            if (!bl2) break block19;
            try {
                this.i();
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(ArrayList object) {
        synchronized (this) {
            try {
                HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                Object object2 = "type";
                String string2 = "WIFI_SCAN_LIST";
                hashMap.put(object2, string2);
                object2 = "list";
                hashMap.put(object2, object);
                object = "cl";
                object2 = this.f();
                hashMap.put(object, object2);
                object = "datetime";
                long l10 = com.mob.commons.b.a();
                object2 = l10;
                hashMap.put(object, object2);
                object = com.mob.commons.c.a();
                l10 = com.mob.commons.b.a();
                ((c)object).a(l10, hashMap);
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.w(throwable);
            }
            return;
        }
    }

    private void a(ArrayList cloneable, int n10) {
        Object object = null;
        int n11 = 1;
        if (n10 == n11) {
            DeviceHelper deviceHelper = this.f;
            int n12 = 30;
            object = deviceHelper.getLocation(n12, 0, n11 != 0);
        } else {
            DeviceHelper deviceHelper = this.f;
            int n13 = 15;
            object = deviceHelper.getLocation(0, n13, n11 != 0);
        }
        if (object != null && (object = this.a((Location)object)) != null && !(n11 = ((HashMap)object).isEmpty())) {
            Object object2 = n10;
            String string2 = "location_type";
            ((HashMap)object).put(string2, object2);
            if (cloneable != null && (n10 = (int)(((ArrayList)cloneable).isEmpty() ? 1 : 0)) == 0) {
                object2 = "wifiList";
                ((HashMap)object).put(object2, cloneable);
            }
            cloneable = new HashMap();
            string2 = "LOCATION";
            ((HashMap)cloneable).put("type", string2);
            ((HashMap)cloneable).put("data", object);
            object2 = com.mob.commons.b.a();
            object = "datetime";
            ((HashMap)cloneable).put(object, object2);
            object2 = com.mob.commons.c.a();
            long l10 = com.mob.commons.b.a();
            ((c)object2).a(l10, (HashMap)cloneable);
        }
    }

    public static /* synthetic */ boolean a(k k10) {
        return k10.i;
    }

    public static /* synthetic */ boolean a(k k10, boolean bl2) {
        k10.i = bl2;
        return bl2;
    }

    private void b(ArrayList arrayList) {
        NLog nLog = null;
        this.h = false;
        int n10 = com.mob.commons.b.m();
        if (n10 != 0) {
            n10 = 2;
            this.a(arrayList, n10);
            n10 = 1;
            try {
                this.a(arrayList, n10);
            }
            catch (Throwable throwable) {
                nLog = MobLog.getInstance();
                nLog.w(throwable);
            }
        }
        long l10 = com.mob.commons.b.n() * 1000;
        this.a(5, l10);
    }

    public static /* synthetic */ boolean b(k k10) {
        return k10.h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(int n10) {
        Class[] classArray = this.d;
        if (classArray != null) return;
        classArray = new k$2(this);
        this.d = classArray;
        classArray = new IntentFilter();
        String string2 = "android.net.wifi.SCAN_RESULTS";
        classArray.addAction(string2);
        try {
            Class<BroadcastReceiver> clazz;
            string2 = MobSDK.getContext();
            String string3 = "registerReceiver";
            int n11 = 2;
            Object[] objectArray = new Object[n11];
            BroadcastReceiver broadcastReceiver = this.d;
            objectArray[0] = broadcastReceiver;
            int n12 = 1;
            objectArray[n12] = classArray;
            classArray = new Class[n11];
            classArray[0] = clazz = BroadcastReceiver.class;
            classArray[n12] = clazz = IntentFilter.class;
            ReflectHelper.invokeInstanceMethod((Object)string2, string3, objectArray, classArray);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    public static /* synthetic */ void c(k k10) {
        k10.s();
    }

    /*
     * WARNING - void declaration
     */
    private void h() {
        block91: {
            String string2;
            Object object;
            HashMap<String, String> hashMap;
            Object object2;
            Object object3;
            block90: {
                void var5_12;
                float f10;
                boolean bl2;
                block89: {
                    float f11;
                    block88: {
                        block87: {
                            object3 = new HashMap();
                            object2 = "phonename";
                            hashMap = this.f;
                            hashMap = ((DeviceHelper)((Object)hashMap)).getBluetoothName();
                            ((HashMap)object3).put(object2, hashMap);
                            object2 = "signmd5";
                            hashMap = this.f;
                            hashMap = ((DeviceHelper)((Object)hashMap)).getSignMD5();
                            ((HashMap)object3).put(object2, hashMap);
                            object2 = "boardname";
                            hashMap = Build.BOARD;
                            ((HashMap)object3).put(object2, hashMap);
                            object2 = "devicename";
                            hashMap = Build.DEVICE;
                            ((HashMap)object3).put(object2, hashMap);
                            object2 = "displayid";
                            hashMap = Build.DISPLAY;
                            ((HashMap)object3).put(object2, hashMap);
                            object2 = "fingerprint";
                            hashMap = Build.FINGERPRINT;
                            ((HashMap)object3).put(object2, hashMap);
                            int bl4 = Build.VERSION.SDK_INT;
                            int n10 = 14;
                            f11 = 2.0E-44f;
                            object = "radiover";
                            if (bl4 < n10) break block87;
                            object2 = Build.getRadioVersion();
                            ((HashMap)object3).put(object, object2);
                            break block88;
                        }
                        boolean bl3 = false;
                        object2 = null;
                        ((HashMap)object3).put(object, null);
                    }
                    object2 = "density";
                    hashMap = MobSDK.getContext();
                    f11 = ResHelper.getDensity((Context)hashMap);
                    hashMap = Float.valueOf(f11);
                    ((HashMap)object3).put(object2, hashMap);
                    object2 = "densitydpi";
                    hashMap = MobSDK.getContext();
                    int n11 = ResHelper.getDensityDpi((Context)hashMap);
                    hashMap = n11;
                    ((HashMap)object3).put(object2, hashMap);
                    object2 = "btm";
                    hashMap = this.f;
                    hashMap = ((DeviceHelper)((Object)hashMap)).getBTMac();
                    ((HashMap)object3).put(object2, hashMap);
                    object2 = "btmp";
                    hashMap = this.f;
                    hashMap = ((DeviceHelper)((Object)hashMap)).getBTMacFromProvider();
                    ((HashMap)object3).put(object2, hashMap);
                    object2 = "bt";
                    hashMap = this.f;
                    boolean bl4 = ((DeviceHelper)((Object)hashMap)).isBT();
                    bl2 = true;
                    f10 = Float.MIN_VALUE;
                    string2 = null;
                    if (bl4) {
                        boolean bl5 = bl2;
                        f11 = f10;
                        break block89;
                    }
                    boolean bl6 = false;
                    hashMap = null;
                    f11 = 0.0f;
                }
                hashMap = (int)var5_12;
                ((HashMap)object3).put(object2, hashMap);
                object2 = "cameraResolutions";
                hashMap = this.f;
                hashMap = ((DeviceHelper)((Object)hashMap)).getCamResolution();
                ((HashMap)object3).put(object2, hashMap);
                object2 = "timezone";
                hashMap = this.f;
                hashMap = ((DeviceHelper)((Object)hashMap)).getTimezone();
                ((HashMap)object3).put(object2, hashMap);
                object2 = "cpuType";
                hashMap = this.f;
                hashMap = ((DeviceHelper)((Object)hashMap)).getCPUType();
                ((HashMap)object3).put(object2, hashMap);
                object2 = "flavor";
                hashMap = this.f;
                hashMap = ((DeviceHelper)((Object)hashMap)).getFlavor();
                ((HashMap)object3).put(object2, hashMap);
                object2 = "features";
                hashMap = this.f;
                hashMap = ((DeviceHelper)((Object)hashMap)).getSupport();
                ((HashMap)object3).put(object2, hashMap);
                object2 = "defaultInputMethod";
                hashMap = this.f;
                hashMap = ((DeviceHelper)((Object)hashMap)).getDefaultIM();
                ((HashMap)object3).put(object2, hashMap);
                object2 = "inputMethods";
                hashMap = this.f;
                hashMap = ((DeviceHelper)((Object)hashMap)).getIMList();
                ((HashMap)object3).put(object2, hashMap);
                object2 = "brand";
                hashMap = this.f;
                hashMap = ((DeviceHelper)((Object)hashMap)).getBrand();
                ((HashMap)object3).put(object2, hashMap);
                object2 = "isSimulator";
                hashMap = this.f;
                boolean bl7 = ((DeviceHelper)((Object)hashMap)).isSmlt();
                hashMap = bl7;
                ((HashMap)object3).put(object2, hashMap);
                object2 = "ipInfo";
                hashMap = this.f;
                hashMap = ((DeviceHelper)((Object)hashMap)).getLocalIpInfo();
                ((HashMap)object3).put(object2, hashMap);
                object2 = this.v();
                object2 = ((Hashon)object2).fromHashMap((HashMap)object3);
                object2 = Data.MD5((String)object2);
                hashMap = com.mob.commons.i.a();
                long l10 = com.mob.commons.b.a();
                long l11 = com.mob.commons.i.o();
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l12 < 0) {
                    bl2 = false;
                    object = null;
                    f10 = 0.0f;
                }
                if (hashMap == null) break block90;
                boolean bl8 = ((String)((Object)hashMap)).equals(object2);
                if (bl8 && !bl2) break block91;
            }
            hashMap = new HashMap<String, String>();
            object = "type";
            string2 = "DEVEXT";
            hashMap.put((String)object, string2);
            object = "data";
            hashMap.put((String)object, (String)object3);
            object3 = "datetime";
            long l13 = com.mob.commons.b.a();
            object = l13;
            hashMap.put((String)object3, (String)object);
            object3 = com.mob.commons.c.a();
            l13 = com.mob.commons.b.a();
            ((c)object3).a(l13, hashMap);
            com.mob.commons.i.a((String)object2);
            long l14 = com.mob.commons.b.a();
            long l15 = 2592000000L;
            l14 += l15;
            try {
                com.mob.commons.i.e(l14);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void i() {
        synchronized (this) {
            Object object = new HashMap();
            try {
                Object object2;
                Object object3;
                Object object4;
                Object object5 = this.f;
                object5 = ((DeviceHelper)object5).getBssid();
                boolean bl2 = TextUtils.isEmpty((CharSequence)object5);
                if (!bl2) {
                    boolean bl3;
                    object4 = this.f;
                    if ((object4 = ((DeviceHelper)object4).getAvailableWifiList()) != null && !(bl3 = ((ArrayList)object4).isEmpty())) {
                        object4 = ((ArrayList)object4).iterator();
                        while (bl3 = object4.hasNext()) {
                            boolean bl4;
                            object3 = object4.next();
                            object3 = (HashMap)object3;
                            object2 = "BSSID";
                            if ((object2 = ((HashMap)object3).get(object2)) == null || !(bl4 = ((String)(object2 = String.valueOf(object2))).equals(object5))) continue;
                            ((HashMap)object).putAll(object3);
                            break;
                        }
                        object4 = "BSSID";
                        ((HashMap)object).remove(object4);
                        object4 = "SSID";
                        ((HashMap)object).remove(object4);
                    }
                }
                object4 = this.f;
                if ((object4 = ((DeviceHelper)object4).getCurrentWifiInfo()) != null) {
                    ((HashMap)object).putAll(object4);
                }
                object4 = this.f;
                object4 = ((DeviceHelper)object4).getSSID();
                object3 = "ssid";
                ((HashMap)object).put(object3, object4);
                object3 = "bssid";
                ((HashMap)object).put(object3, object5);
                object3 = new HashMap();
                object2 = "type";
                String string2 = "WIFI_INFO";
                ((HashMap)object3).put(object2, string2);
                object2 = "data";
                ((HashMap)object3).put(object2, object);
                object = "cl";
                object2 = this.f();
                ((HashMap)object3).put(object, object2);
                long l10 = com.mob.commons.b.a();
                object = "datetime";
                Long l11 = l10;
                ((HashMap)object3).put(object, l11);
                object = com.mob.commons.c.a();
                long l12 = com.mob.commons.b.a();
                ((c)object).a(l12, (HashMap)object3);
                com.mob.commons.i.a(l10);
                object = new TreeMap();
                object3 = "ssid";
                ((TreeMap)object).put(object3, object4);
                object4 = "bssid";
                ((TreeMap)object).put(object4, object5);
                object5 = new JSONObject(object);
                object = object5.toString();
                object = Data.MD5((String)object);
                com.mob.commons.i.b((String)object);
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.w(throwable);
            }
            int n10 = 2;
            int n11 = com.mob.commons.b.p() * 1000;
            long l13 = n11;
            this.a(n10, l13);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        Class[] classArray = this.c;
        if (classArray != null) return;
        classArray = new k$1(this);
        this.c = classArray;
        classArray = new IntentFilter();
        String string2 = "android.net.wifi.STATE_CHANGE";
        classArray.addAction(string2);
        try {
            Class<BroadcastReceiver> clazz;
            string2 = MobSDK.getContext();
            String string3 = "registerReceiver";
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            BroadcastReceiver broadcastReceiver = this.c;
            objectArray[0] = broadcastReceiver;
            int n11 = 1;
            objectArray[n11] = classArray;
            classArray = new Class[n10];
            classArray[0] = clazz = BroadcastReceiver.class;
            classArray[n11] = clazz = IntentFilter.class;
            ReflectHelper.invokeInstanceMethod((Object)string2, string3, objectArray, classArray);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void k() {
        BroadcastReceiver broadcastReceiver = this.c;
        if (broadcastReceiver != null) {
            try {
                broadcastReceiver = MobSDK.getContext();
                String string2 = "unregisterReceiver";
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                Object object = this.c;
                objectArray[0] = object;
                Class[] classArray = new Class[n10];
                object = BroadcastReceiver.class;
                classArray[0] = object;
                ReflectHelper.invokeInstanceMethod((Object)broadcastReceiver, string2, objectArray, classArray);
            }
            catch (Throwable throwable) {}
            broadcastReceiver = null;
            this.c = null;
        }
    }

    private void l() {
        long l10;
        Object object;
        Object object2;
        int n10;
        int n11 = -1;
        Object object3 = this.f;
        object3 = ((DeviceHelper)object3).getCarrier();
        try {
            n10 = Integer.parseInt((String)object3);
        }
        catch (Throwable throwable) {
            n10 = n11;
        }
        Object object4 = this.f;
        int n12 = ((DeviceHelper)object4).getCellLac();
        Object object5 = this.f;
        int n13 = ((DeviceHelper)object5).getCellId();
        DeviceHelper deviceHelper = this.f;
        int n14 = deviceHelper.getPsc();
        HashMap<Object, Object> hashMap = null;
        if (n10 != n11 && n12 != n11 && n13 != n11) {
            hashMap = new HashMap<Object, Object>();
            object4 = n12;
            object2 = "lac";
            hashMap.put(object2, object4);
            object4 = n13;
            object5 = "cell";
            hashMap.put(object5, object4);
            if (n14 != n11) {
                object4 = n14;
                object5 = "psc";
                hashMap.put(object5, object4);
            }
        }
        object4 = this.f;
        n12 = ((DeviceHelper)object4).getCdmaBid();
        object5 = this.f;
        n13 = ((DeviceHelper)object5).getCdmaSid();
        deviceHelper = this.f;
        n14 = deviceHelper.getCdmaNid();
        object2 = this.f;
        int n15 = ((DeviceHelper)object2).getCdmaLat();
        DeviceHelper deviceHelper2 = this.f;
        int n16 = deviceHelper2.getCdmaLon();
        if (n10 != n11 && n12 != n11 && n13 != n11 && n14 != n11) {
            if (hashMap == null) {
                hashMap = new HashMap<Object, Object>();
            }
            object4 = n12;
            String string2 = "bid";
            hashMap.put(string2, object4);
            object4 = n13;
            hashMap.put("sid", object4);
            object4 = n14;
            object5 = "nid";
            hashMap.put(object5, object4);
            if (n15 != n11) {
                object4 = n15;
                object5 = "lat";
                hashMap.put(object5, object4);
            }
            if (n16 != n11) {
                object = n16;
                object4 = "lon";
                hashMap.put(object4, object);
            }
        }
        if (hashMap != null) {
            object = n10;
            hashMap.put("carrier", object);
            object = this.f.getCarrierName();
            object3 = "simopname";
            hashMap.put(object3, object);
            object = this.f.getNeighboringCellInfo();
            if (object != null && (n10 = ((ArrayList)object).size()) > 0) {
                object3 = "nearby";
                hashMap.put(object3, object);
            }
            object = new HashMap();
            ((HashMap)object).put("type", "BSINFO");
            object3 = this.f();
            ((HashMap)object).put("cl", object3);
            ((HashMap)object).put("data", hashMap);
            long l11 = com.mob.commons.b.a();
            object3 = l11;
            object4 = "datetime";
            ((HashMap)object).put(object4, object3);
            object3 = com.mob.commons.c.a();
            l10 = com.mob.commons.b.a();
            ((c)object3).a(l10, (HashMap)object);
            object = Data.MD5(this.v().fromHashMap(hashMap));
            com.mob.commons.i.c((String)object);
        }
        long l12 = com.mob.commons.b.a();
        l10 = (long)com.mob.commons.b.l() * 1000L;
        com.mob.commons.i.b(l12 + l10);
    }

    private boolean m() {
        int n10;
        int n11 = -1;
        Object object = this.f;
        object = ((DeviceHelper)object).getCarrier();
        try {
            n10 = Integer.parseInt((String)object);
        }
        catch (Throwable throwable) {
            n10 = n11;
        }
        Object object2 = this.f;
        int n12 = ((DeviceHelper)object2).getCellLac();
        DeviceHelper deviceHelper = this.f;
        int n13 = deviceHelper.getCellId();
        boolean bl2 = false;
        if (n10 != n11 && n12 != n11 && n13 != n11) {
            Object object3 = new HashMap();
            object = n10;
            ((HashMap)object3).put("carrier", object);
            object = this.f.getCarrierName();
            String string2 = "simopname";
            ((HashMap)object3).put(string2, object);
            object = n12;
            ((HashMap)object3).put("lac", object);
            object = n13;
            object2 = "cell";
            ((HashMap)object3).put(object2, object);
            object3 = Data.MD5(this.v().fromHashMap((HashMap)object3));
            object = com.mob.commons.i.c();
            if (object == null || (n11 = (int)(((String)object).equals(object3) ? 1 : 0)) == 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private void n() {
        boolean bl2;
        Object object;
        Object object2 = this.f;
        Object object3 = null;
        int n10 = 1;
        if ((object2 = ((DeviceHelper)object2).getLocation(0, 0, n10 != 0)) != null && (object = this.a((Location)object2)) != null && !(bl2 = ((HashMap)object).isEmpty())) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("type", "O_LOCATION");
            hashMap.put("data", object);
            object = com.mob.commons.b.a();
            hashMap.put("datetime", object);
            object = new TreeMap();
            Object object4 = object2.getLatitude();
            String string2 = "latitude";
            ((TreeMap)object).put(string2, object4);
            double d10 = object2.getLongitude();
            object2 = d10;
            object4 = "longitude";
            ((TreeMap)object).put(object4, object2);
            object2 = new JSONObject((Map)object);
            object2 = Data.MD5(object2.toString());
            object = com.mob.commons.i.q();
            long l10 = com.mob.commons.i.r();
            long l11 = com.mob.commons.b.a();
            boolean bl3 = TextUtils.isEmpty((CharSequence)object);
            if (!bl3 && (n10 = ((String)object).equals(object2)) != 0 && (n10 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) < 0) {
                object2 = MobLog.getInstance();
                object3 = new Object[]{};
                object = "o_loc: no";
                ((NLog)object2).d(object, (Object[])object3);
            } else {
                object = MobLog.getInstance();
                object3 = new Object[]{};
                object4 = "o_loc: yes";
                ((NLog)object).d(object4, (Object[])object3);
                object3 = com.mob.commons.c.a();
                l10 = com.mob.commons.b.a();
                ((c)object3).a(l10, hashMap);
                com.mob.commons.i.j((String)object2);
                long l12 = com.mob.commons.b.y();
                long l13 = 1000L;
                com.mob.commons.i.g(l11 += (l12 *= l13));
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void o() {
        Object object;
        Object object2;
        try {
            boolean bl2;
            ArrayList arrayList = this.u();
            if (arrayList == null) return;
            boolean bl3 = arrayList.isEmpty();
            if (bl3) return;
            object2 = new ArrayList();
            Object object3 = arrayList.iterator();
            while (bl2 = object3.hasNext()) {
                Object object4 = object3.next();
                object4 = (HashMap)object4;
                String string2 = "BSSID";
                if ((object4 = ((HashMap)object4).get(string2)) == null) continue;
                object4 = String.valueOf(object4);
                ((ArrayList)object2).add(object4);
            }
            Collections.sort(object2);
            object3 = "";
            object2 = TextUtils.join((CharSequence)object3, object2);
            object2 = Data.MD5((String)object2);
            object3 = com.mob.commons.i.i();
            long l10 = com.mob.commons.i.p();
            long l11 = com.mob.commons.b.a();
            NLog nLog = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            Object[] objectArray = "wiHashLast: ";
            ((StringBuilder)charSequence).append((String)objectArray);
            ((StringBuilder)charSequence).append((String)object3);
            charSequence = ((StringBuilder)charSequence).toString();
            objectArray = null;
            Object object5 = new Object[]{};
            nLog.d(charSequence, object5);
            nLog = MobLog.getInstance();
            charSequence = new StringBuilder();
            object5 = "wiHash: ";
            ((StringBuilder)charSequence).append((String)object5);
            ((StringBuilder)charSequence).append((String)object2);
            charSequence = ((StringBuilder)charSequence).toString();
            objectArray = new Object[]{};
            nLog.d(charSequence, objectArray);
            if (object3 != null && (object = ((String)object3).equals(object2)) != 0) {
                object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (object >= 0) return;
            }
            this.a(arrayList);
            com.mob.commons.i.g((String)object2);
            long l12 = com.mob.commons.b.a();
            object = com.mob.commons.b.s() * 1000;
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
            return;
        }
        long l13 = object;
        {
            com.mob.commons.i.f(l12 += l13);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void p() {
        BroadcastReceiver broadcastReceiver = this.d;
        if (broadcastReceiver != null) {
            try {
                broadcastReceiver = MobSDK.getContext();
                String string2 = "unregisterReceiver";
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                Object object = this.d;
                objectArray[0] = object;
                Class[] classArray = new Class[n10];
                object = BroadcastReceiver.class;
                classArray[0] = object;
                ReflectHelper.invokeInstanceMethod((Object)broadcastReceiver, string2, objectArray, classArray);
            }
            catch (Throwable throwable) {}
            broadcastReceiver = null;
            this.d = null;
        }
    }

    private void q() {
        this.r();
        this.h = true;
        this.f.scanWifiList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void r() {
        Class[] classArray = this.e;
        if (classArray != null) return;
        classArray = new k$3(this);
        this.e = classArray;
        classArray = new IntentFilter();
        String string2 = "android.net.wifi.SCAN_RESULTS";
        classArray.addAction(string2);
        try {
            Class<BroadcastReceiver> clazz;
            string2 = MobSDK.getContext();
            String string3 = "registerReceiver";
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            BroadcastReceiver broadcastReceiver = this.e;
            objectArray[0] = broadcastReceiver;
            int n11 = 1;
            objectArray[n11] = classArray;
            classArray = new Class[n10];
            classArray[0] = clazz = BroadcastReceiver.class;
            classArray[n11] = clazz = IntentFilter.class;
            ReflectHelper.invokeInstanceMethod((Object)string2, string3, objectArray, classArray);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void s() {
        BroadcastReceiver broadcastReceiver = this.e;
        if (broadcastReceiver != null) {
            try {
                broadcastReceiver = MobSDK.getContext();
                String string2 = "unregisterReceiver";
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                Object object = this.e;
                objectArray[0] = object;
                Class[] classArray = new Class[n10];
                object = BroadcastReceiver.class;
                classArray[0] = object;
                ReflectHelper.invokeInstanceMethod((Object)broadcastReceiver, string2, objectArray, classArray);
            }
            catch (Throwable throwable) {}
            broadcastReceiver = null;
            this.e = null;
        }
    }

    private void t() {
        block4: {
            int n10 = 10;
            this.a(n10);
            n10 = (int)(this.g ? 1 : 0);
            if (n10 != 0) break block4;
            ArrayList arrayList = this.u();
            try {
                this.b(arrayList);
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.w(throwable);
            }
        }
    }

    private ArrayList u() {
        ArrayList<Serializable> arrayList;
        block27: {
            block28: {
                arrayList = new ArrayList<Serializable>();
                Iterator iterator2 = this.f;
                iterator2 = ((DeviceHelper)((Object)iterator2)).getAvailableWifiList();
                if (iterator2 == null) break block27;
                boolean bl2 = ((ArrayList)((Object)iterator2)).isEmpty();
                if (bl2) break block27;
                Object object = com.mob.commons.b.t();
                if (object == null) break block28;
                boolean bl3 = ((ArrayList)object).isEmpty();
                if (bl3) break block28;
                Object object2 = this.f;
                object2 = ((DeviceHelper)object2).getBssid();
                try {
                    iterator2 = ((ArrayList)((Object)iterator2)).iterator();
                }
                catch (Throwable throwable) {
                    object = MobLog.getInstance();
                    ((NLog)object).w(throwable);
                }
                while (true) {
                    Serializable serializable;
                    Object object3;
                    block29: {
                        boolean bl4 = iterator2.hasNext();
                        if (!bl4) break block27;
                        object3 = iterator2.next();
                        object3 = (HashMap)object3;
                        serializable = "BSSID";
                        serializable = ((HashMap)object3).get(serializable);
                        if (serializable == null) break block29;
                        serializable = String.valueOf(serializable);
                        boolean bl5 = ((String)((Object)serializable)).equals(object2);
                        if (!bl5) break block29;
                        object2 = "___curConn";
                        serializable = Boolean.TRUE;
                        ((HashMap)object3).put(object2, serializable);
                        bl3 = false;
                        object2 = null;
                    }
                    serializable = new HashMap();
                    Iterator iterator3 = ((ArrayList)object).iterator();
                    while (true) {
                        boolean bl6 = iterator3.hasNext();
                        if (!bl6) break;
                        Object object4 = iterator3.next();
                        object4 = (String)object4;
                        Object v10 = ((HashMap)object3).get(object4);
                        if (v10 == null) continue;
                        ((HashMap)serializable).put(object4, v10);
                        continue;
                        break;
                    }
                    arrayList.add(serializable);
                    continue;
                    break;
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    private Hashon v() {
        Hashon hashon = this.a;
        if (hashon == null) {
            this.a = hashon = new Hashon();
        }
        return this.a;
    }

    public File a() {
        return com.mob.commons.e.a("comm/locks/.dic_lock");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(Message var1_1) {
        var2_6 = var1_1.what;
        var3_7 = 4;
        var4_8 = 120;
        var5_9 = true;
        switch (var2_6) {
            default: {
                break;
            }
            case 11: {
                this.t();
                break;
            }
            case 10: {
                this.g = var5_9;
                var6_10 = false;
                var1_1 = null;
                this.b((ArrayList)null);
                break;
            }
            case 9: {
                var1_1 = (Parcelable)var1_1.obj;
                this.a((Parcelable)var1_1);
                break;
            }
            case 8: {
                this.o();
                break;
            }
            case 7: {
                var6_11 = com.mob.commons.b.x();
                if (var6_11 != 0) {
                    try {
                        this.n();
                    }
                    catch (Throwable var1_2) {
                        var7_18 = MobLog.getInstance();
                        var7_18.w(var1_2);
                    }
                }
                var6_11 = 7;
                var8_22 = com.mob.commons.b.z();
                var10_25 = 1000L;
                this.a(var6_11, var8_22 *= var10_25);
                break;
            }
            case 6: {
                var6_12 = com.mob.commons.b.q();
                var8_23 = com.mob.commons.b.r();
                var2_6 = (int)var8_23;
                var3_7 = 6;
                if (var6_12 != 0) {
                    this.i = var5_9;
                    this.c(var2_6);
                    var1_1 = this.f;
                    var1_1.scanWifiList();
                    var10_26 = var2_6 *= 1000;
                    this.a(var3_7, var10_26);
                    break;
                }
                this.p();
                var6_12 = com.mob.commons.b.s() * 1000;
                var10_27 = var6_12;
                this.a(var3_7, var10_27);
                break;
            }
            case 5: {
                var1_1 = null;
                this.g = false;
                var6_13 = com.mob.commons.b.m();
                if (var6_13 == 0) ** GOTO lbl90
                var1_1 = this.f;
                var7_19 = "android.permission.CHANGE_WIFI_STATE";
                var6_13 = (int)var1_1.checkPermission((String)var7_19);
                var2_6 = 10;
                if (var6_13 == 0) ** GOTO lbl82
                var1_1 = this.f;
                var12_30 = "android.permission.ACCESS_WIFI_STATE";
                var6_13 = (int)var1_1.checkPermission(var12_30);
                if (var6_13 == 0) ** GOTO lbl82
                this.q();
                var13_31 = 5000L;
                this.a(var2_6, var13_31);
lbl82:
                // 2 sources

                try {
                    this.b(var2_6);
                }
                catch (Throwable var1_3) {
                    var7_19 = MobLog.getInstance();
                    var7_19.w(var1_3);
                }
                break;
lbl90:
                // 1 sources

                var6_13 = 5;
                var2_6 = com.mob.commons.b.n() * 1000;
                var8_24 = var2_6;
                this.a(var6_13, var8_24);
                break;
            }
            case 4: {
                var6_14 /* !! */  = com.mob.commons.b.k();
                if (var6_14 /* !! */  == 0) break;
                var15_32 = com.mob.commons.i.d();
                cfr_temp_0 = var15_32 - (var17_33 = com.mob.commons.b.a());
                var6_14 /* !! */  = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var6_14 /* !! */  < 0) ** GOTO lbl105
                var6_14 /* !! */  = (int)this.m();
                if (var6_14 /* !! */  == 0) ** GOTO lbl112
lbl105:
                // 2 sources

                try {
                    this.l();
                }
                catch (Throwable var1_4) {
                    var7_20 = MobLog.getInstance();
                    var7_20.w(var1_4);
                }
lbl112:
                // 3 sources

                if ((var1_1 = this.b) == null) {
                    this.b = var1_1 = new Random();
                }
                var1_1 = this.b;
                var6_14 /* !! */  = (var1_1.nextInt(var4_8) + 180) * 1000;
                var10_28 = var6_14 /* !! */ ;
                this.a(var3_7, var10_28);
                break;
            }
            case 3: {
                var6_15 = com.mob.commons.b.k();
                if (var6_15 == 0) break;
                try {
                    this.l();
                }
                catch (Throwable var1_5) {
                    var7_21 = MobLog.getInstance();
                    var7_21.w(var1_5);
                }
                var1_1 = this.b;
                if (var1_1 == null) {
                    this.b = var1_1 = new Random();
                }
                var1_1 = this.b;
                var6_15 = (var1_1.nextInt(var4_8) + 180) * 1000;
                var10_29 = var6_15;
                this.a(var3_7, var10_29);
                break;
            }
            case 2: {
                var6_16 = com.mob.commons.b.o();
                if (var6_16) {
                    this.i();
                    this.j();
                    break;
                }
                this.k();
                break;
            }
            case 1: {
                var6_17 = com.mob.commons.b.j();
                if (!var6_17) break;
                this.h();
            }
        }
    }

    public void b() {
        this.k();
        this.p();
        this.s();
    }

    public void d() {
        this.b(1);
        this.b(2);
        Message message = Message.obtain();
        message.arg1 = -1;
        message.what = 6;
        this.b(message);
        this.b(3);
        this.b(5);
        this.b(7);
    }
}

