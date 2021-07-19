/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.h.f;

import android.util.SparseArray;
import com.zhiyun.editorinterface.EditConfig$a;

public class a
implements Cloneable {
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    private int a;
    private int b = 0;
    private String c;
    private String d;
    private int e;
    private SparseArray f;

    public a() {
        int n10;
        String[] stringArray = EditConfig$a.m;
        int n11 = stringArray.length;
        String[] stringArray2 = new SparseArray(n11);
        this.f = stringArray2;
        this.a = -1;
        this.e = n10 = 100;
        for (int i10 = 0; i10 < (n10 = (stringArray2 = EditConfig$a.m).length); ++i10) {
            n10 = 0;
            stringArray2 = null;
            this.A(i10, 0.0f);
        }
    }

    public a A(int n10, float f10) {
        SparseArray sparseArray = this.f;
        Float f11 = Float.valueOf(f10);
        sparseArray.put(n10, (Object)f11);
        return this;
    }

    public void B(SparseArray sparseArray) {
        this.f = sparseArray;
    }

    public a E(float f10) {
        SparseArray sparseArray = this.f;
        Float f11 = Float.valueOf(f10);
        sparseArray.put(4, (Object)f11);
        return this;
    }

    public a F(float f10) {
        SparseArray sparseArray = this.f;
        Float f11 = Float.valueOf(f10);
        sparseArray.put(2, (Object)f11);
        return this;
    }

    public a G(float f10) {
        SparseArray sparseArray = this.f;
        Float f11 = Float.valueOf(f10);
        sparseArray.put(6, (Object)f11);
        return this;
    }

    public a H(float f10) {
        SparseArray sparseArray = this.f;
        Float f11 = Float.valueOf(f10);
        sparseArray.put(5, (Object)f11);
        return this;
    }

    public a a() {
        a a10 = new a();
        Object object = this.j();
        object = a10.x((String)object);
        int n10 = this.k();
        object = ((a)object).y(n10);
        n10 = this.f();
        object = ((a)object).u(n10);
        n10 = this.l();
        object = ((a)object).z(n10);
        String string2 = this.i();
        object = ((a)object).w(string2);
        float f10 = ((Float)this.m().get(0)).floatValue();
        object = ((a)object).A(0, f10);
        string2 = this.m();
        int n11 = 1;
        f10 = ((Float)string2.get(n11)).floatValue();
        object = ((a)object).A(n11, f10);
        string2 = this.m();
        n11 = 2;
        f10 = ((Float)string2.get(n11)).floatValue();
        object = ((a)object).A(n11, f10);
        string2 = this.m();
        n11 = 3;
        f10 = ((Float)string2.get(n11)).floatValue();
        object = ((a)object).A(n11, f10);
        string2 = this.m();
        n11 = 4;
        f10 = ((Float)string2.get(n11)).floatValue();
        object = ((a)object).A(n11, f10);
        string2 = this.m();
        n11 = 5;
        f10 = ((Float)string2.get(n11)).floatValue();
        object = ((a)object).A(n11, f10);
        string2 = this.m();
        n11 = 6;
        f10 = ((Float)string2.get(n11)).floatValue();
        ((a)object).A(n11, f10);
        return a10;
    }

    public a b(a a10) {
        Object object = this.j();
        object = a10.x((String)object);
        int n10 = this.k();
        object = ((a)object).y(n10);
        n10 = this.f();
        object = ((a)object).u(n10);
        n10 = this.l();
        object = ((a)object).z(n10);
        String string2 = this.i();
        object = ((a)object).w(string2);
        float f10 = ((Float)this.m().get(0)).floatValue();
        object = ((a)object).A(0, f10);
        string2 = this.m();
        int n11 = 1;
        f10 = ((Float)string2.get(n11)).floatValue();
        object = ((a)object).A(n11, f10);
        string2 = this.m();
        n11 = 2;
        f10 = ((Float)string2.get(n11)).floatValue();
        object = ((a)object).A(n11, f10);
        string2 = this.m();
        n11 = 3;
        f10 = ((Float)string2.get(n11)).floatValue();
        object = ((a)object).A(n11, f10);
        string2 = this.m();
        n11 = 4;
        f10 = ((Float)string2.get(n11)).floatValue();
        object = ((a)object).A(n11, f10);
        string2 = this.m();
        n11 = 5;
        f10 = ((Float)string2.get(n11)).floatValue();
        object = ((a)object).A(n11, f10);
        string2 = this.m();
        n11 = 6;
        f10 = ((Float)string2.get(n11)).floatValue();
        ((a)object).A(n11, f10);
        return a10;
    }

    public float c() {
        return ((Float)this.f.get(3)).floatValue();
    }

    public float d() {
        return ((Float)this.f.get(1)).floatValue();
    }

    public float e() {
        return ((Float)this.f.get(0)).floatValue();
    }

    public int f() {
        return this.a;
    }

    public float g() {
        return (float)this.e / 100.0f;
    }

    public String i() {
        return this.d;
    }

    public String j() {
        return this.c;
    }

    public int k() {
        return this.e;
    }

    public int l() {
        return this.b;
    }

    public SparseArray m() {
        return this.f;
    }

    public float n() {
        return ((Float)this.f.get(4)).floatValue();
    }

    public float o() {
        return ((Float)this.f.get(2)).floatValue();
    }

    public float p() {
        return ((Float)this.f.get(6)).floatValue();
    }

    public float q() {
        return ((Float)this.f.get(5)).floatValue();
    }

    public a r(float f10) {
        SparseArray sparseArray = this.f;
        Float f11 = Float.valueOf(f10);
        sparseArray.put(3, (Object)f11);
        return this;
    }

    public a s(float f10) {
        SparseArray sparseArray = this.f;
        Float f11 = Float.valueOf(f10);
        sparseArray.put(1, (Object)f11);
        return this;
    }

    public a t(float f10) {
        SparseArray sparseArray = this.f;
        Float f11 = Float.valueOf(f10);
        sparseArray.put(0, (Object)f11);
        return this;
    }

    public a u(int n10) {
        this.a = n10;
        return this;
    }

    public void v(a a10) {
        int n10 = a10.f();
        a a11 = this.u(n10);
        String string2 = a10.j();
        a11 = a11.x(string2);
        string2 = a10.i();
        a11 = a11.w(string2);
        int n11 = a10.l();
        a11 = a11.z(n11);
        int n12 = a10.k();
        a11.y(n12);
    }

    public a w(String string2) {
        this.d = string2;
        return this;
    }

    public a x(String string2) {
        this.c = string2;
        return this;
    }

    public a y(int n10) {
        this.e = n10;
        return this;
    }

    public a z(int n10) {
        this.b = n10;
        return this;
    }
}

