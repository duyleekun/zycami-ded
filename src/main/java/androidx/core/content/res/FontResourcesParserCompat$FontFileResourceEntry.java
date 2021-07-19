/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.content.res;

public final class FontResourcesParserCompat$FontFileResourceEntry {
    private final String mFileName;
    private boolean mItalic;
    private int mResourceId;
    private int mTtcIndex;
    private String mVariationSettings;
    private int mWeight;

    public FontResourcesParserCompat$FontFileResourceEntry(String string2, int n10, boolean bl2, String string3, int n11, int n12) {
        this.mFileName = string2;
        this.mWeight = n10;
        this.mItalic = bl2;
        this.mVariationSettings = string3;
        this.mTtcIndex = n11;
        this.mResourceId = n12;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public int getResourceId() {
        return this.mResourceId;
    }

    public int getTtcIndex() {
        return this.mTtcIndex;
    }

    public String getVariationSettings() {
        return this.mVariationSettings;
    }

    public int getWeight() {
        return this.mWeight;
    }

    public boolean isItalic() {
        return this.mItalic;
    }
}

