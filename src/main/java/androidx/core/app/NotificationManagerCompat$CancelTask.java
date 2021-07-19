/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.app;

import android.support.v4.app.INotificationSideChannel;
import androidx.core.app.NotificationManagerCompat$Task;

public class NotificationManagerCompat$CancelTask
implements NotificationManagerCompat$Task {
    public final boolean all;
    public final int id;
    public final String packageName;
    public final String tag;

    public NotificationManagerCompat$CancelTask(String string2) {
        this.packageName = string2;
        this.id = 0;
        this.tag = null;
        this.all = true;
    }

    public NotificationManagerCompat$CancelTask(String string2, int n10, String string3) {
        this.packageName = string2;
        this.id = n10;
        this.tag = string3;
        this.all = false;
    }

    public void send(INotificationSideChannel iNotificationSideChannel) {
        boolean bl2 = this.all;
        if (bl2) {
            String string2 = this.packageName;
            iNotificationSideChannel.cancelAll(string2);
        } else {
            String string3 = this.packageName;
            int n10 = this.id;
            String string4 = this.tag;
            iNotificationSideChannel.cancel(string3, n10, string4);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CancelTask[");
        stringBuilder.append("packageName:");
        String string2 = this.packageName;
        stringBuilder.append(string2);
        stringBuilder.append(", id:");
        int bl2 = this.id;
        stringBuilder.append(bl2);
        stringBuilder.append(", tag:");
        string2 = this.tag;
        stringBuilder.append(string2);
        stringBuilder.append(", all:");
        boolean bl3 = this.all;
        stringBuilder.append(bl3);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

