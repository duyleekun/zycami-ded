/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 *  android.net.Uri
 */
package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

public final class ImageSource {
    public static final String ASSET_SCHEME = "file:///android_asset/";
    public static final String FILE_SCHEME = "file:///";
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    private ImageSource(int n10) {
        Integer n11;
        this.bitmap = null;
        this.uri = null;
        this.resource = n11 = Integer.valueOf(n10);
        this.tile = true;
    }

    private ImageSource(Bitmap bitmap, boolean bl2) {
        int n10;
        int n11;
        this.bitmap = bitmap;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = n11 = bitmap.getWidth();
        this.sHeight = n10 = bitmap.getHeight();
        this.cached = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ImageSource(Uri uri) {
        int n10;
        String string2;
        String string3 = uri.toString();
        Object object = FILE_SCHEME;
        boolean bl2 = string3.startsWith((String)object);
        if (bl2 && !(bl2 = ((File)(object = new File(string2 = string3.substring(n10 = 7)))).exists())) {
            object = "UTF-8";
            try {
                string3 = URLDecoder.decode(string3, (String)object);
                uri = Uri.parse((String)string3);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {}
        }
        this.bitmap = null;
        this.uri = uri;
        this.resource = null;
        this.tile = true;
    }

    public static ImageSource asset(String string2) {
        Objects.requireNonNull(string2, "Asset name must not be null");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ASSET_SCHEME);
        stringBuilder.append(string2);
        return ImageSource.uri(stringBuilder.toString());
    }

    public static ImageSource bitmap(Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        ImageSource imageSource = new ImageSource(bitmap, false);
        return imageSource;
    }

    public static ImageSource cachedBitmap(Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        ImageSource imageSource = new ImageSource(bitmap, true);
        return imageSource;
    }

    public static ImageSource resource(int n10) {
        ImageSource imageSource = new ImageSource(n10);
        return imageSource;
    }

    private void setInvariants() {
        Rect rect = this.sRegion;
        if (rect != null) {
            int n10;
            boolean bl2;
            this.tile = bl2 = true;
            this.sWidth = n10 = rect.width();
            rect = this.sRegion;
            this.sHeight = n10 = rect.height();
        }
    }

    public static ImageSource uri(Uri uri) {
        Objects.requireNonNull(uri, "Uri must not be null");
        ImageSource imageSource = new ImageSource(uri);
        return imageSource;
    }

    public static ImageSource uri(String string2) {
        Objects.requireNonNull(string2, "Uri must not be null");
        Object object = "://";
        boolean n10 = string2.contains((CharSequence)object);
        if (!n10) {
            object = "/";
            boolean bl2 = string2.startsWith((String)object);
            if (bl2) {
                int n11 = 1;
                string2 = string2.substring(n11);
            }
            object = new StringBuilder();
            String string3 = FILE_SCHEME;
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
        }
        string2 = Uri.parse((String)string2);
        object = new ImageSource((Uri)string2);
        return object;
    }

    public ImageSource dimensions(int n10, int n11) {
        Bitmap bitmap = this.bitmap;
        if (bitmap == null) {
            this.sWidth = n10;
            this.sHeight = n11;
        }
        this.setInvariants();
        return this;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Integer getResource() {
        return this.resource;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final Rect getSRegion() {
        return this.sRegion;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final boolean getTile() {
        return this.tile;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean isCached() {
        return this.cached;
    }

    public ImageSource region(Rect rect) {
        this.sRegion = rect;
        this.setInvariants();
        return this;
    }

    public ImageSource tiling(boolean bl2) {
        this.tile = bl2;
        return this;
    }

    public ImageSource tilingDisabled() {
        return this.tiling(false);
    }

    public ImageSource tilingEnabled() {
        return this.tiling(true);
    }
}

