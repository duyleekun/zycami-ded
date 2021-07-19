/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.crashlytics.internal.common.InstallerPackageNameProvider;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

public class IdManager
implements InstallIdProvider {
    public static final String DEFAULT_VERSION_NAME = "0.0";
    private static final String FORWARD_SLASH_REGEX;
    private static final Pattern ID_PATTERN;
    public static final String PREFKEY_ADVERTISING_ID = "crashlytics.advertising.id";
    public static final String PREFKEY_FIREBASE_IID = "firebase.installation.id";
    public static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
    public static final String PREFKEY_LEGACY_INSTALLATION_UUID = "crashlytics.installation.id";
    private final Context appContext;
    private final String appIdentifier;
    private String crashlyticsInstallId;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final InstallerPackageNameProvider installerPackageNameProvider;

    static {
        ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
        FORWARD_SLASH_REGEX = Pattern.quote("/");
    }

    public IdManager(Context object, String string2, FirebaseInstallationsApi firebaseInstallationsApi) {
        if (object != null) {
            if (string2 != null) {
                this.appContext = object;
                this.appIdentifier = string2;
                this.firebaseInstallationsApi = firebaseInstallationsApi;
                this.installerPackageNameProvider = object;
                return;
            }
            super("appIdentifier must not be null");
            throw object;
        }
        super("appContext must not be null");
        throw object;
    }

    private String createAndStoreIid(String string2, SharedPreferences sharedPreferences) {
        synchronized (this) {
            Object object = UUID.randomUUID();
            object = ((UUID)object).toString();
            object = IdManager.formatId((String)object);
            Object object2 = Logger.getLogger();
            CharSequence charSequence = new StringBuilder();
            String string3 = "Created new Crashlytics installation ID: ";
            charSequence.append(string3);
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            ((Logger)object2).v((String)charSequence);
            sharedPreferences = sharedPreferences.edit();
            object2 = "crashlytics.installation.id";
            sharedPreferences = sharedPreferences.putString((String)object2, (String)object);
            object2 = PREFKEY_FIREBASE_IID;
            string2 = sharedPreferences.putString((String)object2, string2);
            string2.apply();
            return object;
        }
    }

    private static String formatId(String string2) {
        if (string2 == null) {
            string2 = null;
        } else {
            string2 = ID_PATTERN.matcher(string2).replaceAll("");
            Locale locale = Locale.US;
            string2 = string2.toLowerCase(locale);
        }
        return string2;
    }

    private void migrateLegacyId(String string2, String string3, SharedPreferences object, SharedPreferences sharedPreferences) {
        synchronized (this) {
            Object object2 = Logger.getLogger();
            CharSequence charSequence = new StringBuilder();
            String string4 = "Migrating legacy Crashlytics installation ID: ";
            charSequence.append(string4);
            charSequence.append(string2);
            charSequence = charSequence.toString();
            ((Logger)object2).v((String)charSequence);
            object = object.edit();
            object2 = "crashlytics.installation.id";
            string2 = object.putString((String)object2, string2);
            object = PREFKEY_FIREBASE_IID;
            string2 = string2.putString((String)object, string3);
            string2.apply();
            string2 = sharedPreferences.edit();
            string3 = "crashlytics.installation.id";
            string2 = string2.remove(string3);
            string3 = PREFKEY_ADVERTISING_ID;
            string2 = string2.remove(string3);
            string2.apply();
            return;
        }
    }

    private String removeForwardSlashesIn(String string2) {
        String string3 = FORWARD_SLASH_REGEX;
        return string2.replaceAll(string3, "");
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String getCrashlyticsInstallId() {
        synchronized (this) {
            String string2;
            Object object;
            Object object2 = this.crashlyticsInstallId;
            if (object2 != null) {
                return object2;
            }
            object2 = Logger.getLogger();
            Object object3 = "Determining Crashlytics installation ID...";
            ((Logger)object2).v((String)object3);
            object2 = this.appContext;
            object2 = CommonUtils.getSharedPrefs((Context)object2);
            object3 = this.firebaseInstallationsApi;
            object3 = object3.getId();
            Object object4 = PREFKEY_FIREBASE_IID;
            String string3 = null;
            object4 = object2.getString((String)object4, null);
            try {
                object3 = Utils.awaitEvenIfOnMainThread((Task)object3);
                object3 = (String)object3;
            }
            catch (Exception exception) {
                object = Logger.getLogger();
                string2 = "Failed to retrieve Firebase Installations ID.";
                ((Logger)object).w(string2, exception);
                object3 = object4 != null ? object4 : null;
            }
            if (object4 == null) {
                object4 = Logger.getLogger();
                object = "No cached Firebase Installations ID found.";
                ((Logger)object4).v((String)object);
                object4 = this.appContext;
                object4 = CommonUtils.getLegacySharedPrefs((Context)object4);
                object = "crashlytics.installation.id";
                string3 = object4.getString((String)object, null);
                if (string3 == null) {
                    object4 = Logger.getLogger();
                    string3 = "No legacy Crashlytics installation ID found, creating new ID.";
                    ((Logger)object4).v(string3);
                    this.crashlyticsInstallId = object2 = this.createAndStoreIid((String)object3, (SharedPreferences)object2);
                } else {
                    object = Logger.getLogger();
                    string2 = "A legacy Crashlytics installation ID was found. Upgrading.";
                    ((Logger)object).v(string2);
                    this.crashlyticsInstallId = string3;
                    this.migrateLegacyId(string3, (String)object3, (SharedPreferences)object2, (SharedPreferences)object4);
                }
            } else {
                boolean bl2 = ((String)object4).equals(object3);
                if (bl2) {
                    object4 = "crashlytics.installation.id";
                    this.crashlyticsInstallId = object4 = object2.getString((String)object4, null);
                    object4 = Logger.getLogger();
                    string3 = "Firebase Installations ID is unchanged from previous startup.";
                    ((Logger)object4).v(string3);
                    object4 = this.crashlyticsInstallId;
                    if (object4 == null) {
                        object4 = Logger.getLogger();
                        string3 = "Crashlytics installation ID was null, creating new ID.";
                        ((Logger)object4).v(string3);
                        this.crashlyticsInstallId = object2 = this.createAndStoreIid((String)object3, (SharedPreferences)object2);
                    }
                } else {
                    this.crashlyticsInstallId = object2 = this.createAndStoreIid((String)object3, (SharedPreferences)object2);
                }
            }
            object2 = Logger.getLogger();
            object3 = new StringBuilder();
            object4 = "Crashlytics installation ID is ";
            ((StringBuilder)object3).append((String)object4);
            object4 = this.crashlyticsInstallId;
            ((StringBuilder)object3).append((String)object4);
            object3 = ((StringBuilder)object3).toString();
            ((Logger)object2).v((String)object3);
            return this.crashlyticsInstallId;
        }
    }

    public String getInstallerPackageName() {
        InstallerPackageNameProvider installerPackageNameProvider = this.installerPackageNameProvider;
        Context context = this.appContext;
        return installerPackageNameProvider.getInstallerPackageName(context);
    }

    public String getModelName() {
        Locale locale = Locale.US;
        Object[] objectArray = new Object[2];
        String string2 = Build.MANUFACTURER;
        string2 = this.removeForwardSlashesIn(string2);
        objectArray[0] = string2;
        string2 = Build.MODEL;
        string2 = this.removeForwardSlashesIn(string2);
        objectArray[1] = string2;
        return String.format(locale, "%s/%s", objectArray);
    }

    public String getOsBuildVersionString() {
        String string2 = Build.VERSION.INCREMENTAL;
        return this.removeForwardSlashesIn(string2);
    }

    public String getOsDisplayVersionString() {
        String string2 = Build.VERSION.RELEASE;
        return this.removeForwardSlashesIn(string2);
    }
}

