/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Base64
 *  android.util.TypedValue
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry;
import androidx.core.provider.FontRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = 255;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    private FontResourcesParserCompat() {
    }

    private static int getType(TypedArray typedArray, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return typedArray.getType(n10);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(n10, typedValue);
        return typedValue.type;
    }

    public static FontResourcesParserCompat$FamilyResourceEntry parse(XmlPullParser object, Resources resources) {
        int n10;
        int n11;
        int n12;
        while ((n12 = object.next()) != (n11 = 2) && n12 != (n10 = 1)) {
        }
        if (n12 == n11) {
            return FontResourcesParserCompat.readFamilies(object, resources);
        }
        object = new XmlPullParserException("No start tag found");
        throw object;
    }

    public static List readCerts(Resources object, int n10) {
        ArrayList<String[]> arrayList;
        TypedArray typedArray;
        block19: {
            block18: {
                block17: {
                    if (n10 == 0) {
                        return Collections.emptyList();
                    }
                    typedArray = object.obtainTypedArray(n10);
                    int n11 = typedArray.length();
                    if (n11 != 0) break block17;
                    object = Collections.emptyList();
                    return object;
                }
                arrayList = new ArrayList<String[]>();
                int n12 = FontResourcesParserCompat.getType(typedArray, 0);
                int n13 = 1;
                if (n12 != n13) break block18;
                n10 = 0;
                while (true) {
                    block20: {
                        n12 = typedArray.length();
                        if (n10 >= n12) break block19;
                        n12 = typedArray.getResourceId(n10, 0);
                        if (n12 == 0) break block20;
                        Object object2 = object.getStringArray(n12);
                        object2 = FontResourcesParserCompat.toByteArrayList(object2);
                        arrayList.add((String[])object2);
                    }
                    ++n10;
                }
            }
            object = object.getStringArray(n10);
            object = FontResourcesParserCompat.toByteArrayList(object);
            arrayList.add((String[])object);
        }
        typedArray.recycle();
        return arrayList;
        finally {
            typedArray.recycle();
        }
    }

    private static FontResourcesParserCompat$FamilyResourceEntry readFamilies(XmlPullParser xmlPullParser, Resources resources) {
        String string2 = "font-family";
        xmlPullParser.require(2, null, string2);
        String string3 = xmlPullParser.getName();
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            return FontResourcesParserCompat.readFamily(xmlPullParser, resources);
        }
        FontResourcesParserCompat.skip(xmlPullParser);
        return null;
    }

    private static FontResourcesParserCompat$FamilyResourceEntry readFamily(XmlPullParser object, Resources fontResourcesParserCompat$FontFileResourceEntryArray) {
        Object object2 = Xml.asAttributeSet((XmlPullParser)object);
        Object object3 = R$styleable.FontFamily;
        object2 = fontResourcesParserCompat$FontFileResourceEntryArray.obtainAttributes(object2, (int[])object3);
        int n10 = R$styleable.FontFamily_fontProviderAuthority;
        object3 = object2.getString(n10);
        int n11 = R$styleable.FontFamily_fontProviderPackage;
        Object object4 = object2.getString(n11);
        int n12 = R$styleable.FontFamily_fontProviderQuery;
        String string2 = object2.getString(n12);
        int n13 = R$styleable.FontFamily_fontProviderCerts;
        n13 = object2.getResourceId(n13, 0);
        int n14 = R$styleable.FontFamily_fontProviderFetchStrategy;
        n14 = object2.getInteger(n14, 1);
        int n15 = R$styleable.FontFamily_fontProviderFetchTimeout;
        n15 = object2.getInteger(n15, 500);
        int n16 = R$styleable.FontFamily_fontProviderSystemFontFamily;
        String string3 = object2.getString(n16);
        object2.recycle();
        int n17 = 3;
        if (object3 != null && object4 != null && string2 != null) {
            int n18;
            while ((n18 = object.next()) != n17) {
                FontResourcesParserCompat.skip(object);
            }
            object = FontResourcesParserCompat.readCerts((Resources)fontResourcesParserCompat$FontFileResourceEntryArray, n13);
            object2 = new FontRequest((String)object3, (String)object4, string2, (List)object);
            fontResourcesParserCompat$FontFileResourceEntryArray = new FontResourcesParserCompat$ProviderResourceEntry((FontRequest)object2, n14, n15, string3);
            return fontResourcesParserCompat$FontFileResourceEntryArray;
        }
        object3 = new ArrayList;
        ((ArrayList)object3)();
        while ((n11 = object.next()) != n17) {
            n11 = object.getEventType();
            if (n11 != (n12 = 2)) continue;
            object4 = object.getName();
            n11 = (int)(((String)object4).equals(string2 = "font") ? 1 : 0);
            if (n11 != 0) {
                object4 = FontResourcesParserCompat.readFont(object, (Resources)fontResourcesParserCompat$FontFileResourceEntryArray);
                object3.add(object4);
                continue;
            }
            FontResourcesParserCompat.skip(object);
        }
        boolean bl2 = object3.isEmpty();
        if (bl2) {
            return null;
        }
        fontResourcesParserCompat$FontFileResourceEntryArray = new FontResourcesParserCompat$FontFileResourceEntry[object3.size()];
        fontResourcesParserCompat$FontFileResourceEntryArray = object3.toArray(fontResourcesParserCompat$FontFileResourceEntryArray);
        object = new FontResourcesParserCompat$FontFamilyFilesResourceEntry(fontResourcesParserCompat$FontFileResourceEntryArray);
        return object;
    }

    private static FontResourcesParserCompat$FontFileResourceEntry readFont(XmlPullParser object, Resources resources) {
        int n10;
        int n11;
        int[] nArray;
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)object);
        boolean bl2 = (resources = resources.obtainAttributes(attributeSet, nArray = R$styleable.FontFamilyFont)).hasValue(n11 = R$styleable.FontFamilyFont_fontWeight);
        if (!bl2) {
            n11 = R$styleable.FontFamilyFont_android_fontWeight;
        }
        int n12 = resources.getInt(n11, 400);
        n11 = R$styleable.FontFamilyFont_fontStyle;
        bl2 = resources.hasValue(n11);
        if (!bl2) {
            n11 = R$styleable.FontFamilyFont_android_fontStyle;
        }
        bl2 = false;
        nArray = null;
        n11 = resources.getInt(n11, 0);
        int n13 = 1;
        int n14 = n13 == n11 ? n13 : 0;
        n11 = R$styleable.FontFamilyFont_ttcIndex;
        n13 = (int)(resources.hasValue(n11) ? 1 : 0);
        if (!n13) {
            n11 = R$styleable.FontFamilyFont_android_ttcIndex;
        }
        n13 = R$styleable.FontFamilyFont_fontVariationSettings;
        boolean bl3 = resources.hasValue(n13);
        if (!bl3) {
            n13 = R$styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string2 = resources.getString(n13);
        int n15 = resources.getInt(n11, 0);
        n11 = R$styleable.FontFamilyFont_font;
        n13 = (int)(resources.hasValue(n11) ? 1 : 0);
        if (!n13) {
            n11 = R$styleable.FontFamilyFont_android_font;
        }
        int n16 = resources.getResourceId(n11, 0);
        String string3 = resources.getString(n11);
        resources.recycle();
        while ((n10 = object.next()) != (n11 = 3)) {
            FontResourcesParserCompat.skip(object);
        }
        object = new FontResourcesParserCompat$FontFileResourceEntry(string3, n12, n14 != 0, string2, n15, n16);
        return object;
    }

    private static void skip(XmlPullParser xmlPullParser) {
        int n10 = 1;
        while (n10 > 0) {
            int n11;
            int n12 = xmlPullParser.next();
            if (n12 != (n11 = 2)) {
                n11 = 3;
                if (n12 != n11) continue;
                n10 += -1;
                continue;
            }
            ++n10;
        }
    }

    private static List toByteArrayList(String[] stringArray) {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte[] byArray = Base64.decode((String)stringArray[i10], (int)0);
            arrayList.add(byArray);
        }
        return arrayList;
    }
}

