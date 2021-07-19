/*
 * Decompiled with CFR 0.151.
 */
package d.t.a;

import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a;
import d.t.a.d;

public class d$c
implements HorizontalProgressWheelView$a {
    public final /* synthetic */ d a;

    public d$c(d d10) {
        this.a = d10;
    }

    public void a() {
        d.m(this.a).A();
    }

    public void b() {
        d.m(this.a).u();
    }

    public void c(float f10, float f11) {
        GestureCropImageView gestureCropImageView = d.m(this.a);
        gestureCropImageView.y(f10 /= 42.0f);
    }
}

