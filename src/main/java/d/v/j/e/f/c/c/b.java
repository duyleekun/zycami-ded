/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.c.c;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import java.util.List;
import java.util.function.Consumer;

public final class b
implements Consumer {
    public final /* synthetic */ ScriptTrackPOJO a;

    public /* synthetic */ b(ScriptTrackPOJO scriptTrackPOJO) {
        this.a = scriptTrackPOJO;
    }

    public final void accept(Object object) {
        ScriptTrackPOJO scriptTrackPOJO = this.a;
        object = (List)object;
        ScriptTrackPOJO.a(scriptTrackPOJO, (List)object);
    }
}

