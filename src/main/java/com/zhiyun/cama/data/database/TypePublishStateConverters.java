/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.cama.data.database;

import android.text.TextUtils;
import com.zhiyun.cama.data.PublishState;

public class TypePublishStateConverters {
    public static String StringToPublishState(PublishState publishState) {
        return publishState.name();
    }

    public static PublishState publishStateToString(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return PublishState.STATE_NONE;
        }
        PublishState publishState = PublishState.STATE_PUBLISHING;
        String string3 = publishState.name();
        boolean bl3 = string2.equals(string3);
        if (bl3) {
            return publishState;
        }
        publishState = PublishState.STATE_SUCCESS;
        string3 = publishState.name();
        bl3 = string2.equals(string3);
        if (bl3) {
            return publishState;
        }
        publishState = PublishState.STATE_FAILED;
        string3 = publishState.name();
        bl3 = string2.equals(string3);
        if (bl3) {
            return publishState;
        }
        publishState = PublishState.STATE_CANCEL;
        string3 = publishState.name();
        boolean bl4 = string2.equals(string3);
        if (bl4) {
            return publishState;
        }
        return PublishState.STATE_NONE;
    }
}

