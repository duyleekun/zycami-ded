/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.SystemClock
 */
package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.zzn;
import java.util.UUID;

public class SharedPrefManager {
    public static final Component COMPONENT;
    public static final String PREF_FILE = "com.google.mlkit.internal";
    private final Context zza;

    static {
        Component$Builder component$Builder = Component.builder(SharedPrefManager.class);
        Object object = Dependency.required(MlKitContext.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = Dependency.required(Context.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = zzn.zza;
        COMPONENT = component$Builder.factory((ComponentFactory)object).build();
    }

    private SharedPrefManager(Context context) {
        this.zza = context;
    }

    public static SharedPrefManager getInstance(MlKitContext mlKitContext) {
        return (SharedPrefManager)mlKitContext.get(SharedPrefManager.class);
    }

    private final SharedPreferences zza() {
        return this.zza.getSharedPreferences(PREF_FILE, 0);
    }

    public static final /* synthetic */ SharedPrefManager zza(ComponentContainer componentContainer) {
        componentContainer = (Context)componentContainer.get(Context.class);
        SharedPrefManager sharedPrefManager = new SharedPrefManager((Context)componentContainer);
        return sharedPrefManager;
    }

    public void clearDownloadingModelInfo(RemoteModel object) {
        synchronized (this) {
            String string2 = this.getDownloadingModelHash((RemoteModel)object);
            Object object2 = this.zza();
            object2 = object2.edit();
            Object[] objectArray = "downloading_model_id_%s";
            int n10 = 1;
            Object object3 = new Object[n10];
            String string3 = ((RemoteModel)object).getUniqueModelNameForPersist();
            object3[0] = string3;
            objectArray = String.format((String)objectArray, object3);
            object2 = object2.remove((String)objectArray);
            objectArray = "downloading_model_hash_%s";
            object3 = new Object[n10];
            string3 = ((RemoteModel)object).getUniqueModelNameForPersist();
            object3[0] = string3;
            objectArray = String.format((String)objectArray, object3);
            object2 = object2.remove((String)objectArray);
            objectArray = "downloading_model_type_%s";
            object3 = new Object[n10];
            object3[0] = string2;
            string2 = String.format((String)objectArray, object3);
            string2 = object2.remove(string2);
            object2 = "downloading_begin_time_%s";
            objectArray = new Object[n10];
            object3 = ((RemoteModel)object).getUniqueModelNameForPersist();
            objectArray[0] = object3;
            object2 = String.format((String)object2, objectArray);
            string2 = string2.remove((String)object2);
            object2 = "model_first_use_time_%s";
            objectArray = new Object[n10];
            object = ((RemoteModel)object).getUniqueModelNameForPersist();
            objectArray[0] = object;
            object = String.format((String)object2, objectArray);
            object = string2.remove((String)object);
            object.apply();
            return;
        }
    }

    public void clearIncompatibleModelInfo(RemoteModel object) {
        synchronized (this) {
            Object object2 = this.zza();
            object2 = object2.edit();
            String string2 = "bad_hash_%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            object = ((RemoteModel)object).getUniqueModelNameForPersist();
            objectArray[0] = object;
            object = String.format(string2, objectArray);
            object = object2.remove((String)object);
            object2 = "app_version";
            object = object.remove((String)object2);
            object.apply();
            return;
        }
    }

    public void clearLatestModelHash(RemoteModel object) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.zza();
            sharedPreferences = sharedPreferences.edit();
            String string2 = "current_model_hash_%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            object = ((RemoteModel)object).getUniqueModelNameForPersist();
            objectArray[0] = object;
            object = String.format(string2, objectArray);
            object = sharedPreferences.remove((String)object);
            object.commit();
            return;
        }
    }

    public String getCachedLocalModelHash(LocalModel object, long l10) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.zza();
            String string2 = "cached_local_model_hash_%1s_%2s";
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            String string3 = ((LocalModel)object).getAbsoluteFilePath();
            object = string3 != null ? ((LocalModel)object).getAbsoluteFilePath() : ((LocalModel)object).getAssetFilePath();
            objectArray[0] = object;
            int n11 = 1;
            Long l11 = l10;
            objectArray[n11] = l11;
            object = String.format(string2, objectArray);
            l11 = null;
            object = sharedPreferences.getString((String)object, null);
            return object;
        }
    }

    public String getDownloadingModelHash(RemoteModel object) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.zza();
            String string2 = "downloading_model_hash_%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = ((RemoteModel)object).getUniqueModelNameForPersist();
            object = String.format(string2, objectArray);
            string2 = null;
            object = sharedPreferences.getString((String)object, null);
            return object;
        }
    }

    public Long getDownloadingModelId(RemoteModel object) {
        synchronized (this) {
            long l10;
            block10: {
                SharedPreferences sharedPreferences = this.zza();
                String string2 = "downloading_model_id_%s";
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                object = ((RemoteModel)object).getUniqueModelNameForPersist();
                objectArray[0] = object;
                object = String.format(string2, objectArray);
                long l11 = -1;
                l10 = sharedPreferences.getLong((String)object, l11);
                long l12 = 0L;
                long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                if (l13 >= 0) break block10;
                return null;
            }
            object = l10;
            return object;
        }
    }

    public String getIncompatibleModelHash(RemoteModel object) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.zza();
            String string2 = "bad_hash_%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = ((RemoteModel)object).getUniqueModelNameForPersist();
            object = String.format(string2, objectArray);
            string2 = null;
            object = sharedPreferences.getString((String)object, null);
            return object;
        }
    }

    public String getLatestModelHash(RemoteModel object) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.zza();
            String string2 = "current_model_hash_%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = ((RemoteModel)object).getUniqueModelNameForPersist();
            object = String.format(string2, objectArray);
            string2 = null;
            object = sharedPreferences.getString((String)object, null);
            return object;
        }
    }

    public String getMlSdkInstanceId() {
        synchronized (this) {
            String string2;
            String string3;
            Object object;
            block10: {
                object = this.zza();
                string3 = "ml_sdk_instance_id";
                string2 = null;
                object = object.getString(string3, null);
                if (object == null) break block10;
                return object;
            }
            object = UUID.randomUUID();
            object = ((UUID)object).toString();
            string3 = this.zza();
            string3 = string3.edit();
            string2 = "ml_sdk_instance_id";
            string3 = string3.putString(string2, (String)object);
            string3.apply();
            return object;
        }
    }

    public long getModelDownloadBeginTimeMs(RemoteModel object) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.zza();
            String string2 = "downloading_begin_time_%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = ((RemoteModel)object).getUniqueModelNameForPersist();
            object = String.format(string2, objectArray);
            long l10 = 0L;
            long l11 = sharedPreferences.getLong((String)object, l10);
            return l11;
        }
    }

    public long getModelFirstUseTimeMs(RemoteModel object) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.zza();
            String string2 = "model_first_use_time_%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = ((RemoteModel)object).getUniqueModelNameForPersist();
            object = String.format(string2, objectArray);
            long l10 = 0L;
            long l11 = sharedPreferences.getLong((String)object, l10);
            return l11;
        }
    }

    public String getPreviousAppVersion() {
        synchronized (this) {
            Object object = this.zza();
            String string2 = "app_version";
            object = object.getString(string2, null);
            return object;
        }
    }

    public void setCachedLocalModelHash(LocalModel object, long l10, String string2) {
        synchronized (this) {
            Object[] objectArray;
            String string3;
            SharedPreferences sharedPreferences;
            block15: {
                block14: {
                    sharedPreferences = this.zza();
                    sharedPreferences = sharedPreferences.edit();
                    string3 = "cached_local_model_hash_%1s_%2s";
                    int n10 = 2;
                    objectArray = new Object[n10];
                    String string4 = ((LocalModel)object).getAbsoluteFilePath();
                    if (string4 == null) break block14;
                    object = ((LocalModel)object).getAbsoluteFilePath();
                    break block15;
                }
                object = ((LocalModel)object).getAssetFilePath();
            }
            objectArray[0] = object;
            int n11 = 1;
            Long l11 = l10;
            objectArray[n11] = l11;
            object = String.format(string3, objectArray);
            object = sharedPreferences.putString((String)object, string2);
            object.apply();
            return;
        }
    }

    public void setDownloadingModelInfo(long l10, ModelInfo objectArray) {
        synchronized (this) {
            String string2 = objectArray.getModelNameForPersist();
            objectArray = objectArray.getModelHash();
            Object object = this.zza();
            object = object.edit();
            Object[] objectArray2 = "downloading_model_hash_%s";
            int n10 = 1;
            Object[] objectArray3 = new Object[n10];
            objectArray3[0] = string2;
            objectArray2 = String.format((String)objectArray2, objectArray3);
            objectArray = object.putString((String)objectArray2, (String)objectArray);
            object = "downloading_model_id_%s";
            objectArray2 = new Object[n10];
            objectArray2[0] = string2;
            object = String.format((String)object, objectArray2);
            SharedPreferences.Editor editor = objectArray.putLong((String)object, l10);
            String string3 = "downloading_begin_time_%s";
            objectArray = new Object[n10];
            objectArray[0] = string2;
            string3 = String.format(string3, objectArray);
            long l11 = SystemClock.elapsedRealtime();
            editor = editor.putLong(string3, l11);
            editor.apply();
            return;
        }
    }

    public void setIncompatibleModelInfo(RemoteModel object, String string2, String string3) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.zza();
            sharedPreferences = sharedPreferences.edit();
            String string4 = "bad_hash_%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            object = ((RemoteModel)object).getUniqueModelNameForPersist();
            objectArray[0] = object;
            object = String.format(string4, objectArray);
            object = sharedPreferences.putString((String)object, string2);
            string2 = "app_version";
            object = object.putString(string2, string3);
            object.apply();
            return;
        }
    }

    public void setLatestModelHash(RemoteModel object, String string2) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.zza();
            sharedPreferences = sharedPreferences.edit();
            String string3 = "current_model_hash_%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            object = ((RemoteModel)object).getUniqueModelNameForPersist();
            objectArray[0] = object;
            object = String.format(string3, objectArray);
            object = sharedPreferences.putString((String)object, string2);
            object.apply();
            return;
        }
    }

    public void setModelFirstUseTimeMs(RemoteModel object, long l10) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.zza();
            sharedPreferences = sharedPreferences.edit();
            String string2 = "model_first_use_time_%s";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            object = ((RemoteModel)object).getUniqueModelNameForPersist();
            objectArray[0] = object;
            object = String.format(string2, objectArray);
            object = sharedPreferences.putLong((String)object, l10);
            object.apply();
            return;
        }
    }
}

