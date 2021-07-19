/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 */
package cn.sharesdk.wechat.utils;

import android.content.ContentResolver;
import android.net.Uri;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class n {
    private static volatile n a;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static int a(ContentResolver object, Uri object2) {
        Throwable throwable222222;
        Object object3;
        int n10;
        Object object4;
        String string2;
        String string3;
        block15: {
            string3 = "WechatTools exception";
            string2 = "ShareSDK";
            object4 = SSDKLog.b();
            n10 = 1;
            object3 = new Object[n10];
            object3[0] = "getFileSize with content url";
            String string4 = "MicroMsg.SDK.Util";
            ((NLog)object4).d(string4, (Object[])object3);
            if (object != null && object2 != null) {
                block14: {
                    object4 = null;
                    object4 = object.openInputStream((Uri)object2);
                    if (object4 != null) break block14;
                    if (object4 == null) return 0;
                    try {
                        ((InputStream)object4).close();
                        return 0;
                    }
                    catch (IOException iOException) {
                        object2 = SSDKLog.b();
                        object4 = new Object[n10];
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(string3);
                        stringBuilder.append(iOException);
                        String string5 = stringBuilder.toString();
                        object4[0] = string5;
                        ((NLog)object2).d(string2, (Object[])object4);
                    }
                    return 0;
                }
                int n11 = ((InputStream)object4).available();
                if (object4 == null) return n11;
                try {
                    ((InputStream)object4).close();
                    return n11;
                }
                catch (IOException iOException) {
                    object4 = SSDKLog.b();
                    Object[] objectArray = new Object[n10];
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append(string3);
                    ((StringBuilder)object3).append(iOException);
                    String string6 = ((StringBuilder)object3).toString();
                    objectArray[0] = string6;
                    ((NLog)object4).d(string2, objectArray);
                }
                return n11;
            }
            object = SSDKLog.b();
            object2 = new Object[n10];
            object2[0] = "getFileSize fail, resolver or uri is null";
            ((NLog)object).d(string4, (Object[])object2);
            return 0;
            {
                catch (Throwable throwable222222) {
                    break block15;
                }
                catch (Exception exception) {}
                {
                    object2 = SSDKLog.b();
                    object3 = new Object[n10];
                    StringBuilder stringBuilder = new StringBuilder();
                    String string7 = "getFileSize fail, ";
                    stringBuilder.append(string7);
                    String string8 = exception.getMessage();
                    stringBuilder.append(string8);
                    string8 = stringBuilder.toString();
                    object3[0] = string8;
                    ((NLog)object2).d(string4, (Object[])object3);
                    if (object4 == null) return 0;
                }
                try {
                    ((InputStream)object4).close();
                    return 0;
                }
                catch (IOException iOException) {
                    object2 = SSDKLog.b();
                    object4 = new Object[n10];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    stringBuilder.append(iOException);
                    String string9 = stringBuilder.toString();
                    object4[0] = string9;
                    ((NLog)object2).d(string2, (Object[])object4);
                }
                return 0;
            }
        }
        if (object4 == null) throw throwable222222;
        try {
            ((InputStream)object4).close();
            throw throwable222222;
        }
        catch (IOException iOException) {
            object4 = SSDKLog.b();
            Object[] objectArray = new Object[n10];
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append(iOException);
            String string10 = ((StringBuilder)object3).toString();
            objectArray[0] = string10;
            ((NLog)object4).d(string2, objectArray);
        }
        throw throwable222222;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static n a() {
        Object object = a;
        if (object != null) return a;
        object = n.class;
        synchronized (object) {
            n n10 = a;
            if (n10 != null) return a;
            a = n10 = new n();
            return a;
        }
    }

    public int a(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            Object object = new File(string2);
            boolean bl2 = ((File)object).exists();
            if (!bl2) {
                object = MobSDK.getContext();
                if (object != null && (n10 = (int)(string2.startsWith((String)(object = "content")) ? 1 : 0)) != 0) {
                    try {
                        object = MobSDK.getContext();
                    }
                    catch (Exception exception) {}
                    object = object.getContentResolver();
                    string2 = Uri.parse((String)string2);
                    return n.a((ContentResolver)object, (Uri)string2);
                }
                return 0;
            }
            return (int)((File)object).length();
        }
        return 0;
    }
}

