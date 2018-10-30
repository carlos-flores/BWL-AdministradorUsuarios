package mx.com.bwl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.bwl.model.Peticion;
import mx.com.bwl.model.Respuesta;
import mx.com.bwl.model.Usuario;
import mx.com.bwl.repository.UsuariosRepository;

@RestController
@RequestMapping("/api")
public class ApiUserController {
	private final String sharedKey = "SHARED_KEY";
	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int CODE_SUCCESS = 100;
	private static final int AUTH_FAILURE = 102;
	
	@Autowired
	UsuariosRepository usuariosREPO;

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
//	public String pay(@RequestParam(value = "key") String key, @RequestBody Peticion request, Model model) {
		public String pay(Model model) {
		System.out.println("Método post");
		Respuesta response = new Respuesta();
		response.setStatus(SUCCESS_STATUS);
		response.setCode(CODE_SUCCESS);
//		if (sharedKey.equalsIgnoreCase(key)) {
//			int userId = request.getUserId();
//			String itemId = request.getItemId();
//			double discount = request.getDiscount();
//			
//			System.out.println("userID: " + userId);
//			System.out.println("itemID: " + itemId);
//			System.out.println("discount: " + discount);
//
//			response.setStatus(SUCCESS_STATUS);
//			response.setCode(CODE_SUCCESS);
//		} else {
//			response.setStatus(ERROR_STATUS);
//			response.setCode(AUTH_FAILURE);
//		}
		model.addAttribute(response);
		return "jsonTemplate";
	}
	
	@RequestMapping(value = "/usuarios")
    public String getAllEmployeesJSON(Model model)
    {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios = usuariosREPO.findAll();
        model.addAttribute("usuarios", usuarios);
        return "jsonTemplate";
    }

//	@RequestMapping(value = "/usuario/{id}")
//    public String getEmpleado(@PathVariable("id") int id,Model model)
//    {
//		System.out.println(id);
////		List<Usuario> usuarios = new ArrayList<>();
//		
//		if(usuariosREPO.existsById(id)) {
//			Usuario user = usuariosREPO.findById(id).get();
//			model.addAttribute("usuario", user);
//		}else {
//			model.addAttribute("usuario", null);
//		}
//        
//        return "jsonTemplate";
//    }

	@GetMapping(value = "/usuario/{id}")
  public ResponseEntity<Usuario> getEmpleado(@PathVariable("id") int id,Model model)
  {
		System.out.println(id);
//		List<Usuario> usuarios = new ArrayList<>();
		
		if(usuariosREPO.existsById(id)) {
			Usuario user = usuariosREPO.findById(id).get();
			return ResponseEntity.ok().body(user);
		}else {
			Usuario user = new Usuario();
			return ResponseEntity.ok().body(user);
		}
  }
	
//	@RequestMapping(value = "/usuario/create", method = RequestMethod.POST)
//    public String create(Model model)
//    {
//		int id=1;
//		System.out.println(id);
////		List<Usuario> usuarios = new ArrayList<>();
//		
//		if(usuariosREPO.existsById(id)) {
//			Usuario user = usuariosREPO.findById(id).get();
//			model.addAttribute("usuario", user);
//		}else {
//			model.addAttribute("usuario", null);
//		}
//        
//        return "jsonTemplate";
//    }
	
	@PostMapping("/usuario/create")
    public ResponseEntity<Usuario> create(@RequestBody Peticion peticion)
    {
		System.out.println(peticion);
		int id=1;
		System.out.println(id);
//		List<Usuario> usuarios = new ArrayList<>();
		
		if(usuariosREPO.existsById(id)) {
			Usuario user = usuariosREPO.findById(id).get();
			return ResponseEntity.ok().body(user);
		}else {
			Usuario user = new Usuario();
			return ResponseEntity.ok().body(user);
		}
    }

}
