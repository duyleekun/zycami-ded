/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.e;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public final class i
implements Consumer {
    public final /* synthetic */ AtomicLong a;
    public final /* synthetic */ AppDatabaseTemplate b;

    public /* synthetic */ i(AtomicLong atomicLong, AppDatabaseTemplate appDatabaseTemplate) {
        this.a = atomicLong;
        this.b = appDatabaseTemplate;
    }

    public final void accept(Object object) {
        AtomicLong atomicLong = this.a;
        AppDatabaseTemplate appDatabaseTemplate = this.b;
        object = (List)object;
        TemplateDataDao.n(atomicLong, appDatabaseTemplate, (List)object);
    }
}

