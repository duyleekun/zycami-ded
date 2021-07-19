/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVFile;
import cn.leancloud.AVFriendship;
import cn.leancloud.AVFriendshipRequest;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger$Level;
import cn.leancloud.AVObject;
import cn.leancloud.AVStatus;
import cn.leancloud.AVUser;
import cn.leancloud.core.AVOSCloud$REGION;
import cn.leancloud.core.AVOSService;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.AppRouter;
import cn.leancloud.core.GeneralRequestSignature;
import cn.leancloud.core.PaasClient;
import cn.leancloud.utils.StringUtil;
import e.a.z;
import java.io.PrintStream;

public class AVOSCloud {
    private static String applicationId;
    private static String applicationKey;
    private static AVOSCloud$REGION defaultRegion;
    private static boolean enableCircularReferenceDetect;
    private static String hookKey;
    private static volatile AVLogger$Level logLevel;
    public static boolean printAllHeaders;

    static {
        String string2;
        defaultRegion = AVOSCloud$REGION.NorthChina;
        applicationId = string2 = "";
        applicationKey = string2;
        hookKey = string2;
        logLevel = AVLogger$Level.INFO;
        printAllHeaders = false;
        enableCircularReferenceDetect = false;
    }

    public static void enablePrintAllHeaders4Debug(boolean bl2) {
        printAllHeaders = bl2;
        if (bl2) {
            System.out.println("======= WARNING: you are going to dump all details for a REST request, it is very risky for security!!! please ONLY USE IN absolutely trusted environment!!!");
            PrintStream printStream = System.out;
            String string2 = "( \u2022\u0300\u1d17\u2022\u0301 )\u0648( \u2022\u0300\u1d17\u2022\u0301 )\u0648( \u2022\u0300\u1d17\u2022\u0301 )\u0648( \u2022\u0300\u1d17\u2022\u0301 )\u0648( \u2022\u0300\u1d17\u2022\u0301 )\u0648( \u2022\u0300\u1d17\u2022\u0301 )\u0648( \u2022\u0300\u1d17\u2022\u0301 )\u0648( \u2022\u0300\u1d17\u2022\u0301 )\u0648( \u2022\u0300\u1d17\u2022\u0301 )\u0648( \u2022\u0300\u1d17\u2022\u0301 )\u0648";
            printStream.println(string2);
        }
    }

    public static String getApplicationId() {
        return applicationId;
    }

    public static String getApplicationKey() {
        return applicationKey;
    }

    public static String getHookKey() {
        return hookKey;
    }

    public static AVLogger$Level getLogLevel() {
        return logLevel;
    }

    public static int getNetworkTimeout() {
        return AppConfiguration.getNetworkTimeout();
    }

    public static AVOSCloud$REGION getRegion() {
        return defaultRegion;
    }

    public static z getServerDateInBackground() {
        return PaasClient.getStorageClient().getServerTime();
    }

    public static String getSimplifiedAppId() {
        String string2 = applicationId;
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return "";
        }
        return applicationId.substring(0, 8);
    }

    public static void initialize(String string2, String string3) {
        AVObject.registerSubclass(AVStatus.class);
        AVObject.registerSubclass(AVUser.class);
        AVObject.registerSubclass(AVFile.class);
        AVObject.registerSubclass(AVInstallation.class);
        AVObject.registerSubclass(AVFriendshipRequest.class);
        AVObject.registerSubclass(AVFriendship.class);
        applicationId = string2;
        applicationKey = string3;
        PaasClient.initializeGlobalClient();
    }

    public static void initialize(String string2, String string3, String string4) {
        AVOSCloud.setServerURLs(string4);
        AVOSCloud.initialize(string2, string3);
    }

    public static boolean isDebugEnable() {
        AVLogger$Level aVLogger$Level;
        int n10;
        AVLogger$Level aVLogger$Level2 = logLevel;
        int n11 = aVLogger$Level2.intLevel();
        if (n11 >= (n10 = (aVLogger$Level = AVLogger$Level.DEBUG).intLevel())) {
            n11 = 1;
        } else {
            n11 = 0;
            aVLogger$Level2 = null;
        }
        return n11 != 0;
    }

    public static boolean isEnableCircularReferenceDetect() {
        return enableCircularReferenceDetect;
    }

    public static boolean isLastModifyEnabled() {
        return AppConfiguration.isLastModifyEnabled();
    }

    public static void setAlwaysFetchWhenSave(boolean bl2) {
    }

    public static void setAutoMergeOperationDataWhenSave(boolean bl2) {
        AppConfiguration.setAutoMergeOperationDataWhenSave(bl2);
    }

    public static void setCircularReferenceDetectEnable(boolean bl2) {
        enableCircularReferenceDetect = bl2;
    }

    public static void setHookKey(String string2) {
        hookKey = string2;
    }

    public static void setLastModifyEnabled(boolean bl2) {
        AppConfiguration.setLastModifyEnabled(bl2);
    }

    public static void setLogLevel(AVLogger$Level aVLogger$Level) {
        logLevel = aVLogger$Level;
    }

    public static void setMasterKey(String string2) {
        GeneralRequestSignature.setMasterKey(string2);
    }

    public static void setNetworkTimeout(int n10) {
        AppConfiguration.setNetworkTimeout(n10);
    }

    public static void setRegion(AVOSCloud$REGION aVOSCloud$REGION) {
        defaultRegion = aVOSCloud$REGION;
    }

    public static void setServer(AVOSService aVOSService, String string2) {
        String string3;
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return;
        }
        CharSequence charSequence = string2.toLowerCase();
        bl2 = ((String)charSequence).startsWith(string3 = "http");
        if (!bl2) {
            charSequence = new StringBuilder();
            string3 = "https://";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
        }
        AppRouter.getInstance().freezeEndpoint(aVOSService, string2);
    }

    public static void setServerURLs(String string2) {
        AVOSCloud.setServer(AVOSService.API, string2);
        AVOSCloud.setServer(AVOSService.RTM, string2);
        AVOSCloud.setServer(AVOSService.ENGINE, string2);
        AVOSCloud.setServer(AVOSService.PUSH, string2);
        AVOSCloud.setServer(AVOSService.STATS, string2);
    }
}

