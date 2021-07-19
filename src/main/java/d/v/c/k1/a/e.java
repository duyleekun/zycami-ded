/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;
import d.v.h.e.a;

public final class e
implements Observer {
    public final /* synthetic */ AddVideoFragment a;

    public /* synthetic */ e(AddVideoFragment addVideoFragment) {
        this.a = addVideoFragment;
    }

    public final void onChanged(Object object) {
        AddVideoFragment addVideoFragment = this.a;
        object = (a)object;
        addVideoFragment.V((a)object);
    }
}

