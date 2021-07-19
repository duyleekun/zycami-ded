/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.ProviderInfo
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.CancellationSignal
 *  android.os.Handler
 */
package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompat$ResourcesCallbackAdapter;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontProvider;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat$FontFamilyResult;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.provider.FontsContractCompat$FontRequestCallback;
import androidx.core.provider.RequestExecutor;
import java.util.Map;
import java.util.concurrent.Executor;

public class FontsContractCompat {
    public static final String PARCEL_FONT_RESULTS = "font_results";
    public static final int RESULT_CODE_PROVIDER_NOT_FOUND = 255;
    public static final int RESULT_CODE_WRONG_CERTIFICATES = 254;

    private FontsContractCompat() {
    }

    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArray) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontsContractCompat$FontInfoArray, 0);
    }

    public static FontsContractCompat$FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) {
        return FontProvider.getFontFamilyResult(context, fontRequest, cancellationSignal);
    }

    public static Typeface getFontSync(Context context, FontRequest fontRequest, ResourcesCompat$FontCallback resourcesCompat$FontCallback, Handler handler, boolean bl2, int n10, int n11) {
        TypefaceCompat$ResourcesCallbackAdapter typefaceCompat$ResourcesCallbackAdapter = new TypefaceCompat$ResourcesCallbackAdapter(resourcesCompat$FontCallback);
        Handler handler2 = ResourcesCompat$FontCallback.getHandler(handler);
        return FontsContractCompat.requestFont(context, fontRequest, n11, bl2, n10, handler2, typefaceCompat$ResourcesCallbackAdapter);
    }

    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) {
        return FontProvider.getProvider(packageManager, fontRequest, resources);
    }

    public static Map prepareFontData(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArray, CancellationSignal cancellationSignal) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fontsContractCompat$FontInfoArray, cancellationSignal);
    }

    public static Typeface requestFont(Context context, FontRequest fontRequest, int n10, boolean bl2, int n11, Handler handler, FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontsContractCompat$FontRequestCallback, handler);
        if (bl2) {
            return FontRequestWorker.requestFontSync(context, fontRequest, callbackWithHandler, n10, n11);
        }
        return FontRequestWorker.requestFontAsync(context, fontRequest, n10, null, callbackWithHandler);
    }

    public static void requestFont(Context context, FontRequest fontRequest, FontsContractCompat$FontRequestCallback object, Handler handler) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler((FontsContractCompat$FontRequestCallback)object);
        object = RequestExecutor.createHandlerExecutor(handler);
        FontRequestWorker.requestFontAsync(context.getApplicationContext(), fontRequest, 0, (Executor)object, callbackWithHandler);
    }

    public static void resetCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    public static void resetTypefaceCache() {
        FontRequestWorker.resetTypefaceCache();
    }
}

