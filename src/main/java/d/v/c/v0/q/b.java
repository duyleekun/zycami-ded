/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.v0.q;

import android.content.Context;
import com.zhiyun.cama.data.api.entity.FileResourceUrlBean$DataBean;
import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;
import d.v.c.d0;
import d.v.c.v0.q.b$a;
import d.v.c.v0.q.b$b;
import d.v.c.v0.q.b$c;
import d.v.c.v0.q.c;
import d.v.c.v0.q.d;
import d.v.e.f;
import d.v.e.l.b2;
import d.v.e.l.n2;
import d.v.e.l.s1;
import d.v.f.i.g;
import java.io.File;
import java.util.ArrayList;

public class b
extends d.v.j.g.d0.d {
    private final d d;

    public b() {
        d d10;
        this.d = d10 = d.v.c.v0.d.b();
    }

    public static /* synthetic */ void A(b b10, Object object, int n10) {
        b10.s(object, n10);
    }

    public static /* synthetic */ void B(b b10, c c10) {
        b10.N(c10);
    }

    public static /* synthetic */ void C(b b10, Object object) {
        b10.m(object);
    }

    public static /* synthetic */ void D(b b10, Object object) {
        b10.i(object);
    }

    public static /* synthetic */ void E(b b10, Object object) {
        b10.m(object);
    }

    public static /* synthetic */ void F(b b10, Object object) {
        b10.i(object);
    }

    public static /* synthetic */ void G(b b10, Object object, int n10) {
        b10.s(object, n10);
    }

    private void H(c c10, FileResourceUrlBean$DataBean object, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        c10.A((FileResourceUrlBean$DataBean)object);
        Object object2 = s1.y(((FileResourceUrlBean$DataBean)object).getUrl(), "");
        Object object3 = new StringBuilder();
        String string2 = d0.b(c10.y()).getAbsolutePath();
        ((StringBuilder)object3).append(string2);
        string2 = File.separator;
        ((StringBuilder)object3).append(string2);
        string2 = ((FileResourceUrlBean$DataBean)object).getHash();
        ((StringBuilder)object3).append(string2);
        string2 = ".";
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append((String)object2);
        object3 = ((StringBuilder)object3).toString();
        s1.h((String)object3);
        c10.D((String)object3);
        String string3 = ((FileResourceUrlBean$DataBean)object).getUrl();
        String string4 = d0.b(c10.y()).getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        object = ((FileResourceUrlBean$DataBean)object).getHash();
        stringBuilder.append((String)object);
        stringBuilder.append(string2);
        stringBuilder.append((String)object2);
        object = stringBuilder.toString();
        object3 = new DownloadEntity(string3, string4, (String)object, c10);
        object = DownLoadHelper.getInstance();
        object2 = new b$c(this, c10);
        ((DownLoadHelper)object).startThreadPoolDownLoad((DownloadEntity)object3, (DownLoadHelper$OnDownloadFileEntityCallback)object2, downLoadHelper$CancelControl, false);
    }

    private void I(c c10, String arrayList, String object, FileResourceUrlBean$DataBean object2, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        c10.A((FileResourceUrlBean$DataBean)object2);
        String string2 = s1.y(((FileResourceUrlBean$DataBean)object2).getUrl(), "");
        Object object3 = new StringBuilder();
        String string3 = d0.b(c10.y()).getAbsolutePath();
        ((StringBuilder)object3).append(string3);
        string3 = File.separator;
        ((StringBuilder)object3).append(string3);
        ((StringBuilder)object3).append((String)((Object)arrayList));
        CharSequence charSequence = ".";
        ((StringBuilder)object3).append((String)charSequence);
        ((StringBuilder)object3).append(string2);
        object3 = ((StringBuilder)object3).toString();
        s1.h((String)object3);
        c10.D((String)object3);
        object2 = ((FileResourceUrlBean$DataBean)object2).getUrl();
        String string4 = d0.b(c10.y()).getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)((Object)arrayList));
        stringBuilder.append((String)charSequence);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object3 = new DownloadEntity((String)object2, string4, string2, c10);
        object2 = new StringBuilder();
        string2 = d0.b(c10.y()).getAbsolutePath();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append((String)((Object)arrayList));
        string2 = ".lic";
        ((StringBuilder)object2).append(string2);
        s1.h(((StringBuilder)object2).toString());
        string3 = d0.b(c10.y()).getAbsolutePath();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)((Object)arrayList));
        ((StringBuilder)charSequence).append(string2);
        arrayList = ((StringBuilder)charSequence).toString();
        object2 = new DownloadEntity((String)object, string3, (String)((Object)arrayList));
        arrayList = new ArrayList<Object>();
        arrayList.add(object3);
        arrayList.add(object2);
        object = DownLoadHelper.getInstance();
        object2 = new b$b(this, c10);
        ((DownLoadHelper)object).startThreadPoolDownLoad(arrayList, (DownLoadHelper$OnDownloadFileCallback)object2, downLoadHelper$CancelControl, false);
    }

    private void N(c c10) {
        this.d.d(c10);
    }

    public static /* synthetic */ void x(b b10, Object object) {
        b10.i(object);
    }

    public static /* synthetic */ void y(b b10, c c10, FileResourceUrlBean$DataBean fileResourceUrlBean$DataBean, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        b10.H(c10, fileResourceUrlBean$DataBean, downLoadHelper$CancelControl);
    }

    public static /* synthetic */ void z(b b10, c c10, String string2, String string3, FileResourceUrlBean$DataBean fileResourceUrlBean$DataBean, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        b10.I(c10, string2, string3, fileResourceUrlBean$DataBean, downLoadHelper$CancelControl);
    }

    public void J(Context context, long l10, c c10) {
        this.K(context, c10);
    }

    public void K(Context object, c c10) {
        boolean bl2;
        Context context = f.a().c();
        int n10 = b2.m(context);
        if (n10 == 0) {
            n10 = 2131953290;
            object = g.m(object, n10);
            n2.e((String)object);
        }
        if (bl2 = c10.z()) {
            return;
        }
        this.h(c10);
    }

    public Long L(c c10) {
        return c10.x();
    }

    public void M(c c10, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        Object object = this.d;
        long l10 = this.L(c10);
        object = ((d)object).e(l10);
        b$a b$a = new b$a(this, c10, downLoadHelper$CancelControl);
        object.h(b$a);
    }
}

