/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.widget.RemoteViews
 */
package d.c.a.s.j;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import d.c.a.s.j.e;
import d.c.a.s.k.f;
import d.c.a.u.k;

public class l
extends e {
    private final RemoteViews d;
    private final Context e;
    private final int f;
    private final String g;
    private final Notification h;
    private final int i;

    public l(Context context, int n10, int n11, int n12, RemoteViews remoteViews, Notification notification, int n13, String string2) {
        super(n10, n11);
        this.e = context = (Context)k.e(context, "Context must not be null!");
        context = (Notification)k.e(notification, "Notification object can not be null!");
        this.h = context;
        context = (RemoteViews)k.e(remoteViews, "RemoteViews object can not be null!");
        this.d = context;
        this.i = n12;
        this.f = n13;
        this.g = string2;
    }

    public l(Context context, int n10, RemoteViews remoteViews, Notification notification, int n11) {
        this(context, n10, remoteViews, notification, n11, null);
    }

    public l(Context context, int n10, RemoteViews remoteViews, Notification notification, int n11, String string2) {
        this(context, -1 << -1, -1 << -1, n10, remoteViews, notification, n11, string2);
    }

    private void o(Bitmap bitmap) {
        RemoteViews remoteViews = this.d;
        int n10 = this.i;
        remoteViews.setImageViewBitmap(n10, bitmap);
        this.q();
    }

    private void q() {
        NotificationManager notificationManager = (NotificationManager)k.d((NotificationManager)this.e.getSystemService("notification"));
        String string2 = this.g;
        int n10 = this.f;
        Notification notification = this.h;
        notificationManager.notify(string2, n10, notification);
    }

    public void i(Drawable drawable2) {
        this.o(null);
    }

    public void n(Bitmap bitmap, f f10) {
        this.o(bitmap);
    }
}

