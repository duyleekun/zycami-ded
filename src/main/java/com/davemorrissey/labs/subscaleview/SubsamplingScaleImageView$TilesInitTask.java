/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 */
package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class SubsamplingScaleImageView$TilesInitTask
extends AsyncTask {
    private final WeakReference contextRef;
    private ImageRegionDecoder decoder;
    private final WeakReference decoderFactoryRef;
    private Exception exception;
    private final Uri source;
    private final WeakReference viewRef;

    public SubsamplingScaleImageView$TilesInitTask(SubsamplingScaleImageView object, Context context, DecoderFactory decoderFactory, Uri uri) {
        WeakReference<SubsamplingScaleImageView> weakReference;
        this.viewRef = weakReference = new WeakReference<SubsamplingScaleImageView>((SubsamplingScaleImageView)((Object)object));
        super(context);
        this.contextRef = object;
        super(decoderFactory);
        this.decoderFactoryRef = object;
        this.source = uri;
    }

    public int[] doInBackground(Void ... object) {
        block29: {
            int n10;
            int n11;
            int n12;
            Object object2;
            Object object3;
            block30: {
                object = this.source;
                object = object.toString();
                object3 = this.contextRef;
                object3 = ((Reference)object3).get();
                object3 = (Context)object3;
                object2 = this.decoderFactoryRef;
                object2 = ((Reference)object2).get();
                object2 = (DecoderFactory)object2;
                Object object4 = this.viewRef;
                object4 = object4.get();
                object4 = (SubsamplingScaleImageView)((Object)object4);
                if (object3 == null || object2 == null || object4 == null) break block29;
                String string2 = "TilesInitTask.doInBackground";
                Object[] objectArray = new Object[]{};
                SubsamplingScaleImageView.access$5100((SubsamplingScaleImageView)((Object)object4), string2, objectArray);
                object2 = object2.make();
                object2 = (ImageRegionDecoder)object2;
                this.decoder = object2;
                string2 = this.source;
                object2 = object2.init((Context)object3, (Uri)string2);
                n12 = ((Point)object2).x;
                n11 = ((Point)object2).y;
                n10 = SubsamplingScaleImageView.access$5200((SubsamplingScaleImageView)((Object)object4), (Context)object3, (String)object);
                object3 = SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)((Object)object4));
                if (object3 == null) break block30;
                object3 = SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)((Object)object4));
                n12 = object3.width();
                object3 = SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)((Object)object4));
                n11 = object3.height();
            }
            int n13 = 3;
            object3 = new int[n13];
            object3[0] = n12;
            int n14 = 1;
            object3[n14] = n11;
            n11 = 2;
            try {
                object3[n11] = n10;
                return object3;
            }
            catch (Exception exception) {
                object3 = SubsamplingScaleImageView.access$5400();
                object2 = "Failed to initialise bitmap decoder";
                Log.e((String)object3, (String)object2, (Throwable)exception);
                this.exception = exception;
            }
        }
        return null;
    }

    public void onPostExecute(int[] object) {
        Object object2 = (SubsamplingScaleImageView)((Object)this.viewRef.get());
        if (object2 != null) {
            int n10;
            int n11;
            ImageRegionDecoder imageRegionDecoder = this.decoder;
            if (imageRegionDecoder != null && object != null && (n11 = ((int[])object).length) == (n10 = 3)) {
                n11 = object[0];
                n10 = object[1];
                int n12 = 2;
                Object object3 = object[n12];
                SubsamplingScaleImageView.access$5500(object2, imageRegionDecoder, n11, n10, (int)object3);
            } else {
                object = this.exception;
                if (object != null && (object = (Object)SubsamplingScaleImageView.access$5600(object2)) != null) {
                    object = SubsamplingScaleImageView.access$5600(object2);
                    object2 = this.exception;
                    object.onImageLoadError((Exception)object2);
                }
            }
        }
    }
}

