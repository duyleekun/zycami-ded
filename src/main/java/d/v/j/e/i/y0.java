/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import java.util.Objects;
import java.util.function.Predicate;

public final class y0
implements Predicate {
    public static final /* synthetic */ y0 a;

    static {
        y0 y02;
        a = y02 = new y0();
    }

    public final boolean test(Object object) {
        return Objects.nonNull((ScriptTrackMetaData)object);
    }
}

