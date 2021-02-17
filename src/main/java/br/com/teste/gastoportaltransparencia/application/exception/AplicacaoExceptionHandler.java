package br.com.teste.gastoportaltransparencia.application.exception;

import br.com.teste.gastoportaltransparencia.controller.request.DataRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AplicacaoExceptionHandler {

    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "Argumento inválido";
    private static final String DEFAULT_VIEW = "index";
    private static final String DATA_REQUEST_OBJECT = "dataRequest";
    private static final String ERRO_OBJECT = "dataRequest";

    @ExceptionHandler(value = {NegocioException.class})
    protected ModelAndView handlConflicts(NegocioException ex, HttpServletRequest request) {
        return getModelViewDefault(ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public ModelAndView handleException(IllegalArgumentException argumentException) {

        NegocioException ex = NegocioException.builder()
                .httpCodigoStatus(HttpStatus.BAD_REQUEST)
                .mensagem(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE)
                .descricao(ExceptionResolver.getRootException(argumentException))
                .build();

        return getModelViewDefault(ex);
    }

    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(Exception exception) {

        NegocioException ex = NegocioException.builder()
                .httpCodigoStatus(HttpStatus.BAD_REQUEST)
                .mensagem(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE)
                .descricao(ExceptionResolver.getRootException(exception))
                .build();

        return getModelViewDefault(ex);
    }

    private ModelAndView getModelViewDefault(NegocioException ex) {
        var modelView = new ModelAndView();
        modelView.addObject(ERRO_OBJECT, ex);
        modelView.addObject(DATA_REQUEST_OBJECT, new DataRequest());
        modelView.setViewName(DEFAULT_VIEW);
        return modelView;
    }

}
