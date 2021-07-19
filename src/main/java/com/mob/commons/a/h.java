/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Message
 */
package com.mob.commons.a;

import android.content.Context;
import android.os.Message;
import com.mob.MobSDK;
import com.mob.commons.a.d;
import com.mob.commons.a.h$1;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.e;
import com.mob.commons.i;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SmltHelper;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class h
extends d {
    /*
     * Unable to fully structure code
     */
    private long a(HashMap var1_1) {
        block190: {
            block192: {
                block189: {
                    block188: {
                        block187: {
                            block182: {
                                block181: {
                                    block191: {
                                        block185: {
                                            block186: {
                                                block183: {
                                                    block184: {
                                                        block180: {
                                                            block179: {
                                                                var2_2 = this;
                                                                var3_3 = var1_1;
                                                                var4_4 = "scale";
                                                                var5_5 = "charge_type";
                                                                var6_6 = "technology";
                                                                var7_7 = "present";
                                                                var8_8 = "batteryState";
                                                                var9_9 = "lightMode";
                                                                var10_10 = "light";
                                                                var11_11 = "time";
                                                                var12_12 = "level";
                                                                var2_2 = "plugged";
                                                                var13_13 = "capacity";
                                                                var14_14 = "status";
                                                                var15_15 = "health";
                                                                var16_16 = "voltage";
                                                                var17_17 = "current_avg";
                                                                var18_18 = "temperature";
                                                                var19_19 = "current_now";
                                                                var20_20 = "nextUploadTime";
                                                                var21_21 = 0L;
                                                                var23_22 = var20_20;
                                                                var20_20 = this.j();
                                                                var24_23 = null;
                                                                var26_38 = var25_24 = var20_20.get(var11_11);
                                                                var26_38 = (ArrayList)var25_24;
                                                                var25_24 = var20_20.get(var10_10);
                                                                var27_39 = var25_24;
                                                                var27_39 = (ArrayList<E>)var25_24;
                                                                var25_24 = var20_20.get(var9_9);
                                                                var28_40 = var25_24;
                                                                var28_40 = (ArrayList<E>)var25_24;
                                                                var25_24 = var20_20.get(var8_8);
                                                                var29_41 = var25_24;
                                                                var29_41 = (HashMap)var25_24;
                                                                if (var29_41 != null) break block179;
                                                                try {
                                                                    var25_24 = new HashMap();
                                                                    var30_42 = var11_11;
                                                                    var11_11 = var25_24;
                                                                    break block180;
                                                                }
                                                                catch (Throwable var25_25) {
                                                                    var30_42 = var11_11;
                                                                    var31_43 = 0;
                                                                    var32_44 = null;
                                                                    var33_45 = null;
                                                                    var34_46 = null;
                                                                    var35_47 = var29_41;
                                                                    var29_41 = null;
                                                                    break block181;
                                                                }
                                                            }
                                                            var30_42 = var11_11;
                                                            var11_11 = var29_41;
                                                        }
                                                        var29_41 = var25_24 = var11_11.get(var18_18);
                                                        var29_41 = (ArrayList)var25_24;
                                                        var25_24 = var11_11.get(var16_16);
                                                        var32_44 = (ArrayList<Object>)var25_24;
                                                        var32_44 = (ArrayList)var25_24;
                                                        var33_45 = var25_24 = var11_11.get(var14_14);
                                                        var33_45 = (ArrayList)var25_24;
                                                        var25_24 = var11_11.get(var2_2);
                                                        var34_46 = var25_24;
                                                        var34_46 = (ArrayList)var25_24;
                                                        try {
                                                            var25_24 = var11_11.get(var12_12);
                                                        }
                                                        catch (Throwable var25_26) {
                                                            var35_47 = var11_11;
                                                            break block181;
                                                        }
                                                        var24_23 = var25_24 = (ArrayList)var25_24;
                                                        break block182;
                                                        catch (Throwable var25_27) {
                                                            var35_47 = var11_11;
                                                            var34_46 = null;
                                                        }
                                                        break block181;
                                                        catch (Throwable var25_28) {
                                                            var35_47 = var11_11;
                                                            var33_45 = null;
                                                            break block183;
                                                        }
                                                        catch (Throwable var25_29) {
                                                            var35_47 = var11_11;
                                                            var31_43 = 0;
                                                            var32_44 = null;
                                                            break block184;
                                                        }
                                                        catch (Throwable var25_30) {
                                                            var35_47 = var11_11;
                                                            var29_41 = null;
                                                            var31_43 = 0;
                                                            var32_44 = null;
                                                        }
                                                    }
                                                    var33_45 = null;
                                                }
                                                var34_46 = null;
                                                break block181;
                                                catch (Throwable var25_31) {
                                                    var30_42 = var11_11;
                                                    var29_41 = null;
                                                }
                                                break block191;
                                                catch (Throwable var25_32) {
                                                    var30_42 = var11_11;
                                                    var28_40 = null;
                                                    break block185;
                                                }
                                                catch (Throwable var25_33) {
                                                    var30_42 = var11_11;
                                                    var27_39 = null;
                                                    break block186;
                                                }
                                                catch (Throwable var25_34) {
                                                    var30_42 = var11_11;
                                                    var26_38 = null;
                                                    var27_39 = null;
                                                }
                                            }
                                            var28_40 = null;
                                        }
                                        var29_41 = null;
                                    }
                                    var31_43 = 0;
                                    var32_44 = null;
                                    var33_45 = null;
                                    var34_46 = null;
                                    var35_47 = null;
                                }
                                var11_11 = MobLog.getInstance();
                                var11_11.d((Throwable)var25_24);
                                var11_11 = var35_47;
                            }
                            if (var26_38 != null) ** GOTO lbl150
                            var26_38 = new ArrayList();
lbl150:
                            // 2 sources

                            var36_48 = var26_38.size();
                            if (var27_39 == null || var28_40 == null || var29_41 == null || var32_44 == null || var33_45 == null || var34_46 == null || var24_23 == null) break block187;
                            var35_47 = var11_11;
                            var37_49 = var27_39.size();
                            if (var37_49 != var36_48) break block187;
                            var37_49 = var28_40.size();
                            if (var37_49 != var36_48) break block187;
                            var37_49 = var29_41.size();
                            if (var37_49 != var36_48) break block187;
                            var37_49 = var32_44.size();
                            if (var37_49 != var36_48) break block187;
                            var37_49 = var33_45.size();
                            if (var37_49 != var36_48) break block187;
                            var37_49 = var34_46.size();
                            if (var37_49 != var36_48) break block187;
                            var37_49 = var24_23.size();
                            if (var37_49 != var36_48) break block187;
                            var38_50 = var26_38;
                            var25_24 = var28_40;
                            var39_51 = var33_45;
                            var40_52 = var34_46;
                            break block188;
                        }
                        var26_38 = new ArrayList();
                        var27_39 = new ArrayList();
                        var28_40 = new ArrayList();
                        var11_11 = new HashMap<String, Object>();
                        var29_41 = new ArrayList();
                        var32_44 = new ArrayList<Object>();
                        var33_45 = new ArrayList();
                        var34_46 = new ArrayList();
                        var24_23 = new ArrayList();
                        var38_50 = var26_38;
                        var25_24 = var28_40;
                        var39_51 = var33_45;
                        var40_52 = var34_46;
                    }
                    var28_40 = var2_2;
                    var26_38 = var24_23;
                    var2_2 = var32_44;
                    var24_23 = var8_8;
                    var8_8 = var27_39;
                    var27_39 = var12_12;
                    var12_12 = var29_41;
                    var29_41 = MobSDK.getContext();
                    var29_41 = DeviceHelper.getInstance((Context)var29_41);
                    var31_43 = var29_41.getScreenBrightness();
                    var33_45 = var14_14;
                    var14_14 = var31_43;
                    var8_8.add(var14_14);
                    var41_53 = var29_41.getScreenBrightnessMode();
                    var14_14 = var41_53;
                    var25_24.add((Object)var14_14);
                    var20_20.put(var10_10, var8_8);
                    var20_20.put(var9_9, var25_24);
                    var25_24 = var3_3.get(var7_7);
                    var14_14 = Boolean.FALSE;
                    var25_24 = ResHelper.forceCast(var25_24, var14_14);
                    var25_24 = (Boolean)var25_24;
                    var36_48 = (int)var25_24.booleanValue();
                    var25_24 = (boolean)var36_48;
                    var11_11.put((String)var7_7, var25_24);
                    var25_24 = var3_3.get(var6_6);
                    var25_24 = ResHelper.forceCast(var25_24);
                    var25_24 = (String)var25_24;
                    var11_11.put((String)var6_6, var25_24);
                    var25_24 = var3_3.get(var5_5);
                    var41_53 = -1;
                    var6_6 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var6_6);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var11_11.put((String)var5_5, var25_24);
                    var25_24 = var3_3.get(var4_4);
                    var5_5 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var5_5);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var11_11.put((String)var4_4, var25_24);
                    var4_4 = var19_19;
                    var25_24 = var3_3.get(var19_19);
                    var5_5 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var5_5);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var11_11.put(var19_19, var25_24);
                    var4_4 = var17_17;
                    var25_24 = var3_3.get(var17_17);
                    var5_5 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var5_5);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var11_11.put(var17_17, var25_24);
                    var4_4 = var15_15;
                    var25_24 = var3_3.get(var15_15);
                    var5_5 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var5_5);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var11_11.put(var15_15, var25_24);
                    var4_4 = var13_13;
                    var25_24 = var3_3.get(var13_13);
                    var5_5 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var5_5);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var11_11.put(var13_13, var25_24);
                    var25_24 = var3_3.get(var18_18);
                    var4_4 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var4_4);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var12_12.add(var25_24);
                    var25_24 = var3_3.get(var16_16);
                    var4_4 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var4_4);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var32_44.add(var25_24);
                    var4_4 = var33_45;
                    var25_24 = var3_3.get(var33_45);
                    var5_5 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var5_5);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var5_5 = var39_51;
                    var39_51.add(var25_24);
                    var6_6 = var28_40;
                    var25_24 = var3_3.get(var28_40);
                    var7_7 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var7_7);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var7_7 = var40_52;
                    var40_52.add(var25_24);
                    var8_8 = var27_39;
                    var25_24 = var3_3.get(var27_39);
                    var3_3 = var41_53;
                    var25_24 = ResHelper.forceCast(var25_24, var3_3);
                    var25_24 = (Integer)var25_24;
                    var36_48 = var25_24.intValue();
                    var25_24 = var36_48;
                    var3_3 = var26_38;
                    var26_38.add(var25_24);
                    var11_11.put((String)var18_18, var12_12);
                    var11_11.put((String)var16_16, var32_44);
                    var11_11.put((String)var33_45, var39_51);
                    var11_11.put((String)var28_40, var40_52);
                    var11_11.put((String)var27_39, var26_38);
                    var2_2 = var24_23;
                    var20_20.put((String)var24_23, var11_11);
                    var42_54 = b.a();
                    var3_3 = var42_54;
                    var14_14 = var38_50;
                    var38_50.add(var3_3);
                    var3_3 = var30_42;
                    var20_20.put((String)var30_42, var38_50);
                    var3_3 = var23_22;
                    var16_16 = var20_20.get(var23_22);
                    var18_18 = var21_21;
                    var16_16 = ResHelper.forceCast(var16_16, var18_18);
                    var16_16 = (Long)var16_16;
                    var44_55 = var16_16.longValue();
                    var46_56 = var44_55 == var21_21 ? 0 : (var44_55 < var21_21 ? -1 : 1);
                    var47_57 = 1000L;
                    if (var46_56 != false) break block189;
                    var44_55 = b.G() * var47_57 + var42_54;
                    var4_4 = var44_55;
                    var20_20.put(var23_22, var4_4);
                }
                if ((var41_53 = var14_14.size()) >= (var46_56 = (long)200) && (var41_53 = (int)(var42_54 == var44_55 ? 0 : (var42_54 < var44_55 ? -1 : 1))) < 0) {
                    var21_21 = var44_55 - var42_54;
                }
                if ((var36_48 = (int)(var42_54 == var44_55 ? 0 : (var42_54 < var44_55 ? -1 : 1))) >= 0) {
                    var20_20.remove(var3_3);
                    var25_24 = "cacheSize";
                    var20_20.remove(var25_24);
                    var25_24 = "LIGHT_ELECTRIC_INFO";
                    var2_2 = this;
                    this.a(var20_20, (String)var25_24);
                    var20_20 = new HashMap<String, Object>();
                    var49_58 = b.a();
                    var51_59 = b.G() * var47_57;
                    var49_58 += var51_59;
                    var25_24 = var49_58;
                    var20_20.put((String)var3_3, var25_24);
                } else {
                    var2_2 = this;
                }
                try {
                    super.b(var20_20);
                    break block190;
                }
                catch (Throwable var25_35) {}
                break block192;
                catch (Throwable var25_36) {
                    var2_2 = this;
                }
            }
            var3_3 = MobLog.getInstance();
            var3_3.d((Throwable)var25_37);
        }
        return var21_21;
    }

    private void a(HashMap hashMap, String string2) {
        HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
        hashMap2.put("type", string2);
        hashMap2.put("data", hashMap);
        long l10 = b.a();
        Long l11 = l10;
        hashMap2.put("datetime", l11);
        c.a().a(l10, hashMap2);
    }

    private void b(HashMap hashMap) {
        boolean bl2;
        Object object = MobSDK.getContext();
        Object object2 = "comm/dbs/.lecd";
        if ((object = ResHelper.getDataCacheFile((Context)object, (String)object2)) != null && (hashMap == null || (bl2 = hashMap.isEmpty()))) {
            ((File)object).delete();
            return;
        }
        object2 = new FileOutputStream((File)object);
        object = new ObjectOutputStream((OutputStream)object2);
        try {
            ((ObjectOutputStream)object).writeObject(hashMap);
            ((ObjectOutputStream)object).close();
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).d(throwable);
        }
    }

    private void h() {
        int n10;
        Object object;
        int n11;
        Object object2 = this.i();
        HashMap<String, Object[]> hashMap = new HashMap<String, Object[]>();
        int n12 = 2;
        if (object2 != null && (n11 = ((Object[])object2).length) == n12) {
            n11 = 0;
            object = object2[0];
            ((StringBuilder)((Object)hashMap)).append(object);
        }
        object = new SmltHelper();
        Context context = MobSDK.getContext();
        int n13 = ((SmltHelper)object).checkBaseband(context);
        ((StringBuilder)((Object)hashMap)).append(n13);
        Context context2 = MobSDK.getContext();
        int n14 = ((SmltHelper)object).checkBoard(context2);
        ((StringBuilder)((Object)hashMap)).append(n14);
        Context context3 = MobSDK.getContext();
        int n15 = ((SmltHelper)object).checkPlatform(context3);
        ((StringBuilder)((Object)hashMap)).append(n15);
        Context context4 = MobSDK.getContext();
        int n16 = ((SmltHelper)object).checkFlavor(context4);
        ((StringBuilder)((Object)hashMap)).append(n16);
        int n17 = ((SmltHelper)object).checkCgroup();
        ((StringBuilder)((Object)hashMap)).append(n17);
        Context context5 = MobSDK.getContext();
        int n18 = ((SmltHelper)object).checkBluetooth(context5);
        ((StringBuilder)((Object)hashMap)).append(n18);
        Context context6 = MobSDK.getContext();
        int n19 = ((SmltHelper)object).checkImei(context6);
        ((StringBuilder)((Object)hashMap)).append(n19);
        Context context7 = MobSDK.getContext();
        int n20 = ((SmltHelper)object).checkCommonApp(context7);
        ((StringBuilder)((Object)hashMap)).append(n20);
        int n21 = ((SmltHelper)object).checkCpuInfo();
        ((StringBuilder)((Object)hashMap)).append(n21);
        Object object3 = MobSDK.getContext();
        n11 = ((SmltHelper)object).checkSensor((Context)object3);
        ((StringBuilder)((Object)hashMap)).append(n11);
        hashMap = Data.MD5(((StringBuilder)((Object)hashMap)).toString());
        object3 = i.m();
        if (hashMap == null || (n10 = ((String)((Object)hashMap)).equals(object3)) == 0) {
            i.h((String)((Object)hashMap));
            hashMap = new HashMap<String, Object[]>();
            if (object2 != null && (n10 = ((Object[])object2).length) == n12 && (n10 = (object3 = object2[n12 = 1]) instanceof HashMap) != 0) {
                object2 = (HashMap)object2[n12];
                hashMap.putAll((Map<String, Object[]>)object2);
            }
            object2 = n13;
            hashMap.put("ckBaseband", (Object[])object2);
            object2 = n14;
            hashMap.put("ckBoard", (Object[])object2);
            object2 = n15;
            hashMap.put("ckPlatform", (Object[])object2);
            object2 = n16;
            hashMap.put("ckFlavor", (Object[])object2);
            object2 = n17;
            hashMap.put("ckCgroup", (Object[])object2);
            object2 = n18;
            hashMap.put("ckBluetooth", (Object[])object2);
            object2 = n19;
            hashMap.put("ckImei", (Object[])object2);
            object2 = n20;
            hashMap.put("ckCommonapp", (Object[])object2);
            object2 = n21;
            hashMap.put("ckCpuinfo", (Object[])object2);
            object2 = n11;
            String string2 = "ckSensor";
            hashMap.put(string2, (Object[])object2);
            object2 = "SIMULATOR_DET_INFO";
            this.a(hashMap, (String)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object[] i() {
        boolean bl2;
        int n10;
        Object object;
        int n11;
        int n12;
        HashMap<String, String> hashMap;
        Object object2;
        Object object3;
        Object object4;
        StringBuilder stringBuilder;
        Object[] objectArray;
        Object object5;
        block48: {
            int n13;
            block46: {
                int n14;
                block47: {
                    block45: {
                        block44: {
                            Object object6;
                            block43: {
                                block42: {
                                    File file;
                                    block41: {
                                        object5 = "com.bluestacks.appmart";
                                        int n15 = 2;
                                        objectArray = new Object[n15];
                                        stringBuilder = new StringBuilder();
                                        object4 = DeviceHelper.getInstance(MobSDK.getContext());
                                        object3 = ((DeviceHelper)object4).getQemuKernel();
                                        stringBuilder.append((String)object3);
                                        n14 = 1;
                                        try {
                                            object6 = "/system/lib/libc_malloc_debug_qemu.so";
                                            file = new File((String)object6);
                                            object2 = "/sys/qemu_trace";
                                            object6 = new File((String)object2);
                                            hashMap = "/system/bin/qemu-props";
                                            object2 = new File((String)((Object)hashMap));
                                            n12 = file.exists();
                                            if (n12 == 0 && (n12 = ((File)object6).exists()) == 0 && (n12 = ((File)object2).exists()) == 0) break block41;
                                            n12 = n14;
                                            break block42;
                                        }
                                        catch (Throwable throwable) {
                                            object6 = MobLog.getInstance();
                                            ((NLog)object6).d(throwable);
                                        }
                                    }
                                    n12 = 0;
                                    file = null;
                                }
                                stringBuilder.append(n12 != 0);
                                try {
                                    object2 = "/dev/qemu_pipe";
                                    object6 = new File((String)object2);
                                    hashMap = "/dev/socket/qemud";
                                    object2 = new File((String)((Object)hashMap));
                                    n11 = ((File)object6).exists();
                                    if (n11 == 0 && (n11 = ((File)object2).exists()) == 0) break block43;
                                    n11 = n14;
                                    break block44;
                                }
                                catch (Throwable throwable) {
                                    object2 = MobLog.getInstance();
                                    ((NLog)object2).d(throwable);
                                }
                            }
                            n11 = 0;
                            object6 = null;
                        }
                        stringBuilder.append(n11 != 0);
                        try {
                            n13 = ((DeviceHelper)object4).isPackageInstalled((String)object5);
                            if (n13 != 0) break block45;
                        }
                        catch (Throwable throwable) {
                            n13 = 0;
                            object2 = null;
                            break block46;
                        }
                        try {
                            object = "/data/bluestacks.prop";
                            hashMap = new HashMap<String, String>((String)object);
                            n13 = ((File)((Object)hashMap)).exists();
                            if (n13 != 0) break block45;
                            n13 = 0;
                            object2 = null;
                            break block47;
                        }
                        catch (Throwable throwable) {
                            break block46;
                        }
                    }
                    n13 = n14;
                }
                if (n13 == 0 && (n13 = ((File)((Object)(hashMap = new HashMap<String, String>((String)(object = "/mnt/prebundledapps/bluestacks.prop.orig"))))).exists()) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                hashMap = "com.bluestacks.BstCommandProcessor";
                if (n13 == 0 && (n13 = ((DeviceHelper)object4).isPackageInstalled((String)((Object)hashMap))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n13 = ((DeviceHelper)object4).isPackageInstalled((String)(object = "com.bluestacks.help"))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n13 = ((DeviceHelper)object4).isPackageInstalled((String)(object = "com.bluestacks.home"))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n13 = ((DeviceHelper)object4).isPackageInstalled((String)(object = "com.bluestacks.s2p"))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n13 = ((DeviceHelper)object4).isPackageInstalled((String)(object = "com.bluestacks.searchapp"))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n13 = ((DeviceHelper)object4).isPackageInstalled((String)(object = "com.bluestacks.accelerometerui"))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n13 = ((DeviceHelper)object4).isPackageInstalled((String)(object = "com.bluestacks.appfinder"))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n10 = ((DeviceHelper)object4).isPackageInstalled((String)object5)) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n10 = ((DeviceHelper)object4).isPackageInstalled((String)(object5 = "com.bluestacks.appsettings"))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n10 = ((DeviceHelper)object4).isPackageInstalled((String)((Object)hashMap))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n10 = ((DeviceHelper)object4).isPackageInstalled((String)(object5 = "com.bluestacks.bstfolder"))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n10 = ((DeviceHelper)object4).isPackageInstalled((String)(object5 = "com.bluestacks.setup"))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n10 = ((DeviceHelper)object4).isPackageInstalled((String)(object5 = "com.bluestacks.spotlight"))) == 0) {
                    n13 = 0;
                    object2 = null;
                } else {
                    n13 = n14;
                }
                if (n13 == 0 && (n10 = ((DeviceHelper)object4).isPackageInstalled((String)(object5 = "com.androVM.vmconfig"))) == 0) {
                    n10 = 0;
                    object5 = null;
                    break block48;
                } else {
                    n10 = n14;
                }
                break block48;
            }
            hashMap = MobLog.getInstance();
            ((NLog)((Object)hashMap)).d((Throwable)object5);
            n10 = n13;
        }
        stringBuilder.append(n10 != 0);
        object2 = ((DeviceHelper)object4).getTTYDriversInfo();
        if (object2 != null && !(bl2 = ((ArrayList)object2).isEmpty())) {
            boolean bl3;
            hashMap = ((ArrayList)object2).iterator();
            while (bl3 = hashMap.hasNext()) {
                boolean bl4;
                object = (ArrayList)hashMap.next();
                if (object == null || (bl4 = ((ArrayList)object).isEmpty())) continue;
                object = ((ArrayList)object).iterator();
                while (bl4 = object.hasNext()) {
                    String string2 = (String)object.next();
                    stringBuilder.append(string2);
                }
            }
        }
        object4 = ((DeviceHelper)object4).getCPUInfo();
        hashMap = new HashMap<String, String>();
        hashMap = ((Hashon)((Object)hashMap)).fromHashMap((HashMap)object4);
        stringBuilder.append((String)((Object)hashMap));
        hashMap = new HashMap<String, String>();
        hashMap.put("qemuKernel", (String)object3);
        object3 = n12 != 0;
        hashMap.put("qemuFileExist", (String)object3);
        object3 = n11 != 0;
        hashMap.put("qemuDevExist", (String)object3);
        object5 = n10 != 0;
        hashMap.put("blueStacksFileExist", (String)object5);
        hashMap.put("ttyDrivers", (String)object2);
        hashMap.put("cpuInfo", (String)object4);
        objectArray[0] = object5 = stringBuilder.toString();
        objectArray[n14] = hashMap;
        return objectArray;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private HashMap j() {
        Object object;
        Object object2;
        block9: {
            void var4_8;
            block8: {
                Object object3;
                boolean bl2;
                object2 = MobSDK.getContext();
                object = "comm/dbs/.lecd";
                if ((object2 = ResHelper.getDataCacheFile((Context)object2, (String)object)) != null && !(bl2 = ((File)object2).exists())) {
                    return new HashMap();
                }
                bl2 = false;
                object = null;
                try {
                    object3 = new FileInputStream((File)object2);
                    object2 = new ObjectInputStream((InputStream)object3);
                }
                catch (Throwable throwable) {
                    object2 = null;
                    break block8;
                }
                try {
                    object3 = ((ObjectInputStream)object2).readObject();
                    object3 = (HashMap)object3;
                    this.a((Closeable)object2);
                    object = object3;
                    break block9;
                }
                catch (Throwable throwable) {}
            }
            NLog nLog = MobLog.getInstance();
            nLog.d((Throwable)var4_8);
        }
        if (object != null) return object;
        return new HashMap();
        finally {
            this.a((Closeable)object2);
        }
    }

    public File a() {
        return e.a("comm/locks/.lesd_lock");
    }

    public void a(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        long l10 = 0L;
        if (n10 == n11) {
            long l11 = b.F();
            long l12 = l11 - l10;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                object = DeviceHelper.getInstance(MobSDK.getContext());
                h$1 h$1 = new h$1(this);
                ((DeviceHelper)object).getBatteryState(h$1);
            }
        } else {
            int n12 = 2;
            long l13 = 1000L;
            if (n10 == n12) {
                object = (HashMap)((Message)object).obj;
                long l14 = this.a((HashMap)object);
                long l15 = l14 - l10;
                Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object3 == false) {
                    l10 = b.F();
                    l14 = l10 * l13;
                }
                this.a(n11, l14);
            } else {
                long l16;
                long l17;
                long l18;
                int n13 = 3;
                if (n10 == n13 && (l18 = (l17 = (l16 = b.H()) - l10) == 0L ? 0 : (l17 < 0L ? -1 : 1)) > 0) {
                    this.h();
                    this.a(n13, l16 *= l13);
                }
            }
        }
    }

    public boolean b_() {
        long l10;
        long l11;
        long l12 = b.F();
        long l13 = l12 - (l11 = 0L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object <= 0 && (object = (l10 = (l12 = b.H()) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1)) <= 0 ? (Object)0 : (Object)1;
        return (boolean)object;
    }

    public void d() {
        this.b(1);
        this.b(3);
    }
}

