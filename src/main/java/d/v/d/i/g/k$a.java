/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.d.i.g;

import android.util.Size;
import d.v.d.h.f;
import d.v.d.i.g.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class k$a {
    public Size a;
    public String b;
    public int c = 0;
    private final List d;
    private int e;
    private int f;

    public k$a(Size size, String string2) {
        int n10;
        ArrayList arrayList;
        this.d = arrayList = new ArrayList();
        this.a = size;
        this.b = string2;
        this.f = n10 = 30;
        this.e = n10;
    }

    private void g() {
        this.d.clear();
        List list = this.d;
        Integer n10 = 24;
        list.add(n10);
        list = this.d;
        n10 = 30;
        list.add(n10);
        int n11 = this.e;
        int n12 = 60;
        if (n11 >= n12) {
            list = this.d;
            n10 = n12;
            list.add(n10);
        }
    }

    public List a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return k.s(this.a);
    }

    public boolean e() {
        return k.t(this.e);
    }

    public boolean equals(Object object) {
        Size size;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = this.getClass()) == (size = object.getClass())) {
            boolean bl3;
            object = (k$a)object;
            object2 = this.a;
            size = ((k$a)object).a;
            boolean bl4 = Objects.equals(object2, size);
            if (!bl4 || !(bl3 = Objects.equals(object2 = this.b, object = ((k$a)object).b))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public void f() {
        this.i(30);
    }

    public void h(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set record max  fps=");
        stringBuilder.append(n10);
        stringBuilder.append(",maxFps=");
        int n11 = this.e;
        stringBuilder.append(n11);
        d.v.d.h.f.a(stringBuilder.toString());
        this.e = n10;
        this.g();
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Object object = this.a;
        objectArray[0] = object;
        object = this.b;
        objectArray[1] = object;
        return Objects.hash(objectArray);
    }

    public void i(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("set select fps fps=");
        charSequence.append(n10);
        String string2 = ",selectFps=";
        charSequence.append(string2);
        int n11 = this.f;
        charSequence.append(n11);
        charSequence = charSequence.toString();
        d.v.d.h.f.a((String)charSequence);
        if (n10 <= 0) {
            return;
        }
        int n12 = this.e;
        if (n10 >= n12) {
            this.f = n12;
            return;
        }
        this.f = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FpsSize{size=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", fpsRange=");
        object = this.d.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(",selectFps=");
        int n10 = this.f;
        stringBuilder.append(n10);
        stringBuilder.append(", title='");
        object = this.b;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

