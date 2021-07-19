/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;

public final class b
implements Observer {
    public final /* synthetic */ AddVideoFragment a;

    public /* synthetic */ b(AddVideoFragment addVideoFragment) {
        this.a = addVideoFragment;
    }

    public final void onChanged(Object object) {
        AddVideoFragment addVideoFragment = this.a;
        object = (Integer)object;
        addVideoFragment.R((Integer)object);
    }
}

