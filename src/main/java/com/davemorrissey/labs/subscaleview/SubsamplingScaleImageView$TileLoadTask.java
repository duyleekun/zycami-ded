/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 *  android.os.AsyncTask
 *  android.util.Log
 */
package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class SubsamplingScaleImageView$TileLoadTask
extends AsyncTask {
    private final WeakReference decoderRef;
    private Exception exception;
    private final WeakReference tileRef;
    private final WeakReference viewRef;

    public SubsamplingScaleImageView$TileLoadTask(SubsamplingScaleImageView object, ImageRegionDecoder imageRegionDecoder, SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile) {
        WeakReference<SubsamplingScaleImageView> weakReference;
        this.viewRef = weakReference = new WeakReference<SubsamplingScaleImageView>((SubsamplingScaleImageView)((Object)object));
        super(imageRegionDecoder);
        this.decoderRef = object;
        super(subsamplingScaleImageView$Tile);
        this.tileRef = object;
        SubsamplingScaleImageView$Tile.access$4002(subsamplingScaleImageView$Tile, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bitmap doInBackground(Void ... rect) {
        Object object;
        block7: {
            Rect rect2;
            int n10;
            String string2;
            Object object2;
            try {
                boolean bl2;
                rect = this.viewRef;
                rect = rect.get();
                rect = (SubsamplingScaleImageView)rect;
                object2 = this.decoderRef;
                object2 = ((Reference)object2).get();
                object2 = (ImageRegionDecoder)object2;
                object = this.tileRef;
                object = ((Reference)object).get();
                object = (SubsamplingScaleImageView$Tile)object;
                int n11 = 0;
                Object object3 = null;
                if (object2 == null || object == null || rect == null || !(bl2 = object2.isReady()) || !(bl2 = SubsamplingScaleImageView$Tile.access$400((SubsamplingScaleImageView$Tile)object))) break block7;
                string2 = "TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d";
                n10 = 2;
                rect2 = new Object[n10];
                Object object4 = SubsamplingScaleImageView$Tile.access$4100((SubsamplingScaleImageView$Tile)object);
                rect2[0] = object4;
                n11 = 1;
                int n12 = SubsamplingScaleImageView$Tile.access$4300((SubsamplingScaleImageView$Tile)object);
                object4 = n12;
                rect2[n11] = object4;
                SubsamplingScaleImageView.access$5100((SubsamplingScaleImageView)rect, string2, (Object[])rect2);
                object3 = SubsamplingScaleImageView.access$5700((SubsamplingScaleImageView)rect);
                synchronized (object3) {
                }
            }
            catch (OutOfMemoryError outOfMemoryError) {
                Object object5 = SubsamplingScaleImageView.access$5400();
                String string3 = "Failed to decode tile - OutOfMemoryError";
                Log.e((String)object5, (String)string3, (Throwable)outOfMemoryError);
                this.exception = object5 = new RuntimeException(outOfMemoryError);
                return null;
            }
            catch (Exception exception) {
                String string4 = SubsamplingScaleImageView.access$5400();
                String string5 = "Failed to decode tile";
                Log.e((String)string4, (String)string5, (Throwable)exception);
                this.exception = exception;
                return null;
            }
            {
                string2 = SubsamplingScaleImageView$Tile.access$4100((SubsamplingScaleImageView$Tile)object);
                rect2 = SubsamplingScaleImageView$Tile.access$5000((SubsamplingScaleImageView$Tile)object);
                SubsamplingScaleImageView.access$5800((SubsamplingScaleImageView)rect, (Rect)string2, rect2);
                string2 = SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)rect);
                if (string2 != null) {
                    string2 = SubsamplingScaleImageView$Tile.access$5000((SubsamplingScaleImageView$Tile)object);
                    rect2 = SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)rect);
                    n10 = rect2.left;
                    rect = SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)rect);
                    int n13 = rect.top;
                    string2.offset(n10, n13);
                }
                rect = SubsamplingScaleImageView$Tile.access$5000((SubsamplingScaleImageView$Tile)object);
                int n14 = SubsamplingScaleImageView$Tile.access$4300((SubsamplingScaleImageView$Tile)object);
                return object2.decodeRegion(rect, n14);
            }
        }
        if (object == null) return null;
        SubsamplingScaleImageView$Tile.access$4002((SubsamplingScaleImageView$Tile)object, false);
        return null;
    }

    public void onPostExecute(Bitmap object) {
        Object object2 = (SubsamplingScaleImageView)((Object)this.viewRef.get());
        SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile = (SubsamplingScaleImageView$Tile)this.tileRef.get();
        if (object2 != null && subsamplingScaleImageView$Tile != null) {
            if (object != null) {
                SubsamplingScaleImageView$Tile.access$502(subsamplingScaleImageView$Tile, (Bitmap)object);
                object = null;
                SubsamplingScaleImageView$Tile.access$4002(subsamplingScaleImageView$Tile, false);
                SubsamplingScaleImageView.access$5900(object2);
            } else {
                object = this.exception;
                if (object != null && (object = SubsamplingScaleImageView.access$5600(object2)) != null) {
                    object = SubsamplingScaleImageView.access$5600(object2);
                    object2 = this.exception;
                    object.onTileLoadError((Exception)object2);
                }
            }
        }
    }
}

