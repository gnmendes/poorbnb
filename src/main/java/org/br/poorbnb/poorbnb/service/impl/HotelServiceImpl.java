package org.br.poorbnb.poorbnb.service.impl;

import org.br.poorbnb.poorbnb.pattern.strategy.UsuarioEnum;
import org.br.poorbnb.poorbnb.pattern.command.Condition;
import org.br.poorbnb.poorbnb.pattern.command.Handler;
import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.repository.HotelRepository;
import org.br.poorbnb.poorbnb.service.AvaliacaoHotelService;
import org.br.poorbnb.poorbnb.service.CobrancaHotelService;
import org.br.poorbnb.poorbnb.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
    private AvaliacaoHotelService avaliacaoHotelService;
    private CobrancaHotelService cobrancaHotelService;

    @Autowired
    public HotelServiceImpl(HotelRepository repository,
                            AvaliacaoHotelService avaliacaoHotelService,
                            CobrancaHotelService cobrancaHotelService) {
        this.hotelRepository = repository;
        this.avaliacaoHotelService = avaliacaoHotelService;
        this.cobrancaHotelService = cobrancaHotelService;
    }

    @Override
    public Hotel inserirHotel(Hotel hotel) {
      return this.hotelRepository.save(hotel);
    }

    @Override
    public void removerHotel(Hotel hotel) {
      this.hotelRepository.delete(hotel);
    }

    @Override
    public List<Hotel> verificarAvaliacao() {
        final List<Hotel> hoteis = this.hotelRepository.findAll();
        final List<Hotel> reviwed = new ArrayList<>();

        hoteis.forEach(hotel -> {
            final Double rateAverage = UsuarioEnum.HOTEL.calcularAvaliacao(hotel, this.avaliacaoHotelService);

            final Map<Condition, Handler> commanderOfHotel = getCommanderOfHotel(hotel);
            findCondtion(commanderOfHotel, rateAverage);

            if (rateAverage >= HotelConstants.THREE && rateAverage < HotelConstants.FOUR_AND_HALF) {
                reviwed.add(hotel);
            }
        });

        return reviwed;
    }

    @Override
    public List<Hotel> listarHoteis() {
        return this.hotelRepository.listarHoteis();
    }

    private void findCondtion(final Map<Condition, Handler> commanderOfHotel, final Double rateAverage) {
        final Optional<Condition> first = commanderOfHotel.keySet()
                .stream()
                .filter(any -> any.conditionChecker(rateAverage))
                .findFirst();

        commanderOfHotel.get(first.get()).handler();
    }

    public Map<Condition, Handler> getCommanderOfHotel(Hotel hotel) {

        final Map<Condition, Handler> map = new HashMap<>();

        map.put((r) -> r >= HotelConstants.FOUR_AND_HALF,
                () -> this.cobrancaHotelService.conceberDesconto(hotel));
        map.put((r) -> r >= HotelConstants.THREE && r < HotelConstants.FOUR_AND_HALF,
                () -> this.cobrancaHotelService.manterEstavelOuRemoverRestricao(hotel));
        map.put((r) -> r >= HotelConstants.ONE && r < HotelConstants.THREE,
                () -> this.cobrancaHotelService.aplicarRestricaoPesquisa(hotel));
        map.put((r) -> r < HotelConstants.ONE, () -> removerHotel(hotel));

        return map;
    }
}
