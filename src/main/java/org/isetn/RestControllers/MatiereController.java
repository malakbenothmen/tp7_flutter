package org.isetn.RestControllers;

import java.util.List;

import org.isetn.entities.ClassMat;
import org.isetn.entities.Etudiant;
import org.isetn.entities.Matiere;
import org.isetn.repository.ClassMatRepository;
import org.isetn.repository.EtudiantRepository;
import org.isetn.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("matiere")

public class MatiereController {
	@Autowired
	private MatiereRepository matiereRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private ClassMatRepository classMatRepository;

	
	  @PostMapping("/add") public Matiere add(@RequestBody Matiere matiere ) {
	  
	  return matiereRepository.save(matiere); }
	 
	
	  @GetMapping("/byClass") public List<ClassMat> getByClass(@Param("classeId")
	  Long classeId) {
		  return classMatRepository.findByClasseCodClass(classeId);
	  
	  
	  }
	 

	
	  @GetMapping("/all") public List<Matiere> getAll() { return
			  matiereRepository.findAll(); }
	  
	  @DeleteMapping("/delete") public void delete(@Param("id") Long id) { Etudiant
	  c = etudiantRepository.findById(id).get(); etudiantRepository.delete(c); }
	  
	  @PutMapping("/update") public Etudiant update(@RequestBody Etudiant etudiant)
	  { return etudiantRepository.save(etudiant); }
	 
}
