/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Size
 *  android.util.SizeF
 *  android.util.SparseArray
 */
package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle$SavingStateLiveData;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class SavedStateHandle {
    private static final Class[] ACCEPTABLE_CLASSES;
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map mLiveDatas;
    public final Map mRegular;
    private final SavedStateRegistry$SavedStateProvider mSavedStateProvider;
    public final Map mSavedStateProviders;

    static {
        Class clazz;
        Class<float[]> clazz2;
        Class<Constable> clazz3;
        Class<Comparable<Boolean>> clazz4;
        int n10 = 29;
        Class[] classArray = new Class[n10];
        classArray[0] = clazz4 = Boolean.TYPE;
        classArray[1] = boolean[].class;
        classArray[2] = clazz4 = Double.TYPE;
        int n11 = 3;
        classArray[n11] = double[].class;
        classArray[4] = clazz4 = Integer.TYPE;
        classArray[5] = int[].class;
        classArray[6] = clazz3 = Long.TYPE;
        classArray[7] = long[].class;
        classArray[8] = String.class;
        classArray[9] = String[].class;
        classArray[10] = Binder.class;
        classArray[11] = Bundle.class;
        classArray[12] = clazz3 = Byte.TYPE;
        classArray[13] = byte[].class;
        classArray[14] = clazz3 = Character.TYPE;
        classArray[15] = char[].class;
        classArray[16] = CharSequence.class;
        classArray[17] = CharSequence[].class;
        classArray[18] = ArrayList.class;
        classArray[19] = clazz3 = Float.TYPE;
        classArray[20] = clazz2 = float[].class;
        int n12 = 21;
        classArray[n12] = Parcelable.class;
        classArray[22] = Parcelable[].class;
        classArray[23] = Serializable.class;
        clazz3 = Short.TYPE;
        int n13 = 24;
        classArray[n13] = clazz3;
        classArray[25] = short[].class;
        classArray[26] = clazz = SparseArray.class;
        int n14 = Build.VERSION.SDK_INT;
        clazz = n14 >= n12 ? Size.class : clazz4;
        int n15 = 27;
        classArray[n15] = clazz;
        n13 = 28;
        if (n14 >= n12) {
            clazz4 = SizeF.class;
        }
        classArray[n13] = clazz4;
        ACCEPTABLE_CLASSES = classArray;
    }

    public SavedStateHandle() {
        HashMap hashMap = new HashMap();
        this.mSavedStateProviders = hashMap;
        hashMap = new HashMap();
        this.mLiveDatas = hashMap;
        hashMap = new HashMap(this);
        this.mSavedStateProvider = hashMap;
        this.mRegular = hashMap = new HashMap();
    }

    public SavedStateHandle(Map map) {
        HashMap hashMap = new HashMap();
        this.mSavedStateProviders = hashMap;
        hashMap = new HashMap();
        this.mLiveDatas = hashMap;
        hashMap = new HashMap(this);
        this.mSavedStateProvider = hashMap;
        this.mRegular = hashMap = new HashMap(map);
    }

    public static SavedStateHandle createHandle(Bundle object, Bundle object2) {
        int n10;
        Object object3;
        String string2;
        int n11;
        Object object4;
        if (object == null && object2 == null) {
            object = new SavedStateHandle();
            return object;
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (object2 != null) {
            object4 = object2.keySet().iterator();
            while ((n11 = object4.hasNext()) != 0) {
                string2 = (String)object4.next();
                object3 = object2.get(string2);
                hashMap.put(string2, object3);
            }
        }
        if (object == null) {
            object = new SavedStateHandle(hashMap);
            return object;
        }
        object2 = object.getParcelableArrayList(KEYS);
        object4 = VALUES;
        object = object.getParcelableArrayList((String)object4);
        if (object2 != null && object != null && (n10 = ((ArrayList)object2).size()) == (n11 = ((ArrayList)object).size())) {
            object4 = null;
            for (n10 = 0; n10 < (n11 = ((ArrayList)object2).size()); ++n10) {
                string2 = (String)((ArrayList)object2).get(n10);
                object3 = ((ArrayList)object).get(n10);
                hashMap.put(string2, object3);
            }
            object = new SavedStateHandle(hashMap);
            return object;
        }
        object = new IllegalStateException("Invalid bundle passed as restored state");
        throw object;
    }

    private MutableLiveData getLiveDataInternal(String string2, boolean bl2, Object object) {
        SavedStateHandle$SavingStateLiveData savedStateHandle$SavingStateLiveData;
        Object object2 = (MutableLiveData)this.mLiveDatas.get(string2);
        if (object2 != null) {
            return object2;
        }
        object2 = this.mRegular;
        boolean bl3 = object2.containsKey(string2);
        if (bl3) {
            object = this.mRegular.get(string2);
            savedStateHandle$SavingStateLiveData = new SavedStateHandle$SavingStateLiveData(this, string2, object);
        } else {
            savedStateHandle$SavingStateLiveData = bl2 ? new SavedStateHandle$SavingStateLiveData(this, string2, object) : new SavedStateHandle$SavingStateLiveData(this, string2);
        }
        this.mLiveDatas.put(string2, savedStateHandle$SavingStateLiveData);
        return savedStateHandle$SavingStateLiveData;
    }

    private static void validateValue(Object object) {
        if (object == null) {
            return;
        }
        for (Class clazz : ACCEPTABLE_CLASSES) {
            boolean bl2 = clazz.isInstance(object);
            if (!bl2) continue;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't put value with type ");
        object = object.getClass();
        stringBuilder.append(object);
        stringBuilder.append(" into saved state");
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public void clearSavedStateProvider(String string2) {
        this.mSavedStateProviders.remove(string2);
    }

    public boolean contains(String string2) {
        return this.mRegular.containsKey(string2);
    }

    public Object get(String string2) {
        return this.mRegular.get(string2);
    }

    public MutableLiveData getLiveData(String string2) {
        return this.getLiveDataInternal(string2, false, null);
    }

    public MutableLiveData getLiveData(String string2, Object object) {
        return this.getLiveDataInternal(string2, true, object);
    }

    public Set keys() {
        Set set = this.mRegular.keySet();
        HashSet hashSet = new HashSet(set);
        set = this.mSavedStateProviders.keySet();
        hashSet.addAll(set);
        set = this.mLiveDatas.keySet();
        hashSet.addAll(set);
        return hashSet;
    }

    public Object remove(String object) {
        Object v10 = this.mRegular.remove(object);
        Map map = this.mLiveDatas;
        if ((object = (SavedStateHandle$SavingStateLiveData)map.remove(object)) != null) {
            ((SavedStateHandle$SavingStateLiveData)object).detach();
        }
        return v10;
    }

    public SavedStateRegistry$SavedStateProvider savedStateProvider() {
        return this.mSavedStateProvider;
    }

    public void set(String string2, Object object) {
        SavedStateHandle.validateValue(object);
        Object object2 = (MutableLiveData)this.mLiveDatas.get(string2);
        if (object2 != null) {
            ((MutableLiveData)object2).setValue(object);
        } else {
            object2 = this.mRegular;
            object2.put(string2, object);
        }
    }

    public void setSavedStateProvider(String string2, SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider) {
        this.mSavedStateProviders.put(string2, savedStateRegistry$SavedStateProvider);
    }
}

