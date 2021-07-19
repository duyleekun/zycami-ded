/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.t.f0;
import f.l2.k;
import f.l2.q;
import f.q2.g;
import f.x1.y;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.text.MatcherMatchResult;
import kotlin.text.RegexKt$fromInt$$inlined$apply$lambda$1;

public final class RegexKt {
    public static final /* synthetic */ f.q2.k a(Matcher matcher, int n10, CharSequence charSequence) {
        return RegexKt.g(matcher, n10, charSequence);
    }

    public static final /* synthetic */ Set b(int n10) {
        return RegexKt.h(n10);
    }

    public static final /* synthetic */ f.q2.k c(Matcher matcher, CharSequence charSequence) {
        return RegexKt.i(matcher, charSequence);
    }

    public static final /* synthetic */ k d(MatchResult matchResult) {
        return RegexKt.j(matchResult);
    }

    public static final /* synthetic */ k e(MatchResult matchResult, int n10) {
        return RegexKt.k(matchResult, n10);
    }

    public static final /* synthetic */ int f(Iterable iterable) {
        return RegexKt.l(iterable);
    }

    private static final f.q2.k g(Matcher object, int n10, CharSequence charSequence) {
        if ((n10 = (int)(((Matcher)object).find(n10) ? 1 : 0)) == 0) {
            object = null;
        } else {
            MatcherMatchResult matcherMatchResult = new MatcherMatchResult((Matcher)object, charSequence);
            object = matcherMatchResult;
        }
        return object;
    }

    private static final /* synthetic */ Set h(int n10) {
        f0.y(4, "T");
        EnumSet<Enum> enumSet = EnumSet.allOf(Enum.class);
        RegexKt$fromInt$$inlined$apply$lambda$1 regexKt$fromInt$$inlined$apply$lambda$1 = new RegexKt$fromInt$$inlined$apply$lambda$1(n10);
        y.P0(enumSet, regexKt$fromInt$$inlined$apply$lambda$1);
        Set<Enum> set = Collections.unmodifiableSet(enumSet);
        f0.o(set, "Collections.unmodifiable\u2026mask == it.value }\n    })");
        return set;
    }

    private static final f.q2.k i(Matcher object, CharSequence charSequence) {
        boolean bl2 = ((Matcher)object).matches();
        if (!bl2) {
            object = null;
        } else {
            MatcherMatchResult matcherMatchResult = new MatcherMatchResult((Matcher)object, charSequence);
            object = matcherMatchResult;
        }
        return object;
    }

    private static final k j(MatchResult matchResult) {
        int n10 = matchResult.start();
        int n11 = matchResult.end();
        return q.n1(n10, n11);
    }

    private static final k k(MatchResult matchResult, int n10) {
        int n11 = matchResult.start(n10);
        int n12 = matchResult.end(n10);
        return q.n1(n11, n12);
    }

    private static final int l(Iterable object) {
        int n10;
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            g g10 = (g)object.next();
            n10 = g10.getValue();
            n11 |= n10;
        }
        return n11;
    }
}

