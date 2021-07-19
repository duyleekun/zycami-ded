/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 */
package com.davemorrissey.labs.subscaleview.decoder;

import android.graphics.Bitmap;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import java.lang.reflect.Constructor;

public class CompatDecoderFactory
implements DecoderFactory {
    private Bitmap.Config bitmapConfig;
    private Class clazz;

    public CompatDecoderFactory(Class clazz) {
        this(clazz, null);
    }

    public CompatDecoderFactory(Class clazz, Bitmap.Config config) {
        this.clazz = clazz;
        this.bitmapConfig = config;
    }

    public Object make() {
        Object object = this.bitmapConfig;
        if (object == null) {
            return this.clazz.newInstance();
        }
        object = this.clazz;
        int n10 = 1;
        Bitmap.Config config = new Class[n10];
        config[0] = Bitmap.Config.class;
        object = ((Class)object).getConstructor((Class<?>)config);
        Object[] objectArray = new Object[n10];
        config = this.bitmapConfig;
        objectArray[0] = config;
        return ((Constructor)object).newInstance(objectArray);
    }
}

