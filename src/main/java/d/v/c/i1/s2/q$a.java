/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.s2;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.api.entity.BindDeviceInfoList;
import d.v.c.i1.s2.q;
import d.v.e.i.h;
import m.a.a;

public class q$a
extends d.v.a.f.b.a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ q b;

    public q$a(q q10, boolean bl2) {
        this.b = q10;
        this.a = bl2;
    }

    public void a(BindDeviceInfoList object) {
        Object[] objectArray = null;
        Object object2 = new Object[]{};
        m.a.a.b("----get bind device list success---", object2);
        object2 = q.a(this.b);
        PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.SUCCESS;
        h.g((MutableLiveData)object2, (Object)pagingRequestHelper$Status);
        object2 = this.b;
        boolean bl2 = this.a;
        q.b((q)object2, (BindDeviceInfoList)object, bl2);
        if (object != null && (object2 = ((BindDeviceInfoList)object).getList()) != null) {
            object = ((BindDeviceInfoList)object).getList().toString();
            objectArray = new Object[]{};
            m.a.a.b((String)object, objectArray);
        }
    }

    public void onError(Throwable throwable, int n10, String object) {
        Object object2 = new Object[]{};
        m.a.a.b("----get bind device list fail---", object2);
        object2 = q.a(this.b);
        object = PagingRequestHelper$Status.FAILED;
        h.g((MutableLiveData)object2, object);
        throwable.printStackTrace();
    }
}

