/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  org.json.JSONObject
 */
package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.InputStream;
import org.json.JSONObject;

public class LottieComposition$Factory {
    private LottieComposition$Factory() {
    }

    public static Cancellable fromAssetFileName(Context context, String string2, OnCompositionLoadedListener onCompositionLoadedListener) {
        LottieComposition$Factory$ListenerAdapter lottieComposition$Factory$ListenerAdapter = new LottieComposition$Factory$ListenerAdapter(onCompositionLoadedListener, null);
        LottieCompositionFactory.fromAsset(context, string2).addListener(lottieComposition$Factory$ListenerAdapter);
        return lottieComposition$Factory$ListenerAdapter;
    }

    public static LottieComposition fromFileSync(Context context, String string2) {
        return (LottieComposition)LottieCompositionFactory.fromAssetSync(context, string2).getValue();
    }

    public static Cancellable fromInputStream(InputStream inputStream, OnCompositionLoadedListener onCompositionLoadedListener) {
        LottieComposition$Factory$ListenerAdapter lottieComposition$Factory$ListenerAdapter = new LottieComposition$Factory$ListenerAdapter(onCompositionLoadedListener, null);
        LottieCompositionFactory.fromJsonInputStream(inputStream, null).addListener(lottieComposition$Factory$ListenerAdapter);
        return lottieComposition$Factory$ListenerAdapter;
    }

    public static LottieComposition fromInputStreamSync(InputStream inputStream) {
        return (LottieComposition)LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
    }

    public static LottieComposition fromInputStreamSync(InputStream inputStream, boolean bl2) {
        if (bl2) {
            String string2 = "Lottie now auto-closes input stream!";
            Logger.warning(string2);
        }
        return (LottieComposition)LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
    }

    public static Cancellable fromJsonReader(JsonReader jsonReader, OnCompositionLoadedListener onCompositionLoadedListener) {
        LottieComposition$Factory$ListenerAdapter lottieComposition$Factory$ListenerAdapter = new LottieComposition$Factory$ListenerAdapter(onCompositionLoadedListener, null);
        LottieCompositionFactory.fromJsonReader(jsonReader, null).addListener(lottieComposition$Factory$ListenerAdapter);
        return lottieComposition$Factory$ListenerAdapter;
    }

    public static Cancellable fromJsonString(String string2, OnCompositionLoadedListener onCompositionLoadedListener) {
        LottieComposition$Factory$ListenerAdapter lottieComposition$Factory$ListenerAdapter = new LottieComposition$Factory$ListenerAdapter(onCompositionLoadedListener, null);
        LottieCompositionFactory.fromJsonString(string2, null).addListener(lottieComposition$Factory$ListenerAdapter);
        return lottieComposition$Factory$ListenerAdapter;
    }

    public static LottieComposition fromJsonSync(Resources resources, JSONObject jSONObject) {
        return (LottieComposition)LottieCompositionFactory.fromJsonSync(jSONObject, null).getValue();
    }

    public static LottieComposition fromJsonSync(JsonReader jsonReader) {
        return (LottieComposition)LottieCompositionFactory.fromJsonReaderSync(jsonReader, null).getValue();
    }

    public static LottieComposition fromJsonSync(String string2) {
        return (LottieComposition)LottieCompositionFactory.fromJsonStringSync(string2, null).getValue();
    }

    public static Cancellable fromRawFile(Context context, int n10, OnCompositionLoadedListener onCompositionLoadedListener) {
        LottieComposition$Factory$ListenerAdapter lottieComposition$Factory$ListenerAdapter = new LottieComposition$Factory$ListenerAdapter(onCompositionLoadedListener, null);
        LottieCompositionFactory.fromRawRes(context, n10).addListener(lottieComposition$Factory$ListenerAdapter);
        return lottieComposition$Factory$ListenerAdapter;
    }
}

