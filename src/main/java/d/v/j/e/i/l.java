/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.api.entity.track.TrackBean;
import d.v.j.e.i.b1;
import java.util.List;
import java.util.function.Function;

public final class l
implements Function {
    public final /* synthetic */ b1 a;
    public final /* synthetic */ List b;

    public /* synthetic */ l(b1 b12, List list) {
        this.a = b12;
        this.b = list;
    }

    public final Object apply(Object object) {
        b1 b12 = this.a;
        List list = this.b;
        object = (TrackBean)object;
        return b12.T0(list, (TrackBean)object);
    }
}

