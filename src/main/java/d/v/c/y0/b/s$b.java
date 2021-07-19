/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.data.api.entity.BindDeviceInfoEntity;
import d.v.a.f.b.a;
import d.v.c.y0.b.s;

public class s$b
extends a {
    public final /* synthetic */ s a;

    public s$b(s s10) {
        this.a = s10;
    }

    public void a(BindDeviceInfoEntity object) {
        BindDeviceInfo bindDeviceInfo;
        if (object != null && (bindDeviceInfo = ((BindDeviceInfoEntity)object).getBindDeviceInfo()) != null && (object = ((BindDeviceInfoEntity)object).getBindDeviceInfo().getBindAt()) != null) {
            this.a.dismiss();
            return;
        }
        object = s.z(this.a);
        if (object != null) {
            s.z(this.a).a();
            object = this.a;
            ((DialogFragment)object).dismiss();
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        object = s.z(this.a);
        if (object != null) {
            s.z(this.a).a();
            object = this.a;
            ((DialogFragment)object).dismiss();
        }
    }
}

