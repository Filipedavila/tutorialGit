package pt.iade.aulas.tutorialgit.models.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)

public class AlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 816409195680303768L;

        public AlreadyExistsException(String Name, String id, String Text) {
            super(Name+" Already exist element with "+id+"Reason - "+Text);
        }
    }


