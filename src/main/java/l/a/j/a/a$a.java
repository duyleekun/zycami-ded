/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package l.a.j.a;

import android.content.Context;
import android.text.TextUtils;
import l.a.j.a.a;
import skin.support.exception.SkinCompatException;

public class a$a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

    public a$a() {
    }

    public a$a(a object) {
        String string2;
        this.a = string2 = ((a)object).c;
        this.b = string2 = ((a)object).d;
        this.c = string2 = ((a)object).e;
        this.d = string2 = ((a)object).f;
        this.e = string2 = ((a)object).g;
        this.f = string2 = ((a)object).h;
        this.g = string2 = ((a)object).i;
        this.h = string2 = ((a)object).j;
        this.i = string2 = ((a)object).k;
        this.j = string2 = ((a)object).l;
        this.k = string2 = ((a)object).m;
        this.l = object = ((a)object).n;
    }

    public a a() {
        Object object = this.l;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            String string2 = this.a;
            String string3 = this.b;
            String string4 = this.c;
            String string5 = this.d;
            String string6 = this.e;
            String string7 = this.f;
            String string8 = this.g;
            String string9 = this.h;
            String string10 = this.i;
            String string11 = this.j;
            String string12 = this.k;
            String string13 = this.l;
            object = new a(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13);
            return object;
        }
        object = new SkinCompatException("Default color can not empty!");
        throw object;
    }

    public a$a b(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.h = object;
        return this;
    }

    public a$a c(String string2) {
        String string3 = "colorAccelerated";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.h = string2;
        }
        return this;
    }

    public a$a d(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.g = object;
        return this;
    }

    public a$a e(String string2) {
        String string3 = "colorActivated";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.g = string2;
        }
        return this;
    }

    public a$a f(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.f = object;
        return this;
    }

    public a$a g(String string2) {
        String string3 = "colorChecked";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.f = string2;
        }
        return this;
    }

    public a$a h(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.l = object;
        return this;
    }

    public a$a i(String string2) {
        String string3 = "colorDefault";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.l = string2;
        }
        return this;
    }

    public a$a j(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.j = object;
        return this;
    }

    public a$a k(String string2) {
        String string3 = "colorDragCanAccept";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.j = string2;
        }
        return this;
    }

    public a$a l(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.k = object;
        return this;
    }

    public a$a m(String string2) {
        String string3 = "colorDragHovered";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.k = string2;
        }
        return this;
    }

    public a$a n(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.d = object;
        return this;
    }

    public a$a o(String string2) {
        String string3 = "colorEnabled";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.d = string2;
        }
        return this;
    }

    public a$a p(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.c = object;
        return this;
    }

    public a$a q(String string2) {
        String string3 = "colorFocused";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.c = string2;
        }
        return this;
    }

    public a$a r(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.i = object;
        return this;
    }

    public a$a s(String string2) {
        String string3 = "colorHovered";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.i = string2;
        }
        return this;
    }

    public a$a t(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.e = object;
        return this;
    }

    public a$a u(String string2) {
        String string3 = "colorPressed";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.e = string2;
        }
        return this;
    }

    public a$a v(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.b = object;
        return this;
    }

    public a$a w(String string2) {
        String string3 = "colorSelected";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.b = string2;
        }
        return this;
    }

    public a$a x(Context object, int n10) {
        object = object.getResources().getResourceEntryName(n10);
        this.a = object;
        return this;
    }

    public a$a y(String string2) {
        String string3 = "colorWindowFocused";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (bl2) {
            this.a = string2;
        }
        return this;
    }
}

