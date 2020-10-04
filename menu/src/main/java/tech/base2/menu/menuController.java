package tech.base2.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class menuController {

	@Autowired
	private MenuService menuService;
	
	//Return All Items
	@GetMapping("/menu")
	public String greeting(Model model) {
		model.addAttribute("menu", menuService.getWeeklyMenu());
		return "greeting";
	}
	
	//Return an item
	@GetMapping("/menu/{day}")
	public String getASingleItem(@PathVariable String day, Model model) {
		model.addAttribute("menu", menuService.getDailyMenu(day));
		return "greeting";
	}

//	@RequestMapping("/{day}")
//	public Menu getASingleItem(@PathVariable String day) {
//		return menuService.getDailyMenu(day);
//	}
	
//	//Create an item - TODO
//	@PostMapping("/menu")
//	public String createMenuItemForm(Model model) {
//		model.addAttribute("menu", menuService.getDailyMenu(day));
//		return "greeting";
//	}
//	@RequestMapping(method=RequestMethod.POST, value="/{day}")
//	public void createItem(@RequestBody Menu m) {
//		menuService.addMenu(m);
//		return;
//	}
	
	//update an item
//	@RequestMapping(method=RequestMethod.PUT, value="/{day}")
//	public void updateItem(@RequestBody Menu m) {
//		menuService.updateMenu(m);
//		return;
//	}
	
	//delete an item
//	@RequestMapping(method=RequestMethod.DELETE, value="/{day}")
//	public void deleteItem(@RequestBody Menu m) {
//		menuService.deleteMenu(m);
//		return;
//	}
}
