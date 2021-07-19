/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt___SequencesKt$filterNotNull$1
extends Lambda
implements l {
    public static final SequencesKt___SequencesKt$filterNotNull$1 INSTANCE;

    static {
        SequencesKt___SequencesKt$filterNotNull$1 sequencesKt___SequencesKt$filterNotNull$1;
        INSTANCE = sequencesKt___SequencesKt$filterNotNull$1 = new SequencesKt___SequencesKt$filterNotNull$1();
    }

    public SequencesKt___SequencesKt$filterNotNull$1() {
        super(1);
    }

    public final boolean invoke(Object object) {
        boolean bl2;
        if (object == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

