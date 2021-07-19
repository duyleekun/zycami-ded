/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 */
package com.huawei.hms.utils;

import android.os.AsyncTask;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSBIInitializer$a;

public class HMSBIInitializer$b
extends AsyncTask {
    public final /* synthetic */ HMSBIInitializer a;

    public HMSBIInitializer$b(HMSBIInitializer hMSBIInitializer) {
        this.a = hMSBIInitializer;
    }

    public /* synthetic */ HMSBIInitializer$b(HMSBIInitializer hMSBIInitializer, HMSBIInitializer.a a10) {
        this(hMSBIInitializer);
    }

    public Void a(String ... object) {
        HMSBIInitializer hMSBIInitializer = this.a;
        object = object[0];
        HMSBIInitializer.a(hMSBIInitializer, (String)object);
        return null;
    }
}

