package com.backoffice.fachada;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.backoffice.beans.*;
import com.backoffice.dto.*;
import com.backoffice.excepciones.LogException;
import com.backoffice.excepciones.ServicioException;
import com.backoffice.excepciones.SolicitudException;
import com.backoffice.excepciones.TipoServicioException;

/**
 * Session Bean implementation class FachadaBean
 */
@Stateless
@LocalBean
public class FachadaBean implements FachadaBeanRemote {
	
	@EJB
	SolicitudesBean solicitudesBean = new SolicitudesBean();
	
	@EJB
	LogsBean logsBean = new LogsBean();
	
	@EJB
	ServiciosBean serviciosBean = new ServiciosBean();
	
	@EJB
	TiposServicioBean tiposServicioBean = new TiposServicioBean();
	
    public FachadaBean() {
        // TODO Auto-generated constructor stub
    }
    
    //-------- Solicitudes --------//
    public String enviarSolicitud(SolicitudDTO sDTO) throws SolicitudException {
    	return solicitudesBean.crearSolicitud(sDTO).getCodEntidad();
    }
    
	public List<SolicitudDTO> verSolicitudes() throws SolicitudException {
		return solicitudesBean.getAll();
	}
	    
    //-------- Servicios --------//
    public List<ServicioDTO> obtenerServicios() throws ServicioException {
    	return serviciosBean.getAll();
    }
    
    public List<TipoServicioDTO> obtenerTiposServicio() throws TipoServicioException {
    	return tiposServicioBean.getAll();
    }

    //-------- Logs --------//
	public void enviarLog(LogDTO lDTO) throws LogException {
		logsBean.crearLog(lDTO);
	}

}

