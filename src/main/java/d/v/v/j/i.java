/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.v.j;

import android.util.Size;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsVideoResolution;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.d.c;
import d.v.h.e.a;
import d.v.h.e.d;
import d.v.v.f.j;
import d.v.v.g.f;
import d.v.v.j.g;
import d.v.v.j.h;
import d.v.v.j.i$a;
import java.util.Iterator;
import java.util.List;

public class i {
    private NvsTimeline a;
    private NvsTimeline b;
    private boolean c = true;

    private NvsTimeline b(a[] object, int n10, boolean bl2) {
        int n11;
        NvsVideoResolution nvsVideoResolution;
        int n12 = (object = d.v.v.q.j.g((a[])object)).isEmpty();
        if (n12 != 0) {
            return null;
        }
        n12 = -1;
        if (bl2) {
            int n13;
            NvsTimelineData nvsTimelineData = h.t().u();
            if (n10 == n12) {
                n10 = nvsTimelineData.getAspectRadio();
            }
            nvsTimelineData = nvsTimelineData.getResolutionSize();
            nvsVideoResolution = new NvsVideoResolution();
            nvsVideoResolution.imageWidth = n11 = nvsTimelineData.getWidth();
            nvsVideoResolution.imageHeight = n13 = nvsTimelineData.getHeight();
        } else {
            if (n10 == n12) {
                n10 = d.v.v.q.j.e((List)object);
            }
            boolean bl3 = false;
            d d10 = (d)object.get(0);
            nvsVideoResolution = d.v.v.q.j.j(n10, d10);
        }
        object = h.t().n().setMediaInfoList((List)object).setAspectRadio(n10);
        int n14 = nvsVideoResolution.imageWidth;
        n11 = nvsVideoResolution.imageHeight;
        Size size = new Size(n14, n11);
        ((NvsTimelineData)object).setResolutionSize(size);
        return d.v.v.q.i.o(nvsVideoResolution);
    }

    private void c() {
        List list;
        Object object = h.t().u();
        if (object != null && (list = ((NvsTimelineData)object).getMediaInfoList()) != null) {
            int n10;
            object = ((NvsTimelineData)object).getMediaInfoList();
            list = null;
            for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
                Object object2 = (d)object.get(i10);
                n10 = (int)(((d)object2).P() ? 1 : 0);
                if (n10 == 0) continue;
                object2 = f.k();
                ((f)object2).j(i10);
            }
        }
    }

    public static i e() {
        return i$a.a();
    }

    private void n() {
        Iterator iterator2 = h.t().o();
        Object object = h.t().u();
        if (iterator2 != null && object != null) {
            boolean bl2;
            boolean bl3;
            Object object2 = ((NvsTimelineData)((Object)iterator2)).getMediaInfoList();
            iterator2 = ((NvsTimelineData)((Object)iterator2)).getPasteInfoList();
            List list = ((NvsTimelineData)object).getMediaInfoList();
            if (object2 != null && !(bl3 = object2.isEmpty()) && list != null && !(bl2 = list.isEmpty())) {
                boolean bl4;
                boolean bl5;
                this.c();
                long l10 = d.v.v.q.h.z();
                object2 = object2.iterator();
                while (bl5 = object2.hasNext()) {
                    d d10 = (d)object2.next();
                    boolean bl6 = true;
                    d10.X(bl6);
                    f f10 = f.k();
                    List list2 = ((NvsTimelineData)object).getMediaInfoList();
                    int n10 = list2.size();
                    f10.b(n10, d10);
                }
                if (iterator2 != null && !(bl4 = iterator2.isEmpty())) {
                    iterator2 = iterator2.iterator();
                    while (bl4 = iterator2.hasNext()) {
                        object = (c)iterator2.next();
                        long l11 = ((d.v.h.d.a)object).e() + l10;
                        object2 = l11;
                        ((d.v.h.d.a)object).m((Long)object2);
                        j.z().a((c)object);
                        object2 = h.t();
                        ((h)object2).d((c)object);
                    }
                }
            }
        }
    }

    public void a() {
        this.c();
        this.c = true;
        h.t().G();
        NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
        NvsTimeline nvsTimeline = this.b;
        nvsStreamingContext.removeTimeline(nvsTimeline);
        this.b = null;
    }

    public void d(boolean bl2) {
        boolean bl3;
        this.c = bl3 = true;
        if (bl2) {
            this.n();
        }
        h.t().G();
        NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
        NvsTimeline nvsTimeline = this.b;
        nvsStreamingContext.removeTimeline(nvsTimeline);
        this.b = null;
    }

    public NvsTimeline f() {
        boolean bl2 = this.c;
        Object object = bl2 ? this.a : this.b;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("NvsTimeline should be initialization");
        throw object;
    }

    public boolean g(a[] object) {
        int n10;
        boolean bl2 = false;
        this.c = false;
        Object object2 = this.b;
        if (object2 != null) {
            h.t().G();
            object2 = NvsStreamingContext.getInstance();
            NvsTimeline nvsTimeline = this.b;
            ((NvsStreamingContext)object2).removeTimeline(nvsTimeline);
            n10 = 0;
            object2 = null;
            this.b = null;
        }
        n10 = -1;
        boolean bl3 = true;
        this.b = object = this.b((a[])object, n10, bl3);
        if (object != null) {
            bl2 = bl3;
        }
        if (bl2) {
            d.v.v.q.i.s((NvsTimeline)object);
        } else {
            this.c = bl3;
        }
        g.c().m(bl2);
        return bl2;
    }

    public boolean h(a[] object, int n10) {
        boolean bl2;
        this.c = bl2 = true;
        Object object2 = this.a;
        if (object2 != null) {
            object2 = NvsStreamingContext.getInstance();
            NvsTimeline nvsTimeline = this.a;
            ((NvsStreamingContext)object2).removeTimeline(nvsTimeline);
            object2 = null;
            this.a = null;
        }
        object2 = null;
        this.a = object = this.b((a[])object, n10, false);
        if (object == null) {
            bl2 = false;
        }
        if (bl2) {
            d.v.v.q.i.s((NvsTimeline)object);
        }
        return bl2;
    }

    public boolean i() {
        boolean bl2 = this.c;
        NvsTimeline nvsTimeline = bl2 ? this.a : this.b;
        if (nvsTimeline != null) {
            bl2 = true;
        } else {
            bl2 = false;
            nvsTimeline = null;
        }
        return bl2;
    }

    public boolean j() {
        return this.c;
    }

    public boolean k() {
        boolean bl2 = this.c;
        NvsTimeline nvsTimeline = bl2 ? this.a : this.b;
        if (nvsTimeline == null) {
            bl2 = true;
        } else {
            bl2 = false;
            nvsTimeline = null;
        }
        return bl2;
    }

    public boolean l() {
        boolean bl2 = this.c;
        NvsTimeline nvsTimeline = bl2 ? this.a : this.b;
        if (nvsTimeline != null) {
            bl2 = true;
        } else {
            bl2 = false;
            nvsTimeline = null;
        }
        return bl2;
    }

    public void m() {
        NvsTimeline nvsTimeline;
        Object object = this.a;
        if (object != null) {
            object = NvsStreamingContext.getInstance();
            nvsTimeline = this.a;
            ((NvsStreamingContext)object).removeTimeline(nvsTimeline);
            this.a = null;
        }
        if ((object = this.b) != null) {
            object = NvsStreamingContext.getInstance();
            nvsTimeline = this.b;
            ((NvsStreamingContext)object).removeTimeline(nvsTimeline);
            this.b = null;
        }
    }
}

