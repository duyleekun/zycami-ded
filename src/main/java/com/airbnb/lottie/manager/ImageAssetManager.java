/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.drawable.Drawable$Callback
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.view.View
 */
package com.airbnb.lottie.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ImageAssetManager {
    private static final Object bitmapHashLock;
    private final Context context;
    private ImageAssetDelegate delegate;
    private final Map imageAssets;
    private String imagesFolder;

    static {
        Object object;
        bitmapHashLock = object = new Object();
    }

    public ImageAssetManager(Drawable.Callback object, String charSequence, ImageAssetDelegate imageAssetDelegate, Map map) {
        char c10;
        int c11;
        this.imagesFolder = charSequence;
        char c102 = TextUtils.isEmpty((CharSequence)charSequence);
        if (c102 == '\u0000' && (c102 = ((String)(charSequence = this.imagesFolder)).charAt(c11 = ((String)charSequence).length() + -1)) != (c10 = '/')) {
            String string2 = this.imagesFolder;
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(c10);
            charSequence = ((StringBuilder)charSequence).toString();
            this.imagesFolder = charSequence;
        }
        if ((c102 = object instanceof View) == '\u0000') {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.imageAssets = object = new HashMap();
            this.context = null;
            return;
        }
        object = ((View)object).getContext();
        this.context = object;
        this.imageAssets = map;
        this.setDelegate(imageAssetDelegate);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Bitmap putBitmap(String object, Bitmap bitmap) {
        Object object2 = bitmapHashLock;
        synchronized (object2) {
            Map map = this.imageAssets;
            object = map.get(object);
            object = (LottieImageAsset)object;
            ((LottieImageAsset)object).setBitmap(bitmap);
            return bitmap;
        }
    }

    public Bitmap bitmapForId(String object) {
        Object object2;
        block21: {
            String string2;
            int n10;
            object2 = (LottieImageAsset)this.imageAssets.get(object);
            int n102 = 0;
            Bitmap bitmap = null;
            if (object2 == null) {
                return null;
            }
            Object object3 = ((LottieImageAsset)object2).getBitmap();
            if (object3 != null) {
                return object3;
            }
            object3 = this.delegate;
            if (object3 != null) {
                if ((object2 = object3.fetchBitmap((LottieImageAsset)object2)) != null) {
                    this.putBitmap((String)object, (Bitmap)object2);
                }
                return object2;
            }
            object3 = ((LottieImageAsset)object2).getFileName();
            BitmapFactory.Options options = new BitmapFactory.Options();
            int n11 = 1;
            options.inScaled = n11;
            options.inDensity = 160;
            CharSequence charSequence = "data:";
            boolean n12 = ((String)object3).startsWith((String)charSequence);
            if (n12 && (n10 = ((String)object3).indexOf((String)(charSequence = "base64,"))) > 0) {
                int n15 = 44;
                try {
                    n15 = ((String)object3).indexOf(n15) + n11;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    Logger.warning("data URL did not have correct base64 format.", illegalArgumentException);
                    return null;
                }
                object2 = ((String)object3).substring(n15);
                boolean n14 = false;
                object3 = null;
                object2 = Base64.decode((String)object2, (int)0);
                n102 = ((Object)object2).length;
                object2 = BitmapFactory.decodeByteArray((byte[])object2, (int)0, (int)n102, (BitmapFactory.Options)options);
                return this.putBitmap((String)object, (Bitmap)object2);
            }
            try {
                string2 = this.imagesFolder;
            }
            catch (IOException iOException) {
                Logger.warning("Unable to open asset.", iOException);
                return null;
            }
            n11 = TextUtils.isEmpty((CharSequence)string2);
            if (n11 != 0) break block21;
            string2 = this.context;
            string2 = string2.getAssets();
            charSequence = new StringBuilder();
            String string3 = this.imagesFolder;
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append((String)object3);
            object3 = ((StringBuilder)charSequence).toString();
            bitmap = BitmapFactory.decodeStream((InputStream)string2.open((String)object3), null, (BitmapFactory.Options)options);
            int n13 = ((LottieImageAsset)object2).getWidth();
            int n14 = ((LottieImageAsset)object2).getHeight();
            object2 = Utils.resizeBitmapIfNeeded(bitmap, n13, n14);
            return this.putBitmap((String)object, (Bitmap)object2);
        }
        object2 = "You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder";
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public boolean hasSameContext(Context context) {
        boolean bl2;
        Context context2;
        if (context == null && (context2 = this.context) == null || (bl2 = (context2 = this.context).equals(context))) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        return bl2;
    }

    public void setDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.delegate = imageAssetDelegate;
    }

    public Bitmap updateBitmap(String object, Bitmap bitmap) {
        if (bitmap == null) {
            object = (LottieImageAsset)this.imageAssets.get(object);
            bitmap = ((LottieImageAsset)object).getBitmap();
            ((LottieImageAsset)object).setBitmap(null);
            return bitmap;
        }
        Bitmap bitmap2 = ((LottieImageAsset)this.imageAssets.get(object)).getBitmap();
        this.putBitmap((String)object, bitmap);
        return bitmap2;
    }
}

