/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.baidu.geofence;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.geofence.PoiItem;
import com.baidu.geofence.a;
import com.baidu.geofence.model.DPoint;
import com.baidu.geofence.model.DistrictItem;
import com.baidu.location.BDLocation;
import java.util.ArrayList;
import java.util.List;

public class GeoFence
implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 7;
    public static final String BUNDLE_KEY_CUSTOMID = "2";
    public static final String BUNDLE_KEY_FENCE = "5";
    public static final String BUNDLE_KEY_FENCEID = "1";
    public static final String BUNDLE_KEY_FENCESTATUS = "3";
    public static final String BUNDLE_KEY_LOCERRORCODE = "4";
    public static final Parcelable.Creator CREATOR;
    public static final int ERROR_CODE_EXISTS = 14;
    public static final int ERROR_CODE_FAILURE_AUTH = 11;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 9;
    public static final int ERROR_CODE_FAILURE_PARSER = 10;
    public static final int ERROR_CODE_INVALID_PARAMETER = 8;
    public static final int ERROR_CODE_UNKNOWN = 12;
    public static final int ERROR_NO_VALIDFENCE = 13;
    public static final int INIT_STATUS_IN = 24;
    public static final int INIT_STATUS_OUT = 25;
    public static final int STATUS_IN = 15;
    public static final int STATUS_LOCFAIL = 18;
    public static final int STATUS_OUT = 16;
    public static final int STATUS_STAYED = 17;
    public static final int STATUS_UNKNOWN = 19;
    public static final int TYPE_BDMAPPOI = 22;
    public static final int TYPE_DISTRICT = 23;
    public static final int TYPE_POLYGON = 21;
    public static final int TYPE_ROUND = 20;
    private String a;
    private String b;
    private int c;
    private DistrictItem d;
    private PoiItem e;
    private int f = 19;
    private boolean g = false;
    private DPoint h;
    private boolean i;
    private BDLocation j;
    private String k;
    private float l;
    private String m;
    private String n;
    private long o;
    private long p;
    private boolean q;
    private boolean r;
    private boolean s;
    private ArrayList t;
    private int u;
    private int v;
    private int w;

    static {
        a a10 = new a();
        CREATOR = a10;
    }

    public GeoFence() {
        this.i = true;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private GeoFence(Parcel parcel) {
        long l10;
        float f10;
        int n10;
        int n11 = 1;
        this.i = n11;
        this.q = false;
        this.r = false;
        this.s = false;
        int n12 = 0;
        boolean[] blArray = null;
        this.t = null;
        Object object = parcel.readString();
        this.a = object;
        object = parcel.readString();
        this.b = object;
        object = parcel.readString();
        this.m = object;
        this.c = n10 = parcel.readInt();
        this.f = n10 = parcel.readInt();
        object = parcel.readString();
        this.k = object;
        this.l = f10 = parcel.readFloat();
        object = parcel.readString();
        this.n = object;
        this.o = l10 = parcel.readLong();
        this.p = l10 = parcel.readLong();
        object = new ArrayList();
        Object object2 = DPoint.class;
        object2 = ((Class)object2).getClassLoader();
        try {
            parcel.readList(object, (ClassLoader)object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        int n13 = ((ArrayList)object).size();
        this.t = n13 == 0 ? null : object;
        object = BDLocation.class;
        object = ((Class)object).getClassLoader();
        object = parcel.readParcelable((ClassLoader)object);
        object = (BDLocation)object;
        try {
            this.j = object;
        }
        catch (Exception exception) {
            this.j = null;
            exception.printStackTrace();
        }
        object = DPoint.class;
        object = ((Class)object).getClassLoader();
        object = parcel.readParcelable((ClassLoader)object);
        object = (DPoint)object;
        try {
            this.h = object;
        }
        catch (Exception exception) {
            this.h = null;
            exception.printStackTrace();
        }
        object = PoiItem.class;
        object = ((Class)object).getClassLoader();
        object = parcel.readParcelable((ClassLoader)object);
        object = (PoiItem)object;
        try {
            this.e = object;
        }
        catch (Exception exception) {
            this.e = null;
            exception.printStackTrace();
        }
        object = DistrictItem.class;
        object = ((Class)object).getClassLoader();
        object = parcel.readParcelable((ClassLoader)object);
        object = (DistrictItem)object;
        try {
            this.d = object;
        }
        catch (Exception exception) {
            this.d = null;
            exception.printStackTrace();
        }
        this.u = n12 = parcel.readInt();
        this.v = n12 = parcel.readInt();
        this.w = n12 = parcel.readInt();
        n12 = 5;
        blArray = new boolean[n12];
        try {
            parcel.readBooleanArray(blArray);
        }
        catch (Exception exception) {
            return;
        }
        int n14 = blArray[0];
        this.i = n14;
        n14 = blArray[n11];
        this.g = n14;
        n14 = 2;
        n14 = blArray[n14];
        this.q = n14;
        n14 = 3;
        n14 = blArray[n14];
        this.r = n14;
        n14 = 4;
        n14 = blArray[n14];
        this.s = n14;
    }

    public /* synthetic */ GeoFence(Parcel parcel, a a10) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String getActivatesAction() {
        return this.k;
    }

    public DPoint getCenter() {
        return this.h;
    }

    public BDLocation getCurrentLocation() {
        return this.j;
    }

    public String getCustomId() {
        return this.b;
    }

    public long getEndTimeMillis() {
        return this.p;
    }

    public String getFenceId() {
        return this.a;
    }

    public int getInTriggerCount() {
        return this.u;
    }

    public String getKeyWord() {
        return this.m;
    }

    public int getOutTriggerCount() {
        return this.v;
    }

    public PoiItem getPoiItem() {
        int n10 = this.c;
        int n11 = 22;
        if (n10 == n11) {
            return this.e;
        }
        return null;
    }

    public ArrayList getPoints() {
        return this.t;
    }

    public float getRadius() {
        return this.l;
    }

    public String getRegion() {
        return this.n;
    }

    public long getStartTimeMillis() {
        return this.o;
    }

    public int getStatus() {
        return this.f;
    }

    public int getStayTriggerCount() {
        return this.w;
    }

    public int getType() {
        return this.c;
    }

    public boolean isAble() {
        return this.i;
    }

    public boolean isIn() {
        return this.q;
    }

    public boolean isOneSecond() {
        return this.s;
    }

    public boolean isOut() {
        return this.r;
    }

    public boolean isSend() {
        return this.g;
    }

    public void setAble(boolean bl2) {
        this.i = bl2;
    }

    public void setActivatesAction(String string2) {
        this.k = string2;
    }

    public void setCenter(DPoint dPoint) {
        this.h = dPoint;
    }

    public void setCurrentLoc(BDLocation bDLocation) {
        this.j = bDLocation;
    }

    public void setCustomId(String string2) {
        this.b = string2;
    }

    public void setEndTimeMillis(long l10) {
        this.p = l10;
    }

    public void setFenceId(String string2) {
        this.a = string2;
    }

    public void setFenceType(int n10) {
        this.c = n10;
    }

    public void setIn(boolean bl2) {
        this.q = bl2;
    }

    public void setInTriggerCount(int n10) {
        this.u = n10;
    }

    public void setKeyWord(String string2) {
        this.m = string2;
    }

    public void setOneSecond(boolean bl2) {
        this.s = bl2;
    }

    public void setOut(boolean bl2) {
        this.r = bl2;
    }

    public void setOutTriggerCount(int n10) {
        this.v = n10;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.e = poiItem;
    }

    public void setPoints(ArrayList arrayList) {
        this.t = arrayList;
    }

    public void setRadius(float f10) {
        this.l = f10;
    }

    public void setRegion(String string2) {
        this.n = string2;
    }

    public void setSend(boolean bl2) {
        this.g = bl2;
    }

    public void setStartTimeMillis(long l10) {
        this.o = l10;
    }

    public void setStatus(int n10) {
        this.f = n10;
    }

    public void setStayTriggerCount(int n10) {
        this.w = n10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.a;
        parcel.writeString((String)object);
        object = this.b;
        parcel.writeString((String)object);
        object = this.m;
        parcel.writeString((String)object);
        int bl2 = this.c;
        parcel.writeInt(bl2);
        int n11 = this.f;
        parcel.writeInt(n11);
        object = this.k;
        parcel.writeString((String)object);
        float f10 = this.l;
        parcel.writeFloat(f10);
        object = this.n;
        parcel.writeString((String)object);
        long l10 = this.o;
        parcel.writeLong(l10);
        l10 = this.p;
        parcel.writeLong(l10);
        object = this.t;
        parcel.writeList((List)object);
        object = this.j;
        parcel.writeParcelable((Parcelable)object, n10);
        object = this.h;
        parcel.writeParcelable((Parcelable)object, n10);
        object = this.e;
        parcel.writeParcelable((Parcelable)object, n10);
        object = this.d;
        parcel.writeParcelable((Parcelable)object, n10);
        n10 = this.u;
        parcel.writeInt(n10);
        n10 = this.v;
        parcel.writeInt(n10);
        n10 = this.w;
        parcel.writeInt(n10);
        boolean bl7 = this.i;
        bl7 = this.g;
        bl7 = this.q;
        bl7 = this.r;
        bl7 = this.s;
        boolean[] blArray = new boolean[]{bl3, bl4, bl5, bl6, bl7};
        parcel.writeBooleanArray(blArray);
    }
}

