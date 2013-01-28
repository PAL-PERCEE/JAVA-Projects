package fr.inria.phoenix.diasuite.framework.common.filter;

import fr.inria.diagen.core.service.filter.service.ServiceFilter;

public abstract class AddressBookServiceFilter extends ServiceFilter {
    private static final long serialVersionUID = 0;
  protected AddressBookServiceFilter(String className) {
      super(className);
  }
}