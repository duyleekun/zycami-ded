/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.util.Log
 */
package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl$1;
import androidx.core.graphics.TypefaceCompatBaseImpl$2;
import androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

public class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    private ConcurrentHashMap mFontFamilies;

    public TypefaceCompatBaseImpl() {
        ConcurrentHashMap concurrentHashMap;
        this.mFontFamilies = concurrentHashMap = new ConcurrentHashMap();
    }

    private void addFontFamily(Typeface object, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry) {
        long l10;
        long l11 = TypefaceCompatBaseImpl.getUniqueKey((Typeface)object);
        long l12 = l11 - (l10 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            object = this.mFontFamilies;
            Long l13 = l11;
            ((ConcurrentHashMap)object).put(l13, fontResourcesParserCompat$FontFamilyFilesResourceEntry);
        }
    }

    private FontResourcesParserCompat$FontFileResourceEntry findBestEntry(FontResourcesParserCompat$FontFamilyFilesResourceEntry objectArray, int n10) {
        objectArray = objectArray.getEntries();
        TypefaceCompatBaseImpl$2 typefaceCompatBaseImpl$2 = new TypefaceCompatBaseImpl$2(this);
        return (FontResourcesParserCompat$FontFileResourceEntry)TypefaceCompatBaseImpl.findBestFont(objectArray, n10, typefaceCompatBaseImpl$2);
    }

    private static Object findBestFont(Object[] objectArray, int n10, TypefaceCompatBaseImpl$StyleExtractor typefaceCompatBaseImpl$StyleExtractor) {
        int n11 = n10 & 1;
        n11 = n11 == 0 ? 400 : 700;
        int n12 = 1;
        n10 = (n10 &= 2) != 0 ? n12 : 0;
        Object object = null;
        int n13 = -1 >>> 1;
        for (Object object2 : objectArray) {
            int n14 = Math.abs(typefaceCompatBaseImpl$StyleExtractor.getWeight(object2) - n11) * 2;
            int n15 = typefaceCompatBaseImpl$StyleExtractor.isItalic(object2);
            n15 = n15 == n10 ? 0 : n12;
            if (object != null && n13 <= (n14 += n15)) continue;
            object = object2;
            n13 = n14;
        }
        return object;
    }

    private static long getUniqueKey(Typeface object) {
        String string2 = "Could not retrieve font from family.";
        String string3 = TAG;
        long l10 = 0L;
        if (object == null) {
            return l10;
        }
        Object object2 = Typeface.class;
        String string4 = "native_instance";
        object2 = ((Class)object2).getDeclaredField(string4);
        boolean bl2 = true;
        ((Field)object2).setAccessible(bl2);
        object = ((Field)object2).get(object);
        object = (Number)object;
        try {
            return ((Number)object).longValue();
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)string3, (String)string2, (Throwable)illegalAccessException);
            return l10;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Log.e((String)string3, (String)string2, (Throwable)noSuchFieldException);
            return l10;
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int n10) {
        Object object = this.findBestEntry(fontResourcesParserCompat$FontFamilyFilesResourceEntry, n10);
        if (object == null) {
            return null;
        }
        int n11 = ((FontResourcesParserCompat$FontFileResourceEntry)object).getResourceId();
        object = ((FontResourcesParserCompat$FontFileResourceEntry)object).getFileName();
        context = TypefaceCompat.createFromResourcesFontFile(context, resources, n11, (String)object, n10);
        this.addFontFamily((Typeface)context, fontResourcesParserCompat$FontFamilyFilesResourceEntry);
        return context;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Typeface createFromFontInfo(Context context, CancellationSignal object, FontsContractCompat$FontInfo[] contentResolver, int n10) {
        void var1_4;
        Object object2;
        int n11;
        block7: {
            n11 = ((ContentResolver)contentResolver).length;
            object2 = null;
            int n12 = 1;
            if (n11 < n12) {
                return null;
            }
            object = this.findBestInfo((FontsContractCompat$FontInfo[])contentResolver, n10);
            contentResolver = context.getContentResolver();
            object = ((FontsContractCompat$FontInfo)object).getUri();
            object = contentResolver.openInputStream((Uri)object);
            try {
                context = this.createFromInputStream(context, (InputStream)object);
            }
            catch (Throwable throwable) {
                object2 = object;
                break block7;
            }
            TypefaceCompatUtil.closeQuietly((Closeable)object);
            return context;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        TypefaceCompatUtil.closeQuietly(object2);
        throw var1_4;
        catch (IOException iOException) {
            block8: {
                n11 = 0;
                object = null;
                break block8;
                catch (IOException iOException2) {}
            }
            TypefaceCompatUtil.closeQuietly((Closeable)object);
            return null;
        }
    }

    public Typeface createFromInputStream(Context object, InputStream object2) {
        block7: {
            if ((object = TypefaceCompatUtil.getTempFile((Context)object)) == null) {
                return null;
            }
            boolean bl2 = TypefaceCompatUtil.copyToFile((File)object, (InputStream)object2);
            if (bl2) break block7;
            ((File)object).delete();
            return null;
        }
        try {
            object2 = ((File)object).getPath();
            object2 = Typeface.createFromFile((String)object2);
            return object2;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        finally {
            ((File)object).delete();
        }
    }

    public Typeface createFromResourcesFontFile(Context object, Resources object2, int n10, String string2, int n11) {
        block7: {
            if ((object = TypefaceCompatUtil.getTempFile((Context)object)) == null) {
                return null;
            }
            boolean bl2 = TypefaceCompatUtil.copyToFile((File)object, object2, n10);
            if (bl2) break block7;
            ((File)object).delete();
            return null;
        }
        try {
            object2 = ((File)object).getPath();
            object2 = Typeface.createFromFile((String)object2);
            return object2;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        finally {
            ((File)object).delete();
        }
    }

    public FontsContractCompat$FontInfo findBestInfo(FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArray, int n10) {
        TypefaceCompatBaseImpl$1 typefaceCompatBaseImpl$1 = new TypefaceCompatBaseImpl$1(this);
        return (FontsContractCompat$FontInfo)TypefaceCompatBaseImpl.findBestFont(fontsContractCompat$FontInfoArray, n10, typefaceCompatBaseImpl$1);
    }

    public FontResourcesParserCompat$FontFamilyFilesResourceEntry getFontFamily(Typeface object) {
        long l10;
        long l11 = TypefaceCompatBaseImpl.getUniqueKey((Typeface)object);
        long l12 = l11 - (l10 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            return null;
        }
        object = this.mFontFamilies;
        Long l13 = l11;
        return (FontResourcesParserCompat$FontFamilyFilesResourceEntry)((ConcurrentHashMap)object).get(l13);
    }
}

