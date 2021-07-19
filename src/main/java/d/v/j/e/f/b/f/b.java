/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.f;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPOJODao;
import java.util.List;
import java.util.function.Consumer;

public final class b
implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ AppDatabaseTemplate b;

    public /* synthetic */ b(long l10, AppDatabaseTemplate appDatabaseTemplate) {
        this.a = l10;
        this.b = appDatabaseTemplate;
    }

    public final void accept(Object object) {
        long l10 = this.a;
        AppDatabaseTemplate appDatabaseTemplate = this.b;
        object = (List)object;
        ScriptTrackPOJODao.a(l10, appDatabaseTemplate, (List)object);
    }
}

