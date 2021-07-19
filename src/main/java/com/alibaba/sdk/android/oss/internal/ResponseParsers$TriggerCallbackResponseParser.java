/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.TriggerCallbackResult;

public final class ResponseParsers$TriggerCallbackResponseParser
extends AbstractResponseParser {
    public TriggerCallbackResult parseData(ResponseMessage object, TriggerCallbackResult triggerCallbackResult) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((ResponseMessage)object).getResponse().r0().string()));
        if (!bl2) {
            triggerCallbackResult.setServerCallbackReturnBody((String)object);
        }
        return triggerCallbackResult;
    }
}

