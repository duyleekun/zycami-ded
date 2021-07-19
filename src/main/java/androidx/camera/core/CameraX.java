/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Resources$NotFoundException
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.SystemClock
 */
package androidx.camera.core;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.camera.core.CameraExecutor;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX$1;
import androidx.camera.core.CameraX$2;
import androidx.camera.core.CameraX$InternalInitState;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.CameraXConfig$Provider;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.R$string;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.CameraThreadConfig;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.impl.CameraValidator$CameraIdListIncorrectException;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.IncompleteCameraListQuirk;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.os.HandlerCompat;
import androidx.core.util.Preconditions;
import b.a.b.d;
import b.a.b.e;
import b.a.b.f;
import b.a.b.g;
import b.a.b.h;
import b.a.b.i;
import b.a.b.j;
import b.a.b.k;
import b.a.b.l;
import b.a.b.m;
import b.a.b.n;
import b.a.b.o;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CameraX {
    public static final Object INSTANCE_LOCK;
    private static final long RETRY_SLEEP_MILLIS = 500L;
    private static final String RETRY_TOKEN = "retry_token";
    private static final String TAG = "CameraX";
    private static final long WAIT_INITIALIZED_TIMEOUT_MILLIS = 3000L;
    private static CameraXConfig$Provider sConfigProvider;
    private static ListenableFuture sInitializeFuture;
    public static CameraX sInstance;
    private static ListenableFuture sShutdownFuture;
    private Context mAppContext;
    private final Executor mCameraExecutor;
    private CameraFactory mCameraFactory;
    public final CameraRepository mCameraRepository;
    private final CameraXConfig mCameraXConfig;
    private UseCaseConfigFactory mDefaultConfigFactory;
    private CameraX$InternalInitState mInitState;
    private final Object mInitializeLock;
    private final Handler mSchedulerHandler;
    private final HandlerThread mSchedulerThread;
    private ListenableFuture mShutdownInternalFuture;
    private CameraDeviceSurfaceManager mSurfaceManager;

    static {
        Object object;
        INSTANCE_LOCK = object = new Object();
        object = new IllegalStateException("CameraX is not initialized.");
        sInitializeFuture = Futures.immediateFailedFuture((Throwable)object);
        sShutdownFuture = Futures.immediateFuture(null);
    }

    public CameraX(CameraXConfig cameraXConfig) {
        Object object = new CameraRepository();
        this.mCameraRepository = object;
        this.mInitializeLock = object = new Object();
        object = CameraX$InternalInitState.UNINITIALIZED;
        this.mInitState = object;
        int n10 = 0;
        object = null;
        Object object2 = Futures.immediateFuture(null);
        this.mShutdownInternalFuture = object2;
        this.mCameraXConfig = object2 = (CameraXConfig)Preconditions.checkNotNull(cameraXConfig);
        object2 = cameraXConfig.getCameraExecutor(null);
        cameraXConfig = cameraXConfig.getSchedulerHandler(null);
        if (object2 == null) {
            object2 = new CameraExecutor();
        }
        this.mCameraExecutor = object2;
        if (cameraXConfig == null) {
            n10 = 10;
            object2 = "CameraX-scheduler";
            super((String)object2, n10);
            this.mSchedulerThread = cameraXConfig;
            cameraXConfig.start();
            cameraXConfig = HandlerCompat.createAsync(cameraXConfig.getLooper());
            this.mSchedulerHandler = cameraXConfig;
        } else {
            this.mSchedulerThread = null;
            this.mSchedulerHandler = cameraXConfig;
        }
    }

    public static /* synthetic */ CameraXConfig a(CameraXConfig cameraXConfig) {
        return cameraXConfig;
    }

    public static /* synthetic */ CameraX b(CameraX cameraX, Void void_) {
        return cameraX;
    }

    private /* synthetic */ void c(Executor executor, long l10, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Context context = this.mAppContext;
        this.initAndRetryRecursively(executor, l10, context, callbackToFutureAdapter$Completer);
    }

    private static CameraX checkInitialized() {
        CameraX cameraX = CameraX.waitInitialized();
        Preconditions.checkState(cameraX.isInitializedInternal(), "Must call CameraX.initialize() first");
        return cameraX;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void configureInstance(CameraXConfig cameraXConfig) {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            h h10 = new h(cameraXConfig);
            CameraX.configureInstanceLocked(h10);
            return;
        }
    }

    private static void configureInstanceLocked(CameraXConfig$Provider object) {
        boolean bl2;
        Preconditions.checkNotNull(object);
        Object object2 = sConfigProvider;
        if (object2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        Preconditions.checkState(bl2, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
        sConfigProvider = object;
        object = object.getCameraXConfig();
        object2 = CameraXConfig.OPTION_MIN_LOGGING_LEVEL;
        object = (Integer)object.retrieveOption((Config$Option)object2, null);
        if (object != null) {
            int n10 = (Integer)object;
            Logger.setMinLogLevel(n10);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private /* synthetic */ void e(Context var1_1, Executor var2_6, CallbackToFutureAdapter$Completer var3_7, long var4_8) {
        block56: {
            block53: {
                block54: {
                    block55: {
                        var6_9 = null;
                        var7_10 /* !! */  = CameraX.getApplicationFromContext((Context)var1_1);
                        this.mAppContext = var7_10 /* !! */ ;
                        if (var7_10 /* !! */  != null) ** GOTO lbl11
                        var1_1 = var1_1.getApplicationContext();
                        this.mAppContext = var1_1;
lbl11:
                        // 2 sources

                        var1_1 = this.mCameraXConfig;
                        var1_1 = var1_1.getCameraFactoryProvider(null);
                        if (var1_1 == null) break block53;
                        var7_10 /* !! */  = this.mCameraExecutor;
                        var8_11 = this.mSchedulerHandler;
                        var7_10 /* !! */  = CameraThreadConfig.create((Executor)var7_10 /* !! */ , (Handler)var8_11);
                        var8_11 = this.mCameraXConfig;
                        var8_11 = var8_11.getAvailableCamerasLimiter(null);
                        var9_12 = this.mAppContext;
                        var1_1 = var1_1.newInstance((Context)var9_12, (CameraThreadConfig)var7_10 /* !! */ , (CameraSelector)var8_11);
                        this.mCameraFactory = var1_1;
                        var1_1 = this.mCameraXConfig;
                        var1_1 = var1_1.getDeviceSurfaceManagerProvider(null);
                        if (var1_1 == null) break block54;
                        var7_10 /* !! */  = this.mAppContext;
                        var8_11 = this.mCameraFactory;
                        var8_11 = var8_11.getCameraManager();
                        var9_12 = this.mCameraFactory;
                        var9_12 = var9_12.getAvailableCameraIds();
                        var1_1 = var1_1.newInstance((Context)var7_10 /* !! */ , var8_11, (Set)var9_12);
                        this.mSurfaceManager = var1_1;
                        var1_1 = this.mCameraXConfig;
                        var1_1 = var1_1.getUseCaseConfigFactoryProvider(null);
                        if (var1_1 == null) break block55;
                        var7_10 /* !! */  = this.mAppContext;
                        var1_1 = var1_1.newInstance((Context)var7_10 /* !! */ );
                        this.mDefaultConfigFactory = var1_1;
                        var10_13 = var2_6 instanceof CameraExecutor;
                        if (!var10_13) ** GOTO lbl68
                        var1_1 = var2_6;
                        var1_1 = (CameraExecutor)var2_6;
                        var7_10 /* !! */  = this.mCameraFactory;
                        var1_1.init((CameraFactory)var7_10 /* !! */ );
lbl68:
                        // 2 sources

                        var1_1 = this.mCameraRepository;
                        var7_10 /* !! */  = this.mCameraFactory;
                        var1_1.init((CameraFactory)var7_10 /* !! */ );
                        var1_1 = IncompleteCameraListQuirk.class;
                        var1_1 = DeviceQuirks.get((Class)var1_1);
                        if (var1_1 == null) ** GOTO lbl83
                        var1_1 = this.mAppContext;
                        var7_10 /* !! */  = this.mCameraRepository;
                        CameraValidator.validateCameras((Context)var1_1, (CameraRepository)var7_10 /* !! */ );
lbl83:
                        // 2 sources

                        this.setStateToInitialized();
                        var3_7.set(null);
                        break block56;
                    }
                    var8_11 = "Invalid app configuration provided. Missing UseCaseConfigFactory.";
                    var7_10 /* !! */  = new IllegalArgumentException((String)var8_11);
                    var1_1 = new InitializationException((Throwable)var7_10 /* !! */ );
                    throw var1_1;
                }
                var8_11 = "Invalid app configuration provided. Missing CameraDeviceSurfaceManager.";
                var7_10 /* !! */  = new IllegalArgumentException((String)var8_11);
                var1_1 = new InitializationException((Throwable)var7_10 /* !! */ );
                throw var1_1;
            }
            var8_11 = "Invalid app configuration provided. Missing CameraFactory.";
            var7_10 /* !! */  = new IllegalArgumentException((String)var8_11);
            try {
                var1_1 = new InitializationException((Throwable)var7_10 /* !! */ );
                throw var1_1;
            }
            catch (RuntimeException var1_2) {
            }
            catch (InitializationException var1_3) {
            }
            catch (CameraValidator$CameraIdListIncorrectException var1_4) {
                // empty catch block
            }
            var11_14 = SystemClock.elapsedRealtime() - var4_8;
            var13_15 = 2500L;
            var15_16 = var11_14 == var13_15 ? 0 : (var11_14 < var13_15 ? -1 : 1);
            var8_11 = "CameraX";
            if (var15_16 < 0) {
                var6_9 = new StringBuilder();
                var6_9.append("Retry init. Start time ");
                var6_9.append(var4_8);
                var6_9.append(" current time ");
                var13_15 = SystemClock.elapsedRealtime();
                var6_9.append(var13_15);
                var6_9 = var6_9.toString();
                Logger.w((String)var8_11, (String)var6_9, (Throwable)var1_5);
                var1_5 = this.mSchedulerHandler;
                var6_9 = var16_17;
                var7_10 /* !! */  = this;
                var8_11 = var2_6;
                var13_15 = var4_8;
                var16_17 = new g(this, (Executor)var2_6, var4_8, var3_7);
                var17_18 = 500L;
                var19_19 = "retry_token";
                HandlerCompat.postDelayed((Handler)var1_5, var16_17, var19_19, var17_18);
            } else {
                this.setStateToInitialized();
                var20_20 = var1_5 instanceof CameraValidator$CameraIdListIncorrectException;
                if (var20_20) {
                    var1_5 = "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.";
                    Logger.e((String)var8_11, var1_5);
                    var3_7.set(null);
                } else {
                    var20_20 = var1_5 instanceof InitializationException;
                    if (var20_20) {
                        var3_7.setException((Throwable)var1_5);
                    } else {
                        var2_6 = new InitializationException((Throwable)var1_5);
                        var3_7.setException((Throwable)var2_6);
                    }
                }
            }
        }
    }

    private /* synthetic */ Object g(Context context, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Executor executor = this.mCameraExecutor;
        long l10 = SystemClock.elapsedRealtime();
        this.initAndRetryRecursively(executor, l10, context, callbackToFutureAdapter$Completer);
        return "CameraX initInternal";
    }

    private static Application getApplicationFromContext(Context context) {
        block2: {
            boolean bl2;
            context = context.getApplicationContext();
            while (bl2 = context instanceof ContextWrapper) {
                bl2 = context instanceof Application;
                if (bl2) {
                    context = (Application)context;
                    break block2;
                }
                context = ((ContextWrapper)context).getBaseContext();
            }
            context = null;
        }
        return context;
    }

    public static CameraInternal getCameraWithCameraSelector(CameraSelector cameraSelector) {
        LinkedHashSet linkedHashSet = CameraX.checkInitialized().getCameraRepository().getCameras();
        return cameraSelector.select(linkedHashSet);
    }

    /*
     * WARNING - void declaration
     */
    private static CameraXConfig$Provider getConfigProvider(Context object) {
        Object object2;
        block19: {
            object2 = CameraX.getApplicationFromContext(object);
            boolean bl2 = object2 instanceof CameraXConfig$Provider;
            if (bl2) {
                object2 = (CameraXConfig$Provider)object2;
            } else {
                void var0_8;
                object = object.getApplicationContext();
                object = object.getResources();
                int n10 = R$string.androidx_camera_default_config_provider;
                object = object.getString(n10);
                object = Class.forName((String)object);
                n10 = 0;
                object2 = null;
                Class[] classArray = new Class[]{};
                object = object.getDeclaredConstructor(classArray);
                object2 = new Object[]{};
                object2 = object = object.newInstance((Object[])object2);
                try {
                    object2 = (CameraXConfig$Provider)object;
                    break block19;
                }
                catch (NullPointerException nullPointerException) {
                }
                catch (IllegalAccessException illegalAccessException) {
                }
                catch (NoSuchMethodException noSuchMethodException) {
                }
                catch (InvocationTargetException invocationTargetException) {
                }
                catch (InstantiationException instantiationException) {
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
                catch (Resources.NotFoundException notFoundException) {
                    // empty catch block
                }
                classArray = "Failed to retrieve default CameraXConfig.Provider from resources";
                Logger.e(TAG, (String)classArray, (Throwable)var0_8);
                n10 = 0;
                object2 = null;
            }
        }
        return object2;
    }

    public static Context getContext() {
        return CameraX.checkInitialized().mAppContext;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ListenableFuture getInstance() {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            return CameraX.getInstanceLocked();
        }
    }

    private static ListenableFuture getInstanceLocked() {
        Object object = sInstance;
        if (object == null) {
            object = new IllegalStateException("Must call CameraX.initialize() first");
            return Futures.immediateFailedFuture((Throwable)object);
        }
        ListenableFuture listenableFuture = sInitializeFuture;
        e e10 = new e((CameraX)object);
        object = CameraXExecutors.directExecutor();
        return Futures.transform(listenableFuture, e10, (Executor)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ListenableFuture getOrCreateInstance(Context object) {
        Preconditions.checkNotNull(object, "Context must not be null.");
        Object object2 = INSTANCE_LOCK;
        synchronized (object2) {
            boolean bl2;
            Object object3 = sConfigProvider;
            if (object3 != null) {
                bl2 = true;
            } else {
                bl2 = false;
                object3 = null;
            }
            Object object4 = CameraX.getInstanceLocked();
            boolean bl3 = object4.isDone();
            if (bl3) {
                try {
                    object4.get();
                }
                catch (ExecutionException executionException) {
                    CameraX.shutdownLocked();
                    object4 = null;
                }
                catch (InterruptedException interruptedException) {
                    object4 = "Unexpected thread interrupt. Should not be possible since future is already complete.";
                    object3 = new RuntimeException((String)object4, interruptedException);
                    throw object3;
                }
            }
            if (object4 != null) return object4;
            if (!bl2) {
                object3 = CameraX.getConfigProvider(object);
                if (object3 == null) {
                    object3 = "CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.";
                    object = new IllegalStateException((String)object3);
                    throw object;
                }
                CameraX.configureInstanceLocked((CameraXConfig$Provider)object3);
            }
            CameraX.initializeInstanceLocked(object);
            return CameraX.getInstanceLocked();
        }
    }

    public static /* synthetic */ CameraXConfig i(CameraXConfig cameraXConfig) {
        return cameraXConfig;
    }

    private void initAndRetryRecursively(Executor executor, long l10, Context context, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        l l11 = new l(this, context, executor, callbackToFutureAdapter$Completer, l10);
        executor.execute(l11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ListenableFuture initInternal(Context object) {
        Object object2 = this.mInitializeLock;
        synchronized (object2) {
            boolean bl2;
            Object object3 = this.mInitState;
            Object object4 = CameraX$InternalInitState.UNINITIALIZED;
            if (object3 == object4) {
                bl2 = true;
            } else {
                bl2 = false;
                object3 = null;
            }
            object4 = "CameraX.initInternal() should only be called once per instance";
            Preconditions.checkState(bl2, (String)object4);
            this.mInitState = object3 = CameraX$InternalInitState.INITIALIZING;
            object3 = new d(this, (Context)object);
            return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ListenableFuture initialize(Context object, CameraXConfig cameraXConfig) {
        Object object2 = INSTANCE_LOCK;
        synchronized (object2) {
            Preconditions.checkNotNull(object);
            i i10 = new i(cameraXConfig);
            CameraX.configureInstanceLocked(i10);
            CameraX.initializeInstanceLocked(object);
            return sInitializeFuture;
        }
    }

    private static void initializeInstanceLocked(Context context) {
        boolean bl2;
        Preconditions.checkNotNull(context);
        CameraX cameraX = sInstance;
        if (cameraX == null) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraX = null;
        }
        Preconditions.checkState(bl2, "CameraX already initialized.");
        Preconditions.checkNotNull(sConfigProvider);
        Object object = sConfigProvider.getCameraXConfig();
        sInstance = cameraX = new CameraX((CameraXConfig)object);
        object = new f(cameraX, context);
        sInitializeFuture = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isInitialized() {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            CameraX cameraX = sInstance;
            if (cameraX == null) return false;
            boolean bl2 = cameraX.isInitializedInternal();
            if (!bl2) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean isInitializedInternal() {
        Object object = this.mInitializeLock;
        synchronized (object) {
            CameraX$InternalInitState cameraX$InternalInitState = this.mInitState;
            CameraX$InternalInitState cameraX$InternalInitState2 = CameraX$InternalInitState.INITIALIZED;
            if (cameraX$InternalInitState != cameraX$InternalInitState2) return false;
            return true;
        }
    }

    public static /* synthetic */ ListenableFuture j(CameraX cameraX, Context context, Void void_) {
        return cameraX.initInternal(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ Object k(CameraX object, Context object2, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Object object3 = INSTANCE_LOCK;
        synchronized (object3) {
            Object object4 = sShutdownFuture;
            object4 = FutureChain.from((ListenableFuture)object4);
            j j10 = new j((CameraX)object, (Context)object2);
            object2 = CameraXExecutors.directExecutor();
            object2 = ((FutureChain)object4).transformAsync(j10, (Executor)object2);
            object4 = new CameraX$1(callbackToFutureAdapter$Completer, (CameraX)object);
            object = CameraXExecutors.directExecutor();
            Futures.addCallback((ListenableFuture)object2, (FutureCallback)object4, (Executor)object);
            return "CameraX-initialize";
        }
    }

    private /* synthetic */ void l(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Object object = this.mSchedulerThread;
        if (object != null) {
            object = this.mCameraExecutor;
            boolean bl2 = object instanceof CameraExecutor;
            if (bl2) {
                object = (CameraExecutor)object;
                ((CameraExecutor)object).deinit();
            }
            this.mSchedulerThread.quit();
            object = null;
            callbackToFutureAdapter$Completer.set(null);
        }
    }

    private /* synthetic */ Object n(CallbackToFutureAdapter$Completer object) {
        ListenableFuture listenableFuture = this.mCameraRepository.deinit();
        k k10 = new k(this, (CallbackToFutureAdapter$Completer)object);
        object = this.mCameraExecutor;
        listenableFuture.addListener(k10, (Executor)object);
        return "CameraX shutdownInternal";
    }

    public static /* synthetic */ void p(CameraX cameraX, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Futures.propagate(cameraX.shutdownInternal(), callbackToFutureAdapter$Completer);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ Object q(CameraX object, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Object object2 = INSTANCE_LOCK;
        synchronized (object2) {
            ListenableFuture listenableFuture = sInitializeFuture;
            m m10 = new m((CameraX)object, callbackToFutureAdapter$Completer);
            object = CameraXExecutors.directExecutor();
            listenableFuture.addListener(m10, (Executor)object);
            return "CameraX shutdown";
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setStateToInitialized() {
        Object object = this.mInitializeLock;
        synchronized (object) {
            CameraX$InternalInitState cameraX$InternalInitState;
            this.mInitState = cameraX$InternalInitState = CameraX$InternalInitState.INITIALIZED;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ListenableFuture shutdown() {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            ListenableFuture listenableFuture = null;
            sConfigProvider = null;
            Logger.resetMinLogLevel();
            return CameraX.shutdownLocked();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ListenableFuture shutdownInternal() {
        Object object = this.mInitializeLock;
        synchronized (object) {
            Object object2 = this.mSchedulerHandler;
            Object object3 = RETRY_TOKEN;
            object2.removeCallbacksAndMessages(object3);
            object2 = CameraX$2.$SwitchMap$androidx$camera$core$CameraX$InternalInitState;
            object3 = this.mInitState;
            int n10 = ((Enum)object3).ordinal();
            Object object4 = object2[n10];
            n10 = 1;
            if (object4 == n10) {
                object2 = CameraX$InternalInitState.SHUTDOWN;
                this.mInitState = object2;
                object4 = false;
                object2 = null;
                return Futures.immediateFuture(null);
            }
            n10 = 2;
            if (object4 == n10) {
                object3 = "CameraX could not be shutdown when it is initializing.";
                object2 = new IllegalStateException((String)object3);
                throw object2;
            }
            n10 = 3;
            if (object4 == n10) {
                object2 = CameraX$InternalInitState.SHUTDOWN;
                this.mInitState = object2;
                object2 = new o(this);
                object2 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object2);
                this.mShutdownInternalFuture = object2;
            }
            return this.mShutdownInternalFuture;
        }
    }

    public static ListenableFuture shutdownLocked() {
        Object object = sInstance;
        if (object == null) {
            return sShutdownFuture;
        }
        sInstance = null;
        n n10 = new n((CameraX)object);
        sShutdownFuture = object = Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(n10));
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private static CameraX waitInitialized() {
        void var0_4;
        ListenableFuture listenableFuture = CameraX.getInstance();
        long l10 = 3000L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        listenableFuture = listenableFuture.get(l10, timeUnit);
        try {
            return (CameraX)((Object)listenableFuture);
        }
        catch (TimeoutException timeoutException) {
        }
        catch (InterruptedException interruptedException) {
        }
        catch (ExecutionException executionException) {
            // empty catch block
        }
        IllegalStateException illegalStateException = new IllegalStateException((Throwable)var0_4);
        throw illegalStateException;
    }

    public /* synthetic */ void d(Executor executor, long l10, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.c(executor, l10, callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ void f(Context context, Executor executor, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, long l10) {
        this.e(context, executor, callbackToFutureAdapter$Completer, l10);
    }

    public CameraDeviceSurfaceManager getCameraDeviceSurfaceManager() {
        Object object = this.mSurfaceManager;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("CameraX not initialized yet.");
        throw object;
    }

    public CameraFactory getCameraFactory() {
        Object object = this.mCameraFactory;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("CameraX not initialized yet.");
        throw object;
    }

    public CameraRepository getCameraRepository() {
        return this.mCameraRepository;
    }

    public UseCaseConfigFactory getDefaultConfigFactory() {
        Object object = this.mDefaultConfigFactory;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("CameraX not initialized yet.");
        throw object;
    }

    public /* synthetic */ Object h(Context context, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.g(context, callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ void m(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.l(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ Object o(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.n(callbackToFutureAdapter$Completer);
    }
}

