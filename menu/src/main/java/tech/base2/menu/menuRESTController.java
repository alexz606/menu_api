package tech.base2.menu;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@RestController
public class menuRESTController {

	@Autowired
	private MenuService menuService;
	
	//Returns all items in list
	@RequestMapping("/menu-api")
	public List<Menu> getAllItems() {
		return menuService.getWeeklyMenu();
	}

	//Return an item
	@RequestMapping("/menu-api/{day}")
	public Menu getASingleItem(@PathVariable String day) {
		return menuService.getDailyMenu(day);
	}
	
	//Create an item
	@RequestMapping(method=RequestMethod.POST, value="/menu-api/{day}")
	public void createItem(@RequestBody Menu m) {
		menuService.addMenu(m);
		return;
	}
	
	//update an item
	@RequestMapping(method=RequestMethod.PUT, value="/menu-api/{day}")
	public void updateItem(@RequestBody Menu m) {
		menuService.updateMenu(m);
		return;
	}
	
	//delete an item
	@RequestMapping(method=RequestMethod.DELETE, value="/menu-api/{day}")
	public void deleteItem(@RequestBody Menu m) {
		menuService.deleteMenu(m);
		return;
	}
}
