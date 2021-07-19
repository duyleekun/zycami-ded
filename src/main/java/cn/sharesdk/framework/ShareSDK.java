/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 */
package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Service;
import cn.sharesdk.framework.i;
import cn.sharesdk.framework.loopshare.LoopSharePasswordListener;
import cn.sharesdk.framework.loopshare.LoopShareResultListener;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener;
import cn.sharesdk.framework.loopshare.watermark.WaterMarkListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.commons.ForbThrowable;
import com.mob.commons.dialog.PolicyThrowable;
import com.mob.tools.log.NLog;
import java.util.HashMap;

public class ShareSDK {
    public static final String SDK_TAG = "SHARESDK";
    public static final int SDK_VERSION_CODE = 0;
    public static final String SDK_VERSION_NAME = "3.8.4";
    public static final String SHARESDK_MOBLINK_RESTORE = "sharesdk_moblink_restore";
    private static i a;
    private static boolean b = true;

    static {
        Object object = "\\.";
        String[] stringArray = SDK_VERSION_NAME.split((String)object);
        int n10 = stringArray.length;
        Object[] objectArray = null;
        String string2 = null;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = stringArray[i10];
            n11 *= 100;
            int n12 = Integer.parseInt(string3);
            n11 += n12;
        }
        SDK_VERSION_CODE = n11;
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            objectArray = new Object[]{};
            string2 = "ShareSDK static main catch ";
            ((NLog)object).d(throwable, (Object)string2, objectArray);
        }
    }

    public static String a(int n10, String string2) {
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string3 = "ShareSDK getNetworkDevinfo catch ";
            nLog.d(throwable, (Object)string3, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            return i10.a(n10, string2);
        }
        return null;
    }

    public static String a(Bitmap bitmap) {
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string2 = "ShareSDK uploadImageToFileServer catch ";
            nLog.d(throwable, (Object)string2, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            return i10.a(bitmap);
        }
        return null;
    }

    public static String a(String string2) {
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string3 = "ShareSDK uploadImageToFileServer catch: ";
            nLog.d(throwable, (Object)string3, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            return i10.c(string2);
        }
        return null;
    }

    public static String a(String string2, boolean bl2, int n10, String string3) {
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string4 = "ShareSDK getShortLink catch ";
            nLog.d(throwable, (Object)string4, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            return i10.a(string2, bl2, n10, string3);
        }
        return null;
    }

    public static void a(int n10, int n11) {
        block3: {
            ShareSDK.d();
            Object[] objectArray = a;
            if (objectArray == null) break block3;
            try {
                objectArray.a(n10, n11);
            }
            catch (Throwable throwable) {
                NLog nLog = SSDKLog.b();
                objectArray = new Object[]{};
                String string2 = "ShareSDK copyNetworkDevinfo catch ";
                nLog.d(throwable, (Object)string2, objectArray);
            }
        }
    }

    public static void a(String string2, String object) {
        block3: {
            ShareSDK.d();
            Object[] objectArray = a;
            if (objectArray == null) break block3;
            try {
                objectArray.a(string2, (String)object);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                objectArray = new Object[]{};
                String string3 = "ShareSDK copyDevinfo ";
                ((NLog)object).d(throwable, (Object)string3, objectArray);
            }
        }
    }

    public static boolean a() {
        boolean bl2 = false;
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string2 = "ShareSDK isNetworkDevinfoRequested is catch ";
            nLog.d(throwable, (Object)string2, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            bl2 = i10.h();
        }
        return bl2;
    }

    public static boolean b() {
        ShareSDK.d();
        i i10 = a;
        if (i10 != null) {
            return i10.i();
        }
        return false;
    }

    private static boolean c() {
        int n10 = MobSDK.isForb();
        if (n10 == 0) {
            int n11;
            int n12;
            n10 = MobSDK.isAuth();
            if (n10 != (n12 = 1) && n10 != (n11 = 2)) {
                PolicyThrowable policyThrowable = new PolicyThrowable();
                throw policyThrowable;
            }
            return n12 != 0;
        }
        ForbThrowable forbThrowable = new ForbThrowable();
        throw forbThrowable;
    }

    public static void closeDebug() {
        b = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void d() {
        Class<ShareSDK> clazz = ShareSDK.class;
        synchronized (clazz) {
            ShareSDK.c();
            i i10 = a;
            if (i10 == null) {
                i10 = new i();
                i10.e();
                a = i10;
            }
            return;
        }
    }

    public static void deleteCache() {
        block3: {
            ShareSDK.d();
            i i10 = a;
            if (i10 == null) break block3;
            try {
                i10.j();
            }
            catch (Throwable throwable) {
                NLog nLog = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                String string2 = "ShareSDK deleteCache catch ";
                nLog.d(throwable, (Object)string2, objectArray);
            }
        }
    }

    public static Activity getAuthActivity() {
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string2 = "ShareSDK getAuthActivity catch ";
            nLog.d(throwable, (Object)string2, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            return i10.a();
        }
        return null;
    }

    public static HashMap getCustomDataFromLoopShare() {
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string2 = "ShareSDK getCustomDataFromLoopShare catch ";
            nLog.d(throwable, (Object)string2, objectArray);
        }
        HashMap hashMap = a;
        if (hashMap != null) {
            return ((i)((Object)hashMap)).d();
        }
        hashMap = new HashMap();
        return hashMap;
    }

    public static String getDevinfo(String string2, String string3) {
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string4 = "ShareSDK getDevinfo catch ";
            nLog.d(throwable, (Object)string4, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            return i10.b(string2, string3);
        }
        return null;
    }

    public static boolean getEnableAuthTag() {
        boolean bl2 = false;
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string2 = "ShareSDK getEnableAuthTag catch";
            nLog.d(throwable, (Object)string2, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            bl2 = i10.c();
        }
        return bl2;
    }

    public static void getFirstQrImage(Context context, ReadQrImageListener readQrImageListener) {
        block3: {
            ShareSDK.d();
            i i10 = a;
            if (i10 == null) break block3;
            try {
                i10.a(context, readQrImageListener);
            }
            catch (Throwable throwable) {
                if (readQrImageListener == null) break block3;
                int n10 = -1;
                readQrImageListener.onFailed(throwable, n10);
            }
        }
    }

    public static Platform getPlatform(String string2) {
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string3 = "ShareSDK ensureInit getPlatform catch";
            nLog.d(throwable, (Object)string3, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            return i10.a(string2);
        }
        return null;
    }

    public static Platform[] getPlatformList() {
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string2 = "ShareSDK getPlatformList catch ";
            nLog.d(throwable, (Object)string2, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            return i10.f();
        }
        return null;
    }

    public static Bitmap getQRCodeBitmap(String string2, int n10, int n11) {
        ShareSDK.d();
        i i10 = a;
        if (i10 != null) {
            return i10.a(string2, n10, n11);
        }
        return null;
    }

    public static Service getService(Class clazz) {
        ShareSDK.d();
        i i10 = a;
        if (i10 != null) {
            return i10.c(clazz);
        }
        return null;
    }

    public static boolean isDebug() {
        return b;
    }

    public static boolean isFBInstagram() {
        Object object;
        boolean bl2 = false;
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "ShareSDK isFBInstagram catch: ";
            objectArray.append(string2);
            objectArray.append(throwable);
            object = objectArray.toString();
            objectArray = new Object[]{};
            nLog.d(object, objectArray);
        }
        object = a;
        if (object != null) {
            bl2 = ((i)object).b();
        }
        return bl2;
    }

    public static boolean isRemoveCookieOnAuthorize() {
        Object object;
        boolean bl2 = false;
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "ShareSDK isRemoveCookieOnAuthorize catch: ";
            objectArray.append(string2);
            objectArray.append(throwable);
            object = objectArray.toString();
            objectArray = new Object[]{};
            nLog.d(object, objectArray);
        }
        object = a;
        if (object != null) {
            bl2 = ((i)object).g();
        }
        return bl2;
    }

    public static void logApiEvent(String string2, int n10) {
        block3: {
            ShareSDK.d();
            Object[] objectArray = a;
            if (objectArray == null) break block3;
            try {
                objectArray.a(string2, n10);
            }
            catch (Throwable throwable) {
                NLog nLog = SSDKLog.b();
                objectArray = new Object[]{};
                String string3 = "ShareSDK logApiEvent catch ";
                nLog.d(throwable, (Object)string3, objectArray);
            }
        }
    }

    public static void logDemoEvent(int n10, Platform object) {
        block3: {
            ShareSDK.d();
            Object[] objectArray = a;
            if (objectArray == null) break block3;
            try {
                objectArray.a(n10, (Platform)object);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                objectArray = new Object[]{};
                String string2 = "ShareSDK logDemoEvent catch ";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
            }
        }
    }

    public static void makeVideoWaterMark(String string2, String string3, String string4, String string5, WaterMarkListener waterMarkListener) {
        block3: {
            ShareSDK.d();
            i i10 = a;
            if (i10 == null) break block3;
            try {
                i10.a(string2, string3, string4, string5, waterMarkListener);
            }
            catch (Throwable throwable) {
                if (waterMarkListener == null) break block3;
                String string6 = throwable.getMessage();
                int n10 = -1;
                waterMarkListener.onFailed(string6, n10);
            }
        }
    }

    public static void mobLinkGetMobID(HashMap hashMap, MoblinkActionListener moblinkActionListener) {
        block3: {
            ShareSDK.d();
            i i10 = a;
            if (i10 == null) break block3;
            try {
                i10.a(hashMap, moblinkActionListener);
            }
            catch (Throwable throwable) {
                if (moblinkActionListener == null) break block3;
                moblinkActionListener.onError(throwable);
            }
        }
    }

    public static String platformIdToName(int n10) {
        Object object;
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "ShareSDK platformIdToName catch: ";
            objectArray.append(string2);
            objectArray.append(throwable);
            object = objectArray.toString();
            objectArray = new Object[]{};
            nLog.d(object, objectArray);
        }
        object = a;
        if (object != null) {
            return ((i)object).c(n10);
        }
        return null;
    }

    public static int platformNameToId(String string2) {
        try {
            ShareSDK.d();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            String string3 = "ShareSDK platformNameToId catch ";
            nLog.d(throwable, (Object)string3, objectArray);
        }
        i i10 = a;
        if (i10 != null) {
            return i10.b(string2);
        }
        return -1;
    }

    public static void prepareLoopShare(LoopShareResultListener loopShareResultListener) {
        block3: {
            ShareSDK.d();
            i i10 = a;
            if (i10 == null) break block3;
            try {
                i10.a(loopShareResultListener);
            }
            catch (Throwable throwable) {
                if (loopShareResultListener == null) break block3;
                loopShareResultListener.onError(throwable);
            }
        }
    }

    public static void preparePassWord(HashMap hashMap, String string2, LoopSharePasswordListener loopSharePasswordListener) {
        block3: {
            ShareSDK.d();
            i i10 = a;
            if (i10 == null) break block3;
            try {
                i10.a(hashMap, string2, loopSharePasswordListener);
            }
            catch (Throwable throwable) {
                if (loopSharePasswordListener == null) break block3;
                loopSharePasswordListener.onError(throwable);
            }
        }
    }

    public static void readPassWord(boolean bl2, LoopSharePasswordListener loopSharePasswordListener) {
        block3: {
            ShareSDK.d();
            i i10 = a;
            if (i10 == null) break block3;
            try {
                i10.a(bl2, loopSharePasswordListener);
            }
            catch (Throwable throwable) {
                if (loopSharePasswordListener == null) break block3;
                loopSharePasswordListener.onError(throwable);
            }
        }
    }

    public static void registerPlatform(Class clazz) {
        ShareSDK.d();
        i i10 = a;
        if (i10 != null) {
            i10.d(clazz);
        }
    }

    public static void registerService(Class clazz) {
        block3: {
            ShareSDK.d();
            Object object = a;
            if (object == null) break block3;
            try {
                ((i)object).a(clazz);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                String string2 = "ShareSDK  registerService catch ";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
            }
        }
    }

    public static void removeCookieOnAuthorize(boolean bl2) {
        block3: {
            ShareSDK.d();
            Object object = a;
            if (object == null) break block3;
            try {
                ((i)object).c(bl2);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                String string2 = "ShareSDK removeCookieOnAuthorize catch ";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
            }
        }
    }

    public static void setActivity(Activity activity) {
        block3: {
            ShareSDK.d();
            Object object = a;
            if (object == null) break block3;
            try {
                ((i)object).a(activity);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                String string2 = "ShareSDK setActivity is catch ";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
            }
        }
    }

    public static void setConnTimeout(int n10) {
        block3: {
            ShareSDK.d();
            Object object = a;
            if (object == null) break block3;
            try {
                ((i)object).a(n10);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                String string2 = "ShareSDK setConnTimeout catch";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
            }
        }
    }

    public static void setEnableAuthTag(boolean bl2) {
        block3: {
            ShareSDK.d();
            Object object = a;
            if (object == null) break block3;
            try {
                ((i)object).b(bl2);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                String string2 = "ShareSDK setEnableAuthTag catch";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
            }
        }
    }

    public static void setFBInstagram(boolean bl2) {
        block3: {
            ShareSDK.d();
            Object object = a;
            if (object == null) break block3;
            try {
                ((i)object).a(bl2);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                String string2 = "ShareSDK setFBInstagram catch ";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
            }
        }
    }

    public static void setPlatformDevInfo(String string2, HashMap object) {
        block3: {
            ShareSDK.d();
            Object[] objectArray = a;
            if (objectArray == null) break block3;
            try {
                objectArray.a(string2, (HashMap)object);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                objectArray = new Object[]{};
                String string3 = "ShareSDK setPlatformDevInfo catch ";
                ((NLog)object).d(throwable, (Object)string3, objectArray);
            }
        }
    }

    public static void setReadTimeout(int n10) {
        block3: {
            ShareSDK.d();
            Object object = a;
            if (object == null) break block3;
            try {
                ((i)object).b(n10);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                String string2 = "ShareSDK setReadTimeout catch";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
            }
        }
    }

    public static void unregisterPlatform(Class clazz) {
        ShareSDK.d();
        i i10 = a;
        if (i10 != null) {
            i10.e(clazz);
        }
    }

    public static void unregisterService(Class clazz) {
        block3: {
            ShareSDK.d();
            Object object = a;
            if (object == null) break block3;
            try {
                ((i)object).b(clazz);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                String string2 = "ShareSDK  unregisterService catch ";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
            }
        }
    }
}

