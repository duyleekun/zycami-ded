/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 */
package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentController {
    private final FragmentHostCallback mHost;

    private FragmentController(FragmentHostCallback fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    public static FragmentController createController(FragmentHostCallback fragmentHostCallback) {
        fragmentHostCallback = (FragmentHostCallback)Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null");
        FragmentController fragmentController = new FragmentController(fragmentHostCallback);
        return fragmentController;
    }

    public void attachHost(Fragment fragment) {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        fragmentHostCallback.mFragmentManager.attachController(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(configuration);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(menu2, menuInflater);
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory();
    }

    public void dispatchMultiWindowModeChanged(boolean bl2) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(bl2);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu2) {
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(menu2);
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    public void dispatchPictureInPictureModeChanged(boolean bl2) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(bl2);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu2) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu2);
    }

    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.mHost.mFragmentManager.dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.mFragmentManager.dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.mFragmentManager.dispatchStop();
    }

    public void doLoaderDestroy() {
    }

    public void doLoaderRetain() {
    }

    public void doLoaderStart() {
    }

    public void doLoaderStop(boolean bl2) {
    }

    public void dumpLoaders(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions(true);
    }

    public Fragment findFragmentByWho(String string2) {
        return this.mHost.mFragmentManager.findFragmentByWho(string2);
    }

    public List getActiveFragments(List list) {
        return this.mHost.mFragmentManager.getActiveFragments();
    }

    public int getActiveFragmentsCount() {
        return this.mHost.mFragmentManager.getActiveFragmentCount();
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mHost.mFragmentManager;
    }

    public LoaderManager getSupportLoaderManager() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
        throw unsupportedOperationException;
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    public View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        return this.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(view, string2, context, attributeSet);
    }

    public void reportLoaderStart() {
    }

    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.mHost.mFragmentManager.restoreAllState(parcelable, fragmentManagerNonConfig);
    }

    public void restoreAllState(Parcelable parcelable, List list) {
        FragmentManager fragmentManager = this.mHost.mFragmentManager;
        FragmentManagerNonConfig fragmentManagerNonConfig = new FragmentManagerNonConfig(list, null, null);
        fragmentManager.restoreAllState(parcelable, fragmentManagerNonConfig);
    }

    public void restoreLoaderNonConfig(SimpleArrayMap simpleArrayMap) {
    }

    public void restoreSaveState(Parcelable object) {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        boolean bl2 = fragmentHostCallback instanceof ViewModelStoreOwner;
        if (bl2) {
            fragmentHostCallback.mFragmentManager.restoreSaveState((Parcelable)object);
            return;
        }
        object = new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        throw object;
    }

    public SimpleArrayMap retainLoaderNonConfig() {
        return null;
    }

    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    public List retainNonConfig() {
        ArrayList arrayList;
        Object object = this.mHost.mFragmentManager.retainNonConfig();
        if (object != null && (arrayList = ((FragmentManagerNonConfig)object).getFragments()) != null) {
            object = ((FragmentManagerNonConfig)object).getFragments();
            arrayList = new ArrayList(object);
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }
}

