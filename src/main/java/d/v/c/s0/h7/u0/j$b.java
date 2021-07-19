/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.u0;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.android.CameraView;
import d.v.c.s0.h7.k0;
import d.v.c.s0.h7.k0$d;
import d.v.c.s0.h7.u0.j;
import d.v.d.i.f.z;
import d.v.e.h.a;

public class j$b
implements k0$d {
    public final /* synthetic */ CameraView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ k0 d;
    public final /* synthetic */ j e;

    public j$b(j j10, CameraView cameraView, int n10, int n11, k0 k02) {
        this.e = j10;
        this.a = cameraView;
        this.b = n10;
        this.c = n11;
        this.d = k02;
    }

    public void c() {
        int n10;
        Object object = (Boolean)j.a((j)this.e).e.getValue();
        int n11 = d.v.e.h.a.c((Boolean)object);
        if (n11 != 0 && (n11 = this.b) != (n10 = this.c)) {
            j j10 = this.e;
            k0 k02 = this.d;
            CameraView cameraView = this.a;
            j.b(j10, ++n11, n10, k02, cameraView);
        } else {
            object = j.a((j)this.e).d;
            Boolean bl2 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(bl2);
            object = j.a((j)this.e).e;
            ((MutableLiveData)object).setValue(bl2);
        }
    }

    public void d(float f10) {
        z z10 = this.a.getPreviewWt();
        Float f11 = Float.valueOf(f10);
        z10.x(f11);
    }

    public void e(int n10) {
    }

    public void f(String object) {
        object = j.a((j)this.e).e;
        Boolean bl2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(bl2);
    }

    public void g(boolean bl2) {
    }

    public void onCanceled() {
        MutableLiveData mutableLiveData = j.a((j)this.e).d;
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.setValue(bl2);
        j.a((j)this.e).e.setValue(bl2);
    }
}

