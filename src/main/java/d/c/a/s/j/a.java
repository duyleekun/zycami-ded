/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.appwidget.AppWidgetManager
 *  android.content.ComponentName
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.widget.RemoteViews
 */
package d.c.a.s.j;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import d.c.a.s.j.e;
import d.c.a.s.k.f;
import d.c.a.u.k;

public class a
extends e {
    private final int[] d;
    private final ComponentName e;
    private final RemoteViews f;
    private final Context g;
    private final int h;

    public a(Context context, int n10, int n11, int n12, RemoteViews remoteViews, ComponentName componentName) {
        super(n10, n11);
        this.g = context = (Context)k.e(context, "Context can not be null!");
        context = (RemoteViews)k.e(remoteViews, "RemoteViews object can not be null!");
        this.f = context;
        context = (ComponentName)k.e(componentName, "ComponentName can not be null!");
        this.e = context;
        this.h = n12;
        this.d = null;
    }

    public a(Context object, int n10, int n11, int n12, RemoteViews remoteViews, int ... nArray) {
        super(n10, n11);
        n10 = nArray.length;
        if (n10 != 0) {
            this.g = object = (Context)k.e(object, "Context can not be null!");
            object = (RemoteViews)k.e(remoteViews, "RemoteViews object can not be null!");
            this.f = object;
            object = (int[])k.e(nArray, "WidgetIds can not be null!");
            this.d = (int[])object;
            this.h = n12;
            this.e = null;
            return;
        }
        super("WidgetIds must have length > 0");
        throw object;
    }

    public a(Context context, int n10, RemoteViews remoteViews, ComponentName componentName) {
        this(context, -1 << -1, -1 << -1, n10, remoteViews, componentName);
    }

    public a(Context context, int n10, RemoteViews remoteViews, int ... nArray) {
        this(context, -1 << -1, -1 << -1, n10, remoteViews, nArray);
    }

    private void o(Bitmap bitmap) {
        RemoteViews remoteViews = this.f;
        int n10 = this.h;
        remoteViews.setImageViewBitmap(n10, bitmap);
        this.q();
    }

    private void q() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance((Context)this.g);
        Object object = this.e;
        if (object != null) {
            RemoteViews remoteViews = this.f;
            appWidgetManager.updateAppWidget(object, remoteViews);
        } else {
            object = this.d;
            RemoteViews remoteViews = this.f;
            appWidgetManager.updateAppWidget((int[])object, remoteViews);
        }
    }

    public void i(Drawable drawable2) {
        this.o(null);
    }

    public void n(Bitmap bitmap, f f10) {
        this.o(bitmap);
    }
}

