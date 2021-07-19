/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.List;

public final class InternetDomainName {
    private static final CharMatcher DASH_MATCHER;
    private static final CharMatcher DIGIT_MATCHER;
    private static final CharMatcher DOTS_MATCHER;
    private static final Joiner DOT_JOINER;
    private static final Splitter DOT_SPLITTER;
    private static final CharMatcher LETTER_MATCHER;
    private static final int MAX_DOMAIN_PART_LENGTH = 63;
    private static final int MAX_LENGTH = 253;
    private static final int MAX_PARTS = 127;
    private static final int NO_SUFFIX_FOUND = 255;
    private static final CharMatcher PART_CHAR_MATCHER;
    private final String name;
    private final ImmutableList parts;
    private final int publicSuffixIndex;
    private final int registrySuffixIndex;

    static {
        CharMatcher charMatcher;
        CharMatcher charMatcher2;
        DOTS_MATCHER = CharMatcher.anyOf(".\u3002\uff0e\uff61");
        char c10 = '.';
        DOT_SPLITTER = Splitter.on(c10);
        DOT_JOINER = Joiner.on(c10);
        DASH_MATCHER = charMatcher2 = CharMatcher.anyOf("-_");
        DIGIT_MATCHER = charMatcher = CharMatcher.inRange('0', '9');
        CharMatcher charMatcher3 = CharMatcher.inRange('a', 'z');
        CharMatcher charMatcher4 = CharMatcher.inRange('A', 'Z');
        LETTER_MATCHER = charMatcher3 = charMatcher3.or(charMatcher4);
        PART_CHAR_MATCHER = charMatcher.or(charMatcher3).or(charMatcher2);
    }

    /*
     * WARNING - void declaration
     */
    public InternetDomainName(String object) {
        int n10;
        void var3_8;
        int n11;
        int n12;
        object = Ascii.toLowerCase(DOTS_MATCHER.replaceFrom((CharSequence)object, '.'));
        Object object2 = ".";
        boolean bl3 = ((String)object).endsWith((String)object2);
        int n13 = 1;
        if (bl3) {
            int n14 = ((String)object).length() - n13;
            object = ((String)object).substring(0, n14);
        }
        if ((n12 = ((String)object).length()) <= (n11 = 253)) {
            int n15 = n13;
        } else {
            boolean bl2 = false;
            object2 = null;
        }
        String string2 = "Domain name too long: '%s':";
        Preconditions.checkArgument((boolean)var3_8, string2, object);
        this.name = object;
        this.parts = object2 = ImmutableList.copyOf(DOT_SPLITTER.split((CharSequence)object));
        int n16 = ((AbstractCollection)object2).size();
        int n17 = 127;
        if (n16 > n17) {
            n13 = 0;
        }
        Preconditions.checkArgument(n13 != 0, "Domain has too many parts: '%s'", object);
        Preconditions.checkArgument(InternetDomainName.validateSyntax((List)object2), "Not a valid domain name: '%s'", object);
        object = Optional.absent();
        this.publicSuffixIndex = n10 = this.findSuffixOfType((Optional)object);
        object = Optional.of((Object)PublicSuffixType.REGISTRY);
        this.registrySuffixIndex = n10 = this.findSuffixOfType((Optional)object);
    }

    private InternetDomainName ancestor(int n10) {
        Joiner joiner = DOT_JOINER;
        ImmutableList immutableList = this.parts;
        int n11 = immutableList.size();
        ImmutableList immutableList2 = immutableList.subList(n10, n11);
        return InternetDomainName.from(joiner.join(immutableList2));
    }

    private int findSuffixOfType(Optional optional) {
        ImmutableList immutableList = this.parts;
        int n10 = immutableList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = DOT_JOINER;
            Serializable serializable = this.parts.subList(i10, n10);
            boolean bl2 = InternetDomainName.matchesType(optional, (Optional)(serializable = Optional.fromNullable(PublicSuffixPatterns.EXACT.get(object = ((Joiner)object).join((Iterable)((Object)serializable))))));
            if (bl2) {
                return i10;
            }
            serializable = PublicSuffixPatterns.EXCLUDED;
            bl2 = ((ImmutableMap)serializable).containsKey(object);
            if (bl2) {
                return i10 + 1;
            }
            boolean bl3 = InternetDomainName.matchesWildcardSuffixType(optional, (String)object);
            if (!bl3) continue;
            return i10;
        }
        return -1;
    }

    public static InternetDomainName from(String string2) {
        string2 = (String)Preconditions.checkNotNull(string2);
        InternetDomainName internetDomainName = new InternetDomainName(string2);
        return internetDomainName;
    }

    public static boolean isValid(String string2) {
        try {
            InternetDomainName.from(string2);
            return true;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
    }

    private static boolean matchesType(Optional optional, Optional optional2) {
        boolean bl2 = optional.isPresent();
        boolean bl3 = bl2 ? optional.equals(optional2) : optional2.isPresent();
        return bl3;
    }

    private static boolean matchesWildcardSuffixType(Optional optional, String object) {
        int n10;
        block3: {
            block2: {
                Object object2 = DOT_SPLITTER;
                int n11 = 2;
                object2 = ((Splitter)object2).limit(n11);
                object = ((Splitter)object2).splitToList((CharSequence)object);
                int n12 = object.size();
                n10 = 1;
                if (n12 != n11) break block2;
                object2 = PublicSuffixPatterns.UNDER;
                object = object.get(n10);
                boolean bl2 = InternetDomainName.matchesType(optional, (Optional)(object = Optional.fromNullable(((ImmutableMap)object2).get(object))));
                if (bl2) break block3;
            }
            n10 = 0;
        }
        return n10 != 0;
    }

    private static boolean validatePart(String string2, boolean bl2) {
        int n10;
        int n11;
        int n12 = string2.length();
        if (n12 >= (n11 = 1) && (n12 = string2.length()) <= (n10 = 63)) {
            CharMatcher charMatcher = PART_CHAR_MATCHER;
            Object object = CharMatcher.ascii().retainFrom(string2);
            n12 = (int)(charMatcher.matchesAllOf((CharSequence)object) ? 1 : 0);
            if (!n12) {
                return false;
            }
            object = DASH_MATCHER;
            n10 = string2.charAt(0);
            if (!(n10 = (int)(((CharMatcher)object).matches((char)n10) ? 1 : 0))) {
                n10 = string2.length() - n11;
                n12 = (int)(((CharMatcher)object).matches((char)(n10 = (int)string2.charAt(n10))) ? 1 : 0);
                if (!n12) {
                    if (bl2) {
                        CharMatcher charMatcher2 = DIGIT_MATCHER;
                        char c10 = string2.charAt(0);
                        if ((c10 = (char)(charMatcher2.matches(c10) ? 1 : 0)) != '\u0000') {
                            return false;
                        }
                    }
                    return n11 != 0;
                }
            }
        }
        return false;
    }

    private static boolean validateSyntax(List list) {
        int n10 = list.size();
        int n11 = 1;
        String string2 = (String)list.get(n10 -= n11);
        int n12 = InternetDomainName.validatePart(string2, n11 != 0);
        if (n12 == 0) {
            return false;
        }
        string2 = null;
        for (n12 = 0; n12 < n10; ++n12) {
            String string3 = (String)list.get(n12);
            boolean bl2 = InternetDomainName.validatePart(string3, false);
            if (bl2) continue;
            return false;
        }
        return n11 != 0;
    }

    public InternetDomainName child(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        string2 = (String)Preconditions.checkNotNull(string2);
        stringBuilder.append(string2);
        stringBuilder.append(".");
        string2 = this.name;
        stringBuilder.append(string2);
        return InternetDomainName.from(stringBuilder.toString());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof InternetDomainName;
        if (bl2) {
            object = (InternetDomainName)object;
            String string2 = this.name;
            object = ((InternetDomainName)object).name;
            return string2.equals(object);
        }
        return false;
    }

    public boolean hasParent() {
        int n10;
        ImmutableList immutableList = this.parts;
        int n11 = immutableList.size();
        if (n11 <= (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean hasPublicSuffix() {
        int n10 = this.publicSuffixIndex;
        int n11 = -1;
        n10 = n10 != n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasRegistrySuffix() {
        int n10 = this.registrySuffixIndex;
        int n11 = -1;
        n10 = n10 != n11 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean isPublicSuffix() {
        int n10 = this.publicSuffixIndex;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isRegistrySuffix() {
        int n10 = this.registrySuffixIndex;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isTopDomainUnderRegistrySuffix() {
        int n10 = this.registrySuffixIndex;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isTopPrivateDomain() {
        int n10 = this.publicSuffixIndex;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isUnderPublicSuffix() {
        int n10 = this.publicSuffixIndex;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isUnderRegistrySuffix() {
        int n10 = this.registrySuffixIndex;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public InternetDomainName parent() {
        boolean bl2 = this.hasParent();
        String string2 = this.name;
        Preconditions.checkState(bl2, "Domain '%s' has no parent", (Object)string2);
        return this.ancestor(1);
    }

    public ImmutableList parts() {
        return this.parts;
    }

    public InternetDomainName publicSuffix() {
        InternetDomainName internetDomainName;
        int n10 = this.hasPublicSuffix();
        if (n10 != 0) {
            n10 = this.publicSuffixIndex;
            internetDomainName = this.ancestor(n10);
        } else {
            n10 = 0;
            internetDomainName = null;
        }
        return internetDomainName;
    }

    public InternetDomainName registrySuffix() {
        InternetDomainName internetDomainName;
        int n10 = this.hasRegistrySuffix();
        if (n10 != 0) {
            n10 = this.registrySuffixIndex;
            internetDomainName = this.ancestor(n10);
        } else {
            n10 = 0;
            internetDomainName = null;
        }
        return internetDomainName;
    }

    public String toString() {
        return this.name;
    }

    public InternetDomainName topDomainUnderRegistrySuffix() {
        int n10 = this.isTopDomainUnderRegistrySuffix();
        if (n10 != 0) {
            return this;
        }
        n10 = this.isUnderRegistrySuffix();
        String string2 = this.name;
        Preconditions.checkState(n10 != 0, "Not under a registry suffix: %s", (Object)string2);
        n10 = this.registrySuffixIndex + -1;
        return this.ancestor(n10);
    }

    public InternetDomainName topPrivateDomain() {
        int n10 = this.isTopPrivateDomain();
        if (n10 != 0) {
            return this;
        }
        n10 = this.isUnderPublicSuffix();
        String string2 = this.name;
        Preconditions.checkState(n10 != 0, "Not under a public suffix: %s", (Object)string2);
        n10 = this.publicSuffixIndex + -1;
        return this.ancestor(n10);
    }
}

