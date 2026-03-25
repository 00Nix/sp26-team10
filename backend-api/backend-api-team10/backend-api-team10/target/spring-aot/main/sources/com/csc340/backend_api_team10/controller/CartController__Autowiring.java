package com.csc340.backend_api_team10.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CartController}.
 */
@Generated
public class CartController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CartController apply(RegisteredBean registeredBean, CartController instance) {
    AutowiredFieldValueResolver.forRequiredField("cartService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
