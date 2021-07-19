/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.escape.CharEscaper;
import com.google.common.escape.UnicodeEscaper;

public final class Escapers$2
extends UnicodeEscaper {
    public final /* synthetic */ CharEscaper val$escaper;

    public Escapers$2(CharEscaper charEscaper) {
        this.val$escaper = charEscaper;
    }

    public char[] escape(int n10) {
        Object object = 65536;
        if (n10 < object) {
            CharEscaper charEscaper = this.val$escaper;
            n10 = (char)n10;
            return charEscaper.escape((char)n10);
        }
        object = 2;
        char[] cArray = new char[object];
        int n11 = 0;
        Character.toChars(n10, cArray, 0);
        Object object2 = this.val$escaper;
        char c10 = cArray[0];
        object2 = ((CharEscaper)object2).escape(c10);
        Object object3 = this.val$escaper;
        int n12 = 1;
        int n13 = cArray[n12];
        object3 = ((CharEscaper)object3).escape((char)n13);
        if (object2 == null && object3 == null) {
            return null;
        }
        n13 = object2 != null ? ((Object)object2).length : n12;
        int n14 = object3 != null ? ((Object)object3).length : n12;
        char[] cArray2 = new char[n14 += n13];
        if (object2 != null) {
            Object object4;
            for (int i10 = 0; i10 < (object4 = ((Object)object2).length); ++i10) {
                cArray2[i10] = object4 = (Object)object2[i10];
            }
        } else {
            cArray2[0] = n10 = cArray[0];
        }
        if (object3 != null) {
            while (n11 < (n10 = ((Object)object3).length)) {
                n10 = n13 + n11;
                cArray2[n10] = object = (Object)object3[n11];
                ++n11;
            }
        } else {
            cArray2[n13] = n10 = cArray[n12];
        }
        return cArray2;
    }
}

