/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.c.c;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import java.util.function.Function;

public final class d
implements Function {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final Object apply(Object object) {
        return ((ScriptTrackMetaData)object).clone();
    }
}

