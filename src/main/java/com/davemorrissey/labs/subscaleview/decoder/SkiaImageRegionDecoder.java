/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.BitmapRegionDecoder
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import java.io.InputStream;

public class SkiaImageRegionDecoder
implements ImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private final Bitmap.Config bitmapConfig;
    private BitmapRegionDecoder decoder;
    private final Object decoderLock;

    public SkiaImageRegionDecoder() {
        this(null);
    }

    public SkiaImageRegionDecoder(Bitmap.Config config) {
        Object object;
        this.decoderLock = object = new Object();
        this.bitmapConfig = config == null ? (config = Bitmap.Config.RGB_565) : config;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bitmap decodeRegion(Rect object, int n10) {
        Object object2 = this.decoderLock;
        synchronized (object2) {
            Object object3;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = n10;
            options.inPreferredConfig = object3 = this.bitmapConfig;
            object3 = this.decoder;
            object = object3.decodeRegion(object, options);
            if (object != null) {
                return object;
            }
            object3 = "Skia image decoder returned null bitmap - image format may not be supported";
            object = new RuntimeException((String)object3);
            throw object;
        }
    }

    public Point init(Context context, Uri object) {
        int n10;
        int n11;
        Object object2 = object.toString();
        String string2 = RESOURCE_PREFIX;
        boolean bl2 = ((String)object2).startsWith(string2);
        int n12 = 1;
        if (bl2) {
            block24: {
                String string3;
                String string4;
                object2 = object.getAuthority();
                string2 = context.getPackageName();
                bl2 = string2.equals(object2);
                string2 = bl2 ? context.getResources() : context.getPackageManager().getResourcesForApplication((String)object2);
                object = object.getPathSegments();
                int n13 = object.size();
                int n14 = 2;
                if (n13 == n14 && (n14 = (int)((string4 = (String)object.get(0)).equals(string3 = "drawable") ? 1 : 0)) != 0) {
                    object = (String)object.get(n12);
                    n11 = string2.getIdentifier((String)object, string3, (String)object2);
                } else {
                    if (n13 == n12 && (n10 = (int)(TextUtils.isDigitsOnly((CharSequence)(object2 = (CharSequence)object.get(0))) ? 1 : 0)) != 0) {
                        try {
                            object = object.get(0);
                        }
                        catch (NumberFormatException numberFormatException) {}
                        object = (String)object;
                        n11 = Integer.parseInt((String)object);
                        break block24;
                    }
                    n11 = 0;
                    object = null;
                }
            }
            context = BitmapRegionDecoder.newInstance((InputStream)context.getResources().openRawResource(n11), (boolean)false);
            this.decoder = context;
        } else {
            string2 = ASSET_PREFIX;
            bl2 = ((String)object2).startsWith(string2);
            if (bl2) {
                n11 = 22;
                object = ((String)object2).substring(n11);
                context = BitmapRegionDecoder.newInstance((InputStream)context.getAssets().open((String)object, n12), (boolean)false);
                this.decoder = context;
            } else {
                string2 = FILE_PREFIX;
                bl2 = ((String)object2).startsWith(string2);
                if (bl2) {
                    int n15 = 7;
                    context = BitmapRegionDecoder.newInstance((String)((String)object2).substring(n15), (boolean)false);
                    this.decoder = context;
                } else {
                    n10 = 0;
                    object2 = null;
                    context = context.getContentResolver();
                    object2 = context.openInputStream(object);
                    context = BitmapRegionDecoder.newInstance((InputStream)object2, (boolean)false);
                    this.decoder = context;
                }
            }
        }
        n11 = this.decoder.getWidth();
        n10 = this.decoder.getHeight();
        context = new Point(n11, n10);
        return context;
        finally {
            if (object2 != null) {
                ((InputStream)object2).close();
            }
        }
    }

    public boolean isReady() {
        boolean bl2;
        BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
        if (bitmapRegionDecoder != null && !(bl2 = bitmapRegionDecoder.isRecycled())) {
            bl2 = true;
        } else {
            bl2 = false;
            bitmapRegionDecoder = null;
        }
        return bl2;
    }

    public void recycle() {
        this.decoder.recycle();
    }
}

