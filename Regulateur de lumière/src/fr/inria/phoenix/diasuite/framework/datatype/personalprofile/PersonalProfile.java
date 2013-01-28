package fr.inria.phoenix.diasuite.framework.datatype.personalprofile;
import java.io.Serializable;


/**
 * 
 *
 * @[732,0]
 * structure PersonalProfile {
 * info as Contact;
 * picture as File;
 * relationship as Relationship;
 * }
 */
public class PersonalProfile implements Serializable {

    private static final long serialVersionUID = 0;
    private fr.inria.phoenix.diasuite.framework.datatype.contact.Contact info;
    
    public fr.inria.phoenix.diasuite.framework.datatype.contact.Contact getInfo() {
        return info;
    }
    
    public void setInfo(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact newInfoValue) {
        this.info = newInfoValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.file.File picture;
    
    public fr.inria.phoenix.diasuite.framework.datatype.file.File getPicture() {
        return picture;
    }
    
    public void setPicture(fr.inria.phoenix.diasuite.framework.datatype.file.File newPictureValue) {
        this.picture = newPictureValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.relationship.Relationship relationship;
    
    public fr.inria.phoenix.diasuite.framework.datatype.relationship.Relationship getRelationship() {
        return relationship;
    }
    
    public void setRelationship(fr.inria.phoenix.diasuite.framework.datatype.relationship.Relationship newRelationshipValue) {
        this.relationship = newRelationshipValue;
    }

    public PersonalProfile() {
    }
  
    public PersonalProfile(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact info, fr.inria.phoenix.diasuite.framework.datatype.file.File picture, fr.inria.phoenix.diasuite.framework.datatype.relationship.Relationship relationship) {
      this.info = info;      
      this.picture = picture;      
      this.relationship = relationship;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        result = prime * result + ((picture == null) ? 0 : picture.hashCode());
        result = prime * result + ((relationship == null) ? 0 : relationship.hashCode());

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
        PersonalProfile other = (PersonalProfile) obj;
        if (info == null) {
          if (other.info != null)
            return false;
        } else if (!info.equals(other.info))
          return false; 
        if (picture == null) {
          if (other.picture != null)
            return false;
        } else if (!picture.equals(other.picture))
          return false; 
        if (relationship == null) {
          if (other.relationship != null)
            return false;
        } else if (!relationship.equals(other.relationship))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "PersonalProfile [" + 
       "info=" + info +  ", " +    "picture=" + picture +  ", " +    "relationship=" + relationship +  
          "]";
      }

}
