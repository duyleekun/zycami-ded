/*
 * Decompiled with CFR 0.151.
 */
package androidx.loader.app;

import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManagerImpl$LoaderInfo;
import androidx.loader.app.LoaderManagerImpl$LoaderViewModel$1;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LoaderManagerImpl$LoaderViewModel
extends ViewModel {
    private static final ViewModelProvider$Factory FACTORY;
    private boolean mCreatingLoader;
    private SparseArrayCompat mLoaders;

    static {
        LoaderManagerImpl$LoaderViewModel$1 loaderManagerImpl$LoaderViewModel$1 = new LoaderManagerImpl$LoaderViewModel$1();
        FACTORY = loaderManagerImpl$LoaderViewModel$1;
    }

    public LoaderManagerImpl$LoaderViewModel() {
        SparseArrayCompat sparseArrayCompat;
        this.mLoaders = sparseArrayCompat = new SparseArrayCompat();
        this.mCreatingLoader = false;
    }

    public static LoaderManagerImpl$LoaderViewModel getInstance(ViewModelStore viewModelStore) {
        ViewModelProvider$Factory viewModelProvider$Factory = FACTORY;
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStore, viewModelProvider$Factory);
        return (LoaderManagerImpl$LoaderViewModel)viewModelProvider.get(LoaderManagerImpl$LoaderViewModel.class);
    }

    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        Object object = this.mLoaders;
        int n10 = ((SparseArrayCompat)object).size();
        if (n10 > 0) {
            Object object2;
            int n11;
            printWriter.print(string2);
            printWriter.println("Loaders:");
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("    ");
            object = ((StringBuilder)object).toString();
            for (int i10 = 0; i10 < (n11 = ((SparseArrayCompat)(object2 = this.mLoaders)).size()); ++i10) {
                object2 = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i10);
                printWriter.print(string2);
                printWriter.print("  #");
                int n12 = this.mLoaders.keyAt(i10);
                printWriter.print(n12);
                printWriter.print(": ");
                String string3 = ((LoaderManagerImpl$LoaderInfo)object2).toString();
                printWriter.println(string3);
                ((LoaderManagerImpl$LoaderInfo)object2).dump((String)object, fileDescriptor, printWriter, stringArray);
            }
        }
    }

    public void finishCreatingLoader() {
        this.mCreatingLoader = false;
    }

    public LoaderManagerImpl$LoaderInfo getLoader(int n10) {
        return (LoaderManagerImpl$LoaderInfo)this.mLoaders.get(n10);
    }

    public boolean hasRunningLoaders() {
        SparseArrayCompat sparseArrayCompat = this.mLoaders;
        int n10 = sparseArrayCompat.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i10);
            boolean bl2 = loaderManagerImpl$LoaderInfo.isCallbackWaitingForData();
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public boolean isCreatingLoader() {
        return this.mCreatingLoader;
    }

    public void markForRedelivery() {
        SparseArrayCompat sparseArrayCompat = this.mLoaders;
        int n10 = sparseArrayCompat.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i10);
            loaderManagerImpl$LoaderInfo.markForRedelivery();
        }
    }

    public void onCleared() {
        super.onCleared();
        SparseArrayCompat sparseArrayCompat = this.mLoaders;
        int n10 = sparseArrayCompat.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i10);
            boolean bl2 = true;
            loaderManagerImpl$LoaderInfo.destroy(bl2);
        }
        this.mLoaders.clear();
    }

    public void putLoader(int n10, LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo) {
        this.mLoaders.put(n10, loaderManagerImpl$LoaderInfo);
    }

    public void removeLoader(int n10) {
        this.mLoaders.remove(n10);
    }

    public void startCreatingLoader() {
        this.mCreatingLoader = true;
    }
}

