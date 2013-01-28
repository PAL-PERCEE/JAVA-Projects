package fr.inria.phoenix.diasuite.framework.distributed.addressbook;


import java.io.Serializable;

public final class ContactsIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter;
  
  public fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter() {
  	return filter;
  }
  
  public void setFilter(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) {
  	this.filter = filter;
  }


  public ContactsIndices(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) {
    this.filter = filter;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((filter == null) ? 0 : filter.hashCode());

      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      ContactsIndices other = (ContactsIndices) obj;
      if (filter == null) {
        if (other.filter != null)
          return false;
      } else if (!filter.equals(other.filter))
        return false; 

      return true;
    }

}