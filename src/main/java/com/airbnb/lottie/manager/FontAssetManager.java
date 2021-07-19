/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable$Callback
 *  android.view.View
 */
package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class FontAssetManager {
    private final AssetManager assetManager;
    private String defaultFontFileExtension;
    private FontAssetDelegate delegate;
    private final Map fontFamilies;
    private final Map fontMap;
    private final MutablePair tempPair;

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        Object object = new MutablePair();
        this.tempPair = object;
        object = new HashMap();
        this.fontMap = object;
        object = new HashMap();
        this.fontFamilies = object;
        this.defaultFontFileExtension = object = ".ttf";
        this.delegate = fontAssetDelegate;
        boolean bl2 = callback instanceof View;
        if (!bl2) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        callback = ((View)callback).getContext().getAssets();
        this.assetManager = callback;
    }

    private Typeface getFontFamily(String string2) {
        Object object = (Typeface)this.fontFamilies.get(string2);
        if (object != null) {
            return object;
        }
        object = null;
        Object object2 = this.delegate;
        if (object2 != null) {
            object = ((FontAssetDelegate)object2).fetchFont(string2);
        }
        if ((object2 = this.delegate) != null && object == null && (object2 = ((FontAssetDelegate)object2).getFontPath(string2)) != null) {
            object = Typeface.createFromAsset((AssetManager)this.assetManager, (String)object2);
        }
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("fonts/");
            ((StringBuilder)object).append(string2);
            object2 = this.defaultFontFileExtension;
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            object2 = this.assetManager;
            object = Typeface.createFromAsset((AssetManager)object2, (String)object);
        }
        this.fontFamilies.put(string2, object);
        return object;
    }

    private Typeface typefaceForStyle(Typeface typeface, String string2) {
        String string3 = "Italic";
        int n10 = string2.contains(string3);
        String string4 = "Bold";
        int n11 = string2.contains(string4);
        if (n10 != 0 && n11 != 0) {
            n11 = 3;
        } else if (n10 != 0) {
            n11 = 2;
        } else if (n11 != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            string2 = null;
        }
        n10 = typeface.getStyle();
        if (n10 == n11) {
            return typeface;
        }
        return Typeface.create((Typeface)typeface, (int)n11);
    }

    public Typeface getTypeface(String string2, String object) {
        this.tempPair.set(string2, object);
        Object object2 = this.fontMap;
        MutablePair mutablePair = this.tempPair;
        object2 = (Typeface)object2.get(mutablePair);
        if (object2 != null) {
            return object2;
        }
        string2 = this.getFontFamily(string2);
        string2 = this.typefaceForStyle((Typeface)string2, (String)object);
        object = this.fontMap;
        object2 = this.tempPair;
        object.put(object2, string2);
        return string2;
    }

    public void setDefaultFontFileExtension(String string2) {
        this.defaultFontFileExtension = string2;
    }

    public void setDelegate(FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
    }
}

