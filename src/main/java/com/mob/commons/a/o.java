/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.mob.commons.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.a.d;
import com.mob.commons.a.o$1;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.e;
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
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class o
extends d {
    private static final String[] a = new String[]{"android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_CHANGED", "android.intent.action.PACKAGE_REMOVED", "android.intent.action.PACKAGE_REPLACED"};
    private BroadcastReceiver b;
    private Hashon c;

    private ArrayList a(ArrayList object, ArrayList arrayList) {
        boolean bl2;
        if (object != null && !(bl2 = ((ArrayList)object).isEmpty()) && arrayList != null && !(bl2 = arrayList.isEmpty())) {
            boolean bl3;
            ArrayList<HashMap> arrayList2 = new ArrayList<HashMap>();
            object = ((ArrayList)object).iterator();
            while (bl3 = object.hasNext()) {
                boolean bl4;
                float f10;
                boolean bl5;
                String string2;
                boolean bl6;
                String string3;
                Object object2;
                float f11;
                boolean bl7;
                HashMap hashMap;
                block6: {
                    hashMap = (HashMap)object.next();
                    bl7 = false;
                    f11 = 0.0f;
                    object2 = hashMap.keySet().iterator();
                    do {
                        bl6 = object2.hasNext();
                        bl5 = true;
                        f10 = Float.MIN_VALUE;
                        string2 = "first";
                        if (!bl6) break block6;
                    } while ((string3 = (String)object2.next()) == null || !(bl6 = string3.contains(string2)));
                    bl7 = bl5;
                    f11 = f10;
                }
                if (bl7) {
                    arrayList2.add(hashMap);
                    continue;
                }
                object2 = "pkg";
                string3 = (String)hashMap.get(object2);
                boolean bl8 = TextUtils.isEmpty((CharSequence)string3);
                if (bl8) continue;
                Iterator iterator2 = arrayList.iterator();
                while (bl4 = iterator2.hasNext()) {
                    block7: {
                        HashMap hashMap2 = (HashMap)iterator2.next();
                        Object v10 = hashMap2.get(object2);
                        boolean bl9 = string3.equals(v10);
                        if (!bl9) continue;
                        object2 = hashMap2.keySet().iterator();
                        while (bl6 = object2.hasNext()) {
                            string3 = (String)object2.next();
                            if (string3 == null || !(bl6 = string3.contains(string2))) continue;
                            arrayList2.add(hashMap2);
                            break block7;
                        }
                        bl5 = bl7;
                        f10 = f11;
                    }
                    bl7 = bl5;
                    f11 = f10;
                    break;
                }
                if (bl7) continue;
                arrayList2.add(hashMap);
            }
            return arrayList2;
        }
        return object;
    }

    private void a(long l10) {
        Object object = MobSDK.getContext();
        Object object2 = "comm/dbs/.nulal";
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

    private void a(long l10, String object, ArrayList arrayList) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("type", object);
        hashMap.put("list", arrayList);
        object = com.mob.commons.b.a();
        hashMap.put("datetime", object);
        com.mob.commons.c.a().a(l10, hashMap);
    }

    private void a(ArrayList object) {
        try {
            this.b((ArrayList)object);
        }
        finally {
            Throwable throwable;
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            try {
                this.b((ArrayList)object);
            }
            catch (Throwable throwable2) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
    }

    public static /* synthetic */ boolean a(o o10, String string2) {
        return o10.a(string2);
    }

    private boolean a(String string2) {
        for (String string3 : a) {
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private ArrayList b(ArrayList object, ArrayList arrayList) {
        boolean bl2;
        ArrayList<HashMap> arrayList2 = new ArrayList<HashMap>();
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            String string2;
            HashMap hashMap = (HashMap)object.next();
            String string3 = (String)hashMap.get(string2 = "pkg");
            boolean bl4 = TextUtils.isEmpty((CharSequence)string3);
            if (bl4) continue;
            bl4 = false;
            Iterator iterator2 = arrayList.iterator();
            while (bl3 = iterator2.hasNext()) {
                Object v10 = ((HashMap)iterator2.next()).get(string2);
                bl3 = string3.equals(v10);
                if (!bl3) continue;
                bl4 = true;
                break;
            }
            if (bl4) continue;
            arrayList2.add(hashMap);
        }
        return arrayList2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(ArrayList object) {
        void var1_4;
        Object object2;
        block6: {
            Closeable closeable;
            Object object3 = ResHelper.getDataCacheFile(MobSDK.getContext(), "comm/dbs/.al");
            char c10 = '\u0000';
            object2 = null;
            try {
                closeable = new FileOutputStream((File)object3);
                object3 = new GZIPOutputStream((OutputStream)closeable);
                String string2 = "utf-8";
                closeable = new OutputStreamWriter((OutputStream)object3, string2);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block6;
            }
            try {
                object = ((ArrayList)((Object)object)).iterator();
                while (true) {
                    boolean bl2;
                    if (!(bl2 = object.hasNext())) {
                        this.a(closeable);
                        return;
                    }
                    object3 = object.next();
                    object3 = (HashMap)object3;
                    object2 = this.n();
                    object3 = ((Hashon)object2).fromHashMap((HashMap)object3);
                    object3 = ((OutputStreamWriter)closeable).append((CharSequence)object3);
                    c10 = '\n';
                    ((Writer)object3).append(c10);
                }
            }
            catch (Throwable throwable) {
                object2 = closeable;
            }
        }
        this.a((Closeable)object2);
        throw var1_4;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void h() {
        boolean bl2;
        ArrayList arrayList = this.i();
        long l10 = 1000L;
        String string2 = "APPS_ALL";
        ArrayList arrayList2 = null;
        if (arrayList != null && !(bl2 = arrayList.isEmpty())) {
            long l11;
            long l12;
            long l13 = com.mob.commons.b.a();
            long l14 = this.j();
            long l15 = l14 - (l12 = 0L);
            Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object != false && (l11 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1)) < 0) {
                this.m();
                return;
            }
            Object object2 = MobSDK.getContext();
            object2 = DeviceHelper.getInstance((Context)object2);
            try {
                arrayList2 = ((DeviceHelper)object2).getIA(false);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
                arrayList2 = new ArrayList();
            }
            if (arrayList2 == null || (l11 = (long)arrayList2.isEmpty()) != false) return;
            arrayList = this.a(arrayList2, arrayList);
            l14 = com.mob.commons.b.u();
            this.a(l14, string2, arrayList);
            this.a(arrayList);
            long l16 = com.mob.commons.b.h() * l10;
            this.a(l13 += l16);
            return;
        }
        arrayList = MobSDK.getContext();
        arrayList = DeviceHelper.getInstance((Context)arrayList);
        try {
            arrayList = ((DeviceHelper)((Object)arrayList)).getIA(false);
        }
        catch (Throwable throwable) {
            arrayList2 = MobLog.getInstance();
            ((NLog)((Object)arrayList2)).w(throwable);
            arrayList = new ArrayList();
        }
        long l17 = com.mob.commons.b.u();
        this.a(l17, string2, arrayList);
        this.a(arrayList);
        long l18 = com.mob.commons.b.a();
        long l19 = com.mob.commons.b.h() * l10;
        this.a(l18 += l19);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ArrayList i() {
        Object object;
        Object object2;
        block10: {
            Object object3;
            object2 = MobSDK.getContext();
            Object object4 = "comm/dbs/.al";
            if ((object2 = ResHelper.getDataCacheFile((Context)object2, (String)object4)) == null) return new ArrayList();
            boolean bl2 = ((File)object2).exists();
            if (!bl2) return new ArrayList();
            bl2 = false;
            object4 = null;
            try {
                object = new ArrayList();
                object3 = new FileInputStream((File)object2);
                object2 = new GZIPInputStream((InputStream)object3);
                String string2 = "utf-8";
                object3 = new InputStreamReader((InputStream)object2, string2);
                object2 = new BufferedReader((Reader)object3);
            }
            catch (Throwable throwable) {
                object2 = null;
                break block10;
            }
            try {
                object4 = ((BufferedReader)object2).readLine();
                while (true) {
                    if (object4 == null) {
                        this.a((Closeable)object2);
                        return object;
                    }
                    object3 = this.n();
                    object4 = ((Hashon)object3).fromJson((String)object4);
                    if (object4 != null) {
                        ((ArrayList)object).add(object4);
                    }
                    object4 = ((BufferedReader)object2).readLine();
                }
            }
            catch (Throwable throwable) {}
        }
        try {
            void var2_5;
            object = MobLog.getInstance();
            ((NLog)object).d((Throwable)var2_5);
            return new ArrayList();
        }
        finally {
            this.a((Closeable)object2);
        }
    }

    private long j() {
        Object object = MobSDK.getContext();
        Object object2 = "comm/dbs/.nulal";
        boolean bl2 = ((File)(object = ResHelper.getDataCacheFile((Context)object, (String)object2))).exists();
        if (bl2) {
            object2 = new FileInputStream((File)object);
            object = new DataInputStream((InputStream)object2);
            long l10 = ((DataInputStream)object).readLong();
            try {
                ((FilterInputStream)object).close();
                return l10;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        return 0L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void k() {
        int n10;
        block3: {
            int n11;
            block4: {
                String[] stringArray;
                int n12;
                boolean bl2 = com.mob.commons.b.e();
                n10 = 2;
                n11 = 1;
                if (!bl2 || !(bl2 = com.mob.commons.b.g())) break block4;
                Class[] classArray = this.b;
                if (classArray != null) break block3;
                classArray = new o$1(this);
                this.b = classArray;
                classArray = new IntentFilter();
                Class<IntentFilter> clazz = null;
                String string2 = null;
                for (int i10 = 0; i10 < (n12 = (stringArray = a).length); ++i10) {
                    String string3 = stringArray[i10];
                    classArray.addAction(string3);
                }
                string2 = "package";
                classArray.addDataScheme(string2);
                try {
                    Class<BroadcastReceiver> clazz2;
                    string2 = MobSDK.getContext();
                    String string4 = "registerReceiver";
                    Object[] objectArray = new Object[n10];
                    BroadcastReceiver broadcastReceiver = this.b;
                    objectArray[0] = broadcastReceiver;
                    objectArray[n11] = classArray;
                    classArray = new Class[n10];
                    classArray[0] = clazz2 = BroadcastReceiver.class;
                    classArray[n11] = clazz = IntentFilter.class;
                    ReflectHelper.invokeInstanceMethod((Object)string2, string4, objectArray, classArray);
                    break block3;
                }
                catch (Throwable throwable) {}
            }
            this.a(n11);
            this.l();
        }
        this.a(n10, 3600000L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void l() {
        Object object = this.b;
        if (object != null) {
            try {
                object = MobSDK.getContext();
                String string2 = "unregisterReceiver";
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                Object object2 = this.b;
                objectArray[0] = object2;
                Class[] classArray = new Class[n10];
                object2 = BroadcastReceiver.class;
                classArray[0] = object2;
                ReflectHelper.invokeInstanceMethod(object, string2, objectArray, classArray);
            }
            catch (Throwable throwable) {}
            this.b = null;
        }
        if ((object = this.c) != null) {
            this.c = null;
        }
    }

    private void m() {
        Object object = this.i();
        Object object2 = MobSDK.getContext();
        object2 = DeviceHelper.getInstance((Context)object2);
        boolean bl2 = false;
        Object object3 = null;
        try {
            object2 = ((DeviceHelper)object2).getIA(false);
        }
        catch (Throwable throwable) {
            object3 = MobLog.getInstance();
            ((NLog)object3).w(throwable);
            object2 = new ArrayList();
        }
        if (object != null && !(bl2 = ((ArrayList)object).isEmpty())) {
            String string2;
            long l10;
            object3 = this.b((ArrayList)object2, (ArrayList)object);
            boolean bl3 = ((ArrayList)object3).isEmpty();
            if (!bl3) {
                l10 = com.mob.commons.b.a();
                string2 = "APPS_INCR";
                this.a(l10, string2, (ArrayList)object3);
            }
            if (!(bl3 = ((ArrayList)(object3 = this.b((ArrayList)object, (ArrayList)object2))).isEmpty())) {
                l10 = com.mob.commons.b.a();
                string2 = "UNINSTALL";
                this.a(l10, string2, (ArrayList)object3);
            }
            object = this.a((ArrayList)object2, (ArrayList)object);
            this.a((ArrayList)object);
        } else {
            long l11 = com.mob.commons.b.u();
            object = "APPS_ALL";
            this.a(l11, (String)object, (ArrayList)object2);
            this.a((ArrayList)object2);
            long l12 = com.mob.commons.b.a();
            l11 = com.mob.commons.b.h();
            long l13 = 1000L;
            this.a(l12 += (l11 *= l13));
        }
    }

    private Hashon n() {
        Hashon hashon = this.c;
        if (hashon == null) {
            this.c = hashon = new Hashon();
        }
        return this.c;
    }

    public File a() {
        return e.a("comm/locks/.pkg_lock");
    }

    public void a(Message message) {
        int n10 = message.what;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 == n11) {
                this.k();
            }
        } else {
            this.m();
        }
    }

    public void b() {
        this.l();
    }

    public boolean b_() {
        boolean bl2 = com.mob.commons.b.f();
        if (bl2) {
            this.h();
        }
        return true;
    }

    public void d() {
        this.b(2);
    }
}

