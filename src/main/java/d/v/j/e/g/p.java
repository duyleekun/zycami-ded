/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.api.entity.template.Global;
import d.v.j.e.g.y;
import java.util.List;
import java.util.function.Consumer;

public final class p
implements Consumer {
    public final /* synthetic */ Global a;

    public /* synthetic */ p(Global global) {
        this.a = global;
    }

    public final void accept(Object object) {
        Global global = this.a;
        object = (List)object;
        y.y(global, (List)object);
    }
}

