/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.j;

import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.v.f.j;
import d.v.v.j.a;
import d.v.v.j.b;
import d.v.v.j.c;
import d.v.v.j.d;
import d.v.v.j.e;
import d.v.v.j.f;
import d.v.v.j.h$a;
import d.v.v.j.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class h {
    private NvsTimelineData a;
    private NvsTimelineData b;

    public h() {
        NvsTimelineData nvsTimelineData;
        this.a = nvsTimelineData = new NvsTimelineData();
        this.b = nvsTimelineData = new NvsTimelineData();
    }

    public static /* synthetic */ boolean A(d.v.h.d.c object) {
        boolean bl2;
        DecorationType decorationType;
        if ((object = object.g()) == (decorationType = DecorationType.GIF_PASTER)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ boolean B(d.v.h.d.c object) {
        boolean bl2;
        DecorationType decorationType;
        if ((object = object.g()) == (decorationType = DecorationType.GIF_PASTER)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ boolean C(d.v.h.d.c object) {
        boolean bl2;
        DecorationType decorationType;
        if ((object = object.g()) == (decorationType = DecorationType.IMAGE_PASTER)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ boolean D(d.v.h.d.c object) {
        boolean bl2;
        DecorationType decorationType;
        if ((object = object.g()) == (decorationType = DecorationType.IMAGE_PASTER)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ int E(d.v.h.d.a object, d.v.h.d.a object2) {
        object = ((d.v.h.d.a)object).e();
        object2 = ((d.v.h.d.a)object2).e();
        return ((Long)object).compareTo((Long)object2);
    }

    public static /* synthetic */ int F(d.v.h.h.b object, d.v.h.h.b object2) {
        object = ((d.v.h.h.b)object).d();
        object2 = ((d.v.h.h.b)object2).d();
        return ((Long)object).compareTo((Long)object2);
    }

    private void h(NvsTimelineData object) {
        int n10;
        long l10 = d.v.v.q.h.z();
        object = ((NvsTimelineData)object).getTextInfoList();
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            Object object2 = (d.v.h.d.d)object.get(i10);
            if (object2 == null) continue;
            Long l11 = ((d.v.h.d.a)object2).e();
            long l12 = l11;
            long l13 = l12 - l10;
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 >= 0) {
                object2 = j.z();
                ((j)object2).R(i10);
                this.L(i10);
                i10 += -1;
                continue;
            }
            l11 = ((d.v.h.d.a)object2).e();
            l12 = l11;
            long l14 = ((d.v.h.d.a)object2).i();
            long l15 = (l12 += l14) - l10;
            n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n10 <= 0) continue;
            object2 = j.z();
            ((j)object2).r(i10, l10);
        }
    }

    private void k(NvsTimelineData object) {
        int n10;
        long l10 = d.v.v.q.h.z();
        object = ((NvsTimelineData)object).getPasteInfoList();
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            Object object2 = (d.v.h.d.c)object.get(i10);
            if (object2 == null) continue;
            Long l11 = ((d.v.h.d.a)object2).e();
            long l12 = l11;
            long l13 = l12 - l10;
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 >= 0) {
                object2 = j.z();
                ((j)object2).Q(i10);
                this.L(i10);
                i10 += -1;
                continue;
            }
            l11 = ((d.v.h.d.a)object2).e();
            l12 = l11;
            long l14 = ((d.v.h.d.a)object2).i();
            long l15 = (l12 += l14) - l10;
            n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n10 <= 0) continue;
            object2 = j.z();
            ((j)object2).o(i10, l10);
        }
    }

    public static h t() {
        return h$a.a();
    }

    public void G() {
        NvsTimelineData nvsTimelineData;
        this.b = nvsTimelineData = new NvsTimelineData();
    }

    public boolean H(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return false;
        }
        if ((object = ((NvsTimelineData)object).getMediaInfoList()) != null && n10 >= 0 && n10 < (n11 = object.size())) {
            object.remove(n10);
            return true;
        }
        return false;
    }

    public boolean I(d.v.h.e.d d10) {
        Object object = this.n();
        if (object == null) {
            return false;
        }
        if ((object = ((NvsTimelineData)object).getMediaInfoList()) == null) {
            return false;
        }
        object.remove(d10);
        return true;
    }

    public boolean J(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return false;
        }
        if ((object = ((NvsTimelineData)object).getMusicInfoList()) != null && n10 >= 0 && n10 < (n11 = object.size())) {
            object.remove(n10);
            return true;
        }
        return false;
    }

    public boolean K(d.v.h.h.b b10) {
        Object object = this.n();
        if (object == null) {
            return false;
        }
        if ((object = ((NvsTimelineData)object).getMusicInfoList()) == null) {
            return false;
        }
        object.remove(b10);
        return true;
    }

    public boolean L(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return false;
        }
        object = ((NvsTimelineData)object).getPasteInfoList();
        if (n10 >= 0 && object != null && n10 < (n11 = object.size())) {
            object.remove(n10);
            return true;
        }
        return false;
    }

    public boolean M(d.v.h.d.c c10) {
        Object object = this.n();
        if (object == null) {
            return false;
        }
        if ((object = ((NvsTimelineData)object).getPasteInfoList()) == null) {
            return false;
        }
        object.remove(c10);
        return true;
    }

    public boolean N(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return false;
        }
        if ((object = ((NvsTimelineData)object).getRecordInfoList()) != null && n10 >= 0 && n10 < (n11 = object.size())) {
            object.remove(n10);
            return true;
        }
        return false;
    }

    public boolean O(d.v.h.h.b b10) {
        Object object = this.n();
        if (object == null) {
            return false;
        }
        if ((object = ((NvsTimelineData)object).getRecordInfoList()) == null) {
            return false;
        }
        object.remove(b10);
        return true;
    }

    public boolean P(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return false;
        }
        object = ((NvsTimelineData)object).getTextInfoList();
        if (n10 >= 0 && object != null && n10 < (n11 = object.size())) {
            object.remove(n10);
            return true;
        }
        return false;
    }

    public boolean Q(d.v.h.d.d d10) {
        Object object = this.n();
        if (object == null) {
            return false;
        }
        if ((object = ((NvsTimelineData)object).getTextInfoList()) == null) {
            return false;
        }
        object.remove(d10);
        return true;
    }

    public void R(List list) {
        if (list == null) {
            return;
        }
        b b10 = d.v.v.j.b.a;
        Collections.sort(list, b10);
    }

    public void S(List list) {
        if (list == null) {
            return;
        }
        d d10 = d.a;
        Collections.sort(list, d10);
    }

    public boolean a(int n10, d.v.h.e.d d10) {
        NvsTimelineData nvsTimelineData = this.n();
        ArrayList arrayList = null;
        if (nvsTimelineData == null) {
            return false;
        }
        if (d10 == null) {
            return false;
        }
        arrayList = nvsTimelineData.getMediaInfoList();
        if (arrayList == null) {
            arrayList = new ArrayList();
            nvsTimelineData.setMediaInfoList(arrayList);
        }
        nvsTimelineData.getMediaInfoList().add(n10, d10);
        return true;
    }

    public boolean b(int n10, d.v.h.h.b b10) {
        NvsTimelineData nvsTimelineData = this.n();
        ArrayList arrayList = null;
        if (nvsTimelineData == null) {
            return false;
        }
        if (b10 == null) {
            return false;
        }
        arrayList = nvsTimelineData.getMusicInfoList();
        if (arrayList == null) {
            arrayList = new ArrayList();
            nvsTimelineData.setMusicInfoList(arrayList);
        }
        nvsTimelineData.getMusicInfoList().add(n10, b10);
        List list = nvsTimelineData.getMusicInfoList();
        this.S(list);
        return true;
    }

    public boolean c(d.v.h.h.b object) {
        NvsTimelineData nvsTimelineData = this.n();
        ArrayList arrayList = null;
        if (nvsTimelineData == null) {
            return false;
        }
        if (object == null) {
            return false;
        }
        arrayList = nvsTimelineData.getMusicInfoList();
        if (arrayList == null) {
            arrayList = new ArrayList();
            nvsTimelineData.setMusicInfoList(arrayList);
        }
        nvsTimelineData.getMusicInfoList().add(object);
        object = nvsTimelineData.getMusicInfoList();
        this.S((List)object);
        return true;
    }

    public boolean d(d.v.h.d.c object) {
        NvsTimelineData nvsTimelineData = this.n();
        ArrayList arrayList = null;
        if (nvsTimelineData == null) {
            return false;
        }
        if (object == null) {
            return false;
        }
        arrayList = nvsTimelineData.getPasteInfoList();
        if (arrayList == null) {
            arrayList = new ArrayList();
            nvsTimelineData.setPasteInfoList(arrayList);
        }
        nvsTimelineData.getPasteInfoList().add(object);
        object = nvsTimelineData.getPasteInfoList();
        this.R((List)object);
        return true;
    }

    public boolean e(int n10, d.v.h.h.b b10) {
        NvsTimelineData nvsTimelineData = this.n();
        ArrayList arrayList = null;
        if (nvsTimelineData == null) {
            return false;
        }
        if (b10 == null) {
            return false;
        }
        arrayList = nvsTimelineData.getRecordInfoList();
        if (arrayList == null) {
            arrayList = new ArrayList();
            nvsTimelineData.setRecordInfoList(arrayList);
        }
        nvsTimelineData.getRecordInfoList().add(n10, b10);
        List list = nvsTimelineData.getRecordInfoList();
        this.S(list);
        return true;
    }

    public boolean f(d.v.h.h.b object) {
        NvsTimelineData nvsTimelineData = this.n();
        ArrayList arrayList = null;
        if (nvsTimelineData == null) {
            return false;
        }
        if (object == null) {
            return false;
        }
        arrayList = nvsTimelineData.getRecordInfoList();
        if (arrayList == null) {
            arrayList = new ArrayList();
            nvsTimelineData.setRecordInfoList(arrayList);
        }
        nvsTimelineData.getRecordInfoList().add(object);
        object = nvsTimelineData.getRecordInfoList();
        this.S((List)object);
        return true;
    }

    public boolean g(d.v.h.d.d object) {
        NvsTimelineData nvsTimelineData = this.n();
        ArrayList arrayList = null;
        if (nvsTimelineData == null) {
            return false;
        }
        if (object == null) {
            return false;
        }
        arrayList = nvsTimelineData.getTextInfoList();
        if (arrayList == null) {
            arrayList = new ArrayList();
            nvsTimelineData.setTextInfoList(arrayList);
        }
        nvsTimelineData.getTextInfoList().add(object);
        object = nvsTimelineData.getTextInfoList();
        this.R((List)object);
        return true;
    }

    public void i(NvsTimelineData object) {
        int n10;
        long l10 = d.v.v.q.h.z();
        object = ((NvsTimelineData)object).getMusicInfoList();
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            Object object2 = (d.v.h.h.b)object.get(i10);
            if (object2 == null) continue;
            Object object3 = ((d.v.h.h.b)object2).d();
            long l11 = (Long)object3;
            long l12 = l11 - l10;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 >= 0) {
                object2 = d.v.v.k.a.j();
                ((d.v.v.k.a)object2).y(i10);
                i10 += -1;
                continue;
            }
            object3 = ((d.v.h.h.b)object2).d();
            l11 = (Long)object3;
            long l13 = ((d.v.h.h.b)object2).l();
            long l14 = (l11 += l13) - l10;
            object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object4 <= 0) continue;
            object3 = d.v.v.k.a.j();
            long l15 = ((d.v.h.h.b)object2).m();
            long l16 = ((d.v.h.h.b)object2).m() + l10;
            long l17 = ((d.v.h.h.b)object2).d();
            object2 = object3;
            object4 = i10;
            ((d.v.v.k.a)object3).r(i10, l15, l16 -= l17, false);
        }
    }

    public void j(NvsTimelineData object) {
        int n10;
        long l10 = d.v.v.q.h.z();
        object = ((NvsTimelineData)object).getRecordInfoList();
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            Object object2 = (d.v.h.h.b)object.get(i10);
            if (object2 == null) continue;
            Object object3 = ((d.v.h.h.b)object2).d();
            long l11 = (Long)object3;
            long l12 = l11 - l10;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 >= 0) {
                object2 = d.v.v.l.e.t();
                ((d.v.v.l.e)object2).y(i10);
                i10 += -1;
                continue;
            }
            object3 = ((d.v.h.h.b)object2).d();
            l11 = (Long)object3;
            long l13 = ((d.v.h.h.b)object2).l();
            long l14 = (l11 += l13) - l10;
            object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object4 <= 0) continue;
            object3 = d.v.v.l.e.t();
            long l15 = ((d.v.h.h.b)object2).m();
            long l16 = ((d.v.h.h.b)object2).m() + l10;
            long l17 = ((d.v.h.h.b)object2).d();
            object2 = object3;
            object4 = i10;
            ((d.v.v.l.e)object3).r(i10, l15, l16 -= l17, false);
        }
    }

    public void l() {
        NvsTimelineData nvsTimelineData = this.n();
        if (nvsTimelineData == null) {
            return;
        }
        this.i(nvsTimelineData);
        this.j(nvsTimelineData);
        this.k(nvsTimelineData);
        this.h(nvsTimelineData);
    }

    public void m() {
        NvsTimelineData nvsTimelineData;
        this.a = nvsTimelineData = new NvsTimelineData();
        this.b = nvsTimelineData = new NvsTimelineData();
    }

    public NvsTimelineData n() {
        Object object = i.e();
        boolean bl2 = ((i)object).j();
        object = bl2 ? this.a : this.b;
        return object;
    }

    public NvsTimelineData o() {
        return this.b;
    }

    public d.v.h.d.c p(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return null;
        }
        object = ((NvsTimelineData)object).getPasteInfoList().stream();
        Object object2 = f.a;
        object = object.filter(object2);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        if (n10 >= 0 && object != null && n10 < (n11 = object.size())) {
            return (d.v.h.d.c)object.get(n10);
        }
        return null;
    }

    public List q() {
        Object object = this.n();
        if (object == null) {
            return null;
        }
        object = ((NvsTimelineData)object).getPasteInfoList().stream();
        Object object2 = e.a;
        object = object.filter(object2);
        object2 = Collectors.toList();
        return (List)object.collect(object2);
    }

    public d.v.h.d.c r(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return null;
        }
        object = ((NvsTimelineData)object).getPasteInfoList().stream();
        Object object2 = d.v.v.j.a.a;
        object = object.filter(object2);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        if (n10 >= 0 && object != null && n10 < (n11 = object.size())) {
            return (d.v.h.d.c)object.get(n10);
        }
        return null;
    }

    public List s() {
        Object object = this.n();
        if (object == null) {
            return null;
        }
        object = ((NvsTimelineData)object).getPasteInfoList().stream();
        Object object2 = c.a;
        object = object.filter(object2);
        object2 = Collectors.toList();
        return (List)object.collect(object2);
    }

    public NvsTimelineData u() {
        return this.a;
    }

    public d.v.h.e.d v(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return null;
        }
        object = ((NvsTimelineData)object).getMediaInfoList();
        if (n10 >= 0 && object != null && n10 < (n11 = object.size())) {
            return (d.v.h.e.d)object.get(n10);
        }
        return null;
    }

    public d.v.h.h.b w(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return null;
        }
        object = ((NvsTimelineData)object).getMusicInfoList();
        if (n10 >= 0 && object != null && n10 < (n11 = object.size())) {
            return (d.v.h.h.b)object.get(n10);
        }
        return null;
    }

    public d.v.h.d.c x(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return null;
        }
        object = ((NvsTimelineData)object).getPasteInfoList();
        if (n10 >= 0 && object != null && n10 < (n11 = object.size())) {
            return (d.v.h.d.c)object.get(n10);
        }
        return null;
    }

    public d.v.h.h.b y(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return null;
        }
        object = ((NvsTimelineData)object).getRecordInfoList();
        if (n10 >= 0 && object != null && n10 < (n11 = object.size())) {
            return (d.v.h.h.b)object.get(n10);
        }
        return null;
    }

    public d.v.h.d.d z(int n10) {
        int n11;
        Object object = this.n();
        if (object == null) {
            return null;
        }
        object = ((NvsTimelineData)object).getTextInfoList();
        if (n10 >= 0 && object != null && n10 < (n11 = object.size())) {
            return (d.v.h.d.d)object.get(n10);
        }
        return null;
    }
}

