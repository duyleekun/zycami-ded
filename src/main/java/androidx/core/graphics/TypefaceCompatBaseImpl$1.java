/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.graphics;

import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor;
import androidx.core.provider.FontsContractCompat$FontInfo;

public class TypefaceCompatBaseImpl$1
implements TypefaceCompatBaseImpl$StyleExtractor {
    public final /* synthetic */ TypefaceCompatBaseImpl this$0;

    public TypefaceCompatBaseImpl$1(TypefaceCompatBaseImpl typefaceCompatBaseImpl) {
        this.this$0 = typefaceCompatBaseImpl;
    }

    public int getWeight(FontsContractCompat$FontInfo fontsContractCompat$FontInfo) {
        return fontsContractCompat$FontInfo.getWeight();
    }

    public boolean isItalic(FontsContractCompat$FontInfo fontsContractCompat$FontInfo) {
        return fontsContractCompat$FontInfo.isItalic();
    }
}

