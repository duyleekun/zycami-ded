/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.model.LocalModelLoader;
import com.google.mlkit.common.sdkinternal.model.ModelLoader$ModelContentHandler;
import com.google.mlkit.common.sdkinternal.model.ModelLoader$ModelLoadingLogger;
import com.google.mlkit.common.sdkinternal.model.ModelLoader$ModelLoadingState;
import com.google.mlkit.common.sdkinternal.model.RemoteModelLoader;
import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.util.List;

public class ModelLoader {
    private static final GmsLogger zza;
    public final LocalModelLoader localModelLoader;
    public ModelLoader$ModelLoadingState modelLoadingState;
    public final RemoteModelLoader remoteModelLoader;
    private final ModelLoader$ModelLoadingLogger zzb;

    static {
        GmsLogger gmsLogger;
        zza = gmsLogger = new GmsLogger("ModelLoader", "");
    }

    public ModelLoader(RemoteModelLoader remoteModelLoader, LocalModelLoader localModelLoader, ModelLoader$ModelLoadingLogger modelLoader$ModelLoadingLogger) {
        boolean bl2;
        ModelLoader$ModelLoadingState modelLoader$ModelLoadingState;
        this.modelLoadingState = modelLoader$ModelLoadingState = ModelLoader$ModelLoadingState.NO_MODEL_LOADED;
        if (remoteModelLoader == null && localModelLoader == null) {
            bl2 = false;
            modelLoader$ModelLoadingState = null;
        } else {
            bl2 = true;
        }
        Preconditions.checkArgument(bl2, "At least one of RemoteModelLoader or LocalModelLoader must be non-null.");
        Preconditions.checkNotNull(modelLoader$ModelLoadingLogger);
        this.remoteModelLoader = remoteModelLoader;
        this.localModelLoader = localModelLoader;
        this.zzb = modelLoader$ModelLoadingLogger;
    }

    /*
     * Unable to fully structure code
     */
    private final String zza() {
        var1_1 = this.localModelLoader;
        if (var1_1 == null) ** GOTO lbl-1000
        if ((var1_1 = var1_1.getLocalModel().getAssetFilePath()) != null) {
            var1_1 = this.localModelLoader.getLocalModel().getAssetFilePath();
        } else {
            var1_1 = this.localModelLoader.getLocalModel().getAbsoluteFilePath();
            if (var1_1 != null) {
                var1_1 = this.localModelLoader.getLocalModel().getAbsoluteFilePath();
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = null;
            }
        }
        var2_2 = this.remoteModelLoader;
        var2_2 = var2_2 == null ? "unspecified" : var2_2.getRemoteModel().getUniqueModelNameForPersist();
        var3_3 = new Object[]{var1_1, var2_2};
        return String.format("Local model path: %s. Remote model name: %s. ", var3_3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean zza(ModelLoader$ModelContentHandler object, List object2) {
        synchronized (this) {
            Object object3 = this.remoteModelLoader;
            if (object3 != null) {
                String string2;
                block7: {
                    try {
                        object3 = ((RemoteModelLoader)object3).load();
                        if (object3 == null) break block7;
                    }
                    catch (MlKitException mlKitException) {
                        object3 = zza;
                        String string3 = "ModelLoader";
                        String string4 = "Remote model source can NOT be loaded, try local model.";
                        ((GmsLogger)object3).d(string3, string4);
                        int n10 = 20;
                        object3 = n10;
                        string2.add(object3);
                        throw mlKitException;
                    }
                    try {
                        object.constructModel((MappedByteBuffer)object3);
                        object = zza;
                        string2 = "ModelLoader";
                        object3 = "Remote model source is loaded successfully";
                    }
                    catch (RuntimeException runtimeException) {
                        int n11 = 19;
                        object3 = n11;
                        string2.add(object3);
                        throw runtimeException;
                    }
                    ((GmsLogger)object).d(string2, (String)object3);
                    return true;
                }
                object = zza;
                object3 = "ModelLoader";
                String string5 = "Remote model source can NOT be loaded, try local model.";
                ((GmsLogger)object).d((String)object3, string5);
                int n12 = 21;
                object = n12;
                string2.add(object);
            }
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean zzb(ModelLoader$ModelContentHandler object, List object2) {
        synchronized (this) {
            Object object3 = this.localModelLoader;
            if (object3 != null && (object3 = ((LocalModelLoader)object3).load()) != null) {
                String string2;
                try {
                    object.constructModel((MappedByteBuffer)object3);
                    object = zza;
                    string2 = "ModelLoader";
                    object3 = "Local model source is loaded successfully";
                }
                catch (RuntimeException runtimeException) {
                    int n10 = 18;
                    object3 = n10;
                    string2.add(object3);
                    throw runtimeException;
                }
                ((GmsLogger)object).d(string2, (String)object3);
                return true;
            }
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isRemoteModelLoaded() {
        synchronized (this) {
            ModelLoader$ModelLoadingState modelLoader$ModelLoadingState = this.modelLoadingState;
            ModelLoader$ModelLoadingState modelLoader$ModelLoadingState2 = ModelLoader$ModelLoadingState.REMOTE_MODEL_LOADED;
            if (modelLoader$ModelLoadingState != modelLoader$ModelLoadingState2) return false;
            return true;
        }
    }

    public void loadWithModelContentHandler(ModelLoader$ModelContentHandler object) {
        synchronized (this) {
            int n10;
            String string2;
            Serializable serializable;
            block50: {
                String string3;
                block49: {
                    String string4;
                    int n11;
                    int n12;
                    block44: {
                        Throwable throwable;
                        block46: {
                            block45: {
                                serializable = new Serializable();
                                boolean bl2 = false;
                                string2 = null;
                                string3 = null;
                                try {
                                    n12 = this.zza((ModelLoader$ModelContentHandler)object, (List)((Object)serializable));
                                    n11 = 0;
                                    throwable = null;
                                }
                                catch (Exception exception) {
                                    n12 = 0;
                                    string4 = null;
                                }
                                if (n12 != 0) {
                                    object = this.zzb;
                                    object.logErrorCodes((List)((Object)serializable));
                                    object = ModelLoader$ModelLoadingState.REMOTE_MODEL_LOADED;
                                    this.modelLoadingState = object;
                                    return;
                                }
                                try {
                                    bl2 = this.zzb((ModelLoader$ModelContentHandler)object, (List)((Object)serializable));
                                }
                                catch (Exception exception) {
                                    // empty catch block
                                }
                                if (bl2) {
                                    object = this.zzb;
                                    object.logErrorCodes((List)((Object)serializable));
                                    object = ModelLoader$ModelLoadingState.LOCAL_MODEL_LOADED;
                                    this.modelLoadingState = object;
                                    return;
                                }
                                n10 = 17;
                                object = n10;
                                serializable.add(object);
                                object = this.zzb;
                                object.logErrorCodes((List)((Object)serializable));
                                object = ModelLoader$ModelLoadingState.NO_MODEL_LOADED;
                                this.modelLoadingState = object;
                                n10 = 14;
                                if (throwable == null) break block44;
                                string2 = "Remote model load failed with the model options: ";
                                string3 = this.zza();
                                string3 = String.valueOf(string3);
                                n12 = string3.length();
                                if (n12 == 0) break block45;
                                string2 = string2.concat(string3);
                                break block46;
                            }
                            string2 = string3 = new String(string2);
                        }
                        serializable = new Serializable(string2, n10, throwable);
                        throw serializable;
                    }
                    if (string3 != null) {
                        block48: {
                            block47: {
                                string2 = "Local model load failed with the model options: ";
                                string4 = this.zza();
                                string4 = String.valueOf(string4);
                                n11 = string4.length();
                                if (n11 == 0) break block47;
                                string2 = string2.concat(string4);
                                break block48;
                            }
                            string2 = string4 = new String(string2);
                        }
                        serializable = new Serializable(string2, n10, (Throwable)((Object)string3));
                        throw serializable;
                    }
                    string2 = "Cannot load any model with the model options: ";
                    string3 = this.zza();
                    string3 = String.valueOf(string3);
                    n12 = string3.length();
                    if (n12 == 0) break block49;
                    string2 = string2.concat(string3);
                    break block50;
                }
                string2 = string3 = new String(string2);
            }
            serializable = new Serializable(string2, n10);
            throw serializable;
        }
    }
}

