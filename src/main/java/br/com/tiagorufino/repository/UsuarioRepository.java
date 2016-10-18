package br.com.tiagorufino.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import br.com.tiagorufino.model.UsuarioModel;

@Repository
public class UsuarioRepository {

	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	@javax.transaction.Transactional
	public void salvar(UsuarioModel usuarioModel){
		
		manager.persist(usuarioModel);
		
	}
	
	@javax.transaction.Transactional
	public void Alterar(UsuarioModel usuarioModel){

		manager.merge(usuarioModel);
		
	}
	
	public UsuarioModel ConsultatarPorCodigo(int codigo){
		
		return manager.find(UsuarioModel.class, codigo);
		
	}
	
	@javax.transaction.Transactional
	public void Excluir(int codigo){
		
		UsuarioModel usuarioModel = this.ConsultatarPorCodigo(codigo);
		
		manager.remove(usuarioModel);
		
	}
	
	public List<UsuarioModel> TodosUsuarios(){
		
		return manager.createQuery
				("SELECT c FROM UsuarioModel c ORDER BY c.nome", UsuarioModel.class).getResultList();
	}
	
	public boolean ConsultarLogin(String login, String senha, boolean ativo){
		manager.createQuery
					("SELECT c FROM UsuarioModel c "
							+ "WHERE c.login=:login "
							+ "and c.senha=:senha "
							+ "and c.ativo=:ativo", UsuarioModel.class)
					.setParameter("login", login)
					.setParameter("senha", senha)
					.setParameter("ativo", ativo)
					.getResultList();
		
		return false;
	}
}
