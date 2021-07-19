/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import d.v.j.e.i.b1;
import java.util.Map;
import java.util.function.Consumer;

public final class v
implements Consumer {
    public final /* synthetic */ Map a;

    public /* synthetic */ v(Map map) {
        this.a = map;
    }

    public final void accept(Object object) {
        Map map = this.a;
        object = (ScriptTrackMetaData)object;
        b1.Y0(map, (ScriptTrackMetaData)object);
    }
}

