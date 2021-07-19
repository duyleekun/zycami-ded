/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Rational
 *  android.util.Size
 */
package androidx.camera.core.internal;

import android.graphics.Rect;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraSelector$Builder;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraUseCaseAdapter$CameraException;
import androidx.camera.core.internal.CameraUseCaseAdapter$CameraId;
import androidx.camera.core.internal.CameraUseCaseAdapter$ConfigPair;
import androidx.camera.core.internal.ViewPorts;
import androidx.core.util.Preconditions;
import b.a.b.x1.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public final class CameraUseCaseAdapter
implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";
    private boolean mAttached;
    private CameraConfig mCameraConfig;
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;
    private CameraInternal mCameraInternal;
    private final LinkedHashSet mCameraInternals;
    private final CameraUseCaseAdapter$CameraId mId;
    private Config mInteropConfig;
    private final Object mLock;
    private final UseCaseConfigFactory mUseCaseConfigFactory;
    private final List mUseCases;
    private ViewPort mViewPort;

    public CameraUseCaseAdapter(LinkedHashSet object, CameraDeviceSurfaceManager cameraDeviceSurfaceManager, UseCaseConfigFactory useCaseConfigFactory) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.mUseCases = linkedHashSet;
        linkedHashSet = CameraConfigs.emptyConfig();
        this.mCameraConfig = linkedHashSet;
        linkedHashSet = new LinkedHashSet();
        this.mLock = linkedHashSet;
        this.mAttached = true;
        this.mInteropConfig = null;
        linkedHashSet = (CameraInternal)((HashSet)object).iterator().next();
        this.mCameraInternal = linkedHashSet;
        this.mCameraInternals = linkedHashSet = new LinkedHashSet(object);
        this.mId = object = new CameraUseCaseAdapter$CameraId(linkedHashSet);
        this.mCameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
    }

    public static /* synthetic */ void a(List list) {
        boolean bl2;
        Iterator iterator2 = list.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = ((UseCase)iterator2.next()).getCurrentConfig();
            List list2 = null;
            if ((object = object.getAttachedUseCasesUpdateListener(null)) == null) continue;
            list2 = Collections.unmodifiableList(list);
            object.accept(list2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void cacheInteropConfig() {
        Object object = this.mLock;
        synchronized (object) {
            Config config;
            Object object2 = this.mCameraInternal;
            object2 = object2.getCameraControlInternal();
            this.mInteropConfig = config = object2.getInteropConfig();
            object2.clearInteropConfig();
            return;
        }
    }

    private Map calculateSuggestedResolutions(CameraInfoInternal object, List object2, List object3, Map object4) {
        Object object5;
        UseCase useCase;
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = object.getCameraId();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        object3 = object3.iterator();
        while (bl2 = object3.hasNext()) {
            useCase = (UseCase)object3.next();
            object5 = this.mCameraDeviceSurfaceManager;
            int n10 = useCase.getImageFormat();
            Size size = useCase.getAttachedSurfaceResolution();
            object5 = object5.transformSurfaceConfig(string2, n10, size);
            arrayList.add(object5);
            object5 = useCase.getAttachedSurfaceResolution();
            hashMap.put(useCase, object5);
        }
        boolean bl3 = object2.isEmpty();
        if (!bl3) {
            object3 = new HashMap();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                useCase = (UseCase)object2.next();
                object5 = (CameraUseCaseAdapter$ConfigPair)object4.get(useCase);
                UseCaseConfig useCaseConfig = ((CameraUseCaseAdapter$ConfigPair)object5).mExtendedConfig;
                object5 = ((CameraUseCaseAdapter$ConfigPair)object5).mCameraConfig;
                object5 = useCase.mergeConfigs((CameraInfoInternal)object, useCaseConfig, (UseCaseConfig)object5);
                object3.put(object5, useCase);
            }
            object = this.mCameraDeviceSurfaceManager;
            object4 = object3.keySet();
            object2 = new ArrayList(object4);
            object = object.getSuggestedResolutions(string2, arrayList, (List)object2);
            object2 = object3.entrySet().iterator();
            while (bl3 = object2.hasNext()) {
                object3 = (Map.Entry)object2.next();
                object4 = (UseCase)object3.getValue();
                object3 = object3.getKey();
                object3 = (Size)object.get(object3);
                hashMap.put(object4, object3);
            }
        }
        return hashMap;
    }

    public static CameraUseCaseAdapter$CameraId generateCameraId(LinkedHashSet linkedHashSet) {
        CameraUseCaseAdapter$CameraId cameraUseCaseAdapter$CameraId = new CameraUseCaseAdapter$CameraId(linkedHashSet);
        return cameraUseCaseAdapter$CameraId;
    }

    private Map getConfigs(List object, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        boolean bl2;
        HashMap<UseCase, CameraUseCaseAdapter$ConfigPair> hashMap = new HashMap<UseCase, CameraUseCaseAdapter$ConfigPair>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            UseCase useCase = (UseCase)object.next();
            UseCaseConfig useCaseConfig = useCase.getDefaultConfig(false, useCaseConfigFactory);
            boolean bl3 = true;
            UseCaseConfig useCaseConfig2 = useCase.getDefaultConfig(bl3, useCaseConfigFactory2);
            CameraUseCaseAdapter$ConfigPair cameraUseCaseAdapter$ConfigPair = new CameraUseCaseAdapter$ConfigPair(useCaseConfig, useCaseConfig2);
            hashMap.put(useCase, cameraUseCaseAdapter$ConfigPair);
        }
        return hashMap;
    }

    private void notifyAttachedUseCasesChange(List list) {
        ScheduledExecutorService scheduledExecutorService = CameraXExecutors.mainThreadExecutor();
        a a10 = new a(list);
        scheduledExecutorService.execute(a10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void restoreInteropConfig() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mInteropConfig;
            if (object2 != null) {
                object2 = this.mCameraInternal;
                object2 = object2.getCameraControlInternal();
                Config config = this.mInteropConfig;
                object2.addInteropConfig(config);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateViewPort(Map map, Collection object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            Object object3 = this.mViewPort;
            if (object3 != null) {
                object3 = this.mCameraInternal;
                object3 = object3.getCameraInfoInternal();
                int n10 = (Integer)(object3 = object3.getLensFacing());
                if (!n10) {
                    n10 = 1;
                } else {
                    n10 = 0;
                    object3 = null;
                }
                object3 = this.mCameraInternal;
                object3 = object3.getCameraControlInternal();
                Object object4 = object3.getSensorRect();
                object3 = this.mViewPort;
                Rational rational = ((ViewPort)object3).getAspectRatio();
                object3 = this.mCameraInternal;
                object3 = object3.getCameraInfoInternal();
                ViewPort viewPort = this.mViewPort;
                int n11 = viewPort.getRotation();
                n11 = object3.getSensorRotationDegrees(n11);
                object3 = this.mViewPort;
                int n12 = ((ViewPort)object3).getScaleType();
                object3 = this.mViewPort;
                int n13 = ((ViewPort)object3).getLayoutDirection();
                map = ViewPorts.calculateViewPortRects(object4, n10 != 0, rational, n11, n12, n13, map);
                object = object.iterator();
                while (n10 = object.hasNext()) {
                    object3 = object.next();
                    object3 = (UseCase)object3;
                    object4 = map.get(object3);
                    object4 = Preconditions.checkNotNull(object4);
                    ((UseCase)object3).setViewPortCropRect((Rect)object4);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addUseCases(Collection object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            boolean bl2;
            Object object3;
            Object object4;
            boolean bl3;
            Object object5 = new ArrayList();
            Object object6 = object.iterator();
            while (bl3 = object6.hasNext()) {
                object4 = object6.next();
                object3 = this.mUseCases;
                bl2 = object3.contains(object4 = (UseCase)object4);
                if (bl2) {
                    object4 = TAG;
                    object3 = "Attempting to attach already attached UseCase";
                    Logger.d((String)object4, (String)object3);
                    continue;
                }
                object5.add(object4);
            }
            object6 = this.mCameraConfig;
            object6 = object6.getUseCaseConfigFactory();
            object4 = this.mUseCaseConfigFactory;
            object6 = this.getConfigs((List)object5, (UseCaseConfigFactory)object6, (UseCaseConfigFactory)object4);
            try {
                object4 = this.mCameraInternal;
                object4 = object4.getCameraInfoInternal();
                object3 = this.mUseCases;
                object4 = this.calculateSuggestedResolutions((CameraInfoInternal)object4, (List)object5, (List)object3, (Map)object6);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                String string2 = illegalArgumentException.getMessage();
                object5 = new CameraUseCaseAdapter$CameraException(string2);
                throw object5;
            }
            this.updateViewPort((Map)object4, (Collection)object);
            object = object5.iterator();
            while (bl2 = object.hasNext()) {
                object3 = object.next();
                object3 = (UseCase)object3;
                Object object7 = object6.get(object3);
                object7 = (CameraUseCaseAdapter$ConfigPair)object7;
                CameraInternal cameraInternal = this.mCameraInternal;
                UseCaseConfig useCaseConfig = ((CameraUseCaseAdapter$ConfigPair)object7).mExtendedConfig;
                object7 = ((CameraUseCaseAdapter$ConfigPair)object7).mCameraConfig;
                ((UseCase)object3).onAttach(cameraInternal, useCaseConfig, (UseCaseConfig)object7);
                object7 = object4.get(object3);
                object7 = (Size)object7;
                object7 = Preconditions.checkNotNull(object7);
                object7 = (Size)object7;
                ((UseCase)object3).updateSuggestedResolution((Size)object7);
            }
            object = this.mUseCases;
            object.addAll(object5);
            boolean bl4 = this.mAttached;
            if (bl4) {
                object = this.mUseCases;
                this.notifyAttachedUseCasesChange((List)object);
                object = this.mCameraInternal;
                object.attachUseCases((Collection)object5);
            }
            object = object5.iterator();
            boolean bl5;
            while (bl5 = object.hasNext()) {
                object5 = object.next();
                object5 = (UseCase)object5;
                ((UseCase)object5).notifyState();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void attachUseCases() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mAttached;
            if (!bl2) {
                boolean bl3;
                Iterator iterator2 = this.mCameraInternal;
                Object object2 = this.mUseCases;
                iterator2.attachUseCases((Collection)object2);
                iterator2 = this.mUseCases;
                this.notifyAttachedUseCasesChange((List)((Object)iterator2));
                this.restoreInteropConfig();
                iterator2 = this.mUseCases;
                iterator2 = iterator2.iterator();
                while (bl3 = iterator2.hasNext()) {
                    object2 = iterator2.next();
                    object2 = (UseCase)object2;
                    ((UseCase)object2).notifyState();
                }
                this.mAttached = bl2 = true;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void checkAttachUseCases(List list) {
        Object object = this.mLock;
        synchronized (object) {
            try {
                try {
                    Object object2 = this.mCameraConfig;
                    object2 = object2.getUseCaseConfigFactory();
                    Object object3 = this.mUseCaseConfigFactory;
                    object2 = this.getConfigs(list, (UseCaseConfigFactory)object2, (UseCaseConfigFactory)object3);
                    object3 = this.mCameraInternal;
                    object3 = object3.getCameraInfoInternal();
                    List list2 = Collections.emptyList();
                    this.calculateSuggestedResolutions((CameraInfoInternal)object3, list, list2, (Map)object2);
                    return;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    String string2 = illegalArgumentException.getMessage();
                    CameraUseCaseAdapter$CameraException cameraUseCaseAdapter$CameraException = new CameraUseCaseAdapter$CameraException(string2);
                    throw cameraUseCaseAdapter$CameraException;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void detachUseCases() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mAttached;
            if (bl2) {
                CameraInternal cameraInternal = this.mCameraInternal;
                List list = this.mUseCases;
                ArrayList arrayList = new ArrayList(list);
                cameraInternal.detachUseCases(arrayList);
                this.cacheInteropConfig();
                bl2 = false;
                cameraInternal = null;
                this.mAttached = false;
            }
            return;
        }
    }

    public CameraControl getCameraControl() {
        return this.mCameraInternal.getCameraControlInternal();
    }

    public CameraUseCaseAdapter$CameraId getCameraId() {
        return this.mId;
    }

    public CameraInfo getCameraInfo() {
        return this.mCameraInternal.getCameraInfoInternal();
    }

    public LinkedHashSet getCameraInternals() {
        return this.mCameraInternals;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraConfig getExtendedConfig() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mCameraConfig;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getUseCases() {
        Object object = this.mLock;
        synchronized (object) {
            List list = this.mUseCases;
            return new ArrayList(list);
        }
    }

    public boolean isEquivalent(CameraUseCaseAdapter object) {
        CameraUseCaseAdapter$CameraId cameraUseCaseAdapter$CameraId = this.mId;
        object = ((CameraUseCaseAdapter)object).getCameraId();
        return cameraUseCaseAdapter$CameraId.equals(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeUseCases(Collection collection) {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mCameraInternal;
            object2.detachUseCases(collection);
            object2 = collection.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object2.hasNext())) {
                    object2 = this.mUseCases;
                    object2.removeAll(collection);
                    return;
                }
                Object object3 = object2.next();
                Object object4 = this.mUseCases;
                boolean bl3 = object4.contains(object3 = (UseCase)object3);
                if (bl3) {
                    object4 = this.mCameraInternal;
                    ((UseCase)object3).onDetach((CameraInternal)object4);
                    continue;
                }
                object4 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "Attempting to detach non-attached UseCase: ";
                stringBuilder.append(string2);
                stringBuilder.append(object3);
                object3 = stringBuilder.toString();
                Logger.e((String)object4, (String)object3);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setExtendedConfig(CameraConfig cameraConfig) {
        Object object = this.mLock;
        synchronized (object) {
            Throwable throwable2;
            block12: {
                Object object2;
                boolean bl2;
                Object object3;
                if (cameraConfig == null) {
                    try {
                        cameraConfig = CameraConfigs.emptyConfig();
                    }
                    catch (Throwable throwable2) {
                        break block12;
                    }
                }
                Object object4 = cameraConfig.getCameraFilter();
                Object object5 = new CameraSelector$Builder();
                object4 = ((CameraSelector$Builder)object5).addCameraFilter((CameraFilter)object4);
                object4 = ((CameraSelector$Builder)object4).build();
                object5 = this.mCameraInternals;
                object4 = ((CameraSelector)object4).select((LinkedHashSet)object5);
                object5 = this.mUseCases;
                Object object6 = cameraConfig.getUseCaseConfigFactory();
                Iterator iterator2 = this.mUseCaseConfigFactory;
                object5 = this.getConfigs((List)object5, (UseCaseConfigFactory)object6, (UseCaseConfigFactory)((Object)iterator2));
                try {
                    object6 = object4.getCameraInfoInternal();
                    iterator2 = this.mUseCases;
                    object3 = Collections.emptyList();
                    object6 = this.calculateSuggestedResolutions((CameraInfoInternal)object6, (List)((Object)iterator2), (List)object3, (Map)object5);
                    iterator2 = this.mUseCases;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    String string2 = illegalArgumentException.getMessage();
                    object4 = new CameraUseCaseAdapter$CameraException(string2);
                    throw object4;
                }
                this.updateViewPort((Map)object6, (Collection)((Object)iterator2));
                boolean bl3 = this.mAttached;
                if (bl3) {
                    iterator2 = this.mCameraInternal;
                    object3 = this.mUseCases;
                    iterator2.detachUseCases((Collection)object3);
                }
                iterator2 = this.mUseCases;
                iterator2 = iterator2.iterator();
                while (bl2 = iterator2.hasNext()) {
                    object3 = iterator2.next();
                    object3 = (UseCase)object3;
                    object2 = this.mCameraInternal;
                    ((UseCase)object3).onDetach((CameraInternal)object2);
                }
                iterator2 = this.mUseCases;
                iterator2 = iterator2.iterator();
                while (bl2 = iterator2.hasNext()) {
                    object3 = iterator2.next();
                    object3 = (UseCase)object3;
                    object2 = object5.get(object3);
                    object2 = (CameraUseCaseAdapter$ConfigPair)object2;
                    UseCaseConfig useCaseConfig = ((CameraUseCaseAdapter$ConfigPair)object2).mExtendedConfig;
                    object2 = ((CameraUseCaseAdapter$ConfigPair)object2).mCameraConfig;
                    ((UseCase)object3).onAttach((CameraInternal)object4, useCaseConfig, (UseCaseConfig)object2);
                    object2 = object6.get(object3);
                    object2 = (Size)object2;
                    object2 = Preconditions.checkNotNull(object2);
                    object2 = (Size)object2;
                    ((UseCase)object3).updateSuggestedResolution((Size)object2);
                }
                boolean bl4 = this.mAttached;
                if (bl4) {
                    object5 = this.mUseCases;
                    this.notifyAttachedUseCasesChange((List)object5);
                    object5 = this.mUseCases;
                    object4.attachUseCases((Collection)object5);
                }
                object5 = this.mUseCases;
                object5 = object5.iterator();
                while (true) {
                    boolean bl5;
                    if (!(bl5 = object5.hasNext())) {
                        this.mCameraInternal = object4;
                        this.mCameraConfig = cameraConfig;
                        return;
                    }
                    object6 = object5.next();
                    object6 = (UseCase)object6;
                    ((UseCase)object6).notifyState();
                }
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setViewPort(ViewPort viewPort) {
        Object object = this.mLock;
        synchronized (object) {
            this.mViewPort = viewPort;
            return;
        }
    }
}

