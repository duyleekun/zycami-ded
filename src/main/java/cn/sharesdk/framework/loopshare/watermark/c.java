/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.loopshare.watermark;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.loopshare.watermark.WaterMarkListener;
import cn.sharesdk.framework.loopshare.watermark.b;
import cn.sharesdk.framework.loopshare.watermark.c$1;
import cn.sharesdk.framework.loopshare.watermark.c$2;
import cn.sharesdk.framework.loopshare.watermark.f;
import cn.sharesdk.framework.loopshare.watermark.g;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeListener;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeService;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class c {
    public static String a;
    private static String b = "WMarkVideo";
    private static String c = "WMarkImage.jpg";
    private static String d = "outputVideo";
    private static String e = "textMark";

    public static /* synthetic */ String a() {
        return c;
    }

    public static String a(Context object, boolean n10) {
        Object[] objectArray;
        if (object != null && (objectArray = a) == null) {
            objectArray = new StringBuilder();
            object = object.getCacheDir();
            objectArray.append(object);
            objectArray.append("/");
            object = b;
            objectArray.append((String)object);
            object = objectArray.toString();
            objectArray = new File((String)object);
            int n11 = objectArray.exists();
            if (n11 == 0) {
                n11 = objectArray.mkdirs();
                String string2 = "ShareSDK";
                int n12 = 1;
                if (n11 == 0) {
                    object = SSDKLog.b();
                    Object[] objectArray2 = new Object[n12];
                    objectArray2[0] = "getPathInPackage \u5728pakage\u76ee\u5f55\u521b\u5efaCGE\u4e34\u65f6\u76ee\u5f55\u5931\u8d25!";
                    ((NLog)object).e(string2, objectArray2);
                    return null;
                }
                if (n10 != 0) {
                    String string3;
                    Object[] objectArray3;
                    NLog nLog;
                    boolean bl2;
                    n10 = Build.VERSION.SDK_INT;
                    n11 = 9;
                    if (n10 >= n11 && (bl2 = objectArray.setExecutable(n12 != 0, false))) {
                        nLog = SSDKLog.b();
                        objectArray3 = new Object[n12];
                        string3 = "getPathInPackage Package folder is executable";
                        objectArray3[0] = string3;
                        nLog.i(string2, objectArray3);
                    }
                    if (n10 >= n11 && (bl2 = objectArray.setReadable(n12 != 0, false))) {
                        nLog = SSDKLog.b();
                        objectArray3 = new Object[n12];
                        string3 = "getPathInPackage Package folder is readable";
                        objectArray3[0] = string3;
                        nLog.i(string2, objectArray3);
                    }
                    if (n10 >= n11 && (n10 = (int)(objectArray.setWritable(n12 != 0, false) ? 1 : 0)) != 0) {
                        NLog nLog2 = SSDKLog.b();
                        objectArray = new Object[n12];
                        String string4 = "getPathInPackage Package folder is writable";
                        objectArray[0] = string4;
                        nLog2.i(string2, objectArray);
                    }
                }
            }
            a = object;
            return object;
        }
        return a;
    }

    public static /* synthetic */ String a(String string2, Bitmap bitmap, Context context) {
        return cn.sharesdk.framework.loopshare.watermark.c.b(string2, bitmap, context);
    }

    public static void a(String object, String object2, String object3, String string2, WaterMarkListener waterMarkListener) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 <= n11) {
            if (waterMarkListener != null) {
                int n12 = -2;
                object2 = "The minimum version supported for this feature is 7.0";
                waterMarkListener.onFailed((String)object2, n12);
            }
            return;
        }
        Object object4 = "com.arthenica.mobileffmpeg.FFmpeg";
        try {
            Class.forName((String)object4);
            object4 = new StringBuilder();
        }
        catch (ClassNotFoundException classNotFoundException) {
            if (waterMarkListener != null) {
                int n13 = -10;
                object2 = "The specified package dependency does not exist, please make sure whether the related dependency package is pulled normally";
                waterMarkListener.onFailed((String)object2, n13);
            }
            return;
        }
        Object object5 = MobSDK.getContext();
        boolean bl2 = true;
        object5 = cn.sharesdk.framework.loopshare.watermark.c.a(object5, bl2);
        ((StringBuilder)object4).append((String)object5);
        object5 = "/";
        ((StringBuilder)object4).append((String)object5);
        String[] stringArray = d;
        ((StringBuilder)object4).append((String)stringArray);
        stringArray = ".mp4";
        ((StringBuilder)object4).append((String)stringArray);
        String string3 = ((StringBuilder)object4).toString();
        object4 = new File(string3);
        boolean n14 = ((File)object4).exists();
        if (n14) {
            ((File)object4).delete();
        }
        boolean[] blArray = new boolean[bl2];
        n10 = 0;
        object4 = null;
        blArray[0] = false;
        int n12 = 2;
        stringArray = new String[n12];
        stringArray[0] = object2;
        stringArray[bl2] = object3;
        boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl3) {
            object2 = new StringBuilder();
            object3 = cn.sharesdk.framework.loopshare.watermark.c.a(MobSDK.getContext(), bl2);
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append((String)object5);
            object3 = e;
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(".jpg");
            object2 = ((StringBuilder)object2).toString();
            object3 = new c$1(blArray, (String)object2, stringArray);
            f.a((Runnable)object3);
        } else {
            object2 = "";
        }
        Object object6 = object2;
        object2 = new QRCodeService();
        ((QRCodeService)object2).setContent((String)object);
        object = new c$2(waterMarkListener, blArray, (String)object6, string2, string3);
        ((QRCodeService)object2).generateAsync((QRCodeListener)object);
    }

    private static boolean a(String string2) {
        Object object;
        block4: {
            boolean bl2 = true;
            try {
                object = new File(string2);
                boolean bl3 = ((File)object).exists();
                if (!bl3) break block4;
                return bl2;
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[bl2];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("fileIsExist Throwable: ");
                stringBuilder.append(throwable);
                String string3 = stringBuilder.toString();
                objectArray[0] = string3;
                ((NLog)object).e("ShareSDK", objectArray);
                return false;
            }
        }
        return ((File)object).mkdirs();
    }

    public static String[] a(String charSequence, String stringArray, String object, String string2, String object2, int n10) {
        int n11;
        int n12;
        boolean bl2;
        Serializable serializable = SSDKLog.b();
        int n13 = 1;
        Object object3 = new Object[n13];
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("ffmpeg params makeVideo: textIimageUrl: ");
        charSequence2.append((String)charSequence);
        charSequence2.append(" imageUrl: ");
        charSequence2.append((String)stringArray);
        charSequence2.append(" musicUrl: ");
        charSequence2.append((String)object);
        charSequence2.append(" videoUrl: ");
        charSequence2.append(string2);
        charSequence2.append(" outputUrl: ");
        charSequence2.append((String)object2);
        charSequence2 = charSequence2.toString();
        object3[0] = charSequence2;
        charSequence2 = "LOGCAT";
        ((NLog)((Object)serializable)).d(charSequence2, object3);
        serializable = new ArrayList();
        object3 = "-i";
        ((ArrayList)serializable).add(object3);
        ((ArrayList)serializable).add(string2);
        string2 = "";
        boolean n14 = ((String)charSequence).equals(string2);
        if (!n14 || !(bl2 = stringArray.equals(string2))) {
            boolean bl3;
            String string3;
            boolean bl4 = stringArray.equals(string2);
            if (!bl4) {
                ((ArrayList)serializable).add("-loop");
                string3 = "0";
                ((ArrayList)serializable).add(string3);
                ((ArrayList)serializable).add(object3);
                ((ArrayList)serializable).add(stringArray);
            }
            if (!(bl3 = ((String)charSequence).equals(string2))) {
                ((ArrayList)serializable).add(object3);
                ((ArrayList)serializable).add(charSequence);
            }
            ((ArrayList)serializable).add("-filter_complex");
            n12 = (int)(((String)charSequence).equals(string2) ? 1 : 0);
            string3 = "[1:v]scale=";
            String string4 = ":";
            if (n12 != 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string3);
                int n15 = cn.sharesdk.framework.loopshare.watermark.b.a;
                ((StringBuilder)charSequence).append(n15);
                ((StringBuilder)charSequence).append(string4);
                n15 = cn.sharesdk.framework.loopshare.watermark.b.b;
                ((StringBuilder)charSequence).append(n15);
                stringArray = "[s];[0:v][s]overlay=0:0";
                ((StringBuilder)charSequence).append((String)stringArray);
                charSequence = ((StringBuilder)charSequence).toString();
                ((ArrayList)serializable).add(charSequence);
            } else {
                n12 = (int)(stringArray.equals(string2) ? 1 : 0);
                stringArray = "),(main_w-overlay_w)/2,NAN )':(main_h-overlay_h)/2";
                if (n12 != 0) {
                    charSequence = new StringBuilder();
                    string3 = "overlay=x='if(lte(t,";
                    ((StringBuilder)charSequence).append(string3);
                    int n16 = g.c;
                    ((StringBuilder)charSequence).append(n16);
                    ((StringBuilder)charSequence).append((String)stringArray);
                    charSequence = ((StringBuilder)charSequence).toString();
                    ((ArrayList)serializable).add(charSequence);
                } else {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string3);
                    int n17 = cn.sharesdk.framework.loopshare.watermark.b.g;
                    ((StringBuilder)charSequence).append(n17);
                    ((StringBuilder)charSequence).append(string4);
                    int n18 = cn.sharesdk.framework.loopshare.watermark.b.h;
                    ((StringBuilder)charSequence).append(n18);
                    ((StringBuilder)charSequence).append("[img1];[2:v]scale=");
                    int n19 = g.a;
                    ((StringBuilder)charSequence).append(n19);
                    ((StringBuilder)charSequence).append(string4);
                    int n20 = g.b;
                    ((StringBuilder)charSequence).append(n20);
                    string3 = "[img2];[0:v][img1]overlay=main_w-overlay_w-10:main_h-overlay_h-10[bkg];[bkg][img2]overlay=x='if(lte(t,";
                    ((StringBuilder)charSequence).append(string3);
                    int n21 = g.c;
                    ((StringBuilder)charSequence).append(n21);
                    ((StringBuilder)charSequence).append((String)stringArray);
                    charSequence = ((StringBuilder)charSequence).toString();
                    ((ArrayList)serializable).add(charSequence);
                }
            }
        }
        if ((n12 = ((String)object).equals(string2)) == 0) {
            ((ArrayList)serializable).add(object3);
            ((ArrayList)serializable).add(object);
        }
        ((ArrayList)serializable).add(object2);
        n12 = ((ArrayList)serializable).size();
        stringArray = new String[n12];
        object = null;
        for (int i10 = 0; i10 < (n11 = ((ArrayList)serializable).size()); ++i10) {
            stringArray[i10] = object2 = (String)((ArrayList)serializable).get(i10);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            string2 = stringArray[i10];
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
        }
        object = SSDKLog.b();
        object2 = new Object[n13];
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("ffmpeg command:");
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append(n12);
        charSequence = ((StringBuilder)serializable).toString();
        object2[0] = charSequence;
        ((NLog)object).d(charSequence2, (Object[])object2);
        return stringArray;
    }

    private static String b(String object, Bitmap objectArray, Context objectArray2) {
        int n10;
        Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
        objectArray2 = objectArray2.getCacheDir();
        ((StringBuilder)comparable).append(objectArray2);
        ((StringBuilder)comparable).append("/images/");
        objectArray2 = ((StringBuilder)comparable).toString();
        boolean bl2 = cn.sharesdk.framework.loopshare.watermark.c.a((String)objectArray2);
        int n11 = 1;
        String string2 = "ShareSDK";
        if (!bl2) {
            object = SSDKLog.b();
            objectArray = new Object[n11];
            objectArray[0] = "TargetPath isn't exist";
            ((NLog)object).e(string2, objectArray);
            return null;
        }
        comparable = new Comparable<StringBuilder>((String)objectArray2, (String)object);
        try {
            object = new FileOutputStream((File)comparable);
            comparable = Bitmap.CompressFormat.JPEG;
            n10 = 80;
        }
        catch (IOException iOException) {
            objectArray = SSDKLog.b();
            objectArray2 = new Object[n11];
            comparable = new Comparable<StringBuilder>();
            ((StringBuilder)comparable).append("saveBitmap IOException: ");
            ((StringBuilder)comparable).append(iOException);
            String string3 = ((StringBuilder)comparable).toString();
            objectArray2[0] = string3;
            objectArray.e(string2, objectArray2);
            return null;
        }
        objectArray.compress(comparable, n10, (OutputStream)object);
        ((OutputStream)object).flush();
        ((FileOutputStream)object).close();
        boolean bl3 = TextUtils.isEmpty((CharSequence)objectArray2);
        if (!bl3) {
            return objectArray2;
        }
        return null;
    }
}

