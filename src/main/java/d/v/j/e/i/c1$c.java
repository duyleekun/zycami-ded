/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateTypeListBean;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;
import d.v.j.e.h.j;
import d.v.j.e.i.c1;
import d.v.j.e.i.d1;
import d.v.j.e.i.f0;
import d.v.j.e.i.g0;
import d.v.j.e.i.h;
import d.v.j.e.i.h0;
import d.v.j.e.i.i0;
import d.v.j.e.i.j0;
import d.v.j.e.i.z0;
import e.a.c1.b;
import e.a.q0.c.a;
import e.a.v0.g;
import e.a.z;
import java.util.List;
import k.d;

public class c1$c
extends j {
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ c1 f;

    public c1$c(c1 c12, d.v.e.l.c1 c13, String string2, int n10) {
        this.f = c12;
        this.d = string2;
        this.e = n10;
        super(c13);
    }

    private /* synthetic */ LiveData A(SortResult object) {
        if (object == null) {
            return d.v.e.i.d.create();
        }
        this.a = -1;
        object = ((SortResult)object).getIdList();
        return c1.s(this.f).P0((List)object);
    }

    private /* synthetic */ Boolean t(String string2, int n10, Boolean bl2) {
        c1.s(this.f).b1(null, string2, n10);
        return bl2;
    }

    private /* synthetic */ LiveData v(String object, Boolean object2) {
        object = c1.s(this.f).i0((String)object);
        object2 = new f0(this);
        return Transformations.switchMap((LiveData)object, (Function)object2);
    }

    public static /* synthetic */ void x(MediatorLiveData mediatorLiveData, LiveData liveData) {
        mediatorLiveData.getClass();
        h h10 = new h(mediatorLiveData);
        mediatorLiveData.addSource(liveData, h10);
    }

    private /* synthetic */ LiveData y(SortResult object) {
        if (object == null) {
            return d.v.e.i.d.create();
        }
        this.a = -1;
        object = ((SortResult)object).getIdList();
        return c1.s(this.f).P0((List)object);
    }

    public /* synthetic */ LiveData B(SortResult sortResult) {
        return this.A(sortResult);
    }

    public void C(TemplateTypeListBean templateTypeListBean) {
        z0 z02 = c1.s(this.f);
        String string2 = this.d;
        int n10 = this.e;
        z02.b1(templateTypeListBean, string2, n10);
    }

    public boolean D(List list) {
        return true;
    }

    public d e() {
        return c1.t(this.f).c();
    }

    public LiveData m() {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        z z10 = z.t3(Boolean.TRUE);
        Object object = b.d();
        z10 = z10.i4((e.a.h0)object);
        object = this.d;
        int n10 = this.e;
        j0 j02 = new j0(this, (String)object, n10);
        z10 = z10.H3(j02);
        object = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object);
        object = this.d;
        h0 h02 = new h0(this, (String)object);
        z10 = z10.H3(h02);
        object = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object);
        object = new g0(mediatorLiveData);
        z10.d((g)object);
        return mediatorLiveData;
    }

    public LiveData n() {
        Object object = c1.s(this.f);
        Object object2 = this.d;
        object = ((d1)object).i0((String)object2);
        object2 = new i0(this);
        return Transformations.switchMap((LiveData)object, (Function)object2);
    }

    public /* synthetic */ Boolean u(String string2, int n10, Boolean bl2) {
        this.t(string2, n10, bl2);
        return bl2;
    }

    public /* synthetic */ LiveData w(String string2, Boolean bl2) {
        return this.v(string2, bl2);
    }

    public /* synthetic */ LiveData z(SortResult sortResult) {
        return this.y(sortResult);
    }
}

