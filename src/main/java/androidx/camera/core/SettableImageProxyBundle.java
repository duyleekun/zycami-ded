/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package androidx.camera.core;

import android.util.SparseArray;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SettableImageProxyBundle$1;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.TagBundle;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SettableImageProxyBundle
implements ImageProxyBundle {
    private final List mCaptureIdList;
    private boolean mClosed;
    public final SparseArray mCompleters;
    private final SparseArray mFutureResults;
    public final Object mLock;
    private final List mOwnedImageProxies;
    private String mTagBundleKey;

    public SettableImageProxyBundle(List list, String string2) {
        ArrayList arrayList = new ArrayList();
        this.mLock = arrayList;
        arrayList = new ArrayList();
        this.mCompleters = arrayList;
        arrayList = new ArrayList();
        this.mFutureResults = arrayList;
        this.mOwnedImageProxies = arrayList = new ArrayList();
        this.mTagBundleKey = null;
        this.mClosed = false;
        this.mCaptureIdList = list;
        this.mTagBundleKey = string2;
        this.setup();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setup() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mCaptureIdList;
            object2 = object2.iterator();
            int n10;
            while ((n10 = object2.hasNext()) != 0) {
                Object object3 = object2.next();
                object3 = (Integer)object3;
                n10 = (Integer)object3;
                Object object4 = new SettableImageProxyBundle$1(this, n10);
                object4 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object4);
                SparseArray sparseArray = this.mFutureResults;
                sparseArray.put(n10, object4);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addImageProxy(ImageProxy object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            boolean bl2 = this.mClosed;
            if (bl2) {
                return;
            }
            Object object3 = object.getImageInfo();
            object3 = object3.getTagBundle();
            Object object4 = this.mTagBundleKey;
            if ((object3 = ((TagBundle)object3).getTag((String)object4)) == null) {
                object3 = "CaptureId is null.";
                object = new IllegalArgumentException((String)object3);
                throw object;
            }
            object4 = this.mCompleters;
            int n10 = (Integer)object3;
            object4 = object4.get(n10);
            if ((object4 = (CallbackToFutureAdapter$Completer)object4) != null) {
                object3 = this.mOwnedImageProxies;
                object3.add(object);
                ((CallbackToFutureAdapter$Completer)object4).set(object);
                return;
            }
            object4 = new StringBuilder();
            String string2 = "ImageProxyBundle does not contain this id: ";
            ((StringBuilder)object4).append(string2);
            ((StringBuilder)object4).append(object3);
            object3 = ((StringBuilder)object4).toString();
            object = new IllegalArgumentException((String)object3);
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mClosed;
            if (bl2) {
                return;
            }
            Object object2 = this.mOwnedImageProxies;
            object2 = object2.iterator();
            while (true) {
                boolean bl3;
                if (!(bl3 = object2.hasNext())) {
                    object2 = this.mOwnedImageProxies;
                    object2.clear();
                    object2 = this.mFutureResults;
                    object2.clear();
                    object2 = this.mCompleters;
                    object2.clear();
                    this.mClosed = bl2 = true;
                    return;
                }
                Object object3 = object2.next();
                object3 = (ImageProxy)object3;
                object3.close();
            }
        }
    }

    public List getCaptureIds() {
        return Collections.unmodifiableList(this.mCaptureIdList);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture getImageProxy(int n10) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mClosed;
            if (bl2) {
                String string2 = "ImageProxyBundle already closed.";
                IllegalStateException illegalStateException = new IllegalStateException(string2);
                throw illegalStateException;
            }
            Object object2 = this.mFutureResults;
            object2 = object2.get(n10);
            if ((object2 = (ListenableFuture)object2) != null) {
                return object2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "ImageProxyBundle does not contain this id: ";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            String string4 = stringBuilder.toString();
            object2 = new IllegalArgumentException(string4);
            throw object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void reset() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mClosed;
            if (bl2) {
                return;
            }
            Object object2 = this.mOwnedImageProxies;
            object2 = object2.iterator();
            while (true) {
                boolean bl3;
                if (!(bl3 = object2.hasNext())) {
                    object2 = this.mOwnedImageProxies;
                    object2.clear();
                    object2 = this.mFutureResults;
                    object2.clear();
                    object2 = this.mCompleters;
                    object2.clear();
                    this.setup();
                    return;
                }
                Object object3 = object2.next();
                object3 = (ImageProxy)object3;
                object3.close();
            }
        }
    }
}

