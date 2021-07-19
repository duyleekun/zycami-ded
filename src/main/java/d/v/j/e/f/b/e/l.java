/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.e;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public final class l
implements Consumer {
    public final /* synthetic */ TemplateDataDao a;
    public final /* synthetic */ long b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ AppDatabaseTemplate d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ AtomicLong f;

    public /* synthetic */ l(TemplateDataDao templateDataDao, long l10, boolean bl2, AppDatabaseTemplate appDatabaseTemplate, boolean bl3, AtomicLong atomicLong) {
        this.a = templateDataDao;
        this.b = l10;
        this.c = bl2;
        this.d = appDatabaseTemplate;
        this.e = bl3;
        this.f = atomicLong;
    }

    public final void accept(Object object) {
        TemplateDataDao templateDataDao = this.a;
        long l10 = this.b;
        boolean bl2 = this.c;
        AppDatabaseTemplate appDatabaseTemplate = this.d;
        boolean bl3 = this.e;
        AtomicLong atomicLong = this.f;
        Object object2 = object;
        object2 = (Template)object;
        TemplateDataDao.c(templateDataDao, l10, bl2, appDatabaseTemplate, bl3, atomicLong, (Template)object2);
    }
}

