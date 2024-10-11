package br.com.exposicao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exposicao.dto.ExhibitionDto;
import br.com.exposicao.service.ExhibitionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/exhibition")
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService exhibitionService;
	
	@GetMapping
	public ResponseEntity<List<ExhibitionDto>> getAllExhibition() {
		return new ResponseEntity<>(exhibitionService.findAllExhibitions(), HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public Optional<ExhibitionDto> getExhibitionById(@PathVariable Long id) {
		return exhibitionService.findExhibitonById(id);
	}
	
	@PostMapping
	public ResponseEntity<ExhibitionDto> registerExhibition(@Valid @RequestBody ExhibitionDto exhibition) {
		return new ResponseEntity<>(exhibitionService.registerExhibition(exhibition), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Optional<ExhibitionDto> alterExhibition(@PathVariable Long id, @Valid @RequestBody ExhibitionDto exhibition) {
		return exhibitionService.alterExhibition(id, exhibition);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExhibition(@PathVariable Long id) {
		if (exhibitionService.deleteExhibitionById(id)) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
