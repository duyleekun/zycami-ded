/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 */
package d.v.c.s0.d7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import d.v.c.s0.d7.s;
import d.v.c.s0.d7.y$a;
import d.v.c.s0.d7.z;
import d.v.e.l.h2;
import d.v.f.i.g;
import d.v.n.j.b;
import java.util.ArrayList;
import java.util.List;

public class y
extends RecyclerView$Adapter {
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public static final int n = 255;
    public int[] a;
    public int[] b;
    public int[] c;
    public int[] d;
    public int[] e;
    private final Context f;
    private z g;
    private List h;
    private View i;
    private int j;

    static {
        k = h2.b(88.0f);
        l = h2.b(132.0f);
        m = h2.b(242.0f);
    }

    public y(Context context, z z10) {
        Object object;
        int[] nArray;
        int n10 = 3;
        int[] nArray2 = nArray = new int[n10];
        nArray[0] = 480;
        nArray2[1] = 720;
        nArray2[2] = 1080;
        this.a = nArray;
        int[] nArray3 = object = new int[n10];
        object[0] = 640;
        nArray3[1] = 1280;
        nArray3[2] = 1920;
        this.b = object;
        n10 = 6;
        int[] nArray4 = nArray = new int[n10];
        int[] nArray5 = nArray;
        nArray4[0] = 1;
        nArray5[1] = 2;
        nArray4[2] = 3;
        nArray5[3] = 4;
        nArray4[4] = 5;
        nArray5[5] = 6;
        this.c = nArray;
        nArray = new int[]{24, 30};
        this.d = nArray;
        int[] nArray6 = object = new int[n10];
        int[] nArray7 = object;
        nArray6[0] = 5;
        nArray7[1] = 10;
        nArray6[2] = 15;
        nArray7[3] = 20;
        nArray6[4] = 25;
        nArray7[5] = -1;
        this.e = object;
        object = new ArrayList;
        this.h = object;
        this.f = context;
        this.g = z10;
    }

    private String a(int n10) {
        Object object;
        Object object2 = this.i;
        int n11 = object2.getId();
        int n12 = 0;
        int n13 = 1;
        int n14 = 2131363130;
        if (n11 == n14) {
            object2 = this.f;
            n14 = 2131952459;
            Object[] objectArray = new Object[n13];
            objectArray[0] = object = Integer.valueOf(n10);
            object = d.v.f.i.g.n((Context)object2, n14, objectArray);
        } else {
            object2 = this.i;
            n11 = object2.getId();
            if (n11 == (n14 = 2131363128)) {
                object2 = this.f;
                n14 = 2131952456;
                Object[] objectArray = new Object[n13];
                objectArray[0] = object = Integer.valueOf(n10);
                object = d.v.f.i.g.n((Context)object2, n14, objectArray);
            } else {
                object2 = this.i;
                n11 = object2.getId();
                if (n11 == (n14 = 2131363127)) {
                    object2 = this.f;
                    n14 = 2131952454;
                    Object[] objectArray = new Object[n13];
                    objectArray[0] = object = Integer.valueOf(n10);
                    object = d.v.f.i.g.n((Context)object2, n14, objectArray);
                } else {
                    object2 = this.i;
                    n11 = object2.getId();
                    if (n11 == (n14 = 2131363129)) {
                        object2 = this.f;
                        n14 = 2131952464;
                        Object[] objectArray = new Object[n13];
                        Integer n15 = n10;
                        objectArray[0] = n15;
                        object2 = d.v.f.i.g.n((Context)object2, n14, objectArray);
                        n12 = -1;
                        if (n10 == n12) {
                            object = this.f;
                            n11 = 2131952465;
                            object = d.v.f.i.g.m((Context)object, n11);
                        } else {
                            object = object2;
                        }
                    } else {
                        object = "";
                    }
                }
            }
        }
        return object;
    }

    private /* synthetic */ void c(int n10, View view) {
        this.f(n10);
    }

    private void f(int object) {
        Object object2;
        Object object3 = (Integer)this.h.get((int)object);
        int n10 = (Integer)object3;
        b b10 = this.g.K();
        View view = this.i;
        int n11 = view.getId();
        int n12 = 1;
        int n13 = 2131363130;
        if (n11 == n13) {
            view = this.f;
            n13 = 2131952459;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object3 = Integer.valueOf(n10);
            object3 = d.v.f.i.g.n((Context)view, n13, objectArray);
            b10.T((String)object3);
            n10 = this.a[object];
            b10.d0(n10);
            object3 = this.b;
            object = object3[object];
            b10.I((int)object);
        } else {
            object2 = this.i;
            object = object2.getId();
            if (object == (n11 = 2131363128)) {
                b10.D(n10);
                object2 = this.f;
                n11 = 2131952456;
                Object[] objectArray = new Object[n12];
                objectArray[0] = object3 = Integer.valueOf(n10);
                object2 = d.v.f.i.g.n((Context)object2, n11, objectArray);
                b10.E((String)object2);
            } else {
                object2 = this.i;
                object = object2.getId();
                if (object == (n11 = 2131363127)) {
                    b10.G(n10);
                    object2 = this.f;
                    n11 = 2131952454;
                    Object[] objectArray = new Object[n12];
                    objectArray[0] = object3 = Integer.valueOf(n10);
                    object2 = d.v.f.i.g.n((Context)object2, n11, objectArray);
                    b10.H((String)object2);
                } else {
                    object2 = this.i;
                    object = object2.getId();
                    if (object == (n11 = 2131363129) && n10 == (object = -1)) {
                        b10.R(n10);
                        object2 = this.f;
                        n11 = 2131952464;
                        Object[] objectArray = new Object[n12];
                        objectArray[0] = object3 = Integer.valueOf(n10);
                        object2 = d.v.f.i.g.n((Context)object2, n11, objectArray);
                        b10.S((String)object2);
                    }
                }
            }
        }
        this.g.p.setValue(b10);
        object2 = this.g.T();
        object3 = Boolean.FALSE;
        ((MutableLiveData)object2).setValue(object3);
        this.g.U().setValue(object3);
    }

    public View b() {
        return this.i;
    }

    public /* synthetic */ void d(int n10, View view) {
        this.c(n10, view);
    }

    public void e(y$a y$a, int n10) {
        Integer n11 = (Integer)this.h.get(n10);
        int n12 = n11;
        String string2 = this.a(n12);
        y$a.a.setText((CharSequence)string2);
        string2 = y$a.a;
        s s10 = new s(this, n10);
        string2.setOnClickListener((View.OnClickListener)s10);
        n10 = this.j;
        if (n10 == n12) {
            y$a = y$a.a;
            n10 = 2131099891;
            y$a.setBackgroundResource(n10);
        }
    }

    public y$a g(ViewGroup viewGroup, int n10) {
        viewGroup = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131558637, viewGroup, false);
        y$a y$a = new y$a((View)viewGroup);
        return y$a;
    }

    public int getItemCount() {
        return this.h.size();
    }

    public long getItemId(int n10) {
        return n10;
    }

    public void h(View object) {
        this.i = object;
        Object object2 = this.h;
        object2.clear();
        int n10 = object.getId();
        int n11 = 0;
        Object object3 = 2131363130;
        if (n10 == object3) {
            object = this.a;
            object2 = this.g.K();
            this.j = n10 = ((b)object2).z();
        } else {
            n10 = object.getId();
            if (n10 == (object3 = 2131363128)) {
                object = this.c;
                object2 = this.g.K();
                this.j = n10 = ((b)object2).b();
            } else {
                n10 = object.getId();
                if (n10 == (object3 = 2131363127)) {
                    object = this.d;
                    object2 = this.g.K();
                    this.j = n10 = ((b)object2).e();
                } else {
                    int n12 = object.getId();
                    if (n12 == (n10 = 2131363129)) {
                        object = this.e;
                        object2 = this.g.K();
                        this.j = n10 = ((b)object2).n();
                    } else {
                        object = new int[0];
                    }
                }
            }
        }
        n10 = ((View)object).length;
        while (n11 < n10) {
            object3 = object[n11];
            List list = this.h;
            Integer n13 = object3;
            list.add(n13);
            ++n11;
        }
    }
}

