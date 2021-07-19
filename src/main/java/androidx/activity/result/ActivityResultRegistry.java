/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 */
package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry$1;
import androidx.activity.result.ActivityResultRegistry$2;
import androidx.activity.result.ActivityResultRegistry$3;
import androidx.activity.result.ActivityResultRegistry$CallbackAndContract;
import androidx.activity.result.ActivityResultRegistry$LifecycleContainer;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT = "KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    public final transient Map mKeyToCallback;
    private final Map mKeyToLifecycleContainers;
    private final Map mKeyToRc;
    public ArrayList mLaunchedKeys;
    public final Map mParsedPendingResults;
    public final Bundle mPendingResults;
    private Random mRandom;
    private final Map mRcToKey;

    public ActivityResultRegistry() {
        Serializable serializable;
        this.mRandom = serializable = new Random();
        this.mRcToKey = serializable;
        super();
        this.mKeyToRc = serializable;
        super();
        this.mKeyToLifecycleContainers = serializable;
        super();
        this.mLaunchedKeys = serializable;
        super();
        this.mKeyToCallback = serializable;
        super();
        this.mParsedPendingResults = serializable;
        super();
        this.mPendingResults = serializable;
    }

    private void bindRcKey(int n10, String string2) {
        Map map = this.mRcToKey;
        Integer n11 = n10;
        map.put(n11, string2);
        map = this.mKeyToRc;
        Integer n12 = n10;
        map.put(string2, n12);
    }

    private void doDispatch(String object, int n10, Intent intent, ActivityResultRegistry$CallbackAndContract activityResultRegistry$CallbackAndContract) {
        Object object2;
        if (activityResultRegistry$CallbackAndContract != null && (object2 = activityResultRegistry$CallbackAndContract.mCallback) != null) {
            object = activityResultRegistry$CallbackAndContract.mContract.parseResult(n10, intent);
            object2.onActivityResult(object);
        } else {
            this.mParsedPendingResults.remove(object);
            activityResultRegistry$CallbackAndContract = this.mPendingResults;
            object2 = new ActivityResult(n10, intent);
            activityResultRegistry$CallbackAndContract.putParcelable((String)object, (Parcelable)object2);
        }
    }

    private int generateRandomNumber() {
        Integer n10;
        Map map;
        boolean bl2;
        Random random = this.mRandom;
        int n11 = 0x7FFF0000;
        int n12 = random.nextInt(n11);
        int n13 = 65536;
        while (bl2 = (map = this.mRcToKey).containsKey(n10 = Integer.valueOf(n12 += n13))) {
            random = this.mRandom;
            n12 = random.nextInt(n11);
        }
        return n12;
    }

    private int registerKey(String string2) {
        Integer n10 = (Integer)this.mKeyToRc.get(string2);
        if (n10 != null) {
            return n10;
        }
        int n11 = this.generateRandomNumber();
        this.bindRcKey(n11, string2);
        return n11;
    }

    public final boolean dispatchResult(int n10, int n11, Intent intent) {
        Object object = this.mRcToKey;
        Object object2 = n10;
        if ((object2 = (String)object.get(object2)) == null) {
            return false;
        }
        this.mLaunchedKeys.remove(object2);
        object = (ActivityResultRegistry$CallbackAndContract)this.mKeyToCallback.get(object2);
        this.doDispatch((String)object2, n11, intent, (ActivityResultRegistry$CallbackAndContract)object);
        return true;
    }

    public final boolean dispatchResult(int n10, Object object) {
        Object object2 = this.mRcToKey;
        Object object3 = n10;
        if ((object3 = (String)object2.get(object3)) == null) {
            return false;
        }
        this.mLaunchedKeys.remove(object3);
        object2 = (ActivityResultRegistry$CallbackAndContract)this.mKeyToCallback.get(object3);
        if (object2 != null && (object2 = ((ActivityResultRegistry$CallbackAndContract)object2).mCallback) != null) {
            object2.onActivityResult(object);
        } else {
            this.mPendingResults.remove((String)object3);
            object2 = this.mParsedPendingResults;
            object2.put(object3, object);
        }
        return true;
    }

    public abstract void onLaunch(int var1, ActivityResultContract var2, Object var3, ActivityOptionsCompat var4);

    public final void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Serializable serializable = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        Object object = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (object != null && serializable != null) {
            int n10 = ((ArrayList)object).size();
            for (int i10 = 0; i10 < n10; ++i10) {
                Integer n11 = (Integer)serializable.get(i10);
                int n12 = n11;
                String string2 = (String)((ArrayList)object).get(i10);
                this.bindRcKey(n12, string2);
            }
            this.mLaunchedKeys = serializable = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            serializable = (Random)bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
            this.mRandom = serializable;
            serializable = this.mPendingResults;
            object = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
            bundle = bundle.getBundle((String)object);
            serializable.putAll(bundle);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Collection<Object> collection = this.mRcToKey.keySet();
        Object object = new ArrayList(collection);
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", object);
        collection = this.mRcToKey.values();
        object = new ArrayList(collection);
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", object);
        collection = this.mLaunchedKeys;
        object = new ArrayList(collection);
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", object);
        object = (Bundle)this.mPendingResults.clone();
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", object);
        object = this.mRandom;
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", (Serializable)object);
    }

    public final ActivityResultLauncher register(String string2, ActivityResultContract activityResultContract, ActivityResultCallback object) {
        int n10 = this.registerKey(string2);
        Object object2 = this.mKeyToCallback;
        Object object3 = new ActivityResultRegistry$CallbackAndContract((ActivityResultCallback)object, activityResultContract);
        object2.put(string2, object3);
        object2 = this.mParsedPendingResults;
        boolean bl2 = object2.containsKey(string2);
        if (bl2) {
            object2 = this.mParsedPendingResults.get(string2);
            object3 = this.mParsedPendingResults;
            object3.remove(string2);
            object.onActivityResult(object2);
        }
        if ((object2 = (ActivityResult)this.mPendingResults.getParcelable(string2)) != null) {
            object3 = this.mPendingResults;
            object3.remove(string2);
            int n11 = ((ActivityResult)object2).getResultCode();
            object2 = ((ActivityResult)object2).getData();
            object2 = activityResultContract.parseResult(n11, (Intent)object2);
            object.onActivityResult(object2);
        }
        object = new ActivityResultRegistry$3(this, string2, n10, activityResultContract);
        return object;
    }

    public final ActivityResultLauncher register(String object, LifecycleOwner object2, ActivityResultContract object3, ActivityResultCallback object4) {
        Lifecycle$State lifecycle$State;
        Object object5 = object2.getLifecycle();
        Object object6 = ((Lifecycle)object5).getCurrentState();
        boolean bl2 = object6.isAtLeast(lifecycle$State = Lifecycle$State.STARTED);
        if (!bl2) {
            int n10 = this.registerKey((String)object);
            object6 = (ActivityResultRegistry$LifecycleContainer)this.mKeyToLifecycleContainers.get(object);
            if (object6 == null) {
                object6 = new ActivityResultRegistry$LifecycleContainer((Lifecycle)object5);
            }
            object5 = new ActivityResultRegistry$1(this, (String)object, (ActivityResultCallback)object4, (ActivityResultContract)object3);
            ((ActivityResultRegistry$LifecycleContainer)object6).addObserver((LifecycleEventObserver)object5);
            this.mKeyToLifecycleContainers.put(object, object6);
            object4 = new ActivityResultRegistry$2(this, (String)object, n10, (ActivityResultContract)object3);
            return object4;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("LifecycleOwner ");
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append(" is attempting to register while current state is ");
        object2 = ((Lifecycle)object5).getCurrentState();
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append(". LifecycleOwners must call register before they are STARTED.");
        object2 = ((StringBuilder)object3).toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public final void unregister(String string2) {
        Object object;
        Object object2 = this.mLaunchedKeys;
        boolean bl2 = ((ArrayList)object2).contains(string2);
        if (!bl2 && (object2 = (Integer)this.mKeyToRc.remove(string2)) != null) {
            object = this.mRcToKey;
            object.remove(object2);
        }
        this.mKeyToCallback.remove(string2);
        object2 = this.mParsedPendingResults;
        bl2 = object2.containsKey(string2);
        object = ": ";
        String string3 = "Dropping pending result for request ";
        String string4 = "ActivityResultRegistry";
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append((String)object);
            Object v10 = this.mParsedPendingResults.get(string2);
            ((StringBuilder)object2).append(v10);
            object2 = ((StringBuilder)object2).toString();
            Log.w((String)string4, (String)object2);
            object2 = this.mParsedPendingResults;
            object2.remove(string2);
        }
        if (bl2 = (object2 = this.mPendingResults).containsKey(string2)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append((String)object);
            object = this.mPendingResults.getParcelable(string2);
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            Log.w((String)string4, (String)object2);
            object2 = this.mPendingResults;
            object2.remove(string2);
        }
        if ((object2 = (ActivityResultRegistry$LifecycleContainer)this.mKeyToLifecycleContainers.get(string2)) != null) {
            ((ActivityResultRegistry$LifecycleContainer)object2).clearObservers();
            object2 = this.mKeyToLifecycleContainers;
            object2.remove(string2);
        }
    }
}

