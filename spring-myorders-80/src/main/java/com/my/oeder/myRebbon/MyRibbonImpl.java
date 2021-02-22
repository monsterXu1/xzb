package com.my.oeder.myRebbon;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyRibbonImpl implements MyRebbon {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIntance(){
        int cuurent;
        int next;
        do {
            cuurent = this.atomicInteger.get();
            next = cuurent >= 2147483647 ? 0 : cuurent + 1;

        }while (!this.atomicInteger.compareAndSet(cuurent,next));
        return  next;
    }

    @Override
    public ServiceInstance getMyInstances(List<ServiceInstance> serviceInstances) {
        int index = getAndIntance() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
