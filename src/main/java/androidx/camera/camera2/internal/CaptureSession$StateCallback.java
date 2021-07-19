/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.camera2.impl.CameraEventCallbacks$ComboCameraEventCallback;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.CaptureSession$3;
import androidx.camera.camera2.internal.CaptureSession$State;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback;
import androidx.camera.core.Logger;
import java.util.List;

public final class CaptureSession$StateCallback
extends SynchronizedCaptureSession$StateCallback {
    public final /* synthetic */ CaptureSession this$0;

    public CaptureSession$StateCallback(CaptureSession captureSession) {
        this.this$0 = captureSession;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onClosed(SynchronizedCaptureSession object) {
        object = this.this$0.mStateLock;
        synchronized (object) {
            Object object2 = this.this$0;
            object2 = ((CaptureSession)object2).mState;
            Object object3 = CaptureSession$State.UNINITIALIZED;
            if (object2 != object3) {
                object2 = "CaptureSession";
                object3 = "CameraCaptureSession.onClosed()";
                Logger.d((String)object2, (String)object3);
                object2 = this.this$0;
                ((CaptureSession)object2).finishClose();
                return;
            }
            object3 = new StringBuilder();
            Object object4 = "onClosed() should not be possible in state: ";
            ((StringBuilder)object3).append((String)object4);
            object4 = this.this$0;
            object4 = ((CaptureSession)object4).mState;
            ((StringBuilder)object3).append(object4);
            object3 = ((StringBuilder)object3).toString();
            object2 = new IllegalStateException((String)object3);
            throw object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onConfigureFailed(SynchronizedCaptureSession object) {
        object = this.this$0.mStateLock;
        synchronized (object) {
            Object object2 = CaptureSession$3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            Object object3 = this.this$0;
            object3 = ((CaptureSession)object3).mState;
            int n10 = ((Enum)object3).ordinal();
            int n11 = object2[n10];
            switch (n11) {
                default: {
                    break;
                }
                case 4: 
                case 6: 
                case 7: {
                    object2 = this.this$0;
                    ((CaptureSession)object2).finishClose();
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 5: 
                case 8: {
                    object2 = new IllegalStateException;
                    object3 = new StringBuilder();
                    Object object4 = "onConfigureFailed() should not be possible in state: ";
                    ((StringBuilder)object3).append((String)object4);
                    object4 = this.this$0;
                    object4 = ((CaptureSession)object4).mState;
                    ((StringBuilder)object3).append(object4);
                    object3 = ((StringBuilder)object3).toString();
                    ((IllegalStateException)object2)((String)object3);
                    throw object2;
                }
            }
            object2 = "CaptureSession";
            object3 = new StringBuilder();
            Object object5 = "CameraCaptureSession.onConfigureFailed() ";
            ((StringBuilder)object3).append((String)object5);
            object5 = this.this$0;
            object5 = ((CaptureSession)object5).mState;
            ((StringBuilder)object3).append(object5);
            object3 = ((StringBuilder)object3).toString();
            Logger.e((String)object2, (String)object3);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onConfigured(SynchronizedCaptureSession object) {
        Object object2 = this.this$0.mStateLock;
        synchronized (object2) {
            Object object3 = CaptureSession$3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            Object object4 = this.this$0;
            object4 = object4.mState;
            int n10 = ((Enum)object4).ordinal();
            int n11 = object3[n10];
            switch (n11) {
                default: {
                    break;
                }
                case 7: {
                    object.close();
                    break;
                }
                case 6: {
                    object3 = this.this$0;
                    ((CaptureSession)object3).mSynchronizedCaptureSession = object;
                    break;
                }
                case 4: {
                    object3 = this.this$0;
                    object4 = CaptureSession$State.OPENED;
                    ((CaptureSession)object3).mState = object4;
                    ((CaptureSession)object3).mSynchronizedCaptureSession = object;
                    object = ((CaptureSession)object3).mSessionConfig;
                    if (object != null) {
                        object = this.this$0;
                        object = ((CaptureSession)object).mCameraEventCallbacks;
                        object = ((CameraEventCallbacks)object).createComboCallback();
                        n11 = (int)((object = ((CameraEventCallbacks$ComboCameraEventCallback)object).onEnableSession()).isEmpty() ? 1 : 0);
                        if (n11 == 0) {
                            object3 = this.this$0;
                            object = ((CaptureSession)object3).setupConfiguredSurface((List)object);
                            ((CaptureSession)object3).issueBurstCaptureRequest((List)object);
                        }
                    }
                    object = "CaptureSession";
                    object3 = "Attempting to send capture request onConfigured";
                    Logger.d((String)object, (String)object3);
                    object = this.this$0;
                    ((CaptureSession)object).issueRepeatingCaptureRequests();
                    object = this.this$0;
                    ((CaptureSession)object).issuePendingCaptureRequest();
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 5: 
                case 8: {
                    object3 = new StringBuilder;
                    ((StringBuilder)object3)();
                    object4 = "onConfigured() should not be possible in state: ";
                    ((StringBuilder)object3).append((String)object4);
                    object4 = this.this$0;
                    object4 = object4.mState;
                    ((StringBuilder)object3).append(object4);
                    object3 = ((StringBuilder)object3).toString();
                    object = new IllegalStateException((String)object3);
                    throw object;
                }
            }
            object = "CaptureSession";
            object3 = new StringBuilder;
            ((StringBuilder)object3)();
            object4 = "CameraCaptureSession.onConfigured() mState=";
            ((StringBuilder)object3).append((String)object4);
            object4 = this.this$0;
            object4 = object4.mState;
            ((StringBuilder)object3).append(object4);
            object3 = ((StringBuilder)object3).toString();
            Logger.d((String)object, (String)object3);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReady(SynchronizedCaptureSession object) {
        object = this.this$0.mStateLock;
        synchronized (object) {
            Object object2 = CaptureSession$3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            Object object3 = this.this$0;
            object3 = ((CaptureSession)object3).mState;
            int n10 = ((Enum)object3).ordinal();
            int n11 = object2[n10];
            n10 = 1;
            if (n11 != n10) {
                object2 = "CaptureSession";
                object3 = new StringBuilder();
                Object object4 = "CameraCaptureSession.onReady() ";
                ((StringBuilder)object3).append((String)object4);
                object4 = this.this$0;
                object4 = ((CaptureSession)object4).mState;
                ((StringBuilder)object3).append(object4);
                object3 = ((StringBuilder)object3).toString();
                Logger.d((String)object2, (String)object3);
                return;
            }
            object2 = new IllegalStateException;
            object3 = new StringBuilder();
            Object object5 = "onReady() should not be possible in state: ";
            ((StringBuilder)object3).append((String)object5);
            object5 = this.this$0;
            object5 = ((CaptureSession)object5).mState;
            ((StringBuilder)object3).append(object5);
            object3 = ((StringBuilder)object3).toString();
            object2((String)object3);
            throw object2;
        }
    }
}

