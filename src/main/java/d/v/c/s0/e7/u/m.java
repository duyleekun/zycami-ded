/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.hardware.display.VirtualDisplay
 *  android.hardware.display.VirtualDisplay$Callback
 *  android.media.projection.MediaProjection
 *  android.media.projection.MediaProjection$Callback
 *  android.media.projection.MediaProjectionManager
 *  android.util.DisplayMetrics
 *  android.util.Size
 *  android.view.Surface
 *  android.view.WindowManager
 */
package d.v.c.s0.e7.u;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.Surface;
import android.view.WindowManager;
import d.v.c.s0.e7.u.m$a;
import d.v.c.s0.e7.u.m$b;

public class m {
    private final Context a;
    private final MediaProjectionManager b;
    private final Size c;
    private final int d;
    private MediaProjection e;
    private VirtualDisplay f;
    private m$b g;
    private final m$b h;

    public m(Context context, int n10) {
        Size size;
        m$a m$a = new m$a(this);
        this.h = m$a;
        this.a = context;
        this.d = n10;
        this.c = size = this.h();
        context = (MediaProjectionManager)context.getSystemService(MediaProjectionManager.class);
        this.b = context;
    }

    public static /* synthetic */ m$b a(m m10) {
        return m10.g;
    }

    private DisplayMetrics b() {
        WindowManager windowManager = (WindowManager)this.a.getSystemService(WindowManager.class);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int n10 = displayMetrics.widthPixels;
        int n11 = this.d;
        displayMetrics.widthPixels = n10 /= n11;
        displayMetrics.heightPixels = n10 = displayMetrics.heightPixels / n11;
        return displayMetrics;
    }

    public static MediaProjectionManager d(Context context) {
        return (MediaProjectionManager)context.getSystemService(MediaProjectionManager.class);
    }

    private Size h() {
        DisplayMetrics displayMetrics = this.b();
        int n10 = displayMetrics.widthPixels;
        int n11 = displayMetrics.heightPixels;
        if (n10 > n11) {
            Size size = new Size(n11, n10);
            return size;
        }
        Size size = new Size(n10, n11);
        return size;
    }

    public Intent c() {
        return this.b.createScreenCaptureIntent();
    }

    public Size e() {
        return this.c;
    }

    public Size f() {
        DisplayMetrics displayMetrics = this.b();
        int n10 = displayMetrics.widthPixels;
        int n11 = displayMetrics.heightPixels;
        Size size = new Size(n10, n11);
        return size;
    }

    public Size g() {
        Object object = this.f;
        if (object != null) {
            object = object.getDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            object.getRealMetrics(displayMetrics);
            int n10 = displayMetrics.widthPixels;
            int n11 = displayMetrics.heightPixels;
            object = new Size(n10, n11);
            return object;
        }
        object = new IllegalStateException("Must be after start()");
        throw object;
    }

    public boolean i() {
        boolean bl2;
        MediaProjection mediaProjection = this.e;
        if (mediaProjection != null) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaProjection = null;
        }
        return bl2;
    }

    public void j(int n10, Intent intent) {
        MediaProjection mediaProjection;
        this.e = mediaProjection = this.b.getMediaProjection(n10, intent);
    }

    public void k(MediaProjection.Callback object) {
        MediaProjection mediaProjection = this.e;
        if (mediaProjection != null) {
            mediaProjection.registerCallback(object, null);
            return;
        }
        object = new IllegalStateException("Must be after prepare()");
        throw object;
    }

    public void l(Size object, int n10, Surface surface) {
        VirtualDisplay virtualDisplay = this.f;
        if (virtualDisplay != null) {
            int n11 = object.getWidth();
            int n12 = object.getHeight();
            this.f.resize(n11, n12, n10);
            this.f.setSurface(surface);
            return;
        }
        object = new IllegalStateException("Must be after start()");
        throw object;
    }

    public void m(Surface object) {
        VirtualDisplay virtualDisplay = this.f;
        if (virtualDisplay != null) {
            virtualDisplay = this.b();
            int n10 = virtualDisplay.widthPixels;
            int n11 = virtualDisplay.heightPixels;
            int n12 = virtualDisplay.densityDpi;
            this.f.resize(n10, n11, n12);
            this.f.setSurface(object);
            return;
        }
        object = new IllegalStateException("Must be after start()");
        throw object;
    }

    public void n(m$b m$b) {
        this.g = m$b;
    }

    public void o(Size object, int n10, Surface surface) {
        MediaProjection mediaProjection = this.e;
        if (mediaProjection != null) {
            int n11 = object.getWidth();
            int n12 = object.getHeight();
            MediaProjection mediaProjection2 = this.e;
            m$b m$b = this.h;
            object = mediaProjection2.createVirtualDisplay("Screen Record", n11, n12, n10, 16, surface, (VirtualDisplay.Callback)m$b, null);
            this.f = object;
            this.h.a();
            return;
        }
        object = new IllegalStateException("Must be after prepare()");
        throw object;
    }

    public void p(Surface object) {
        MediaProjection mediaProjection = this.e;
        if (mediaProjection != null) {
            mediaProjection = this.b();
            int n10 = mediaProjection.widthPixels;
            int n11 = mediaProjection.heightPixels;
            int n12 = mediaProjection.densityDpi;
            MediaProjection mediaProjection2 = this.e;
            m$b m$b = this.h;
            object = mediaProjection2.createVirtualDisplay("Screen Record", n10, n11, n12, 16, object, (VirtualDisplay.Callback)m$b, null);
            this.f = object;
            this.h.a();
            return;
        }
        object = new IllegalStateException("Must be after prepare()");
        throw object;
    }

    public void q() {
        VirtualDisplay virtualDisplay = this.f;
        if (virtualDisplay != null) {
            virtualDisplay.release();
            this.f = null;
        }
        if ((virtualDisplay = this.e) != null) {
            virtualDisplay.stop();
            this.e = null;
        }
    }
}

