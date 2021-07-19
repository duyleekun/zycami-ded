/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Base64
 *  org.json.JSONObject
 */
package com.mob;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.EverythingKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import java.io.Serializable;
import org.json.JSONObject;

public class PrivacyPolicy
implements EverythingKeeper,
Serializable {
    private String content;
    private int ppVersion;
    private long timestamp;
    private String title;

    public PrivacyPolicy() {
    }

    public PrivacyPolicy(String string2) {
        block18: {
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                Object object = new JSONObject(string2);
                string2 = "timestamp";
                long l10 = object.optLong(string2);
                this.setTimestamp(l10);
                string2 = "title";
                string2 = object.optString(string2);
                string2 = this.decrypt(string2);
                this.setTitle(string2);
                string2 = "content";
                string2 = object.optString(string2);
                string2 = this.decrypt(string2);
                this.setContent(string2);
                string2 = "ppVersion";
                string2 = object.optString(string2);
                string2 = this.decrypt(string2);
                bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (bl2) break block18;
                string2 = string2.trim();
                int n10 = Integer.parseInt(string2);
                try {
                    this.setPpVersion(n10);
                }
                catch (Throwable throwable) {
                    object = MobLog.getInstance();
                    ((NLog)object).d(throwable);
                }
            }
        }
    }

    private String decrypt(String object) {
        block18: {
            Object object2 = ":";
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block18;
            String string2 = MobSDK.getAppkey();
            Object object3 = MobSDK.getContext();
            object3 = DeviceHelper.getInstance((Context)object3);
            object3 = ((DeviceHelper)object3).getPackageName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object3);
            stringBuilder.append((String)object2);
            long l10 = this.getTimestamp();
            stringBuilder.append(l10);
            object2 = stringBuilder.toString();
            object2 = Data.rawMD5((String)object2);
            bl2 = false;
            string2 = null;
            object = Base64.decode((String)object, (int)0);
            object = Data.AES128Decode((byte[])object2, (byte[])object);
            string2 = "UTF-8";
            try {
                object2 = new String((byte[])object, string2);
                return object2;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        return null;
    }

    public String getContent() {
        return this.content;
    }

    public int getPpVersion() {
        return this.ppVersion;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String string2) {
        this.content = string2;
    }

    public void setPpVersion(int n10) {
        this.ppVersion = n10;
    }

    public void setTimestamp(long l10) {
        this.timestamp = l10;
    }

    public void setTitle(String string2) {
        this.title = string2;
    }
}

