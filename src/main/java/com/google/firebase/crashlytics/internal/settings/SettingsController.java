/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 *  org.json.JSONObject
 */
package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.CachedSettingsIo;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsCacheBehavior;
import com.google.firebase.crashlytics.internal.settings.SettingsController$1;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonParser;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class SettingsController
implements SettingsDataProvider {
    private static final String PREFS_BUILD_INSTANCE_IDENTIFIER = "existing_instance_identifier";
    private static final String SETTINGS_URL_FORMAT = "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings";
    private final AtomicReference appSettingsData;
    private final CachedSettingsIo cachedSettingsIo;
    private final Context context;
    private final CurrentTimeProvider currentTimeProvider;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final AtomicReference settings;
    private final SettingsJsonParser settingsJsonParser;
    private final SettingsRequest settingsRequest;
    private final SettingsSpiCall settingsSpiCall;

    public SettingsController(Context object, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<TaskCompletionSource> atomicReference;
        AtomicReference<Context> atomicReference2;
        this.settings = atomicReference2 = new AtomicReference<Context>();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.appSettingsData = atomicReference = new AtomicReference<TaskCompletionSource>(taskCompletionSource);
        this.context = object;
        this.settingsRequest = settingsRequest;
        this.currentTimeProvider = currentTimeProvider;
        this.settingsJsonParser = settingsJsonParser;
        this.cachedSettingsIo = cachedSettingsIo;
        this.settingsSpiCall = settingsSpiCall;
        this.dataCollectionArbiter = dataCollectionArbiter;
        object = DefaultSettingsJsonTransform.defaultSettings(currentTimeProvider);
        atomicReference2.set((Context)object);
    }

    public static /* synthetic */ SettingsRequest access$000(SettingsController settingsController) {
        return settingsController.settingsRequest;
    }

    public static /* synthetic */ SettingsSpiCall access$100(SettingsController settingsController) {
        return settingsController.settingsSpiCall;
    }

    public static /* synthetic */ SettingsJsonParser access$200(SettingsController settingsController) {
        return settingsController.settingsJsonParser;
    }

    public static /* synthetic */ CachedSettingsIo access$300(SettingsController settingsController) {
        return settingsController.cachedSettingsIo;
    }

    public static /* synthetic */ void access$400(SettingsController settingsController, JSONObject jSONObject, String string2) {
        settingsController.logSettings(jSONObject, string2);
    }

    public static /* synthetic */ boolean access$500(SettingsController settingsController, String string2) {
        return settingsController.setStoredBuildInstanceIdentifier(string2);
    }

    public static /* synthetic */ AtomicReference access$600(SettingsController settingsController) {
        return settingsController.settings;
    }

    public static /* synthetic */ AtomicReference access$700(SettingsController settingsController) {
        return settingsController.appSettingsData;
    }

    public static SettingsController create(Context context, String string2, IdManager idManager, HttpRequestFactory httpRequestFactory, String string3, String string4, DataCollectionArbiter dataCollectionArbiter) {
        SettingsRequest settingsRequest;
        Object object = idManager.getInstallerPackageName();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        SettingsJsonParser settingsJsonParser = new SettingsJsonParser(systemCurrentTimeProvider);
        CachedSettingsIo cachedSettingsIo = new CachedSettingsIo(context);
        Object object2 = Locale.US;
        int n10 = 1;
        Object object3 = new Object[n10];
        object3[0] = string2;
        object2 = String.format((Locale)object2, SETTINGS_URL_FORMAT, object3);
        object3 = httpRequestFactory;
        DefaultSettingsSpiCall defaultSettingsSpiCall = new DefaultSettingsSpiCall((String)object2, httpRequestFactory);
        object3 = idManager.getModelName();
        Object object4 = idManager.getOsBuildVersionString();
        Object object5 = idManager.getOsDisplayVersionString();
        object2 = new String[4];
        Object object6 = CommonUtils.getMappingFileId(context);
        object2[0] = object6;
        object2[n10] = string2;
        object2[2] = string4;
        object2[3] = string3;
        object6 = CommonUtils.createInstanceIdFrom(object2);
        int n11 = DeliveryMechanism.determineFrom((String)object).getId();
        object = settingsRequest;
        object2 = string2;
        Context context2 = object3;
        object3 = object4;
        Object object7 = object5;
        object4 = idManager;
        object5 = object6;
        object6 = string4;
        settingsRequest = new SettingsRequest(string2, (String)context2, (String)object3, (String)object7, idManager, (String)object5, string4, string3, n11);
        object2 = object;
        context2 = context;
        object3 = settingsRequest;
        object7 = systemCurrentTimeProvider;
        object4 = settingsJsonParser;
        object5 = cachedSettingsIo;
        object6 = defaultSettingsSpiCall;
        object = new SettingsController(context, settingsRequest, systemCurrentTimeProvider, settingsJsonParser, cachedSettingsIo, defaultSettingsSpiCall, dataCollectionArbiter);
        return object;
    }

    /*
     * Unable to fully structure code
     */
    private SettingsData getCachedSettingsData(SettingsCacheBehavior var1_1) {
        block20: {
            block23: {
                block21: {
                    block22: {
                        var2_5 = null;
                        var3_6 = SettingsCacheBehavior.SKIP_CACHE_LOOKUP;
                        var4_7 = var3_6.equals(var1_1);
                        if (var4_7) break block20;
                        var3_6 = this.cachedSettingsIo;
                        var3_6 = var3_6.readCachedSettings();
                        if (var3_6 == null) ** GOTO lbl55
                        var5_8 = this.settingsJsonParser;
                        var5_8 = var5_8.parseSettingsJson((JSONObject)var3_6);
                        if (var5_8 == null) break block21;
                        var6_9 = "Loaded cached settings: ";
                        this.logSettings((JSONObject)var3_6, var6_9);
                        var3_6 = this.currentTimeProvider;
                        var7_10 = var3_6.getCurrentTimeMillis();
                        var3_6 = SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION;
                        var9_11 = var3_6.equals(var1_1);
                        if (var9_11) break block22;
                        var9_11 = var5_8.isExpired(var7_10);
                        if (!var9_11) break block22;
                        var1_1 = Logger.getLogger();
                        var3_6 = "Cached settings have expired.";
                        var1_1.v((String)var3_6);
                        break block20;
                    }
                    var1_1 = Logger.getLogger();
                    var2_5 = "Returning cached settings.";
                    try {
                        var1_1.v((String)var2_5);
                        var2_5 = var5_8;
                        break block20;
                    }
                    catch (Exception var1_2) {
                        var2_5 = var5_8;
                    }
                    break block23;
                }
                var1_1 = Logger.getLogger();
                var3_6 = "Failed to parse cached settings data.";
                var1_1.e((String)var3_6, null);
                break block20;
lbl55:
                // 1 sources

                var1_1 = Logger.getLogger();
                var3_6 = "No cached settings data found.";
                try {
                    var1_1.d((String)var3_6);
                    break block20;
                }
                catch (Exception var1_3) {
                    // empty catch block
                }
            }
            var3_6 = Logger.getLogger();
            var5_8 = "Failed to get cached settings";
            var3_6.e((String)var5_8, (Throwable)var1_4);
        }
        return var2_5;
    }

    private String getStoredBuildInstanceIdentifier() {
        return CommonUtils.getSharedPrefs(this.context).getString(PREFS_BUILD_INSTANCE_IDENTIFIER, "");
    }

    private void logSettings(JSONObject object, String string2) {
        Logger logger = Logger.getLogger();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        object = object.toString();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        logger.d((String)object);
    }

    private boolean setStoredBuildInstanceIdentifier(String string2) {
        SharedPreferences.Editor editor = CommonUtils.getSharedPrefs(this.context).edit();
        editor.putString(PREFS_BUILD_INSTANCE_IDENTIFIER, string2);
        editor.apply();
        return true;
    }

    public boolean buildInstanceIdentifierChanged() {
        String string2 = this.getStoredBuildInstanceIdentifier();
        String string3 = this.settingsRequest.instanceId;
        return string2.equals(string3) ^ true;
    }

    public Task getAppSettings() {
        return ((TaskCompletionSource)this.appSettingsData.get()).getTask();
    }

    public Settings getSettings() {
        return (Settings)this.settings.get();
    }

    public Task loadSettingsData(SettingsCacheBehavior object, Executor object2) {
        Object object3;
        boolean bl2 = this.buildInstanceIdentifierChanged();
        if (!bl2 && (object = this.getCachedSettingsData((SettingsCacheBehavior)((Object)object))) != null) {
            this.settings.set(object);
            object2 = (TaskCompletionSource)this.appSettingsData.get();
            object = ((SettingsData)object).getAppSettingsData();
            ((TaskCompletionSource)object2).trySetResult(object);
            return Tasks.forResult(null);
        }
        object = SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION;
        if ((object = this.getCachedSettingsData((SettingsCacheBehavior)((Object)object))) != null) {
            this.settings.set(object);
            object3 = (TaskCompletionSource)this.appSettingsData.get();
            object = ((SettingsData)object).getAppSettingsData();
            ((TaskCompletionSource)object3).trySetResult(object);
        }
        object = this.dataCollectionArbiter.waitForDataCollectionPermission();
        object3 = new SettingsController$1(this);
        return ((Task)object).onSuccessTask((Executor)object2, (SuccessContinuation)object3);
    }

    public Task loadSettingsData(Executor executor) {
        SettingsCacheBehavior settingsCacheBehavior = SettingsCacheBehavior.USE_CACHE;
        return this.loadSettingsData(settingsCacheBehavior, executor);
    }
}

