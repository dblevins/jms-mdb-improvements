package javax.jms;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SubscriptionDurability {

    Mode value();

    /**
     * DMB: Not sure I got this right.  If there are just two choices
     * then the value of this enum could be a boolean
     */
    public static enum Mode {
        DURABLE,
        NON_DURABLE;
    }
}
