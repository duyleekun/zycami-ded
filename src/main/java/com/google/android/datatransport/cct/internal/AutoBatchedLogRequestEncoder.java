/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$ClientInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$LogEventEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$LogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

public final class AutoBatchedLogRequestEncoder
implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG;

    static {
        AutoBatchedLogRequestEncoder autoBatchedLogRequestEncoder = new AutoBatchedLogRequestEncoder();
        CONFIG = autoBatchedLogRequestEncoder;
    }

    private AutoBatchedLogRequestEncoder() {
    }

    public void configure(EncoderConfig encoderConfig) {
        ObjectEncoder objectEncoder = AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder.INSTANCE;
        encoderConfig.registerEncoder(BatchedLogRequest.class, objectEncoder);
        encoderConfig.registerEncoder(AutoValue_BatchedLogRequest.class, objectEncoder);
        objectEncoder = AutoBatchedLogRequestEncoder$LogRequestEncoder.INSTANCE;
        encoderConfig.registerEncoder(LogRequest.class, objectEncoder);
        encoderConfig.registerEncoder(AutoValue_LogRequest.class, objectEncoder);
        objectEncoder = AutoBatchedLogRequestEncoder$ClientInfoEncoder.INSTANCE;
        encoderConfig.registerEncoder(ClientInfo.class, objectEncoder);
        encoderConfig.registerEncoder(AutoValue_ClientInfo.class, objectEncoder);
        objectEncoder = AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder.INSTANCE;
        encoderConfig.registerEncoder(AndroidClientInfo.class, objectEncoder);
        encoderConfig.registerEncoder(AutoValue_AndroidClientInfo.class, objectEncoder);
        objectEncoder = AutoBatchedLogRequestEncoder$LogEventEncoder.INSTANCE;
        encoderConfig.registerEncoder(LogEvent.class, objectEncoder);
        encoderConfig.registerEncoder(AutoValue_LogEvent.class, objectEncoder);
        objectEncoder = AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder.INSTANCE;
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, objectEncoder);
        encoderConfig.registerEncoder(AutoValue_NetworkConnectionInfo.class, objectEncoder);
    }
}

