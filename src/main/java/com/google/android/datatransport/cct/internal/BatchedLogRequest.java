/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

public abstract class BatchedLogRequest {
    public static BatchedLogRequest create(List list) {
        AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = new AutoValue_BatchedLogRequest(list);
        return autoValue_BatchedLogRequest;
    }

    public static DataEncoder createDataEncoder() {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        Configurator configurator = AutoBatchedLogRequestEncoder.CONFIG;
        return jsonDataEncoderBuilder.configureWith(configurator).ignoreNullValues(true).build();
    }

    public abstract List getLogRequests();
}

