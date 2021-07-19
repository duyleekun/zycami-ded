/*
 * Decompiled with CFR 0.151.
 */
package com.google.thirdparty.publicsuffix;

public final class PublicSuffixType
extends Enum {
    private static final /* synthetic */ PublicSuffixType[] $VALUES;
    public static final /* enum */ PublicSuffixType PRIVATE;
    public static final /* enum */ PublicSuffixType REGISTRY;
    private final char innerNodeCode;
    private final char leafNodeCode;

    static {
        PublicSuffixType publicSuffixType;
        PublicSuffixType publicSuffixType2;
        PRIVATE = publicSuffixType2 = new PublicSuffixType("PRIVATE", 0, ':', ',');
        int n10 = 1;
        REGISTRY = publicSuffixType = new PublicSuffixType("REGISTRY", n10, '!', '?');
        PublicSuffixType[] publicSuffixTypeArray = new PublicSuffixType[2];
        publicSuffixTypeArray[0] = publicSuffixType2;
        publicSuffixTypeArray[n10] = publicSuffixType;
        $VALUES = publicSuffixTypeArray;
    }

    /*
     * WARNING - void declaration
     */
    private PublicSuffixType() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.innerNodeCode = var3_1;
        this.leafNodeCode = var4_2;
    }

    public static PublicSuffixType fromCode(char c10) {
        for (PublicSuffixType publicSuffixType : PublicSuffixType.values()) {
            char c11 = publicSuffixType.getInnerNodeCode();
            if (c11 != c10 && (c11 = publicSuffixType.getLeafNodeCode()) != c10) {
                continue;
            }
            return publicSuffixType;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No enum corresponding to given code: ");
        stringBuilder.append(c10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static PublicSuffixType fromIsPrivate(boolean bl2) {
        PublicSuffixType publicSuffixType = bl2 ? PRIVATE : REGISTRY;
        return publicSuffixType;
    }

    public static PublicSuffixType valueOf(String string2) {
        return Enum.valueOf(PublicSuffixType.class, string2);
    }

    public static PublicSuffixType[] values() {
        return (PublicSuffixType[])$VALUES.clone();
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}

