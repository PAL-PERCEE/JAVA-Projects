package fr.inria.phoenix.diasuite.framework.datatype.task;
import java.io.Serializable;


/**
 * 
 *
 * @[146,0]
 * structure Task {
 * id as String;
 * content as String;
 * state as TaskState;
 * }
 */
public class Task implements Serializable {

    private static final long serialVersionUID = 0;
    private java.lang.String id;
    
    public java.lang.String getId() {
        return id;
    }
    
    public void setId(java.lang.String newIdValue) {
        this.id = newIdValue;
    }
    private java.lang.String content;
    
    public java.lang.String getContent() {
        return content;
    }
    
    public void setContent(java.lang.String newContentValue) {
        this.content = newContentValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState state;
    
    public fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState getState() {
        return state;
    }
    
    public void setState(fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState newStateValue) {
        this.state = newStateValue;
    }

    public Task() {
    }
  
    public Task(java.lang.String id, java.lang.String content, fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState state) {
      this.id = id;      
      this.content = content;      
      this.state = state;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());

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
        Task other = (Task) obj;
        if (id == null) {
          if (other.id != null)
            return false;
        } else if (!id.equals(other.id))
          return false; 
        if (content == null) {
          if (other.content != null)
            return false;
        } else if (!content.equals(other.content))
          return false; 
        if (state == null) {
          if (other.state != null)
            return false;
        } else if (!state.equals(other.state))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "Task [" + 
       "id=" + id +  ", " +    "content=" + content +  ", " +    "state=" + state +  
          "]";
      }

}
