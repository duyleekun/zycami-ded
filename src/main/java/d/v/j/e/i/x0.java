/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import java.util.function.Function;

public final class x0
implements Function {
    public static final /* synthetic */ x0 a;

    static {
        x0 x02;
        a = x02 = new x0();
    }

    public final Object apply(Object object) {
        return ((ScriptTrackMetaData)object).getProduct();
    }
}

