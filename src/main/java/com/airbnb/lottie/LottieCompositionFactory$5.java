/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public class LottieCompositionFactory$5
implements Callable {
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ JSONObject val$json;

    public LottieCompositionFactory$5(JSONObject jSONObject, String string2) {
        this.val$json = jSONObject;
        this.val$cacheKey = string2;
    }

    public LottieResult call() {
        JSONObject jSONObject = this.val$json;
        String string2 = this.val$cacheKey;
        return LottieCompositionFactory.fromJsonSync(jSONObject, string2);
    }
}

