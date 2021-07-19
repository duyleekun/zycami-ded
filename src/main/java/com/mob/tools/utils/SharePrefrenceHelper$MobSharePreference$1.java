/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools.utils;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.SharePrefrenceHelper$OnCommitListener;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public final class SharePrefrenceHelper$MobSharePreference$1
implements Handler.Callback {
    public boolean handleMessage(Message object) {
        block12: {
            NLog nLog = null;
            Object object2 = ((Message)object).obj;
            try {
                object2 = (SharePrefrenceHelper$OnCommitListener)object2;
            }
            catch (Throwable throwable) {
                object2 = null;
            }
            object = object.getData();
            String string2 = "json";
            string2 = object.getString(string2);
            Object object3 = "file";
            object = object.getString((String)object3);
            object3 = new FileOutputStream((String)object);
            String string3 = "utf-8";
            object = new OutputStreamWriter((OutputStream)object3, string3);
            ((OutputStreamWriter)object).append(string2);
            ((OutputStreamWriter)object).flush();
            ((OutputStreamWriter)object).close();
            if (object2 == null) break block12;
            try {
                object2.onCommit(null);
            }
            catch (Throwable throwable) {
                nLog = MobLog.getInstance();
                nLog.w(throwable);
                if (object2 == null) break block12;
                object2.onCommit(throwable);
            }
        }
        return false;
    }
}

