package fr.inria.phoenix.diasuite.framework.datatype.file;
import java.io.Serializable;


/**
 * 
 *
 * @[122,0]
 * structure File {
 * info as FileInfo;
 * content as Binary;
 * }
 */
public class File implements Serializable {

    private static final long serialVersionUID = 0;
    private fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info;
    
    public fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo getInfo() {
        return info;
    }
    
    public void setInfo(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo newInfoValue) {
        this.info = newInfoValue;
    }
    private byte[] content;
    
    public byte[] getContent() {
        return content;
    }
    
    public void setContent(byte[] newContentValue) {
        this.content = newContentValue;
    }

    public File() {
    }
  
    public File(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info, byte[] content) {
      this.info = info;      
      this.content = content;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());

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
        File other = (File) obj;
        if (info == null) {
          if (other.info != null)
            return false;
        } else if (!info.equals(other.info))
          return false; 
        if (content == null) {
          if (other.content != null)
            return false;
        } else if (!content.equals(other.content))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "File [" + 
       "info=" + info +  ", " +    "content.length=" + content.length +  
          "]";
      }

}
