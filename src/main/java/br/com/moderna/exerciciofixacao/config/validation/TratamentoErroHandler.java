package br.com.moderna.exerciciofixacao.config.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class TratamentoErroHandler {
    private MessageSource messageSource;

    public TratamentoErroHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)//continuar devolvendo erro 404 ao inves de 200
    @ExceptionHandler(MethodArgumentNotValidException.class)//mostrar que é error de formulario
    public List<ErroDeFormularioDto> handler(MethodArgumentNotValidException exception) {
        List<ErroDeFormularioDto> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(p -> {
            String mensagem = messageSource.getMessage(p, LocaleContextHolder.getLocale());
            ErroDeFormularioDto erro = new ErroDeFormularioDto(p.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }
}
