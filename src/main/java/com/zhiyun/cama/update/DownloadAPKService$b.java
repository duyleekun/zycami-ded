/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.zhiyun.cama.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zhiyun.cama.update.DownloadAPKService;
import com.zhiyun.cama.update.DownloadAPKService$Status;
import com.zhiyun.cama.update.DownloadAPKService$a;

public class DownloadAPKService$b
extends BroadcastReceiver {
    public final /* synthetic */ DownloadAPKService a;

    private DownloadAPKService$b(DownloadAPKService downloadAPKService) {
        this.a = downloadAPKService;
    }

    public /* synthetic */ DownloadAPKService$b(DownloadAPKService downloadAPKService, DownloadAPKService.a a10) {
        this(downloadAPKService);
    }

    public void onReceive(Context object, Intent object2) {
        object = object2.getAction();
        boolean bl2 = object.equals(object2 = "download_click");
        if (!bl2) {
            return;
        }
        object = DownloadAPKService.f(this.a);
        if (object == (object2 = DownloadAPKService$Status.FAIL)) {
            object = this.a;
            object2 = DownloadAPKService.a((DownloadAPKService)((Object)object));
            DownloadAPKService.g((DownloadAPKService)((Object)object), (String)object2);
        }
    }
}

