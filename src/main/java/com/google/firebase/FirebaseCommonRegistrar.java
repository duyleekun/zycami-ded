/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.google.firebase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.firebase.FirebaseCommonRegistrar$$Lambda$1;
import com.google.firebase.FirebaseCommonRegistrar$$Lambda$4;
import com.google.firebase.FirebaseCommonRegistrar$$Lambda$5;
import com.google.firebase.FirebaseCommonRegistrar$$Lambda$6;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor;
import java.util.ArrayList;
import java.util.List;

public class FirebaseCommonRegistrar
implements ComponentRegistrar {
    private static final String ANDROID_INSTALLER = "android-installer";
    private static final String ANDROID_PLATFORM = "android-platform";
    private static final String DEVICE_BRAND = "device-brand";
    private static final String DEVICE_MODEL = "device-model";
    private static final String DEVICE_NAME = "device-name";
    private static final String FIREBASE_ANDROID = "fire-android";
    private static final String FIREBASE_COMMON = "fire-core";
    private static final String KOTLIN = "kotlin";
    private static final String MIN_SDK = "android-min-sdk";
    private static final String TARGET_SDK = "android-target-sdk";

    public static /* synthetic */ String lambda$getComponents$0(Context context) {
        if ((context = context.getApplicationInfo()) != null) {
            return String.valueOf(context.targetSdkVersion);
        }
        return "";
    }

    public static /* synthetic */ String lambda$getComponents$1(Context context) {
        int n10;
        int n11;
        if ((context = context.getApplicationInfo()) != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 24)) {
            return String.valueOf(context.minSdkVersion);
        }
        return "";
    }

    public static /* synthetic */ String lambda$getComponents$2(Context context) {
        String string2;
        boolean bl2;
        String string3;
        PackageManager packageManager;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11 && (n11 = (int)((packageManager = context.getPackageManager()).hasSystemFeature(string3 = "android.hardware.type.television") ? 1 : 0)) != 0) {
            return "tv";
        }
        n11 = 20;
        if (n10 >= n11 && (n11 = (int)((packageManager = context.getPackageManager()).hasSystemFeature(string3 = "android.hardware.type.watch") ? 1 : 0)) != 0) {
            return "watch";
        }
        n11 = 23;
        if (n10 >= n11 && (n11 = (int)((packageManager = context.getPackageManager()).hasSystemFeature(string3 = "android.hardware.type.automotive") ? 1 : 0)) != 0) {
            return "auto";
        }
        n11 = 26;
        if (n10 >= n11 && (bl2 = (context = context.getPackageManager()).hasSystemFeature(string2 = "android.hardware.type.embedded"))) {
            return "embedded";
        }
        return "";
    }

    public static /* synthetic */ String lambda$getComponents$3(Context object) {
        PackageManager packageManager = object.getPackageManager();
        object = object.getPackageName();
        object = (object = packageManager.getInstallerPackageName((String)object)) != null ? FirebaseCommonRegistrar.safeValue((String)object) : "";
        return object;
    }

    private static String safeValue(String string2) {
        char c10 = '_';
        return string2.replace(' ', c10).replace('/', c10);
    }

    public List getComponents() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = DefaultUserAgentPublisher.component();
        arrayList.add(object);
        object = DefaultHeartBeatInfo.component();
        arrayList.add(object);
        int n10 = Build.VERSION.SDK_INT;
        object = String.valueOf(n10);
        object = LibraryVersionComponent.create(FIREBASE_ANDROID, (String)object);
        arrayList.add(object);
        object = LibraryVersionComponent.create(FIREBASE_COMMON, "19.5.0");
        arrayList.add(object);
        object = FirebaseCommonRegistrar.safeValue(Build.PRODUCT);
        object = LibraryVersionComponent.create(DEVICE_NAME, (String)object);
        arrayList.add(object);
        object = FirebaseCommonRegistrar.safeValue(Build.DEVICE);
        object = LibraryVersionComponent.create(DEVICE_MODEL, (String)object);
        arrayList.add(object);
        object = FirebaseCommonRegistrar.safeValue(Build.BRAND);
        object = LibraryVersionComponent.create(DEVICE_BRAND, (String)object);
        arrayList.add(object);
        object = FirebaseCommonRegistrar$$Lambda$1.lambdaFactory$();
        object = LibraryVersionComponent.fromContext(TARGET_SDK, (LibraryVersionComponent$VersionExtractor)object);
        arrayList.add(object);
        object = FirebaseCommonRegistrar$$Lambda$4.lambdaFactory$();
        object = LibraryVersionComponent.fromContext(MIN_SDK, (LibraryVersionComponent$VersionExtractor)object);
        arrayList.add(object);
        object = FirebaseCommonRegistrar$$Lambda$5.lambdaFactory$();
        object = LibraryVersionComponent.fromContext(ANDROID_PLATFORM, (LibraryVersionComponent$VersionExtractor)object);
        arrayList.add(object);
        object = FirebaseCommonRegistrar$$Lambda$6.lambdaFactory$();
        String string2 = ANDROID_INSTALLER;
        object = LibraryVersionComponent.fromContext(string2, (LibraryVersionComponent$VersionExtractor)object);
        arrayList.add(object);
        object = KotlinDetector.detectVersion();
        if (object != null) {
            string2 = KOTLIN;
            object = LibraryVersionComponent.create(string2, (String)object);
            arrayList.add(object);
        }
        return arrayList;
    }
}

