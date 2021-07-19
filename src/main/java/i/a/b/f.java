/*
 * Decompiled with CFR 0.151.
 */
package i.a.b;

import i.a.b.c;
import i.a.b.d;
import i.a.b.e;
import i.a.b.f$a;
import i.a.b.f$b;
import i.a.b.g;
import i.a.b.h.a;
import i.a.b.h.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class f {
    private g a;
    private d b;

    private f(g object) {
        this.a = object;
        this.b = object = new d();
    }

    public /* synthetic */ f(g g10, f$a f$a) {
        this(g10);
    }

    public static /* synthetic */ void a(f f10, String string2) {
        f10.d(string2);
    }

    public static /* synthetic */ g b(f f10) {
        return f10.a;
    }

    public static /* synthetic */ void c(f f10) {
        f10.f();
    }

    private void d(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            d d10 = this.b;
            for (char c10 : string2.toCharArray()) {
                Character c11 = Character.valueOf(c10);
                g g10 = this.a;
                boolean bl2 = g10.b();
                if (bl2) {
                    c10 = Character.toLowerCase(c11.charValue());
                    c11 = Character.valueOf(c10);
                }
                d10 = d10.c(c11);
            }
            Object object = this.a;
            boolean bl3 = ((g)object).b();
            if (bl3) {
                string2 = string2.toLowerCase();
            }
            d10.a(string2);
        }
    }

    public static f$b e() {
        f$b f$b = new f$b(null);
        return f$b;
    }

    private void f() {
        boolean bl2;
        Object object;
        Object object2;
        boolean bl3;
        LinkedBlockingDeque<d> linkedBlockingDeque = new LinkedBlockingDeque<d>();
        Object object3 = this.b.g().iterator();
        while (bl3 = object3.hasNext()) {
            object2 = (d)object3.next();
            object = this.b;
            ((d)object2).l((d)object);
            linkedBlockingDeque.add((d)object2);
        }
        while (!(bl2 = linkedBlockingDeque.isEmpty())) {
            boolean bl4;
            object3 = (d)linkedBlockingDeque.remove();
            object2 = ((d)object3).h().iterator();
            while (bl4 = object2.hasNext()) {
                d d10;
                object = (Character)object2.next();
                d d11 = ((d)object3).i((Character)object);
                linkedBlockingDeque.add(d11);
                d d12 = ((d)object3).e();
                while ((d10 = d12.i((Character)object)) == null) {
                    d12 = d12.e();
                }
                object = d12.i((Character)object);
                d11.l((d)object);
                object = ((d)object).d();
                d11.b((Collection)object);
            }
        }
    }

    private e h(i.a.b.a object, String string2, int n10) {
        int n11 = object == null ? string2.length() : ((i.a.a.a)object).getStart();
        object = string2.substring(++n10, n11);
        i.a.b.b b10 = new i.a.b.b((String)object);
        return b10;
    }

    private e i(i.a.b.a a10, String string2) {
        int n10 = a10.getStart();
        int n11 = a10.getEnd() + 1;
        string2 = string2.substring(n10, n11);
        c c10 = new c(string2, a10);
        return c10;
    }

    private d k(d d10, Character c10) {
        d d11 = d10.i(c10);
        while (d11 == null) {
            d10 = d10.e();
            d11 = d10.i(c10);
        }
        return d11;
    }

    private boolean l(CharSequence charSequence, i.a.b.a a10) {
        int n10;
        block5: {
            int n11;
            boolean bl2;
            int n12;
            int n13;
            block4: {
                n13 = a10.getStart();
                n10 = 1;
                if (n13 == 0) break block4;
                n13 = a10.getStart() - n10;
                if ((n13 = (int)(Character.isAlphabetic(charSequence.charAt(n13)) ? 1 : 0)) != 0) break block5;
            }
            if ((n13 = a10.getEnd() + n10) == (n12 = charSequence.length()) || !(bl2 = Character.isAlphabetic(charSequence.charAt(n11 = a10.getEnd() + n10)))) {
                n10 = 0;
            }
        }
        return n10 != 0;
    }

    private void o(CharSequence object, List list) {
        boolean bl2;
        boolean bl3;
        Object object2 = new ArrayList();
        Iterator iterator2 = list.iterator();
        while (bl3 = iterator2.hasNext()) {
            i.a.b.a a10 = (i.a.b.a)iterator2.next();
            boolean bl4 = this.l((CharSequence)object, a10);
            if (!bl4) continue;
            object2.add(a10);
        }
        object = object2.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (i.a.b.a)object.next();
            list.remove(object2);
        }
    }

    private void p(CharSequence object, List list) {
        boolean bl2;
        int n10 = object.length();
        long l10 = n10;
        ArrayList<i.a.b.a> arrayList = new ArrayList<i.a.b.a>();
        Iterator iterator2 = list.iterator();
        while (bl2 = iterator2.hasNext()) {
            i.a.b.a a10;
            block5: {
                long l11;
                long l12;
                int n11;
                block4: {
                    a10 = (i.a.b.a)iterator2.next();
                    n11 = a10.getStart();
                    if (n11 == 0) break block4;
                    n11 = a10.getStart() + -1;
                    if ((n11 = (int)(Character.isWhitespace(object.charAt(n11)) ? 1 : 0)) == 0) break block5;
                }
                if ((n11 = (int)((l12 = (l11 = (long)(a10.getEnd() + 1)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) continue;
                n11 = a10.getEnd() + 1;
                if ((n11 = (int)(Character.isWhitespace(object.charAt(n11)) ? 1 : 0)) != 0) continue;
            }
            arrayList.add(a10);
        }
        object = arrayList.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            i.a.b.a a11 = (i.a.b.a)object.next();
            list.remove(a11);
        }
    }

    private boolean q(int n10, d iterator2, b b10) {
        int n11;
        iterator2 = ((d)((Object)iterator2)).d();
        int n12 = 0;
        String string2 = null;
        if (iterator2 != null && (n11 = iterator2.isEmpty()) == 0) {
            boolean bl2;
            iterator2 = iterator2.iterator();
            n11 = 1;
            while (bl2 = iterator2.hasNext()) {
                string2 = (String)iterator2.next();
                int n13 = string2.length();
                n13 = n10 - n13 + n11;
                i.a.b.a a10 = new i.a.b.a(n13, n10, string2);
                b10.a(a10);
                n12 = n11;
            }
        }
        return n12 != 0;
    }

    public boolean g(CharSequence object) {
        boolean bl2;
        if ((object = this.j((CharSequence)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public i.a.b.a j(CharSequence object) {
        Object object2 = this.a;
        boolean bl2 = ((g)object2).a();
        if (!bl2) {
            if ((object = this.m((CharSequence)object)) != null && !(bl2 = object.isEmpty())) {
                return (i.a.b.a)object.iterator().next();
            }
        } else {
            int n10;
            object2 = this.b;
            for (int i10 = 0; i10 < (n10 = object.length()); ++i10) {
                n10 = object.charAt(i10);
                Iterator iterator2 = Character.valueOf((char)n10);
                Object object3 = this.a;
                boolean bl3 = ((g)object3).b();
                if (bl3) {
                    n10 = Character.toLowerCase(((Character)((Object)iterator2)).charValue());
                    iterator2 = Character.valueOf((char)n10);
                }
                if ((iterator2 = ((d)(object2 = this.k((d)object2, (Character)((Object)iterator2)))).d()) == null || (bl3 = iterator2.isEmpty())) continue;
                iterator2 = iterator2.iterator();
                while (bl3 = iterator2.hasNext()) {
                    object3 = (String)iterator2.next();
                    int n11 = ((String)object3).length();
                    n11 = i10 - n11 + 1;
                    i.a.b.a a10 = new i.a.b.a(n11, i10, (String)object3);
                    object3 = this.a;
                    bl3 = ((g)object3).c();
                    if (bl3 && (bl3 = this.l((CharSequence)object, a10))) continue;
                    return a10;
                }
            }
        }
        return null;
    }

    public Collection m(CharSequence object) {
        boolean bl2;
        Object object2 = new a();
        this.n((CharSequence)object, (b)object2);
        object2 = ((a)object2).b();
        g g10 = this.a;
        boolean bl3 = g10.c();
        if (bl3) {
            this.o((CharSequence)object, (List)object2);
        }
        if (bl3 = (g10 = this.a).d()) {
            this.p((CharSequence)object, (List)object2);
        }
        if (!(bl2 = ((g)(object = this.a)).a())) {
            object = new i.a.a.b((List)object2);
            ((i.a.a.b)object).b((List)object2);
        }
        return object2;
    }

    public void n(CharSequence charSequence, b b10) {
        int n10;
        d d10 = this.b;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            g g10 = this.a;
            boolean bl2 = g10.b();
            if (bl2) {
                n10 = Character.toLowerCase(((Character)object).charValue());
                object = Character.valueOf((char)n10);
            }
            if ((n10 = (int)(this.q(i10, d10 = this.k(d10, (Character)object), b10) ? 1 : 0)) == 0 || (n10 = (int)(((g)(object = this.a)).e() ? 1 : 0)) == 0) continue;
            return;
        }
    }

    public Collection r(String object) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator2 = this.m((CharSequence)object).iterator();
        int n11 = -1;
        while (true) {
            e e10;
            boolean bl2 = iterator2.hasNext();
            n10 = 1;
            if (!bl2) break;
            i.a.b.a a10 = (i.a.b.a)iterator2.next();
            int n12 = a10.getStart() - n11;
            if (n12 > n10) {
                e10 = this.h(a10, (String)object, n11);
                arrayList.add(e10);
            }
            e10 = this.i(a10, (String)object);
            arrayList.add(e10);
            n11 = a10.getEnd();
        }
        int n13 = ((String)object).length() - n11;
        if (n13 > n10) {
            n13 = 0;
            iterator2 = null;
            object = this.h(null, (String)object, n11);
            arrayList.add(object);
        }
        return arrayList;
    }
}

