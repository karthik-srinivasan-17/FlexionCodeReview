package com.flexion.coding.challenge.unitconversion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.flexion.coding.challenge.unitconversion.entity.Entries;

@RepositoryRestResource()
public interface UnitConversionRepository extends JpaRepository<Entries, Integer>, JpaSpecificationExecutor<Entries>, QuerydslPredicateExecutor<Entries> {}

