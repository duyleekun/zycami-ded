/*
 * Decompiled with CFR 0.151.
 */
package d.t.a;

import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a;
import d.t.a.c;

public class c$c
implements HorizontalProgressWheelView$a {
    public final /* synthetic */ c a;

    public c$c(c c10) {
        this.a = c10;
    }

    public void a() {
        c.k(this.a).A();
    }

    public void b() {
        c.k(this.a).u();
    }

    public void c(float f10, float f11) {
        GestureCropImageView gestureCropImageView = c.k(this.a);
        gestureCropImageView.y(f10 /= 42.0f);
    }
}

