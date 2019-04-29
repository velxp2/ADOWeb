
package br.com.ado.web.ADO_DevWeb.controller;

import br.com.ado.web.ADO_DevWeb.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author victor
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {
    
    @GetMapping
    public ModelAndView listar(){
        return new ModelAndView ("produto/listar");
    }
    
    @GetMapping("/novo")
    public ModelAndView adicionarNovo(){
        return new ModelAndView("produto/formulario").addObject(new Produto());
    }
    
    @GetMapping("{id}/editar")
    public ModelAndView editar(Long id){
        return new ModelAndView("produto/formulario").addObject(new Produto());
    }
    
    @PostMapping("/salvar")
    public ModelAndView salvar(Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        return new ModelAndView("redirect:/produto/lista");
    }
    
    @PostMapping("/{id}/remover")
    public ModelAndView remover(Long id) {
        return new ModelAndView("redirect:/produto/lista");
    }
    
}
