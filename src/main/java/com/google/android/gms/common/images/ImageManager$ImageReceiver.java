/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.ParcelFileDescriptor
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 */
package com.google.android.gms.common.images;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageManager$zab;
import com.google.android.gms.common.images.zaa;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;

public final class ImageManager$ImageReceiver
extends ResultReceiver {
    private final Uri mUri;
    private final ArrayList zamq;
    private final /* synthetic */ ImageManager zamr;

    public ImageManager$ImageReceiver(ImageManager object, Uri uri) {
        this.zamr = object;
        Looper looper = Looper.getMainLooper();
        super(looper);
        super((Handler)object);
        this.mUri = uri;
        super();
        this.zamq = object;
    }

    public static /* synthetic */ ArrayList zaa(ImageManager$ImageReceiver imageManager$ImageReceiver) {
        return imageManager$ImageReceiver.zamq;
    }

    public final void onReceiveResult(int n10, Bundle object) {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor)object.getParcelable("com.google.android.gms.extra.fileDescriptor");
        object = ImageManager.zaf(this.zamr);
        ImageManager imageManager = this.zamr;
        Uri uri = this.mUri;
        ImageManager$zab imageManager$zab = new ImageManager$zab(imageManager, uri, parcelFileDescriptor);
        object.execute(imageManager$zab);
    }

    public final void zab(zaa zaa2) {
        Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
        this.zamq.add(zaa2);
    }

    public final void zac(zaa zaa2) {
        Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
        this.zamq.remove(zaa2);
    }

    public final void zace() {
        Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
        Uri uri = this.mUri;
        intent.putExtra("com.google.android.gms.extras.uri", (Parcelable)uri);
        intent.putExtra("com.google.android.gms.extras.resultReceiver", (Parcelable)this);
        intent.putExtra("com.google.android.gms.extras.priority", 3);
        ImageManager.zab(this.zamr).sendBroadcast(intent);
    }
}

