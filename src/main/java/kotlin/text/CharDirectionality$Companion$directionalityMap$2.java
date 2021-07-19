/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.a;
import f.l2.q;
import f.x1.s0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharDirectionality;

public final class CharDirectionality$Companion$directionalityMap$2
extends Lambda
implements a {
    public static final CharDirectionality$Companion$directionalityMap$2 INSTANCE;

    static {
        CharDirectionality$Companion$directionalityMap$2 charDirectionality$Companion$directionalityMap$2;
        INSTANCE = charDirectionality$Companion$directionalityMap$2 = new CharDirectionality$Companion$directionalityMap$2();
    }

    public CharDirectionality$Companion$directionalityMap$2() {
        super(0);
    }

    public final Map invoke() {
        CharDirectionality[] charDirectionalityArray = CharDirectionality.values();
        int n10 = s0.j(charDirectionalityArray.length);
        int n11 = 16;
        n10 = q.n(n10, n11);
        LinkedHashMap<Integer, CharDirectionality> linkedHashMap = new LinkedHashMap<Integer, CharDirectionality>(n10);
        for (CharDirectionality charDirectionality : charDirectionalityArray) {
            int n12 = charDirectionality.getValue();
            Integer n13 = n12;
            linkedHashMap.put(n13, charDirectionality);
        }
        return linkedHashMap;
    }
}

