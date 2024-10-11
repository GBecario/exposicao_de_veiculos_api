package br.com.exposicao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.exposicao.dto.ExhibitionDto;
import br.com.exposicao.model.Exhibition;
import br.com.exposicao.repository.ExhibitionRepository;

@Service
public class ExhibitionService {
	
	@Autowired
	private ExhibitionRepository exhibitionRepository;
	
	@Transactional(readOnly = true)
	public List<ExhibitionDto> findAllExhibitions() {
		return exhibitionRepository.findAll().stream().map(e -> ExhibitionDto.toDto(e)).toList();
	}
	
	@Transactional(readOnly = true)
	public Optional<ExhibitionDto> findExhibitonById(Long id) {
		Optional<Exhibition> exhibitionEntity = exhibitionRepository.findById(id);
		
		if (exhibitionEntity.isPresent()) {
			return Optional.of(ExhibitionDto.toDto(exhibitionEntity.get()));
		}
		
		return Optional.empty();
	}
	
	@Transactional
	public ExhibitionDto registerExhibition(ExhibitionDto exhibition) {
		Exhibition exhibitionEntity = exhibitionRepository.save(exhibition.toEntity());
		return ExhibitionDto.toDto(exhibitionEntity);
	}
	
	@Transactional
	public Optional<ExhibitionDto> alterExhibition(Long id, ExhibitionDto exhibition) {
		if (exhibitionRepository.existsById(id)) {
			Exhibition exhibitionEntity = exhibition.toEntity();
			exhibitionEntity.setId(id);
			exhibitionRepository.save(exhibitionEntity);
			return Optional.of(ExhibitionDto.toDto(exhibitionEntity));
		}
		
		return Optional.empty();
	}
	
	@Transactional
	public boolean deleteExhibitionById(Long id) {
		Optional<Exhibition> exhibitionEntity = exhibitionRepository.findById(id);
		
		if (exhibitionEntity.isPresent()) {
			exhibitionRepository.deleteById(id);
			return true;
		}
		
		return false;
	}
}
