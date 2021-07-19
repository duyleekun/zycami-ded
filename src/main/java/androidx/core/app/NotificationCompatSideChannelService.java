/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.IBinder
 */
package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompatSideChannelService$NotificationSideChannelStub;

public abstract class NotificationCompatSideChannelService
extends Service {
    public abstract void cancel(String var1, int var2, String var3);

    public abstract void cancelAll(String var1);

    public void checkPermission(int n10, String string2) {
        for (String string3 : this.getPackageManager().getPackagesForUid(n10)) {
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NotificationSideChannelService: Uid ");
        stringBuilder.append(n10);
        stringBuilder.append(" is not authorized for package ");
        stringBuilder.append(string2);
        String string4 = stringBuilder.toString();
        SecurityException securityException = new SecurityException(string4);
        throw securityException;
    }

    public abstract void notify(String var1, int var2, String var3, Notification var4);

    public IBinder onBind(Intent object) {
        boolean n10 = ((String)(object = object.getAction())).equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL");
        if (n10) {
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 19;
            if (n11 > n12) {
                return null;
            }
            object = new NotificationCompatSideChannelService$NotificationSideChannelStub(this);
            return object;
        }
        return null;
    }
}

