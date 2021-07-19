/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment;
import com.zhiyun.protocol.constants.SceneMode;

public final class s
implements Observer {
    public final /* synthetic */ SetStabilizerFragment a;

    public /* synthetic */ s(SetStabilizerFragment setStabilizerFragment) {
        this.a = setStabilizerFragment;
    }

    public final void onChanged(Object object) {
        SetStabilizerFragment setStabilizerFragment = this.a;
        object = (SceneMode)((Object)object);
        setStabilizerFragment.r((SceneMode)((Object)object));
    }
}

