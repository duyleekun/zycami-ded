/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.internal;

import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.protobuf.GeneratedMessageLite;

public class FirebasePerfApplicationInfoValidator
extends PerfMetricValidator {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ApplicationInfo mApplicationInfo;

    public FirebasePerfApplicationInfoValidator(ApplicationInfo applicationInfo) {
        this.mApplicationInfo = applicationInfo;
    }

    private boolean isValidApplicationInfo() {
        GeneratedMessageLite generatedMessageLite = this.mApplicationInfo;
        if (generatedMessageLite == null) {
            logger.warn("ApplicationInfo is null");
            return false;
        }
        boolean bl2 = ((ApplicationInfo)generatedMessageLite).hasGoogleAppId();
        if (!bl2) {
            logger.warn("GoogleAppId is null");
            return false;
        }
        generatedMessageLite = this.mApplicationInfo;
        bl2 = ((ApplicationInfo)generatedMessageLite).hasAppInstanceId();
        if (!bl2) {
            logger.warn("AppInstanceId is null");
            return false;
        }
        generatedMessageLite = this.mApplicationInfo;
        bl2 = ((ApplicationInfo)generatedMessageLite).hasApplicationProcessState();
        if (!bl2) {
            logger.warn("ApplicationProcessState is null");
            return false;
        }
        generatedMessageLite = this.mApplicationInfo;
        bl2 = ((ApplicationInfo)generatedMessageLite).hasAndroidAppInfo();
        if (bl2) {
            generatedMessageLite = this.mApplicationInfo.getAndroidAppInfo();
            bl2 = ((AndroidApplicationInfo)generatedMessageLite).hasPackageName();
            if (!bl2) {
                logger.warn("AndroidAppInfo.packageName is null");
                return false;
            }
            generatedMessageLite = this.mApplicationInfo.getAndroidAppInfo();
            bl2 = ((AndroidApplicationInfo)generatedMessageLite).hasSdkVersion();
            if (!bl2) {
                logger.warn("AndroidAppInfo.sdkVersion is null");
                return false;
            }
        }
        return true;
    }

    public boolean isValidPerfMetric() {
        boolean bl2 = this.isValidApplicationInfo();
        if (!bl2) {
            logger.warn("ApplicationInfo is invalid");
            return false;
        }
        return true;
    }
}

