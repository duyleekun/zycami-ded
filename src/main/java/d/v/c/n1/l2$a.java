/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.v.c.n1;

import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.mediaprovider.data.MediaBean;
import com.zhiyun.mediaprovider.data.VideoBean;
import d.v.c.n1.l2;
import d.v.e.i.h;
import d.v.e.l.s1;
import d.v.h.e.a;
import d.v.s.b.i$a;

public class l2$a
implements i$a {
    public final /* synthetic */ l2 a;

    public l2$a(l2 l22) {
        this.a = l22;
    }

    public void a(MediaBean object) {
        block6: {
            Object object2;
            Object object3;
            block5: {
                int n10;
                int n11;
                block4: {
                    object3 = ((MediaBean)object).getPath();
                    boolean bl2 = s1.q((String)object3);
                    if (!bl2) {
                        return;
                    }
                    object3 = new a();
                    object2 = ((MediaBean)object).getPath();
                    object3 = ((a)object3).l((String)object2);
                    object2 = ((MediaBean)object).getPath();
                    object3 = ((a)object3).p((String)object2);
                    n11 = ((MediaBean)object).getType();
                    if (n11 != (n10 = 2)) break block4;
                    object2 = object;
                    long l10 = ((VideoBean)object).getDuration();
                    long l11 = 1000L;
                    object2 = ((a)object3).k(l10 *= l11);
                    MediaType mediaType = MediaType.VIDEO;
                    ((a)object2).m(mediaType);
                    break block5;
                }
                n11 = ((MediaBean)object).getType();
                if (n11 != (n10 = 4)) break block6;
                object2 = MediaType.IMAGE;
                ((a)object3).m((MediaType)((Object)object2));
            }
            object2 = new UploadCEMediaInfo((a)object3);
            object = ((MediaBean)object).getUri();
            ((UploadCEMediaInfo)object2).f((Uri)object);
            object = l2.b(this.a);
            h.e((MutableLiveData)object, object2);
        }
    }

    public void b() {
        MutableLiveData mutableLiveData = l2.c(this.a);
        Boolean bl2 = Boolean.FALSE;
        h.g(mutableLiveData, bl2);
        mutableLiveData = l2.d(this.a);
        bl2 = Boolean.TRUE;
        h.e(mutableLiveData, bl2);
    }

    public void c(Exception object) {
        object = l2.c(this.a);
        Boolean bl2 = Boolean.FALSE;
        h.g((MutableLiveData)object, bl2);
        object = l2.e(this.a);
        bl2 = Boolean.TRUE;
        h.e((MutableLiveData)object, bl2);
    }
}

