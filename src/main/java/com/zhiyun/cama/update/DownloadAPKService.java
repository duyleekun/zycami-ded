/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.text.TextUtils
 */
package com.zhiyun.cama.update;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat$Builder;
import com.zhiyun.cama.update.DownloadAPKService$Status;
import com.zhiyun.cama.update.DownloadAPKService$a;
import com.zhiyun.cama.update.DownloadAPKService$b;
import d.v.c.v0.u.z;
import d.v.e.l.a1;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.f.i.g;

public class DownloadAPKService
extends Service {
    public static final String j = "DownloadService";
    private static final String k = "download_url";
    private final String a;
    private final int b;
    private NotificationManager c;
    private NotificationCompat$Builder d;
    private String e;
    private DownloadAPKService$Status f;
    private DownloadAPKService$b g;
    private long h;
    private int i;

    public DownloadAPKService() {
        DownloadAPKService$Status downloadAPKService$Status;
        this.a = "download_click";
        this.b = 100;
        this.f = downloadAPKService$Status = DownloadAPKService$Status.DOWNLOADING;
        this.h = 0L;
        this.i = -1;
    }

    public static /* synthetic */ String a(DownloadAPKService downloadAPKService) {
        return downloadAPKService.e;
    }

    public static /* synthetic */ long b(DownloadAPKService downloadAPKService) {
        return downloadAPKService.h;
    }

    public static /* synthetic */ long c(DownloadAPKService downloadAPKService, long l10) {
        downloadAPKService.h = l10;
        return l10;
    }

    public static /* synthetic */ int d(DownloadAPKService downloadAPKService) {
        return downloadAPKService.i;
    }

    public static /* synthetic */ int e(DownloadAPKService downloadAPKService, int n10) {
        downloadAPKService.i = n10;
        return n10;
    }

    public static /* synthetic */ DownloadAPKService$Status f(DownloadAPKService downloadAPKService) {
        return downloadAPKService.f;
    }

    public static /* synthetic */ void g(DownloadAPKService downloadAPKService, String string2) {
        downloadAPKService.n(string2);
    }

    private void h() {
        this.o();
        NotificationManager notificationManager = this.c;
        if (notificationManager != null) {
            int n10 = 100;
            notificationManager.cancel(n10);
        }
    }

    private void k(String string2, String string3, int n10) {
        NotificationChannel notificationChannel = new NotificationChannel(string2, (CharSequence)string3, n10);
        string2 = (NotificationManager)this.getSystemService("notification");
        if (string2 != null) {
            string2.createNotificationChannel(notificationChannel);
        }
    }

    private void n(String string2) {
        this.p();
        String string3 = k2.d().getAbsolutePath();
        String string4 = s1.D(string2);
        z z10 = z.m();
        DownloadAPKService$a downloadAPKService$a = new DownloadAPKService$a(this, string2, string3);
        z10.b(string3, string4, string2, downloadAPKService$a);
    }

    private void o() {
        NotificationManager notificationManager = this.c;
        if (notificationManager == null) {
            this.c = notificationManager = (NotificationManager)this.getSystemService("notification");
        }
    }

    private void q() {
        NotificationCompat$Builder notificationCompat$Builder;
        this.o();
        NotificationManager notificationManager = this.c;
        if (notificationManager != null && (notificationCompat$Builder = this.d) != null) {
            int n10 = 100;
            notificationCompat$Builder = notificationCompat$Builder.build();
            notificationManager.notify(n10, (Notification)notificationCompat$Builder);
        }
    }

    private void r() {
        DownloadAPKService$b downloadAPKService$b = this.g;
        if (downloadAPKService$b != null) {
            return;
        }
        this.g = downloadAPKService$b = new DownloadAPKService$b(this, null);
        downloadAPKService$b = new IntentFilter();
        downloadAPKService$b.addAction("download_click");
        DownloadAPKService$b downloadAPKService$b2 = this.g;
        this.registerReceiver(downloadAPKService$b2, (IntentFilter)downloadAPKService$b);
    }

    public static void w(Activity activity, String string2) {
        Bundle bundle = new Bundle();
        bundle.putString(k, string2);
        string2 = new Intent();
        string2 = string2.setClass((Context)activity, DownloadAPKService.class).putExtras(bundle);
        activity.startService((Intent)string2);
    }

    public void i() {
        NotificationCompat$Builder notificationCompat$Builder = this.d;
        if (notificationCompat$Builder != null) {
            int n10 = 2131953193;
            String string2 = d.v.f.i.g.m((Context)this, n10);
            notificationCompat$Builder.setContentText(string2);
        }
    }

    public void j() {
        Intent intent = new Intent("download_click");
        int n10 = 1;
        int n11 = 0;
        String string2 = null;
        intent = PendingIntent.getBroadcast((Context)this, (int)n10, (Intent)intent, (int)0);
        NotificationCompat$Builder notificationCompat$Builder = this.d;
        if (notificationCompat$Builder != null) {
            int n12 = 100;
            notificationCompat$Builder = notificationCompat$Builder.setProgress(n12, 0, false);
            n11 = 2131953196;
            string2 = d.v.f.i.g.m((Context)this, n11);
            notificationCompat$Builder = notificationCompat$Builder.setContentText(string2);
            notificationCompat$Builder.setContentIntent((PendingIntent)intent);
        }
    }

    public void l(int n10) {
        NotificationCompat$Builder notificationCompat$Builder = this.d;
        if (notificationCompat$Builder != null) {
            int n11 = 100;
            notificationCompat$Builder = notificationCompat$Builder.setProgress(n11, n10, false);
            StringBuilder stringBuilder = new StringBuilder();
            int n12 = 2131953194;
            int n13 = 1;
            Object[] objectArray = new Object[n13];
            String string2 = String.valueOf(n10);
            objectArray[0] = string2;
            string2 = d.v.f.i.g.n((Context)this, n12, objectArray);
            stringBuilder.append(string2);
            stringBuilder.append("%");
            string2 = stringBuilder.toString();
            notificationCompat$Builder.setContentText(string2);
        }
    }

    public void m() {
        NotificationCompat$Builder notificationCompat$Builder = this.d;
        if (notificationCompat$Builder != null) {
            int n10 = 2131953195;
            String string2 = d.v.f.i.g.m((Context)this, n10);
            notificationCompat$Builder.setContentText(string2);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        this.c = null;
        this.d = null;
        DownloadAPKService$b downloadAPKService$b = this.g;
        if (downloadAPKService$b != null) {
            this.unregisterReceiver(downloadAPKService$b);
            this.g = null;
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int n10, int n11) {
        if (intent != null) {
            DownloadAPKService$Status downloadAPKService$Status;
            this.r();
            String string2 = intent.getStringExtra(k);
            Object object = this.e;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2 || (object = DownloadAPKService$Status.FAIL) == (downloadAPKService$Status = this.f)) {
                this.e = string2;
                this.n(string2);
            }
        } else {
            this.h();
            this.stopSelf();
        }
        return super.onStartCommand(intent, n10, n11);
    }

    public void p() {
        this.t((Context)this);
    }

    public void s() {
        DownloadAPKService$Status downloadAPKService$Status;
        this.f = downloadAPKService$Status = DownloadAPKService$Status.FAIL;
        this.i();
        this.q();
    }

    public void t(Context object) {
        NotificationCompat$Builder notificationCompat$Builder;
        int n10 = Build.VERSION.SDK_INT;
        String string2 = "Update";
        int n11 = 26;
        if (n10 >= n11) {
            n10 = 3;
            this.k(string2, string2, n10);
        }
        this.d = notificationCompat$Builder = new NotificationCompat$Builder((Context)object, string2);
        int n12 = 1;
        notificationCompat$Builder = notificationCompat$Builder.setOnlyAlertOnce(n12 != 0).setOngoing(n12 != 0).setSmallIcon(2131231773);
        n12 = 2131953192;
        string2 = d.v.f.i.g.m(object, n12);
        notificationCompat$Builder.setContentTitle(string2);
        this.j();
        notificationCompat$Builder = this.d;
        if (notificationCompat$Builder != null) {
            n12 = 2131953196;
            object = d.v.f.i.g.m(object, n12);
            notificationCompat$Builder.setTicker((CharSequence)object);
            object = this.d.build();
            object.flags = n10 = 32;
            this.q();
        }
    }

    public void u(int n10) {
        DownloadAPKService$Status downloadAPKService$Status;
        this.f = downloadAPKService$Status = DownloadAPKService$Status.DOWNLOADING;
        this.l(n10);
        this.q();
    }

    public void v(String string2, String string3) {
        DownloadAPKService$Status downloadAPKService$Status;
        this.f = downloadAPKService$Status = DownloadAPKService$Status.SUCCESS;
        this.m();
        this.q();
        this.h();
        a1.b((Context)this, string2, string3);
        this.stopSelf();
    }
}

