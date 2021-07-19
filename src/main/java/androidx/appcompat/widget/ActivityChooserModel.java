/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ResolveInfo
 *  android.database.DataSetObservable
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.widget.ActivityChooserModel$ActivityResolveInfo;
import androidx.appcompat.widget.ActivityChooserModel$ActivitySorter;
import androidx.appcompat.widget.ActivityChooserModel$DefaultSorter;
import androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord;
import androidx.appcompat.widget.ActivityChooserModel$OnChooseActivityListener;
import androidx.appcompat.widget.ActivityChooserModel$PersistHistoryAsyncTask;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParserException;

public class ActivityChooserModel
extends DataSetObservable {
    public static final String ATTRIBUTE_ACTIVITY = "activity";
    public static final String ATTRIBUTE_TIME = "time";
    public static final String ATTRIBUTE_WEIGHT = "weight";
    public static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = 255;
    public static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    public static final String TAG_HISTORICAL_RECORD = "historical-record";
    public static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map sDataModelRegistry;
    private static final Object sRegistryLock;
    private final List mActivities;
    private ActivityChooserModel$OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivityChooserModel$ActivitySorter mActivitySorter;
    public boolean mCanReadHistoricalData;
    public final Context mContext;
    private final List mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    public final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;
    private boolean mReloadActivities;

    static {
        HashMap hashMap = new HashMap();
        sRegistryLock = hashMap;
        sDataModelRegistry = hashMap = new HashMap();
    }

    private ActivityChooserModel(Context object, String string2) {
        boolean bl2;
        Object object2;
        this.mInstanceLock = object2 = new Object();
        object2 = new ArrayList();
        this.mActivities = object2;
        object2 = new ArrayList();
        this.mHistoricalRecords = object2;
        this.mActivitySorter = object2 = new ActivityChooserModel$DefaultSorter();
        this.mHistoryMaxSize = 50;
        this.mCanReadHistoricalData = bl2 = true;
        this.mReadShareHistoryCalled = false;
        this.mHistoricalRecordsChanged = bl2;
        this.mReloadActivities = false;
        this.mContext = object = object.getApplicationContext();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3 && !(bl2 = string2.endsWith((String)(object = HISTORY_FILE_EXTENSION)))) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            this.mHistoryFileName = object;
        } else {
            this.mHistoryFileName = string2;
        }
    }

    private boolean addHistoricalRecord(ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord) {
        List list = this.mHistoricalRecords;
        boolean bl2 = list.add(activityChooserModel$HistoricalRecord);
        if (bl2) {
            boolean bl3;
            this.mHistoricalRecordsChanged = bl3 = true;
            this.pruneExcessiveHistoricalRecordsIfNeeded();
            this.persistHistoricalDataIfNeeded();
            this.sortActivitiesIfNeeded();
            this.notifyChanged();
        }
        return bl2;
    }

    private void ensureConsistentState() {
        boolean bl2 = this.loadActivitiesIfNeeded();
        boolean bl3 = this.readHistoricalDataIfNeeded();
        this.pruneExcessiveHistoricalRecordsIfNeeded();
        if (bl2 |= bl3) {
            this.sortActivitiesIfNeeded();
            this.notifyChanged();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ActivityChooserModel get(Context context, String string2) {
        Object object = sRegistryLock;
        synchronized (object) {
            Map map = sDataModelRegistry;
            Object object2 = map.get(string2);
            object2 = (ActivityChooserModel)((Object)object2);
            if (object2 == null) {
                object2 = new Object(context, string2);
                map.put(string2, object2);
            }
            return object2;
        }
    }

    private boolean loadActivitiesIfNeeded() {
        Object object;
        boolean bl2 = this.mReloadActivities;
        if (bl2 && (object = this.mIntent) != null) {
            this.mReloadActivities = false;
            this.mActivities.clear();
            object = this.mContext.getPackageManager();
            Intent intent = this.mIntent;
            object = object.queryIntentActivities(intent, 0);
            int n10 = object.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                ResolveInfo resolveInfo = (ResolveInfo)object.get(i10);
                List list = this.mActivities;
                ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo = new ActivityChooserModel$ActivityResolveInfo(resolveInfo);
                list.add(activityChooserModel$ActivityResolveInfo);
            }
            return true;
        }
        return false;
    }

    private void persistHistoricalDataIfNeeded() {
        int n10 = this.mReadShareHistoryCalled ? 1 : 0;
        if (n10 != 0) {
            n10 = this.mHistoricalRecordsChanged;
            if (n10 == 0) {
                return;
            }
            n10 = 0;
            Object var2_2 = null;
            this.mHistoricalRecordsChanged = false;
            Object object = this.mHistoryFileName;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                object = new ActivityChooserModel$PersistHistoryAsyncTask(this);
                Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
                int n11 = 2;
                Object[] objectArray = new Object[n11];
                List list = this.mHistoricalRecords;
                Object object2 = new ArrayList(list);
                objectArray[0] = object2;
                n10 = 1;
                objectArray[n10] = object2 = this.mHistoryFileName;
                object.executeOnExecutor(executor, objectArray);
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No preceding call to #readHistoricalData");
        throw illegalStateException;
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        List list = this.mHistoricalRecords;
        int n10 = list.size();
        int n11 = this.mHistoryMaxSize;
        if ((n10 -= n11) <= 0) {
            return;
        }
        this.mHistoricalRecordsChanged = true;
        n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            ActivityChooserModel$HistoricalRecord cfr_ignored_0 = (ActivityChooserModel$HistoricalRecord)this.mHistoricalRecords.remove(0);
        }
    }

    private boolean readHistoricalDataIfNeeded() {
        String string2;
        boolean bl2 = this.mCanReadHistoricalData;
        if (bl2 && (bl2 = this.mHistoricalRecordsChanged) && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.mHistoryFileName)))) {
            this.mCanReadHistoricalData = false;
            this.mReadShareHistoryCalled = bl2 = true;
            this.readHistoricalDataImpl();
            return bl2;
        }
        return false;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void readHistoricalDataImpl() {
        Throwable throwable222;
        Object object;
        block18: {
            Object object2;
            String string2 = "Error reading historical recrod file: ";
            object = this.mContext;
            Object object3 = this.mHistoryFileName;
            object = object.openFileInput(object3);
            try {
                String string3;
                int n10;
                int n11;
                block19: {
                    object3 = Xml.newPullParser();
                    object2 = "UTF-8";
                    object3.setInput((InputStream)object, (String)object2);
                    int n12 = 0;
                    object2 = null;
                    while (n12 != (n11 = 1) && n12 != (n10 = 2)) {
                        n12 = object3.next();
                    }
                    object2 = TAG_HISTORICAL_RECORDS;
                    string3 = object3.getName();
                    n12 = ((String)object2).equals(string3) ? 1 : 0;
                    if (n12 == 0) {
                        object2 = "Share records file does not start with historical-records tag.";
                        object3 = new XmlPullParserException((String)object2);
                        throw object3;
                    }
                    break block19;
                    catch (FileNotFoundException fileNotFoundException) {
                        return;
                    }
                }
                object2 = this.mHistoricalRecords;
                object2.clear();
                while (true) {
                    if ((n10 = object3.next()) == n11) {
                        if (object == null) return;
                        break;
                    }
                    int n13 = 3;
                    float f10 = 4.2E-45f;
                    if (n10 == n13) continue;
                    n13 = 4;
                    f10 = 5.6E-45f;
                    if (n10 == n13) continue;
                    String string4 = TAG_HISTORICAL_RECORD;
                    string3 = object3.getName();
                    n10 = string4.equals(string3) ? 1 : 0;
                    if (n10 == 0) {
                        object2 = "Share records file not well-formed.";
                        object3 = new XmlPullParserException((String)object2);
                        throw object3;
                    }
                    string3 = ATTRIBUTE_ACTIVITY;
                    n13 = 0;
                    f10 = 0.0f;
                    string4 = null;
                    string3 = object3.getAttributeValue(null, string3);
                    String string5 = ATTRIBUTE_TIME;
                    string5 = object3.getAttributeValue(null, string5);
                    long l10 = Long.parseLong(string5);
                    Object object4 = ATTRIBUTE_WEIGHT;
                    string4 = object3.getAttributeValue(null, (String)object4);
                    f10 = Float.parseFloat(string4);
                    object4 = new ActivityChooserModel$HistoricalRecord(string3, l10, f10);
                    object2.add(object4);
                }
            }
            catch (Throwable throwable222) {
                break block18;
            }
            catch (IOException iOException) {
                object2 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                string2 = this.mHistoryFileName;
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                Log.e((String)object2, (String)string2, (Throwable)iOException);
                if (object == null) return;
            }
            catch (XmlPullParserException xmlPullParserException) {
                object2 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                string2 = this.mHistoryFileName;
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                Log.e((String)object2, (String)string2, (Throwable)xmlPullParserException);
                if (object == null) return;
            }
            try {
                ((FileInputStream)object).close();
                return;
            }
            catch (IOException iOException) {}
            return;
        }
        if (object == null) throw throwable222;
        try {
            ((FileInputStream)object).close();
        }
        catch (IOException iOException) {
            throw throwable222;
        }
        throw throwable222;
    }

    private boolean sortActivitiesIfNeeded() {
        boolean bl2;
        Object object = this.mActivitySorter;
        if (object != null && (object = this.mIntent) != null && !(bl2 = (object = this.mActivities).isEmpty()) && !(bl2 = (object = this.mHistoricalRecords).isEmpty())) {
            object = this.mActivitySorter;
            Intent intent = this.mIntent;
            List list = this.mActivities;
            List list2 = Collections.unmodifiableList(this.mHistoricalRecords);
            object.sort(intent, list, list2);
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Intent chooseActivity(int n10) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            ActivityChooserModel$OnChooseActivityListener activityChooserModel$OnChooseActivityListener;
            boolean bl2;
            Object object2 = this.mIntent;
            ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = null;
            if (object2 == null) {
                return null;
            }
            this.ensureConsistentState();
            object2 = this.mActivities;
            Object object3 = object2.get(n10);
            object3 = (ActivityChooserModel$ActivityResolveInfo)object3;
            object3 = ((ActivityChooserModel$ActivityResolveInfo)object3).resolveInfo;
            object3 = ((ResolveInfo)object3).activityInfo;
            Object object4 = ((ActivityInfo)object3).packageName;
            object3 = ((ActivityInfo)object3).name;
            object2 = new ComponentName((String)object4, object3);
            object4 = this.mIntent;
            object3 = new Object((Intent)object4);
            object3.setComponent((ComponentName)object2);
            object4 = this.mActivityChoserModelPolicy;
            if (object4 != null && (bl2 = (activityChooserModel$OnChooseActivityListener = this.mActivityChoserModelPolicy).onChooseActivity(this, (Intent)(object4 = new Intent(object3))))) {
                return null;
            }
            long l10 = System.currentTimeMillis();
            float f10 = 1.0f;
            activityChooserModel$HistoricalRecord = new ActivityChooserModel$HistoricalRecord((ComponentName)object2, l10, f10);
            this.addHistoricalRecord(activityChooserModel$HistoricalRecord);
            return object3;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ResolveInfo getActivity(int n10) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            List list = this.mActivities;
            Object object2 = list.get(n10);
            object2 = (ActivityChooserModel$ActivityResolveInfo)object2;
            return ((ActivityChooserModel$ActivityResolveInfo)object2).resolveInfo;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getActivityCount() {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            List list = this.mActivities;
            return list.size();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getActivityIndex(ResolveInfo resolveInfo) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            List list = this.mActivities;
            int n10 = list.size();
            int n11 = 0;
            while (n11 < n10) {
                Object object2 = list.get(n11);
                object2 = (ActivityChooserModel$ActivityResolveInfo)object2;
                object2 = ((ActivityChooserModel$ActivityResolveInfo)object2).resolveInfo;
                if (object2 == resolveInfo) {
                    return n11;
                }
                ++n11;
            }
            return -1;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ResolveInfo getDefaultActivity() {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            Object object2 = this.mActivities;
            boolean bl2 = object2.isEmpty();
            if (bl2) return null;
            object2 = this.mActivities;
            object2 = object2.get(0);
            object2 = (ActivityChooserModel$ActivityResolveInfo)object2;
            return ((ActivityChooserModel$ActivityResolveInfo)object2).resolveInfo;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getHistoryMaxSize() {
        Object object = this.mInstanceLock;
        synchronized (object) {
            return this.mHistoryMaxSize;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getHistorySize() {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.ensureConsistentState();
            List list = this.mHistoricalRecords;
            return list.size();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Intent getIntent() {
        Object object = this.mInstanceLock;
        synchronized (object) {
            return this.mIntent;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setActivitySorter(ActivityChooserModel$ActivitySorter activityChooserModel$ActivitySorter) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            ActivityChooserModel$ActivitySorter activityChooserModel$ActivitySorter2 = this.mActivitySorter;
            if (activityChooserModel$ActivitySorter2 == activityChooserModel$ActivitySorter) {
                return;
            }
            this.mActivitySorter = activityChooserModel$ActivitySorter;
            boolean bl2 = this.sortActivitiesIfNeeded();
            if (bl2) {
                this.notifyChanged();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setDefaultActivity(int n10) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            float f10;
            this.ensureConsistentState();
            Object object2 = this.mActivities;
            Object object3 = object2.get(n10);
            object3 = (ActivityChooserModel$ActivityResolveInfo)object3;
            object2 = this.mActivities;
            float f11 = 0.0f;
            ComponentName componentName = null;
            object2 = object2.get(0);
            object2 = (ActivityChooserModel$ActivityResolveInfo)object2;
            if (object2 != null) {
                f10 = ((ActivityChooserModel$ActivityResolveInfo)object2).weight;
                f11 = ((ActivityChooserModel$ActivityResolveInfo)object3).weight;
                f10 -= f11;
                f11 = 5.0f;
                f10 += f11;
            } else {
                f10 = 1.0f;
            }
            object3 = ((ActivityChooserModel$ActivityResolveInfo)object3).resolveInfo;
            object3 = ((ResolveInfo)object3).activityInfo;
            String string2 = ((ActivityInfo)object3).packageName;
            object3 = ((ActivityInfo)object3).name;
            componentName = new ComponentName(string2, object3);
            long l10 = System.currentTimeMillis();
            object3 = new Object(componentName, l10, f10);
            this.addHistoricalRecord((ActivityChooserModel$HistoricalRecord)object3);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setHistoryMaxSize(int n10) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            int n11 = this.mHistoryMaxSize;
            if (n11 == n10) {
                return;
            }
            this.mHistoryMaxSize = n10;
            this.pruneExcessiveHistoricalRecordsIfNeeded();
            n10 = this.sortActivitiesIfNeeded() ? 1 : 0;
            if (n10 != 0) {
                this.notifyChanged();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setIntent(Intent intent) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            boolean bl2;
            Intent intent2 = this.mIntent;
            if (intent2 == intent) {
                return;
            }
            this.mIntent = intent;
            this.mReloadActivities = bl2 = true;
            this.ensureConsistentState();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setOnChooseActivityListener(ActivityChooserModel$OnChooseActivityListener activityChooserModel$OnChooseActivityListener) {
        Object object = this.mInstanceLock;
        synchronized (object) {
            this.mActivityChoserModelPolicy = activityChooserModel$OnChooseActivityListener;
            return;
        }
    }
}

