package fr.inria.phoenix.diasuite.framework.distributed.mobilestorage;


import java.io.Serializable;

public final class FileIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info;
  
  public fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info() {
  	return info;
  }
  
  public void setInfo(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) {
  	this.info = info;
  }


  public FileIndices(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) {
    this.info = info;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((info == null) ? 0 : info.hashCode());

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
      FileIndices other = (FileIndices) obj;
      if (info == null) {
        if (other.info != null)
          return false;
      } else if (!info.equals(other.info))
        return false; 

      return true;
    }

}