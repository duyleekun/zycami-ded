/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.Binder
 */
package androidx.core.app;

import android.app.Notification;
import android.os.Binder;
import android.support.v4.app.INotificationSideChannel$Stub;
import androidx.core.app.NotificationCompatSideChannelService;

public class NotificationCompatSideChannelService$NotificationSideChannelStub
extends INotificationSideChannel$Stub {
    public final /* synthetic */ NotificationCompatSideChannelService this$0;

    public NotificationCompatSideChannelService$NotificationSideChannelStub(NotificationCompatSideChannelService notificationCompatSideChannelService) {
        this.this$0 = notificationCompatSideChannelService;
    }

    public void cancel(String string2, int n10, String string3) {
        NotificationCompatSideChannelService notificationCompatSideChannelService = this.this$0;
        int n11 = Binder.getCallingUid();
        notificationCompatSideChannelService.checkPermission(n11, string2);
        long l10 = Binder.clearCallingIdentity();
        try {
            NotificationCompatSideChannelService notificationCompatSideChannelService2 = this.this$0;
            notificationCompatSideChannelService2.cancel(string2, n10, string3);
            return;
        }
        finally {
            Binder.restoreCallingIdentity((long)l10);
        }
    }

    public void cancelAll(String string2) {
        NotificationCompatSideChannelService notificationCompatSideChannelService = this.this$0;
        int n10 = Binder.getCallingUid();
        notificationCompatSideChannelService.checkPermission(n10, string2);
        long l10 = Binder.clearCallingIdentity();
        try {
            NotificationCompatSideChannelService notificationCompatSideChannelService2 = this.this$0;
            notificationCompatSideChannelService2.cancelAll(string2);
            return;
        }
        finally {
            Binder.restoreCallingIdentity((long)l10);
        }
    }

    public void notify(String string2, int n10, String string3, Notification notification) {
        NotificationCompatSideChannelService notificationCompatSideChannelService = this.this$0;
        int n11 = Binder.getCallingUid();
        notificationCompatSideChannelService.checkPermission(n11, string2);
        long l10 = Binder.clearCallingIdentity();
        try {
            NotificationCompatSideChannelService notificationCompatSideChannelService2 = this.this$0;
            notificationCompatSideChannelService2.notify(string2, n10, string3, notification);
            return;
        }
        finally {
            Binder.restoreCallingIdentity((long)l10);
        }
    }
}

