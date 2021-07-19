/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Chars;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class Chars$CharArrayAsList
extends AbstractList
implements RandomAccess,
Serializable {
    private static final long serialVersionUID;
    public final char[] array;
    public final int end;
    public final int start;

    public Chars$CharArrayAsList(char[] cArray) {
        int n10 = cArray.length;
        this(cArray, 0, n10);
    }

    public Chars$CharArrayAsList(char[] cArray, int n10, int n11) {
        this.array = cArray;
        this.start = n10;
        this.end = n11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean contains(Object object) {
        int n10 = object instanceof Character;
        if (n10 == 0) return 0 != 0;
        char[] cArray = this.array;
        object = (Character)object;
        int n11 = ((Character)object).charValue();
        int n12 = this.start;
        int n13 = this.end;
        if ((n11 = Chars.access$000(cArray, (char)n11, n12, n13)) == (n10 = -1)) return 0 != 0;
        return 1 != 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof Chars$CharArrayAsList;
        if (n10 != 0) {
            object = (Chars$CharArrayAsList)object;
            n10 = this.size();
            int n11 = ((Chars$CharArrayAsList)object).size();
            if (n11 != n10) {
                return false;
            }
            for (n11 = 0; n11 < n10; ++n11) {
                char[] cArray = this.array;
                int n12 = this.start + n11;
                char c10 = cArray[n12];
                char[] cArray2 = ((Chars$CharArrayAsList)object).array;
                int n13 = ((Chars$CharArrayAsList)object).start + n11;
                if (c10 == (n12 = cArray2[n13])) continue;
                return false;
            }
            return bl2;
        }
        return super.equals(object);
    }

    public Character get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        char[] cArray = this.array;
        int n12 = this.start + n10;
        return Character.valueOf(cArray[n12]);
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = this.start; i10 < (n10 = this.end); ++i10) {
            n11 *= 31;
            char[] cArray = this.array;
            n10 = Chars.hashCode(cArray[i10]);
            n11 += n10;
        }
        return n11;
    }

    public int indexOf(Object object) {
        int n10 = object instanceof Character;
        if (n10 != 0) {
            char[] cArray = this.array;
            object = (Character)object;
            int n11 = ((Character)object).charValue();
            int n12 = this.start;
            int n13 = this.end;
            if ((n11 = Chars.access$000(cArray, (char)n11, n12, n13)) >= 0) {
                n10 = this.start;
                return n11 - n10;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public int lastIndexOf(Object object) {
        int n10 = object instanceof Character;
        if (n10 != 0) {
            char[] cArray = this.array;
            object = (Character)object;
            int n11 = ((Character)object).charValue();
            int n12 = this.start;
            int n13 = this.end;
            if ((n11 = Chars.access$100(cArray, (char)n11, n12, n13)) >= 0) {
                n10 = this.start;
                return n11 - n10;
            }
        }
        return -1;
    }

    public Character set(int n10, Character c10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        char[] cArray = this.array;
        int n12 = this.start;
        char c11 = n12 + n10;
        c11 = cArray[c11];
        n12 += n10;
        cArray[n12] = n10 = (int)((Character)Preconditions.checkNotNull(c10)).charValue();
        return Character.valueOf(c11);
    }

    public int size() {
        int n10 = this.end;
        int n11 = this.start;
        return n10 - n11;
    }

    public List subList(int n10, int n11) {
        int n12 = this.size();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        if (n10 == n11) {
            return Collections.emptyList();
        }
        char[] cArray = this.array;
        int n13 = this.start;
        n10 += n13;
        Chars$CharArrayAsList chars$CharArrayAsList = new Chars$CharArrayAsList(cArray, n10, n13 += n11);
        return chars$CharArrayAsList;
    }

    public char[] toCharArray() {
        char[] cArray = this.array;
        int n10 = this.start;
        int n11 = this.end;
        return Arrays.copyOfRange(cArray, n10, n11);
    }

    public String toString() {
        char c10;
        int n10 = this.size() * 3;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append('[');
        char[] cArray = this.array;
        int c102 = this.start;
        n10 = cArray[c102];
        stringBuilder.append((char)n10);
        n10 = this.start;
        while (++n10 < (c10 = this.end)) {
            stringBuilder.append(", ");
            char[] cArray2 = this.array;
            c10 = cArray2[n10];
            stringBuilder.append(c10);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

