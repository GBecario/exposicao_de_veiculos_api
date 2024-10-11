package br.com.exposicao.dto;

import br.com.exposicao.model.Exhibition;
import br.com.exposicao.util.Mapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExhibitionDto(
		Long id,
		@NotBlank
		String vehicleName,
		@NotNull
		int vehicleYear
		) {
	public Exhibition toEntity() {
		return Mapper.getMapper().convertValue(this, Exhibition.class);
	}
	
	public static ExhibitionDto toDto(Exhibition exhibitionEntity) {
		return Mapper.getMapper().convertValue(exhibitionEntity, ExhibitionDto.class);
	}
}
