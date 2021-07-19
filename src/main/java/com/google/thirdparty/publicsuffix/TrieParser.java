/*
 * Decompiled with CFR 0.151.
 */
package com.google.thirdparty.publicsuffix;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.Lists;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.LinkedList;
import java.util.List;

public final class TrieParser {
    private static final Joiner PREFIX_JOINER = Joiner.on("");

    private static int doParseTrieToBuilder(List list, CharSequence charSequence, int n10, ImmutableMap$Builder immutableMap$Builder) {
        String string2;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15 = charSequence.length();
        int n16 = n10;
        int n17 = 0;
        while (true) {
            int n18;
            n14 = 58;
            n13 = 33;
            n12 = 44;
            n11 = 63;
            if (n16 >= n15 || (n17 = charSequence.charAt(n16)) == (n18 = 38) || n17 == n11 || n17 == n13 || n17 == n14 || n17 == n12) break;
            ++n16;
        }
        CharSequence charSequence2 = TrieParser.reverse(charSequence.subSequence(n10, n16));
        list.add(0, charSequence2);
        if ((n17 == n13 || n17 == n11 || n17 == n14 || n17 == n12) && (n13 = (string2 = PREFIX_JOINER.join(list)).length()) > 0) {
            PublicSuffixType publicSuffixType = PublicSuffixType.fromCode((char)n17);
            immutableMap$Builder.put(string2, (Object)publicSuffixType);
        }
        ++n16;
        if (n17 != n11 && n17 != n12) {
            while (n16 < n15) {
                n17 = TrieParser.doParseTrieToBuilder(list, charSequence, n16, immutableMap$Builder);
                if ((n17 = (int)charSequence.charAt(n16 += n17)) != n11 && (n17 = (int)charSequence.charAt(n16)) != n12) continue;
                ++n16;
                break;
            }
        }
        list.remove(0);
        return n16 - n10;
    }

    public static ImmutableMap parseTrie(CharSequence charSequence) {
        int n10;
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        int n11 = charSequence.length();
        for (int i10 = 0; i10 < n11; i10 += n10) {
            LinkedList linkedList = Lists.newLinkedList();
            n10 = TrieParser.doParseTrieToBuilder(linkedList, charSequence, i10, immutableMap$Builder);
        }
        return immutableMap$Builder.build();
    }

    private static CharSequence reverse(CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder(charSequence);
        return stringBuilder.reverse();
    }
}

