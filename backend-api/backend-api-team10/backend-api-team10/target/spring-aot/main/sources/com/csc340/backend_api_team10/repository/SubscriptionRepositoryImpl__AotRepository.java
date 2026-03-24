package com.csc340.backend_api_team10.repository;

import com.csc340.backend_api_team10.entity.Subscription;
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
 * AOT generated JPA repository implementation for {@link SubscriptionRepository}.
 */
@Generated
public class SubscriptionRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public SubscriptionRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link SubscriptionRepository#findByCustomerSubId(java.lang.String)}.
   */
  public Optional<Subscription> findByCustomerSubId(String customerSubId) {
    String queryString = "SELECT s FROM Subscription s WHERE s.customerSubId = :customerSubId";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("customerSubId", customerSubId);

    return Optional.ofNullable((Subscription) convertOne(query.getSingleResultOrNull(), false, Subscription.class));
  }

  /**
   * AOT generated implementation of {@link SubscriptionRepository#findByCustomer_CustomerId(java.lang.Long)}.
   */
  public List<Subscription> findByCustomer_CustomerId(Long customerId) {
    String queryString = "SELECT s FROM Subscription s WHERE s.customer.customerId = :customerId";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("customerId", customerId);

    return (List<Subscription>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link SubscriptionRepository#findByStatus(java.lang.String)}.
   */
  public List<Subscription> findByStatus(String status) {
    String queryString = "SELECT s FROM Subscription s WHERE s.status = :status";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("status", status);

    return (List<Subscription>) query.getResultList();
  }
}
