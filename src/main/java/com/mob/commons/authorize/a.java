/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Base64
 */
package com.mob.commons.authorize;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.authorize.a$1;
import com.mob.commons.authorize.a$2;
import com.mob.commons.authorize.a$3;
import com.mob.commons.authorize.a$4;
import com.mob.commons.authorize.a$5;
import com.mob.commons.authorize.a$6;
import com.mob.commons.b;
import com.mob.commons.b.d;
import com.mob.commons.e;
import com.mob.commons.i;
import com.mob.commons.j;
import com.mob.commons.k;
import com.mob.commons.l;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public final class a {
    private static final String a = j.b("devs.data.mob.com");

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private String a(MobProduct var1_1, boolean var2_3, String var3_4) {
        synchronized (this) {
            block31: {
                block35: {
                    block34: {
                        block36: {
                            block33: {
                                block32: {
                                    var4_5 = MobSDK.getContext();
                                    var4_5 = DeviceHelper.getInstance((Context)var4_5);
                                    var5_6 = var4_5.getSdcardState();
                                    var6_7 = this.e();
                                    if (var6_7 == null) break block31;
                                    var7_8 = var6_7.size();
                                    if (var7_8 <= 0) break block31;
                                    var8_9 /* !! */  = "duid";
                                    var8_9 /* !! */  = var6_7.get(var8_9 /* !! */ );
                                    ** try [egrp 6[TRYBLOCK] [6 : 57->62)] { 
lbl19:
                                    // 2 sources

                                    var9_10 = i.F();
                                    var11_11 = TextUtils.isEmpty((CharSequence)var8_9 /* !! */ );
                                    if (var11_11) break block32;
                                    var3_4 = var8_9 /* !! */ ;
                                }
                                var7_8 = (int)TextUtils.isEmpty((CharSequence)var3_4);
                                var11_11 = true;
                                var12_12 = false;
                                if (var7_8 == 0) break block33;
                                var3_4 = this.a(var3_4);
                                var13_13 = "duid";
                                var6_7.put(var13_13, var3_4);
lbl36:
                                // 3 sources

                                while (true) {
                                    var12_12 = var11_11;
                                    ** GOTO lbl-1000
                                    break;
                                }
                            }
                            var14_16 = System.currentTimeMillis();
                            var7_8 = (int)(var14_16 == var9_10 ? 0 : (var14_16 < var9_10 ? -1 : 1));
                            if (var7_8 < 0) break block36;
                            var13_14 = this.c(var3_4);
                            var16_17 = TextUtils.isEmpty((CharSequence)var13_14);
                            if (var16_17) ** GOTO lbl-1000
                            var3_4 = "duid";
                            var6_7.put(var3_4, var13_14);
                            var3_4 = var13_14;
                        }
                        if (!var5_6) ** GOTO lbl-1000
                        var17_18 = var4_5.getWAbcd(0);
                        var7_8 = (int)TextUtils.isEmpty((CharSequence)var17_18);
                        if (var7_8 == 0) break block34;
                        var4_5.saveWabcd(var3_4, 0);
                        ** break block37
                    }
                    var7_8 = (int)var3_4.equals(var17_18);
                    if (var7_8 != 0) ** GOTO lbl-1000
                    if (!var2_3) break block35;
                    var13_15 = "duid";
                    var6_7.put(var13_15, var17_18);
                    var3_4 = var17_18;
                    ** continue;
                }
                var4_5.saveWabcd(var3_4, 0);
lbl-1000:
                // 6 sources

                {
                    if (var12_12) {
                        this.a(var6_7, var11_11);
                    }
                    this.a(var6_7, var12_12, var1_1);
                }
            }
            var3_4 = this.a(var3_4);
            this.a(var3_4, var1_1);
        }
    }

    public static /* synthetic */ String a(a a10, MobProduct mobProduct, boolean bl2, String string2) {
        return a10.a(mobProduct, bl2, string2);
    }

    public static /* synthetic */ String a(a a10, boolean bl2) {
        return a10.a(bl2);
    }

    private String a(String string2) {
        String string3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2 && (string3 = DeviceAuthorizer.a) != null) {
            return string3;
        }
        string3 = this.b(string2);
        if (string3 == null) {
            if (string2 == null) {
                boolean bl3 = true;
                string2 = this.a(bl3);
            }
        } else {
            string2 = string3;
        }
        return string2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(boolean var1_1) {
        block16: {
            var2_2 = ":";
            var3_3 = DeviceHelper.getInstance(MobSDK.getContext());
            var4_4 = var3_3.getSdcardState();
            var5_5 /* !! */  = var3_3.getWAbcd(0);
            var6_6 = TextUtils.isEmpty((CharSequence)var5_5 /* !! */ );
            if (!var6_6) {
                return var5_5 /* !! */ ;
            }
            var5_5 /* !! */  = var3_3.getModel();
            var6_6 = com.mob.commons.a.c();
            if (var6_6 && !(var6_6 = com.mob.commons.a.d())) {
                var6_6 = false;
                var7_7 = null;
                var8_8 /* !! */  = null;
                var9_9 /* !! */  = null;
            } else {
                var7_7 = var3_3.getIMEI();
                var8_8 /* !! */  = var3_3.getMacAddress();
                var9_9 /* !! */  = var3_3.getSerialno();
            }
            var5_5 /* !! */  = var5_5 /* !! */  == null ? null : var5_5 /* !! */ .trim();
            var8_8 /* !! */  = var8_8 /* !! */  == null ? null : var8_8 /* !! */ .trim();
            if (var7_7 == null) {
                var6_6 = false;
                var7_7 = null;
            } else {
                var7_7 = var7_7.trim();
            }
            var9_9 /* !! */  = var9_9 /* !! */  == null ? null : var9_9 /* !! */ .trim();
            var10_10 = TextUtils.isEmpty((CharSequence)var7_7);
            if (!var10_10) ** GOTO lbl62
            var11_11 = MobSDK.getContext();
            if ((var11_11 = d.c((Context)var11_11)) == null) {
                var10_10 = false;
                var11_11 = null;
            } else {
                var11_11 = var11_11.trim();
            }
            var12_13 = TextUtils.isEmpty((CharSequence)var11_11);
            if (var12_13) break block16;
            var7_7 = var11_11;
            ** GOTO lbl62
            {
                catch (Throwable var14_15) {
                    MobLog.getInstance().w(var14_15);
                    return null;
                }
            }
        }
        try {
            var11_11 = var3_3.getAdvertisingID();
            if (var11_11 == null) {
                var6_6 = false;
                var7_7 = null;
            } else {
                var7_7 = var11_11.trim();
            }
            ** GOTO lbl58
        }
        catch (Throwable var11_12) {
            var13_14 = MobLog.getInstance();
            var13_14.w(var11_12);
lbl58:
            // 3 sources

            var10_10 = TextUtils.isEmpty((CharSequence)var7_7);
            if (var10_10) {
                var7_7 = UUID.randomUUID();
                var7_7 = var7_7.toString();
            }
lbl62:
            // 5 sources

            var11_11 = new StringBuilder();
            var11_11.append(var5_5 /* !! */ );
            var11_11.append((String)var2_2);
            var11_11.append((String)var7_7);
            var11_11.append((String)var2_2);
            var11_11.append(var8_8 /* !! */ );
            var11_11.append((String)var2_2);
            var11_11.append(var9_9 /* !! */ );
            var2_2 = var11_11.toString();
            var2_2 = Data.SHA1((String)var2_2);
            var2_2 = Data.byteToHex((byte[])var2_2);
            if (var1_1 && var4_4) {
                var3_3.saveWabcd((String)var2_2, 0);
            }
            return var2_2;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static HashMap a(File object) {
        void var2_5;
        Object object2;
        block15: {
            boolean bl2 = ((File)object).exists();
            if (!bl2) return null;
            bl2 = ((File)object).isFile();
            if (!bl2) return null;
            {
                catch (Throwable throwable) {
                    return null;
                }
            }
            object2 = new FileInputStream((File)object);
            object = new ObjectInputStream((InputStream)object2);
            try {
                object2 = ((ObjectInputStream)object).readObject();
                object2 = (HashMap)object2;
            }
            catch (Throwable throwable) {}
            ((ObjectInputStream)object).close();
            return object2;
            break block15;
            catch (Throwable throwable) {
                object = null;
            }
        }
        NLog nLog = MobLog.getInstance();
        nLog.w((Throwable)var2_5);
        if (object == null) return null;
        ((ObjectInputStream)object).close();
        return null;
        catch (Throwable throwable) {
            block14: {
                if (object == null) break block14;
                try {
                    ((ObjectInputStream)object).close();
                    break block14;
                }
                catch (Throwable throwable2) {}
                catch (Throwable throwable3) {
                    return object2;
                }
            }
            throw throwable;
        }
    }

    private void a(long l10) {
        Object object = MobSDK.getContext();
        Object object2 = "comm/dbs/.digap";
        object = ResHelper.getDataCacheFile((Context)object, (String)object2);
        object2 = new FileOutputStream((File)object);
        object = new DataOutputStream((OutputStream)object2);
        try {
            ((DataOutputStream)object).writeLong(l10);
            ((DataOutputStream)object).flush();
            ((FilterOutputStream)object).close();
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
    }

    public static void a(Context object) {
        block52: {
            DeviceHelper deviceHelper;
            boolean bl2;
            File file;
            Object object2;
            block42: {
                String string2;
                String string3;
                String string4;
                String string5;
                boolean bl3;
                boolean bl4;
                Object object3;
                String string6;
                block51: {
                    block44: {
                        block45: {
                            boolean bl5;
                            block43: {
                                block41: {
                                    block40: {
                                        object2 = "comm/dbs/.duid";
                                        string6 = "unknown";
                                        if (object == null) {
                                            return;
                                        }
                                        file = ResHelper.getCacheRootFile((Context)object, (String)object2);
                                        object3 = com.mob.commons.authorize.a.a(file);
                                        Context context = MobSDK.getContext();
                                        object2 = ResHelper.getDataCacheFile(context, (String)object2);
                                        bl4 = false;
                                        context = null;
                                        bl3 = true;
                                        float f10 = Float.MIN_VALUE;
                                        if (object3 == null) break block40;
                                        bl2 = ((HashMap)object3).isEmpty();
                                        if (bl2) break block40;
                                        bl2 = bl3;
                                        break block41;
                                    }
                                    object3 = com.mob.commons.authorize.a.a((File)object2);
                                    bl2 = false;
                                    string5 = null;
                                }
                                deviceHelper = DeviceHelper.getInstance((Context)object);
                                if (object3 == null) break block42;
                                string4 = "deviceInfo";
                                object3 = ((HashMap)object3).get(string4);
                                if (object3 == null) break block42;
                                string4 = "model";
                                string4 = ((HashMap)object3).get(string4);
                                string3 = "factory";
                                object3 = ((HashMap)object3).get(string3);
                                object3 = (String)object3;
                                bl5 = string6.equalsIgnoreCase(string4);
                                string2 = null;
                                if (!bl5) break block43;
                                string4 = null;
                            }
                            bl5 = string6.equalsIgnoreCase((String)object3);
                            if (bl5) {
                                object3 = null;
                            }
                            if (!bl2) break block44;
                            bl2 = TextUtils.isEmpty((CharSequence)string4);
                            if (bl2) break block45;
                            bl2 = TextUtils.isEmpty((CharSequence)object3);
                            if (!bl2) break block44;
                        }
                        bl2 = bl3;
                        break block51;
                    }
                    bl2 = false;
                    string5 = null;
                }
                if (!bl2) {
                    block50: {
                        block49: {
                            boolean bl6;
                            block48: {
                                block47: {
                                    block46: {
                                        string5 = deviceHelper.getModel();
                                        string3 = deviceHelper.getManufacturer();
                                        boolean bl7 = string6.equalsIgnoreCase(string5);
                                        if (!bl7) break block46;
                                        bl2 = false;
                                        string5 = null;
                                    }
                                    bl6 = string6.equalsIgnoreCase(string3);
                                    if (bl6) break block47;
                                    string2 = string3;
                                }
                                bl6 = TextUtils.isEmpty((CharSequence)string5);
                                if (bl6) break block48;
                                bl6 = TextUtils.isEmpty((CharSequence)string4);
                                if (bl6) break block48;
                                bl6 = string5.equalsIgnoreCase(string4);
                                if (!bl6) break block49;
                            }
                            bl6 = TextUtils.isEmpty((CharSequence)string2);
                            if (bl6) break block50;
                            bl6 = TextUtils.isEmpty((CharSequence)object3);
                            if (bl6) break block50;
                            bl6 = string2.equalsIgnoreCase((String)object3);
                            if (bl6) break block50;
                        }
                        bl4 = bl3;
                    }
                    bl2 = bl4;
                }
            }
            if (!bl2) break block52;
            file.delete();
            ((File)object2).delete();
            deviceHelper.removeWABCD();
            object2 = "comm/.di";
            object2 = ResHelper.getCacheRootFile((Context)object, (String)object2);
            ((File)object2).delete();
            object2 = ".dk";
            object2 = ResHelper.getCacheRootFile((Context)object, (String)object2);
            ((File)object2).delete();
            object2 = ".mcw";
            object2 = ResHelper.getCacheRootFile((Context)object, (String)object2);
            ((File)object2).delete();
            object2 = ".slw";
            object = ResHelper.getCacheRootFile((Context)object, (String)object2);
            try {
                ((File)object).delete();
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
        }
    }

    public static /* synthetic */ void a(a a10, HashMap hashMap, String string2) {
        a10.a(hashMap, string2);
    }

    public static /* synthetic */ void a(a a10, HashMap hashMap, boolean bl2) {
        a10.a(hashMap, bl2);
    }

    private void a(String string2, MobProduct mobProduct) {
        a$5 a$5 = new a$5(this, string2, mobProduct);
        a$5.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(HashMap object, String object2) {
        Object object3;
        ArrayList<Object> arrayList;
        Object object4;
        int n10;
        int n11;
        ArrayList<Object> arrayList2;
        Object object5;
        Object object6;
        int n12;
        Object object7;
        block18: {
            object7 = "carrier";
            n12 = b.I();
            if (n12 != 0) {
                return;
            }
            object6 = l.a();
            object6 = ((l)object6).b();
            this.b((HashMap)object);
            object5 = "deviceInfo";
            object = ((HashMap)object).get(object5);
            object = (HashMap)object;
            object5 = new HashMap();
            arrayList2 = "token";
            ((HashMap)object5).put(arrayList2, object6);
            object = ((HashMap)object).entrySet();
            object = object.iterator();
            while ((n12 = object.hasNext()) != 0) {
                object6 = object.next();
                object6 = (Map.Entry)object6;
                arrayList2 = object6.getKey();
                object6 = object6.getValue();
                ((HashMap)object5).put(arrayList2, object6);
            }
            try {
                object = ((HashMap)object5).get(object7);
                object = String.valueOf(object);
                n11 = ResHelper.parseInt((String)object);
                object = n11;
                ((HashMap)object5).put(object7, object);
            }
            catch (Throwable throwable) {}
            object = "androidids";
            object = ((HashMap)object5).remove(object);
            object = (ArrayList)object;
            if (object != null && (n10 = ((ArrayList)object).isEmpty()) == 0) {
                object7 = "androidid";
                n12 = ((ArrayList)object).size() + -1;
                object = ((ArrayList)object).get(n12);
                ((HashMap)object5).put(object7, object);
            }
            object = MobSDK.getContext();
            object = DeviceHelper.getInstance((Context)object);
            object7 = "duid";
            ((HashMap)object5).put(object7, object2);
            object7 = ((DeviceHelper)object).queryIMEI();
            if (object7 == null || (n12 = ((String[])object7).length) <= 0) break block18;
            object6 = "imeiArray";
            ((HashMap)object5).put(object6, object7);
        }
        try {
            object7 = ((DeviceHelper)object).listNetworkHardware();
            if (object7 != null && (n12 = (int)(((HashMap)object7).isEmpty() ? 1 : 0)) == 0) {
                boolean bl2;
                object6 = new ArrayList();
                object7 = ((HashMap)object7).entrySet();
                object7 = object7.iterator();
                while (bl2 = object7.hasNext()) {
                    arrayList2 = object7.next();
                    arrayList2 = (Map.Entry)((Object)arrayList2);
                    object4 = new HashMap();
                    arrayList = "ss";
                    object3 = arrayList2.getKey();
                    ((HashMap)object4).put(arrayList, object3);
                    arrayList = "mac";
                    arrayList2 = arrayList2.getValue();
                    ((HashMap)object4).put(arrayList, arrayList2);
                    ((ArrayList)object6).add(object4);
                }
                object7 = "macArray";
                ((HashMap)object5).put(object7, object6);
            }
        }
        catch (Throwable throwable) {}
        try {
            object7 = ((DeviceHelper)object).getMemoryInfo();
            object6 = ((DeviceHelper)object).getSizeInfo();
            arrayList2 = "total";
            if (object7 != null) {
                object4 = "ram";
                object7 = ((HashMap)object7).get(arrayList2);
                ((HashMap)object5).put(object4, object7);
            }
            if (object6 != null) {
                object7 = "sdcard";
                object7 = ((HashMap)object6).get(object7);
                if ((object7 = (HashMap)object7) != null) {
                    object4 = "sdcardStorage";
                    object7 = ((HashMap)object7).get(arrayList2);
                    ((HashMap)object5).put(object4, object7);
                }
                object7 = "data";
                object7 = ((HashMap)object6).get(object7);
                if ((object7 = (HashMap)object7) != null) {
                    object6 = "dataStorage";
                    object7 = ((HashMap)object7).get(arrayList2);
                    ((HashMap)object5).put(object6, object7);
                }
            }
            object7 = "romImg";
            object = ((DeviceHelper)object).getMIUIVersion();
            ((HashMap)object5).put(object7, object);
            object = new Hashon();
            object7 = ((Hashon)object).fromHashMap((HashMap)object5);
            object6 = this.f();
            object7 = Data.AES128Encode((String)object6, (String)object7);
            n12 = 2;
            object7 = Base64.encodeToString((byte[])object7, (int)n12);
            arrayList2 = new ArrayList<Object>();
            object5 = "m";
            object6 = new KVPair((String)object5, object7);
            arrayList2.add(object6);
            object3 = new Object();
            ((NetworkHelper$NetworkTimeOut)object3).readTimout = n10 = 30000;
            ((NetworkHelper$NetworkTimeOut)object3).connectionTimeout = n10;
            object6 = new NetworkHelper();
            object7 = new StringBuilder();
            object5 = a;
            ((StringBuilder)object7).append((String)object5);
            object5 = "/dinfo";
            ((StringBuilder)object7).append((String)object5);
            object5 = ((StringBuilder)object7).toString();
            arrayList = new ArrayList<Object>();
            object4 = "User-Identity";
            String string2 = MobProductCollector.getUserIdentity();
            object7 = new KVPair((String)object4, string2);
            arrayList.add(object7);
            int n13 = 68;
            object4 = k.a(n13);
            string2 = MobSDK.getContext();
            string2 = d.d((Context)string2);
            object7 = new KVPair((String)object4, string2);
            arrayList.add(object7);
            n13 = 0;
            object4 = null;
            object7 = ((NetworkHelper)object6).httpPost((String)object5, (ArrayList)arrayList2, null, arrayList, (NetworkHelper$NetworkTimeOut)object3);
            object = ((Hashon)object).fromJson((String)object7);
            object7 = "200";
            object6 = "status";
            object = ((HashMap)object).get(object6);
            object = String.valueOf(object);
            n11 = (int)(((String)object7).equals(object) ? 1 : 0);
            if (n11 == 0) return;
            i.i((String)object2);
            long l10 = b.a();
            long l11 = b.L();
            this.a(l10 += l11);
            return;
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void a(HashMap var1_1, boolean var2_6) {
        block41: {
            block40: {
                block39: {
                    var3_7 = "duid";
                    var4_8 = null;
                    if (var2_6) ** GOTO lbl48
                    var5_9 = var1_1.get(var3_7);
                    var5_9 = (String)var5_9;
                    var6_10 = MobSDK.getContext();
                    var6_10 = DeviceHelper.getInstance((Context)var6_10);
                    var7_11 = var6_10.getSdcardState();
                    if (!var7_11) ** GOTO lbl48
                    var8_12 = this.e();
                    if (var8_12 == null) break block39;
                    var6_10 = var8_12.get(var3_7);
                    var6_10 = ResHelper.forceCast(var6_10, null);
                    var6_10 = (String)var6_10;
                    var7_11 = TextUtils.isEmpty((CharSequence)var6_10);
                    if (var7_11) ** GOTO lbl48
                    var2_6 = var6_10.equals(var5_9);
                    if (var2_6) ** GOTO lbl48
                    var1_1.put(var3_7, var6_10);
                    ** GOTO lbl48
                }
                var7_11 = false;
                var8_12 = null;
                var6_10 = var6_10.getWAbcd(0);
                var7_11 = TextUtils.isEmpty((CharSequence)var6_10);
                if (var7_11) ** GOTO lbl48
                var2_6 = var6_10.equals(var5_9);
                if (var2_6) ** GOTO lbl48
                var1_1.put(var3_7, var6_10);
lbl48:
                // 8 sources

                var5_9 = this.c();
                var3_7 = new FileOutputStream((File)var5_9);
                var6_10 = new ObjectOutputStream((OutputStream)var3_7);
                var6_10.writeObject(var1_1);
                var1_1 = this.d();
                var3_7 = var5_9.getAbsolutePath();
                var4_8 = var1_1.getAbsolutePath();
                var9_13 = var3_7.equals(var4_8);
                if (var9_13) break block40;
                var1_1.delete();
                var5_9 = var5_9.getAbsolutePath();
                var1_1 = var1_1.getAbsolutePath();
                ResHelper.copyFile((String)var5_9, (String)var1_1);
            }
            var6_10.flush();
            var6_10.close();
            catch (Throwable var1_2) {
                var4_8 = var6_10;
            }
            break block41;
            catch (Throwable var1_3) {
                // empty catch block
            }
        }
        var5_9 = MobLog.getInstance();
        var5_9.w((Throwable)var1_4);
lbl87:
        // 2 sources

        return;
        catch (Throwable v0) {}
        ** while (true)
        finally {
            if (var4_8 != null) {
                var4_8.flush();
                var4_8.close();
            }
        }
    }

    private void a(HashMap hashMap, boolean bl2, MobProduct mobProduct) {
        a$2 a$2 = new a$2(this, bl2, hashMap, mobProduct);
        a$2.start();
    }

    private boolean a(MobProduct object, HashMap hashMap) {
        int n10;
        boolean bl2 = b.I();
        if (bl2) {
            return false;
        }
        Object object2 = DeviceHelper.getInstance(MobSDK.getContext());
        Object object3 = new ArrayList();
        Object object4 = object.getProductTag();
        Object object5 = new KVPair("product", object4);
        ((ArrayList)object3).add(object5);
        object5 = "duid";
        object4 = hashMap.get(object5);
        String string2 = object4;
        string2 = object4;
        Object object6 = MobSDK.getAppkey();
        object4 = new KVPair("appkey", object6);
        ((ArrayList)object3).add(object4);
        object4 = new KVPair((String)object5, string2);
        ((ArrayList)object3).add(object4);
        object4 = String.valueOf(((DeviceHelper)object2).getPackageName());
        object5 = new KVPair("apppkg", object4);
        ((ArrayList)object3).add(object5);
        object4 = String.valueOf(((DeviceHelper)object2).getAppVersion());
        object5 = new KVPair("appver", object4);
        ((ArrayList)object3).add(object5);
        object4 = String.valueOf(object.getSdkver());
        object5 = new KVPair("sdkver", object4);
        ((ArrayList)object3).add(object5);
        object4 = String.valueOf(((DeviceHelper)object2).getDetailNetworkTypeForStatic());
        object5 = new KVPair("network", object4);
        ((ArrayList)object3).add(object5);
        NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = new NetworkHelper$NetworkTimeOut();
        networkHelper$NetworkTimeOut.readTimout = n10 = 30000;
        networkHelper$NetworkTimeOut.connectionTimeout = n10;
        object5 = new NetworkHelper();
        object4 = new StringBuilder();
        object6 = a;
        ((StringBuilder)object4).append((String)object6);
        ((StringBuilder)object4).append("/dsign");
        object4 = ((StringBuilder)object4).toString();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string3 = MobProductCollector.getUserIdentity();
        object6 = new KVPair("User-Identity", string3);
        arrayList.add(object6);
        int n11 = 68;
        string3 = k.a(n11);
        String string4 = d.d(MobSDK.getContext());
        object6 = new KVPair(string3, string4);
        arrayList.add(object6);
        object6 = null;
        object5 = ((NetworkHelper)object5).httpPost((String)object4, (ArrayList)object3, null, arrayList, networkHelper$NetworkTimeOut);
        object4 = new Hashon();
        object5 = ((Hashon)object4).fromJson((String)object5);
        object4 = String.valueOf(((HashMap)object5).get("reup"));
        object3 = "true";
        boolean bl3 = ((String)object3).equals(object4);
        if (bl3) {
            this.a(hashMap, string2);
        }
        if ((n10 = (int)(((String)(object4 = "200")).equals(object5 = String.valueOf(((HashMap)object5).get("status"))) ? 1 : 0)) != 0) {
            hashMap = (HashMap)hashMap.get("appInfo");
            object2 = ((DeviceHelper)object2).getPackageName();
            hashMap = (HashMap)hashMap.get(object2);
            object = object.getProductTag();
            object2 = MobSDK.getAppkey();
            hashMap.put(object, object2);
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean a(a a10) {
        return a10.g();
    }

    public static /* synthetic */ boolean a(a a10, HashMap hashMap) {
        return a10.a(hashMap);
    }

    public static /* synthetic */ boolean a(a a10, HashMap hashMap, MobProduct mobProduct) {
        return a10.a(hashMap, mobProduct);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(HashMap object) {
        int n10;
        int n11;
        Object object2;
        Object object3;
        int n12;
        Object object4;
        block34: {
            int n13;
            NLog nLog;
            String string2;
            object4 = (HashMap)((HashMap)object).get("deviceInfo");
            n12 = 1;
            if (object4 == null) {
                return n12;
            }
            object3 = DeviceHelper.getInstance(MobSDK.getContext());
            object = ((HashMap)object).get("duid");
            object2 = i.n();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2 && object != null) {
                string2 = String.valueOf(object);
                i.i(string2);
            }
            if (!(bl2 = TextUtils.isEmpty((CharSequence)object2)) && object != null && (n11 = ((String)object2).equals(object)) == 0) {
                return n12;
            }
            object = ((HashMap)object4).get("adsid");
            n10 = 0;
            object2 = null;
            try {
                object2 = ((DeviceHelper)object3).getAdvertisingID();
            }
            catch (Throwable throwable) {
                nLog = MobLog.getInstance();
                nLog.w(throwable);
            }
            if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
                return n12;
            }
            System.currentTimeMillis();
            n11 = b.X();
            if (n11 != 0) {
                object = ((HashMap)object4).get("phoneno");
                object2 = ((DeviceHelper)object3).getLN();
                if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
                    return n12;
                }
            }
            object = ((HashMap)object4).get("simserialno");
            object2 = ((DeviceHelper)object3).getSimSerialNumber();
            if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
                return n12;
            }
            object = ((HashMap)object4).get("imei");
            object2 = ((DeviceHelper)object3).getIMEI();
            if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
                return n12;
            }
            object = ((HashMap)object4).get("serialno");
            object2 = ((DeviceHelper)object3).getSerialno();
            if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
                return n12;
            }
            object = ((HashMap)object4).get("mac");
            object2 = ((DeviceHelper)object3).getMacAddress();
            if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
                return n12;
            }
            object = ((HashMap)object4).get("model");
            object2 = ((DeviceHelper)object3).getModel();
            if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
                return n12;
            }
            object = ((HashMap)object4).get("factory");
            object2 = ((DeviceHelper)object3).getManufacturer();
            if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
                return n12;
            }
            object = ((HashMap)object4).get("carrier");
            object2 = ((DeviceHelper)object3).getCarrier();
            if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
                return n12;
            }
            object = ((HashMap)object4).get("imsi");
            object2 = ((DeviceHelper)object3).getIMSI();
            if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
                return n12;
            }
            object = ((HashMap)object4).get("imsiArray");
            object2 = ((DeviceHelper)object3).queryIMSI();
            bl2 = false;
            string2 = null;
            if (object2 != null && (n13 = ((String[])object2).length) > 0) {
                if (object == null) {
                    return n12;
                }
                try {
                    object = (ArrayList)object;
                    n13 = ((ArrayList)object).size();
                    int n14 = ((String[])object2).length;
                    if (n13 != n14) {
                        return n12;
                    }
                    n13 = ((Object)object2).length;
                    int n15 = 0;
                    Object object5 = null;
                    block4: for (n14 = 0; n14 < n13; ++n14) {
                        boolean bl3;
                        object5 = object2[n14];
                        Iterator iterator2 = ((ArrayList)object).iterator();
                        while (bl3 = iterator2.hasNext()) {
                            Object object6 = iterator2.next();
                            bl3 = ((String)object5).equals(object6 = (String)object6);
                            if (!bl3) continue;
                            n15 = 0;
                            object5 = null;
                            continue block4;
                        }
                        n15 = n12;
                    }
                    if (n15 != 0) {
                        return n12;
                    }
                }
                catch (Throwable throwable) {}
            }
            if ((object = ((HashMap)object4).get("androidids")) == null && (object = ((HashMap)object4).get("androidid")) != null) {
                object2 = new ArrayList();
                ((ArrayList)object2).add(object);
                object = object2;
            }
            if (object == null) return n12;
            n10 = object instanceof ArrayList;
            if (n10 == 0) {
                return n12;
            }
            object2 = ((DeviceHelper)object3).getAndroidID();
            object = ((ArrayList)object).iterator();
            while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                nLog = object.next();
                if (nLog == null || (n13 = (int)(nLog.equals(object2) ? 1 : 0)) == 0) continue;
                n11 = n12;
                break block34;
            }
            n11 = 0;
            object = null;
        }
        if (n11 == 0) {
            return n12;
        }
        object = ((HashMap)object4).get("sysver");
        object2 = ((DeviceHelper)object3).getOSVersionName();
        if (object2 != null && (n11 = ((String)object2).equals(object)) == 0) {
            return n12;
        }
        object = ((HashMap)object4).get("xp");
        n10 = ((DeviceHelper)object3).cx();
        if (object == null) return n12;
        object2 = String.valueOf(n10);
        n11 = ((String)object2).equals(object = String.valueOf(object));
        if (n11 == 0) {
            return n12;
        }
        object = ((HashMap)object4).get("breaked");
        boolean bl4 = ((DeviceHelper)object3).isRooted();
        if (object == null) {
            if (bl4) return n12;
        }
        if (object != null && (n11 = (int)(((String)(object = String.valueOf(object))).equals(object3 = String.valueOf(bl4)) ? 1 : 0)) == 0) {
            return n12;
        }
        n11 = 69;
        object = k.a(n11);
        object = ((HashMap)object4).get(object);
        object4 = d.c(MobSDK.getContext());
        if (object == null) {
            bl4 = TextUtils.isEmpty((CharSequence)object4);
            if (!bl4) return n12;
        }
        if (object == null) return false;
        n11 = (int)(((String)(object = String.valueOf(object))).equals(object4) ? 1 : 0);
        if (n11 != 0) return false;
        return n12;
    }

    private boolean a(HashMap hashMap, MobProduct object) {
        boolean bl2;
        block25: {
            float f10;
            float f11;
            boolean bl3;
            block24: {
                block23: {
                    Object object2;
                    Object object3;
                    Object object4;
                    block22: {
                        block21: {
                            object4 = "appInfo";
                            if (object == null) {
                                object = new a$3(this);
                            }
                            bl3 = false;
                            f11 = 0.0f;
                            object3 = hashMap.get(object4);
                            object3 = (HashMap)object3;
                            bl2 = true;
                            f10 = Float.MIN_VALUE;
                            if (object3 != null) break block21;
                            object3 = new HashMap();
                            hashMap.put(object4, object3);
                            bl3 = bl2;
                            f11 = f10;
                        }
                        object4 = MobSDK.getContext();
                        object4 = DeviceHelper.getInstance((Context)object4);
                        object4 = ((DeviceHelper)object4).getPackageName();
                        object2 = ((HashMap)object3).get(object4);
                        object2 = (HashMap)object2;
                        if (object2 != null) break block22;
                        object2 = new HashMap();
                        ((HashMap)object3).put(object4, object2);
                        bl3 = bl2;
                        f11 = f10;
                    }
                    object4 = object.getProductTag();
                    object4 = ((HashMap)object2).get(object4);
                    object4 = (String)object4;
                    object3 = MobSDK.getAppkey();
                    if (object4 == null) break block23;
                    boolean bl4 = ((String)object4).equals(object3);
                    if (bl4) break block24;
                }
                try {
                    boolean bl5 = this.a((MobProduct)object, hashMap);
                    if (!bl5) break block24;
                    break block25;
                }
                catch (Throwable throwable) {
                    object = MobLog.getInstance();
                    ((NLog)object).w(throwable);
                }
            }
            bl2 = bl3;
            f10 = f11;
        }
        return bl2;
    }

    public static /* synthetic */ String b() {
        return a;
    }

    private String b(String string2) {
        block6: {
            Object object;
            try {
                object = MobSDK.getContext();
            }
            catch (Throwable throwable) {
                MobLog.getInstance().w(throwable);
                return null;
            }
            object = DeviceHelper.getInstance((Context)object);
            boolean bl2 = false;
            object = ((DeviceHelper)object).getWAbcd(0);
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block6;
            return object;
        }
        return this.c(string2);
    }

    public static /* synthetic */ void b(a a10, HashMap hashMap) {
        a10.c(hashMap);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(HashMap var1_1) {
        block65: {
            var2_3 = "imsiArray";
            var3_8 = "androidids";
            var4_9 = "deviceInfo";
            var5_10 = MobSDK.getContext();
            var5_10 = DeviceHelper.getInstance((Context)var5_10);
            var6_11 = var1_1.get(var4_9);
            var6_11 = (HashMap)var6_11;
            if (var6_11 == null) {
                var6_11 = new HashMap();
                var1_1.put(var4_9, var6_11);
            }
            if (!(var8_21 = TextUtils.isEmpty((CharSequence)(var7_12 = i.n())))) {
                var9_22 = "lduid";
                var6_11.put((String)var9_22, (String)var7_12);
            }
            var7_12 = "plat";
            var8_21 = 1;
            var10_23 = var8_21;
            var6_11.put(var7_12, var10_23);
            var7_12 = "deviceType";
            var10_23 = var5_10.getDeviceType();
            var6_11.put(var7_12, var10_23);
            var7_12 = var5_10.getOSVersionName();
            var11_25 = TextUtils.isEmpty((CharSequence)var7_12);
            if (var11_25) break block65;
            var10_23 = "sysver";
            var6_11.put(var10_23, var7_12);
        }
        try {
            var7_12 = var5_10.getModel();
            var11_25 = TextUtils.isEmpty((CharSequence)var7_12);
            if (!var11_25) {
                var10_23 = "model";
                var6_11.put(var10_23, var7_12);
            }
        }
        catch (Throwable var7_13) {
            var10_23 = MobLog.getInstance();
            var10_23.w(var7_13);
        }
        try {
            var7_12 = var5_10.getManufacturer();
            var11_25 = TextUtils.isEmpty((CharSequence)var7_12);
            if (!var11_25) {
                var10_23 = "factory";
                var6_11.put(var10_23, var7_12);
            }
            ** GOTO lbl60
        }
        catch (Throwable var7_14) {
            var10_23 = MobLog.getInstance();
            var10_23.w(var7_14);
lbl60:
            // 2 sources

            if ((var12_26 = b.X()) && !(var11_25 = TextUtils.isEmpty((CharSequence)(var7_12 = var5_10.getLN())))) {
                var10_23 = "phoneno";
                var6_11.put(var10_23, var7_12);
            }
            if (!(var11_25 = TextUtils.isEmpty((CharSequence)(var7_12 = var5_10.getSimSerialNumber())))) {
                var10_23 = "simserialno";
                var6_11.put(var10_23, var7_12);
            }
            var12_26 = false;
            var7_12 = null;
            try {
                var7_12 = var5_10.getAdvertisingID();
                ** GOTO lbl78
            }
            catch (Throwable var10_24) {
                block66: {
                    var13_27 = MobLog.getInstance();
                    var13_27.w(var10_24);
lbl78:
                    // 2 sources

                    var11_25 = TextUtils.isEmpty((CharSequence)var7_12);
                    if (var11_25) break block66;
                    var10_23 = "adsid";
                    var6_11.put(var10_23, var7_12);
                }
                try {
                    var7_12 = var5_10.getIMEI();
                    var11_25 = TextUtils.isEmpty((CharSequence)var7_12);
                    if (!var11_25) {
                        var10_23 = "imei";
                        var6_11.put(var10_23, var7_12);
                    }
                }
                catch (Throwable var7_15) {
                    var10_23 = MobLog.getInstance();
                    var10_23.w(var7_15);
                }
                try {
                    var7_12 = var5_10.getSerialno();
                    var11_25 = TextUtils.isEmpty((CharSequence)var7_12);
                    if (!var11_25) {
                        var10_23 = "serialno";
                        var6_11.put(var10_23, var7_12);
                    }
                }
                catch (Throwable var7_16) {
                    var10_23 = MobLog.getInstance();
                    var10_23.w(var7_16);
                }
                try {
                    var7_12 = var5_10.getMacAddress();
                    var11_25 = TextUtils.isEmpty((CharSequence)var7_12);
                    if (!var11_25) {
                        var10_23 = "mac";
                        var6_11.put(var10_23, var7_12);
                    }
                }
                catch (Throwable var7_17) {
                    var10_23 = MobLog.getInstance();
                    var10_23.w(var7_17);
                }
                try {
                    var7_12 = var5_10.getIMSI();
                    var11_25 = TextUtils.isEmpty((CharSequence)var7_12);
                    if (!var11_25) {
                        var10_23 = "imsi";
                        var6_11.put(var10_23, var7_12);
                    }
                    ** GOTO lbl139
                }
                catch (Throwable var7_18) {
                    block67: {
                        var10_23 = MobLog.getInstance();
                        var10_23.w(var7_18);
lbl139:
                        // 2 sources

                        var7_12 = var6_11.get(var2_3);
                        var11_25 = false;
                        var10_23 = null;
                        var13_27 = var5_10.queryIMSI();
                        if (var13_27 == null || (var14_28 = ((String[])var13_27).length) <= 0) ** GOTO lbl196
                        if (var7_12 == null) {
                            var14_28 = var8_21;
                        } else {
                            var14_28 = 0;
                            var15_29 = null;
                        }
                        if (var14_28) ** GOTO lbl187
                        try {
                            var7_12 = var7_12;
                            var16_30 = var7_12.size();
                            var14_28 = ((String[])var13_27).length;
                            if (var16_30 != var14_28) {
                                var14_28 = var8_21;
                            } else {
                                var14_28 = 0;
                                var15_29 = null;
                            }
                            if (var14_28) ** GOTO lbl187
                            var16_30 = ((String[])var13_27).length;
                            block41: for (var17_31 = 0; var17_31 < var16_30; ++var17_31) {
                                var15_29 = var13_27[var17_31];
                            }
                            ** GOTO lbl187
                        }
                        catch (Throwable var7_20) {
                            // empty catch block
                        }
                        {
                            try {
                                var18_32 = var7_12.iterator();
                                while (var19_33 = var18_32.hasNext()) {
                                    var20_34 /* !! */  = var18_32.next();
                                    var19_33 = var15_29.equals(var20_34 /* !! */  = (String)var20_34 /* !! */ );
                                    if (!var19_33) continue;
                                    var14_28 = 0;
                                    var15_29 = null;
                                    continue block41;
                                }
                                var14_28 = var8_21;
                                continue;
                            }
                            catch (Throwable var7_19) {
                                var14_28 = var8_21;
                                break block67;
                                break;
                            }
                        }
                    }
                    try {
                        var21_35 = MobLog.getInstance();
                        var21_35.d((Throwable)var7_12);
lbl187:
                        // 4 sources

                        if (var14_28) {
                            var6_11.put(var2_3, var13_27);
                        }
                        ** GOTO lbl196
                    }
                    catch (Throwable var2_4) {
                        block68: {
                            var7_12 = MobLog.getInstance();
                            var7_12.w(var2_4);
lbl196:
                            // 3 sources

                            if (!(var12_26 = TextUtils.isEmpty((CharSequence)(var2_3 = var5_10.getCarrier())))) {
                                var7_12 = "carrier";
                                var6_11.put(var7_12, var2_3);
                            }
                            if ((var2_3 = var6_11.get(var3_8)) != null) break block68;
                            var2_3 = "androidid";
                            var2_3 = var6_11.get(var2_3);
                            if (var2_3 == null) break block68;
                            var7_12 = new ArrayList<ArrayList<Object>>();
                            var7_12.add((ArrayList<Object>)var2_3);
                            var2_3 = var7_12;
                        }
                        if (var2_3 == null || !(var12_26 = var2_3 instanceof ArrayList)) ** GOTO lbl228
                        try {
                            block69: {
                                var7_12 = var5_10.getAndroidID();
                                var13_27 = var2_3.iterator();
                                while (var14_28 = (int)var13_27.hasNext()) {
                                    var15_29 = var13_27.next();
                                    if (var15_29 == null || !(var14_28 = (int)var15_29.equals(var7_12))) continue;
                                    var22_36 = var8_21;
                                    break block69;
                                }
                                var22_36 = 0;
                                var13_27 = null;
                            }
                            if (!var22_36) {
                                var2_3.add(var7_12);
                                var6_11.put(var3_8, var2_3);
                            }
                            ** GOTO lbl240
lbl228:
                            // 1 sources

                            var2_3 = new ArrayList();
                            var7_12 = var5_10.getAndroidID();
                            var2_3.add(var7_12);
                            var6_11.put(var3_8, var2_3);
                            ** GOTO lbl240
                        }
                        catch (Throwable var2_5) {}
                        var3_8 = MobLog.getInstance();
                        var3_8.w(var2_5);
lbl240:
                        // 3 sources

                        var23_37 = var5_10.isRooted();
                        var3_8 = "breaked";
                        var2_3 = (boolean)var23_37;
                        var6_11.put(var3_8, var2_3);
                        var23_37 = var5_10.cx();
                        if (var23_37) {
                            var23_37 = var8_21;
                        } else {
                            var23_37 = 0;
                            var2_3 = null;
                        }
                        var3_8 = "xp";
                        var2_3 = var23_37;
                        var6_11.put(var3_8, var2_3);
                        try {
                            var23_37 = (int)var5_10.checkPad();
                            if (!var23_37) {
                                var8_21 = 0;
                                var9_22 = null;
                            }
                            var2_3 = "pad";
                            var3_8 = var8_21;
                            var6_11.put(var2_3, var3_8);
                            ** GOTO lbl270
                        }
                        catch (Throwable var2_6) {
                            var3_8 = MobLog.getInstance();
                            var3_8.w(var2_6);
lbl270:
                            // 2 sources

                            var23_37 = (int)b.X();
                            var2_3 = var5_10.getIInfo((boolean)var23_37);
                            var3_8 = "sims";
                            var6_11.put(var3_8, var2_3);
                            var2_3 = "screensize";
                            try {
                                var3_8 = var5_10.getScreenSize();
                                var6_11.put(var2_3, var3_8);
                                ** GOTO lbl286
                            }
                            catch (Throwable var2_7) {
                                try {
                                    var3_8 = MobLog.getInstance();
                                    var3_8.w(var2_7);
lbl286:
                                    // 2 sources

                                    var2_3 = MobSDK.getContext();
                                    var2_3 = d.a((Context)var2_3);
                                    if (var2_3 != null && (var24_38 = var2_3.size()) > 0) {
                                        var6_11.putAll(var2_3);
                                    }
                                    var1_1.put(var4_9, var6_11);
                                    return;
                                }
                                catch (Throwable var1_2) {
                                    var2_3 = MobLog.getInstance();
                                    var2_3.w(var1_2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ boolean b(a a10) {
        return a10.h();
    }

    private File c() {
        return ResHelper.getDataCacheFile(MobSDK.getContext(), "comm/dbs/.duid");
    }

    private String c(String object) {
        block48: {
            block49: {
                Object object2;
                Object object3;
                block47: {
                    block46: {
                        object3 = "duid";
                        boolean bl2 = b.I();
                        if (!bl2) break block46;
                        return null;
                    }
                    object2 = MobSDK.getContext();
                    object2 = DeviceHelper.getInstance((Context)object2);
                    Object object4 = new HashMap();
                    String string2 = "plat";
                    int n10 = 1;
                    Object object5 = n10;
                    ((HashMap)object4).put(string2, object5);
                    string2 = "imei";
                    object5 = ((DeviceHelper)object2).getIMEI();
                    ((HashMap)object4).put(string2, object5);
                    string2 = "serialno";
                    object5 = ((DeviceHelper)object2).getSerialno();
                    ((HashMap)object4).put(string2, object5);
                    string2 = "mac";
                    object5 = ((DeviceHelper)object2).getMacAddress();
                    ((HashMap)object4).put(string2, object5);
                    string2 = "model";
                    object5 = ((DeviceHelper)object2).getModel();
                    ((HashMap)object4).put(string2, object5);
                    string2 = "factory";
                    object5 = ((DeviceHelper)object2).getManufacturer();
                    ((HashMap)object4).put(string2, object5);
                    string2 = "adsid";
                    object5 = ((DeviceHelper)object2).getAdvertisingID();
                    ((HashMap)object4).put(string2, object5);
                    string2 = "oaid";
                    object5 = MobSDK.getContext();
                    object5 = d.c((Context)object5);
                    ((HashMap)object4).put(string2, object5);
                    string2 = "imsi";
                    object5 = ((DeviceHelper)object2).getIMSI();
                    ((HashMap)object4).put(string2, object5);
                    string2 = "androidid";
                    object5 = ((DeviceHelper)object2).getAndroidID();
                    ((HashMap)object4).put(string2, object5);
                    string2 = "simserialno";
                    object5 = ((DeviceHelper)object2).getSimSerialNumber();
                    ((HashMap)object4).put(string2, object5);
                    ((HashMap)object4).put(object3, object);
                    object = "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07";
                    string2 = "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd";
                    int n11 = 1024;
                    object5 = new MobCommunicator(n11, (String)object, string2);
                    object = new StringBuilder();
                    string2 = a;
                    ((StringBuilder)object).append(string2);
                    string2 = "/dgen";
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                    string2 = null;
                    object = ((MobCommunicator)object5).requestSynchronized((HashMap)object4, (String)object, false);
                    object = (HashMap)object;
                    object4 = "dri";
                    object4 = ((HashMap)object).get(object4);
                    if (object4 == null) break block47;
                    object4 = (Integer)object4;
                    int n12 = (Integer)object4;
                    long l10 = System.currentTimeMillis();
                    n12 = n12 * 60 * 60 * 1000;
                    long l11 = n12;
                    l10 += l11;
                    i.i(l10);
                }
                object = ((HashMap)object).get(object3);
                if (object == null) break block48;
                object = String.valueOf(object);
                boolean bl3 = ((DeviceHelper)object2).getSdcardState();
                if (!bl3) break block49;
                try {
                    ((DeviceHelper)object2).saveWabcd((String)object, 0);
                }
                catch (Throwable throwable) {
                    object3 = MobLog.getInstance();
                    ((NLog)object3).w(throwable);
                    long l12 = System.currentTimeMillis();
                    i.i(l12);
                }
            }
            return object;
        }
        return null;
    }

    public static /* synthetic */ HashMap c(a a10) {
        return a10.e();
    }

    private void c(HashMap hashMap) {
        File file = e.a("comm/locks/.globalLock");
        a$4 a$4 = new a$4(this, hashMap);
        e.a(file, a$4);
    }

    private File d() {
        Object object = ResHelper.getDataCache(MobSDK.getContext());
        String string2 = "comm/dbs/.duid";
        File file = new File((String)object, string2);
        boolean bl2 = ((File)(object = file.getParentFile())).exists();
        if (!bl2) {
            object = file.getParentFile();
            ((File)object).mkdirs();
        }
        return file;
    }

    private HashMap e() {
        Serializable serializable = this.c();
        try {
            serializable = com.mob.commons.authorize.a.a(serializable);
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
            serializable = null;
        }
        return serializable;
    }

    private String f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sd");
        stringBuilder.append("k.");
        stringBuilder.append("co");
        stringBuilder.append("mm");
        stringBuilder.append("on");
        stringBuilder.append("ap");
        stringBuilder.append(".s");
        stringBuilder.append("dk");
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean g() {
        try {
            Object object = this.c();
            Object object2 = this.d();
            String string2 = ((File)object).getPath();
            String string3 = ((File)object2).getPath();
            boolean bl2 = string2.equals(string3);
            if (bl2) {
                return false;
            }
            bl2 = ((File)object).exists();
            if (bl2 && (bl2 = ((File)object).isFile())) {
                bl2 = ((File)object2).exists();
                if (bl2) {
                    bl2 = ((File)object2).isFile();
                    if (bl2) return false;
                }
                object = ((File)object).getAbsolutePath();
                object2 = ((File)object2).getAbsolutePath();
                ResHelper.copyFile((String)object, (String)object2);
                return false;
            }
            bl2 = ((File)object2).exists();
            if (!bl2) return false;
            bl2 = ((File)object2).isFile();
            if (!bl2) return false;
            object2 = ((File)object2).getAbsolutePath();
            object = ((File)object).getAbsolutePath();
            ResHelper.copyFile((String)object2, (String)object);
            return true;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
        return false;
    }

    private boolean h() {
        boolean bl2;
        Object object = ResHelper.getDataCacheFile(MobSDK.getContext(), "comm/dbs/.digap");
        boolean bl3 = false;
        if (object != null && (bl2 = ((File)object).exists())) {
            Object object2 = new FileInputStream((File)object);
            object = new DataInputStream((InputStream)object2);
            long l10 = ((DataInputStream)object).readLong();
            try {
                ((FilterInputStream)object).close();
                long l11 = b.a();
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l12 < 0) {
                    bl3 = true;
                }
                return bl3;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        } else {
            long l13 = b.L();
            long l14 = b.a();
            this.a(l13 += l14);
        }
        return false;
    }

    public final String a() {
        Object object;
        block7: {
            block6: {
                String string2;
                try {
                    object = this.e();
                    if (object == null) break block6;
                    string2 = "duid";
                }
                catch (Throwable throwable) {
                    MobLog.getInstance().w(throwable);
                    return null;
                }
                object = ((HashMap)object).get(string2);
                object = (String)object;
                break block7;
            }
            object = null;
        }
        if (object == null) {
            object = this.a((String)null);
        }
        return object;
    }

    public final String a(MobProduct mobProduct, String string2) {
        String[] stringArray = new String[1];
        File file = e.a("comm/locks/.globalLock");
        a$1 a$1 = new a$1(this, stringArray, mobProduct, string2);
        e.a(file, a$1);
        return stringArray[0];
    }

    public final String a(boolean bl2, boolean bl3) {
        String[] stringArray = new String[1];
        File file = e.a("comm/locks/.globalLock");
        a$6 a$6 = new a$6(this, bl2, bl3, stringArray);
        e.a(file, a$6);
        return stringArray[0];
    }
}

