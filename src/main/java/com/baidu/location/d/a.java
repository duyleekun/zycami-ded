/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.location.Location
 */
package com.baidu.location.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.baidu.location.BDLocation;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient;
import com.baidu.location.d.a$a;
import com.baidu.location.d.a$b;
import java.util.ArrayList;
import java.util.Iterator;

public class a {
    private ArrayList a = null;
    private float b = Float.MAX_VALUE;
    private BDLocation c = null;
    private long d;
    private LocationClient e;
    private Context f;
    private int g;
    private long h;
    private boolean i;
    private PendingIntent j;
    private AlarmManager k;
    private a$a l;
    private a$b m;
    private boolean n;

    public a(Context object, LocationClient locationClient) {
        a$b a$b;
        long l10;
        this.d = l10 = 0L;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = l10;
        this.i = false;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = a$b = new a$b(this);
        this.n = false;
        this.f = object;
        this.e = locationClient;
        locationClient.registerNotifyLocationListener(a$b);
        object = (AlarmManager)this.f.getSystemService("alarm");
        this.k = object;
        super(this);
        this.l = object;
        this.n = false;
    }

    public static /* synthetic */ ArrayList a(a a10) {
        return a10.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(long l10) {
        try {
            AlarmManager alarmManager;
            PendingIntent pendingIntent = this.j;
            if (pendingIntent != null) {
                alarmManager = this.k;
                alarmManager.cancel(pendingIntent);
            }
            pendingIntent = this.f;
            String string2 = "android.com.baidu.location.TIMER.NOTIFY";
            alarmManager = new Intent(string2);
            int n10 = 0x8000000;
            this.j = pendingIntent = PendingIntent.getBroadcast((Context)pendingIntent, (int)0, (Intent)alarmManager, (int)n10);
            if (pendingIntent == null) {
                return;
            }
            pendingIntent = this.k;
            long l11 = System.currentTimeMillis() + l10;
            PendingIntent pendingIntent2 = this.j;
            pendingIntent.set(0, l11, pendingIntent2);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void a(BDLocation bDLocation) {
        Object object;
        a a10 = this;
        BDLocation bDLocation2 = bDLocation;
        int n10 = bDLocation.getLocType();
        int n11 = 61;
        float f10 = 8.5E-44f;
        if (n10 != n11) {
            n10 = bDLocation.getLocType();
            n11 = 161;
            f10 = 2.26E-43f;
            if (n10 != n11) {
                n10 = bDLocation.getLocType();
                n11 = 65;
                f10 = 9.1E-44f;
                if (n10 != n11) {
                    this.a(120000L);
                    return;
                }
            }
        }
        long l10 = System.currentTimeMillis();
        long l11 = a10.d;
        long l12 = (l10 -= l11) - (l11 = 5000L);
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n10 >= 0 && (object = a10.a) != null) {
            a10.c = bDLocation2;
            a10.d = l10 = System.currentTimeMillis();
            n10 = 1;
            float[] fArray = new float[n10];
            n11 = 0x7F7FFFFF;
            f10 = Float.MAX_VALUE;
            ArrayList arrayList = a10.a;
            Iterator iterator2 = arrayList.iterator();
            float f11 = f10;
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                Object e10;
                Object object2 = e10 = iterator2.next();
                object2 = (BDNotifyListener)e10;
                double d10 = bDLocation.getLatitude();
                double d11 = bDLocation.getLongitude();
                double d12 = ((BDNotifyListener)object2).mLatitudeC;
                double d13 = ((BDNotifyListener)object2).mLongitudeC;
                object = object2;
                object2 = fArray;
                Location.distanceBetween((double)d10, (double)d11, (double)d12, (double)d13, (float[])fArray);
                f10 = fArray[0];
                float f12 = ((BDNotifyListener)object).mRadius;
                f10 -= f12;
                f12 = bDLocation.getRadius();
                f10 -= f12;
                f12 = 0.0f;
                arrayList = null;
                float f13 = f10 - 0.0f;
                float f14 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                if (f14 > 0) {
                    n10 = (int)(f10 == f11 ? 0 : (f10 < f11 ? -1 : 1));
                    if (n10 < 0) {
                        f11 = f10;
                    }
                } else {
                    n11 = ((BDNotifyListener)object).Notified;
                    f14 = 3;
                    f12 = 4.2E-45f;
                    if (n11 < f14) {
                        ((BDNotifyListener)object).Notified = ++n11;
                        f10 = fArray[0];
                        ((BDNotifyListener)object).onNotify(bDLocation2, f10);
                        n10 = ((BDNotifyListener)object).Notified;
                        if (n10 < f14) {
                            n10 = 1;
                            a10.i = n10;
                            continue;
                        }
                    }
                }
                n10 = 1;
            }
            float f15 = a10.b;
            float f16 = f11 - f15;
            Object object3 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
            if (object3 < 0) {
                a10.b = f11;
            }
            a10.g = 0;
            this.c();
        }
    }

    public static /* synthetic */ void a(a a10, BDLocation bDLocation) {
        a10.a(bDLocation);
    }

    public static /* synthetic */ LocationClient b(a a10) {
        return a10.e;
    }

    private boolean b() {
        boolean bl2;
        Object object = this.a;
        boolean bl3 = false;
        if (object != null && !(bl2 = ((ArrayList)object).isEmpty())) {
            int n10;
            object = this.a.iterator();
            while ((n10 = object.hasNext()) != 0) {
                BDNotifyListener bDNotifyListener = (BDNotifyListener)object.next();
                n10 = bDNotifyListener.Notified;
                int n11 = 3;
                if (n10 >= n11) continue;
                bl3 = true;
            }
        }
        return bl3;
    }

    private void c() {
        long l10;
        boolean bl2;
        int n10;
        int n11;
        block14: {
            block13: {
                n11 = this.b();
                if (n11 == 0) {
                    return;
                }
                float f10 = this.b;
                float f11 = 5000.0f;
                Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
                n10 = 10000;
                float f12 = 1.4013E-41f;
                if (object > 0) {
                    n11 = 600000;
                    f10 = 8.40779E-40f;
                } else {
                    f11 = 1000.0f;
                    float f13 = f10 - f11;
                    object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                    if (object > 0) {
                        n11 = 120000;
                        f10 = 1.68156E-40f;
                    } else {
                        object = 1140457472;
                        f11 = 500.0f;
                        float f14 = f10 - f11;
                        n11 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
                        if (n11 > 0) {
                            n11 = 60000;
                            f10 = 8.4078E-41f;
                        } else {
                            n11 = n10;
                            f10 = f12;
                        }
                    }
                }
                object = this.i;
                bl2 = false;
                if (object != false) {
                    this.i = false;
                } else {
                    n10 = n11;
                    f12 = f10;
                }
                n11 = this.g;
                if (n11 == 0) break block13;
                long l11 = this.h;
                l10 = n11;
                l11 += l10;
                l10 = System.currentTimeMillis();
                l10 = n10;
                long l12 = l10 - (l11 -= l10);
                n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n11 > 0) break block14;
            }
            bl2 = true;
        }
        if (bl2) {
            this.g = n10;
            this.h = l10 = System.currentTimeMillis();
            n11 = this.g;
            l10 = n11;
            this.a(l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public int a(BDNotifyListener object) {
        int n10;
        block9: {
            block7: {
                float[] fArray;
                float f10;
                Object object2;
                block8: {
                    BDLocation bDLocation;
                    double d10;
                    double d11;
                    String string2;
                    Object object3;
                    a$a a$a;
                    ArrayList<Object> arrayList = this.a;
                    if (arrayList == null) {
                        this.a = arrayList = new ArrayList<Object>();
                    }
                    arrayList = this.a;
                    arrayList.add(object);
                    n10 = 1;
                    ((BDNotifyListener)object).isAdded = n10;
                    ((BDNotifyListener)object).mNotifyCache = this;
                    boolean bl2 = this.n;
                    if (!bl2) {
                        Context context = this.f;
                        a$a = this.l;
                        object2 = new IntentFilter("android.com.baidu.location.TIMER.NOTIFY");
                        boolean bl3 = false;
                        f10 = 0.0f;
                        object3 = "android.permission.ACCESS_FINE_LOCATION";
                        context.registerReceiver((BroadcastReceiver)a$a, (IntentFilter)object2, (String)object3, null);
                        this.n = n10;
                    }
                    if ((string2 = ((BDNotifyListener)object).mCoorType) == null) {
                        return n10;
                    }
                    boolean bl4 = string2.equals("gcj02");
                    a$a = null;
                    if (!bl4) {
                        d11 = ((BDNotifyListener)object).mLongitude;
                        d10 = ((BDNotifyListener)object).mLatitude;
                        StringBuilder stringBuilder = new StringBuilder();
                        String string3 = ((BDNotifyListener)object).mCoorType;
                        stringBuilder.append(string3);
                        string3 = "2gcj";
                        stringBuilder.append(string3);
                        String string4 = stringBuilder.toString();
                        double[] dArray = Jni.coorEncrypt(d11, d10, string4);
                        ((BDNotifyListener)object).mLongitudeC = d11 = dArray[0];
                        ((BDNotifyListener)object).mLatitudeC = d11 = dArray[n10];
                    }
                    if ((bDLocation = this.c) == null) break block7;
                    long l10 = System.currentTimeMillis();
                    long l11 = this.d;
                    l10 -= l11;
                    l11 = 30000L;
                    d10 = 1.4822E-319;
                    Object object4 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (object4 > 0) break block7;
                    fArray = new float[n10];
                    object2 = this.c;
                    d11 = ((BDLocation)object2).getLatitude();
                    object3 = this.c;
                    d10 = ((BDLocation)object3).getLongitude();
                    double d12 = ((BDNotifyListener)object).mLatitudeC;
                    double d13 = ((BDNotifyListener)object).mLongitudeC;
                    Location.distanceBetween((double)d11, (double)d10, (double)d12, (double)d13, (float[])fArray);
                    float f11 = fArray[0];
                    f10 = ((BDNotifyListener)object).mRadius;
                    f11 -= f10;
                    f10 = this.c.getRadius();
                    f11 -= f10;
                    f10 = 0.0f;
                    float f12 = f11 - 0.0f;
                    float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
                    if (f13 <= 0) break block8;
                    float f14 = this.b;
                    float f15 = f11 - f14;
                    Object object5 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                    if (object5 < 0) {
                        this.b = f11;
                    }
                    break block9;
                }
                int n11 = ((BDNotifyListener)object).Notified;
                int n12 = 3;
                f10 = 4.2E-45f;
                if (n11 < n12) {
                    ((BDNotifyListener)object).Notified = n11 += n10;
                    object2 = this.c;
                    float f16 = fArray[0];
                    ((BDNotifyListener)object).onNotify((BDLocation)object2, f16);
                    int n13 = ((BDNotifyListener)object).Notified;
                    if (n13 < n12) {
                        this.i = n10;
                    }
                }
                break block9;
            }
            object = this.e;
            ((LocationClient)object).requestNotifyLocation();
        }
        this.c();
        return n10;
    }

    public void a() {
        long l10;
        Object object;
        PendingIntent pendingIntent = this.j;
        if (pendingIntent != null) {
            object = this.k;
            object.cancel(pendingIntent);
        }
        pendingIntent = null;
        this.c = null;
        this.d = l10 = 0L;
        boolean bl2 = this.n;
        if (bl2) {
            pendingIntent = this.f;
            object = this.l;
            pendingIntent.unregisterReceiver((BroadcastReceiver)object);
        }
        this.n = false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void b(BDNotifyListener object) {
        block7: {
            block5: {
                float f10;
                BDLocation bDLocation;
                int n10;
                Object object2;
                block6: {
                    double d10;
                    Object object3;
                    object2 = ((BDNotifyListener)object).mCoorType;
                    if (object2 == null) {
                        return;
                    }
                    boolean bl2 = ((String)object2).equals("gcj02");
                    n10 = 1;
                    if (!bl2) {
                        object3 = ((BDNotifyListener)object).mLongitude;
                        d10 = ((BDNotifyListener)object).mLatitude;
                        object2 = new StringBuilder();
                        String string2 = ((BDNotifyListener)object).mCoorType;
                        ((StringBuilder)object2).append(string2);
                        string2 = "2gcj";
                        ((StringBuilder)object2).append(string2);
                        object2 = ((StringBuilder)object2).toString();
                        object2 = Jni.coorEncrypt(object3, d10, (String)object2);
                        ((BDNotifyListener)object).mLongitudeC = object3 = (Object)object2[0];
                        ((BDNotifyListener)object).mLatitudeC = object3 = (Object)object2[n10];
                    }
                    if ((object2 = this.c) == null) break block5;
                    long l10 = System.currentTimeMillis();
                    long l11 = this.d;
                    l10 -= l11;
                    l11 = 300000L;
                    d10 = 1.482197E-318;
                    Object object4 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (object4 > 0) break block5;
                    object2 = new float[n10];
                    bDLocation = this.c;
                    object3 = bDLocation.getLatitude();
                    BDLocation bDLocation2 = this.c;
                    d10 = bDLocation2.getLongitude();
                    double d11 = ((BDNotifyListener)object).mLatitudeC;
                    double d12 = ((BDNotifyListener)object).mLongitudeC;
                    Location.distanceBetween((double)object3, (double)d10, (double)d11, (double)d12, (float[])object2);
                    reference var20_15 = object2[0];
                    f10 = ((BDNotifyListener)object).mRadius;
                    var20_15 -= f10;
                    f10 = this.c.getRadius();
                    var20_15 -= f10;
                    f10 = 0.0f;
                    reference cfr_temp_0 = var20_15 - 0.0f;
                    reference var22_17 = cfr_temp_0 == 0 ? 0 : (cfr_temp_0 > 0 ? 1 : -1);
                    if (var22_17 <= 0) break block6;
                    float f11 = this.b;
                    reference cfr_temp_1 = var20_15 - f11;
                    Object object5 = cfr_temp_1 == 0 ? 0 : (cfr_temp_1 < 0 ? -1 : 1);
                    if (object5 < 0) {
                        this.b = (float)var20_15;
                    }
                    break block7;
                }
                int n11 = ((BDNotifyListener)object).Notified;
                int n12 = 3;
                f10 = 4.2E-45f;
                if (n11 < n12) {
                    ((BDNotifyListener)object).Notified = n11 += n10;
                    bDLocation = this.c;
                    Object object6 = object2[0];
                    ((BDNotifyListener)object).onNotify(bDLocation, (float)object6);
                    int n13 = ((BDNotifyListener)object).Notified;
                    if (n13 < n12) {
                        this.i = n10;
                    }
                }
                break block7;
            }
            object = this.e;
            ((LocationClient)object).requestNotifyLocation();
        }
        this.c();
    }

    public int c(BDNotifyListener object) {
        int n10;
        ArrayList arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        boolean bl2 = arrayList.contains(object);
        if (bl2) {
            arrayList = this.a;
            arrayList.remove(object);
        }
        if ((n10 = ((ArrayList)(object = this.a)).size()) == 0 && (object = this.j) != null) {
            arrayList = this.k;
            arrayList.cancel((PendingIntent)object);
        }
        return 1;
    }
}

