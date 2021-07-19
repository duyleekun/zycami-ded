/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.Intent
 */
package d.v.c.o1;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import cn.leancloud.AVInstallation;
import cn.leancloud.push.PushService;
import com.zhiyun.cama.push.CustomPushReceiver;
import d.v.c.o1.a;
import d.v.c.o1.b$a;
import e.a.g0;
import e.a.h0;
import e.a.z;

public class b {
    private static int a;

    public static void a(Activity activity) {
        d.v.t.b.a(activity);
    }

    public static int b() {
        return a;
    }

    public static void c(Context object, Class object2, int n10, Class clazz) {
        a = n10;
        PushService.setDefaultChannelId(object.getApplicationContext(), "Lightollector");
        PushService.setDefaultPushCallback((Context)object, (Class)object2);
        CustomPushReceiver.e(clazz);
        object = AVInstallation.getCurrentInstallation().saveInBackground();
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((h0)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((h0)object2);
        object2 = new b$a();
        ((z)object).subscribe((g0)object2);
        object = d.v.e.b.i();
        object2 = d.v.c.o1.a.a;
        ((d.v.e.b)object).p((d.v.e.b$a)object2);
    }

    public static void d(Application application) {
        d.v.t.b.e(application, false, true);
    }

    public static /* synthetic */ void e(Activity activity) {
        b.f(activity.getApplicationContext());
    }

    public static void f(Context context) {
        Class<PushService> clazz = PushService.class;
        Intent intent = new Intent(context, clazz);
        try {
            context.startService(intent);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

