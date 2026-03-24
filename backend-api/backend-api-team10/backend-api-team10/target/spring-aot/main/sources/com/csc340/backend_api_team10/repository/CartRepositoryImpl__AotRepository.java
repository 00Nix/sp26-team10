package com.csc340.backend_api_team10.repository;

import com.csc340.backend_api_team10.entity.Cart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link CartRepository}.
 */
@Generated
public class CartRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public CartRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link CartRepository#findByCartId(java.lang.Long)}.
   */
  public List<Cart> findByCartId(Long cartId) {
    String queryString = "SELECT c FROM Cart c WHERE c.cartId = :cartId";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("cartId", cartId);

    return (List<Cart>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link CartRepository#findByCustomer_CustomerId(java.lang.Long)}.
   */
  public Optional<Cart> findByCustomer_CustomerId(Long customerId) {
    String queryString = "SELECT c FROM Cart c WHERE c.customer.customerId = :customerId";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("customerId", customerId);

    return Optional.ofNullable((Cart) convertOne(query.getSingleResultOrNull(), false, Cart.class));
  }
}
