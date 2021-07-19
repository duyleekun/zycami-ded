/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.core.content.res;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.res.ResourcesCompat$FontCallback$1;
import androidx.core.content.res.ResourcesCompat$FontCallback$2;

public abstract class ResourcesCompat$FontCallback {
    public static Handler getHandler(Handler handler) {
        if (handler == null) {
            Looper looper = Looper.getMainLooper();
            handler = new Handler(looper);
        }
        return handler;
    }

    public final void callbackFailAsync(int n10, Handler handler) {
        handler = ResourcesCompat$FontCallback.getHandler(handler);
        ResourcesCompat$FontCallback$2 resourcesCompat$FontCallback$2 = new ResourcesCompat$FontCallback$2(this, n10);
        handler.post((Runnable)resourcesCompat$FontCallback$2);
    }

    public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
        handler = ResourcesCompat$FontCallback.getHandler(handler);
        ResourcesCompat$FontCallback$1 resourcesCompat$FontCallback$1 = new ResourcesCompat$FontCallback$1(this, typeface);
        handler.post((Runnable)resourcesCompat$FontCallback$1);
    }

    public abstract void onFontRetrievalFailed(int var1);

    public abstract void onFontRetrieved(Typeface var1);
}

