package com.csc340.backend_api_team10.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CartService}.
 */
@Generated
public class CartService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CartService apply(RegisteredBean registeredBean, CartService instance) {
    AutowiredFieldValueResolver.forRequiredField("cartRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
