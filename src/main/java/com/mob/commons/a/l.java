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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class l
extends d {
    private HashMap a;

    private HashMap a(String string2, byte[] object) {
        try {
            string2 = Data.AES128Decode(string2, (byte[])object);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            Object[] objectArray = new Object[]{"DvcvClt", "Decrypt error"};
            ((NLog)object).d(throwable, (Object)"[%s] %s", objectArray);
            HashMap hashMap = new HashMap();
            return hashMap;
        }
        object = new Hashon;
        ((Hashon)object)();
        return ((Hashon)object).fromJson(string2);
    }

    private void a(HashMap object) {
        Object object2 = MobSDK.getContext();
        String string2 = "comm/dbs/.dextvcd";
        object2 = ResHelper.getDataCacheFile((Context)object2, string2);
        boolean bl2 = true;
        Object object3 = MobSDK.getContext();
        object3 = DeviceHelper.getInstance((Context)object3);
        object3 = ((DeviceHelper)object3).getModel();
        object = this.a((String)object3, (HashMap)object);
        object3 = new FileOutputStream((File)object2);
        object2 = ((FileOutputStream)object3).getChannel();
        object = ByteBuffer.wrap((byte[])object);
        ((FileChannel)object2).write((ByteBuffer)object);
        try {
            ((FileChannel)object2).force(bl2);
            ((AbstractInterruptibleChannel)object2).close();
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            int n10 = 2;
            object3 = new Object[n10];
            String string3 = "DvcvClt";
            object3[0] = string3;
            String string4 = throwable.getMessage();
            object3[bl2] = string4;
            string2 = "[%s] %s";
            ((NLog)object2).d(throwable, (Object)string2, (Object[])object3);
        }
    }

    private byte[] a(String string2, HashMap object) {
        Object object2 = new Hashon();
        object = ((Hashon)object2).fromHashMap((HashMap)object);
        try {
            return Data.AES128Encode(string2, (String)object);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            Object[] objectArray = new Object[2];
            objectArray[0] = "DvcvClt";
            String string3 = throwable.getMessage();
            objectArray[1] = string3;
            ((NLog)object2).d(throwable, (Object)"[%s] %s", objectArray);
            return ((String)object).getBytes();
        }
    }

    private void b(HashMap hashMap) {
        long l10;
        long l11;
        long l12 = i.H();
        long l13 = b.ae() * 1000L;
        long l14 = 0L;
        long l15 = l12 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false) {
            l12 = b.a() + l13;
            i.k(l12);
        }
        if ((l11 = (l10 = (l13 = b.a()) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) >= 0) {
            this.c(hashMap);
        }
    }

    private void c(HashMap hashMap) {
        block16: {
            if (hashMap != null) {
                boolean bl2 = hashMap.isEmpty();
                if (bl2) break block16;
                long l10 = b.a();
                Object object = new HashMap();
                ((HashMap)object).putAll(hashMap);
                hashMap = new HashMap();
                Object object2 = "type";
                String string2 = "DEVEXT_VAR";
                hashMap.put(object2, string2);
                object2 = "data";
                hashMap.put(object2, object);
                object = "datetime";
                object2 = l10;
                hashMap.put(object, object2);
                object = c.a();
                ((c)object).a(l10, hashMap);
                hashMap = this.a;
                hashMap.clear();
                hashMap = this.a;
                this.a(hashMap);
                long l11 = b.ae();
                long l12 = 1000L;
                l10 += (l11 *= l12);
                try {
                    i.k(l10);
                }
                catch (Throwable throwable) {
                    NLog nLog = MobLog.getInstance();
                    CharSequence charSequence = new StringBuilder();
                    object = throwable.getMessage();
                    charSequence.append((String)object);
                    charSequence.append("");
                    charSequence = charSequence.toString();
                    object = new Object[]{};
                    nLog.d(throwable, (Object)charSequence, (Object[])object);
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h() {
        Object object = "list";
        try {
            void var3_9;
            HashMap hashMap = this.a;
            if (hashMap == null) {
                this.a = hashMap = this.j();
            }
            if ((hashMap = this.a) == null) {
                this.a = hashMap = new HashMap();
            }
            hashMap = this.i();
            HashMap hashMap2 = this.a;
            Object v10 = hashMap2.get(object);
            ArrayList arrayList = (ArrayList)v10;
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList();
            }
            var3_9.add(hashMap);
            hashMap = this.a;
            hashMap.put(object, var3_9);
            object = this.a;
            this.a((HashMap)object);
            object = this.a;
            this.b((HashMap)object);
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
    }

    private HashMap i() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object = DeviceHelper.getInstance(MobSDK.getContext());
        Serializable serializable = ((DeviceHelper)object).getCPUFreq();
        hashMap.putAll((Map<String, Object>)((Object)serializable));
        serializable = Integer.valueOf(((DeviceHelper)object).getAlbumCount());
        hashMap.put("photoCount", serializable);
        serializable = ((DeviceHelper)object).getTraffic();
        hashMap.putAll((Map<String, Object>)((Object)serializable));
        object = ((DeviceHelper)object).getDeviceMemUsage();
        hashMap.putAll((Map<String, Object>)object);
        object = b.a();
        hashMap.put("createTime", object);
        return hashMap;
    }

    private HashMap j() {
        Object object = MobSDK.getContext();
        Object object2 = "comm/dbs/.dextvcd";
        int n10 = (object = ResHelper.getDataCacheFile(object, (String)object2)).exists();
        if (n10 != 0) {
            int n11;
            object2 = new FileInputStream((File)object);
            object = ((FileInputStream)object2).getChannel();
            long l10 = object.size();
            n10 = (int)l10;
            object2 = ByteBuffer.allocate(n10);
            while (true) {
                n11 = object.read((ByteBuffer)object2);
                if (n11 > 0) continue;
                break;
            }
            object = ((ByteBuffer)object2).array();
            object2 = MobSDK.getContext();
            object2 = DeviceHelper.getInstance((Context)object2);
            object2 = ((DeviceHelper)object2).getModel();
            try {
                return this.a((String)object2, (byte[])object);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                n11 = 2;
                Object[] objectArray = new Object[n11];
                objectArray[0] = "DvcvClt";
                int n12 = 1;
                String string2 = "Read cache error";
                objectArray[n12] = string2;
                String string3 = "[%s] %s";
                ((NLog)object2).d(throwable, (Object)string3, objectArray);
            }
        }
        object = new HashMap();
        return object;
    }

    public File a() {
        return e.a("comm/locks/.dvcv_lock");
    }

    public void a(Message message) {
        int n10 = message.what;
        int n11 = 1;
        if (n10 == n11 && (n10 = (int)(this.b_() ? 1 : 0)) != 0) {
            this.h();
            long l10 = b.ad();
            long l11 = 1000L;
            this.a(n11, l10 *= l11);
        }
    }

    public boolean b_() {
        return b.ac();
    }

    public void d() {
        this.b(1);
    }
}

