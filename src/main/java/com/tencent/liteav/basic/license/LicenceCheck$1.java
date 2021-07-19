/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.tencent.liteav.basic.license;

import android.text.TextUtils;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.license.LicenceCheck$a;
import com.tencent.liteav.basic.license.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.File;

public class LicenceCheck$1
implements b {
    public final /* synthetic */ LicenceCheck$a a;
    public final /* synthetic */ LicenceCheck b;

    public LicenceCheck$1(LicenceCheck licenceCheck, LicenceCheck$a licenceCheck$a) {
        this.b = licenceCheck;
        this.a = licenceCheck$a;
    }

    public void a() {
        TXCLog.i("LicenceCheck", "downloadLicense, onProcessEnd");
        this.a.f = false;
    }

    public void a(int n10) {
        TXCLog.i("LicenceCheck", "downloadLicense, onProgressUpdate");
    }

    public void a(File file, Exception exception) {
        TXCLog.i("LicenceCheck", "downloadLicense, onSaveFailed");
    }

    public void a(File object, String object2) {
        Object object3 = "LicenceCheck";
        if (object == null) {
            TXCLog.i((String)object3, "downloadLicense, license not modified");
            return;
        }
        object = this.b;
        LicenceCheck$a licenceCheck$a = this.a;
        LicenceCheck.a((LicenceCheck)object, licenceCheck$a, (String)object2);
        TXCLog.i((String)object3, "downloadLicense, onSaveSuccess");
        object = this.b;
        object2 = this.a;
        object = LicenceCheck.a((LicenceCheck)object, (LicenceCheck$a)object2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            TXCLog.e((String)object3, "downloadLicense, readDownloadTempLicence is empty!");
            this.a.f = false;
            return;
        }
        object2 = this.b;
        object3 = this.a;
        int n10 = LicenceCheck.b((LicenceCheck)object2, (LicenceCheck$a)object3, (String)object);
        if (n10 == 0) {
            object = this.b;
            object2 = this.a;
            LicenceCheck.b((LicenceCheck)object, (LicenceCheck$a)object2);
        }
    }
}

