package fr.inria.phoenix.diasuite.framework.common.filter;

import fr.inria.diagen.core.service.filter.service.ServiceFilter;

public abstract class IdentifierServiceFilter extends ServiceFilter {
    private static final long serialVersionUID = 0;
  protected IdentifierServiceFilter(String className) {
      super(className);
  }
}