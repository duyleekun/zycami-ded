/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.widget.ImageView
 */
package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager$OnImageLoadedListener;
import com.google.android.gms.common.images.ImageManager$zaa;
import com.google.android.gms.common.images.ImageManager$zac;
import com.google.android.gms.common.images.zaa;
import com.google.android.gms.common.images.zab;
import com.google.android.gms.common.images.zac;
import com.google.android.gms.common.images.zad;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zamh;
    private static HashSet zami;
    private static ImageManager zamj;
    private final Context mContext;
    private final Handler mHandler;
    private final ExecutorService zamk;
    private final ImageManager$zaa zaml;
    private final zak zamm;
    private final Map zamn;
    private final Map zamo;
    private final Map zamp;

    static {
        HashSet hashSet = new HashSet();
        zamh = hashSet;
        zami = hashSet = new HashSet();
    }

    private ImageManager(Context object, boolean bl2) {
        this.mContext = object = object.getApplicationContext();
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.mHandler = object;
        object = Executors.newFixedThreadPool(4);
        this.zamk = object;
        this.zaml = null;
        super();
        this.zamm = object;
        super();
        this.zamn = object;
        super();
        this.zamo = object;
        super();
        this.zamp = object;
    }

    public static ImageManager create(Context context) {
        ImageManager imageManager = zamj;
        if (imageManager == null) {
            zamj = imageManager = new ImageManager(context, false);
        }
        return zamj;
    }

    public static /* synthetic */ Bitmap zaa(ImageManager imageManager, zab zab2) {
        return imageManager.zaa(zab2);
    }

    private final Bitmap zaa(zab zab2) {
        ImageManager$zaa imageManager$zaa = this.zaml;
        if (imageManager$zaa == null) {
            return null;
        }
        return (Bitmap)imageManager$zaa.get(zab2);
    }

    public static /* synthetic */ Map zaa(ImageManager imageManager) {
        return imageManager.zamn;
    }

    private final void zaa(zaa zaa2) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        ImageManager$zac imageManager$zac = new ImageManager$zac(this, zaa2);
        imageManager$zac.run();
    }

    public static /* synthetic */ Context zab(ImageManager imageManager) {
        return imageManager.mContext;
    }

    public static /* synthetic */ zak zac(ImageManager imageManager) {
        return imageManager.zamm;
    }

    public static /* synthetic */ Object zacc() {
        return zamh;
    }

    public static /* synthetic */ HashSet zacd() {
        return zami;
    }

    public static /* synthetic */ Map zad(ImageManager imageManager) {
        return imageManager.zamp;
    }

    public static /* synthetic */ Map zae(ImageManager imageManager) {
        return imageManager.zamo;
    }

    public static /* synthetic */ ExecutorService zaf(ImageManager imageManager) {
        return imageManager.zamk;
    }

    public static /* synthetic */ Handler zag(ImageManager imageManager) {
        return imageManager.mHandler;
    }

    public static /* synthetic */ ImageManager$zaa zah(ImageManager imageManager) {
        return imageManager.zaml;
    }

    public final void loadImage(ImageView imageView, int n10) {
        zac zac2 = new zac(imageView, n10);
        this.zaa(zac2);
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        zac zac2 = new zac(imageView, uri);
        this.zaa(zac2);
    }

    public final void loadImage(ImageView imageView, Uri uri, int n10) {
        zac zac2 = new zac(imageView, uri);
        zac2.zamx = n10;
        this.zaa(zac2);
    }

    public final void loadImage(ImageManager$OnImageLoadedListener imageManager$OnImageLoadedListener, Uri uri) {
        zad zad2 = new zad(imageManager$OnImageLoadedListener, uri);
        this.zaa(zad2);
    }

    public final void loadImage(ImageManager$OnImageLoadedListener imageManager$OnImageLoadedListener, Uri uri, int n10) {
        zad zad2 = new zad(imageManager$OnImageLoadedListener, uri);
        zad2.zamx = n10;
        this.zaa(zad2);
    }
}

