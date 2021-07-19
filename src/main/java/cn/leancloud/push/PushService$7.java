/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package cn.leancloud.push;

import android.content.Context;
import android.content.Intent;
import cn.leancloud.AVLogger;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.push.PushService;

public final class PushService$7
implements Runnable {
    public final /* synthetic */ Class val$cls;
    public final /* synthetic */ Context val$context;

    public PushService$7(Context context, Class clazz) {
        this.val$context = context;
        this.val$cls = clazz;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        AVLogger aVLogger = PushService.access$000();
        Object object = "Start service";
        aVLogger.d((String)object);
        try {
            object = this.val$context;
            Object object2 = PushService.class;
            aVLogger = new Intent((Context)object, object2);
            object = "AV_APPLICATION_ID";
            object2 = AVOSCloud.getApplicationId();
            aVLogger.putExtra((String)object, (String)object2);
            object = this.val$cls;
            if (object != null) {
                object2 = "AV_DEFAULT_CALLBACK";
                object = ((Class)object).getName();
                aVLogger.putExtra((String)object2, (String)object);
            }
            object = this.val$context;
            object.startService((Intent)aVLogger);
            return;
        }
        catch (Exception exception) {
            object = PushService.access$000();
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "failed to start PushService. cause: ";
            stringBuilder.append(string2);
            String string3 = exception.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            ((AVLogger)object).e(string3);
        }
    }
}

