/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.text.TextUtils
 *  android.util.Base64
 *  org.json.JSONObject
 */
package com.mob.commons;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.MobProductCollector;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b;
import com.mob.commons.b.d;
import com.mob.commons.i;
import com.mob.commons.j;
import com.mob.commons.k;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public class l {
    private static final String a;
    private static l b;
    private String c;
    private DeviceHelper d;
    private Context e;
    private TreeMap f;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = j.b();
        stringBuilder.append(string2);
        stringBuilder.append("/openid");
        a = stringBuilder.toString();
    }

    private l() {
        Object object;
        this.e = object = MobSDK.getContext();
        object = DeviceHelper.getInstance(object);
        this.d = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static l a() {
        Object object = b;
        if (object != null) return b;
        object = l.class;
        synchronized (object) {
            l l10 = b;
            if (l10 != null) return b;
            b = l10 = new l();
            return b;
        }
    }

    private File a(Context object, String object2) {
        block19: {
            Object object3;
            block21: {
                int n10;
                int n11;
                int n12;
                block20: {
                    block18: {
                        n12 = Build.VERSION.SDK_INT;
                        n11 = 29;
                        if (n12 < n11) break block18;
                        object = object.getApplicationInfo();
                        n10 = ((ApplicationInfo)object).targetSdkVersion;
                        if (n10 >= n11) break block19;
                    }
                    object = this.d;
                    n10 = (int)(((DeviceHelper)object).getSdcardState() ? 1 : 0);
                    if (n10 == 0) break block19;
                    object = Environment.getExternalStorageDirectory();
                    object = ((File)object).getAbsolutePath();
                    n12 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                    if (n12 != 0) break block19;
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append((String)object);
                    object = "/Mob/";
                    ((StringBuilder)object3).append((String)object);
                    object = ((StringBuilder)object3).toString();
                    object3 = new File((String)object);
                    n11 = (int)(((File)object3).exists() ? 1 : 0);
                    if (n11 != 0) break block20;
                    ((File)object3).mkdirs();
                }
                object3 = new File((String)object, (String)object2);
                n10 = (int)(((File)object3).exists() ? 1 : 0);
                if (n10 != 0) break block21;
                try {
                    ((File)object3).createNewFile();
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    n12 = 2;
                    object3 = new Object[n12];
                    object3[0] = "TokenFetcher";
                    n11 = 1;
                    String string2 = "Get MDID error";
                    object3[n11] = string2;
                    String string3 = "[%s] %s";
                    ((NLog)object2).d(throwable, (Object)string3, (Object[])object3);
                }
            }
            return object3;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(TreeMap treeMap) {
        int n11;
        Cloneable cloneable = this;
        Object object6 = treeMap;
        Object object5 = "moId";
        Object object7 = "mdId";
        Object[] objectArray = "duid";
        String string3 = "deviceId";
        Object object8 = "appInstallTime";
        Object object9 = "firstLaunchTime";
        String string4 = "appver";
        String string5 = "pkg";
        String string6 = "adsid";
        String string7 = "serialNo";
        String string8 = "imei";
        cloneable = "sysver";
        String string9 = "androidId";
        Object object4 = "model";
        String string10 = "maaId";
        Object object3 = "factory";
        String string2 = "TokenFetcher";
        String string11 = "mvaId";
        Object object2 = "[%s] %s";
        Object object = null;
        if (treeMap != null && (n11 = treeMap.isEmpty()) == 0) {
            void var3_8;
            int n10;
            block11: {
                HashMap hashMap;
                block10: {
                    int n12;
                    n11 = 1;
                    hashMap = object2;
                    try {
                        object2 = new HashMap();
                        String string12 = object5;
                        object5 = treeMap.get(object3);
                        ((HashMap)object2).put(object3, object5);
                        object3 = treeMap.get(object4);
                        ((HashMap)object2).put(object4, object3);
                        object4 = treeMap.get(cloneable);
                        ((HashMap)object2).put(cloneable, object4);
                        cloneable = treeMap.get(string8);
                        ((HashMap)object2).put(string8, cloneable);
                        cloneable = treeMap.get(string7);
                        ((HashMap)object2).put(string7, cloneable);
                        cloneable = treeMap.get(string6);
                        ((HashMap)object2).put(string6, cloneable);
                        cloneable = treeMap.get(string5);
                        ((HashMap)object2).put(string5, cloneable);
                        cloneable = treeMap.get(string4);
                        ((HashMap)object2).put(string4, cloneable);
                        cloneable = treeMap.get(object9);
                        ((HashMap)object2).put(object9, cloneable);
                        cloneable = treeMap.get(object8);
                        ((HashMap)object2).put(object8, cloneable);
                        cloneable = treeMap.get(string3);
                        ((HashMap)object2).put(string3, cloneable);
                        cloneable = treeMap.get(objectArray);
                        ((HashMap)object2).put(objectArray, cloneable);
                        cloneable = treeMap.get(object7);
                        ((HashMap)object2).put(object7, cloneable);
                        cloneable = string12;
                        object4 = treeMap.get(string12);
                        ((HashMap)object2).put(string12, object4);
                        cloneable = string11;
                        object4 = treeMap.get(string11);
                        ((HashMap)object2).put(string11, object4);
                        cloneable = string10;
                        object4 = treeMap.get(string10);
                        ((HashMap)object2).put(string10, object4);
                        cloneable = string9;
                        object4 = treeMap.get(string9);
                        ((HashMap)object2).put(string9, object4);
                        cloneable = "macArray";
                        object4 = "macArray";
                        object4 = treeMap.get(object4);
                        ((HashMap)object2).put(cloneable, object4);
                        cloneable = "imeiArray";
                        object4 = "imeiArray";
                        object4 = treeMap.get(object4);
                        ((HashMap)object2).put(cloneable, object4);
                        cloneable = "imsiArray";
                        object4 = "imsiArray";
                        object4 = treeMap.get(object4);
                        ((HashMap)object2).put(cloneable, object4);
                        cloneable = "al";
                        object4 = "al";
                        object6 = treeMap.get(object4);
                        ((HashMap)object2).put(cloneable, object6);
                        object6 = new ArrayList();
                        object4 = "appkey";
                        object3 = MobSDK.getAppkey();
                        cloneable = new Cloneable((String)object4, object3);
                        ((ArrayList)object6).add(cloneable);
                        cloneable = new Cloneable();
                        cloneable = ((Hashon)((Object)cloneable)).fromHashMap((HashMap)object2);
                        object3 = "m";
                        object2 = this;
                    }
                    catch (Throwable throwable) {
                        object2 = this;
                        break block10;
                    }
                    try {
                        cloneable = this.b((String)((Object)cloneable));
                        object4 = new KVPair((String)object3, cloneable);
                        ((ArrayList)object6).add(object4);
                        cloneable = new Cloneable();
                        object3 = "User-Identity";
                        object5 = MobProductCollector.getUserIdentity();
                        object4 = new KVPair((String)object3, object5);
                        cloneable.add(object4);
                        n10 = 68;
                        object3 = k.a(n10);
                        object5 = MobSDK.getContext();
                        object5 = com.mob.commons.b.d.d((Context)object5);
                        object4 = new KVPair((String)object3, object5);
                        cloneable.add(object4);
                        object9 = new NetworkHelper$NetworkTimeOut();
                        ((NetworkHelper$NetworkTimeOut)object9).readTimout = n12 = 30000;
                        ((NetworkHelper$NetworkTimeOut)object9).connectionTimeout = n12 = 30000;
                        object5 = new NetworkHelper();
                        object4 = a;
                        string3 = null;
                        object7 = object4;
                        objectArray = object6;
                        object8 = cloneable;
                        object3 = ((NetworkHelper)object5).httpPost((String)object4, (ArrayList)object6, null, (ArrayList)cloneable, (NetworkHelper$NetworkTimeOut)object9);
                        object5 = MobLog.getInstance();
                        int n13 = 2;
                        objectArray = new Object[n13];
                        objectArray[0] = string2;
                        object7 = new StringBuilder();
                        string3 = "Request: ";
                        ((StringBuilder)object7).append(string3);
                        ((StringBuilder)object7).append((String)object4);
                        object4 = "\nvaluesEn: ";
                        ((StringBuilder)object7).append((String)object4);
                        ((StringBuilder)object7).append(object6);
                        object6 = "\nheaders: ";
                        ((StringBuilder)object7).append((String)object6);
                        ((StringBuilder)object7).append(cloneable);
                        object6 = "\nResponse: ";
                        ((StringBuilder)object7).append((String)object6);
                        ((StringBuilder)object7).append((String)object3);
                        objectArray[n11] = object6 = ((StringBuilder)object7).toString();
                        cloneable = hashMap;
                    }
                    catch (Throwable throwable) {
                        break block10;
                    }
                    try {
                        ((NLog)object5).d(hashMap, objectArray);
                        object6 = new Hashon();
                        object6 = ((Hashon)object6).fromJson((String)object3);
                        object4 = "200";
                        object3 = "code";
                        object3 = ((HashMap)object6).get(object3);
                        object3 = String.valueOf(object3);
                        n12 = (int)(((String)object4).equals(object3) ? 1 : 0);
                        if (n12 == 0) return object;
                        object4 = "data";
                        object6 = ((HashMap)object6).get(object4);
                        if ((object6 = (HashMap)object6) == null) return object;
                        object4 = "token";
                        object4 = object6 = ((HashMap)object6).get(object4);
                        object4 = (String)object6;
                    }
                    catch (Throwable throwable) {
                        break block11;
                    }
                    try {
                        object6 = b;
                        ((l)object6).c = object4;
                        this.c((String)object4);
                    }
                    finally {
                        return object4;
                    }
                }
                cloneable = hashMap;
            }
            object4 = MobLog.getInstance();
            n10 = 2;
            object3 = new Object[n10];
            object3[0] = string2;
            object3[n11] = object5 = "Fetch token from server error.";
            ((NLog)object4).e((Throwable)var3_8, cloneable, object3);
            return object;
        }
        object2 = this;
        return object;
    }

    private HashMap a(String string2, byte[] object) {
        try {
            string2 = Data.AES128Decode(string2, (byte[])object);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            Object[] objectArray = new Object[]{"TokenFetcher", "Decrypt data error"};
            ((NLog)object).d(throwable, (Object)"[%s] %s", objectArray);
            HashMap hashMap = new HashMap();
            return hashMap;
        }
        object = new Hashon;
        ((Hashon)object)();
        return ((Hashon)object).fromJson(string2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2) {
        Object[] objectArray;
        Object object;
        Object object2;
        int n10;
        String string3;
        String string4;
        String string5;
        block14: {
            block13: {
                string5 = "Close stream error";
                string4 = "TokenFetcher";
                string3 = "[%s] %s";
                int n11 = 1;
                n10 = 2;
                object2 = null;
                try {
                    boolean bl2;
                    object = this.e;
                    objectArray = ".mdid";
                    object = this.a((Context)object, (String)objectArray);
                    if (object == null || !(bl2 = ((File)object).exists())) break block13;
                    objectArray = new FileOutputStream((File)object);
                    object = new DataOutputStream((OutputStream)objectArray);
                }
                catch (Throwable throwable) {
                    // empty catch block
                    break block14;
                }
                try {
                    ((DataOutputStream)object).writeUTF(string2);
                }
                finally {
                    object2 = object;
                }
            }
            if (object2 == null) return;
            try {
                ((DataOutputStream)object2).flush();
                ((FilterOutputStream)object2).close();
                return;
            }
            catch (IOException iOException) {
                object2 = MobLog.getInstance();
                Object[] objectArray2 = new Object[n10];
                objectArray2[0] = string4;
                objectArray2[n11] = string5;
                ((NLog)object2).d(iOException, (Object)string3, objectArray2);
                return;
            }
        }
        try {
            void var1_5;
            object = MobLog.getInstance();
            objectArray = new Object[n10];
            objectArray[0] = string4;
            String string6 = "Cache mdid error";
            objectArray[n11] = string6;
            ((NLog)object).d((Throwable)var1_5, (Object)string3, objectArray);
            if (object2 == null) return;
        }
        catch (Throwable throwable) {
            if (object2 == null) throw throwable;
            try {
                ((DataOutputStream)object2).flush();
                ((FilterOutputStream)object2).close();
                throw throwable;
            }
            catch (IOException iOException) {
                object = MobLog.getInstance();
                Object[] objectArray3 = new Object[n10];
                objectArray3[0] = string4;
                objectArray3[n11] = string5;
                ((NLog)object).d(iOException, (Object)string3, objectArray3);
            }
            throw throwable;
        }
        try {
            ((DataOutputStream)object2).flush();
            ((FilterOutputStream)object2).close();
            return;
        }
        catch (IOException iOException) {
            object2 = MobLog.getInstance();
            Object[] objectArray4 = new Object[n10];
            objectArray4[0] = string4;
            objectArray4[n11] = string5;
            ((NLog)object2).d(iOException, (Object)string3, objectArray4);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(HashMap var1_1) {
        block50: {
            var2_2 = this;
            var3_3 = var1_1;
            var4_8 /* !! */  = "generalMd5";
            var5_9 = "pkg";
            var6_10 = "TokenFetcher";
            var7_11 = "[%s] %s";
            try {
                var8_12 = this.f;
                var9_13 = "factory";
                var10_14 = this.d;
                var10_14 = var10_14.getManufacturer();
                var8_12.put(var9_13, var10_14);
                var8_12 = this.f;
                var9_13 = "model";
                var10_14 = this.d;
                var10_14 = var10_14.getModel();
                var8_12.put(var9_13, var10_14);
                var8_12 = this.f;
                var9_13 = "sysver";
                var10_14 = this.d;
                var11_15 = var10_14.getOSVersionInt();
                var10_14 = var11_15;
                var8_12.put(var9_13, var10_14);
                var8_12 = this.f;
                var9_13 = "imei";
                var10_14 = this.d;
                var10_14 = var10_14.getIMEI();
                var8_12.put(var9_13, var10_14);
                var8_12 = this.f;
                var9_13 = "serialNo";
                var10_14 = this.d;
                var10_14 = var10_14.getSerialno();
                var8_12.put(var9_13, var10_14);
                var8_12 = this.f;
                var9_13 = "adsid";
                var10_14 = this.d;
                var10_14 = var10_14.getAdvertisingID();
                var8_12.put(var9_13, var10_14);
                var8_12 = this.f;
                var9_13 = this.d;
                var9_13 = var9_13.getPackageName();
                var8_12.put(var5_9, var9_13);
                var8_12 = this.f;
                var9_13 = "appver";
                var10_14 = this.d;
                var10_14 = var10_14.getAppVersionName();
                var8_12.put(var9_13, var10_14);
                var12_16 = i.G();
                var14_17 = 0L;
                var16_18 = var12_16 == var14_17 ? 0 : (var12_16 < var14_17 ? -1 : 1);
                if (var16_18 > 0) {
                    var17_19 /* !! */  = this.f;
                    var18_20 = "firstLaunchTime";
                    var8_12 = var12_16;
                    var17_19 /* !! */ .put(var18_20, var8_12);
                }
                if ((var11_15 = (int)((cfr_temp_0 = (var12_16 = this.d()) - var14_17) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) > 0) {
                    var10_14 = var2_2.f;
                    var19_21 = "appInstallTime";
                    var8_12 = var12_16;
                    var10_14.put(var19_21, var8_12);
                }
                var8_12 = var2_2.f;
                var9_13 = "deviceId";
                var10_14 = var2_2.d;
                var10_14 = var10_14.getDeviceKey();
                var8_12.put(var9_13, var10_14);
                var8_12 = var2_2.f;
                var9_13 = "duid";
                var10_14 = DeviceAuthorizer.authorizeForOnce();
                var8_12.put(var9_13, var10_14);
                var8_12 = var2_2.f;
                var9_13 = "androidId";
                var10_14 = var2_2.d;
                var10_14 = var10_14.getAndroidID();
                var8_12.put(var9_13, var10_14);
                var8_12 = this.e();
                var20_22 = TextUtils.isEmpty((CharSequence)var8_12);
                if (var20_22 == 0) {
                    var9_13 = var2_2.f;
                    var10_14 = "mdId";
                    var9_13.put(var10_14, var8_12);
                }
                var9_13 = var2_2.f;
                var8_12 = new JSONObject((Map)var9_13);
                var8_12 = var8_12.toString();
                var8_12 = Data.MD5((String)var8_12);
                var9_13 = this.h();
                var11_15 = (int)TextUtils.isEmpty((CharSequence)var9_13);
                if (var11_15 == 0) {
                    var10_14 = var2_2.f;
                    var19_21 = "moId";
                    var10_14.put(var19_21, var9_13);
                }
                if ((var11_15 = (int)TextUtils.isEmpty((CharSequence)(var9_13 = this.i()))) == 0) {
                    var10_14 = var2_2.f;
                    var19_21 = "mvaId";
                    var10_14.put(var19_21, var9_13);
                }
                var9_13 = "maaid";
                if (var3_3 != null && (var11_15 = (int)var1_1.isEmpty()) == 0) {
                    var10_14 = var3_3.get(var9_13);
                    var10_14 = (String)var10_14;
                } else {
                    var10_14 = this.j();
                }
                var21_23 = TextUtils.isEmpty((CharSequence)var10_14);
                if (!var21_23) {
                    var19_21 = var2_2.f;
                    var17_19 /* !! */  = "maaId";
                    var19_21.put(var17_19 /* !! */ , var10_14);
                }
                var19_21 = var2_2.d;
                var19_21 = var19_21.listNetworkHardware();
                var17_19 /* !! */  = new ArrayList<Object>();
                var18_20 = "mac";
                var22_24 = "macArray";
                if (var19_21 != null && !(var23_25 = var19_21.isEmpty())) {
                    var19_21 = var19_21.entrySet();
                    var19_21 = var19_21.iterator();
                    while (var23_25 = var19_21.hasNext()) {
                        var24_26 = var19_21.next();
                        var24_26 = (Map.Entry)var24_26;
                        var25_27 = new HashMap();
                        var26_28 = "ss";
                        var27_29 = var24_26.getKey();
                        var25_27.put(var26_28, var27_29);
                        var26_28 = var24_26.getValue();
                        var25_27.put(var18_20, var26_28);
                        var17_19 /* !! */ .add(var25_27);
                    }
                    var26_28 = var2_2.f;
                    var26_28.put(var22_24, var17_19 /* !! */ );
                }
                var26_28 = var2_2.d;
                var26_28 = var26_28.queryIMEI();
                var27_29 = "imeiArray";
                if (var26_28 != null && (var28_30 = var26_28.length) > 0) {
                    var25_27 = var2_2.f;
                    var25_27.put(var27_29, var26_28);
                }
                var25_27 = var2_2.d;
                var25_27 = var25_27.queryIMSI();
                var19_21 = "imsiArray";
                if (var25_27 != null) {
                    var24_26 = var5_9;
                    var29_31 = ((Object)var25_27).length;
                    if (var29_31 > false) {
                        var5_9 = var2_2.f;
                        var5_9.put(var19_21, var25_27);
                    }
                } else {
                    var24_26 = var5_9;
                }
                var5_9 = var2_2.d;
                var30_32 = var18_20;
                var18_20 = null;
                var5_9 = var5_9.getIA(false);
                var18_20 = "al";
                if (var5_9 != null && !(var31_33 = var5_9.isEmpty())) {
                    var32_34 = var7_11;
                }
                ** GOTO lbl184
            }
            catch (Throwable var3_6) {
                var4_8 /* !! */  = var7_11;
                break block50;
            }
            try {
                block51: {
                    var7_11 = var2_2.f;
                    var7_11.put(var18_20, var5_9);
                    break block51;
lbl184:
                    // 1 sources

                    var32_34 = var7_11;
                }
                var7_11 = new TreeMap();
                var7_11.put(var4_8 /* !! */ , var8_12);
                var7_11.put(var9_13, var10_14);
                var7_11.put(var22_24, var17_19 /* !! */ );
                var7_11.put(var27_29, var26_28);
                var7_11.put(var19_21, var25_27);
                var7_11.put(var18_20, var5_9);
                var2_2.b((TreeMap)var7_11);
                if (var3_3 == null || (var33_35 = var1_1.isEmpty())) ** GOTO lbl469
                var4_8 /* !! */  = var3_3.get(var4_8 /* !! */ );
                var34_36 = var8_12.equals(var4_8 /* !! */  = (String)var4_8 /* !! */ );
                if (var34_36 == 0) {
                    var3_3 = MobLog.getInstance();
                    var34_36 = 2;
                    var5_9 = new Object[var34_36];
                    var34_36 = 0;
                    var4_8 /* !! */  = null;
                    var5_9[0] = var6_10;
                    var4_8 /* !! */  = "generalMd5 changed";
                    var33_35 = true;
                    var5_9[var33_35] = var4_8 /* !! */ ;
                    var4_8 /* !! */  = var32_34;
                }
                ** GOTO lbl223
            }
            catch (Throwable var3_5) {
                var4_8 /* !! */  = var32_34;
                break block50;
            }
            try {
                var3_3.d(var32_34, (Object[])var5_9);
                return var33_35;
lbl223:
                // 1 sources

                var4_8 /* !! */  = var32_34;
                var7_11 = var3_3.get(var22_24);
                var7_11 = (ArrayList)var7_11;
                var35_37 = var17_19 /* !! */ .isEmpty();
                if (var35_37 == 0) {
                    var8_12 = "macArray changed";
                    if (var7_11 != null && (var20_22 = var7_11.isEmpty()) == 0) {
                        var20_22 = var7_11.size();
                        if (var20_22 != (var11_15 = var17_19 /* !! */ .size())) {
                            var3_3 = MobLog.getInstance();
                            var29_31 = 2 != 0;
                            var7_11 = new Object[var29_31];
                            var29_31 = false;
                            var5_9 = null;
                            var7_11[0] = var6_10;
                            var29_31 = true;
                            var7_11[var29_31] = var8_12;
                            var3_3.d(var32_34, (Object[])var7_11);
                            return var29_31;
                        }
                        var9_13 = new ArrayList();
                        var10_14 = var17_19 /* !! */ .iterator();
                        while ((var16_18 = (long)var10_14.hasNext()) != false) {
                            var17_19 /* !! */  = var10_14.next();
                            if ((var17_19 /* !! */  = (HashMap)var17_19 /* !! */ ) != null && !(var36_38 = var17_19 /* !! */ .isEmpty())) {
                                var22_24 = var30_32;
                                var17_19 /* !! */  = var17_19 /* !! */ .get(var30_32);
                                var9_13.add(var17_19 /* !! */ );
                            } else {
                                var22_24 = var30_32;
                            }
                            var30_32 = var22_24;
                        }
                        var22_24 = var30_32;
                        var10_14 = new ArrayList();
                        var7_11 = var7_11.iterator();
                        while ((var16_18 = (long)var7_11.hasNext()) != false) {
                            var17_19 /* !! */  = var7_11.next();
                            if ((var17_19 /* !! */  = (HashMap)var17_19 /* !! */ ) == null || (var37_39 = var17_19 /* !! */ .isEmpty())) continue;
                            var17_19 /* !! */  = var17_19 /* !! */ .get(var22_24);
                            var10_14.add(var17_19 /* !! */ );
                        }
                        var7_11 = var9_13.iterator();
                        while ((var20_22 = (int)var7_11.hasNext()) != 0) {
                            var9_13 = var7_11.next();
                            var20_22 = (int)var10_14.contains(var9_13 = (String)var9_13);
                            if (var20_22 != 0) continue;
                            var3_3 = MobLog.getInstance();
                            var29_31 = 2 != 0;
                            var7_11 = new Object[var29_31];
                            var29_31 = false;
                            var5_9 = null;
                            var7_11[0] = var6_10;
                            var29_31 = true;
                            var7_11[var29_31] = var8_12;
                            var3_3.d(var4_8 /* !! */ , (Object[])var7_11);
                            return var29_31;
                        }
                    } else {
                        var3_3 = MobLog.getInstance();
                        var29_31 = 2 != 0;
                        var7_11 = new Object[var29_31];
                        var29_31 = false;
                        var5_9 = null;
                        var7_11[0] = var6_10;
                        var29_31 = true;
                        var7_11[var29_31] = var8_12;
                        var3_3.d(var4_8 /* !! */ , (Object[])var7_11);
                        return var29_31;
                    }
                }
                var7_11 = var3_3.get(var27_29);
                var7_11 = (ArrayList)var7_11;
                if (var26_28 != null && (var38_40 = var26_28.length) > 0) {
                    var27_29 = "imeiArray changed";
                    if (var7_11 != null && (var35_37 = var7_11.isEmpty()) == 0) {
                        var35_37 = var7_11.size();
                        if (var35_37 != (var20_22 = var26_28.length)) {
                            var3_3 = MobLog.getInstance();
                            var29_31 = 2 != 0;
                            var7_11 = new Object[var29_31];
                            var29_31 = false;
                            var5_9 = null;
                            var7_11[0] = var6_10;
                            var29_31 = true;
                            var7_11[var29_31] = var27_29;
                            var3_3.d(var4_8 /* !! */ , (Object[])var7_11);
                            return var29_31;
                        }
                        var35_37 = var26_28.length;
                        var9_13 = null;
                        for (var20_22 = 0; var20_22 < var35_37; ++var20_22) {
                            var10_14 = var26_28[var20_22];
                            var11_15 = (int)var7_11.contains(var10_14);
                            if (var11_15 != 0) continue;
                            var3_3 = MobLog.getInstance();
                            var29_31 = 2 != 0;
                            var7_11 = new Object[var29_31];
                            var29_31 = false;
                            var5_9 = null;
                            var7_11[0] = var6_10;
                            var29_31 = true;
                            var7_11[var29_31] = var27_29;
                            var3_3.d(var4_8 /* !! */ , (Object[])var7_11);
                            return var29_31;
                        }
                    } else {
                        var3_3 = MobLog.getInstance();
                        var29_31 = 2 != 0;
                        var7_11 = new Object[var29_31];
                        var29_31 = false;
                        var5_9 = null;
                        var7_11[0] = var6_10;
                        var29_31 = true;
                        var7_11[var29_31] = var27_29;
                        var3_3.d(var4_8 /* !! */ , (Object[])var7_11);
                        return var29_31;
                    }
                }
                var7_11 = var3_3.get(var19_21);
                var7_11 = (ArrayList)var7_11;
                if (var25_27 != null && (var39_41 = ((Object)var25_27).length) > 0) {
                    var26_28 = "imsiArray changed";
                    if (var7_11 != null && (var38_40 = (int)var7_11.isEmpty()) == 0) {
                        var38_40 = var7_11.size();
                        if (var38_40 != (var35_37 = ((Object)var25_27).length)) {
                            var3_3 = MobLog.getInstance();
                            var29_31 = 2 != 0;
                            var7_11 = new Object[var29_31];
                            var29_31 = false;
                            var5_9 = null;
                            var7_11[0] = var6_10;
                            var29_31 = true;
                            var7_11[var29_31] = var26_28;
                            var3_3.d(var4_8 /* !! */ , (Object[])var7_11);
                            return var29_31;
                        }
                        var38_40 = ((Object)var25_27).length;
                        var8_12 = null;
                        for (var35_37 = 0; var35_37 < var38_40; ++var35_37) {
                            var9_13 = var25_27[var35_37];
                            var20_22 = (int)var7_11.contains(var9_13);
                            if (var20_22 != 0) continue;
                            var3_3 = MobLog.getInstance();
                            var29_31 = 2 != 0;
                            var7_11 = new Object[var29_31];
                            var29_31 = false;
                            var5_9 = null;
                            var7_11[0] = var6_10;
                            var29_31 = true;
                            var7_11[var29_31] = var26_28;
                            var3_3.d(var4_8 /* !! */ , (Object[])var7_11);
                            return var29_31;
                        }
                    } else {
                        var3_3 = MobLog.getInstance();
                        var29_31 = 2 != 0;
                        var7_11 = new Object[var29_31];
                        var29_31 = false;
                        var5_9 = null;
                        var7_11[0] = var6_10;
                        var29_31 = true;
                        var7_11[var29_31] = var26_28;
                        var3_3.d(var4_8 /* !! */ , (Object[])var7_11);
                        return var29_31;
                    }
                }
                var3_3 = var3_3.get(var18_20);
                var3_3 = (ArrayList)var3_3;
                if (var5_9 != null && !(var33_35 = var5_9.isEmpty())) {
                    var7_11 = "al changed";
                    if (var3_3 != null && (var39_41 = (int)var3_3.isEmpty()) == 0) {
                        var39_41 = var3_3.size();
                        if (var39_41 != (var38_40 = var5_9.size())) {
                            var3_3 = MobLog.getInstance();
                            var29_31 = 2 != 0;
                            var26_28 = new Object[var29_31];
                            var29_31 = false;
                            var5_9 = null;
                            var26_28[0] = var6_10;
                            var29_31 = true;
                            var26_28[var29_31] = var7_11;
                            var3_3.d(var4_8 /* !! */ , var26_28);
                            return var29_31;
                        }
                        var26_28 = new ArrayList();
                        var5_9 = var5_9.iterator();
                        while ((var38_40 = (int)var5_9.hasNext()) != 0) {
                            var27_29 = var5_9.next();
                            if ((var27_29 = (HashMap)var27_29) != null && (var28_30 = (int)var27_29.isEmpty()) == 0) {
                                var25_27 = var24_26;
                                var27_29 = var27_29.get(var24_26);
                                var26_28.add(var27_29);
                            } else {
                                var25_27 = var24_26;
                            }
                            var24_26 = var25_27;
                        }
                        var25_27 = var24_26;
                        var5_9 = new ArrayList();
                        var3_3 = var3_3.iterator();
                        while ((var38_40 = (int)var3_3.hasNext()) != 0) {
                            var27_29 = var3_3.next();
                            if ((var27_29 = (HashMap)var27_29) == null || (var35_37 = (int)var27_29.isEmpty()) != 0) continue;
                            var27_29 = var27_29.get(var25_27);
                            var5_9.add(var27_29);
                        }
                        var3_3 = var26_28.iterator();
                        while ((var39_41 = (int)var3_3.hasNext()) != 0) {
                            var26_28 = var3_3.next();
                            var39_41 = (int)var5_9.contains(var26_28 = (String)var26_28);
                            if (var39_41 != 0) continue;
                            var3_3 = MobLog.getInstance();
                            var29_31 = 2 != 0;
                            var26_28 = new Object[var29_31];
                            var29_31 = false;
                            var5_9 = null;
                            var26_28[0] = var6_10;
                            var29_31 = true;
                            var26_28[var29_31] = var7_11;
                            var3_3.d(var4_8 /* !! */ , var26_28);
                            return var29_31;
                        }
                    } else {
                        var3_3 = MobLog.getInstance();
                        var29_31 = 2 != 0;
                        var26_28 = new Object[var29_31];
                        var29_31 = false;
                        var5_9 = null;
                        var26_28[0] = var6_10;
                        var29_31 = true;
                        var26_28[var29_31] = var7_11;
                        var3_3.d(var4_8 /* !! */ , var26_28);
                        return var29_31;
                    }
                }
                var3_3 = MobLog.getInstance();
                var29_31 = 2 != 0;
                var7_11 = new Object[var29_31];
                var29_31 = false;
                var5_9 = null;
                var7_11[0] = var6_10;
                var26_28 = "No changes";
                var38_40 = 1;
                var7_11[var38_40] = var26_28;
                var3_3.d(var4_8 /* !! */ , (Object[])var7_11);
                return false;
lbl469:
                // 1 sources

                var4_8 /* !! */  = var32_34;
                var3_3 = MobLog.getInstance();
                var29_31 = 2 != 0;
                var7_11 = new Object[var29_31];
                var29_31 = false;
                var5_9 = null;
                var7_11[0] = var6_10;
                var5_9 = "No openids cache, treat as changed";
                var39_42 = true;
                var7_11[var39_42] = var5_9;
                var3_3.d(var32_34, (Object[])var7_11);
                return var39_42;
            }
            catch (Throwable var3_4) {}
        }
        var5_9 = MobLog.getInstance();
        var7_11 = new Object[]{var6_10, "Fetch token from server error."};
        var5_9.e((Throwable)var3_7, (Object)var4_8 /* !! */ , (Object[])var7_11);
        return false;
    }

    private byte[] a(String string2, TreeMap object) {
        Object[] objectArray;
        try {
            objectArray = new JSONObject((Map)object);
            object = objectArray.toString();
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            objectArray = new Object[]{"TokenFetcher", "Encypt data error"};
            ((NLog)object).d(throwable, (Object)"[%s] %s", objectArray);
            return null;
        }
        return Data.AES128Encode(string2, (String)object);
    }

    private String b(String object) {
        Object object2 = new ByteArrayOutputStream();
        Object object3 = new DataOutputStream((OutputStream)object2);
        Object object4 = new Random();
        long l10 = ((Random)object4).nextLong();
        ((DataOutputStream)object3).writeLong(l10);
        long l11 = ((Random)object4).nextLong();
        ((DataOutputStream)object3).writeLong(l11);
        ((DataOutputStream)object3).flush();
        ((FilterOutputStream)object3).close();
        object2 = ((ByteArrayOutputStream)object2).toByteArray();
        object3 = new ByteArrayOutputStream();
        object4 = new GZIPOutputStream((OutputStream)object3);
        Object object5 = new BufferedOutputStream((OutputStream)object4);
        object = ((String)object).getBytes("utf-8");
        ((FilterOutputStream)object5).write((byte[])object);
        ((BufferedOutputStream)object5).flush();
        ((FilterOutputStream)object5).close();
        object = ((ByteArrayOutputStream)object3).toByteArray();
        object = Data.AES128Encode((byte[])object2, (byte[])object);
        object3 = new MobRSA(1024);
        int n10 = 16;
        object4 = new BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", n10);
        object5 = new BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", n10);
        object2 = ((MobRSA)object3).encode((byte[])object2, (BigInteger)object4, (BigInteger)object5);
        object3 = new ByteArrayOutputStream();
        object4 = new DataOutputStream((OutputStream)object3);
        int n11 = ((Object)object2).length;
        ((DataOutputStream)object4).writeInt(n11);
        ((FilterOutputStream)object4).write((byte[])object2);
        int n12 = ((Object)object).length;
        ((DataOutputStream)object4).writeInt(n12);
        ((FilterOutputStream)object4).write((byte[])object);
        ((DataOutputStream)object4).flush();
        ((FilterOutputStream)object4).close();
        return Base64.encodeToString((byte[])((ByteArrayOutputStream)object3).toByteArray(), (int)2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(TreeMap object) {
        String string4 = "Close stream error";
        String string3 = "TokenFetcher";
        String string2 = "[%s] %s";
        int n10 = 2;
        int bl2 = 1;
        Object object3 = null;
        try {
            int n11;
            Object object2 = this.e;
            Object object4 = ".opdn";
            object2 = ResHelper.getDataCacheFile(object2, (String)object4);
            object4 = "1234567890abcdfi";
            object = this.a((String)object4, (TreeMap)object);
            if (object != null && (n11 = ((Object)object).length) > 0) {
                object4 = new FileOutputStream((File)object2);
                object3 = ((FileOutputStream)object4).getChannel();
                object = ByteBuffer.wrap((byte[])object);
                ((FileChannel)object3).write((ByteBuffer)object);
                ((FileChannel)object3).force(bl2 != 0);
            }
            if (object3 == null) return;
        }
        catch (Throwable throwable) {
            try {
                NLog nLog = MobLog.getInstance();
                Object[] objectArray = new Object[n10];
                objectArray[0] = string3;
                String string5 = "Write openid cache error";
                objectArray[bl2] = string5;
                nLog.d(throwable, (Object)string2, objectArray);
                if (object3 == null) return;
            }
            catch (Throwable throwable2) {
                if (object3 == null) throw throwable2;
                try {
                    ((AbstractInterruptibleChannel)object3).close();
                    throw throwable2;
                }
                catch (IOException iOException) {
                    NLog nLog = MobLog.getInstance();
                    Object[] objectArray = new Object[n10];
                    objectArray[0] = string3;
                    objectArray[bl2] = string4;
                    nLog.d(iOException, (Object)string2, objectArray);
                }
                throw throwable2;
            }
            try {
                ((AbstractInterruptibleChannel)object3).close();
                return;
            }
            catch (IOException iOException) {
                object3 = MobLog.getInstance();
                Object[] objectArray = new Object[n10];
                objectArray[0] = string3;
                objectArray[bl2] = string4;
                ((NLog)object3).d(iOException, (Object)string2, objectArray);
            }
            return;
        }
        try {
            ((AbstractInterruptibleChannel)object3).close();
            return;
        }
        catch (IOException iOException) {
            object3 = MobLog.getInstance();
            Object[] objectArray = new Object[n10];
            objectArray[0] = string3;
            objectArray[bl2] = string4;
            ((NLog)object3).d(iOException, (Object)string2, objectArray);
            return;
        }
    }

    private String c() {
        Object object;
        Object object2;
        Object object3;
        int n10;
        String string2;
        String string3;
        block27: {
            block28: {
                String string4;
                CharSequence charSequence;
                Object[] objectArray;
                NLog nLog;
                boolean bl2;
                block26: {
                    TreeMap treeMap;
                    string3 = "TokenFetcher";
                    string2 = "[%s] %s";
                    this.f = treeMap = new TreeMap();
                    int n11 = 1;
                    n10 = 2;
                    object3 = null;
                    object2 = this.k();
                    object = this.l();
                    bl2 = this.a((HashMap)object);
                    nLog = MobLog.getInstance();
                    objectArray = new Object[n10];
                    objectArray[0] = string3;
                    charSequence = new StringBuilder();
                    string4 = "cachedToken: ";
                    ((StringBuilder)charSequence).append(string4);
                    ((StringBuilder)charSequence).append((String)object2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    objectArray[n11] = charSequence;
                    nLog.d(string2, objectArray);
                    boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
                    if (!bl3) break block26;
                    object2 = this.f;
                    object3 = this.a((TreeMap)object2);
                    break block27;
                }
                nLog = MobLog.getInstance();
                objectArray = new Object[n10];
                objectArray[0] = string3;
                charSequence = new StringBuilder();
                string4 = "isChanged: ";
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(bl2);
                charSequence = ((StringBuilder)charSequence).toString();
                objectArray[n11] = charSequence;
                nLog.d(string2, objectArray);
                if (bl2) break block28;
                object3 = object2;
                break block27;
            }
            object2 = this.f;
            object3 = this.a((TreeMap)object2);
        }
        object2 = b;
        try {
            ((l)object2).c = object3;
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            Object[] objectArray = new Object[n10];
            objectArray[0] = string3;
            string3 = "Sync token from cache & net error";
            objectArray[n11] = string3;
            ((NLog)object).d(throwable, (Object)string2, objectArray);
        }
        return object3;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(String string2) {
        Object[] objectArray;
        String string3;
        String string4;
        Object object;
        int n10;
        Object object2;
        String string5;
        block14: {
            block13: {
                string5 = "Close stream error";
                object2 = MobLog.getInstance();
                n10 = 2;
                object = new Object[n10];
                string4 = "TokenFetcher";
                object[0] = string4;
                int n11 = 1;
                object[n11] = "Write token cache";
                string3 = "[%s] %s";
                ((NLog)object2).d(string3, (Object[])object);
                object2 = null;
                try {
                    object = this.e;
                    objectArray = ".optn";
                    object = ResHelper.getDataCacheFile((Context)object, (String)objectArray);
                    if (object == null) break block13;
                    objectArray = new FileOutputStream((File)object);
                    object = new DataOutputStream((OutputStream)objectArray);
                }
                catch (Throwable throwable) {
                    // empty catch block
                    break block14;
                }
                try {
                    ((DataOutputStream)object).writeUTF(string2);
                }
                finally {
                    object2 = object;
                }
            }
            if (object2 == null) return;
            try {
                ((DataOutputStream)object2).flush();
                ((FilterOutputStream)object2).close();
                return;
            }
            catch (IOException iOException) {
                object2 = MobLog.getInstance();
                Object[] objectArray2 = new Object[n10];
                objectArray2[0] = string4;
                objectArray2[n11] = string5;
                ((NLog)object2).d(iOException, (Object)string3, objectArray2);
                return;
            }
        }
        try {
            void var1_5;
            object = MobLog.getInstance();
            objectArray = new Object[n10];
            objectArray[0] = string4;
            String string6 = "Cache token error";
            objectArray[n11] = string6;
            ((NLog)object).d((Throwable)var1_5, (Object)string3, objectArray);
            if (object2 == null) return;
        }
        catch (Throwable throwable) {
            if (object2 == null) throw throwable;
            try {
                ((DataOutputStream)object2).flush();
                ((FilterOutputStream)object2).close();
                throw throwable;
            }
            catch (IOException iOException) {
                object = MobLog.getInstance();
                Object[] objectArray3 = new Object[n10];
                objectArray3[0] = string4;
                objectArray3[n11] = string5;
                ((NLog)object).d(iOException, (Object)string3, objectArray3);
            }
            throw throwable;
        }
        try {
            ((DataOutputStream)object2).flush();
            ((FilterOutputStream)object2).close();
            return;
        }
        catch (IOException iOException) {
            object2 = MobLog.getInstance();
            Object[] objectArray4 = new Object[n10];
            objectArray4[0] = string4;
            objectArray4[n11] = string5;
            ((NLog)object2).d(iOException, (Object)string3, objectArray4);
        }
    }

    private long d() {
        block8: {
            int n10 = 0;
            String string2 = null;
            Context context = this.e;
            context = context.getPackageManager();
            if (context == null) break block8;
            Object object = this.d;
            object = ((DeviceHelper)object).getPackageName();
            context = context.getPackageInfo((String)object, 0);
            if (context == null) break block8;
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 9;
            if (n11 < n12) break block8;
            try {
                return context.firstInstallTime;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                n12 = 2;
                Object[] objectArray = new Object[n12];
                objectArray[0] = "TokenFetcher";
                n10 = 1;
                String string3 = "Get ins time error";
                objectArray[n10] = string3;
                string2 = "[%s] %s";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
            }
        }
        return 0L;
    }

    private String e() {
        DeviceHelper deviceHelper;
        String string2 = this.f();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2 && (bl2 = (deviceHelper = this.d).getSdcardState()) && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.g())))) {
            this.a(string2);
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String f() {
        NLog nLog;
        Object object2;
        int n10;
        Object object;
        String string2;
        String string3;
        String string4;
        block13: {
            Object object3;
            block14: {
                block12: {
                    string4 = "Close stream error";
                    string3 = "TokenFetcher";
                    string2 = "[%s] %s";
                    object = null;
                    int n11 = 1;
                    n10 = 2;
                    try {
                        boolean bl2;
                        object2 = this.e;
                        object3 = ".mdid";
                        object2 = this.a((Context)object2, (String)object3);
                        if (object2 == null || !(bl2 = ((File)object2).exists())) break block12;
                        object3 = new FileInputStream((File)object2);
                        object2 = new DataInputStream((InputStream)object3);
                    }
                    catch (Throwable throwable) {
                        object2 = null;
                        break block13;
                    }
                    try {
                        object = ((DataInputStream)object2).readUTF();
                        Object object4 = object2;
                        object2 = object;
                        object = object4;
                        break block14;
                    }
                    catch (Throwable throwable) {
                        break block13;
                    }
                }
                object2 = null;
            }
            if (object == null) return object2;
            try {
                ((FilterInputStream)object).close();
                return object2;
            }
            catch (IOException iOException) {
                object3 = MobLog.getInstance();
                Object[] objectArray = new Object[n10];
                objectArray[0] = string3;
                objectArray[n11] = string4;
                ((NLog)object3).d(iOException, (Object)string2, objectArray);
            }
            return object2;
        }
        try {
            NLog nLog2 = MobLog.getInstance();
            Object[] objectArray = new Object[n10];
            objectArray[0] = string3;
            String string5 = "Read mdid cache error";
            objectArray[n11] = string5;
            nLog2.d((Throwable)((Object)nLog), (Object)string2, objectArray);
            if (object2 == null) return object;
        }
        catch (Throwable throwable) {
            if (object2 == null) throw throwable;
            try {
                ((FilterInputStream)object2).close();
                throw throwable;
            }
            catch (IOException iOException) {
                nLog = MobLog.getInstance();
                Object[] objectArray = new Object[n10];
                objectArray[0] = string3;
                objectArray[n11] = string4;
                nLog.d(iOException, (Object)string2, objectArray);
            }
            throw throwable;
        }
        try {
            ((FilterInputStream)object2).close();
            return object;
        }
        catch (IOException iOException) {
            nLog = MobLog.getInstance();
            Object[] objectArray2 = new Object[n10];
            objectArray2[0] = string3;
            objectArray2[n11] = string4;
            nLog.d(iOException, (Object)string2, objectArray2);
        }
        return object;
    }

    private String g() {
        Object object = UUID.randomUUID();
        object = ((UUID)object).toString();
        object = Data.SHA1((String)object);
        try {
            object = Data.byteToHex((byte[])object);
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = "TokenFetcher";
            int n11 = 1;
            String string2 = "Generate mdid error";
            objectArray[n11] = string2;
            String string3 = "[%s] %s";
            nLog.d(throwable, (Object)string3, objectArray);
            object = null;
        }
        return object;
    }

    private String h() {
        return com.mob.commons.b.d.c(this.e);
    }

    private String i() {
        Object object;
        Object object2;
        Object object3;
        try {
            object3 = DeviceAuthorizer.authorizeForOnce();
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            object = new Object[]{"TokenFetcher", "Generate mvaid error"};
            ((NLog)object2).d(throwable, (Object)"[%s] %s", (Object[])object);
            return null;
        }
        object2 = this.d;
        object2 = ((DeviceHelper)object2).getSignMD5();
        object = new StringBuilder();
        ((StringBuilder)object).append((String)object3);
        ((StringBuilder)object).append((String)object2);
        object3 = ((StringBuilder)object).toString();
        object3 = Data.SHA1((String)object3);
        return Data.byteToHex((byte[])object3);
    }

    private String j() {
        Object[] objectArray;
        Object object;
        Object object2;
        try {
            object2 = this.d;
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            objectArray = new Object[]{"TokenFetcher", "Generate mvaid error"};
            ((NLog)object).d(throwable, (Object)"[%s] %s", objectArray);
            return null;
        }
        object2 = ((DeviceHelper)object2).getPackageName();
        object = UUID.randomUUID();
        object = ((UUID)object).toString();
        objectArray = new StringBuilder();
        objectArray.append((String)object2);
        objectArray.append((String)object);
        object2 = objectArray.toString();
        object2 = Data.SHA1((String)object2);
        return Data.byteToHex((byte[])object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String k() {
        NLog nLog;
        Object object2;
        int n10;
        Object object;
        String string2;
        String string3;
        String string4;
        block13: {
            Object object3;
            block14: {
                block12: {
                    string4 = "Close stream error";
                    string3 = "TokenFetcher";
                    string2 = "[%s] %s";
                    object = null;
                    int n11 = 1;
                    n10 = 2;
                    try {
                        boolean bl2;
                        object2 = this.e;
                        object3 = ".optn";
                        object2 = ResHelper.getDataCacheFile((Context)object2, (String)object3);
                        if (object2 == null || !(bl2 = ((File)object2).exists())) break block12;
                        object3 = new FileInputStream((File)object2);
                        object2 = new DataInputStream((InputStream)object3);
                    }
                    catch (Throwable throwable) {
                        object2 = null;
                        break block13;
                    }
                    try {
                        object = ((DataInputStream)object2).readUTF();
                        Object object4 = object2;
                        object2 = object;
                        object = object4;
                        break block14;
                    }
                    catch (Throwable throwable) {
                        break block13;
                    }
                }
                object2 = null;
            }
            if (object == null) return object2;
            try {
                ((FilterInputStream)object).close();
                return object2;
            }
            catch (IOException iOException) {
                object3 = MobLog.getInstance();
                Object[] objectArray = new Object[n10];
                objectArray[0] = string3;
                objectArray[n11] = string4;
                ((NLog)object3).d(iOException, (Object)string2, objectArray);
            }
            return object2;
        }
        try {
            NLog nLog2 = MobLog.getInstance();
            Object[] objectArray = new Object[n10];
            objectArray[0] = string3;
            String string5 = "Read token cache error";
            objectArray[n11] = string5;
            nLog2.d((Throwable)((Object)nLog), (Object)string2, objectArray);
            if (object2 == null) return object;
        }
        catch (Throwable throwable) {
            if (object2 == null) throw throwable;
            try {
                ((FilterInputStream)object2).close();
                throw throwable;
            }
            catch (IOException iOException) {
                nLog = MobLog.getInstance();
                Object[] objectArray = new Object[n10];
                objectArray[0] = string3;
                objectArray[n11] = string4;
                nLog.d(iOException, (Object)string2, objectArray);
            }
            throw throwable;
        }
        try {
            ((FilterInputStream)object2).close();
            return object;
        }
        catch (IOException iOException) {
            nLog = MobLog.getInstance();
            Object[] objectArray2 = new Object[n10];
            objectArray2[0] = string3;
            objectArray2[n11] = string4;
            nLog.d(iOException, (Object)string2, objectArray2);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private HashMap l() {
        NLog nLog;
        Object object3;
        int n10;
        Object object;
        String string2;
        String string3;
        String string4;
        block14: {
            Object object4;
            block15: {
                block13: {
                    string4 = "Close stream error";
                    string3 = "TokenFetcher";
                    string2 = "[%s] %s";
                    object = null;
                    int n11 = 1;
                    n10 = 2;
                    try {
                        boolean n12;
                        object3 = this.e;
                        object4 = ".opdn";
                        object3 = ResHelper.getDataCacheFile((Context)object3, (String)object4);
                        if (object3 == null || !(n12 = ((File)object3).exists())) break block13;
                        object4 = new FileInputStream((File)object3);
                        object3 = ((FileInputStream)object4).getChannel();
                    }
                    catch (Throwable throwable) {
                        object3 = null;
                        break block14;
                    }
                    try {
                        int n14;
                        long l10 = ((FileChannel)object3).size();
                        int n13 = (int)l10;
                        object4 = ByteBuffer.allocate(n13);
                        while ((n14 = ((FileChannel)object3).read((ByteBuffer)object4)) > 0) {
                        }
                        object4 = ((ByteBuffer)object4).array();
                        String object2 = "1234567890abcdfi";
                        object = this.a(object2, (byte[])object4);
                        Object object5 = object3;
                        object3 = object;
                        object = object5;
                        break block15;
                    }
                    catch (Throwable throwable) {
                        break block14;
                    }
                }
                object3 = null;
            }
            if (object == null) return object3;
            try {
                ((AbstractInterruptibleChannel)object).close();
                return object3;
            }
            catch (IOException iOException) {
                object4 = MobLog.getInstance();
                Object[] objectArray2 = new Object[n10];
                objectArray2[0] = string3;
                objectArray2[n11] = string4;
                ((NLog)object4).d(iOException, (Object)string2, objectArray2);
            }
            return object3;
        }
        try {
            NLog nLog2 = MobLog.getInstance();
            Object[] objectArray = new Object[n10];
            objectArray[0] = string3;
            String string5 = "Read openid cache error";
            objectArray[n11] = string5;
            nLog2.d((Throwable)((Object)nLog), (Object)string2, objectArray);
            if (object3 == null) return object;
        }
        catch (Throwable throwable) {
            if (object3 == null) throw throwable;
            try {
                ((AbstractInterruptibleChannel)object3).close();
                throw throwable;
            }
            catch (IOException iOException) {
                nLog = MobLog.getInstance();
                Object[] objectArray = new Object[n10];
                objectArray[0] = string3;
                objectArray[n11] = string4;
                nLog.d(iOException, (Object)string2, objectArray);
            }
            throw throwable;
        }
        try {
            ((AbstractInterruptibleChannel)object3).close();
            return object;
        }
        catch (IOException iOException) {
            nLog = MobLog.getInstance();
            Object[] objectArray = new Object[n10];
            objectArray[0] = string3;
            objectArray[n11] = string4;
            nLog.d(iOException, (Object)string2, objectArray);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String b() {
        boolean bl2 = com.mob.commons.b.al();
        if (!bl2) {
            return null;
        }
        Class<l> clazz = MobLog.getInstance();
        String string2 = "[%s] %s";
        int n10 = 2;
        Object[] objectArray = new Object[n10];
        objectArray[0] = "TokenFetcher";
        int n11 = 1;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Mem token: ");
        String string3 = this.c;
        charSequence.append(string3);
        charSequence = charSequence.toString();
        objectArray[n11] = charSequence;
        ((NLog)((Object)clazz)).d(string2, objectArray);
        clazz = this.c;
        bl2 = TextUtils.isEmpty((CharSequence)((Object)clazz));
        if (!bl2) return this.c;
        clazz = l.class;
        synchronized (clazz) {
            string2 = this.c;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3) return this.c;
            return this.c();
        }
    }
}

