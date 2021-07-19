/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.c.c;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import java.util.function.Function;

public final class a
implements Function {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final Object apply(Object object) {
        return ((ScriptTrackPoint)object).clone();
    }
}

