/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoList;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;
import d.v.j.e.h.j;
import d.v.j.e.i.c0;
import d.v.j.e.i.c1;
import d.v.j.e.i.d1;
import d.v.j.e.i.e1;
import d.v.j.e.i.z0;
import java.util.List;
import k.d;
import m.a.a;

public class c1$a
extends j {
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ long f;
    public final /* synthetic */ int g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ c1 k;

    public c1$a(c1 c12, d.v.e.l.c1 c13, String string2, int n10, long l10, int n11, boolean bl2, boolean bl3, boolean bl4) {
        this.k = c12;
        this.d = string2;
        this.e = n10;
        this.f = l10;
        this.g = n11;
        this.h = bl2;
        this.i = bl3;
        this.j = bl4;
        super(c13);
    }

    private /* synthetic */ LiveData t(boolean bl2, SortResult sortResult) {
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = sortResult;
        String string2 = "\u51c6\u5907\u4ece\u6570\u636e\u5e93\u52a0\u8f7d\u6a21\u677f\u6570\u636eID\u5217\u8868: %s";
        m.a.a.b(string2, objectArray);
        if (sortResult == null) {
            return d.v.e.i.d.create();
        }
        if (!bl2) {
            n10 = sortResult.getNextPage();
        }
        this.a = n10;
        List list = sortResult.getIdList();
        return c1.s(this.k).a0(list);
    }

    public d e() {
        e1 e12 = c1.t(this.k);
        int n10 = this.a;
        int n11 = this.e;
        long l10 = this.f;
        boolean bl2 = this.j;
        return e12.b(n10, n11, l10, bl2);
    }

    public LiveData m() {
        z0 z02 = c1.s(this.k);
        Integer n10 = 0;
        Integer n11 = this.g;
        Boolean bl2 = Boolean.TRUE;
        long l10 = this.f;
        boolean bl3 = this.h;
        return z02.S0(null, n10, n11, bl2, null, l10, bl3);
    }

    public LiveData n() {
        Object object = c1.s(this.k);
        String string2 = this.d;
        object = ((d1)object).i0(string2);
        boolean bl2 = this.i;
        c0 c02 = new c0(this, bl2);
        return Transformations.switchMap((LiveData)object, c02);
    }

    public /* synthetic */ LiveData u(boolean bl2, SortResult sortResult) {
        return this.t(bl2, sortResult);
    }

    public void v(TemplateInfoList templateInfoList) {
        z0 z02 = c1.s(this.k);
        String string2 = this.d;
        int n10 = this.e;
        int n11 = this.a;
        long l10 = this.f;
        int n12 = this.g;
        boolean bl2 = this.h;
        z02.a1(templateInfoList, string2, n10, n11, l10, n12, bl2);
    }

    public boolean w(List list) {
        int n10 = this.i;
        n10 = n10 == 0 && (n10 = this.a) <= 0 ? 0 : 1;
        return n10 != 0;
    }
}

