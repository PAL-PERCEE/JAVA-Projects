package fr.inria.phoenix.diasuite.framework.datatype.channel;
import java.io.Serializable;


/**
 * 
 *
 * @[98,0]
 * structure Channel {
 * name as String;
 * icon as File;
 * }
 */
public class Channel implements Serializable {

    private static final long serialVersionUID = 0;
    private java.lang.String name;
    
    public java.lang.String getName() {
        return name;
    }
    
    public void setName(java.lang.String newNameValue) {
        this.name = newNameValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.file.File icon;
    
    public fr.inria.phoenix.diasuite.framework.datatype.file.File getIcon() {
        return icon;
    }
    
    public void setIcon(fr.inria.phoenix.diasuite.framework.datatype.file.File newIconValue) {
        this.icon = newIconValue;
    }

    public Channel() {
    }
  
    public Channel(java.lang.String name, fr.inria.phoenix.diasuite.framework.datatype.file.File icon) {
      this.name = name;      
      this.icon = icon;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((icon == null) ? 0 : icon.hashCode());

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
        Channel other = (Channel) obj;
        if (name == null) {
          if (other.name != null)
            return false;
        } else if (!name.equals(other.name))
          return false; 
        if (icon == null) {
          if (other.icon != null)
            return false;
        } else if (!icon.equals(other.icon))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "Channel [" + 
       "name=" + name +  ", " +    "icon=" + icon +  
          "]";
      }

}
