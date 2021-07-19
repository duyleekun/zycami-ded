/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import java.util.HashMap;
import java.util.Map;

public class TextDelegate {
    private final LottieAnimationView animationView;
    private boolean cacheText;
    private final LottieDrawable drawable;
    private final Map stringMap;

    public TextDelegate() {
        HashMap hashMap;
        this.stringMap = hashMap = new HashMap();
        this.cacheText = true;
        this.animationView = null;
        this.drawable = null;
    }

    public TextDelegate(LottieAnimationView lottieAnimationView) {
        HashMap hashMap;
        this.stringMap = hashMap = new HashMap();
        this.cacheText = true;
        this.animationView = lottieAnimationView;
        this.drawable = null;
    }

    public TextDelegate(LottieDrawable lottieDrawable) {
        HashMap hashMap;
        this.stringMap = hashMap = new HashMap();
        this.cacheText = true;
        this.drawable = lottieDrawable;
        this.animationView = null;
    }

    private String getText(String string2) {
        return string2;
    }

    private void invalidate() {
        Object object = this.animationView;
        if (object != null) {
            object.invalidate();
        }
        if ((object = this.drawable) != null) {
            ((LottieDrawable)((Object)object)).invalidateSelf();
        }
    }

    public final String getTextInternal(String string2) {
        Object object;
        boolean bl2 = this.cacheText;
        if (bl2 && (bl2 = (object = this.stringMap).containsKey(string2))) {
            return (String)this.stringMap.get(string2);
        }
        object = this.getText(string2);
        boolean bl3 = this.cacheText;
        if (bl3) {
            Map map = this.stringMap;
            map.put(string2, object);
        }
        return object;
    }

    public void invalidateAllText() {
        this.stringMap.clear();
        this.invalidate();
    }

    public void invalidateText(String string2) {
        this.stringMap.remove(string2);
        this.invalidate();
    }

    public void setCacheText(boolean bl2) {
        this.cacheText = bl2;
    }

    public void setText(String string2, String string3) {
        this.stringMap.put(string2, string3);
        this.invalidate();
    }
}

