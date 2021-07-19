/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.f;

import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPOJODao;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import java.util.function.Consumer;

public final class f
implements Consumer {
    public final /* synthetic */ ScriptTrackPOJODao a;
    public final /* synthetic */ long b;

    public /* synthetic */ f(ScriptTrackPOJODao scriptTrackPOJODao, long l10) {
        this.a = scriptTrackPOJODao;
        this.b = l10;
    }

    public final void accept(Object object) {
        ScriptTrackPOJODao scriptTrackPOJODao = this.a;
        long l10 = this.b;
        object = (ScriptTrackPOJO)object;
        ScriptTrackPOJODao.f(scriptTrackPOJODao, l10, (ScriptTrackPOJO)object);
    }
}

