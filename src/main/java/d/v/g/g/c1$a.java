/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import com.zhiyun.device.data.remote.entity.FirmwareEntity;
import d.v.e.i.h;
import d.v.g.g.c;
import d.v.g.g.c1;
import m.a.a;

public class c1$a
extends d.v.g.d.a {
    public final /* synthetic */ DeviceInfo c;
    public final /* synthetic */ c1 d;

    public c1$a(c1 c12, DeviceInfo deviceInfo) {
        this.d = c12;
        this.c = deviceInfo;
    }

    private /* synthetic */ void a(FirmwareInfo firmwareInfo) {
        c1.j(this.d).a(firmwareInfo);
    }

    public /* synthetic */ void b(FirmwareInfo firmwareInfo) {
        this.a(firmwareInfo);
    }

    public void c(FirmwareEntity object) {
        block4: {
            Object object2;
            block5: {
                if (object == null) {
                    object = new Object[]{};
                    a.b("Get firmware info done, but null entity", (Object[])object);
                    object = this.d.a;
                    Boolean bl2 = Boolean.FALSE;
                    h.g((MutableLiveData)object, bl2);
                    return;
                }
                if ((object = ((FirmwareEntity)object).getFirmwareInfo()) == null) break block4;
                int n10 = this.c.getSerial();
                ((FirmwareInfo)object).setSerial(n10);
                float f10 = this.c.getVersion();
                ((FirmwareInfo)object).setUnionVersion(f10);
                object2 = this.d;
                c c10 = new c(this, (FirmwareInfo)object);
                c1.b((c1)object2, c10);
                object2 = this.d;
                n10 = (int)(c1.c((c1)object2) ? 1 : 0);
                if (n10 == 0) break block5;
                int n11 = ((FirmwareInfo)object).getHasPopup();
                n10 = 1;
                f10 = Float.MIN_VALUE;
                if (n11 != n10) break block4;
            }
            object = this.d;
            object2 = this.c;
            c1.d((c1)object, (DeviceInfo)object2);
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        n10 = 0;
        Object object2 = new Object[]{};
        string2 = "Get firmware info failed.";
        a.d((Throwable)object, string2, object2);
        object = this.d;
        int n11 = c1.e((c1)object);
        if (n11 != 0 && (n11 = c1.f((c1)(object = this.d))) <= (n10 = 5)) {
            c1.g(this.d);
            object = this.d;
            object2 = this.c;
            c1.i((c1)object, (DeviceInfo)object2);
        } else {
            object = this.d.c;
            object2 = Boolean.FALSE;
            h.g((MutableLiveData)object, object2);
        }
    }
}

