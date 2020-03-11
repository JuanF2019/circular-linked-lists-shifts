package model;

public class ShiftsManager {
	private ShiftType firstShiftType;
	private Person people;
	
	public ShiftsManager() {		
	}
	
	public void addShiftType(String na, double t) {
		ShiftType st = firstShiftType;
		
		if(firstShiftType != null) {
			while(st.getNextShiftType() != firstShiftType) {
				st = st.getNextShiftType();
			}				
			st.setNextShiftType(new ShiftType(na,t));
			st.getNextShiftType().setNextShiftType(firstShiftType);				
		}
		else {
			firstShiftType = new ShiftType(na,t);
			firstShiftType.setNextShiftType(firstShiftType); 
		}
	}
	
	public ShiftType searchShiftType(String na) {
		ShiftType st = firstShiftType;
		
		if(firstShiftType != null) {
			if(firstShiftType.getNextShiftType() != firstShiftType && !firstShiftType.getName().equals(na)) {
				while(st != firstShiftType && !st.getName().equals(na)) {
					st = st.getNextShiftType();
				}
				
				if(!st.getName().equals(na)) {
					st = null;
				}			
			}
			else {
				if(!firstShiftType.getName().equals(na)) {
					st = null;
				}
			}
		}
		return st;
	}
	
	public ShiftType removeShiftType(String na) {
		ShiftType removed = null;
		//If the first is the one to remove
		if(firstShiftType!=null && na.equals(firstShiftType.getName())){
			removed = firstShiftType;
			if(firstShiftType.getNextShiftType()!=firstShiftType){				
				//If there is more than 1 element
				firstShiftType = firstShiftType.getNextShiftType();
				ShiftType current = firstShiftType;
				
				while(current.getNextShiftType()!=removed){
					current = current.getNextShiftType();
				}
				
				current.setNextShiftType(firstShiftType);
				
			}else{ //If there is only one element.
				firstShiftType = null;
			}
		}else{
			ShiftType prev = null;
			ShiftType current = firstShiftType.getNextShiftType();
			while(current!=firstShiftType && !na.equals(current.getName())){
				prev = current;
				current = current.getNextShiftType();
			}
			if(na.equals(current.getName())){
				prev.setNextShiftType(current.getNextShiftType());
				removed = current;
			}
		}
		return removed;
	}
	
	public void addPerson(String na, String id) {
		Person p = people;
		
		if(people != null) {
			while(p.getNextPerson() != null) {
				p = p.getNextPerson();
			}				
			
			p.setNextPerson(new Person(na,id));
			p.getNextPerson().setPrevPerson(p);						
		}
		else {
			people = new Person(na,id);		
		
		}
	
	}
	
	public Person searchPerson(String id) {
		Person p = people;
		
		if(people !=null) {
			while(p.getNextPerson() != null && !p.getId().equals(id)) {
				p = p.getNextPerson();
			}
			
			if(!p.getId().equals(id)) {
				p = null;
			}
		}
		
		return p;
		
	}
}
