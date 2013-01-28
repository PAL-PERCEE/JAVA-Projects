package fr.inria.phoenix.diasuite.framework.distributed.addressbook;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[380,0]
 * device AddressBook extends HomeService {
 *   attribute owner as String;
 *   source contacts as Contact[] indexed by filter as Contact;
 *   action AddressBookAction;
 * }
 */
public abstract class AbstractAddressBook extends Service {

    public AbstractAddressBook(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String owner) {
      super("/Device/Device/Service/HomeService/AddressBook/", serviceConfiguration);
      updateId(id);
      updateOwner(owner);
    }

    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id",id);
        attributes.put("owner",owner);

        return attributes;
    }
    
        
        private java.lang.String id;

        /**
         * @[293,11]
         * attribute id as String;
         * @param newIdValue
         */
        protected void updateId(java.lang.String newIdValue) {
          if (id != newIdValue) {
            id = newIdValue;
            updateAttribute("id", newIdValue);
          }
        }

        /**
         * @[293,11]
         * attribute id as String;
         * @return
         */  
        public java.lang.String getId() {
          return id;
        }

        private java.lang.String owner;

        /**
         * @[381,11]
         * attribute owner as String;
         * @param newOwnerValue
         */
        protected void updateOwner(java.lang.String newOwnerValue) {
          if (owner != newOwnerValue) {
            owner = newOwnerValue;
            updateAttribute("owner", newOwnerValue);
          }
        }

        /**
         * @[381,11]
         * attribute owner as String;
         * @return
         */  
        public java.lang.String getOwner() {
          return owner;
        }


  protected final void internalPostInitialize() {postInitialize();}

        /**
         * 
         */
        protected abstract void removeContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact) throws Exception;

        /**
         * 
         */
        protected abstract void addContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact) throws Exception;

        /**
         * 
         */
        protected abstract void replaceContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact oldContact, fr.inria.phoenix.diasuite.framework.datatype.contact.Contact newContact) throws Exception;


        private java.util.HashMap<ContactsIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact>> _contacts = new java.util.HashMap<ContactsIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact>>();
        /**
         * @[382,1]
         * source contacts as Contact[] indexed by filter as Contact;
         */  
        protected void publishContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> newContactsValue , fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) {
          ContactsIndices _indices_ = new ContactsIndices(filter);
          _contacts.put(_indices_,newContactsValue);
          getProcessor().publishValue(getOutProperties(), "contacts", newContactsValue
    			, filter ); 
        }

        /**
         * @[382,1]
         * source contacts as Contact[] indexed by filter as Contact;
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> getContacts(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) throws Exception{
          return _contacts.get(new ContactsIndices(filter));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("removeContact")) {
          removeContact((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0]);
          return null;
        } else     if (orderName.equals("addContact")) {
          addContact((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0]);
          return null;
        } else     if (orderName.equals("replaceContact")) {
          replaceContact((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[1]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("contacts")) {
          return getContacts((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0]);
        }

       if (orderName.equals("id")) {
         return id;
       } else      if (orderName.equals("owner")) {
         return owner;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}