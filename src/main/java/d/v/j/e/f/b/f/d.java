/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.f;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPOJODao;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import java.util.function.Consumer;

public final class d
implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ AppDatabaseTemplate b;

    public /* synthetic */ d(long l10, AppDatabaseTemplate appDatabaseTemplate) {
        this.a = l10;
        this.b = appDatabaseTemplate;
    }

    public final void accept(Object object) {
        long l10 = this.a;
        AppDatabaseTemplate appDatabaseTemplate = this.b;
        object = (ScriptTrackPoint)object;
        ScriptTrackPOJODao.b(l10, appDatabaseTemplate, (ScriptTrackPoint)object);
    }
}

