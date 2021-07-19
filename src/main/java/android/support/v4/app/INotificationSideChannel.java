/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.IInterface
 */
package android.support.v4.app;

import android.app.Notification;
import android.os.IInterface;

public interface INotificationSideChannel
extends IInterface {
    public void cancel(String var1, int var2, String var3);

    public void cancelAll(String var1);

    public void notify(String var1, int var2, String var3, Notification var4);
}

