/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.l;
import f.q2.g;
import kotlin.jvm.internal.Lambda;

public final class RegexKt$fromInt$$inlined$apply$lambda$1
extends Lambda
implements l {
    public final /* synthetic */ int $value$inlined;

    public RegexKt$fromInt$$inlined$apply$lambda$1(int n10) {
        this.$value$inlined = n10;
        super(1);
    }

    public final boolean invoke(Enum object) {
        int n10;
        int n11 = this.$value$inlined;
        int n12 = (object = (g)object).getMask();
        if ((n11 &= n12) == (n10 = object.getValue())) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }
}

