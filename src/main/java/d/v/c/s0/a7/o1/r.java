/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment;
import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;

public final class r
implements Observer {
    public final /* synthetic */ SetStabilizerFragment a;

    public /* synthetic */ r(SetStabilizerFragment setStabilizerFragment) {
        this.a = setStabilizerFragment;
    }

    public final void onChanged(Object object) {
        SetStabilizerFragment setStabilizerFragment = this.a;
        object = (KeyFunc)((Object)object);
        setStabilizerFragment.z((KeyFunc)((Object)object));
    }
}

