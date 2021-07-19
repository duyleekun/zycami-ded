/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 *  android.os.SystemClock
 */
package com.mob.commons.a;

import android.os.Message;
import android.os.SystemClock;
import com.mob.MobSDK;
import com.mob.commons.a.d;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.e;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class n
extends d {
    private Random a;
    private DeviceHelper b;
    private HashMap c;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private HashMap a(String object) {
        Object object2;
        Object object3;
        block10: {
            block9: {
                boolean bl2;
                object3 = null;
                try {
                    object2 = MobSDK.getContext();
                    object = ResHelper.getDataCacheFile(object2, (String)object);
                    bl2 = ((File)object).exists();
                    if (!bl2) {
                        object = new HashMap();
                        this.a((Closeable)null);
                        return object;
                    }
                }
                catch (Throwable throwable) {
                    bl2 = false;
                    object2 = null;
                    break block9;
                }
                {
                    object2 = new FileInputStream((File)object);
                    object = new ObjectInputStream((InputStream)object2);
                }
                try {
                    object2 = ((ObjectInputStream)object).readObject();
                    object2 = (HashMap)object2;
                    this.a((Closeable)object);
                    object3 = object2;
                    break block10;
                }
                catch (Throwable throwable) {
                    object2 = object;
                    object = throwable;
                }
            }
            NLog nLog = MobLog.getInstance();
            nLog.d((Throwable)object);
        }
        if (object3 != null) return object3;
        return new HashMap();
        finally {
            this.a((Closeable)object2);
        }
    }

    /*
     * WARNING - void declaration
     */
    private void a(HashMap hashMap, String object) {
        Object object2;
        block15: {
            void var1_4;
            block16: {
                block14: {
                    object2 = null;
                    Object object3 = MobSDK.getContext();
                    object = ResHelper.getDataCacheFile(object3, (String)object);
                    if (hashMap == null) break block14;
                    boolean bl2 = hashMap.isEmpty();
                    if (bl2) break block14;
                    object3 = new FileOutputStream((File)object);
                    object = new ObjectOutputStream((OutputStream)object3);
                    try {
                        ((ObjectOutputStream)object).writeObject(hashMap);
                        this.a((Closeable)object);
                        break block15;
                    }
                    catch (Throwable throwable) {
                        object2 = object;
                        break block16;
                    }
                }
                try {
                    ((File)object).delete();
                    this.a((Closeable)null);
                    return;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            object = MobLog.getInstance();
            ((NLog)object).w((Throwable)var1_4);
        }
        return;
        finally {
            this.a((Closeable)object2);
        }
    }

    private void b(HashMap object, String hashMap) {
        int n10;
        int n11;
        Serializable serializable = MobLog.getInstance();
        int n12 = 2;
        Object object2 = new Object[n12];
        object2[0] = "IMcClt";
        int n13 = 1;
        object2[n13] = "Write into queue";
        String string2 = "[%s] %s";
        ((NLog)((Object)serializable)).d(string2, object2);
        serializable = new Serializable();
        serializable.put("type", (String)((Object)hashMap));
        serializable.put("data", (String)object);
        hashMap = this.f();
        object2 = "cl";
        serializable.put((String)object2, (String)((Object)hashMap));
        long l10 = com.mob.commons.b.a();
        hashMap = Long.valueOf(l10);
        String string3 = "datetime";
        serializable.put(string3, (String)((Object)hashMap));
        com.mob.commons.c.a().a(l10, (HashMap)serializable);
        hashMap = this.c;
        if (hashMap == null) {
            this.c = hashMap = new HashMap();
        }
        if ((n11 = (hashMap = this.c).size()) >= (n10 = 500)) {
            hashMap = this.c;
            hashMap.clear();
        }
        long l11 = com.mob.commons.b.R() * 1000L;
        hashMap = this.c;
        object = (String)((HashMap)object).get("bssid");
        serializable = l10 += l11;
        hashMap.put(object, serializable);
        object = this.c;
        this.a((HashMap)object, "comm/dbs/.imcd");
    }

    private void h() {
        Object object = MobLog.getInstance();
        int n10 = 2;
        Object object2 = new Object[n10];
        String string2 = "IMcClt";
        object2[0] = string2;
        int n11 = 1;
        object2[n11] = ">>> Pre-obtain";
        String string3 = "[%s] %s";
        ((NLog)object).d(string3, (Object[])object2);
        object = this.b.getNetworkType();
        object2 = "wifi";
        Object object3 = ((String)object2).equals(object);
        if (object3 != 0) {
            object = this.c;
            if (object == null || (object3 = ((HashMap)object).isEmpty()) != 0) {
                this.c = object = this.a("comm/dbs/.imcd");
            }
            if ((object = this.c) != null && (object3 = ((HashMap)object).isEmpty()) == 0) {
                object2 = this.c;
                object = this.b.getBssid();
                boolean bl2 = ((HashMap)object2).containsKey(object);
                if (bl2) {
                    long l10;
                    object2 = this.c;
                    object = (Long)((HashMap)object2).get(object);
                    long l11 = com.mob.commons.b.a();
                    long l12 = l11 - (l10 = ((Long)object).longValue());
                    object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object3 >= 0) {
                        this.i();
                    } else {
                        object = MobLog.getInstance();
                        Object[] objectArray = new Object[n10];
                        objectArray[0] = string2;
                        objectArray[n11] = object2 = "Interval not reached";
                        ((NLog)object).d(string3, objectArray);
                    }
                } else {
                    this.i();
                }
            } else {
                this.i();
            }
            object3 = 0;
            object = null;
            this.c = null;
            this.a = null;
            this.b = null;
        } else {
            object = MobLog.getInstance();
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            objectArray[n11] = object2 = "No wifi";
            ((NLog)object).d(string3, objectArray);
            this.e();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void i() {
        Object object = "IMcClt";
        HashMap<Object, Object> hashMap = "[%s] %s";
        try {
            int n10;
            Object object2 = MobLog.getInstance();
            int n11 = 2;
            Object object3 = new Object[n11];
            object3[0] = object;
            String string2 = ">>> Obtain";
            int n12 = 1;
            object3[n12] = string2;
            ((NLog)object2).d(hashMap, (Object[])object3);
            object2 = "wifi";
            object3 = this.b;
            object3 = ((DeviceHelper)object3).getNetworkType();
            boolean bl2 = ((String)object2).equals(object3);
            if (!bl2) {
                object2 = MobLog.getInstance();
                Object[] objectArray = new Object[n11];
                objectArray[0] = object;
                objectArray[n12] = object = "No wifi";
                ((NLog)object2).d(hashMap, objectArray);
                return;
            }
            object2 = MobLog.getInstance();
            object3 = new Object[n11];
            object3[0] = object;
            string2 = "Communicating";
            object3[n12] = string2;
            ((NLog)object2).d(hashMap, (Object[])object3);
            this.j();
            object2 = MobLog.getInstance();
            object3 = new Object[n11];
            object3[0] = object;
            string2 = "Waiting for update";
            object3[n12] = string2;
            ((NLog)object2).d(hashMap, (Object[])object3);
            long l10 = 5000L;
            SystemClock.sleep((long)l10);
            object2 = MobLog.getInstance();
            Object object4 = new Object[n11];
            object4[0] = object;
            object4[n12] = object = "Obtaining";
            ((NLog)object2).d(hashMap, (Object[])object4);
            object = new ArrayList();
            for (int i10 = 0; (n10 = ((ArrayList)object).isEmpty()) != 0 && i10 < (n10 = 8); ++i10) {
                object = this.b;
                n10 = ((ArrayList)(object = ((DeviceHelper)object).getArpList())).size();
                long l11 = n10 > 0 ? 0L : 1000L;
                SystemClock.sleep((long)l11);
            }
            bl2 = false;
            object2 = null;
            hashMap = new HashMap<Object, Object>(null);
            Collections.sort(object, hashMap);
            hashMap = new HashMap<Object, Object>();
            object2 = "bssid";
            object4 = this.b;
            object4 = ((DeviceHelper)object4).getBssid();
            hashMap.put(object2, object4);
            object2 = "ssid";
            object4 = this.b;
            object4 = ((DeviceHelper)object4).getSSID();
            hashMap.put(object2, object4);
            object2 = "curip";
            object4 = this.b;
            object4 = ((DeviceHelper)object4).getIPAddress();
            hashMap.put(object2, object4);
            object2 = "list";
            hashMap.put(object2, object);
            object = "WIFI_IP_MAC";
            this.b(hashMap, (String)object);
            return;
        }
        catch (Throwable throwable) {
            hashMap = MobLog.getInstance();
            ((NLog)((Object)hashMap)).w(throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        int n10;
        Object object = this.b.getIPAddress();
        Object object2 = "\\.";
        int n11 = ((String[])(object = object.split((String)object2))).length;
        if (n11 <= (n10 = 2)) return;
        object2 = new StringBuilder();
        int n12 = 0;
        Object object3 = null;
        Object object4 = object[0];
        ((StringBuilder)object2).append((String)object4);
        object4 = ".";
        ((StringBuilder)object2).append((String)object4);
        int n13 = 1;
        String string2 = object[n13];
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append((String)object4);
        object = object[n10];
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append((String)object4);
        object = ((StringBuilder)object2).toString();
        try {
            object2 = new byte[0];
            object4 = new DatagramPacket((byte[])object2, 0, 0);
            object2 = new DatagramSocket();
            while (true) {
                if (n10 >= (n12 = 255)) {
                    ((DatagramSocket)object2).close();
                    return;
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                string2 = String.valueOf(n10);
                ((StringBuilder)object3).append(string2);
                object3 = ((StringBuilder)object3).toString();
                object3 = InetAddress.getByName((String)object3);
                ((DatagramPacket)object4).setAddress((InetAddress)object3);
                ((DatagramSocket)object2).send((DatagramPacket)object4);
                n12 = 125;
                if (++n10 != n12) continue;
                ((DatagramSocket)object2).close();
                object2 = new DatagramSocket();
            }
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
    }

    private int k() {
        long l10;
        long l11 = com.mob.commons.b.Q();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            Random random = this.a;
            if (random == null) {
                this.a = random = new Random();
            }
            random = this.a;
            long l13 = com.mob.commons.b.Q();
            int n10 = (int)l13;
            object = random.nextInt(n10);
        } else {
            object = 0;
            Object var6_5 = null;
        }
        return (int)(object * 1000);
    }

    public File a() {
        return e.a("comm/locks/.im_lock");
    }

    public void a(Message message) {
        int n10;
        int n11;
        DeviceHelper deviceHelper = this.b;
        if (deviceHelper == null) {
            this.b = deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        }
        if ((n11 = message.what) == (n10 = 1)) {
            this.h();
        }
    }

    public boolean b_() {
        long l10;
        long l11 = com.mob.commons.b.Q();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void d() {
        long l10 = com.mob.commons.b.Q();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        if (l12 > 0) {
            l12 = this.k();
            l11 = l12;
            this.a(n10, l11);
        } else {
            NLog nLog = MobLog.getInstance();
            int n11 = 2;
            Object[] objectArray = new Object[n11];
            String string2 = "IMcClt";
            objectArray[0] = string2;
            String string3 = "Config no process";
            objectArray[n10] = string3;
            String string4 = "[%s] %s";
            nLog.d(string4, objectArray);
        }
    }
}

