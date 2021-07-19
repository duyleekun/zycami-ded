/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraSelector$Builder;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.internal.CameraUseCaseAdapter$CameraId;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.camera.lifecycle.LifecycleCameraProvider;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import b.a.c.a;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.Executor;

public final class ProcessCameraProvider
implements LifecycleCameraProvider {
    private static final ProcessCameraProvider sAppInstance;
    private CameraX mCameraX;
    private final LifecycleCameraRepository mLifecycleCameraRepository;

    static {
        ProcessCameraProvider processCameraProvider;
        sAppInstance = processCameraProvider = new ProcessCameraProvider();
    }

    private ProcessCameraProvider() {
        LifecycleCameraRepository lifecycleCameraRepository;
        this.mLifecycleCameraRepository = lifecycleCameraRepository = new LifecycleCameraRepository();
    }

    public static /* synthetic */ ProcessCameraProvider a(CameraX cameraX) {
        ProcessCameraProvider processCameraProvider = sAppInstance;
        processCameraProvider.setCameraX(cameraX);
        return processCameraProvider;
    }

    public static void configureInstance(CameraXConfig cameraXConfig) {
        CameraX.configureInstance(cameraXConfig);
    }

    public static ListenableFuture getInstance(Context object) {
        Preconditions.checkNotNull(object);
        object = CameraX.getOrCreateInstance(object);
        a a10 = a.a;
        Executor executor = CameraXExecutors.directExecutor();
        return Futures.transform((ListenableFuture)object, a10, executor);
    }

    private void setCameraX(CameraX cameraX) {
        this.mCameraX = cameraX;
    }

    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseArray) {
        ViewPort viewPort = useCaseArray.getViewPort();
        useCaseArray = useCaseArray.getUseCases();
        UseCase[] useCaseArray2 = new UseCase[]{};
        useCaseArray = useCaseArray.toArray(useCaseArray2);
        return this.bindToLifecycle(lifecycleOwner, cameraSelector, viewPort, useCaseArray);
    }

    public Camera bindToLifecycle(LifecycleOwner object, CameraSelector object2, ViewPort viewPort, UseCase ... useCaseArray) {
        int n10;
        CameraFilter cameraFilter;
        int n11;
        Object object3;
        Threads.checkMainThread();
        object2 = CameraSelector$Builder.fromSelector((CameraSelector)object2);
        int n12 = useCaseArray.length;
        CameraUseCaseAdapter cameraUseCaseAdapter = null;
        Object object4 = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            object3 = useCaseArray[i10].getCurrentConfig();
            n11 = 0;
            cameraFilter = null;
            if ((object3 = object3.getCameraSelector(null)) == null) continue;
            object3 = ((CameraSelector)object3).getCameraFilterSet().iterator();
            while ((n11 = object3.hasNext()) != 0) {
                cameraFilter = (CameraFilter)object3.next();
                object2.addCameraFilter(cameraFilter);
            }
        }
        object2 = object2.build();
        Object object5 = this.mCameraX.getCameraRepository().getCameras();
        object2 = object2.filter((LinkedHashSet)object5);
        object5 = CameraUseCaseAdapter.generateCameraId((LinkedHashSet)object2);
        object5 = this.mLifecycleCameraRepository.getLifecycleCamera((LifecycleOwner)object, (CameraUseCaseAdapter$CameraId)object5);
        object4 = this.mLifecycleCameraRepository.getLifecycleCameras();
        int n13 = useCaseArray.length;
        cameraFilter = null;
        for (n11 = 0; n11 < n13; ++n11) {
            boolean bl2;
            UseCase useCase = useCaseArray[n11];
            Iterator iterator2 = object4.iterator();
            while (bl2 = iterator2.hasNext()) {
                LifecycleCamera lifecycleCamera = (LifecycleCamera)iterator2.next();
                boolean bl3 = lifecycleCamera.isBound(useCase);
                if (!bl3 || lifecycleCamera == object5) continue;
                object2 = new Object[]{useCase};
                object2 = String.format("Use case %s already bound to a different lifecycle.", object2);
                object = new IllegalStateException((String)object2);
                throw object;
            }
        }
        if (object5 == null) {
            object5 = this.mLifecycleCameraRepository;
            object4 = this.mCameraX.getCameraDeviceSurfaceManager();
            object3 = this.mCameraX.getDefaultConfigFactory();
            cameraUseCaseAdapter = new CameraUseCaseAdapter((LinkedHashSet)object2, (CameraDeviceSurfaceManager)object4, (UseCaseConfigFactory)object3);
            object5 = ((LifecycleCameraRepository)object5).createLifecycleCamera((LifecycleOwner)object, cameraUseCaseAdapter);
        }
        if ((n10 = useCaseArray.length) == 0) {
            return object5;
        }
        object = this.mLifecycleCameraRepository;
        object2 = Arrays.asList(useCaseArray);
        ((LifecycleCameraRepository)object).bindToLifecycleCamera((LifecycleCamera)object5, viewPort, (Collection)object2);
        return object5;
    }

    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase ... useCaseArray) {
        return this.bindToLifecycle(lifecycleOwner, cameraSelector, (ViewPort)null, useCaseArray);
    }

    public List getAvailableCameraInfos() {
        boolean bl2;
        ArrayList<CameraInfo> arrayList = new ArrayList<CameraInfo>();
        Iterator iterator2 = this.mCameraX.getCameraRepository().getCameras().iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraInfo cameraInfo = ((CameraInternal)iterator2.next()).getCameraInfo();
            arrayList.add(cameraInfo);
        }
        return arrayList;
    }

    public boolean hasCamera(CameraSelector cameraSelector) {
        Object object;
        try {
            object = this.mCameraX;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
        object = ((CameraX)object).getCameraRepository();
        object = ((CameraRepository)object).getCameras();
        cameraSelector.select((LinkedHashSet)object);
        return true;
    }

    public boolean isBound(UseCase useCase) {
        boolean bl2;
        Iterator iterator2 = this.mLifecycleCameraRepository.getLifecycleCameras().iterator();
        while (bl2 = iterator2.hasNext()) {
            LifecycleCamera lifecycleCamera = (LifecycleCamera)iterator2.next();
            bl2 = lifecycleCamera.isBound(useCase);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public ListenableFuture shutdown() {
        this.mLifecycleCameraRepository.clear();
        return CameraX.shutdown();
    }

    public void unbind(UseCase ... object) {
        Threads.checkMainThread();
        LifecycleCameraRepository lifecycleCameraRepository = this.mLifecycleCameraRepository;
        object = Arrays.asList(object);
        lifecycleCameraRepository.unbind((Collection)object);
    }

    public void unbindAll() {
        Threads.checkMainThread();
        this.mLifecycleCameraRepository.unbindAll();
    }
}

