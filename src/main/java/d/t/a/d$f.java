/*
 * Decompiled with CFR 0.151.
 */
package d.t.a;

import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a;
import d.t.a.d;

public class d$f
implements HorizontalProgressWheelView$a {
    public final /* synthetic */ d a;

    public d$f(d d10) {
        this.a = d10;
    }

    public void a() {
        d.m(this.a).A();
    }

    public void b() {
        d.m(this.a).u();
    }

    public void c(float f10, float f11) {
        GestureCropImageView gestureCropImageView = null;
        float f12 = f10 - 0.0f;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        float f14 = 15000.0f;
        if (f13 > 0) {
            gestureCropImageView = d.m(this.a);
            GestureCropImageView gestureCropImageView2 = d.m(this.a);
            float f15 = gestureCropImageView2.getCurrentScale();
            GestureCropImageView gestureCropImageView3 = d.m(this.a);
            float f16 = gestureCropImageView3.getMaxScale();
            GestureCropImageView gestureCropImageView4 = d.m(this.a);
            float f17 = gestureCropImageView4.getMinScale();
            f16 = (f16 - f17) / f14;
            gestureCropImageView.D(f15 += (f10 *= f16));
        } else {
            gestureCropImageView = d.m(this.a);
            GestureCropImageView gestureCropImageView5 = d.m(this.a);
            float f18 = gestureCropImageView5.getCurrentScale();
            GestureCropImageView gestureCropImageView6 = d.m(this.a);
            float f19 = gestureCropImageView6.getMaxScale();
            GestureCropImageView gestureCropImageView7 = d.m(this.a);
            float f20 = gestureCropImageView7.getMinScale();
            f19 = (f19 - f20) / f14;
            gestureCropImageView.F(f18 += (f10 *= f19));
        }
    }
}

