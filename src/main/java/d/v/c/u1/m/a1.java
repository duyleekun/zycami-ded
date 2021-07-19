/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package d.v.c.u1.m;

import android.net.Uri;
import android.text.TextUtils;
import com.zhiyun.cama.data.api.entity.sticker.AssetsStickerListBean;
import com.zhiyun.cama.data.api.entity.sticker.AssetsStickerListBean$AssetsStickerBean;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.template.StickerBean;
import com.zhiyun.editorsdk.template.TemplateUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.c.m0;
import d.v.c.u1.m.r;
import d.v.e.f;
import d.v.e.l.q2.c;
import d.v.h.e.d;
import d.v.h.f.a;
import d.v.j.b;
import d.v.j.g.b0;
import d.v.v.q.h;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class a1
extends TemplateUseCase {
    private boolean A;
    private List x;
    private boolean y;
    private boolean z;

    public a1(TemplatePOJO templatePOJO, boolean bl2) {
        boolean bl3 = true;
        this(templatePOJO, bl3, bl3, bl2);
    }

    public a1(TemplatePOJO object, boolean bl2, boolean bl3, boolean bl4) {
        ArrayList arrayList;
        this.x = arrayList = new ArrayList();
        if (object != null) {
            this.y = bl2;
            this.z = bl3;
            this.A = bl4;
            this.J0();
            this.Y((TemplatePOJO)object);
            return;
        }
        object = new IllegalArgumentException("\u6a21\u677f\u4fe1\u606f\u9519\u8bef,templatePOJO == null");
        throw object;
    }

    public static /* synthetic */ StickerBean F0(AssetsStickerListBean$AssetsStickerBean assetsStickerListBean$AssetsStickerBean) {
        String string2 = assetsStickerListBean$AssetsStickerBean.getUrl();
        float f10 = assetsStickerListBean$AssetsStickerBean.getScale();
        long l10 = assetsStickerListBean$AssetsStickerBean.getTypeId();
        StickerBean stickerBean = new StickerBean(string2, f10, l10);
        return stickerBean;
    }

    private void J0() {
        boolean bl2;
        Object object = m0.j();
        Object object2 = AssetsStickerListBean.class;
        if ((object = (AssetsStickerListBean)d.v.e.l.q2.c.d((String)object, object2)) != null && !(bl2 = d.v.j.b.f((List)(object2 = ((AssetsStickerListBean)object).getList())))) {
            object = ((AssetsStickerListBean)object).getList().stream();
            object2 = d.v.c.u1.m.r.a;
            object = object.map(object2);
            object2 = Collectors.toList();
            object = object.collect(object2);
            this.S((List)object);
        }
    }

    private void L0() {
        this.c0();
        this.d0();
        this.f0();
        this.g0();
        boolean bl2 = this.A;
        if (!bl2) {
            this.e0();
        }
    }

    private void j0() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.i).size()) && i10 < (n10 = (object = this.k).size()); ++i10) {
            object = ((d.v.h.e.a)this.k.get(i10)).e();
            n10 = (int)(d.v.j.b.b((String)object) ? 1 : 0);
            if (n10 != 0) continue;
            object = (TemplateVideo)this.i.get(i10);
            this.i0(i10, (TemplateVideo)object);
        }
    }

    private void k0() {
        boolean bl2 = this.A;
        if (!bl2) {
            this.Q();
        }
        bl2 = true;
        this.P(bl2);
        this.N(bl2);
        this.O(bl2);
        this.R(bl2);
    }

    private void l0() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.c).size()) && i10 < (n10 = (object = this.x).size()); ++i10) {
            object = ((d.v.h.e.a)this.x.get(i10)).e();
            n10 = (int)(d.v.j.b.b((String)object) ? 1 : 0);
            if (n10 != 0) continue;
            object = (TemplateVideo)this.c.get(i10);
            this.i0(i10, (TemplateVideo)object);
        }
        this.U();
    }

    private void m0() {
        this.j0();
        this.e(true);
    }

    private void o0() {
        this.l0();
        this.e(false);
        this.k0();
        this.L0();
        this.b();
        this.d();
    }

    private void s0(List list, String[] stringArray) {
        int n10;
        list.clear();
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            boolean bl2;
            Object object = MediaType.VIDEO;
            Object object2 = d.v.e.f.a().c().getContentResolver();
            Object object3 = Uri.parse((String)stringArray[i10]);
            if ((object2 = object2.getType(object3)) != null) {
                object3 = "image/";
                boolean bl3 = ((String)object2).startsWith((String)object3);
                if (bl3) {
                    object = MediaType.IMAGE;
                }
                if (bl2 = TextUtils.equals((CharSequence)object2, (CharSequence)(object3 = "image/gif"))) {
                    object = MediaType.GIF;
                }
            } else {
                object2 = stringArray[i10].toLowerCase();
                bl2 = ((String)object2).endsWith((String)(object3 = ".gif"));
                if (bl2) {
                    object = MediaType.GIF;
                }
                if ((bl2 = ((String)(object2 = stringArray[i10].toLowerCase())).endsWith((String)(object3 = ".jpg"))) || (bl2 = ((String)(object2 = stringArray[i10].toLowerCase())).endsWith((String)(object3 = ".jpeg"))) || (bl2 = ((String)(object2 = stringArray[i10].toLowerCase())).endsWith((String)(object3 = ".png")))) {
                    object = MediaType.IMAGE;
                }
            }
            object2 = new d.v.h.e.a();
            object3 = stringArray[i10];
            object2 = ((d.v.h.e.a)object2).l((String)object3);
            object3 = stringArray[i10];
            object = ((d.v.h.e.a)object2).p((String)object3).m((MediaType)((Object)object));
            object2 = (TemplateVideo)this.c.get(i10);
            long l10 = b0.h((TemplateVideo)object2);
            object = ((d.v.h.e.a)object).k(l10);
            list.add(object);
        }
    }

    public long A0(int n10) {
        TemplateVideo templateVideo = (TemplateVideo)this.c.get(n10);
        float f10 = b0.h(templateVideo);
        float f11 = templateVideo.getRate();
        return (long)(f10 / f11);
    }

    public long B0(int n10) {
        return b0.h((TemplateVideo)this.c.get(n10));
    }

    public long C0(int n10) {
        TemplateVideo templateVideo = (TemplateVideo)this.c.get(n10);
        float f10 = d.v.v.q.h.C(((d.v.h.e.a)this.x.get(n10)).e());
        float f11 = templateVideo.getRate();
        return (long)(f10 / f11);
    }

    public List D0(String[] object) {
        Object object2;
        int n10;
        int n11 = this.y;
        if (n11 != 0 && (object == null || (n11 = ((String[])object).length) != (n10 = (object2 = this.c).size()))) {
            object2 = new StringBuilder();
            CharSequence charSequence = "\u89c6\u9891\u5730\u5740\u6570\u91cf\u4e0d\u5bf9,mediaArray:";
            ((StringBuilder)object2).append((String)charSequence);
            if (object == null) {
                object = "null";
            } else {
                charSequence = new StringBuilder();
                int n12 = ((String[])object).length;
                ((StringBuilder)charSequence).append(n12);
                ((StringBuilder)charSequence).append("videoList:");
                n12 = this.c.size();
                ((StringBuilder)charSequence).append(n12);
                object = ((StringBuilder)charSequence).toString();
            }
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        List list = this.x;
        this.s0(list, (String[])object);
        return this.x;
    }

    public String E0(int n10) {
        return ((d.v.h.e.a)this.x.get(n10)).e();
    }

    public boolean G0(String[] object, int n10) {
        ArrayList arrayList = new ArrayList();
        this.s0(arrayList, (String[])object);
        boolean bl2 = d.v.j.b.f(arrayList);
        if (bl2) {
            return false;
        }
        object = ((d.v.h.e.a)arrayList.get(0)).e();
        return this.l.o0(n10, (String)object);
    }

    public boolean H0(int n10, a a10) {
        return this.r.a(n10, a10, true);
    }

    public boolean I0(a a10) {
        return this.r.b(a10, true);
    }

    public boolean K0(boolean bl2) {
        return this.r.s(bl2);
    }

    public boolean M0() {
        int n10 = this.l.F();
        boolean bl2 = ((d)this.l.H().get(n10)).Q() ^ true;
        return this.T(n10, bl2);
    }

    public void h(MainUseCase mainUseCase) {
        super.h(mainUseCase);
        boolean bl2 = this.z;
        if (bl2) {
            this.o0();
        }
    }

    public void n0(TemplatePOJO object) {
        if (object != null) {
            Object object2 = ((TemplatePOJO)object).getTemplateGlobal();
            this.J((TemplateGlobal)object2);
            object2 = ((TemplatePOJO)object).getTemplateVideoList();
            object2 = this.x0((List)object2);
            object = ((TemplatePOJO)object).getTemplateStickerList();
            object = this.z0((List)object);
            boolean bl2 = d.v.j.b.f((List)object2);
            if (!bl2) {
                MainUseCase mainUseCase = this.l;
                mainUseCase.j((List)object2, (List)object);
            }
        }
    }

    public boolean p0(int n10) {
        return this.r.d(n10);
    }

    public boolean q0(int n10, int n11) {
        return this.r.e(n10, n11);
    }

    public void r0() {
        this.m0();
    }

    public long t0(int n10) {
        return b0.h((TemplateVideo)this.c.get(n10));
    }

    public a u0(int n10) {
        return this.r.i(n10);
    }

    public a v0() {
        return this.r.h();
    }

    public d.v.h.e.a w0(int n10) {
        return (d.v.h.e.a)this.l.H().get(n10);
    }

    public List x0(List list) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Object object = (TemplateVideo)list.get(i10);
            if (object == null || (object = this.t((TemplateVideo)object)) == null) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    public float y0(int n10) {
        return ((TemplateVideo)this.c.get(n10)).getRate();
    }

    public List z0(List object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        List list = this.s();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            String string2;
            String string3;
            boolean bl4;
            Object object2 = (TemplateSticker)object.next();
            if (object2 == null || (object2 = this.m((TemplateSticker)object2, bl4 = (string3 = "image").equals(string2 = ((TemplateSticker)object2).getType()), list, bl3 = true)) == null) continue;
            arrayList.add(object2);
        }
        return arrayList;
    }
}

