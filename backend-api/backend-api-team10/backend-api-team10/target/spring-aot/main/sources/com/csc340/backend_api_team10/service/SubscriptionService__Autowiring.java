package com.csc340.backend_api_team10.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SubscriptionService}.
 */
@Generated
public class SubscriptionService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SubscriptionService apply(RegisteredBean registeredBean,
      SubscriptionService instance) {
    AutowiredFieldValueResolver.forRequiredField("subscriptionRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("customerRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
