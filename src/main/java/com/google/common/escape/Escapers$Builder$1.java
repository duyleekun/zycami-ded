/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.escape.ArrayBasedCharEscaper;
import com.google.common.escape.Escapers$Builder;
import java.util.Map;

public class Escapers$Builder$1
extends ArrayBasedCharEscaper {
    private final char[] replacementChars;
    public final /* synthetic */ Escapers$Builder this$0;

    public Escapers$Builder$1(Escapers$Builder object, Map object2, char c10, char c11) {
        this.this$0 = object;
        super((Map)object2, c10, c11);
        object2 = Escapers$Builder.access$100((Escapers$Builder)object);
        object = object2 != null ? (Object)Escapers$Builder.access$100((Escapers$Builder)object).toCharArray() : null;
        this.replacementChars = (char[])object;
    }

    public char[] escapeUnsafe(char c10) {
        return this.replacementChars;
    }
}

