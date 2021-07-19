/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.api.entity.track.TrackBean;
import d.v.j.e.i.b1;
import java.util.function.Predicate;

public final class w
implements Predicate {
    public final /* synthetic */ TrackBean a;

    public /* synthetic */ w(TrackBean trackBean) {
        this.a = trackBean;
    }

    public final boolean test(Object object) {
        TrackBean trackBean = this.a;
        object = (TrackBean)object;
        return b1.U0(trackBean, (TrackBean)object);
    }
}

