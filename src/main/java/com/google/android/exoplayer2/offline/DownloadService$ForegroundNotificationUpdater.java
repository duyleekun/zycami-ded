/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.exoplayer2.offline;

import android.app.Notification;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.k0.l;
import java.util.List;

public final class DownloadService$ForegroundNotificationUpdater {
    private final Handler handler;
    private boolean notificationDisplayed;
    private final int notificationId;
    private boolean periodicUpdatesStarted;
    public final /* synthetic */ DownloadService this$0;
    private final long updateInterval;

    public DownloadService$ForegroundNotificationUpdater(DownloadService downloadService, int n10, long l10) {
        this.this$0 = downloadService;
        this.notificationId = n10;
        this.updateInterval = l10;
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.handler = downloadService;
    }

    public static /* synthetic */ void a(DownloadService$ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater) {
        downloadService$ForegroundNotificationUpdater.update();
    }

    private void update() {
        List list = ((DownloadManager)Assertions.checkNotNull(DownloadService.access$200(this.this$0))).getCurrentDownloads();
        Object object = this.this$0;
        int n10 = this.notificationId;
        list = object.getForegroundNotification(list);
        object.startForeground(n10, (Notification)list);
        this.notificationDisplayed = true;
        boolean bl2 = this.periodicUpdatesStarted;
        if (bl2) {
            this.handler.removeCallbacksAndMessages(null);
            list = this.handler;
            object = new l(this);
            long l10 = this.updateInterval;
            list.postDelayed((Runnable)object, l10);
        }
    }

    public void invalidate() {
        boolean bl2 = this.notificationDisplayed;
        if (bl2) {
            this.update();
        }
    }

    public void showNotificationIfNotAlready() {
        boolean bl2 = this.notificationDisplayed;
        if (!bl2) {
            this.update();
        }
    }

    public void startPeriodicUpdates() {
        this.periodicUpdatesStarted = true;
        this.update();
    }

    public void stopPeriodicUpdates() {
        this.periodicUpdatesStarted = false;
        this.handler.removeCallbacksAndMessages(null);
    }
}

