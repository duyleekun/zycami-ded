/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.Typeface$CustomFallbackBuilder
 *  android.graphics.fonts.Font
 *  android.graphics.fonts.Font$Builder
 *  android.graphics.fonts.FontFamily
 *  android.graphics.fonts.FontFamily$Builder
 *  android.graphics.fonts.FontStyle
 *  android.os.CancellationSignal
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.IOException;
import java.io.InputStream;

public class TypefaceCompatApi29Impl
extends TypefaceCompatBaseImpl {
    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontStyle, Resources resources, int n10) {
        context = null;
        try {
            fontStyle = fontStyle.getEntries();
            int n11 = ((FontResourcesParserCompat$FontFileResourceEntry[])fontStyle).length;
            int n12 = 0;
            Object object = null;
            int n13 = 0;
            while (true) {
                block11: {
                    int n14 = 1;
                    if (n13 < n11) {
                        Font.Builder builder;
                        Object object2 = fontStyle[n13];
                        int n15 = ((FontResourcesParserCompat$FontFileResourceEntry)object2).getResourceId();
                        Font.Builder builder2 = new Font.Builder(resources, n15);
                        n15 = ((FontResourcesParserCompat$FontFileResourceEntry)object2).getWeight();
                        builder2 = builder2.setWeight(n15);
                        n15 = (int)(((FontResourcesParserCompat$FontFileResourceEntry)object2).isItalic() ? 1 : 0);
                        if (n15 == 0) {
                            n14 = 0;
                            builder = null;
                        }
                        builder = builder2.setSlant(n14);
                        int n16 = ((FontResourcesParserCompat$FontFileResourceEntry)object2).getTtcIndex();
                        builder = builder.setTtcIndex(n16);
                        object2 = ((FontResourcesParserCompat$FontFileResourceEntry)object2).getVariationSettings();
                        builder = builder.setFontVariationSettings((String)object2);
                        builder = builder.build();
                        if (object == null) {
                            object = object2 = new FontFamily.Builder((Font)builder);
                            break block11;
                        } else {
                            object.addFont((Font)builder);
                        }
                        break block11;
                    }
                    if (object == null) {
                        return null;
                    }
                    int n17 = n10 & 1;
                    n17 = n17 != 0 ? 700 : 400;
                    if ((n10 &= 2) != 0) {
                        n12 = n14;
                    }
                    fontStyle = new FontStyle(n17, n12);
                    FontFamily fontFamily = object.build();
                    resources = new Typeface.CustomFallbackBuilder(fontFamily);
                    fontStyle = resources.setStyle(fontStyle);
                    return fontStyle.build();
                    catch (IOException iOException) {}
                }
                ++n13;
            }
        }
        catch (Exception exception) {
            return context;
        }
    }

    /*
     * Exception decompiling
     */
    public Typeface createFromFontInfo(Context var1_1, CancellationSignal var2_2, FontsContractCompat$FontInfo[] var3_3, int var4_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public Typeface createFromInputStream(Context object, InputStream inputStream) {
        object = new RuntimeException("Do not use this function in API 29 or later.");
        throw object;
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int n10, String string2, int n11) {
        try {
            context = new Font.Builder(resources, n10);
            context = context.build();
        }
        catch (Exception exception) {
            return null;
        }
        resources = new FontFamily.Builder((Font)context);
        resources = resources.build();
        Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder((FontFamily)resources);
        context = context.getStyle();
        context = customFallbackBuilder.setStyle((FontStyle)context);
        return context.build();
    }

    public FontsContractCompat$FontInfo findBestInfo(FontsContractCompat$FontInfo[] object, int n10) {
        object = new RuntimeException("Do not use this function in API 29 or later.");
        throw object;
    }
}

