package com.crud.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.crud.dao.UsuarioDAO;
import com.crud.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
	private Usuario usuario = new Usuario();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public UsuarioBean() {
		usuarios = usuarioDAO.readAll();
	}

	public void inserir(ActionEvent evt) {
		usuarioDAO.create(usuario);
		usuarios = usuarioDAO.readAll();
		showMessage("Usuário " + usuario.getNome() + " criado com sucesso!");
	}

	public void atualizar() {
		usuarioDAO.update(usuario);
		usuarios = usuarioDAO.readAll();
		showMessage("Usuário " + usuario.getNome() + " atualizado com sucesso!");
	}

	public void remover() {
		usuarioDAO.delete(usuario.getId());
		usuarios = usuarioDAO.readAll();
		showMessage("Usuário " + usuario.getNome() + " removido com sucesso!");
	}

	public void limpar() {
		usuario = new Usuario();
	}
	
	private void showMessage(String summary) {
		FacesContext context = FacesContext.getCurrentInstance();  
		context.addMessage(null, new FacesMessage(summary));  
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getNullUser() {
		return new Usuario();
	}
	
	public int getProxId() {
		UsuarioDAO dao = new UsuarioDAO();
		
		return dao.contarQtdeUsuariosParaExibicaoDeProxId() + 1;
	}
}
