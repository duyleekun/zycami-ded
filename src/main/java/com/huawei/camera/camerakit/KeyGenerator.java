/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult$Key
 *  android.util.Log
 */
package com.huawei.camera.camerakit;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;

public final class KeyGenerator {
    private static final String CAPTURE_REQUEST_KEY = "android.hardware.camera2.CaptureRequest$Key";
    private static final String CAPTURE_RESULT_KEY = "android.hardware.camera2.CaptureResult$Key";
    private static final String CHARACTERISTICS_KEY = "android.hardware.camera2.CameraCharacteristics$Key";
    private static final String TAG = "KeyGenerator";
    private static Constructor captureRequestKeyConstructor;
    private static Constructor captureResultKeyConstructor;
    private static Constructor characteristicsKeyConstructor;

    static {
        block25: {
            Object object;
            boolean bl2;
            int n10;
            StringBuilder stringBuilder;
            GenericDeclaration genericDeclaration;
            Object object2;
            block24: {
                Class<Class> clazz;
                Class[] classArray;
                block23: {
                    object2 = String.class;
                    genericDeclaration = CHARACTERISTICS_KEY;
                    genericDeclaration = Class.forName((String)((Object)genericDeclaration));
                    stringBuilder = null;
                    n10 = 2;
                    bl2 = true;
                    if (genericDeclaration == null) break block23;
                    classArray = new Class[n10];
                    classArray[0] = object2;
                    clazz = Class.class;
                    classArray[bl2] = clazz;
                    genericDeclaration = ((Class)genericDeclaration).getDeclaredConstructor(classArray);
                    characteristicsKeyConstructor = genericDeclaration;
                    if (genericDeclaration == null) break block23;
                    ((Constructor)genericDeclaration).setAccessible(bl2);
                }
                genericDeclaration = CAPTURE_REQUEST_KEY;
                genericDeclaration = Class.forName((String)((Object)genericDeclaration));
                if (genericDeclaration == null) break block24;
                classArray = new Class[n10];
                classArray[0] = object2;
                clazz = Class.class;
                classArray[bl2] = clazz;
                genericDeclaration = ((Class)genericDeclaration).getDeclaredConstructor(classArray);
                captureRequestKeyConstructor = genericDeclaration;
                if (genericDeclaration == null) break block24;
                ((Constructor)genericDeclaration).setAccessible(bl2);
            }
            genericDeclaration = CAPTURE_RESULT_KEY;
            genericDeclaration = Class.forName((String)((Object)genericDeclaration));
            if (genericDeclaration == null) break block25;
            Class[] classArray = new Class[n10];
            classArray[0] = object2;
            object2 = Class.class;
            classArray[bl2] = object2;
            object2 = ((Class)genericDeclaration).getDeclaredConstructor(classArray);
            captureResultKeyConstructor = object2;
            if (object2 == null) break block25;
            try {
                ((Constructor)object2).setAccessible(bl2);
                break block25;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            genericDeclaration = TAG;
            stringBuilder = new StringBuilder();
            classArray = "exception when invoke constructor of Key.";
            stringBuilder.append((String)classArray);
            object = ((Throwable)object).getCause();
            stringBuilder.append(object);
            object = stringBuilder.toString();
            Log.d(genericDeclaration, (String)object);
        }
    }

    private KeyGenerator() {
    }

    public static CaptureRequest.Key generateCaptureRequestKey(String string2, Class object) {
        String string3;
        block8: {
            Object object2;
            Object object3 = captureRequestKeyConstructor;
            string3 = null;
            if (object3 == null) break block8;
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            int n11 = 1;
            objectArray[n11] = object;
            string2 = ((Constructor)object3).newInstance(objectArray);
            boolean bl2 = string2 instanceof CaptureRequest.Key;
            if (!bl2) break block8;
            try {
                string3 = string2 = (CaptureRequest.Key)string2;
                break block8;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InstantiationException instantiationException) {
                // empty catch block
            }
            object = TAG;
            object3 = new StringBuilder();
            objectArray = "new request key exception!";
            ((StringBuilder)object3).append((String)objectArray);
            object2 = ((Throwable)object2).getCause();
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            Log.d((String)object, (String)object2);
        }
        return string3;
    }

    public static CaptureResult.Key generateCaptureResultKey(String string2, Class object) {
        String string3;
        block8: {
            Object object2;
            Object object3 = captureResultKeyConstructor;
            string3 = null;
            if (object3 == null) break block8;
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            int n11 = 1;
            objectArray[n11] = object;
            string2 = ((Constructor)object3).newInstance(objectArray);
            boolean bl2 = string2 instanceof CaptureResult.Key;
            if (!bl2) break block8;
            try {
                string3 = string2 = (CaptureResult.Key)string2;
                break block8;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InstantiationException instantiationException) {
                // empty catch block
            }
            object = TAG;
            object3 = new StringBuilder();
            objectArray = "new result key exception!";
            ((StringBuilder)object3).append((String)objectArray);
            object2 = ((Throwable)object2).getCause();
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            Log.d((String)object, (String)object2);
        }
        return string3;
    }

    public static CameraCharacteristics.Key generateCharacteristicsKey(String string2, Class object) {
        String string3;
        block8: {
            Object object2;
            Object object3 = characteristicsKeyConstructor;
            string3 = null;
            if (object3 == null) break block8;
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            int n11 = 1;
            objectArray[n11] = object;
            string2 = ((Constructor)object3).newInstance(objectArray);
            boolean bl2 = string2 instanceof CameraCharacteristics.Key;
            if (!bl2) break block8;
            try {
                string3 = string2 = (CameraCharacteristics.Key)string2;
                break block8;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InstantiationException instantiationException) {
                // empty catch block
            }
            object = TAG;
            object3 = new StringBuilder();
            objectArray = "new characteristics key exception!";
            ((StringBuilder)object3).append((String)objectArray);
            object2 = ((Throwable)object2).getCause();
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            Log.d((String)object, (String)object2);
        }
        return string3;
    }
}

