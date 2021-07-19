/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.google.firebase.installations;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.CrossProcessLock;
import com.google.firebase.installations.FirebaseInstallations$$Lambda$1;
import com.google.firebase.installations.FirebaseInstallations$$Lambda$2;
import com.google.firebase.installations.FirebaseInstallations$$Lambda$3;
import com.google.firebase.installations.FirebaseInstallations$$Lambda$4;
import com.google.firebase.installations.FirebaseInstallations$1;
import com.google.firebase.installations.FirebaseInstallations$2;
import com.google.firebase.installations.FirebaseInstallations$3;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.FirebaseInstallationsException$Status;
import com.google.firebase.installations.GetAuthTokenListener;
import com.google.firebase.installations.GetIdListener;
import com.google.firebase.installations.RandomFidGenerator;
import com.google.firebase.installations.StateListener;
import com.google.firebase.installations.Utils;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseInstallations
implements FirebaseInstallationsApi {
    private static final String API_KEY_VALIDATION_MSG = "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final String APP_ID_VALIDATION_MSG = "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final String AUTH_ERROR_MSG = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request.";
    private static final String CHIME_FIREBASE_APP_NAME = "CHIME_ANDROID_SDK";
    private static final int CORE_POOL_SIZE = 0;
    private static final long KEEP_ALIVE_TIME_IN_SECONDS = 30L;
    private static final String LOCKFILE_NAME_GENERATE_FID = "generatefid.lock";
    private static final int MAXIMUM_POOL_SIZE = 1;
    private static final String PROJECT_ID_VALIDATION_MSG = "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final ThreadFactory THREAD_FACTORY;
    private static final Object lockGenerateFid;
    private final ExecutorService backgroundExecutor;
    private String cachedFid;
    private final RandomFidGenerator fidGenerator;
    private Set fidListeners;
    private final FirebaseApp firebaseApp;
    private final IidStore iidStore;
    private final List listeners;
    private final Object lock;
    private final ExecutorService networkExecutor;
    private final PersistedInstallation persistedInstallation;
    private final FirebaseInstallationServiceClient serviceClient;
    private final Utils utils;

    static {
        Object object;
        lockGenerateFid = object = new Object();
        THREAD_FACTORY = object = new FirebaseInstallations$1();
    }

    public FirebaseInstallations(FirebaseApp firebaseApp, Provider provider, Provider provider2) {
        ThreadPoolExecutor threadPoolExecutor;
        Object object = TimeUnit.SECONDS;
        Object object2 = new LinkedBlockingQueue();
        Object object3 = THREAD_FACTORY;
        Object object4 = threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long)30, (TimeUnit)((Object)object), (BlockingQueue<Runnable>)object2, (ThreadFactory)object3);
        object4 = firebaseApp.getApplicationContext();
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient((Context)object4, provider, provider2);
        PersistedInstallation persistedInstallation = new PersistedInstallation(firebaseApp);
        object = Utils.getInstance();
        object2 = new IidStore(firebaseApp);
        object3 = new RandomFidGenerator();
        object4 = this;
        this(threadPoolExecutor, firebaseApp, firebaseInstallationServiceClient, persistedInstallation, (Utils)object, (IidStore)object2, (RandomFidGenerator)object3);
    }

    public FirebaseInstallations(ExecutorService executorService, FirebaseApp firebaseApp, FirebaseInstallationServiceClient firebaseInstallationServiceClient, PersistedInstallation persistedInstallation, Utils utils, IidStore iidStore, RandomFidGenerator randomFidGenerator) {
        ThreadPoolExecutor threadPoolExecutor;
        Object object;
        this.lock = object = new Object();
        object = new HashSet();
        this.fidListeners = object;
        this.listeners = object;
        object = firebaseApp;
        this.firebaseApp = firebaseApp;
        object = firebaseInstallationServiceClient;
        this.serviceClient = firebaseInstallationServiceClient;
        object = persistedInstallation;
        this.persistedInstallation = persistedInstallation;
        object = utils;
        this.utils = utils;
        object = iidStore;
        this.iidStore = iidStore;
        object = randomFidGenerator;
        this.fidGenerator = randomFidGenerator;
        object = executorService;
        this.backgroundExecutor = executorService;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        ThreadFactory threadFactory = THREAD_FACTORY;
        object = threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long)30, timeUnit, linkedBlockingQueue, threadFactory);
        this.networkExecutor = threadPoolExecutor;
    }

    public static /* synthetic */ Set access$000(FirebaseInstallations firebaseInstallations) {
        return firebaseInstallations.fidListeners;
    }

    public static /* synthetic */ Void access$lambda$0(FirebaseInstallations firebaseInstallations) {
        return firebaseInstallations.deleteFirebaseInstallationId();
    }

    private Task addGetAuthTokenListener() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Utils utils = this.utils;
        GetAuthTokenListener getAuthTokenListener = new GetAuthTokenListener(utils, taskCompletionSource);
        this.addStateListeners(getAuthTokenListener);
        return taskCompletionSource.getTask();
    }

    private Task addGetIdListener() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetIdListener getIdListener = new GetIdListener(taskCompletionSource);
        this.addStateListeners(getIdListener);
        return taskCompletionSource.getTask();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void addStateListeners(StateListener stateListener) {
        Object object = this.lock;
        synchronized (object) {
            List list = this.listeners;
            list.add(stateListener);
            return;
        }
    }

    private Void deleteFirebaseInstallationId() {
        this.updateCacheFid(null);
        PersistedInstallationEntry persistedInstallationEntry = this.getMultiProcessSafePrefs();
        boolean bl2 = persistedInstallationEntry.isRegistered();
        if (bl2) {
            FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.serviceClient;
            String string2 = this.getApiKey();
            String string3 = persistedInstallationEntry.getFirebaseInstallationId();
            String string4 = this.getProjectIdentifier();
            String string5 = persistedInstallationEntry.getRefreshToken();
            firebaseInstallationServiceClient.deleteFirebaseInstallation(string2, string3, string4, string5);
        }
        persistedInstallationEntry = persistedInstallationEntry.withNoGeneratedFid();
        this.insertOrUpdatePrefs(persistedInstallationEntry);
        return null;
    }

    private void doNetworkCallIfNecessary(boolean bl2) {
        Object object;
        Object object2;
        block14: {
            block12: {
                block13: {
                    boolean bl3;
                    object2 = this.getMultiProcessSafePrefs();
                    try {
                        bl3 = ((PersistedInstallationEntry)object2).isErrored();
                        if (bl3) break block12;
                    }
                    catch (FirebaseInstallationsException firebaseInstallationsException) {
                        this.triggerOnException(firebaseInstallationsException);
                        return;
                    }
                    bl3 = ((PersistedInstallationEntry)object2).isUnregistered();
                    if (bl3) break block12;
                    if (bl2) break block13;
                    object = this.utils;
                    bl2 = ((Utils)object).isAuthTokenExpired((PersistedInstallationEntry)object2);
                    if (bl2) break block13;
                    return;
                }
                object = this.fetchAuthTokenFromServer((PersistedInstallationEntry)object2);
                break block14;
            }
            object = this.registerFidWithServer((PersistedInstallationEntry)object2);
        }
        this.insertOrUpdatePrefs((PersistedInstallationEntry)object);
        this.updateFidListener((PersistedInstallationEntry)object2, (PersistedInstallationEntry)object);
        boolean bl4 = ((PersistedInstallationEntry)object).isRegistered();
        if (bl4) {
            object2 = ((PersistedInstallationEntry)object).getFirebaseInstallationId();
            this.updateCacheFid((String)object2);
        }
        if (bl4 = ((PersistedInstallationEntry)object).isErrored()) {
            object2 = FirebaseInstallationsException$Status.BAD_CONFIG;
            object = new FirebaseInstallationsException((FirebaseInstallationsException$Status)((Object)object2));
            this.triggerOnException((Exception)object);
        } else {
            bl4 = ((PersistedInstallationEntry)object).isNotGenerated();
            if (bl4) {
                object2 = AUTH_ERROR_MSG;
                object = new IOException((String)object2);
                this.triggerOnException((Exception)object);
            } else {
                this.triggerOnStateReached((PersistedInstallationEntry)object);
            }
        }
    }

    private final void doRegistrationOrRefresh(boolean bl2) {
        Object object = this.getPrefsWithGeneratedIdMultiProcessSafe();
        if (bl2) {
            object = ((PersistedInstallationEntry)object).withClearedAuthToken();
        }
        this.triggerOnStateReached((PersistedInstallationEntry)object);
        object = this.networkExecutor;
        Runnable runnable = FirebaseInstallations$$Lambda$4.lambdaFactory$(this, bl2);
        object.execute(runnable);
    }

    private PersistedInstallationEntry fetchAuthTokenFromServer(PersistedInstallationEntry object) {
        Object object2 = this.serviceClient;
        Object object3 = this.getApiKey();
        Object object4 = ((PersistedInstallationEntry)object).getFirebaseInstallationId();
        String string2 = this.getProjectIdentifier();
        String string3 = ((PersistedInstallationEntry)object).getRefreshToken();
        object2 = ((FirebaseInstallationServiceClient)object2).generateAuthToken((String)object3, (String)object4, string2, string3);
        object3 = FirebaseInstallations$3.$SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode;
        object4 = ((TokenResult)object2).getResponseCode();
        int n10 = ((Enum)object4).ordinal();
        Object object5 = object3[n10];
        if (object5 != (n10 = 1)) {
            int n11 = 2;
            if (object5 != n11) {
                n11 = 3;
                if (object5 == n11) {
                    this.updateCacheFid(null);
                    return ((PersistedInstallationEntry)object).withNoGeneratedFid();
                }
                object2 = FirebaseInstallationsException$Status.UNAVAILABLE;
                object = new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", (FirebaseInstallationsException$Status)((Object)object2));
                throw object;
            }
            return ((PersistedInstallationEntry)object).withFisError("BAD CONFIG");
        }
        object3 = ((TokenResult)object2).getToken();
        long l10 = ((TokenResult)object2).getTokenExpirationTimestamp();
        long l11 = this.utils.currentTimeInSecs();
        object2 = object;
        return ((PersistedInstallationEntry)object).withAuthToken((String)object3, l10, l11);
    }

    private String getCacheFid() {
        synchronized (this) {
            String string2 = this.cachedFid;
            return string2;
        }
    }

    public static FirebaseInstallations getInstance() {
        return FirebaseInstallations.getInstance(FirebaseApp.getInstance());
    }

    public static FirebaseInstallations getInstance(FirebaseApp firebaseApp) {
        boolean bl2 = firebaseApp != null;
        Preconditions.checkArgument(bl2, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations)firebaseApp.get(FirebaseInstallationsApi.class);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private PersistedInstallationEntry getMultiProcessSafePrefs() {
        Object object = lockGenerateFid;
        synchronized (object) {
            Object object2 = this.firebaseApp;
            object2 = ((FirebaseApp)object2).getApplicationContext();
            Object object3 = LOCKFILE_NAME_GENERATE_FID;
            object2 = CrossProcessLock.acquire((Context)object2, (String)object3);
            try {
                object3 = this.persistedInstallation;
                object3 = ((PersistedInstallation)object3).readPersistedInstallationEntryValue();
                return object3;
            }
            finally {
                if (object2 != null) {
                    ((CrossProcessLock)object2).releaseAndClose();
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private PersistedInstallationEntry getPrefsWithGeneratedIdMultiProcessSafe() {
        Object object = lockGenerateFid;
        synchronized (object) {
            Object object2 = this.firebaseApp;
            object2 = ((FirebaseApp)object2).getApplicationContext();
            Object object3 = LOCKFILE_NAME_GENERATE_FID;
            object2 = CrossProcessLock.acquire((Context)object2, (String)object3);
            try {
                object3 = this.persistedInstallation;
                object3 = ((PersistedInstallation)object3).readPersistedInstallationEntryValue();
                boolean bl2 = ((PersistedInstallationEntry)object3).isNotGenerated();
                if (bl2) {
                    String string2 = this.readExistingIidOrCreateFid((PersistedInstallationEntry)object3);
                    PersistedInstallation persistedInstallation = this.persistedInstallation;
                    object3 = ((PersistedInstallationEntry)object3).withUnregisteredFid(string2);
                    object3 = persistedInstallation.insertOrUpdatePersistedInstallationEntry((PersistedInstallationEntry)object3);
                }
                return object3;
            }
            finally {
                if (object2 != null) {
                    ((CrossProcessLock)object2).releaseAndClose();
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void insertOrUpdatePrefs(PersistedInstallationEntry persistedInstallationEntry) {
        Object object = lockGenerateFid;
        synchronized (object) {
            Object object2 = this.firebaseApp;
            object2 = ((FirebaseApp)object2).getApplicationContext();
            Object object3 = LOCKFILE_NAME_GENERATE_FID;
            object2 = CrossProcessLock.acquire((Context)object2, (String)object3);
            try {
                object3 = this.persistedInstallation;
                ((PersistedInstallation)object3).insertOrUpdatePersistedInstallationEntry(persistedInstallationEntry);
                return;
            }
            finally {
                if (object2 != null) {
                    ((CrossProcessLock)object2).releaseAndClose();
                }
            }
        }
    }

    public static /* synthetic */ void lambda$doRegistrationOrRefresh$2(FirebaseInstallations firebaseInstallations, boolean bl2) {
        firebaseInstallations.doNetworkCallIfNecessary(bl2);
    }

    public static /* synthetic */ void lambda$getId$0(FirebaseInstallations firebaseInstallations) {
        firebaseInstallations.doRegistrationOrRefresh(false);
    }

    public static /* synthetic */ void lambda$getToken$1(FirebaseInstallations firebaseInstallations, boolean bl2) {
        firebaseInstallations.doRegistrationOrRefresh(bl2);
    }

    private void preConditionChecks() {
        String string2 = this.getApplicationId();
        String string3 = APP_ID_VALIDATION_MSG;
        Preconditions.checkNotEmpty(string2, string3);
        Preconditions.checkNotEmpty(this.getProjectIdentifier(), PROJECT_ID_VALIDATION_MSG);
        string2 = this.getApiKey();
        String string4 = API_KEY_VALIDATION_MSG;
        Preconditions.checkNotEmpty(string2, string4);
        Preconditions.checkArgument(Utils.isValidAppIdFormat(this.getApplicationId()), string3);
        Preconditions.checkArgument(Utils.isValidApiKeyFormat(this.getApiKey()), string4);
    }

    private String readExistingIidOrCreateFid(PersistedInstallationEntry object) {
        boolean bl2;
        String string2;
        Object object2 = this.firebaseApp.getName();
        boolean bl3 = ((String)object2).equals(string2 = CHIME_FIREBASE_APP_NAME);
        if (!bl3 && !(bl3 = ((FirebaseApp)(object2 = this.firebaseApp)).isDefaultApp()) || !(bl2 = ((PersistedInstallationEntry)object).shouldAttemptMigration())) {
            return this.fidGenerator.createRandomFid();
        }
        object = this.iidStore.readIid();
        bl3 = TextUtils.isEmpty((CharSequence)object);
        if (bl3) {
            object = this.fidGenerator.createRandomFid();
        }
        return object;
    }

    private PersistedInstallationEntry registerFidWithServer(PersistedInstallationEntry object) {
        Object object2;
        int n10;
        Object object3 = ((PersistedInstallationEntry)object).getFirebaseInstallationId();
        if (object3 != null && (n10 = ((String)(object3 = ((PersistedInstallationEntry)object).getFirebaseInstallationId())).length()) == (object2 = 11)) {
            object3 = this.iidStore.readToken();
        } else {
            n10 = 0;
            object3 = null;
        }
        Object object4 = this.serviceClient;
        Object object5 = this.getApiKey();
        String string2 = ((PersistedInstallationEntry)object).getFirebaseInstallationId();
        String string3 = this.getProjectIdentifier();
        String string4 = this.getApplicationId();
        object3 = ((FirebaseInstallationServiceClient)object4).createFirebaseInstallation((String)object5, string2, string3, string4, (String)object3);
        object4 = FirebaseInstallations$3.$SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode;
        object5 = ((InstallationResponse)object3).getResponseCode();
        int n11 = ((Enum)object5).ordinal();
        object2 = object4[n11];
        n11 = 1;
        if (object2 != n11) {
            n10 = 2;
            if (object2 == n10) {
                return ((PersistedInstallationEntry)object).withFisError("BAD CONFIG");
            }
            object3 = FirebaseInstallationsException$Status.UNAVAILABLE;
            object = new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", (FirebaseInstallationsException$Status)((Object)object3));
            throw object;
        }
        string2 = ((InstallationResponse)object3).getFid();
        string3 = ((InstallationResponse)object3).getRefreshToken();
        long l10 = this.utils.currentTimeInSecs();
        String string5 = ((InstallationResponse)object3).getAuthToken().getToken();
        long l11 = ((InstallationResponse)object3).getAuthToken().getTokenExpirationTimestamp();
        object5 = object;
        return ((PersistedInstallationEntry)object).withRegisteredFid(string2, string3, l10, string5, l11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void triggerOnException(Exception exception) {
        Object object = this.lock;
        synchronized (object) {
            Object object2 = this.listeners;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                bl2 = (object3 = (StateListener)object3).onException(exception);
                if (!bl2) continue;
                object2.remove();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void triggerOnStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        Object object = this.lock;
        synchronized (object) {
            Object object2 = this.listeners;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                bl2 = (object3 = (StateListener)object3).onStateReached(persistedInstallationEntry);
                if (!bl2) continue;
                object2.remove();
            }
            return;
        }
    }

    private void updateCacheFid(String string2) {
        synchronized (this) {
            this.cachedFid = string2;
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateFidListener(PersistedInstallationEntry iterator2, PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this) {
            void var2_2;
            boolean bl2;
            Object object = this.fidListeners;
            int n10 = object.size();
            if (n10 != 0 && !(bl2 = ((String)((Object)(iterator2 = ((PersistedInstallationEntry)((Object)iterator2)).getFirebaseInstallationId()))).equals(object = var2_2.getFirebaseInstallationId()))) {
                iterator2 = this.fidListeners;
                iterator2 = iterator2.iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    object = iterator2.next();
                    object = (FidListener)object;
                    String string2 = var2_2.getFirebaseInstallationId();
                    object.onFidChanged(string2);
                }
            }
            return;
        }
    }

    public Task delete() {
        ExecutorService executorService = this.backgroundExecutor;
        Callable callable = FirebaseInstallations$$Lambda$3.lambdaFactory$(this);
        return Tasks.call(executorService, callable);
    }

    public String getApiKey() {
        return this.firebaseApp.getOptions().getApiKey();
    }

    public String getApplicationId() {
        return this.firebaseApp.getOptions().getApplicationId();
    }

    public Task getId() {
        this.preConditionChecks();
        Object object = this.getCacheFid();
        if (object != null) {
            return Tasks.forResult(object);
        }
        object = this.addGetIdListener();
        ExecutorService executorService = this.backgroundExecutor;
        Runnable runnable = FirebaseInstallations$$Lambda$1.lambdaFactory$(this);
        executorService.execute(runnable);
        return object;
    }

    public String getName() {
        return this.firebaseApp.getName();
    }

    public String getProjectIdentifier() {
        return this.firebaseApp.getOptions().getProjectId();
    }

    public Task getToken(boolean bl2) {
        this.preConditionChecks();
        Task task = this.addGetAuthTokenListener();
        ExecutorService executorService = this.backgroundExecutor;
        Runnable runnable = FirebaseInstallations$$Lambda$2.lambdaFactory$(this, bl2);
        executorService.execute(runnable);
        return task;
    }

    public FidListenerHandle registerFidListener(FidListener fidListener) {
        synchronized (this) {
            Object object = this.fidListeners;
            object.add(fidListener);
            object = new FirebaseInstallations$2(this, fidListener);
            return object;
        }
    }
}

