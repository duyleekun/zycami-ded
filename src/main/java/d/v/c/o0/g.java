/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.album.AlbumDetailFragment;

public final class g
implements Observer {
    public final /* synthetic */ AlbumDetailFragment a;

    public /* synthetic */ g(AlbumDetailFragment albumDetailFragment) {
        this.a = albumDetailFragment;
    }

    public final void onChanged(Object object) {
        AlbumDetailFragment albumDetailFragment = this.a;
        object = (Integer)object;
        albumDetailFragment.D((Integer)object);
    }
}

