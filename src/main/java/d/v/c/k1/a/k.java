/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;

public final class k
implements Observer {
    public final /* synthetic */ AddVideoFragment a;

    public /* synthetic */ k(AddVideoFragment addVideoFragment) {
        this.a = addVideoFragment;
    }

    public final void onChanged(Object object) {
        AddVideoFragment addVideoFragment = this.a;
        object = (Boolean)object;
        addVideoFragment.L((Boolean)object);
    }
}

