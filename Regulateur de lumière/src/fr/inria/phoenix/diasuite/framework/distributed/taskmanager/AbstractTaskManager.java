package fr.inria.phoenix.diasuite.framework.distributed.taskmanager;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[428,0]
 * device TaskManager extends HomeService {
 *   source tasks as Task[];
 *   action AddTask;
 *   action DeleteTask;
 *   action UpdateTaskState;
 * }
 */
public abstract class AbstractTaskManager extends Service {

    public AbstractTaskManager(ServiceConfiguration serviceConfiguration , java.lang.String id) {
      super("/Device/Device/Service/HomeService/TaskManager/", serviceConfiguration);
      updateId(id);
    }

    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id",id);

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


  protected final void internalPostInitialize() {postInitialize();}

        /**
         * 
         */
        protected abstract void update(java.lang.String taskId, fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState state) throws Exception;

        /**
         * 
         */
        protected abstract void addTask(fr.inria.phoenix.diasuite.framework.datatype.task.Task task) throws Exception;

        /**
         * 
         */
        protected abstract void deleteTask(fr.inria.phoenix.diasuite.framework.datatype.task.Task task) throws Exception;


        private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> _tasks;
        /**
         * @[429,1]
         * source tasks as Task[];
         */  
        protected void publishTasks(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> newTasksValue ) {
          _tasks = newTasksValue;
          getProcessor().publishValue(getOutProperties(), "tasks", newTasksValue); 
        }

        /**
         * @[429,1]
         * source tasks as Task[];
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> getTasks() throws Exception{
          return _tasks;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("update")) {
          update((java.lang.String)args[0], (fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState)args[1]);
          return null;
        } else     if (orderName.equals("addTask")) {
          addTask((fr.inria.phoenix.diasuite.framework.datatype.task.Task)args[0]);
          return null;
        } else     if (orderName.equals("deleteTask")) {
          deleteTask((fr.inria.phoenix.diasuite.framework.datatype.task.Task)args[0]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("tasks")) {
          return getTasks();
        }

       if (orderName.equals("id")) {
         return id;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}