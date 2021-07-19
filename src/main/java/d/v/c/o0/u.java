/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.album.AlbumListFragment;

public final class u
implements Observer {
    public final /* synthetic */ AlbumListFragment a;

    public /* synthetic */ u(AlbumListFragment albumListFragment) {
        this.a = albumListFragment;
    }

    public final void onChanged(Object object) {
        AlbumListFragment albumListFragment = this.a;
        object = (Boolean)object;
        albumListFragment.y((Boolean)object);
    }
}

