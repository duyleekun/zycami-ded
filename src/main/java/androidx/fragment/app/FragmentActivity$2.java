/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcelable
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Parcelable;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentController;
import androidx.savedstate.SavedStateRegistry;

public class FragmentActivity$2
implements OnContextAvailableListener {
    public final /* synthetic */ FragmentActivity this$0;

    public FragmentActivity$2(FragmentActivity fragmentActivity) {
        this.this$0 = fragmentActivity;
    }

    public void onContextAvailable(Context object) {
        this.this$0.mFragments.attachHost(null);
        object = this.this$0.getSavedStateRegistry();
        Object object2 = "android:support:fragments";
        object = ((SavedStateRegistry)object).consumeRestoredStateForKey((String)object2);
        if (object != null) {
            object = object.getParcelable((String)object2);
            object2 = this.this$0.mFragments;
            ((FragmentController)object2).restoreSaveState((Parcelable)object);
        }
    }
}

