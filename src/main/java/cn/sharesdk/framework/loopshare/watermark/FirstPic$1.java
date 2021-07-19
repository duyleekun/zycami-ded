/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Pair
 */
package cn.sharesdk.framework.loopshare.watermark;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.sharesdk.framework.loopshare.watermark.FirstPic;
import cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener;
import cn.sharesdk.framework.loopshare.watermark.e;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;

public final class FirstPic$1
extends Thread {
    public final /* synthetic */ Context a;
    public final /* synthetic */ ReadQrImageListener b;

    public FirstPic$1(Context context, ReadQrImageListener readQrImageListener) {
        this.a = context;
        this.b = readQrImageListener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = "ShareSDK";
        int n10 = 0;
        int n11 = 1;
        try {
            Object object2;
            Object object3;
            boolean bl2 = e.b();
            if (!bl2 && !(bl2 = e.a())) {
                object3 = this.a;
                object3 = FirstPic.b((Context)object3);
            } else {
                object3 = this.a;
                object3 = FirstPic.a((Context)object3);
            }
            int n12 = -1;
            if (object3 == null) {
                object3 = this.b;
                if (object3 == null) return;
                String string2 = "\u8bfb\u53d6\u622a\u5c4f\u76f8\u518c\u56fe\u7247\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u6709\u56fe\u7247";
                Throwable throwable = new Throwable(string2);
                object3.onFailed(throwable, n12);
                return;
            }
            object3 = ((Pair)object3).second;
            object3 = (String)object3;
            NLog nLog = SSDKLog.b();
            Object object4 = new Object[n11];
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = " \u76f8\u518c\u7b2c\u4e00\u5f20\u56fe\u7247\u7684\u8def\u5f84\u4e3a: ";
            stringBuilder.append(string3);
            stringBuilder.append((String)object3);
            String string4 = stringBuilder.toString();
            object4[0] = string4;
            nLog.d(object, (Object[])object4);
            boolean bl3 = TextUtils.isEmpty((CharSequence)object3);
            if (!bl3) {
                object2 = this.a;
                ReadQrImageListener readQrImageListener = this.b;
                FirstPic.a((Context)object2, (String)object3, readQrImageListener);
            } else {
                ReadQrImageListener readQrImageListener = this.b;
                if (readQrImageListener != null) {
                    String string5 = "\u8bfb\u53d6\u76f8\u518c\u56fe\u7247\u5931\u8d25";
                    object4 = new Throwable(string5);
                    readQrImageListener.onFailed((Throwable)object4, n12);
                }
            }
            object2 = SSDKLog.b();
            Object[] objectArray = new Object[n11];
            object4 = new StringBuilder();
            String string6 = "pairPath: ";
            ((StringBuilder)object4).append(string6);
            ((StringBuilder)object4).append((String)object3);
            objectArray[0] = object3 = ((StringBuilder)object4).toString();
            ((NLog)object2).d(object, objectArray);
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[n11];
            StringBuilder stringBuilder = new StringBuilder();
            String string7 = "\u89e3\u6790\u4e8c\u7ef4\u7801\u5f02\u5e38 ";
            stringBuilder.append(string7);
            stringBuilder.append(throwable);
            String string8 = stringBuilder.toString();
            objectArray[0] = string8;
            nLog.e(object, objectArray);
            object = this.b;
            if (object == null) return;
            n10 = -3;
            object.onFailed(throwable, n10);
        }
    }
}

