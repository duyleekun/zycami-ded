/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.mob.tools.utils.BitmapHelper
 */
package com.mob.tools.gui;

import android.graphics.Bitmap;
import com.mob.tools.MobLog;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.gui.BitmapProcessor$1;
import com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions;
import com.mob.tools.gui.BitmapProcessor$ImageReq;
import com.mob.tools.gui.BitmapProcessor$WorkerThread$1;
import com.mob.tools.gui.CachePool;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class BitmapProcessor$WorkerThread
extends Thread {
    private BitmapProcessor$ImageReq curReq;
    private boolean localType;

    private BitmapProcessor$WorkerThread() {
    }

    public /* synthetic */ BitmapProcessor$WorkerThread(BitmapProcessor$1 bitmapProcessor$1) {
        this();
    }

    public static /* synthetic */ void access$1900(BitmapProcessor$WorkerThread bitmapProcessor$WorkerThread, InputStream inputStream, File file) {
        bitmapProcessor$WorkerThread.saveFile(inputStream, file);
    }

    public static /* synthetic */ BitmapProcessor$ImageReq access$2002(BitmapProcessor$WorkerThread bitmapProcessor$WorkerThread, BitmapProcessor$ImageReq bitmapProcessor$ImageReq) {
        bitmapProcessor$WorkerThread.curReq = bitmapProcessor$ImageReq;
        return bitmapProcessor$ImageReq;
    }

    public static /* synthetic */ boolean access$902(BitmapProcessor$WorkerThread bitmapProcessor$WorkerThread, boolean bl2) {
        bitmapProcessor$WorkerThread.localType = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void doLocalTask() {
        Object object = BitmapProcessor.access$1100();
        // MONITORENTER : object
        Object object2 = BitmapProcessor.access$1100();
        int n10 = ((ArrayList)object2).size();
        int n11 = 0;
        Object object3 = null;
        if (n10 > 0) {
            object2 = BitmapProcessor.access$1100();
            object2 = ((ArrayList)object2).remove(0);
            object2 = (BitmapProcessor$ImageReq)object2;
        } else {
            n10 = 0;
            object2 = null;
        }
        // MONITOREXIT : object
        if (object2 != null) {
            Object object4;
            boolean bl2 = BitmapProcessor$ImageReq.access$300((BitmapProcessor$ImageReq)object2);
            if (bl2) {
                object = BitmapProcessor.access$1000();
                object4 = BitmapProcessor$ImageReq.access$000((BitmapProcessor$ImageReq)object2);
                BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions = BitmapProcessor$ImageReq.access$100((BitmapProcessor$ImageReq)object2);
                if ((object = (SoftReference)((CachePool)object).get(object4 = BitmapProcessor.access$1300((String)object4, bitmapProcessor$BitmapDesiredOptions))) != null) {
                    object3 = object = (Bitmap)((SoftReference)object).get();
                }
            }
            if (object3 != null) {
                this.curReq = object2;
                BitmapProcessor$ImageReq.access$1402((BitmapProcessor$ImageReq)object2, this);
                BitmapProcessor$ImageReq.access$1500((BitmapProcessor$ImageReq)object2, object3);
                return;
            }
            bl2 = BitmapProcessor$ImageReq.access$500((BitmapProcessor$ImageReq)object2);
            if (bl2 && (object = BitmapProcessor.access$1600()) != null && (bl2 = ((File)(object = new File((File)(object3 = BitmapProcessor.access$1600()), (String)(object4 = Data.MD5(BitmapProcessor$ImageReq.access$000((BitmapProcessor$ImageReq)object2)))))).exists())) {
                this.doTask((BitmapProcessor$ImageReq)object2);
                return;
            }
            object = BitmapProcessor.access$1100();
            // MONITORENTER : object
            object3 = BitmapProcessor.access$1700();
            n11 = ((ArrayList)object3).size();
            int n12 = 100;
            if (n11 > n12) {
                object3 = BitmapProcessor.access$1100();
                // MONITORENTER : object3
                while ((n12 = ((ArrayList)(object4 = BitmapProcessor.access$1100())).size()) > 0) {
                    object4 = BitmapProcessor.access$1100();
                    ((ArrayList)object4).remove(0);
                }
                // MONITOREXIT : object3
                object3 = BitmapProcessor.access$1700();
                ((ArrayList)object3).remove(0);
            }
            // MONITOREXIT : object
            object = BitmapProcessor.access$1700();
            ((ArrayList)object).add(object2);
            return;
        }
        long l10 = 30;
        try {
            Thread.sleep(l10);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void doNetworkTask() {
        Object object;
        Object object2 = BitmapProcessor.access$1700();
        // MONITORENTER : object2
        Object object3 = BitmapProcessor.access$1700();
        int n10 = ((ArrayList)object3).size();
        String string2 = null;
        Object object4 = null;
        if (n10 > 0) {
            object3 = BitmapProcessor.access$1700();
            object3 = ((ArrayList)object3).remove(0);
            object3 = (BitmapProcessor$ImageReq)object3;
        } else {
            n10 = 0;
            object3 = null;
        }
        // MONITOREXIT : object2
        if (object3 == null) {
            object2 = BitmapProcessor.access$1100();
            // MONITORENTER : object2
            object = BitmapProcessor.access$1100();
            int n11 = ((ArrayList)object).size();
            if (n11 > 0) {
                object3 = BitmapProcessor.access$1100();
                object3 = ((ArrayList)object3).remove(0);
                object3 = (BitmapProcessor$ImageReq)object3;
            }
            // MONITOREXIT : object2
        }
        if (object3 != null) {
            boolean bl2 = BitmapProcessor$ImageReq.access$300((BitmapProcessor$ImageReq)object3);
            if (bl2) {
                object2 = BitmapProcessor.access$1000();
                string2 = BitmapProcessor$ImageReq.access$000((BitmapProcessor$ImageReq)object3);
                object = BitmapProcessor$ImageReq.access$100((BitmapProcessor$ImageReq)object3);
                if ((object2 = (SoftReference)((CachePool)object2).get(string2 = BitmapProcessor.access$1300(string2, (BitmapProcessor$BitmapDesiredOptions)object))) != null) {
                    object4 = object2 = (Bitmap)((SoftReference)object2).get();
                }
            }
            if (object4 != null) {
                this.curReq = object3;
                BitmapProcessor$ImageReq.access$1402((BitmapProcessor$ImageReq)object3, this);
                BitmapProcessor$ImageReq.access$1500((BitmapProcessor$ImageReq)object3, object4);
                return;
            }
            this.doTask((BitmapProcessor$ImageReq)object3);
            return;
        }
        long l10 = 30;
        try {
            Thread.sleep(l10);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void doTask(BitmapProcessor$ImageReq bitmapProcessor$ImageReq) {
        try {
            long l10;
            long l11;
            long l12;
            this.curReq = bitmapProcessor$ImageReq;
            BitmapProcessor$ImageReq.access$1402(bitmapProcessor$ImageReq, this);
            Object object = BitmapProcessor$ImageReq.access$000(bitmapProcessor$ImageReq);
            object = Data.MD5((String)object);
            Object object2 = BitmapProcessor.access$1600();
            Object object3 = new File((File)object2, (String)object);
            int n10 = BitmapProcessor$ImageReq.access$500(bitmapProcessor$ImageReq);
            if (n10 != 0 && (n10 = (l12 = (l11 = BitmapProcessor$ImageReq.access$400(bitmapProcessor$ImageReq)) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 && (n10 = (int)(((File)object3).exists() ? 1 : 0)) != 0) {
                l11 = ((File)object3).lastModified();
                l10 = System.currentTimeMillis();
                long l13 = BitmapProcessor$ImageReq.access$400(bitmapProcessor$ImageReq);
                long l14 = (l11 += l13) - l10;
                n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                if (n10 < 0) {
                    ((File)object3).delete();
                }
            }
            if ((n10 = BitmapProcessor$ImageReq.access$500(bitmapProcessor$ImageReq)) != 0 && (object2 = BitmapProcessor.access$1600()) != null && (n10 = (int)(((File)object3).exists() ? 1 : 0)) != 0) {
                SoftReference<Object> softReference;
                object2 = BitmapProcessor$ImageReq.access$100(bitmapProcessor$ImageReq);
                if (object2 != null && (n10 = (int)(((BitmapProcessor$BitmapDesiredOptions)(object2 = BitmapProcessor$ImageReq.access$100(bitmapProcessor$ImageReq))).equals(softReference = "") ? 1 : 0)) == 0) {
                    object2 = BitmapProcessor.access$1600();
                    object3 = new File((File)object2, (String)object);
                    softReference = ((File)object3).getAbsolutePath();
                    object = BitmapProcessor$ImageReq.access$100(bitmapProcessor$ImageReq);
                    int n11 = ((BitmapProcessor$BitmapDesiredOptions)object).desiredWidth;
                    object = BitmapProcessor$ImageReq.access$100(bitmapProcessor$ImageReq);
                    int n12 = ((BitmapProcessor$BitmapDesiredOptions)object).desiredHeight;
                    object = BitmapProcessor$ImageReq.access$100(bitmapProcessor$ImageReq);
                    int n13 = ((BitmapProcessor$BitmapDesiredOptions)object).quality;
                    object = BitmapProcessor$ImageReq.access$100(bitmapProcessor$ImageReq);
                    long l15 = ((BitmapProcessor$BitmapDesiredOptions)object).maxBytes;
                    object = BitmapHelper.getBitmapByCompressQuality(softReference, (int)n11, (int)n12, (int)n13, (long)l15);
                } else {
                    object = ((File)object3).getAbsolutePath();
                    object = BitmapHelper.getBitmap((String)object);
                }
                if (object != null) {
                    boolean bl2 = BitmapProcessor$ImageReq.access$300(bitmapProcessor$ImageReq);
                    if (bl2) {
                        object3 = BitmapProcessor.access$1000();
                        object2 = BitmapProcessor$ImageReq.access$000(bitmapProcessor$ImageReq);
                        softReference = BitmapProcessor$ImageReq.access$100(bitmapProcessor$ImageReq);
                        object2 = BitmapProcessor.access$1300((String)object2, (BitmapProcessor$BitmapDesiredOptions)((Object)softReference));
                        softReference = new SoftReference<Object>(object);
                        ((CachePool)object3).put(object2, softReference);
                    }
                    BitmapProcessor$ImageReq.access$1500(bitmapProcessor$ImageReq, (Bitmap)object);
                } else {
                    BitmapProcessor$ImageReq.access$1800(bitmapProcessor$ImageReq);
                }
                this.curReq = null;
                return;
            }
            object3 = new NetworkHelper();
            object2 = BitmapProcessor$ImageReq.access$000(bitmapProcessor$ImageReq);
            BitmapProcessor$WorkerThread$1 bitmapProcessor$WorkerThread$1 = new BitmapProcessor$WorkerThread$1(this, (String)object, bitmapProcessor$ImageReq);
            object = BitmapProcessor.access$2100();
            ((NetworkHelper)object3).rawGet((String)object2, bitmapProcessor$WorkerThread$1, (NetworkHelper$NetworkTimeOut)object);
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
            BitmapProcessor$ImageReq.access$1800(bitmapProcessor$ImageReq);
            this.curReq = null;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void saveFile(InputStream var1_1, File var2_2) {
        var3_4 = 0;
        var4_5 = null;
        var5_6 = var2_2.exists();
        if (var5_6) {
            var2_2.delete();
        }
        if (!(var5_6 = (var6_7 = var2_2.getParentFile()).exists())) {
            var6_7 = var2_2.getParentFile();
            var6_7.mkdirs();
        }
        var2_2.createNewFile();
        var6_7 = new FileOutputStream(var2_2);
        var3_4 = 256;
        try {
            var4_5 = new byte[var3_4];
            var7_8 = var1_1.read((byte[])var4_5);
            while (var7_8 > 0) {
                var6_7.write((byte[])var4_5, 0, var7_8);
                var7_8 = var1_1.read((byte[])var4_5);
            }
            var6_7.flush();
        }
        catch (Throwable v0) {
            var4_5 = var6_7;
lbl26:
            // 2 sources

            while (true) {
                try {
                    var5_6 = var2_2.exists();
                    if (var5_6) {
                        var2_2.delete();
                    }
                    ** GOTO lbl40
                }
                catch (Throwable var2_3) {
                    try {
                        var4_5.close();
                        var1_1.close();
                    }
                    finally {
                        throw var2_3;
                    }
lbl40:
                    // 1 sources

                    try {
                        var4_5.close();
                        ** continue;
                    }
                    catch (Throwable v1) {}
                    return;
                }
                break;
            }
        }
        var6_7.close();
lbl47:
        // 2 sources

        while (true) {
            var1_1.close();
            return;
        }
        catch (Throwable v2) {
            ** continue;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void interrupt() {
        try {
            super.interrupt();
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        boolean bl2;
        while (bl2 = BitmapProcessor.access$1200()) {
            try {
                bl2 = this.localType;
                if (bl2) {
                    this.doLocalTask();
                    continue;
                }
                this.doNetworkTask();
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.w(throwable);
                continue;
            }
            break;
        }
        return;
    }
}

