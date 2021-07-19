/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.v;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.data.database.model.music.AlbumData;

public class k$a
extends DiffUtil$ItemCallback {
    public boolean a(AlbumData albumData, AlbumData albumData2) {
        return albumData.equals(albumData2);
    }

    public boolean b(AlbumData albumData, AlbumData albumData2) {
        long l10;
        long l11 = albumData.getResId();
        long l12 = l11 - (l10 = albumData2.getResId());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            albumData = null;
        }
        return (boolean)object;
    }
}

