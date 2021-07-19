/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.album.AlbumDetailFragment;
import java.util.List;

public final class h
implements Observer {
    public final /* synthetic */ AlbumDetailFragment a;

    public /* synthetic */ h(AlbumDetailFragment albumDetailFragment) {
        this.a = albumDetailFragment;
    }

    public final void onChanged(Object object) {
        AlbumDetailFragment albumDetailFragment = this.a;
        object = (List)object;
        albumDetailFragment.B((List)object);
    }
}

