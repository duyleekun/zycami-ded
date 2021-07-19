/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.e;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public final class g
implements Consumer {
    public final /* synthetic */ TemplateDataDao a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ AtomicLong c;
    public final /* synthetic */ AppDatabaseTemplate d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ g(TemplateDataDao templateDataDao, boolean bl2, AtomicLong atomicLong, AppDatabaseTemplate appDatabaseTemplate, boolean bl3) {
        this.a = templateDataDao;
        this.b = bl2;
        this.c = atomicLong;
        this.d = appDatabaseTemplate;
        this.e = bl3;
    }

    public final void accept(Object object) {
        TemplateDataDao templateDataDao = this.a;
        boolean bl2 = this.b;
        AtomicLong atomicLong = this.c;
        AppDatabaseTemplate appDatabaseTemplate = this.d;
        boolean bl3 = this.e;
        Object object2 = object;
        object2 = (TemplateData)object;
        TemplateDataDao.d(templateDataDao, bl2, atomicLong, appDatabaseTemplate, bl3, (TemplateData)object2);
    }
}

