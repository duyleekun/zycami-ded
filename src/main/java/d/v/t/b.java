/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package d.v.t;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import cn.leancloud.AVLogger$Level;
import cn.leancloud.AVOPPOPushAdapter;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.oppo.AVMixPushManager;
import com.zhiyun.common.util.RomUtils;
import d.r.a.d;
import d.v.t.b$a;
import m.a.a;

public class b {
    private static final String a = "PUSH_HMS_PROFILE";
    private static final String b = "PUSH_MI_APP_ID";
    private static final String c = "PUSH_MI_APP_KEY";
    private static final String d = "PUSH_MI_PROFILE";
    private static final String e = "PUSH_OPPO_APP_KEY";
    private static final String f = "PUSH_OPPO_APP_SECRET";
    private static final String g = "PUSH_OPPO_PROFILE";
    private static final String h = "PUSH_VIVO_PROFILE";
    private static final String i = "2bcK6NAJvoNEw8e8GqtFrT4r-gzGzoHsz";
    private static final String j = "PLLxcAN5hUORwRaGHPBCASKg";
    private static final String k = "FbxQwaGlWrU6JMbvqbYiUGpo-gzGzoHsz";
    private static final String l = "lffhc4enOaWpWCuBUwuEvKRJ";
    private static final String m = "https://api.zyplay.zhiyun-tech.com";
    private static final String n = "https://api.zyplaytest.zhiyun-tech.com";

    public static void a(Activity activity) {
        cn.leancloud.hms.AVMixPushManager.connectHMS(activity);
    }

    private static void b(boolean bl2, Context context) {
        String string2 = bl2 ? k : i;
        String string3 = bl2 ? l : j;
        String string4 = bl2 ? n : m;
        if (bl2) {
            AVLogger$Level aVLogger$Level = AVLogger$Level.DEBUG;
            AVOSCloud.setLogLevel(aVLogger$Level);
        }
        cn.leancloud.AVOSCloud.initialize(context, string2, string3, string4);
    }

    private static void c(Application application, Bundle object) {
        object = object.getString(a);
        cn.leancloud.hms.AVMixPushManager.registerHMSPush(application, (String)object);
    }

    private static void d(Context context, Bundle object) {
        String string2 = object.getString(e);
        String string3 = object.getString(f);
        object = object.getString(g);
        AVOPPOPushAdapter aVOPPOPushAdapter = new AVOPPOPushAdapter();
        AVMixPushManager.registerOppoPush(context, string2, string3, (String)object, aVOPPOPushAdapter);
    }

    public static void e(Application application, boolean bl2, boolean bl3) {
        PackageManager packageManager = application.getPackageManager();
        String string2 = application.getPackageName();
        int n10 = 128;
        packageManager = packageManager.getApplicationInfo(string2, n10);
        try {
            packageManager = packageManager.metaData;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            if (bl2) {
                nameNotFoundException.printStackTrace();
            }
            packageManager = null;
        }
        if (packageManager == null) {
            return;
        }
        d.v.t.b.b(bl2, (Context)application);
        if (!bl3) {
            d.v.t.b.c(application, (Bundle)packageManager);
            d.v.t.b.g((Context)application, (Bundle)packageManager);
            d.v.t.b.d((Context)application, (Bundle)packageManager);
            d.v.t.b.f(application, (Bundle)packageManager);
            return;
        }
        bl2 = RomUtils.m();
        if (bl2) {
            d.v.t.b.c(application, (Bundle)packageManager);
            return;
        }
        bl2 = RomUtils.A();
        if (bl2) {
            d.v.t.b.g((Context)application, (Bundle)packageManager);
            return;
        }
        bl2 = RomUtils.u();
        if (bl2) {
            d.v.t.b.d((Context)application, (Bundle)packageManager);
            return;
        }
        bl2 = RomUtils.z();
        if (bl2) {
            d.v.t.b.f(application, (Bundle)packageManager);
        }
    }

    private static void f(Application object, Bundle objectArray) {
        objectArray = objectArray.getString(h);
        boolean bl2 = cn.leancloud.vivo.AVMixPushManager.registerVIVOPush((Application)object, (String)objectArray);
        int n10 = 1;
        Object[] objectArray2 = new Object[n10];
        object = bl2;
        objectArray2[0] = object;
        m.a.a.b("vivo push init %s", objectArray2);
        object = new b$a();
        cn.leancloud.vivo.AVMixPushManager.turnOnVIVOPush((AVCallback)object);
        object = d.r.a.d.f(cn.leancloud.AVOSCloud.getContext()).g();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            objectArray = new Object[n10];
            objectArray[0] = object;
            object = "vivo push turn on success %s";
            m.a.a.b((String)object, objectArray);
        } else {
            object = new Object[]{};
            objectArray = "vivo push turn on failed";
            m.a.a.b((String)objectArray, object);
        }
    }

    private static void g(Context context, Bundle object) {
        String string2 = object.getString(b);
        String string3 = object.getString(c);
        object = object.getString(d);
        cn.leancloud.mi.AVMixPushManager.registerXiaomiPush(context, string2, string3, (String)object);
    }
}

