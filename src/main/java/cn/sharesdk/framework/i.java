/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextUtils
 *  org.xmlpull.v1.XmlPullParserFactory
 */
package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Service;
import cn.sharesdk.framework.b.a;
import cn.sharesdk.framework.h;
import cn.sharesdk.framework.i$1;
import cn.sharesdk.framework.i$2;
import cn.sharesdk.framework.i$a;
import cn.sharesdk.framework.loopshare.LoopSharePasswordListener;
import cn.sharesdk.framework.loopshare.LoopShareResultListener;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener;
import cn.sharesdk.framework.loopshare.watermark.WaterMarkListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.e;
import com.mob.MobSDK;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;

public class i
extends e {
    private i$a b;
    private HashMap c;
    private ArrayList d;
    private HashMap e;
    private HashMap f;
    private HashMap g;
    private HashMap h;
    private HashMap i;
    private boolean j = true;
    private boolean k;

    public i() {
        HashMap hashMap = new HashMap();
        this.c = hashMap;
        this.d = hashMap;
        this.e = hashMap = new HashMap();
        this.f = hashMap = new HashMap();
        this.g = hashMap = new HashMap();
        this.h = hashMap = new HashMap();
        this.i = hashMap = new HashMap();
    }

    private HashMap a(a object, HashMap object2) {
        block19: {
            Object[] objectArray;
            block18: {
                int n10;
                boolean bl2;
                Object[] objectArray2;
                block17: {
                    objectArray = "res";
                    objectArray2 = "error";
                    try {
                        bl2 = ((HashMap)object2).containsKey(objectArray2);
                        n10 = 1;
                        if (!bl2) break block17;
                    }
                    catch (Throwable throwable) {
                        SSDKLog.b().w(throwable);
                        return null;
                    }
                    object = SSDKLog.b();
                    objectArray = "ShareSDK parse sns config ==>>";
                    objectArray2 = new Object[n10];
                    Hashon hashon = new Hashon();
                    object2 = hashon.fromHashMap((HashMap)object2);
                    objectArray2[0] = object2;
                    ((NLog)object).i(objectArray, objectArray2);
                    return null;
                }
                bl2 = ((HashMap)object2).containsKey(objectArray);
                if (bl2) break block18;
                object = SSDKLog.b();
                object2 = "ShareSDK platform config result ==>>";
                objectArray = new Object[n10];
                objectArray2 = "SNS configuration is empty";
                objectArray[0] = objectArray2;
                ((NLog)object).d(object2, objectArray);
                return null;
            }
            object2 = ((HashMap)object2).get(objectArray);
            object2 = (String)object2;
            if (object2 != null) break block19;
            return null;
        }
        return ((a)object).c((String)object2);
    }

    public static /* synthetic */ HashMap a(i i10, a a10, HashMap hashMap) {
        return i10.a(a10, hashMap);
    }

    public static /* synthetic */ boolean a(i i10, HashMap hashMap) {
        return i10.a(hashMap);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(HashMap hashMap) {
        HashMap hashMap2 = this.h;
        synchronized (hashMap2) {
            hashMap = cn.sharesdk.framework.h.a(hashMap);
            if (hashMap == null) return false;
            int n10 = hashMap.size();
            if (n10 <= 0) return false;
            HashMap hashMap3 = this.h;
            hashMap3.clear();
            this.h = hashMap;
            return true;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void k() {
        var1_1 = this.c;
        synchronized (var1_1) {
            block11: {
                var2_2 = this.c;
                var2_2.clear();
                var2_2 = XmlPullParserFactory.newInstance();
                var3_4 = 1;
                var2_2.setNamespaceAware((boolean)var3_4);
                var2_2 = var2_2.newPullParser();
                var4_5 = null;
                {
                    catch (Throwable var2_3) {
                        var14_16 = SSDKLog.b();
                        var14_16.d(var2_3);
                        break block11;
                    }
                    try {
                        var5_6 /* !! */  = MobSDK.getContext();
                        var5_6 /* !! */  = var5_6 /* !! */ .getAssets();
                        var6_8 = "ShareSDK.xml";
                        var4_5 = var5_6 /* !! */ .open((String)var6_8);
                        ** GOTO lbl27
                    }
                    catch (Throwable var5_7) {}
                    {
                        var6_8 = SSDKLog.b();
                        var6_8.d(var5_7);
lbl27:
                        // 2 sources

                        var5_6 /* !! */  = "utf-8";
                        var2_2.setInput(var4_5, (String)var5_6 /* !! */ );
                        var7_9 = var2_2.getEventType();
                        while (var7_9 != var3_4) {
                            var8_10 = 2;
                            if (var7_9 == var8_10) {
                                var5_6 /* !! */  = var2_2.getName();
                                var6_8 = new HashMap<String, String>();
                                var9_11 = var2_2.getAttributeCount();
                                for (var10_12 = 0; var10_12 < var9_11; var12_14 = var12_14.trim(), ++var10_12) {
                                    var11_13 = var2_2.getAttributeName(var10_12);
                                    var12_14 = var2_2.getAttributeValue(var10_12);
                                    var6_8.put(var11_13, var12_14);
                                }
                                var13_15 = this.c;
                                var13_15.put(var5_6 /* !! */ , var6_8);
                            }
                            var7_9 = var2_2.next();
                        }
                        var4_5.close();
                    }
                }
            }
            return;
        }
    }

    public Activity a() {
        return cn.sharesdk.framework.h.b();
    }

    public Bitmap a(String string2, int n10, int n11) {
        return cn.sharesdk.framework.h.a(string2, n10, n11);
    }

    public Platform a(String string2) {
        if (string2 == null) {
            return null;
        }
        Platform[] platformArray = this.f();
        if (platformArray == null) {
            return null;
        }
        for (Platform platform : platformArray) {
            String string3 = platform.getName();
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            return platform;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a(int n10, String string2) {
        HashMap hashMap = this.h;
        synchronized (hashMap) {
            Object object = this.h;
            Serializable serializable = n10;
            serializable = ((HashMap)object).get(serializable);
            serializable = (HashMap)serializable;
            object = null;
            if (serializable == null) {
                return null;
            }
            if ((serializable = ((HashMap)serializable).get(string2)) != null) return String.valueOf(serializable);
            return object;
        }
    }

    public String a(Bitmap bitmap) {
        i$a i$a = i$a.b;
        i$a i$a2 = this.b;
        if (i$a != i$a2) {
            return null;
        }
        return cn.sharesdk.framework.b.a.a().a(bitmap);
    }

    public String a(String string2, boolean bl2, int n10, String string3) {
        i$a i$a = i$a.b;
        i$a i$a2 = this.b;
        if (i$a != i$a2) {
            return string2;
        }
        return cn.sharesdk.framework.b.a.a().a(string2, n10, bl2, string3);
    }

    public void a(int n10) {
        NetworkHelper.connectionTimeout = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, int n11) {
        HashMap hashMap = this.h;
        synchronized (hashMap) {
            HashMap hashMap2 = this.h;
            Serializable serializable = n10;
            serializable = hashMap2.get(serializable);
            serializable = (HashMap)serializable;
            hashMap2 = this.h;
            Integer n12 = n11;
            hashMap2.put(n12, serializable);
            return;
        }
    }

    public void a(int n10, Platform platform) {
        cn.sharesdk.framework.h.a(n10, platform);
    }

    public void a(Activity activity) {
        cn.sharesdk.framework.h.a(activity);
    }

    public void a(Context context, ReadQrImageListener readQrImageListener) {
        cn.sharesdk.framework.h.a(context, readQrImageListener);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Message var1_1) {
        var1_1 /* !! */  = this.i;
        synchronized (var1_1 /* !! */ ) {
            var2_2 = this.d;
            synchronized (var2_2) {
                block15: {
                    var3_3 = "SHARESDK";
                    try {
                        var3_3 = EventRecorder.checkRecord((String)var3_3);
                        var4_7 = TextUtils.isEmpty((CharSequence)var3_3);
                        if (var4_7 == 0) {
                            var5_8 = cn.sharesdk.framework.b.a.a();
                            var6_11 = null;
                            var5_8.a((HashMap)null);
                            var5_8 = SSDKLog.b();
                            var6_11 = new StringBuilder();
                            var7_12 = "EventRecorder checkRecord result ==";
                            var6_11.append((String)var7_12);
                            var6_11.append((String)var3_3);
                            var3_3 = var6_11.toString();
                            var5_8.w((String)var3_3);
                            this.j();
                        }
                        EventRecorder.clear();
                        ** GOTO lbl31
                    }
                    catch (Throwable var3_4) {
                        try {
                            var5_8 = SSDKLog.b();
                            var5_8.w(var3_4);
lbl31:
                            // 2 sources

                            var3_3 = this.d;
                            var3_3.clear();
                            var3_3 = cn.sharesdk.framework.h.a();
                            if (var3_3 != null) {
                                var5_8 = this.d;
                                var5_8.addAll(var3_3);
                            }
                            var3_3 = this.d;
                            var3_3 = var3_3.iterator();
                            while ((var4_7 = var3_3.hasNext()) != 0) {
                                var5_8 = var3_3.next();
                                var5_8 = (Platform)var5_8;
                                var6_11 = this.f;
                                var8_13 = var5_8.getPlatformId();
                                var7_12 = var8_13;
                                var9_14 = var5_8.getName();
                                var6_11.put(var7_12, var9_14);
                                var6_11 = this.e;
                                var7_12 = var5_8.getName();
                                var4_7 = var5_8.getPlatformId();
                                var5_8 = var4_7;
                                var6_11.put(var7_12, var5_8);
                            }
                            var3_3 = this.a;
                            cn.sharesdk.framework.h.a((Handler)var3_3);
                            var3_3 = i$a.b;
                            this.b = var3_3;
                            var5_8 = new i$1(this);
                            var5_8.start();
                        }
                        catch (Throwable var3_5) {
                            try {
                                var5_9 = SSDKLog.b();
                                var5_9.w(var3_5);
                                var3_3 = i$a.b;
                                this.b = var3_3;
                                var3_3 = this.d;
                                var3_3.notify();
                                var3_3 = this.i;
                                break block15;
                            }
                            catch (Throwable var3_6) {
                                var5_10 = i$a.b;
                                this.b = var5_10;
                                var5_10 = this.d;
                                var5_10.notify();
                                var5_10 = this.i;
                                var5_10.notify();
                                throw var3_6;
                            }
                        }
                    }
                    this.b = var3_3;
                    var3_3 = this.d;
                    var3_3.notify();
                    var3_3 = this.i;
                }
                var3_3.notify();
                return;
            }
        }
    }

    public void a(LoopShareResultListener loopShareResultListener) {
        try {
            cn.sharesdk.framework.h.a(loopShareResultListener);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "ShareSDKCoreThrad prepareLoopShare ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            nLog.e(string3, objectArray);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Class constable) {
        HashMap hashMap = this.i;
        synchronized (hashMap) {
            Object object = this.i;
            int n10 = constable.hashCode();
            Serializable serializable = Integer.valueOf(n10);
            boolean bl2 = ((HashMap)object).containsKey(serializable);
            if (bl2) {
                return;
            }
            try {
                object = constable.newInstance();
                object = (Service)object;
                serializable = this.i;
                int n11 = constable.hashCode();
                constable = Integer.valueOf(n11);
                ((HashMap)serializable).put(constable, object);
                ((Service)object).onBind();
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                ((NLog)object).w(throwable);
            }
            return;
        }
    }

    public void a(String string2, int n10) {
        cn.sharesdk.framework.h.a(string2, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String object, String string2) {
        HashMap hashMap = this.c;
        synchronized (hashMap) {
            HashMap hashMap2 = this.c;
            object = hashMap2.get(object);
            object = (HashMap)object;
            hashMap2 = this.c;
            hashMap2.put(string2, object);
            return;
        }
    }

    public void a(String string2, String string3, String string4, String string5, WaterMarkListener waterMarkListener) {
        cn.sharesdk.framework.h.a(string2, string3, string4, string5, waterMarkListener);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2, HashMap iterator2) {
        boolean bl2;
        Object object;
        Object object2 = this.c;
        synchronized (object2) {
            object = this.c;
            object = ((HashMap)object).get(string2);
            if (object == null) {
                object = new HashMap();
            }
            synchronized (object) {
                boolean bl3;
                iterator2 = ((HashMap)((Object)iterator2)).entrySet();
                iterator2 = iterator2.iterator();
                while (bl3 = iterator2.hasNext()) {
                    Object object3 = iterator2.next();
                    object3 = (Map.Entry)object3;
                    Object object4 = object3.getKey();
                    object4 = (String)object4;
                    if ((object3 = object3.getValue()) == null) continue;
                    object3 = String.valueOf(object3);
                    ((HashMap)object).put(object4, object3);
                }
            }
            iterator2 = this.c;
            ((HashMap)((Object)iterator2)).put(string2, object);
        }
        iterator2 = this.d;
        synchronized (iterator2) {
            object2 = this.b;
            object = i$a.a;
            if (object2 == object) {
                try {
                    object2 = this.d;
                    object2.wait();
                }
                catch (Throwable throwable) {
                    object = SSDKLog.b();
                    ((NLog)object).w(throwable);
                }
            }
        }
        iterator2 = this.d.iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl4;
            object2 = (Platform)iterator2.next();
            if (object2 == null || !(bl4 = ((String)(object = ((Platform)object2).getName())).equals(string2))) continue;
            ((Platform)object2).a();
            return;
        }
    }

    public void a(HashMap hashMap, MoblinkActionListener object) {
        try {
            cn.sharesdk.framework.h.a(hashMap, (MoblinkActionListener)object);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "ShareSDKCoreThread mobLinkGetMobID ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            ((NLog)object).e(string3, objectArray);
        }
    }

    public void a(HashMap hashMap, String object, LoopSharePasswordListener objectArray) {
        try {
            cn.sharesdk.framework.h.a(hashMap, (String)object, (LoopSharePasswordListener)objectArray);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            objectArray = new StringBuilder();
            String string2 = "ShareSDKCoreThrad preparePassWord catch: ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            ((NLog)object).e(string3, objectArray);
        }
    }

    public void a(boolean bl2) {
        cn.sharesdk.framework.h.a(bl2);
    }

    public void a(boolean bl2, LoopSharePasswordListener object) {
        try {
            cn.sharesdk.framework.h.a(bl2, (LoopSharePasswordListener)object);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "ShareSDKCoreThrad readPassWord catch: ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            ((NLog)object).e(string3, objectArray);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int b(String object) {
        ArrayList arrayList = this.d;
        synchronized (arrayList) {
            HashMap hashMap = this.g;
            synchronized (hashMap) {
                HashMap hashMap2 = this.e;
                boolean bl2 = hashMap2.containsKey(object);
                if (!bl2) return 0;
                hashMap2 = this.e;
                object = hashMap2.get(object);
                object = (Integer)object;
                return (Integer)object;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String b(String object, String string2) {
        HashMap hashMap = this.c;
        synchronized (hashMap) {
            HashMap hashMap2 = this.c;
            object = hashMap2.get(object);
            object = (HashMap)object;
            if (object == null) {
                return null;
            }
            object = ((HashMap)object).get(string2);
            return (String)object;
        }
    }

    public void b(int n10) {
        NetworkHelper.readTimout = n10;
    }

    public void b(Message message) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(Class constable) {
        HashMap hashMap = this.i;
        synchronized (hashMap) {
            int n10 = constable.hashCode();
            Object object = this.i;
            Integer n11 = n10;
            boolean bl2 = ((HashMap)object).containsKey(n11);
            if (bl2) {
                object = this.i;
                n11 = n10;
                object = ((HashMap)object).get(n11);
                object = (Service)object;
                ((Service)object).onUnbind();
                object = this.i;
                constable = Integer.valueOf(n10);
                ((HashMap)object).remove(constable);
            }
            return;
        }
    }

    public void b(boolean bl2) {
        cn.sharesdk.framework.h.b(bl2);
    }

    public boolean b() {
        return cn.sharesdk.framework.h.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Service c(Class object) {
        HashMap hashMap = this.i;
        synchronized (hashMap) {
            Object object2 = this.b;
            Object object3 = i$a.a;
            if (object2 == object3) {
                try {
                    object2 = this.i;
                    ((Object)object2).wait();
                }
                catch (Throwable throwable) {
                    object3 = SSDKLog.b();
                    ((NLog)object3).w(throwable);
                }
            }
            try {
                object2 = this.i;
                int n10 = object.hashCode();
                object3 = n10;
                object2 = ((HashMap)object2).get(object3);
                object = ((Class)object).cast(object2);
                return (Service)object;
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).w(throwable);
                return null;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String c(int n10) {
        ArrayList arrayList = this.d;
        synchronized (arrayList) {
            HashMap hashMap = this.g;
            synchronized (hashMap) {
                HashMap hashMap2 = this.f;
                Object object = n10;
                object = hashMap2.get(object);
                return (String)object;
            }
        }
    }

    public String c(String string2) {
        i$a i$a = i$a.b;
        i$a i$a2 = this.b;
        if (i$a != i$a2) {
            return null;
        }
        return cn.sharesdk.framework.b.a.a().b(string2);
    }

    public void c(boolean bl2) {
        this.k = bl2;
    }

    public boolean c() {
        return cn.sharesdk.framework.h.d();
    }

    public HashMap d() {
        return cn.sharesdk.framework.h.e();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(Class serializable) {
        HashMap hashMap = this.g;
        synchronized (hashMap) {
            Object object = this.g;
            int n10 = serializable.hashCode();
            Object object2 = n10;
            int n11 = ((HashMap)object).containsKey(object2);
            if (n11 != 0) {
                return;
            }
            try {
                object = ((Class)serializable).newInstance();
                object = (CustomPlatform)object;
                object2 = this.g;
                int n12 = serializable.hashCode();
                serializable = Integer.valueOf(n12);
                ((HashMap)object2).put(serializable, object);
                if (object != null && (n12 = (int)(((Platform)object).b() ? 1 : 0)) != 0) {
                    serializable = this.f;
                    n10 = ((CustomPlatform)object).getPlatformId();
                    object2 = n10;
                    String string2 = ((CustomPlatform)object).getName();
                    ((HashMap)serializable).put(object2, string2);
                    serializable = this.e;
                    object2 = ((CustomPlatform)object).getName();
                    n11 = ((CustomPlatform)object).getPlatformId();
                    object = n11;
                    ((HashMap)serializable).put(object2, object);
                }
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                ((NLog)object).w(throwable);
            }
            return;
        }
    }

    public void e() {
        i$a i$a;
        this.b = i$a = i$a.a;
        SSDKLog.a();
        EventRecorder.prepare();
        this.k();
        super.e();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e(Class constable) {
        int n10 = constable.hashCode();
        HashMap hashMap = this.g;
        synchronized (hashMap) {
            HashMap hashMap2 = this.g;
            constable = Integer.valueOf(n10);
            hashMap2.remove(constable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Platform[] f() {
        boolean bl2;
        boolean bl3;
        Object object;
        Object object2;
        long l10 = System.currentTimeMillis();
        Object object3 = this.d;
        synchronized (object3) {
            object2 = this.b;
            object = i$a.a;
            if (object2 == object) {
                try {
                    object2 = this.d;
                    object2.wait();
                }
                catch (Throwable throwable) {
                    object = SSDKLog.b();
                    ((NLog)object).w(throwable);
                }
            }
        }
        object3 = new ArrayList();
        object2 = this.d.iterator();
        while (bl3 = object2.hasNext()) {
            object = (Platform)object2.next();
            if (object == null || !(bl2 = ((Platform)object).b())) continue;
            ((Platform)object).a();
            ((ArrayList)object3).add(object);
        }
        cn.sharesdk.framework.h.a(object3);
        object2 = this.g.entrySet().iterator();
        while (bl3 = object2.hasNext()) {
            object = (Platform)((Map.Entry)object2.next()).getValue();
            if (object == null || !(bl2 = ((Platform)object).b())) continue;
            ((ArrayList)object3).add(object);
        }
        int n10 = ((ArrayList)object3).size();
        if (n10 <= 0) {
            return null;
        }
        n10 = ((ArrayList)object3).size();
        object = new Platform[n10];
        bl2 = false;
        int n11 = 0;
        Object[] objectArray = null;
        while (true) {
            if (n11 >= n10) {
                object3 = SSDKLog.b();
                objectArray = new Object[1];
                Long l11 = System.currentTimeMillis() - l10;
                objectArray[0] = l11;
                ((NLog)object3).i("sort list use time: %s", objectArray);
                return object;
            }
            Platform platform = (Platform)((ArrayList)object3).get(n11);
            object[n11] = platform;
            ++n11;
        }
    }

    public boolean g() {
        return this.k;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean h() {
        HashMap hashMap = this.h;
        synchronized (hashMap) {
            HashMap hashMap2 = this.h;
            if (hashMap2 == null) return false;
            int n10 = hashMap2.size();
            if (n10 <= 0) return false;
            return 1 != 0;
        }
    }

    public boolean i() {
        boolean bl2;
        block10: {
            int n10;
            Object object = i$a.b;
            Object object2 = this.b;
            bl2 = false;
            if (object != object2) {
                object = SSDKLog.b();
                object2 = new Object[]{};
                ((NLog)object).d("Statistics module unopened", (Object[])object2);
                return false;
            }
            object = cn.sharesdk.framework.b.a.a();
            object2 = ((a)object).e();
            if ((object2 = this.a((a)object, (HashMap)object2)) != null && (n10 = ((HashMap)object2).size()) > 0) {
                bl2 = this.a((HashMap)object2);
            }
            if (bl2) {
                object2 = new i$2(this, (a)object);
                ((Thread)object2).start();
            } else {
                object2 = ((a)object).f();
                HashMap hashMap = this.a((a)object, (HashMap)object2);
                if (hashMap == null) break block10;
                int n11 = hashMap.size();
                if (n11 <= 0) break block10;
                bl2 = this.a(hashMap);
                if (!bl2) break block10;
                try {
                    ((a)object).a((HashMap)object2);
                }
                catch (Throwable throwable) {
                    object2 = SSDKLog.b();
                    ((NLog)object2).w(throwable);
                }
            }
        }
        return bl2;
    }

    public void j() {
        Context context = MobSDK.getContext();
        try {
            ResHelper.clearCache(context);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            nLog.w(throwable);
        }
    }
}

