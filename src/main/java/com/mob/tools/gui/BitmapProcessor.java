/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 */
package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import com.mob.tools.gui.BitmapProcessor$1;
import com.mob.tools.gui.BitmapProcessor$BitmapCallback;
import com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions;
import com.mob.tools.gui.BitmapProcessor$ImageReq;
import com.mob.tools.gui.BitmapProcessor$ManagerThread;
import com.mob.tools.gui.BitmapProcessor$WorkerThread;
import com.mob.tools.gui.CachePool;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Locale;

public class BitmapProcessor {
    private static final int CAPACITY = 3;
    private static final int MAX_CACHE_SIZE = 50;
    private static final int MAX_CACHE_TIME = 60000;
    private static final int MAX_REQ_TIME = 20000;
    private static final int MAX_SIZE = 100;
    private static final int OVERFLOW_SIZE = 120;
    private static final int SCAN_INTERVAL = 20000;
    private static File cacheDir;
    private static CachePool cachePool;
    private static BitmapProcessor$ManagerThread manager;
    private static ArrayList netReqTPS;
    private static ArrayList reqList;
    private static NetworkHelper$NetworkTimeOut timeout;
    private static boolean work;
    private static BitmapProcessor$WorkerThread[] workerList;

    static {
        int n10;
        Object object = new NetworkHelper$NetworkTimeOut();
        timeout = object;
        ((NetworkHelper$NetworkTimeOut)object).connectionTimeout = n10 = 5000;
        ((NetworkHelper$NetworkTimeOut)object).readTimout = n10 = 20000 - n10;
        object = new ArrayList();
        reqList = object;
        object = new ArrayList();
        netReqTPS = object;
        workerList = new BitmapProcessor$WorkerThread[3];
        cachePool = object = new CachePool(50);
    }

    public static /* synthetic */ CachePool access$1000() {
        return cachePool;
    }

    public static /* synthetic */ ArrayList access$1100() {
        return reqList;
    }

    public static /* synthetic */ boolean access$1200() {
        return work;
    }

    public static /* synthetic */ String access$1300(String string2, BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions) {
        return BitmapProcessor.getCacheKey(string2, bitmapProcessor$BitmapDesiredOptions);
    }

    public static /* synthetic */ File access$1600() {
        return cacheDir;
    }

    public static /* synthetic */ ArrayList access$1700() {
        return netReqTPS;
    }

    public static /* synthetic */ NetworkHelper$NetworkTimeOut access$2100() {
        return timeout;
    }

    public static /* synthetic */ void access$600() {
        BitmapProcessor.deleteCacheDir();
    }

    public static /* synthetic */ BitmapProcessor$WorkerThread[] access$700() {
        return workerList;
    }

    private static void deleteCacheDir() {
        Class<BitmapProcessor> clazz = BitmapProcessor.class;
        synchronized (clazz) {
            block12: {
                String[] stringArray = cacheDir;
                stringArray = stringArray.getPath();
                File file = new File((String)stringArray);
                boolean bl2 = file.isDirectory();
                if (!bl2) break block12;
                stringArray = file.list();
                int n10 = 0;
                while (true) {
                    int n11 = stringArray.length;
                    if (n10 >= n11) break;
                    String string2 = stringArray[n10];
                    File file2 = new File(file, string2);
                    file2.delete();
                    ++n10;
                    continue;
                    break;
                }
            }
            return;
        }
    }

    public static void deleteCacheDir(boolean bl2) {
        if (bl2) {
            BitmapProcessor.deleteCacheDir();
        } else {
            BitmapProcessor$1 bitmapProcessor$1 = new BitmapProcessor$1();
            bitmapProcessor$1.start();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void deleteCachedFile(String string2, BitmapProcessor$BitmapDesiredOptions object) {
        File file;
        BitmapProcessor.removeBitmapFromRamCache(string2, (BitmapProcessor$BitmapDesiredOptions)object);
        try {
            file = cacheDir;
        }
        catch (Throwable throwable) {
            return;
        }
        string2 = Data.MD5(string2);
        object = new File(file, string2);
        ((File)object).delete();
    }

    public static Bitmap getBitmapFromCache(String string2) {
        return BitmapProcessor.getBitmapFromCache(string2, null);
    }

    public static Bitmap getBitmapFromCache(String string2, BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions) {
        String string3;
        Object object = cachePool;
        if (object != null && string2 != null && (object = ((CachePool)object).get(string3 = BitmapProcessor.getCacheKey(string2, bitmapProcessor$BitmapDesiredOptions))) != null) {
            object = cachePool;
            string2 = BitmapProcessor.getCacheKey(string2, bitmapProcessor$BitmapDesiredOptions);
            return (Bitmap)((SoftReference)((CachePool)object).get(string2)).get();
        }
        return null;
    }

    private static String getCacheKey(String string2, BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions) {
        if (bitmapProcessor$BitmapDesiredOptions != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            string2 = bitmapProcessor$BitmapDesiredOptions.toString();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static long getCacheSizeInByte() {
        String string2 = cacheDir.getPath();
        File[] fileArray = new File(string2);
        fileArray = fileArray.listFiles();
        int n10 = fileArray.length;
        long l10 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            File file = fileArray[i10];
            long l11 = file.length();
            l10 += l11;
        }
        return l10;
    }

    public static String getCacheSizeText() {
        Object object;
        long l10 = BitmapProcessor.getCacheSizeInByte();
        float f10 = l10;
        int n10 = 0x44800000;
        float f11 = 1024.0f;
        float f12 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        int n11 = 1;
        String string2 = "%.02f";
        if (f12 < 0) {
            Object object2;
            StringBuilder stringBuilder = new StringBuilder();
            Locale locale = Locale.CHINA;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object2 = Float.valueOf(f10);
            object2 = String.format(locale, string2, objectArray);
            stringBuilder.append((String)object2);
            stringBuilder.append(" B");
            return stringBuilder.toString();
        }
        float f13 = (f10 /= f11) - (f11 = 1000.0f);
        n10 = (int)(f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1));
        if (n10 < 0) {
            Object object3;
            StringBuilder stringBuilder = new StringBuilder();
            Locale locale = Locale.CHINA;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object3 = Float.valueOf(f10);
            object3 = String.format(locale, string2, objectArray);
            stringBuilder.append((String)object3);
            stringBuilder.append(" KB");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        Locale locale = Locale.CHINA;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object = Float.valueOf(f10 / 1204.0f);
        object = String.format(locale, string2, objectArray);
        stringBuilder.append((String)object);
        stringBuilder.append(" MB");
        return stringBuilder.toString();
    }

    public static void prepare(Context object) {
        Class<BitmapProcessor> clazz = BitmapProcessor.class;
        synchronized (clazz) {
            File file;
            object = ResHelper.getImageCachePath(object);
            cacheDir = file = new File((String)object);
            return;
        }
    }

    public static void process(String string2, BitmapProcessor$BitmapCallback bitmapProcessor$BitmapCallback) {
        Class<BitmapProcessor> clazz = BitmapProcessor.class;
        synchronized (clazz) {
            BitmapProcessor.process(string2, null, bitmapProcessor$BitmapCallback);
            return;
        }
    }

    public static void process(String string2, BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions, BitmapProcessor$BitmapCallback bitmapProcessor$BitmapCallback) {
        Class<BitmapProcessor> clazz = BitmapProcessor.class;
        synchronized (clazz) {
            boolean bl2 = true;
            BitmapProcessor.process(string2, bitmapProcessor$BitmapDesiredOptions, bl2, bitmapProcessor$BitmapCallback);
            return;
        }
    }

    public static void process(String string2, BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions, boolean bl2, BitmapProcessor$BitmapCallback bitmapProcessor$BitmapCallback) {
        Class<BitmapProcessor> clazz = BitmapProcessor.class;
        synchronized (clazz) {
            boolean bl3 = true;
            BitmapProcessor.process(string2, bitmapProcessor$BitmapDesiredOptions, bl2, bl3, bitmapProcessor$BitmapCallback);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void process(String object, BitmapProcessor$BitmapDesiredOptions object2, boolean n10, boolean bl2, long l10, BitmapProcessor$BitmapCallback bitmapProcessor$BitmapCallback) {
        Class<BitmapProcessor> clazz = BitmapProcessor.class;
        synchronized (clazz) {
            if (object == null) {
                return;
            }
            Object object3 = reqList;
            synchronized (object3) {
                ArrayList arrayList = reqList;
                int n11 = arrayList.size();
                for (int i10 = 0; i10 < n11; ++i10) {
                    int n12;
                    int n13;
                    boolean bl3;
                    Object object4 = reqList;
                    object4 = ((ArrayList)object4).get(i10);
                    object4 = (BitmapProcessor$ImageReq)object4;
                    String string2 = BitmapProcessor$ImageReq.access$000((BitmapProcessor$ImageReq)object4);
                    boolean bl4 = string2.equals(object);
                    BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions = BitmapProcessor$ImageReq.access$100((BitmapProcessor$ImageReq)object4);
                    if (bitmapProcessor$BitmapDesiredOptions == null && object2 == null || (bitmapProcessor$BitmapDesiredOptions = BitmapProcessor$ImageReq.access$100((BitmapProcessor$ImageReq)object4)) != null && (bl3 = (bitmapProcessor$BitmapDesiredOptions = BitmapProcessor$ImageReq.access$100((BitmapProcessor$ImageReq)object4)).equals(object2))) {
                        bl3 = true;
                    } else {
                        bl3 = false;
                        bitmapProcessor$BitmapDesiredOptions = null;
                    }
                    if (!bl4 || !bl3) continue;
                    if (bitmapProcessor$BitmapCallback != null && (n13 = ((ArrayList)(object = BitmapProcessor$ImageReq.access$200((BitmapProcessor$ImageReq)object4))).indexOf(bitmapProcessor$BitmapCallback)) == (n12 = -1)) {
                        object = BitmapProcessor$ImageReq.access$200((BitmapProcessor$ImageReq)object4);
                        ((ArrayList)object).add(bitmapProcessor$BitmapCallback);
                    }
                    BitmapProcessor.start();
                    return;
                }
            }
            object3 = new BitmapProcessor$ImageReq();
            BitmapProcessor$ImageReq.access$002((BitmapProcessor$ImageReq)object3, (String)object);
            BitmapProcessor$ImageReq.access$102((BitmapProcessor$ImageReq)object3, (BitmapProcessor$BitmapDesiredOptions)object2);
            BitmapProcessor$ImageReq.access$302((BitmapProcessor$ImageReq)object3, n10 != 0);
            BitmapProcessor$ImageReq.access$402((BitmapProcessor$ImageReq)object3, l10);
            BitmapProcessor$ImageReq.access$502((BitmapProcessor$ImageReq)object3, bl2);
            if (bitmapProcessor$BitmapCallback != null) {
                object = BitmapProcessor$ImageReq.access$200((BitmapProcessor$ImageReq)object3);
                ((ArrayList)object).add(bitmapProcessor$BitmapCallback);
            }
            object = reqList;
            synchronized (object) {
                object2 = reqList;
                ((ArrayList)object2).add(object3);
                object2 = reqList;
                int n14 = ((ArrayList)object2).size();
                n10 = 120;
                if (n14 > n10) {
                    while ((n14 = ((ArrayList)(object2 = reqList)).size()) > (n10 = 100)) {
                        object2 = reqList;
                        ((ArrayList)object2).remove(0);
                    }
                }
            }
            BitmapProcessor.start();
            return;
        }
    }

    public static void process(String string2, BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions, boolean bl2, boolean bl3, BitmapProcessor$BitmapCallback bitmapProcessor$BitmapCallback) {
        Class<BitmapProcessor> clazz = BitmapProcessor.class;
        synchronized (clazz) {
            long l10 = 0L;
            BitmapProcessor.process(string2, bitmapProcessor$BitmapDesiredOptions, bl2, bl3, l10, bitmapProcessor$BitmapCallback);
            return;
        }
    }

    public static void removeBitmapFromRamCache(String string2, BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions) {
        CachePool cachePool = BitmapProcessor.cachePool;
        if (cachePool != null) {
            string2 = BitmapProcessor.getCacheKey(string2, bitmapProcessor$BitmapDesiredOptions);
            bitmapProcessor$BitmapDesiredOptions = null;
            cachePool.put(string2, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void start() {
        Class<BitmapProcessor> clazz = BitmapProcessor.class;
        synchronized (clazz) {
            boolean bl2 = work;
            if (!bl2) {
                BitmapProcessor$ManagerThread bitmapProcessor$ManagerThread;
                work = bl2 = true;
                manager = bitmapProcessor$ManagerThread = new BitmapProcessor$ManagerThread();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void stop() {
        Class<BitmapProcessor> clazz = BitmapProcessor.class;
        synchronized (clazz) {
            boolean bl2 = work;
            if (bl2) {
                bl2 = false;
                Object object = null;
                work = false;
                object = reqList;
                synchronized (object) {
                    Object object2 = reqList;
                    ((ArrayList)object2).clear();
                    object2 = cachePool;
                    ((CachePool)object2).clear();
                }
                object = manager;
                ((BitmapProcessor$ManagerThread)object).quit();
            }
            return;
        }
    }
}

