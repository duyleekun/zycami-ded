/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import java.util.Objects;
import java.util.function.Predicate;

public final class a
implements Predicate {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final boolean test(Object object) {
        return Objects.nonNull((ScriptTrackPOJO)object);
    }
}

