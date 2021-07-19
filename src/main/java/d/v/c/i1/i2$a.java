/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.editorsdk.MainUseCase;
import d.v.c.i1.i2;
import d.v.c.j0;
import d.v.c.m0;
import d.v.e.i.h;
import d.v.h.e.b;
import m.a.a;

public class i2$a
implements b {
    public final /* synthetic */ i2 a;

    public i2$a(i2 i22) {
        this.a = i22;
    }

    public void d(int n10) {
        Object[] objectArray = new StringBuilder();
        objectArray.append("onMediaEnd:");
        objectArray.append(n10);
        String string2 = objectArray.toString();
        objectArray = new Object[]{};
        m.a.a.b(string2, objectArray);
    }

    public void f() {
    }

    public void g(int n10, DecorationType decorationType) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("type:");
        charSequence.append((Object)decorationType);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)charSequence, objectArray);
        h.g(i2.o(this.a), (Object)decorationType);
    }

    public void h() {
        Object[] objectArray = i2.m(this.a);
        Float f10 = Float.valueOf(1.0f);
        h.g((MutableLiveData)objectArray, f10);
        objectArray = new Object[]{};
        m.a.a.b("onMediaAllEnd:", objectArray);
    }

    public void k(int n10, DecorationType decorationType, int n11) {
        Object[] objectArray = new Object[3];
        Integer n12 = n10;
        objectArray[0] = n12;
        objectArray[1] = decorationType;
        n12 = n11;
        objectArray[2] = n12;
        m.a.a.b("index = %s,type = %s,action = %s", objectArray);
    }

    public void l(int n10, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onMediaIndexChange:");
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
        object = i2.n(this.a);
        Integer n12 = n11;
        h.g((MutableLiveData)object, n12);
        i2.g(this.a);
    }

    public void m(boolean bl2) {
        Object object;
        Boolean bl3 = Boolean.TRUE;
        if (bl2) {
            object = i2.b(this.a);
            h.g((MutableLiveData)object, bl3);
        } else {
            object = i2.c(this.a);
            h.g((MutableLiveData)object, bl3);
        }
        if (!bl2) {
            return;
        }
        i2.g(this.a);
        i2.i(this.a);
        i2.j(this.a);
        this.a.i4();
        Object object2 = this.a;
        boolean bl4 = true;
        ((i2)object2).D3(bl4);
        i2.k(this.a);
        object2 = m0.d();
        object = this.a.G;
        boolean bl5 = j0.A();
        ((MainUseCase)object).l0(bl5, (String)object2);
        this.a.G.k0(bl4);
    }

    public void p(int n10) {
        Object[] objectArray = new StringBuilder();
        objectArray.append("onMediaStart:");
        objectArray.append(n10);
        String string2 = objectArray.toString();
        objectArray = new Object[]{};
        m.a.a.b(string2, objectArray);
    }

    public void r() {
    }

    public void s(int n10, DecorationType decorationType) {
    }

    public void t(int n10) {
        MutableLiveData mutableLiveData = i2.l(this.a);
        Boolean bl2 = Boolean.FALSE;
        h.g(mutableLiveData, bl2);
    }

    public void u() {
        MutableLiveData mutableLiveData = i2.l(this.a);
        Boolean bl2 = Boolean.TRUE;
        h.g(mutableLiveData, bl2);
    }
}

