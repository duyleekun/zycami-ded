/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.a$1;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;

public class a {
    public static volatile boolean a = false;
    public static String b;

    public static boolean a() {
        Object object = MobSDK.getAppkey();
        boolean bl2 = a;
        Object[] objectArray = null;
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            Object object2 = b;
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) {
                object = SSDKLog.b();
                object2 = new Object[]{};
                ((NLog)object).d("CheckAppKeyAsynchronously verify the appkey", object2);
                object = new a$1();
                ((Thread)object).start();
                return true;
            }
            object2 = SSDKLog.b();
            objectArray = new Object[]{};
            object2.d("CheckAppKeyDetermine whether successAppKey is equal to mobsdk.getappkey", objectArray);
            object2 = b;
            return ((String)object).equals(object2);
        }
        return false;
    }
}

