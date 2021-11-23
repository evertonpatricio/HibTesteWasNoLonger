package util.faces;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Stateless
public class FacesProducer {

        public FacesContext getFacesContext() {
                return FacesContext.getCurrentInstance();
        }
        
        public ExternalContext getExternalContext() {
                return getFacesContext().getExternalContext();
        }
        
        @Produces
        @RequestScoped
        public HttpServletResponse getHttpServletResponse() {
                return ((HttpServletResponse) getExternalContext().getResponse());        
        }
        
}