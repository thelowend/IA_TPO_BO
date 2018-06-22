package com.backoffice.beans;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.ServicioDTO;

@Remote
public interface ServiciosBeanRemote {
	public List<ServicioDTO> getAll();
	public ServicioDTO getById(Integer nroServicio);
	public String crearServicio(ServicioDTO sDTO);
	public String editarServicio(ServicioDTO sDTO);
	public String borrarServicio(Integer nroServicio);
}
