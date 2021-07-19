/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 */
package com.google.mediapipe.framework;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;

public final class AndroidAssetUtil {
    private AndroidAssetUtil() {
    }

    public static byte[] getAssetBytes(AssetManager object, String object2) {
        try {
            object = object.open((String)object2);
        }
        catch (IOException iOException) {
            object2 = new RuntimeException(iOException);
            throw object2;
        }
        object2 = ByteStreams.toByteArray((InputStream)object);
        ((InputStream)object).close();
        return object2;
    }

    public static boolean initializeNativeAssetManager(Context context) {
        String string2 = context.getCacheDir().getAbsolutePath();
        return AndroidAssetUtil.nativeInitializeAssetManager(context, string2);
    }

    private static native boolean nativeInitializeAssetManager(Context var0, String var1);
}

