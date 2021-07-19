/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 *  com.arthenica.mobileffmpeg.Config
 *  com.arthenica.mobileffmpeg.FFmpeg
 */
package cn.sharesdk.framework.loopshare.watermark;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.loopshare.watermark.WaterMarkListener;
import cn.sharesdk.framework.loopshare.watermark.c;
import cn.sharesdk.framework.loopshare.watermark.c$2$1;
import cn.sharesdk.framework.loopshare.watermark.d;
import cn.sharesdk.framework.loopshare.watermark.f;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.arthenica.mobileffmpeg.Config;
import com.arthenica.mobileffmpeg.FFmpeg;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import java.io.File;

public final class c$2
implements QRCodeListener {
    public final /* synthetic */ WaterMarkListener a;
    public final /* synthetic */ boolean[] b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public c$2(WaterMarkListener waterMarkListener, boolean[] blArray, String string2, String string3, String string4) {
        this.a = waterMarkListener;
        this.b = blArray;
        this.c = string2;
        this.d = string3;
        this.e = string4;
    }

    public void onError(Throwable object) {
        NLog nLog = SSDKLog.b();
        int n10 = 1;
        Object object2 = new Object[n10];
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "onError \u4e8c\u7ef4\u7801\u751f\u6210\u5931\u8d25 ";
        stringBuilder.append(string2);
        stringBuilder.append(object);
        object = stringBuilder.toString();
        stringBuilder = null;
        object2[0] = object;
        nLog.e("ShareSDK", object2);
        object = this.a;
        if (object != null) {
            int n11 = -5;
            object2 = "\u4e8c\u7ef4\u7801\u751f\u6210\u5931\u8d25";
            object.onFailed((String)object2, n11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSuccess(Bitmap object) {
        block11: {
            Object object2 = SSDKLog.b();
            int n10 = 1;
            Object object3 = new Object[n10];
            object3[0] = "onSuccess \u4e8c\u7ef4\u7801\u751f\u6210\u6210\u529f ";
            Object[] objectArray = "ShareSDK";
            ((NLog)object2).d(objectArray, (Object[])object3);
            object2 = new StringBuilder();
            object3 = cn.sharesdk.framework.loopshare.watermark.c.a();
            Context context = MobSDK.getContext();
            object = cn.sharesdk.framework.loopshare.watermark.c.a((String)object3, (Bitmap)object, context);
            ((StringBuilder)object2).append((String)object);
            object = cn.sharesdk.framework.loopshare.watermark.c.a();
            ((StringBuilder)object2).append((String)object);
            Object object4 = ((StringBuilder)object2).toString();
            int n11 = TextUtils.isEmpty((CharSequence)object4);
            if (n11 != 0 && (object = this.a) != null) {
                object.onFailed("QR code image storage failed", -9);
                return;
            }
            object = SSDKLog.b();
            object2 = new Object[n10];
            object3 = new StringBuilder();
            String string2 = "\u56fe\u7247\u4fdd\u5b58\u7684\u8def\u5f84\u4e3a: ";
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append((String)object4);
            object2[0] = object3 = ((StringBuilder)object3).toString();
            ((NLog)object).d(objectArray, (Object[])object2);
            object = this.b;
            n11 = object[0];
            if (n11 != 0) {
                object = SSDKLog.b();
                object2 = new Object[n10];
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("textMarkImage length: ");
                int n12 = this.c.length();
                ((StringBuilder)object3).append(n12);
                object2[0] = object3 = ((StringBuilder)object3).toString();
                ((NLog)object).e(objectArray, (Object[])object2);
                object = SSDKLog.b();
                object2 = new Object[n10];
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("imagePath length: ");
                n12 = ((String)object4).length();
                ((StringBuilder)object3).append(n12);
                object2[0] = object3 = ((StringBuilder)object3).toString();
                ((NLog)object).e(objectArray, (Object[])object2);
                String string3 = this.c;
                String string4 = this.d;
                String string5 = this.e;
                int n13 = 5;
                String string6 = "";
                object = cn.sharesdk.framework.loopshare.watermark.c.a(string3, (String)object4, string6, string4, string5, n13);
            } else {
                String string7 = this.d;
                String string8 = this.e;
                int n14 = 5;
                String string9 = "";
                String string10 = "";
                object = cn.sharesdk.framework.loopshare.watermark.c.a(string9, (String)object4, string10, string7, string8, n14);
            }
            n11 = FFmpeg.execute((String[])object);
            object2 = "mobile-ffmpeg";
            if (n11 == 0) {
                object3 = SSDKLog.b();
                Object[] objectArray2 = new Object[n10];
                objectArray2[0] = object4 = "Async command execution completed successfully.";
                ((NLog)object3).i(object2, objectArray2);
                object2 = SSDKLog.b();
                object3 = new Object[n10];
                String string11 = " FFmpeg \u547d\u4ee4\u884c\u6267\u884c\u5b8c\u6210...onEnd ";
                object3[0] = string11;
                ((NLog)object2).d(objectArray, (Object[])object3);
                try {
                    long l10;
                    object2 = this.e;
                    boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                    if (bl2) break block11;
                    object3 = this.e;
                    object2 = new File((String)object3);
                    long l11 = ((File)object2).length();
                    long l12 = l11 - (l10 = 0L);
                    Object object5 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object5 >= 0) {
                        cn.sharesdk.framework.loopshare.watermark.d.a((File)object2);
                        object2 = this.a;
                        if (object2 != null) {
                            object2.onEnd(n11);
                        }
                        break block11;
                    }
                    object = this.a;
                    if (object != null) {
                        object2 = "\u5408\u6210\u89c6\u9891\u5b58\u50a8\u5230\u672c\u5730\u5f02\u5e38";
                        object5 = -8;
                        object.onFailed((String)object2, (int)object5);
                    }
                    break block11;
                }
                catch (Throwable throwable) {
                    object2 = SSDKLog.b();
                    Object[] objectArray3 = new Object[n10];
                    object3 = new StringBuilder();
                    String string12 = "onEnd catch: ";
                    ((StringBuilder)object3).append(string12);
                    ((StringBuilder)object3).append(throwable);
                    objectArray3[0] = object3 = ((StringBuilder)object3).toString();
                    ((NLog)object2).e(objectArray, objectArray3);
                    object2 = this.a;
                    if (object2 != null) {
                        object = throwable.getMessage();
                        n10 = -7;
                        object2.onFailed((String)object, n10);
                    }
                    break block11;
                }
            }
            object3 = SSDKLog.b();
            objectArray = new Object[n10];
            Object[] objectArray4 = new Object[n10];
            objectArray4[0] = object4 = Integer.valueOf(n11);
            object4 = "Command execution failed with rc=%d and the output below.";
            String string13 = String.format((String)object4, objectArray4);
            objectArray[0] = string13;
            ((NLog)object3).i(object2, objectArray);
            int n15 = 4;
            Config.printLastCommandOutput((int)n15);
            object2 = this.a;
            if (object2 != null) {
                Object[] objectArray5 = new Object[n10];
                objectArray5[0] = object = Integer.valueOf(n11);
                object = String.format("Async command execution failed with rc=%d.", objectArray5);
                n10 = -6;
                object2.onFailed((String)object, n10);
            }
        }
        object = new c$2$1(this);
        f.a((Runnable)object);
    }
}

