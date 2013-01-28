package fr.inria.phoenix.diasuite.framework.datatype.call;
import java.io.Serializable;


/**
 * 
 *
 * @[132,0]
 * structure Call {
 * status as CallStatus;
 * caller as String;
 * }
 */
public class Call implements Serializable {

    private static final long serialVersionUID = 0;
    private fr.inria.phoenix.diasuite.framework.datatype.callstatus.CallStatus status;
    
    public fr.inria.phoenix.diasuite.framework.datatype.callstatus.CallStatus getStatus() {
        return status;
    }
    
    public void setStatus(fr.inria.phoenix.diasuite.framework.datatype.callstatus.CallStatus newStatusValue) {
        this.status = newStatusValue;
    }
    private java.lang.String caller;
    
    public java.lang.String getCaller() {
        return caller;
    }
    
    public void setCaller(java.lang.String newCallerValue) {
        this.caller = newCallerValue;
    }

    public Call() {
    }
  
    public Call(fr.inria.phoenix.diasuite.framework.datatype.callstatus.CallStatus status, java.lang.String caller) {
      this.status = status;      
      this.caller = caller;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((caller == null) ? 0 : caller.hashCode());

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
        Call other = (Call) obj;
        if (status == null) {
          if (other.status != null)
            return false;
        } else if (!status.equals(other.status))
          return false; 
        if (caller == null) {
          if (other.caller != null)
            return false;
        } else if (!caller.equals(other.caller))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "Call [" + 
       "status=" + status +  ", " +    "caller=" + caller +  
          "]";
      }

}
