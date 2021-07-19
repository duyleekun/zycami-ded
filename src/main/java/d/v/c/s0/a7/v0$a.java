/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.data.BeautyData;
import com.zhiyun.cama.camera.data.CameraSet$Beauty;
import d.v.c.n0.c;
import d.v.c.n0.e;
import d.v.c.s0.a7.v0;
import d.v.c.s0.a7.v0$c;
import d.v.c.w0.j0;
import d.v.f.g.b;

public class v0$a
extends c {
    public final /* synthetic */ v0 b;

    public v0$a(v0 v02) {
        this.b = v02;
    }

    public int a(int n10) {
        return 2131558458;
    }

    public void b(e object, int n10) {
        int n11;
        object = (j0)((e)object).a;
        Object object2 = (BeautyData)this.getItem(n10);
        CameraSet$Beauty cameraSet$Beauty = ((BeautyData)object2).getBeauty();
        int n12 = cameraSet$Beauty.getId();
        v0 v02 = this.b;
        int n13 = v0.w(v02);
        int n14 = 0;
        if (n12 == n13) {
            n12 = 1;
        } else {
            n12 = 0;
            cameraSet$Beauty = null;
        }
        ((j0)object).F(n12 != 0);
        ((j0)object).E(n10);
        ((j0)object).C((BeautyData)object2);
        object2 = this.b;
        Object object3 = new v0$c((v0)object2);
        ((j0)object).D((v0$c)object3);
        ((ViewDataBinding)object).executePendingBindings();
        object3 = this.b;
        n10 = ((b)object3).k();
        if (n10 != 0 && (n10 = ((b)(object3 = this.b)).k()) != (n11 = 2)) {
            n14 = 90;
        }
        object = ((j0)object).a;
        float f10 = n14;
        object.setRotation(f10);
    }
}

