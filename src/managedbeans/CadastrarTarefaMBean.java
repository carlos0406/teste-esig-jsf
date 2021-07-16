package managedbeans;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import dao.Database;
import dominio.Tarefa;
import uteis.MetodosUteis;
import uteis.ValidadorUtil;

@ManagedBean
@RequestScoped
public class CadastrarTarefaMBean {
	private Tarefa tarefa ;
	

	public CadastrarTarefaMBean() {
		tarefa = new Tarefa();
		
		
		
	}

	/** Entra na tela de ediï¿½ï¿½o de usuï¿½rios. */
	public String entrarEdicaotarefas(Tarefa tarefa) {
		this.tarefa = tarefa; // o livro a ser editado sera o recebido pelo
								// parametro
		return "/index.xhtml";
	}

	public String cadastrar() {
			EntityManager gerenciador = Database.getInstance().getEntityManager();
			gerenciador.getTransaction().begin();
			boolean erro=false;
			
			if (MetodosUteis.estaVazia(tarefa.getTitulo())) {
				MetodosUteis.addMensagem("Campo titulo obrigatorio!");
				erro = true;
			}
			if (MetodosUteis.estaVazia(tarefa.getDescricao())) {
				MetodosUteis.addMensagem("Campo descricao obrigatorio!");
				erro = true;
			}
			if (MetodosUteis.estaVazia(tarefa.getPrioridade())) {
				MetodosUteis.addMensagem("Campo prioridade obrigatorio!");
				erro = true;
			}
			if (MetodosUteis.estaVazia(tarefa.getResponsavel())) {
				MetodosUteis.addMensagem("Campo responsavel obrigatorio!");
				erro = true;
			}
			if (tarefa.getDeadline()==null) {
				MetodosUteis.addMensagem("Campo deadline obrigatorio!");
				erro = true;
			}
			if(erro) {
				if (gerenciador.getTransaction().isActive()) {
					gerenciador.getTransaction().rollback();
				}
				return null;
			}else {
				try {
					if (tarefa.getId() == 0)
						gerenciador.persist(tarefa);
					else
						gerenciador.merge(tarefa);

					gerenciador.getTransaction().commit();
					MetodosUteis.addMensagem("Seu cadastro está pronto!");
					

				} catch (Exception e) {
					e.printStackTrace();

					if (gerenciador.getTransaction().isActive()) {
						gerenciador.getTransaction().rollback();
					}
				}

			

			tarefa = new Tarefa();
			return null;
			}
			
	}

	public Tarefa gettarefa() {
		return tarefa;
	}

	public void settarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	public String editarTarefa(Tarefa tarefa) {
		this.tarefa = tarefa; 
		return "/index.xhtml";
	}

	
}
