/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 */
package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat$OnRequestPermissionsResultCallback;
import androidx.core.app.ActivityCompat$RequestPermissionsRequestCodeValidator;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity$1;
import androidx.fragment.app.FragmentActivity$2;
import androidx.fragment.app.FragmentActivity$HostCallbacks;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewLifecycleOwner;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleRegistry;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity
extends ComponentActivity
implements ActivityCompat$OnRequestPermissionsResultCallback,
ActivityCompat$RequestPermissionsRequestCodeValidator {
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public boolean mCreated;
    public final LifecycleRegistry mFragmentLifecycleRegistry;
    public final FragmentController mFragments;
    public boolean mResumed;
    public boolean mStopped;

    public FragmentActivity() {
        Object object = new FragmentActivity$HostCallbacks(this);
        this.mFragments = object = FragmentController.createController((FragmentHostCallback)object);
        this.mFragmentLifecycleRegistry = object = new LifecycleRegistry(this);
        this.mStopped = true;
        this.init();
    }

    public FragmentActivity(int n10) {
        super(n10);
        Object object = new FragmentActivity$HostCallbacks(this);
        this.mFragments = object = FragmentController.createController((FragmentHostCallback)object);
        this.mFragmentLifecycleRegistry = object = new LifecycleRegistry(this);
        this.mStopped = true;
        this.init();
    }

    private void init() {
        Object object = this.getSavedStateRegistry();
        FragmentActivity$1 fragmentActivity$1 = new FragmentActivity$1(this);
        ((SavedStateRegistry)object).registerSavedStateProvider(FRAGMENTS_TAG, fragmentActivity$1);
        object = new FragmentActivity$2(this);
        this.addOnContextAvailableListener((OnContextAvailableListener)object);
    }

    private static boolean markState(FragmentManager object, Lifecycle$State lifecycle$State) {
        boolean bl2;
        object = ((FragmentManager)object).getFragments().iterator();
        boolean bl3 = false;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Lifecycle$State lifecycle$State2;
            boolean bl4;
            Fragment fragment = (Fragment)object.next();
            if (fragment == null) continue;
            Object object3 = fragment.getHost();
            if (object3 != null) {
                object3 = fragment.getChildFragmentManager();
                bl4 = FragmentActivity.markState((FragmentManager)object3, lifecycle$State);
                bl3 |= bl4;
            }
            object3 = fragment.mViewLifecycleOwner;
            boolean bl5 = true;
            if (object3 != null && (bl4 = ((Lifecycle$State)((Object)(object3 = ((FragmentViewLifecycleOwner)object3).getLifecycle().getCurrentState()))).isAtLeast(lifecycle$State2 = Lifecycle$State.STARTED))) {
                object2 = fragment.mViewLifecycleOwner;
                ((FragmentViewLifecycleOwner)object2).setCurrentState(lifecycle$State);
                bl3 = bl5;
            }
            if (!(bl4 = ((Lifecycle$State)((Object)(object3 = fragment.mLifecycleRegistry.getCurrentState()))).isAtLeast(lifecycle$State2 = Lifecycle$State.STARTED))) continue;
            object2 = fragment.mLifecycleRegistry;
            ((LifecycleRegistry)object2).setCurrentState(lifecycle$State);
            bl3 = bl5;
        }
        return bl3;
    }

    public final View dispatchFragmentsOnCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        return this.mFragments.onCreateView(view, string2, context, attributeSet);
    }

    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        super.dump(string2, fileDescriptor, printWriter, stringArray);
        printWriter.print(string2);
        printWriter.print("Local FragmentActivity ");
        int n10 = System.identityHashCode(this);
        CharSequence charSequence = Integer.toHexString(n10);
        printWriter.print((String)charSequence);
        printWriter.println(" State:");
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("  ");
        charSequence = ((StringBuilder)charSequence).toString();
        printWriter.print((String)charSequence);
        printWriter.print("mCreated=");
        boolean bl2 = this.mCreated;
        printWriter.print(bl2);
        printWriter.print(" mResumed=");
        bl2 = this.mResumed;
        printWriter.print(bl2);
        printWriter.print(" mStopped=");
        bl2 = this.mStopped;
        printWriter.print(bl2);
        Object object = this.getApplication();
        if (object != null) {
            object = LoaderManager.getInstance(this);
            ((LoaderManager)object).dump((String)charSequence, fileDescriptor, printWriter, stringArray);
        }
        this.mFragments.getSupportFragmentManager().dump(string2, fileDescriptor, printWriter, stringArray);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public void markFragmentsCreated() {
        Lifecycle$State lifecycle$State;
        FragmentManager fragmentManager;
        boolean bl2;
        while (bl2 = FragmentActivity.markState(fragmentManager = this.getSupportFragmentManager(), lifecycle$State = Lifecycle$State.CREATED)) {
        }
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(n10, n11, intent);
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.noteStateNotSaved();
        this.mFragments.dispatchConfigurationChanged(configuration);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.mFragmentLifecycleRegistry;
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_CREATE;
        ((LifecycleRegistry)object).handleLifecycleEvent(lifecycle$Event);
        this.mFragments.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int n10, Menu menu2) {
        if (n10 == 0) {
            n10 = (int)(super.onCreatePanelMenu(n10, menu2) ? 1 : 0);
            FragmentController fragmentController = this.mFragments;
            MenuInflater menuInflater = this.getMenuInflater();
            int n11 = fragmentController.dispatchCreateOptionsMenu(menu2, menuInflater);
            return (n10 | n11) != 0;
        }
        return super.onCreatePanelMenu(n10, menu2);
    }

    public View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        View view2 = this.dispatchFragmentsOnCreateView(view, string2, context, attributeSet);
        if (view2 == null) {
            return super.onCreateView(view, string2, context, attributeSet);
        }
        return view2;
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        View view = this.dispatchFragmentsOnCreateView(null, string2, context, attributeSet);
        if (view == null) {
            return super.onCreateView(string2, context, attributeSet);
        }
        return view;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_DESTROY;
        lifecycleRegistry.handleLifecycleEvent(lifecycle$Event);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int n10, MenuItem menuItem) {
        int n11 = super.onMenuItemSelected(n10, menuItem);
        if (n11 != 0) {
            return true;
        }
        if (n10 != 0) {
            n11 = 6;
            if (n10 != n11) {
                return false;
            }
            return this.mFragments.dispatchContextItemSelected(menuItem);
        }
        return this.mFragments.dispatchOptionsItemSelected(menuItem);
    }

    public void onMultiWindowModeChanged(boolean bl2) {
        this.mFragments.dispatchMultiWindowModeChanged(bl2);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.noteStateNotSaved();
    }

    public void onPanelClosed(int n10, Menu menu2) {
        if (n10 == 0) {
            FragmentController fragmentController = this.mFragments;
            fragmentController.dispatchOptionsMenuClosed(menu2);
        }
        super.onPanelClosed(n10, menu2);
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_PAUSE;
        lifecycleRegistry.handleLifecycleEvent(lifecycle$Event);
    }

    public void onPictureInPictureModeChanged(boolean bl2) {
        this.mFragments.dispatchPictureInPictureModeChanged(bl2);
    }

    public void onPostResume() {
        super.onPostResume();
        this.onResumeFragments();
    }

    public boolean onPrepareOptionsPanel(View view, Menu menu2) {
        return super.onPreparePanel(0, view, menu2);
    }

    public boolean onPreparePanel(int n10, View view, Menu menu2) {
        if (n10 == 0) {
            n10 = (int)(this.onPrepareOptionsPanel(view, menu2) ? 1 : 0);
            int n11 = this.mFragments.dispatchPrepareOptionsMenu(menu2);
            return (n10 | n11) != 0;
        }
        return super.onPreparePanel(n10, view, menu2);
    }

    public void onRequestPermissionsResult(int n10, String[] stringArray, int[] nArray) {
        this.mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(n10, stringArray, nArray);
    }

    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
    }

    public void onResumeFragments() {
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_RESUME;
        lifecycleRegistry.handleLifecycleEvent(lifecycle$Event);
        this.mFragments.dispatchResume();
    }

    public void onStart() {
        super.onStart();
        Object object = null;
        this.mStopped = false;
        boolean bl2 = this.mCreated;
        if (!bl2) {
            this.mCreated = bl2 = true;
            object = this.mFragments;
            ((FragmentController)object).dispatchActivityCreated();
        }
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        object = this.mFragmentLifecycleRegistry;
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_START;
        ((LifecycleRegistry)object).handleLifecycleEvent(lifecycle$Event);
        this.mFragments.dispatchStart();
    }

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        this.markFragmentsCreated();
        this.mFragments.dispatchStop();
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_STOP;
        lifecycleRegistry.handleLifecycleEvent(lifecycle$Event);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int n10) {
        this.startActivityFromFragment(fragment, intent, n10, null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int n10, Bundle bundle) {
        int n11 = -1;
        if (n10 == n11) {
            ActivityCompat.startActivityForResult(this, intent, n11, bundle);
            return;
        }
        fragment.startActivityForResult(intent, n10, bundle);
    }

    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int n10, Intent intent, int n11, int n12, int n13, Bundle bundle) {
        int n14 = -1;
        if (n10 == n14) {
            ActivityCompat.startIntentSenderForResult(this, intentSender, n10, intent, n11, n12, n13, bundle);
            return;
        }
        fragment.startIntentSenderForResult(intentSender, n10, intent, n11, n12, n13, bundle);
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    public void supportInvalidateOptionsMenu() {
        this.invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    public final void validateRequestPermissionsRequestCode(int n10) {
    }
}

