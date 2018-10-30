package mx.com.bwl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.com.bwl.model.Usuario;
import mx.com.bwl.service.IUsuariosService;

@Controller
@RequestMapping("/users")
public class UsuariosController {
	@Autowired
	private IUsuariosService usuariosSRV;
	
	@GetMapping(value="/index")
	public String mostrarPrincipal(Model model){
		model.addAttribute("usuariosList", usuariosSRV.getAll());
		return "usuarios/todos";
	}

	@GetMapping(value="/create")
	public String crear(@ModelAttribute Usuario usuario, Model model){
		return "usuarios/new";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Usuario usuario, BindingResult result, RedirectAttributes attributes, @RequestParam("confirmacion") String confirmacion, Model model) {
		System.out.println("Usuario: " + usuario);
		System.out.println("Confirmación: " + confirmacion);
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}

			return "usuarios/new";
		}
		
		if(usuariosSRV.getPorUsername(usuario.getUsername()) != null) {
			attributes.addFlashAttribute("msg_error", "Ya existe un usuario registrado con este username");
			attributes.addFlashAttribute("usuario", usuario);
			return "redirect:/users/create";
		}
		
		if(!usuario.getPwd().equals(confirmacion)) {
			attributes.addFlashAttribute("msg_error", "Las contraseñas deben ser identicas");
			attributes.addFlashAttribute("usuario", usuario);
			return "redirect:/users/create";
		}

		usuariosSRV.save(usuario);
		attributes.addFlashAttribute("msg", "Usuario guardado correctamente");
		return "redirect:/users/index";
	}

	@GetMapping(value="/update/{id}")
	public String cargarActualizar(@PathVariable("id") int idUsuario, Model model) {
		Usuario usuarioTemp = usuariosSRV.get(idUsuario);
		usuarioTemp.setPwd(usuarioTemp.getPwd().replace("{noop}",""));
		model.addAttribute("usuario", usuarioTemp);
		model.addAttribute("confirmacion", usuarioTemp.getPwd());
		return "usuarios/update";
	}

	@PostMapping(value = "/update")
	public String actualizar(@ModelAttribute Usuario usuario, BindingResult result, RedirectAttributes attributes, @RequestParam("confirmacion") String confirmacion, Model model) {
		System.out.println("Usuario: " + usuario);
		System.out.println("Confirmación: " + confirmacion);
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}

			return "usuarios/update";
		}
		
		if(!usuario.getPwd().equals(confirmacion)) {
			attributes.addFlashAttribute("msg_error", "Las contraseñas deben ser identicas");
			attributes.addFlashAttribute("usuario", usuario);
			return "redirect:/users/update/"+usuario.getId();
		}

		usuariosSRV.update(usuario);
		attributes.addFlashAttribute("msg", "Usuario actualizado correctamente");
		return "redirect:/users/index";
	}
	
	@GetMapping(value="/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes, Model model) {
		Usuario usuarioTemp = usuariosSRV.get(idUsuario);
		if(usuarioTemp.getStatus()==1) {
			attributes.addFlashAttribute("msg_error", "No se puede eliminar un usuario con status ACTIVO");
			return "redirect:/users/index";
		}else if(usuarioTemp.getFechaactualizacion().getTime() > (System.currentTimeMillis() - (86400000l * 5))) {
			attributes.addFlashAttribute("msg_error", "No se puede eliminar un usuario que tiene menos de 5 días inactivo");
			return "redirect:/users/index";
		}
		
		usuariosSRV.delete(idUsuario);
		attributes.addFlashAttribute("msg", "Usuario eliminado correctamente");
		return "redirect:/users/index";
	}
	
	@InitBinder
	public void initBinderFecha(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
