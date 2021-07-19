/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.base.Preconditions;
import com.google.common.escape.CharEscaperBuilder$CharArrayDecorator;
import com.google.common.escape.Escaper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class CharEscaperBuilder {
    private final Map map;
    private int max = -1;

    public CharEscaperBuilder() {
        HashMap hashMap;
        this.map = hashMap = new HashMap();
    }

    public CharEscaperBuilder addEscape(char c10, String object) {
        Map map = this.map;
        Character c11 = Character.valueOf(c10);
        object = Preconditions.checkNotNull(object);
        map.put(c11, object);
        int n10 = this.max;
        if (c10 > n10) {
            this.max = c10;
        }
        return this;
    }

    public CharEscaperBuilder addEscapes(char[] cArray, String string2) {
        Preconditions.checkNotNull(string2);
        for (char c10 : cArray) {
            this.addEscape(c10, string2);
        }
        return this;
    }

    public char[][] toArray() {
        boolean bl2;
        int n10 = this.max + 1;
        char[][] cArrayArray = new char[n10][];
        Iterator iterator2 = this.map.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            Character c10 = (Character)object.getKey();
            char c11 = c10.charValue();
            object = ((String)object.getValue()).toCharArray();
            cArrayArray[c11] = (char[])object;
        }
        return cArrayArray;
    }

    public Escaper toEscaper() {
        char[][] cArray = this.toArray();
        CharEscaperBuilder$CharArrayDecorator charEscaperBuilder$CharArrayDecorator = new CharEscaperBuilder$CharArrayDecorator(cArray);
        return charEscaperBuilder$CharArrayDecorator;
    }
}

