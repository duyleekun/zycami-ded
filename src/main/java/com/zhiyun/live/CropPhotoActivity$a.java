/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.widget.Toast
 */
package com.zhiyun.live;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import com.zhiyun.live.CropPhotoActivity;
import d.v.n.l.c$b;

public class CropPhotoActivity$a
implements c$b {
    public final /* synthetic */ CropPhotoActivity a;

    public CropPhotoActivity$a(CropPhotoActivity cropPhotoActivity) {
        this.a = cropPhotoActivity;
    }

    public void a(Uri object) {
        Intent intent = new Intent();
        object = object.getPath();
        intent.putExtra("action_crop_photo_uri", (String)object);
        this.a.setResult(-1, intent);
        ActivityCompat.finishAfterTransition(this.a);
    }

    public void b(String string2) {
        Toast.makeText((Context)this.a, (CharSequence)string2, (int)0).show();
    }
}

