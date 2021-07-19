/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.api.entity.track.TrackBean;
import d.v.j.e.i.b1;
import java.util.function.Consumer;

public final class x
implements Consumer {
    public final /* synthetic */ TrackBean a;

    public /* synthetic */ x(TrackBean trackBean) {
        this.a = trackBean;
    }

    public final void accept(Object object) {
        TrackBean trackBean = this.a;
        object = (TrackBean)object;
        b1.V0(trackBean, (TrackBean)object);
    }
}

