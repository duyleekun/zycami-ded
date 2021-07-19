/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.content.res;

import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;

public final class FontResourcesParserCompat$FontFamilyFilesResourceEntry
implements FontResourcesParserCompat$FamilyResourceEntry {
    private final FontResourcesParserCompat$FontFileResourceEntry[] mEntries;

    public FontResourcesParserCompat$FontFamilyFilesResourceEntry(FontResourcesParserCompat$FontFileResourceEntry[] fontResourcesParserCompat$FontFileResourceEntryArray) {
        this.mEntries = fontResourcesParserCompat$FontFileResourceEntryArray;
    }

    public FontResourcesParserCompat$FontFileResourceEntry[] getEntries() {
        return this.mEntries;
    }
}

