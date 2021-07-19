/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 */
package androidx.core.app;

import android.app.Notification;
import android.support.v4.app.INotificationSideChannel;
import androidx.core.app.NotificationManagerCompat$Task;

public class NotificationManagerCompat$NotifyTask
implements NotificationManagerCompat$Task {
    public final int id;
    public final Notification notif;
    public final String packageName;
    public final String tag;

    public NotificationManagerCompat$NotifyTask(String string2, int n10, String string3, Notification notification) {
        this.packageName = string2;
        this.id = n10;
        this.tag = string3;
        this.notif = notification;
    }

    public void send(INotificationSideChannel iNotificationSideChannel) {
        String string2 = this.packageName;
        int n10 = this.id;
        String string3 = this.tag;
        Notification notification = this.notif;
        iNotificationSideChannel.notify(string2, n10, string3, notification);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
        stringBuilder.append("packageName:");
        String string2 = this.packageName;
        stringBuilder.append(string2);
        stringBuilder.append(", id:");
        int n10 = this.id;
        stringBuilder.append(n10);
        stringBuilder.append(", tag:");
        string2 = this.tag;
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

