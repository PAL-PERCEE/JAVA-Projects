package fr.inria.phoenix.diasuite.framework.datatype.contact;
import java.io.Serializable;


/**
 * 
 *
 * @[33,0]
 * structure Contact {
 * name as String;
 * emailAddress as String;
 * phone as String;
 * mobile as String;
 * iconUrl as String;
 * groups as String[];
 * }
 */
public class Contact implements Serializable {

    private static final long serialVersionUID = 0;
    private java.lang.String name;
    
    public java.lang.String getName() {
        return name;
    }
    
    public void setName(java.lang.String newNameValue) {
        this.name = newNameValue;
    }
    private java.lang.String emailAddress;
    
    public java.lang.String getEmailAddress() {
        return emailAddress;
    }
    
    public void setEmailAddress(java.lang.String newEmailAddressValue) {
        this.emailAddress = newEmailAddressValue;
    }
    private java.lang.String phone;
    
    public java.lang.String getPhone() {
        return phone;
    }
    
    public void setPhone(java.lang.String newPhoneValue) {
        this.phone = newPhoneValue;
    }
    private java.lang.String mobile;
    
    public java.lang.String getMobile() {
        return mobile;
    }
    
    public void setMobile(java.lang.String newMobileValue) {
        this.mobile = newMobileValue;
    }
    private java.lang.String iconUrl;
    
    public java.lang.String getIconUrl() {
        return iconUrl;
    }
    
    public void setIconUrl(java.lang.String newIconUrlValue) {
        this.iconUrl = newIconUrlValue;
    }
    private java.util.List<java.lang.String> groups;
    
    public java.util.List<java.lang.String> getGroups() {
        return groups;
    }
    
    public void setGroups(java.util.List<java.lang.String> newGroupsValue) {
        this.groups = newGroupsValue;
    }

    public Contact() {
    }
  
    public Contact(java.lang.String name, java.lang.String emailAddress, java.lang.String phone, java.lang.String mobile, java.lang.String iconUrl, java.util.List<java.lang.String> groups) {
      this.name = name;      
      this.emailAddress = emailAddress;      
      this.phone = phone;      
      this.mobile = mobile;      
      this.iconUrl = iconUrl;      
      this.groups = groups;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
        result = prime * result + ((iconUrl == null) ? 0 : iconUrl.hashCode());
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());

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
        Contact other = (Contact) obj;
        if (name == null) {
          if (other.name != null)
            return false;
        } else if (!name.equals(other.name))
          return false; 
        if (emailAddress == null) {
          if (other.emailAddress != null)
            return false;
        } else if (!emailAddress.equals(other.emailAddress))
          return false; 
        if (phone == null) {
          if (other.phone != null)
            return false;
        } else if (!phone.equals(other.phone))
          return false; 
        if (mobile == null) {
          if (other.mobile != null)
            return false;
        } else if (!mobile.equals(other.mobile))
          return false; 
        if (iconUrl == null) {
          if (other.iconUrl != null)
            return false;
        } else if (!iconUrl.equals(other.iconUrl))
          return false; 
        if (groups == null) {
          if (other.groups != null)
            return false;
        } else if (!groups.equals(other.groups))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "Contact [" + 
       "name=" + name +  ", " +    "emailAddress=" + emailAddress +  ", " +    "phone=" + phone +  ", " +    "mobile=" + mobile +  ", " +    "iconUrl=" + iconUrl +  ", " +    "groups=" + groups +  
          "]";
      }

}
