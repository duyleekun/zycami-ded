/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.p;

import android.content.Context;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption$LocationMode;

public class c {
    private LocationClient a = null;
    private LocationClientOption b;
    private LocationClientOption c;
    private Object d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c(Context object) {
        Object object2;
        this.d = object2 = new Object();
        synchronized (object2) {
            LocationClient locationClient = this.a;
            if (locationClient == null) {
                this.a = locationClient = new LocationClient((Context)object);
                object = this.a();
                locationClient.setLocOption((LocationClientOption)object);
            }
            return;
        }
    }

    public LocationClientOption a() {
        LocationClientOption locationClientOption = this.b;
        if (locationClientOption == null) {
            this.b = locationClientOption = new LocationClientOption();
            Object object = LocationClientOption$LocationMode.Hight_Accuracy;
            locationClientOption.setLocationMode((LocationClientOption$LocationMode)((Object)object));
            locationClientOption = this.b;
            object = "gcj02";
            locationClientOption.setCoorType((String)object);
            this.b.setScanSpan(3000);
            locationClientOption = this.b;
            boolean bl2 = true;
            locationClientOption.setIsNeedAddress(bl2);
            this.b.setIsNeedLocationDescribe(bl2);
            this.b.setNeedDeviceDirect(false);
            this.b.setLocationNotify(false);
            this.b.setIgnoreKillProcess(bl2);
            this.b.setIsNeedLocationDescribe(bl2);
            this.b.setIsNeedLocationPoiList(bl2);
            this.b.SetIgnoreCacheException(false);
            this.b.setOpenGps(bl2);
            locationClientOption = this.b;
            locationClientOption.setIsNeedAltitude(false);
        }
        return this.b;
    }

    public LocationClientOption b() {
        LocationClientOption locationClientOption = this.c;
        if (locationClientOption == null) {
            this.c = locationClientOption = new LocationClientOption();
        }
        return this.c;
    }

    public boolean c() {
        return this.a.isStarted();
    }

    public boolean d(BDAbstractLocationListener bDAbstractLocationListener) {
        boolean bl2;
        if (bDAbstractLocationListener != null) {
            LocationClient locationClient = this.a;
            locationClient.registerLocationListener(bDAbstractLocationListener);
            bl2 = true;
        } else {
            bl2 = false;
            bDAbstractLocationListener = null;
        }
        return bl2;
    }

    public boolean e() {
        return this.a.requestHotSpotState();
    }

    public boolean f(LocationClientOption locationClientOption) {
        if (locationClientOption != null) {
            LocationClient locationClient = this.a;
            boolean bl2 = locationClient.isStarted();
            if (bl2) {
                locationClient = this.a;
                locationClient.stop();
            }
            this.c = locationClientOption;
            locationClient = this.a;
            locationClient.setLocOption(locationClientOption);
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g() {
        Object object = this.d;
        synchronized (object) {
            LocationClient locationClient = this.a;
            if (locationClient != null) {
                locationClient.start();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h() {
        Object object = this.d;
        synchronized (object) {
            boolean bl2;
            LocationClient locationClient = this.a;
            if (locationClient != null && (bl2 = locationClient.isStarted())) {
                locationClient = this.a;
                locationClient.stop();
            }
            return;
        }
    }

    public void i(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener != null) {
            LocationClient locationClient = this.a;
            locationClient.unRegisterLocationListener(bDAbstractLocationListener);
        }
    }
}

