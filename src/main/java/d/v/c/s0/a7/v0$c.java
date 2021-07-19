/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import com.zhiyun.cama.camera.data.BeautyData;
import d.v.c.s0.a7.v0;
import d.v.c.s0.u6;
import java.util.List;

public class v0$c {
    public final /* synthetic */ v0 a;

    public v0$c(v0 v02) {
        this.a = v02;
    }

    public void a(int n10, BeautyData object) {
        object = this.a;
        v0.x((v0)object, n10);
        Object object2 = this.a;
        n10 = v0.w((v0)object2);
        int n11 = 1;
        if (n11 == n10) {
            object2 = this.a;
            n11 = 50;
            List list = v0.y((v0)object2);
            v0.A((v0)object2, n11, list);
        }
        object2 = v0.z(this.a);
        n11 = v0.w(this.a);
        ((u6)object2).C1(n11);
        v0.B(this.a);
    }
}

