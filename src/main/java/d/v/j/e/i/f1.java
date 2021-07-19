/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.j.e.c;
import d.v.j.e.i.a1;
import d.v.j.e.i.c1;
import java.util.List;

public class f1
extends ViewModel {
    private a1 a;

    public f1() {
        c1 c12 = c.a();
        this.a = c12;
    }

    public LiveData b() {
        return this.a.f(0);
    }

    public LiveData c() {
        return this.a.f(1);
    }

    public LiveData d(long l10) {
        return this.a.g().f1(l10);
    }

    public TemplatePOJO e(long l10) {
        return this.a.g().B(l10);
    }

    public TemplateData f(long l10) {
        return this.a.d().x(l10);
    }

    public LiveData g(long l10) {
        return this.a.d().Q0(l10);
    }

    public TemplateGlobal i(long l10) {
        return this.a.d().z(l10);
    }

    public LiveData j(long l10) {
        return this.a.d().g0(l10);
    }

    public List k(long l10) {
        return this.a.d().A(l10);
    }

    public List l(long l10) {
        return this.a.d().C(l10);
    }

    public LiveData m(long l10) {
        return this.a.d().D(l10);
    }

    public void onCleared() {
        super.onCleared();
    }
}

