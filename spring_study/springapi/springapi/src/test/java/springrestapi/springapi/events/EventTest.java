package springrestapi.springapi.events;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(JUnitParamsRunner.class)
@SpringBootTest
public class EventTest {



    @Test
    public void builder() {
        Event event = Event.builder()
                .name("Spring REST API")
                .description("REST API development").build();

        Assertions.assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        //Given
        String name = "Event";
        String description = "Spring REST API";

        //When
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        //Then
        Assertions.assertThat(event.getName()).isEqualTo(name);

    }

    @Test
    @Parameters(method = "parametersForTestFree")
    public void testFree(int basePrice, int maxPrice, boolean isFree) {
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        event.update();

        Assertions.assertThat(event.isFree()).isEqualTo(isFree);
    }

    private Object[] parametersForTestFree() {
        return new Object[] {
                new Object[] {0,0,true},
                new Object[] {100,0,false},
                new Object[] {0,100,false},
        };
    }

    @Test
    @Parameters(method = "parametersForTestOffline")
    public void testOffline(String location, boolean isOffline){
        Event event = Event.builder()
                .location("Hello Ranggu")
                .build();

        event.update();

        Assertions.assertThat(event.isOffline()).isTrue();
    }

    private Object[] parametersForTestOffline() {
        return new Object[] {
                new Object[] {"강남",true},
                new Object[] {null, false},
                new Object[] {"   ", false},
        };
    }


}