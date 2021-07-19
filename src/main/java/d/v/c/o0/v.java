/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.album.AlbumListFragment;
import java.util.List;

public final class v
implements Observer {
    public final /* synthetic */ AlbumListFragment a;

    public /* synthetic */ v(AlbumListFragment albumListFragment) {
        this.a = albumListFragment;
    }

    public final void onChanged(Object object) {
        AlbumListFragment albumListFragment = this.a;
        object = (List)object;
        AlbumListFragment.s(albumListFragment, (List)object);
    }
}

