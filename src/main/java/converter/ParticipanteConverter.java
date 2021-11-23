package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.ParticipanteDao;
import pojo.Participante;


@FacesConverter(forClass = Participante.class, managed = true)
public class ParticipanteConverter implements Converter {

	@Inject
	private ParticipanteDao dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Participante retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = dao.getPorId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {
			return String.valueOf(((Participante) value).getId());
		}
		return "";
	}
}
