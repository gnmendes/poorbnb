package org.br.poorbnb.poorbnb.mapper;

import org.br.poorbnb.poorbnb.dto.AvaliacaoHotelDTO;
import org.br.poorbnb.poorbnb.model.AvaliacaoHotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface AvaliacaoHotelMapper {

    @Mappings({
            @Mapping(source = "avaliacaoHotelDTO.hotel.idHotel", target = "id.idHotelAvaliado"),
            @Mapping(source = "avaliacaoHotelDTO.idUsuario", target = "id.idAvaliador"),
            @Mapping(source = "avaliacaoHotelDTO.idReserva", target = "idReserva"),
            @Mapping(source = "avaliacaoHotelDTO.avaliacao", target = "notaHotel")
    })
    AvaliacaoHotel dtoParaEntidade(final AvaliacaoHotelDTO avaliacaoHotelDTO);
    @Mappings({
            @Mapping(target = "hotel.idHotel", source = "avaliacaoHotel.id.idHotelAvaliado"),
            @Mapping(target = "idUsuario", source = "avaliacaoHotel.id.idAvaliador"),
            @Mapping(target = "idReserva", source = "avaliacaoHotel.idReserva"),
            @Mapping(target = "avaliacao", source = "avaliacaoHotel.notaHotel")
    })
    AvaliacaoHotelDTO entidadeParaDTO(final AvaliacaoHotel avaliacaoHotel);
}
