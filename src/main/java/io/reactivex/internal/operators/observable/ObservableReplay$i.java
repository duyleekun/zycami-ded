/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableReplay$UnboundedReplayBuffer;
import io.reactivex.internal.operators.observable.ObservableReplay$a;
import io.reactivex.internal.operators.observable.ObservableReplay$e;

public final class ObservableReplay$i
implements ObservableReplay$a {
    public ObservableReplay$e call() {
        ObservableReplay$UnboundedReplayBuffer observableReplay$UnboundedReplayBuffer = new ObservableReplay$UnboundedReplayBuffer(16);
        return observableReplay$UnboundedReplayBuffer;
    }
}

