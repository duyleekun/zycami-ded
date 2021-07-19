/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.api.entity.track.ScriptInfoData;
import d.v.j.e.i.b1;
import java.util.function.Consumer;

public final class o
implements Consumer {
    public final /* synthetic */ b1 a;

    public /* synthetic */ o(b1 b12) {
        this.a = b12;
    }

    public final void accept(Object object) {
        b1 b12 = this.a;
        object = (ScriptInfoData)object;
        b1.J0(b12, (ScriptInfoData)object);
    }
}

