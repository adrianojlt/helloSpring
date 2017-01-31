package pt.adrz.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.adrz.hellospring.utils.Utils;

@Controller
@RequestMapping("/")
public class ArenaController {
	
    @RequestMapping(value="arenavision",method = RequestMethod.GET)
	public String arena(ModelMap model) {

		String html = Utils.table();
		model.addAttribute("html",html);
		System.out.println(html);

    	return "arenavision";
    }
    
    @RequestMapping(value="acestream",method = RequestMethod.GET)
    @ResponseBody
    public String acestream(@RequestParam(value="ace",required = false) String ace,@RequestParam(value="sop",required = false) String sop) {

    	if (ace != null) {
    		return Utils.getLink(ace);
    	}

    	if (sop != null) {
    		return Utils.getLink(sop);
    	}
    	
    	return "";
    }
}
