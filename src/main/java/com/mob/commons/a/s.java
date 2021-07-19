/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Message
 *  android.util.Base64
 */
package com.mob.commons.a;

import android.content.Context;
import android.os.Message;
import android.util.Base64;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.a.d;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b;
import com.mob.commons.j;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class s
extends d {
    private SharePrefrenceHelper a;

    private static Object a(HashMap hashMap, String string2) {
        boolean bl2 = b.I();
        if (bl2) {
            return null;
        }
        MobCommunicator mobCommunicator = new MobCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1");
        return mobCommunicator.requestSynchronized(hashMap, string2, false);
    }

    private Object b(HashMap hashMap) {
        long l10;
        String string2 = "cplAt";
        try {
            l10 = b.a();
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return null;
        }
        Long l11 = l10;
        hashMap.put(string2, l11);
        string2 = "v.data.mob.com/cpl";
        string2 = j.a(string2);
        return s.a(hashMap, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void l() {
        synchronized (this) {
            SharePrefrenceHelper sharePrefrenceHelper = this.a;
            if (sharePrefrenceHelper == null) {
                Context context = MobSDK.getContext();
                this.a = sharePrefrenceHelper = new SharePrefrenceHelper(context);
                String string2 = "vpl_cache";
                sharePrefrenceHelper.open(string2);
            }
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void m() {
        block76: {
            block78: {
                var1_1 = this;
                var2_2 = "pkgs";
                var3_4 = "lastVplId";
                var4_5 = "lastVplAt";
                var5_6 = "networktype";
                var6_7 = "appver";
                var7_8 = "apppkg";
                var8_9 = MobSDK.getContext();
                var8_9 = DeviceHelper.getInstance((Context)var8_9);
                var9_10 = new HashMap<Object, Object>();
                var10_11 = MobSDK.getAppkey();
                var11_12 = 0;
                var12_13 = null;
                var12_13 = DeviceAuthorizer.authorize(null);
                var13_14 = "appkey";
                var9_10.put(var13_14, var10_11);
                var13_14 = var8_9.getPackageName();
                var9_10.put(var7_8, var13_14);
                var14_15 = var8_9.getAppVersion();
                var13_14 = var14_15;
                var9_10.put(var6_7, var13_14);
                var13_14 = "duid";
                var9_10.put(var13_14, var12_13);
                var13_14 = "plat";
                var15_16 = var8_9.getPlatformCode();
                var16_17 = var15_16;
                var9_10.put(var13_14, var16_17);
                var13_14 = var8_9.getNetworkType();
                var9_10.put(var5_6, var13_14);
                var17_18 = this.i();
                var13_14 = var17_18;
                var9_10.put(var4_5, var13_14);
                var13_14 = new ArrayList<HashMap<K, V>>();
                var13_14.append((String)var10_11);
                var10_11 = ":";
                var13_14.append((String)var10_11);
                var13_14.append((String)var12_13);
                var10_11 = var13_14.toString();
                var12_13 = "utf-8";
                var10_11 = var10_11.getBytes((String)var12_13);
                var11_12 = 2;
                var10_11 = Base64.encodeToString((byte[])var10_11, (int)var11_12);
                var9_10.put(var3_4, var10_11);
                var12_13 = "v.data.mob.com/vpl";
                var12_13 = j.a((String)var12_13);
                var12_13 = s.a(var9_10, (String)var12_13);
                var12_13 = (HashMap)var12_13;
                if (var12_13 == null) ** GOTO lbl215
                var14_15 = var12_13.size();
                if (var14_15 == 0) ** GOTO lbl215
                this.j();
                var12_13 = var12_13.get(var2_2);
                var12_13 = (List)var12_13;
                if (var12_13 == null) break block76;
                var14_15 = var12_13.size();
                if (var14_15 <= 0) break block76;
                var13_14 = new ArrayList<HashMap<K, V>>();
                var12_13 = var12_13.iterator();
                block69: while (true) {
                    block77: {
                        var15_16 = (int)var12_13.hasNext();
                        if (var15_16 == 0) break;
                        var16_17 = var12_13.next();
                        var16_17 = (String)var16_17;
                        var19_19 = new HashMap<String, Object>();
                        var19_19.put(var7_8, var16_17);
                        var20_20 /* !! */  = MobSDK.getContext();
                        var20_20 /* !! */  = var20_20 /* !! */ .getPackageManager();
                        var21_21 = 0;
                        var22_22 = null;
                        var16_17 = var20_20 /* !! */ .getPackageInfo((String)var16_17, 0);
                        var20_20 /* !! */  = var16_17.versionName;
                        var19_19.put(var6_7, var20_20 /* !! */ );
                        var16_17 = var16_17.applicationInfo;
                        var15_16 = var16_17.flags;
                        var23_23 = var15_16 & 1;
                        var21_21 = 1;
                        if (var23_23 == var21_21) {
                            var23_23 = var21_21;
                        } else {
                            var23_23 = 0;
                            var20_20 /* !! */  = null;
                        }
                        if ((var15_16 &= 128) == var21_21) {
                            var15_16 = var21_21;
                        } else {
                            var15_16 = 0;
                            var16_17 = null;
                        }
                        var22_22 = "issys";
                        if (var23_23 == 0 && var15_16 == 0) {
                            var24_24 = false;
                            break block77;
                        }
                        var24_24 = true;
                    }
                    var16_17 = var24_24;
                    var19_19.put(var22_22, var16_17);
lbl153:
                    // 2 sources

                    while (true) {
                        var13_14.add(var19_19);
                        continue block69;
                        break;
                    }
                    break;
                }
                var9_10.remove(var5_6);
                var9_10.remove(var4_5);
                var9_10.remove(var3_4);
                var3_4 = "mac";
                var4_5 = var8_9.getMacAddress();
                var9_10.put(var3_4, var4_5);
                var3_4 = "model";
                var4_5 = var8_9.getModel();
                var9_10.put(var3_4, var4_5);
                var3_4 = "imei";
                var4_5 = var8_9.getIMEI();
                var9_10.put(var3_4, var4_5);
                var3_4 = "serialno";
                var4_5 = var8_9.getSerialno();
                var9_10.put(var3_4, var4_5);
                var3_4 = "datetime";
                var25_25 = b.a();
                var4_5 = var25_25;
                var9_10.put(var3_4, var4_5);
                var3_4 = "id";
                var9_10.put(var3_4, var10_11);
                var9_10.put(var2_2, var13_14);
                var2_2 = var1_1.b(var9_10);
                if (var2_2 != null) break block78;
                var2_2 = var1_1.b(var9_10);
            }
            if (var2_2 != null) break block76;
            try {
                block79: {
                    break block79;
lbl215:
                    // 2 sources

                    return;
                }
                var1_1.a(var9_10);
            }
            catch (Throwable var2_3) {
                var3_4 = MobLog.getInstance();
                var3_4.d(var2_3);
            }
        }
        return;
        catch (Throwable v0) {
            ** continue;
        }
    }

    public File a() {
        return this.h();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Message message) {
        long l10;
        long l11;
        long l12;
        int n10 = message.what;
        if (n10 == 0 && (n10 = (int)((l12 = (l11 = b.D()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0) {
            l10 = 1000L;
            l11 *= l10;
            n10 = 0;
            message = null;
            try {
                boolean bl2;
                Thread.sleep(l11);
                Object object = this.k();
                if (object != null && !(bl2 = ((HashMap)object).isEmpty()) && (object = this.b((HashMap)object)) != null) {
                    this.a((HashMap)null);
                }
            }
            catch (Throwable throwable) {}
            this.m();
            this.a = null;
            n10 = 0;
            message = null;
            l11 = b.E() * l10;
            this.a(0, l11);
        }
    }

    public void a(HashMap object) {
        synchronized (this) {
            this.l();
            if (object == null) {
                object = this.a;
                String string2 = "LAST_FAILED_DATA";
                ((SharePrefrenceHelper)object).remove(string2);
            } else {
                SharePrefrenceHelper sharePrefrenceHelper = this.a;
                String string3 = "LAST_FAILED_DATA";
                sharePrefrenceHelper.put(string3, object);
            }
            return;
        }
    }

    public boolean b_() {
        long l10;
        long l11 = b.D();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void d() {
        this.b(0);
    }

    public File h() {
        Object object = ResHelper.getDataCache(MobSDK.getContext());
        String string2 = ".vpl_lock";
        File file = new File((String)object, string2);
        boolean bl2 = ((File)(object = file.getParentFile())).exists();
        if (!bl2) {
            object = file.getParentFile();
            ((File)object).mkdirs();
        }
        return file;
    }

    public long i() {
        synchronized (this) {
            this.l();
            SharePrefrenceHelper sharePrefrenceHelper = this.a;
            String string2 = "LAST_UPLOAD_TIME";
            long l10 = sharePrefrenceHelper.getLong(string2);
            return l10;
        }
    }

    public void j() {
        synchronized (this) {
            this.l();
            SharePrefrenceHelper sharePrefrenceHelper = this.a;
            String string2 = "LAST_UPLOAD_TIME";
            long l10 = b.a();
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public HashMap k() {
        synchronized (this) {
            this.l();
            Object object = this.a;
            String string2 = "LAST_FAILED_DATA";
            object = ((SharePrefrenceHelper)object).get(string2);
            object = (HashMap)object;
            return object;
        }
    }
}

