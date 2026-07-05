package dev.kevin.jticket.dto.auth;

import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(@NotEmpty(message = "Nome é obrigatório") String nome,
                                  @NotEmpty(message = "E-mail é obrigatório") String email,
                                  @NotEmpty(message = "Senha é obrigatória") String senha,
                                  @NotEmpty(message = "Cargo é obrigatório") String cargo,
                                  @NotEmpty(message = "Telefone é obrigatório") String telefone,
                                  @NotEmpty(message = "Tipo de usuário é obrigatório") String tipo_usuario) {

}
