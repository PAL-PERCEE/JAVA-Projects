package fr.inria.phoenix.diasuite.framework.common.filter;

import fr.inria.diagen.core.service.filter.service.ServiceFilter;

public abstract class SpeakerServiceFilter extends ServiceFilter {
    private static final long serialVersionUID = 0;
  protected SpeakerServiceFilter(String className) {
      super(className);
  }
}