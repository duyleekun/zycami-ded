/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.o0;

import android.text.TextUtils;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.mediaprovider.data.ImageBean;
import com.zhiyun.mediaprovider.data.MediaBean;
import com.zhiyun.mediaprovider.data.VideoBean;
import d.v.c.o0.u0;
import d.v.e.i.h;
import d.v.e.l.m1;
import d.v.s.b.i$a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class u0$a
implements i$a {
    public final /* synthetic */ u0 a;

    public u0$a(u0 u02) {
        this.a = u02;
    }

    public void a(MediaBean object) {
        long l10;
        int n10;
        Object object2;
        int n11;
        Object object3;
        Object object4;
        Object object5;
        int n12;
        int n13;
        block11: {
            Object object6;
            int n14;
            block10: {
                n13 = ((MediaBean)object).getType();
                if (n13 == (n12 = 2)) {
                    long l11;
                    object5 = object;
                    object5 = (VideoBean)object;
                    long l12 = ((VideoBean)object5).getDuration();
                    long l13 = l12 - (l11 = 0L);
                    n13 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                    if (n13 == 0) {
                        return;
                    }
                }
                object5 = this.a;
                n13 = (int)(u0.b((u0)object5) ? 1 : 0);
                object4 = "album_like";
                if (n13 != 0 && (n13 = (int)(TextUtils.equals((CharSequence)object4, (CharSequence)(object5 = ((MediaBean)object).getTag())) ? 1 : 0)) == 0) {
                    return;
                }
                long l14 = ((MediaBean)object).getDateAdded();
                object5 = m1.q(l14);
                object3 = u0.c(this.a);
                n14 = object3.size();
                n11 = 1;
                if (n14 == 0) break block10;
                object3 = u0.c(this.a);
                object2 = u0.c(this.a);
                n10 = object2.size() - n11;
                object3 = (CharSequence)((AlbumSection)object3.get((int)n10)).getAlbum().addTimeDay.get();
                n14 = (int)(TextUtils.equals((CharSequence)object3, (CharSequence)object5) ? 1 : 0);
                if (n14 != 0) break block11;
            }
            if ((n14 = (object3 = u0.c(this.a)).size()) != 0) {
                object3 = this.a.c;
                object6 = u0.c(this.a);
                object2 = new ArrayList(object6);
                h.g((MutableLiveData)object3, object2);
            }
            object3 = new Album();
            ((Album)object3).addTimeDay.set(object5);
            ((Album)object3).isChecked.set(false);
            object2 = u0.c(this.a);
            object6 = new AlbumSection(n11 != 0, (Album)object3);
            object2.add(object6);
        }
        object3 = new Album();
        ((Album)object3).id = n10 = ((MediaBean)object).getId();
        ((Album)object3).path = object2 = ((MediaBean)object).getPath();
        ((Album)object3).mime = object2 = ((MediaBean)object).getMime();
        ((Album)object3).displayName = object2 = ((MediaBean)object).getDisplayName();
        ((Album)object3).addDate = l10 = ((MediaBean)object).getDateAdded();
        object2 = ((Album)object3).addTimeDay;
        ((ObservableField)object2).set(object5);
        object5 = ((MediaBean)object).getUri();
        ((Album)object3).uri = object5;
        object5 = ((MediaBean)object).getTag();
        n13 = (int)(TextUtils.equals((CharSequence)object4, (CharSequence)object5) ? 1 : 0);
        object4 = ((Album)object3).favorite;
        ((ObservableBoolean)object4).set(n13 != 0);
        n13 = ((MediaBean)object).getType();
        if (n13 == n12) {
            int n15;
            long l15;
            object = (VideoBean)object;
            ((Album)object3).duration = l15 = ((VideoBean)object).getDuration();
            ((Album)object3).isVideo = n11;
            ((Album)object3).height = n13 = ((VideoBean)object).getHeight();
            ((Album)object3).width = n13 = ((VideoBean)object).getWidth();
            ((Album)object3).orientation = n15 = ((VideoBean)object).getOrientation();
        } else {
            n13 = ((MediaBean)object).getType();
            if (n13 == (n12 = 4)) {
                int n16;
                object = (ImageBean)object;
                ((Album)object3).isVideo = false;
                ((Album)object3).height = n13 = ((ImageBean)object).getHeight();
                ((Album)object3).width = n13 = ((ImageBean)object).getWidth();
                ((Album)object3).orientation = n16 = ((ImageBean)object).getOrientation();
            }
        }
        object = u0.c(this.a);
        object5 = new AlbumSection(false, (Album)object3);
        object.add(object5);
    }

    public void b() {
        MutableLiveData mutableLiveData = this.a.c;
        List list = u0.c(this.a);
        Serializable serializable = new Serializable(list);
        h.g(mutableLiveData, serializable);
        mutableLiveData = this.a.e;
        serializable = Boolean.FALSE;
        mutableLiveData.postValue(serializable);
    }

    public void c(Exception object) {
        object = this.a.e;
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).postValue(bl2);
    }
}

