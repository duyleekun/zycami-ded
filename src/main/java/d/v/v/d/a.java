/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.d;

import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsSize;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsStreamingContext$CompileCallback;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsTrack;
import com.zhiyun.editorinterface.compose.ComposeParams;
import d.v.h.c.b;
import d.v.h.c.b$a;
import d.v.v.d.a$a;
import d.v.v.d.a$b;
import d.v.v.j.g;
import d.v.v.j.i;
import d.v.v.q.h;
import java.util.Hashtable;

public class a
implements b {
    private String a;
    private b$a b;
    private ComposeParams c;
    private NvsSize d;
    private boolean e;

    public static /* synthetic */ void a(a a10, int n10) {
        a10.r(n10);
    }

    public static /* synthetic */ boolean b(a a10) {
        return a10.e;
    }

    public static /* synthetic */ void c(a a10) {
        a10.s();
    }

    public static /* synthetic */ void d(a a10) {
        a10.p();
    }

    public static /* synthetic */ void j(a a10, Exception exception) {
        a10.q(exception);
    }

    private void k() {
        int n10;
        int n11;
        Object object;
        Object object2 = this.c;
        if (object2 == null) {
            object2 = NvsStreamingContext.getInstance();
            int n12 = this.o().getVideoRes().imageHeight;
            object2.setCustomCompileVideoHeight(n12);
            return;
        }
        object2 = new Hashtable();
        Object object3 = this.c;
        int n13 = ((ComposeParams)object3).c();
        if (n13 == 0) {
            n13 = 0;
            object3 = null;
        } else {
            object = this.c;
            n11 = ((ComposeParams)object).c();
            n10 = 1;
            object3 = new NvsRational(n11, n10);
        }
        object = "";
        if (object3 == null) {
            object3 = object;
        }
        String string2 = "fps";
        object2.put(string2, object3);
        object3 = this.c;
        long l10 = ((ComposeParams)object3).b();
        long l11 = 0L;
        n13 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n13 == 0) {
            object3 = object;
        } else {
            l10 = this.c.b();
            object3 = l10;
        }
        string2 = "bitrate";
        object2.put(string2, object3);
        object3 = this.c;
        n13 = ((ComposeParams)object3).e();
        if (n13 == 0) {
            object3 = object;
        } else {
            n13 = this.c.e();
            object3 = n13;
        }
        string2 = "gopsize";
        object2.put(string2, object3);
        object3 = this.c;
        n13 = ((ComposeParams)object3).a();
        if (n13 != 0) {
            object3 = this.c;
            n13 = ((ComposeParams)object3).a();
            object = n13;
        }
        object2.put("audio bitrate", object);
        object3 = NvsStreamingContext.getInstance();
        ((NvsStreamingContext)object3).setCompileConfigurations((Hashtable)object2);
        object2 = this.c.d();
        if (object2 != null) {
            object2 = h.f0(this.c.d());
            object3 = h.c0();
            n11 = object2.getWidth();
            if (n11 != (n10 = object3.getWidth()) || (n11 = object2.getHeight()) != (n13 = object3.getHeight())) {
                n13 = object2.getWidth();
                n11 = object2.getHeight();
                d.v.v.q.i.m(n13, n11);
            }
            object3 = NvsStreamingContext.getInstance();
            int n14 = object2.getHeight();
            ((NvsStreamingContext)object3).setCustomCompileVideoHeight(n14);
        }
    }

    private void l() {
        Object object = this.o();
        if (object != null) {
            return;
        }
        object = new IllegalStateException("NvsTimeline should be initialization");
        throw object;
    }

    public static a n() {
        return a$b.a();
    }

    private NvsTimeline o() {
        return i.e().f();
    }

    private void p() {
        int n10;
        Object object = this.o();
        if (object == null) {
            return;
        }
        object = h.S();
        int n11 = ((NvsSize)object).height;
        NvsSize nvsSize = this.d;
        int n12 = nvsSize.height;
        if (n11 != n12 || (n12 = ((NvsSize)object).width) != (n10 = nvsSize.width)) {
            int n13 = ((NvsSize)object).width;
            d.v.v.q.i.m(n13, n11);
        }
    }

    private void q(Exception exception) {
        g.c().f(exception);
        b$a b$a = this.b;
        if (b$a != null) {
            String string2 = exception.getMessage();
            b$a.a(exception, string2);
        }
    }

    private void r(int n10) {
        g.c().g(n10);
        b$a b$a = this.b;
        if (b$a != null) {
            b$a.b(n10);
        }
    }

    private void s() {
        Object object = g.c();
        String string2 = this.a;
        ((g)object).h(string2);
        object = this.b;
        if (object != null) {
            string2 = this.a;
            object.c(string2);
        }
    }

    public boolean e() {
        boolean bl2;
        this.e = bl2 = true;
        NvsStreamingContext.getInstance().stop((int)(bl2 ? 1 : 0));
        return bl2;
    }

    public void f(String string2) {
        this.a = string2;
    }

    public void g(b$a b$a) {
        this.b = b$a;
    }

    public void h(ComposeParams composeParams) {
        this.c = composeParams;
    }

    public void i() {
        Object object = this.o();
        if (object == null) {
            object = new IllegalStateException("NvsTimeline should be initialization");
            this.q((Exception)object);
            return;
        }
        object = this.a;
        if (object == null) {
            object = new IllegalStateException("path can not be null");
            this.q((Exception)object);
            return;
        }
        this.d = object = h.S();
        this.e = false;
        object = h.h0();
        this.k();
        Object object2 = NvsStreamingContext.getInstance();
        NvsTimeline nvsTimeline = this.o();
        long l10 = ((NvsTrack)object).getDuration();
        String string2 = this.a;
        ((NvsStreamingContext)object2).compileTimeline(nvsTimeline, 0L, l10, string2, 256, 2, 0);
        object = NvsStreamingContext.getInstance();
        object2 = new a$a(this);
        ((NvsStreamingContext)object).setCompileCallback((NvsStreamingContext$CompileCallback)object2);
    }

    public void m() {
        this.a = null;
        this.c = null;
        this.b = null;
    }

    public void release() {
    }
}

