/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.t.f0;
import f.l2.k;
import f.q2.i;
import f.q2.k$a;
import f.q2.k$b;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.MatcherMatchResult$a;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlin.text.RegexKt;

public final class MatcherMatchResult
implements f.q2.k {
    private final i a;
    private List b;
    private final Matcher c;
    private final CharSequence d;

    public MatcherMatchResult(Matcher object, CharSequence charSequence) {
        f0.p(object, "matcher");
        f0.p(charSequence, "input");
        this.c = object;
        this.d = charSequence;
        this.a = object = new MatcherMatchResult$groups$1(this);
    }

    public static final /* synthetic */ MatchResult e(MatcherMatchResult matcherMatchResult) {
        return matcherMatchResult.f();
    }

    private final MatchResult f() {
        return this.c;
    }

    public k$b a() {
        return k$a.a(this);
    }

    public List b() {
        List list = this.b;
        if (list == null) {
            this.b = list = new MatcherMatchResult$a(this);
        }
        list = this.b;
        f0.m(list);
        return list;
    }

    public k c() {
        return RegexKt.d(this.f());
    }

    public i d() {
        return this.a;
    }

    public String getValue() {
        String string2 = this.f().group();
        f0.o(string2, "matchResult.group()");
        return string2;
    }

    public f.q2.k next() {
        Object object;
        int n10;
        Object object2 = this.f();
        int n11 = object2.end();
        Object object3 = this.f();
        int n12 = object3.end();
        if (n12 == (n10 = (object = this.f()).start())) {
            n12 = 1;
        } else {
            n12 = 0;
            object3 = null;
        }
        n11 += n12;
        object3 = this.d;
        n12 = object3.length();
        if (n11 <= n12) {
            object3 = this.c.pattern();
            object = this.d;
            object3 = ((Pattern)object3).matcher((CharSequence)object);
            f0.o(object3, "matcher.pattern().matcher(input)");
            object = this.d;
            object2 = RegexKt.a((Matcher)object3, n11, (CharSequence)object);
        } else {
            n11 = 0;
            object2 = null;
        }
        return object2;
    }
}

