package fr.inria.phoenix.diasuite.framework.distributed.networkstorage;


import java.io.Serializable;

public final class FileBrowsingIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory;
  
  public fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory() {
  	return directory;
  }
  
  public void setDirectory(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory) {
  	this.directory = directory;
  }
  private fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter;
  
  public fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter() {
  	return filter;
  }
  
  public void setFilter(fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) {
  	this.filter = filter;
  }


  public FileBrowsingIndices(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory, fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) {
    this.directory = directory;
    this.filter = filter;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((directory == null) ? 0 : directory.hashCode());
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
      FileBrowsingIndices other = (FileBrowsingIndices) obj;
      if (directory == null) {
        if (other.directory != null)
          return false;
      } else if (!directory.equals(other.directory))
        return false; 
      if (filter == null) {
        if (other.filter != null)
          return false;
      } else if (!filter.equals(other.filter))
        return false; 

      return true;
    }

}