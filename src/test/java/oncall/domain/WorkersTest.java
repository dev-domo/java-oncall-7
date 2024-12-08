package oncall.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.constants.ExceptionMessage;
import oncall.domain.parser.WorkersParser;
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
}
