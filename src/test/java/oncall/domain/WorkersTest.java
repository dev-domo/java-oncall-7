package oncall.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.constants.ExceptionMessage;
import oncall.domain.parser.WorkersParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WorkersTest {
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d", "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a,b,c,d,e,f,g,h,i,j"})
    void 근무자는_5명_이상_35명_이하여야_한다(String names) {
        assertThatThrownBy(() -> new WeekdaysWorkers(new WorkersParser().parse(names)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_INPUT.getMessage());
    }

    @Test
    void 근무자_순번에_같은_근무자가_중복될_수_없다() {
        assertThatThrownBy(() -> new WeekdaysWorkers(new WorkersParser().parse("승준,승준,수빈,지한,포비")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_INPUT.getMessage());
    }

    @Test
    void 근무자_수_반환() {
        assertThat(new WeekdaysWorkers(new WorkersParser().parse("승준,라일,수빈,지한,포비")).hasSize()).isEqualTo(5);

    }
}
