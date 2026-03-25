package com.csc340.backend_api_team10.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SubscriptionController}.
 */
@Generated
public class SubscriptionController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SubscriptionController apply(RegisteredBean registeredBean,
      SubscriptionController instance) {
    AutowiredFieldValueResolver.forRequiredField("subscriptionService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
