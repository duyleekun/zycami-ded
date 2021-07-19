/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 */
package d.v.b.f0;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.zhiyun.renderengine.business.display.DisplayRender$s;
import d.v.b.f0.k;
import d.v.b.f0.l.g;
import d.v.b0.b.b;
import d.v.d.h.f;

public class k$b
implements DisplayRender$s {
    public final /* synthetic */ k a;

    public k$b(k k10) {
        this.a = k10;
    }

    public void a(b object, int n10, int n11) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("DisplayRender  Available width=");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(",height=");
        ((StringBuilder)object2).append(n11);
        f.a(((StringBuilder)object2).toString());
        object2 = this.a;
        object = (SurfaceTexture)((b)object).a();
        k.e((k)object2, (SurfaceTexture)object);
        object = this.a;
        SurfaceTexture surfaceTexture = k.d(this.a);
        object2 = new Surface(surfaceTexture);
        k.f((k)object, (Surface)object2);
        k.g(this.a, n10, n11);
        object = k.h(this.a);
        Integer n12 = 1;
        ((g)object).p(n12);
    }

    public boolean b(b object) {
        f.a("DisplayRender  onDestroy");
        k.i(this.a);
        object = k.h(this.a);
        Integer n10 = 4;
        ((g)object).p(n10);
        return true;
    }

    public void c(b object, int n10, int n11) {
        k.g(this.a, n10, n11);
        object = k.h(this.a);
        Integer n12 = 2;
        ((g)object).p(n12);
    }

    public void d(b b10) {
    }
}

