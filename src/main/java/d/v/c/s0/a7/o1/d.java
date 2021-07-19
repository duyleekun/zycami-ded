/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment;

public final class d
implements Observer {
    public final /* synthetic */ SetGeneralFragment a;

    public /* synthetic */ d(SetGeneralFragment setGeneralFragment) {
        this.a = setGeneralFragment;
    }

    public final void onChanged(Object object) {
        SetGeneralFragment setGeneralFragment = this.a;
        object = (Boolean)object;
        setGeneralFragment.q((Boolean)object);
    }
}

