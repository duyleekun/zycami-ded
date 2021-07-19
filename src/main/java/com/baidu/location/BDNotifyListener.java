/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.baidu.location;

import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.d.a;

public abstract class BDNotifyListener {
    public int Notified;
    public float differDistance;
    public boolean isAdded;
    public String mCoorType;
    public double mLatitude;
    public double mLatitudeC;
    public double mLongitude;
    public double mLongitudeC;
    public a mNotifyCache;
    public float mRadius;

    public BDNotifyListener() {
        double d10;
        this.mLatitude = d10 = Double.MIN_VALUE;
        this.mLongitude = d10;
        this.mRadius = 0.0f;
        this.differDistance = 0.0f;
        this.mCoorType = null;
        this.mLatitudeC = d10;
        this.mLongitudeC = d10;
        this.Notified = 0;
        this.isAdded = false;
        this.mNotifyCache = null;
    }

    public void SetNotifyLocation(double d10, double d11, float f10, String string2) {
        String string3;
        this.mLatitude = d10;
        this.mLongitude = d11;
        float f11 = 0.0f;
        Object object = null;
        float f12 = f10 - 0.0f;
        Object object2 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object2 < 0) {
            object2 = 1128792064;
            this.mRadius = f11 = 200.0f;
        } else {
            this.mRadius = f10;
        }
        object = "gcj02";
        boolean bl2 = string2.equals(object);
        this.mCoorType = !(bl2 || (bl2 = string2.equals(string3 = "bd09")) || (bl2 = string2.equals(string3 = "bd09ll")) || (bl2 = string2.equals(string3 = "gps"))) ? object : string2;
        string3 = this.mCoorType;
        object2 = string3.equals(object);
        if (object2 != false) {
            this.mLatitudeC = d10 = this.mLatitude;
            this.mLongitudeC = d10 = this.mLongitude;
        }
        if ((object2 = (Object)this.isAdded) != false) {
            object2 = false;
            f11 = 0.0f;
            this.Notified = 0;
            object = this.mNotifyCache;
            ((a)object).b(this);
        }
    }

    public void onNotify(BDLocation object, float f10) {
        object = new StringBuilder();
        ((StringBuilder)object).append("new location, not far from the destination...");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        Log.d((String)"baidu_location_service", (String)object);
    }
}

