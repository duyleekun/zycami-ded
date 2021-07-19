/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;
import d.v.c.s0.t6;
import d.v.c.t0.u$a;
import d.v.e.l.k2;
import java.io.File;

public class u
extends ViewModel {
    private String a;
    public MutableLiveData b;

    public u() {
        MutableLiveData mutableLiveData;
        this.b = mutableLiveData = new MutableLiveData();
    }

    public void b(String object) {
        Object object2 = t6.f();
        String string2 = k2.k().getAbsolutePath();
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append(string2);
        String string3 = File.separator;
        ((StringBuilder)object3).append(string3);
        ((StringBuilder)object3).append((String)object2);
        object3 = ((StringBuilder)object3).toString();
        this.a = object3;
        object3 = new DownloadEntity((String)object, string2, (String)object2);
        object = DownLoadHelper.getInstance();
        object2 = new u$a(this);
        ((DownLoadHelper)object).startThreadPoolDownLoad((DownloadEntity)object3, (DownLoadHelper$OnDownloadFileCallback)object2, null, true);
    }

    public String c() {
        return this.a;
    }
}

