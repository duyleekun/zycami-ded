/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.FirebaseApp$$Lambda$1;
import com.google.firebase.FirebaseApp$BackgroundStateChangeListener;
import com.google.firebase.FirebaseApp$GlobalBackgroundStateListener;
import com.google.firebase.FirebaseApp$UiExecutor;
import com.google.firebase.FirebaseApp$UserUnlockReceiver;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.ComponentRuntime$Builder;
import com.google.firebase.components.Lazy;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final String FIREBASE_ANDROID = "fire-android";
    private static final String FIREBASE_COMMON = "fire-core";
    public static final Map INSTANCES;
    private static final String KOTLIN = "kotlin";
    private static final Object LOCK;
    private static final String LOG_TAG = "FirebaseApp";
    private static final Executor UI_EXECUTOR;
    private final Context applicationContext;
    private final AtomicBoolean automaticResourceManagementEnabled;
    private final List backgroundStateChangeListeners;
    private final ComponentRuntime componentRuntime;
    private final Lazy dataCollectionConfigStorage;
    private final AtomicBoolean deleted;
    private final List lifecycleListeners;
    private final String name;
    private final FirebaseOptions options;

    static {
        Object object;
        LOCK = object = new Object();
        UI_EXECUTOR = object = new FirebaseApp$UiExecutor(null);
        INSTANCES = object = new ArrayMap();
    }

    public FirebaseApp(Context object, String object2, FirebaseOptions object3) {
        Object object4 = new AtomicBoolean(false);
        this.automaticResourceManagementEnabled = object4;
        object4 = new AtomicBoolean();
        this.deleted = object4;
        this.backgroundStateChangeListeners = object4;
        super();
        this.lifecycleListeners = object4;
        object4 = (Context)Preconditions.checkNotNull(object);
        this.applicationContext = object4;
        object2 = Preconditions.checkNotEmpty((String)object2);
        this.name = object2;
        this.options = object2 = (FirebaseOptions)Preconditions.checkNotNull(object3);
        object2 = ComponentDiscovery.forContext(object, ComponentDiscoveryService.class).discoverLazy();
        object2 = ComponentRuntime.builder(UI_EXECUTOR).addLazyComponentRegistrars((Collection)object2);
        object4 = new FirebaseCommonRegistrar();
        object2 = ((ComponentRuntime$Builder)object2).addComponentRegistrar((ComponentRegistrar)object4);
        Class[] classArray = new Class[]{};
        object4 = Component.of(object, Context.class, classArray);
        object2 = ((ComponentRuntime$Builder)object2).addComponent((Component)object4);
        classArray = new Class[]{};
        object4 = Component.of(this, FirebaseApp.class, classArray);
        object2 = ((ComponentRuntime$Builder)object2).addComponent((Component)object4);
        Class[] classArray2 = new Class[]{};
        object3 = Component.of(object3, FirebaseOptions.class, classArray2);
        this.componentRuntime = object2 = ((ComponentRuntime$Builder)object2).addComponent((Component)object3).build();
        object = FirebaseApp$$Lambda$1.lambdaFactory$(this, object);
        this.dataCollectionConfigStorage = object2 = new Lazy((Provider)object);
    }

    public static /* synthetic */ Object access$300() {
        return LOCK;
    }

    public static /* synthetic */ void access$400(FirebaseApp firebaseApp) {
        firebaseApp.initializeAllApis();
    }

    public static /* synthetic */ AtomicBoolean access$500(FirebaseApp firebaseApp) {
        return firebaseApp.automaticResourceManagementEnabled;
    }

    public static /* synthetic */ void access$600(FirebaseApp firebaseApp, boolean bl2) {
        firebaseApp.notifyBackgroundStateChangeListeners(bl2);
    }

    private void checkNotDeleted() {
        Preconditions.checkState(this.deleted.get() ^ true, "FirebaseApp was deleted");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void clearInstancesForTest() {
        Object object = LOCK;
        synchronized (object) {
            Map map = INSTANCES;
            map.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List getAllAppNames() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = LOCK;
        synchronized (object) {
            Iterator iterator2 = INSTANCES;
            iterator2 = iterator2.values();
            iterator2 = iterator2.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = iterator2.hasNext())) {
                    // MONITOREXIT @DISABLED, blocks:[2, 3, 4] lbl9 : MonitorExitStatement: MONITOREXIT : var1_1
                    Collections.sort(arrayList);
                    return arrayList;
                }
                Object object2 = iterator2.next();
                object2 = (FirebaseApp)object2;
                object2 = ((FirebaseApp)object2).getName();
                arrayList.add(object2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static List getApps(Context object) {
        object = LOCK;
        synchronized (object) {
            Object object2 = INSTANCES;
            object2 = object2.values();
            return new ArrayList(object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static FirebaseApp getInstance() {
        Object object = LOCK;
        synchronized (object) {
            Object object2 = INSTANCES;
            CharSequence charSequence = DEFAULT_APP_NAME;
            object2 = object2.get(charSequence);
            object2 = (FirebaseApp)object2;
            if (object2 != null) {
                return object2;
            }
            charSequence = new StringBuilder();
            String string2 = "Default FirebaseApp is not initialized in this process ";
            ((StringBuilder)charSequence).append(string2);
            string2 = ProcessUtils.getMyProcessName();
            ((StringBuilder)charSequence).append(string2);
            string2 = ". Make sure to call FirebaseApp.initializeApp(Context) first.";
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            object2 = new IllegalStateException((String)charSequence);
            throw object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static FirebaseApp getInstance(String string2) {
        Object object = LOCK;
        synchronized (object) {
            Object[] objectArray;
            Object object2 = INSTANCES;
            CharSequence charSequence = FirebaseApp.normalize(string2);
            object2 = object2.get(charSequence);
            object2 = (FirebaseApp)object2;
            if (object2 != null) {
                return object2;
            }
            object2 = FirebaseApp.getAllAppNames();
            boolean bl2 = object2.isEmpty();
            if (bl2) {
                object2 = "";
            } else {
                charSequence = new StringBuilder();
                objectArray = "Available app names: ";
                ((StringBuilder)charSequence).append((String)objectArray);
                objectArray = ", ";
                object2 = TextUtils.join((CharSequence)objectArray, (Iterable)object2);
                ((StringBuilder)charSequence).append((String)object2);
                object2 = ((StringBuilder)charSequence).toString();
            }
            charSequence = "FirebaseApp with name %s doesn't exist. %s";
            int n10 = 2;
            objectArray = new Object[n10];
            objectArray[0] = string2;
            int n11 = 1;
            objectArray[n11] = object2;
            string2 = String.format((String)charSequence, objectArray);
            object2 = new IllegalStateException(string2);
            throw object2;
        }
    }

    public static String getPersistenceKey(String string2, FirebaseOptions object) {
        StringBuilder stringBuilder = new StringBuilder();
        Charset charset = Charset.defaultCharset();
        string2 = Base64Utils.encodeUrlSafeNoPadding(string2.getBytes(charset));
        stringBuilder.append(string2);
        stringBuilder.append("+");
        string2 = ((FirebaseOptions)object).getApplicationId();
        object = Charset.defaultCharset();
        string2 = Base64Utils.encodeUrlSafeNoPadding(string2.getBytes((Charset)object));
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private void initializeAllApis() {
        Object object = this.applicationContext;
        boolean bl2 = UserManagerCompat.isUserUnlocked((Context)object) ^ true;
        String string2 = LOG_TAG;
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            String string3 = this.getName();
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            Log.i((String)string2, (String)object);
            object = this.applicationContext;
            FirebaseApp$UserUnlockReceiver.access$200((Context)object);
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("Device unlocked: initializing all Firebase APIs for app ");
            String string4 = this.getName();
            ((StringBuilder)object).append(string4);
            object = ((StringBuilder)object).toString();
            Log.i((String)string2, (String)object);
            object = this.componentRuntime;
            boolean bl3 = this.isDefaultApp();
            ((ComponentRuntime)object).initializeEagerComponents(bl3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static FirebaseApp initializeApp(Context object) {
        Object object2 = LOCK;
        synchronized (object2) {
            Object object3 = INSTANCES;
            String string2 = DEFAULT_APP_NAME;
            boolean bl2 = object3.containsKey(string2);
            if (bl2) {
                return FirebaseApp.getInstance();
            }
            object3 = FirebaseOptions.fromResource(object);
            if (object3 != null) return FirebaseApp.initializeApp(object, (FirebaseOptions)object3);
            object = LOG_TAG;
            object3 = "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.";
            Log.w((String)object, (String)object3);
            return null;
        }
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return FirebaseApp.initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String string2) {
        Object object;
        FirebaseApp$GlobalBackgroundStateListener.access$100(context);
        string2 = FirebaseApp.normalize(string2);
        Object object2 = context.getApplicationContext();
        if (object2 != null) {
            context = context.getApplicationContext();
        }
        object2 = LOCK;
        synchronized (object2) {
            Map map = INSTANCES;
            boolean bl2 = map.containsKey(string2);
            if (!bl2) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            CharSequence charSequence = new StringBuilder();
            String string3 = "FirebaseApp name ";
            charSequence.append(string3);
            charSequence.append(string2);
            string3 = " already exists!";
            charSequence.append(string3);
            charSequence = charSequence.toString();
            Preconditions.checkState(bl2, charSequence);
            object = "Application context cannot be null.";
            Preconditions.checkNotNull(context, object);
            object = new FirebaseApp(context, string2, firebaseOptions);
            map.put(string2, object);
        }
        super.initializeAllApis();
        return object;
    }

    public static /* synthetic */ DataCollectionConfigStorage lambda$new$0(FirebaseApp object, Context context) {
        String string2 = ((FirebaseApp)object).getPersistenceKey();
        object = (Publisher)((FirebaseApp)object).componentRuntime.get(Publisher.class);
        DataCollectionConfigStorage dataCollectionConfigStorage = new DataCollectionConfigStorage(context, string2, (Publisher)object);
        return dataCollectionConfigStorage;
    }

    private static String normalize(String string2) {
        return string2.trim();
    }

    private void notifyBackgroundStateChangeListeners(boolean bl2) {
        boolean bl3;
        Object object = "Notifying background state change listeners.";
        Log.d((String)LOG_TAG, (String)object);
        Iterator iterator2 = this.backgroundStateChangeListeners.iterator();
        while (bl3 = iterator2.hasNext()) {
            object = (FirebaseApp$BackgroundStateChangeListener)iterator2.next();
            object.onBackgroundStateChanged(bl2);
        }
    }

    private void notifyOnAppDeleted() {
        boolean bl2;
        Iterator iterator2 = this.lifecycleListeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            FirebaseAppLifecycleListener firebaseAppLifecycleListener = (FirebaseAppLifecycleListener)iterator2.next();
            String string2 = this.name;
            FirebaseOptions firebaseOptions = this.options;
            firebaseAppLifecycleListener.onDeleted(string2, firebaseOptions);
        }
    }

    public void addBackgroundStateChangeListener(FirebaseApp$BackgroundStateChangeListener firebaseApp$BackgroundStateChangeListener) {
        this.checkNotDeleted();
        Object object = this.automaticResourceManagementEnabled;
        boolean bl2 = ((AtomicBoolean)object).get();
        if (bl2 && (bl2 = ((BackgroundDetector)(object = BackgroundDetector.getInstance())).isInBackground())) {
            bl2 = true;
            firebaseApp$BackgroundStateChangeListener.onBackgroundStateChanged(bl2);
        }
        this.backgroundStateChangeListeners.add(firebaseApp$BackgroundStateChangeListener);
    }

    public void addLifecycleEventListener(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        this.checkNotDeleted();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.lifecycleListeners.add(firebaseAppLifecycleListener);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void delete() {
        Object object = this.deleted;
        Map map = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (!bl3) {
            return;
        }
        object = LOCK;
        synchronized (object) {
            map = INSTANCES;
            String string2 = this.name;
            map.remove(string2);
        }
        this.notifyOnAppDeleted();
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof FirebaseApp;
        if (!bl2) {
            return false;
        }
        String string2 = this.name;
        object = ((FirebaseApp)object).getName();
        return string2.equals(object);
    }

    public Object get(Class clazz) {
        this.checkNotDeleted();
        return this.componentRuntime.get(clazz);
    }

    public Context getApplicationContext() {
        this.checkNotDeleted();
        return this.applicationContext;
    }

    public String getName() {
        this.checkNotDeleted();
        return this.name;
    }

    public FirebaseOptions getOptions() {
        this.checkNotDeleted();
        return this.options;
    }

    public String getPersistenceKey() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.getName();
        Charset charset = Charset.defaultCharset();
        string2 = Base64Utils.encodeUrlSafeNoPadding(string2.getBytes(charset));
        stringBuilder.append(string2);
        stringBuilder.append("+");
        string2 = this.getOptions().getApplicationId();
        charset = Charset.defaultCharset();
        string2 = Base64Utils.encodeUrlSafeNoPadding(string2.getBytes(charset));
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public void initializeAllComponents() {
        this.componentRuntime.initializeAllComponentsForTests();
    }

    public boolean isDataCollectionDefaultEnabled() {
        this.checkNotDeleted();
        return ((DataCollectionConfigStorage)this.dataCollectionConfigStorage.get()).isEnabled();
    }

    public boolean isDefaultApp() {
        String string2 = this.getName();
        return DEFAULT_APP_NAME.equals(string2);
    }

    public void removeBackgroundStateChangeListener(FirebaseApp$BackgroundStateChangeListener firebaseApp$BackgroundStateChangeListener) {
        this.checkNotDeleted();
        this.backgroundStateChangeListeners.remove(firebaseApp$BackgroundStateChangeListener);
    }

    public void removeLifecycleEventListener(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        this.checkNotDeleted();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.lifecycleListeners.remove(firebaseAppLifecycleListener);
    }

    public void setAutomaticResourceManagementEnabled(boolean bl2) {
        this.checkNotDeleted();
        Object object = this.automaticResourceManagementEnabled;
        boolean bl3 = bl2 ^ true;
        boolean bl4 = ((AtomicBoolean)object).compareAndSet(bl3, bl2);
        if (bl4) {
            object = BackgroundDetector.getInstance();
            bl4 = ((BackgroundDetector)object).isInBackground();
            if (bl2 && bl4) {
                bl2 = true;
                this.notifyBackgroundStateChangeListeners(bl2);
            } else if (!bl2 && bl4) {
                bl2 = false;
                this.notifyBackgroundStateChangeListeners(false);
            }
        }
    }

    public void setDataCollectionDefaultEnabled(Boolean bl2) {
        this.checkNotDeleted();
        ((DataCollectionConfigStorage)this.dataCollectionConfigStorage.get()).setEnabled(bl2);
    }

    public void setDataCollectionDefaultEnabled(boolean bl2) {
        Boolean bl3 = bl2;
        this.setDataCollectionDefaultEnabled(bl3);
    }

    public String toString() {
        Objects$ToStringHelper objects$ToStringHelper = Objects.toStringHelper(this);
        Object object = this.name;
        objects$ToStringHelper = objects$ToStringHelper.add("name", object);
        object = this.options;
        return objects$ToStringHelper.add("options", object).toString();
    }
}

