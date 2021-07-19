/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.graphics;

import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor;

public class TypefaceCompatBaseImpl$2
implements TypefaceCompatBaseImpl$StyleExtractor {
    public final /* synthetic */ TypefaceCompatBaseImpl this$0;

    public TypefaceCompatBaseImpl$2(TypefaceCompatBaseImpl typefaceCompatBaseImpl) {
        this.this$0 = typefaceCompatBaseImpl;
    }

    public int getWeight(FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry) {
        return fontResourcesParserCompat$FontFileResourceEntry.getWeight();
    }

    public boolean isItalic(FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry) {
        return fontResourcesParserCompat$FontFileResourceEntry.isItalic();
    }
}

