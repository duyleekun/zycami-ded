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
import kotlin.text.CharCategory;

public final class CharCategory$Companion$categoryMap$2
extends Lambda
implements a {
    public static final CharCategory$Companion$categoryMap$2 INSTANCE;

    static {
        CharCategory$Companion$categoryMap$2 charCategory$Companion$categoryMap$2;
        INSTANCE = charCategory$Companion$categoryMap$2 = new CharCategory$Companion$categoryMap$2();
    }

    public CharCategory$Companion$categoryMap$2() {
        super(0);
    }

    public final Map invoke() {
        CharCategory[] charCategoryArray = CharCategory.values();
        int n10 = s0.j(charCategoryArray.length);
        int n11 = 16;
        n10 = q.n(n10, n11);
        LinkedHashMap<Integer, CharCategory> linkedHashMap = new LinkedHashMap<Integer, CharCategory>(n10);
        for (CharCategory charCategory : charCategoryArray) {
            int n12 = charCategory.getValue();
            Integer n13 = n12;
            linkedHashMap.put(n13, charCategory);
        }
        return linkedHashMap;
    }
}

