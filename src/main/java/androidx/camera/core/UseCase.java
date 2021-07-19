/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Size
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase$1;
import androidx.camera.core.UseCase$State;
import androidx.camera.core.UseCase$StateChangeCallback;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfig$Builder;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.core.util.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public abstract class UseCase {
    private Size mAttachedResolution;
    private SessionConfig mAttachedSessionConfig;
    private CameraInternal mCamera;
    private UseCaseConfig mCameraConfig;
    private final Object mCameraLock;
    private UseCaseConfig mCurrentConfig;
    private UseCaseConfig mExtendedConfig;
    private UseCase$State mState;
    private final Set mStateChangeCallbacks;
    private UseCaseConfig mUseCaseConfig;
    private Rect mViewPortCropRect;

    public UseCase(UseCaseConfig useCaseConfig) {
        Object object = new HashSet();
        this.mStateChangeCallbacks = object;
        this.mCameraLock = object = new Object();
        object = UseCase$State.INACTIVE;
        this.mState = object;
        object = SessionConfig.defaultEmptySessionConfig();
        this.mAttachedSessionConfig = object;
        this.mUseCaseConfig = useCaseConfig;
        this.mCurrentConfig = useCaseConfig;
    }

    private void addStateChangeCallback(UseCase$StateChangeCallback useCase$StateChangeCallback) {
        this.mStateChangeCallbacks.add(useCase$StateChangeCallback);
    }

    private void removeStateChangeCallback(UseCase$StateChangeCallback useCase$StateChangeCallback) {
        this.mStateChangeCallbacks.remove(useCase$StateChangeCallback);
    }

    public Size getAttachedSurfaceResolution() {
        return this.mAttachedResolution;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraInternal getCamera() {
        Object object = this.mCameraLock;
        synchronized (object) {
            return this.mCamera;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraControlInternal getCameraControl() {
        Object object = this.mCameraLock;
        synchronized (object) {
            CameraInternal cameraInternal = this.mCamera;
            if (cameraInternal != null) return cameraInternal.getCameraControlInternal();
            return CameraControlInternal.DEFAULT_EMPTY_INSTANCE;
        }
    }

    public String getCameraId() {
        CameraInternal cameraInternal = this.getCamera();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("No camera attached to use case: ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        return ((CameraInternal)Preconditions.checkNotNull(cameraInternal, charSequence)).getCameraInfoInternal().getCameraId();
    }

    public UseCaseConfig getCurrentConfig() {
        return this.mCurrentConfig;
    }

    public abstract UseCaseConfig getDefaultConfig(boolean var1, UseCaseConfigFactory var2);

    public int getImageFormat() {
        return this.mCurrentConfig.getInputFormat();
    }

    public String getName() {
        UseCaseConfig useCaseConfig = this.mCurrentConfig;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("<UnknownUseCase-");
        int n10 = this.hashCode();
        charSequence.append(n10);
        charSequence.append(">");
        charSequence = charSequence.toString();
        return useCaseConfig.getTargetName((String)charSequence);
    }

    public int getRelativeRotation(CameraInternal object) {
        object = object.getCameraInfoInternal();
        int n10 = this.getTargetRotationInternal();
        return object.getSensorRotationDegrees(n10);
    }

    public SessionConfig getSessionConfig() {
        return this.mAttachedSessionConfig;
    }

    public int getTargetRotationInternal() {
        return ((ImageOutputConfig)((Object)this.mCurrentConfig)).getTargetRotation(0);
    }

    public abstract UseCaseConfig$Builder getUseCaseConfigBuilder(Config var1);

    public Rect getViewPortCropRect() {
        return this.mViewPortCropRect;
    }

    public boolean isCurrentCamera(String string2) {
        Object object = this.getCamera();
        if (object == null) {
            return false;
        }
        object = this.getCameraId();
        return Objects.equals(string2, object);
    }

    public UseCaseConfig mergeConfigs(CameraInfoInternal cameraInfoInternal, UseCaseConfig object, UseCaseConfig config) {
        boolean bl2;
        boolean bl3;
        Object object2;
        Object object3;
        Config$Option config$Option;
        boolean bl4;
        Iterator iterator2;
        if (config != null) {
            config = MutableOptionsBundle.from(config);
            iterator2 = TargetConfig.OPTION_TARGET_NAME;
            ((MutableOptionsBundle)config).removeOption((Config$Option)((Object)iterator2));
        } else {
            config = MutableOptionsBundle.create();
        }
        iterator2 = this.mUseCaseConfig.listOptions().iterator();
        while (bl4 = iterator2.hasNext()) {
            config$Option = (Config$Option)iterator2.next();
            object3 = this.mUseCaseConfig.getOptionPriority(config$Option);
            object2 = this.mUseCaseConfig.retrieveOption(config$Option);
            ((MutableOptionsBundle)config).insertOption(config$Option, (Config$OptionPriority)((Object)object3), object2);
        }
        if (object != null) {
            iterator2 = object.listOptions().iterator();
            while (bl4 = iterator2.hasNext()) {
                config$Option = (Config$Option)iterator2.next();
                object3 = config$Option.getId();
                boolean bl5 = ((String)object3).equals(object2 = TargetConfig.OPTION_TARGET_NAME.getId());
                if (bl5) continue;
                object3 = object.getOptionPriority(config$Option);
                object2 = object.retrieveOption(config$Option);
                ((MutableOptionsBundle)config).insertOption(config$Option, (Config$OptionPriority)((Object)object3), object2);
            }
        }
        if ((bl3 = ((OptionsBundle)config).containsOption((Config$Option)(object = ImageOutputConfig.OPTION_TARGET_RESOLUTION))) && (bl2 = ((OptionsBundle)config).containsOption((Config$Option)(object = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)))) {
            ((MutableOptionsBundle)config).removeOption((Config$Option)object);
        }
        object = this.getUseCaseConfigBuilder(config);
        return this.onMergeConfig(cameraInfoInternal, (UseCaseConfig$Builder)object);
    }

    public final void notifyActive() {
        UseCase$State useCase$State;
        this.mState = useCase$State = UseCase$State.ACTIVE;
        this.notifyState();
    }

    public final void notifyInactive() {
        UseCase$State useCase$State;
        this.mState = useCase$State = UseCase$State.INACTIVE;
        this.notifyState();
    }

    public final void notifyReset() {
        boolean bl2;
        Iterator iterator2 = this.mStateChangeCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            UseCase$StateChangeCallback useCase$StateChangeCallback = (UseCase$StateChangeCallback)iterator2.next();
            useCase$StateChangeCallback.onUseCaseReset(this);
        }
    }

    public final void notifyState() {
        block3: {
            int n10;
            Object object;
            Object object2;
            block2: {
                object2 = UseCase$1.$SwitchMap$androidx$camera$core$UseCase$State;
                object = this.mState;
                n10 = ((Enum)object).ordinal();
                int n11 = object2[n10];
                if (n11 == (n10 = 1)) break block2;
                n10 = 2;
                if (n11 != n10) break block3;
                object2 = this.mStateChangeCallbacks.iterator();
                while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    object = (UseCase$StateChangeCallback)object2.next();
                    object.onUseCaseActive(this);
                }
                break block3;
            }
            object2 = this.mStateChangeCallbacks.iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object = (UseCase$StateChangeCallback)object2.next();
                object.onUseCaseInactive(this);
            }
        }
    }

    public final void notifyUpdated() {
        boolean bl2;
        Iterator iterator2 = this.mStateChangeCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            UseCase$StateChangeCallback useCase$StateChangeCallback = (UseCase$StateChangeCallback)iterator2.next();
            useCase$StateChangeCallback.onUseCaseUpdated(this);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onAttach(CameraInternal object, UseCaseConfig object2, UseCaseConfig useCaseConfig) {
        Object object3 = this.mCameraLock;
        synchronized (object3) {
            this.mCamera = object;
            this.addStateChangeCallback((UseCase$StateChangeCallback)object);
        }
        this.mExtendedConfig = object2;
        this.mCameraConfig = useCaseConfig;
        object2 = object.getCameraInfoInternal();
        useCaseConfig = this.mExtendedConfig;
        object3 = this.mCameraConfig;
        this.mCurrentConfig = object2 = this.mergeConfigs((CameraInfoInternal)object2, useCaseConfig, (UseCaseConfig)object3);
        useCaseConfig = null;
        object2 = object2.getUseCaseEventCallback(null);
        if (object2 != null) {
            object = object.getCameraInfoInternal();
            object2.onAttach((CameraInfo)object);
        }
        this.onAttached();
    }

    public void onAttached() {
    }

    public void onCameraControlReady() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDetach(CameraInternal object) {
        this.onDetached();
        Object object2 = this.mCurrentConfig.getUseCaseEventCallback(null);
        if (object2 != null) {
            object2.onDetach();
        }
        object2 = this.mCameraLock;
        synchronized (object2) {
            boolean bl2;
            CameraInternal cameraInternal = this.mCamera;
            if (object == cameraInternal) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            Preconditions.checkArgument(bl2);
            object = this.mCamera;
            this.removeStateChangeCallback((UseCase$StateChangeCallback)object);
            this.mCamera = null;
        }
        this.mAttachedResolution = null;
        this.mViewPortCropRect = null;
        this.mCurrentConfig = object = this.mUseCaseConfig;
        this.mExtendedConfig = null;
        this.mCameraConfig = null;
    }

    public void onDetached() {
    }

    public UseCaseConfig onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig$Builder useCaseConfig$Builder) {
        return useCaseConfig$Builder.getUseCaseConfig();
    }

    public void onStateAttached() {
        this.onCameraControlReady();
    }

    public void onStateDetached() {
    }

    public abstract Size onSuggestedResolutionUpdated(Size var1);

    public boolean setTargetRotationInternal(int n10) {
        int n11;
        Object object = (ImageOutputConfig)((Object)this.getCurrentConfig());
        int n12 = object.getTargetRotation(n11 = -1);
        if (n12 != n11 && n12 == n10) {
            return false;
        }
        object = this.mUseCaseConfig;
        object = this.getUseCaseConfigBuilder((Config)object);
        UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs((UseCaseConfig$Builder)object, n10);
        Object object2 = object.getUseCaseConfig();
        this.mUseCaseConfig = object2;
        object2 = this.getCamera();
        if (object2 == null) {
            this.mCurrentConfig = object2 = this.mUseCaseConfig;
        } else {
            object2 = object2.getCameraInfoInternal();
            object = this.mExtendedConfig;
            UseCaseConfig useCaseConfig = this.mCameraConfig;
            this.mCurrentConfig = object2 = this.mergeConfigs((CameraInfoInternal)object2, (UseCaseConfig)object, useCaseConfig);
        }
        return true;
    }

    public void setViewPortCropRect(Rect rect) {
        this.mViewPortCropRect = rect;
    }

    public void updateSessionConfig(SessionConfig sessionConfig) {
        this.mAttachedSessionConfig = sessionConfig;
    }

    public void updateSuggestedResolution(Size size) {
        this.mAttachedResolution = size = this.onSuggestedResolutionUpdated(size);
    }
}

