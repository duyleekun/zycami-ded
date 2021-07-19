/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.l;

import androidx.arch.core.util.Function;
import com.zhiyun.cama.template.PlayState;

public final class j
implements Function {
    public static final /* synthetic */ j a;

    static {
        j j10;
        a = j10 = new j();
    }

    public final Object apply(Object object) {
        return PlayState.isPlaying((PlayState)((Object)object));
    }
}

