/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.editorsdk;

import android.text.TextUtils;
import com.zhiyun.editorsdk.CallChangeUseCase;
import com.zhiyun.editorsdk.fundation.EditorConfig;
import d.v.h.e.c;
import d.v.h.k.b;
import d.v.v.c$a;
import d.v.v.q.h;
import java.util.List;
import m.a.a;

public class TransitionUseCase
extends CallChangeUseCase {
    private c e;
    private List f;

    public TransitionUseCase(c c10, List list) {
        this.e = c10;
        this.f = list;
    }

    public boolean e(int n10, b b10, boolean bl2) {
        return this.f(n10, b10, bl2, true);
    }

    public boolean f(int n10, b object, boolean bl2, boolean bl3) {
        long l10;
        long l11;
        long l12;
        Object object2 = this.f;
        int n11 = d.v.j.b.h(n10, (List)object2);
        if (n11 == 0 && object != null && (n11 = (l12 = (l11 = ((b)object).a()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            object2 = ((b)object).c();
            n11 = (int)(d.v.j.b.b((String)object2) ? 1 : 0);
            String string2 = ((b)object).b();
            boolean bl4 = TextUtils.isEmpty((CharSequence)string2);
            int n12 = 1;
            int n13 = 2;
            if (n11 != 0 && bl4) {
                Object[] objectArray = new Object[n13];
                String string3 = ((b)object).c();
                objectArray[0] = string3;
                objectArray[n12] = object = ((b)object).b();
                a.i("transition info error,transition path:%s,transition name:%s", objectArray);
                return false;
            }
            if (!bl4) {
                ((b)object).j(n12);
            } else {
                ((b)object).j(n13);
            }
            long l13 = ((b)object).a();
            l11 = EditorConfig.e;
            n11 = (int)(l13 == l11 ? 0 : (l13 < l11 ? -1 : 1));
            l13 = n11 > 0 ? EditorConfig.d : ((b)object).a();
            ((b)object).f(l13);
            object2 = this.e;
            n10 = (int)(object2.h(n10, (b)object, bl2) ? 1 : 0);
            if (n10 != 0) {
                this.a(bl3);
            }
            return n10 != 0;
        }
        return false;
    }

    public boolean g(int n10) {
        long l10;
        long l11 = h.T(n10);
        long l12 = l11 - (l10 = EditorConfig.d);
        n10 = (n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean h(int n10, long l10, boolean bl2) {
        Object object = this.f;
        boolean bl3 = d.v.j.b.h(n10, (List)object);
        if (bl3) {
            return false;
        }
        object = this.e;
        if ((n10 = (int)(object.n2(n10, l10, bl2) ? 1 : 0)) != 0) {
            boolean bl4 = true;
            this.a(bl4);
        }
        return n10 != 0;
    }

    public int i(String string2) {
        Object object = string2.split("\\.");
        int n10 = ((String[])object).length;
        int n11 = -1;
        int n12 = 1;
        if (n10 == n12) {
            Object object2;
            int n13;
            int n14 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = ((String[])(object2 = c$a.b)).length); ++n10) {
                boolean bl2 = ((String)(object2 = object2[n10])).equals(string2);
                if (!bl2) continue;
                n14 = n12;
                break;
            }
            if (n14 != 0) {
                n11 = n12;
            }
            return n11;
        }
        int n15 = ((String[])object).length - n12;
        string2 = object[n15];
        if ((n15 = (int)(string2.equals(object = "videotransition") ? 1 : 0)) != 0) {
            return 2;
        }
        return n11;
    }

    public boolean j(int n10, boolean bl2) {
        return this.k(n10, bl2, true);
    }

    public boolean k(int n10, boolean bl2, boolean bl3) {
        Object object = this.f;
        boolean bl4 = d.v.j.b.h(n10, (List)object);
        if (bl4) {
            return false;
        }
        object = this.e;
        if ((n10 = (int)(object.p0(n10, bl2) ? 1 : 0)) != 0) {
            this.a(bl3);
        }
        return n10 != 0;
    }
}

