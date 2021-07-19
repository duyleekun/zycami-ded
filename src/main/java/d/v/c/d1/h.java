/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.d1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.d1.a;
import d.v.c.d1.b;
import d.v.c.d1.c;
import d.v.c.d1.d;
import d.v.c.d1.e;
import d.v.c.j0;
import d.v.c.m0;
import d.v.j.e.i.a1;
import d.v.j.e.i.z0;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class h
extends ViewModel {
    private static final int g;
    private final MediatorLiveData a;
    private final MutableLiveData b;
    private final MediatorLiveData c;
    private final MutableLiveData d;
    private final d.v.c.x1.p.c e;
    private final a1 f;

    public h() {
        Object object = new MediatorLiveData();
        this.a = object;
        object = new MediatorLiveData();
        this.b = object;
        object = new MediatorLiveData();
        this.c = object;
        this.d = object;
        this.e = object = new d.v.c.x1.p.c();
        this.f = object = d.v.j.e.c.a();
    }

    private int d(List list, e e10) {
        if (e10 == null) {
            return 0;
        }
        int n10 = list.size();
        IntStream intStream = IntStream.range(0, n10);
        b b10 = new b(list, e10);
        return intStream.filter(b10).findFirst().orElse(0);
    }

    public static /* synthetic */ e p(TemplatePOJO templatePOJO) {
        TemplateData templateData = templatePOJO.getTemplateData();
        int n10 = templateData.isDownloadFinished();
        if (n10 != 0) {
            n10 = 100;
        } else {
            n10 = 0;
            templateData = null;
        }
        e e10 = new e(templatePOJO, n10);
        return e10;
    }

    public static /* synthetic */ boolean r(List object, e e10, int n10) {
        long l10;
        long l11;
        long l12;
        boolean bl2;
        Object object2;
        if ((object = (e)object.get(n10)) != null && (object2 = ((e)object).b()) != null && (object2 = ((e)object).b().getTemplate()) != null && (object2 = e10.b()) != null && (object2 = e10.b().getTemplate()) != null && !(bl2 = (l12 = (l11 = ((e)object).b().getTemplate().getReferenceId()) - (l10 = ((Template)(object = e10.b().getTemplate())).getReferenceId())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private /* synthetic */ void s(e object, List object2) {
        boolean bl2 = d.v.j.b.f((List)object2);
        if (bl2) {
            return;
        }
        int n10 = this.d((List)object2, (e)object);
        object2 = this.a;
        object = n10;
        d.v.e.i.h.g((MutableLiveData)object2, object);
    }

    public List b(List stream) {
        boolean bl2 = d.v.j.b.f((List)((Object)stream));
        Object object = bl2 ? new Object() : stream;
        Object object2 = d.v.c.d1.d.a;
        stream.forEach((Consumer<Object>)object2);
        stream = new Stream<Object>();
        object2 = new TemplateData();
        ((TemplateData)object2).setDownloadFinished(true);
        String string2 = m0.i();
        ((TemplateData)object2).setCoverUrl(string2);
        ((TemplateData)object2).setTextZh("\u65e0");
        ((TemplateData)object2).setTextZhTw("\u7121");
        ((TemplateData)object2).setTextEn("None");
        ((TemplatePOJO)((Object)stream)).setTemplateData((TemplateData)object2);
        object.add(0, stream);
        stream = object.stream();
        object = d.v.c.d1.c.a;
        stream = stream.map(object);
        object = Collectors.toList();
        return stream.collect(object);
    }

    public void c(e e10) {
        d.v.e.i.h.g(this.d, e10);
    }

    public void e(e e10) {
        MediatorLiveData mediatorLiveData = this.a;
        Object object = 0;
        d.v.e.i.h.g(mediatorLiveData, object);
        mediatorLiveData = this.a;
        object = this.c;
        d.v.e.i.h.c(mediatorLiveData, (LiveData)object);
        mediatorLiveData = this.a;
        object = this.c;
        a a10 = new a(this, e10);
        mediatorLiveData.addSource((LiveData)object, a10);
    }

    public MutableLiveData f() {
        return this.b;
    }

    public MutableLiveData g() {
        return this.d;
    }

    public e i(int n10) {
        int n11;
        List list = (List)this.c.getValue();
        if (list != null && n10 <= (n11 = list.size())) {
            return (e)list.get(n10);
        }
        return null;
    }

    public MediatorLiveData j() {
        return (MediatorLiveData)Transformations.distinctUntilChanged(this.c);
    }

    public List k() {
        return (List)this.c.getValue();
    }

    public MediatorLiveData l() {
        return (MediatorLiveData)Transformations.distinctUntilChanged(this.a);
    }

    public int m() {
        int n10;
        Object object = this.a.getValue();
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = (Integer)this.a.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public boolean n() {
        int n10 = this.m();
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public void o(int n10) {
        int n11 = this.m();
        if (n10 == n11) {
            return;
        }
        MutableLiveData mutableLiveData = this.b;
        Integer n12 = n10;
        d.v.e.i.h.g(mutableLiveData, n12);
    }

    public /* synthetic */ void t(e e10, List list) {
        this.s(e10, list);
    }

    public LiveData u() {
        z0 z02 = this.f.d();
        int[] nArray = new int[]{-1, 0};
        int n10 = 1;
        int[] nArray2 = new int[n10];
        nArray2[0] = 0;
        Object object = new int[n10];
        object[0] = n10;
        Boolean bl2 = Boolean.TRUE;
        int[] nArray3 = object;
        object = bl2;
        return z02.c0(nArray, nArray2, nArray3, bl2, null);
    }

    public e v() {
        return (e)this.e.a();
    }

    public void w(List object, boolean n10) {
        Integer n11;
        MediatorLiveData mediatorLiveData = this.c;
        d.v.e.i.h.g(mediatorLiveData, object);
        if (n10 == 0) {
            return;
        }
        long l10 = j0.C();
        long l11 = Long.MIN_VALUE;
        n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n12 = 0;
        if (n10 != 0) {
            int n13;
            n11 = null;
            for (n10 = 0; n10 < (n13 = object.size()); ++n10) {
                long l12;
                long l13;
                Object object2;
                Object object3 = (e)object.get(n10);
                if (object3 == null || (object2 = ((e)object3).b()) == null || (object2 = ((e)object3).b().getTemplate()) == null || (n13 = (int)((l13 = l10 - (l12 = ((Template)(object3 = ((e)object3).b().getTemplate())).getReferenceId())) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) continue;
                n12 = n10;
                break;
            }
        }
        object = this.b;
        n11 = n12;
        d.v.e.i.h.g((MutableLiveData)object, n11);
    }

    public void x(e e10) {
        this.e.b(e10);
    }
}

