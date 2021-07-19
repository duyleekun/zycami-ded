/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity;

import androidx.activity.ComponentActivity$2;
import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;

public class ComponentActivity$2$1
implements Runnable {
    public final /* synthetic */ ComponentActivity$2 this$1;
    public final /* synthetic */ int val$requestCode;
    public final /* synthetic */ ActivityResultContract$SynchronousResult val$synchronousResult;

    public ComponentActivity$2$1(ComponentActivity$2 var1_1, int n10, ActivityResultContract$SynchronousResult synchronousResult) {
        this.this$1 = var1_1;
        this.val$requestCode = n10;
        this.val$synchronousResult = synchronousResult;
    }

    public void run() {
        ComponentActivity$2 componentActivity$2 = this.this$1;
        int n10 = this.val$requestCode;
        Object object = this.val$synchronousResult.getValue();
        componentActivity$2.dispatchResult(n10, object);
    }
}

