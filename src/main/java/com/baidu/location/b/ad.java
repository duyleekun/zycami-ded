/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssNavigationMessage
 *  android.location.Location
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Parcelable
 */
package com.baidu.location.b;

import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcelable;
import com.baidu.location.b.ae;
import com.baidu.location.b.g;
import com.baidu.location.h.l;

public class ad {
    private static Object a;
    private static ad b;
    private HandlerThread c;
    private Handler d;
    private boolean e = false;

    static {
        Object object;
        a = object = new Object();
    }

    public static /* synthetic */ Handler a(ad ad2) {
        return ad2.d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ad a() {
        Object object = a;
        synchronized (object) {
            ad ad2 = b;
            if (ad2 != null) return b;
            b = ad2 = new ad();
            return b;
        }
    }

    public void a(GnssNavigationMessage object, long l10) {
        block9: {
            boolean bl2 = this.e;
            if (bl2 && object != null) {
                Handler handler = this.d;
                if (handler == null) break block9;
                int n10 = 11;
                handler = handler.obtainMessage(n10);
                Bundle bundle = new Bundle();
                String string2 = "gnss_navigation_message";
                bundle.putParcelable(string2, (Parcelable)object);
                object = "gps_time";
                bundle.putLong((String)object, l10);
                try {
                    handler.setData(bundle);
                    handler.sendToTarget();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public void a(Location object, int n10) {
        block11: {
            boolean bl2 = this.e;
            if (bl2 && object != null) {
                Handler handler = this.d;
                if (handler == null) break block11;
                int n11 = 1;
                handler = handler.obtainMessage(n11);
                Bundle bundle = new Bundle();
                String string2 = "loc";
                Location location = new Location(object);
                bundle.putParcelable(string2, (Parcelable)location);
                object = "satnum";
                bundle.putInt((String)object, n10);
                try {
                    handler.setData(bundle);
                    handler.sendToTarget();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public void b() {
        block5: {
            boolean bl2 = this.e;
            if (!bl2) {
                return;
            }
            Handler handler = this.d;
            if (handler == null) break block5;
            int n10 = 3;
            handler = handler.obtainMessage(n10);
            try {
                handler.sendToTarget();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void c() {
        block5: {
            boolean bl2 = this.e;
            if (!bl2) {
                return;
            }
            Handler handler = this.d;
            if (handler == null) break block5;
            int n10 = 2;
            handler = handler.obtainMessage(n10);
            try {
                handler.sendToTarget();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void d() {
        block5: {
            boolean bl2 = this.e;
            if (!bl2) {
                return;
            }
            Handler handler = this.d;
            if (handler == null) break block5;
            int n10 = 7;
            handler = handler.obtainMessage(n10);
            try {
                handler.sendToTarget();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void e() {
        block12: {
            int n10;
            Object object;
            block11: {
                boolean bl2 = this.e;
                if (bl2) {
                    return;
                }
                this.e = bl2 = true;
                object = this.c;
                if (object == null) {
                    String string2 = "LocUploadThreadManager";
                    this.c = object = new HandlerThread(string2);
                    object.start();
                    object = this.c;
                    if (object != null) {
                        string2 = this.c.getLooper();
                        object = new ae(this, (Looper)string2);
                        this.d = object;
                    }
                }
                object = this.d;
                if (object == null) break block11;
                n10 = 5;
                object = object.obtainMessage(n10);
                try {
                    object.sendToTarget();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            object = this.d;
            if (object == null) break block12;
            n10 = 4;
            int n11 = l.T;
            long l10 = n11;
            try {
                object.sendEmptyMessageDelayed(n10, l10);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void f() {
        block9: {
            Handler handler;
            block8: {
                boolean bl2 = this.e;
                if (!bl2) {
                    return;
                }
                g.a().b();
                bl2 = false;
                handler = this.d;
                if (handler == null) break block8;
                try {
                    handler.removeCallbacksAndMessages(null);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            this.d = null;
            handler = this.c;
            if (handler == null) break block9;
            handler.quit();
            handler = this.c;
            try {
                handler.interrupt();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        this.c = null;
        this.e = false;
    }
}

