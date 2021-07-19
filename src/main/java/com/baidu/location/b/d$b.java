/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.os.Looper
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.d;
import com.baidu.location.b.d$b$a;
import com.baidu.location.b.f;
import com.baidu.location.b.m;
import com.baidu.location.h.l;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class d$b
extends com.baidu.location.h.f {
    public String a = null;
    public LocationManager b;
    public d$b$a c;
    public boolean d = false;
    public final /* synthetic */ d e;

    public d$b(d hashMap) {
        this.e = hashMap;
        this.k = hashMap = new HashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        try {
            d$b$a d$b$a;
            Object object = this.e;
            object = com.baidu.location.b.d.f((d)object);
            String string2 = "location";
            object = object.getSystemService(string2);
            object = (LocationManager)object;
            this.b = object;
            object = null;
            this.c = d$b$a = new d$b$a(this, null);
            string2 = this.b;
            if (string2 == null) return;
            if (d$b$a == null) return;
            String string3 = "network";
            long l10 = 1000L;
            try {
                Looper looper = Looper.getMainLooper();
                string2.requestLocationUpdates(string3, l10, 0.0f, (LocationListener)d$b$a, looper);
                return;
            }
            catch (SecurityException securityException) {
                securityException.printStackTrace();
            }
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    public static /* synthetic */ void a(d$b d$b) {
        d$b.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        d$b$a d$b$a = this.c;
        if (d$b$a == null) return;
        LocationManager locationManager = this.b;
        if (locationManager == null) return;
        try {
            locationManager.removeUpdates((LocationListener)d$b$a);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public void a(String object) {
        this.a = object;
        object = com.baidu.location.h.l.f;
        this.e((String)object);
        object = this.e;
        boolean bl2 = com.baidu.location.b.d.e((d)object);
        if (bl2) {
            this.a();
            object = new Timer();
            f f10 = new f(this, (Timer)object);
            long l10 = 10000L;
            ((Timer)object).schedule((TimerTask)f10, l10);
            object = com.baidu.location.b.d.f(this.e);
            f10 = null;
            String string2 = "cuidRelate";
            object = object.getSharedPreferences(string2, 0).edit();
            long l11 = System.currentTimeMillis();
            String string3 = "reqtime";
            object.putLong(string3, l11);
            object.apply();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean var1_1) {
        block11: {
            block12: {
                block13: {
                    var2_2 = ";";
                    var3_3 = "enc";
                    var4_5 = 63;
                    if (var1_1 == 0 || (var5_6 = this.j) == null) break block12;
                    var6_8 = "\"enc\"";
                    var7_9 = var5_6.contains((CharSequence)var6_8);
                    if (var7_9 == 0) break block13;
                    try {
                        var6_8 = new JSONObject((String)var5_6);
                        var8_10 = var6_8.has((String)var3_3);
                        if (var8_10) {
                            var3_3 = var6_8.getString((String)var3_3);
                            var6_8 = com.baidu.location.b.m.a();
                            var5_6 = var6_8.b((String)var3_3);
                        }
                    }
                    catch (Exception var3_4) {
                        var3_4.printStackTrace();
                    }
                }
                try {
                    var3_3 = new BDLocation((String)var5_6);
                    var6_8 = this.e;
                    com.baidu.location.b.d.a((d)var6_8, (String)var5_6);
                    ** GOTO lbl30
                }
                catch (Exception v0) {
                    try {
                        var3_3 = new BDLocation();
                        var3_3.setLocType(var4_5);
lbl30:
                        // 2 sources

                        var1_1 = var3_3.getLocType();
                        var7_9 = 161;
                        if (var1_1 == var7_9) {
                            var5_6 = this.e;
                            var5_6 = com.baidu.location.b.d.c((d)var5_6);
                            var5_6 = var5_6.coorType;
                            var3_3.setCoorType((String)var5_6);
                            var5_6 = new StringBuilder();
                            var6_8 = this.e;
                            var6_8 = var6_8.a;
                            var5_6.append((String)var6_8);
                            var5_6.append((String)var2_2);
                            var6_8 = this.e;
                            var6_8 = var6_8.b;
                            var5_6.append((String)var6_8);
                            var5_6.append((String)var2_2);
                            var2_2 = var3_3.getTime();
                            var5_6.append((String)var2_2);
                            var5_6 = var5_6.toString();
                            var5_6 = Jni.en1((String)var5_6);
                            var3_3.setLocationID((String)var5_6);
                            var1_1 = 0;
                            var5_6 = null;
                            var3_3.setRoadLocString(0.0f, 0.0f);
                            var5_6 = this.e;
                            var9_11 = true;
                            com.baidu.location.b.d.a((d)var5_6, var9_11);
                            var5_6 = this.e;
                            var5_6 = com.baidu.location.b.d.d((d)var5_6);
                            var5_6.onReceiveLocation((BDLocation)var3_3);
                            break block11;
                        }
                        var5_6 = this.e;
                        var9_12 = var3_3.getLocType();
                        com.baidu.location.b.d.a((d)var5_6, var9_12);
                    }
                    catch (Exception var5_7) {
                        var2_2 = this.e;
                        com.baidu.location.b.d.a((d)var2_2, var4_5);
                        var5_7.printStackTrace();
                    }
                    break block11;
                }
            }
            var5_6 = this.e;
            com.baidu.location.b.d.a((d)var5_6, var4_5);
        }
        var5_6 = this.k;
        if (var5_6 != null) {
            var5_6.clear();
        }
    }

    public void b() {
        Object object;
        Object object2 = com.baidu.location.h.l.e();
        this.h = object2;
        object2 = com.baidu.location.b.d.a(this.e);
        int n10 = 1;
        if (object2 != null && (object2 = com.baidu.location.b.d.b(this.e)) != null) {
            object2 = new StringBuilder();
            object = this.a;
            ((StringBuilder)object2).append((String)object);
            object = Locale.CHINA;
            int n11 = 2;
            Object[] objectArray = new Object[n11];
            String string2 = com.baidu.location.b.d.a(this.e);
            objectArray[0] = string2;
            string2 = com.baidu.location.b.d.b(this.e);
            objectArray[n10] = string2;
            string2 = "&ki=%s&sn=%s";
            object = String.format((Locale)object, string2, objectArray);
            ((StringBuilder)object2).append((String)object);
            this.a = object2 = ((StringBuilder)object2).toString();
        }
        object2 = new StringBuilder();
        object = this.a;
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("&enc=2");
        object2 = ((StringBuilder)object2).toString();
        this.a = object2;
        object2 = Jni.encodeTp4((String)object2);
        this.a = null;
        this.k.put("bloc", object2);
        object2 = Locale.CHINA;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object = Long.valueOf(System.currentTimeMillis());
        object2 = String.format((Locale)object2, "%d", objectArray);
        this.k.put("trtm", object2);
    }
}

