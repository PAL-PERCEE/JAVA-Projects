package fr.inria.phoenix.diasuite.framework.common.filter;

import fr.inria.diagen.core.service.filter.service.ServiceFilter;

public abstract class AudioInputServiceFilter extends ServiceFilter {
    private static final long serialVersionUID = 0;
  protected AudioInputServiceFilter(String className) {
      super(className);
  }
}