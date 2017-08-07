import java.util.HashMap;
import java.util.ArrayDeque;

public class StateMachine<object_type> 
{
   
   object_type m_Owner;
   
   State<object_type> m_currentState;
	
   private HashMap<String, State<object_type>> m_States = new HashMap<String, State<object_type>>();
   
   private ArrayDeque<State<object_type>> m_stateStack = new ArrayDeque<State<object_type>>();
   
   public StateMachine(object_type owner)
   {
	   m_Owner = owner;
   }
   
   public void Update()
   {
	   m_currentState = m_stateStack.getFirst();
	   if(m_currentState != null) m_currentState.execute(m_Owner); 
   }
   
   public void changeState(String name) 
   { 
	   m_currentState.exit(m_Owner);
	   m_States.clear();
	   push(name);
	   m_stateStack.getFirst().enter(m_Owner);
   }
   
   public void setCurrentState(String name) { push(name); }
   public void push(String name) { m_stateStack.push(m_States.get(name)); }
   public void pop() { m_stateStack.pop(); }
   
   public void add(String name, State<object_type> state) { m_States.put(name, state); }
}
