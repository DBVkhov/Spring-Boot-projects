package web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Televisor;

@RestController
@RequestMapping("/api")
public class TVController {
	Televisor tv;
	List<Televisor> lista = new ArrayList<>();
	@GetMapping
	public Televisor getTelevisor() {
		tv = new Televisor(null, 0, 0);
		return tv;
	};
	
	@GetMapping("/Stock")
	public List<Televisor> getTV(){
		return addTV(tv);
	}
	
	@PostMapping("/stock")
	public List<Televisor> addTV(@RequestBody Televisor tv){
		lista.add(tv);
		return lista;
	}
}
