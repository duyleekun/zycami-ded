/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;
import java.util.Objects;
import java.util.function.Predicate;

public final class t0
implements Predicate {
    public static final /* synthetic */ t0 a;

    static {
        t0 t02;
        a = t02 = new t0();
    }

    public final boolean test(Object object) {
        return Objects.nonNull((ScriptTrack)object);
    }
}

