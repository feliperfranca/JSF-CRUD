package com.crud.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.crud.dao.UsuarioDAO;
import com.crud.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 455659950717243338L;
	private Usuario usuario = new Usuario();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public UsuarioBean() {
		usuarios = usuarioDAO.readAll();
	}

	public void inserir(ActionEvent evt) {
		usuarioDAO.create(usuario);
		usuarios = usuarioDAO.readAll();
	}

	public void atualizar(ActionEvent evt) {
		usuarioDAO.update(usuario);
		usuarios = usuarioDAO.readAll();
	}

	public void remover(ActionEvent evt) {
		usuarioDAO.delete(usuario.getId());
		usuarios = usuarioDAO.readAll();
	}

	public void limpar() {
		usuario = new Usuario();
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
}
