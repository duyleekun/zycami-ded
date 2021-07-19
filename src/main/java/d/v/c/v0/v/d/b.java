/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.d;

import androidx.lifecycle.LiveData;
import d.v.c.v0.v.c.s;
import d.v.c.v0.v.d.a;
import d.v.c.v0.v.d.b$a;
import d.v.c.v0.v.d.b$b;
import d.v.e.l.c1;
import d.v.j.e.h.j;
import java.util.HashMap;
import java.util.Map;

public class b
implements a {
    private static volatile b d;
    private final s a;
    private final d.v.c.v0.v.e.a b;
    private c1 c;

    private b(c1 object) {
        this.c = object;
        this.a = object = s.p();
        this.b = object = d.v.c.v0.v.e.a.a();
    }

    public static /* synthetic */ s r(b b10) {
        return b10.a;
    }

    public static /* synthetic */ d.v.c.v0.v.e.a s(b b10) {
        return b10.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b t(c1 c12) {
        Object object = d;
        if (object != null) return d;
        object = b.class;
        synchronized (object) {
            b b10 = d;
            if (b10 != null) return d;
            d = b10 = new b(c12);
            return d;
        }
    }

    public LiveData b(boolean bl2, Map map) {
        long l10;
        Object object = (String)map.get("albumId");
        long l11 = Long.parseLong((String)object);
        long l12 = l11 - (l10 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 < 0) {
            this.j(l11);
        }
        c1 c12 = this.c;
        object = new b$b(this, c12, l11, bl2, map);
        return ((j)object).d();
    }

    public void d() {
        this.a.D();
    }

    public LiveData e(boolean bl2, int n10, int n11) {
        HashMap<String, CharSequence> hashMap = new HashMap<String, CharSequence>();
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "";
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        Object object = stringBuilder.toString();
        hashMap.put("page", (CharSequence)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        hashMap.put("pageSize", (CharSequence)object);
        c1 c12 = this.c;
        object = new b$a(this, c12, bl2, hashMap);
        return ((j)object).d();
    }

    public void g(long l10) {
        this.a.E(l10);
    }

    public LiveData h(boolean bl2, int n10, int n11, long l10, long l11) {
        HashMap<CharSequence, CharSequence> hashMap = new HashMap<CharSequence, CharSequence>();
        CharSequence charSequence = new StringBuilder();
        String string2 = "";
        charSequence.append(string2);
        charSequence.append(n10);
        CharSequence charSequence2 = charSequence.toString();
        charSequence = "page";
        hashMap.put(charSequence, charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append(string2);
        ((StringBuilder)charSequence2).append(n11);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        hashMap.put("pageSize", charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append(string2);
        ((StringBuilder)charSequence2).append(l10);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        String string3 = "albumId";
        hashMap.put(string3, charSequence2);
        long l12 = 0L;
        n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
        if (n10 < 0) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(l11);
            ((StringBuilder)charSequence2).append(string2);
            string2 = ((StringBuilder)charSequence2).toString();
        }
        hashMap.put("localId", string2);
        return this.b(bl2, hashMap);
    }

    public void j(long l10) {
        this.a.F(l10);
    }

    public void k() {
        this.a.G();
    }

    public LiveData q() {
        return this.a.k0();
    }

    public void release() {
    }

    public void updateMusicPath(String string2, String string3, long l10) {
        this.a.r0(string2, string3, l10);
    }
}

