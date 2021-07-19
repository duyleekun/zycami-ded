/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.f;

import androidx.arch.core.util.Function;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.util.DownloadState;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.e.l.c1;
import d.v.e.l.s1;
import d.v.j.e.h.k;
import d.v.j.e.i.a1;
import d.v.j.e.i.z0;
import d.v.j.f.a;
import d.v.j.f.b;
import d.v.j.f.c;
import d.v.j.f.d;
import d.v.j.f.e;
import d.v.j.f.g$a;
import d.v.j.g.d0.d$a;
import d.v.j.g.d0.f;
import d.v.j.g.x;
import java.util.List;
import java.util.concurrent.Executor;

public class g
extends ViewModel {
    private final MutableLiveData a;
    private final LiveData b;
    private final MutableLiveData c;
    private LiveData d;
    private a1 e;
    private f f;
    private int g;
    private d$a h;

    public g() {
        LiveData liveData;
        this.a = liveData = new MutableLiveData();
        Object object = new MutableLiveData();
        this.c = object;
        this.h = object = new c(this);
        this.f = object = d.v.j.g.d0.f.H();
        d$a d$a = this.h;
        ((d.v.j.g.d0.d)object).b(d$a);
        this.e = object = d.v.j.e.c.a();
        object = new b(this);
        liveData = Transformations.switchMap(liveData, (Function)object);
        this.b = liveData;
    }

    private void F(long l10, DownloadEvent downloadEvent) {
        Object object = l10;
        Pair pair = new Pair(object, downloadEvent);
        object = new StringBuilder();
        ((StringBuilder)object).append("notifyPostDownloadState:");
        ((StringBuilder)object).append(pair);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
        this.c.postValue(pair);
    }

    private void G(long l10, DownloadEvent downloadEvent) {
        Executor executor = c1.b().c();
        d d10 = new d(this, l10, downloadEvent);
        executor.execute(d10);
    }

    private /* synthetic */ void o(TemplatePOJO templatePOJO) {
        Template template = templatePOJO.getTemplate();
        long l10 = template.getTypeId();
        z0 z02 = this.e.d();
        long l11 = z02.F0(l10);
        TemplateData templateData = templatePOJO.getTemplateData();
        a1 a12 = this.e;
        a12.r(templateData);
        long l12 = 1L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 == false) {
            z02 = this.e.d();
            z02.E0(l10);
        }
        s1.g(d.v.j.d.a(templatePOJO));
    }

    private /* synthetic */ void r(Long l10, TemplatePOJO object, DownloadEvent downloadEvent) {
        object = g$a.a;
        DownloadState downloadState = downloadEvent.getDownloadState();
        int n10 = downloadState.ordinal();
        Object object2 = object[n10];
        switch (object2) {
            default: {
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                long l11 = l10;
                this.G(l11, downloadEvent);
                break;
            }
            case 2: {
                object2 = downloadEvent.getProgress();
                if (object2 == false) {
                    long l12 = l10;
                    this.G(l12, downloadEvent);
                    break;
                }
                long l13 = l10;
                this.F(l13, downloadEvent);
            }
        }
    }

    private /* synthetic */ LiveData t(Pair object) {
        a1 a12 = this.e;
        Boolean bl2 = (Boolean)((Pair)object).first;
        boolean bl3 = bl2;
        Long l10 = (Long)((Pair)object).second;
        long l11 = l10;
        Long l12 = (Long)((Pair)object).second;
        long l13 = l12;
        long l14 = 0L;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        boolean bl4 = true;
        boolean bl5 = false;
        if (l15 < 0) {
            l15 = (long)bl4;
        } else {
            l15 = 0;
            l12 = null;
        }
        boolean bl6 = this.g;
        object = (Long)((Pair)object).second;
        long l16 = (Long)object;
        long l17 = -999L;
        long l18 = l16 == l17 ? 0 : (l16 < l17 ? -1 : 1);
        if (l18 != false) {
            bl5 = bl4;
        }
        bl4 = bl6;
        return a12.q(bl3, l11, (boolean)l15, (int)(bl6 ? 1 : 0), bl5);
    }

    private /* synthetic */ void v(long l10, DownloadEvent downloadEvent) {
        Object object = l10;
        Pair pair = new Pair(object, downloadEvent);
        object = new StringBuilder();
        ((StringBuilder)object).append("notifySetDownloadStateSingleEvent:");
        ((StringBuilder)object).append(pair);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
        downloadEvent.setSingleEvent(true);
        this.c.setValue(pair);
        downloadEvent.setSingleEvent(false);
        this.c.setValue(pair);
    }

    private /* synthetic */ void x(TemplateData templateData, String string2, String string3, String string4) {
        z0 z02 = this.e.d();
        long l10 = templateData.getId();
        z02.j0(l10, string2, string3, string4);
    }

    public void A(long l10) {
        LiveData liveData;
        this.d = liveData = this.e.d().Q0(l10);
    }

    public void H(long l10, int n10) {
        this.g = n10;
        MutableLiveData mutableLiveData = this.a;
        Boolean bl2 = Boolean.TRUE;
        Long l11 = l10;
        Pair pair = new Pair(bl2, l11);
        mutableLiveData.setValue(pair);
    }

    public void I(TemplateData templateData, String string2, String string3, String string4) {
        Executor executor = c1.b().a();
        e e10 = new e(this, templateData, string2, string3, string4);
        executor.execute(e10);
    }

    public void J(TemplatePOJO object) {
        if (object == null) {
            return;
        }
        Object object2 = this.f;
        Long l10 = ((f)object2).C((TemplatePOJO)object);
        ((d.v.j.g.d0.d)object2).g(l10);
        object2 = this.e;
        object = ((TemplatePOJO)object).getTemplateData();
        object2.p((TemplateData)object);
    }

    public void K(TemplatePOJO templatePOJO) {
        if (templatePOJO == null) {
            return;
        }
        TemplateData templateData = templatePOJO.getTemplateData();
        boolean bl2 = templateData.isNetworkTemplate();
        if (bl2) {
            this.J(templatePOJO);
        }
    }

    public boolean b(TemplatePOJO templatePOJO) {
        return x.v(templatePOJO);
    }

    public void c(TemplatePOJO templatePOJO) {
        Executor executor = c1.b().a();
        a a10 = new a(this, templatePOJO);
        executor.execute(a10);
    }

    public void d(TemplatePOJO templatePOJO) {
        this.f.h(templatePOJO);
    }

    public LiveData e() {
        return this.c;
    }

    public f f() {
        return this.f;
    }

    public TemplatePOJO g() {
        return (TemplatePOJO)this.d.getValue();
    }

    public LiveData i() {
        return this.b;
    }

    public LiveData j() {
        return this.d;
    }

    public void k(long l10) {
        f f10 = this.f;
        Long l11 = l10;
        f10.o(l11);
    }

    public String l() {
        Object object = this.g();
        object = object == null ? null : this.g().getTemplateData().getVideoUrl();
        return object;
    }

    public boolean m() {
        int n10;
        Object object = this.b;
        boolean bl2 = false;
        if (object != null && (object = (k)((LiveData)object).getValue()) != null && (object = (List)((k)object).c) != null && (n10 = object.size()) > 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean n() {
        boolean bl2;
        Object object = this.a.getValue();
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void onCleared() {
        f f10 = this.f;
        d$a d$a = this.h;
        f10.w(d$a);
        this.h = null;
        this.f = null;
    }

    public /* synthetic */ void p(TemplatePOJO templatePOJO) {
        this.o(templatePOJO);
    }

    public /* synthetic */ void s(Long l10, TemplatePOJO templatePOJO, DownloadEvent downloadEvent) {
        this.r(l10, templatePOJO, downloadEvent);
    }

    public /* synthetic */ LiveData u(Pair pair) {
        return this.t(pair);
    }

    public /* synthetic */ void w(long l10, DownloadEvent downloadEvent) {
        this.v(l10, downloadEvent);
    }

    public /* synthetic */ void y(TemplateData templateData, String string2, String string3, String string4) {
        this.x(templateData, string2, string3, string4);
    }

    public void z(long l10, int n10) {
        this.g = n10;
        MutableLiveData mutableLiveData = this.a;
        Boolean bl2 = Boolean.FALSE;
        Long l11 = l10;
        Pair pair = new Pair(bl2, l11);
        mutableLiveData.setValue(pair);
    }
}

