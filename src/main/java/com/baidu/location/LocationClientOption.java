/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.baidu.location;

import android.text.TextUtils;
import com.baidu.location.LocationClientOption$1;
import com.baidu.location.LocationClientOption$BDLocationPurpose;
import com.baidu.location.LocationClientOption$LocationMode;

public final class LocationClientOption {
    public static final int GpsFirst = 1;
    public static final int GpsOnly = 3;
    public static final int LOC_SENSITIVITY_HIGHT = 1;
    public static final int LOC_SENSITIVITY_LOW = 3;
    public static final int LOC_SENSITIVITY_MIDDLE = 2;
    public static final int MIN_AUTO_NOTIFY_INTERVAL = 10000;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NetWorkFirst = 2;
    public LocationClientOption$LocationMode a;
    public String addrType = "noaddr";
    public float autoNotifyLocSensitivity;
    public int autoNotifyMaxInterval;
    public int autoNotifyMinDistance;
    public int autoNotifyMinTimeInterval;
    public String coorType = "gcj02";
    public boolean disableLocCache;
    public boolean enableSimulateGps;
    public boolean isIgnoreCacheException;
    public boolean isIgnoreKillProcess;
    public boolean isNeedAltitude;
    public boolean isNeedAptag;
    public boolean isNeedAptagd;
    public boolean isNeedNewVersionRgc;
    public boolean isNeedPoiRegion;
    public boolean isNeedRealLocWhenIsMock;
    public boolean isNeedRegular;
    public boolean isOnceLocation;
    public double judgeMockDisValue;
    public boolean location_change_notify;
    public boolean mIsNeedDeviceDirect;
    public boolean openGps = false;
    public int priority;
    public String prodName = "SDK6.0";
    public int scanSpan = 0;
    public String serviceName;
    public int timeOut = 12000;
    public int wifiCacheTimeOut;

    public LocationClientOption() {
        int n10;
        this.priority = n10 = 1;
        this.location_change_notify = false;
        this.disableLocCache = n10;
        this.enableSimulateGps = false;
        this.judgeMockDisValue = 500.0;
        this.isNeedRealLocWhenIsMock = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = n10;
        this.isIgnoreKillProcess = n10;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.isNeedNewVersionRgc = n10;
        this.isOnceLocation = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = -1 >>> 1;
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        boolean bl2;
        double d10;
        float f10;
        int n10;
        Object object;
        int n11;
        this.priority = n11 = 1;
        this.location_change_notify = false;
        this.disableLocCache = n11;
        this.enableSimulateGps = false;
        this.judgeMockDisValue = 500.0;
        this.isNeedRealLocWhenIsMock = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = n11;
        this.isIgnoreKillProcess = n11;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.isNeedNewVersionRgc = n11;
        this.isOnceLocation = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = -1 >>> 1;
        this.coorType = object = locationClientOption.coorType;
        this.addrType = object = locationClientOption.addrType;
        this.openGps = n10 = locationClientOption.openGps;
        this.scanSpan = n10 = locationClientOption.scanSpan;
        this.timeOut = n10 = locationClientOption.timeOut;
        this.prodName = object = locationClientOption.prodName;
        this.priority = n10 = locationClientOption.priority;
        n10 = (int)(locationClientOption.location_change_notify ? 1 : 0);
        this.location_change_notify = n10;
        this.serviceName = object = locationClientOption.serviceName;
        n10 = (int)(locationClientOption.disableLocCache ? 1 : 0);
        this.disableLocCache = n10;
        n10 = (int)(locationClientOption.isIgnoreCacheException ? 1 : 0);
        this.isIgnoreCacheException = n10;
        n10 = (int)(locationClientOption.isIgnoreKillProcess ? 1 : 0);
        this.isIgnoreKillProcess = n10;
        n10 = (int)(locationClientOption.enableSimulateGps ? 1 : 0);
        this.enableSimulateGps = n10;
        object = locationClientOption.a;
        this.a = object;
        n10 = (int)(locationClientOption.isNeedAptag ? 1 : 0);
        this.isNeedAptag = n10;
        n10 = (int)(locationClientOption.isNeedAptagd ? 1 : 0);
        this.isNeedAptagd = n10;
        n10 = (int)(locationClientOption.isNeedPoiRegion ? 1 : 0);
        this.isNeedPoiRegion = n10;
        n10 = (int)(locationClientOption.isNeedRegular ? 1 : 0);
        this.isNeedRegular = n10;
        n10 = (int)(locationClientOption.mIsNeedDeviceDirect ? 1 : 0);
        this.mIsNeedDeviceDirect = n10;
        n10 = (int)(locationClientOption.isNeedAltitude ? 1 : 0);
        this.isNeedAltitude = n10;
        this.autoNotifyMaxInterval = n10 = locationClientOption.autoNotifyMaxInterval;
        this.autoNotifyLocSensitivity = f10 = locationClientOption.autoNotifyLocSensitivity;
        this.autoNotifyMinTimeInterval = n10 = locationClientOption.autoNotifyMinTimeInterval;
        this.autoNotifyMinDistance = n10 = locationClientOption.autoNotifyMinDistance;
        this.wifiCacheTimeOut = n10 = locationClientOption.wifiCacheTimeOut;
        n10 = (int)(locationClientOption.isNeedNewVersionRgc ? 1 : 0);
        this.isNeedNewVersionRgc = n10;
        n10 = (int)(locationClientOption.isOnceLocation ? 1 : 0);
        this.isOnceLocation = n10;
        this.judgeMockDisValue = d10 = locationClientOption.judgeMockDisValue;
        this.isNeedRealLocWhenIsMock = bl2 = locationClientOption.isNeedRealLocWhenIsMock;
    }

    public void SetIgnoreCacheException(boolean bl2) {
        this.isIgnoreCacheException = bl2;
    }

    public int a() {
        return this.autoNotifyMaxInterval;
    }

    public float b() {
        return this.autoNotifyLocSensitivity;
    }

    public void disableCache(boolean bl2) {
        this.disableLocCache = bl2;
    }

    public String getAddrType() {
        return this.addrType;
    }

    public int getAutoNotifyMinDistance() {
        return this.autoNotifyMinDistance;
    }

    public int getAutoNotifyMinTimeInterval() {
        return this.autoNotifyMinTimeInterval;
    }

    public String getCoorType() {
        return this.coorType;
    }

    public double getJudgeMockDisValue() {
        return this.judgeMockDisValue;
    }

    public LocationClientOption$LocationMode getLocationMode() {
        return this.a;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getProdName() {
        return this.prodName;
    }

    public int getScanSpan() {
        return this.scanSpan;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public boolean isDisableCache() {
        return this.disableLocCache;
    }

    public boolean isLocationNotify() {
        return this.location_change_notify;
    }

    public boolean isNeedRealLocWhenIsMock() {
        return this.isNeedRealLocWhenIsMock;
    }

    public boolean isOnceLocation() {
        return this.isOnceLocation;
    }

    public boolean isOpenGps() {
        return this.openGps;
    }

    public boolean optionEquals(LocationClientOption locationClientOption) {
        int n10;
        double d10;
        double d11;
        double d12;
        float f10;
        float f11;
        float f12;
        int n11;
        Object object = this.coorType;
        Object object2 = locationClientOption.coorType;
        int n12 = object.equals(object2);
        return n12 != 0 && (n12 = (object = this.addrType).equals(object2 = locationClientOption.addrType)) != 0 && (n12 = this.openGps) == (n11 = locationClientOption.openGps) && (n12 = this.scanSpan) == (n11 = locationClientOption.scanSpan) && (n12 = this.timeOut) == (n11 = locationClientOption.timeOut) && (n12 = (int)((object = this.prodName).equals(object2 = locationClientOption.prodName) ? 1 : 0)) != 0 && (n12 = (int)(this.location_change_notify ? 1 : 0)) == (n11 = (int)(locationClientOption.location_change_notify ? 1 : 0)) && (n12 = this.priority) == (n11 = locationClientOption.priority) && (n12 = (int)(this.disableLocCache ? 1 : 0)) == (n11 = (int)(locationClientOption.disableLocCache ? 1 : 0)) && (n12 = (int)(this.isIgnoreCacheException ? 1 : 0)) == (n11 = (int)(locationClientOption.isIgnoreCacheException ? 1 : 0)) && (n12 = (int)(this.isNeedNewVersionRgc ? 1 : 0)) == (n11 = (int)(locationClientOption.isNeedNewVersionRgc ? 1 : 0)) && (n12 = (int)(this.isIgnoreKillProcess ? 1 : 0)) == (n11 = (int)(locationClientOption.isIgnoreKillProcess ? 1 : 0)) && (n12 = (int)(this.isNeedAptag ? 1 : 0)) == (n11 = (int)(locationClientOption.isNeedAptag ? 1 : 0)) && (n12 = (int)(this.isNeedAptagd ? 1 : 0)) == (n11 = (int)(locationClientOption.isNeedAptagd ? 1 : 0)) && (n12 = (int)(this.isNeedPoiRegion ? 1 : 0)) == (n11 = (int)(locationClientOption.isNeedPoiRegion ? 1 : 0)) && (n12 = (int)(this.isNeedRegular ? 1 : 0)) == (n11 = (int)(locationClientOption.isNeedRegular ? 1 : 0)) && (n12 = (int)(this.mIsNeedDeviceDirect ? 1 : 0)) == (n11 = (int)(locationClientOption.mIsNeedDeviceDirect ? 1 : 0)) && (n12 = this.autoNotifyMaxInterval) == (n11 = locationClientOption.autoNotifyMaxInterval) && (n12 = (int)((f12 = (f11 = this.autoNotifyLocSensitivity) - (f10 = locationClientOption.autoNotifyLocSensitivity)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) == 0 && (n12 = this.autoNotifyMinTimeInterval) == (n11 = locationClientOption.autoNotifyMinTimeInterval) && (n12 = this.autoNotifyMinDistance) == (n11 = locationClientOption.autoNotifyMinDistance) && (n12 = this.wifiCacheTimeOut) == (n11 = locationClientOption.wifiCacheTimeOut) && (n12 = (int)(this.isOnceLocation ? 1 : 0)) == (n11 = (int)(locationClientOption.isOnceLocation ? 1 : 0)) && (n12 = (int)(this.isNeedAltitude ? 1 : 0)) == (n11 = (int)(locationClientOption.isNeedAltitude ? 1 : 0)) && (object = this.a) == (object2 = locationClientOption.a) && (n12 = (int)((d12 = (d11 = this.judgeMockDisValue) - (d10 = locationClientOption.judgeMockDisValue)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1))) == 0 && (n12 = (int)(this.isNeedRealLocWhenIsMock ? 1 : 0)) == (n10 = locationClientOption.isNeedRealLocWhenIsMock);
    }

    public void setAddrType(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        String string3 = "all";
        boolean bl3 = string3.equals(string2);
        if (bl3) {
            bl3 = true;
        } else {
            bl3 = false;
            string2 = null;
        }
        this.setIsNeedAddress(bl3);
    }

    public void setCoorType(String string2) {
        String string3;
        boolean bl2 = (string2 = string2.toLowerCase()).equals(string3 = "gcj02");
        if (bl2 || (bl2 = string2.equals(string3 = "bd09")) || (bl2 = string2.equals(string3 = "bd09ll"))) {
            this.coorType = string2;
        }
    }

    public void setEnableSimulateGps(boolean bl2) {
        this.enableSimulateGps = bl2;
    }

    public void setIgnoreKillProcess(boolean bl2) {
        this.isIgnoreKillProcess = bl2;
    }

    public void setIsNeedAddress(boolean bl2) {
        String string2 = bl2 ? "all" : "noaddr";
        this.addrType = string2;
    }

    public void setIsNeedAltitude(boolean bl2) {
        this.isNeedAltitude = bl2;
    }

    public void setIsNeedLocationDescribe(boolean bl2) {
        this.isNeedAptag = bl2;
    }

    public void setIsNeedLocationPoiList(boolean bl2) {
        this.isNeedAptagd = bl2;
    }

    public void setJudgeMockDisValue(double d10) {
        this.judgeMockDisValue = d10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setLocationMode(LocationClientOption$LocationMode object) {
        int[] nArray = LocationClientOption$1.a;
        int n10 = ((Enum)object).ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 1)) {
            int n12 = 2;
            if (n11 != n12) {
                n12 = 3;
                if (n11 != n12) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Illegal this mode : ");
                    stringBuilder.append(object);
                    String string2 = stringBuilder.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                    throw illegalArgumentException;
                }
                this.priority = n12;
                this.openGps = n10;
            } else {
                n11 = 0;
                Object var2_5 = null;
                this.openGps = false;
                this.priority = n12;
            }
        } else {
            this.openGps = n10;
            this.priority = n10;
        }
        this.a = object;
    }

    public void setLocationNotify(boolean bl2) {
        this.location_change_notify = bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setLocationPurpose(LocationClientOption$BDLocationPurpose enum_) {
        if (enum_ == null) return;
        LocationClientOption$BDLocationPurpose locationClientOption$BDLocationPurpose = LocationClientOption$BDLocationPurpose.SignIn;
        boolean bl2 = true;
        if (enum_ == locationClientOption$BDLocationPurpose) {
            enum_ = LocationClientOption$LocationMode.Hight_Accuracy;
            this.setLocationMode((LocationClientOption$LocationMode)enum_);
            this.setLocationNotify(false);
            this.setScanSpan(0);
            this.setNeedNewVersionRgc(bl2);
            this.setIsNeedAddress(bl2);
            this.setIsNeedLocationPoiList(bl2);
            this.setIsNeedAltitude(bl2);
            this.setIsNeedLocationDescribe(bl2);
            int n10 = 10000;
            this.setWifiCacheTimeOut(n10);
            return;
        }
        locationClientOption$BDLocationPurpose = LocationClientOption$BDLocationPurpose.Sport;
        int n11 = 1000;
        if (enum_ == locationClientOption$BDLocationPurpose) {
            enum_ = LocationClientOption$LocationMode.Hight_Accuracy;
            this.setLocationMode((LocationClientOption$LocationMode)enum_);
            this.setLocationNotify(bl2);
            int n12 = 3000;
            this.setScanSpan(n12);
        } else {
            locationClientOption$BDLocationPurpose = LocationClientOption$BDLocationPurpose.Transport;
            if (enum_ != locationClientOption$BDLocationPurpose) return;
            enum_ = LocationClientOption$LocationMode.Hight_Accuracy;
            this.setLocationMode((LocationClientOption$LocationMode)enum_);
            this.setLocationNotify(bl2);
            this.setScanSpan(n11);
        }
        this.setNeedNewVersionRgc(bl2);
        this.setIsNeedAddress(bl2);
        this.setIsNeedLocationPoiList(false);
        this.setIsNeedAltitude(bl2);
        this.setIsNeedLocationDescribe(false);
        this.setWifiCacheTimeOut(n11);
    }

    public void setNeedDeviceDirect(boolean bl2) {
        this.mIsNeedDeviceDirect = bl2;
    }

    public void setNeedNewVersionRgc(boolean bl2) {
        this.isNeedNewVersionRgc = bl2;
    }

    public void setNeedRealLocWhenIsMock(boolean bl2) {
        this.isNeedRealLocWhenIsMock = bl2;
    }

    public void setOnceLocation(boolean bl2) {
        this.isOnceLocation = bl2;
    }

    public void setOpenAutoNotifyMode() {
        this.setOpenAutoNotifyMode(0, 0, 1);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setOpenAutoNotifyMode(int n10, int n11, int n12) {
        float f10;
        int n13;
        int n14 = 180000;
        if (n10 > n14) {
            n14 = n10 + 1000;
        }
        if (n14 < (n13 = 10000)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal this maxLocInterval : ");
            stringBuilder.append(n14);
            stringBuilder.append(" , maxLocInterval must >= ");
            stringBuilder.append(n13);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        n13 = 1;
        if (n12 != n13) {
            n13 = 2;
            if (n12 != n13) {
                n13 = 3;
                if (n12 != n13) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Illegal this locSensitivity : ");
                    stringBuilder.append(n12);
                    String string3 = stringBuilder.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
                    throw illegalArgumentException;
                }
                n12 = 0x3DCCCCCD;
                f10 = 0.1f;
            } else {
                n12 = 1050253722;
                f10 = 0.3f;
            }
        } else {
            n12 = 0x3F000000;
            f10 = 0.5f;
        }
        this.autoNotifyLocSensitivity = f10;
        this.autoNotifyMaxInterval = n14;
        this.autoNotifyMinTimeInterval = n10;
        this.autoNotifyMinDistance = n11;
    }

    public void setOpenGps(boolean bl2) {
        this.openGps = bl2;
    }

    public void setPriority(int n10) {
        int n11 = 1;
        if (n10 == n11 || n10 == (n11 = 2)) {
            this.priority = n10;
        }
    }

    public void setProdName(String string2) {
        int n10;
        int n11 = string2.length();
        if (n11 > (n10 = 64)) {
            n11 = 0;
            string2 = string2.substring(0, n10);
        }
        this.prodName = string2;
    }

    public void setScanSpan(int n10) {
        if (n10 >= 0) {
            this.scanSpan = n10;
        }
    }

    public void setSema(boolean bl2, boolean bl3, boolean bl4) {
        this.isNeedAptag = bl2;
        this.isNeedPoiRegion = bl3;
        this.isNeedRegular = bl4;
    }

    public void setServiceName(String string2) {
        this.serviceName = string2;
    }

    public void setTimeOut(int n10) {
        this.timeOut = n10;
    }

    public void setWifiCacheTimeOut(int n10) {
        int n11 = 10000;
        if (n10 >= n11) {
            this.wifiCacheTimeOut = n10;
        }
    }
}

