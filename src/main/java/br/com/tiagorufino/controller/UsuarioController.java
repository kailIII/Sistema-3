package br.com.tiagorufino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.tiagorufino.model.ResultadoModel;
import br.com.tiagorufino.model.UsuarioModel;
import br.com.tiagorufino.repository.UsuarioRepository;

@Controller	
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	ResultadoModel resultadoModel;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/login.html", method = RequestMethod.GET)
	public ModelAndView Login(){
		
		return new ModelAndView("login");
		
	}
	
	@RequestMapping(value="/cadastrar.html", method = RequestMethod.GET)
	public ModelAndView Cadastrat(){
		
		return new ModelAndView("cadastrar");
		
	}
	
	@RequestMapping(value="/consultarRegistros.html", method = RequestMethod.GET)
	public ModelAndView Consultar(){
		
		return new ModelAndView("consultarRegistros");
		
	}
	
	@RequestMapping(value="/editarResgitro.html/{codigo}", method= RequestMethod.GET)
	public ModelAndView EditarRegistro(@PathVariable int codigo){
		
		UsuarioModel usuarioModel = usuarioRepository.ConsultatarPorCodigo(codigo);
		
		return new ModelAndView("editarRegistro", "usuarioModel", usuarioModel);
		
	}
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public @ResponseBody ResultadoModel Salvar(@RequestBody UsuarioModel usuarioModel){
		
		try{
			
			usuarioRepository.salvar(usuarioModel);
			
			resultadoModel.setCodigo(1);
			resultadoModel.setMensagem("Registro inserido com sucesso");
		} catch (Exception e){
			
			resultadoModel.setCodigo(2);
			resultadoModel.setMensagem("Erro ao salvar registro" + e.getMessage());
		}
		
		return resultadoModel;
	}
	
	@RequestMapping(value="/alterar", method = RequestMethod.POST)
	public @ResponseBody ResultadoModel Alterar(@RequestBody UsuarioModel usuarioModel){
		
		try{
			
			usuarioRepository.Alterar(usuarioModel);
			
			resultadoModel.setCodigo(1);
			resultadoModel.setMensagem("Registro Alterado com Sucesso");
			
		}catch (Exception e){
			resultadoModel.setCodigo(2);
			resultadoModel.setMensagem("Erro ao alterar o registro " + e.getMessage());
		}
		
		return resultadoModel;
	}
	
	@RequestMapping(value="/consultarTodos", method = RequestMethod.GET)
	public @ResponseBody List<UsuarioModel> ConsultarTodos(){
		
		return usuarioRepository.TodosUsuarios();
		                                         
	}
	
	@RequestMapping(value="/excluirRegistro/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody void ExcluirRegistro(@PathVariable int codigo){
		
		usuarioRepository.Excluir(codigo);
		
	}
	

	@RequestMapping(value="/logar", method = RequestMethod.GET)
	public @ResponseBody ResultadoModel Login(@PathVariable UsuarioModel usuarioModel){
		
		try{
			
			usuarioRepository.ConsultarLogin(usuarioModel.getLogin(), usuarioModel.getSenha(), true);
			
			resultadoModel.setCodigo(1);
			resultadoModel.setMensagem("Login Efetuado com sucesso");
		} catch (Exception e){
			
			resultadoModel.setCodigo(2);
			resultadoModel.setMensagem("Erro ao logar, verifique login e senha" + e.getMessage());
		}
		
		return resultadoModel;
	}
}
