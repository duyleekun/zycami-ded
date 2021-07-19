/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.settings.CachedSettingsIo;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class SettingsController$1
implements SuccessContinuation {
    public final /* synthetic */ SettingsController this$0;

    public SettingsController$1(SettingsController settingsController) {
        this.this$0 = settingsController;
    }

    public Task then(Void object) {
        boolean bl2;
        object = SettingsController.access$100(this.this$0);
        Object object2 = SettingsController.access$000(this.this$0);
        if ((object = object.invoke((SettingsRequest)object2, bl2 = true)) != null) {
            object2 = SettingsController.access$200(this.this$0).parseSettingsJson((JSONObject)object);
            Object object3 = SettingsController.access$300(this.this$0);
            long l10 = ((SettingsData)object2).getExpiresAtMillis();
            ((CachedSettingsIo)object3).writeCachedSettings(l10, (JSONObject)object);
            object3 = this.this$0;
            String string2 = "Loaded settings: ";
            SettingsController.access$400((SettingsController)object3, (JSONObject)object, string2);
            object = this.this$0;
            object3 = SettingsController.access$000((SettingsController)object).instanceId;
            SettingsController.access$500((SettingsController)object, (String)object3);
            SettingsController.access$600(this.this$0).set(object2);
            object = (TaskCompletionSource)SettingsController.access$700(this.this$0).get();
            object3 = ((SettingsData)object2).getAppSettingsData();
            ((TaskCompletionSource)object).trySetResult(object3);
            object = new TaskCompletionSource();
            object2 = ((SettingsData)object2).getAppSettingsData();
            ((TaskCompletionSource)object).trySetResult(object2);
            object2 = SettingsController.access$700(this.this$0);
            ((AtomicReference)object2).set(object);
        }
        return Tasks.forResult(null);
    }
}

