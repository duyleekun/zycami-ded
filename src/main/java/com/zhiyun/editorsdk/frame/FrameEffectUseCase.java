/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.SparseArray
 */
package com.zhiyun.editorsdk.frame;

import android.text.TextUtils;
import android.util.SparseArray;
import com.zhiyun.editorsdk.fundation.IUseCase;
import d.v.h.e.c;
import d.v.h.e.d;
import d.v.h.f.a;
import d.v.j.b;
import d.v.v.c$a;
import java.util.List;

public class FrameEffectUseCase
implements IUseCase {
    private final c c;
    private final List d;

    public FrameEffectUseCase(c c10, List list) {
        this.c = c10;
        this.d = list;
    }

    private boolean c(boolean bl2, int n10, a a10, boolean bl3) {
        int n11;
        if (a10 == null) {
            return false;
        }
        int n12 = a10.f();
        if (n12 == (n11 = -1)) {
            return this.m(bl2, n10, bl3);
        }
        String string2 = a10.i();
        n12 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n12 != 0 && (n12 = (int)(b.b(string2 = a10.j()) ? 1 : 0)) != 0) {
            return false;
        }
        if (bl2) {
            return this.c.O(a10, bl3);
        }
        List list = this.d;
        bl2 = b.h(n10, list);
        if (bl2) {
            return false;
        }
        return this.c.k(n10, a10, bl3);
    }

    private boolean f(int n10, int n11, boolean n12) {
        int n13 = b.c(n10);
        if (n13 != 0) {
            return false;
        }
        n13 = -1;
        if (n12 != 0) {
            a a10 = this.h();
            if (a10 != null && (n11 = a10.f()) != n13) {
                return this.c.H(n10);
            }
            return false;
        }
        Object object = this.d;
        n12 = b.h(n11, (List)object);
        if (n12 != 0) {
            return false;
        }
        object = this.i(n11);
        if (object != null && (n12 = ((a)object).f()) != n13) {
            return this.c.F(n11, n10);
        }
        return false;
    }

    private a j(boolean bl2, int n10) {
        if (bl2) {
            return this.c.j();
        }
        Object object = this.d;
        bl2 = b.h(n10, (List)object);
        if (bl2) {
            object = new a();
            return object;
        }
        return ((d)this.d.get(n10)).w();
    }

    private boolean m(boolean bl2, int n10, boolean bl3) {
        if (bl2) {
            return this.c.z(bl3);
        }
        List list = this.d;
        bl2 = b.h(n10, list);
        if (bl2) {
            return false;
        }
        return this.c.K(n10, bl3);
    }

    private boolean q(boolean bl2, int n10, int n11, int n12, boolean bl3) {
        boolean bl4 = b.e(n12);
        if (!bl4 && !(bl4 = b.d(n11))) {
            if (bl2) {
                c c10 = this.c;
                float f10 = b.n(n12);
                return c10.s(n11, f10, bl3);
            }
            Object object = this.d;
            bl2 = b.h(n10, (List)object);
            if (bl2) {
                return false;
            }
            object = this.c;
            float f11 = b.n(n12);
            return object.w(n10, n11, f11, bl3);
        }
        return false;
    }

    public boolean a(int n10, a a10, boolean bl2) {
        return this.c(false, n10, a10, bl2);
    }

    public boolean b(a a10, boolean bl2) {
        return this.c(true, -1, a10, bl2);
    }

    public boolean d(int n10) {
        return this.f(n10, -1, true);
    }

    public boolean e(int n10, int n11) {
        return this.f(n10, n11, false);
    }

    public int g(String string2) {
        boolean bl2;
        int n10 = -1;
        if (string2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            int n11;
            String[] stringArray = string2.split("\\.");
            int n12 = stringArray.length;
            if (n12 == (n11 = 1)) {
                block6: {
                    Object object;
                    int n13;
                    bl2 = false;
                    stringArray = null;
                    for (n12 = 0; n12 < (n13 = ((String[])(object = c$a.a)).length); ++n12) {
                        boolean bl3 = ((String)(object = object[n12])).equals(string2);
                        if (!bl3) {
                            continue;
                        }
                        break block6;
                    }
                    n11 = 0;
                }
                if (n11 != 0) {
                    n10 = 0;
                    Object var10_10 = null;
                }
                return n10;
            }
            int n14 = stringArray.length - n11;
            string2 = stringArray[n14];
            String string3 = "videofx";
            if ((n14 = (int)(string2.equals(string3) ? 1 : 0)) != 0) {
                return n11;
            }
            return 2;
        }
        return n10;
    }

    public a h() {
        return this.j(true, -1);
    }

    public a i(int n10) {
        return this.j(false, n10);
    }

    public boolean k(int n10, boolean bl2) {
        return this.m(false, n10, bl2);
    }

    public boolean l(boolean bl2) {
        return this.m(true, -1, bl2);
    }

    public void n(int n10, SparseArray sparseArray, boolean bl2) {
        int n11;
        if (sparseArray == null) {
            return;
        }
        for (int i10 = 0; i10 < (n11 = sparseArray.size()); ++i10) {
            float f10;
            int n12;
            n11 = sparseArray.keyAt(i10);
            Object object = sparseArray.valueAt(i10);
            if (object == null) {
                n12 = 0;
                f10 = 0.0f;
                object = null;
            } else {
                object = (Float)sparseArray.valueAt(i10);
                f10 = ((Float)object).floatValue();
            }
            n12 = b.o(f10);
            this.o(n10, n11, n12, bl2);
        }
    }

    public boolean o(int n10, int n11, int n12, boolean bl2) {
        return this.q(false, n10, n11, n12, bl2);
    }

    public boolean p(int n10, int n11, boolean bl2) {
        return this.q(true, -1, n10, n11, bl2);
    }

    public void r(SparseArray sparseArray, boolean bl2) {
        int n10;
        if (sparseArray == null) {
            return;
        }
        for (int i10 = 0; i10 < (n10 = sparseArray.size()); ++i10) {
            float f10;
            int n11;
            n10 = sparseArray.keyAt(i10);
            Object object = sparseArray.valueAt(i10);
            if (object == null) {
                n11 = 0;
                f10 = 0.0f;
                object = null;
            } else {
                object = (Float)sparseArray.valueAt(i10);
                f10 = ((Float)object).floatValue();
            }
            n11 = b.o(f10);
            this.p(n10, n11, bl2);
        }
    }

    public boolean s(boolean bl2) {
        return this.c.q(bl2);
    }

    public boolean t(boolean bl2) {
        return this.c.G(bl2);
    }
}

