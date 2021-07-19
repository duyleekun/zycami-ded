/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.content.res;

import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.provider.FontRequest;

public final class FontResourcesParserCompat$ProviderResourceEntry
implements FontResourcesParserCompat$FamilyResourceEntry {
    private final FontRequest mRequest;
    private final int mStrategy;
    private final String mSystemFontFamilyName;
    private final int mTimeoutMs;

    public FontResourcesParserCompat$ProviderResourceEntry(FontRequest fontRequest, int n10, int n11) {
        this(fontRequest, n10, n11, null);
    }

    public FontResourcesParserCompat$ProviderResourceEntry(FontRequest fontRequest, int n10, int n11, String string2) {
        this.mRequest = fontRequest;
        this.mStrategy = n10;
        this.mTimeoutMs = n11;
        this.mSystemFontFamilyName = string2;
    }

    public int getFetchStrategy() {
        return this.mStrategy;
    }

    public FontRequest getRequest() {
        return this.mRequest;
    }

    public String getSystemFontFamilyName() {
        return this.mSystemFontFamilyName;
    }

    public int getTimeout() {
        return this.mTimeoutMs;
    }
}

