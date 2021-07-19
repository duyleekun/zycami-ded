/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 */
package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class SubsamplingScaleImageView$BitmapLoadTask
extends AsyncTask {
    private Bitmap bitmap;
    private final WeakReference contextRef;
    private final WeakReference decoderFactoryRef;
    private Exception exception;
    private final boolean preview;
    private final Uri source;
    private final WeakReference viewRef;

    public SubsamplingScaleImageView$BitmapLoadTask(SubsamplingScaleImageView object, Context context, DecoderFactory decoderFactory, Uri uri, boolean bl2) {
        WeakReference<SubsamplingScaleImageView> weakReference;
        this.viewRef = weakReference = new WeakReference<SubsamplingScaleImageView>((SubsamplingScaleImageView)((Object)object));
        super(context);
        this.contextRef = object;
        super(decoderFactory);
        this.decoderFactoryRef = object;
        this.source = uri;
        this.preview = bl2;
    }

    public Integer doInBackground(Void ... object) {
        block21: {
            object = this.source;
            object = object.toString();
            Object object2 = this.contextRef;
            object2 = ((Reference)object2).get();
            object2 = (Context)object2;
            Object object3 = this.decoderFactoryRef;
            object3 = ((Reference)object3).get();
            object3 = (DecoderFactory)object3;
            Object object4 = this.viewRef;
            object4 = object4.get();
            object4 = (SubsamplingScaleImageView)((Object)object4);
            if (object2 == null || object3 == null || object4 == null) break block21;
            String string2 = "BitmapLoadTask.doInBackground";
            Object[] objectArray = null;
            objectArray = new Object[]{};
            SubsamplingScaleImageView.access$5100((SubsamplingScaleImageView)((Object)object4), string2, objectArray);
            object3 = object3.make();
            object3 = (ImageDecoder)object3;
            string2 = this.source;
            object3 = object3.decode((Context)object2, (Uri)string2);
            this.bitmap = object3;
            int n10 = SubsamplingScaleImageView.access$5200((SubsamplingScaleImageView)((Object)object4), (Context)object2, (String)object);
            try {
                return n10;
            }
            catch (OutOfMemoryError outOfMemoryError) {
                object2 = SubsamplingScaleImageView.access$5400();
                object3 = "Failed to load bitmap - OutOfMemoryError";
                Log.e((String)object2, (String)object3, (Throwable)outOfMemoryError);
                this.exception = object2 = new RuntimeException(outOfMemoryError);
            }
            catch (Exception exception) {
                object2 = SubsamplingScaleImageView.access$5400();
                object3 = "Failed to load bitmap";
                Log.e((String)object2, (String)object3, (Throwable)exception);
                this.exception = exception;
            }
        }
        return null;
    }

    public void onPostExecute(Integer object) {
        Object object2 = (SubsamplingScaleImageView)((Object)this.viewRef.get());
        if (object2 != null) {
            Bitmap bitmap = this.bitmap;
            if (bitmap != null && object != null) {
                boolean bl2 = this.preview;
                if (bl2) {
                    SubsamplingScaleImageView.access$6000(object2, bitmap);
                } else {
                    int n10 = (Integer)object;
                    bl2 = false;
                    SubsamplingScaleImageView.access$6100(object2, bitmap, n10, false);
                }
            } else {
                object = this.exception;
                if (object != null && (object = SubsamplingScaleImageView.access$5600(object2)) != null) {
                    boolean bl3 = this.preview;
                    if (bl3) {
                        object = SubsamplingScaleImageView.access$5600(object2);
                        object2 = this.exception;
                        object.onPreviewLoadError((Exception)object2);
                    } else {
                        object = SubsamplingScaleImageView.access$5600(object2);
                        object2 = this.exception;
                        object.onImageLoadError((Exception)object2);
                    }
                }
            }
        }
    }
}

