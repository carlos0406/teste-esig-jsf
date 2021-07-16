package managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import dao.Database;
import javax.persistence.EntityManager;
import dao.TarefaDAO;
import dominio.Tarefa;
import uteis.MetodosUteis;

@SuppressWarnings("serial") /*Parar de exibir falsos erros*/
@ManagedBean
@SessionScoped
public class BuscaTarefasMBean {
	private List<Tarefa> tarefasEncontradas;
	
	private int limiteBusca;
	private String tituloBusca;
	private String responsavelBusca;
	private boolean situacaoBusca;
	
	/** Permite o acesso ao banco. */
	private TarefaDAO dao;
	public int getLimiteBusca() {
		return limiteBusca;
	}

	public void setLimiteBusca(int limiteBusca) {
		this.limiteBusca = limiteBusca;
	}

	public String getTituloBusca() {
		return tituloBusca;
	}

	public void setTituloBusca(String tituloBusca) {
		this.tituloBusca = tituloBusca;
	}

	public String getResponsavelBusca() {
		return responsavelBusca;
	}

	public void setResponsavelBusca(String responsavelBusca) {
		this.responsavelBusca = responsavelBusca;
	}

	public boolean isSituacaoBusca() {
		return situacaoBusca;
	}

	public void setSituacaoBusca(boolean situacaoBusca) {
		this.situacaoBusca = situacaoBusca;
	}

	public List<Tarefa> getTarefasEncontradas() {
		return tarefasEncontradas;
	}
	
	public void setTarefasEncontradas(List<Tarefa> tarefasEncontradas) {
		this.tarefasEncontradas = tarefasEncontradas;
	}


	
	
	/** Entra na pagina de busca de usuï¿½rios */
	public String entrarBuscarTreinos(){
		return buscar();
	}
	
	/** Realiza a busca de usuï¿½rios no banco. */
	public String buscar(){
		dao = new TarefaDAO();
		
		tarefasEncontradas = dao.buscarTarefa(limiteBusca,
		tituloBusca,
		responsavelBusca,
		situacaoBusca);
			
		return "/busca_tarefas.xhtml";
	}
	
	public TarefaDAO getDao() {
		return dao;
	}

	public void setDao(TarefaDAO dao) {
		this.dao = dao;
	}
	
	public String alterarSituacao(Tarefa t) {
		EntityManager em = Database.getInstance().getEntityManager();
			
			try {
				
				em.getTransaction().begin();
				t.setCompleta(!t.isCompleta());
				em.merge(t);
				MetodosUteis.addMensagem("Situação da tarefa alterada com sucesso!");
				em.getTransaction().commit();		
			} catch (Exception e){
				e.printStackTrace();
				
				if (em.getTransaction().isActive())
					
					em.getTransaction().rollback();
			}
			
			return buscar();
		}
	
	public String removerTarefa(Tarefa t) {
		EntityManager em = Database.getInstance().getEntityManager();
			
			try {
				
				em.getTransaction().begin();
				em.remove(t);	
				em.getTransaction().commit();
				MetodosUteis.addMensagem("Tarefa deletada com sucesso!");
			} catch (Exception e){
				e.printStackTrace();
				
				if (em.getTransaction().isActive())
					
					em.getTransaction().rollback();
			}
			
			return buscar();
		}
	
	
}
