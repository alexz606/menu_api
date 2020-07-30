package tech.base2.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

	@Autowired
	private MenuRepository mr;
	
	//asList returns a fixed size list
//	private List<Menu> menu = new ArrayList<>(Arrays.asList(
//			new Menu("Monday", "chicken", "rice"),
//			new Menu("Tuesday", "steak", "pasta"),
//			new Menu("Wednesday", "salmon", "quinoa"),
//			new Menu("Thursday", "lamb chops", "bread"),
//			new Menu("Friday", "ribs", "pasta"),
//			new Menu("Saturday", "pork", "rice"),
//			new Menu("Sunday", "beef", "quinoa")));
	
	public List<Menu> getWeeklyMenu(){
		//return menu;
		List<Menu> m = (ArrayList<Menu>) mr.findAll();
		
		return m;
	}
	
	public Menu getDailyMenu(String day){
//		// for loop to iterate through the list.
//		for (int i=0; i < menu.size(); i++) {
//			//comparing the value of the current menu object to
//			// the day
//			if(menu.get(i).getDay().equalsIgnoreCase(day)) {
//				return menu.get(i);
//			}
//		}
//		return null;
		
		if(mr.findById(day).isPresent()) {
			return mr.findById(day).get();
		} else {
			return null;
		}
	}
	
	public void addMenu(Menu m) {
		//menu.add(m);
		mr.save(m);
	}

	public void updateMenu(Menu m) {
//		for (int i=0; i < menu.size(); i++) {
//			//comparing the value of the current menu object to
//			// the day value of the object being passed
//			if(menu.get(i).getDay().equalsIgnoreCase(m.getDay())) {
//				menu.set(i, m);
//			}
//		}
		
		mr.save(m);
	}

	public void deleteMenu(Menu m) {
//		for (int i=0; i < menu.size(); i++) {
//			//comparing the value of the current menu object to
//			// the day value of the object being passed
//			if(menu.get(i).getDay().equalsIgnoreCase(m.getDay())) {
//				menu.remove(i);
//			}
//		}
		mr.delete(m);
		
	}
	
}
