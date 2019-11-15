package canteen.manager.controller;

import canteen.manager.model.Menu;
import canteen.manager.service.menu.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    MenuServiceImpl menuService;

    @PostMapping("/addMenu")
    public ResponseEntity<?> addMenu(@RequestBody Menu menu){
        Menu menu1 = menuService.addMenu(menu);
        return new ResponseEntity<Menu>(menu1, HttpStatus.CREATED);
    }

    @GetMapping("/getMenu")
    public ResponseEntity<?> getMenu(@RequestBody Menu menu){
        return new ResponseEntity<Menu>(new Menu(), HttpStatus.CREATED);
    }
}
