/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.album.AlbumDeleteConfirmDialog;

public final class b
implements Observer {
    public final /* synthetic */ AlbumDeleteConfirmDialog a;

    public /* synthetic */ b(AlbumDeleteConfirmDialog albumDeleteConfirmDialog) {
        this.a = albumDeleteConfirmDialog;
    }

    public final void onChanged(Object object) {
        AlbumDeleteConfirmDialog albumDeleteConfirmDialog = this.a;
        object = (Integer)object;
        albumDeleteConfirmDialog.x((Integer)object);
    }
}

