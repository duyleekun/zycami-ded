/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.editortemplate.data.api.entity.track.ScriptInfoList;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;
import d.v.j.e.h.j;
import d.v.j.e.i.b1;
import d.v.j.e.i.c1;
import d.v.j.e.i.d0;
import d.v.j.e.i.d1;
import d.v.j.e.i.e0;
import java.util.List;
import k.d;
import m.a.a;

public class c1$b
extends j {
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ String h;
    public final /* synthetic */ c1 i;

    public c1$b(c1 c12, d.v.e.l.c1 c13, String string2, int n10, int n11, boolean bl2, String string3) {
        this.i = c12;
        this.d = string2;
        this.e = n10;
        this.f = n11;
        this.g = bl2;
        this.h = string3;
        super(c13);
    }

    private /* synthetic */ LiveData t(boolean n10, SortResult sortResult) {
        if (sortResult != null) {
            n10 = n10 != 0 ? 1 : sortResult.getNextPage();
            this.a = n10;
            List list = sortResult.getIdList();
            return c1.u(this.i).a0(list);
        }
        return d.v.e.i.d.create();
    }

    private /* synthetic */ LiveData v(SortResult object) {
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        String string2 = "\u51c6\u5907\u4ece\u6570\u636e\u5e93\u52a0\u8f7d\u6a21\u677f\u6570\u636eID\u5217\u8868: %s";
        m.a.a.b(string2, objectArray);
        if (object == null) {
            return d.v.e.i.d.create();
        }
        object = ((SortResult)object).getIdList();
        return c1.u(this.i).a0((List)object);
    }

    public d e() {
        d.v.j.e.d.a a10 = c1.t(this.i).a();
        int n10 = this.a;
        int n11 = this.e;
        String string2 = this.h;
        return a10.f(n10, n11, string2);
    }

    public LiveData m() {
        Object object = c1.s(this.i);
        String string2 = this.d;
        object = ((d1)object).i0(string2);
        boolean bl2 = this.g;
        d0 d02 = new d0(this, bl2);
        return Transformations.switchMap((LiveData)object, d02);
    }

    public LiveData n() {
        Object object = c1.s(this.i);
        Object object2 = this.d;
        object = ((d1)object).i0((String)object2);
        object2 = new e0(this);
        return Transformations.switchMap((LiveData)object, (Function)object2);
    }

    public /* synthetic */ LiveData u(boolean bl2, SortResult sortResult) {
        return this.t(bl2, sortResult);
    }

    public /* synthetic */ LiveData w(SortResult sortResult) {
        return this.v(sortResult);
    }

    public void x(ScriptInfoList scriptInfoList) {
        b1 b12 = c1.u(this.i);
        String string2 = this.d;
        int n10 = this.e;
        int n11 = this.a;
        int n12 = this.f;
        b12.l1(scriptInfoList, string2, n10, n11, n12);
    }

    public boolean y(List list) {
        int n10 = this.g;
        n10 = n10 == 0 && (n10 = this.a) <= 0 ? 0 : 1;
        return n10 != 0;
    }
}

