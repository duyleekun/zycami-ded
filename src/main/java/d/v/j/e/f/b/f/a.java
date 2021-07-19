/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.f;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPOJODao;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import java.util.function.Consumer;

public final class a
implements Consumer {
    public final /* synthetic */ ScriptTrack a;
    public final /* synthetic */ long b;
    public final /* synthetic */ AppDatabaseTemplate c;
    public final /* synthetic */ ScriptTrackPOJO d;

    public /* synthetic */ a(ScriptTrack scriptTrack, long l10, AppDatabaseTemplate appDatabaseTemplate, ScriptTrackPOJO scriptTrackPOJO) {
        this.a = scriptTrack;
        this.b = l10;
        this.c = appDatabaseTemplate;
        this.d = scriptTrackPOJO;
    }

    public final void accept(Object object) {
        ScriptTrack scriptTrack = this.a;
        long l10 = this.b;
        AppDatabaseTemplate appDatabaseTemplate = this.c;
        ScriptTrackPOJO scriptTrackPOJO = this.d;
        Object object2 = object;
        object2 = (ScriptTrack)object;
        ScriptTrackPOJODao.c(scriptTrack, l10, appDatabaseTemplate, scriptTrackPOJO, (ScriptTrack)object2);
    }
}

