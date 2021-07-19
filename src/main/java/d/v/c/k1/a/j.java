/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;
import java.util.List;

public final class j
implements Observer {
    public final /* synthetic */ AddVideoFragment a;

    public /* synthetic */ j(AddVideoFragment addVideoFragment) {
        this.a = addVideoFragment;
    }

    public final void onChanged(Object object) {
        AddVideoFragment addVideoFragment = this.a;
        object = (List)object;
        addVideoFragment.X((List)object);
    }
}

