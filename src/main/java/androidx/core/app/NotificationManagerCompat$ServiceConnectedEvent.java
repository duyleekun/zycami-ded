/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.os.IBinder
 */
package androidx.core.app;

import android.content.ComponentName;
import android.os.IBinder;

public class NotificationManagerCompat$ServiceConnectedEvent {
    public final ComponentName componentName;
    public final IBinder iBinder;

    public NotificationManagerCompat$ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
        this.componentName = componentName;
        this.iBinder = iBinder;
    }
}

