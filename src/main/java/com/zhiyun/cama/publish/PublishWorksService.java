/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 */
package com.zhiyun.cama.publish;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.zhiyun.cama.data.database.model.PublishWorks;
import d.v.c.v0.u.y;

public class PublishWorksService
extends IntentService {
    public PublishWorksService() {
        super("PublishWorksService");
    }

    public static void a(Context context, PublishWorks publishWorks) {
        Intent intent = new Intent(context, PublishWorksService.class);
        intent.putExtra("PublishWorks", (Parcelable)publishWorks);
        context.startService(intent);
    }

    public void onHandleIntent(Intent object) {
        if (object == null) {
            this.stopSelf();
        } else {
            Object object2 = "PublishWorks";
            if ((object = (PublishWorks)object.getParcelableExtra((String)object2)) != null) {
                object2 = new y((PublishWorks)object);
                ((y)object2).run();
            }
        }
    }
}

