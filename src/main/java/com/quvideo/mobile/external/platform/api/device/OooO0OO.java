/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.quvideo.mobile.external.platform.api.device;

import android.content.Context;
import com.quvideo.mobile.external.platform.api.device.OnDeviceListener;
import com.quvideo.mobile.external.platform.api.device.OooO0O0;
import com.quvideo.mobile.external.platform.api.device.OooO0OO$a;
import com.quvideo.mobile.external.platform.api.device.OooO0OO$b;
import com.quvideo.mobile.external.platform.httpcore.OooO;
import e.a.z;

public class OooO0OO {
    private com.quvideo.mobile.external.platform.httpcore.util.OooO0O0 OooO00o;
    private String OooO0O0 = null;
    private String OooO0OO = null;

    private OooO0OO() {
        String string2;
        Context context = OooO.OooO00o();
        Object object = new com.quvideo.mobile.external.platform.httpcore.util.OooO0O0(context, "QuVideoDevice");
        this.OooO00o = object;
        this.OooO0O0 = object = ((com.quvideo.mobile.external.platform.httpcore.util.OooO0O0)object).OooO00o("qv_key_device_external", null);
        this.OooO0OO = string2 = this.OooO00o.OooO00o("qv_key_device_inner", null);
    }

    public /* synthetic */ OooO0OO(OooO0OO$a a10) {
        this();
    }

    private void OooO00o() {
        this.OooO0O0 = null;
        this.OooO0OO = null;
        this.OooO00o.OooO00o("qv_key_device_external");
        this.OooO00o.OooO00o("qv_key_device_inner");
    }

    public static /* synthetic */ void OooO00o(OooO0OO oooO0OO, String string2, String string3) {
        oooO0OO.OooO00o(string2, string3);
    }

    private void OooO00o(String string2, String string3) {
        this.OooO0O0 = string3;
        this.OooO0OO = string2;
        this.OooO00o.OooO0O0("qv_key_device_external", string3);
        this.OooO00o.OooO0O0("qv_key_device_inner", string2);
    }

    public static OooO0OO OooO0O0() {
        return OooO0OO$b.a();
    }

    public void OooO00o(String string2, OnDeviceListener onDeviceListener) {
        Object object;
        boolean bl2;
        if (string2 != null && !(bl2 = ((String)(object = "")).equals(string2))) {
            object = this.OooO0O0;
            if (object != null && !(bl2 = ((String)object).equals(string2))) {
                this.OooO00o();
            }
            if ((object = this.OooO0O0) != null && (object = this.OooO0OO) != null) {
                boolean bl3 = true;
                onDeviceListener.onLoaded(bl3);
            } else {
                this.OooO0O0 = string2;
                object = com.quvideo.mobile.external.platform.api.device.OooO0O0.OooO00o();
                long l10 = 3;
                object = ((z)object).U4(l10);
                OooO0OO$a oooO0OO$a = new OooO0OO$a(this, string2, onDeviceListener);
                ((z)object).subscribe(oooO0OO$a);
            }
        }
    }

    public String OooO0OO() {
        Object object = this.OooO0O0;
        if (object == null) {
            object = this.OooO00o;
            String string2 = "qv_key_device_external";
            this.OooO0O0 = object = ((com.quvideo.mobile.external.platform.httpcore.util.OooO0O0)object).OooO00o(string2, null);
        }
        return this.OooO0O0;
    }

    public String OooO0Oo() {
        Object object = this.OooO0OO;
        if (object == null) {
            object = this.OooO00o;
            String string2 = "qv_key_device_inner";
            this.OooO0OO = object = ((com.quvideo.mobile.external.platform.httpcore.util.OooO0O0)object).OooO00o(string2, null);
        }
        return this.OooO0OO;
    }
}

