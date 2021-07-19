/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.StatFs
 *  android.text.TextUtils
 */
package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.BatteryState;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem$Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class CrashlyticsReportDataCapture {
    private static final Map ARCHITECTURES_BY_NAME;
    public static final String GENERATOR;
    public static final int GENERATOR_TYPE = 3;
    public static final int REPORT_ANDROID_PLATFORM = 4;
    public static final int SESSION_ANDROID_PLATFORM = 3;
    public static final String SIGNAL_DEFAULT = "0";
    private final AppData appData;
    private final Context context;
    private final IdManager idManager;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;

    static {
        Cloneable cloneable;
        ARCHITECTURES_BY_NAME = cloneable = new Cloneable();
        Integer n10 = 5;
        cloneable.put("armeabi", n10);
        n10 = 6;
        cloneable.put("armeabi-v7a", n10);
        n10 = 9;
        cloneable.put("arm64-v8a", n10);
        Object[] objectArray = Integer.valueOf(0);
        cloneable.put("x86", objectArray);
        int n11 = 1;
        Integer n12 = n11;
        cloneable.put("x86_64", n12);
        cloneable = Locale.US;
        objectArray = new Object[n11];
        objectArray[0] = "17.4.0";
        GENERATOR = String.format(cloneable, "Crashlytics Android SDK/%s", objectArray);
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, AppData appData, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.context = context;
        this.idManager = idManager;
        this.appData = appData;
        this.stackTraceTrimmingStrategy = stackTraceTrimmingStrategy;
    }

    private CrashlyticsReport$Builder buildReportData() {
        CrashlyticsReport$Builder crashlyticsReport$Builder = CrashlyticsReport.builder().setSdkVersion("17.4.0");
        String string2 = this.appData.googleAppId;
        crashlyticsReport$Builder = crashlyticsReport$Builder.setGmpAppId(string2);
        string2 = this.idManager.getCrashlyticsInstallId();
        crashlyticsReport$Builder = crashlyticsReport$Builder.setInstallationUuid(string2);
        string2 = this.appData.versionCode;
        crashlyticsReport$Builder = crashlyticsReport$Builder.setBuildVersion(string2);
        string2 = this.appData.versionName;
        return crashlyticsReport$Builder.setDisplayVersion(string2).setPlatform(4);
    }

    private static int getDeviceArchitecture() {
        Object object = Build.CPU_ABI;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        int n10 = 7;
        if (bl2) {
            return n10;
        }
        Map map = ARCHITECTURES_BY_NAME;
        Locale locale = Locale.US;
        object = ((String)object).toLowerCase(locale);
        if ((object = (Integer)map.get(object)) == null) {
            return n10;
        }
        return (Integer)object;
    }

    private CrashlyticsReport$Session$Event$Application$Execution$BinaryImage populateBinaryImageData() {
        CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder = CrashlyticsReport$Session$Event$Application$Execution$BinaryImage.builder();
        long l10 = 0L;
        crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder = crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder.setBaseAddress(l10).setSize(l10);
        String string2 = this.appData.packageName;
        crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder = crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder.setName(string2);
        string2 = this.appData.buildId;
        return crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder.setUuid(string2).build();
    }

    private ImmutableList populateBinaryImagesList() {
        CrashlyticsReport$Session$Event$Application$Execution$BinaryImage crashlyticsReport$Session$Event$Application$Execution$BinaryImage = this.populateBinaryImageData();
        Object[] objectArray = new CrashlyticsReport$Session$Event$Application$Execution$BinaryImage[]{crashlyticsReport$Session$Event$Application$Execution$BinaryImage};
        return ImmutableList.from(objectArray);
    }

    private CrashlyticsReport$Session$Event$Application populateEventApplicationData(int n10, TrimmedThrowableData object, Thread thread, int n11, int n12, boolean bl2) {
        Object object2 = this.appData.packageName;
        Object object3 = this.context;
        if ((object2 = CommonUtils.getAppProcessInfo((String)object2, object3)) != null) {
            int n13 = ((ActivityManager.RunningAppProcessInfo)object2).importance;
            int n14 = 100;
            if (n13 != n14) {
                n13 = 1;
            } else {
                n13 = 0;
                object2 = null;
            }
            object2 = n13 != 0;
        } else {
            boolean bl3 = false;
            object2 = null;
        }
        CrashlyticsReport$Session$Event$Application$Builder crashlyticsReport$Session$Event$Application$Builder = CrashlyticsReport$Session$Event$Application.builder().setBackground((Boolean)object2).setUiOrientation(n10);
        object2 = this;
        object3 = object;
        object = this.populateExecutionData((TrimmedThrowableData)object, thread, n11, n12, bl2);
        return crashlyticsReport$Session$Event$Application$Builder.setExecution((CrashlyticsReport$Session$Event$Application$Execution)object).build();
    }

    private CrashlyticsReport$Session$Event$Device populateEventDeviceData(int n10) {
        BatteryState batteryState = BatteryState.get(this.context);
        Number number = batteryState.getBatteryLevel();
        if (number != null) {
            double d10 = number.doubleValue();
            number = d10;
        } else {
            number = null;
        }
        int n11 = batteryState.getBatteryVelocity();
        boolean bl2 = CommonUtils.getProximitySensorEnabled(this.context);
        long l10 = CommonUtils.getTotalRamInBytes();
        long l11 = CommonUtils.calculateFreeRamInBytes(this.context);
        l10 -= l11;
        l11 = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
        return CrashlyticsReport$Session$Event$Device.builder().setBatteryLevel((Double)number).setBatteryVelocity(n11).setProximityOn(bl2).setOrientation(n10).setRamUsed(l10).setDiskUsed(l11).build();
    }

    private CrashlyticsReport$Session$Event$Application$Execution$Exception populateExceptionData(TrimmedThrowableData trimmedThrowableData, int n10, int n11) {
        return this.populateExceptionData(trimmedThrowableData, n10, n11, 0);
    }

    private CrashlyticsReport$Session$Event$Application$Execution$Exception populateExceptionData(TrimmedThrowableData object, int n10, int n11, int n12) {
        Object object2;
        Object object3 = ((TrimmedThrowableData)object).className;
        Object object4 = ((TrimmedThrowableData)object).localizedMessage;
        StackTraceElement[] stackTraceElementArray = ((TrimmedThrowableData)object).stacktrace;
        int n13 = 0;
        if (stackTraceElementArray == null) {
            stackTraceElementArray = new StackTraceElement[]{};
        }
        object = ((TrimmedThrowableData)object).cause;
        if (n12 >= n11) {
            object2 = object;
            while (object2 != null) {
                object2 = ((TrimmedThrowableData)object2).cause;
                ++n13;
            }
        }
        object2 = CrashlyticsReport$Session$Event$Application$Execution$Exception.builder();
        object3 = ((CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder)object2).setType((String)object3).setReason((String)object4);
        object4 = ImmutableList.from(this.populateFramesList(stackTraceElementArray, n10));
        object3 = ((CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder)object3).setFrames((ImmutableList)object4).setOverflowCount(n13);
        if (object != null && n13 == 0) {
            object = this.populateExceptionData((TrimmedThrowableData)object, n10, n11, ++n12);
            ((CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder)object3).setCausedBy((CrashlyticsReport$Session$Event$Application$Execution$Exception)object);
        }
        return ((CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder)object3).build();
    }

    private CrashlyticsReport$Session$Event$Application$Execution populateExecutionData(TrimmedThrowableData object, Thread object2, int n10, int n11, boolean bl2) {
        CrashlyticsReport$Session$Event$Application$Execution$Builder crashlyticsReport$Session$Event$Application$Execution$Builder = CrashlyticsReport$Session$Event$Application$Execution.builder();
        object2 = this.populateThreadsList((TrimmedThrowableData)object, (Thread)object2, n10, bl2);
        object2 = crashlyticsReport$Session$Event$Application$Execution$Builder.setThreads((ImmutableList)object2);
        object = this.populateExceptionData((TrimmedThrowableData)object, n10, n11);
        object = ((CrashlyticsReport$Session$Event$Application$Execution$Builder)object2).setException((CrashlyticsReport$Session$Event$Application$Execution$Exception)object);
        object2 = this.populateSignalData();
        object = ((CrashlyticsReport$Session$Event$Application$Execution$Builder)object).setSignal((CrashlyticsReport$Session$Event$Application$Execution$Signal)object2);
        object2 = this.populateBinaryImagesList();
        return ((CrashlyticsReport$Session$Event$Application$Execution$Builder)object).setBinaries((ImmutableList)object2).build();
    }

    private CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame populateFrameData(StackTraceElement stackTraceElement, CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder) {
        long l10;
        int n10 = stackTraceElement.isNativeMethod();
        long l11 = 0L;
        if (n10 != 0) {
            n10 = stackTraceElement.getLineNumber();
            l10 = Math.max((long)n10, l11);
        } else {
            l10 = l11;
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = stackTraceElement.getClassName();
        charSequence.append(string2);
        charSequence.append(".");
        string2 = stackTraceElement.getMethodName();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        string2 = stackTraceElement.getFileName();
        int n11 = stackTraceElement.isNativeMethod();
        if (n11 == 0 && (n11 = stackTraceElement.getLineNumber()) > 0) {
            int n12 = stackTraceElement.getLineNumber();
            l11 = n12;
        }
        return crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder.setPc(l10).setSymbol((String)charSequence).setFile(string2).setOffset(l11).build();
    }

    private ImmutableList populateFramesList(StackTraceElement[] stackTraceElementArray, int n10) {
        ArrayList<CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame> arrayList = new ArrayList<CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame>();
        for (StackTraceElement stackTraceElement : stackTraceElementArray) {
            CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder = CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame.builder().setImportance(n10);
            CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame object = this.populateFrameData(stackTraceElement, crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder);
            arrayList.add(object);
        }
        return ImmutableList.from(arrayList);
    }

    private CrashlyticsReport$Session$Application populateSessionApplicationData() {
        CrashlyticsReport$Session$Application$Builder crashlyticsReport$Session$Application$Builder = CrashlyticsReport$Session$Application.builder();
        String string2 = this.idManager.getAppIdentifier();
        crashlyticsReport$Session$Application$Builder = crashlyticsReport$Session$Application$Builder.setIdentifier(string2);
        string2 = this.appData.versionCode;
        crashlyticsReport$Session$Application$Builder = crashlyticsReport$Session$Application$Builder.setVersion(string2);
        string2 = this.appData.versionName;
        crashlyticsReport$Session$Application$Builder = crashlyticsReport$Session$Application$Builder.setDisplayVersion(string2);
        string2 = this.idManager.getCrashlyticsInstallId();
        crashlyticsReport$Session$Application$Builder = crashlyticsReport$Session$Application$Builder.setInstallationUuid(string2);
        string2 = this.appData.unityVersionProvider.getUnityVersion();
        if (string2 != null) {
            CrashlyticsReport$Session$Application$Builder crashlyticsReport$Session$Application$Builder2 = crashlyticsReport$Session$Application$Builder.setDevelopmentPlatform("Unity");
            crashlyticsReport$Session$Application$Builder2.setDevelopmentPlatformVersion(string2);
        }
        return crashlyticsReport$Session$Application$Builder.build();
    }

    private CrashlyticsReport$Session populateSessionData(String object, long l10) {
        object = CrashlyticsReport$Session.builder().setStartedAt(l10).setIdentifier((String)object);
        Object object2 = GENERATOR;
        object = ((CrashlyticsReport$Session$Builder)object).setGenerator((String)object2);
        object2 = this.populateSessionApplicationData();
        object = ((CrashlyticsReport$Session$Builder)object).setApp((CrashlyticsReport$Session$Application)object2);
        object2 = this.populateSessionOperatingSystemData();
        object = ((CrashlyticsReport$Session$Builder)object).setOs((CrashlyticsReport$Session$OperatingSystem)object2);
        object2 = this.populateSessionDeviceData();
        return ((CrashlyticsReport$Session$Builder)object).setDevice((CrashlyticsReport$Session$Device)object2).setGeneratorType(3).build();
    }

    private CrashlyticsReport$Session$Device populateSessionDeviceData() {
        Object object = Environment.getDataDirectory().getPath();
        StatFs statFs = new StatFs((String)object);
        int n10 = CrashlyticsReportDataCapture.getDeviceArchitecture();
        int n11 = Runtime.getRuntime().availableProcessors();
        long l10 = CommonUtils.getTotalRamInBytes();
        long l11 = statFs.getBlockCount();
        long l12 = statFs.getBlockSize();
        boolean bl2 = CommonUtils.isEmulator(this.context);
        int n12 = CommonUtils.getDeviceState(this.context);
        String string2 = Build.MANUFACTURER;
        String string3 = Build.PRODUCT;
        object = CrashlyticsReport$Session$Device.builder().setArch(n10);
        String string4 = Build.MODEL;
        return ((CrashlyticsReport$Session$Device$Builder)object).setModel(string4).setCores(n11).setRam(l10).setDiskSpace(l11 *= l12).setSimulator(bl2).setState(n12).setManufacturer(string2).setModelClass(string3).build();
    }

    private CrashlyticsReport$Session$OperatingSystem populateSessionOperatingSystemData() {
        CrashlyticsReport$Session$OperatingSystem$Builder crashlyticsReport$Session$OperatingSystem$Builder = CrashlyticsReport$Session$OperatingSystem.builder().setPlatform(3);
        String string2 = Build.VERSION.RELEASE;
        crashlyticsReport$Session$OperatingSystem$Builder = crashlyticsReport$Session$OperatingSystem$Builder.setVersion(string2);
        string2 = Build.VERSION.CODENAME;
        crashlyticsReport$Session$OperatingSystem$Builder = crashlyticsReport$Session$OperatingSystem$Builder.setBuildVersion(string2);
        boolean bl2 = CommonUtils.isRooted(this.context);
        return crashlyticsReport$Session$OperatingSystem$Builder.setJailbroken(bl2).build();
    }

    private CrashlyticsReport$Session$Event$Application$Execution$Signal populateSignalData() {
        CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder crashlyticsReport$Session$Event$Application$Execution$Signal$Builder = CrashlyticsReport$Session$Event$Application$Execution$Signal.builder();
        String string2 = SIGNAL_DEFAULT;
        return crashlyticsReport$Session$Event$Application$Execution$Signal$Builder.setName(string2).setCode(string2).setAddress(0L).build();
    }

    private CrashlyticsReport$Session$Event$Application$Execution$Thread populateThreadData(Thread thread, StackTraceElement[] stackTraceElementArray) {
        return this.populateThreadData(thread, stackTraceElementArray, 0);
    }

    private CrashlyticsReport$Session$Event$Application$Execution$Thread populateThreadData(Thread object, StackTraceElement[] object2, int n10) {
        CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder crashlyticsReport$Session$Event$Application$Execution$Thread$Builder = CrashlyticsReport$Session$Event$Application$Execution$Thread.builder();
        object = ((Thread)object).getName();
        object = crashlyticsReport$Session$Event$Application$Execution$Thread$Builder.setName((String)object).setImportance(n10);
        object2 = ImmutableList.from(this.populateFramesList((StackTraceElement[])object2, n10));
        return ((CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder)object).setFrames((ImmutableList)object2).build();
    }

    private ImmutableList populateThreadsList(TrimmedThrowableData object, Thread thread, int n10, boolean bl2) {
        ArrayList<StackTraceElement[]> arrayList = new ArrayList<StackTraceElement[]>();
        object = ((TrimmedThrowableData)object).stacktrace;
        object = this.populateThreadData(thread, (StackTraceElement[])object, n10);
        arrayList.add((StackTraceElement[])object);
        if (bl2) {
            object = Thread.getAllStackTraces().entrySet().iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Object object2 = (StackTraceElement[])object.next();
                Thread thread2 = (Thread)object2.getKey();
                boolean bl3 = thread2.equals(thread);
                if (bl3) continue;
                StackTraceTrimmingStrategy stackTraceTrimmingStrategy = this.stackTraceTrimmingStrategy;
                object2 = (StackTraceElement[])object2.getValue();
                object2 = stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[])object2);
                object2 = this.populateThreadData(thread2, (StackTraceElement[])object2);
                arrayList.add((StackTraceElement[])object2);
            }
        }
        return ImmutableList.from(arrayList);
    }

    public CrashlyticsReport$Session$Event captureEventData(Throwable throwable, Thread thread, String string2, long l10, int n10, int n11, boolean bl2) {
        int n12 = this.context.getResources().getConfiguration().orientation;
        Object object = this.stackTraceTrimmingStrategy;
        Object object2 = throwable;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(throwable, (StackTraceTrimmingStrategy)object);
        object = CrashlyticsReport$Session$Event.builder();
        object2 = string2;
        CrashlyticsReport$Session$Event$Builder crashlyticsReport$Session$Event$Builder = ((CrashlyticsReport$Session$Event$Builder)object).setType(string2).setTimestamp(l10);
        object = this;
        object = this.populateEventApplicationData(n12, trimmedThrowableData, thread, n10, n11, bl2);
        object = crashlyticsReport$Session$Event$Builder.setApp((CrashlyticsReport$Session$Event$Application)object);
        object2 = this.populateEventDeviceData(n12);
        return ((CrashlyticsReport$Session$Event$Builder)object).setDevice((CrashlyticsReport$Session$Event$Device)object2).build();
    }

    public CrashlyticsReport captureReportData(String object, long l10) {
        CrashlyticsReport$Builder crashlyticsReport$Builder = this.buildReportData();
        object = this.populateSessionData((String)object, l10);
        return crashlyticsReport$Builder.setSession((CrashlyticsReport$Session)object).build();
    }
}

