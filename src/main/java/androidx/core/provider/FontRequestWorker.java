/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Typeface
 */
package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontProvider;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontRequestWorker$1;
import androidx.core.provider.FontRequestWorker$2;
import androidx.core.provider.FontRequestWorker$3;
import androidx.core.provider.FontRequestWorker$4;
import androidx.core.provider.FontRequestWorker$TypefaceResult;
import androidx.core.provider.FontsContractCompat$FontFamilyResult;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.provider.RequestExecutor;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class FontRequestWorker {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE;
    public static final Object LOCK;
    public static final SimpleArrayMap PENDING_REPLIES;
    public static final LruCache sTypefaceCache;

    static {
        Object object = new LruCache(16);
        sTypefaceCache = object;
        DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
        LOCK = object = new Object();
        PENDING_REPLIES = object = new SimpleArrayMap();
    }

    private FontRequestWorker() {
    }

    private static String createCacheId(FontRequest object, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        object = ((FontRequest)object).getId();
        stringBuilder.append((String)object);
        stringBuilder.append("-");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    private static int getFontFamilyResultStatus(FontsContractCompat$FontFamilyResult fontsContractCompat$FontInfoArray) {
        int n10 = fontsContractCompat$FontInfoArray.getStatusCode();
        int n11 = -3;
        int n12 = 1;
        if (n10 != 0) {
            int n13 = fontsContractCompat$FontInfoArray.getStatusCode();
            if (n13 != n12) {
                return n11;
            }
            return -2;
        }
        if ((fontsContractCompat$FontInfoArray = fontsContractCompat$FontInfoArray.getFonts()) != null && (n10 = fontsContractCompat$FontInfoArray.length) != 0) {
            n10 = fontsContractCompat$FontInfoArray.length;
            n12 = 0;
            for (int i10 = 0; i10 < n10; ++i10) {
                FontsContractCompat$FontInfo fontsContractCompat$FontInfo = fontsContractCompat$FontInfoArray[i10];
                int n14 = fontsContractCompat$FontInfo.getResultCode();
                if (n14 == 0) continue;
                if (n14 >= 0) {
                    n11 = n14;
                }
                return n11;
            }
        }
        return n12;
    }

    public static FontRequestWorker$TypefaceResult getFontSync(String object, Context context, FontRequest fontsContractCompat$FontInfoArray, int n10) {
        LruCache lruCache = sTypefaceCache;
        Typeface typeface = (Typeface)lruCache.get(object);
        if (typeface != null) {
            object = new FontRequestWorker$TypefaceResult(typeface);
            return object;
        }
        typeface = null;
        try {
            fontsContractCompat$FontInfoArray = FontProvider.getFontFamilyResult(context, (FontRequest)fontsContractCompat$FontInfoArray, null);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = new FontRequestWorker$TypefaceResult(-1);
            return object;
        }
        int n11 = FontRequestWorker.getFontFamilyResultStatus((FontsContractCompat$FontFamilyResult)fontsContractCompat$FontInfoArray);
        if (n11 != 0) {
            object = new FontRequestWorker$TypefaceResult(n11);
            return object;
        }
        if ((context = TypefaceCompat.createFromFontInfo(context, null, fontsContractCompat$FontInfoArray = fontsContractCompat$FontInfoArray.getFonts(), n10)) != null) {
            lruCache.put(object, context);
            object = new FontRequestWorker$TypefaceResult((Typeface)context);
            return object;
        }
        object = new FontRequestWorker$TypefaceResult(-3);
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Typeface requestFontAsync(Context object, FontRequest fontRequest, int n10, Executor executor, CallbackWithHandler object2) {
        String string2 = FontRequestWorker.createCacheId(fontRequest, n10);
        Object object3 = (Typeface)sTypefaceCache.get(string2);
        if (object3 != null) {
            object = new FontRequestWorker$TypefaceResult((Typeface)object3);
            ((CallbackWithHandler)object2).onTypefaceResult((FontRequestWorker$TypefaceResult)object);
            return object3;
        }
        object3 = new FontRequestWorker$2((CallbackWithHandler)object2);
        object2 = LOCK;
        synchronized (object2) {
            SimpleArrayMap simpleArrayMap = PENDING_REPLIES;
            ArrayList<Typeface> arrayList = simpleArrayMap.get(string2);
            arrayList = arrayList;
            if (arrayList != null) {
                arrayList.add((Typeface)object3);
                return null;
            }
            arrayList = new ArrayList<Typeface>();
            arrayList.add((Typeface)object3);
            simpleArrayMap.put(string2, arrayList);
        }
        object2 = new FontRequestWorker$3(string2, (Context)object, fontRequest, n10);
        if (executor == null) {
            executor = DEFAULT_EXECUTOR_SERVICE;
        }
        object = new FontRequestWorker$4(string2);
        RequestExecutor.execute(executor, (Callable)object2, (Consumer)object);
        return null;
    }

    public static Typeface requestFontSync(Context object, FontRequest fontRequest, CallbackWithHandler callbackWithHandler, int n10, int n11) {
        String string2 = FontRequestWorker.createCacheId(fontRequest, n10);
        Object object2 = (Typeface)sTypefaceCache.get(string2);
        if (object2 != null) {
            object = new FontRequestWorker$TypefaceResult((Typeface)object2);
            callbackWithHandler.onTypefaceResult((FontRequestWorker$TypefaceResult)object);
            return object2;
        }
        int n12 = -1;
        if (n11 == n12) {
            object = FontRequestWorker.getFontSync(string2, object, fontRequest, n10);
            callbackWithHandler.onTypefaceResult((FontRequestWorker$TypefaceResult)object);
            return object.mTypeface;
        }
        object2 = new FontRequestWorker$1(string2, (Context)object, fontRequest, n10);
        try {
            object = DEFAULT_EXECUTOR_SERVICE;
        }
        catch (InterruptedException interruptedException) {
            object = new FontRequestWorker$TypefaceResult(-3);
            callbackWithHandler.onTypefaceResult((FontRequestWorker$TypefaceResult)object);
            return null;
        }
        object = RequestExecutor.submit((ExecutorService)object, (Callable)object2, n11);
        object = (FontRequestWorker$TypefaceResult)object;
        callbackWithHandler.onTypefaceResult((FontRequestWorker$TypefaceResult)object);
        return object.mTypeface;
    }

    public static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }
}

