/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.u1.e;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.h.e.a;
import d.v.j.b;
import java.util.List;
import java.util.stream.Collectors;

public class k
extends ViewModel {
    private final MutableLiveData a;
    private final j b;
    private final MutableLiveData c;
    private Long d;
    private List e;

    public k() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData;
        this.c = mutableLiveData = new MutableLiveData();
    }

    public LiveData b() {
        return this.a;
    }

    public List c() {
        return this.e;
    }

    public LiveData d() {
        return this.b;
    }

    public LiveData e() {
        return this.c;
    }

    public boolean f() {
        int n10;
        Object object = this.c.getValue();
        if (object != null && (n10 = ((Integer)(object = (Integer)this.c.getValue())).intValue()) != 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public boolean g() {
        int n10;
        Object object = this.b().getValue();
        int n11 = 1;
        if (object == null || (n10 = ((Integer)(object = (Integer)this.b().getValue())).intValue()) != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void i(a a10, int n10) {
        List list = this.e;
        int n11 = d.v.j.b.f(list);
        if (n11 != 0 && n10 >= 0 && n10 < (n11 = (list = this.e).size())) {
            list = this.e;
            list.set(n10, a10);
        }
    }

    public boolean j(long l10) {
        long l11;
        long l12;
        boolean bl2;
        Long l13 = this.d;
        bl2 = l13 != null && !(bl2 = (l12 = (l11 = l13.longValue()) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1));
        return bl2;
    }

    public void k(int n10) {
        MutableLiveData mutableLiveData = this.a;
        Integer n11 = n10;
        h.e(mutableLiveData, n11);
    }

    public void l(List object) {
        boolean bl2 = d.v.j.b.f((List)object);
        if (bl2) {
            return;
        }
        Object object2 = this.e;
        bl2 = d.v.j.b.f((List)object2);
        if (bl2) {
            object = object.stream();
            object2 = d.v.c.u1.e.a;
            object = object.map(object2);
            object2 = Collectors.toList();
            this.e = object = object.collect(object2);
        }
    }

    public void m(TemplatePOJO templatePOJO) {
        h.e(this.b, templatePOJO);
    }

    public void n(int n10) {
        MutableLiveData mutableLiveData = this.c;
        Integer n11 = n10;
        h.e(mutableLiveData, n11);
    }

    public void o(long l10) {
        Long l11;
        this.d = l11 = Long.valueOf(l10);
    }
}

