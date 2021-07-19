/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.HorizontalScrollView
 */
package d.v.c.s0.a7;

import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.a7.e1;
import d.v.c.w0.h1;

public class e1$a
implements Runnable {
    public final /* synthetic */ e1 a;

    public e1$a(e1 e12) {
        this.a = e12;
    }

    public void run() {
        int n10 = e1.B(this.a);
        Object object = this.a;
        Object object2 = e1.C((e1)object).e;
        int n11 = e1.C((e1)this.a).f.getWidth() / 2;
        Object object3 = e1.D((e1)object, (ViewGroup)object2, n10 += n11);
        if (object3 != null) {
            object = e1.C((e1)this.a).e;
            n11 = object.indexOfChild((View)object3);
            object2 = this.a;
            HorizontalScrollView horizontalScrollView = e1.C((e1)object2).f;
            e1.E((e1)object2, horizontalScrollView, (View)object3);
            object3 = this.a;
            n10 = e1.F((e1)object3);
            if (n10 != n11) {
                e1.G(this.a, n11);
                object3 = e1.C(this.a);
                n11 = e1.F(this.a);
                object = n11;
                ((h1)object3).B((Integer)object);
                object3 = e1.C((e1)this.a).b;
                n10 = object3.getVisibility();
                if (n10 == 0) {
                    n11 = 1;
                    object3 = this.a;
                    n10 = e1.F((e1)object3);
                    if (n11 == n10) {
                        object3 = e1.C((e1)this.a).b;
                        ((ExoVideoView)object3).start();
                    } else {
                        object3 = e1.C((e1)this.a).b;
                        ((ExoVideoView)object3).F(n11 != 0);
                    }
                }
            }
        }
    }
}

