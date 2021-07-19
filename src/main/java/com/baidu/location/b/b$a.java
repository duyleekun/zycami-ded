/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.Parcelable
 */
package com.baidu.location.b;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.b;
import com.baidu.location.b.q;
import com.baidu.location.b.s;
import com.baidu.location.f.f;
import com.baidu.location.h.e;
import com.baidu.location.h.l;
import com.baidu.location.indoor.g;

public class b$a {
    public String a;
    public Messenger b;
    public LocationClientOption c;
    public int d;
    public final /* synthetic */ b e;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public b$a(b var1_1, Message var2_2) {
        block25: {
            block24: {
                this.e = var1_1;
                super();
                this.a = null;
                this.b = null;
                this.c = var3_3 = new LocationClientOption();
                var4_4 = 0;
                var3_3 = null;
                this.d = 0;
                var5_5 = var2_2.replyTo;
                this.b = var5_5;
                var5_5 = var2_2.getData().getString("packName");
                this.a = var5_5;
                var5_5 = this.c;
                var5_5.prodName = var6_6 = var2_2.getData().getString("prodName");
                var5_5 = com.baidu.location.h.b.a();
                var6_6 = this.c.prodName;
                var7_7 = this.a;
                var5_5.a(var6_6, var7_7);
                var5_5 = this.c;
                var5_5.coorType = var6_6 = var2_2.getData().getString("coorType");
                var5_5 = this.c;
                var5_5.addrType = var6_6 = var2_2.getData().getString("addrType");
                var5_5 = this.c;
                var5_5.enableSimulateGps = var8_8 = var2_2.getData().getBoolean("enableSimulateGps", false);
                var5_5 = this.c;
                var6_6 = var2_2.getData();
                var9_9 = 500.0;
                var5_5.judgeMockDisValue = var11_10 = var6_6.getDouble("judgeMockDisValue", var9_9);
                var5_5 = this.c;
                var6_6 = var2_2.getData();
                var7_7 = "isNeedRealLocWhenIsMock";
                var5_5.isNeedRealLocWhenIsMock = var8_8 = var6_6.getBoolean(var7_7, false);
                var13_11 = l.m;
                var8_8 = 1;
                var14_12 = 1.4E-45f;
                if (var13_11) ** GOTO lbl-1000
                var5_5 = this.c;
                var13_11 = var5_5.enableSimulateGps;
                if (!var13_11) {
                    var13_11 = 0;
                    var5_5 = null;
                    var15_13 = 0.0f;
                } else lbl-1000:
                // 2 sources

                {
                    var13_11 = var8_8;
                    var15_13 = var14_12;
                }
                l.m = var13_11;
                var5_5 = this.c;
                l.n = var16_14 = var5_5.judgeMockDisValue;
                l.o = var5_5.isNeedRealLocWhenIsMock;
                var5_5 = l.g;
                var7_7 = "all";
                var13_11 = var5_5.equals(var7_7);
                if (!var13_11) {
                    l.g = var5_5 = this.c.addrType;
                }
                var5_5 = this.c;
                var5_5.openGps = var18_15 = var2_2.getData().getBoolean("openGPS");
                var5_5 = this.c;
                var5_5.scanSpan = var18_15 = var2_2.getData().getInt("scanSpan");
                var5_5 = this.c;
                var5_5.timeOut = var18_15 = var2_2.getData().getInt("timeOut");
                var5_5 = this.c;
                var5_5.priority = var18_15 = var2_2.getData().getInt("priority");
                var5_5 = this.c;
                var18_15 = (int)var2_2.getData().getBoolean("location_change_notify");
                var5_5.location_change_notify = var18_15;
                var5_5 = this.c;
                var18_15 = (int)var2_2.getData().getBoolean("needDirect", false);
                var5_5.mIsNeedDeviceDirect = var18_15;
                var5_5 = this.c;
                var18_15 = (int)var2_2.getData().getBoolean("isneedaltitude", false);
                var5_5.isNeedAltitude = var18_15;
                var5_5 = this.c;
                var7_7 = var2_2.getData();
                var19_16 = "isneednewrgc";
                var18_15 = (int)var7_7.getBoolean(var19_16, false);
                var5_5.isNeedNewVersionRgc = var18_15;
                var13_11 = l.i;
                if (var13_11) ** GOTO lbl-1000
                var5_5 = this.c;
                var13_11 = var5_5.isNeedNewVersionRgc;
                if (!var13_11) {
                    var13_11 = 0;
                    var5_5 = null;
                    var15_13 = 0.0f;
                } else lbl-1000:
                // 2 sources

                {
                    var13_11 = var8_8;
                    var15_13 = var14_12;
                }
                l.i = var13_11;
                var13_11 = l.h;
                if (!var13_11 && !(var13_11 = (var5_5 = var2_2.getData()).getBoolean(var7_7 = "isneedaptag", false))) {
                    var13_11 = 0;
                    var5_5 = null;
                    var15_13 = 0.0f;
                } else {
                    var13_11 = var8_8;
                    var15_13 = var14_12;
                }
                l.h = var13_11;
                var13_11 = l.j;
                if (!var13_11 && !(var13_11 = (var5_5 = var2_2.getData()).getBoolean(var7_7 = "isneedaptagd", false))) {
                    var13_11 = 0;
                    var5_5 = null;
                    var15_13 = 0.0f;
                } else {
                    var13_11 = var8_8;
                    var15_13 = var14_12;
                }
                l.j = var13_11;
                l.U = var15_13 = var2_2.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
                var5_5 = var2_2.getData();
                var18_15 = l.aB;
                var13_11 = var5_5.getInt("wfnum", var18_15);
                var7_7 = var2_2.getData();
                var20_17 = l.aC;
                var21_18 = var7_7.getFloat("wfsm", var20_17);
                var19_16 = var2_2.getData();
                var22_19 = l.aE;
                var23_20 = "gnmcon";
                var24_21 = var19_16.getInt(var23_20, var22_19);
                var25_22 /* !! */  = var2_2.getData();
                var26_23 = l.aD;
                var28_24 = "gnmcrm";
                var29_25 = var25_22 /* !! */ .getDouble(var28_24, var26_23);
                var31_26 = var2_2.getData();
                var32_27 = l.aF;
                var33_28 = "lpcs";
                var34_29 = var31_26.getInt(var33_28, var32_27);
                if (var34_29 == 0) {
                    l.aF = 0;
                }
                if (var24_21 == var8_8) {
                    l.aE = var8_8;
                }
                if ((var24_21 = (int)((cfr_temp_0 = var29_25 - (var35_30 = l.aD)) == 0.0 ? 0 : (cfr_temp_0 > 0.0 ? 1 : -1))) > 0) {
                    l.aD = var29_25;
                }
                var19_16 = var2_2.getData();
                var25_22 /* !! */  = "ischeckper";
                var24_21 = (int)var19_16.getBoolean((String)var25_22 /* !! */ , false);
                var22_19 = (int)l.aA;
                if (var22_19 == 0 && var24_21 == 0) {
                    var24_21 = 0;
                    var19_16 = null;
                    var20_17 = 0.0f;
                } else {
                    var24_21 = var8_8;
                    var20_17 = var14_12;
                }
                l.aA = var24_21;
                var24_21 = l.aB;
                if (var13_11 > var24_21) {
                    l.aB = var13_11;
                }
                if ((var13_11 = (int)((cfr_temp_1 = var21_18 - (var15_13 = l.aC)) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1))) > 0) {
                    l.aC = var21_18;
                }
                var5_5 = var2_2.getData();
                var21_18 = 0.0f / 0.0f;
                var19_16 = "wifitimeout";
                var13_11 = var5_5.getInt(var19_16, -1 >>> 1);
                if (var13_11 < (var18_15 = l.ai)) {
                    l.ai = var13_11;
                }
                if ((var13_11 = (var5_5 = var2_2.getData()).getInt(var7_7 = "autoNotifyMaxInterval", 0)) >= (var18_15 = l.Z)) {
                    l.Z = var13_11;
                }
                if ((var13_11 = (var5_5 = var2_2.getData()).getInt(var7_7 = "autoNotifyMinDistance", 0)) >= (var18_15 = l.ab)) {
                    l.ab = var13_11;
                }
                if ((var37_31 = (var2_2 = var2_2.getData()).getInt((String)(var5_5 = "autoNotifyMinTimeInterval"), 0)) >= (var13_11 = l.aa)) {
                    l.aa = var37_31;
                }
                var2_2 = this.c;
                var13_11 = (int)var2_2.mIsNeedDeviceDirect;
                if (var13_11 || (var37_31 = (int)var2_2.isNeedAltitude) != 0) {
                    var2_2 = s.a();
                    var5_5 = this.c;
                    var13_11 = (int)var5_5.mIsNeedDeviceDirect;
                    var2_2.a((boolean)var13_11);
                    var2_2 = s.a();
                    var2_2.b();
                }
                if ((var37_31 = (int)var1_1.b) != 0) break block24;
                var2_2 = this.c;
                var37_31 = (int)var2_2.isNeedAltitude;
                if (var37_31 == 0) break block25;
            }
            var4_4 = var8_8;
        }
        var1_1.b = var4_4;
    }

    private void a(int n10) {
        block5: {
            Message message;
            block4: {
                Messenger messenger = null;
                message = Message.obtain(null, (int)n10);
                messenger = this.b;
                if (messenger == null) break block4;
                messenger.send(message);
            }
            n10 = 0;
            message = null;
            try {
                this.d = 0;
            }
            catch (Exception exception) {
                n10 = exception instanceof DeadObjectException;
                if (n10 == 0) break block5;
                this.d = n10 = this.d + 1;
            }
        }
    }

    private void a(int n10, Bundle bundle) {
        Message message;
        block5: {
            message = Message.obtain(null, (int)n10);
            message.setData(bundle);
            bundle = this.b;
            if (bundle == null) break block5;
            bundle.send(message);
        }
        n10 = 0;
        message = null;
        try {
            this.d = 0;
        }
        catch (Exception exception) {
            int n11 = exception instanceof DeadObjectException;
            if (n11 != 0) {
                this.d = n11 = this.d + 1;
            }
            exception.printStackTrace();
        }
    }

    private void a(int n10, String object, BDLocation bDLocation) {
        block5: {
            Message message;
            block4: {
                Bundle bundle = new Bundle();
                bundle.putParcelable((String)object, (Parcelable)bDLocation);
                object = BDLocation.class.getClassLoader();
                bundle.setClassLoader((ClassLoader)object);
                object = null;
                message = Message.obtain(null, (int)n10);
                message.setData(bundle);
                object = this.b;
                if (object == null) break block4;
                object.send(message);
            }
            n10 = 0;
            message = null;
            try {
                this.d = 0;
            }
            catch (Exception exception) {
                n10 = exception instanceof DeadObjectException;
                if (n10 == 0) break block5;
                this.d = n10 = this.d + 1;
            }
        }
    }

    public static /* synthetic */ void a(b$a b$a, int n10) {
        b$a.a(n10);
    }

    public static /* synthetic */ void a(b$a b$a, int n10, Bundle bundle) {
        b$a.a(n10, bundle);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void b(BDLocation var1_1) {
        block4: {
            block3: {
                var2_2 = f.a().i();
                var3_3 = 1;
                var4_4 = null;
                if (var2_2 == null) break block3;
                var5_5 = com.baidu.location.h.e.a();
                var10_8 = var5_5.a(var6_6 /* !! */  = var2_2.getLongitude(), var8_7 = var2_2.getLatitude());
                if (var10_8 == 0) ** GOTO lbl-1000
                var11_9 /* !! */  = var2_2.getLongitude();
                var6_6 /* !! */  = var2_2.getLatitude();
                var2_2 = Jni.coorEncrypt(var11_9 /* !! */ , var6_6 /* !! */ , "gps2gcj");
                var11_9 /* !! */  = (double)var2_2[0];
                var6_6 /* !! */  = (double)var2_2[var3_3];
                var2_2 = this.c.coorType;
                var4_4 = Jni.coorEncrypt(var11_9 /* !! */ , var6_6 /* !! */ , (String)var2_2);
                var2_2 = new BDLocation();
                var10_8 = 61;
                var2_2.setLocType(var10_8);
                break block4;
            }
            var2_2 = q.a().c();
            if (var2_2 != null) {
                var4_4 = new BDLocation((BDLocation)var2_2);
                var13_10 /* !! */  = var4_4.getLongitude();
                var15_11 = var4_4.getLatitude();
                var2_2 = this.c.coorType;
                var2_2 = Jni.coorEncrypt(var13_10 /* !! */ , var15_11, (String)var2_2);
                var17_12 = var4_4;
                var4_4 = var2_2;
                var2_2 = var17_12;
            } else lbl-1000:
            // 2 sources

            {
                var2_2 = null;
            }
        }
        if (var4_4 != null && var2_2 != null) {
            var13_10 /* !! */  = (double)var4_4[0];
            var2_2.setLongitude(var13_10 /* !! */ );
            var18_13 = var4_4[var3_3];
            var2_2.setLatitude((double)var18_13);
            var20_14 = this.c.coorType;
            var2_2.setCoorType(var20_14);
            var1_1.setReallLocation((BDLocation)var2_2);
        }
    }

    private void c(BDLocation bDLocation) {
        BDLocation bDLocation2;
        Object object = f.a().i();
        if (object != null) {
            double d10;
            double d11;
            bDLocation2 = new BDLocation((BDLocation)object);
            e e10 = com.baidu.location.h.e.a();
            int n10 = (int)(e10.a(d11 = ((BDLocation)object).getLongitude(), d10 = ((BDLocation)object).getLatitude()) ? 1 : 0);
            if (n10 != 0) {
                Object object2 = ((BDLocation)object).getLongitude();
                double d12 = ((BDLocation)object).getLatitude();
                object = Jni.coorEncrypt(object2, d12, "gps2gcj");
                e10 = null;
                object2 = object[0];
                bDLocation2.setLongitude((double)object2);
                n10 = 1;
                object2 = object[n10];
                bDLocation2.setLatitude((double)object2);
                object = "gcj02";
                bDLocation2.setCoorType((String)object);
                int n11 = 61;
                bDLocation2.setLocType(n11);
            }
        } else {
            object = q.a().c();
            bDLocation2 = object != null ? new BDLocation((BDLocation)object) : null;
        }
        if (bDLocation2 != null) {
            bDLocation.setReallLocation(bDLocation2);
        }
    }

    public void a() {
        this.a(111);
    }

    public void a(BDLocation bDLocation) {
        this.a(bDLocation, 21);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(BDLocation object, int n10) {
        String string2;
        BDLocation bDLocation;
        block5: {
            block4: {
                block7: {
                    double d10;
                    double d11;
                    String string3;
                    int n11;
                    int n12;
                    block6: {
                        bDLocation = new BDLocation((BDLocation)object);
                        object = g.a();
                        n12 = ((g)object).e();
                        n11 = 1;
                        if (n12 != 0) {
                            bDLocation.setIndoorLocMode(n11 != 0);
                        }
                        n12 = 21;
                        string2 = "locStr";
                        if (n10 == n12) {
                            n12 = 27;
                            this.a(n12, string2, bDLocation);
                        }
                        if ((object = this.c.coorType) == null || (n12 = (int)(((String)object).equals(string3 = "gcj02") ? 1 : 0)) != 0) break block4;
                        this.b(bDLocation);
                        d11 = bDLocation.getLongitude();
                        d10 = bDLocation.getLatitude();
                        double d12 = Double.MIN_VALUE;
                        n12 = (int)(d11 == d12 ? 0 : (d11 > d12 ? 1 : -1));
                        if (n12 == 0 || (n12 = (int)(d10 == d12 ? 0 : (d10 > d12 ? 1 : -1))) == 0) break block5;
                        object = bDLocation.getCoorType();
                        if ((object == null || (n12 = (int)(((String)(object = bDLocation.getCoorType())).equals(string3) ? 1 : 0)) == 0) && (object = bDLocation.getCoorType()) != null) break block6;
                        object = this.c.coorType;
                        object = Jni.coorEncrypt(d11, d10, (String)object);
                        Object object2 = object[0];
                        bDLocation.setLongitude((double)object2);
                        object2 = object[n11];
                        bDLocation.setLatitude((double)object2);
                        object = this.c.coorType;
                        break block7;
                    }
                    object = bDLocation.getCoorType();
                    if (object == null || (n12 = (int)(((String)(object = bDLocation.getCoorType())).equals(string3 = "wgs84") ? 1 : 0)) == 0 || (n12 = (int)(((String)(object = this.c.coorType)).equals(string3 = "bd09ll") ? 1 : 0)) != 0) break block5;
                    object = Jni.coorEncrypt(d11, d10, "wgs842mc");
                    Object object3 = object[0];
                    bDLocation.setLongitude((double)object3);
                    object3 = object[n11];
                    bDLocation.setLatitude((double)object3);
                    object = "wgs84mc";
                }
                bDLocation.setCoorType((String)object);
                break block5;
            }
            this.c(bDLocation);
        }
        this.a(n10, string2, bDLocation);
    }

    public void b() {
        LocationClientOption locationClientOption = this.c;
        int n10 = locationClientOption.location_change_notify;
        int n11 = 1;
        if (n10 == n11) {
            n10 = l.b;
            n10 = n10 != 0 ? 54 : 55;
            this.a(n10);
        }
    }
}

