/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.os.Build$VERSION
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.mob.commons.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.a.d;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.e;
import com.mob.commons.k;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;

public class q
extends d {
    private static final String a;
    private PackageManager b;
    private Process c = null;
    private OutputStream d = null;
    private String e = null;
    private long f = 0L;
    private boolean g = true;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        String string2 = n10 >= n11 ? "^u\\d+_a\\d+" : "^app_\\d+";
        a = string2;
    }

    private ArrayList a(HashMap[][] hashMapArray, ArrayList arrayList) {
        int n10;
        HashMap[][] hashMapArray2 = hashMapArray;
        int n11 = hashMapArray.length;
        ArrayList arrayList2 = new ArrayList(n11);
        Integer n12 = 0;
        for (n11 = 0; n11 < (n10 = hashMapArray2.length); ++n11) {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            long l10 = 0L;
            Object object = l10;
            String string2 = "runtimes";
            hashMap.put(string2, object);
            object = "fg";
            hashMap.put(object, n12);
            String string3 = "bg";
            hashMap.put(string3, n12);
            String string4 = "empty";
            hashMap.put(string4, n12);
            arrayList2.add(hashMap);
            HashMap[] hashMapArray3 = hashMapArray2[n11];
            int n13 = hashMapArray3.length;
            int n14 = 1;
            n13 -= n14;
            while (n13 >= 0) {
                Object object2 = hashMapArray3[n13];
                if (object2 != null) {
                    Object object3;
                    long l11;
                    object2 = hashMap.get(string2);
                    Long l12 = l10;
                    object2 = (Long)ResHelper.forceCast(object2, l12);
                    long l13 = (Long)object2;
                    if (n13 == 0) {
                        l11 = l10;
                    } else {
                        object3 = (long[])arrayList.get(n13);
                        l11 = object3[n14];
                    }
                    object3 = l13 += l11;
                    hashMap.put(string2, object3);
                    object3 = hashMapArray3[n13];
                    object2 = "pcy";
                    object3 = object3.get(object2);
                    int n15 = ((String)object).equals(object3);
                    if (n15 != 0) {
                        n15 = (Integer)ResHelper.forceCast(hashMap.get(object), n12) + n14;
                        object3 = n15;
                        hashMap.put(object, object3);
                    } else {
                        object3 = hashMapArray3[n13].get(object2);
                        n15 = (int)(string3.equals(object3) ? 1 : 0);
                        if (n15 != 0) {
                            n15 = (Integer)ResHelper.forceCast(hashMap.get(string3), n12) + n14;
                            object3 = n15;
                            hashMap.put(string3, object3);
                        } else {
                            n15 = (Integer)ResHelper.forceCast(hashMap.get(string4), n12) + n14;
                            object3 = n15;
                            hashMap.put(string4, object3);
                        }
                    }
                    object3 = hashMapArray3[n13];
                    object2 = "pkg";
                    object3 = object3.get(object2);
                    hashMap.put(object2, object3);
                    object3 = hashMapArray3[n13];
                    object2 = "name";
                    object3 = object3.get(object2);
                    hashMap.put(object2, object3);
                    object3 = hashMapArray3[n13];
                    object2 = "version";
                    object3 = object3.get(object2);
                    hashMap.put(object2, object3);
                }
                n13 += -1;
                l10 = 0L;
            }
        }
        return arrayList2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private HashMap a(String var1_1, String[] var2_3) {
        block26: {
            var3_4 /* !! */  = this.b;
            if (var3_4 /* !! */  != null) ** GOTO lbl10
            var3_4 /* !! */  = MobSDK.getContext();
            var3_4 /* !! */  = var3_4 /* !! */ .getPackageManager();
            this.b = var3_4 /* !! */ ;
lbl10:
            // 2 sources

            var3_4 /* !! */  = this.b;
            var4_5 = 0;
            var5_6 = null;
            var3_4 /* !! */  = var3_4 /* !! */ .getPackageInfo(var1_1 /* !! */ , 0);
            var6_7 /* !! */  = var3_4 /* !! */ .applicationInfo;
            var7_8 = var6_7 /* !! */ .flags;
            var8_9 = var7_8 & 1;
            var9_10 = 1;
            var8_9 = var8_9 == var9_10 ? var9_10 : 0;
            if ((var7_8 &= 128) == var9_10) {
                var4_5 = var9_10;
            }
            if (var8_9 != 0 || var4_5 != 0) break block26;
            var5_6 = new HashMap<Object, Object>();
            var6_7 /* !! */  = "pkg";
            var5_6.put(var6_7 /* !! */ , var1_1 /* !! */ );
            var1_1 /* !! */  = var3_4 /* !! */ .applicationInfo;
            var6_7 /* !! */  = this.b;
            try {
                var1_1 /* !! */  = var1_1 /* !! */ .loadLabel((PackageManager)var6_7 /* !! */ );
            }
            catch (Throwable v0) {
                var1_1 /* !! */  = null;
            }
            var6_7 /* !! */  = "name";
            if (var1_1 /* !! */  == null) {
                var1_1 /* !! */  = var3_4 /* !! */ .packageName;
            } else {
                var1_1 /* !! */  = var1_1 /* !! */ .toString();
            }
            var5_6.put(var6_7 /* !! */ , var1_1 /* !! */ );
            var1_1 /* !! */  = "version";
            var3_4 /* !! */  = var3_4 /* !! */ .versionName;
            var5_6.put(var1_1 /* !! */ , var3_4 /* !! */ );
            var1_1 /* !! */  = "pcy";
            var10_11 = ((Object)var2_3).length + -3;
            var2_3 = var2_3[var10_11];
            try {
                var5_6.put(var1_1 /* !! */ , var2_3);
                return var5_6;
            }
            catch (Throwable var1_2) {
                var2_3 = MobLog.getInstance();
                var2_3.d(var1_2);
            }
        }
        return null;
    }

    private HashMap a(ArrayList object) {
        boolean bl2;
        HashMap<Object, StringBuilder> hashMap = new HashMap<Object, StringBuilder>();
        object = ((ArrayList)object).iterator();
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            boolean bl3;
            Iterator iterator2 = ((ArrayList)object.next()).iterator();
            while (bl3 = iterator2.hasNext()) {
                Object object2 = (HashMap)iterator2.next();
                Comparable<StringBuilder> comparable = new StringBuilder();
                String string2 = (String)((HashMap)object2).get("pkg");
                comparable.append(string2);
                comparable.append(":");
                string2 = "version";
                object2 = (String)((HashMap)object2).get(string2);
                comparable.append((String)object2);
                object2 = comparable.toString();
                boolean bl4 = hashMap.containsKey(object2);
                if (bl4) continue;
                comparable = n10;
                hashMap.put(object2, (StringBuilder)comparable);
                ++n10;
            }
        }
        return hashMap;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void a(String var1_1, ArrayList var2_6, ArrayList var3_7) {
        block38: {
            block39: {
                var4_8 = null;
                var5_9 = this.l();
                var6_10 = new FileInputStream((String)var1_1 /* !! */ );
                var7_11 /* !! */  = "utf-8";
                var1_1 /* !! */  = new InputStreamReader((InputStream)var6_10, (String)var7_11 /* !! */ );
                var6_10 = new BufferedReader((Reader)var1_1 /* !! */ );
                var1_1 /* !! */  = var6_10.readLine();
                var4_8 = null;
                var7_11 /* !! */  = null;
                for (var8_12 = 0; var8_12 < (var9_13 = 7); ++var8_12) {
                    var1_1 /* !! */  = var6_10.readLine();
                    continue;
                }
                try {
                    var7_11 /* !! */  = new ArrayList();
                }
                catch (Throwable var1_2) {
                    var4_8 = var6_10;
                }
                while (var1_1 /* !! */  != null) {
                    block37: {
                        var10_14 = "======================";
                        var11_15 = var10_14.equals(var1_1 /* !! */ );
                        if (var11_15 == 0) break block37;
                        var1_1 /* !! */  = var6_10.readLine();
                        var10_14 = "_";
                        var1_1 /* !! */  = var1_1 /* !! */ .split((String)var10_14);
                        var11_15 = 2;
                        var10_14 = new long[var11_15];
                        var12_16 = var1_1 /* !! */ [0];
                        var13_17 = Long.parseLong(var12_16);
                        var10_14[0] = var13_17;
                        var15_18 = 1;
                        var1_1 /* !! */  = var1_1 /* !! */ [var15_18];
                        var16_19 = Long.parseLong((String)var1_1 /* !! */ );
                        var10_14[var15_18] = var16_19;
                        var2_6.add(var7_11 /* !! */ );
                        var3_7.add(var10_14);
lbl53:
                        // 2 sources

                        while (true) {
                            var1_1 /* !! */  = new ArrayList();
                            var7_11 /* !! */  = null;
                            for (var8_12 = 0; var8_12 < var9_13; ++var8_12) {
                                var6_10.readLine();
                                continue;
                            }
                            var7_11 /* !! */  = var1_1 /* !! */ ;
                            ** GOTO lbl70
                            break;
                        }
                    }
                    var11_15 = var1_1 /* !! */ .length();
                    if (var11_15 <= 0) ** GOTO lbl70
                    this.a((String)var1_1 /* !! */ , var5_9, (ArrayList)var7_11 /* !! */ );
lbl70:
                    // 3 sources

                    var1_1 /* !! */  = var6_10.readLine();
                }
                this.a(var6_10);
                break block38;
                break block39;
                catch (Throwable var1_3) {
                    // empty catch block
                }
            }
            var2_6 = MobLog.getInstance();
            var2_6.d((Throwable)var1_4);
        }
        return;
        finally {
            this.a(var4_8);
        }
        catch (Throwable v0) {
            ** continue;
        }
    }

    private void a(String object, HashMap object2, ArrayList arrayList) {
        int n10;
        int n11;
        String string2 = " +";
        String string3 = " ";
        if ((object = object.replaceAll(string2, string3).split(string3)) != null && (n11 = ((String[])object).length) >= (n10 = 10)) {
            n11 = ((String[])object).length;
            n10 = 1;
            string2 = object[n11 -= n10];
            int n12 = ((String[])object).length + -2;
            Object object3 = object[n12];
            String string4 = a;
            if ((n12 = (int)(((String)object3).matches(string4) ? 1 : 0)) != 0 && (n12 = (int)(((String)(object3 = "top")).equals(string2) ? 1 : 0)) == 0) {
                if (object2 != null && (n12 = (int)(object2.isEmpty() ? 1 : 0)) == 0) {
                    if ((object2 = (String[])object2.get(string2)) != null) {
                        object3 = new Object();
                        ((HashMap)object3).put("pkg", string2);
                        n11 = 0;
                        string2 = object2[0];
                        string4 = "name";
                        ((HashMap)object3).put(string4, string2);
                        object2 = object2[n10];
                        string2 = "version";
                        ((HashMap)object3).put(string2, object2);
                        int n13 = ((String[])object).length + -3;
                        object = object[n13];
                        object2 = "pcy";
                        ((HashMap)object3).put(object2, object);
                        arrayList.add(object3);
                    }
                } else if ((object = this.a(string2, (String[])object)) != null) {
                    arrayList.add(object);
                }
            }
        }
    }

    private void a(ArrayList object, ArrayList arrayList) {
        int n10;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string2 = "APP_RUNTIMES";
        hashMap.put("type", string2);
        hashMap.put("list", object);
        object = com.mob.commons.b.a();
        hashMap.put("datetime", object);
        long l10 = ((long[])arrayList.get(0))[0];
        object = l10;
        String string3 = "recordat";
        hashMap.put(string3, object);
        int n11 = 1;
        long l11 = 0L;
        for (int i10 = n11; i10 < (n10 = arrayList.size()); ++i10) {
            long[] lArray = (long[])arrayList.get(i10);
            long l12 = lArray[n11];
            l11 += l12;
        }
        object = l11;
        hashMap.put("sdk_runtime_len", object);
        object = arrayList.size();
        hashMap.put("top_count", object);
        object = com.mob.commons.c.a();
        l11 = com.mob.commons.b.a();
        ((c)object).a(l11, hashMap);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(String string2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.a(string2, arrayList, arrayList2);
        HashMap hashMap = this.a(arrayList);
        HashMap[][] hashMapArray = this.a(hashMap, arrayList);
        ArrayList arrayList3 = this.a(hashMapArray, arrayList2);
        try {
            this.a(arrayList3, arrayList2);
            return this.b(string2);
        }
        catch (Throwable throwable) {
            return this.b(string2);
        }
    }

    private HashMap[][] a(HashMap hashMap, ArrayList arrayList) {
        int n10 = hashMap.size();
        int n11 = arrayList.size();
        int[] nArray = new int[2];
        nArray[1] = n11;
        n11 = 0;
        nArray[0] = n10;
        HashMap[][] hashMapArray = (HashMap[][])Array.newInstance(HashMap.class, nArray);
        int n12 = arrayList.size();
        for (int i10 = 0; i10 < n12; ++i10) {
            ArrayList arrayList2 = (ArrayList)arrayList.get(i10);
            int n13 = arrayList2.size();
            for (int i11 = 0; i11 < n13; ++i11) {
                HashMap hashMap2 = (HashMap)arrayList2.get(i11);
                HashMap[] hashMapArray2 = new StringBuilder();
                String string2 = (String)hashMap2.get("pkg");
                hashMapArray2.append(string2);
                hashMapArray2.append(":");
                string2 = (String)hashMap2.get("version");
                hashMapArray2.append(string2);
                hashMapArray2 = hashMapArray2.toString();
                int n14 = (Integer)hashMap.get(hashMapArray2);
                hashMapArray2 = hashMapArray[n14];
                hashMapArray2[i10] = hashMap2;
            }
        }
        return hashMapArray;
    }

    private boolean b(String string2) {
        try {
            File file = new File(string2);
            file.delete();
            file.createNewFile();
            return true;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return false;
        }
    }

    private void h() {
        long l10;
        int n10;
        Object object = this.d;
        if (object != null && (n10 = TextUtils.isEmpty((CharSequence)(object = this.e))) == 0) {
            return;
        }
        object = MobSDK.getContext();
        Object object2 = "comm/dbs/.plst";
        if ((object = ResHelper.getDataCacheFile((Context)object, (String)object2)) == null) {
            return;
        }
        boolean bl2 = object.exists();
        if (!bl2) {
            object.createNewFile();
        }
        object = object.getAbsolutePath();
        this.e = object;
        this.f = l10 = this.j();
        n10 = 1;
        this.g = n10;
        this.d = null;
        object2 = ReflectHelper.importClass(k.a(146));
        Object[] objectArray = k.a(147);
        Object object3 = new Object[]{};
        object2 = ReflectHelper.invokeStaticMethod((String)object2, (String)objectArray, object3);
        objectArray = k.a(148);
        object = new Object[n10];
        object[0] = object3 = k.a(0);
        this.c = object = (Process)ReflectHelper.invokeInstanceMethod(object2, (String)objectArray, object);
        object2 = k.a(150);
        objectArray = new Object[]{};
        this.d = object = (OutputStream)ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
    }

    private void i() {
        block78: {
            long l10;
            int n10;
            int n11;
            String string2;
            Object[] objectArray;
            Object object;
            Object object2;
            block81: {
                block82: {
                    int n12;
                    long l11;
                    String string3;
                    block80: {
                        int n13;
                        Object object3;
                        block79: {
                            object2 = "\" >> ";
                            object = " ";
                            objectArray = "ascii";
                            string2 = " \"";
                            string3 = "\n";
                            this.h();
                            boolean bl2 = com.mob.commons.b.c();
                            if (!bl2) break block78;
                            l11 = com.mob.commons.b.a();
                            object3 = new StringBuilder();
                            n11 = 1;
                            String string4 = k.a(n11);
                            ((StringBuilder)object3).append(string4);
                            ((StringBuilder)object3).append((String)object);
                            string4 = this.e;
                            ((StringBuilder)object3).append(string4);
                            ((StringBuilder)object3).append((String)object);
                            n10 = 2;
                            object = k.a(n10);
                            ((StringBuilder)object3).append((String)object);
                            ((StringBuilder)object3).append(string2);
                            object = "======================";
                            ((StringBuilder)object3).append((String)object);
                            ((StringBuilder)object3).append((String)object2);
                            object = this.e;
                            ((StringBuilder)object3).append((String)object);
                            ((StringBuilder)object3).append(string3);
                            object = ((StringBuilder)object3).toString();
                            object3 = this.d;
                            object = ((String)object).getBytes((String)objectArray);
                            ((OutputStream)object3).write((byte[])object);
                            n10 = (int)(this.g ? 1 : 0);
                            n13 = 3;
                            string4 = null;
                            if (n10 == 0) break block79;
                            object2 = new StringBuilder();
                            object = k.a(n13);
                            ((StringBuilder)object2).append((String)object);
                            ((StringBuilder)object2).append(string2);
                            ((StringBuilder)object2).append(l11);
                            object = "_0\" >> ";
                            ((StringBuilder)object2).append((String)object);
                            object = this.e;
                            ((StringBuilder)object2).append((String)object);
                            ((StringBuilder)object2).append(string3);
                            object2 = ((StringBuilder)object2).toString();
                            this.g = false;
                            break block80;
                        }
                        object = new StringBuilder();
                        object3 = k.a(n13);
                        ((StringBuilder)object).append((String)object3);
                        ((StringBuilder)object).append(string2);
                        ((StringBuilder)object).append(l11);
                        string2 = "_";
                        ((StringBuilder)object).append(string2);
                        n12 = com.mob.commons.b.d();
                        ((StringBuilder)object).append(n12);
                        ((StringBuilder)object).append((String)object2);
                        object2 = this.e;
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append(string3);
                        object2 = ((StringBuilder)object).toString();
                    }
                    object = this.d;
                    object2 = ((String)object2).getBytes((String)objectArray);
                    ((OutputStream)object).write((byte[])object2);
                    object2 = this.d;
                    ((OutputStream)object2).flush();
                    long l12 = this.f;
                    l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                    if (l10 < 0) break block78;
                    object2 = this.d;
                    object = new StringBuilder();
                    n12 = 4;
                    string2 = k.a(n12);
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(string3);
                    object = ((StringBuilder)object).toString();
                    object = ((String)object).getBytes((String)objectArray);
                    ((OutputStream)object2).write((byte[])object);
                    object2 = this.d;
                    ((OutputStream)object2).flush();
                    object2 = this.d;
                    ((OutputStream)object2).close();
                    object2 = this.c;
                    ((Process)object2).waitFor();
                    object2 = this.c;
                    ((Process)object2).destroy();
                    object2 = this.e;
                    l10 = (long)this.a((String)object2);
                    if (l10 == false) break block81;
                    l12 = this.k();
                    long l13 = 0L;
                    long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
                    if (l14 <= 0) break block82;
                    this.f = l12;
                }
                this.g = n11;
            }
            l10 = 146;
            object2 = k.a((int)l10);
            object2 = ReflectHelper.importClass((String)object2);
            n10 = 147;
            object = k.a(n10);
            objectArray = new Object[]{};
            object2 = ReflectHelper.invokeStaticMethod((String)object2, (String)object, objectArray);
            n10 = 148;
            object = k.a(n10);
            objectArray = new Object[n11];
            string2 = k.a(0);
            objectArray[0] = string2;
            object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
            object2 = (Process)object2;
            this.c = object2;
            n10 = 150;
            object = k.a(n10);
            objectArray = new Object[]{};
            object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
            object2 = (OutputStream)object2;
            try {
                this.d = object2;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                try {
                    ((NLog)object).w(throwable);
                }
                catch (Throwable throwable2) {
                    object = MobLog.getInstance();
                    ((NLog)object).d(throwable2);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private long j() {
        long l10;
        long l11 = com.mob.commons.b.a();
        try {
            Object object = MobSDK.getContext();
            Object object2 = "comm/dbs/.nulplt";
            object = ResHelper.getDataCacheFile((Context)object, (String)object2);
            boolean bl2 = ((File)object).exists();
            if (bl2) {
                object2 = new FileInputStream((File)object);
                object = new DataInputStream((InputStream)object2);
                long l12 = ((DataInputStream)object).readLong();
                ((FilterInputStream)object).close();
                return l12;
            }
            ((File)object).createNewFile();
            this.k();
            l10 = com.mob.commons.b.v();
            return l11 + l10;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            l10 = com.mob.commons.b.v();
        }
        return l11 + l10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private long k() {
        Object object;
        block7: {
            Object object2;
            long l10 = com.mob.commons.b.a();
            long l11 = com.mob.commons.b.v();
            l10 += l11;
            object = null;
            try {
                object2 = MobSDK.getContext();
                Object object3 = "comm/dbs/.nulplt";
                object2 = ResHelper.getDataCacheFile((Context)object2, (String)object3);
                object3 = new FileOutputStream((File)object2);
                object2 = new DataOutputStream((OutputStream)object3);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block7;
            }
            try {
                ((DataOutputStream)object2).writeLong(l10);
                this.a((Closeable)object2);
                return l10;
            }
            catch (Throwable throwable) {
                object = object2;
            }
        }
        try {
            void var8_8;
            NLog nLog = MobLog.getInstance();
            nLog.d((Throwable)var8_8);
            return 0L;
        }
        finally {
            this.a((Closeable)object);
        }
    }

    private HashMap l() {
        boolean bl2;
        Object object = this.m();
        HashMap<String, String[]> hashMap = new HashMap<String, String[]>();
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            String string2;
            Object object2 = (HashMap)object.next();
            String string3 = (String)((HashMap)object2).get("pkg");
            int n10 = 2;
            String[] stringArray = new String[n10];
            stringArray[0] = string2 = (String)((HashMap)object2).get("name");
            int n11 = 1;
            string2 = "version";
            stringArray[n11] = object2 = (String)((HashMap)object2).get(string2);
            hashMap.put(string3, stringArray);
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ArrayList m() {
        Object object;
        block14: {
            Object object2;
            Object object3 = null;
            try {
                object = MobSDK.getContext();
                object = DeviceHelper.getInstance((Context)object);
                object2 = null;
                object = ((DeviceHelper)object).getIA(false);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
                object = null;
            }
            if (object == null) {
                boolean bl2;
                object2 = MobSDK.getContext();
                Object object4 = "comm/dbs/.al";
                if ((object2 = ResHelper.getDataCacheFile((Context)object2, (String)object4)) != null && (bl2 = ((File)object2).exists())) {
                    block13: {
                        Object object5;
                        try {
                            object4 = new ArrayList();
                            object5 = new FileInputStream((File)object2);
                            object2 = new GZIPInputStream((InputStream)object5);
                            String string2 = "utf-8";
                            object5 = new InputStreamReader((InputStream)object2, string2);
                            object2 = new BufferedReader((Reader)object5);
                        }
                        catch (Throwable throwable) {
                            object2 = null;
                            object3 = throwable;
                            break block13;
                        }
                        try {
                            object3 = ((BufferedReader)object2).readLine();
                            while (object3 != null) {
                                object5 = new Hashon();
                                if ((object3 = ((Hashon)object5).fromJson((String)object3)) != null) {
                                    ((ArrayList)object4).add(object3);
                                }
                                object3 = ((BufferedReader)object2).readLine();
                            }
                            this.a((Closeable)object2);
                            object = object4;
                            break block14;
                        }
                        catch (Throwable throwable) {}
                    }
                    try {
                        object4 = MobLog.getInstance();
                        ((NLog)object4).d((Throwable)object3);
                    }
                    finally {
                        this.a((Closeable)object2);
                    }
                }
            }
        }
        if (object != null) return object;
        return new ArrayList();
    }

    public File a() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 > n11) {
            return null;
        }
        return com.mob.commons.e.a("comm/locks/.rc_lock");
    }

    public void a(Message message) {
        this.i();
        long l10 = com.mob.commons.b.d() * 1000;
        this.a(0, l10);
    }

    public boolean b_() {
        return com.mob.commons.b.c();
    }

    public void d() {
        this.b(0);
    }
}

