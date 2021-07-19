/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.ac;
import com.xiaomi.push.az;
import com.xiaomi.push.dm;
import com.xiaomi.push.y;
import java.io.File;
import java.util.HashMap;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class u
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ boolean a;

    public u(Context context, boolean bl2) {
        this.a = context;
        this.a = bl2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        File file;
        boolean bl2;
        block11: {
            void var3_8;
            Object object;
            block10: {
                File file2;
                HashMap hashMap;
                Object object2;
                bl2 = false;
                object = null;
                try {
                    Context context = this.a;
                    object2 = "";
                    hashMap = ac.a(context, (String)object2);
                    boolean bl3 = this.a;
                    if (bl3) {
                        object2 = this.a;
                        object2 = object2.getFilesDir();
                        object2 = ((File)object2).getAbsolutePath();
                    } else {
                        object2 = new StringBuilder();
                        Context context2 = this.a;
                        File file3 = context2.getExternalFilesDir(null);
                        String string2 = file3.getAbsolutePath();
                        ((StringBuilder)object2).append(string2);
                        String string3 = dm.a;
                        ((StringBuilder)object2).append(string3);
                        object2 = ((StringBuilder)object2).toString();
                    }
                    file2 = Logger.getLogFile((String)object2);
                    if (file2 == null) {
                        String string4 = "log file null";
                        b.a(string4);
                        return;
                    }
                    Context context3 = this.a;
                    String string5 = context3.getPackageName();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string5);
                    String string6 = ".zip";
                    stringBuilder.append(string6);
                    String string7 = stringBuilder.toString();
                    file = new File((String)object2, string7);
                }
                catch (Throwable throwable) {
                    // empty catch block
                    break block10;
                }
                try {
                    y.a(file, file2);
                    bl2 = file.exists();
                    if (bl2) {
                        bl2 = this.a;
                        object = bl2 ? "https://api.xmpush.xiaomi.com/upload/xmsf_log?file=" : "https://api.xmpush.xiaomi.com/upload/app_log?file=";
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append((String)object);
                        object = file.getName();
                        ((StringBuilder)object2).append((String)object);
                        object = ((StringBuilder)object2).toString();
                        object2 = "file";
                        az.a((String)object, hashMap, file, (String)object2);
                        break block11;
                    } else {
                        object = "zip log file failed";
                        b.a((String)object);
                    }
                    break block11;
                }
                catch (Throwable throwable) {
                    object = file;
                }
            }
            b.a((Throwable)var3_8);
            file = object;
        }
        if (file != null && (bl2 = file.exists())) {
            file.delete();
        }
    }
}

