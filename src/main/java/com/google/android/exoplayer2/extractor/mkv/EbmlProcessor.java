/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;

public interface EbmlProcessor {
    public static final int ELEMENT_TYPE_BINARY = 4;
    public static final int ELEMENT_TYPE_FLOAT = 5;
    public static final int ELEMENT_TYPE_MASTER = 1;
    public static final int ELEMENT_TYPE_STRING = 3;
    public static final int ELEMENT_TYPE_UNKNOWN = 0;
    public static final int ELEMENT_TYPE_UNSIGNED_INT = 2;

    public void binaryElement(int var1, int var2, ExtractorInput var3);

    public void endMasterElement(int var1);

    public void floatElement(int var1, double var2);

    public int getElementType(int var1);

    public void integerElement(int var1, long var2);

    public boolean isLevel1Element(int var1);

    public void startMasterElement(int var1, long var2, long var4);

    public void stringElement(int var1, String var2);
}

