package br.com.exposicao.dto;

import br.com.exposicao.model.Exhibition;
import br.com.exposicao.util.Mapper;

public record ExhibitionDto(
		Long id,
		String vehicleName,
		int vehicleYear
		) {
	public Exhibition toEntity() {
		return Mapper.getMapper().convertValue(this, Exhibition.class);
	}
	
	public static ExhibitionDto toDto(Exhibition exhibitionEntity) {
		return Mapper.getMapper().convertValue(exhibitionEntity, ExhibitionDto.class);
	}
}
