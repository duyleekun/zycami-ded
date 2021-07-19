/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.s2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.camera.data.CameraSet$Theme;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.UserThemeInfo;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo$Theme;
import com.zhiyun.cama.data.api.entity.BindDeviceInfoList;
import com.zhiyun.protocol.constants.Model;
import d.v.c.i1.s2.a;
import d.v.c.i1.s2.b;
import d.v.c.i1.s2.q$a;
import d.v.c.i1.s2.q$b;
import d.v.c.v0.l.e;
import d.v.e.i.h;
import d.v.e0.ce;
import d.v.e0.td;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k.f;

public class q {
    private d.v.c.v0.p.a a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private String e;

    public q() {
        Object object = new MutableLiveData();
        this.b = object;
        object = new MutableLiveData();
        this.c = object;
        object = new MutableLiveData();
        this.d = object;
        this.a = object = d.v.c.v0.p.a.g();
    }

    public static /* synthetic */ MutableLiveData a(q q10) {
        return q10.d;
    }

    public static /* synthetic */ void b(q q10, BindDeviceInfoList bindDeviceInfoList, boolean bl2) {
        q10.r(bindDeviceInfoList, bl2);
    }

    public static q h() {
        return q$b.a;
    }

    private /* synthetic */ void l(List object, td object2) {
        if (object2 != null) {
            boolean bl2;
            this.e = object2 = ((td)object2).e;
            UserInfo userInfo = d.v.a.f.c.b.N().i();
            int n10 = userInfo.getId();
            Object object3 = CameraSet$Theme.DEFAULT;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                UserThemeInfo userThemeInfo = (UserThemeInfo)object.next();
                String string2 = userThemeInfo.getSn();
                int n11 = string2.equalsIgnoreCase((String)object2);
                if (n11 == 0 || n10 != (n11 = userThemeInfo.getUserId())) continue;
                int n12 = userThemeInfo.getThemeValue();
                object3 = CameraSet$Theme.fromId(n12);
                object = this.a;
                ((d.v.c.v0.p.a)object).n((CameraSet$Theme)((Object)object3));
                break;
            }
            if (object3 == (object = CameraSet$Theme.DEFAULT)) {
                object = this.c;
                n10 = 0;
                userInfo = null;
                h.g((MutableLiveData)object, null);
            } else {
                object = this.c;
                h.g((MutableLiveData)object, object3);
            }
            object = this.a.j((String)object2);
            object2 = this.b;
            if (object != null) {
                object3 = object;
            }
            h.g((MutableLiveData)object2, object3);
        }
    }

    private /* synthetic */ void n(CameraSet$Theme cameraSet$Theme, td object) {
        String string2;
        boolean bl2;
        Object object2 = this.e;
        if (object2 != null && (bl2 = ((String)object2).equals(string2 = ((td)object).e))) {
            object2 = this.a;
            object = ((td)object).e;
            ((d.v.c.v0.p.a)object2).q((String)object, cameraSet$Theme);
        }
    }

    private void q() {
        Object object;
        Object object2;
        boolean bl2 = ce.z1();
        if (bl2 && (bl2 = ((d.v.a.f.c.b)(object2 = d.v.a.f.c.b.N())).s()) && (object2 = ce.E0().a1().H2()) == (object = Model.SMOOTHXS)) {
            boolean bl3;
            object2 = this.a.k();
            if (object2 != null && !(bl3 = object2.isEmpty())) {
                object = ce.E0();
                a a10 = new a(this, (List)object2);
                ((ce)object).z0(a10);
            } else {
                this.d();
            }
            return;
        }
        this.d();
    }

    private void r(BindDeviceInfoList object, boolean bl2) {
        ArrayList<Object> arrayList;
        boolean bl3;
        if (object != null && !(bl3 = (arrayList = ((BindDeviceInfoList)object).getList()).isEmpty())) {
            int n10;
            arrayList = new ArrayList<Object>();
            object = ((BindDeviceInfoList)object).getList().iterator();
            while ((n10 = object.hasNext()) != 0) {
                Object object2 = (BindDeviceInfo)object.next();
                Object object3 = ((BindDeviceInfo)object2).getTheme();
                if (object3 == null) continue;
                String string2 = ((BindDeviceInfo)object2).getSn();
                int n11 = ((BindDeviceInfo)object2).getActiveUserId();
                object2 = ((BindDeviceInfo)object2).getTheme();
                n10 = ((BindDeviceInfo$Theme)object2).getValue();
                object3 = new UserThemeInfo(string2, n11, n10);
                arrayList.add(object3);
            }
            object = this.a;
            ((d.v.c.v0.p.a)object).r(arrayList);
            if (bl2) {
                this.q();
            }
            return;
        }
        this.d();
        object = this.a;
        List list = Collections.emptyList();
        ((d.v.c.v0.p.a)object).r(list);
    }

    public void c() {
        Model model;
        boolean bl2 = ce.z1();
        if (!bl2) {
            return;
        }
        Object object = ce.E0().a1().H2();
        if (object == (model = Model.SMOOTHXS) && (bl2 = ((d.v.a.f.c.b)(object = d.v.a.f.c.b.N())).s())) {
            object = this.a;
            bl2 = ((d.v.c.v0.p.a)object).m();
            if (bl2) {
                this.q();
            } else {
                bl2 = true;
                this.f(bl2);
            }
        }
    }

    public void d() {
        MutableLiveData mutableLiveData = this.b;
        CameraSet$Theme cameraSet$Theme = CameraSet$Theme.DEFAULT;
        h.g(mutableLiveData, (Object)cameraSet$Theme);
        h.g(this.c, null);
    }

    public void e() {
        MutableLiveData mutableLiveData = this.b;
        CameraSet$Theme cameraSet$Theme = CameraSet$Theme.DEFAULT;
        h.g(mutableLiveData, (Object)cameraSet$Theme);
        h.g(this.c, null);
        this.a.c();
    }

    public void f(boolean bl2) {
        Object object = d.v.a.f.c.b.N();
        boolean bl3 = ((d.v.a.f.c.b)object).s();
        if (bl3 && !(bl3 = ((d.v.c.v0.p.a)(object = this.a)).m())) {
            object = this.d;
            Object object2 = PagingRequestHelper$Status.RUNNING;
            h.g((MutableLiveData)object, object2);
            object = d.v.a.f.c.b.N().i();
            object2 = d.v.c.v0.l.e.a;
            object = ((UserInfo)object).getToken();
            object = object2.b((String)object);
            object2 = new q$a(this, bl2);
            object.h((f)object2);
        }
    }

    public LiveData g() {
        return Transformations.distinctUntilChanged(this.b);
    }

    public LiveData i() {
        return Transformations.distinctUntilChanged(this.d);
    }

    public LiveData j() {
        return Transformations.distinctUntilChanged(this.c);
    }

    public void k() {
        this.e = null;
    }

    public /* synthetic */ void m(List list, td td2) {
        this.l(list, td2);
    }

    public /* synthetic */ void o(CameraSet$Theme cameraSet$Theme, td td2) {
        this.n(cameraSet$Theme, td2);
    }

    public boolean p() {
        Model model;
        Object object = d.v.a.f.c.b.N();
        boolean bl2 = object.s();
        if (bl2 && (bl2 = ce.z1()) && (object = ce.E0().a1().H2()) == (model = Model.SMOOTHXS)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void s(CameraSet$Theme cameraSet$Theme) {
        boolean bl2 = ce.z1();
        if (bl2) {
            ce ce2 = ce.E0();
            b b10 = new b(this, cameraSet$Theme);
            ce2.z0(b10);
        }
        h.g(this.b, (Object)cameraSet$Theme);
    }
}

