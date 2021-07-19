/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.mob.tools.utils.BitmapHelper
 */
package com.mob.tools.gui;

import android.graphics.Bitmap;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions;
import com.mob.tools.gui.BitmapProcessor$ImageReq;
import com.mob.tools.gui.BitmapProcessor$PatchInputStream;
import com.mob.tools.gui.BitmapProcessor$WorkerThread;
import com.mob.tools.gui.CachePool;
import com.mob.tools.network.RawNetworkCallback;
import com.mob.tools.utils.BitmapHelper;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.SoftReference;

public class BitmapProcessor$WorkerThread$1
implements RawNetworkCallback {
    public final /* synthetic */ BitmapProcessor$WorkerThread this$0;
    public final /* synthetic */ String val$md5;
    public final /* synthetic */ BitmapProcessor$ImageReq val$req;

    public BitmapProcessor$WorkerThread$1(BitmapProcessor$WorkerThread bitmapProcessor$WorkerThread, String string2, BitmapProcessor$ImageReq bitmapProcessor$ImageReq) {
        this.this$0 = bitmapProcessor$WorkerThread;
        this.val$md5 = string2;
        this.val$req = bitmapProcessor$ImageReq;
    }

    public void onResponse(InputStream object) {
        boolean bl2;
        Object object2;
        Object object3;
        Object object4 = new BitmapProcessor$PatchInputStream((InputStream)object);
        object = BitmapProcessor.access$1600();
        int n10 = 1;
        if (object != null) {
            boolean bl3;
            object3 = BitmapProcessor.access$1600();
            String string2 = this.val$md5;
            object = new File((File)object3, string2);
            object3 = this.this$0;
            BitmapProcessor$WorkerThread.access$1900((BitmapProcessor$WorkerThread)object3, (InputStream)object4, (File)object);
            object4 = BitmapProcessor$ImageReq.access$100(this.val$req);
            if (object4 != null && !(bl3 = ((BitmapProcessor$BitmapDesiredOptions)(object4 = BitmapProcessor$ImageReq.access$100(this.val$req))).equals(object3 = ""))) {
                object3 = ((File)object).getAbsolutePath();
                int n11 = BitmapProcessor$ImageReq.access$100((BitmapProcessor$ImageReq)this.val$req).desiredWidth;
                int n12 = BitmapProcessor$ImageReq.access$100((BitmapProcessor$ImageReq)this.val$req).desiredHeight;
                int n13 = BitmapProcessor$ImageReq.access$100((BitmapProcessor$ImageReq)this.val$req).quality;
                long l10 = BitmapProcessor$ImageReq.access$100((BitmapProcessor$ImageReq)this.val$req).maxBytes;
                object4 = BitmapHelper.getBitmapByCompressQuality((String)object3, (int)n11, (int)n12, (int)n13, (long)l10);
            } else {
                object4 = BitmapHelper.getBitmap((File)object, (int)n10);
            }
            object2 = this.val$req;
            n10 = (int)(BitmapProcessor$ImageReq.access$500((BitmapProcessor$ImageReq)object2) ? 1 : 0);
            if (n10 == 0) {
                ((File)object).delete();
            }
        } else {
            object4 = BitmapHelper.getBitmap((InputStream)object4, (int)n10);
        }
        if (object4 != null && !(bl2 = object4.isRecycled())) {
            object = this.val$req;
            bl2 = BitmapProcessor$ImageReq.access$300((BitmapProcessor$ImageReq)object);
            if (bl2) {
                object = BitmapProcessor.access$1000();
                object2 = BitmapProcessor$ImageReq.access$000(this.val$req);
                object3 = BitmapProcessor$ImageReq.access$100(this.val$req);
                object2 = BitmapProcessor.access$1300((String)object2, (BitmapProcessor$BitmapDesiredOptions)object3);
                object3 = new SoftReference(object4);
                ((CachePool)object).put(object2, object3);
            }
            object = this.val$req;
            BitmapProcessor$ImageReq.access$1500((BitmapProcessor$ImageReq)object, (Bitmap)object4);
        } else {
            object = this.val$req;
            BitmapProcessor$ImageReq.access$1800((BitmapProcessor$ImageReq)object);
        }
        BitmapProcessor$WorkerThread.access$2002(this.this$0, null);
    }
}

