package br.edu.cse.controller;

import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cse.entity.Ies;
import br.edu.cse.service.IesService;

@RestController
@CrossOrigin
@RequestMapping("/ies")
public class IesController {

	@Autowired
	private IesService service;

	@GetMapping("/list/{pagina}")
	public Collection<Ies> todos(@PathVariable Long pagina) {
		Page<Ies> retorno = service.todos(pagina.intValue(), 20, "nome");
		return retorno.getContent();
	}
	
	@GetMapping("/combo")
	public Collection<Ies> combo() {
		return service.todos();
	}
	
	@GetMapping("/{id}")
	public Ies obtemIes(@PathVariable Long id) {
		return service.obtem(id);
	}
	
	@GetMapping("/nome/{nome}/pagina/{pagina}")
	public List<Ies> procuraPorNome(@PathVariable String nome,@PathVariable Long pagina) {
		return service.buscaPorNome(nome, pagina.intValue(), 10, "nome").getContent();
	}
	
	@PostMapping
	public Ies salva(@RequestBody Ies entidade) {
		return service.salva(entidade);
	}
	
	@DeleteMapping("/{id}")
	public void exclui(@PathParam(value = "id") Long id) {
		service.exclui(id);
	}
	
	@GetMapping("/contapaginas")
	public Long contaPaginas() {
		return service.contaPaginas()/20;
	}
	
	@ApiOperation(value = "recupera um arquivo para download da tabela de anexos por idAnexo", notes = "Busca todos as Anexos do Processo de Análise", response = AnexoDTO.class)
	@GetMapping("/download/{id}")
    	public void downloadAnexo(@PathVariable Long id, final HttpServletRequest request, final HttpServletResponse response) {
		AnexoDTO anexo = this.obterAnexo(id);
		byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(anexo.getAnexo().getBytes());

		response.reset();
		response.setContentType(selecionaTipoContentType(anexo.getNomeAnexo()));
		response.setHeader("Content-Disposition", "filename='" + anexo.getNomeAnexo() + "'");
		response.setContentLength(decoded.length);		

		try {
			InputStream input = new BinaryStreamImpl(decoded);
			OutputStream output = response.getOutputStream();
			IOUtils.copyLarge(input, output);
            output.flush();
		} catch (IOException e) {
			throw new CustomGenericException("500", "anexo download", e, e.getStackTrace()[0]);
		}
		
    }
	
}
