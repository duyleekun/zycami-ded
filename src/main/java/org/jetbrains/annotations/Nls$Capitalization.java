/*
 * Decompiled with CFR 0.151.
 */
package org.jetbrains.annotations;

public final class Nls$Capitalization
extends Enum {
    public static final /* enum */ Nls$Capitalization NotSpecified;
    public static final /* enum */ Nls$Capitalization Sentence;
    public static final /* enum */ Nls$Capitalization Title;
    private static final /* synthetic */ Nls$Capitalization[] a;

    static {
        Nls$Capitalization nls$Capitalization;
        Nls$Capitalization nls$Capitalization2;
        Nls$Capitalization nls$Capitalization3;
        NotSpecified = nls$Capitalization3 = new Nls$Capitalization("NotSpecified", 0);
        int n10 = 1;
        Title = nls$Capitalization2 = new Nls$Capitalization("Title", n10);
        int n11 = 2;
        Sentence = nls$Capitalization = new Nls$Capitalization("Sentence", n11);
        Nls$Capitalization[] nls$CapitalizationArray = new Nls$Capitalization[3];
        nls$CapitalizationArray[0] = nls$Capitalization3;
        nls$CapitalizationArray[n10] = nls$Capitalization2;
        nls$CapitalizationArray[n11] = nls$Capitalization;
        a = nls$CapitalizationArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Nls$Capitalization() {
        void var2_-1;
        void var1_-1;
    }

    public static Nls$Capitalization valueOf(String string2) {
        return Enum.valueOf(Nls$Capitalization.class, string2);
    }

    public static Nls$Capitalization[] values() {
        return (Nls$Capitalization[])a.clone();
    }
}

