/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.l;
import f.h2.t.f0;
import f.q2.k;
import kotlin.jvm.internal.FunctionReferenceImpl;

public final class Regex$findAll$2
extends FunctionReferenceImpl
implements l {
    public static final Regex$findAll$2 INSTANCE;

    static {
        Regex$findAll$2 regex$findAll$2;
        INSTANCE = regex$findAll$2 = new Regex$findAll$2();
    }

    public Regex$findAll$2() {
        super(1, k.class, "next", "next()Lkotlin/text/MatchResult;", 0);
    }

    public final k invoke(k k10) {
        f0.p(k10, "p1");
        return k10.next();
    }
}

