/*
 * Decompiled with CFR 0.151.
 */
package f.d2.r;

import f.h2.t.f0;
import f.k2.e;
import f.l2.k;
import f.q2.h;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public class a
extends f.d2.q.a {
    public e b() {
        f.k2.i.a a10 = new f.k2.i.a();
        return a10;
    }

    public h c(MatchResult object, String string2) {
        f0.p(object, "matchResult");
        Object object2 = "name";
        f0.p(string2, (String)object2);
        int n10 = object instanceof Matcher;
        h h10 = null;
        if (n10 == 0) {
            object = null;
        }
        if ((object = (Matcher)object) != null) {
            n10 = ((Matcher)object).start(string2);
            int n11 = ((Matcher)object).end(string2) + -1;
            k k10 = new k(n10, n11);
            object2 = k10.l();
            if ((n10 = ((Integer)object2).intValue()) >= 0) {
                object = ((Matcher)object).group(string2);
                string2 = "matcher.group(name)";
                f0.o(object, string2);
                h10 = new h((String)object, k10);
            }
            return h10;
        }
        object = new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        throw object;
    }
}

