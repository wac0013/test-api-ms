package br.com.teste.gastoportaltransparencia.application.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
public class NegocioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private final HttpStatus httpCodigoStatus;

    private final String codigo;

    private final String mensagem;

    private final String descricao;

    public NegocioExceptionBody getBody() {
        return NegocioExceptionBody.builder()
                .codigo(this.codigo)
                .mensagem(this.mensagem)
                .descricao(this.descricao)
                .build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class NegocioExceptionBody {
        private String codigo;

        private String mensagem;

        private String descricao;

    }
}
