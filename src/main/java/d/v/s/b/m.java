/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.s.b;

import android.content.Context;
import com.zhiyun.mediaprovider.data.MediaBean;
import com.zhiyun.mediaprovider.data.local.MediaDatabaseCommHelp;
import com.zhiyun.mediaprovider.data.local.dao.AlbumCustomizeDao;
import com.zhiyun.mediaprovider.data.local.model.AlbumCustomizeData;
import d.v.s.b.j;
import java.lang.ref.WeakReference;

public class m
implements j {
    private final WeakReference a;
    private final AlbumCustomizeDao b;

    private m(Context object) {
        Context context;
        this.a = context = new WeakReference(object);
        object = MediaDatabaseCommHelp.getInstance();
        context = (Context)context.get();
        this.b = object = ((MediaDatabaseCommHelp)object).getDataBase(context).albumCustomizeDao();
    }

    public static m B(Context context) {
        m m10 = new m(context);
        return m10;
    }

    public void d(int n10, String string2, boolean bl2) {
        String string3 = "album_like";
        if (bl2) {
            AlbumCustomizeData albumCustomizeData = new AlbumCustomizeData(string3, n10, string2);
            AlbumCustomizeDao albumCustomizeDao = this.b;
            albumCustomizeDao.insertAlbumCustomizeData(albumCustomizeData);
        } else {
            AlbumCustomizeDao albumCustomizeDao = this.b;
            albumCustomizeDao.deleteAlbumLikeData(string3, n10, string2);
        }
    }

    public void k(MediaBean mediaBean, boolean bl2) {
        int n10 = mediaBean.getId();
        this.n(n10, bl2);
    }

    public void n(int n10, boolean bl2) {
        if (bl2) {
            String string2 = "album_like";
            String string3 = "";
            AlbumCustomizeData albumCustomizeData = new AlbumCustomizeData(string2, n10, string3);
            AlbumCustomizeDao albumCustomizeDao = this.b;
            albumCustomizeDao.insertAlbumCustomizeData(albumCustomizeData);
        } else {
            AlbumCustomizeDao albumCustomizeDao = this.b;
            albumCustomizeDao.deleteAlbumLikeData(n10);
        }
    }
}

