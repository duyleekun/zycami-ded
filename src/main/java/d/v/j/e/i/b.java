/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import java.util.function.Function;

public final class b
implements Function {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final Object apply(Object object) {
        return ((ScriptTrackPOJO)object).getScriptTrackMetaDataList();
    }
}

