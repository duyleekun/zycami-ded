/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.e;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public final class n
implements Consumer {
    public final /* synthetic */ AtomicLong a;
    public final /* synthetic */ AppDatabaseTemplate b;

    public /* synthetic */ n(AtomicLong atomicLong, AppDatabaseTemplate appDatabaseTemplate) {
        this.a = atomicLong;
        this.b = appDatabaseTemplate;
    }

    public final void accept(Object object) {
        AtomicLong atomicLong = this.a;
        AppDatabaseTemplate appDatabaseTemplate = this.b;
        object = (TemplateGlobal)object;
        TemplateDataDao.g(atomicLong, appDatabaseTemplate, (TemplateGlobal)object);
    }
}

