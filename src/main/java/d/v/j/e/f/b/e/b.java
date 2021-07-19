/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.e;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public final class b
implements Consumer {
    public final /* synthetic */ TemplateDataDao a;
    public final /* synthetic */ Script b;
    public final /* synthetic */ long c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ AppDatabaseTemplate e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ AtomicLong g;

    public /* synthetic */ b(TemplateDataDao templateDataDao, Script script, long l10, boolean bl2, AppDatabaseTemplate appDatabaseTemplate, boolean bl3, AtomicLong atomicLong) {
        this.a = templateDataDao;
        this.b = script;
        this.c = l10;
        this.d = bl2;
        this.e = appDatabaseTemplate;
        this.f = bl3;
        this.g = atomicLong;
    }

    public final void accept(Object object) {
        TemplateDataDao templateDataDao = this.a;
        Script script = this.b;
        long l10 = this.c;
        boolean bl2 = this.d;
        AppDatabaseTemplate appDatabaseTemplate = this.e;
        boolean bl3 = this.f;
        AtomicLong atomicLong = this.g;
        Object object2 = object;
        object2 = (Script)object;
        TemplateDataDao.l(templateDataDao, script, l10, bl2, appDatabaseTemplate, bl3, atomicLong, (Script)object2);
    }
}

