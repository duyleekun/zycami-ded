/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.Handler
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.graphics.TypefaceCompat$ResourcesCallbackAdapter;
import androidx.core.graphics.TypefaceCompatApi21Impl;
import androidx.core.graphics.TypefaceCompatApi24Impl;
import androidx.core.graphics.TypefaceCompatApi26Impl;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import androidx.core.graphics.TypefaceCompatApi29Impl;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.FontsContractCompat$FontInfo;

public class TypefaceCompat {
    private static final LruCache sTypefaceCache;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    static {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            object = new TypefaceCompatApi29Impl();
            sTypefaceCompatImpl = object;
        } else {
            n11 = 28;
            sTypefaceCompatImpl = n10 >= n11 ? (object = new TypefaceCompatApi28Impl()) : (n10 >= (n11 = 26) ? (object = new TypefaceCompatApi26Impl()) : (n10 >= (n11 = 24) && (n11 = (int)(TypefaceCompatApi24Impl.isUsable() ? 1 : 0)) != 0 ? (object = new TypefaceCompatApi24Impl()) : (n10 >= (n11 = 21) ? (object = new TypefaceCompatApi21Impl()) : (object = new TypefaceCompatBaseImpl()))));
        }
        sTypefaceCache = object = new LruCache(16);
    }

    private TypefaceCompat() {
    }

    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    public static Typeface create(Context object, Typeface typeface, int n10) {
        if (object != null) {
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 21;
            if (n11 < n12 && (object = TypefaceCompat.getBestFontFromFamily(object, typeface, n10)) != null) {
                return object;
            }
            return Typeface.create((Typeface)typeface, (int)n10);
        }
        object = new IllegalArgumentException("Context cannot be null");
        throw object;
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArray, int n10) {
        return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontsContractCompat$FontInfoArray, n10);
    }

    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry, Resources resources, int n10, int n11, ResourcesCompat$FontCallback resourcesCompat$FontCallback, Handler handler, boolean bl2) {
        FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry2 = fontResourcesParserCompat$FamilyResourceEntry;
        Object object = resourcesCompat$FontCallback;
        Object object2 = handler;
        int n12 = fontResourcesParserCompat$FamilyResourceEntry instanceof FontResourcesParserCompat$ProviderResourceEntry;
        if (n12 != 0) {
            int n13;
            fontResourcesParserCompat$FamilyResourceEntry2 = (FontResourcesParserCompat$ProviderResourceEntry)fontResourcesParserCompat$FamilyResourceEntry;
            Typeface typeface = TypefaceCompat.getSystemFontFamily(((FontResourcesParserCompat$ProviderResourceEntry)fontResourcesParserCompat$FamilyResourceEntry2).getSystemFontFamilyName());
            if (typeface != null) {
                if (resourcesCompat$FontCallback != null) {
                    resourcesCompat$FontCallback.callbackSuccessAsync(typeface, handler);
                }
                return typeface;
            }
            n12 = 1;
            int n14 = (bl2 ? (n13 = ((FontResourcesParserCompat$ProviderResourceEntry)fontResourcesParserCompat$FamilyResourceEntry2).getFetchStrategy()) == 0 : resourcesCompat$FontCallback == null) ? n12 : 0;
            n12 = bl2 ? ((FontResourcesParserCompat$ProviderResourceEntry)fontResourcesParserCompat$FamilyResourceEntry2).getTimeout() : -1;
            Handler handler2 = ResourcesCompat$FontCallback.getHandler(handler);
            TypefaceCompat$ResourcesCallbackAdapter typefaceCompat$ResourcesCallbackAdapter = new TypefaceCompat$ResourcesCallbackAdapter((ResourcesCompat$FontCallback)object);
            FontRequest fontRequest = ((FontResourcesParserCompat$ProviderResourceEntry)fontResourcesParserCompat$FamilyResourceEntry2).getRequest();
            fontResourcesParserCompat$FamilyResourceEntry2 = FontsContractCompat.requestFont(context, fontRequest, n11, n14 != 0, n12, handler2, typefaceCompat$ResourcesCallbackAdapter);
        } else {
            TypefaceCompatBaseImpl typefaceCompatBaseImpl = sTypefaceCompatImpl;
            fontResourcesParserCompat$FamilyResourceEntry2 = (FontResourcesParserCompat$FontFamilyFilesResourceEntry)fontResourcesParserCompat$FamilyResourceEntry;
            fontResourcesParserCompat$FamilyResourceEntry2 = typefaceCompatBaseImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat$FontFamilyFilesResourceEntry)fontResourcesParserCompat$FamilyResourceEntry2, resources, n11);
            if (resourcesCompat$FontCallback != null) {
                if (fontResourcesParserCompat$FamilyResourceEntry2 != null) {
                    resourcesCompat$FontCallback.callbackSuccessAsync((Typeface)fontResourcesParserCompat$FamilyResourceEntry2, handler);
                } else {
                    n12 = -3;
                    resourcesCompat$FontCallback.callbackFailAsync(n12, handler);
                }
            }
        }
        if (fontResourcesParserCompat$FamilyResourceEntry2 != null) {
            object = sTypefaceCache;
            object2 = TypefaceCompat.createResourceUid(resources, n10, n11);
            ((LruCache)object).put(object2, fontResourcesParserCompat$FamilyResourceEntry2);
        }
        return fontResourcesParserCompat$FamilyResourceEntry2;
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources object, int n10, String string2, int n11) {
        TypefaceCompatBaseImpl typefaceCompatBaseImpl = sTypefaceCompatImpl;
        if ((context = typefaceCompatBaseImpl.createFromResourcesFontFile(context, (Resources)object, n10, string2, n11)) != null) {
            object = TypefaceCompat.createResourceUid(object, n10, n11);
            LruCache lruCache = sTypefaceCache;
            lruCache.put(object, context);
        }
        return context;
    }

    private static String createResourceUid(Resources object, int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        object = object.getResourcePackageName(n10);
        stringBuilder.append((String)object);
        object = "-";
        stringBuilder.append((String)object);
        stringBuilder.append(n10);
        stringBuilder.append((String)object);
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public static Typeface findFromCache(Resources object, int n10, int n11) {
        LruCache lruCache = sTypefaceCache;
        object = TypefaceCompat.createResourceUid(object, n10, n11);
        return (Typeface)lruCache.get(object);
    }

    private static Typeface getBestFontFromFamily(Context context, Typeface object, int n10) {
        TypefaceCompatBaseImpl typefaceCompatBaseImpl = sTypefaceCompatImpl;
        if ((object = typefaceCompatBaseImpl.getFontFamily((Typeface)object)) == null) {
            return null;
        }
        Resources resources = context.getResources();
        return typefaceCompatBaseImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat$FontFamilyFilesResourceEntry)object, resources, n10);
    }

    private static Typeface getSystemFontFamily(String string2) {
        boolean bl2;
        String string3 = null;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            bl2 = false;
            string2 = Typeface.create((String)string2, (int)0);
            Typeface typeface = Typeface.DEFAULT;
            Typeface typeface2 = Typeface.create((Typeface)typeface, (int)0);
            if (string2 != null && !(bl2 = string2.equals((Object)typeface2))) {
                string3 = string2;
            }
        }
        return string3;
    }
}

