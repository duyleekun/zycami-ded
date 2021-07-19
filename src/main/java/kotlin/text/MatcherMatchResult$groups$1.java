/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.d2.l;
import f.h2.t.f0;
import f.l2.k;
import f.n2.m;
import f.q2.h;
import f.q2.j;
import java.util.Iterator;
import java.util.regex.MatchResult;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.MatcherMatchResult;
import kotlin.text.MatcherMatchResult$groups$1$iterator$1;
import kotlin.text.RegexKt;

public final class MatcherMatchResult$groups$1
extends AbstractCollection
implements j {
    public final /* synthetic */ MatcherMatchResult a;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.a = matcherMatchResult;
    }

    public int b() {
        return MatcherMatchResult.e(this.a).groupCount() + 1;
    }

    public h get(int n10) {
        k k10 = RegexKt.e(MatcherMatchResult.e(this.a), n10);
        Object object = k10.l();
        int n11 = (Integer)object;
        if (n11 >= 0) {
            String string2 = MatcherMatchResult.e(this.a).group(n10);
            String string3 = "matchResult.group(index)";
            f0.o(string2, string3);
            object = new h(string2, k10);
        } else {
            n11 = 0;
            object = null;
        }
        return object;
    }

    public h get(String string2) {
        f0.p(string2, "name");
        f.d2.k k10 = l.a;
        MatchResult matchResult = MatcherMatchResult.e(this.a);
        return k10.c(matchResult, string2);
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator iterator() {
        m m10 = CollectionsKt___CollectionsKt.n1(CollectionsKt__CollectionsKt.F(this));
        MatcherMatchResult$groups$1$iterator$1 matcherMatchResult$groups$1$iterator$1 = new MatcherMatchResult$groups$1$iterator$1(this);
        return SequencesKt___SequencesKt.b1(m10, matcherMatchResult$groups$1$iterator$1).iterator();
    }
}

