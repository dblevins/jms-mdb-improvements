package javax.jms;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Acknowledge {

    Mode value();

    /**
     * Enum ordinals of Mode intentionally lines
     * up with numeric constants of javax.jms.Session
     */
    public static enum Mode {
        SESSION_TRANSACTED,
        AUTO_ACKNOWLEDGE,
        CLIENT_ACKNOWLEDGE,
        DUPS_OK_ACKNOWLEDGE;
    }
}
