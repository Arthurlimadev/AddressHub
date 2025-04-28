package com.addresshub.address.controller;

import com.addresshub.address.model.entity.Cliente;
import com.addresshub.address.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Lista todos os Usuários")
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Busca um usuário por ID")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping("/{id}")
    @Operation(summary = "Inserir usuário")
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuário")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um usuário")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
