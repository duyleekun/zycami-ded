/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.aq;

public class r {
    public static void a(Context context, Config config) {
        if (config == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_cr_config");
        boolean bl2 = config.isEventUploadSwitchOpen();
        intent.putExtra("action_cr_event_switch", bl2);
        long l10 = config.getEventUploadFrequency();
        intent.putExtra("action_cr_event_frequency", l10);
        bl2 = config.isPerfUploadSwitchOpen();
        intent.putExtra("action_cr_perf_switch", bl2);
        l10 = config.getPerfUploadFrequency();
        intent.putExtra("action_cr_perf_frequency", l10);
        bl2 = config.isEventEncrypted();
        intent.putExtra("action_cr_event_en", bl2);
        l10 = config.getMaxFileLength();
        intent.putExtra("action_cr_max_file_size", l10);
        aq.a(context).a(intent);
    }
}

