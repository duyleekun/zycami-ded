/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVACL;
import cn.leancloud.cache.InMemorySetting;
import cn.leancloud.cache.LastModifyCache;
import cn.leancloud.cache.SystemSetting;
import cn.leancloud.core.AppConfiguration$SchedulerCreator;
import cn.leancloud.gson.GSONConverterFactory;
import cn.leancloud.json.ConverterFactory;
import cn.leancloud.json.JSONParser;
import cn.leancloud.logging.InternalLoggerAdapter;
import cn.leancloud.logging.SimpleLoggerAdapter;
import cn.leancloud.network.NetworkingDetector;
import cn.leancloud.network.SimpleNetworkingDetector;
import cn.leancloud.utils.FileUtil;
import cn.leancloud.utils.FileUtil$MimeTypeDetector;
import java.io.File;
import k.h$a;

public class AppConfiguration {
    public static final int DEFAULT_NETWORK_TIMEOUT = 30;
    private static final String DEFAULT_USER_AGENT = "LeanCloud-Java-SDK/7.2.6";
    private static final String SDK_VERSION = "7.2.6";
    private static String analyticsCacheDir;
    private static String applicationPackageName;
    private static boolean asynchronized = false;
    private static boolean autoMergeOperationDataWhenSave = false;
    private static String commandCacheDir;
    private static ConverterFactory converterFactory;
    private static AVACL defaultACL;
    private static AppConfiguration$SchedulerCreator defaultScheduler;
    private static SystemSetting defaultSetting;
    private static String documentDir;
    private static boolean enableLocalCache = false;
    private static String fileCacheDir;
    private static NetworkingDetector globalNetworkingDetector;
    private static String importantFileDir;
    private static boolean incognitoMode = false;
    private static JSONParser jsonParser;
    private static InternalLoggerAdapter logAdapter;
    private static int networkTimeout = 30;
    private static String queryResultCacheDir;
    private static h.a retrofitConverterFactory;

    static {
        boolean bl2;
        Object object = new SimpleLoggerAdapter();
        logAdapter = object;
        asynchronized = false;
        defaultScheduler = null;
        Object object2 = new SimpleNetworkingDetector();
        globalNetworkingDetector = object2;
        applicationPackageName = "";
        importantFileDir = "./persistFiles/";
        documentDir = "./data/";
        fileCacheDir = "./file/";
        commandCacheDir = "./command/";
        analyticsCacheDir = "./stats/";
        queryResultCacheDir = "./PaasKeyValueCache";
        defaultSetting = object2 = new InMemorySetting();
        enableLocalCache = bl2 = true;
        incognitoMode = false;
        converterFactory = object = new GSONConverterFactory();
        retrofitConverterFactory = object.generateRetrofitConverterFactory();
        jsonParser = converterFactory.createJSONParser();
        autoMergeOperationDataWhenSave = bl2;
    }

    public static void config(boolean bl2, AppConfiguration$SchedulerCreator appConfiguration$SchedulerCreator) {
        asynchronized = bl2;
        defaultScheduler = appConfiguration$SchedulerCreator;
    }

    public static void configCacheSettings(String charSequence, String string2, String string3, String string4, String string5, String string6, SystemSetting systemSetting) {
        importantFileDir = charSequence;
        String string7 = "/";
        boolean bl2 = ((String)charSequence).endsWith(string7);
        if (!bl2) {
            charSequence = new StringBuilder();
            String string8 = importantFileDir;
            ((StringBuilder)charSequence).append(string8);
            ((StringBuilder)charSequence).append(string7);
            charSequence = ((StringBuilder)charSequence).toString();
            importantFileDir = charSequence;
        }
        documentDir = string2;
        bl2 = string2.endsWith(string7);
        if (!bl2) {
            charSequence = new StringBuilder();
            string2 = documentDir;
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string7);
            charSequence = ((StringBuilder)charSequence).toString();
            documentDir = charSequence;
        }
        fileCacheDir = string3;
        bl2 = string3.endsWith(string7);
        if (!bl2) {
            charSequence = new StringBuilder();
            string2 = fileCacheDir;
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string7);
            charSequence = ((StringBuilder)charSequence).toString();
            fileCacheDir = charSequence;
        }
        queryResultCacheDir = string4;
        bl2 = string4.endsWith(string7);
        if (!bl2) {
            charSequence = new StringBuilder();
            string2 = queryResultCacheDir;
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string7);
            charSequence = ((StringBuilder)charSequence).toString();
            queryResultCacheDir = charSequence;
        }
        commandCacheDir = string5;
        bl2 = string5.endsWith(string7);
        if (!bl2) {
            charSequence = new StringBuilder();
            string2 = commandCacheDir;
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string7);
            charSequence = ((StringBuilder)charSequence).toString();
            commandCacheDir = charSequence;
        }
        analyticsCacheDir = string6;
        bl2 = string6.endsWith(string7);
        if (!bl2) {
            charSequence = new StringBuilder();
            string2 = analyticsCacheDir;
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string7);
            charSequence = ((StringBuilder)charSequence).toString();
            analyticsCacheDir = charSequence;
        }
        AppConfiguration.makeSureCacheDirWorkable();
        defaultSetting = systemSetting;
    }

    public static String getAnalyticsCacheDir() {
        boolean bl2 = enableLocalCache;
        if (!bl2) {
            return null;
        }
        AppConfiguration.makeSureDirExist(analyticsCacheDir);
        return analyticsCacheDir;
    }

    public static String getApplicationPackageName() {
        return applicationPackageName;
    }

    public static String getCommandCacheDir() {
        boolean bl2 = enableLocalCache;
        if (!bl2) {
            return null;
        }
        AppConfiguration.makeSureDirExist(commandCacheDir);
        return commandCacheDir;
    }

    public static AVACL getDefaultACL() {
        return defaultACL;
    }

    public static AppConfiguration$SchedulerCreator getDefaultScheduler() {
        return defaultScheduler;
    }

    public static SystemSetting getDefaultSetting() {
        return defaultSetting;
    }

    public static String getDocumentDir() {
        boolean bl2 = enableLocalCache;
        if (!bl2) {
            return null;
        }
        AppConfiguration.makeSureDirExist(documentDir);
        return documentDir;
    }

    public static String getFileCacheDir() {
        boolean bl2 = enableLocalCache;
        if (!bl2) {
            return null;
        }
        AppConfiguration.makeSureDirExist(fileCacheDir);
        return fileCacheDir;
    }

    public static NetworkingDetector getGlobalNetworkingDetector() {
        return globalNetworkingDetector;
    }

    public static String getImportantFileDir() {
        boolean bl2 = enableLocalCache;
        if (!bl2) {
            return null;
        }
        AppConfiguration.makeSureDirExist(importantFileDir);
        return importantFileDir;
    }

    public static JSONParser getJsonParser() {
        return jsonParser;
    }

    public static InternalLoggerAdapter getLogAdapter() {
        return logAdapter;
    }

    public static int getNetworkTimeout() {
        return networkTimeout;
    }

    public static String getQueryResultCacheDir() {
        boolean bl2 = enableLocalCache;
        if (!bl2) {
            return null;
        }
        AppConfiguration.makeSureDirExist(queryResultCacheDir);
        return queryResultCacheDir;
    }

    public static h.a getRetrofitConverterFactory() {
        return retrofitConverterFactory;
    }

    public static String getUserAgent() {
        return DEFAULT_USER_AGENT;
    }

    public static boolean isAsynchronized() {
        return asynchronized;
    }

    public static boolean isAutoMergeOperationDataWhenSave() {
        return autoMergeOperationDataWhenSave;
    }

    public static boolean isEnableLocalCache() {
        return enableLocalCache;
    }

    public static boolean isIncognitoMode() {
        return incognitoMode;
    }

    public static boolean isLastModifyEnabled() {
        return LastModifyCache.getInstance().isLastModifyEnabled();
    }

    public static void makeSureCacheDirWorkable() {
        AppConfiguration.makeSureDirExist(importantFileDir);
        AppConfiguration.makeSureDirExist(documentDir);
        AppConfiguration.makeSureDirExist(fileCacheDir);
        AppConfiguration.makeSureDirExist(queryResultCacheDir);
        AppConfiguration.makeSureDirExist(commandCacheDir);
        AppConfiguration.makeSureDirExist(analyticsCacheDir);
    }

    private static void makeSureDirExist(String string2) {
        File file = new File(string2);
        boolean bl2 = file.exists();
        if (!bl2) {
            file.mkdirs();
        }
    }

    public static void setApplicationPackageName(String string2) {
        applicationPackageName = string2;
    }

    public static void setAutoMergeOperationDataWhenSave(boolean bl2) {
        autoMergeOperationDataWhenSave = bl2;
    }

    public static void setConverterFactory(ConverterFactory converterFactory) {
        if (converterFactory == null) {
            return;
        }
        AppConfiguration.converterFactory = converterFactory;
        retrofitConverterFactory = converterFactory.generateRetrofitConverterFactory();
        jsonParser = AppConfiguration.converterFactory.createJSONParser();
    }

    public static void setDefaultACL(AVACL aVACL) {
        defaultACL = aVACL;
    }

    public static void setEnableLocalCache(boolean bl2) {
        enableLocalCache = bl2;
    }

    public static void setGlobalNetworkingDetector(NetworkingDetector networkingDetector) {
        globalNetworkingDetector = networkingDetector;
    }

    public static void setIncognitoMode(boolean bl2) {
        incognitoMode = bl2;
    }

    public static void setLastModifyEnabled(boolean bl2) {
        LastModifyCache.getInstance().setLastModifyEnabled(bl2);
    }

    public static void setLogAdapter(InternalLoggerAdapter internalLoggerAdapter) {
        logAdapter = internalLoggerAdapter;
    }

    public static void setMimeTypeDetector(FileUtil.MimeTypeDetector mimeTypeDetector) {
        if (mimeTypeDetector != null) {
            FileUtil.config(mimeTypeDetector);
        }
    }

    public static void setNetworkTimeout(int n10) {
        networkTimeout = n10;
    }
}

