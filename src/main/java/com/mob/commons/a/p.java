/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.mob.commons.a;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.a.d;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.e;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
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

public class p
extends d {
    private Hashon a;
    private DeviceHelper b;

    public p() {
        Hashon hashon;
        this.a = hashon = new Hashon();
    }

    private void a(long l10) {
        Object object = MobSDK.getContext();
        Object object2 = "comm/dbs/.snulal";
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

    private void a(String string2, ArrayList arrayList) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("type", string2);
        hashMap.put("list", arrayList);
        long l10 = com.mob.commons.b.a();
        Long l11 = l10;
        hashMap.put("datetime", l11);
        c.a().a(l10, hashMap);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(ArrayList object) {
        Object object2;
        Object object3;
        block9: {
            Closeable closeable;
            object3 = ResHelper.getDataCacheFile(MobSDK.getContext(), "comm/dbs/.sal");
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
                break block9;
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
                    object2 = this.a;
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
        try {
            void var1_4;
            object3 = MobLog.getInstance();
            ((NLog)object3).d((Throwable)var1_4);
            return;
        }
        finally {
            this.a((Closeable)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h() {
        long l10;
        int n10;
        ArrayList arrayList;
        Object object;
        block17: {
            float f10;
            int n11;
            NLog nLog;
            object = this.i();
            try {
                arrayList = this.b;
                if (arrayList == null) {
                    arrayList = MobSDK.getContext();
                    arrayList = DeviceHelper.getInstance((Context)arrayList);
                    this.b = arrayList;
                }
                arrayList = this.b;
                arrayList = ((DeviceHelper)((Object)arrayList)).getSA();
            }
            catch (Throwable throwable) {
                nLog = MobLog.getInstance();
                nLog.w(throwable);
                arrayList = new ArrayList();
            }
            boolean bl2 = arrayList.isEmpty();
            if (bl2) {
                return;
            }
            bl2 = false;
            nLog = null;
            n10 = 1;
            float f11 = Float.MIN_VALUE;
            if (object != null && (n11 = ((ArrayList)object).isEmpty()) == 0) {
                n11 = 0;
                f10 = 0.0f;
            } else {
                n11 = n10;
                f10 = f11;
            }
            if (n11 == 0) {
                long l11;
                long l12;
                l10 = this.j();
                long l13 = l10 - (l12 = 0L);
                Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object2 != false && (n11 = (l11 = (l12 = com.mob.commons.b.a()) - l10) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
                    n11 = 0;
                    f10 = 0.0f;
                } else {
                    n11 = n10;
                    f10 = f11;
                }
                if (n11 == 0) {
                    int n12;
                    n11 = arrayList.size();
                    if (n11 != (n12 = ((ArrayList)object).size())) {
                        n11 = n10;
                        f10 = f11;
                    } else {
                        n11 = 0;
                        f10 = 0.0f;
                    }
                    if (n11 == 0) {
                        int n13;
                        Iterator iterator2 = arrayList.iterator();
                        while ((n13 = iterator2.hasNext()) != 0) {
                            block16: {
                                boolean bl3;
                                Object object3 = (HashMap)iterator2.next();
                                String string2 = "pkg";
                                boolean bl4 = TextUtils.isEmpty((CharSequence)(object3 = (String)((HashMap)object3).get(string2)));
                                if (bl4) continue;
                                Iterator iterator3 = ((ArrayList)object).iterator();
                                while (bl3 = iterator3.hasNext()) {
                                    Object v10 = ((HashMap)iterator3.next()).get(string2);
                                    bl3 = ((String)object3).equals(v10);
                                    if (!bl3) continue;
                                    n13 = n10;
                                    break block16;
                                }
                                n13 = 0;
                                object3 = null;
                            }
                            if (n13 != 0) continue;
                            break block17;
                        }
                    }
                }
            }
            n10 = n11;
            f11 = f10;
        }
        if (n10 != 0) {
            object = "SYSTEM_APPS";
            this.a((String)object, arrayList);
            this.a(arrayList);
            long l14 = com.mob.commons.b.a();
            long l15 = com.mob.commons.b.P();
            l10 = 1000L;
            this.a(l14 += (l15 *= l10));
        }
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
            Object object4 = "comm/dbs/.sal";
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
                    object3 = this.a;
                    if ((object4 = ((Hashon)object3).fromJson((String)object4)) != null) {
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
        Object object2 = "comm/dbs/.snulal";
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

    public File a() {
        return e.a("comm/locks/.pkgs_lock");
    }

    public void a(Message message) {
        int n10 = message.what;
        int n11 = 1;
        if (n10 == n11) {
            long l10;
            long l11 = com.mob.commons.b.O();
            long l12 = l11 - (l10 = 0L);
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 <= 0) {
                return;
            }
            this.h();
            l10 = 1000L;
            this.a(n11, l11 *= l10);
        }
    }

    public boolean b_() {
        long l10;
        long l11 = com.mob.commons.b.O();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void d() {
        this.b(1);
    }
}

