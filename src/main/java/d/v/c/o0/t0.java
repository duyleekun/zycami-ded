/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.o0;

import android.text.TextUtils;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumSection;

public class t0
extends DiffUtil$ItemCallback {
    public boolean a(AlbumSection parcelable, AlbumSection parcelable2) {
        boolean bl2 = parcelable.isHeader();
        boolean bl3 = true;
        if (bl2 && (bl2 = parcelable2.isHeader())) {
            boolean bl4;
            parcelable = parcelable.getAlbum().isChecked;
            boolean bl5 = parcelable.get();
            if (bl5 != (bl4 = (parcelable2 = parcelable2.getAlbum().isChecked).get())) {
                bl3 = false;
            }
            return bl3;
        }
        bl2 = parcelable.isHeader();
        if (!bl2 && !(bl2 = parcelable2.isHeader())) {
            boolean bl6;
            boolean bl7;
            ObservableBoolean observableBoolean;
            boolean bl8;
            ObservableBoolean observableBoolean2 = parcelable.getAlbum().favorite;
            bl2 = observableBoolean2.get();
            if (bl2 != (bl8 = (observableBoolean = parcelable2.getAlbum().favorite).get()) || (bl7 = (parcelable = parcelable.getAlbum().isChecked).get()) != (bl6 = (parcelable2 = parcelable2.getAlbum().isChecked).get())) {
                bl3 = false;
            }
            return bl3;
        }
        return false;
    }

    public boolean b(AlbumSection object, AlbumSection object2) {
        boolean bl2 = ((AlbumSection)object).isHeader();
        if (bl2 && (bl2 = ((AlbumSection)object2).isHeader())) {
            object = (CharSequence)object.getAlbum().addTimeDay.get();
            object2 = (CharSequence)object2.getAlbum().addTimeDay.get();
            return TextUtils.equals((CharSequence)object, (CharSequence)object2);
        }
        bl2 = ((AlbumSection)object).isHeader();
        boolean bl3 = false;
        if (!bl2 && !(bl2 = ((AlbumSection)object2).isHeader())) {
            object = ((AlbumSection)object).getAlbum();
            int n10 = ((Album)object).id;
            object2 = ((AlbumSection)object2).getAlbum();
            int n11 = ((Album)object2).id;
            if (n10 == n11) {
                bl3 = true;
            }
        }
        return bl3;
    }
}

