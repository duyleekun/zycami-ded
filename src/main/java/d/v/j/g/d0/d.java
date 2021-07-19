/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g.d0;

import com.zhiyun.editortemplate.util.DownloadState;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import d.v.j.g.d0.d$a;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import m.a.a;

public abstract class d {
    private final List a;
    private final Map b;
    private final Map c;

    public d() {
        Serializable serializable;
        this.a = serializable = new Serializable();
        this.b = serializable;
        super();
        this.c = serializable;
    }

    public void a(Object object, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        Map map = this.c;
        object = this.q(object);
        map.put(object, downLoadHelper$CancelControl);
    }

    public void b(d$a d$a) {
        this.a.add(d$a);
    }

    public void c(Object object, DownloadEvent downloadEvent) {
        Object object2 = this.q(object);
        Object object3 = this.a;
        if (object3 != null) {
            object3 = new Object();
            ((StringBuilder)object3).append("notifyDownloadState:");
            ((StringBuilder)object3).append(downloadEvent);
            object3 = ((StringBuilder)object3).toString();
            boolean bl2 = false;
            Object object4 = new Object[]{};
            m.a.a.b((String)object3, (Object[])object4);
            object3 = this.a.iterator();
            while (bl2 = object3.hasNext()) {
                object4 = (d$a)object3.next();
                object4.a(object2, object, downloadEvent);
            }
        }
    }

    public void d() {
        boolean bl2;
        Object object = new Object[]{};
        Object object2 = "cancelAllTask, \u53d6\u6d88\u5168\u90e8\u4e0b\u8f7d\u4efb\u52a1";
        m.a.a.b((String)object2, (Object[])object);
        object = this.c.values().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (DownLoadHelper$CancelControl)object.next();
            ((DownLoadHelper$CancelControl)object2).cancel();
        }
        this.c.clear();
        this.b.clear();
    }

    public boolean e(Object object) {
        boolean bl2;
        Map map = this.c;
        object = this.q(object);
        if ((object = map.get(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void f(Object object) {
        object = this.q(object);
        this.g(object);
    }

    public void g(Object object) {
        this.b.remove(object);
    }

    public boolean h(Object object) {
        boolean bl2 = this.e(object);
        if (bl2) {
            return false;
        }
        DownLoadHelper$CancelControl downLoadHelper$CancelControl = new DownLoadHelper$CancelControl();
        this.a(object, downLoadHelper$CancelControl);
        int n10 = this.r();
        this.s(object, n10);
        this.u(object, downLoadHelper$CancelControl);
        return true;
    }

    public void i(Object object) {
        DownloadState downloadState = DownloadState.DOWNLOAD_FAILED;
        this.t(object, downloadState);
    }

    public void j(Object object) {
        DownloadState downloadState = DownloadState.INSUFFICIENT_RESOURCES;
        this.t(object, downloadState);
    }

    public void k(Object object) {
        DownloadState downloadState = DownloadState.DOWNLOAD_NETWORK_FAILED;
        this.t(object, downloadState);
    }

    public void l(Object object) {
        DownloadState downloadState = DownloadState.PARSE_ERROR;
        this.t(object, downloadState);
    }

    public void m(Object object) {
        DownloadState downloadState = DownloadState.DOWNLOAD_SUCCESSFUL;
        this.t(object, downloadState);
    }

    public DownloadEvent n(Object object) {
        object = this.q(object);
        return this.o(object);
    }

    public DownloadEvent o(Object object) {
        return (DownloadEvent)this.b.get(object);
    }

    public DownloadEvent p(Object object) {
        DownloadEvent downloadEvent = (DownloadEvent)this.b.get(object = this.q(object));
        if (downloadEvent == null) {
            downloadEvent = new DownloadEvent();
            Map map = this.b;
            map.put(object, downloadEvent);
        }
        return downloadEvent;
    }

    public abstract Object q(Object var1);

    public int r() {
        return 0;
    }

    public void s(Object object, int n10) {
        DownloadEvent downloadEvent = this.p(object);
        DownloadState downloadState = DownloadState.DOWNLOADING;
        downloadEvent.setDownloadState(downloadState);
        downloadEvent.setProgress(n10);
        this.c(object, downloadEvent);
    }

    public void t(Object object, DownloadState downloadState) {
        this.v(object);
        DownloadEvent downloadEvent = this.p(object);
        downloadEvent.setDownloadState(downloadState);
        downloadEvent.setProgress(-1);
        this.c(object, downloadEvent);
    }

    public abstract void u(Object var1, DownLoadHelper$CancelControl var2);

    public void v(Object object) {
        Map map = this.c;
        object = this.q(object);
        map.remove(object);
    }

    public boolean w(d$a d$a) {
        return this.a.remove(d$a);
    }
}

