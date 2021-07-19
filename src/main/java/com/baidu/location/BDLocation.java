/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.Address;
import com.baidu.location.Address$Builder;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.baidu.location.a;
import com.baidu.location.h.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class BDLocation
implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Parcelable.Creator CREATOR;
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int MOCK_GPS_TYPE_FALSE = 0;
    public static final int MOCK_GPS_TYPE_TRUE = 1;
    public static final int MOCK_GPS_TYPE_UNKNOWN = 255;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = 255;
    private int A;
    private String B;
    private int C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private String K;
    private List L;
    private String M;
    private String N;
    private String O;
    private Bundle P;
    private int Q;
    private int R;
    private long S;
    private String T;
    private double U;
    private double V;
    private boolean W;
    private PoiRegion X;
    private float Y;
    private int Z;
    private int a;
    private BDLocation aa;
    private String b;
    private double c;
    private double d;
    private boolean e;
    private double f;
    private boolean g;
    private float h;
    private boolean i;
    private float j;
    private boolean k;
    private int l;
    private float m;
    private String n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private Address u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private int z;

    static {
        a a10 = new a();
        CREATOR = a10;
    }

    public BDLocation() {
        float f10;
        int n10;
        double d10;
        this.a = 0;
        this.b = null;
        this.c = d10 = Double.MIN_VALUE;
        this.d = d10;
        this.e = false;
        this.f = d10;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = n10 = -1;
        this.m = f10 = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        Object object = new Address$Builder();
        this.u = object = ((Address$Builder)object).build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = n10;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        object = new Bundle();
        this.P = object;
        this.Q = 0;
        this.R = 0;
        this.S = 0L;
        this.T = null;
        this.U = d10;
        this.V = d10;
        this.W = false;
        this.X = null;
        this.Y = f10;
        this.Z = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private BDLocation(Parcel parcel) {
        double d10;
        long l10;
        float f10;
        long l11;
        Object object;
        int n10;
        int n11;
        float f11;
        Object object2;
        double d11;
        BDLocation bDLocation = this;
        Parcel parcel2 = parcel;
        int n12 = 0;
        ArrayList arrayList = null;
        this.a = 0;
        this.b = null;
        this.c = d11 = Double.MIN_VALUE;
        this.d = d11;
        this.e = false;
        this.f = d11;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = object2 = -1;
        this.m = f11 = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        Object object3 = new Address$Builder();
        this.u = object3 = ((Address$Builder)object3).build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = n11 = 1;
        this.B = null;
        this.D = "";
        this.E = object2;
        this.F = 0;
        this.G = n10 = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = object = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = l11 = 0L;
        this.T = null;
        this.U = d11;
        this.V = d11;
        this.W = false;
        this.X = null;
        this.Y = f11;
        this.Z = object2;
        this.a = object2 = parcel.readInt();
        Object object4 = parcel.readString();
        this.b = object4;
        this.c = d11 = parcel.readDouble();
        this.d = d11 = parcel.readDouble();
        this.f = d11 = parcel.readDouble();
        this.h = f10 = parcel.readFloat();
        this.j = f10 = parcel.readFloat();
        this.l = object2 = parcel.readInt();
        this.m = f10 = parcel.readFloat();
        object4 = parcel.readString();
        this.v = object4;
        this.z = object2 = parcel.readInt();
        object4 = parcel.readString();
        this.w = object4;
        object4 = parcel.readString();
        this.x = object4;
        object4 = parcel.readString();
        this.B = object4;
        object4 = parcel.readString();
        Object object5 = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        object = parcel.readString();
        String string4 = parcel.readString();
        parcel.readString();
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        Address$Builder address$Builder = new Address$Builder();
        address$Builder = address$Builder.country(string5).countryCode(string6);
        this.u = object4 = address$Builder.province((String)object4).city((String)object5).cityCode(string4).district(string2).street(string3).streetNumber((String)object).adcode(string7).town(string8).build();
        object5 = new boolean[8];
        this.C = object2 = parcel.readInt();
        this.D = object4 = parcel.readString();
        this.q = object4 = parcel.readString();
        this.r = object4 = parcel.readString();
        this.s = object4 = parcel.readString();
        this.A = object2 = parcel.readInt();
        this.M = object4 = parcel.readString();
        this.E = object2 = parcel.readInt();
        this.F = object2 = parcel.readInt();
        this.G = object2 = parcel.readInt();
        this.H = object2 = parcel.readInt();
        this.I = object4 = parcel.readString();
        this.J = object4 = parcel.readString();
        this.K = object4 = parcel.readString();
        this.Q = object2 = parcel.readInt();
        this.N = object4 = parcel.readString();
        this.R = object2 = parcel.readInt();
        this.O = object4 = parcel.readString();
        this.T = object4 = parcel.readString();
        this.S = l10 = parcel.readLong();
        this.U = d10 = parcel.readDouble();
        this.V = d10 = parcel.readDouble();
        this.Y = f10 = parcel.readFloat();
        this.Z = object2 = parcel.readInt();
        this.n = object4 = parcel.readString();
        object4 = BDLocation.class;
        try {
            object4 = ((Class)object4).getClassLoader();
            object4 = parcel.readParcelable((ClassLoader)object4);
            this.aa = object4 = (BDLocation)object4;
        }
        catch (Exception exception) {
            bDLocation.aa = null;
            exception.printStackTrace();
        }
        try {
            parcel2.readBooleanArray((boolean[])object5);
            object2 = object5[0];
            bDLocation.e = object2;
            object2 = object5[n11];
            bDLocation.g = object2;
            n12 = 2;
            object2 = object5[n12];
            bDLocation.i = object2;
            object2 = 3;
            f10 = 4.2E-45f;
            object2 = object5[object2];
            bDLocation.k = object2;
            object2 = 4;
            f10 = 5.6E-45f;
            object2 = object5[object2];
            bDLocation.o = object2;
            object2 = 5;
            f10 = 7.0E-45f;
            object2 = object5[object2];
            bDLocation.t = object2;
            object2 = 6;
            f10 = 8.4E-45f;
            object2 = object5[object2];
            bDLocation.y = object2;
            object2 = 7;
            f10 = 9.8E-45f;
            object2 = object5[object2];
            bDLocation.W = object2;
        }
        catch (Exception exception) {}
        arrayList = new ArrayList();
        object4 = Poi.class;
        try {
            object4 = ((Class)object4).getClassLoader();
            parcel2.readList(arrayList, (ClassLoader)object4);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        object2 = arrayList.size();
        bDLocation.L = object2 == 0 ? null : arrayList;
        try {
            object4 = parcel.readBundle();
            bDLocation.P = object4;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object4 = new Bundle();
            bDLocation.P = object4;
        }
        object4 = PoiRegion.class;
        try {
            object4 = ((Class)object4).getClassLoader();
            object4 = parcel2.readParcelable((ClassLoader)object4);
            bDLocation.X = object4 = (PoiRegion)object4;
            return;
        }
        catch (Exception exception) {
            bDLocation.X = null;
            exception.printStackTrace();
        }
    }

    public /* synthetic */ BDLocation(Parcel parcel, a a10) {
        this(parcel);
    }

    /*
     * Enabled aggressive block sorting
     */
    public BDLocation(BDLocation bDLocation) {
        float f10;
        int n10;
        long l10;
        float f11;
        int n11;
        int n12;
        float f12;
        int n13;
        double d10;
        Object object = null;
        this.a = 0;
        ArrayList<Poi> arrayList = null;
        this.b = null;
        this.c = d10 = Double.MIN_VALUE;
        this.d = d10;
        this.e = false;
        this.f = d10;
        this.g = false;
        String string2 = null;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = n13 = -1;
        this.m = f12 = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        Object object2 = new Address$Builder();
        this.u = object2 = ((Address$Builder)object2).build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = n13;
        this.F = 0;
        this.G = n12 = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        object2 = new Bundle();
        this.P = object2;
        this.Q = 0;
        this.R = 0;
        long l11 = 0L;
        double d11 = 0.0;
        this.S = l11;
        this.T = null;
        this.U = d10;
        this.V = d10;
        this.W = false;
        this.X = null;
        this.Y = f12;
        this.Z = n13;
        this.a = n11 = bDLocation.a;
        Object object3 = bDLocation.b;
        this.b = object3;
        this.c = d10 = bDLocation.c;
        this.d = d10 = bDLocation.d;
        n11 = (int)(bDLocation.e ? 1 : 0);
        this.e = n11;
        this.f = d10 = bDLocation.f;
        n11 = (int)(bDLocation.g ? 1 : 0);
        this.g = n11;
        this.h = f11 = bDLocation.h;
        n11 = (int)(bDLocation.i ? 1 : 0);
        this.i = n11;
        this.j = f11 = bDLocation.j;
        n11 = (int)(bDLocation.k ? 1 : 0);
        this.k = n11;
        this.l = n11 = bDLocation.l;
        this.m = f11 = bDLocation.m;
        object3 = bDLocation.n;
        this.n = object3;
        n11 = (int)(bDLocation.o ? 1 : 0);
        this.o = n11;
        object3 = bDLocation.p;
        this.p = object3;
        n11 = (int)(bDLocation.t ? 1 : 0);
        this.t = n11;
        object3 = new Address$Builder();
        Object object4 = bDLocation.u.country;
        object3 = ((Address$Builder)object3).country((String)object4);
        object4 = bDLocation.u.countryCode;
        object3 = ((Address$Builder)object3).countryCode((String)object4);
        object4 = bDLocation.u.province;
        object3 = ((Address$Builder)object3).province((String)object4);
        object4 = bDLocation.u.city;
        object3 = ((Address$Builder)object3).city((String)object4);
        object4 = bDLocation.u.cityCode;
        object3 = ((Address$Builder)object3).cityCode((String)object4);
        object4 = bDLocation.u.district;
        object3 = ((Address$Builder)object3).district((String)object4);
        object4 = bDLocation.u.street;
        object3 = ((Address$Builder)object3).street((String)object4);
        object4 = bDLocation.u.streetNumber;
        object3 = ((Address$Builder)object3).streetNumber((String)object4);
        object4 = bDLocation.u.adcode;
        object3 = ((Address$Builder)object3).adcode((String)object4);
        object4 = bDLocation.u.town;
        this.u = object3 = ((Address$Builder)object3).town((String)object4).build();
        this.v = object3 = bDLocation.v;
        this.w = object3 = bDLocation.w;
        this.x = object3 = bDLocation.x;
        this.A = n11 = bDLocation.A;
        this.z = n11 = bDLocation.z;
        n11 = (int)(bDLocation.y ? 1 : 0);
        this.y = n11;
        this.B = object3 = bDLocation.B;
        this.C = n11 = bDLocation.C;
        this.D = object3 = bDLocation.D;
        this.q = object3 = bDLocation.q;
        this.r = object3 = bDLocation.r;
        this.s = object3 = bDLocation.s;
        this.E = n11 = bDLocation.E;
        this.F = n11 = bDLocation.F;
        this.G = n11 = bDLocation.F;
        this.H = n11 = bDLocation.H;
        this.I = object3 = bDLocation.I;
        this.J = object3 = bDLocation.J;
        this.K = object3 = bDLocation.K;
        this.Q = n11 = bDLocation.Q;
        this.O = object3 = bDLocation.O;
        this.U = d10 = bDLocation.U;
        this.V = d10 = bDLocation.V;
        this.S = l10 = bDLocation.S;
        this.Z = n11 = bDLocation.Z;
        this.aa = object3 = bDLocation.aa;
        this.N = object3 = bDLocation.N;
        object3 = bDLocation.L;
        if (object3 != null) {
            arrayList = new ArrayList<Poi>();
            for (n10 = 0; n10 < (n11 = (object3 = bDLocation.L).size()); ++n10) {
                Poi poi;
                object3 = (Poi)bDLocation.L.get(n10);
                string2 = ((Poi)object3).getId();
                String string3 = ((Poi)object3).getName();
                d11 = ((Poi)object3).getRank();
                String string4 = ((Poi)object3).getTags();
                String string5 = ((Poi)object3).getAddr();
                object4 = poi;
                poi = new Poi(string2, string3, d11, string4, string5);
                arrayList.add(poi);
            }
        }
        this.L = arrayList;
        object = bDLocation.M;
        this.M = object;
        object = bDLocation.P;
        this.P = object;
        this.R = n10 = bDLocation.R;
        n10 = (int)(bDLocation.W ? 1 : 0);
        this.W = n10;
        this.X = object = bDLocation.X;
        this.Y = f10 = bDLocation.Y;
    }

    /*
     * Exception decompiling
     */
    public BDLocation(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 43[TRYBLOCK] [84, 85 : 847->852)] java.lang.Exception
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void a(Boolean bl2) {
        boolean bl3;
        this.t = bl3 = bl2.booleanValue();
    }

    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.u.adcode;
    }

    public String getAddrStr() {
        return this.u.address;
    }

    public Address getAddress() {
        return this.u;
    }

    public double getAltitude() {
        return this.f;
    }

    public String getBuildingID() {
        return this.w;
    }

    public String getBuildingName() {
        return this.x;
    }

    public String getCity() {
        return this.u.city;
    }

    public String getCityCode() {
        return this.u.cityCode;
    }

    public String getCoorType() {
        return this.n;
    }

    public String getCountry() {
        return this.u.country;
    }

    public String getCountryCode() {
        return this.u.countryCode;
    }

    public long getDelayTime() {
        return this.S;
    }

    public float getDerect() {
        return this.m;
    }

    public float getDirection() {
        return this.m;
    }

    public String getDistrict() {
        return this.u.district;
    }

    public Location getExtraLocation(String string2) {
        boolean bl2;
        Bundle bundle = this.P;
        if (bundle != null && (bl2 = (string2 = bundle.getParcelable(string2)) instanceof Location)) {
            return (Location)string2;
        }
        return null;
    }

    public String getFloor() {
        return this.v;
    }

    public double[] getFusionLocInfo(String string2) {
        return this.P.getDoubleArray(string2);
    }

    public int getGpsAccuracyStatus() {
        return this.Q;
    }

    public float getGpsBiasProb() {
        return this.Y;
    }

    public int getGpsCheckStatus() {
        return this.R;
    }

    public int getIndoorLocationSource() {
        return this.H;
    }

    public int getIndoorLocationSurpport() {
        return this.F;
    }

    public String getIndoorLocationSurpportBuidlingID() {
        return this.J;
    }

    public String getIndoorLocationSurpportBuidlingName() {
        return this.I;
    }

    public int getIndoorNetworkState() {
        return this.G;
    }

    public String getIndoorSurpportPolygon() {
        return this.K;
    }

    public double getLatitude() {
        return this.c;
    }

    public int getLocType() {
        return this.a;
    }

    public String getLocTypeDescription() {
        return this.M;
    }

    public String getLocationDescribe() {
        return this.q;
    }

    public String getLocationID() {
        return this.N;
    }

    public int getLocationWhere() {
        return this.A;
    }

    public double getLongitude() {
        return this.d;
    }

    public String getNetworkLocationType() {
        return this.B;
    }

    public double getNrlLat() {
        return this.U;
    }

    public double getNrlLon() {
        return this.V;
    }

    public String getNrlResult() {
        return this.T;
    }

    public int getOperators() {
        return this.C;
    }

    public List getPoiList() {
        return this.L;
    }

    public PoiRegion getPoiRegion() {
        return this.X;
    }

    public String getProvince() {
        return this.u.province;
    }

    public float getRadius() {
        return this.j;
    }

    public BDLocation getReallLocation() {
        int n10;
        int n11 = this.isMockGps();
        if (n11 == (n10 = 1)) {
            return this.aa;
        }
        return null;
    }

    public String getRetFields(String string2) {
        return this.P.getString(string2);
    }

    public String getRoadLocString() {
        return this.O;
    }

    public int getSatelliteNumber() {
        this.k = true;
        return this.l;
    }

    public String getSemaAptag() {
        return this.q;
    }

    public float getSpeed() {
        return this.h;
    }

    public String getStreet() {
        return this.u.street;
    }

    public String getStreetNumber() {
        return this.u.streetNumber;
    }

    public String getTime() {
        return this.b;
    }

    public String getTown() {
        return this.u.town;
    }

    public int getUserIndoorState() {
        return this.E;
    }

    public String getVdrJsonString() {
        String string2;
        boolean bl2;
        Object object = this.P;
        if (object != null && (bl2 = object.containsKey(string2 = "vdr"))) {
            object = this.P.getString(string2);
        } else {
            bl2 = false;
            object = null;
        }
        return object;
    }

    public boolean hasAddr() {
        return this.o;
    }

    public boolean hasAltitude() {
        return this.e;
    }

    public boolean hasRadius() {
        return this.i;
    }

    public boolean hasSateNumber() {
        return this.k;
    }

    public boolean hasSpeed() {
        return this.g;
    }

    public boolean isCellChangeFlag() {
        return this.t;
    }

    public boolean isInIndoorPark() {
        return this.W;
    }

    public boolean isIndoorLocMode() {
        return this.y;
    }

    public int isMockGps() {
        return this.Z;
    }

    public boolean isNrlAvailable() {
        double d10;
        double d11 = this.V;
        double d12 = Double.MIN_VALUE;
        double d13 = d11 - d12;
        Object object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        object = object != false && (object = (d10 = (d11 = this.U) - d12) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1)) != false ? (Object)true : (Object)false;
        return (boolean)object;
    }

    public int isParkAvailable() {
        return this.z;
    }

    public void setAddr(Address address) {
        if (address != null) {
            boolean bl2;
            this.u = address;
            this.o = bl2 = true;
        }
    }

    public void setAddrStr(String string2) {
        boolean bl2;
        this.p = string2;
        if (string2 == null) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        this.o = bl2;
    }

    public void setAltitude(double d10) {
        double d11 = 9999.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object < 0) {
            boolean bl2;
            this.f = d10;
            this.e = bl2 = true;
        }
    }

    public void setBuildingID(String string2) {
        this.w = string2;
    }

    public void setBuildingName(String string2) {
        this.x = string2;
    }

    public void setCoorType(String string2) {
        this.n = string2;
    }

    public void setDelayTime(long l10) {
        this.S = l10;
    }

    public void setDirection(float f10) {
        this.m = f10;
    }

    public void setExtraLocation(String string2, Location location) {
        Bundle bundle = this.P;
        if (bundle == null) {
            this.P = bundle = new Bundle();
        }
        this.P.putParcelable(string2, (Parcelable)location);
    }

    public void setFloor(String string2) {
        this.v = string2;
    }

    public void setFusionLocInfo(String string2, double[] dArray) {
        Bundle bundle = this.P;
        if (bundle == null) {
            this.P = bundle = new Bundle();
        }
        this.P.putDoubleArray(string2, dArray);
    }

    public void setGpsAccuracyStatus(int n10) {
        this.Q = n10;
    }

    public void setGpsBiasProb(float f10) {
        this.Y = f10;
    }

    public void setGpsCheckStatus(int n10) {
        this.R = n10;
    }

    public void setIndoorLocMode(boolean bl2) {
        this.y = bl2;
    }

    public void setIndoorLocationSource(int n10) {
        this.H = n10;
    }

    public void setIndoorLocationSurpport(int n10) {
        this.F = n10;
    }

    public void setIndoorNetworkState(int n10) {
        this.G = n10;
    }

    public void setIndoorSurpportPolygon(String string2) {
        this.K = string2;
    }

    public void setIsInIndoorPark(boolean bl2) {
        this.W = bl2;
    }

    public void setIsMockGps(int n10) {
        this.Z = n10;
    }

    public void setLatitude(double d10) {
        this.c = d10;
    }

    /*
     * Unable to fully structure code
     */
    public void setLocType(int var1_1) {
        block6: {
            block7: {
                block8: {
                    block9: {
                        block10: {
                            block11: {
                                block12: {
                                    this.a = var1_1;
                                    var2_2 = 66;
                                    if (var1_1 == var2_2) break block7;
                                    var2_2 = 67;
                                    if (var1_1 == var2_2) break block8;
                                    var2_2 = 161;
                                    if (var1_1 == var2_2) break block9;
                                    var2_2 = 162;
                                    if (var1_1 == var2_2) break block10;
                                    var2_2 = 167;
                                    if (var1_1 == var2_2) break block11;
                                    var2_2 = 505;
                                    if (var1_1 == var2_2) break block12;
                                    switch (var1_1) {
                                        default: {
                                            var3_3 = "UnKnown!";
                                            ** GOTO lbl20
                                        }
                                        case 62: {
                                            var3_3 = "Location failed beacuse we can not get any loc information!";
lbl20:
                                            // 8 sources

                                            while (true) {
                                                this.setLocTypeDescription(var3_3);
                                                break block6;
                                                break;
                                            }
                                        }
                                        case 61: {
                                            this.setLocTypeDescription("GPS location successful!");
                                            var1_1 = 0;
                                            var3_4 = null;
                                            this.setUserIndoorState(0);
                                            break block6;
                                        }
                                    }
                                }
                                var3_3 = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
                                ** GOTO lbl20
                            }
                            var3_3 = "NetWork location failed because baidu location service can not caculate the location!";
                            ** GOTO lbl20
                        }
                        var3_3 = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                        ** GOTO lbl20
                    }
                    var3_3 = "NetWork location successful!";
                    ** GOTO lbl20
                    {
                        ** case 63:
                    }
                }
                var3_3 = "Offline location failed, please check the net (wifi/cell)!";
                ** GOTO lbl20
            }
            var3_3 = "Offline location successful!";
            ** while (true)
        }
    }

    public void setLocTypeDescription(String string2) {
        this.M = string2;
    }

    public void setLocationDescribe(String string2) {
        this.q = string2;
    }

    public void setLocationID(String string2) {
        this.N = string2;
    }

    public void setLocationWhere(int n10) {
        this.A = n10;
    }

    public void setLongitude(double d10) {
        this.d = d10;
    }

    public void setNetworkLocationType(String string2) {
        this.B = string2;
    }

    public void setNrlData(String string2) {
        this.T = string2;
    }

    public void setOperators(int n10) {
        this.C = n10;
    }

    public void setParkAvailable(int n10) {
        this.z = n10;
    }

    public void setPoiList(List list) {
        this.L = list;
    }

    public void setPoiRegion(PoiRegion poiRegion) {
        this.X = poiRegion;
    }

    public void setRadius(float f10) {
        this.j = f10;
        this.i = true;
    }

    public void setReallLocation(BDLocation bDLocation) {
        int n10;
        int n11 = this.isMockGps();
        if (n11 == (n10 = 1)) {
            this.aa = bDLocation;
        }
    }

    public void setRetFields(String string2, String string3) {
        Bundle bundle = this.P;
        if (bundle == null) {
            this.P = bundle = new Bundle();
        }
        this.P.putString(string2, string3);
    }

    public void setRoadLocString(float f10, float f11) {
        Object object;
        Object object2;
        Object[] objectArray;
        double d10 = f10;
        double d11 = 0.001;
        double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        Object[] objectArray2 = "%.2f";
        String string2 = "";
        int n10 = 1;
        if (d12 > 0) {
            objectArray = new Object[n10];
            objectArray[0] = object2 = Float.valueOf(f10);
            object2 = String.format((String)objectArray2, objectArray);
        } else {
            object2 = string2;
        }
        double d13 = f11;
        d12 = d13 == d11 ? 0 : (d13 > d11 ? 1 : -1);
        if (d12 > 0) {
            objectArray = new Object[n10];
            objectArray[0] = object = Float.valueOf(f11);
            string2 = String.format((String)objectArray2, objectArray);
        }
        if ((object = this.T) != null) {
            objectArray = Locale.US;
            int n11 = 3;
            objectArray2 = new Object[n11];
            objectArray2[0] = object;
            objectArray2[n10] = object2;
            int n12 = 2;
            f10 = 2.8E-45f;
            objectArray2[n12] = string2;
            this.O = object2 = String.format((Locale)objectArray, "%s|%s,%s", objectArray2);
        }
    }

    public void setSatelliteNumber(int n10) {
        this.l = n10;
    }

    public void setSpeed(float f10) {
        this.h = f10;
        this.g = true;
    }

    public void setTime(String string2) {
        this.b = string2;
        string2 = com.baidu.location.h.l.a(string2);
        this.setLocationID(string2);
    }

    public void setUserIndoorState(int n10) {
        this.E = n10;
    }

    public void setVdrJsonValue(String string2) {
        Bundle bundle = this.P;
        if (bundle == null) {
            this.P = bundle = new Bundle();
        }
        this.P.putString("vdr", string2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&loctype=");
        int n10 = this.getLocType();
        stringBuilder.append(n10);
        stringBuilder.append("&lat=");
        double d10 = this.getLatitude();
        stringBuilder.append(d10);
        stringBuilder.append("&lon=");
        d10 = this.getLongitude();
        stringBuilder.append(d10);
        stringBuilder.append("&radius=");
        float f10 = this.getRadius();
        stringBuilder.append(f10);
        stringBuilder.append("&biasprob=");
        f10 = this.getGpsBiasProb();
        stringBuilder.append(f10);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = this.a;
        parcel.writeInt(n11);
        Object object = this.b;
        parcel.writeString((String)object);
        double d10 = this.c;
        parcel.writeDouble(d10);
        d10 = this.d;
        parcel.writeDouble(d10);
        d10 = this.f;
        parcel.writeDouble(d10);
        float f10 = this.h;
        parcel.writeFloat(f10);
        f10 = this.j;
        parcel.writeFloat(f10);
        n11 = this.l;
        parcel.writeInt(n11);
        f10 = this.m;
        parcel.writeFloat(f10);
        object = this.v;
        parcel.writeString((String)object);
        n11 = this.z;
        parcel.writeInt(n11);
        object = this.w;
        parcel.writeString((String)object);
        object = this.x;
        parcel.writeString((String)object);
        object = this.B;
        parcel.writeString((String)object);
        object = this.u.province;
        parcel.writeString((String)object);
        object = this.u.city;
        parcel.writeString((String)object);
        object = this.u.district;
        parcel.writeString((String)object);
        object = this.u.street;
        parcel.writeString((String)object);
        object = this.u.streetNumber;
        parcel.writeString((String)object);
        object = this.u.cityCode;
        parcel.writeString((String)object);
        object = this.u.address;
        parcel.writeString((String)object);
        object = this.u.country;
        parcel.writeString((String)object);
        object = this.u.countryCode;
        parcel.writeString((String)object);
        object = this.u.adcode;
        parcel.writeString((String)object);
        object = this.u.town;
        parcel.writeString((String)object);
        n11 = this.C;
        parcel.writeInt(n11);
        object = this.D;
        parcel.writeString((String)object);
        object = this.q;
        parcel.writeString((String)object);
        object = this.r;
        parcel.writeString((String)object);
        object = this.s;
        parcel.writeString((String)object);
        n11 = this.A;
        parcel.writeInt(n11);
        object = this.M;
        parcel.writeString((String)object);
        n11 = this.E;
        parcel.writeInt(n11);
        n11 = this.F;
        parcel.writeInt(n11);
        n11 = this.G;
        parcel.writeInt(n11);
        n11 = this.H;
        parcel.writeInt(n11);
        object = this.I;
        parcel.writeString((String)object);
        object = this.J;
        parcel.writeString((String)object);
        object = this.K;
        parcel.writeString((String)object);
        n11 = this.Q;
        parcel.writeInt(n11);
        object = this.N;
        parcel.writeString((String)object);
        n11 = this.R;
        parcel.writeInt(n11);
        object = this.O;
        parcel.writeString((String)object);
        object = this.T;
        parcel.writeString((String)object);
        long l10 = this.S;
        parcel.writeLong(l10);
        d10 = this.U;
        parcel.writeDouble(d10);
        d10 = this.V;
        parcel.writeDouble(d10);
        f10 = this.Y;
        parcel.writeFloat(f10);
        n11 = this.Z;
        parcel.writeInt(n11);
        object = this.n;
        parcel.writeString((String)object);
        object = this.aa;
        parcel.writeParcelable((Parcelable)object, n10);
        object = new boolean[8];
        boolean bl2 = this.e;
        object[0] = bl2;
        bl2 = this.g;
        object[1] = bl2;
        bl2 = this.i;
        object[2] = bl2;
        bl2 = this.k;
        object[3] = bl2;
        bl2 = this.o;
        object[4] = bl2;
        bl2 = this.t;
        object[5] = bl2;
        bl2 = this.y;
        object[6] = bl2;
        bl2 = this.W;
        object[7] = bl2;
        parcel.writeBooleanArray((boolean[])object);
        object = this.L;
        parcel.writeList((List)object);
        object = this.P;
        parcel.writeBundle((Bundle)object);
        object = this.X;
        parcel.writeParcelable((Parcelable)object, n10);
    }
}

