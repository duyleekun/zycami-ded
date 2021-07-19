/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.mlkit.common.model;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;

public class RemoteModel {
    private static final Map zzd;
    private static final Map zze;
    private final String zza;
    private final BaseModel zzb;
    private final ModelType zzc;
    private String zzf;

    static {
        EnumMap enumMap;
        Class<BaseModel> clazz = BaseModel.class;
        zzd = enumMap = new EnumMap(clazz);
        zze = enumMap = new EnumMap(clazz);
    }

    public RemoteModel(String string2, BaseModel baseModel, ModelType modelType) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl3 = true;
        boolean bl4 = baseModel != null ? bl3 : false;
        if (bl2 != bl4) {
            bl3 = false;
        }
        Preconditions.checkArgument(bl3, "One of cloud model name and base model cannot be empty");
        this.zza = string2;
        this.zzb = baseModel;
        this.zzc = modelType;
    }

    public boolean baseModelHashMatches(String string2) {
        BaseModel baseModel = this.zzb;
        if (baseModel == null) {
            return false;
        }
        baseModel = zzd.get((Object)baseModel);
        return string2.equals((Object)baseModel);
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        if (object != null && (bl2 = (object3 = object.getClass()).equals(object2 = this.getClass()))) {
            boolean bl4;
            object = (RemoteModel)object;
            object3 = this.zza;
            object2 = ((RemoteModel)object).zza;
            bl2 = Objects.equal(object3, object2);
            if (bl2 && (bl4 = Objects.equal(object3 = this.zzb, object = ((RemoteModel)object).zzb))) {
                return bl3;
            }
        }
        return false;
    }

    public String getModelHash() {
        return this.zzf;
    }

    public String getModelName() {
        return this.zza;
    }

    public String getModelNameForBackend() {
        Object object = this.zza;
        if (object != null) {
            return object;
        }
        object = zze;
        BaseModel baseModel = this.zzb;
        return (String)object.get((Object)baseModel);
    }

    public ModelType getModelType() {
        return this.zzc;
    }

    public String getUniqueModelNameForPersist() {
        String string2 = this.zza;
        if (string2 != null) {
            return string2;
        }
        string2 = "COM.GOOGLE.BASE_";
        Object object = zze;
        BaseModel baseModel = this.zzb;
        int n10 = ((String)(object = String.valueOf((String)object.get((Object)baseModel)))).length();
        if (n10 != 0) {
            return string2.concat((String)object);
        }
        object = new String(string2);
        return object;
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Object object = this.zza;
        objectArray[0] = object;
        object = this.zzb;
        objectArray[1] = object;
        return Objects.hashCode(objectArray);
    }

    public boolean isBaseModel() {
        BaseModel baseModel = this.zzb;
        return baseModel != null;
    }

    public void setModelHash(String string2) {
        this.zzf = string2;
    }
}

