/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.SceneMode;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.rd;
import e.a.v0.o;

public final class f6
implements o {
    public final /* synthetic */ SceneMode a;

    public /* synthetic */ f6(SceneMode sceneMode) {
        this.a = sceneMode;
    }

    public final Object apply(Object object) {
        SceneMode sceneMode = this.a;
        object = (rd)object;
        return Stabilizer.d6(sceneMode, (rd)object);
    }
}

