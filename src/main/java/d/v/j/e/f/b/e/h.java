/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.e;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public final class h
implements Consumer {
    public final /* synthetic */ AppDatabaseTemplate a;
    public final /* synthetic */ List b;
    public final /* synthetic */ AtomicLong c;

    public /* synthetic */ h(AppDatabaseTemplate appDatabaseTemplate, List list, AtomicLong atomicLong) {
        this.a = appDatabaseTemplate;
        this.b = list;
        this.c = atomicLong;
    }

    public final void accept(Object object) {
        AppDatabaseTemplate appDatabaseTemplate = this.a;
        List list = this.b;
        AtomicLong atomicLong = this.c;
        object = (List)object;
        TemplateDataDao.k(appDatabaseTemplate, list, atomicLong, (List)object);
    }
}

