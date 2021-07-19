/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 */
package androidx.core.app;

import android.content.ComponentName;
import android.support.v4.app.INotificationSideChannel;
import java.util.ArrayDeque;

public class NotificationManagerCompat$SideChannelManager$ListenerRecord {
    public boolean bound = false;
    public final ComponentName componentName;
    public int retryCount;
    public INotificationSideChannel service;
    public ArrayDeque taskQueue;

    public NotificationManagerCompat$SideChannelManager$ListenerRecord(ComponentName componentName) {
        ArrayDeque arrayDeque;
        this.taskQueue = arrayDeque = new ArrayDeque();
        this.retryCount = 0;
        this.componentName = componentName;
    }
}

