package com.csc340.backend_api_team10.repository;

import com.csc340.backend_api_team10.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link ReviewRepository}.
 */
@Generated
public class ReviewRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public ReviewRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link ReviewRepository#findByOrderId(java.lang.Long)}.
   */
  public List<Review> findByOrderId(Long orderId) {
    String queryString = "SELECT r FROM Review r WHERE r.orderId = :orderId";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("orderId", orderId);

    return (List<Review>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link ReviewRepository#findByRating(java.lang.Integer)}.
   */
  public List<Review> findByRating(Integer rating) {
    String queryString = "SELECT r FROM Review r WHERE r.rating = :rating";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("rating", rating);

    return (List<Review>) query.getResultList();
  }
}
