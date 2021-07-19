/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.v0.q;

import android.text.TextUtils;
import com.zhiyun.cama.data.api.entity.FileResourceUrlBean;
import com.zhiyun.cama.data.api.entity.FileResourceUrlBean$DataBean;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import d.v.c.v0.q.a;
import d.v.c.v0.q.b;
import d.v.c.v0.q.c;
import d.v.e.l.c1;
import k.d;
import k.f;
import k.r;

public class b$a
implements f {
    public final /* synthetic */ c a;
    public final /* synthetic */ DownLoadHelper$CancelControl b;
    public final /* synthetic */ b c;

    public b$a(b b10, c c10, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        this.c = b10;
        this.a = c10;
        this.b = downLoadHelper$CancelControl;
    }

    private /* synthetic */ void a(c c10, r object, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        Object object2 = c10.v();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = c10.w())))) {
            b b10 = this.c;
            String string2 = c10.v();
            String string3 = c10.w();
            object = (FileResourceUrlBean)((r)object).a();
            FileResourceUrlBean$DataBean fileResourceUrlBean$DataBean = ((FileResourceUrlBean)object).getData();
            d.v.c.v0.q.b.z(b10, c10, string2, string3, fileResourceUrlBean$DataBean, downLoadHelper$CancelControl);
        } else {
            object2 = this.c;
            object = ((FileResourceUrlBean)((r)object).a()).getData();
            d.v.c.v0.q.b.y((b)object2, c10, (FileResourceUrlBean$DataBean)object, downLoadHelper$CancelControl);
        }
    }

    public /* synthetic */ void b(c c10, r r10, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        this.a(c10, r10, downLoadHelper$CancelControl);
    }

    public void onFailure(d object, Throwable object2) {
        object = this.c;
        object2 = this.a;
        d.v.c.v0.q.b.x((b)object, object2);
    }

    public void onResponse(d object, r r10) {
        boolean bl2 = r10.g();
        if (bl2 && (object = r10.a()) != null && (object = ((FileResourceUrlBean)r10.a()).getData()) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((FileResourceUrlBean)r10.a()).getData().getUrl())))) {
            object = c1.b().d();
            c c10 = this.a;
            DownLoadHelper$CancelControl downLoadHelper$CancelControl = this.b;
            a a10 = new a(this, c10, r10, downLoadHelper$CancelControl);
            object.execute(a10);
        }
    }
}

