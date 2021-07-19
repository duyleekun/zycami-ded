/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.media.projection.MediaProjection
 *  android.media.projection.MediaProjectionManager
 *  android.os.Bundle
 */
package com.tencent.rtmp.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.screencapture.c;

public class TXScreenCapture$TXScreenCaptureAssistantActivity
extends Activity {
    private static final int REQUEST_CODE = 100;
    private static final String TAG = "TXScreenCaptureAssistantActivity";
    private MediaProjectionManager mMediaProjectionManager;

    public void onActivityResult(int n10, int n11, Intent intent) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onActivityResult ");
        charSequence.append((Object)this);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        charSequence = this.mMediaProjectionManager.getMediaProjection(n11, intent);
        c.a((Context)this).a((MediaProjection)charSequence);
        this.finish();
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = new StringBuilder();
        ((StringBuilder)object).append("onCreate ");
        ((StringBuilder)object).append((Object)this);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        int n10 = 1;
        this.requestWindowFeature(n10);
        object = this.getApplicationContext();
        CharSequence charSequence = "media_projection";
        object = (MediaProjectionManager)object.getSystemService((String)charSequence);
        this.mMediaProjectionManager = object;
        object = object.createScreenCaptureIntent();
        int n11 = 100;
        try {
            this.startActivityForResult((Intent)object, n11);
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            String string3 = "start permission activity failed. ";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(exception);
            Object object2 = ((StringBuilder)charSequence).toString();
            TXCLog.e(string2, (String)object2);
            object2 = c.a((Context)this);
            string2 = null;
            ((c)object2).a((MediaProjection)null);
            this.finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onDestroy ");
        charSequence.append((Object)this);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
    }
}

