/*
 * Decompiled with CFR 0.151.
 */
package d.t.a;

import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a;
import d.t.a.c;

public class c$f
implements HorizontalProgressWheelView$a {
    public final /* synthetic */ c a;

    public c$f(c c10) {
        this.a = c10;
    }

    public void a() {
        c.k(this.a).A();
    }

    public void b() {
        c.k(this.a).u();
    }

    public void c(float f10, float f11) {
        GestureCropImageView gestureCropImageView = null;
        float f12 = f10 - 0.0f;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        float f14 = 15000.0f;
        if (f13 > 0) {
            gestureCropImageView = c.k(this.a);
            GestureCropImageView gestureCropImageView2 = c.k(this.a);
            float f15 = gestureCropImageView2.getCurrentScale();
            GestureCropImageView gestureCropImageView3 = c.k(this.a);
            float f16 = gestureCropImageView3.getMaxScale();
            GestureCropImageView gestureCropImageView4 = c.k(this.a);
            float f17 = gestureCropImageView4.getMinScale();
            f16 = (f16 - f17) / f14;
            gestureCropImageView.D(f15 += (f10 *= f16));
        } else {
            gestureCropImageView = c.k(this.a);
            GestureCropImageView gestureCropImageView5 = c.k(this.a);
            float f18 = gestureCropImageView5.getCurrentScale();
            GestureCropImageView gestureCropImageView6 = c.k(this.a);
            float f19 = gestureCropImageView6.getMaxScale();
            GestureCropImageView gestureCropImageView7 = c.k(this.a);
            float f20 = gestureCropImageView7.getMinScale();
            f19 = (f19 - f20) / f14;
            gestureCropImageView.F(f18 += (f10 *= f19));
        }
    }
}

