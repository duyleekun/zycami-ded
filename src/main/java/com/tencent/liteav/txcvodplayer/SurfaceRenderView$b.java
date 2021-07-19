/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 */
package com.tencent.liteav.txcvodplayer;

import android.view.SurfaceHolder;
import com.tencent.liteav.txcvodplayer.SurfaceRenderView;
import com.tencent.liteav.txcvodplayer.SurfaceRenderView$a;
import com.tencent.liteav.txcvodplayer.a$a;
import com.tencent.liteav.txcvodplayer.a$b;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class SurfaceRenderView$b
implements SurfaceHolder.Callback {
    private SurfaceHolder a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private WeakReference f;
    private Map g;

    public SurfaceRenderView$b(SurfaceRenderView surfaceRenderView) {
        WeakReference<SurfaceRenderView> weakReference = new WeakReference<SurfaceRenderView>();
        this.g = weakReference;
        this.f = weakReference = new WeakReference<SurfaceRenderView>(surfaceRenderView);
    }

    public void a(a$a a$a) {
        int n10;
        int n11;
        SurfaceHolder surfaceHolder;
        SurfaceRenderView surfaceRenderView;
        this.g.put(a$a, a$a);
        Object object = this.a;
        if (object != null) {
            surfaceRenderView = (SurfaceRenderView)this.f.get();
            surfaceHolder = this.a;
            object = new SurfaceRenderView$a(surfaceRenderView, surfaceHolder);
            n11 = this.d;
            n10 = this.e;
            a$a.a((a$b)object, n11, n10);
        } else {
            object = null;
        }
        n11 = this.b;
        if (n11 != 0) {
            if (object == null) {
                surfaceRenderView = (SurfaceRenderView)this.f.get();
                surfaceHolder = this.a;
                object = new SurfaceRenderView$a(surfaceRenderView, surfaceHolder);
            }
            n11 = this.c;
            n10 = this.d;
            int n12 = this.e;
            a$a.a((a$b)object, n11, n10, n12);
        }
    }

    public void b(a$a a$a) {
        this.g.remove(a$a);
    }

    public void surfaceChanged(SurfaceHolder object, int n10, int n11, int n12) {
        boolean bl2;
        boolean bl3;
        this.a = object;
        this.b = bl3 = true;
        this.c = n10;
        this.d = n11;
        this.e = n12;
        Object object2 = (SurfaceRenderView)this.f.get();
        Object object3 = this.a;
        object = new SurfaceRenderView$a((SurfaceRenderView)object2, (SurfaceHolder)object3);
        object2 = this.g.keySet().iterator();
        while (bl2 = object2.hasNext()) {
            object3 = (a$a)object2.next();
            object3.a((a$b)object, n10, n11, n12);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        boolean bl2;
        this.a = surfaceHolder;
        surfaceHolder = null;
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        Object object = (SurfaceRenderView)this.f.get();
        Object object2 = this.a;
        SurfaceRenderView$a surfaceRenderView$a = new SurfaceRenderView$a((SurfaceRenderView)object, (SurfaceHolder)object2);
        object = this.g.keySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (a$a)object.next();
            object2.a(surfaceRenderView$a, 0, 0);
        }
    }

    public void surfaceDestroyed(SurfaceHolder object) {
        boolean bl2;
        this.a = null;
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        Object object2 = (SurfaceRenderView)this.f.get();
        Object object3 = this.a;
        object = new SurfaceRenderView$a((SurfaceRenderView)object2, (SurfaceHolder)object3);
        object2 = this.g.keySet().iterator();
        while (bl2 = object2.hasNext()) {
            object3 = (a$a)object2.next();
            object3.a((a$b)object);
        }
    }
}

