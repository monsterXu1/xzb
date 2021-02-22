package com.my.oeder.myRebbon;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyRebbon {
    ServiceInstance getMyInstances(List<ServiceInstance> serviceInstances);
}
