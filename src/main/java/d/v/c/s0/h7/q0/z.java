/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.q0;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.camera.data.MoreDevice;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.util.DownloadState;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import com.zhiyun.protocol.constants.Model;
import d.v.c.s0.h7.l0;
import d.v.c.s0.h7.q0.s;
import d.v.c.s0.h7.q0.t;
import d.v.c.s0.h7.q0.u;
import d.v.c.s0.h7.q0.v;
import d.v.c.s0.h7.q0.w;
import d.v.e.i.d;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.e.l.c1;
import d.v.j.e.c;
import d.v.j.e.h.k;
import d.v.j.g.d0.d$a;
import d.v.j.g.d0.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import m.a.a;

public class z
extends ViewModel {
    private static final int k = 12;
    public j a;
    public MutableLiveData b;
    public final MutableLiveData c;
    private final Map d;
    private final Map e;
    private k f;
    private final MediatorLiveData g;
    private e h;
    private d$a i;
    private final MutableLiveData j;

    public z() {
        LiveData liveData;
        this.a = liveData = new j();
        this.b = liveData;
        super();
        this.c = liveData;
        Object object = new HashMap();
        this.d = object;
        object = new HashMap();
        this.e = object;
        this.g = object = new MediatorLiveData();
        Object object2 = new w(this);
        this.i = object2;
        this.j = object2 = new MutableLiveData();
        object2 = new s(this);
        liveData = Transformations.switchMap(liveData, (Function)object2);
        object2 = new t(this);
        ((MediatorLiveData)object).addSource(liveData, (Observer)object2);
    }

    public static /* synthetic */ LiveData i(z z10, boolean bl2) {
        return z10.v(bl2);
    }

    private /* synthetic */ void j(Long l10, TemplatePOJO templatePOJO, DownloadEvent downloadEvent) {
        this.t(templatePOJO, downloadEvent);
    }

    private /* synthetic */ void l(k k10) {
        this.f = k10;
        this.u(null);
    }

    private /* synthetic */ void n(TemplatePOJO object, DownloadEvent downloadEvent) {
        long l10 = l0.c(object);
        object = DownloadState.DOWNLOADING;
        Object object2 = downloadEvent.getDownloadState();
        if (object == object2) {
            int n10;
            object = this.e;
            object2 = l10;
            int n11 = d.v.e.h.d.c((Integer)(object = (Integer)object.get(object2)));
            if (n11 != (n10 = downloadEvent.getProgress())) {
                n11 = downloadEvent.getProgress();
                if (n11 <= 0) {
                    n11 = 1;
                    downloadEvent.setProgress(n11);
                }
                object = this.d;
                object2 = l10;
                object.put(object2, downloadEvent);
                object = this.e;
                Long l11 = l10;
                int n12 = downloadEvent.getProgress();
                Integer n13 = n12;
                object.put(l11, n13);
                this.u(downloadEvent);
            }
        } else {
            object = this.d;
            object2 = l10;
            object.remove(object2);
            object = this.e;
            Long l12 = l10;
            object.remove(l12);
            this.u(downloadEvent);
        }
    }

    private /* synthetic */ void p(DownloadEvent object) {
        long l10;
        Object object2 = this.b.getValue();
        if (object2 != null) {
            object2 = (TemplatePOJO)this.b.getValue();
            l10 = l0.c((TemplatePOJO)object2);
        } else {
            l10 = 0L;
        }
        Iterator iterator2 = this.f;
        if (iterator2 != null && (iterator2 = ((k)iterator2).c) != null) {
            boolean bl2;
            iterator2 = ((List)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                TemplatePOJO templatePOJO = (TemplatePOJO)iterator2.next();
                long l11 = l0.c(templatePOJO);
                Object object3 = this.d;
                Long l12 = l11;
                object3 = (DownloadEvent)object3.get(l12);
                templatePOJO.setDownloadEvent((DownloadEvent)object3);
                Object object4 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (object4 != false) continue;
                MutableLiveData mutableLiveData = this.b;
                d.v.e.i.h.e(mutableLiveData, templatePOJO);
            }
        }
        object2 = this.g;
        Object object5 = this.f;
        d.v.e.i.h.e((MutableLiveData)object2, object5);
        if (object != null && ((object2 = DownloadState.DOWNLOAD_FAILED) == (object5 = ((DownloadEvent)object).getDownloadState()) || (object2 = DownloadState.PARSE_ERROR) == (object5 = ((DownloadEvent)object).getDownloadState()) || (object2 = DownloadState.INSUFFICIENT_RESOURCES) == (object5 = ((DownloadEvent)object).getDownloadState()) || (object2 = DownloadState.DOWNLOAD_NETWORK_FAILED) == (object = ((DownloadEvent)object).getDownloadState()))) {
            object = this.a;
            int n10 = 2131953126;
            object2 = n10;
            d.v.e.i.h.e((MutableLiveData)object, object2);
        }
    }

    private void t(TemplatePOJO templatePOJO, DownloadEvent downloadEvent) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("notifyDownloadState");
        long l10 = templatePOJO.getTemplateData().getId();
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append(",title = ");
        Object object2 = templatePOJO.getTemplateData().showTitle();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(",state = ");
        object2 = downloadEvent.getDownloadState();
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(",progress");
        int n10 = downloadEvent.getProgress();
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        object2 = new Object[]{};
        m.a.a.b((String)object, object2);
        object = c1.b().a();
        object2 = new v(this, templatePOJO, downloadEvent);
        object.execute((Runnable)object2);
    }

    private void u(DownloadEvent downloadEvent) {
        Executor executor = c1.b().a();
        u u10 = new u(this, downloadEvent);
        executor.execute(u10);
    }

    private LiveData v(boolean bl2) {
        int n10;
        Object object = this.j.getValue();
        if (object != null && (object = ((MoreDevice)((Object)this.j.getValue())).getModels()) != null && (n10 = ((Model[])(object = ((MoreDevice)((Object)this.j.getValue())).getModels())).length) > 0) {
            object = new Object[1];
            Integer n11 = ((MoreDevice)((Object)this.j.getValue())).getModels()[0].getCode();
            object[0] = n11;
            String string2 = String.format("0x%04x", (Object[])object);
            object = new StringBuilder();
            ((StringBuilder)object).append("SortSmartByTemplateDataId");
            ((StringBuilder)object).append(string2);
            String string3 = ((StringBuilder)object).toString();
            return d.v.j.e.c.a().n(string3, 12, bl2, 0, string2);
        }
        return d.v.e.i.d.create();
    }

    public void b() {
        e e10 = this.h;
        if (e10 != null) {
            e10.d();
            e10 = this.h;
            d$a d$a = this.i;
            e10.w(d$a);
            e10 = null;
            this.h = null;
        }
        this.d.clear();
        this.e.clear();
    }

    public void c(TemplatePOJO object) {
        long l10 = l0.c((TemplatePOJO)object);
        object = this.d;
        Long l11 = l10;
        object.remove(l11);
        object = this.e;
        Long l12 = l10;
        object.remove(l12);
    }

    public void d(TemplatePOJO object) {
        TemplateData templateData;
        int n10;
        long l10;
        Object object2;
        Object object3 = ((TemplatePOJO)object).getDownloadEvent();
        if (object3 != null && ((object3 = DownloadState.DOWNLOADING) == (object2 = ((TemplatePOJO)object).getDownloadEvent().getDownloadState()) || (object3 = DownloadState.DOWNLOAD_SUCCESSFUL) == (object2 = ((TemplatePOJO)object).getDownloadEvent().getDownloadState()))) {
            return;
        }
        long l11 = d.v.d.i.g.c.p();
        long l12 = l11 - (l10 = (long)(n10 = (templateData = ((TemplatePOJO)object).getTemplateData()).getResSize() / 1024 / 1024 + 300));
        Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object4 < 0) {
            object = this.a;
            object3 = 2131953127;
            ((j)object).setValue(object3);
            return;
        }
        object3 = this.h;
        if (object3 == null) {
            object3 = new e();
            this.h = object3;
            object2 = this.i;
            ((d.v.j.g.d0.d)object3).b((d$a)object2);
        }
        this.h.h(object);
        object2 = DownloadState.DOWNLOADING;
        object3 = new DownloadEvent((DownloadState)((Object)object2), 1);
        object2 = this.d;
        object = l0.c((TemplatePOJO)object);
        object2.put(object, object3);
        this.u((DownloadEvent)object3);
    }

    public LiveData e() {
        return this.g;
    }

    public LiveData f() {
        return this.j;
    }

    public void g(Model enum_) {
        Object object = Model.UNKNOWN;
        if (object != enum_) {
            enum_ = MoreDevice.fromModel((Model)enum_);
            object = d.v.c.v0.n.d.s();
            ((d.v.c.v0.n.d)object).x0((MoreDevice)enum_);
        } else {
            enum_ = d.v.c.v0.n.d.s().F();
        }
        this.j.setValue(enum_);
    }

    public /* synthetic */ void k(Long l10, TemplatePOJO templatePOJO, DownloadEvent downloadEvent) {
        this.j(l10, templatePOJO, downloadEvent);
    }

    public /* synthetic */ void m(k k10) {
        this.l(k10);
    }

    public /* synthetic */ void o(TemplatePOJO templatePOJO, DownloadEvent downloadEvent) {
        this.n(templatePOJO, downloadEvent);
    }

    public /* synthetic */ void r(DownloadEvent downloadEvent) {
        this.p(downloadEvent);
    }

    public void s() {
        MutableLiveData mutableLiveData = this.c;
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.setValue(bl2);
    }

    public void w() {
        MutableLiveData mutableLiveData = this.c;
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.setValue(bl2);
    }

    public void x(MoreDevice moreDevice) {
        this.j.setValue((Object)moreDevice);
        d.v.c.v0.n.d.s().x0(moreDevice);
    }
}

