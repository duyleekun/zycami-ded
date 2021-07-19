/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.c.b;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import java.util.function.Function;

public final class j
implements Function {
    public static final /* synthetic */ j a;

    static {
        j j10;
        a = j10 = new j();
    }

    public final Object apply(Object object) {
        return ((ScriptTrackPOJO)object).clone();
    }
}

