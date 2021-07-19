/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.mediaprovider.data.ImageBean;
import com.zhiyun.mediaprovider.data.MediaBean;
import com.zhiyun.mediaprovider.data.VideoBean;
import d.v.c.k1.a.w;
import d.v.e.i.h;
import d.v.h.e.a;
import d.v.s.b.i$a;
import java.util.ArrayList;

public class w$a
implements i$a {
    public final /* synthetic */ w a;

    public w$a(w w10) {
        this.a = w10;
    }

    public void a(MediaBean object) {
        long l10;
        long l11;
        long l12;
        Object object2 = ((MediaBean)object).getPath();
        int n10 = d.v.v.q.h.l0((String)object2);
        if (n10 == 0) {
            return;
        }
        n10 = ((MediaBean)object).getType();
        int n11 = 4;
        int n12 = 2;
        if (n10 != n12 && (n10 = ((MediaBean)object).getType()) != n11) {
            return;
        }
        n10 = ((MediaBean)object).getType();
        if (n10 == n12 && (n10 = (int)((l12 = (l11 = d.v.v.q.h.Z((String)(object2 = ((MediaBean)object).getUri().toString()))) - (l10 = 500000L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) < 0) {
            return;
        }
        object2 = new a();
        Object object3 = ((MediaBean)object).getUri().toString();
        object3 = ((a)object2).l((String)object3);
        String string2 = ((MediaBean)object).getUri().toString();
        ((a)object3).p(string2);
        int n13 = ((MediaBean)object).getType();
        if (n13 != n12) {
            if (n13 != n11) {
                return;
            }
            object = (ImageBean)object;
            long l13 = 3000000L;
            a a10 = ((a)object2).k(l13);
            Object object4 = ((MediaBean)object).getMime();
            n12 = (int)(object4.equals(object3 = "image/gif") ? 1 : 0);
            object4 = n12 != 0 ? MediaType.GIF : MediaType.IMAGE;
            a10.m((MediaType)((Object)object4));
            object = ((MediaBean)object).getMime();
            boolean bl2 = ((String)object).equals(object3);
            if (bl2) {
                object = w.c(this.a);
                ((ArrayList)object).add(object2);
            } else {
                object = w.d(this.a);
                ((ArrayList)object).add(object2);
            }
        } else {
            long l14 = ((VideoBean)object).getDuration();
            l11 = 1000L;
            object = ((a)object2).k(l14 *= l11);
            MediaType mediaType = MediaType.VIDEO;
            ((a)object).m(mediaType);
            object = w.b(this.a);
            ((ArrayList)object).add(object2);
        }
        w.e(this.a).add(object2);
        h.e(w.f(this.a), object2);
    }

    public void b() {
        MutableLiveData mutableLiveData = w.g(this.a);
        Boolean bl2 = Boolean.FALSE;
        h.g(mutableLiveData, bl2);
        mutableLiveData = w.i(this.a);
        bl2 = Boolean.TRUE;
        h.e(mutableLiveData, bl2);
    }

    public void c(Exception object) {
        object = w.g(this.a);
        Boolean bl2 = Boolean.FALSE;
        h.g((MutableLiveData)object, bl2);
        object = w.j(this.a);
        bl2 = Boolean.TRUE;
        h.e((MutableLiveData)object, bl2);
    }
}

