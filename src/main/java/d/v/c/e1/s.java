/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.e1;

import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import d.v.c.b2.v.c;
import d.v.c.b2.w.a;
import d.v.c.w0.ab;
import d.v.f.d.b;
import d.v.f.d.b$b;

public class s
implements c {
    public void a(b object, d.v.c.b2.v.b b10, b$b object2, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (ab)viewDataBinding;
        object2 = (a)((b)object).d().get(n10);
        ((ab)viewDataBinding).E((a)object2);
        object = ((b)object).d();
        ((ab)viewDataBinding).C((ObservableList)object);
        ((ab)viewDataBinding).F(b10);
        object = n10;
        ((ab)viewDataBinding).D((Integer)object);
    }

    public int b(int n10) {
        return 2131558631;
    }
}

