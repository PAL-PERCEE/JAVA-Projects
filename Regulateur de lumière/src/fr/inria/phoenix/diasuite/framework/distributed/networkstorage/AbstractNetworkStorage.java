package fr.inria.phoenix.diasuite.framework.distributed.networkstorage;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[621,0]
 * device NetworkStorage extends Storage {
 * }
 */
public abstract class AbstractNetworkStorage extends Service {

    public AbstractNetworkStorage(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user, java.lang.String name) {
      super("/Device/Device/PhysicalDevice/Storage/NetworkStorage/", serviceConfiguration);
      updateId(id);
      updateLocation(location);
      updateUser(user);
      updateName(name);
    }

    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id",id);
        attributes.put("location",location);
        attributes.put("user",user);
        attributes.put("name",name);

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

        private java.lang.String location;

        /**
         * @[440,11]
         * attribute location as String;
         * @param newLocationValue
         */
        protected void updateLocation(java.lang.String newLocationValue) {
          if (location != newLocationValue) {
            location = newLocationValue;
            updateAttribute("location", newLocationValue);
          }
        }

        /**
         * @[440,11]
         * attribute location as String;
         * @return
         */  
        public java.lang.String getLocation() {
          return location;
        }

        private java.lang.String user;

        /**
         * @[441,11]
         * attribute user as String;
         * @param newUserValue
         */
        protected void updateUser(java.lang.String newUserValue) {
          if (user != newUserValue) {
            user = newUserValue;
            updateAttribute("user", newUserValue);
          }
        }

        /**
         * @[441,11]
         * attribute user as String;
         * @return
         */  
        public java.lang.String getUser() {
          return user;
        }

        private java.lang.String name;

        /**
         * @[611,11]
         * attribute name as String;
         * @param newNameValue
         */
        protected void updateName(java.lang.String newNameValue) {
          if (name != newNameValue) {
            name = newNameValue;
            updateAttribute("name", newNameValue);
          }
        }

        /**
         * @[611,11]
         * attribute name as String;
         * @return
         */  
        public java.lang.String getName() {
          return name;
        }


  protected final void internalPostInitialize() {postInitialize();}

        /**
         * 
         */
        protected abstract void put(fr.inria.phoenix.diasuite.framework.datatype.file.File file) throws Exception;

        /**
         * 
         */
        protected abstract void delete(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo file) throws Exception;


        private java.util.HashMap<FileIndices,fr.inria.phoenix.diasuite.framework.datatype.file.File> _file = new java.util.HashMap<FileIndices,fr.inria.phoenix.diasuite.framework.datatype.file.File>();
        /**
         * @[612,1]
         * source file as File indexed by info as FileInfo;
         */  
        protected void publishFile(fr.inria.phoenix.diasuite.framework.datatype.file.File newFileValue , fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) {
          FileIndices _indices_ = new FileIndices(info);
          _file.put(_indices_,newFileValue);
          getProcessor().publishValue(getOutProperties(), "file", newFileValue
    			, info ); 
        }

        /**
         * @[612,1]
         * source file as File indexed by info as FileInfo;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.file.File getFile(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) throws Exception{
          return _file.get(new FileIndices(info));    }
        private java.util.HashMap<FileBrowsingIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo>> _fileBrowsing = new java.util.HashMap<FileBrowsingIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo>>();
        /**
         * @[613,1]
         * source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
         */  
        protected void publishFileBrowsing(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> newFileBrowsingValue , fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory, fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) {
          FileBrowsingIndices _indices_ = new FileBrowsingIndices(directory, filter);
          _fileBrowsing.put(_indices_,newFileBrowsingValue);
          getProcessor().publishValue(getOutProperties(), "fileBrowsing", newFileBrowsingValue
    			, directory , filter ); 
        }

        /**
         * @[613,1]
         * source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> getFileBrowsing(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory, fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) throws Exception{
          return _fileBrowsing.get(new FileBrowsingIndices(directory, filter));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("put")) {
          put((fr.inria.phoenix.diasuite.framework.datatype.file.File)args[0]);
          return null;
        } else     if (orderName.equals("delete")) {
          delete((fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo)args[0]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("file")) {
          return getFile((fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo)args[0]);
        } else     if (orderName.equals("fileBrowsing")) {
          return getFileBrowsing((fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo)args[0], (fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType)args[1]);
        }

       if (orderName.equals("id")) {
         return id;
       } else      if (orderName.equals("location")) {
         return location;
       } else      if (orderName.equals("user")) {
         return user;
       } else      if (orderName.equals("name")) {
         return name;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}