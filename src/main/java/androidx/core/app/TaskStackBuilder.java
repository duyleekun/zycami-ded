/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Log
 */
package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder$SupportParentable;
import androidx.core.content.ContextCompat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder
implements Iterable {
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList mIntents;
    private final Context mSourceContext;

    private TaskStackBuilder(Context context) {
        ArrayList arrayList;
        this.mIntents = arrayList = new ArrayList();
        this.mSourceContext = context;
    }

    public static TaskStackBuilder create(Context context) {
        TaskStackBuilder taskStackBuilder = new TaskStackBuilder(context);
        return taskStackBuilder;
    }

    public static TaskStackBuilder from(Context context) {
        return TaskStackBuilder.create(context);
    }

    public TaskStackBuilder addNextIntent(Intent intent) {
        this.mIntents.add(intent);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent intent) {
        ComponentName componentName = intent.getComponent();
        if (componentName == null) {
            componentName = this.mSourceContext.getPackageManager();
            componentName = intent.resolveActivity((PackageManager)componentName);
        }
        if (componentName != null) {
            this.addParentStack(componentName);
        }
        this.addNextIntent(intent);
        return this;
    }

    public TaskStackBuilder addParentStack(Activity activity) {
        Activity activity2;
        boolean bl2 = activity instanceof TaskStackBuilder$SupportParentable;
        if (bl2) {
            activity2 = activity;
            activity2 = ((TaskStackBuilder$SupportParentable)activity).getSupportParentActivityIntent();
        } else {
            bl2 = false;
            activity2 = null;
        }
        if (activity2 == null) {
            activity2 = NavUtils.getParentActivityIntent(activity);
        }
        if (activity2 != null) {
            activity = activity2.getComponent();
            if (activity == null) {
                activity = this.mSourceContext.getPackageManager();
                activity = activity2.resolveActivity((PackageManager)activity);
            }
            this.addParentStack((ComponentName)activity);
            this.addNextIntent((Intent)activity2);
        }
        return this;
    }

    public TaskStackBuilder addParentStack(ComponentName componentName) {
        Serializable serializable = this.mIntents;
        int n10 = serializable.size();
        Object object = this.mSourceContext;
        try {
            componentName = NavUtils.getParentActivityIntent((Context)object, componentName);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e((String)TAG, (String)"Bad ComponentName while traversing activity parent metadata");
            serializable = new IllegalArgumentException(nameNotFoundException);
            throw serializable;
        }
        while (componentName != null) {
            object = this.mIntents;
            ((ArrayList)object).add(n10, componentName);
            object = this.mSourceContext;
            componentName = componentName.getComponent();
            componentName = NavUtils.getParentActivityIntent((Context)object, componentName);
        }
        return this;
    }

    public TaskStackBuilder addParentStack(Class clazz) {
        Context context = this.mSourceContext;
        ComponentName componentName = new ComponentName(context, clazz);
        return this.addParentStack(componentName);
    }

    public Intent editIntentAt(int n10) {
        return (Intent)this.mIntents.get(n10);
    }

    public Intent getIntent(int n10) {
        return this.editIntentAt(n10);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    public Intent[] getIntents() {
        ArrayList arrayList = this.mIntents;
        int n10 = arrayList.size();
        Intent[] intentArray = new Intent[n10];
        if (n10 == 0) {
            return intentArray;
        }
        ArrayList arrayList2 = this.mIntents;
        Intent intent = null;
        arrayList2 = (Intent)arrayList2.get(0);
        Intent intent2 = new Intent((Intent)arrayList2);
        int n11 = 0x1000C000;
        intentArray[0] = intent2 = intent2.addFlags(n11);
        for (int i10 = 1; i10 < n10; ++i10) {
            intent = (Intent)this.mIntents.get(i10);
            arrayList2 = new Intent(intent);
            intentArray[i10] = arrayList2;
        }
        return intentArray;
    }

    public PendingIntent getPendingIntent(int n10, int n11) {
        return this.getPendingIntent(n10, n11, null);
    }

    public PendingIntent getPendingIntent(int n10, int n11, Bundle bundle) {
        Intent[] intentArray = this.mIntents;
        boolean bl2 = intentArray.isEmpty();
        if (!bl2) {
            intentArray = this.mIntents;
            Intent intent = new Intent[intentArray.size()];
            intentArray = intentArray.toArray((T[])intent);
            Intent intent2 = intentArray[0];
            intent = new Intent(intent2);
            int n12 = 0x1000C000;
            intentArray[0] = intent = intent.addFlags(n12);
            int n13 = Build.VERSION.SDK_INT;
            int n14 = 16;
            if (n13 >= n14) {
                return PendingIntent.getActivities((Context)this.mSourceContext, (int)n10, (Intent[])intentArray, (int)n11, (Bundle)bundle);
            }
            return PendingIntent.getActivities((Context)this.mSourceContext, (int)n10, (Intent[])intentArray, (int)n11);
        }
        IllegalStateException illegalStateException = new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        throw illegalStateException;
    }

    public Iterator iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        this.startActivities(null);
    }

    public void startActivities(Bundle object) {
        Intent intent = this.mIntents;
        int n10 = intent.isEmpty();
        if (n10 == 0) {
            intent = this.mIntents;
            int n11 = intent.size();
            Intent intent2 = new Intent[n11];
            intent = intent.toArray((T[])intent2);
            Intent intent3 = intent[0];
            intent2 = new Intent(intent3);
            int n12 = 0x1000C000;
            intent[0] = intent2 = intent2.addFlags(n12);
            intent2 = this.mSourceContext;
            boolean bl2 = ContextCompat.startActivities((Context)intent2, (Intent[])intent, object);
            if (!bl2) {
                n11 = ((Intent[])intent).length + -1;
                intent = intent[n11];
                object = new Intent(intent);
                n10 = 0x10000000;
                object.addFlags(n10);
                intent = this.mSourceContext;
                intent.startActivity((Intent)object);
            }
            return;
        }
        object = new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        throw object;
    }
}

