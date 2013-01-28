package fr.inria.phoenix.diasuite.framework.datatype.fileinfo;
import java.io.Serializable;


/**
 * 
 *
 * @[116,0]
 * structure FileInfo {
 * name as String;
 * type as FileType;
 * size as Integer;
 * }
 */
public class FileInfo implements Serializable {

    private static final long serialVersionUID = 0;
    private java.lang.String name;
    
    public java.lang.String getName() {
        return name;
    }
    
    public void setName(java.lang.String newNameValue) {
        this.name = newNameValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType type;
    
    public fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType getType() {
        return type;
    }
    
    public void setType(fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType newTypeValue) {
        this.type = newTypeValue;
    }
    private java.lang.Integer size;
    
    public java.lang.Integer getSize() {
        return size;
    }
    
    public void setSize(java.lang.Integer newSizeValue) {
        this.size = newSizeValue;
    }

    public FileInfo() {
    }
  
    public FileInfo(java.lang.String name, fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType type, java.lang.Integer size) {
      this.name = name;      
      this.type = type;      
      this.size = size;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());

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
        FileInfo other = (FileInfo) obj;
        if (name == null) {
          if (other.name != null)
            return false;
        } else if (!name.equals(other.name))
          return false; 
        if (type == null) {
          if (other.type != null)
            return false;
        } else if (!type.equals(other.type))
          return false; 
        if (size == null) {
          if (other.size != null)
            return false;
        } else if (!size.equals(other.size))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "FileInfo [" + 
       "name=" + name +  ", " +    "type=" + type +  ", " +    "size=" + size +  
          "]";
      }

}
