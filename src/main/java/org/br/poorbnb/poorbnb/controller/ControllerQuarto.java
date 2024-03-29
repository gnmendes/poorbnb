package org.br.poorbnb.poorbnb.controller;

import javax.management.AttributeNotFoundException;
import javax.validation.Valid;

import org.br.poorbnb.poorbnb.dto.QuartoDTO;
import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Quarto;
import org.br.poorbnb.poorbnb.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/quarto")
public class ControllerQuarto {

	private QuartoService quartoService;

	@Autowired
	public ControllerQuarto(QuartoService quartoService) {
		this.quartoService = quartoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Quarto> obterQuartoPorId(@PathVariable(value = "id") Long quartoId)
			throws ResourceNotFoundException {

		return ResponseEntity.ok(this.quartoService.obterQuartoPorId(quartoId));
	}

	@PostMapping
	public ResponseEntity<Quarto> criarQuarto(@Valid @RequestBody Quarto quarto) {

		return ResponseEntity.ok(this.quartoService.salvarQuarto(quarto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Quarto> atualizaQuarto(@PathVariable(value = "id") Long quartoId,
												 @Valid @RequestBody QuartoDTO quartoAlteracoes)
			throws ResourceNotFoundException, AttributeNotFoundException {

		return ResponseEntity.ok(this.quartoService.atualizaQuarto(quartoId, quartoAlteracoes));
	}

}

