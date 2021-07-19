/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model;

public final class DocumentData$Justification
extends Enum {
    private static final /* synthetic */ DocumentData$Justification[] $VALUES;
    public static final /* enum */ DocumentData$Justification CENTER;
    public static final /* enum */ DocumentData$Justification LEFT_ALIGN;
    public static final /* enum */ DocumentData$Justification RIGHT_ALIGN;

    static {
        DocumentData$Justification documentData$Justification;
        DocumentData$Justification documentData$Justification2;
        DocumentData$Justification documentData$Justification3;
        LEFT_ALIGN = documentData$Justification3 = new DocumentData$Justification("LEFT_ALIGN", 0);
        int n10 = 1;
        RIGHT_ALIGN = documentData$Justification2 = new DocumentData$Justification("RIGHT_ALIGN", n10);
        int n11 = 2;
        CENTER = documentData$Justification = new DocumentData$Justification("CENTER", n11);
        DocumentData$Justification[] documentData$JustificationArray = new DocumentData$Justification[3];
        documentData$JustificationArray[0] = documentData$Justification3;
        documentData$JustificationArray[n10] = documentData$Justification2;
        documentData$JustificationArray[n11] = documentData$Justification;
        $VALUES = documentData$JustificationArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DocumentData$Justification() {
        void var2_-1;
        void var1_-1;
    }

    public static DocumentData$Justification valueOf(String string2) {
        return Enum.valueOf(DocumentData$Justification.class, string2);
    }

    public static DocumentData$Justification[] values() {
        return (DocumentData$Justification[])$VALUES.clone();
    }
}

