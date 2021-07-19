/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningTaskInfo
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.graphics.Bitmap$CompressFormat
 *  android.media.MediaFormat
 *  android.media.MediaMetadataRetriever
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.Display
 *  android.view.WindowManager
 */
package com.tencent.liteav.basic.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.a;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.basic.util.g$1;
import com.tencent.liteav.basic.util.g$2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

public class g {
    public static long a = 0L;
    private static boolean b = true;
    private static String c = "";
    private static int d = 0;
    private static long e = 0L;
    private static boolean f = false;
    private static a g;
    private static final Object h;
    private static boolean i;
    private static int[] j;

    static {
        g$1 g$1 = new g$1();
        Object object = new a(g$1);
        g = object;
        h = object = new Object();
        i = false;
        Object object2 = object = (Object)new int[13];
        object2[0] = 96000;
        object2[1] = 88200;
        object2[2] = 64000;
        object2[3] = 48000;
        object2[4] = 44100;
        object2[5] = 32000;
        object2[6] = 24000;
        object2[7] = 22050;
        object2[8] = 16000;
        object2[9] = 12000;
        object2[10] = 11025;
        object2[11] = 8000;
        object2[12] = 7350;
        j = (int[])object;
    }

    public static int a(int n10) {
        int[] nArray;
        int n11;
        int n12;
        for (n12 = 0; n12 < (n11 = (nArray = j).length) && (n11 = nArray[n12]) != n10; ++n12) {
        }
        n10 = nArray.length;
        if (n12 >= n10) {
            n12 = -1;
        }
        return n12;
    }

    public static /* synthetic */ long a(long l10) {
        e = l10;
        return l10;
    }

    public static MediaFormat a(int n10, int n11, int n12) {
        int by2 = com.tencent.liteav.basic.util.g.a(n10);
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        n12 <<= 3;
        int n13 = by2 >> 1;
        n12 = (byte)(n12 | n13);
        byteBuffer.put(0, (byte)n12);
        n12 = 1;
        int n14 = (by2 & n12) << 7;
        n13 = n11 << 3;
        byte by3 = (byte)(n14 | n13);
        byteBuffer.put(n12, by3);
        MediaFormat mediaFormat = MediaFormat.createAudioFormat((String)"audio/mp4a-latm", (int)n10, (int)n11);
        mediaFormat.setInteger("channel-count", n11);
        mediaFormat.setInteger("sample-rate", n10);
        mediaFormat.setByteBuffer("csd-0", byteBuffer);
        return mediaFormat;
    }

    /*
     * Unable to fully structure code
     */
    public static MediaFormat a(byte[] var0, int var1_1, int var2_2) {
        var3_3 = MediaFormat.createVideoFormat((String)"video/avc", (int)var1_1, (int)var2_2);
        var2_2 = 0;
        var4_4 = 0;
        var5_5 = 0;
        var6_6 = 0;
        var7_7 = 0;
        var8_8 = 0;
        while (true) {
            var9_9 = var4_4 + 3;
            var10_10 = var0.length;
            var11_11 = "csd-0";
            var12_12 = "csd-1";
            var13_13 = 7;
            var14_14 = 8;
            if (var9_9 >= var10_10) break;
            var10_10 = var0[var4_4];
            var15_15 = 1;
            if (var10_10 != 0) ** GOTO lbl-1000
            var10_10 = var4_4 + 1;
            if ((var10_10 = var0[var10_10]) != 0) ** GOTO lbl-1000
            var10_10 = var4_4 + 2;
            if ((var10_10 = var0[var10_10]) == var15_15) {
                var10_10 = 3;
            } else lbl-1000:
            // 3 sources

            {
                var10_10 = 0;
            }
            var16_16 = var0[var4_4];
            if (var16_16 == 0) {
                var16_16 = var4_4 + 1;
                if ((var16_16 = var0[var16_16]) == 0) {
                    var16_16 = var4_4 + 2;
                    if ((var16_16 = var0[var16_16]) == 0 && (var9_9 = var0[var9_9]) == var15_15) {
                        var10_10 = 4;
                    }
                }
            }
            if (var10_10 > 0) {
                if (var5_5 == 0) {
                    var4_4 += var10_10;
                    var5_5 = var10_10;
                } else {
                    var8_8 = var0[var5_5] & 31;
                    if (var8_8 == var13_13) {
                        com.tencent.liteav.basic.util.g.a(var11_11, var3_3, var0, var5_5, var4_4);
                        var6_6 = var15_15;
                    } else if (var8_8 == var14_14) {
                        com.tencent.liteav.basic.util.g.a(var12_12, var3_3, var0, var5_5, var4_4);
                        var7_7 = var15_15;
                    }
                    var5_5 = var4_4 + var10_10;
                    if (var6_6 != 0 && var7_7 != 0) {
                        return var3_3;
                    }
                    var8_8 = var4_4;
                    var4_4 = var5_5;
                }
            }
            var4_4 += var15_15;
        }
        var2_2 = var0[var5_5] & 31;
        if (var6_6 != 0 && var2_2 == var14_14) {
            com.tencent.liteav.basic.util.g.a(var12_12, var3_3, var0, var5_5, var8_8);
            return var3_3;
        }
        if (var7_7 != 0 && var2_2 == var13_13) {
            com.tencent.liteav.basic.util.g.a(var11_11, var3_3, var0, var5_5, var8_8);
            return var3_3;
        }
        return null;
    }

    public static com.tencent.liteav.basic.opengl.a a(int n10, int n11, int n12, int n13) {
        int n14 = n10 * n13;
        int n15 = n11 * n12;
        if (n14 >= n15) {
            n15 /= n13;
            n14 = n11;
        } else {
            n14 /= n12;
            n15 = n10;
        }
        n12 = 0;
        n10 = n10 > n15 ? n10 - n15 >> 1 : 0;
        if (n11 > n14) {
            n12 = (n11 -= n14) >> 1;
        }
        com.tencent.liteav.basic.opengl.a a10 = new com.tencent.liteav.basic.opengl.a(n10, n12, n15, n14);
        return a10;
    }

    private static void a(String string2, MediaFormat mediaFormat, byte[] byArray, int n10, int n11) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(n11 -= n10);
        byteBuffer.put(byArray, n10, n11);
        byteBuffer.position(0);
        mediaFormat.setByteBuffer(string2, byteBuffer);
    }

    public static void a(WeakReference object, int n10, Bundle bundle) {
        if (object == null) {
            return;
        }
        if ((object = (com.tencent.liteav.basic.b.b)((Reference)object).get()) != null) {
            object.onNotifyEvent(n10, bundle);
        }
    }

    public static void a(WeakReference weakReference, int n10, String string2) {
        Bundle bundle = new Bundle();
        String string3 = "EVT_ID";
        bundle.putInt(string3, n10);
        long l10 = TXCTimeUtil.getTimeTick();
        bundle.putLong("EVT_TIME", l10);
        l10 = TXCTimeUtil.getUtcTimeTick();
        String string4 = "EVT_UTC_TIME";
        bundle.putLong(string4, l10);
        if (string2 != null) {
            string3 = "EVT_MSG";
            bundle.putCharSequence(string3, (CharSequence)string2);
        }
        com.tencent.liteav.basic.util.g.a(weakReference, n10, bundle);
    }

    public static void a(WeakReference object, String string2, int n10, Bundle bundle) {
        if (object == null) {
            return;
        }
        if ((object = (com.tencent.liteav.basic.b.b)((Reference)object).get()) != null) {
            String string3 = "EVT_USERID";
            bundle.putString(string3, string2);
            object.onNotifyEvent(n10, bundle);
        }
    }

    public static void a(WeakReference weakReference, String string2, int n10, String string3, long l10) {
        Bundle bundle = new Bundle();
        String string4 = "EVT_USERID";
        bundle.putString(string4, string2);
        bundle.putInt("EVT_ID", n10);
        long l11 = TXCTimeUtil.getTimeTick();
        bundle.putLong("EVT_TIME", l11);
        l11 = TXCTimeUtil.getUtcTimeTick();
        bundle.putLong("EVT_UTC_TIME", l11);
        string2 = "EVT_BLOCK_DURATION";
        bundle.putLong(string2, l10);
        if (string3 != null) {
            string2 = "EVT_MSG";
            bundle.putCharSequence(string2, (CharSequence)string3);
        }
        com.tencent.liteav.basic.util.g.a(weakReference, n10, bundle);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(Context object) {
        String string2;
        block16: {
            int n10;
            Object object2;
            block15: {
                if (object == null) {
                    return false;
                }
                object2 = "activity";
                try {
                    object2 = object.getSystemService((String)object2);
                }
                catch (Exception exception) {
                    return false;
                }
                object2 = (ActivityManager)object2;
                n10 = 1;
                List list = object2.getRunningTasks(n10);
                string2 = "TXCSystemUtil";
                if (list != null) break block15;
                String string3 = "running task is null, ams is abnormal!!!";
                TXCLog.e(string2, string3);
                return false;
            }
            object2 = object2.getRunningTasks(n10);
            object2 = object2.get(0);
            object2 = (ActivityManager.RunningTaskInfo)object2;
            if (object2 == null) break block16;
            object2 = ((ActivityManager.RunningTaskInfo)object2).topActivity;
            if (object2 == null) break block16;
            object2 = object2.getPackageName();
            String string4 = object.getPackageName();
            return (((String)object2).equals(string4) ^ n10) != 0;
        }
        String string5 = "failed to get RunningTaskInfo";
        TXCLog.e(string2, string5);
        return false;
    }

    public static boolean a(String string2) {
        String string3 = "load library : ";
        String string4 = "Native-LiteAV";
        CharSequence charSequence = new StringBuilder();
        CharSequence charSequence2 = "load library ";
        charSequence.append((String)charSequence2);
        charSequence.append(string2);
        charSequence2 = " from system path ";
        charSequence.append((String)charSequence2);
        charSequence = charSequence.toString();
        try {
            Log.w((String)string4, (String)charSequence);
            System.loadLibrary(string2);
            return true;
        }
        catch (Exception exception) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(string3);
            string3 = exception.toString();
            ((StringBuilder)charSequence2).append(string3);
            string3 = ((StringBuilder)charSequence2).toString();
            Log.w((String)string4, (String)string3);
            return com.tencent.liteav.basic.util.g.b(c, string2);
        }
        catch (Error error) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(string3);
            string3 = error.toString();
            ((StringBuilder)charSequence2).append(string3);
            string3 = ((StringBuilder)charSequence2).toString();
            Log.w((String)string4, (String)string3);
            return com.tencent.liteav.basic.util.g.b(c, string2);
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(String string2, String object) {
        void var0_7;
        File file;
        block23: {
            block22: {
                block19: {
                    Object object2;
                    block20: {
                        Object object3;
                        block21: {
                            if (string2 == null) return false;
                            if (object == null) {
                                return false;
                            }
                            object2 = null;
                            file = new File(string2);
                            boolean bl2 = file.exists();
                            if (!bl2) {
                                return false;
                            }
                            file = new MediaMetadataRetriever();
                            file.setDataSource(string2);
                            string2 = file.getFrameAtTime();
                            object3 = new File((String)object);
                            boolean bl3 = ((File)object3).exists();
                            if (bl3) {
                                ((File)object3).delete();
                            }
                            object = new FileOutputStream((File)object3);
                            object2 = Bitmap.CompressFormat.JPEG;
                            int n10 = 100;
                            string2.compress((Bitmap.CompressFormat)object2, n10, (OutputStream)object);
                            ((OutputStream)object).flush();
                            try {
                                ((FileOutputStream)object).close();
                                break block19;
                            }
                            catch (IOException iOException) {}
                            catch (Throwable throwable) {
                                object2 = object;
                                break block20;
                            }
                            catch (Exception exception) {
                                object2 = object;
                                break block21;
                            }
                            catch (Exception exception) {
                                break block21;
                            }
                            catch (Throwable throwable) {
                                boolean bl4 = false;
                                file = null;
                                break block20;
                            }
                            catch (Exception exception) {
                                boolean bl5 = false;
                                file = null;
                            }
                        }
                        object = "TXCSystemUtil";
                        object3 = "get video thumb failed.";
                        TXCLog.e((String)object, (String)object3, (Throwable)((Object)string2));
                        if (object2 == null) break block22;
                        try {
                            ((FileOutputStream)object2).close();
                            break block22;
                        }
                        catch (IOException iOException) {}
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (object2 == null) break block23;
                    try {
                        ((FileOutputStream)object2).close();
                        break block23;
                    }
                    catch (IOException iOException) {}
                }
                file.release();
                return true;
            }
            if (file == null) return false;
            file.release();
            return false;
        }
        if (file == null) throw var0_7;
        file.release();
        throw var0_7;
    }

    public static /* synthetic */ boolean a(boolean bl2) {
        f = bl2;
        return bl2;
    }

    public static int[] a() {
        boolean bl2 = b;
        if (bl2) {
            b = false;
            ((b)g.a()).a();
            int[] nArray = new int[]{0, 0};
            return nArray;
        }
        return ((b)g.a()).a();
    }

    public static int b() {
        block2: {
            block3: {
                Object object = f;
                if (object != 0) break block2;
                long l10 = e;
                long l11 = 0L;
                long l12 = l10 - l11;
                object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object == 0) break block3;
                l10 = TXCTimeUtil.getTimeTick();
                l11 = e;
                long l13 = (l10 -= l11) - (l11 = 15000L);
                object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object < 0) break block2;
            }
            f = true;
            g$2 g$2 = new g$2();
            AsyncTask.execute((Runnable)g$2);
            return d;
        }
        return d;
    }

    public static /* synthetic */ int b(int n10) {
        d = n10;
        return n10;
    }

    public static String b(Context context) {
        return TXCDRApi.getSimulateIDFA(context);
    }

    public static void b(String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setLibraryPath ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        Log.w((String)"Native-LiteAV", (String)charSequence);
        c = string2;
    }

    private static boolean b(String string2, String charSequence) {
        boolean bl2;
        block16: {
            String string3 = "load library : ";
            String string4 = "Native-LiteAV";
            bl2 = false;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (bl3) break block16;
            CharSequence charSequence2 = new StringBuilder();
            String string5 = "load library ";
            ((StringBuilder)charSequence2).append(string5);
            ((StringBuilder)charSequence2).append((String)charSequence);
            string5 = " from path ";
            ((StringBuilder)charSequence2).append(string5);
            ((StringBuilder)charSequence2).append(string2);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            Log.w((String)string4, (String)charSequence2);
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(string2);
            string2 = "/lib";
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append((String)charSequence);
            string2 = ".so";
            ((StringBuilder)charSequence2).append(string2);
            string2 = ((StringBuilder)charSequence2).toString();
            try {
                boolean bl4;
                System.load(string2);
                bl2 = bl4 = true;
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string3);
                String string6 = exception.toString();
                ((StringBuilder)charSequence).append(string6);
                string6 = ((StringBuilder)charSequence).toString();
                Log.w((String)string4, (String)string6);
            }
            catch (Error error) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string3);
                String string7 = error.toString();
                ((StringBuilder)charSequence).append(string7);
                string7 = ((StringBuilder)charSequence).toString();
                Log.w((String)string4, (String)string7);
            }
        }
        return bl2;
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String c(Context object) {
        block6: {
            if (object != null) {
                PackageManager packageManager;
                try {
                    packageManager = object.getPackageManager();
                }
                catch (Exception exception) {}
                object = object.getPackageName();
                object = packageManager.getPackageInfo((String)object, 0);
                object = object.packageName;
                break block6;
            }
            object = "";
        }
        return object;
    }

    public static int d(Context context) {
        int n10;
        if (context == null) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        context = (TelephonyManager)context.getSystemService("phone");
        NetworkInfo networkInfo = null;
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        catch (Exception exception) {
            String string2 = "TXCSystemUtil";
            String string3 = "getNetworkType: error occurred.";
            TXCLog.e(string2, string3, exception);
        }
        if (networkInfo == null) {
            return 0;
        }
        int n11 = networkInfo.isConnected();
        if (n11 == 0) {
            return 0;
        }
        n11 = networkInfo.getType();
        if (n11 == (n10 = 9)) {
            return 5;
        }
        n11 = networkInfo.getType();
        if (n11 == (n10 = 1)) {
            return n10;
        }
        n11 = networkInfo.getType();
        if (n11 == 0) {
            int n12 = context.getNetworkType();
            switch (n12) {
                default: {
                    return 2;
                }
                case 3: 
                case 5: 
                case 6: 
                case 8: 
                case 9: 
                case 10: 
                case 12: 
                case 14: 
                case 15: {
                    return 3;
                }
                case 1: 
                case 2: 
                case 4: 
                case 7: 
                case 11: 
            }
            return 4;
        }
        return 0;
    }

    public static String d() {
        return Build.VERSION.RELEASE;
    }

    public static String e() {
        return UUID.randomUUID().toString();
    }

    public static String e(Context context) {
        String string2 = TXCDRApi.getSimulateIDFA(context);
        return TXCDRApi.getDevUUID(context, string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int f(Context object) {
        Object object2;
        int n10 = 0;
        if (object == null) {
            return 0;
        }
        String string2 = "window";
        try {
            object2 = object.getSystemService(string2);
        }
        catch (Exception exception) {
            return n10;
        }
        WindowManager windowManager = (WindowManager)object2;
        Display display = windowManager.getDefaultDisplay();
        return display.getRotation();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean f() {
        Object object = h;
        synchronized (object) {
            boolean bl2 = i;
            if (bl2) return i;
            String string2 = "txffmpeg";
            bl2 = com.tencent.liteav.basic.util.g.a(string2);
            CharSequence charSequence = "Native-LiteAV";
            CharSequence charSequence2 = new StringBuilder();
            String string3 = "load library txffmpeg ";
            charSequence2.append(string3);
            charSequence2.append(bl2);
            string2 = charSequence2.toString();
            Log.w((String)charSequence, (String)string2);
            string2 = "traeimp-rtmp";
            bl2 = com.tencent.liteav.basic.util.g.a(string2);
            charSequence = "Native-LiteAV";
            charSequence2 = new StringBuilder();
            string3 = "load library traeimp-rtmp ";
            charSequence2.append(string3);
            charSequence2.append(bl2);
            string2 = charSequence2.toString();
            Log.w((String)charSequence, (String)string2);
            string2 = "liteavsdk";
            i = bl2 = com.tencent.liteav.basic.util.g.a(string2);
            string2 = "Native-LiteAV";
            charSequence = new StringBuilder();
            charSequence2 = "load library liteavsdk ";
            ((StringBuilder)charSequence).append((String)charSequence2);
            boolean bl3 = i;
            ((StringBuilder)charSequence).append(bl3);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.w((String)string2, (String)charSequence);
            return i;
        }
    }

    public static String g() {
        return c;
    }
}

