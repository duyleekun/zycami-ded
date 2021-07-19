/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.api.entity.track.TrackBean;
import d.v.j.e.i.b1;
import java.util.function.Function;

public final class s
implements Function {
    public final /* synthetic */ b1 a;
    public final /* synthetic */ String b;

    public /* synthetic */ s(b1 b12, String string2) {
        this.a = b12;
        this.b = string2;
    }

    public final Object apply(Object object) {
        b1 b12 = this.a;
        String string2 = this.b;
        object = (TrackBean)object;
        return b12.R0(string2, (TrackBean)object);
    }
}

