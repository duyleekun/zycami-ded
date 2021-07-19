/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.x1.c;
import java.util.regex.MatchResult;
import kotlin.text.MatcherMatchResult;

public final class MatcherMatchResult$a
extends c {
    public final /* synthetic */ MatcherMatchResult b;

    public MatcherMatchResult$a(MatcherMatchResult matcherMatchResult) {
        this.b = matcherMatchResult;
    }

    public int b() {
        return MatcherMatchResult.e(this.b).groupCount() + 1;
    }

    public String e(int n10) {
        MatchResult matchResult = MatcherMatchResult.e(this.b);
        String string2 = matchResult.group(n10);
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }
}

